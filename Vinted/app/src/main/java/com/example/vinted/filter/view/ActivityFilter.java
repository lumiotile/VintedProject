package com.example.vinted.filter.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.vinted.R;
import com.example.vinted.filter.ContractFilter;

public class ActivityFilter extends AppCompatActivity implements ContractFilter.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
    }

    @Override
    public void success() {

    }

    @Override
    public void failure() {

    }
}