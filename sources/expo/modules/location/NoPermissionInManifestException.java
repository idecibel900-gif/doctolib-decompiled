package expo.modules.location;

import expo.modules.kotlin.exception.CodedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class NoPermissionInManifestException extends CodedException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoPermissionInManifestException(String permissionName) {
        super("You need to add `" + permissionName + "` to the AndroidManifest", null, 2, null);
        Intrinsics.checkNotNullParameter(permissionName, "permissionName");
    }
}
