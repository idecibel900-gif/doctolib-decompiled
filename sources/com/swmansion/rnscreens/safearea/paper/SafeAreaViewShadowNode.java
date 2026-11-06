package com.swmansion.rnscreens.safearea.paper;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.NativeViewHierarchyOptimizer;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class SafeAreaViewShadowNode extends LayoutShadowNode {
    private final float[] margins;
    private boolean needsUpdate;

    private final void updateInsets() {
    }

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl, com.facebook.react.uimanager.ReactShadowNode
    public void setLocalData(Object data) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    public SafeAreaViewShadowNode() {
        int[] iArr = ViewProps.PADDING_MARGIN_SPACING_TYPES;
        this.margins = new float[iArr.length];
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            this.margins[i] = Float.NaN;
        }
    }

    @Override // com.facebook.react.uimanager.ReactShadowNodeImpl, com.facebook.react.uimanager.ReactShadowNode
    public void onBeforeLayout(NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer) {
        Intrinsics.checkNotNullParameter(nativeViewHierarchyOptimizer, "nativeViewHierarchyOptimizer");
        if (this.needsUpdate) {
            this.needsUpdate = false;
            updateInsets();
        }
    }

    @Override // com.facebook.react.uimanager.LayoutShadowNode
    @ReactPropGroup(names = {"margin", "marginVertical", "marginHorizontal", "marginStart", "marginEnd", "marginTop", "marginBottom", "marginLeft", "marginRight"})
    public void setMargins(int i, Dynamic margin) {
        Intrinsics.checkNotNullParameter(margin, "margin");
        this.margins[ViewProps.PADDING_MARGIN_SPACING_TYPES[i]] = margin.getType() == ReadableType.Number ? (float) margin.asDouble() : Float.NaN;
        super.setMargins(i, margin);
        this.needsUpdate = true;
    }
}
