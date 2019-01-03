package com.a000webhostapp.infopizzalocal.pizzalocal;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Myclass> {

    Context context;
    ArrayList<GetterSetter> arrayList;

    public MyAdapter(Context context, ArrayList<GetterSetter> arrayList) {
        this.context = context;
        this.arrayList = arrayList;

    }

    @Override
    public Myclass onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurantfile, parent, false);
        Myclass myclass = new Myclass(v, context, arrayList);
        return myclass;
    }

    @Override
    public void onBindViewHolder(final Myclass holder, final int position) {

        final GetterSetter g1 = arrayList.get(position);
       // holder.im.setImageResource(g1.getImg());
        holder.tv.setText(g1.getTitle());
       // holder.desc.setText(g1.getDesc());
        holder.city.setText(g1.getCity());
        holder.zip.setText(g1.getZip());
        Picasso.with(context)
                .load(g1.getImage())
                .into(holder.im);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, ""+g1.getTitle(), Toast.LENGTH_SHORT).show();

                holder.onClick(v);

            }
        });


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


     class Myclass extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        ImageView im;
        TextView tv;
        TextView city;
        TextView zip;
        TextView desc;
        TextView small;
        TextView medium;
        TextView large;
        ArrayList<GetterSetter> arrayList;
        Context context;



        public Myclass(View itemView, Context context, ArrayList<GetterSetter> arrayList) {
            super(itemView);
            this.arrayList = arrayList;
            this.context = context;


            itemView.setOnClickListener(this);

            tv = itemView.findViewById(R.id.tv);
            city = itemView.findViewById(R.id.city);
            zip = itemView.findViewById(R.id.zip);
            desc = itemView.findViewById(R.id.desc);
            small = itemView.findViewById(R.id.small);
            medium = itemView.findViewById(R.id.medium);
            large = itemView.findViewById(R.id.large);

            im = itemView.findViewById (R.id.imview);

        }



        @Override
        public void onClick(View v) {

            int position = getAdapterPosition();
            GetterSetter arrayList = this.arrayList.get(position);
            Intent intent = new Intent(this.context, PizzaRestaurants.class);
            intent.putExtra("city", arrayList.getCity());
            intent.putExtra("zip", arrayList.getZip());
          //  intent.putExtra("large", arrayList.getLarge_price());
          //  intent.putExtra("desc", arrayList.getDesc());
            intent.putExtra("tv", arrayList.getTitle());

            this.context.startActivity(intent);


        }
    }
}
