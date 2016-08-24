package com.openknowl.ontact.adapter;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.openknowl.ontact.R;
import com.openknowl.ontact.model.Contact;


/**
 * Created by gracefulife on 16. 8. 9.
 */
public class ContactListAdapter extends ArrayAdapter<Contact> {
    private Contact[] contacts;

    public ContactListAdapter(Context context, int resource, Contact[] contacts) {
        super(context, resource, contacts);
        this.contacts = contacts;


    }

    static class ViewHolder implements View.OnClickListener {
        ImageView avatarImageView;
        TextView nameTextView;
        ImageView outgoingCallImageView;
        Contact contact;


        @Override
        public void onClick(View view) {
            Uri uri = Uri.parse("tel:" + contact.getNumber());
            Intent intent = new Intent(Intent.ACTION_DIAL, uri);
            view.getContext().startActivity(intent);
        }

        public void init(Contact[] contacts, int position) {
            this.contact = contacts[position];
            nameTextView.setText(contact.getName());
            outgoingCallImageView.setOnClickListener(this);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_contact, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.avatarImageView = (ImageView) convertView.findViewById(R.id.avatarImageView);
            viewHolder.nameTextView = (TextView) convertView.findViewById(R.id.nameTextView);
            viewHolder.outgoingCallImageView = (ImageView) convertView.findViewById(R.id.outgoingCallImageView);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (viewHolder != null)
            viewHolder.init(contacts, position);

        return convertView;
    }

}
