package com.example.datereminder.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.datereminder.Model.DatabaseHelper;
import com.example.datereminder.Model.DateItem;
import com.example.datereminder.Model.DateItemAdapter;
import com.example.datereminder.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {
    private RecyclerView recyclerView;
    private DateItemAdapter recyclerViewAdapter;
    private ArrayList<DateItem> dateItemList = new ArrayList<DateItem>();
    private EditText searchBar;
    private DatabaseHelper db;

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
        searchBar = view.findViewById(R.id.fragment_search_edittext);

        db = new DatabaseHelper(getActivity());
        db.createDatabase();

        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                dateItemList.clear();
                if (s.toString().length()>2){
                    ArrayList<DateItem> searchResult = db.SearchDateItemTable(searchBar.getText().toString());
                    if (searchResult != null) {
                        dateItemList.addAll(searchResult);
                    }
                }
                recyclerViewAdapter.notifyDataSetChanged();
            }
        });

        return view;
    }

//    private void populateRecyclerView(int size) {
//        int oldSize = recyclerViewAdapter.getItemCount();
//        for (int i = 1; i <= size; i++) {
//            dateItemList.add(new DateItem("Title " + i, "Description " + i));
//        }
//        recyclerViewAdapter.notifyItemRangeInserted(oldSize, oldSize + size);
//    }
//
//    public void addToItems(ArrayList<DateItem> myNewList) {
//        dateItemList = myNewList;
//        Objects.requireNonNull(recyclerView.getAdapter()).notifyDataSetChanged();
//    }
}
