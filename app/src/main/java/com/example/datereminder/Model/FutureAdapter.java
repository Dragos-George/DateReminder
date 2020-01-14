package com.example.datereminder.Model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datereminder.FirstItem;
import com.example.datereminder.R;

import java.util.ArrayList;

public class FutureAdapter extends RecyclerView.Adapter<FutureAdapter.FutureViewHolder> {

    private ArrayList<FirstItem> mFirstList;

    public static class FutureViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;


        public FutureViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mTextView1 = itemView.findViewById(R.id.textView);
            mTextView2 = itemView.findViewById(R.id.textView2);
        }
    }

    public FutureAdapter(ArrayList<FirstItem> firstList){
        mFirstList = firstList;
    }
    @NonNull
    @Override
    public FutureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.first_item, parent, false);
        FutureViewHolder fvh = new FutureViewHolder(v);
        return fvh;
    }

    @Override
    public void onBindViewHolder(@NonNull FutureViewHolder holder, int position) {
        FirstItem currentItem = mFirstList.get(position);

        holder.mImageView.setImageResource(currentItem.getImageResource());
        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(currentItem.getText2());
    }


    @Override
    public int getItemCount() {
        return mFirstList.size();
    }
}
