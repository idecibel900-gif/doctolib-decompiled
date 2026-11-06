package expo.modules.imagepicker.contracts;

import expo.modules.imagepicker.ImagePickerOptions;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class CameraContractOptions implements Serializable {
    private final ImagePickerOptions options;
    private final String uri;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraContractOptions)) {
            return false;
        }
        CameraContractOptions cameraContractOptions = (CameraContractOptions) obj;
        return Intrinsics.areEqual(this.uri, cameraContractOptions.uri) && Intrinsics.areEqual(this.options, cameraContractOptions.options);
    }

    public int hashCode() {
        return (this.uri.hashCode() * 31) + this.options.hashCode();
    }

    public String toString() {
        return "CameraContractOptions(uri=" + this.uri + ", options=" + this.options + ")";
    }

    public CameraContractOptions(String uri, ImagePickerOptions options) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(options, "options");
        this.uri = uri;
        this.options = options;
    }

    public final String getUri() {
        return this.uri;
    }

    public final ImagePickerOptions getOptions() {
        return this.options;
    }
}
