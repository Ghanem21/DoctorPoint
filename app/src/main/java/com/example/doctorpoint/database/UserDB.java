package com.example.doctorpoint.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserDB extends SQLiteOpenHelper {
    private volatile static UserDB INSTANCE;

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "User_DB";

    private static final String USERS_TABLE_NAME = "users";
    private static final String USERS_CLN_ID = "id";
    private static final String USERS_CLN_NAME = "name";
    private static final String USERS_CLN_EMAIL = "email";
    private static final String USERS_CLN_PHONE = "phone";
    private static final String USERS_CLN_PASSWORD = "password";

    private UserDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public static UserDB getInstance(Context context) {
        if (INSTANCE == null)
            synchronized (UserDB.class) {
                if (INSTANCE == null)
                    INSTANCE = new UserDB(context);
            }
        return INSTANCE;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + USERS_TABLE_NAME
                + " ( "
                + USERS_CLN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + USERS_CLN_EMAIL + " TEXT UNIQUE NOT NULL, "
                + USERS_CLN_NAME + " TEXT NOT NULL, "
                + USERS_CLN_PHONE+ " TEXT UNIQUE NOT NULL,"
                + USERS_CLN_PASSWORD + " TEXT NOT NULL "
                + " )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insertUser(User user) {
        ContentValues values = new ContentValues();
        values.put(USERS_CLN_EMAIL, user.getEmail());
        values.put(USERS_CLN_NAME, user.getName());
        values.put(USERS_CLN_PHONE, user.getPhone());
        values.put(USERS_CLN_PASSWORD, user.getPassword());

        long result = getWritableDatabase().insert(USERS_TABLE_NAME, null, values);
        return result != -1;
    }

    public User getUser(String email,String password) {
        User user = new User();
        String[] args = {email , password};
        Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM " + USERS_TABLE_NAME + " WHERE " + USERS_CLN_EMAIL + " = ?" + " AND " + USERS_CLN_PASSWORD + " = ?", args);

        if (cursor.moveToFirst()) {
            int id = Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(USERS_CLN_ID)));
            String name = cursor.getString(cursor.getColumnIndexOrThrow(USERS_CLN_NAME));
            String phone = cursor.getString(cursor.getColumnIndexOrThrow(USERS_CLN_PHONE));

            user = new User(id,email,name,phone,password);

            cursor.close();
        }

        return user;
    }
}
