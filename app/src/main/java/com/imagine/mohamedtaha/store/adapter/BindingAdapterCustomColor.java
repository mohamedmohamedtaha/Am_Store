package com.imagine.mohamedtaha.store.adapter;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.imagine.mohamedtaha.store.model.TableColors;

import java.util.List;

public class BindingAdapterCustomColor {
    private static final int NUM_COLUMNS = 2;

    @BindingAdapter("colorsList")
    public static void setColorsList(RecyclerView recyclerView, List<TableColors> tableColors) {
        if (tableColors == null) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager == null) {
        //    recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), NUM_COLUMNS));
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));

        }
        AdapterAddColors adapterAddColors = (AdapterAddColors) recyclerView.getAdapter();
        if (adapterAddColors == null) {
            adapterAddColors = new AdapterAddColors(recyclerView.getContext(), tableColors);
            recyclerView.setAdapter(adapterAddColors);
        }
    }
}
