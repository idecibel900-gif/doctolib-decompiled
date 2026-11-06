package expo.modules.calendar.exceptions;

import expo.modules.kotlin.exception.CodedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class EventNotSavedException extends CodedException {
    public /* synthetic */ EventNotSavedException(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "Event could not be saved" : str, (i & 2) != 0 ? null : th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EventNotSavedException(String message, Throwable th) {
        super("E_EVENT_NOT_SAVED", message, th);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
