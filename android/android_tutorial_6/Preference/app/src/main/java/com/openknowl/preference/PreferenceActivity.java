package com.openknowl.preference;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

public class PreferenceActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String PREF_FILE_NAME = "openknowl_example";

    SwitchCompat compat1;
    SwitchCompat compat2;
    SwitchCompat compat3;
    SwitchCompat compat4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);
        compat1 = (SwitchCompat) findViewById(R.id.switch1);
        compat2 = (SwitchCompat) findViewById(R.id.switch2);
        compat3 = (SwitchCompat) findViewById(R.id.switch3);
        compat4 = (SwitchCompat) findViewById(R.id.switch4);

        compat1.setOnClickListener(this);
        compat2.setOnClickListener(this);
        compat3.setOnClickListener(this);
        compat4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String prefName;
        if (compat1.getId() == view.getId()) {
            prefName = "useAutoLogin";
        } else if (compat2.getId() == view.getId()) {
            prefName = "usePush";
        } else if (compat3.getId() == view.getId()) {
            prefName = "useAdvertisement";
        } else {
            prefName = "useEvent";
        }
        boolean checked = ((SwitchCompat) view).isChecked();
        getEditPreference(PreferenceActivity.this)
                .putBoolean(prefName, checked)
                .commit();
        Toast.makeText(PreferenceActivity.this,
                prefName + "checked = " + getReadPreference(PreferenceActivity.this)
                        .getBoolean(prefName, false)
                , Toast.LENGTH_SHORT).show();

    }

    private static SharedPreferences.Editor getEditPreference(Context context) {
        SharedPreferences pref = context.getSharedPreferences(PREF_FILE_NAME, Activity.MODE_PRIVATE);
        return pref.edit();
    }

    private static SharedPreferences getReadPreference(Context context) {
        return context.getSharedPreferences(PREF_FILE_NAME, Activity.MODE_PRIVATE);
    }
}
