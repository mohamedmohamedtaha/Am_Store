package com.imagine.mohamedtaha.store.ui.fragments.jobs;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.imagine.mohamedtaha.store.Constants;
import com.imagine.mohamedtaha.store.adapter.AdapterAddJobs;
import com.imagine.mohamedtaha.store.databinding.FragmentJobsBinding;
import com.imagine.mohamedtaha.store.model.TableJobs;
import com.imagine.mohamedtaha.store.room.addstore.AddStoreViewModel;
import com.imagine.mohamedtaha.store.threading.ClickRecyclerViewTableJobs;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link JobsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
//implements ClickRecyclerViewTableJobs
public class JobsFragment extends Fragment  {
    public static final String DIALOG_JOB = "dialog_job";
    private AddStoreViewModel addStoreViewModel;
    private PagedList<TableJobs> tableJobsList;

    FragmentJobsBinding fragmentJobsBinding;

    public JobsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getParentFragmentManager().setFragmentResultListener("requestKey", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
              //  String reslut = result.getString("bundleKey");
                Log.d("Main" , "onFragmentResult()");
                Log.d("Main" , "EXTRA_REPLY is before = " + result.getString(Constants.EXTRA_REPLY));

                if (requestKey.equals("requestKey")) {
                TableJobs tableJobs = new TableJobs(result.getString(Constants.EXTRA_REPLY), result.getString(Constants.EXTRA_NOTES), getDate(), getTime());
                addStoreViewModel.insertJob(tableJobs);
                    Log.d("Main" , "EXTRA_REPLY is after = " + result.getString(Constants.EXTRA_REPLY));


                } else {
                    Toast.makeText(getActivity(), "There is an error!", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("Main" , "onCreateView()");
        fragmentJobsBinding = FragmentJobsBinding.inflate(inflater);
        View view = fragmentJobsBinding.getRoot();
        AddStoreViewModel.Factory factory = new AddStoreViewModel.Factory(getActivity().getApplication());
        addStoreViewModel = new ViewModelProvider(getActivity(), factory).get(AddStoreViewModel.class);
        addStoreViewModel.getAllJobs().observe(getActivity(), new Observer<PagedList<TableJobs>>() {
            @Override
            public void onChanged(PagedList<TableJobs> tableJobs) {
                if (tableJobs != null){
                    fragmentJobsBinding.setJobs(tableJobs);
                    fragmentJobsBinding.emptyViewFragmentAddJob.setVisibility(View.GONE);
                }else {
                    fragmentJobsBinding.emptyViewFragmentAddJob.setVisibility(View.VISIBLE);
                }
                Log.d("OnCreate" , "On Create()");
            }
        });
        fragmentJobsBinding.addJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start
                new EditJobFragment().show(getFragmentManager(), DIALOG_JOB);
            }
        });
        return view;
    }
//
//    @Override
//    public void inflateViewJobsFragment(TableJobs tableJobs) {
//        Toast.makeText(getActivity(), " id : " + tableJobs.getId_jobs() , Toast.LENGTH_SHORT).show();
//
//    }
    //get date
    public static String getDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }

    //get time
    public static String getTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("h:mm a", Locale.getDefault());
        Date time = new Date();
        return dateFormat.format(time);
    }
}