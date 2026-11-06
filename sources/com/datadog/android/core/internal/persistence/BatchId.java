package com.datadog.android.core.internal.persistence;

import java.io.File;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class BatchId {
    public static final Companion Companion = new Companion(null);
    private final String id;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BatchId) && Intrinsics.areEqual(this.id, ((BatchId) obj).id);
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public String toString() {
        return "BatchId(id=" + this.id + ")";
    }

    public BatchId(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.id = id;
    }

    public final String getId() {
        return this.id;
    }

    public final boolean matchesFile(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return Intrinsics.areEqual(Companion.extractFileId(file), this.id);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BatchId fromFile(File file) {
            Intrinsics.checkNotNullParameter(file, "file");
            return new BatchId(extractFileId(file));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String extractFileId(File file) {
            String absolutePath = file.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "absolutePath");
            return absolutePath;
        }
    }
}
