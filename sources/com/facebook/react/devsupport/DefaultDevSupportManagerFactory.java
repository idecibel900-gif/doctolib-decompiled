package com.facebook.react.devsupport;

import android.content.Context;
import com.facebook.react.common.SurfaceDelegateFactory;
import com.facebook.react.common.build.ReactBuildConfig;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import com.facebook.react.devsupport.interfaces.DevLoadingViewManager;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.devsupport.interfaces.PausedInDebuggerOverlayManager;
import com.facebook.react.devsupport.interfaces.RedBoxHandler;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DefaultDevSupportManagerFactory implements DevSupportManagerFactory {
    private static final Companion Companion = new Companion(null);

    @Override // com.facebook.react.devsupport.DevSupportManagerFactory
    public DevSupportManager create(Context applicationContext, ReactInstanceDevHelper reactInstanceManagerHelper, String str, boolean z, RedBoxHandler redBoxHandler, DevBundleDownloadListener devBundleDownloadListener, int i, Map map, SurfaceDelegateFactory surfaceDelegateFactory, DevLoadingViewManager devLoadingViewManager, PausedInDebuggerOverlayManager pausedInDebuggerOverlayManager) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(reactInstanceManagerHelper, "reactInstanceManagerHelper");
        if (!z) {
            return new ReleaseDevSupportManager();
        }
        try {
            String str2 = "com.facebook.react.devsupport.BridgeDevSupportManager";
            Intrinsics.checkNotNullExpressionValue(str2, "toString(...)");
            Object objNewInstance = Class.forName(str2).getConstructor(Context.class, ReactInstanceDevHelper.class, String.class, Boolean.TYPE, RedBoxHandler.class, DevBundleDownloadListener.class, Integer.TYPE, Map.class, SurfaceDelegateFactory.class, DevLoadingViewManager.class, PausedInDebuggerOverlayManager.class).newInstance(applicationContext, reactInstanceManagerHelper, str, Boolean.TRUE, redBoxHandler, devBundleDownloadListener, Integer.valueOf(i), map, surfaceDelegateFactory, devLoadingViewManager, pausedInDebuggerOverlayManager);
            Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type com.facebook.react.devsupport.interfaces.DevSupportManager");
            return (DevSupportManager) objNewInstance;
        } catch (Exception unused) {
            return new PerftestDevSupportManager(applicationContext);
        }
    }

    @Override // com.facebook.react.devsupport.DevSupportManagerFactory
    public DevSupportManager create(Context applicationContext, ReactInstanceDevHelper reactInstanceManagerHelper, String str, boolean z, RedBoxHandler redBoxHandler, DevBundleDownloadListener devBundleDownloadListener, int i, Map map, SurfaceDelegateFactory surfaceDelegateFactory, DevLoadingViewManager devLoadingViewManager, PausedInDebuggerOverlayManager pausedInDebuggerOverlayManager, boolean z2) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(reactInstanceManagerHelper, "reactInstanceManagerHelper");
        if (ReactBuildConfig.UNSTABLE_ENABLE_FUSEBOX_RELEASE) {
            return new PerftestDevSupportManager(applicationContext);
        }
        if (z2) {
            return new BridgelessDevSupportManager(applicationContext, reactInstanceManagerHelper, str, z, redBoxHandler, devBundleDownloadListener, i, map, surfaceDelegateFactory, devLoadingViewManager, pausedInDebuggerOverlayManager);
        }
        return new ReleaseDevSupportManager();
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
