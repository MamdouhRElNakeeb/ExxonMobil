package com.exxonmobil.mobapp.helper;

/**
 * Created by Nakeeb PC on 7/23/2016.
 */
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

public class SessionManager {
    // LogCat tag
    private static String TAG = SessionManager.class.getSimpleName();

    // Shared Preferences
    SharedPreferences pref;

    Editor editor;
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "UserDetails";

    private static final String KEY_IS_LOGGED_IN = "isLoggedIn";

    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setLogin(String isLoggedIn) {

        editor.putString(KEY_IS_LOGGED_IN, isLoggedIn);

        // commit changes
        editor.commit();

        Log.d(TAG, "User login session modified!");
    }

    public String isLoggedIn(){
        return pref.getString(KEY_IS_LOGGED_IN, "");
    }

    public void insertData(String name, String email, String mobile, String password, String carBrand, String carModel, String carYear, String regID, String created_at){
        editor.putString("name", name);
        editor.putString("email", email);
        editor.putString("mobile", mobile);
        editor.putString("password", password);
        editor.putString("carBrand", carBrand);
        editor.putString("carModel", carModel);
        editor.putString("carYear", carYear);
        editor.putString("regID", regID);
        editor.putString("created_at", created_at);
        editor.commit();
        setLogin("1");
    }

    public void removeData(){
        editor.remove("name");
        editor.remove("email");
        editor.remove("mobile");
        editor.remove("carBrand");
        editor.remove("carModel");
        editor.remove("carYear");
        editor.remove("created_at");
        editor.commit();

        // Logout from session
        setLogin("0");
    }
}
