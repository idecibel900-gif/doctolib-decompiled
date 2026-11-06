package expo.modules.fetch;

import expo.modules.kotlin.exception.CodedException;

/* JADX INFO: loaded from: classes4.dex */
public final class FetchRedirectException extends CodedException {
    public FetchRedirectException() {
        super("Redirect is not allowed when redirect mode is 'error'", null, 2, null);
    }
}
