package com.facebook.react.devsupport;

import android.content.Context;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.SurfaceDelegateFactory;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import com.facebook.react.devsupport.interfaces.DevLoadingViewManager;
import com.facebook.react.devsupport.interfaces.PausedInDebuggerOverlayManager;
import com.facebook.react.devsupport.interfaces.RedBoxHandler;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class BridgelessDevSupportManager extends DevSupportManagerBase {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BridgelessDevSupportManager(Context applicationContext, ReactInstanceDevHelper reactInstanceManagerHelper, String str, boolean z, RedBoxHandler redBoxHandler, DevBundleDownloadListener devBundleDownloadListener, int i, Map map, SurfaceDelegateFactory surfaceDelegateFactory, DevLoadingViewManager devLoadingViewManager, PausedInDebuggerOverlayManager pausedInDebuggerOverlayManager) {
        super(applicationContext, reactInstanceManagerHelper, str, z, redBoxHandler, devBundleDownloadListener, i, map, surfaceDelegateFactory, devLoadingViewManager, pausedInDebuggerOverlayManager);
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(reactInstanceManagerHelper, "reactInstanceManagerHelper");
    }

    @Override // com.facebook.react.devsupport.DevSupportManagerBase
    protected String getUniqueTag() {
        return "Bridgeless";
    }

    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager
    public void handleReloadJS() {
        UiThreadUtil.assertOnUiThread();
        hideRedboxDialog();
        getReactInstanceDevHelper().reload("BridgelessDevSupportManager.handleReloadJS()");
    }
}
