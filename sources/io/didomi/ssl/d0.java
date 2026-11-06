package io.didomi.ssl;

import android.content.Context;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class d0 implements Provider {
    private final c0 a;
    private final Provider b;
    private final Provider c;
    private final Provider d;
    private final Provider e;
    private final Provider f;

    public d0(c0 c0Var, Provider provider, Provider provider2, Provider provider3, Provider provider4, Provider provider5) {
        this.a = c0Var;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public e0 get() {
        return a(this.a, (Context) this.b.get(), (v0) this.c.get(), (r7) this.d.get(), (DidomiInitializeParameters) this.e.get(), (bb) this.f.get());
    }

    public static d0 a(c0 c0Var, Provider provider, Provider provider2, Provider provider3, Provider provider4, Provider provider5) {
        return new d0(c0Var, provider, provider2, provider3, provider4, provider5);
    }

    public static e0 a(c0 c0Var, Context context, v0 v0Var, r7 r7Var, DidomiInitializeParameters didomiInitializeParameters, bb bbVar) {
        return (e0) Preconditions.checkNotNullFromProvides(c0Var.a(context, v0Var, r7Var, didomiInitializeParameters, bbVar));
    }
}
