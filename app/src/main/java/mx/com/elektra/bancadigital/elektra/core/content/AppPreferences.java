package mx.com.elektra.bancadigital.elektra.core.content;

import android.content.Context;
import android.content.SharedPreferences;

public class AppPreferences {

    public static void saveObjectUserSession(Context context, String objectLogIn){
        SharedPreferences preferences = context.getSharedPreferences(Constants.APP_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(Constants.USER_OBJECT, objectLogIn);
        editor.putBoolean(Constants.LOGGED_IN, true);
        editor.apply();
    }

    public static String getUserObject(Context activity){
        return activity.getSharedPreferences(Constants.APP_PREFERENCES, Context.MODE_PRIVATE).getString(Constants.USER_OBJECT, "");
    }

    public static boolean isLoggedIn(Context context) {
        return context.getSharedPreferences(Constants.APP_PREFERENCES, Context.MODE_PRIVATE).getBoolean(Constants.LOGGED_IN, false);
    }
}
