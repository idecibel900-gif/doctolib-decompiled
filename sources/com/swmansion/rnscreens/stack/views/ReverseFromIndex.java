package com.swmansion.rnscreens.stack.views;

import java.util.Collections;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ReverseFromIndex extends ChildrenDrawingOrderStrategyBase {
    private final int startIndex;

    public ReverseFromIndex(int i) {
        super(false, 1, null);
        this.startIndex = i;
    }

    @Override // com.swmansion.rnscreens.stack.views.ChildrenDrawingOrderStrategy
    public void apply(List drawingOperations) {
        Intrinsics.checkNotNullParameter(drawingOperations, "drawingOperations");
        if (isEnabled()) {
            int i = this.startIndex;
            for (int lastIndex = CollectionsKt.getLastIndex(drawingOperations); i < lastIndex; lastIndex--) {
                Collections.swap(drawingOperations, i, lastIndex);
                i++;
            }
        }
    }
}
