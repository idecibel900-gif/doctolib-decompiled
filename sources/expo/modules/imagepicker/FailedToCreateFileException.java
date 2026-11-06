package expo.modules.imagepicker;

import expo.modules.kotlin.exception.CodedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class FailedToCreateFileException extends CodedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FailedToCreateFileException(String path, Throwable th) {
        super("Failed to create the file '" + path + "'", th);
        Intrinsics.checkNotNullParameter(path, "path");
    }
}
