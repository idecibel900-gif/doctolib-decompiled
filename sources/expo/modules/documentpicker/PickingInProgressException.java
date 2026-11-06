package expo.modules.documentpicker;

import expo.modules.kotlin.exception.CodedException;

/* JADX INFO: loaded from: classes4.dex */
public final class PickingInProgressException extends CodedException {
    public PickingInProgressException() {
        super("Different document picking in progress. Await other document picking first.", null, 2, null);
    }
}
