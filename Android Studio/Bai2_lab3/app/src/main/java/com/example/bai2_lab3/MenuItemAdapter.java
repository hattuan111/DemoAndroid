package com.example.bai2_lab3;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

public class MenuItemAdapter extends BaseAdapter {
    private final Context context;
    private final ArrayList<MenuItem> menuItems;

    public MenuItemAdapter(Context context, ArrayList<MenuItem> menuItems) {
        this.context = context;
        this.menuItems = menuItems;
    }

    @Override
    public int getCount() {
        return menuItems.size();
    }

    @Override
    public Object getItem(int position) {
        return menuItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_menu, parent, false);
        }

        ImageView itemImage = convertView.findViewById(R.id.item_image);
        TextView itemName = convertView.findViewById(R.id.item_name);
        TextView itemPrice = convertView.findViewById(R.id.item_price);

        MenuItem menuItem = menuItems.get(position);
        itemImage.setImageResource(menuItem.getImageResourceId());
        itemName.setText(menuItem.getName());
        itemPrice.setText(menuItem.getPrice());

        return convertView;
    }
}
