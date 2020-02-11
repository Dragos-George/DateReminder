package com.example.datereminder.Fragments;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;

import com.example.datereminder.FirstItem;
import com.example.datereminder.MainActivity;
import com.example.datereminder.Model.DatabaseHelper;
import com.example.datereminder.Model.DateItem;
import com.example.datereminder.Model.DateItemAdapter;
import com.example.datereminder.Model.FutureAdapter;
import com.example.datereminder.R;
import com.google.type.DayOfWeek;

import java.time.Instant;
import java.time.MonthDay;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private DateItemAdapter dateItemAdapter;
    private ArrayList<DateItem> dateItemList = new ArrayList<>();
    private static DatabaseHelper db;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        CalendarView calendarView = view.findViewById(R.id.home_calendar);
        calendarView.setFirstDayOfWeek(DayOfWeek.MONDAY_VALUE);

        recyclerView = view.findViewById(R.id.homeRecyclerView);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        dateItemAdapter = new DateItemAdapter(dateItemList);

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(dateItemAdapter);

        db = new DatabaseHelper(getActivity());
        db.createDatabase();


        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                Date date = new Date();
                date.setYear(year);
                date.setMonth(month);
                date.setDate(dayOfMonth);
                //date = new Date(year, month, dayOfMonth);
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, dayOfMonth, 0, 0, 0);

                //calendar.setTime(date);
                //Instant instant = Instant.
                Toast.makeText(getActivity(), calendar.getTimeInMillis()/1000 + "", Toast.LENGTH_SHORT).show();
            }
        });



//        dateItemList= db.readDateItem();
//        dateItemList= db.readDateItem();
//        dateItemAdapter.notifyDataSetChanged();

//        dateItemList.add(new DateItem(R.drawable.circle, "Line 1", "Line 2"));
//        dateItemList.add(new DateItem(R.drawable.circle, "Line 3", "Line 4"));
//        dateItemList.add(new DateItem(R.drawable.circle, "Line 5", "Line 6"));
//        dateItemList.add(new DateItem(R.drawable.circle, "Line 1", "Line 2"));
//        dateItemList.add(new DateItem(R.drawable.circle, "Line 3", "Line 4"));
//        dateItemList.add(new DateItem(R.drawable.circle, "Line 5", "Line 6"));
//        dateItemList.add(new DateItem(R.drawable.circle, "Line 3", "Line 4"));
//        dateItemList.add(new DateItem(R.drawable.circle, "Line 1", "Line 2"));
//        dateItemList.add(new DateItem(R.drawable.circle, "Line 3", "Line 4"));
//        dateItemList.add(new DateItem(R.drawable.circle, "Line 5", "Line 6"));
//        dateItemList.add(new DateItem(R.drawable.circle, "Line 1", "Line 2"));
//        dateItemList.add(new DateItem(R.drawable.circle, "Line 3", "Line 4"));
//        dateItemList.add(new DateItem(R.drawable.circle, "Line 5", "Line 6"));
//        dateItemList.add(new DateItem(R.drawable.circle, "Line 3", "Line 4"));
//        dateItemList.add(new DateItem(R.drawable.circle, "Line 5", "Line 6"));

        return view;

    }

}
