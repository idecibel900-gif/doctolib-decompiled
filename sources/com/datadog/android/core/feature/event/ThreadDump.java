package com.datadog.android.core.feature.event;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ThreadDump {
    private final boolean crashed;
    private final String name;
    private final String stack;
    private final String state;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ThreadDump)) {
            return false;
        }
        ThreadDump threadDump = (ThreadDump) obj;
        return Intrinsics.areEqual(this.name, threadDump.name) && Intrinsics.areEqual(this.state, threadDump.state) && Intrinsics.areEqual(this.stack, threadDump.stack) && this.crashed == threadDump.crashed;
    }

    public int hashCode() {
        return (((((this.name.hashCode() * 31) + this.state.hashCode()) * 31) + this.stack.hashCode()) * 31) + Boolean.hashCode(this.crashed);
    }

    public String toString() {
        return "ThreadDump(name=" + this.name + ", state=" + this.state + ", stack=" + this.stack + ", crashed=" + this.crashed + ")";
    }

    public ThreadDump(String name, String state, String stack, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(stack, "stack");
        this.name = name;
        this.state = state;
        this.stack = stack;
        this.crashed = z;
    }

    public final String getName() {
        return this.name;
    }

    public final String getState() {
        return this.state;
    }

    public final String getStack() {
        return this.stack;
    }

    public final boolean getCrashed() {
        return this.crashed;
    }
}
