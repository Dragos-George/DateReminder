package com.example.datereminder.Fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.datereminder.FirstItem;
import com.example.datereminder.Model.FutureAdapter;
import com.example.datereminder.R;
import java.util.ArrayList;

public class CategoriesFragment extends Fragment {
    
    private RecyclerView recyclerView;
    private FutureAdapter futureAdapter;
    private  ArrayList<FirstItem> firstItemList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_categories, container, false);


        //Build RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        futureAdapter = new FutureAdapter(firstItemList);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(futureAdapter);

        //Add items
        firstItemList.add(new FirstItem(R.drawable.ic_fire24dp, "Line 1", "Line 2"));
        firstItemList.add(new FirstItem(R.drawable.ic_fire24dp, "Line 3", "Line 4"));
        firstItemList.add(new FirstItem(R.drawable.ic_fire24dp, "Line 5", "Line 6"));
        futureAdapter.notifyItemRangeInserted(0, firstItemList.size());


        //Click change
        futureAdapter.setOnItemClickListener(new FutureAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                changeItem(position, "Clicked");
            }

            @Override
            public void onDeleteClick(int position) {
                removeItem(position);
            }
        });

        return view;

    }


    //Methods

    public void insertItem(int position){
        firstItemList.add(position, new FirstItem(R.drawable.ic_add, "New Item At Position" + position, "This is Line 2"));
        futureAdapter.notifyItemInserted(position);
    }

    public void removeItem(int position){
        firstItemList.remove(position);
        futureAdapter.notifyItemRemoved(position);
    }

    public void changeItem(int position, String text) {
        firstItemList.get(position).changeText1(text);
        futureAdapter.notifyItemChanged(position);
    }
}
