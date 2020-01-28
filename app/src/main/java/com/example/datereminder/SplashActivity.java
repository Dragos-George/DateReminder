package com.example.datereminder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SplashActivity extends AppCompatActivity {
    private static final String Name = "DATABASE.db";

    //method to copy the database from assets folder to the internal storage of the device if it doesn't exist
    public void _copydatabase() throws IOException {
        if (!new File(getApplicationContext().getFilesDir() + "/" + Name).exists()) {
            //OutputStream myOutput = new FileOutputStream(path + Name);
            OutputStream myOutput = new FileOutputStream(getApplicationContext().getFilesDir() + "/" + Name);
            Log.e("PATH:", getApplicationContext().getFilesDir().getAbsolutePath());

            byte[] buffer = new byte[1024];
            int length;
            InputStream myInput = getAssets().open(Name);
            while ((length = myInput.read(buffer)) > 0) {
                myOutput.write(buffer, 0, length);
            }
            myInput.close();
            myOutput.flush();
            myOutput.close();
        }
    }

    //testing data from the database
//    private void testMethod() {
//        try {
//            byte[] result = new Encryption().encryptString("Alex", "1");
//
//            String result2 = Encryption.decryptString(result, "1");
//
//            Log.e("DATA:", result2);
//            Log.e("DATA:", new String(result));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    //first encryption from phone to database
//    private void encryptDatabase() {
//
//        //dataBaseHelper.openDataBase();
//
//        String myPath = this.getApplicationContext().getFilesDir() + "/" + Name;
//        System.out.println("åbner " + Name);
//        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
//
//        Cursor mCursor;
//
//        mCursor = myDataBase.rawQuery("SELECT id_, headword_, html_ FROM entries", null);
//
//        Cursor writeCursor;
//
//        mCursor.moveToFirst();
//
//        Encryption encryption = new Encryption();
//
//        if (mCursor.getCount() > 0) {
//            System.out.println("search cursor is not null");
//            do {
//                //byte[] headwordBytes = mCursor.getBlob(searchCursor.getColumnIndex(KEY_HEADWORD_));
//                //byte[] shortBytes = searchCursor.getBlob(searchCursor.getColumnIndex(KEY_SHORT_));
//                String _id = mCursor.getString(mCursor.getColumnIndex("id_"));
//                byte[] headword_ = mCursor.getBlob(mCursor.getColumnIndex("headword_"));
//                byte[] html_ = mCursor.getBlob(mCursor.getColumnIndex("html_"));
//
//                byte[] headNEW = headword_;
//                byte[] htmlNEW = html_;
//
//                try {
//                    headNEW = encryption.encryptString(new String(headword_), _id);
//                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                }
//
//                try {
//                    htmlNEW = encryption.encryptString(new String(html_), _id);
//                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                }
//
//
////                myDataBase.execSQL("UPDATE entries SET html_ =(" + htmlNEW + ") WHERE id = " + _id );
////                myDataBase.execSQL("UPDATE entries SET headword_ =(" + headNEW + ") WHERE id = " + _id );
//
//
//                ContentValues cv = new ContentValues();
//                cv.put("html_", htmlNEW);
//                cv.put("headword_", headNEW);
//                myDataBase.update("entries", cv, "id_ = " + _id, null);
//
//
//                mCursor.moveToNext();
//            } while (!mCursor.isAfterLast());
//
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        try {
            _copydatabase();
        }catch (IOException e){

        }
    }

    @Override
    public void onStart() {
        super.onStart();
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                openActivity();
            }
        }, 2000);
    }

    private void openActivity() {
        //is logged in
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
        SplashActivity.this.finish();
    }
}
