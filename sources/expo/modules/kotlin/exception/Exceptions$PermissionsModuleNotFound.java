package expo.modules.kotlin.exception;

import expo.modules.interfaces.permissions.Permissions;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes4.dex */
public final class Exceptions$PermissionsModuleNotFound extends Exceptions$ModuleNotFound {
    public Exceptions$PermissionsModuleNotFound() {
        super(Reflection.getOrCreateKotlinClass(Permissions.class));
    }
}
