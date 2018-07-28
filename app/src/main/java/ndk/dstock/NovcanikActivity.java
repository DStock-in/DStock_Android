package ndk.dstock;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


public class NovcanikActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        WebView webview = findViewById(R.id.webView1);

        WebSettings websettings = webview.getSettings();

        websettings.setJavaScriptEnabled(true);
        websettings.setSaveFormData(false);
        websettings.setSavePassword(false);

        webview.loadUrl("https://dstock.in");
        webview.setHorizontalScrollBarEnabled(false);
        webview.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);
        webview.setBackgroundColor(128);

        webview.setWebViewClient(new NovcanikWebViewClient());

        webview.setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String url, String userAgent,
                                        String contentDisposition, String mimetype,
                                        long contentLength) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);

            }
        });


    }

    public void visible() {

        WebView webview = findViewById(R.id.webView1);

        ImageView logo = findViewById(R.id.imageView1);

        ProgressBar bar = findViewById(R.id.progressBar1);

        TextView version = findViewById(R.id.textView1);

        webview.setVisibility(View.INVISIBLE);

        logo.setVisibility(View.VISIBLE);

        bar.setVisibility(View.VISIBLE);

        version.setVisibility(View.VISIBLE);

    }

    public void unvisible() {

        WebView webview = findViewById(R.id.webView1);

        ImageView logo = findViewById(R.id.imageView1);

        ProgressBar bar = findViewById(R.id.progressBar1);

        TextView version = findViewById(R.id.textView1);

        webview.setVisibility(View.VISIBLE);

        logo.setVisibility(View.INVISIBLE);

        bar.setVisibility(View.INVISIBLE);

        version.setVisibility(View.INVISIBLE);

    }


    private class NovcanikWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView webview, String url) {
            webview.loadUrl(url);
            return true;
        }

        @Override
        public void onReceivedError(WebView view, int errorCode,
                                    String description, String failingUrl) {
            // TODO Auto-generated method stub
            view.loadUrl("file:///android_asset/noconnection.html");
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {

            visible();

        }

        @Override
        public void onPageFinished(WebView view, String url) {

            unvisible();

        }

    }

}
