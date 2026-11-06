package io.didomi.ssl;

import dagger.internal.Preconditions;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes5.dex */
public final class fb implements Provider {
    private final cb a;

    public fb(cb cbVar) {
        this.a = cbVar;
    }

    public static UIStateRepository b(cb cbVar) {
        return (UIStateRepository) Preconditions.checkNotNullFromProvides(cbVar.a());
    }

    @Override // javax.inject.Provider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public UIStateRepository get() {
        return b(this.a);
    }

    public static fb a(cb cbVar) {
        return new fb(cbVar);
    }
}
