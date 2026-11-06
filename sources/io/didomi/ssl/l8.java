package io.didomi.ssl;

import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class l8 implements Provider {
    private final i8 a;

    public l8(i8 i8Var) {
        this.a = i8Var;
    }

    public static h8 b(i8 i8Var) {
        return (h8) Preconditions.checkNotNullFromProvides(i8Var.getOrganizationUserRepository());
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public h8 get() {
        return b(this.a);
    }

    public static l8 a(i8 i8Var) {
        return new l8(i8Var);
    }
}
