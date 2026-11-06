package expo.modules.calendar.next.exceptions;

import expo.modules.kotlin.exception.CodedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class AttendeeCouldNotBeCreatedException extends CodedException {
    public /* synthetic */ AttendeeCouldNotBeCreatedException(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AttendeeCouldNotBeCreatedException(String message, Throwable th) {
        super(message, th);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
