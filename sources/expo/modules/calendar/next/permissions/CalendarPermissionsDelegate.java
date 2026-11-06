package expo.modules.calendar.next.permissions;

import expo.modules.calendar.next.exceptions.CalendarPermissionException;
import expo.modules.interfaces.permissions.Permissions;
import expo.modules.kotlin.AppContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class CalendarPermissionsDelegate {
    private final AppContext appContext;

    public CalendarPermissionsDelegate(AppContext appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.appContext = appContext;
    }

    private final boolean hasReadPermissions() {
        Permissions permissions = this.appContext.getPermissions();
        return permissions != null && permissions.hasGrantedPermissions("android.permission.READ_CALENDAR");
    }

    private final boolean hasWritePermissions() {
        Permissions permissions = this.appContext.getPermissions();
        return permissions != null && permissions.hasGrantedPermissions("android.permission.WRITE_CALENDAR");
    }

    public final void requireReadPermissions() throws CalendarPermissionException {
        if (!hasReadPermissions()) {
            throw new CalendarPermissionException("Read permission not found", null, 2, null);
        }
    }

    public final void requireWritePermissions() throws CalendarPermissionException {
        if (!hasWritePermissions()) {
            throw new CalendarPermissionException("Write permission not found", null, 2, null);
        }
    }

    public final void requireSystemPermissions(boolean z) throws CalendarPermissionException {
        if (z) {
            requireWritePermissions();
        }
        requireReadPermissions();
    }
}
