package com.example.hisaab;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InsertFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InsertFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private EditText farmerName, factoryRate, date, troliWeight, labourName, labourRate, vehicleName, driverName, vehicleRate;
    private Button saveData ;

    public InsertFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InsertFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InsertFragment newInstance(String param1, String param2) {
        InsertFragment fragment = new InsertFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_insert, container, false);

//        create layout references
        farmerName = rootView.findViewById(R.id.editTextFarmerName);
        factoryRate = rootView.findViewById(R.id.editTextFactoryRate);
        date = rootView.findViewById(R.id.editTextDate);
        troliWeight = rootView.findViewById(R.id.editTextTroliWeight);
        labourName = rootView.findViewById(R.id.editTextLabourName);
        labourRate = rootView.findViewById(R.id.editTextLabourRate);
        vehicleName = rootView.findViewById(R.id.editTextVehicleName);
        driverName = rootView.findViewById(R.id.editTextDriverName);
        vehicleRate = rootView.findViewById(R.id.editTextVehicleRate);
        saveData = rootView.findViewById(R.id.buttonSaveData);


//        setting button onclick listner
        saveData.setOnClickListener(v -> {
            if (validate(farmerName) && validate(factoryRate) && validate(date) && validate(troliWeight) && validate(labourName) && validate(labourRate) && validate(vehicleName) && validate(driverName) && validate(vehicleRate)){

                String farmer_Name = farmerName.getText().toString();
                String d_date = date.getText().toString();
                String labour_Name = labourName.getText().toString();
                String vehicle_Name = vehicleName.getText().toString();
                String driver_Name = driverName.getText().toString();

                float troliweight = Float.parseFloat(troliWeight.getText().toString());
                float factoryrate = Float.parseFloat(factoryRate.getText().toString());
                float totalMoney =  troliweight * factoryrate;
                float labourrate = Float.parseFloat(labourRate.getText().toString());
                float labourTotalMoney = troliweight * labourrate;
                float vehiclerate = Float.parseFloat(vehicleRate.getText().toString());
                float vehicleTotalMoney = troliweight * vehiclerate;

    //            //            check valid values
    //            if (farmer_Name.equals("")||d_date.equals("")||labour_Name.equals("")||vehicle_Name.equals("")||driver_Name.equals("")||
    //            ){
    //                flag = false;
    //                showWarning(farmerName);
    //            }

                Log.i("check"," toatl Money = " + totalMoney);
                Log.i("check"," labour total Money = " + labourTotalMoney);
                Log.i("check"," vehicle total Money = " + vehicleTotalMoney);

    //            create FullData object
                    FullData fullData = new FullData( farmer_Name, d_date, Float.toString(troliweight), Float.toString(factoryrate), Float.toString(totalMoney), Float.toString(labourrate), labour_Name, Float.toString(labourTotalMoney), vehicle_Name, driver_Name,Float.toString(vehiclerate), Float.toString(vehicleTotalMoney));

    //            send data to the database
                    MyDatabaseHelper myDatabaseHelper = MyDatabaseHelper.getInstance(getContext());

                    myDatabaseHelper.addFullData(fullData);


//            set edittexts to empty
                farmerName.setText("");
                factoryRate.setText("");
                date.setText("");
                troliWeight.setText("");
                labourName.setText("");
                labourRate.setText("");
                vehicleName.setText("");
                driverName.setText("");
                vehicleRate.setText("");

            }

        });

        return rootView;

//        return inflater.inflate(R.layout.fragment_insert, container, false);
    }

    public boolean validate(EditText editText){
        if (editText.getText().toString().length()==0){
            showWarning();
            return false;
        }
        return true;
    }

    public void showWarning(){
        Toast.makeText(getContext(),R.string.validDataWarningMessage,Toast.LENGTH_SHORT).show();
    }
}