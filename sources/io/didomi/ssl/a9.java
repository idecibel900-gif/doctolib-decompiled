package io.didomi.ssl;

import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class a9 implements Provider {
    private final y8 a;
    private final Provider b;
    private final Provider c;

    public a9(y8 y8Var, Provider provider, Provider provider2) {
        this.a = y8Var;
        this.b = provider;
        this.c = provider2;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public eh get() {
        return a(this.a, (v0) this.b.get(), (e0) this.c.get());
    }

    public static a9 a(y8 y8Var, Provider provider, Provider provider2) {
        return new a9(y8Var, provider, provider2);
    }

    public static eh a(y8 y8Var, v0 v0Var, e0 e0Var) {
        return (eh) Preconditions.checkNotNullFromProvides(y8Var.a(v0Var, e0Var));
    }
}
