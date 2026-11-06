package expo.modules.updates;

import android.app.Application;
import android.content.Context;
import com.facebook.react.ReactHost;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import expo.modules.core.interfaces.ApplicationLifecycleListener;
import expo.modules.core.interfaces.Package;
import expo.modules.core.interfaces.ReactNativeHostHandler;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0002¨\u0006\u0011"}, d2 = {"Lexpo/modules/updates/UpdatesPackage;", "Lexpo/modules/core/interfaces/Package;", "<init>", "()V", "createReactNativeHostHandlers", "", "Lexpo/modules/core/interfaces/ReactNativeHostHandler;", "context", "Landroid/content/Context;", "createReactActivityHandlers", "Lexpo/modules/core/interfaces/ReactActivityHandler;", "activityContext", "createApplicationLifecycleListeners", "Lexpo/modules/core/interfaces/ApplicationLifecycleListener;", "isRunningAndroidTest", "", "Companion", "expo-updates_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UpdatesPackage implements Package {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = UpdatesPackage.class.getSimpleName();
    private static final boolean isUsingCustomInit = false;
    private static final boolean isUsingNativeDebug = false;

    @Override // expo.modules.core.interfaces.Package
    public List createReactNativeHostHandlers(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return CollectionsKt.listOf(new ReactNativeHostHandler() { // from class: expo.modules.updates.UpdatesPackage$createReactNativeHostHandlers$handler$1
            @Override // expo.modules.core.interfaces.ReactNativeHostHandler
            public String getJSBundleFile(boolean z) {
                if (UpdatesController.getInstance().isActiveController()) {
                    return UpdatesController.getInstance().getLaunchAssetFile();
                }
                return null;
            }

            @Override // expo.modules.core.interfaces.ReactNativeHostHandler
            public String getBundleAssetName(boolean z) {
                if (UpdatesController.getInstance().isActiveController()) {
                    return UpdatesController.getInstance().getBundleAssetName();
                }
                return null;
            }

            @Override // expo.modules.core.interfaces.ReactNativeHostHandler
            public void onWillCreateReactInstance(boolean z) {
                UpdatesController.initialize(context, z);
            }

            @Override // expo.modules.core.interfaces.ReactNativeHostHandler
            public void onDidCreateReactHost(Context context2, ReactHost reactNativeHost) {
                Intrinsics.checkNotNullParameter(context2, "context");
                Intrinsics.checkNotNullParameter(reactNativeHost, "reactNativeHost");
                UpdatesController.getInstance().setReactHost(new WeakReference(reactNativeHost));
            }

            @Override // expo.modules.core.interfaces.ReactNativeHostHandler
            public void onDidCreateDevSupportManager(DevSupportManager devSupportManager) {
                Intrinsics.checkNotNullParameter(devSupportManager, "devSupportManager");
                UpdatesController.getInstance().onDidCreateDevSupportManager(devSupportManager);
            }

            @Override // expo.modules.core.interfaces.ReactNativeHostHandler
            public void onDidCreateReactInstance(boolean z, ReactContext reactContext) {
                Intrinsics.checkNotNullParameter(reactContext, "reactContext");
                UpdatesController.getInstance().onDidCreateReactInstance(reactContext);
            }

            @Override // expo.modules.core.interfaces.ReactNativeHostHandler
            public void onReactInstanceException(boolean z, Exception exception) {
                Intrinsics.checkNotNullParameter(exception, "exception");
                UpdatesController.getInstance().onReactInstanceException(exception);
            }
        });
    }

    @Override // expo.modules.core.interfaces.Package
    public List createReactActivityHandlers(Context activityContext) {
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        return CollectionsKt.listOf(new UpdatesPackage$createReactActivityHandlers$handler$1());
    }

    @Override // expo.modules.core.interfaces.Package
    public List createApplicationLifecycleListeners(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return CollectionsKt.listOf(new ApplicationLifecycleListener() { // from class: expo.modules.updates.UpdatesPackage$createApplicationLifecycleListeners$handler$1
            @Override // expo.modules.core.interfaces.ApplicationLifecycleListener
            public void onCreate(Application application) {
                Intrinsics.checkNotNullParameter(application, "application");
                super.onCreate(application);
                if (this.this$0.isRunningAndroidTest()) {
                    UpdatesController.initialize$default(context, false, 2, null);
                    UpdatesController.getInstance().getLaunchAssetFile();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isRunningAndroidTest() {
        try {
            Class.forName("androidx.test.espresso.Espresso");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isUsingNativeDebug() {
            return UpdatesPackage.isUsingNativeDebug;
        }

        public final boolean isUsingCustomInit$expo_updates_release() {
            return UpdatesPackage.isUsingCustomInit;
        }
    }
}
