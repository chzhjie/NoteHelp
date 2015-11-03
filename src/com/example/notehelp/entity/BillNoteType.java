
package com.example.notehelp.entity;

import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;

/**
 * 该类用于表示消费或者收入的类别
 * 
 * @author changzhenjie
 */
public class BillNoteType extends NoteContent {
    public static final String TABLE_NAME = "BillNoteType ";

    public static Uri CONTENT_URI_BILLNOTETYPE;
    public static Uri CONTENT_URI_GETBYTYPE;

    public String noteTypeName;
    public String noteTypeColor;
    public int inOrOut;

    public static final int CONTENT_ID_COLUMN = 0;
    public static final int CONTENT_NOTETYPE_NAME_COLUMN = 1;
    public static final int CONTENT_NOTETYPE_COLOR_COLUMN = 2;
    public static final int CONTENT_NOTETYPE_INOROUT_COLUMN = 3;

    public String getNoteTypeName() {
        return noteTypeName;
    }

    public void setNoteTypeName(String noteTypeName) {
        this.noteTypeName = noteTypeName;
    }

    public String getNoteTypeColor() {
        return noteTypeColor;
    }

    public void setNoteTypeColor(String noteTypeColor) {
        this.noteTypeColor = noteTypeColor;
    }

    public int getInOrOut() {
        return inOrOut;
    }

    public void setInOrOut(int inOrOut) {
        this.inOrOut = inOrOut;
    }

    public BillNoteType() {
        mBaseUri = CONTENT_URI_BILLNOTETYPE;
    }

    @Override
    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(NoteTypeColumns.NOTETYPE_NAME, noteTypeName);
        values.put(NoteTypeColumns.NOTETYPE_COLOR, noteTypeColor);
        values.put(NoteTypeColumns.NOTETYPE_INOROUR, inOrOut);
        return values;
    }

    @Override
    public void restore(Cursor cursor) {
        mId = cursor.getLong(CONTENT_ID_COLUMN);
        noteTypeName = cursor.getString(CONTENT_NOTETYPE_NAME_COLUMN);
        noteTypeColor = cursor.getString(CONTENT_NOTETYPE_COLOR_COLUMN);
        inOrOut = cursor.getInt(CONTENT_NOTETYPE_INOROUT_COLUMN);

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        if(!TextUtils.isEmpty(noteTypeName)){
            sb.append("noteTypeName : ").append(noteTypeName);
        }
        if(!TextUtils.isEmpty(noteTypeColor)){
            sb.append("noteTypeColor : ").append(noteTypeColor);
        }
        sb.append("is in or out :" ).append(inOrOut);
        return sb.toString();
    }

    /**
     * 对BillNoteTYpe相关的变量进行初始化
     */
    public static void initBillNotes() {
        CONTENT_URI_BILLNOTETYPE = Uri.parse(CONTENT_URI + "/billnotetype");
        CONTENT_URI_GETBYTYPE = Uri.parse(CONTENT_URI + "/getbytype");
    }

    public interface NoteTypeColumns {
        public static final String _ID = "_id";
        public static final String NOTETYPE_NAME = "noteTypeName";
        public static final String NOTETYPE_COLOR = "noteTypeColor";
        public static final String NOTETYPE_INOROUR = "noteTypeInorOut";
    }

    public static final String[] CONTENT_PROJECTION = {
            NoteTypeColumns._ID,NoteTypeColumns.NOTETYPE_NAME,NoteTypeColumns.NOTETYPE_COLOR,NoteTypeColumns.NOTETYPE_INOROUR
    };

    /**
     * 根据ID获取BIllNoteType
     * @param context
     * @param id
     * @return
     */
    public static BillNoteType restoreBillNoteWithID(Context context, long id) {
        return restoreBillNoteWithID(context, id, null);
    }
    /**
     * 根据ID获取BIllNoteType
     * @param context
     * @param id
     * @return
     */
    public static BillNoteType restoreBillNoteWithID(Context context, long id, ContentObserver observer) {
        return NoteContent.restoreContentWithID(context, BillNoteType.class,
                BillNoteType.CONTENT_URI_BILLNOTETYPE, BillNoteType.CONTENT_PROJECTION, id);
    }
}
