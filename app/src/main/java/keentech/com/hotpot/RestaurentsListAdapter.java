package keentech.com.hotpot;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

class RestaurentsListAdapter extends RecyclerView.Adapter<RestaurentsListAdapter.RestaurantViewHolder> {

    private ArrayList<Restaurant> list;
    private Context mContext;

    public RestaurentsListAdapter(ArrayList<Restaurant> list, MainActivity mainActivity) {

        this.list=list;
        this.mContext=mainActivity;

    }

    @Override
    public RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.restaurant_layout, parent, false);
        return new RestaurentsListAdapter.RestaurantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RestaurantViewHolder holder, final int position) {

        holder.name.setText(list.get(position).getName());
        holder.address.setText(list.get(position).getAddress());
        Picasso.get().load(list.get(position).getLink()).into(holder.image);
        holder.number.setText(list.get(position).getNumber());

        holder.viewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(mContext,MenuActivity.class);
                i.putExtra("id",list.get(position).getId());
                mContext.startActivity(i);
            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

     class RestaurantViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name,address,number;
        Button viewbtn;

        public RestaurantViewHolder(View view) {
            super(view);

            image=view.findViewById(R.id.image);
            name=view.findViewById(R.id.name);
            address=view.findViewById(R.id.address);
            number=view.findViewById(R.id.number);
            viewbtn=view.findViewById(R.id.viewbtn);


        }
    }
}
