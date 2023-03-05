package com.ukn.edu.tainex.ui.main.myticks;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ukn.edu.tainex.ExhibitData;
import com.ukn.edu.tainex.databinding.CardviewMyticksBinding;

import java.util.List;


public class MyTicksCardAdapter extends RecyclerView.Adapter<MyTicksCardAdapter.ViewHolder>{
    private List<MyTicksCardData> myTicksCardDataList;
    ViewHolder viewHolder;

    public MyTicksCardAdapter(List<MyTicksCardData> myTicksCardDataList) {
        this.myTicksCardDataList = myTicksCardDataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        viewHolder = new MyTicksCardAdapter.ViewHolder(CardviewMyticksBinding.inflate(LayoutInflater.from(parent.getContext())));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyTicksCardAdapter.ViewHolder holder, int position) {
        final MyTicksCardData exhibitCard = myTicksCardDataList.get(position);
        viewHolder.cardviewMyticksBinding.ivExhibit.setImageResource(exhibitCard.getImage());
        viewHolder.cardviewMyticksBinding.tvDate.setText(exhibitCard.getDate());
        viewHolder.cardviewMyticksBinding.tvName.setText(exhibitCard.getPlace());
        viewHolder.cardviewMyticksBinding.tvPlace.setText(exhibitCard.getPlace());
        viewHolder.cardviewMyticksBinding.tvBuytime.setText("購買時間 : "+exhibitCard.getTime());
    }

    @Override
    public int getItemCount() {
        return myTicksCardDataList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        CardviewMyticksBinding cardviewMyticksBinding;
        public ViewHolder(@NonNull CardviewMyticksBinding viewBinding) {
            super(viewBinding.getRoot());
            cardviewMyticksBinding = viewBinding;
        }
    }
}
