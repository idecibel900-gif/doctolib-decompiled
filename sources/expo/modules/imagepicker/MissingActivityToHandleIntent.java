package expo.modules.imagepicker;

import expo.modules.kotlin.exception.CodedException;

/* JADX INFO: loaded from: classes4.dex */
public final class MissingActivityToHandleIntent extends CodedException {
    public MissingActivityToHandleIntent(String str) {
        super("Failed to resolve activity to handle the intent of type '" + str + "'", null, 2, null);
    }
}
