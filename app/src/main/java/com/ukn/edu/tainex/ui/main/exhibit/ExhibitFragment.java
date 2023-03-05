package com.ukn.edu.tainex.ui.main.exhibit;

import android.graphics.Rect;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ukn.edu.tainex.Exhibit;
import com.ukn.edu.tainex.ExhibitData;
import com.ukn.edu.tainex.R;
import com.ukn.edu.tainex.databinding.FragmentExhibitBinding;

import java.util.ArrayList;
import java.util.List;

public class ExhibitFragment extends Fragment {
    private FragmentExhibitBinding fragmentExhibitBinding;
    private List<ExhibitData> exhibitCardList;
    public ExhibitFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentExhibitBinding = FragmentExhibitBinding.inflate(inflater, container, false);
        initCardList();
        initCardListView();
        return fragmentExhibitBinding.getRoot();
    }

    private void initCardList(){
        exhibitCardList = new ArrayList<>();
        for(ExhibitData exhibitData:Exhibit.getInstance().getExhibits()){
            exhibitCardList.add(new ExhibitData(
                    exhibitData.getImage(),
                    exhibitData.getDate(),
                    exhibitData.getName(),
                    exhibitData.getPlace()
            ));
        }
    }

    private void initCardListView(){
        fragmentExhibitBinding.rvCardlist.setLayoutManager(new LinearLayoutManager(getContext()));
        fragmentExhibitBinding.rvCardlist.addItemDecoration(new SpacesItemDecoration(12));
        fragmentExhibitBinding.rvCardlist.setAdapter(new ExhibitCardAdapter(exhibitCardList, getActivity()));
    }
    static class SpacesItemDecoration extends RecyclerView.ItemDecoration{
        private int space;

        public SpacesItemDecoration(int space){
            this.space = space;
        }

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);

            outRect.bottom = space;

        }
    }
}