package expo.modules.filesystem;

import expo.modules.kotlin.exception.CodedException;

/* JADX INFO: loaded from: classes4.dex */
public final class PickerCancelledException extends CodedException {
    public PickerCancelledException() {
        super("The file picker was cancelled by the user", null, 2, null);
    }
}
