package ndk.dstock;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        WebView wv = findViewById(R.id.webView1);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageFinished(WebView view, String url) {
                //hide loading image
                findViewById(R.id.imageLoading1).setVisibility(View.GONE);
                //show webview
                findViewById(R.id.webView1).setVisibility(View.VISIBLE);
            }


        });
        wv.loadUrl("https://www.google.com");

    }

}
