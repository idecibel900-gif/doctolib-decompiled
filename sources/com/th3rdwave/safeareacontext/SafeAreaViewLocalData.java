package com.th3rdwave.safeareacontext;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class SafeAreaViewLocalData {
    private final SafeAreaViewEdges edges;
    private final EdgeInsets insets;
    private final SafeAreaViewMode mode;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SafeAreaViewLocalData)) {
            return false;
        }
        SafeAreaViewLocalData safeAreaViewLocalData = (SafeAreaViewLocalData) obj;
        return Intrinsics.areEqual(this.insets, safeAreaViewLocalData.insets) && this.mode == safeAreaViewLocalData.mode && Intrinsics.areEqual(this.edges, safeAreaViewLocalData.edges);
    }

    public int hashCode() {
        return (((this.insets.hashCode() * 31) + this.mode.hashCode()) * 31) + this.edges.hashCode();
    }

    public String toString() {
        return "SafeAreaViewLocalData(insets=" + this.insets + ", mode=" + this.mode + ", edges=" + this.edges + ")";
    }

    public SafeAreaViewLocalData(EdgeInsets insets, SafeAreaViewMode mode, SafeAreaViewEdges edges) {
        Intrinsics.checkNotNullParameter(insets, "insets");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(edges, "edges");
        this.insets = insets;
        this.mode = mode;
        this.edges = edges;
    }

    public final EdgeInsets getInsets() {
        return this.insets;
    }

    public final SafeAreaViewMode getMode() {
        return this.mode;
    }

    public final SafeAreaViewEdges getEdges() {
        return this.edges;
    }
}
