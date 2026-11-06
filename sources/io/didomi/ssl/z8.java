package io.didomi.ssl;

import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes5.dex */
public final class z8 implements Provider {
    private final y8 a;
    private final Provider b;
    private final Provider c;
    private final Provider d;
    private final Provider e;

    public z8(y8 y8Var, Provider provider, Provider provider2, Provider provider3, Provider provider4) {
        this.a = y8Var;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public u7 get() {
        return a(this.a, (e0) this.b.get(), (v0) this.c.get(), (x6) this.d.get(), (CoroutineDispatcher) this.e.get());
    }

    public static z8 a(y8 y8Var, Provider provider, Provider provider2, Provider provider3, Provider provider4) {
        return new z8(y8Var, provider, provider2, provider3, provider4);
    }

    public static u7 a(y8 y8Var, e0 e0Var, v0 v0Var, x6 x6Var, CoroutineDispatcher coroutineDispatcher) {
        return (u7) Preconditions.checkNotNullFromProvides(y8Var.a(e0Var, v0Var, x6Var, coroutineDispatcher));
    }
}
