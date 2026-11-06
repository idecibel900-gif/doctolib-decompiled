package expo.modules.imagepicker;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class PendingMediaPickingResult {
    private final List data;
    private final ImagePickerOptions options;

    public final List component1() {
        return this.data;
    }

    public final ImagePickerOptions component2() {
        return this.options;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PendingMediaPickingResult)) {
            return false;
        }
        PendingMediaPickingResult pendingMediaPickingResult = (PendingMediaPickingResult) obj;
        return Intrinsics.areEqual(this.data, pendingMediaPickingResult.data) && Intrinsics.areEqual(this.options, pendingMediaPickingResult.options);
    }

    public int hashCode() {
        return (this.data.hashCode() * 31) + this.options.hashCode();
    }

    public String toString() {
        return "PendingMediaPickingResult(data=" + this.data + ", options=" + this.options + ")";
    }

    public PendingMediaPickingResult(List data, ImagePickerOptions options) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(options, "options");
        this.data = data;
        this.options = options;
    }
}
