package io.didomi.ssl;

import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class a6 implements Provider {
    private final z5 a;

    public a6(z5 z5Var) {
        this.a = z5Var;
    }

    public static b6 b(z5 z5Var) {
        return (b6) Preconditions.checkNotNullFromProvides(z5Var.getEventsRepository());
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public b6 get() {
        return b(this.a);
    }

    public static a6 a(z5 z5Var) {
        return new a6(z5Var);
    }
}
