package expo.modules.updates.statemachine;

import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class UpdatesStateError {
    private final String message;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof UpdatesStateError) && Intrinsics.areEqual(this.message, ((UpdatesStateError) obj).message);
    }

    public int hashCode() {
        return this.message.hashCode();
    }

    public String toString() {
        return "UpdatesStateError(message=" + this.message + ")";
    }

    public UpdatesStateError(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.message = message;
    }

    public final String getMessage() {
        return this.message;
    }

    public final Map getJson() {
        return MapsKt.mapOf(TuplesKt.to("message", this.message));
    }
}
