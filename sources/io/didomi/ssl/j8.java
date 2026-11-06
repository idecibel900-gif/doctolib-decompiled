package io.didomi.ssl;

import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class j8 implements Provider {
    private final i8 a;

    public j8(i8 i8Var) {
        this.a = i8Var;
    }

    public static DidomiInitializeParameters b(i8 i8Var) {
        return (DidomiInitializeParameters) Preconditions.checkNotNullFromProvides(i8Var.getParameters());
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public DidomiInitializeParameters get() {
        return b(this.a);
    }

    public static j8 a(i8 i8Var) {
        return new j8(i8Var);
    }
}
