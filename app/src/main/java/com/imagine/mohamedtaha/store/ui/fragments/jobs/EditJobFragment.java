package com.imagine.mohamedtaha.store.ui.fragments.jobs;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.imagine.mohamedtaha.store.Constants;
import com.imagine.mohamedtaha.store.R;
import com.imagine.mohamedtaha.store.databinding.FragmentEditJobBinding;
import com.imagine.mohamedtaha.store.room.StoreAppDatabase;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EditJobFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditJobFragment extends DialogFragment {
    private FragmentEditJobBinding fragmentEditJobBinding;
    private AlertDialog alertDialog;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
     //   return super.onCreateDialog(savedInstanceState);
        // Inflate the layout for this fragment
//        fragmentEditColorBinding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.fragment_edit_color,null
//                ,false);
//        view = fragmentEditColorBinding.getRoot();

        fragmentEditJobBinding = DataBindingUtil.inflate(LayoutInflater.from(getActivity()),R.layout.fragment_edit_job,null, false);
        View view = fragmentEditJobBinding.getRoot();
        saveData();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view);
        alertDialog = builder.create();
        alertDialog.show();


        return alertDialog;
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        fragmentEditJobBinding = FragmentEditJobBinding.inflate(inflater);
//        View view = fragmentEditJobBinding.getRoot();
//        saveData();
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        builder.setView(view);
//        alertDialog = builder.create();
//        alertDialog.show();
//
//
//        return alertDialog;
//    }
    private void saveData(){
        fragmentEditJobBinding.btAddJobEditJobFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Main" , "saveData" );
                Bundle reslut = new Bundle();

               // Intent replyIntent = new Intent();
                String position_title = fragmentEditJobBinding.etTitlePositionEditJobFragment.getText().toString().trim();
                String notes = fragmentEditJobBinding.etNotesEditJobFragment.getText().toString().trim();

                if (TextUtils.isEmpty(position_title)){
                 //   getActivity().setResult(Activity.RESULT_CANCELED,replyIntent);
                }else {
                    reslut.putString(Constants.EXTRA_REPLY,position_title);
                    reslut.putString(Constants.EXTRA_NOTES, notes);
                    getParentFragmentManager().setFragmentResult("requestKey",reslut);
                    Log.d("Main" , "requestKey" );

                }
//                if (TextUtils.isEmpty(position_title)){
//                    getActivity().setResult(Activity.RESULT_CANCELED,replyIntent);
//                }else {
//                    replyIntent.putExtra(Constants.EXTRA_REPLY,position_title);
//                    replyIntent.putExtra(Constants.EXTRA_NOTES, notes);
//                    getActivity().setResult(Activity.RESULT_OK,replyIntent);
//                }
                alertDialog.dismiss();
             //   getActivity().finish();
            }
        });
    }
}