package com.firstapp.joel.recyclerview;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by joel on 11/9/2017.
 */

public class DisplayData extends AppCompatActivity {
 Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);
        /*ArrayList<ListItem> myCompList = new ArrayList<ListItem>();
        int position = Integer.parseInt(getIntent().getExtras().getString("pos"));
        Toast.makeText(this, "position is = " + position + " with "+ myCompList.get(position).getHeading(), Toast.LENGTH_SHORT).show();
        */
        TextView myheading = (TextView) findViewById(R.id.textviewHeading);
        TextView mydescription = (TextView) findViewById(R.id.textviewDescription);
        TextView mydob = (TextView) findViewById(R.id.textviewDOB);
        TextView mycountry = (TextView) findViewById(R.id.textviewCountry);
        TextView myspouse = (TextView) findViewById(R.id.textviewSpouse);
        ImageView imageViewholder = (ImageView)findViewById(R.id.imageView);


        String headin = super.getIntent().getExtras().getString("heading");
        myheading.setText("Name: \n " + headin);
        String desc = super.getIntent().getExtras().getString("description");
        mydescription.setText("Description: \n " + desc);
        String dob1 = super.getIntent().getExtras().getString("dob");
        mydob.setText("Date of Birth: \n " + dob1);
        String nation = super.getIntent().getExtras().getString("country");
        mycountry.setText("Country: \n " + nation);
        String wife = super.getIntent().getExtras().getString("spouse");
        myspouse.setText("Spouse: \n " +wife);
        String imag = super.getIntent().getExtras().getString("image");
        Picasso.with(context)
                .load(imag)
                .into(imageViewholder);
    }
}