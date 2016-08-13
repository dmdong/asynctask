package com.manhdong.asynctask;

import android.app.Service;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Saphiro on 6/24/2016.
 */
public class MyAdapter extends ArrayAdapter<Country> {

    Context context;
    int resource;
    List<Country> listCountry;

    public MyAdapter(Context context, int resource, List<Country> objects) {
        super(context, resource, objects);
        this.context = context;
        this.listCountry = objects;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resource, parent,false);
            viewHolder = new ViewHolder();
            viewHolder.image = (ImageView) convertView.findViewById(R.id.photo);
            viewHolder.title = (TextView) convertView.findViewById(R.id.photoTitle);
            convertView.setTag(viewHolder);

        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.image.setImageResource(listCountry.get(position).getImageView());
        viewHolder.title.setText(listCountry.get(position).getTitle());

        return convertView;
    }

    class ViewHolder{
        ImageView image;
        TextView title;
    }
}
