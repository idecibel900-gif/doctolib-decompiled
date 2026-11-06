package com.revenuecat.purchases.ui.revenuecatui.components.countdown;

import com.opentok.android.PublisherKit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/countdown/CountdownState;", "", "countdownTime", "Lcom/revenuecat/purchases/ui/revenuecatui/components/countdown/CountdownTime;", "hasEnded", "", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/countdown/CountdownTime;Z)V", "getCountdownTime", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/countdown/CountdownTime;", "getHasEnded", "()Z", "component1", "component2", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CountdownState {
    public static final int $stable = 0;
    private final CountdownTime countdownTime;
    private final boolean hasEnded;

    public static /* synthetic */ CountdownState copy$default(CountdownState countdownState, CountdownTime countdownTime, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            countdownTime = countdownState.countdownTime;
        }
        if ((i & 2) != 0) {
            z = countdownState.hasEnded;
        }
        return countdownState.copy(countdownTime, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CountdownTime getCountdownTime() {
        return this.countdownTime;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getHasEnded() {
        return this.hasEnded;
    }

    public final CountdownState copy(CountdownTime countdownTime, boolean hasEnded) {
        Intrinsics.checkNotNullParameter(countdownTime, "countdownTime");
        return new CountdownState(countdownTime, hasEnded);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CountdownState)) {
            return false;
        }
        CountdownState countdownState = (CountdownState) other;
        return Intrinsics.areEqual(this.countdownTime, countdownState.countdownTime) && this.hasEnded == countdownState.hasEnded;
    }

    public int hashCode() {
        return (this.countdownTime.hashCode() * 31) + Boolean.hashCode(this.hasEnded);
    }

    public String toString() {
        return "CountdownState(countdownTime=" + this.countdownTime + ", hasEnded=" + this.hasEnded + ')';
    }

    public CountdownState(CountdownTime countdownTime, boolean z) {
        Intrinsics.checkNotNullParameter(countdownTime, "countdownTime");
        this.countdownTime = countdownTime;
        this.hasEnded = z;
    }

    public final CountdownTime getCountdownTime() {
        return this.countdownTime;
    }

    public final boolean getHasEnded() {
        return this.hasEnded;
    }
}
