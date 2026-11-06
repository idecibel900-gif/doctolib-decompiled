package expo.modules.location;

import expo.modules.kotlin.exception.CodedException;

/* JADX INFO: loaded from: classes4.dex */
public final class NoPermissionsModuleException extends CodedException {
    public NoPermissionsModuleException() {
        super("Permissions module is null. Are you sure all the installed Expo modules are properly linked?", null, 2, null);
    }
}
