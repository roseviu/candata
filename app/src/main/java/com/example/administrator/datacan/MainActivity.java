package com.example.administrator.datacan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Window;
import android.widget.ArrayAdapter;
//import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper CanDb;
    SQLiteDatabase mDb;
    Cursor mCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        CanDb = new DatabaseHelper(this);

        //ListView listView1 = (ListView)findViewById(R.id.listView1);

        mDb = CanDb.getWritableDatabase();
        mCursor = mDb.rawQuery("SELECT " + CanDb.COL_1 + ", "  + CanDb.COL_2 + ", "
                + CanDb.COL_3 + ", "  + CanDb.COL_4 + " FROM " + CanDb.TABLE_NAME, null);

        ArrayList<String> dirArray = new ArrayList<String>();
        mCursor.moveToFirst();

        while ( !mCursor.isAfterLast() ){
            dirArray.add(mCursor.getString(mCursor.getColumnIndex(CanDb.COL_1)) + "\n"
                    + "Piece : " + mCursor.getString(mCursor.getColumnIndex(CanDb.COL_2)) + "\t\t"  //getStringดูตัวแปรตัวเองด้วยเด้อ
                    + "Cake : " + mCursor.getString(mCursor.getColumnIndex(CanDb.COL_3)));
            mCursor.moveToNext();
        }

        ArrayAdapter<String> adapterDir = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dirArray);
        listView1.setAdapter(adapterDir);
    }

    public void onPause() {
        super.onPause();
        CanDb.close();
        mDb.close();
    }
}
