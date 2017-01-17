package com.phacsin.student.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.jaredrummler.materialspinner.MaterialSpinner;
import com.phacsin.student.R;
import com.phacsin.student.customfonts.HelveticaButton;
import com.phacsin.student.recyclerview.DataModel;
import com.phacsin.student.recyclerviewAttendance.AdapterAttendanceDetails;
import com.phacsin.student.recyclerviewAttendance.DataAttendance;


import java.util.ArrayList;


/**
 * Created by Bineesh P Babu on 26-11-2016.
 */

public class Fragment_1 extends Fragment  {

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<DataModel> data;
    public static View.OnClickListener myOnClickListener;
    private static ArrayList<Integer> removedItems;
    HelveticaButton btn_sbmt;

    public Fragment_1() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_1, container, false);
        btn_sbmt = (HelveticaButton)rootView.findViewById(R.id.btn_submit_month);
        MaterialSpinner spinner = (MaterialSpinner) rootView.findViewById(R.id.spinner);
        spinner.setItems("January", "February", "March", "April", "May","Total Month");
        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                Snackbar.make(view, "Attendance of " + item, Snackbar.LENGTH_LONG).show();
            }
        });
/*
        myOnClickListener = new MyOnClickListener(this);
*/
        recyclerView = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        data = new ArrayList<DataModel>();
        for (int i = 0; i < DataAttendance.nameArray.length; i++) {
            data.add(new DataModel(
                    DataAttendance.nameArray[i],
                    DataAttendance.attendance_perc[i],
                    DataAttendance.id_[i],
                    DataAttendance.drawableArray[i]
            ));
        }

        removedItems = new ArrayList<Integer>();
        adapter = new AdapterAttendanceDetails(data);
        recyclerView.setAdapter(adapter);
        return rootView;
    }

}

