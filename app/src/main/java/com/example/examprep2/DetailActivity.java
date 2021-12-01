package com.example.examprep2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    private static final String TAG = "DetailActivity";
    public static final String INTENT_MESSAGE = "au.edu.unsw.infs3634.covid19tracker.intent_message";
    private TextView countryTxt, newCasesTxt, totalCasesTxt, newDeathsTxt, totalDeathsTxt, newRecoveredTxt, totalRecoveredTxt;
    private Button bSearch;
    private ImageView mSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        countryTxt = findViewById(R.id.tvCountry);
        newCasesTxt = findViewById(R.id.tvNewCases);
        totalCasesTxt = findViewById(R.id.tvTotalCases);
        newDeathsTxt = findViewById(R.id.tvNewDeaths);
        totalDeathsTxt = findViewById(R.id.tvTotalDeaths);
        newRecoveredTxt = findViewById(R.id.tvNewRecovered);
        totalRecoveredTxt = findViewById(R.id.tvTotalRecovered);
        mSearch = findViewById(R.id.ivSearch);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(intent.hasExtra(INTENT_MESSAGE)){
            Log.d(TAG, "INTENT_MESSAGE = " + bundle.getStringArrayList(INTENT_MESSAGE));
            String countryCode = intent.getStringExtra(INTENT_MESSAGE);
            ArrayList<Country> countries = Country.getCountries();
            for(final Country country : countries) {
                setTitle(country.getCountryCode());

                newCasesTxt.setText(String.valueOf(country.getNewConfirmed()));
                totalCasesTxt.setText(String.valueOf(country.getTotalConfirmed()));
                newDeathsTxt.setText(String.valueOf(country.getNewDeaths()));
                totalDeathsTxt.setText(String.valueOf(country.getTotalDeaths()));
                newRecoveredTxt.setText(String.valueOf(country.getNewRecovered()));
                totalRecoveredTxt.setText(String.valueOf(country.getTotalRecovered()));
                mSearch.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com.au/search?q=covid " + country.getCountry()));
                        startActivity(intent);
                    }
                });
            }
        }
    }
}