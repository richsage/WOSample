package uk.co.whiteoctober.wosample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class WebViewFragment extends Fragment {

    View rootView;
    WebView webView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_main, container, false);

            loadWebView();
        }
        else {
            ((ViewGroup) rootView.getParent()).removeView(rootView);
        }

        return rootView;
    }

    protected void loadWebView() {
        webView = (WebView) rootView.findViewById(R.id.webView);

        // We'll use the tab's "tag" to determine what file to load into the webview
        String htmlFile= "default.html";
        if (getTag().equals("tab-1")) {
            htmlFile = "tab1.html";
        }
        if (getTag().equals("tab-2")) {
            htmlFile = "tab2.html";
        }
        if (getTag().equals("tab-3")) {
            htmlFile = "topcoat-mobile-dark.html";
        }

        webView.setWebChromeClient(new WebChromeClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/" + htmlFile);
    }
}
