package app.notifee.core.utility;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import app.notifee.core.ContextHolder;
import app.notifee.core.Logger;

/* JADX INFO: loaded from: classes3.dex */
public abstract class IntentUtils {
    public static String getActivityName(Intent intent) {
        if (intent == null) {
            return null;
        }
        try {
            String className = intent.getComponent().getClassName();
            int iLastIndexOf = className.lastIndexOf(".");
            if (iLastIndexOf != -1) {
                return className.substring(iLastIndexOf + 1);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static void startActivityOnUiThread(Activity activity, final Intent intent) {
        if (activity == null || intent == null) {
            Logger.w("IntentUtils", "Activity or intent is null when calling startActivityOnUiThread()");
            return;
        }
        final Context applicationContext = ContextHolder.getApplicationContext();
        if (applicationContext == null) {
            Logger.w("IntentUtils", "Unable to get application context when calling startActivityOnUiThread()");
        } else {
            activity.runOnUiThread(new Runnable() { // from class: app.notifee.core.utility.IntentUtils$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    IntentUtils.$r8$lambda$REk6I5BA74OWbkbSEo4GfL34l2c(applicationContext, intent);
                }
            });
        }
    }

    public static /* synthetic */ void $r8$lambda$REk6I5BA74OWbkbSEo4GfL34l2c(Context context, Intent intent) {
        try {
            context.startActivity(intent);
        } catch (Exception e) {
            Logger.e("IntentUtils", "An error occurred whilst trying to start activity on Ui Thread", e);
        }
    }

    public static Class getLaunchActivity(String str) {
        String mainActivityClassName = (str == null || str.equals("default")) ? getMainActivityClassName() : str;
        if (mainActivityClassName == null) {
            Logger.e("ReceiverService", "Launch Activity for notification could not be found.");
            return null;
        }
        Class classForName = getClassForName(mainActivityClassName);
        if (classForName != null) {
            return classForName;
        }
        Logger.e("ReceiverService", String.format("Launch Activity for notification does not exist ('%s').", str));
        return null;
    }

    private static Class getClassForName(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private static String getMainActivityClassName() {
        Intent launchIntentForPackage = ContextHolder.getApplicationContext().getPackageManager().getLaunchIntentForPackage(ContextHolder.getApplicationContext().getPackageName());
        if (launchIntentForPackage == null || launchIntentForPackage.getComponent() == null) {
            return null;
        }
        return launchIntentForPackage.getComponent().getClassName();
    }
}
