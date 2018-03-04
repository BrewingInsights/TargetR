package com.example.dannyreilly.targetr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;
import java.util.List;

public class Swipe extends AppCompatActivity {

    //private ArrayList<String> al;
    private Cards Cards_data[];
    private arrayAdapter arrayAdapter;
    private Button mFeedback, mMap;

    ListView listView;
    List<Cards> rowitems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe);

        rowitems = new ArrayList<Cards>();

        arrayAdapter = new arrayAdapter(this, R.layout.item, rowitems);

        SwipeFlingAdapterView flingContainer = (SwipeFlingAdapterView) findViewById(R.id.frame);

        flingContainer.setAdapter(arrayAdapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                Log.d("LIST", "removed object!");
                rowitems.remove(0);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                //Toast.makeText(Swipe.this, "Left!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRightCardExit(Object dataObject) {
                //Toast.makeText(Swipe.this, "Right!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
                // Ask for more data here
                //al.add("XML ".concat(String.valueOf(i)));
                //arrayAdapter.notifyDataSetChanged();
                //Log.d("LIST", "notified");
                //i++;
                getHCPs();
            }

            @Override
            public void onScroll(float scrollProgressPercent) {
            }
        });


        // Optionally add an OnItemClickListener
        flingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {
                //Toast.makeText(Swipe.this, "Clicked!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void getHCPs() {
        DatabaseReference TerrDB = FirebaseDatabase.getInstance().getReference().child("Terr").child("5WCCADT1");
        TerrDB.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
               if(dataSnapshot.exists()){
                   String name = dataSnapshot.child("name").getValue().toString();
                   String address = dataSnapshot.child("address").getValue().toString();
                   String score = dataSnapshot.child("score").getValue().toString();
                   String distance = dataSnapshot.child("distance").getValue().toString();
                   String spec = dataSnapshot.child("spec").getValue().toString();
                   String callplantarget = dataSnapshot.child("callplantarget").getValue().toString();
                   String marketrx = dataSnapshot.child("marketrx").getValue().toString();
                   String favor = dataSnapshot.child("favor").getValue().toString();
                   String loyal = dataSnapshot.child("loyal").getValue().toString();
                   float finalScore = Float.parseFloat(score);
                   Cards item = new Cards(dataSnapshot.getKey(), name, address, finalScore, distance, spec, callplantarget, marketrx, loyal, favor);
                   rowitems.add(item);
                   arrayAdapter.notifyDataSetChanged();
               }
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            }
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
            }
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

    }

    public void goToFeedback (View view){
        Intent intent = new Intent (Swipe.this, Feedback.class);
        //cards obj = (cards) dataObject;
        //intent.putExtra("SHS_ID", shsid)
        startActivity(intent);
        return;
    }


}

