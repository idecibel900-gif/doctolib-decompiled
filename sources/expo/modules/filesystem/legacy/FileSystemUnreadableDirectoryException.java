package expo.modules.filesystem.legacy;

import expo.modules.kotlin.exception.CodedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class FileSystemUnreadableDirectoryException extends CodedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileSystemUnreadableDirectoryException(String uri) {
        super("No readable files with the uri '" + uri + "'. Please use other uri", null, 2, null);
        Intrinsics.checkNotNullParameter(uri, "uri");
    }
}
