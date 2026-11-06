package io.didomi.ssl;

import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class o7 implements Provider {
    private final Provider a;
    private final Provider b;
    private final Provider c;

    public o7(Provider provider, Provider provider2, Provider provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public n7 get() {
        return a((e0) this.a.get(), (ib) this.b.get(), (DidomiInitializeParameters) this.c.get());
    }

    public static o7 a(Provider provider, Provider provider2, Provider provider3) {
        return new o7(provider, provider2, provider3);
    }

    public static n7 a(e0 e0Var, ib ibVar, DidomiInitializeParameters didomiInitializeParameters) {
        return new n7(e0Var, ibVar, didomiInitializeParameters);
    }
}
