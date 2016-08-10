package com.openknowl.ontact;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.openknowl.ontact.adapter.ContactListAdapter;
import com.openknowl.ontact.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactActivity extends AppCompatActivity {
    private static final String TAG = ContactActivity.class.getSimpleName();
    private static final int PERMISSIONS_REQUEST_READ_CONTACTS = 100;

    private List<Contact> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setTitle("전화번호부");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.READ_CONTACTS}, PERMISSIONS_REQUEST_READ_CONTACTS);
        } else {
            contactList = loadContacts();
            ListView contactListView = (ListView) findViewById(R.id.contactListView);
            ContactListAdapter contactListAdapter = new ContactListAdapter(
                    this, R.layout.list_contact, contactList.toArray(new Contact[contactList.size()])
            );
            contactListView.setAdapter(contactListAdapter);
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        if (requestCode == PERMISSIONS_REQUEST_READ_CONTACTS) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission is granted
                contactList = loadContacts();
                ListView contactListView = (ListView) findViewById(R.id.contactListView);
                ContactListAdapter contactListAdapter = new ContactListAdapter(
                        this, R.layout.list_contact, contactList.toArray(new Contact[contactList.size()])
                );
                contactListView.setAdapter(contactListAdapter);
            } else {
                Toast.makeText(this, "권한이 없어서 표시할 수 없습니다.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private List<Contact> loadContacts() {
        Uri uri = ContactsContract.Contacts.CONTENT_URI;
        String[] projection = new String[]{
                ContactsContract.Contacts._ID,
                ContactsContract.Contacts.DISPLAY_NAME,
                ContactsContract.Contacts.HAS_PHONE_NUMBER};

        Cursor cursor = managedQuery(uri, projection, null, null, null);
        List<Contact> contacts = new ArrayList<>();
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                if (cursor.getInt(2) == 1) {
                    String phoneNumber = loadPhoneNumbers(cursor.getString(0));
                    if (phoneNumber != null) {
                        Contact item = new Contact();
                        item.setName(cursor.getString(1));
                        item.setNumber(phoneNumber);
                        contacts.add(item);
                    }
                }
            }
        }
        return contacts;
    }

    private String loadPhoneNumbers(String id) {
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        String[] projection = new String[]{
                ContactsContract.CommonDataKinds.Phone.TYPE,
                ContactsContract.CommonDataKinds.Phone.NUMBER
        };

        String selection = ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=?";
        Cursor cursor = managedQuery(uri, projection, selection, new String[]{id}, null);
        if (cursor.moveToNext()) {
            Log.w(TAG, "Number Type = " + cursor.getString(0));
            Log.w(TAG, "Number = " + cursor.getString(1));
            return cursor.getString(1);
        }
        return null;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contact, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
