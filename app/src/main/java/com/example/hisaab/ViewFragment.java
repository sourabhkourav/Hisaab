 package com.example.hisaab;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

 /**
 * A simple {@link Fragment} subclass.
 * Use the {@link ViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViewFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ViewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ViewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ViewFragment newInstance(String param1, String param2) {
        ViewFragment fragment = new ViewFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_view, container, false);

//        arraylist handling all the data got from database

        // Get singleton instance of database
        MyDatabaseHelper databaseHelper = MyDatabaseHelper.getInstance(getContext());

        // Get all posts from database
        List<FullData> fullData = databaseHelper.getFullData();
        ArrayList<FullData> listFullData = new ArrayList<>(fullData);


//        listContact.add(new FullData("Sourabh Kourav", "20/5/2027"));
//        for (int i=0;i<2;i++){
//            listContact.add(new FullData());
//        }


        ListView lv = (ListView)rootView.findViewById(R.id.ViewDataListView);

        FullDataAdapter itemsAdapter = new FullDataAdapter(getActivity(), listFullData);

        lv.setAdapter(itemsAdapter);


        return rootView;

//        return inflater.inflate(R.layout.fragment_view, container, false);
    }
}