package expo.modules.calendar.exceptions;

import expo.modules.kotlin.exception.CodedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class AttendeeNotDeletedException extends CodedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AttendeeNotDeletedException(String message, Throwable th) {
        super("E_ATTENDEE_NOT_DELETED", message, th);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
