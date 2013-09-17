package uk.co.whiteoctober.wosample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class WebViewFragment extends Fragment {

    View rootView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        rootView = inflater.inflate(R.layout.fragment_main, container, false);

        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        WebView webView = (WebView) rootView.findViewById(R.id.webView);

        // We'll use the tab's "tag" to determine what file to load into the webview
        String htmlFile= "default.html";
        if (getTag().equals("tab-1")) {
            htmlFile = "tab1.html";
        }
        if (getTag().equals("tab-2")) {
            htmlFile = "tab2.html";
        }

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/" + htmlFile);
    }
}
