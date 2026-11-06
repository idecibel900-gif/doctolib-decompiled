package io.didomi.ssl;

import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class e1 implements Provider {
    private final Provider a;
    private final Provider b;
    private final Provider c;

    public e1(Provider provider, Provider provider2, Provider provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public d1 get() {
        return a((e0) this.a.get(), (g0) this.b.get(), (o6) this.c.get());
    }

    public static e1 a(Provider provider, Provider provider2, Provider provider3) {
        return new e1(provider, provider2, provider3);
    }

    public static d1 a(e0 e0Var, g0 g0Var, o6 o6Var) {
        return new d1(e0Var, g0Var, o6Var);
    }
}
