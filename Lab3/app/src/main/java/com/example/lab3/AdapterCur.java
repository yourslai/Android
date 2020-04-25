package com.example.lab3;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterCur extends BaseAdapter{

    List<Item> list;
    Context context;

    public AdapterCur(List<Item> list, Context context){
        this.list = list;
        this.context = context;
        //列表同步方法
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder viewHolder;
        if (view == null){
            view = View.inflate(context,R.layout.list_view_item2,null);
            viewHolder = new ViewHolder();
            viewHolder.textView = (TextView) view.findViewById(R.id.textView1);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }

        //得到十六进制的颜色的int值
        int green = Color.parseColor("#00FF00");
        int white = Color.parseColor("#FFFFFF");
        viewHolder.textView.setText(list.get(i).getName());
        if (list.get(i).isBo() == true){
            viewHolder.textView.setBackgroundColor(green);
        }else {
            viewHolder.textView.setBackgroundColor(white);
        }
        return view;
    }

    class ViewHolder{
        TextView textView;
    }
}
