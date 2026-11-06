package expo.modules.imagepicker.contracts;

import android.graphics.Bitmap;
import expo.modules.imagepicker.ImagePickerOptions;
import java.io.File;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class CropImageContractOptions implements Serializable {
    private final Bitmap.CompressFormat compressFormat;
    private final ImagePickerOptions options;
    private final File outputFile;
    private final String sourceUri;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CropImageContractOptions)) {
            return false;
        }
        CropImageContractOptions cropImageContractOptions = (CropImageContractOptions) obj;
        return Intrinsics.areEqual(this.sourceUri, cropImageContractOptions.sourceUri) && Intrinsics.areEqual(this.options, cropImageContractOptions.options) && Intrinsics.areEqual(this.outputFile, cropImageContractOptions.outputFile) && this.compressFormat == cropImageContractOptions.compressFormat;
    }

    public int hashCode() {
        return (((((this.sourceUri.hashCode() * 31) + this.options.hashCode()) * 31) + this.outputFile.hashCode()) * 31) + this.compressFormat.hashCode();
    }

    public String toString() {
        return "CropImageContractOptions(sourceUri=" + this.sourceUri + ", options=" + this.options + ", outputFile=" + this.outputFile + ", compressFormat=" + this.compressFormat + ")";
    }

    public CropImageContractOptions(String sourceUri, ImagePickerOptions options, File outputFile, Bitmap.CompressFormat compressFormat) {
        Intrinsics.checkNotNullParameter(sourceUri, "sourceUri");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(outputFile, "outputFile");
        Intrinsics.checkNotNullParameter(compressFormat, "compressFormat");
        this.sourceUri = sourceUri;
        this.options = options;
        this.outputFile = outputFile;
        this.compressFormat = compressFormat;
    }

    public final String getSourceUri() {
        return this.sourceUri;
    }

    public final ImagePickerOptions getOptions() {
        return this.options;
    }

    public final File getOutputFile() {
        return this.outputFile;
    }

    public final Bitmap.CompressFormat getCompressFormat() {
        return this.compressFormat;
    }
}
