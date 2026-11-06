package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.ActualJvm_jvmKt;
import androidx.compose.runtime.WeakReference;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes.dex */
public final class SnapshotWeakSet {
    private int size;
    private int[] hashes = new int[16];
    private WeakReference[] values = new WeakReference[16];

    public final int getSize$runtime_release() {
        return this.size;
    }

    public final void setSize$runtime_release(int i) {
        this.size = i;
    }

    public final int[] getHashes$runtime_release() {
        return this.hashes;
    }

    public final WeakReference[] getValues$runtime_release() {
        return this.values;
    }

    public final boolean add(Object obj) {
        int iFind;
        int i = this.size;
        int iIdentityHashCode = ActualJvm_jvmKt.identityHashCode(obj);
        if (i > 0) {
            iFind = find(obj, iIdentityHashCode);
            if (iFind >= 0) {
                return false;
            }
        } else {
            iFind = -1;
        }
        int i2 = -(iFind + 1);
        WeakReference[] weakReferenceArr = this.values;
        int length = weakReferenceArr.length;
        if (i == length) {
            int i3 = length * 2;
            WeakReference[] weakReferenceArr2 = new WeakReference[i3];
            int[] iArr = new int[i3];
            int i4 = i2 + 1;
            ArraysKt.copyInto(weakReferenceArr, weakReferenceArr2, i4, i2, i);
            ArraysKt.copyInto$default(this.values, weakReferenceArr2, 0, 0, i2, 6, (Object) null);
            ArraysKt.copyInto(this.hashes, iArr, i4, i2, i);
            ArraysKt.copyInto$default(this.hashes, iArr, 0, 0, i2, 6, (Object) null);
            this.values = weakReferenceArr2;
            this.hashes = iArr;
        } else {
            int i5 = i2 + 1;
            ArraysKt.copyInto(weakReferenceArr, weakReferenceArr, i5, i2, i);
            int[] iArr2 = this.hashes;
            ArraysKt.copyInto(iArr2, iArr2, i5, i2, i);
        }
        this.values[i2] = new WeakReference(obj);
        this.hashes[i2] = iIdentityHashCode;
        this.size++;
        return true;
    }

    private final int find(Object obj, int i) {
        int i2 = this.size - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            int i5 = this.hashes[i4];
            if (i5 < i) {
                i3 = i4 + 1;
            } else {
                if (i5 <= i) {
                    WeakReference weakReference = this.values[i4];
                    return obj == (weakReference != null ? weakReference.get() : null) ? i4 : findExactIndex(i4, obj, i);
                }
                i2 = i4 - 1;
            }
        }
        return -(i3 + 1);
    }

    private final int findExactIndex(int i, Object obj, int i2) {
        int i3 = i - 1;
        while (true) {
            if (-1 >= i3 || this.hashes[i3] != i2) {
                break;
            }
            WeakReference weakReference = this.values[i3];
            if ((weakReference != null ? weakReference.get() : null) == obj) {
                return i3;
            }
            i3--;
        }
        int i4 = i + 1;
        int i5 = this.size;
        while (i4 < i5) {
            if (this.hashes[i4] != i2) {
                return -(i4 + 1);
            }
            WeakReference weakReference2 = this.values[i4];
            if ((weakReference2 != null ? weakReference2.get() : null) == obj) {
                return i4;
            }
            i4++;
        }
        i4 = this.size;
        return -(i4 + 1);
    }
}
