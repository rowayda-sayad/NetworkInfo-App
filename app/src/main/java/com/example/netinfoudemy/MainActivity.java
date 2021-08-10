package com.example.netinfoudemy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    TextView netInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        netInfo = findViewById(R.id.netInfo);


        ConnectivityManager connectivityManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        boolean isAvailable = networkInfo.isAvailable();
        boolean isConnected = networkInfo.isConnected();
        boolean isRoaming = networkInfo.isRoaming();
        int networkType = networkInfo.getType();
        String networkName = networkInfo.getTypeName();

        netInfo.setText("isAvailable: " + isAvailable +
                "\nisConnected: " + isConnected
                + "\nisRoaming: " + isRoaming + "" +
                "\nnetworkType: " + networkType + "" +
                "\nnetworkName: " + networkName);
    }
}