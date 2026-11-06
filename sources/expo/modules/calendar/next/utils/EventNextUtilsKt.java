package expo.modules.calendar.next.utils;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import expo.modules.calendar.next.records.RecurrenceRuleRecord;
import java.util.Calendar;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class EventNextUtilsKt {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:23:0x004f  */
    public static final String createRecurrenceRule(RecurrenceRuleRecord opts) {
        String str;
        Intrinsics.checkNotNullParameter(opts, "opts");
        String endDate = opts.getEndDate();
        String frequency = opts.getFrequency();
        Integer interval = opts.getInterval();
        Integer occurrence = opts.getOccurrence();
        if (frequency != null) {
            switch (frequency) {
                case "weekly":
                    str = "FREQ=WEEKLY";
                    break;
                case "yearly":
                    str = "FREQ=YEARLY";
                    break;
                case "daily":
                    str = "FREQ=DAILY";
                    break;
                case "monthly":
                    str = "FREQ=MONTHLY";
                    break;
                default:
                    str = "";
                    break;
            }
        } else {
            str = "";
        }
        if (interval != null) {
            str = str + ";INTERVAL=" + interval;
        }
        if (endDate != null) {
            return str + ";UNTIL=" + endDate;
        }
        if (occurrence == null) {
            return str;
        }
        return str + ";COUNT=" + occurrence;
    }

    public static final Long dateToMilliseconds(String str) {
        Date date;
        if (str == null || (date = CalendarNextUtilsKt.getSdf().parse(str)) == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return Long.valueOf(calendar.getTimeInMillis());
    }

    public static final void removeRemindersForEvent(ContentResolver contentResolver, long j) {
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        Cursor cursorQuery = CalendarContract.Reminders.query(contentResolver, j, new String[]{"_id"});
        int columnIndex = cursorQuery.getColumnIndex("_id");
        while (cursorQuery.moveToNext()) {
            Uri uriWithAppendedId = ContentUris.withAppendedId(CalendarContract.Reminders.CONTENT_URI, cursorQuery.getLong(columnIndex));
            Intrinsics.checkNotNullExpressionValue(uriWithAppendedId, "withAppendedId(...)");
            contentResolver.delete(uriWithAppendedId, null, null);
        }
    }
}
