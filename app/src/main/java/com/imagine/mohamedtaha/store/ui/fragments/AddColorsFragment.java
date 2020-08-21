package com.imagine.mohamedtaha.store.ui.fragments;

import android.os.Bundle;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.imagine.mohamedtaha.store.adapter.AdapterAddPermission;
import com.imagine.mohamedtaha.store.R;
import com.imagine.mohamedtaha.store.data.TaskDbHelper;
import com.imagine.mohamedtaha.store.model.TableColors;
import com.imagine.mohamedtaha.store.threading.Constants;
import com.imagine.mohamedtaha.store.threading.MyThread;

import java.util.ArrayList;

public class AddColorsFragment extends Fragment implements SearchView.OnQueryTextListener
, Handler.Callback {
    private static final String TAG = "AddColorsFragment";

    public AddColorsFragment() {
        // Required empty public constructor
    }
    public static final String ID_COLOR = "id";
    public static final String NAME_COLOR = "nameColor";
    public static final String NOTE_COLOR = "noteColor";
    public static final String DIALOG_COLOR = "dialogColor";
    private MyThread myThread = null;
    private Handler mainHandler = null;

    FloatingActionButton fab_add_color;
    ListView mListView;
    public static  AdapterAddPermission adapterAddColor;
    TaskDbHelper dbHelper;
    ArrayList<TableColors> itemsColors = new ArrayList<TableColors>();
    private ProgressBar progressBarColors;
    //Identifier for the category dataloader;
    public static final int PERMISSION_LOADER = 2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainHandler = new Handler(this);
    }

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_add_premission, container, false);
        TextView namePremission = (TextView)view.findViewById(R.id.ETTypeStore);

        dbHelper = new TaskDbHelper(getActivity());
        mListView = (ListView) view.findViewById(R.id.listViewAddPermission);
        progressBarColors =(ProgressBar)view.findViewById(R.id.progressBarPermission);

        adapterAddColor = new AdapterAddPermission(getContext(), itemsColors);
        View emptyView = view.findViewById(R.id.empty_view_permission);
        mListView.setEmptyView(emptyView);
        mListView.setAdapter(adapterAddColor);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //   Toast.makeText(getContext(), "Click :"+ position, Toast.LENGTH_SHORT).show();
                TableColors itemSPermision = itemsColors.get(position);
                Bundle bundle = new Bundle();
                bundle.putInt(ID_COLOR, itemSPermision.getId_color());
                bundle.putString(NAME_COLOR, itemSPermision.getName_color());
                bundle.putString(NOTE_COLOR, itemSPermision.getNotes());
                // startActivity(intent);
                //  long id = cursor.getLong(cursor.getColumnIndex(TaskContract.TaskEntry._ID));
                EditColorFragment f = new EditColorFragment();
                f.setArguments(bundle);
                f.show(getFragmentManager(), DIALOG_COLOR);}});
        //    namePremission.setText("Name Permission");
        fab_add_color = (FloatingActionButton)view.findViewById(R.id.fab_add_permission);
        fab_add_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new EditColorFragment().show(getFragmentManager(), DIALOG_COLOR);



            }
        });
        return view;
    }

//    @Override
//    public Loader<ArrayList<ItemsStore>> onCreateLoader(int id, Bundle args) {
//        return new LoaderPErmission(getContext().getApplicationContext(), itemsColors,dbHelper);
//    }
//
//    @Override
//    public void onLoadFinished(Loader<ArrayList<ItemsStore>> loader, ArrayList<ItemsStore> data) {
//        progressBarColors.setVisibility(View.GONE);
//        mListView.setVisibility(View.VISIBLE);
//        adapterAddColor.swapData(data);
//    }
//
//    @Override
//    public void onLoaderReset(Loader<ArrayList<ItemsStore>> loader) {
//        adapterAddColor.swapData(Collections.<ItemsStore>emptyList());
//
//    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getActivity().getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);

        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(this);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
//        itemsColors = dbHelper.getAllItemsPermissionBySearch(newText);
//        if (itemsColors !=null){
//            adapterAddColor.setFilter(itemsColors);
//            //  getSupportLoaderManager().restartLoader(Daily_LOADER,null,this);
//
//        }
        return false;
    }

    @Override
    public void onStart() {
        super.onStart();
        myThread = new MyThread(getContext(),mainHandler);
        myThread.start();
    }

    @Override
    public void onResume() {
        super.onResume();
        sendTestMessage();
    }

    private void sendTestMessage(){
        Log.d(TAG," sendTestMessage : saving word on thread: " + Thread.currentThread().getName());
        Message message = Message.obtain(null, Constants.WORD_RETRIEVE);
        myThread.sendMessageToBackgroundThread(message);
    }
    @Override
    public void onStop() {
        super.onStop();
        myThread.quitThread();
    }

//    private void retrieveColor(TableColors tableColors){
//        Log.d(TAG," Retreive words called. ");
//        Message message = Message.obtain(null, Constants.WORD_RETRIEVE);
//        Bundle bundle = new Bundle();
//        bundle.putParcelableArrayList("colors",tableColors);
//        message.setData(bundle);
//        myThread.sendMessageToBackgroundThread(message);
//    }
    private void deleteColor(TableColors tableColors){
        Log.d(TAG," Delete color : Called.");
        itemsColors.remove(tableColors);
        adapterAddColor.notifyDataSetChanged();

        Message message = Message.obtain(null,Constants.COLOR_DELETE);
        Bundle bundle = new Bundle();
        bundle.putParcelable("delete_color",tableColors);
        message.setData(bundle);
        myThread.sendMessageToBackgroundThread(message);


    }
    @Override
    public boolean handleMessage(@NonNull Message msg) {
        switch (msg.what){
            case Constants.WORD_RETRIEVE_SUCCESS:
                Log.d(TAG," handleMessage : WORD_RETRIEVE_SUCCESS on thread: " + Thread.currentThread().getName());
                ArrayList<TableColors>tableColors = new ArrayList<>(msg.getData().<TableColors>getParcelableArrayList("colors"));
                itemsColors.clear();
                itemsColors.addAll(tableColors);
                adapterAddColor.setFilter(itemsColors);
                progressBarColors.setVisibility(View.GONE);
                break;
            case Constants.WORD_RETRIEVE_FAIL:
                Log.d(TAG," handleMessage : WORD_RETRIEVE_Fail on thread: " + Thread.currentThread().getName());
                break;
            case Constants.WORD_INSERT_SUCCESS:
                Log.d(TAG," handleMessage : WORD_insert success on thread: " + Thread.currentThread().getName());
                break;
            case Constants.WORD_INSERT_FAIL:
                Log.d(TAG," handleMessage : WORD_insert fail on thread: " + Thread.currentThread().getName());
                break;
            case Constants.WORD__DELETE_SUCCESS:
                Log.d(TAG," handleMessage : WORD_DELETE_SUCCESS on thread: " + Thread.currentThread().getName());
                break;
            case Constants.WORD__DELETE_FAIL:
                Log.d(TAG," handleMessage : WORD__DELETE_FAIL on thread: " + Thread.currentThread().getName());
                break;
        }
        return false;    }
}
