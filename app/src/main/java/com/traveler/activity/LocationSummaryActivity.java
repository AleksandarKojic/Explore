package com.traveler.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ScrollView;

import com.traveler.R;
import com.traveler.fragment.LocationSummaryFragment;
import com.traveler.views.NotifyingScrollView;


public class LocationSummaryActivity extends BaseActivity implements NotifyingScrollView.OnScrollChangedListener {

    private Drawable actionBarBackgroundDrawable;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_summary);
        setTitle("");
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        actionBarBackgroundDrawable = toolbar.getBackground();

        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_back));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        NotifyingScrollView scrollView = (NotifyingScrollView) findViewById(R.id.scroll_view);
        scrollView.setOnScrollChangedListener(this);
        onScrollChanged(scrollView, 0, 0, 0, 0);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.content, new LocationSummaryFragment())
                    .commit();
        }
    }

    private void updateActionBarTransparency(float scrollRatio) {
        int newAlpha = (int) (scrollRatio * 255);
        actionBarBackgroundDrawable.setAlpha(newAlpha);
        toolbar.setBackgroundDrawable(actionBarBackgroundDrawable);
    }

    @Override
    public void onScrollChanged(ScrollView who, int l, int scrollPosition, int oldl, int oldt) {
        int headerHeight = getResources().getDimensionPixelSize(R.dimen.header_image) - toolbar.getHeight();
        float ratio = 0;
        if (scrollPosition > 0 && headerHeight > 0)
            ratio = (float) Math.min(Math.max(scrollPosition, 0), headerHeight) / headerHeight;

        updateActionBarTransparency(ratio);
    }
}
