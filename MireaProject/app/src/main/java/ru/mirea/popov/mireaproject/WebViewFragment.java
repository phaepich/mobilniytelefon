package ru.mirea.popov.mireaproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class WebViewFragment extends Fragment {

    private WebView webView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_web_view, container, false);
        webView = root.findViewById(R.id.webView);

        webView.getSettings().setJavaScriptEnabled(true);

        webView.loadUrl("https://github.com/phaepich/mobilniytelefon");
        return root;
    }
}