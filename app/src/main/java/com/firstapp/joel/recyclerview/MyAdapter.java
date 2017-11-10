package com.firstapp.joel.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by joel on 11/9/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> implements View.OnClickListener  {
    List<ListItem> listItems;
    private Context context;
    //ImageLoader imageLoader;


    public MyAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        final ListItem myList = listItems.get(position);

        holder.heading.setText(myList.getHeading());
        holder.description.setText(myList.getDesc());
       // holder.dob.setText(myList.getDob());
        //holder.country.setText(myList.getCountry());
        //holder.spouse.setText(myList.getSpouse());
        Picasso.with(context)
                .load(myList.getImage_url())
                .into(holder.imageView);



      holder.linearLayout.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Toast.makeText(context, "item Clicked : "+ myList.getHeading() + "postion : " +
                      position ,Toast.LENGTH_LONG).show();
              Intent i = new Intent(context,DisplayData.class);
              i.putExtra("heading",""+myList.getHeading());
              i.putExtra("description",""+myList.getDesc());
              i.putExtra("dob",""+myList.getDob());
              i.putExtra("country",""+myList.getCountry());
              i.putExtra("spouse",""+ myList.getSpouse());
              i.putExtra("image",""+myList.getImage_url());
                v.getContext().startActivity(i);

          }
      });
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    @Override
    public void onClick(View v) {

    }



    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView heading,description,dob,country,spouse;
        ImageView imageView;
        LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            heading= (TextView) itemView.findViewById(R.id.textviewHeading);
            description= (TextView) itemView.findViewById(R.id.textviewDescription);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.MyLLitem);

        }
    }
}
