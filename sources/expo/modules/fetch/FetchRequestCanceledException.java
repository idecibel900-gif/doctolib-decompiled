package expo.modules.fetch;

import expo.modules.kotlin.exception.CodedException;

/* JADX INFO: loaded from: classes4.dex */
public final class FetchRequestCanceledException extends CodedException {
    public FetchRequestCanceledException() {
        super("Fetch request has been canceled", null, 2, null);
    }
}
