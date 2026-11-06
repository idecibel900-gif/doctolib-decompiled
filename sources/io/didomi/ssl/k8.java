package io.didomi.ssl;

import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class k8 implements Provider {
    private final i8 a;

    public k8(i8 i8Var) {
        this.a = i8Var;
    }

    public static r7 b(i8 i8Var) {
        return (r7) Preconditions.checkNotNullFromProvides(i8Var.getLocalPropertiesRepository());
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public r7 get() {
        return b(this.a);
    }

    public static k8 a(i8 i8Var) {
        return new k8(i8Var);
    }
}
