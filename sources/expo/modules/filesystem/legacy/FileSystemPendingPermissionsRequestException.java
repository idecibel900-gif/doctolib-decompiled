package expo.modules.filesystem.legacy;

import expo.modules.kotlin.exception.CodedException;

/* JADX INFO: loaded from: classes4.dex */
public final class FileSystemPendingPermissionsRequestException extends CodedException {
    public FileSystemPendingPermissionsRequestException() {
        super("You have an unfinished permission request", null, 2, null);
    }
}
