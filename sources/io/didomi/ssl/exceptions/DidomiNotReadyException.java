package io.didomi.ssl.exceptions;

import androidx.annotation.Keep;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Keep
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/didomi/sdk/exceptions/DidomiNotReadyException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "()V", "android_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DidomiNotReadyException extends Exception {
    public DidomiNotReadyException() {
        super("Didomi SDK is not ready. Use the onReady callback to access this method.");
    }
}
