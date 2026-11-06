package expo.modules.filesystem;

import expo.modules.kotlin.exception.CodedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class UnableToWriteHandleException extends CodedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnableToWriteHandleException(String reason) {
        super("Unable to write to a file handle: '" + reason + "'", null, 2, null);
        Intrinsics.checkNotNullParameter(reason, "reason");
    }
}
