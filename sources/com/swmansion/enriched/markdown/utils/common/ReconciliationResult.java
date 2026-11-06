package com.swmansion.enriched.markdown.utils.common;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ReconciliationResult {
    private final List signatures;
    private final List views;
    private final List viewsToAttach;
    private final List viewsToRemove;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReconciliationResult)) {
            return false;
        }
        ReconciliationResult reconciliationResult = (ReconciliationResult) obj;
        return Intrinsics.areEqual(this.views, reconciliationResult.views) && Intrinsics.areEqual(this.signatures, reconciliationResult.signatures) && Intrinsics.areEqual(this.viewsToRemove, reconciliationResult.viewsToRemove) && Intrinsics.areEqual(this.viewsToAttach, reconciliationResult.viewsToAttach);
    }

    public int hashCode() {
        return (((((this.views.hashCode() * 31) + this.signatures.hashCode()) * 31) + this.viewsToRemove.hashCode()) * 31) + this.viewsToAttach.hashCode();
    }

    public String toString() {
        return "ReconciliationResult(views=" + this.views + ", signatures=" + this.signatures + ", viewsToRemove=" + this.viewsToRemove + ", viewsToAttach=" + this.viewsToAttach + ")";
    }

    public ReconciliationResult(List views, List signatures, List viewsToRemove, List viewsToAttach) {
        Intrinsics.checkNotNullParameter(views, "views");
        Intrinsics.checkNotNullParameter(signatures, "signatures");
        Intrinsics.checkNotNullParameter(viewsToRemove, "viewsToRemove");
        Intrinsics.checkNotNullParameter(viewsToAttach, "viewsToAttach");
        this.views = views;
        this.signatures = signatures;
        this.viewsToRemove = viewsToRemove;
        this.viewsToAttach = viewsToAttach;
    }

    public final List getViews() {
        return this.views;
    }

    public final List getSignatures() {
        return this.signatures;
    }

    public final List getViewsToRemove() {
        return this.viewsToRemove;
    }

    public final List getViewsToAttach() {
        return this.viewsToAttach;
    }
}
