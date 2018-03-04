package com.example.dannyreilly.targetr;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;


/**
 * Created by dannyreilly on 2/25/18.
 */

public class arrayAdapter extends ArrayAdapter<Cards> {

    Context context;

    public arrayAdapter(Context context, int resourceId, List<Cards> items){
        super(context, resourceId, items);

    }

    public View getView(int position, View convertView, ViewGroup parent)  {
        Cards card_item = getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item, parent, false);
        }

        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView address = (TextView) convertView.findViewById(R.id.address);
        RatingBar score = (RatingBar) convertView.findViewById(R.id.score);
        TextView distance = (TextView) convertView.findViewById(R.id.distance);
        TextView spec = (TextView) convertView.findViewById(R.id.spec);
        TextView callplantarget = (TextView) convertView.findViewById(R.id.callplantarget);
        TextView marketrx = (TextView) convertView.findViewById(R.id.marketrx);
        TextView loyal = (TextView) convertView.findViewById(R.id.loyal);
        TextView favor  = (TextView) convertView.findViewById(R.id.favor);


        name.setText(card_item.getName());
        address.setText(card_item.getaddress());
        score.setRating(card_item.getscore());
        distance.setText(card_item.getdistance());
        spec.setText(card_item.getspec());
        callplantarget.setText(card_item.getCallplantarget());
        marketrx.setText(card_item.getMarketrx());
        favor.setText(card_item.getFavor());
        loyal.setText(card_item.getLoyal());

        return convertView;

    }

}
