
package com.example.notehelp.manager;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;

import com.example.notehelp.entity.MoneyStoreType;
import com.example.notehelp.entity.MoneyStoreType.MoneyStoreTypeColumns;

public class BillNoteManager {

    private static BillNoteManager mBillNoteManager;
    private static final Object syncLock = new Object();

    private BillNoteManager() {
        // TODO Auto-generated constructor stub
    }

    public static BillNoteManager getInstance() {
        if (mBillNoteManager == null) {
            synchronized (syncLock) {
                if (mBillNoteManager == null) {
                    mBillNoteManager = new BillNoteManager();
                }
            }
        }
        return mBillNoteManager;
    }

    public boolean saveMoneyStoreType(MoneyStoreType moneyStoreType,Context context){
        boolean isSaveSuccess = false;
        ContentValues values = new ContentValues();
        values.put(MoneyStoreTypeColumns.MONEY_STORE_ID, moneyStoreType.storeAccountID);
        values.put(MoneyStoreTypeColumns.MONEY_STORE_NAME, moneyStoreType.storeAccountName);
        values.put(MoneyStoreTypeColumns.MONEY_STORE_COLOR, moneyStoreType.storeAccountColor);
        values.put(MoneyStoreTypeColumns.MONEY_STORE_TYPE, moneyStoreType.storeAccountType);
        values.put(MoneyStoreTypeColumns.MONEY_STORE_MONEY, moneyStoreType.storeAccountMoney);
        values.put(MoneyStoreTypeColumns.MONEY_STORE_DESC, moneyStoreType.storeAccountDesc);
        Uri uri = context.getContentResolver().insert(MoneyStoreType.CONTENT_URI_MONEYSTORE, values);
        isSaveSuccess = true;
        return isSaveSuccess;
    }

}
