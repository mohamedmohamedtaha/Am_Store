package com.imagine.mohamedtaha.store.ui.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.textfield.TextInputLayout;
import com.imagine.mohamedtaha.store.R;
import com.imagine.mohamedtaha.store.data.TaskDbHelper;
import com.imagine.mohamedtaha.store.model.TableColors;
import com.imagine.mohamedtaha.store.threading.Constants;
import com.imagine.mohamedtaha.store.threading.MyThread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static com.imagine.mohamedtaha.store.ui.fragments.AddColorsFragment.ID_COLOR;
import static com.imagine.mohamedtaha.store.ui.fragments.AddColorsFragment.NAME_COLOR;
import static com.imagine.mohamedtaha.store.ui.fragments.AddColorsFragment.NOTE_COLOR;


public class EditColorFragment extends DialogFragment implements DialogInterface.OnClickListener, Handler.Callback {
    private EditText ETNameColor, ETNotesColor;
    private Button BTAddOrUpdateColor, BTDeleteColor;
    private TextView TVTitleColor;
    Bundle intent;
    TaskDbHelper dbHelper;
    AlertDialog dialog;
    AlertDialog alertDialogDelete;
    private MyThread myThread = null;
    private Handler mainHandler = null;
    private static final String TAG = "MyThread";

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_edit_store, null);
        TextInputLayout ETTypeStoreMaterial = (TextInputLayout) view.findViewById(R.id.ETTypeStoreMaterial);
        TVTitleColor = (TextView) view.findViewById(R.id.TVTitleStore);
        ETNameColor = (EditText) view.findViewById(R.id.ETTypeStoreStore);
        ETNotesColor = (EditText) view.findViewById(R.id.EtNotesStore);
        BTAddOrUpdateColor = (Button) view.findViewById(R.id.BTAddStore);
        BTDeleteColor = (Button) view.findViewById(R.id.BTDeleteStore);
        dbHelper = new TaskDbHelper(getContext());
        intent = getArguments();
        TVTitleColor.setText(getString(R.string.add_color_titile));
        ETTypeStoreMaterial.setHint(getString(R.string.type_color));
        mainHandler = new Handler(this);

        boolean saveState = true;
        if (intent != null) {
            saveState = false;
            BTAddOrUpdateColor.setText(getString(R.string.action_edit));
            TVTitleColor.setText(getString(R.string.update_color_titile));
            BTDeleteColor.setVisibility(View.VISIBLE);
            ETNameColor.setText(intent.getString(NAME_COLOR));
            ETNotesColor.setText(intent.getString(NOTE_COLOR));
        }
        BTAddOrUpdateColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveStore();

            }
        });
        BTDeleteColor.setOnClickListener(new View.OnClickListener() {
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
        return dialog;

    }

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

    public void saveStore() {
        String nameColor = ETNameColor.getText().toString().trim();
        String notes = ETNotesColor.getText().toString().trim();
        boolean isExist = dbHelper.isExistNamePErmission(nameColor);

        if (intent == null && TextUtils.isEmpty(nameColor) || TextUtils.isEmpty(nameColor)) {
            ETNameColor.requestFocus();
            ETNameColor.setError(getString(R.string.error_empty_text));
            return;
        }
        if (isExist == true) {
            ETNameColor.requestFocus();
            ETNameColor.setError(getString(R.string.error_exist_color));
            return;
        }
        if (intent == null) {
            TableColors tableColors = new TableColors();
            tableColors.setName_color(nameColor);
            tableColors.setNotes(notes);
            tableColors.setCreatedDate(getDate());
            tableColors.setCreatedTime(getTime());
            Message message = Message.obtain(null, Constants.WORD_INSERT_NEW);
            Bundle bundle = new Bundle();
            bundle.putParcelable("new_color", tableColors);
            message.setData(bundle);
            myThread.sendMessageToBackgroundThread(message);
            dialog.dismiss();

//            ItemsStore itemSavePErmission = new ItemsStore();
//            itemSavePErmission.setNamePermission(nameColor);
//            itemSavePErmission.setNotes(notes);
//            if (itemSavePErmission == null) {
//                Toast.makeText(getContext(), getString(R.string.error_save_permission), Toast.LENGTH_LONG).show();
//            }else {
//                dbHelper.addPermission(itemSavePErmission);
//                Toast.makeText(getContext(), getString(R.string.save_permission), Toast.LENGTH_LONG).show();
//                dialog.dismiss();
//            }
        } else {
            TableColors tableColors = new TableColors();
            tableColors.setId_color(intent.getInt(ID_COLOR));
            tableColors.setName_color(nameColor);
            tableColors.setNotes(notes);
            tableColors.setCreatedDate(getDate());
            tableColors.setCreatedTime(getTime());
            Message message = Message.obtain(null, Constants.WORD_UPDATE);
            Bundle bundle = new Bundle();
            bundle.putParcelable("update_color", tableColors);
            message.setData(bundle);
            myThread.sendMessageToBackgroundThread(message);
            dialog.dismiss();


//            ItemsStore itemUpdatePermision = new ItemsStore();
//            itemUpdatePermision.setId(intent.getInt(ID_COLOR));
//            itemUpdatePermision.setNamePermission(nameColor);
//            itemUpdatePermision.setNotes(notes);
//            boolean isExistForUpdated = dbHelper.isNamePermissioneUsedDailyMovements(intent.getInt(ID_COLOR));
//            if (isExistForUpdated == true){
//                Toast.makeText(getContext(), getString(R.string.this_permission_not_updated), Toast.LENGTH_SHORT).show();
//                return;
//            }
//
//            if (itemUpdatePermision != null){
//                dbHelper.updatePermission(itemUpdatePermision);
//                Toast.makeText(getContext(), getString(R.string.update_permission), Toast.LENGTH_LONG).show();
//                dialog.dismiss();
//
//            }else {
//                Toast.makeText(getContext(), getString(R.string.error_update_permission), Toast.LENGTH_LONG).show();
//            }

        }
    }

    public void deleteStore() {
        if (intent != null) {
            String namePermission = ETNameColor.getText().toString();
            String notes = ETNotesColor.getText().toString();
            TableColors tableColors = new TableColors();
            tableColors.setId_color(intent.getInt(ID_COLOR));
            tableColors.setName_color(namePermission);
            tableColors.setNotes(notes);
            tableColors.setCreatedDate(getDate());
            tableColors.setCreatedTime(getTime());
            boolean isExist = dbHelper.isNamePermissioneUsedDailyMovements(intent.getInt(ID_COLOR));
            if (isExist == true) {
                Toast.makeText(getContext(), getString(R.string.this_permission_used), Toast.LENGTH_SHORT).show();
                return;
            }

            if (tableColors != null) {
                Message message = Message.obtain(null, Constants.COLOR_DELETE);
                Bundle bundle = new Bundle();
                bundle.putParcelable("delete_color", tableColors);
                message.setData(bundle);
                myThread.sendMessageToBackgroundThread(message);
                dialog.dismiss();

//
//                dbHelper.deletePermission(itemDeletePermision);
//                Toast.makeText(getContext(), getString(R.string.delete_permission), Toast.LENGTH_LONG).show();
//                dialog.dismiss();
//                alertDialogDelete.dismiss();

                // getActivity().finish();

            }
//            else {
//                Toast.makeText(getContext(), getString(R.string.error_delete_permission), Toast.LENGTH_LONG).show();
//            }
        } else {
            // Toast.makeText(getActivity(), "Not Data For Deleted", Toast.LENGTH_LONG).show();
            return;
        }

    }

    private void showDeleteConfirmationDialog() {
        //Create an AlertDialog.Builder and set the message,and click listeners
        //for the positive and negative buttons on the dialog.
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(R.string.delete_dialog_msg);
        builder.setPositiveButton(R.string.BTDelete, new DialogInterface.OnClickListener() {
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
                if (dialog != null) {
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

    @Override
    public void onResume() {
        super.onResume();
        sendTestMessage();
    }

    @Override
    public void onStop() {
        super.onStop();
        myThread.quitThread();
    }

    @Override
    public void onStart() {
        super.onStart();
        myThread = new MyThread(getActivity(), mainHandler);
        myThread.start();
    }

    @Override
    public boolean handleMessage(@NonNull Message msg) {
        switch (msg.what) {
            case Constants.WORD_RETRIEVE_SUCCESS:
                Log.d(TAG, " handleMessage : WORD_RETRIEVE_SUCCESS on thread: " + Thread.currentThread().getName());
                break;
            case Constants.WORD_RETRIEVE_FAIL:
                Log.d(TAG, " handleMessage : WORD_RETRIEVE_Fail on thread: " + Thread.currentThread().getName());
                break;
            case Constants.WORD_INSERT_SUCCESS:
                Log.d(TAG, " handleMessage : WORD_insert success on thread: " + Thread.currentThread().getName());
                Toast.makeText(getContext(), getString(R.string.save_color), Toast.LENGTH_LONG).show();

                break;
            case Constants.WORD_INSERT_FAIL:
                Log.d(TAG, " handleMessage : WORD_insert fail on thread: " + Thread.currentThread().getName());
                Toast.makeText(getContext(), getString(R.string.error_save_color), Toast.LENGTH_LONG).show();

                break;
            case Constants.WORD__DELETE_SUCCESS:
                Log.d(TAG, " handleMessage : WORD_DELETE_SUCCESS on thread: " + Thread.currentThread().getName());
                Toast.makeText(getContext(), getString(R.string.delete_color), Toast.LENGTH_LONG).show();

                break;
            case Constants.WORD__DELETE_FAIL:
                Log.d(TAG, " handleMessage : WORD__DELETE_FAIL on thread: " + Thread.currentThread().getName());
                Toast.makeText(getContext(), getString(R.string.error_delete_color), Toast.LENGTH_LONG).show();

                break;
            case Constants.WORD__UPDATE_SUCCESS:
                Log.d(TAG, " handleMessage : WORD_DELETE_SUCCESS on thread: " + Thread.currentThread().getName());
                Toast.makeText(getContext(), getString(R.string.update_color), Toast.LENGTH_LONG).show();

                break;
            case Constants.WORD__UPDATE_FAIL:
                Log.d(TAG, " handleMessage : WORD__DELETE_FAIL on thread: " + Thread.currentThread().getName());
                Toast.makeText(getContext(), getString(R.string.error_update_color), Toast.LENGTH_LONG).show();

                break;
        }
        return false;
    }

    private void sendTestMessage() {
        Log.d(TAG, " sendTestMessage : saving word on thread: " + Thread.currentThread().getName());
        Message message = Message.obtain(null, Constants.WORD_RETRIEVE);
        myThread.sendMessageToBackgroundThread(message);
    }
}