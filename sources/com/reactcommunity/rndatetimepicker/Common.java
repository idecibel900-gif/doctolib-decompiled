package com.reactcommunity.rndatetimepicker;

import android.R;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.amazon.a.a.o.b;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.util.RNLog;
import com.google.firebase.messaging.Constants;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import j$.util.DesugarTimeZone;
import java.util.Calendar;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Common {
    public static void dismissDialog(FragmentActivity fragmentActivity, String str, Promise promise) {
        if (fragmentActivity == null) {
            promise.reject("E_NO_ACTIVITY", "Tried to close a " + str + " dialog while not attached to an Activity");
            return;
        }
        try {
            DialogFragment dialogFragment = (DialogFragment) fragmentActivity.getSupportFragmentManager().findFragmentByTag(str);
            boolean z = dialogFragment != null;
            if (z) {
                dialogFragment.dismiss();
            }
            promise.resolve(Boolean.valueOf(z));
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    public static int getDefaultDialogButtonTextColor(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.textColorPrimary, typedValue, true);
        int i = typedValue.resourceId;
        if (i != 0) {
            return ContextCompat.getColor(context, i);
        }
        return typedValue.data;
    }

    public static DialogInterface.OnShowListener setButtonTextColor(final Context context, final AlertDialog alertDialog, final Bundle bundle, final boolean z) {
        return new DialogInterface.OnShowListener() { // from class: com.reactcommunity.rndatetimepicker.Common$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                Common.$r8$lambda$p1dD36YWz_xzPJMtnQ49kHNyziY(alertDialog, context, bundle, z, dialogInterface);
            }
        };
    }

    public static /* synthetic */ void $r8$lambda$p1dD36YWz_xzPJMtnQ49kHNyziY(AlertDialog alertDialog, Context context, Bundle bundle, boolean z, DialogInterface dialogInterface) {
        Button button = alertDialog.getButton(-1);
        Button button2 = alertDialog.getButton(-2);
        Button button3 = alertDialog.getButton(-3);
        int defaultDialogButtonTextColor = getDefaultDialogButtonTextColor(context);
        setTextColor(button, "positive", bundle, z, defaultDialogButtonTextColor);
        setTextColor(button2, "negative", bundle, z, defaultDialogButtonTextColor);
        setTextColor(button3, "neutral", bundle, z, defaultDialogButtonTextColor);
    }

    public static DialogInterface.OnShowListener openYearDialog(final AlertDialog alertDialog, final boolean z) {
        return new DialogInterface.OnShowListener() { // from class: com.reactcommunity.rndatetimepicker.Common$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                Common.m3713$r8$lambda$Fuyi18jZHQAcj39UmaxC8fbRs(z, alertDialog, dialogInterface);
            }
        };
    }

    /* JADX INFO: renamed from: $r8$lambda$Fuyi18jZHQAcj3-9UmaxC-8fbRs, reason: not valid java name */
    public static /* synthetic */ void m3713$r8$lambda$Fuyi18jZHQAcj39UmaxC8fbRs(boolean z, AlertDialog alertDialog, DialogInterface dialogInterface) {
        View viewFindViewById;
        if (z && (alertDialog instanceof DatePickerDialog)) {
            DatePicker datePicker = ((DatePickerDialog) alertDialog).getDatePicker();
            int identifier = Resources.getSystem().getIdentifier("date_picker_header_year", DiagnosticsEntry.ID_KEY, "android");
            if (identifier == 0 || (viewFindViewById = datePicker.findViewById(identifier)) == null) {
                return;
            }
            viewFindViewById.performClick();
        }
    }

    public static DialogInterface.OnShowListener combine(final DialogInterface.OnShowListener... onShowListenerArr) {
        return new DialogInterface.OnShowListener() { // from class: com.reactcommunity.rndatetimepicker.Common$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                Common.$r8$lambda$8QPpvU1B0RO7c8h1jxmlAIORcEI(onShowListenerArr, dialogInterface);
            }
        };
    }

    public static /* synthetic */ void $r8$lambda$8QPpvU1B0RO7c8h1jxmlAIORcEI(DialogInterface.OnShowListener[] onShowListenerArr, DialogInterface dialogInterface) {
        for (DialogInterface.OnShowListener onShowListener : onShowListenerArr) {
            if (onShowListener != null) {
                onShowListener.onShow(dialogInterface);
            }
        }
    }

    private static void setTextColor(Button button, String str, Bundle bundle, boolean z, int i) {
        if (button == null) {
            return;
        }
        Integer buttonColor = getButtonColor(bundle, str);
        if (z || buttonColor != null) {
            if (buttonColor != null) {
                i = buttonColor.intValue();
            }
            button.setTextColor(i);
        }
    }

    private static Integer getButtonColor(Bundle bundle, String str) {
        Bundle bundle2;
        int i;
        Bundle bundle3 = bundle.getBundle("dialogButtons");
        if (bundle3 == null || (bundle2 = bundle3.getBundle(str)) == null || (i = (int) bundle2.getDouble("textColor", 0.0d)) == 0) {
            return null;
        }
        return Integer.valueOf(i);
    }

    public static RNTimePickerDisplay getDisplayTime(Bundle bundle) {
        return (bundle == null || bundle.getString(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION, null) == null) ? RNTimePickerDisplay.DEFAULT : RNTimePickerDisplay.valueOf(bundle.getString(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION).toUpperCase(Locale.US));
    }

    public static RNDatePickerDisplay getDisplayDate(Bundle bundle) {
        return (bundle == null || bundle.getString(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION, null) == null) ? RNDatePickerDisplay.DEFAULT : RNDatePickerDisplay.valueOf(bundle.getString(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION).toUpperCase(Locale.US));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setButtonTitles(Bundle bundle, AlertDialog alertDialog, DialogInterface.OnClickListener onClickListener) {
        Bundle bundle2 = bundle.getBundle("dialogButtons");
        if (bundle2 == null) {
            return;
        }
        setButtonLabel(bundle2.getBundle("neutral"), alertDialog, -3, onClickListener);
        DialogInterface.OnClickListener onClickListener2 = (DialogInterface.OnClickListener) alertDialog;
        setButtonLabel(bundle2.getBundle("positive"), alertDialog, -1, onClickListener2);
        setButtonLabel(bundle2.getBundle("negative"), alertDialog, -2, onClickListener2);
    }

    private static void setButtonLabel(Bundle bundle, AlertDialog alertDialog, int i, DialogInterface.OnClickListener onClickListener) {
        if (bundle == null || bundle.getString(Constants.ScionAnalytics.PARAM_LABEL) == null) {
            return;
        }
        alertDialog.setButton(i, bundle.getString(Constants.ScionAnalytics.PARAM_LABEL), onClickListener);
    }

    public static TimeZone getTimeZone(Bundle bundle) {
        if (bundle != null && bundle.containsKey("timeZoneOffsetInMinutes")) {
            return new SimpleTimeZone(((int) bundle.getLong("timeZoneOffsetInMinutes")) * 60000, "GMT");
        }
        if (bundle != null && bundle.containsKey("timeZoneName")) {
            String string = bundle.getString("timeZoneName");
            if (!"GMT".equals(string)) {
                if (!"GMT".equals(DesugarTimeZone.getTimeZone(string).getID())) {
                    return DesugarTimeZone.getTimeZone(string);
                }
                RNLog.w(null, "'" + string + "' does not exist in TimeZone.getAvailableIDs(). Falling back to TimeZone.getDefault()=" + TimeZone.getDefault().getID());
            } else {
                return DesugarTimeZone.getTimeZone("GMT");
            }
        }
        return TimeZone.getDefault();
    }

    public static long maxDateWithTimeZone(Bundle bundle) {
        if (!bundle.containsKey("maximumDate")) {
            return Long.MAX_VALUE;
        }
        Calendar calendar = Calendar.getInstance(getTimeZone(bundle));
        calendar.setTimeInMillis(bundle.getLong("maximumDate"));
        calendar.set(11, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        calendar.set(14, 999);
        return calendar.getTimeInMillis();
    }

    public static long minDateWithTimeZone(Bundle bundle) {
        if (!bundle.containsKey("minimumDate")) {
            return 0L;
        }
        Calendar calendar = Calendar.getInstance(getTimeZone(bundle));
        calendar.setTimeInMillis(bundle.getLong("minimumDate"));
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public static Bundle createFragmentArguments(ReadableMap readableMap) {
        Bundle bundle = new Bundle();
        if (readableMap.hasKey("value") && !readableMap.isNull("value")) {
            bundle.putLong("value", (long) readableMap.getDouble("value"));
        }
        if (readableMap.hasKey("timeZoneName") && !readableMap.isNull("timeZoneName")) {
            bundle.putString("timeZoneName", readableMap.getString("timeZoneName"));
        }
        if (readableMap.hasKey(b.S) && !readableMap.isNull(b.S)) {
            bundle.putString(b.S, readableMap.getString(b.S));
        }
        if (readableMap.hasKey("initialInputMode") && !readableMap.isNull("initialInputMode")) {
            bundle.putString("initialInputMode", readableMap.getString("initialInputMode"));
        }
        return bundle;
    }

    public static Bundle createDatePickerArguments(ReadableMap readableMap) {
        Bundle bundleCreateFragmentArguments = createFragmentArguments(readableMap);
        if (readableMap.hasKey("minimumDate") && !readableMap.isNull("minimumDate")) {
            bundleCreateFragmentArguments.putLong("minimumDate", (long) readableMap.getDouble("minimumDate"));
        }
        if (readableMap.hasKey("maximumDate") && !readableMap.isNull("maximumDate")) {
            bundleCreateFragmentArguments.putLong("maximumDate", (long) readableMap.getDouble("maximumDate"));
        }
        if (readableMap.hasKey(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION) && !readableMap.isNull(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION)) {
            bundleCreateFragmentArguments.putString(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION, readableMap.getString(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION));
        }
        if (readableMap.hasKey("dialogButtons") && !readableMap.isNull("dialogButtons")) {
            bundleCreateFragmentArguments.putBundle("dialogButtons", Arguments.toBundle(readableMap.getMap("dialogButtons")));
        }
        if (readableMap.hasKey("timeZoneOffsetInMinutes") && !readableMap.isNull("timeZoneOffsetInMinutes")) {
            bundleCreateFragmentArguments.putLong("timeZoneOffsetInMinutes", (long) readableMap.getDouble("timeZoneOffsetInMinutes"));
        }
        if (readableMap.hasKey("testID") && !readableMap.isNull("testID")) {
            bundleCreateFragmentArguments.putString("testID", readableMap.getString("testID"));
        }
        if (readableMap.hasKey("fullscreen") && !readableMap.isNull("fullscreen")) {
            bundleCreateFragmentArguments.putBoolean("fullscreen", readableMap.getBoolean("fullscreen"));
        }
        if (readableMap.hasKey("firstDayOfWeek") && !readableMap.isNull("firstDayOfWeek")) {
            bundleCreateFragmentArguments.putInt("firstDayOfWeek", readableMap.getInt("firstDayOfWeek") + 1);
        }
        if (readableMap.hasKey("startOnYearSelection") && !readableMap.isNull("startOnYearSelection")) {
            bundleCreateFragmentArguments.putBoolean("startOnYearSelection", readableMap.getBoolean("startOnYearSelection"));
        }
        return bundleCreateFragmentArguments;
    }

    public static Bundle createTimePickerArguments(ReadableMap readableMap) {
        Bundle bundleCreateFragmentArguments = createFragmentArguments(readableMap);
        if (readableMap.hasKey("is24Hour") && !readableMap.isNull("is24Hour")) {
            bundleCreateFragmentArguments.putBoolean("is24Hour", readableMap.getBoolean("is24Hour"));
        }
        if (readableMap.hasKey(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION) && !readableMap.isNull(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION)) {
            bundleCreateFragmentArguments.putString(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION, readableMap.getString(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION));
        }
        if (readableMap.hasKey("dialogButtons") && !readableMap.isNull("dialogButtons")) {
            bundleCreateFragmentArguments.putBundle("dialogButtons", Arguments.toBundle(readableMap.getMap("dialogButtons")));
        }
        if (readableMap.hasKey("minuteInterval") && !readableMap.isNull("minuteInterval")) {
            bundleCreateFragmentArguments.putInt("minuteInterval", readableMap.getInt("minuteInterval"));
        }
        if (readableMap.hasKey("timeZoneOffsetInMinutes") && !readableMap.isNull("timeZoneOffsetInMinutes")) {
            bundleCreateFragmentArguments.putLong("timeZoneOffsetInMinutes", (long) readableMap.getDouble("timeZoneOffsetInMinutes"));
        }
        return bundleCreateFragmentArguments;
    }
}
