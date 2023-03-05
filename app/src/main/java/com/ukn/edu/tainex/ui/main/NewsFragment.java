package com.ukn.edu.tainex.ui.main;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebViewClient;

import com.ukn.edu.tainex.databinding.FragmentNewsBinding;

public class NewsFragment extends Fragment {
    private FragmentNewsBinding fragmentNewsBinding;
    public NewsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentNewsBinding = FragmentNewsBinding.inflate(inflater, container, false);
        fragmentNewsBinding.wvNews.setWebViewClient(new WebViewClient());
        fragmentNewsBinding.wvNews.getSettings().setJavaScriptEnabled(true);
        fragmentNewsBinding.wvNews.setFocusableInTouchMode(true);

        fragmentNewsBinding.wvNews.loadUrl("https://www.tainex.com.tw/news/news/0/0/0");
        return fragmentNewsBinding.getRoot();
    }

}