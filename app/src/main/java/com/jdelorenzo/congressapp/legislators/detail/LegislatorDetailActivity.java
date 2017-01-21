package com.jdelorenzo.congressapp.legislators.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.jdelorenzo.congressapp.R;
import com.jdelorenzo.congressapp.model.Legislator;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LegislatorDetailActivity extends AppCompatActivity implements LegislatorDetailContract.View {
    public static final String EXTRA_LEGISLATOR = "legislator";
    private Legislator legislator;
    @BindView(R.id.name) TextView nameView;
    @BindView(R.id.party) TextView partyView;
    @BindView(R.id.term) TextView termView;
    @BindView(R.id.chamber) TextView chamberView;
    @BindView(R.id.contact_form) TextView contactFormView;
    @BindView(R.id.phone) TextView phoneView;
    @BindView(R.id.facebook) TextView facebookView;
    @BindView(R.id.twitter) TextView twitterView;
    @BindView(R.id.youtube) TextView youtubeView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        if (savedInstanceState == null) {
            legislator = (Legislator) getIntent().getSerializableExtra(EXTRA_LEGISLATOR);
            nameView.setText(String.format(Locale.getDefault(),
                    getString(R.string.legislator_name_format),
                    legislator.title,
                    legislator.firstName,
                    legislator.lastName,
                    legislator.nameSuffix != null ? legislator.nameSuffix : ""));
            partyView.setText(getFullPartyName(legislator.party));
            termView.setText(String.format(Locale.getDefault(),
                    getString(R.string.term_format),
                    legislator.termStart,
                    legislator.termEnd));
            chamberView.setText(String.format(Locale.getDefault(),
                    getString(R.string.chamber_format),
                    legislator.chamber,
                    legislator.crpId));

            //None of the contact form information is guaranteed to exist.
            if (!TextUtils.isEmpty(legislator.contactForm)) {
                contactFormView.setText(legislator.contactForm);
            } else {
                contactFormView.setVisibility(View.GONE);
            }
            if (!TextUtils.isEmpty(legislator.phone)) {
                phoneView.setText(legislator.phone);
            } else {
                phoneView.setVisibility(View.GONE);
            }
            if (!TextUtils.isEmpty(legislator.facebookId)) {
                facebookView.setText(String.format(Locale.getDefault(),
                        getString(R.string.facebook_format), legislator.facebookId));
            } else {
                facebookView.setVisibility(View.GONE);
            }
            if (!TextUtils.isEmpty(legislator.twitterId)) {
                twitterView.setText(String.format(Locale.getDefault(),
                        getString(R.string.twitter_format), legislator.twitterId));
            } else {
                twitterView.setVisibility(View.GONE);
            }
            if (!TextUtils.isEmpty(legislator.youtubeId)) {
                youtubeView.setText(String.format(Locale.getDefault(),
                        getString(R.string.youtube_format), legislator.youtubeId));
            } else {
                youtubeView.setVisibility(View.GONE);
            }
        }
    }

    String getFullPartyName(String party) {
        switch (party) {
            case "D":
                return getString(R.string.party_democrat);
            case "R":
                return getString(R.string.party_republican);
            case "I":
                return getString(R.string.party_independent);
            default:
                return "";
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(EXTRA_LEGISLATOR, legislator);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        legislator = (Legislator) savedInstanceState.getSerializable(EXTRA_LEGISLATOR);
    }
}
