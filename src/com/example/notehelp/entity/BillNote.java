
package com.example.notehelp.entity;

import java.util.Date;

import com.example.notehelp.utils.NoteUtils;

import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;

public class BillNote extends NoteContent {

    public static final String TABLE_NAME = "BillNote ";

    public static Uri CONTENT_URI_BILLNOTE;

    public static final int CONTENT_ID_COLUMN = 0;
    public static final int CONTENT_BILLNOTE_MONEY_COLUMN = 1;
    public static final int CONTENT_BILLNOTE_TYPE_COLUMN = 2;
    public static final int CONTENT_BILLNOTE_PHOTO_COLUMN = 3;
    public static final int CONTENT_BILLNOTE_MONEYSTOREID_COLUMN = 4;
    public static final int CONTENT_BILLNOTE_MONEYTYPE_COLUMN = 5;
    public static final int CONTENT_BILLNOTE_TIME_COLUMN = 6;
    public static final int CONTENT_BILLNOTE_DESC_COLUMN = 7;

    public float billMoney;
    public int billType;
    public String billPhoto;
    public String billMoneyStoreTypeID;
    public String billMoneyType;
    public Date billTime;
    public String billDesc;

    public BillNote() {
        mBaseUri = CONTENT_URI_BILLNOTE;
    }

    public float getBillMoney() {
        return billMoney;
    }

    public void setBillMoney(float billMoney) {
        this.billMoney = billMoney;
    }

    public int getBillType() {
        return billType;
    }

    public void setBillType(int billType) {
        this.billType = billType;
    }

    public String getBillPhoto() {
        return billPhoto;
    }

    public void setBillPhoto(String billPhoto) {
        this.billPhoto = billPhoto;
    }

    public String getBillMoneyStoreTypeID() {
        return billMoneyStoreTypeID;
    }

    public void setBillMoneyStoreTypeID(String billMoneyStoreTypeID) {
        this.billMoneyStoreTypeID = billMoneyStoreTypeID;
    }

    public String getBillMoneyType() {
        return billMoneyType;
    }

    public void setBillMoneyType(String billMoneyType) {
        this.billMoneyType = billMoneyType;
    }

    public Date getBillTime() {
        return billTime;
    }

    public void setBillTime(Date billTime) {
        this.billTime = billTime;
    }

    public String getBillDesc() {
        return billDesc;
    }

    public void setBillDesc(String billDesc) {
        this.billDesc = billDesc;
    }

    @Override
    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(BillNoteColumns.BILL_NOTE_MONEY, billMoney);
        values.put(BillNoteColumns.BILL_NOTE_TYPE, billType);
        values.put(BillNoteColumns.BILL_NOTE_PHOTO, billPhoto);
        values.put(BillNoteColumns.BILL_NOTE_STOREID, billMoneyStoreTypeID);
        values.put(BillNoteColumns.BILL_NOTE_MONEY_TYPE, billMoneyType);
        values.put(BillNoteColumns.BILL_NOTE_TIME, NoteUtils.parseStringFromDate(billTime));
        values.put(BillNoteColumns.BILL_NOTE_DESC, billDesc);
        return values;
    }

    @Override
    public void restore(Cursor cursor) {
        mId = cursor.getLong(CONTENT_ID_COLUMN);
        billMoney = cursor.getFloat(CONTENT_BILLNOTE_MONEY_COLUMN);
        billType = cursor.getInt(CONTENT_BILLNOTE_TYPE_COLUMN);
        billPhoto = cursor.getString(CONTENT_BILLNOTE_PHOTO_COLUMN);
        billMoneyStoreTypeID = cursor.getString(CONTENT_BILLNOTE_MONEYSTOREID_COLUMN);
        billMoneyType = cursor.getString(CONTENT_BILLNOTE_MONEYTYPE_COLUMN);
        billTime = NoteUtils.parseDataFromString(cursor.getString(CONTENT_BILLNOTE_TIME_COLUMN));
        billDesc = cursor.getString(CONTENT_BILLNOTE_DESC_COLUMN);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        if (billMoney != 0) {
            sb.append("billMoney : ").append(billMoney);
        }
        if (billType != 0) {
            sb.append("billType : ").append(billType);
        }
        if (billTime != null) {
            sb.append("billTIme : ").append(NoteUtils.parseStringFromDate(billTime));
        }
        if (!TextUtils.isEmpty(billDesc)) {
            sb.append("billDesc : ").append(billDesc);
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * 对BillNote相关的变量进行初始化
     */
    public static void initBillNotes() {
        CONTENT_URI_BILLNOTE = Uri.parse(CONTENT_URI + "/billnote");
    }

    public interface BillNoteColumns {
        public static final String _ID = "_id";
        public static final String BILL_NOTE_MONEY = "billNoteMoney";
        public static final String BILL_NOTE_TYPE = "billNoteType";
        public static final String BILL_NOTE_PHOTO = "billNotePhoto";
        public static final String BILL_NOTE_STOREID = "billNoteStoreID";
        public static final String BILL_NOTE_MONEY_TYPE = "billNoteMoneyType";
        public static final String BILL_NOTE_TIME = "billNoteTime";
        public static final String BILL_NOTE_DESC = "billNoteDesc";
    }

    public static final String[] CONTENT_PROJECTION = {
            BillNoteColumns._ID, BillNoteColumns.BILL_NOTE_MONEY, BillNoteColumns.BILL_NOTE_TYPE,
            BillNoteColumns.BILL_NOTE_PHOTO, BillNoteColumns.BILL_NOTE_STOREID,
            BillNoteColumns.BILL_NOTE_MONEY_TYPE, BillNoteColumns.BILL_NOTE_TIME,
            BillNoteColumns.BILL_NOTE_DESC
    };

    /**
     * 根据ID获取BIllNote
     * @param context
     * @param id
     * @return
     */
    public static BillNote restoreBillNoteWithID(Context context, long id) {
        return restoreBillNoteWithID(context, id, null);
    }
    /**
     * 根据ID获取BIllNote
     * @param context
     * @param id
     * @return
     */
    public static BillNote restoreBillNoteWithID(Context context, long id, ContentObserver observer) {
        return NoteContent.restoreContentWithID(context, BillNote.class,
                BillNote.CONTENT_URI_BILLNOTE, BillNote.CONTENT_PROJECTION, id);
    }
}
