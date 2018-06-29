package keentech.com.hotpot;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    String id,itemsString;
    FirebaseDatabase database;
    DatabaseReference mRef;

    RecyclerView rvList;
    ArrayList<Product> list;
    private RecyclerView.LayoutManager mLayoutManager;
    MenuListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        itemsString="";
        id=getIntent().getStringExtra("id");

        database = FirebaseDatabase.getInstance();
        mRef = database.getReference();

        list=new ArrayList<>();
        rvList=findViewById(R.id.List2);
        mAdapter=new MenuListAdapter(list,MenuActivity.this);
        rvList.setAdapter(mAdapter);
        rvList.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        rvList.setLayoutManager(mLayoutManager);


        mRef.child("menu").child(id).child("items").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                itemsString= (String) dataSnapshot.getValue();
                updateList();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(MenuActivity.this, "No Internet Connection", Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void updateList() {
       ArrayList listArr = new ArrayList<String>(Arrays.asList(itemsString.split(",")));

        for(int i=0;i<listArr.size();i++){
            mRef.child("products").child(String.valueOf(listArr.get(i))).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    Product res= dataSnapshot.getValue(Product.class);
                    res.setId(dataSnapshot.getKey());
                    list.add(res);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            mAdapter.notifyDataSetChanged();

                        }
                    });

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }


    }
}
