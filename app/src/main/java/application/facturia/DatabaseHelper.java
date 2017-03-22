package application.facturia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by USER on 3/21/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contacts.db";
    private static final String TABLE_NAME = "contacts";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "nom";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASS = "pass";
    SQLiteDatabase db;
    private static final String TABLE_CREATE = "create table contacts (id integer primary key not null," +
            "nom text not null,email text not null,pass text not null)";

    public DatabaseHelper(Context context){
        super(context , DATABASE_NAME , null , DATABASE_VERSION);
    }

    public void insertContact(Contact c){

        db = this.getWritableDatabase();
        ContentValues val = new ContentValues();

        String query = "select * from contacts";
        Cursor curs = db.rawQuery(query,null);
        int count = curs.getCount();

        val.put(COLUMN_ID, count);
        val.put(COLUMN_NAME,c.getNom());
        val.put(COLUMN_EMAIL,c.getEmail());
        val.put(COLUMN_PASS,c.getPass());
        db.insert(TABLE_NAME , null ,val);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query ="DROP TABLE IF EXISTS"+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }

    public String searchPass(String mail){
        db  = this.getReadableDatabase();
        String query= "select mail,pass from "+TABLE_NAME;
        Cursor curs = db.rawQuery(query , null);
        String a,b ;
        b = "non trouve";
        if (curs.moveToFirst()){
            do{
                a = curs.getString(0);
                b = curs.getString(1);
                if (a.equals(mail)){
                    b = curs.getString(1);
                    break;
                }
            }while (curs.moveToNext());
        }
        return b;
    }

}
