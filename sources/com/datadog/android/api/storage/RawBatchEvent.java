package com.datadog.android.api.storage;

import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class RawBatchEvent {
    private static final Companion Companion = new Companion(null);
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private final byte[] data;
    private final byte[] metadata;

    public String toString() {
        return "RawBatchEvent(data=" + Arrays.toString(this.data) + ", metadata=" + Arrays.toString(this.metadata) + ")";
    }

    public RawBatchEvent(byte[] data, byte[] metadata) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        this.data = data;
        this.metadata = metadata;
    }

    public final byte[] getData() {
        return this.data;
    }

    public /* synthetic */ RawBatchEvent(byte[] bArr, byte[] bArr2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bArr, (i & 2) != 0 ? EMPTY_BYTE_ARRAY : bArr2);
    }

    public final byte[] getMetadata() {
        return this.metadata;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(RawBatchEvent.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.datadog.android.api.storage.RawBatchEvent");
        RawBatchEvent rawBatchEvent = (RawBatchEvent) obj;
        return Arrays.equals(this.data, rawBatchEvent.data) && Arrays.equals(this.metadata, rawBatchEvent.metadata);
    }

    public int hashCode() {
        return (Arrays.hashCode(this.data) * 31) + Arrays.hashCode(this.metadata);
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
