package com.example.notehelp.entity;

import com.example.notehelp.utils.LogUtils;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;


/**
 * Created by zhenjie on 2015/5/9.
 */
public abstract class NoteContent {
    public static final String Tag = "NoteContent";
    public static final int NOT_SAVED = -1;
    public long mId = NOT_SAVED;
    public static String AUTHORITY = "com.zhenjie.note";
    public static Uri CONTENT_URI;
    public Uri mBaseUri;

    /**
     * 当项目启动的第一时间，要调用此方法将相关的URI初始化
     */
    public static void init() {
        CONTENT_URI = Uri.parse("content://" + AUTHORITY);
        Account.initAccount();
        MoneyStoreType.initMoneyStoreType();
        BillNote.initBillNotes();
        BillNoteType.initBillNotes();

    }

    /**
     * 根据Cursor得到一个相关类的实例
     *
     * @param c     cursor值
     * @param klass 要得到的实体类
     * @param <T>
     * @return 要得到的实体类
     */
    public static <T extends NoteContent> T getContent(Cursor c, Class<T> klass) {
        try {
            T content = klass.newInstance();
            content.mId = c.getLong(0);
            content.restore(c);
            return content;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 得到每个实体类的ContentValues
     *
     * @return
     */
    public abstract ContentValues toContentValues();

    /**
     * 根据ID查找一个实体类，该类为基类的抽象方法
     *
     * @param context            上下文
     * @param klass              要查找的类
     * @param contentUri         要查找的Uri
     * @param contentProjections 要得到的列
     * @param id                 要查找的id
     * @param <T>
     * @return 要得到的实体类
     */
    public static <T extends NoteContent> T restoreContentWithID(Context context, Class<T> klass, Uri contentUri, String[] contentProjections, long id) {
        Uri u = ContentUris.withAppendedId(contentUri, id);
        Cursor c = context.getContentResolver().query(u, contentProjections, null, null, null);
        if (c == null) {
            LogUtils.info(Tag, "can not restore the Content with id: %1d and Uri : %2s", id, u);
            return null;
        }
        try {
            if (c.moveToFirst()) {
                return getContent(c, klass);
            } else {
                return null;
            }
        } finally {
            c.close();
        }


    }

    /**
     * 从Cursor中读取一个类的相关的属性
     *
     * @param cursor
     */
    public abstract void restore(Cursor cursor);

    /**
     * 判断该实体类是否已经保存
     *
     * @return
     */
    public boolean isSaved() {
        return mId != NOT_SAVED;
    }

    /**
     * 根据Uri将相关的实体类存入到数据库
     *
     * @param context
     * @return 返回存储成功的uri路径
     */
    public Uri save(Context context) {
        if (isSaved()) {
            throw new UnsupportedOperationException();
        }
        Uri res = context.getContentResolver().insert(mBaseUri, toContentValues());
        mId = Long.parseLong(res.getPathSegments().get(1));
        return res;
    }

    public long getmId() {
        return mId;
    }

    public void setmId(long mId) {
        this.mId = mId;
    }

    public abstract String toString();

}
