package expo.modules.devlauncher;

import android.content.Context;
import com.facebook.react.bridge.ReactApplicationContext;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class DevLauncherPackageDelegate {
    public static final DevLauncherPackageDelegate INSTANCE = new DevLauncherPackageDelegate();

    private DevLauncherPackageDelegate() {
    }

    public final List createNativeModules(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return CollectionsKt.emptyList();
    }

    public final List createApplicationLifecycleListeners(Context context) {
        return CollectionsKt.emptyList();
    }

    public final List createReactActivityLifecycleListeners(Context context) {
        return CollectionsKt.emptyList();
    }

    public final List createReactActivityHandlers(Context context) {
        return CollectionsKt.emptyList();
    }

    public final List createReactNativeHostHandlers(Context context) {
        return CollectionsKt.emptyList();
    }
}
