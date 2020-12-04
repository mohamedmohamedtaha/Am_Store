package com.imagine.mohamedtaha.store.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.imagine.mohamedtaha.store.R;
import com.imagine.mohamedtaha.store.databinding.CustomColorBinding;
import com.imagine.mohamedtaha.store.model.TableColors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by MANASATT on 03/12/17.
 */

public class AdapterAddColors extends RecyclerView.Adapter<AdapterAddColors.AddColorViewHolder> {
    //  private final LayoutInflater inflater;
    private Context context;
    private List<TableColors> TableColors;

    public AdapterAddColors(Context context, List<TableColors> TableColors) {
        //  this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.TableColors = TableColors;
    }


    @Override
    public AdapterAddColors.AddColorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CustomColorBinding customColorBinding;
        customColorBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.custom_color, parent, false);
        return new AddColorViewHolder(customColorBinding);
    }

    @Override
    public void onBindViewHolder(final AddColorViewHolder holder, int position) {
        TableColors data = TableColors.get(position);
        Log.d("MyThread", "onBindViewHolder :" + TableColors.size());
        holder.bind(data);
    }

    @Override
    public int getItemCount() {
        Log.d("MyThread", "Size :" + TableColors.size());
        if (TableColors != null) {
            return TableColors.size();
        } else {
            return 0;
        }

    }

    //Inner class for creating ViewHolders
    class AddColorViewHolder extends RecyclerView.ViewHolder {
        //Class variables for the name StokeWearhehouse
        CustomColorBinding customColorBinding;

        public AddColorViewHolder(final CustomColorBinding customColorBinding) {
            super(customColorBinding.getRoot());
            this.customColorBinding = customColorBinding;
        }

        public void bind(TableColors tableColors) {
            //  customColorBinding.setVariable(BR.color,tableColors);
            customColorBinding.setColor(tableColors);
            //    customColorBinding.setClickRecyclerView((ClickRecyclerView)context.getApplicationContext());
            customColorBinding.executePendingBindings();
        }
    }

    public void swapData(Collection<TableColors> itemsStokeCollections) {
        this.TableColors.clear();
        this.TableColors.addAll(itemsStokeCollections);
        notifyDataSetChanged();
    }

    public void setFilter(ArrayList<TableColors> itemStoke) {
        //  FragmentAddColorsBinding binding = null;
        TableColors = new ArrayList<>();
        TableColors.addAll(itemStoke);
        notifyDataSetChanged();
    }
}


















