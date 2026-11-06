package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class CircularIntArray {
    private int capacityBitmask;
    private int[] elements;
    private int head;
    private int tail;

    public CircularIntArray() {
        this(0, 1, null);
    }

    public CircularIntArray(int i) {
        if (!(i >= 1)) {
            RuntimeHelpersKt.throwIllegalArgumentException("capacity must be >= 1");
        }
        if (!(i <= 1073741824)) {
            RuntimeHelpersKt.throwIllegalArgumentException("capacity must be <= 2^30");
        }
        i = Integer.bitCount(i) != 1 ? Integer.highestOneBit(i - 1) << 1 : i;
        this.capacityBitmask = i - 1;
        this.elements = new int[i];
    }

    public /* synthetic */ CircularIntArray(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 8 : i);
    }

    private final void doubleCapacity() {
        int[] iArr = this.elements;
        int length = iArr.length;
        int i = this.head;
        int i2 = length - i;
        int i3 = length << 1;
        if (i3 < 0) {
            throw new RuntimeException("Max array capacity exceeded");
        }
        int[] iArr2 = new int[i3];
        ArraysKt.copyInto(iArr, iArr2, 0, i, length);
        ArraysKt.copyInto(this.elements, iArr2, i2, 0, this.head);
        this.elements = iArr2;
        this.head = 0;
        this.tail = length;
        this.capacityBitmask = i3 - 1;
    }

    public final void addLast(int i) {
        int[] iArr = this.elements;
        int i2 = this.tail;
        iArr[i2] = i;
        int i3 = this.capacityBitmask & (i2 + 1);
        this.tail = i3;
        if (i3 == this.head) {
            doubleCapacity();
        }
    }

    public final int popFirst() {
        int i = this.head;
        if (i == this.tail) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        int i2 = this.elements[i];
        this.head = (i + 1) & this.capacityBitmask;
        return i2;
    }

    public final void clear() {
        this.tail = this.head;
    }

    public final boolean isEmpty() {
        return this.head == this.tail;
    }
}
