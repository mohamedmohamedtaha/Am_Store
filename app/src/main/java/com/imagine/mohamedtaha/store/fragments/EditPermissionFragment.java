package com.imagine.mohamedtaha.store.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.imagine.mohamedtaha.store.R;
import com.imagine.mohamedtaha.store.data.ItemsStore;
import com.imagine.mohamedtaha.store.data.TaskDbHelper;

import static com.imagine.mohamedtaha.store.fragments.AddPremissionFragment.ID_PERMISSION;
import static com.imagine.mohamedtaha.store.fragments.AddPremissionFragment.NAME_PERMISION;
import static com.imagine.mohamedtaha.store.fragments.AddPremissionFragment.NOTES_PERMISSION;


public class EditPermissionFragment extends DialogFragment implements DialogInterface.OnClickListener {
    private EditText ETNamePermission,ETNotesPermission;
    private Button BTAddOrUpdatePermission, BTDeletePermission;
    private TextView TVTitlePermission;
    Bundle intent;
    TaskDbHelper dbHelper;
    AlertDialog dialog;
    AlertDialog alertDialogDelete;
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_edit_store,null);
        TVTitlePermission = (TextView)view.findViewById(R.id.TVTitleStore);
        ETNamePermission = (EditText)view.findViewById(R.id.ETTypeStoreStore);
        ETNotesPermission = (EditText)view.findViewById(R.id.EtNotesStore);
        BTAddOrUpdatePermission = (Button)view.findViewById(R.id.BTAddStore);
        BTDeletePermission = (Button)view.findViewById(R.id.BTDeleteStore);
        dbHelper = new TaskDbHelper(getContext());
        intent = getArguments();
        TVTitlePermission.setText(getString(R.string.add_permission_titile));
        ETNamePermission.setHint(getString(R.string.type_permission));

        boolean saveState = true;
        if (intent != null ){
            saveState = false;
            BTAddOrUpdatePermission.setText(getString(R.string.BTUpdate));
            TVTitlePermission.setText(getString(R.string.update_permission_titile));

            BTDeletePermission.setVisibility(View.VISIBLE);
            ETNamePermission.setText(intent.getString(NAME_PERMISION));
            ETNotesPermission.setText(intent.getString(NOTES_PERMISSION));
        }
        BTAddOrUpdatePermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveStore();

            }
        });
        BTDeletePermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDeleteConfirmationDialog();

            }
        });
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view);
        dialog = builder.create();
        dialog.show();

        // return new AlertDialog.Builder(getActivity()).setTitle(saveState? "Add Store" : "Edit store").setView(view)
        //      .create();
        return dialog ;

    }


    public void saveStore(){
        String namePermission =ETNamePermission.getText().toString();
        boolean isExist = dbHelper.isExistNamePErmission(namePermission);
        String notes = ETNotesPermission.getText().toString();

        if ( intent == null && TextUtils.isEmpty(namePermission)|| TextUtils.isEmpty(namePermission) ){
            // ETTypeStore.setError("not should leave field name emputy");
            Toast.makeText(getContext(), getString(R.string.error_empty_text), Toast.LENGTH_SHORT).show();
            return;
        }
        if (intent == null) {
            if (isExist ==true){
                Toast.makeText(getContext(), getString(R.string.error_exist_permission), Toast.LENGTH_SHORT).show();
                return;
            }
            ItemsStore itemSavePErmission = new ItemsStore();
            itemSavePErmission.setNamePermission(namePermission);
            itemSavePErmission.setNotes(notes);
            if (itemSavePErmission == null) {
                Toast.makeText(getContext(), getString(R.string.error_save_permission), Toast.LENGTH_LONG).show();
            }else {
                dbHelper.addPermission(itemSavePErmission);
                Toast.makeText(getContext(), getString(R.string.save_permission), Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        }else {

            ItemsStore itemUpdatePErmision = new ItemsStore();
            itemUpdatePErmision.setId(intent.getInt(ID_PERMISSION));
            itemUpdatePErmision.setNamePermission(namePermission);
            itemUpdatePErmision.setNotes(notes);
            if (itemUpdatePErmision != null){
                dbHelper.updatePermission(itemUpdatePErmision);
                Toast.makeText(getContext(), getString(R.string.update_permission), Toast.LENGTH_LONG).show();
                dialog.dismiss();

            }else {
                Toast.makeText(getContext(), getString(R.string.error_update_permission), Toast.LENGTH_LONG).show();
            }
        } }
    public void deleteStore(){
        if (intent != null){
            String namePermission =ETNamePermission.getText().toString();
            String notes = ETNotesPermission.getText().toString();
            ItemsStore itemDeletePermision = new ItemsStore();
            itemDeletePermision.setId(intent.getInt(ID_PERMISSION));
            itemDeletePermision.setNamePermission(namePermission);
            itemDeletePermision.setNotes(notes);
            if (itemDeletePermision != null){
                dbHelper.deletePermission(itemDeletePermision);
                Toast.makeText(getContext(), getString(R.string.delete_permission), Toast.LENGTH_LONG).show();
                dialog.dismiss();
                alertDialogDelete.dismiss();

               // getActivity().finish();

            }else {
                Toast.makeText(getContext(), getString(R.string.error_delete_permission), Toast.LENGTH_LONG).show();
            }
        }else {
            // Toast.makeText(getActivity(), "Not Data For Deleted", Toast.LENGTH_LONG).show();
            return;
        }

    }
    private void showDeleteConfirmationDialog(){
        //Create an AlertDialog.Builder and set the message,and click listeners
        //for the positive and negative buttons on the dialog.
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(R.string.delete_dialog_msg);
        builder.setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //User clicked the "Delete" button,so delete the Category
                deleteStore();

            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //USer clciked the "cancel" button ,so dismiss the dialog and continue editing the category
                if (dialog != null){
                    dialog.dismiss();
                }
            }
        });
        //Create and show the AlertDialog
        alertDialogDelete = builder.create();
        alertDialogDelete.show();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

    }
}
