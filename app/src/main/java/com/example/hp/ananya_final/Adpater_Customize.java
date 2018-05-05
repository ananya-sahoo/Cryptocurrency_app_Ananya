package com.example.hp.ananya_final;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adpater_Customize extends BaseAdapter
{
    Context context;
    ArrayList<Get_Data.ListView_Ex> listitems;
    LayoutInflater layoutInflater;
    public Adpater_Customize(Context context, ArrayList<Get_Data.ListView_Ex> list)
    {
        this.context=context;
        listitems=list;

        layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return listitems.size();
    }

    @Override
    public Object getItem(int i) {
        return listitems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        Get_Data.ListView_Ex list=listitems.get(i);
        if(view==null)
        {
            view=LayoutInflater.from(context).inflate(R.layout.res_layout,viewGroup,false);

        }

        TextView name=view.findViewById(R.id.textView2);
        TextView usd=view.findViewById(R.id.textView3);
        TextView change=view.findViewById(R.id.textView4);

        name.setText(list.name);
        usd.setText(list.usd);
        change.setText(list.change_last_hour);


        return view;
    }
}
