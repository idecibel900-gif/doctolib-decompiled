package expo.modules.location;

import expo.modules.kotlin.exception.CodedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
public final class GeocodeException extends CodedException {
    public /* synthetic */ GeocodeException(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : th);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public GeocodeException(String str, Throwable th) {
        String message;
        String str2 = "";
        str = str == null ? "" : str;
        if (th != null && (message = th.getMessage()) != null) {
            str2 = message;
        }
        super("An exception occurred when accessing the geocode: " + str + " " + str2, null, 2, null);
    }
}
