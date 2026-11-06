package expo.modules.calendar.domain.event.extensions;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.CalendarContract;
import com.amazon.a.a.o.b;
import expo.modules.calendar.CalendarUtils;
import expo.modules.calendar.domain.event.enums.AlarmMethod;
import expo.modules.calendar.domain.event.enums.Availability;
import expo.modules.calendar.domain.event.enums.EventAccessLevel;
import expo.modules.calendar.domain.event.records.Alarm;
import expo.modules.calendar.domain.event.records.EventEntity;
import expo.modules.calendar.domain.event.records.RecurrenceRuleEntity;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class CursorExtensionsKt {
    public static final Alarm extractAlarm(Cursor cursor) {
        Intrinsics.checkNotNullParameter(cursor, "<this>");
        return new Alarm(Integer.valueOf(-cursor.getInt(cursor.getColumnIndexOrThrow("minutes"))), AlarmMethod.INSTANCE.fromContentProviderValue(cursor.getInt(cursor.getColumnIndexOrThrow("method"))));
    }

    /* JADX WARN: Code duplicated, block: B:15:0x005b  */
    /* JADX WARN: Code duplicated, block: B:8:0x0035  */
    public static final EventEntity extractEvent(Cursor cursor, ContentResolver contentResolver) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(cursor, "<this>");
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        String string = cursor.getString(3);
        if (string != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(Long.parseLong(string));
            String str3 = CalendarUtils.INSTANCE.getSdf().format(calendar.getTime());
            if (str3 == null) {
                str = "";
            } else {
                str = str3;
            }
        } else {
            str = "";
        }
        String string2 = cursor.getString(4);
        if (string2 != null) {
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(Long.parseLong(string2));
            String str4 = CalendarUtils.INSTANCE.getSdf().format(calendar2.getTime());
            if (str4 == null) {
                str2 = "";
            } else {
                str2 = str4;
            }
        } else {
            str2 = "";
        }
        int intOrDefault$default = expo.modules.calendar.extensions.CursorExtensionsKt.getIntOrDefault$default(cursor, "availability", 0, 2, null);
        int intOrDefault$default2 = expo.modules.calendar.extensions.CursorExtensionsKt.getIntOrDefault$default(cursor, "accessLevel", 0, 2, null);
        Cursor cursor2 = cursor.getColumnCount() > 18 ? cursor : null;
        String string3 = cursor2 != null ? cursor2.getString(18) : null;
        String optionalString = expo.modules.calendar.extensions.CursorExtensionsKt.getOptionalString(cursor, "rrule");
        RecurrenceRuleEntity recurrenceRuleEntityFromRuleString = optionalString != null ? RecurrenceRuleEntity.INSTANCE.fromRuleString(optionalString) : null;
        String string4 = cursor.getString(0);
        Intrinsics.checkNotNull(string4);
        return new EventEntity(string4, expo.modules.calendar.extensions.CursorExtensionsKt.getOptionalString(cursor, "calendar_id"), expo.modules.calendar.extensions.CursorExtensionsKt.getOptionalString(cursor, b.S), expo.modules.calendar.extensions.CursorExtensionsKt.getOptionalString(cursor, b.c), str, str2, getAlarmsForEvent(contentResolver, Long.parseLong(string4)), Availability.INSTANCE.fromContentProviderValue(intOrDefault$default), expo.modules.calendar.extensions.CursorExtensionsKt.getIntOrDefault$default(cursor, "allDay", 0, 2, null) != 0, expo.modules.calendar.extensions.CursorExtensionsKt.getOptionalString(cursor, "eventLocation"), expo.modules.calendar.extensions.CursorExtensionsKt.getOptionalString(cursor, "organizer"), expo.modules.calendar.extensions.CursorExtensionsKt.getIntOrDefault$default(cursor, "guestsCanModify", 0, 2, null) != 0, expo.modules.calendar.extensions.CursorExtensionsKt.getIntOrDefault$default(cursor, "guestsCanInviteOthers", 0, 2, null) != 0, expo.modules.calendar.extensions.CursorExtensionsKt.getIntOrDefault$default(cursor, "guestsCanSeeGuests", 0, 2, null) != 0, expo.modules.calendar.extensions.CursorExtensionsKt.getOptionalString(cursor, "eventTimezone"), expo.modules.calendar.extensions.CursorExtensionsKt.getOptionalString(cursor, "eventEndTimezone"), EventAccessLevel.INSTANCE.fromContentProviderValue(intOrDefault$default2), recurrenceRuleEntityFromRuleString, expo.modules.calendar.extensions.CursorExtensionsKt.getOptionalString(cursor, "original_id"), string3);
    }

    private static final List getAlarmsForEvent(ContentResolver contentResolver, long j) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = CalendarContract.Reminders.query(contentResolver, j, new String[]{"minutes", "method"});
        while (cursorQuery.moveToNext()) {
            Intrinsics.checkNotNull(cursorQuery);
            arrayList.add(extractAlarm(cursorQuery));
        }
        return arrayList;
    }
}
