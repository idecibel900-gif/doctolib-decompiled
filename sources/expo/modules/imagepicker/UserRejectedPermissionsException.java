package expo.modules.imagepicker;

import expo.modules.kotlin.exception.CodedException;

/* JADX INFO: loaded from: classes4.dex */
public final class UserRejectedPermissionsException extends CodedException {
    public UserRejectedPermissionsException() {
        super("User rejected permissions", null, 2, null);
    }
}
