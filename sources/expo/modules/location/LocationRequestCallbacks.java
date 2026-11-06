package expo.modules.location;

import android.location.Location;
import expo.modules.kotlin.exception.CodedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public interface LocationRequestCallbacks {

    public static final class DefaultImpls {
        public static void onLocationError(LocationRequestCallbacks locationRequestCallbacks, CodedException cause) {
            Intrinsics.checkNotNullParameter(cause, "cause");
        }
    }

    void onLocationChanged(Location location);

    void onLocationError(CodedException codedException);

    void onRequestFailed(CodedException codedException);

    void onRequestSuccess();
}
