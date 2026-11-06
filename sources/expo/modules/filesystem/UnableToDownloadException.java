package expo.modules.filesystem;

import expo.modules.kotlin.exception.CodedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class UnableToDownloadException extends CodedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnableToDownloadException(String reason) {
        super("Unable to download a file: " + reason, null, 2, null);
        Intrinsics.checkNotNullParameter(reason, "reason");
    }
}
