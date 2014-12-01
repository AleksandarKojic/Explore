package com.traveler.activity;

import android.app.Activity;
import android.os.Bundle;

import com.traveler.fragment.DescriptionFragment;
import com.traveler.fragment.LocationSummaryFragment;
import com.traveler.models.wikipedia.PageDescription;

public class DescriptionActivity extends Activity {

    public static final String TITLE = "TITLE";
    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            PageDescription pageDescription = (PageDescription) extras.getSerializable(LocationSummaryFragment.PAGE_DESCRIPTION);
            title = pageDescription.getTitle();
            addDescriptionFragment(extras);
        } else {
            title = savedInstanceState.getString(TITLE);
        }

        if (title != null) {
            setTitle(title);
        }
    }

    private void addDescriptionFragment(Bundle extras) {
        getFragmentManager().beginTransaction()
                .add(android.R.id.content, DescriptionFragment.newInstance(extras))
                .commit();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(TITLE, title);
    }
}