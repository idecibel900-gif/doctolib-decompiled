package io.didomi.ssl;

import android.content.Context;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class j6 implements Provider {
    private final i6 a;
    private final Provider b;

    public j6(i6 i6Var, Provider provider) {
        this.a = i6Var;
        this.b = provider;
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public g0 get() {
        return a(this.a, (Context) this.b.get());
    }

    public static j6 a(i6 i6Var, Provider provider) {
        return new j6(i6Var, provider);
    }

    public static g0 a(i6 i6Var, Context context) {
        return (g0) Preconditions.checkNotNullFromProvides(i6Var.a(context));
    }
}
