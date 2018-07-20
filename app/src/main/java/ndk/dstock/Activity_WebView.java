package ndk.dstock;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;

import ndk.utils.Log_Utils;

public class Activity_WebView extends AppCompatActivity {

    private WebView webView;

    boolean from_app_link = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_weview);

        //TODO : Launch Screen
        handleIntent(getIntent());

        webView = findViewById(R.id.WebView);
        ProgressBar progressBar = findViewById(R.id.progressBar);

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);

        String desktop_mozilla= "Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.9.0.4) Gecko/20100101 Firefox/4.0";
        settings.setUserAgentString(desktop_mozilla);

        Custom_WebViewClient webViewClient = new Custom_WebViewClient(this, progressBar);
        webView.setWebViewClient(webViewClient);
        webView.setOverScrollMode(View.OVER_SCROLL_NEVER);
        webView.loadUrl("https://dstock.in");

        FirebaseMessaging.getInstance().subscribeToTopic("all");
        Toast.makeText(getApplicationContext(), "Topic Subscribed", Toast.LENGTH_LONG).show();
        //TODO : Implement Device Orientation Change Handling
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack();
            return true;
        }

        //TODO : Implement App Exit Confirmation - Not for appLinks
        return super.onKeyDown(keyCode, event);
    }

    //TODO : Implement offline cache

    private void handleIntent(Intent intent) {
        String appLinkAction = intent.getAction();
        Uri appLinkData = intent.getData();
        if (Intent.ACTION_VIEW.equals(appLinkAction) && appLinkData != null) {
            //TODO : Handle appLinkData - Show product page, About Us, etc.
            Log_Utils.debug(Application_Specification.APPLICATION_NAME, "appLinkData : " + appLinkData);
            from_app_link =true;
        }
    }
}
