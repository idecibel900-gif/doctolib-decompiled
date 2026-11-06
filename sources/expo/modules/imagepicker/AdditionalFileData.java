package expo.modules.imagepicker;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class AdditionalFileData {
    private final String fileName;
    private final Long fileSize;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdditionalFileData)) {
            return false;
        }
        AdditionalFileData additionalFileData = (AdditionalFileData) obj;
        return Intrinsics.areEqual(this.fileName, additionalFileData.fileName) && Intrinsics.areEqual(this.fileSize, additionalFileData.fileSize);
    }

    public int hashCode() {
        String str = this.fileName;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l = this.fileSize;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        return "AdditionalFileData(fileName=" + this.fileName + ", fileSize=" + this.fileSize + ")";
    }

    public AdditionalFileData(String str, Long l) {
        this.fileName = str;
        this.fileSize = l;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final Long getFileSize() {
        return this.fileSize;
    }
}
