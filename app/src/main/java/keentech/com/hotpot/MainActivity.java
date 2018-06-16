package keentech.com.hotpot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvList;
    ArrayList<Restaurant> list;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list=new ArrayList<>();

        list.add(new Restaurant("a","a","a","a","a"));
        list.add(new Restaurant("a","a","a","a","a"));
        list.add(new Restaurant("a","a","a","a","a"));
        list.add(new Restaurant("a","a","a","a","a"));
        list.add(new Restaurant("a","a","a","a","a"));

        rvList=findViewById(R.id.list);
        rvList.setAdapter(new RestaurentsListAdapter(list,MainActivity.this));
        rvList.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        rvList.setLayoutManager(mLayoutManager);

    }
}
