package com.example.aboutpagedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import java.util.Calendar;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setDescription("Developer: Mohamad Islahuddin Bin Malek  2019805538, Nik Hafifi Bin Mamat  2019218168, Nurul Jannah Binti Sa'adat  2019423798, Nurul Sajdahany Binti Johari  2019253196, Maturina Binti Azmi  2019805396, Syafiqah Adibah Binti Arbain  2019208142")
                .addItem(new Element().setTitle("Version 1.0"))
                .addGroup("Connect with me")
                .addWebsite("")
                .addGitHub("")
                .addItem(createCopyRight())
                .create();

        setContentView(aboutPage);

    }

    private Element createCopyRight() {
        Element copyright = new Element();
        String copyrightString = String.format("Copyright %d  ", Calendar.getInstance().get(Calendar.YEAR));
        copyright.setTitle(copyrightString);
        copyright.setGravity(Gravity.CENTER);
        copyright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(About.this,copyrightString,Toast.LENGTH_SHORT).show();
            }
        });
        return copyright;
    }
}