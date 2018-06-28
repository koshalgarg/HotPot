package keentech.com.hotpot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    FirebaseDatabase database;
    DatabaseReference mRef;

    RecyclerView rvList;
    ArrayList<Restaurant> list;
    private RecyclerView.LayoutManager mLayoutManager;
    RestaurentsListAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        database = FirebaseDatabase.getInstance();
        mRef = database.getReference("restaurents");

        list=new ArrayList<>();
        rvList=findViewById(R.id.list);
        mAdapter=new RestaurentsListAdapter(list,MainActivity.this);
        rvList.setAdapter(mAdapter);
        rvList.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        rvList.setLayoutManager(mLayoutManager);

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot restaurent: dataSnapshot.getChildren()) {

                    Restaurant res= restaurent.getValue(Restaurant.class);
                    res.setId(restaurent.getKey());
                    list.add(res);
                    mAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("i", "Failed to read value.", error.toException());
            }
        });


    }
}
