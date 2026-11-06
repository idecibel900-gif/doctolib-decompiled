package expo.modules.documentpicker;

import expo.modules.kotlin.exception.CodedException;

/* JADX INFO: loaded from: classes4.dex */
public final class FailedToReadDocumentException extends CodedException {
    public FailedToReadDocumentException() {
        super("Failed to read the selected document.", null, 2, null);
    }
}
