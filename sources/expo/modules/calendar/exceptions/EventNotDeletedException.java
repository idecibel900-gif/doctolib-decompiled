package expo.modules.calendar.exceptions;

import expo.modules.kotlin.exception.CodedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class EventNotDeletedException extends CodedException {
    public /* synthetic */ EventNotDeletedException(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EventNotDeletedException(String message, Throwable th) {
        super("E_EVENT_NOT_DELETED", message, th);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
