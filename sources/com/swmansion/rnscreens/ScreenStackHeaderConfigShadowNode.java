package com.swmansion.rnscreens;

import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.LayoutShadowNode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ScreenStackHeaderConfigShadowNode extends LayoutShadowNode {
    private ReactContext context;

    public ScreenStackHeaderConfigShadowNode(ReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl, com.facebook.react.uimanager.ReactShadowNode
    public void setLocalData(Object obj) {
        super.setLocalData(obj);
    }
}
