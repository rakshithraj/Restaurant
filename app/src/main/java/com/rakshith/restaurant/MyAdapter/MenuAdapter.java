package com.rakshith.restaurant.MyAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.rakshith.restaurant.R;
import com.rakshith.restaurant.dao.MenuItem;
import com.rakshith.restaurant.dao.NavDrawerItem;
import com.rakshith.restaurant.side_menu.NavigationDrawerAdapter;

import java.util.Collections;
import java.util.List;

/**
 * Created by Rakshith on 10/6/2015.
 */
public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MyViewHolder> {
    List<MenuItem> data = Collections.emptyList();
    private LayoutInflater inflater;
    private Context context;

    public MenuAdapter(Context context, List<MenuItem> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    public void delete(int position) {
        data.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.menu_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MenuItem current = data.get(position);
        holder.menuImage.setImageResource(current.getImageId());
        holder.itemView.setOnClickListener(new ItemOnclickListner(position));


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView menuImage;
        View itemView;
        public MyViewHolder(View itemView) {
            super(itemView);
            menuImage = (ImageView) itemView.findViewById(R.id.menuImage);
            this.itemView=itemView;
        }
    }

    public class ItemOnclickListner implements View.OnClickListener {
        int postion;
        public  ItemOnclickListner(int postion ){
            this.postion=postion;
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context,"clicked psoition "+(postion+1),Toast.LENGTH_SHORT).show();
        }
    }
}