package io.didomi.ssl;

import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class z0 implements Provider {
    private final x0 a;

    public z0(x0 x0Var) {
        this.a = x0Var;
    }

    public static l7 b(x0 x0Var) {
        return (l7) Preconditions.checkNotNullFromProvides(x0Var.b());
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public l7 get() {
        return b(this.a);
    }

    public static z0 a(x0 x0Var) {
        return new z0(x0Var);
    }
}
