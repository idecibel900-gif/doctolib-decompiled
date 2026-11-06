package io.didomi.ssl;

import android.content.Context;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class k0 implements Provider {
    private final i0 a;
    private final Provider b;

    public k0(i0 i0Var, Provider provider) {
        this.a = i0Var;
        this.b = provider;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public j7 get() {
        return a(this.a, (Context) this.b.get());
    }

    public static k0 a(i0 i0Var, Provider provider) {
        return new k0(i0Var, provider);
    }

    public static j7 a(i0 i0Var, Context context) {
        return (j7) Preconditions.checkNotNullFromProvides(i0Var.a(context));
    }
}
