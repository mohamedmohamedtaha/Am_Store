package com.imagine.mohamedtaha.store.threading;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;

import com.imagine.mohamedtaha.store.model.TableColors;
import com.imagine.mohamedtaha.store.room.StoreAppDatabase;

import java.util.ArrayList;
import java.util.List;

public class MyThread extends Thread {
    private static final String TAG = "MyThread";
    private MyThreadHandler myHandler = null;
    private Handler mainHandler = null;
    private boolean isRunning = false;
    private StoreAppDatabase storeAppDatabase;

    public MyThread(Context context, Handler mainHandler) {
        this.mainHandler = mainHandler;
        isRunning = true;
        storeAppDatabase = StoreAppDatabase.getInstance(context);
    }

    @Override
    public void run() {
        Log.e(TAG, "run " );

        if (isRunning) {
            Looper.prepare();
            myHandler = new MyThreadHandler(Looper.myLooper());
            Looper.loop();
        }
    }

    public void quitThread() {
        isRunning = false;
        mainHandler = null;
    }

    public void sendMessageToBackgroundThread(Message message) {
        Log.e(TAG, "SsendMessageToBackgroundThread " );
        while (true) {
            try {
                if (message != null){
                    myHandler.sendMessage(message);
                }
                break;
            } catch (NullPointerException e) {
                Log.e(TAG, "Send message to background thread: Null Pointer: " + e.getMessage());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                    Log.e(TAG, "e1: " + e1.getMessage());

                }
            }
        }
    }

    private long[] saveColor(TableColors tableColors) {
        long[] returnValue = storeAppDatabase.storeDao().insertColor(tableColors);
        if (returnValue.length > 0) {
            Log.d(TAG, "Saved new color: return value " + returnValue.toString());
        }
        return returnValue;
    }
    private List<TableColors>retriveColor(){
        return storeAppDatabase.storeDao().getAllColors();
    }
    private int uppdateColor(TableColors tableColors){
        return storeAppDatabase.storeDao().updateColor(tableColors.getName_color(),tableColors.getNotes(),tableColors.getCreatedDate(),
                tableColors.getCreatedTime(),tableColors.getId_color());
    }
    private int deleteColor(TableColors tableColors){
        return storeAppDatabase.storeDao().deleteColorById(tableColors.getId_color());
    }

    private class MyThreadHandler extends Handler {
        public MyThreadHandler(@NonNull Looper looper) {
            super(looper);
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            //  super.handleMessage(msg);
            switch (msg.what) {
                case Constants.WORD_INSERT_NEW:{
                    Log.d(TAG, " handleMessage : saving word on thread: " + Thread.currentThread().getName());
                    TableColors tableColors = msg.getData().getParcelable("new_color");
                    Message message = null;
                    if (saveColor(tableColors).length > 0){
                        message = Message.obtain(null,Constants.WORD_INSERT_SUCCESS);
                    }else {
                        message = Message.obtain(null,Constants.WORD_INSERT_FAIL);
                    }
                    mainHandler.sendMessage(message);
//                    Message message = Message.obtain(mainHandler,Constants.WORD_INSERT_SUCCESS);
//                    message.sendToTarget();
                    break;}
                case Constants.WORD_UPDATE:{
                    Log.d(TAG, " handleMessage : updating word on thread: " + Thread.currentThread().getName());
                    TableColors tableColors1 = msg.getData().getParcelable("update_color");
                    Message message = null;
                    int updateInt = uppdateColor(tableColors1);
                    if (updateInt > 0){
                        message = Message.obtain(null,Constants.WORD__UPDATE_SUCCESS);
                    }else {
                        message = Message.obtain(null,Constants.WORD__UPDATE_FAIL);
                    }
                    mainHandler.sendMessage(message);
                    break;}
                case Constants.WORD_RETRIEVE:{
                    Log.d(TAG, " handleMessage : retreiving word on thread: " + Thread.currentThread().getName());
                   // String query = msg.getData().getString("query");
                    Message message = null;
                    ArrayList<TableColors> retrive = new ArrayList<>(retriveColor());
                    if (retrive.size() > 0){
                        Log.d(TAG, " retrive.size : " + retrive.size() + " : "+ Thread.currentThread().getName());
                        message = Message.obtain(mainHandler, Constants.WORD_RETRIEVE_SUCCESS);
                        Bundle bundle =  new Bundle();
                        bundle.putParcelableArrayList("colors",retrive);
                        message.setData(bundle);

                    }else {
                        message = Message.obtain(mainHandler, Constants.WORD_RETRIEVE_FAIL);
                        Log.d(TAG, " retrive.size : " + retrive.size() + " : " + Thread.currentThread().getName());

                    }
                    message.sendToTarget();
                    break;}
                case Constants.COLOR_DELETE: {
                    Log.d(TAG, " handleMessage : deleting word on thread: " + Thread.currentThread().getName());
                    TableColors tableColors = msg.getData().getParcelable("delete_color");
                    Message message = null;
                    if (deleteColor(tableColors) > 0){
                        message = Message.obtain(null,Constants.WORD__DELETE_SUCCESS);
                    }else {
                        message = Message.obtain(null,Constants.WORD__DELETE_FAIL);
                    }
                    mainHandler.sendMessage(message);
                    break;
                }
            }
        }
    }
}
