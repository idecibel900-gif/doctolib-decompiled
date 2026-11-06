package io.didomi.ssl;

import android.content.Context;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class n6 implements Provider {
    private final i6 a;
    private final Provider b;

    public n6(i6 i6Var, Provider provider) {
        this.a = i6Var;
        this.b = provider;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ib get() {
        return a(this.a, (Context) this.b.get());
    }

    public static n6 a(i6 i6Var, Provider provider) {
        return new n6(i6Var, provider);
    }

    public static ib a(i6 i6Var, Context context) {
        return (ib) Preconditions.checkNotNullFromProvides(i6Var.b(context));
    }
}
