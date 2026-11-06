package com.reactcommunity.rndatetimepicker;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.widget.DatePicker;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.google.firebase.messaging.Constants;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
@SuppressLint({"ValidFragment"})
public class RNDatePickerDialogFragment extends DialogFragment {
    private DatePickerDialog instance;
    private DatePickerDialog.OnDateSetListener mOnDateSetListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private DialogInterface.OnClickListener mOnNeutralButtonActionListener;

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        DatePickerDialog datePickerDialogCreateDialog = createDialog(getArguments());
        this.instance = datePickerDialogCreateDialog;
        return datePickerDialogCreateDialog;
    }

    public void update(Bundle bundle) {
        RNDate rNDate = new RNDate(bundle);
        this.instance.updateDate(rNDate.year(), rNDate.month(), rNDate.day());
    }

    static DatePickerDialog getDialog(Bundle bundle, Context context, DatePickerDialog.OnDateSetListener onDateSetListener) {
        RNDate rNDate = new RNDate(bundle);
        int iYear = rNDate.year();
        int iMonth = rNDate.month();
        int iDay = rNDate.day();
        RNDatePickerDisplay displayDate = Common.getDisplayDate(bundle);
        if (bundle != null && bundle.getString(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION, null) != null) {
            displayDate = RNDatePickerDisplay.valueOf(bundle.getString(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION).toUpperCase(Locale.US));
        }
        RNDatePickerDisplay rNDatePickerDisplay = displayDate;
        if (rNDatePickerDisplay == RNDatePickerDisplay.SPINNER) {
            return new RNDismissableDatePickerDialog(context, R$style.SpinnerDatePickerDialog, onDateSetListener, iYear, iMonth, iDay, rNDatePickerDisplay);
        }
        return new RNDismissableDatePickerDialog(context, onDateSetListener, iYear, iMonth, iDay, rNDatePickerDisplay);
    }

    private DatePickerDialog createDialog(Bundle bundle) {
        final Bundle bundle2;
        FragmentActivity activity = getActivity();
        DatePickerDialog dialog = getDialog(bundle, activity, this.mOnDateSetListener);
        if (bundle != null) {
            Common.setButtonTitles(bundle, dialog, this.mOnNeutralButtonActionListener);
            if (activity != null) {
                RNDatePickerDisplay displayDate = Common.getDisplayDate(bundle);
                dialog.setOnShowListener(Common.combine(Common.openYearDialog(dialog, displayDate == RNDatePickerDisplay.DEFAULT && bundle.getBoolean("startOnYearSelection")), Common.setButtonTextColor(activity, dialog, bundle, displayDate == RNDatePickerDisplay.SPINNER)));
            }
        }
        final DatePicker datePicker = dialog.getDatePicker();
        final long jMinDateWithTimeZone = Common.minDateWithTimeZone(bundle);
        final long jMaxDateWithTimeZone = Common.maxDateWithTimeZone(bundle);
        if (bundle.containsKey("minimumDate")) {
            datePicker.setMinDate(jMinDateWithTimeZone);
        } else {
            datePicker.setMinDate(-2208988800001L);
        }
        if (bundle.containsKey("maximumDate")) {
            datePicker.setMaxDate(jMaxDateWithTimeZone);
        }
        int i = Build.VERSION.SDK_INT;
        if (bundle.containsKey("firstDayOfWeek")) {
            datePicker.setFirstDayOfWeek(bundle.getInt("firstDayOfWeek"));
        }
        if (i < 26 || !(bundle.containsKey("maximumDate") || bundle.containsKey("minimumDate"))) {
            bundle2 = bundle;
        } else {
            bundle2 = bundle;
            datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() { // from class: com.reactcommunity.rndatetimepicker.RNDatePickerDialogFragment$$ExternalSyntheticLambda0
                @Override // android.widget.DatePicker.OnDateChangedListener
                public final void onDateChanged(DatePicker datePicker2, int i2, int i3, int i4) {
                    RNDatePickerDialogFragment.$r8$lambda$PwGU8C0vUPPYF53Hfq3NFMQORMs(bundle2, jMinDateWithTimeZone, jMaxDateWithTimeZone, datePicker, datePicker2, i2, i3, i4);
                }
            });
        }
        if (bundle2.containsKey("testID")) {
            datePicker.setTag(bundle2.getString("testID"));
        }
        return dialog;
    }

    public static /* synthetic */ void $r8$lambda$PwGU8C0vUPPYF53Hfq3NFMQORMs(Bundle bundle, long j, long j2, DatePicker datePicker, DatePicker datePicker2, int i, int i2, int i3) {
        Calendar calendar = Calendar.getInstance(Common.getTimeZone(bundle));
        calendar.set(i, i2, i3, 0, 0, 0);
        calendar.setTimeInMillis(Math.min(Math.max(calendar.getTimeInMillis(), j), j2));
        if (datePicker.getYear() == calendar.get(1) && datePicker.getMonth() == calendar.get(2) && datePicker.getDayOfMonth() == calendar.get(5)) {
            return;
        }
        datePicker.updateDate(calendar.get(1), calendar.get(2), calendar.get(5));
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        DialogInterface.OnDismissListener onDismissListener = this.mOnDismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }

    void setOnDateSetListener(DatePickerDialog.OnDateSetListener onDateSetListener) {
        this.mOnDateSetListener = onDateSetListener;
    }

    void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    void setOnNeutralButtonActionListener(DialogInterface.OnClickListener onClickListener) {
        this.mOnNeutralButtonActionListener = onClickListener;
    }
}
