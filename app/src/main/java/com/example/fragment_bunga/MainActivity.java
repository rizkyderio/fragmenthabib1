package com.example.fragment_bunga;

import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private TextView tvText;
    private BottomNavigationView navigation;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        navigationListener();
    }

    private void init() {
        tvText = findViewById(R.id.tv_text);
        navigation = findViewById(R.id.navigation);
        webView = findViewById(R.id.webView);

        // Aktifkan JavaScript untuk memainkan video YouTube
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Set WebViewClient untuk menangani navigasi di dalam WebView
        webView.setWebViewClient(new WebViewClient());
    }

    private void navigationListener() {
        navigation.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.nav_home) {
                    tvText.setText(item.getTitle());
                    // Load halaman web YouTube saat item home dipilih
                    webView.loadUrl("https://youtu.be/eBMi6nzhV2s?si=A3SZr6klvZ42FraB");
                    return true;
                } else if (item.getItemId() == R.id.nav_search) {
                    tvText.setText(item.getTitle());
                    // Load halaman web YouTube saat item search dipilih
                    webView.loadUrl("https://youtu.be/XFiQz78FSzI?si=TMf_qccZqHSN97u-");
                    return true;
                } else if (item.getItemId() == R.id.nav_notification) {
                    tvText.setText(item.getTitle());
                    // Load halaman web YouTube saat item notification dipilih
                    webView.loadUrl("https://www.youtube.com/your_notification_video_url_here");
                    return true;
                } else if (item.getItemId() == R.id.nav_account) {
                    tvText.setText(item.getTitle());
                    // Load halaman web YouTube saat item account dipilih
                    webView.loadUrl("https://www.youtube.com/your_account_video_url_here");
                    return true;
                }
                return false;
            }
        });
    }
}
