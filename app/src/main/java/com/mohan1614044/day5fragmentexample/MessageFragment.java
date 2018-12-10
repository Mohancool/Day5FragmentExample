package com.mohan1614044.day5fragmentexample;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment {

    private EditText editText;
    private Button button;
    onMessegeReadListner messegeReadListner;

    public MessageFragment() {
        // Required empty public constructor
    }
    public interface onMessegeReadListner {
        public void onMessageRead(String message) ;


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_message, container, false);

        editText =view.findViewById(R.id.textMsg);
        button =view.findViewById(R.id.btnsend);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             String message  =editText.getText().toString();

             messegeReadListner.onMessageRead(message);
            }
        });


        return view;
    }


    @Override

    public void onAttach(Context context) {

        super.onAttach(context);

        Activity activity =  (Activity) context;

        try {
            messegeReadListner = (onMessegeReadListner) activity;
        }catch (ClassCastException e){
            throw  new ClassCastException(activity.toString()+"must override onMessageRead...");
        }
    }

}
