package com.explore.activity;

import android.os.Bundle;

import com.explore.fragment.DescriptionFragment;
import com.explore.fragment.LocationSummaryFragment;
import com.explore.models.wikipedia.PageDescription;

public class DescriptionActivity extends BaseActivity {

    public static final String TITLE = "TITLE";
    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            PageDescription pageDescription = (PageDescription) extras.getSerializable(LocationSummaryFragment.KEY_PAGE_DESCRIPTION);
            addDescriptionFragment(extras);
            title = pageDescription.getTitle();
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
