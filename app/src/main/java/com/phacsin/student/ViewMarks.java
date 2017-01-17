package com.phacsin.student;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jaredrummler.materialspinner.MaterialSpinner;
import com.phacsin.student.customfonts.HelveticaButton;
import com.phacsin.student.recyclerview.DataModel;
import com.phacsin.student.recyclerviewmarks.AdapterMarkDetails;
import com.phacsin.student.recyclerviewmarks.DataMarks;

import java.util.ArrayList;

/**
 * Created by Bineesh P Babu on 09-01-2017.
 */

public class ViewMarks extends AppCompatActivity {
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<DataModel> data;
    public static View.OnClickListener myOnClickListener;
    private static ArrayList<Integer> removedItems;
    HelveticaButton btn_sbmt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_marks);
        btn_sbmt = (HelveticaButton) findViewById(R.id.btn_submit_month);
        MaterialSpinner spinner = (MaterialSpinner) findViewById(R.id.spinner);
        spinner.setItems("Sessional 1", "Sessional 1", "Sessional 1");
        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                Snackbar.make(view, "Attendance of " + item, Snackbar.LENGTH_LONG).show();
            }
        });


        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        data = new ArrayList<DataModel>();
        for (int i = 0; i < DataMarks.nameArray.length; i++) {
            data.add(new DataModel(
                    DataMarks.nameArray[i],
                    DataMarks.marks_sub[i],
                    DataMarks.id_[i],
                    DataMarks.drawableArray[i]
            ));
        }

        removedItems = new ArrayList<Integer>();
        adapter = new AdapterMarkDetails(data);
        recyclerView.setAdapter(adapter);
    }

}