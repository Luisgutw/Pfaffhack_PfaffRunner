package com.example.pfaffhack.ui.bestenliste;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pfaffhack.R;

import java.util.List;

public class CustomListAdapter  extends BaseAdapter {

    private List<userInfo> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListAdapter(Context aContext,  List<userInfo> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.listitem_bestenliste, null);
            holder = new ViewHolder();
            holder.userIconView = (ImageView) convertView.findViewById(R.id.imageView_userIcon);
            holder.userName = (TextView) convertView.findViewById(R.id.textView_userName);
            holder.stromAnzahl = (TextView) convertView.findViewById(R.id.textView_stromAnzahl);
            holder.number = (TextView) convertView.findViewById(R.id.textView_number);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        userInfo user = this.listData.get(position);
        holder.userName.setText(user.getUserName());
        holder.stromAnzahl.setText(user.getStromErzeugt() + " kwH");
        holder.number.setText(user.getNumber() + ".");

       // holder.userIconView.setImageResource(R.drawable.ic_launcher_foreground);

        return convertView;
    }

    static class ViewHolder {
        ImageView userIconView;
        TextView userName;
        TextView stromAnzahl;
        TextView number;
    }

}