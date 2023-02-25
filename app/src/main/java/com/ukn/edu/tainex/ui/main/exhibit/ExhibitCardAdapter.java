package com.ukn.edu.tainex.ui.main.exhibit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ukn.edu.tainex.databinding.CardviewEventsgalleryBinding;

import java.util.List;

public class ExhibitCardAdapter extends RecyclerView.Adapter<ExhibitCardAdapter.ViewHolder> {
    private List<ExhibitCard> exhibitCardList;
    ViewHolder viewHolder;

    ExhibitCardAdapter(List<ExhibitCard> exhibitCardList){
        this.exhibitCardList = exhibitCardList;
    }

    @NonNull
    @Override
    public ExhibitCardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        viewHolder = new ViewHolder(CardviewEventsgalleryBinding.inflate(LayoutInflater.from(viewGroup.getContext())));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExhibitCardAdapter.ViewHolder viewHolder, int i) {
        final ExhibitCard exhibitCard = exhibitCardList.get(i);
        viewHolder.cardviewEventsgalleryBinding.ivExhibit.setImageResource(exhibitCard.getImage());
        viewHolder.cardviewEventsgalleryBinding.tvDate.setText(exhibitCard.getDate());
        viewHolder.cardviewEventsgalleryBinding.tvName.setText(exhibitCard.getName());
        viewHolder.cardviewEventsgalleryBinding.tvPlace.setText(exhibitCard.getPlace());
    }

    @Override
    public int getItemCount() {
        return exhibitCardList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        CardviewEventsgalleryBinding cardviewEventsgalleryBinding;
        public ViewHolder(@NonNull CardviewEventsgalleryBinding viewBonding) {
            super(viewBonding.getRoot());
            cardviewEventsgalleryBinding = viewBonding;
        }
    }
}
