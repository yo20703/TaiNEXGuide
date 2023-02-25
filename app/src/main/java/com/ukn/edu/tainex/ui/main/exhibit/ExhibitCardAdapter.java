package com.ukn.edu.tainex.ui.main.exhibit;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ukn.edu.tainex.R;
import com.ukn.edu.tainex.databinding.BuyticketsBinding;
import com.ukn.edu.tainex.databinding.CardviewEventsgalleryBinding;

import java.util.List;

public class ExhibitCardAdapter extends RecyclerView.Adapter<ExhibitCardAdapter.ViewHolder> {
    final String TAG = "ExhibitCardAdapter";
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

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BuyticketsBinding buyticketsBinding = BuyticketsBinding.inflate(LayoutInflater.from(view.getContext()));
                Dialog dialog = new Dialog(view.getContext());
                View dialogView = buyticketsBinding.getRoot();
                dialog.setContentView(dialogView);
                dialog.show();

                buyticketsBinding.tvTitle.setText(exhibitCard.getName());
                buyticketsBinding.btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();
                    }
                });
                buyticketsBinding.btnOk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();
                    }
                });
            }
        });
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
