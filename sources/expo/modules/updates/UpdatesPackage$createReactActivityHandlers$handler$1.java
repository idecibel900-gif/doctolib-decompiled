package expo.modules.updates;

import android.content.Context;
import com.facebook.react.ReactActivity;
import com.facebook.react.ReactHost;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import expo.modules.core.interfaces.ReactActivityHandler;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes4.dex */
public final class UpdatesPackage$createReactActivityHandlers$handler$1 implements ReactActivityHandler {
    UpdatesPackage$createReactActivityHandlers$handler$1() {
    }

    @Override // expo.modules.core.interfaces.ReactActivityHandler
    public ReactActivityHandler.DelayLoadAppHandler getDelayLoadAppHandler(ReactActivity activity, ReactHost reactHost) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(reactHost, "reactHost");
        UpdatesPackage.Companion companion = UpdatesPackage.INSTANCE;
        if (companion.isUsingCustomInit$expo_updates_release()) {
            return null;
        }
        final Context applicationContext = activity.getApplicationContext();
        DevSupportManager devSupportManager = reactHost.getDevSupportManager();
        final boolean devSupportEnabled = devSupportManager != null ? devSupportManager.getDevSupportEnabled() : false;
        if (!devSupportEnabled || companion.isUsingNativeDebug()) {
            return new ReactActivityHandler.DelayLoadAppHandler() { // from class: expo.modules.updates.UpdatesPackage$createReactActivityHandlers$handler$1$$ExternalSyntheticLambda0
                @Override // expo.modules.core.interfaces.ReactActivityHandler.DelayLoadAppHandler
                public final void whenReady(Runnable runnable) {
                    UpdatesPackage$createReactActivityHandlers$handler$1.getDelayLoadAppHandler$lambda$0(this.f$0, applicationContext, devSupportEnabled, runnable);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getDelayLoadAppHandler$lambda$0(UpdatesPackage$createReactActivityHandlers$handler$1 updatesPackage$createReactActivityHandlers$handler$1, Context context, boolean z, Runnable runnable) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new UpdatesPackage$createReactActivityHandlers$handler$1$getDelayLoadAppHandler$1$1(updatesPackage$createReactActivityHandlers$handler$1, context, z, runnable, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object startUpdatesController(Context context, boolean z, Continuation continuation) {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new UpdatesPackage$createReactActivityHandlers$handler$1$startUpdatesController$2(context, z, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object invokeReadyRunnable(Runnable runnable, Continuation continuation) {
        Object objWithContext = BuildersKt.withContext(Dispatchers.getMain(), new UpdatesPackage$createReactActivityHandlers$handler$1$invokeReadyRunnable$2(runnable, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }
}
