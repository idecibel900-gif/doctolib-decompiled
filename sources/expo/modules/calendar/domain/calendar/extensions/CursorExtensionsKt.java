package expo.modules.calendar.domain.calendar.extensions;

import android.database.Cursor;
import expo.modules.calendar.domain.attendee.enums.AttendeeType;
import expo.modules.calendar.domain.calendar.enums.CalendarAccessLevel;
import expo.modules.calendar.domain.calendar.records.CalendarEntity;
import expo.modules.calendar.domain.calendar.records.CalendarSource;
import expo.modules.calendar.domain.event.enums.AlarmMethod;
import expo.modules.calendar.domain.event.enums.Availability;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class CursorExtensionsKt {
    public static final CalendarEntity extractCalendar(Cursor cursor) {
        Intrinsics.checkNotNullParameter(cursor, "<this>");
        int intOrDefault$default = expo.modules.calendar.extensions.CursorExtensionsKt.getIntOrDefault$default(cursor, "calendar_access_level", 0, 2, null);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(expo.modules.calendar.extensions.CursorExtensionsKt.getIntOrDefault$default(cursor, "calendar_color", 0, 2, null) & 16777215)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        List valueList = expo.modules.calendar.extensions.CursorExtensionsKt.getValueList(cursor, "allowedAvailability", new Function1() { // from class: expo.modules.calendar.domain.calendar.extensions.CursorExtensionsKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CursorExtensionsKt.extractCalendar$lambda$0(((Integer) obj).intValue());
            }
        });
        List valueList2 = expo.modules.calendar.extensions.CursorExtensionsKt.getValueList(cursor, "allowedReminders", new Function1() { // from class: expo.modules.calendar.domain.calendar.extensions.CursorExtensionsKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CursorExtensionsKt.extractCalendar$lambda$1(((Integer) obj).intValue());
            }
        });
        List valueList3 = expo.modules.calendar.extensions.CursorExtensionsKt.getValueList(cursor, "allowedAttendeeTypes", new Function1() { // from class: expo.modules.calendar.domain.calendar.extensions.CursorExtensionsKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CursorExtensionsKt.extractCalendar$lambda$2(((Integer) obj).intValue());
            }
        });
        String optionalString = expo.modules.calendar.extensions.CursorExtensionsKt.getOptionalString(cursor, "_id");
        String optionalString2 = expo.modules.calendar.extensions.CursorExtensionsKt.getOptionalString(cursor, "name");
        String optionalString3 = expo.modules.calendar.extensions.CursorExtensionsKt.getOptionalString(cursor, "calendar_displayName");
        boolean z = expo.modules.calendar.extensions.CursorExtensionsKt.getIntOrDefault$default(cursor, "isPrimary", 0, 2, null) == 1;
        String optionalString4 = expo.modules.calendar.extensions.CursorExtensionsKt.getOptionalString(cursor, "ownerAccount");
        String optionalString5 = expo.modules.calendar.extensions.CursorExtensionsKt.getOptionalString(cursor, "calendar_timezone");
        boolean z2 = expo.modules.calendar.extensions.CursorExtensionsKt.getIntOrDefault$default(cursor, "visible", 0, 2, null) != 0;
        boolean z3 = expo.modules.calendar.extensions.CursorExtensionsKt.getIntOrDefault$default(cursor, "sync_events", 0, 2, null) != 0;
        return new CalendarEntity(optionalString, optionalString3, Boolean.valueOf(z), valueList, optionalString2, str, optionalString4, optionalString5, valueList2, valueList3, Boolean.valueOf(z2), Boolean.valueOf(z3), CalendarAccessLevel.INSTANCE.fromContentProviderValue(intOrDefault$default), Boolean.valueOf(intOrDefault$default == 800 || intOrDefault$default == 700 || intOrDefault$default == 600 || intOrDefault$default == 500), new CalendarSource(expo.modules.calendar.extensions.CursorExtensionsKt.getOptionalString(cursor, "account_name"), expo.modules.calendar.extensions.CursorExtensionsKt.getOptionalString(cursor, "account_type")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Availability extractCalendar$lambda$0(int i) {
        return Availability.INSTANCE.fromContentProviderValue(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AlarmMethod extractCalendar$lambda$1(int i) {
        return AlarmMethod.INSTANCE.fromContentProviderValue(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AttendeeType extractCalendar$lambda$2(int i) {
        return AttendeeType.INSTANCE.fromContentProviderValue(i);
    }
}
