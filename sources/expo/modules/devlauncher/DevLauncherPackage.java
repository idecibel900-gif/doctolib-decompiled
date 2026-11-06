package expo.modules.devlauncher;

import android.content.Context;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.ReactApplicationContext;
import expo.modules.core.interfaces.Package;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\u001e\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000b0\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0016J\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0016J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0017"}, d2 = {"Lexpo/modules/devlauncher/DevLauncherPackage;", "Lexpo/modules/core/interfaces/Package;", "Lcom/facebook/react/ReactPackage;", "<init>", "()V", "createNativeModules", "", "Lcom/facebook/react/bridge/NativeModule;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "createViewManagers", "Lcom/facebook/react/uimanager/ViewManager;", "createApplicationLifecycleListeners", "Lexpo/modules/core/interfaces/ApplicationLifecycleListener;", "context", "Landroid/content/Context;", "createReactActivityLifecycleListeners", "Lexpo/modules/core/interfaces/ReactActivityLifecycleListener;", "activityContext", "createReactActivityHandlers", "Lexpo/modules/core/interfaces/ReactActivityHandler;", "createReactNativeHostHandlers", "Lexpo/modules/core/interfaces/ReactNativeHostHandler;", "expo-dev-launcher_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DevLauncherPackage implements Package, ReactPackage {
    @Override // com.facebook.react.ReactPackage
    public List createNativeModules(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return DevLauncherPackageDelegate.INSTANCE.createNativeModules(reactContext);
    }

    @Override // com.facebook.react.ReactPackage
    public List createViewManagers(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return CollectionsKt.emptyList();
    }

    @Override // expo.modules.core.interfaces.Package
    public List createApplicationLifecycleListeners(Context context) {
        return DevLauncherPackageDelegate.INSTANCE.createApplicationLifecycleListeners(context);
    }

    @Override // expo.modules.core.interfaces.Package
    public List createReactActivityLifecycleListeners(Context activityContext) {
        return DevLauncherPackageDelegate.INSTANCE.createReactActivityLifecycleListeners(activityContext);
    }

    @Override // expo.modules.core.interfaces.Package
    public List createReactActivityHandlers(Context activityContext) {
        return DevLauncherPackageDelegate.INSTANCE.createReactActivityHandlers(activityContext);
    }

    @Override // expo.modules.core.interfaces.Package
    public List createReactNativeHostHandlers(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DevLauncherPackageDelegate.INSTANCE.createReactNativeHostHandlers(context);
    }
}
