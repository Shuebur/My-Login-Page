package com.example.myloginpage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="user details.db";
    private static final String TABLE_NAME="user_details_db";
    private static final String ID="Id";
    private static final String NAME="Name";
    private static final String USERNAME="Username";
    private static final String PASSWORD="Password";
    private static final String EMAIL="Email";
    private static final int VERSION_NUMBER=4;
    private Context context;
    private SQLiteDatabase db;

    private static final  String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+" ( "+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+"  TEXT , "+EMAIL+" TEXT NOT NULL, "+USERNAME+" TEXT NOT NULL, "+PASSWORD+" TEXT NOT NULL )";
    private static final  String DROP_TABLE ="DROP TABLE IF EXISTS "+TABLE_NAME;

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            db=sqLiteDatabase;
            db.execSQL(CREATE_TABLE);
            Toast.makeText(context, "onCreate is called",Toast.LENGTH_LONG).show();

        }catch(Exception e){

            Toast.makeText(context, "Exception :"+e,Toast.LENGTH_LONG).show();


        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        try {
            db=sqLiteDatabase;
            db.execSQL(DROP_TABLE);
           onCreate(db);
            Toast.makeText(context, "onUpgrade is called",Toast.LENGTH_LONG).show();

        }catch(Exception e){

            Toast.makeText(context, "Exception :"+e,Toast.LENGTH_LONG).show();


        }

    }
    public long insertData(UserDetails userDetails){
        db=getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(NAME,userDetails.getName());
        contentValues.put(EMAIL,userDetails.getEmail());
        contentValues.put(USERNAME,userDetails.getUsername());
        contentValues.put(PASSWORD,userDetails.getPassword());

       Long rowId = db.insert(TABLE_NAME,null,contentValues);
       return rowId;
    }
    public Boolean findPassword (String uname,String pasword) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(" SELECT * FROM " + TABLE_NAME ,null);
Boolean result = false;

        if (cursor.getCount() == 0) {

Toast.makeText(context,"No data is found",Toast.LENGTH_LONG).show();
        }
        else{
          while (cursor.moveToNext())
          {

          String username =  cursor.getString(3)  ;
       String password = cursor.getString(4);
if (username.equals(uname) && password.equals(pasword)){
    result=true;
    break;

}

          }


        }
        return result;
    }
}
