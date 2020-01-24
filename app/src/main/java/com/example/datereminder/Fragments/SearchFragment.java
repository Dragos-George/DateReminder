package com.example.datereminder.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.datereminder.Model.DateItem;
import com.example.datereminder.Model.DateItemAdapter;
import com.example.datereminder.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {
    private RecyclerView recyclerView;
    private DateItemAdapter recyclerViewAdapter;
    private ArrayList<DateItem> dateItemList = new ArrayList<DateItem>();

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        recyclerView = view.findViewById(R.id.search_recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager((getActivity()));

        recyclerViewAdapter = new DateItemAdapter(dateItemList);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);

        //populate recyclerview
        populateRecyclerView(100);
        //populateRecyclerView(20);

        return view;
    }

    private void populateRecyclerView(int size) {
        int oldSize = recyclerViewAdapter.getItemCount();
        for (int i = 1; i <= size; i++) {
            dateItemList.add(new DateItem(R.drawable.circle, "Title " + i, "Description " + i));
        }
        recyclerViewAdapter.notifyItemRangeInserted(oldSize, oldSize + size);
    }
}
