package com.imagine.mohamedtaha.store.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.paging.PagedList;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.imagine.mohamedtaha.store.R;
import com.imagine.mohamedtaha.store.databinding.CustomAddJobsBinding;
import com.imagine.mohamedtaha.store.model.TableJobs;

import java.util.List;

public class AdapterAddJobs extends PagedListAdapter<TableJobs, AdapterAddJobs.JobsViewHolder> {
    private CustomAddJobsBinding addJobsBinding;
    private final LayoutInflater layoutInflater;
    private PagedList<TableJobs> tableJobsList;

    public AdapterAddJobs(Context context,PagedList<TableJobs> tableJobsList) {
        super(TableJobs.tableJobsItemCallback);
        this.tableJobsList = tableJobsList;
        Log.d("Main" , "AdapterAddJobs ");

        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public JobsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        addJobsBinding = DataBindingUtil.inflate(layoutInflater, R.layout.custom_add_jobs, parent, false);

        return new JobsViewHolder(addJobsBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull JobsViewHolder holder, int position) {
        if (tableJobsList != null) {
            TableJobs tableJobs = tableJobsList.get(position);
            holder.bind(tableJobs);
            addJobsBinding.setClickRecyclerView(tableJobs1 ->{
                Log.i("Main" , "Clcik RecyclerView");
                        Toast.makeText(layoutInflater.getContext(), " id : " + tableJobs1.getId_jobs() , Toast.LENGTH_SHORT).show();

                    }

            );

        }

    }

    @Override
    public int getItemCount() {
        if (tableJobsList != null) {
            return tableJobsList.size();
        } else return 0;
    }

     class JobsViewHolder extends RecyclerView.ViewHolder {
        public JobsViewHolder(@NonNull CustomAddJobsBinding customAddJobsBinding) {

            super(customAddJobsBinding.getRoot());

        }

        public void bind(TableJobs tableJobs) {
            addJobsBinding.setJobs(tableJobs);
            addJobsBinding.executePendingBindings();
        }

    }
}
