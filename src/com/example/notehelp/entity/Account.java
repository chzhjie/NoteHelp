package com.example.notehelp.entity;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

import java.util.Date;

import com.example.notehelp.utils.NoteUtils;

/**
 * Created by zhenjie on 2015/5/8.
 */
public class Account extends NoteContent {
	public static final String TABLE_NAME = "Account";
	public static Uri CONTENT_URI_ACCOUNT;

	public static final int CONTENT_ID_COLUMN = 0;
	public static final int CONTENT_ACCOUNT_NAME_COLUMN = 1;
	public static final int CONTENT_ACCOUNT_AVATAR_COLUMN = 2;
	public static final int CONTENT_ACCOUNT_PWD_COLUMN = 3;
	public static final int CONTENT_ACCOUNT_BG_COLUMN = 4;
	public static final int CONTENT_ACCOUNT_CREATE_TIME_COLUMN = 5;
	public static final int CONTENT_ACCOUNT_NOTE_COUNT_COLUMN = 6;

	private String accountName;
	private String accountAvatar;
	private String accountPWD;
	private String accountBackground;
	private Date accountCreateTime;
	private int accountNoteCount;

	public Account() {
		mBaseUri = CONTENT_URI_ACCOUNT;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountAvatar() {
		return accountAvatar;
	}

	public void setAccountAvatar(String accountAvatar) {
		this.accountAvatar = accountAvatar;
	}

	public String getAccountPWD() {
		return accountPWD;
	}

	public void setAccountPWD(String accountPWD) {
		this.accountPWD = accountPWD;
	}

	public String getAccountBackground() {
		return accountBackground;
	}

	public void setAccountBackground(String accountBackground) {
		this.accountBackground = accountBackground;
	}

	public Date getAccountCreateTime() {
		return accountCreateTime;
	}

	public void setAccountCreateTime(Date accountCreateTime) {
		this.accountCreateTime = accountCreateTime;
	}

	public int getAccountNoteCount() {
		return accountNoteCount;
	}

	public void setAccountNoteCount(int accountNoteCount) {
		this.accountNoteCount = accountNoteCount;
	}

	@Override
	public ContentValues toContentValues() {
		ContentValues values = new ContentValues();
		values.put(AccountColumns.ACCOUNT_NAME, accountName);
		values.put(AccountColumns.ACCOUNT_AVATAR, accountAvatar);
		values.put(AccountColumns.ACCOUNT_PWD, accountPWD);
		values.put(AccountColumns.ACCOUNT_BACKGROUND, accountBackground);
		values.put(AccountColumns.ACCOUNT_CREATE_TIME,
				NoteUtils.parseStringFromDate(new Date()));
		values.put(AccountColumns.ACCOUNT_NOTE_COUNT, accountNoteCount);
		return values;
	}

	@Override
	public void restore(Cursor cursor) {
		mId = cursor.getLong(CONTENT_ID_COLUMN);
		accountAvatar = cursor.getString(CONTENT_ACCOUNT_AVATAR_COLUMN);
		accountBackground = cursor.getString(CONTENT_ACCOUNT_BG_COLUMN);
		accountCreateTime = NoteUtils.parseDataFromString(cursor
				.getString(CONTENT_ACCOUNT_CREATE_TIME_COLUMN));
		accountName = cursor.getString(CONTENT_ACCOUNT_NAME_COLUMN);
		accountNoteCount = cursor.getInt(CONTENT_ACCOUNT_NOTE_COUNT_COLUMN);
		accountPWD = cursor.getString(CONTENT_ACCOUNT_PWD_COLUMN);
	}

	public interface AccountColumns {
		public static final String _ID = "_id";
		public static final String Account_ID = "accountID";
		public static final String ACCOUNT_NAME = "accountName";
		public static final String ACCOUNT_AVATAR = "accountAvatar";
		public static final String ACCOUNT_PWD = "accountPassword";
		public static final String ACCOUNT_BACKGROUND = "accountBackground";
		public static final String ACCOUNT_CREATE_TIME = "accountCreateTime";
		public static final String ACCOUNT_NOTE_COUNT = "accountNoteCount";
	}

	public static void initAccount() {
		CONTENT_URI_ACCOUNT = Uri.parse(CONTENT_URI + "/account");
	}

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return null;
    }

}
