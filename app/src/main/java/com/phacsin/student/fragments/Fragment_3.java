package com.phacsin.student.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.phacsin.student.R;
import com.phacsin.student.recyclerview.DataModel;
import com.phacsin.student.recyclerviewnotifications.AdapterNotifications;
import com.phacsin.student.recyclerviewnotifications.DataModelNotification;
import com.phacsin.student.recyclerviewnotifications.DataNotifications;

import java.util.ArrayList;

/**
 * Created by Bineesh P Babu on 26-11-2016.
 */

public class Fragment_3 extends Fragment {

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<DataModelNotification> data;
    static View.OnClickListener myOnClickListener;
    private static ArrayList<Integer> removedItems;
    public Fragment_3() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_3, container, false);
/*
        myOnClickListener = new MyOnClickListener(this);
*/
        recyclerView = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        data = new ArrayList<DataModelNotification>();
        for (int i = 0; i < DataNotifications.nameArray.length; i++) {
            data.add(new DataModelNotification(
                    DataNotifications.nameArray[i],
                    DataNotifications.versionArray[i],
                    DataNotifications.date[i],
                    DataNotifications.id_[i],
                    DataNotifications.drawableArray[i]
            ));
        }

        removedItems = new ArrayList<Integer>();
        adapter = new AdapterNotifications(data);
        recyclerView.setAdapter(adapter);

        return rootView;
    }

}

