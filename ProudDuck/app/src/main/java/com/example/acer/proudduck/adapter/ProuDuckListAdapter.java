package com.example.acer.proudduck.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.acer.proudduck.R;
import com.example.acer.proudduck.model.ProuDuck;

import java.util.ArrayList;

/**
 * Created by ACER on 20/11/2017.
 */

public class ProuDuckListAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<ProuDuck> ducksList;

    public ProuDuckListAdapter(Context context, int layout, ArrayList<ProuDuck> bagsList) {
        this.context = context;
        this.layout = layout;
        this.ducksList = bagsList;
    }

    @Override
    public int getCount() {
        return ducksList.size();
    }

    @Override
    public Object getItem(int position) {
        return ducksList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        ImageView imageView;
        TextView txtName, txtPrice;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View row = view;
        ViewHolder holder = new ViewHolder();

        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);

            holder.txtName = (TextView) row.findViewById(R.id.txtName);
            holder.txtPrice = (TextView) row.findViewById(R.id.txtPrice);
            holder.imageView = (ImageView) row.findViewById(R.id.imgFood);
            row.setTag(holder);

        }
        else {
            holder=(ViewHolder) row.getTag();
        }

        ProuDuck prouDuck = ducksList.get(position);

        holder.txtName.setText(prouDuck.getName());
        holder.txtPrice.setText(prouDuck.getPrice());

        byte[] bagimage = prouDuck.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(bagimage, 0, bagimage.length);
        holder.imageView.setImageBitmap(bitmap);

        return row;
    }
}