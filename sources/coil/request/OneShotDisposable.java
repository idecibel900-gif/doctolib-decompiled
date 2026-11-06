package coil.request;

import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: classes3.dex */
public final class OneShotDisposable implements Disposable {
    private final Deferred job;

    public OneShotDisposable(Deferred deferred) {
        this.job = deferred;
    }
}
