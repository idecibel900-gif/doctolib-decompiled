package expo.modules.documentpicker;

import expo.modules.kotlin.exception.CodedException;

/* JADX INFO: loaded from: classes4.dex */
public final class DocumentPickerOptionsEmptyListException extends CodedException {
    public DocumentPickerOptionsEmptyListException() {
        super("The 'type' argument must be a non-empty array.", null, 2, null);
    }
}
