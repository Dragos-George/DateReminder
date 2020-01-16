package com.example.datereminder.Fragments;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;

import com.example.datereminder.R;
import com.google.type.DayOfWeek;

import java.time.MonthDay;


public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        CalendarView calendarView = view.findViewById(R.id.home_calendar);
        calendarView.setFirstDayOfWeek(DayOfWeek.MONDAY_VALUE);
//        calendarView.setTopbarVisible(false);

        return view;
    }
}
