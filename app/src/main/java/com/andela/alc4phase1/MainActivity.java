package com.andela.alc4phase1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    private Button mProfile, mAbout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
        bindWidgets();

    }

    private void initWidgets() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mProfile = findViewById(R.id.my_profile);
        mAbout = findViewById(R.id.about_alc);
    }

    private void bindWidgets() {
        mProfile.setOnClickListener(this);
        mAbout.setOnClickListener(this);
    }

    private void sendToActivity(Class activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.about_alc: {
                sendToActivity(AboutActivity.class);
                break;
            }
            case R.id.my_profile: {
                sendToActivity(ProfileActivity.class);
                break;
            }
            default: {
                break;
            }
        }
    }
}
