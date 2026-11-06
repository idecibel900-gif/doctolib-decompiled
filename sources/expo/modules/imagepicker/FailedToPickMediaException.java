package expo.modules.imagepicker;

import expo.modules.kotlin.exception.CodedException;

/* JADX INFO: loaded from: classes4.dex */
public final class FailedToPickMediaException extends CodedException {
    public FailedToPickMediaException() {
        super("Failed to parse PhotoPicker result", null, 2, null);
    }
}
