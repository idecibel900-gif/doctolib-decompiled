package expo.modules.calendar.exceptions;

import expo.modules.kotlin.exception.CodedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class CalendarsNotFoundException extends CodedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CalendarsNotFoundException(String message, Throwable th) {
        super("E_CALENDARS_NOT_FOUND", message, th);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
