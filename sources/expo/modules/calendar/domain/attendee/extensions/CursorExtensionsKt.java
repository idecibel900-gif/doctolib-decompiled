package expo.modules.calendar.domain.attendee.extensions;

import android.database.Cursor;
import expo.modules.calendar.domain.attendee.enums.AttendeeRole;
import expo.modules.calendar.domain.attendee.enums.AttendeeStatus;
import expo.modules.calendar.domain.attendee.enums.AttendeeType;
import expo.modules.calendar.domain.attendee.records.Attendee;
import expo.modules.calendar.exceptions.ColumnMissingException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class CursorExtensionsKt {
    public static final Attendee extractAttendee(Cursor cursor) throws ColumnMissingException {
        Intrinsics.checkNotNullParameter(cursor, "<this>");
        int intOrDefault$default = expo.modules.calendar.extensions.CursorExtensionsKt.getIntOrDefault$default(cursor, "attendeeRelationship", 0, 2, null);
        int intOrDefault$default2 = expo.modules.calendar.extensions.CursorExtensionsKt.getIntOrDefault$default(cursor, "attendeeType", 0, 2, null);
        int intOrDefault$default3 = expo.modules.calendar.extensions.CursorExtensionsKt.getIntOrDefault$default(cursor, "attendeeStatus", 0, 2, null);
        return new Attendee(expo.modules.calendar.extensions.CursorExtensionsKt.getOptionalString(cursor, "_id"), expo.modules.calendar.extensions.CursorExtensionsKt.getRequiredString(cursor, "attendeeName"), expo.modules.calendar.extensions.CursorExtensionsKt.getOptionalString(cursor, "attendeeEmail"), AttendeeRole.INSTANCE.fromContentProviderValue(intOrDefault$default), AttendeeStatus.INSTANCE.fromContentProviderValue(intOrDefault$default3), AttendeeType.INSTANCE.fromContentProviderValue(intOrDefault$default2));
    }
}
