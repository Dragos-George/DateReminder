package com.example.datereminder.MainMenuFragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datereminder.FirstItem;
import com.example.datereminder.Model.FutureAdapter;
import com.example.datereminder.R;

import java.util.ArrayList;
import java.util.List;

public class CategoriesFragment extends Fragment {
    private RecyclerView recyclerView;
    private FutureAdapter futureAdapter;
    private  ArrayList<FirstItem> firstItemList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_categories, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        futureAdapter = new FutureAdapter(firstItemList);

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(futureAdapter);


        firstItemList.add(new FirstItem(R.drawable.ic_fire24dp, "Line 1", "Line 2"));
        firstItemList.add(new FirstItem(R.drawable.ic_fire24dp, "Line 3", "Line 4"));
        firstItemList.add(new FirstItem(R.drawable.ic_fire24dp, "Line 5", "Line 6"));

        futureAdapter.notifyItemRangeInserted(0, firstItemList.size());
        return view;
    }
}
