package com.ukn.edu.tainex.ui.main.myticks;

import android.graphics.Rect;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ukn.edu.tainex.R;
import com.ukn.edu.tainex.databinding.CardviewMyticksBinding;
import com.ukn.edu.tainex.databinding.FragmentExhibitBinding;
import com.ukn.edu.tainex.databinding.FragmentMySticksBinding;
import com.ukn.edu.tainex.room.AppDataBase;
import com.ukn.edu.tainex.room.MyTicks;
import com.ukn.edu.tainex.room.MyTicksDao;
import com.ukn.edu.tainex.ui.main.exhibit.ExhibitCardAdapter;
import com.ukn.edu.tainex.ui.main.exhibit.ExhibitFragment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MyTicksFragment extends Fragment {
    FragmentMySticksBinding fragmentMySticksBinding;
    List<MyTicksCardData> myTicksCardDataList;
    public MyTicksFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentMySticksBinding = FragmentMySticksBinding.inflate(inflater, container, false);
        initMyTicksData();
        return fragmentMySticksBinding.getRoot();
    }

    private void initMyTicksData(){
        myTicksCardDataList = new ArrayList<>();
        Thread syncThread = new Thread(new Runnable() {
            @Override
            public void run() {
                syncMyTicksCardData();
                initCardListView();
            }
        });
        syncThread.start();
    }

    private void initCardListView(){
        fragmentMySticksBinding.rvMyticksList.setLayoutManager(new LinearLayoutManager(getContext()));
        fragmentMySticksBinding.rvMyticksList.addItemDecoration(new SpacesItemDecoration(12));
        fragmentMySticksBinding.rvMyticksList.setAdapter(new MyTicksCardAdapter(myTicksCardDataList));
    }

    private void syncMyTicksCardData(){
        AppDataBase appDataBase = AppDataBase.getInstance(getActivity());
        MyTicksDao myTicksDao = appDataBase.getMyTicksDao();
        List<MyTicks> myTicks = myTicksDao.getAll();

        myTicksCardDataList.clear();
        for(MyTicks myTicks1:myTicks){
            MyTicksCardData myTicksCardData = new MyTicksCardData(
                    myTicks1.image,
                    myTicks1.date,
                    myTicks1.name,
                    myTicks1.place,
                    myTicks1.timeStamp,
                    myTicksDao.findByTickType(myTicks1.tickType).size()
            );
            myTicksCardDataList.add(myTicksCardData);
        }
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