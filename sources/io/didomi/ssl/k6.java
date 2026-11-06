package io.didomi.ssl;

import android.content.Context;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class k6 implements Provider {
    private final i6 a;
    private final Provider b;
    private final Provider c;
    private final Provider d;

    public k6(i6 i6Var, Provider provider, Provider provider2, Provider provider3) {
        this.a = i6Var;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public v0 get() {
        return a(this.a, (Context) this.b.get(), (DidomiInitializeParameters) this.c.get(), (r7) this.d.get());
    }

    public static k6 a(i6 i6Var, Provider provider, Provider provider2, Provider provider3) {
        return new k6(i6Var, provider, provider2, provider3);
    }

    public static v0 a(i6 i6Var, Context context, DidomiInitializeParameters didomiInitializeParameters, r7 r7Var) {
        return (v0) Preconditions.checkNotNullFromProvides(i6Var.a(context, didomiInitializeParameters, r7Var));
    }
}
