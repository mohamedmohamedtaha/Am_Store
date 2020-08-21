package com.imagine.mohamedtaha.store.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.imagine.mohamedtaha.store.data.ItemsStore;
import com.imagine.mohamedtaha.store.R;
import com.imagine.mohamedtaha.store.model.TableColors;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

/**
 * Created by MANASATT on 03/12/17.
 */

public class AdapterAddPermission extends BaseAdapter {
    private  ArrayList<TableColors> itemsColors;
    private final LayoutInflater inflater;

    public AdapterAddPermission(Context context,ArrayList<TableColors> itemsColors) {
        this.inflater = LayoutInflater.from(context);
        this.itemsColors = itemsColors;
    }

    @Override
    public int getCount() {
        return itemsColors.size();
    }

    @Override
    public Object getItem(int position) {
        return itemsColors.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    //Return the formatted date String (i.e "Mar 3,1984") from a Date object
    private String formatDate(Date dataObject){

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(dataObject);
    }


     public static String getDateTime(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date=new Date();
        return dateFormat.format(date);
    }

    //return the formatted Time String (i.e "4:30pm") from a Date object.
    private String formatTime(Date dateObject){
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = inflater.inflate(R.layout.custom_store_listview,parent,false);
        }
        //Find individual views that we want to modify in the list item layout
        TextView TVTypeStore = (TextView)listItemView.findViewById(R.id.TVType_store);
        TextView TVTitle = (TextView)listItemView.findViewById(R.id.titleName);
        TextView TVDateStore = (TextView)listItemView.findViewById(R.id.TVDdate_store);
        TextView TVTimeStore = (TextView)listItemView.findViewById(R.id.TVTime_store);
        TextView TVIDStore   = (TextView)listItemView.findViewById(R.id.TVID);


        //Read the Store attributes from the Cursor for the current Store
        String idStore = String.valueOf(itemsColors.get(position).getId_color());
        String typeStore = itemsColors.get(position).getName_color();
        String  dateStore = String.valueOf(itemsColors.get(position).getCreatedDate());
        String  timeStore = itemsColors.get(position).getCreatedTime();


        //Update the TextView with the attributes for the current store
        TVIDStore.setText(idStore);
        TVTypeStore.setText(typeStore);
       // TVDateStore.setText(dateStore);
        TVTitle.setText(R.string.type_color);
        TVDateStore.setText(dateStore);
        TVTimeStore.setText(timeStore);


        return listItemView;    }
    public void swapData(Collection<TableColors> itemsStoreCollections){
        this.itemsColors.clear();
        this.itemsColors.addAll(itemsStoreCollections);
        notifyDataSetChanged();

    }
    public void setFilter(ArrayList<TableColors> itemStoke){
        itemsColors = new ArrayList<>();
        itemsColors.addAll(itemStoke);
        notifyDataSetChanged();
    }
}
