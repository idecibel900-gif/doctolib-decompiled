package expo.modules.location;

import expo.modules.kotlin.exception.CodedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class LocationRequestRejectedException extends CodedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocationRequestRejectedException(Exception cause) {
        super("Location request has been rejected: " + cause.getMessage(), null, 2, null);
        Intrinsics.checkNotNullParameter(cause, "cause");
    }
}
