package com.example.hisaab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;


public class FullDataAdapter extends BaseAdapter {
    private final Context context; //context
    private final ArrayList<FullData> items; //data source of the list adapter

    //public constructor
    public FullDataAdapter(Context context, ArrayList<FullData> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size(); //returns total of items in the list
    }

    @Override
    public Object getItem(int position) {
        return items.get(position); //returns list item at the specified position
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // inflate the layout for each list row
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.list_item, parent, false);
        }

        // get current item to be displayed
        FullData fullData = (FullData) getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent,false);
        }

//        String farmerName, date, troliWeight, factoryRate,
//                totalMoney, labourRate, labourName, labourTotalMoney,
//                vehicle, driverName, vehicleRate, vehicleTotalMoney;


        TextView farmerName = convertView.findViewById(R.id.farmerName);
        TextView date = convertView.findViewById(R.id.date);
        TextView troliWeight = convertView.findViewById(R.id.troliWeight);
        TextView factoryRate = convertView.findViewById(R.id.factoryRate);
        TextView totalMoney = convertView.findViewById(R.id.totalMoney);
        TextView labourRate = convertView.findViewById(R.id.labourRate);
        TextView labourName = convertView.findViewById(R.id.labourName);
        TextView labourTotalMoney = convertView.findViewById(R.id.labourTotalMoney);
        TextView vehicle = convertView.findViewById(R.id.vehicle);
        TextView driverName = convertView.findViewById(R.id.driverName);
        TextView vehicleRate = convertView.findViewById(R.id.vehicleRate);
        TextView vehicleTotalMoney = convertView.findViewById(R.id.vehicleTotalMoney);
        TextView textView22 = convertView.findViewById(R.id.textView22);
        TextView textView23 = convertView.findViewById(R.id.textView23);


//        set data in the item views
        farmerName.setText(fullData.farmerName);
        date.setText(fullData.date);
        troliWeight.setText(fullData.troliWeight);
        factoryRate.setText(fullData.factoryRate);
        labourRate.setText(fullData.labourRate);
        totalMoney.setText(fullData.totalMoney);
        labourName.setText(fullData.labourName);
        labourTotalMoney.setText(fullData.labourTotalMoney);
        vehicle.setText(fullData.vehicle);
        driverName.setText(fullData.driverName);
        vehicleRate.setText(fullData.vehicleRate);
        vehicleTotalMoney.setText(fullData.vehicleTotalMoney);

//        // get the TextView for item name and item description
//        TextView textViewFullDataName = (TextView)
//                convertView.findViewById(R.id.text_view_item_name);
//        TextView textViewItemDescription = (TextView)
//                convertView.findViewById(R.id.text_view_item_description);
//
//        //sets the text for item name and item description from the current item object
//        textViewItemName.setText(currentItem.getItemName());
//        textViewItemDescription.setText(currentItem.getItemDescription());

        // returns the view for the current row
        return convertView;
    }
}
