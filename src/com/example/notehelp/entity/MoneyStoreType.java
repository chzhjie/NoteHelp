
package com.example.notehelp.entity;

import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;

public class MoneyStoreType extends NoteContent {
    public static final String TABLE_NAME = "MoneyStoreType ";

    public static Uri CONTENT_URI_MONEYSTORE;

    public static final int CONTENT_ID_COLUMN = 0;
    public static final int CONTENT_STORE_ACCOUNT_ID_COLUMN = 1;
    public static final int CONTENT_STORE_ACCOUNT_NAME_COLUMN = 2;
    public static final int CONTENT_STORE_ACCOUNT_COLOR_COLUMN = 3;
    public static final int CONTENT_STORE_ACCOUNT_TYPE_COLUMN = 4;
    public static final int CONTENT_STORE_ACCOUNT_MONEY_COLUMN = 5;
    public static final int CONTENT_STORE_ACCOUNT_DESC_COLUMN = 6;

    public String storeAccountID;
    public String storeAccountName;
    public String storeAccountColor;
    public String storeAccountType;
    public float storeAccountMoney;
    public String storeAccountDesc;

    public MoneyStoreType() {
        mBaseUri = CONTENT_URI_MONEYSTORE;
    }

    public String getStoreAccountName() {
        return storeAccountName;
    }

    public void setStoreAccountName(String storeAccountName) {
        this.storeAccountName = storeAccountName;
    }

    public String getStoreAccountColor() {
        return storeAccountColor;
    }

    public void setStoreAccountColor(String storeAccountColor) {
        this.storeAccountColor = storeAccountColor;
    }

    public String getStoreAccountType() {
        return storeAccountType;
    }

    public void setStoreAccountType(String storeAccountType) {
        this.storeAccountType = storeAccountType;
    }

    public float getStoreAccountMoney() {
        return storeAccountMoney;
    }

    public void setStoreAccountMoney(float storeAccountMoney) {
        this.storeAccountMoney = storeAccountMoney;
    }

    public String getStoreAccountDesc() {
        return storeAccountDesc;
    }

    public void setStoreAccountDesc(String storeAccountDesc) {
        this.storeAccountDesc = storeAccountDesc;
    }

    @Override
    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(MoneyStoreTypeColumns.MONEY_STORE_ID, storeAccountID);
        values.put(MoneyStoreTypeColumns.MONEY_STORE_NAME, storeAccountName);
        values.put(MoneyStoreTypeColumns.MONEY_STORE_COLOR, storeAccountColor);
        values.put(MoneyStoreTypeColumns.MONEY_STORE_TYPE, storeAccountType);
        values.put(MoneyStoreTypeColumns.MONEY_STORE_MONEY, storeAccountMoney);
        values.put(MoneyStoreTypeColumns.MONEY_STORE_DESC, storeAccountDesc);
        return values;
    }

    /**
     * 从cursor中获取MoneyStoreType
     */
    @Override
    public void restore(Cursor cursor) {
        mId = cursor.getLong(CONTENT_ID_COLUMN);
        storeAccountID = cursor.getString(CONTENT_STORE_ACCOUNT_ID_COLUMN);
        storeAccountName = cursor.getString(CONTENT_STORE_ACCOUNT_NAME_COLUMN);
        storeAccountColor = cursor
                .getString(CONTENT_STORE_ACCOUNT_COLOR_COLUMN);
        storeAccountType = cursor.getString(CONTENT_STORE_ACCOUNT_TYPE_COLUMN);
        storeAccountMoney = cursor.getFloat(CONTENT_STORE_ACCOUNT_MONEY_COLUMN);
        storeAccountDesc = cursor.getString(CONTENT_STORE_ACCOUNT_DESC_COLUMN);
    }

    public static void initMoneyStoreType() {
        CONTENT_URI_MONEYSTORE = Uri.parse(CONTENT_URI + "/moneystoretype");
    }

    public interface MoneyStoreTypeColumns {
        public static final String _ID = "_id";
        public static final String MONEY_STORE_ID = "moneyStoreID";
        public static final String MONEY_STORE_NAME = "moneyStoreName";
        public static final String MONEY_STORE_COLOR = "moneyStoreColor";
        public static final String MONEY_STORE_TYPE = "moneyStoreType";
        public static final String MONEY_STORE_MONEY = "moneyStoreMoney";
        public static final String MONEY_STORE_DESC = "moneyStoreDesc";
    }

    public static final String[] CONTENT_PROJECTION = {
            MoneyStoreTypeColumns._ID, MoneyStoreTypeColumns.MONEY_STORE_ID,
            MoneyStoreTypeColumns.MONEY_STORE_NAME, MoneyStoreTypeColumns.MONEY_STORE_COLOR,
            MoneyStoreTypeColumns.MONEY_STORE_TYPE, MoneyStoreTypeColumns.MONEY_STORE_MONEY,
            MoneyStoreTypeColumns.MONEY_STORE_DESC
    };

    /**
     * 根据ID获取MoneyStoreType
     * @param context
     * @param id
     * @return
     */
    public static MoneyStoreType restoreMoneyStoreTypeWithID(Context context, long id) {
        return restoreMoneyStoreTypeWithID(context, id, null);
    }

    /**
     * 根据ID获取MoneyStoreType
     * @param context
     * @param id
     * @return
     */
    public static MoneyStoreType restoreMoneyStoreTypeWithID(Context context,long id,ContentObserver observer){
        return NoteContent.restoreContentWithID(context, MoneyStoreType.class, MoneyStoreType.CONTENT_URI_MONEYSTORE, MoneyStoreType.CONTENT_PROJECTION, id);
    }

    @Override
    public String toString() {
        StringBuilder sBuilder = new StringBuilder("[");
        if(!TextUtils.isEmpty(storeAccountID)){
            sBuilder.append("storeAccountID : ").append(storeAccountID);
        }
        if(!TextUtils.isEmpty(storeAccountName)){
            sBuilder.append("storeAccountName : ").append(storeAccountName);
        }
        sBuilder.append("]");
        return null;
    }
}
