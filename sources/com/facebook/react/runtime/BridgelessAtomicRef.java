package com.facebook.react.runtime;

import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class BridgelessAtomicRef {
    private volatile String failureMessage;
    private Object initialValue;
    private volatile State state;
    private volatile Object value;

    public interface Provider {
        Object get();
    }

    public enum State {
        Init,
        Creating,
        Success,
        Failure;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    }

    public BridgelessAtomicRef(Object obj) {
        this.value = obj;
        this.initialValue = this.value;
        this.state = State.Init;
        this.failureMessage = "";
    }

    public /* synthetic */ BridgelessAtomicRef(Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : obj);
    }

    public final synchronized Object getNullable() {
        return this.value;
    }

    public final Object getOrCreate(Provider provider) {
        boolean z;
        Object obj;
        Object obj2;
        Intrinsics.checkNotNullParameter(provider, "provider");
        synchronized (this) {
            State state = this.state;
            State state2 = State.Success;
            if (state == state2) {
                return get();
            }
            if (this.state == State.Failure) {
                throw new RuntimeException("BridgelessAtomicRef: Failed to create object. Reason: " + this.failureMessage);
            }
            State state3 = this.state;
            State state4 = State.Creating;
            boolean z2 = false;
            if (state3 != state4) {
                this.state = state4;
                z = true;
            } else {
                z = false;
            }
            Unit unit = Unit.INSTANCE;
            if (z) {
                try {
                    this.value = provider.get();
                    synchronized (this) {
                        this.state = state2;
                        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
                        notifyAll();
                        obj = get();
                    }
                    return obj;
                } catch (RuntimeException e) {
                    synchronized (this) {
                        this.state = State.Failure;
                        this.failureMessage = String.valueOf(e.getMessage());
                        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
                        notifyAll();
                        Unit unit2 = Unit.INSTANCE;
                        throw new RuntimeException("BridgelessAtomicRef: Failed to create object.", e);
                    }
                }
            }
            synchronized (this) {
                while (this.state == State.Creating) {
                    try {
                        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
                        wait();
                    } catch (InterruptedException unused) {
                        z2 = true;
                    }
                }
                if (z2) {
                    Thread.currentThread().interrupt();
                }
                if (this.state == State.Failure) {
                    throw new RuntimeException("BridgelessAtomicRef: Failed to create object. Reason: " + this.failureMessage);
                }
                obj2 = get();
            }
            return obj2;
        }
    }

    public final synchronized Object getAndReset() {
        Object obj;
        obj = get();
        reset();
        return obj;
    }

    public final synchronized void reset() {
        this.value = this.initialValue;
        this.state = State.Init;
        this.failureMessage = "";
    }

    public final synchronized Object get() {
        Object obj;
        obj = this.value;
        if (obj == null) {
            throw new IllegalStateException("Required value was null.");
        }
        return obj;
    }
}
