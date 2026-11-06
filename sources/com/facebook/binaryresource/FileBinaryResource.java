package com.facebook.binaryresource;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class FileBinaryResource implements BinaryResource {
    public static final Companion Companion = new Companion(null);
    private final File file;

    public /* synthetic */ FileBinaryResource(File file, DefaultConstructorMarker defaultConstructorMarker) {
        this(file);
    }

    public static final FileBinaryResource create(File file) {
        return Companion.create(file);
    }

    public static final FileBinaryResource createOrNull(File file) {
        return Companion.createOrNull(file);
    }

    private FileBinaryResource(File file) {
        this.file = file;
    }

    public final File getFile() {
        return this.file;
    }

    @Override // com.facebook.binaryresource.BinaryResource
    public InputStream openStream() {
        return new FileInputStream(this.file);
    }

    @Override // com.facebook.binaryresource.BinaryResource
    public long size() {
        return this.file.length();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof FileBinaryResource)) {
            return false;
        }
        return Intrinsics.areEqual(this.file, ((FileBinaryResource) obj).file);
    }

    public int hashCode() {
        return this.file.hashCode();
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FileBinaryResource createOrNull(File file) {
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (file != null) {
                return new FileBinaryResource(file, defaultConstructorMarker);
            }
            return null;
        }

        public final FileBinaryResource create(File file) {
            Intrinsics.checkNotNullParameter(file, "file");
            return new FileBinaryResource(file, null);
        }
    }
}
