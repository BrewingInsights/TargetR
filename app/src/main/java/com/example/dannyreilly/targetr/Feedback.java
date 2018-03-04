package com.example.dannyreilly.targetr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class Feedback extends AppCompatActivity {

    private EditText mFeedbackfield;
    private Button mBack, mSubmit;

    private DatabaseReference mCustomerDatabase;
    private String Terr, shsId, feedbackinput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

       mFeedbackfield = (EditText) findViewById(R.id.feedbackinput);
       mBack = (Button) findViewById(R.id.back);
       mSubmit = (Button) findViewById(R.id.submit);

       Terr = "5WCCADT1";
       mCustomerDatabase = FirebaseDatabase.getInstance().getReference().child("Terr").child(Terr).child("111111");

       getUserInfo();

       mSubmit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               saveUserInformation();
               finish();
               return;
           }
       });

       mBack.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View view){
               finish();
               return;
           }
       });

    }

    private void getUserInfo(){
        mCustomerDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists() && dataSnapshot.getChildrenCount()>0){
                    Map<String, Object> map = (Map<String, Object>) dataSnapshot.getValue();
                    if(map.get("feedbackinput") !=null){
                        feedbackinput = map.get("feedbackinput").toString();
                        mFeedbackfield.setText(feedbackinput);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void saveUserInformation() {
        feedbackinput = mFeedbackfield.getText().toString();

        Map userInfo = new HashMap();
        userInfo.put("feedbackinput",feedbackinput);
        mCustomerDatabase.updateChildren(userInfo);

    }
}
