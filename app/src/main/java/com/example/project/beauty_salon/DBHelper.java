package com.example.project.beauty_salon;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Birva on 4/4/2018.
 */

public class DBHelper extends SQLiteOpenHelper{
    static String DBname="dbreg";
    static String tabname="REG2";
    static String table2="details";
    static String col1="name";
    static String col2="pwd";
    static String col3="email";
    static String col4="phnno";

    static String col21="salonname";
    static String col22="salonadd";
    static String col23="ot";
    static String col24="ct";

    Context c;
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DBname, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query="CREATE TABLE "+tabname+"("+col1+" text,"+col2+" text,"+col3+" text,"+col4+" text)";
        sqLiteDatabase.execSQL(query);
        String query2="CREATE TABLE "+table2+"("+col21+" text,"+col22+" text,"+col23+" text,"+col24+" text)";
        sqLiteDatabase.execSQL(query2);


    }
    public long inrecords(String uname,String pwd,String email,String phn) {
        SQLiteDatabase db=this.getWritableDatabase();
        String s="insert into "+tabname + " values('"+uname+"','"+pwd+"','"+email+"','"+phn+"');";
        db.execSQL(s);
        return 0;
    }
    public long inrecdetails(String salname,String saladd)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String s2="insert into "+table2 +" values('"+salname+"','"+saladd+"')";
        db.execSQL(s2);
        return 0;
    }
    public Cursor Selrec(String uname, String pwd) {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c;
        return db.rawQuery("select * from "+tabname+" where name='"+uname+"' and pwd='"+pwd+"';", null);
    }
    public Cursor Seldet(String salname) {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c;
        return db.rawQuery("select * from "+table2+" where name='"+salname+"';", null);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.delete(tabname, null, null);
        db.delete(table2, null, null);
    }
    public void clearRecords()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(tabname,null,null);
        db.delete(table2,null,null);
    }

    public Cursor getAllTitles() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("select * from " + tabname, null);
   }
    public Cursor getalldetails() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("select * from " + table2, null);
    }
}
