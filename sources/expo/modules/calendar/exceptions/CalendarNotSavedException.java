package expo.modules.calendar.exceptions;

import expo.modules.kotlin.exception.CodedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class CalendarNotSavedException extends CodedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CalendarNotSavedException(String message, Throwable th) {
        super("E_CALENDARS_NOT_SAVED", message, th);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
