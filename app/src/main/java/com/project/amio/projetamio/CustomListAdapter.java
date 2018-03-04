package com.project.amio.projetamio;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by MusKad on 04/03/2018.
 */

public class CustomListAdapter extends ArrayAdapter {

    private List<Sensor> list;
    private final Activity context;
    private static final int LIMIT_LIGHT = 150;


    public CustomListAdapter(Activity context, List<Sensor> list){

        super(context,R.layout.content_list_view , list);

        this.context=context;
        this.list = list;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.content_list_view, null,true);

        TextView sensorNameTextField = (TextView) rowView.findViewById(R.id.textViewSensorName);
        TextView sensorValueTextField = (TextView) rowView.findViewById(R.id.textViewSensorValue);
        ImageView sensorStateImageView = (ImageView) rowView.findViewById(R.id.imageViewSensorState);

        sensorNameTextField.setText(list.get(position).getName());
        sensorValueTextField.setText(list.get(position).getValue() + "");
        if (list.get(position).getValue() > LIMIT_LIGHT)
            sensorStateImageView.setImageResource(R.mipmap.light_bulb_on);
        else
            sensorStateImageView.setImageResource(R.mipmap.light_bulb_off);


        return rowView;

    };

}
