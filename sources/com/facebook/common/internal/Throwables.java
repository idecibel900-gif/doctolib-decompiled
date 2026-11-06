package com.facebook.common.internal;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Throwables {
    public static void propagateIfInstanceOf(Throwable th, Class cls) throws Throwable {
        if (th != null && cls.isInstance(th)) {
            throw ((Throwable) cls.cast(th));
        }
    }

    public static void propagateIfPossible(Throwable th) throws Throwable {
        propagateIfInstanceOf(th, Error.class);
        propagateIfInstanceOf(th, RuntimeException.class);
    }

    public static RuntimeException propagate(Throwable th) throws Throwable {
        propagateIfPossible((Throwable) Preconditions.checkNotNull(th));
        throw new RuntimeException(th);
    }
}
