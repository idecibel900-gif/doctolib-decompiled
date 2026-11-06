package com.datadog.android.core.internal.persistence;

import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class BatchData {
    private final List data;
    private final BatchId id;
    private final byte[] metadata;

    public String toString() {
        return "BatchData(id=" + this.id + ", data=" + this.data + ", metadata=" + Arrays.toString(this.metadata) + ")";
    }

    public BatchData(BatchId id, List data, byte[] bArr) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(data, "data");
        this.id = id;
        this.data = data;
        this.metadata = bArr;
    }

    public final BatchId getId() {
        return this.id;
    }

    public final List getData() {
        return this.data;
    }

    public final byte[] getMetadata() {
        return this.metadata;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(BatchData.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.datadog.android.core.internal.persistence.BatchData");
        BatchData batchData = (BatchData) obj;
        if (!Intrinsics.areEqual(this.id, batchData.id) || !Intrinsics.areEqual(this.data, batchData.data)) {
            return false;
        }
        byte[] bArr = this.metadata;
        if (bArr != null) {
            byte[] bArr2 = batchData.metadata;
            if (bArr2 == null || !Arrays.equals(bArr, bArr2)) {
                return false;
            }
        } else if (batchData.metadata != null) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int iHashCode = ((this.id.hashCode() * 31) + this.data.hashCode()) * 31;
        byte[] bArr = this.metadata;
        return iHashCode + (bArr != null ? Arrays.hashCode(bArr) : 0);
    }
}
