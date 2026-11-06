package com.swmansion.rnscreens.stack.views;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface ChildrenDrawingOrderStrategy {
    void apply(List list);

    void disable();

    void enable();
}
