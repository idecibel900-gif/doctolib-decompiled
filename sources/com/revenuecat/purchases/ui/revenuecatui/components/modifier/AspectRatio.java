package com.revenuecat.purchases.ui.revenuecatui.components.modifier;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/modifier/AspectRatio;", "", "ratio", "", "matchHeightConstraintsFirst", "", "(FZ)V", "getMatchHeightConstraintsFirst", "()Z", "getRatio", "()F", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AspectRatio {
    public static final int $stable = 0;
    private final boolean matchHeightConstraintsFirst;
    private final float ratio;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AspectRatio)) {
            return false;
        }
        AspectRatio aspectRatio = (AspectRatio) obj;
        return Float.compare(this.ratio, aspectRatio.ratio) == 0 && this.matchHeightConstraintsFirst == aspectRatio.matchHeightConstraintsFirst;
    }

    public int hashCode() {
        return (Float.hashCode(this.ratio) * 31) + Boolean.hashCode(this.matchHeightConstraintsFirst);
    }

    public String toString() {
        return "AspectRatio(ratio=" + this.ratio + ", matchHeightConstraintsFirst=" + this.matchHeightConstraintsFirst + ')';
    }

    public AspectRatio(float f, boolean z) {
        this.ratio = f;
        this.matchHeightConstraintsFirst = z;
    }

    public final /* synthetic */ float getRatio() {
        return this.ratio;
    }

    public final /* synthetic */ boolean getMatchHeightConstraintsFirst() {
        return this.matchHeightConstraintsFirst;
    }
}
