package com.example.datereminder.Model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datereminder.R;
import java.util.ArrayList;

public class DateItemAdapter extends RecyclerView.Adapter<DateItemAdapter.DateItemViewHolder> {


    private ArrayList<DateItem> mDateItem;

    public DateItemAdapter(ArrayList<DateItem> dateItem) {
        mDateItem = dateItem;
    }

    @NonNull
    @Override
    public DateItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.date_item, parent, false);
        return new DateItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DateItemViewHolder holder, int position) {
        DateItem currentItem = mDateItem.get(position);

        //holder.mItemTag.setImageResource(currentItem.getColor());
        holder.mItemTitle.setText(currentItem.getName());
        holder.mItemDescription.setText(currentItem.getDescription());
    }

    @Override
    public int getItemCount() {
        return mDateItem.size();
    }

    public static class DateItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView mItemTag;
        private TextView mItemTitle;
        private TextView mItemDescription;

        private DateItemViewHolder(@NonNull View itemView) {
            super(itemView);
            mItemTag = itemView.findViewById(R.id.date_item_tag);
            mItemTitle = itemView.findViewById(R.id.date_item_title);
            mItemDescription = itemView.findViewById(R.id.date_item_description);
        }
    }
}
