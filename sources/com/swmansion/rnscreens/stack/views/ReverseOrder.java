package com.swmansion.rnscreens.stack.views;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ReverseOrder extends ChildrenDrawingOrderStrategyBase {
    public ReverseOrder() {
        super(false, 1, null);
    }

    @Override // com.swmansion.rnscreens.stack.views.ChildrenDrawingOrderStrategy
    public void apply(List drawingOperations) {
        Intrinsics.checkNotNullParameter(drawingOperations, "drawingOperations");
        if (isEnabled()) {
            CollectionsKt.reverse(drawingOperations);
        }
    }
}
