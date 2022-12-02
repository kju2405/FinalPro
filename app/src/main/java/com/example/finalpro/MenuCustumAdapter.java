package com.example.finalpro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MenuCustumAdapter extends ArrayAdapter implements AdapterView.OnItemClickListener{
    private Context context;
    private List list;

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show();
    }

    class ViewHolder {
        public ImageView iv_chicken;
        public TextView tv_name;
        public TextView tv_price;

    }

    public MenuCustumAdapter(Context context, ArrayList list){
        super(context, 0, list);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;

        if (convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            convertView = layoutInflater.inflate(R.layout.menu_item, parent, false);
        }

        viewHolder = new ViewHolder();
        viewHolder.iv_chicken = (ImageView) convertView.findViewById(R.id.chickenImg);
        viewHolder.tv_name = (TextView) convertView.findViewById(R.id.chickenName);
        viewHolder.tv_price=(TextView) convertView.findViewById(R.id.chickenPrice);

        final Fragment_menu.ChickenMenu chickenMenu= (Fragment_menu.ChickenMenu) list.get(position);
        viewHolder.iv_chicken.setImageResource(chickenMenu.getChickenMenuImg());
        viewHolder.tv_name.setText(chickenMenu.getMenuName());
        viewHolder.tv_price.setText(chickenMenu.getChickenPrice());

        return convertView;
    }
}
