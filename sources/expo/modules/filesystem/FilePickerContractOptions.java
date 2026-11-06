package expo.modules.filesystem;

import android.net.Uri;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class FilePickerContractOptions implements Serializable {
    private final Uri initialUri;
    private final String mimeType;
    private final PickerType pickerType;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FilePickerContractOptions)) {
            return false;
        }
        FilePickerContractOptions filePickerContractOptions = (FilePickerContractOptions) obj;
        return Intrinsics.areEqual(this.initialUri, filePickerContractOptions.initialUri) && Intrinsics.areEqual(this.mimeType, filePickerContractOptions.mimeType) && this.pickerType == filePickerContractOptions.pickerType;
    }

    public int hashCode() {
        Uri uri = this.initialUri;
        int iHashCode = (uri == null ? 0 : uri.hashCode()) * 31;
        String str = this.mimeType;
        return ((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.pickerType.hashCode();
    }

    public String toString() {
        return "FilePickerContractOptions(initialUri=" + this.initialUri + ", mimeType=" + this.mimeType + ", pickerType=" + this.pickerType + ")";
    }

    public FilePickerContractOptions(Uri uri, String str, PickerType pickerType) {
        Intrinsics.checkNotNullParameter(pickerType, "pickerType");
        this.initialUri = uri;
        this.mimeType = str;
        this.pickerType = pickerType;
    }

    public final Uri getInitialUri() {
        return this.initialUri;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final PickerType getPickerType() {
        return this.pickerType;
    }
}
