package com.facebook.react.defaults;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultReactActivityDelegate extends ReactActivityDelegate {
    private final boolean fabricEnabled;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultReactActivityDelegate(ReactActivity activity, String mainComponentName, boolean z) {
        super(activity, mainComponentName);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(mainComponentName, "mainComponentName");
        this.fabricEnabled = z;
    }

    @Override // com.facebook.react.ReactActivityDelegate
    protected boolean isFabricEnabled() {
        return this.fabricEnabled;
    }
}
