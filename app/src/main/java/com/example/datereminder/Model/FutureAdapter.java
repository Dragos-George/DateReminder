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

import org.w3c.dom.Text;

import java.util.ArrayList;

public class FutureAdapter extends RecyclerView.Adapter {

    private ArrayList<FirstItem> mFirstList;
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.first_item, parent, false);
        FutureViewHolder fvh = new FutureViewHolder(v);
        return fvh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

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
}
