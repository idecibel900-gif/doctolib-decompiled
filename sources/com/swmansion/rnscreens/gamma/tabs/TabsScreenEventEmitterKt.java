package com.swmansion.rnscreens.gamma.tabs;

import com.swmansion.rnscreens.utils.RNSLog;

/* JADX INFO: loaded from: classes4.dex */
public abstract class TabsScreenEventEmitterKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void logEventDispatch(int i, String str) {
        RNSLog.INSTANCE.d("TabsScreenEventEmitter", "TabsScreen [" + i + "] emits event: " + str);
    }
}
