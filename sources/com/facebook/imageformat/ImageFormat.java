package com.facebook.imageformat;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ImageFormat {
    public static final Companion Companion = new Companion(null);
    public static final ImageFormat UNKNOWN = new ImageFormat("UNKNOWN", null);
    private final String fileExtension;
    private final String name;

    public interface FormatChecker {
        ImageFormat determineFormat(byte[] bArr, int i);

        int getHeaderSize();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageFormat)) {
            return false;
        }
        ImageFormat imageFormat = (ImageFormat) obj;
        return Intrinsics.areEqual(this.name, imageFormat.name) && Intrinsics.areEqual(this.fileExtension, imageFormat.fileExtension);
    }

    public int hashCode() {
        int iHashCode = this.name.hashCode() * 31;
        String str = this.fileExtension;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public ImageFormat(String name, String str) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.fileExtension = str;
    }

    public final String getName() {
        return this.name;
    }

    public String toString() {
        return this.name;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
