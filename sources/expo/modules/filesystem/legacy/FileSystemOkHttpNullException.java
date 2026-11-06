package expo.modules.filesystem.legacy;

import expo.modules.kotlin.exception.CodedException;

/* JADX INFO: loaded from: classes4.dex */
public final class FileSystemOkHttpNullException extends CodedException {
    public FileSystemOkHttpNullException() {
        super("okHttpClient is null", null, 2, null);
    }
}
