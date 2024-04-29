package com.example.networking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<Mountain> mountains;
    private LayoutInflater layoutInflater;
    private OnClickListener onClickListener;

    RecyclerViewAdapter(Context context, ArrayList<Mountain> mountains, OnClickListener onClickListener) {
       this.layoutInflater = LayoutInflater.from(context);
       this.mountains = mountains;
       this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.recyclerview_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        holder.title.setText(mountains.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return mountains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;

        ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            title = itemView.findViewById(R.id.title);
        }

        @Override
        public void onClick(View view) {
            onClickListener.onClick(mountains.get(getAdapterPosition()));
        }

    }

    public interface OnClickListener {
        void onClick(Mountain mountains);
    }

    //Skickar in listOfMountains i RecyclerView så att dom visas i appen
    public void update(ArrayList newMountains){
        mountains.addAll(newMountains);
    }

}
