package expo.modules.filesystem;

import expo.modules.kotlin.exception.CodedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class UnableToDeleteException extends CodedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnableToDeleteException(String reason) {
        super("Unable to delete file or directory: " + reason, null, 2, null);
        Intrinsics.checkNotNullParameter(reason, "reason");
    }
}
