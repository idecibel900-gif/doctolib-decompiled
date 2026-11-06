package io.didomi.ssl;

import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class b9 implements Provider {
    private final y8 a;

    public b9(y8 y8Var) {
        this.a = y8Var;
    }

    public static jh b(y8 y8Var) {
        return (jh) Preconditions.checkNotNullFromProvides(y8Var.a());
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public jh get() {
        return b(this.a);
    }

    public static b9 a(y8 y8Var) {
        return new b9(y8Var);
    }
}
