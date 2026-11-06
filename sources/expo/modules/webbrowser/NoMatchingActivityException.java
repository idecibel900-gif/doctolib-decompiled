package expo.modules.webbrowser;

import expo.modules.kotlin.exception.CodedException;

/* JADX INFO: loaded from: classes5.dex */
public final class NoMatchingActivityException extends CodedException {
    public NoMatchingActivityException() {
        super("No matching browser activity found", null, 2, null);
    }
}
