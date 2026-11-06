package com.facebook.react.views.scroll;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
final class IntervalNode {
    private int height;
    private Interval interval;
    private IntervalNode left;
    private int max;
    private IntervalNode right;
    private VirtualView virtualView;

    public IntervalNode(Interval interval, VirtualView virtualView, int i, int i2, IntervalNode intervalNode, IntervalNode intervalNode2) {
        Intrinsics.checkNotNullParameter(interval, "interval");
        Intrinsics.checkNotNullParameter(virtualView, "virtualView");
        this.interval = interval;
        this.virtualView = virtualView;
        this.max = i;
        this.height = i2;
        this.left = intervalNode;
        this.right = intervalNode2;
    }

    public final Interval getInterval() {
        return this.interval;
    }

    public final void setInterval(Interval interval) {
        Intrinsics.checkNotNullParameter(interval, "<set-?>");
        this.interval = interval;
    }

    public final VirtualView getVirtualView() {
        return this.virtualView;
    }

    public final void setVirtualView(VirtualView virtualView) {
        Intrinsics.checkNotNullParameter(virtualView, "<set-?>");
        this.virtualView = virtualView;
    }

    public /* synthetic */ IntervalNode(Interval interval, VirtualView virtualView, int i, int i2, IntervalNode intervalNode, IntervalNode intervalNode2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(interval, virtualView, (i3 & 4) != 0 ? interval.getEnd() : i, (i3 & 8) != 0 ? 1 : i2, (i3 & 16) != 0 ? null : intervalNode, (i3 & 32) != 0 ? null : intervalNode2);
    }

    public final int getMax() {
        return this.max;
    }

    public final void setMax(int i) {
        this.max = i;
    }

    public final int getHeight() {
        return this.height;
    }

    public final void setHeight(int i) {
        this.height = i;
    }

    public final IntervalNode getLeft() {
        return this.left;
    }

    public final void setLeft(IntervalNode intervalNode) {
        this.left = intervalNode;
    }

    public final IntervalNode getRight() {
        return this.right;
    }

    public final void setRight(IntervalNode intervalNode) {
        this.right = intervalNode;
    }
}
