package com.facebook.react;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.queue.ReactQueueConfiguration;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.devsupport.DevMenuConfiguration;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.interfaces.TaskInterface;
import com.facebook.react.interfaces.fabric.ReactSurface;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.google.firebase.messaging.Constants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\n\u0010\fJ\u0019\u0010\r\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\r\u0010\fJ\u0019\u0010\u000e\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\u000e\u001a\u00020\tH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\tH&¢\u0006\u0004\b\u0010\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0010\u0010\fJ)\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH&¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001e\u001a\u00020\u0013H&¢\u0006\u0004\b\u001f\u0010 J-\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001e\u001a\u00020\u00132\u000e\u0010#\u001a\n\u0018\u00010!j\u0004\u0018\u0001`\"H&¢\u0006\u0004\b$\u0010%JC\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001e\u001a\u00020\u00132\u000e\u0010#\u001a\n\u0018\u00010!j\u0004\u0018\u0001`\"2\u0014\b\u0002\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0&H&¢\u0006\u0004\b$\u0010(J\u000f\u0010)\u001a\u00020\tH&¢\u0006\u0004\b)\u0010\u000fJ1\u0010/\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*2\b\u0010.\u001a\u0004\u0018\u00010-H&¢\u0006\u0004\b/\u00100J\u0017\u00102\u001a\u00020\t2\u0006\u00101\u001a\u00020\u0002H&¢\u0006\u0004\b2\u00103J\u0017\u00105\u001a\u00020\t2\u0006\u00104\u001a\u00020-H&¢\u0006\u0004\b5\u00106J\u0017\u00107\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b7\u00108J\u001d\u0010;\u001a\u00020\t2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\t09H&¢\u0006\u0004\b;\u0010<J\u001d\u0010=\u001a\u00020\t2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\t09H&¢\u0006\u0004\b=\u0010<J\u0017\u0010@\u001a\u00020\t2\u0006\u0010?\u001a\u00020>H&¢\u0006\u0004\b@\u0010AJ\u0017\u0010B\u001a\u00020\t2\u0006\u0010?\u001a\u00020>H&¢\u0006\u0004\bB\u0010AJ\u0017\u0010E\u001a\u00020\t2\u0006\u0010D\u001a\u00020CH\u0016¢\u0006\u0004\bE\u0010FJ\u0017\u0010H\u001a\u00020\t2\u0006\u0010G\u001a\u00020\u0013H\u0016¢\u0006\u0004\bH\u0010IJM\u0010H\u001a\u00020\t2\u0006\u0010J\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132,\b\u0002\u0010L\u001a&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130K\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130K0&H\u0016¢\u0006\u0004\bH\u0010MR\u0014\u0010Q\u001a\u00020N8&X¦\u0004¢\u0006\u0006\u001a\u0004\bO\u0010PR\u0016\u0010U\u001a\u0004\u0018\u00010R8&X¦\u0004¢\u0006\u0006\u001a\u0004\bS\u0010TR\u0016\u0010Y\u001a\u0004\u0018\u00010V8&X¦\u0004¢\u0006\u0006\u001a\u0004\bW\u0010XR\u0016\u0010]\u001a\u0004\u0018\u00010Z8&X¦\u0004¢\u0006\u0006\u001a\u0004\b[\u0010\\R\u0014\u0010a\u001a\u00020^8&X¦\u0004¢\u0006\u0006\u001a\u0004\b_\u0010`ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006bÀ\u0006\u0001"}, d2 = {"Lcom/facebook/react/ReactHost;", "", "", "onBackPressed", "()Z", "Landroid/app/Activity;", "activity", "Lcom/facebook/react/modules/core/DefaultHardwareBackBtnHandler;", "defaultBackButtonImpl", "", "onHostResume", "(Landroid/app/Activity;Lcom/facebook/react/modules/core/DefaultHardwareBackBtnHandler;)V", "(Landroid/app/Activity;)V", "onHostLeaveHint", "onHostPause", "()V", "onHostDestroy", "Landroid/content/Context;", "context", "", "moduleName", "Landroid/os/Bundle;", "initialProps", "Lcom/facebook/react/interfaces/fabric/ReactSurface;", "createSurface", "(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)Lcom/facebook/react/interfaces/fabric/ReactSurface;", "Lcom/facebook/react/interfaces/TaskInterface;", "Ljava/lang/Void;", "start", "()Lcom/facebook/react/interfaces/TaskInterface;", "reason", "reload", "(Ljava/lang/String;)Lcom/facebook/react/interfaces/TaskInterface;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "ex", "destroy", "(Ljava/lang/String;Ljava/lang/Exception;)Lcom/facebook/react/interfaces/TaskInterface;", "Lkotlin/Function1;", "onDestroyFinished", "(Ljava/lang/String;Ljava/lang/Exception;Lkotlin/jvm/functions/Function1;)Lcom/facebook/react/interfaces/TaskInterface;", "invalidate", "", "requestCode", "resultCode", "Landroid/content/Intent;", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "onActivityResult", "(Landroid/app/Activity;IILandroid/content/Intent;)V", "hasFocus", "onWindowFocusChange", "(Z)V", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "onConfigurationChanged", "(Landroid/content/Context;)V", "Lkotlin/Function0;", "onBeforeDestroy", "addBeforeDestroyListener", "(Lkotlin/jvm/functions/Function0;)V", "removeBeforeDestroyListener", "Lcom/facebook/react/ReactInstanceEventListener;", "listener", "addReactInstanceEventListener", "(Lcom/facebook/react/ReactInstanceEventListener;)V", "removeReactInstanceEventListener", "Lcom/facebook/react/devsupport/DevMenuConfiguration;", "config", "setDevMenuConfiguration", "(Lcom/facebook/react/devsupport/DevMenuConfiguration;)V", "filePath", "setBundleSource", "(Ljava/lang/String;)V", "debugServerHost", "", "queryMapper", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "Lcom/facebook/react/common/LifecycleState;", "getLifecycleState", "()Lcom/facebook/react/common/LifecycleState;", "lifecycleState", "Lcom/facebook/react/bridge/ReactContext;", "getCurrentReactContext", "()Lcom/facebook/react/bridge/ReactContext;", "currentReactContext", "Lcom/facebook/react/devsupport/interfaces/DevSupportManager;", "getDevSupportManager", "()Lcom/facebook/react/devsupport/interfaces/DevSupportManager;", "devSupportManager", "Lcom/facebook/react/bridge/queue/ReactQueueConfiguration;", "getReactQueueConfiguration", "()Lcom/facebook/react/bridge/queue/ReactQueueConfiguration;", "reactQueueConfiguration", "Lcom/facebook/react/MemoryPressureRouter;", "getMemoryPressureRouter", "()Lcom/facebook/react/MemoryPressureRouter;", "memoryPressureRouter", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ReactHost {
    /* JADX INFO: Access modifiers changed from: private */
    static Map setBundleSource$lambda$1(Map it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it;
    }

    void addBeforeDestroyListener(Function0 onBeforeDestroy);

    void addReactInstanceEventListener(ReactInstanceEventListener listener);

    ReactSurface createSurface(Context context, String moduleName, Bundle initialProps);

    TaskInterface destroy(String reason, Exception ex);

    TaskInterface destroy(String reason, Exception ex, Function1 onDestroyFinished);

    ReactContext getCurrentReactContext();

    DevSupportManager getDevSupportManager();

    LifecycleState getLifecycleState();

    MemoryPressureRouter getMemoryPressureRouter();

    ReactQueueConfiguration getReactQueueConfiguration();

    void invalidate();

    void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data);

    boolean onBackPressed();

    void onConfigurationChanged(Context context);

    void onHostDestroy();

    void onHostDestroy(Activity activity);

    void onHostLeaveHint(Activity activity);

    void onHostPause();

    void onHostPause(Activity activity);

    void onHostResume(Activity activity);

    void onHostResume(Activity activity, DefaultHardwareBackBtnHandler defaultBackButtonImpl);

    void onNewIntent(Intent intent);

    void onWindowFocusChange(boolean hasFocus);

    TaskInterface reload(String reason);

    void removeBeforeDestroyListener(Function0 onBeforeDestroy);

    void removeReactInstanceEventListener(ReactInstanceEventListener listener);

    default void setBundleSource(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
    }

    default void setBundleSource(String debugServerHost, String moduleName, Function1 queryMapper) {
        Intrinsics.checkNotNullParameter(debugServerHost, "debugServerHost");
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNullParameter(queryMapper, "queryMapper");
    }

    default void setDevMenuConfiguration(DevMenuConfiguration config) {
        Intrinsics.checkNotNullParameter(config, "config");
    }

    TaskInterface start();

    static /* synthetic */ TaskInterface destroy$default(ReactHost reactHost, String str, Exception exc, Function1 function1, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: destroy");
        }
        if ((i & 4) != 0) {
            function1 = new Function1() { // from class: com.facebook.react.ReactHost$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return ReactHost.destroy$lambda$0(((Boolean) obj2).booleanValue());
                }
            };
        }
        return reactHost.destroy(str, exc, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static Unit destroy$lambda$0(boolean z) {
        return Unit.INSTANCE;
    }

    static /* synthetic */ void setBundleSource$default(ReactHost reactHost, String str, String str2, Function1 function1, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setBundleSource");
        }
        if ((i & 4) != 0) {
            function1 = new Function1() { // from class: com.facebook.react.ReactHost$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return ReactHost.setBundleSource$lambda$1((Map) obj2);
                }
            };
        }
        reactHost.setBundleSource(str, str2, function1);
    }
}
