package expo.modules.imagepicker.contracts;

import expo.modules.imagepicker.ImagePickerOptions;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ImageLibraryContractOptions implements Serializable {
    private final ImagePickerOptions options;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ImageLibraryContractOptions) && Intrinsics.areEqual(this.options, ((ImageLibraryContractOptions) obj).options);
    }

    public int hashCode() {
        return this.options.hashCode();
    }

    public String toString() {
        return "ImageLibraryContractOptions(options=" + this.options + ")";
    }

    public ImageLibraryContractOptions(ImagePickerOptions options) {
        Intrinsics.checkNotNullParameter(options, "options");
        this.options = options;
    }

    public final ImagePickerOptions getOptions() {
        return this.options;
    }
}
