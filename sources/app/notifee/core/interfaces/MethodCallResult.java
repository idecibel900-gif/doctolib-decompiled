package app.notifee.core.interfaces;

import app.notifee.core.KeepForSdk;

/* JADX INFO: loaded from: classes3.dex */
@KeepForSdk
public interface MethodCallResult<T> {
    @KeepForSdk
    void onComplete(Exception exc, T t);
}
