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

class MenuListAdapter extends RecyclerView.Adapter<MenuListAdapter.MenuViewHolder> {

    private ArrayList<Product> list;
    private Context mContext;

    public MenuListAdapter(ArrayList<Product> list, Context mainActivity) {

        this.list=list;
        this.mContext=mainActivity;

    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_layout, parent, false);
        return new MenuListAdapter.MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MenuViewHolder holder, int position) {

        holder.name.setText(list.get(position).getName());
        holder.serving.setText(String.valueOf(list.get(position).getServing()));
        holder.price.setText(String.valueOf(list.get(position).getPrice()));

        if(list.get(position).getVeg()==1){
            holder.veg.setText("Veg");
        }
        else {
            holder.veg.setText("Non Veg");
        }

        Picasso.get().load(list.get(position).getLink()).into(holder.image);



    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class MenuViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name,serving,price,veg;
        Button addbtn;

        public MenuViewHolder(View view) {
            super(view);

            image=view.findViewById(R.id.image);
            name=view.findViewById(R.id.name);
            serving=view.findViewById(R.id.serving);
            price=view.findViewById(R.id.price);
            veg=view.findViewById(R.id.veg);
            addbtn=view.findViewById(R.id.addbtn);


        }
    }
}
