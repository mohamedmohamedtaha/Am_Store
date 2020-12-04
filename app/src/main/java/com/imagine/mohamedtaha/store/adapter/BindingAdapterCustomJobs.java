package com.imagine.mohamedtaha.store.adapter;

import android.util.Log;

import androidx.databinding.BindingAdapter;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.imagine.mohamedtaha.store.model.TableJobs;

import java.util.List;

public class BindingAdapterCustomJobs {
    @BindingAdapter("jobsList")
    public static void setJobsList(RecyclerView recyclerView, PagedList<TableJobs> tableJobs){
        if (tableJobs == null){
            Log.i("Main", "tableJobs is null " );
            return;
        }
        RecyclerView.LayoutManager layoutManager= recyclerView.getLayoutManager();
        if (layoutManager == null){
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        }
        AdapterAddJobs adapterAddJobs = (AdapterAddJobs)recyclerView.getAdapter();
        if (adapterAddJobs == null){
            adapterAddJobs = new AdapterAddJobs(recyclerView.getContext(),tableJobs);
            recyclerView.setAdapter(adapterAddJobs);
        }
    }
}
