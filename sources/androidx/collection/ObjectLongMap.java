package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import androidx.collection.internal.RuntimeHelpersKt;
import com.amazon.a.a.o.b.f;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class ObjectLongMap {
    public int _capacity;
    public int _size;
    public Object[] keys;
    public long[] metadata;
    public long[] values;

    public /* synthetic */ ObjectLongMap(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ObjectLongMap() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.keys = ContainerHelpersKt.EMPTY_OBJECTS;
        this.values = LongSetKt.getEmptyLongArray();
    }

    public final int getCapacity() {
        return this._capacity;
    }

    public final int getSize() {
        return this._size;
    }

    public final boolean isEmpty() {
        return this._size == 0;
    }

    public final long get(Object obj) {
        int iFindKeyIndex = findKeyIndex(obj);
        if (iFindKeyIndex < 0) {
            RuntimeHelpersKt.throwNoSuchElementException("There is no key " + obj + " in the map");
        }
        return this.values[iFindKeyIndex];
    }

    public final long getOrDefault(Object obj, long j) {
        int iFindKeyIndex = findKeyIndex(obj);
        return iFindKeyIndex >= 0 ? this.values[iFindKeyIndex] : j;
    }

    public int hashCode() {
        Object[] objArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return 0;
        }
        int i = 0;
        int iHashCode = 0;
        while (true) {
            long j = jArr2[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        int i4 = (i << 3) + i3;
                        Object obj = objArr[i4];
                        iHashCode += (obj != null ? obj.hashCode() : 0) ^ Long.hashCode(jArr[i4]);
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return iHashCode;
                }
            }
            if (i == length) {
                return iHashCode;
            }
            i++;
        }
    }

    public final boolean contains(Object obj) {
        return containsKey(obj);
    }

    public final boolean containsKey(Object obj) {
        return findKeyIndex(obj) >= 0;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0068 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x006a A[LOOP:0: B:14:0x0027->B:28:0x006a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:33:0x006d A[SYNTHETIC] */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ObjectLongMap)) {
            return false;
        }
        ObjectLongMap objectLongMap = (ObjectLongMap) obj;
        if (objectLongMap.getSize() != getSize()) {
            return false;
        }
        Object[] objArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i = 0;
            loop0: while (true) {
                long j = jArr2[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            int i4 = (i << 3) + i3;
                            Object obj2 = objArr[i4];
                            long j2 = jArr[i4];
                            int iFindKeyIndex = objectLongMap.findKeyIndex(obj2);
                            if (iFindKeyIndex < 0 || j2 != objectLongMap.values[iFindKeyIndex]) {
                                break loop0;
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 == 8) {
                        if (i != length) {
                            i++;
                        }
                    }
                } else if (i != length) {
                    i++;
                }
            }
            return false;
        }
        return true;
    }

    public String toString() {
        int i;
        int i2;
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        Object[] objArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i3 = 0;
            int i4 = 0;
            while (true) {
                long j = jArr2[i3];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i5 = 8 - ((~(i3 - length)) >>> 31);
                    int i6 = 0;
                    while (i6 < i5) {
                        if ((255 & j) < 128) {
                            int i7 = (i3 << 3) + i6;
                            Object obj = objArr[i7];
                            i2 = i3;
                            long j2 = jArr[i7];
                            if (obj == this) {
                                obj = "(this)";
                            }
                            sb.append(obj);
                            sb.append(f.b);
                            sb.append(j2);
                            i4++;
                            if (i4 < this._size) {
                                sb.append(',');
                                sb.append(' ');
                            }
                        } else {
                            i2 = i3;
                        }
                        j >>= 8;
                        i6++;
                        i3 = i2;
                    }
                    int i8 = i3;
                    if (i5 != 8) {
                        break;
                    }
                    i = i8;
                } else {
                    i = i3;
                }
                if (i == length) {
                    break;
                }
                i3 = i + 1;
            }
        }
        sb.append('}');
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final int findKeyIndex(Object obj) {
        int i = 0;
        int iHashCode = (obj != null ? obj.hashCode() : 0) * (-862048943);
        int i2 = iHashCode ^ (iHashCode << 16);
        int i3 = i2 & 127;
        int i4 = this._capacity;
        int i5 = i2 >>> 7;
        while (true) {
            int i6 = i5 & i4;
            long[] jArr = this.metadata;
            int i7 = i6 >> 3;
            int i8 = (i6 & 7) << 3;
            long j = ((jArr[i7 + 1] << (64 - i8)) & ((-i8) >> 63)) | (jArr[i7] >>> i8);
            long j2 = (((long) i3) * 72340172838076673L) ^ j;
            for (long j3 = (~j2) & (j2 - 72340172838076673L) & (-9187201950435737472L); j3 != 0; j3 &= j3 - 1) {
                int iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j3) >> 3) + i6) & i4;
                if (Intrinsics.areEqual(this.keys[iNumberOfTrailingZeros], obj)) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((j & ((~j) << 6) & (-9187201950435737472L)) != 0) {
                return -1;
            }
            i += 8;
            i5 = i6 + i;
        }
    }
}
