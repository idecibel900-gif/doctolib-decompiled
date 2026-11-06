package expo.modules.screencapture;

import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ScreenCaptureModuleKt {
    private static final Map grantedPermissions;

    public static final Map getGrantedPermissions() {
        return grantedPermissions;
    }

    static {
        Boolean bool = Boolean.TRUE;
        grantedPermissions = MapsKt.mapOf(TuplesKt.to("canAskAgain", bool), TuplesKt.to("granted", bool), TuplesKt.to("expires", "never"), TuplesKt.to("status", "granted"));
    }
}
