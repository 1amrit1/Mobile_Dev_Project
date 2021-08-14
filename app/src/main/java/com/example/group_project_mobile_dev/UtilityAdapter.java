package com.example.group_project_mobile_dev;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class UtilityAdapter extends BaseAdapter {

    ArrayList<Utility> utList = new ArrayList<>();
    LayoutInflater inflater;//this we need to initialize the objects to link to the list_row

    public UtilityAdapter(Context context, ArrayList<Utility> utList){
        //constructor
        this.utList  = utList;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return utList.size();
    }

    @Override
    public Object getItem(int position) {
        return utList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            // if view doesnt exsist
            convertView = inflater.inflate(R.layout.list_row,null);
            holder = new ViewHolder();
            holder.type= convertView.findViewById(R.id.txvType);
            holder.img = convertView.findViewById(R.id.imgUtility);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        System.out.println(utList.get(position).getType());

        holder.type.setText(utList.get(position).getType());
        holder.img.setImageResource(utList.get(position).getImg());

        return convertView;
    }
    static  class  ViewHolder{
        TextView type;
        ImageView img;
    }
}
