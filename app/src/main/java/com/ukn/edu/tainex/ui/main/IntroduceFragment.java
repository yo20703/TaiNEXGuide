package com.ukn.edu.tainex.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.ukn.edu.tainex.databinding.FragmentIntroduceBinding;

/**
 * A placeholder fragment containing a simple view.
 */
public class IntroduceFragment extends Fragment {
    final String TAG = "PlaceholderFragment";
    private static final String ARG_SECTION_NUMBER = "section_number";

    private FragmentIntroduceBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        binding = FragmentIntroduceBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}