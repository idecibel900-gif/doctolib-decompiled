package expo.modules.location;

import expo.modules.kotlin.exception.CodedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
public final class GeofencingException extends CodedException {
    public /* synthetic */ GeofencingException(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : th);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public GeofencingException(String str, Throwable th) {
        String message;
        String str2 = "";
        str = str == null ? "" : str;
        if (th != null && (message = th.getMessage()) != null) {
            str2 = message;
        }
        super("A geofencing exception has occurred: " + str + " " + str2, null, 2, null);
    }
}
