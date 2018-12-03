package com.bwie.guoxiny;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class SearchDao {
    private static SearchDao intence;
    private Context context;
    private final SqliteHelper sqliteHelper;
    private final SQLiteDatabase sb;

    public SearchDao(Context context) {
        this.context = context;
        sqliteHelper = new SqliteHelper(context);
        sb = sqliteHelper.getWritableDatabase();

    }

    public static SearchDao getIntence(Context context) {
        if (intence==null){
            intence = new SearchDao(context);
        }
        return intence;
    }
    //添加
    public void add(String name){
        ContentValues values = new ContentValues();
        values.put("name",name);
        sb.insert("serachs",null,values);
    }
    //删除
    public void del(){
        sb.delete("serachs",null,null);
    }
    //查询
    public List<String> sel(){
        List<String> list = new ArrayList<>();
        Cursor serachs = sb.query("serachs", null, null, null, null, null, null, null);
        while (serachs.moveToNext()){
            String name = serachs.getString(serachs.getColumnIndex("name"));
            list.add(name);
        }
        return list;
    }
}
