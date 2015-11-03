package com.example.notehelp.database;

import com.example.notehelp.entity.Account;


/**
 * Created by zhenjie on 2015/5/12.
 */
public class UIProvider {
    public static String[] ACCOUNT_PROJECTION = {
            Account.AccountColumns._ID,
            Account.AccountColumns.ACCOUNT_AVATAR,
            Account.AccountColumns.ACCOUNT_BACKGROUND,
            Account.AccountColumns.ACCOUNT_CREATE_TIME,
            Account.AccountColumns.Account_ID,
            Account.AccountColumns.ACCOUNT_NAME,
            Account.AccountColumns.ACCOUNT_NOTE_COUNT,
            Account.AccountColumns.ACCOUNT_PWD
    };
}
