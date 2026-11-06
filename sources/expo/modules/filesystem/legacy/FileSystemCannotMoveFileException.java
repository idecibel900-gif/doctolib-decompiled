package expo.modules.filesystem.legacy;

import android.net.Uri;
import expo.modules.kotlin.exception.CodedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class FileSystemCannotMoveFileException extends CodedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileSystemCannotMoveFileException(Uri fromUri, Uri toUri) {
        super("File '" + fromUri + "' could not be moved to '" + toUri + "'", null, 2, null);
        Intrinsics.checkNotNullParameter(fromUri, "fromUri");
        Intrinsics.checkNotNullParameter(toUri, "toUri");
    }
}
