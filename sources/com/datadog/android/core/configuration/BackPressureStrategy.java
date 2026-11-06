package com.datadog.android.core.configuration;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class BackPressureStrategy {
    private final BackPressureMitigation backpressureMitigation;
    private final int capacity;
    private final Function1 onItemDropped;
    private final Function0 onThresholdReached;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BackPressureStrategy)) {
            return false;
        }
        BackPressureStrategy backPressureStrategy = (BackPressureStrategy) obj;
        return this.capacity == backPressureStrategy.capacity && Intrinsics.areEqual(this.onThresholdReached, backPressureStrategy.onThresholdReached) && Intrinsics.areEqual(this.onItemDropped, backPressureStrategy.onItemDropped) && this.backpressureMitigation == backPressureStrategy.backpressureMitigation;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.capacity) * 31) + this.onThresholdReached.hashCode()) * 31) + this.onItemDropped.hashCode()) * 31) + this.backpressureMitigation.hashCode();
    }

    public String toString() {
        return "BackPressureStrategy(capacity=" + this.capacity + ", onThresholdReached=" + this.onThresholdReached + ", onItemDropped=" + this.onItemDropped + ", backpressureMitigation=" + this.backpressureMitigation + ")";
    }

    public BackPressureStrategy(int i, Function0 onThresholdReached, Function1 onItemDropped, BackPressureMitigation backpressureMitigation) {
        Intrinsics.checkNotNullParameter(onThresholdReached, "onThresholdReached");
        Intrinsics.checkNotNullParameter(onItemDropped, "onItemDropped");
        Intrinsics.checkNotNullParameter(backpressureMitigation, "backpressureMitigation");
        this.capacity = i;
        this.onThresholdReached = onThresholdReached;
        this.onItemDropped = onItemDropped;
        this.backpressureMitigation = backpressureMitigation;
    }

    public final int getCapacity() {
        return this.capacity;
    }

    public final Function0 getOnThresholdReached() {
        return this.onThresholdReached;
    }

    public final Function1 getOnItemDropped() {
        return this.onItemDropped;
    }

    public final BackPressureMitigation getBackpressureMitigation() {
        return this.backpressureMitigation;
    }
}
