package com.imagine.mohamedtaha.store.room;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.imagine.mohamedtaha.store.model.TableAds;
import com.imagine.mohamedtaha.store.model.TableColors;
import com.imagine.mohamedtaha.store.model.TableCoupons;
import com.imagine.mohamedtaha.store.model.TableCustomers;
import com.imagine.mohamedtaha.store.model.TableEmployees;
import com.imagine.mohamedtaha.store.model.TableFeedbacks;
import com.imagine.mohamedtaha.store.model.TableJobs;
import com.imagine.mohamedtaha.store.model.TableOrders;
import com.imagine.mohamedtaha.store.model.TablePayments;
import com.imagine.mohamedtaha.store.model.TablePermission;
import com.imagine.mohamedtaha.store.model.TablePlatformAds;
import com.imagine.mohamedtaha.store.model.TableProducts;
import com.imagine.mohamedtaha.store.model.TableStatusOrders;
import com.imagine.mohamedtaha.store.model.TableSupplier;
import com.imagine.mohamedtaha.store.model.TableSupplierMovement;
import com.imagine.mohamedtaha.store.model.TableTargetAds;
import com.imagine.mohamedtaha.store.model.TableCategories;

@Database(entities = {TableAds.class, TableColors.class, TableCoupons.class, TableCustomers.class
, TableEmployees.class, TableFeedbacks.class, TableJobs.class, TableOrders.class, TablePayments.class
, TablePermission.class, TablePlatformAds.class, TableProducts.class, TableStatusOrders.class,
        TableSupplier.class, TableSupplierMovement.class, TableTargetAds.class, TableCategories.class}, version = 2, exportSchema = true)
public abstract class StoreAppDatabase extends RoomDatabase {
    private static final String TAG = "StoreAppDatabase";
    private static final String DATABASE_NAME = "store";
    private static StoreAppDatabase mInstance;
    public abstract StoreDao storeDao();
    public static StoreAppDatabase getInstance(Context context){
        if (mInstance == null){
            synchronized (StoreAppDatabase.class){
                if (mInstance == null){
                    Log.d(TAG,"getInstance: creating a new database instance");
                    mInstance = Room.databaseBuilder(context.getApplicationContext(),
                            StoreAppDatabase.class,StoreAppDatabase.DATABASE_NAME)
                            .addMigrations(MIGRATION_1_2).build();

                }
            }
            Log.d(TAG,"getInstance :  Getting the database instance, no need to recreated it.");
        }
        return mInstance;
    }
    //For migration after edit or add on the table
    static final Migration MIGRATION_1_2 = new Migration(1,2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE TableAds  ADD COLUMN createdDate TEXT ");
            database.execSQL("ALTER TABLE TableAds  ADD COLUMN createdTime TEXT ");

            database.execSQL("ALTER TABLE TableCategories  ADD COLUMN createdDate TEXT ");
            database.execSQL("ALTER TABLE TableCategories  ADD COLUMN createdTime TEXT ");

            database.execSQL("ALTER TABLE TableColors  ADD COLUMN createdDate TEXT ");
            database.execSQL("ALTER TABLE TableColors  ADD COLUMN createdTime TEXT ");

            database.execSQL("ALTER TABLE TableCoupons  ADD COLUMN createdDate TEXT ");
            database.execSQL("ALTER TABLE TableCoupons  ADD COLUMN createdTime TEXT ");

            database.execSQL("ALTER TABLE TableCustomers  ADD COLUMN createdDate TEXT ");
            database.execSQL("ALTER TABLE TableCustomers  ADD COLUMN createdTime TEXT ");

            database.execSQL("ALTER TABLE TableEmployees  ADD COLUMN createdDate TEXT ");
            database.execSQL("ALTER TABLE TableEmployees  ADD COLUMN createdTime TEXT ");

            database.execSQL("ALTER TABLE TableFeedbacks  ADD COLUMN createdDate TEXT ");
            database.execSQL("ALTER TABLE TableFeedbacks  ADD COLUMN createdTime TEXT ");

            database.execSQL("ALTER TABLE TableJobs  ADD COLUMN createdDate TEXT ");
            database.execSQL("ALTER TABLE TableJobs  ADD COLUMN createdTime TEXT ");

            database.execSQL("ALTER TABLE TableOrders  ADD COLUMN createdDate TEXT ");
            database.execSQL("ALTER TABLE TableOrders  ADD COLUMN createdTime TEXT ");

            database.execSQL("ALTER TABLE TablePayments  ADD COLUMN createdDate TEXT ");
            database.execSQL("ALTER TABLE TablePayments  ADD COLUMN createdTime TEXT ");

            database.execSQL("ALTER TABLE TablePermission  ADD COLUMN createdDate TEXT ");
            database.execSQL("ALTER TABLE TablePermission  ADD COLUMN createdTime TEXT ");

            database.execSQL("ALTER TABLE TablePlatformAds  ADD COLUMN createdDate TEXT ");
            database.execSQL("ALTER TABLE TablePlatformAds  ADD COLUMN createdTime TEXT ");

            database.execSQL("ALTER TABLE TableProducts  ADD COLUMN createdDate TEXT ");
            database.execSQL("ALTER TABLE TableProducts  ADD COLUMN createdTime TEXT ");

            database.execSQL("ALTER TABLE TableStatusOrders  ADD COLUMN createdDate TEXT ");
            database.execSQL("ALTER TABLE TableStatusOrders  ADD COLUMN createdTime TEXT ");

            database.execSQL("ALTER TABLE TableSupplier  ADD COLUMN createdDate TEXT ");
            database.execSQL("ALTER TABLE TableSupplier  ADD COLUMN createdTime TEXT ");

            database.execSQL("ALTER TABLE TableSupplierMovement  ADD COLUMN createdDate TEXT ");
            database.execSQL("ALTER TABLE TableSupplierMovement  ADD COLUMN createdTime TEXT ");

            database.execSQL("ALTER TABLE TableTargetAds  ADD COLUMN createdDate TEXT ");
            database.execSQL("ALTER TABLE TableTargetAds  ADD COLUMN createdTime TEXT ");
        }
    };
}
