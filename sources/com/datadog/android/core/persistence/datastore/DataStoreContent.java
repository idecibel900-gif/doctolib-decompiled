package com.datadog.android.core.persistence.datastore;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DataStoreContent {
    private final Object data;
    private final int versionCode;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DataStoreContent)) {
            return false;
        }
        DataStoreContent dataStoreContent = (DataStoreContent) obj;
        return this.versionCode == dataStoreContent.versionCode && Intrinsics.areEqual(this.data, dataStoreContent.data);
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.versionCode) * 31;
        Object obj = this.data;
        return iHashCode + (obj == null ? 0 : obj.hashCode());
    }

    public String toString() {
        return "DataStoreContent(versionCode=" + this.versionCode + ", data=" + this.data + ")";
    }

    public DataStoreContent(int i, Object obj) {
        this.versionCode = i;
        this.data = obj;
    }

    public final int getVersionCode() {
        return this.versionCode;
    }

    public final Object getData() {
        return this.data;
    }
}
