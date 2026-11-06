package expo.modules.interfaces.permissions;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class PermissionsResponse {
    public static final Companion Companion = new Companion(null);
    private final boolean canAskAgain;
    private final PermissionsStatus status;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PermissionsResponse)) {
            return false;
        }
        PermissionsResponse permissionsResponse = (PermissionsResponse) obj;
        return this.status == permissionsResponse.status && this.canAskAgain == permissionsResponse.canAskAgain;
    }

    public int hashCode() {
        return (this.status.hashCode() * 31) + Boolean.hashCode(this.canAskAgain);
    }

    public String toString() {
        return "PermissionsResponse(status=" + this.status + ", canAskAgain=" + this.canAskAgain + ")";
    }

    public PermissionsResponse(PermissionsStatus status, boolean z) {
        Intrinsics.checkNotNullParameter(status, "status");
        this.status = status;
        this.canAskAgain = z;
    }

    public final PermissionsStatus getStatus() {
        return this.status;
    }

    public final boolean getCanAskAgain() {
        return this.canAskAgain;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
