package expo.modules.filesystem;

import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.services.FilePermissionService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class InvalidPermissionException extends CodedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvalidPermissionException(FilePermissionService.Permission permission) {
        super("Missing '" + permission.name() + "' permission for accessing the file.", null, 2, null);
        Intrinsics.checkNotNullParameter(permission, "permission");
    }
}
