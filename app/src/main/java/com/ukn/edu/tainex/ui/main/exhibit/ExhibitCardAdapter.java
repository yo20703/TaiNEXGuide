package com.ukn.edu.tainex.ui.main.exhibit;

import android.app.Dialog;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ukn.edu.tainex.ExhibitData;
import com.ukn.edu.tainex.databinding.BuyticketsBinding;
import com.ukn.edu.tainex.databinding.CardviewEventsgalleryBinding;
import com.ukn.edu.tainex.room.AppDataBase;
import com.ukn.edu.tainex.room.MyTicks;
import com.ukn.edu.tainex.room.MyTicksDao;

import java.util.Calendar;
import java.util.List;

public class ExhibitCardAdapter extends RecyclerView.Adapter<ExhibitCardAdapter.ViewHolder> {
    final String TAG = "ExhibitCardAdapter";
    private List<ExhibitData> exhibitCardList;
    private Context context;
    ViewHolder viewHolder;

    ExhibitCardAdapter(List<ExhibitData> exhibitCardList, Context context){
        this.exhibitCardList = exhibitCardList;
        this.context = context;
    }

    @NonNull
    @Override
    public ExhibitCardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        viewHolder = new ViewHolder(CardviewEventsgalleryBinding.inflate(LayoutInflater.from(viewGroup.getContext())));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExhibitCardAdapter.ViewHolder viewHolder, final int i) {
        final ExhibitData exhibitCard = exhibitCardList.get(i);
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
                        String name = String.valueOf(buyticketsBinding.etName.getText());
                        String email = String.valueOf(buyticketsBinding.etEmail.getText());
                        String phoneNumber = String.valueOf(buyticketsBinding.etPhone.getText());

                        saveBuyExhibitInfo(String.valueOf(i), name, email, phoneNumber, exhibitCard);
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

    private void saveBuyExhibitInfo(String tickType, String name, String email, String phoneNumber, ExhibitData exhibitData){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                AppDataBase appDataBase = AppDataBase.getInstance(context);
                MyTicksDao myTicksDao = appDataBase.getMyTicksDao();

                MyTicks myTicks = new MyTicks();
                myTicks.tickType = tickType;
                myTicks.name = name;
                myTicks.email = email;
                myTicks.phoneNumber = phoneNumber;
                myTicks.timeStamp = getNowFormatTime();
                myTicks.image = exhibitData.getImage();
                myTicks.date = exhibitData.getDate();
                myTicks.exhibitName = exhibitData.getName();
                myTicks.place = exhibitData.getPlace();

                myTicksDao.insert(myTicks);
            }
        });

        thread.start();
    }

    private String getNowFormatTime(){
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR) + "/" +
                calendar.get(Calendar.MONTH + 1) + "/" +
                calendar.get(Calendar.DAY_OF_MONTH) + "_"
                + calendar.get(Calendar.HOUR) + ":"
                + calendar.get(Calendar.MINUTE) + ":"
                + calendar.get(Calendar.SECOND) + "."
                + calendar.get(Calendar.MILLISECOND);
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        CardviewEventsgalleryBinding cardviewEventsgalleryBinding;
        public ViewHolder(@NonNull CardviewEventsgalleryBinding viewBinding) {
            super(viewBinding.getRoot());
            cardviewEventsgalleryBinding = viewBinding;
        }
    }
}
