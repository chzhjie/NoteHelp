
package com.example.notehelp.database;

import com.example.notehelp.entity.Account;
import com.example.notehelp.entity.BillNote;
import com.example.notehelp.entity.BillNote.BillNoteColumns;
import com.example.notehelp.entity.BillNoteType;
import com.example.notehelp.entity.BillNoteType.NoteTypeColumns;
import com.example.notehelp.entity.MoneyStoreType;
import com.example.notehelp.entity.MoneyStoreType.MoneyStoreTypeColumns;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by zhenjie on 2015/5/9.
 */
public class NoteDBHelper extends SQLiteOpenHelper {
    public static final String LogTag = "NoteHelper";
    public static final int DATABASE_VERSION = 1;
    Context mContext;

    public NoteDBHelper(Context context, String name) {
        super(context, name, null, DATABASE_VERSION);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(LogTag, "NoteDBHelper onCreate Table");
        // 创建账户表
        createAccountTable(db);
        // 创建资金存储类型表
        createMoneyStoreTable(db);
        //创建流水帐目表
        createBillNoteTable(db);
        //创建帐目类型表
        createBillNoteTypeTable(db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    static void createAccountTable(SQLiteDatabase sqLiteDatabase) {
        Log.d(LogTag, "createAccountTable start");
        String accountColumns = " (" + Account.AccountColumns._ID
                + " integer primary key autoincrement, "
                + Account.AccountColumns.ACCOUNT_AVATAR + " text, "
                + Account.AccountColumns.ACCOUNT_BACKGROUND + " text, "
                + Account.AccountColumns.ACCOUNT_CREATE_TIME + " text, "
                + Account.AccountColumns.ACCOUNT_NAME + " text, "
                + Account.AccountColumns.ACCOUNT_NOTE_COUNT + " integer, "
                + Account.AccountColumns.ACCOUNT_PWD + " text " + " )";
        sqLiteDatabase.execSQL("create table " + Account.TABLE_NAME
                + accountColumns);
        Log.d(LogTag, "createAccountTable finished : " + accountColumns);
    }

    static void createMoneyStoreTable(SQLiteDatabase sqLiteDatabase) {
        Log.d(LogTag, "createMoneyStoreTable start");
        String moneyStoreColumnsString = " ("
                + MoneyStoreType.MoneyStoreTypeColumns._ID
                + " integer primary key autoincrement, "
                + MoneyStoreTypeColumns.MONEY_STORE_ID + " text, "
                + MoneyStoreTypeColumns.MONEY_STORE_NAME + " text, "
                + MoneyStoreTypeColumns.MONEY_STORE_COLOR + " text, "
                + MoneyStoreTypeColumns.MONEY_STORE_TYPE + " text, "
                + MoneyStoreTypeColumns.MONEY_STORE_MONEY + " integer, "
                + MoneyStoreTypeColumns.MONEY_STORE_DESC + " text " + " )";
        sqLiteDatabase.execSQL("create table " + MoneyStoreType.TABLE_NAME
                + moneyStoreColumnsString);
        Log.d(LogTag, "createMoneyStoreTable finished : " + moneyStoreColumnsString);
    }

    static void createBillNoteTable(SQLiteDatabase sqLiteDatabase) {
        Log.d(LogTag, "createBillNoteTable start");
        String billNoteColumnsString = " ("
                + BillNoteColumns._ID
                + " integer primary key autoincrement, "
                + BillNoteColumns.BILL_NOTE_MONEY + " integer, "
                + BillNoteColumns.BILL_NOTE_TYPE + " integer, "
                + BillNoteColumns.BILL_NOTE_PHOTO + " text, "
                + BillNoteColumns.BILL_NOTE_STOREID + " text, "
                + BillNoteColumns.BILL_NOTE_MONEY_TYPE + " text, "
                + BillNoteColumns.BILL_NOTE_TIME + " text, " 
                + BillNoteColumns.BILL_NOTE_DESC + " text " + " )";
        sqLiteDatabase.execSQL("create table " + BillNote.TABLE_NAME
                + billNoteColumnsString);
        Log.d(LogTag, "createBillNoteTable finished : " + billNoteColumnsString);
    }
    
    static void createBillNoteTypeTable(SQLiteDatabase sqLiteDatabase) {
        Log.d(LogTag, "createBillNoteTypeTable start");
        String noteTypeColumnsString = " ("
                + NoteTypeColumns._ID
                + " integer primary key autoincrement, "
                + NoteTypeColumns.NOTETYPE_NAME + " text, "
                + NoteTypeColumns.NOTETYPE_COLOR + " text, "
                + NoteTypeColumns.NOTETYPE_INOROUR + " integer " + " )";
        sqLiteDatabase.execSQL("create table " + BillNoteType.TABLE_NAME
                + noteTypeColumnsString);
        Log.d(LogTag, "createBillNoteTypeTable finished : " + noteTypeColumnsString);
    }
}
