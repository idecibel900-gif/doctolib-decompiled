package expo.modules.fetch;

import expo.modules.kotlin.exception.CodedException;

/* JADX INFO: loaded from: classes4.dex */
public final class FetchAndroidContextLostException extends CodedException {
    public FetchAndroidContextLostException() {
        super("The Android context has been lost", null, 2, null);
    }
}
