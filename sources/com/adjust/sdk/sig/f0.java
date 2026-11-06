package com.adjust.sdk.sig;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public final class f0 extends d implements Serializable {
    public final Enum[] a;

    public f0(Enum[] enumArr) {
        this.a = enumArr;
    }

    @Override // com.adjust.sdk.sig.d
    public final int a() {
        return this.a.length;
    }

    @Override // com.adjust.sdk.sig.d, java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        if (!(obj instanceof Enum)) {
            return false;
        }
        Enum r5 = (Enum) obj;
        Enum[] enumArr = this.a;
        int iOrdinal = r5.ordinal();
        return ((iOrdinal < 0 || iOrdinal >= enumArr.length) ? null : enumArr[iOrdinal]) == r5;
    }

    @Override // java.util.List
    public final Object get(int i) {
        Enum[] enumArr = this.a;
        int length = enumArr.length;
        if (i >= 0 && i < length) {
            return enumArr[i];
        }
        throw new IndexOutOfBoundsException("index: " + i + ", size: " + length);
    }

    @Override // com.adjust.sdk.sig.d, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum r5 = (Enum) obj;
        int iOrdinal = r5.ordinal();
        Enum[] enumArr = this.a;
        if (((iOrdinal < 0 || iOrdinal >= enumArr.length) ? null : enumArr[iOrdinal]) == r5) {
            return iOrdinal;
        }
        return -1;
    }

    @Override // com.adjust.sdk.sig.d, java.util.List
    public final int lastIndexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum r5 = (Enum) obj;
        int iOrdinal = r5.ordinal();
        Enum[] enumArr = this.a;
        if (((iOrdinal < 0 || iOrdinal >= enumArr.length) ? null : enumArr[iOrdinal]) == r5) {
            return iOrdinal;
        }
        return -1;
    }
}
