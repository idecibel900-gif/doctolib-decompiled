package expo.modules.calendar.exceptions;

import expo.modules.kotlin.exception.CodedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class FieldMissingException extends CodedException {
    public /* synthetic */ FieldMissingException(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FieldMissingException(String message, Throwable th) {
        super(message, th);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
