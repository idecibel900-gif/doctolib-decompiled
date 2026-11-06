package expo.modules.clipboard;

import expo.modules.kotlin.exception.CodedException;

/* JADX INFO: loaded from: classes4.dex */
public final class ClipboardUnavailableException extends CodedException {
    public ClipboardUnavailableException() {
        super("'CLIPBOARD_SERVICE' is unavailable on this device", null);
    }
}
