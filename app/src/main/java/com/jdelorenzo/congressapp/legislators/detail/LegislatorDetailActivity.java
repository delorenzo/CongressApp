package com.jdelorenzo.congressapp.legislators.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.jdelorenzo.congressapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LegislatorDetailActivity extends AppCompatActivity implements LegislatorDetailContract.View {
    public static final String EXTRA_LEGISLATOR = "legislator";

    @BindView(R.id.name) TextView nameView;
    @BindView(R.id.party) TextView partyView;
    @BindView(R.id.term) TextView termView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
    }
}
