package com.ukn.edu.tainex.ui.main.exhibit;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ukn.edu.tainex.R;
import com.ukn.edu.tainex.databinding.FragmentExhibitBinding;

import java.util.ArrayList;
import java.util.List;

public class ExhibitFragment extends Fragment {
    private FragmentExhibitBinding fragmentExhibitBinding;
    private List<ExhibitCard> exhibitCardList;
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
        exhibitCardList.add(new ExhibitCard(
                R.drawable.exhibit1,
                "2023 03/06(一)-11(六)",
                "2023年台北國際工具機展",
                "地點 : 一樓展場 四樓展場")
        );

        exhibitCardList.add(new ExhibitCard(
                R.drawable.exhibit2,
                "2023 03/22(三)-25(六)",
                "2023年TaiSPO台灣國際運動及健身展",
                "地點 : 一樓展場")
        );

        exhibitCardList.add(new ExhibitCard(
                R.drawable.exhibit3,
                "2023 03/28(二)-31(五)",
                "智慧城市展",
                "地點 : 一樓展場")
        );
    }

    private void initCardListView(){
        fragmentExhibitBinding.rvCardlist.setLayoutManager(new LinearLayoutManager(getContext()));
        fragmentExhibitBinding.rvCardlist.addItemDecoration(new SpacesItemDecoration(12));
        fragmentExhibitBinding.rvCardlist.setAdapter(new ExhibitCardAdapter(exhibitCardList));
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