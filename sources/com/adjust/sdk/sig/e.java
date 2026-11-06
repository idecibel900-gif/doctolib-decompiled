package com.adjust.sdk.sig;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends AbstractList implements List, q1 {
    public static final Object[] d = new Object[0];
    public int a;
    public Object[] b = d;
    public int c;

    public final void a(int i) {
        if (i < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.b;
        if (i <= objArr.length) {
            return;
        }
        if (objArr == d) {
            if (i < 10) {
                i = 10;
            }
            this.b = new Object[i];
            return;
        }
        int length = objArr.length;
        int i2 = length + (length >> 1);
        if (i2 - i < 0) {
            i2 = i;
        }
        if (i2 - 2147483639 > 0) {
            i2 = i > 2147483639 ? Integer.MAX_VALUE : 2147483639;
        }
        Object[] objArr2 = new Object[i2];
        int i3 = this.a;
        System.arraycopy(objArr, i3, objArr2, 0, objArr.length - i3);
        Object[] objArr3 = this.b;
        int length2 = objArr3.length;
        int i4 = this.a;
        System.arraycopy(objArr3, 0, objArr2, length2 - i4, i4);
        this.a = 0;
        this.b = objArr2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i2 = this.c;
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException("index: " + i + ", size: " + i2);
        }
        if (i == i2) {
            addLast(obj);
            return;
        }
        if (i == 0) {
            addFirst(obj);
            return;
        }
        ((AbstractList) this).modCount++;
        a(i2 + 1);
        int iC = c(this.a + i);
        int i3 = this.c;
        int i4 = (i3 + 1) >> 1;
        int i5 = this.a;
        if (i < i4) {
            int length = iC == 0 ? this.b.length - 1 : iC - 1;
            int length2 = i5 == 0 ? this.b.length - 1 : i5 - 1;
            Object[] objArr = this.b;
            if (length >= i5) {
                objArr[length2] = objArr[i5];
                int i6 = i5 + 1;
                System.arraycopy(objArr, i6, objArr, i5, (length + 1) - i6);
            } else {
                System.arraycopy(objArr, i5, objArr, i5 - 1, objArr.length - i5);
                Object[] objArr2 = this.b;
                objArr2[objArr2.length - 1] = objArr2[0];
                System.arraycopy(objArr2, 1, objArr2, 0, length);
            }
            this.b[length] = obj;
            this.a = length2;
        } else {
            int iC2 = c(i5 + i3);
            Object[] objArr3 = this.b;
            if (iC < iC2) {
                System.arraycopy(objArr3, iC, objArr3, iC + 1, iC2 - iC);
            } else {
                System.arraycopy(objArr3, 0, objArr3, 1, iC2);
                Object[] objArr4 = this.b;
                objArr4[0] = objArr4[objArr4.length - 1];
                System.arraycopy(objArr4, iC, objArr4, iC + 1, (objArr4.length - 1) - iC);
            }
            this.b[iC] = obj;
        }
        this.c++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        int i2 = this.c;
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException("index: " + i + ", size: " + i2);
        }
        if (collection.isEmpty()) {
            return false;
        }
        int i3 = this.c;
        if (i == i3) {
            return addAll(collection);
        }
        ((AbstractList) this).modCount++;
        a(collection.size() + i3);
        int iC = c(this.a + this.c);
        int iC2 = c(this.a + i);
        int size = collection.size();
        if (i < ((this.c + 1) >> 1)) {
            int i4 = this.a;
            int length = i4 - size;
            if (iC2 >= i4) {
                Object[] objArr = this.b;
                if (length >= 0) {
                    System.arraycopy(objArr, i4, objArr, length, iC2 - i4);
                } else {
                    length += objArr.length;
                    int i5 = iC2 - i4;
                    int length2 = objArr.length - length;
                    if (length2 >= i5) {
                        System.arraycopy(objArr, i4, objArr, length, i5);
                    } else {
                        System.arraycopy(objArr, i4, objArr, length, (i4 + length2) - i4);
                        Object[] objArr2 = this.b;
                        int i6 = this.a + length2;
                        System.arraycopy(objArr2, i6, objArr2, 0, iC2 - i6);
                    }
                }
            } else {
                Object[] objArr3 = this.b;
                System.arraycopy(objArr3, i4, objArr3, length, objArr3.length - i4);
                Object[] objArr4 = this.b;
                if (size >= iC2) {
                    System.arraycopy(objArr4, 0, objArr4, objArr4.length - size, iC2);
                } else {
                    System.arraycopy(objArr4, 0, objArr4, objArr4.length - size, size);
                    Object[] objArr5 = this.b;
                    System.arraycopy(objArr5, size, objArr5, 0, iC2 - size);
                }
            }
            this.a = length;
            a(b(iC2 - size), collection);
        } else {
            int i7 = iC2 + size;
            Object[] objArr6 = this.b;
            if (iC2 < iC) {
                int i8 = size + iC;
                if (i8 <= objArr6.length) {
                    System.arraycopy(objArr6, iC2, objArr6, i7, iC - iC2);
                } else if (i7 >= objArr6.length) {
                    System.arraycopy(objArr6, iC2, objArr6, i7 - objArr6.length, iC - iC2);
                } else {
                    int length3 = iC - (i8 - objArr6.length);
                    System.arraycopy(objArr6, length3, objArr6, 0, iC - length3);
                    Object[] objArr7 = this.b;
                    System.arraycopy(objArr7, iC2, objArr7, i7, length3 - iC2);
                }
            } else {
                System.arraycopy(objArr6, 0, objArr6, size, iC);
                Object[] objArr8 = this.b;
                if (i7 >= objArr8.length) {
                    System.arraycopy(objArr8, iC2, objArr8, i7 - objArr8.length, objArr8.length - iC2);
                } else {
                    int length4 = objArr8.length - size;
                    System.arraycopy(objArr8, length4, objArr8, 0, objArr8.length - length4);
                    Object[] objArr9 = this.b;
                    System.arraycopy(objArr9, iC2, objArr9, i7, (objArr9.length - size) - iC2);
                }
            }
            a(iC2, collection);
        }
        return true;
    }

    public final void addFirst(Object obj) {
        ((AbstractList) this).modCount++;
        a(this.c + 1);
        int length = this.a;
        if (length == 0) {
            length = this.b.length;
        }
        int i = length - 1;
        this.a = i;
        this.b[i] = obj;
        this.c++;
    }

    public final void addLast(Object obj) {
        ((AbstractList) this).modCount++;
        a(this.c + 1);
        this.b[c(this.a + this.c)] = obj;
        this.c++;
    }

    public final int b(int i) {
        return i < 0 ? i + this.b.length : i;
    }

    public final int c(int i) {
        Object[] objArr = this.b;
        return i >= objArr.length ? i - objArr.length : i;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        if (!isEmpty()) {
            ((AbstractList) this).modCount++;
            int iC = c(this.a + this.c);
            int i = this.a;
            Object[] objArr = this.b;
            if (i < iC) {
                Arrays.fill(objArr, i, iC, (Object) null);
            } else {
                Arrays.fill(objArr, i, objArr.length, (Object) null);
                Arrays.fill(this.b, 0, iC, (Object) null);
            }
        }
        this.a = 0;
        this.c = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final Object d(int i) {
        int i2 = this.c;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException("index: " + i + ", size: " + i2);
        }
        if (i == i2 - 1) {
            return removeLast();
        }
        if (i == 0) {
            return removeFirst();
        }
        ((AbstractList) this).modCount++;
        int iC = c(this.a + i);
        Object[] objArr = this.b;
        Object obj = objArr[iC];
        int i3 = this.c;
        int i4 = i3 >> 1;
        int i5 = this.a;
        if (i < i4) {
            if (iC >= i5) {
                System.arraycopy(objArr, i5, objArr, i5 + 1, iC - i5);
            } else {
                System.arraycopy(objArr, 0, objArr, 1, iC);
                Object[] objArr2 = this.b;
                objArr2[0] = objArr2[objArr2.length - 1];
                int i6 = this.a;
                System.arraycopy(objArr2, i6, objArr2, i6 + 1, (objArr2.length - 1) - i6);
            }
            Object[] objArr3 = this.b;
            int i7 = this.a;
            objArr3[i7] = null;
            this.a = i7 != objArr3.length - 1 ? i7 + 1 : 0;
        } else {
            int iC2 = c((i3 - 1) + i5);
            Object[] objArr4 = this.b;
            if (iC <= iC2) {
                int i8 = iC + 1;
                System.arraycopy(objArr4, i8, objArr4, iC, (iC2 + 1) - i8);
            } else {
                int i9 = iC + 1;
                System.arraycopy(objArr4, i9, objArr4, iC, objArr4.length - i9);
                Object[] objArr5 = this.b;
                objArr5[objArr5.length - 1] = objArr5[0];
                System.arraycopy(objArr5, 1, objArr5, 0, iC2);
            }
            this.b[iC2] = null;
        }
        this.c--;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        int i2 = this.c;
        if (i >= 0 && i < i2) {
            return this.b[c(this.a + i)];
        }
        throw new IndexOutOfBoundsException("index: " + i + ", size: " + i2);
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        int i;
        int iC = c(this.a + this.c);
        int length = this.a;
        if (length < iC) {
            while (length < iC) {
                if (g1.a(obj, this.b[length])) {
                    i = this.a;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < iC) {
            return -1;
        }
        int length2 = this.b.length;
        while (length < length2) {
            if (g1.a(obj, this.b[length])) {
                i = this.a;
            } else {
                length++;
            }
        }
        for (int i2 = 0; i2 < iC; i2++) {
            if (g1.a(obj, this.b[i2])) {
                length = i2 + this.b.length;
                i = this.a;
            }
        }
        return -1;
        return length - i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.c == 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        Object[] objArr;
        int length;
        int i;
        int iC = c(this.a + this.c);
        int i2 = this.a;
        if (i2 < iC) {
            length = iC - 1;
            if (i2 <= length) {
                while (!g1.a(obj, this.b[length])) {
                    if (length != i2) {
                        length--;
                    }
                }
                i = this.a;
                return length - i;
            }
            return -1;
        }
        if (i2 > iC) {
            do {
                iC--;
                objArr = this.b;
                if (-1 >= iC) {
                    length = objArr.length - 1;
                    int i3 = this.a;
                    if (i3 <= length) {
                        while (!g1.a(obj, this.b[length])) {
                            if (length != i3) {
                                length--;
                            }
                        }
                        i = this.a;
                    }
                }
                return length - i;
            } while (!g1.a(obj, objArr[iC]));
            length = iC + this.b.length;
            i = this.a;
            return length - i;
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ Object remove(int i) {
        return d(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        int iC;
        Object[] objArr;
        boolean z = false;
        if (!isEmpty() && this.b.length != 0) {
            int iC2 = c(this.a + this.c);
            int i = this.a;
            if (i < iC2) {
                iC = i;
                while (true) {
                    objArr = this.b;
                    if (i >= iC2) {
                        break;
                    }
                    Object obj = objArr[i];
                    if (collection.contains(obj)) {
                        z = true;
                    } else {
                        this.b[iC] = obj;
                        iC++;
                    }
                    i++;
                }
                Arrays.fill(objArr, iC, iC2, (Object) null);
            } else {
                int length = this.b.length;
                boolean z2 = false;
                int i2 = i;
                while (i < length) {
                    Object[] objArr2 = this.b;
                    Object obj2 = objArr2[i];
                    objArr2[i] = null;
                    if (collection.contains(obj2)) {
                        z2 = true;
                    } else {
                        this.b[i2] = obj2;
                        i2++;
                    }
                    i++;
                }
                iC = c(i2);
                for (int i3 = 0; i3 < iC2; i3++) {
                    Object[] objArr3 = this.b;
                    Object obj3 = objArr3[i3];
                    objArr3[i3] = null;
                    if (collection.contains(obj3)) {
                        z2 = true;
                    } else {
                        Object[] objArr4 = this.b;
                        objArr4[iC] = obj3;
                        iC = iC == objArr4.length - 1 ? 0 : iC + 1;
                    }
                }
                z = z2;
            }
            if (z) {
                ((AbstractList) this).modCount++;
                this.c = b(iC - this.a);
            }
        }
        return z;
    }

    public final Object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        ((AbstractList) this).modCount++;
        Object[] objArr = this.b;
        int i = this.a;
        Object obj = objArr[i];
        objArr[i] = null;
        this.a = i == objArr.length + (-1) ? 0 : i + 1;
        this.c--;
        return obj;
    }

    public final Object removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        ((AbstractList) this).modCount++;
        int iC = c((size() - 1) + this.a);
        Object[] objArr = this.b;
        Object obj = objArr[iC];
        objArr[iC] = null;
        this.c--;
        return obj;
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        int i3 = this.c;
        if (i < 0 || i2 > i3) {
            throw new IndexOutOfBoundsException("fromIndex: " + i + ", toIndex: " + i2 + ", size: " + i3);
        }
        if (i > i2) {
            throw new IllegalArgumentException("fromIndex: " + i + " > toIndex: " + i2);
        }
        int i4 = i2 - i;
        if (i4 == 0) {
            return;
        }
        if (i4 == i3) {
            clear();
            return;
        }
        if (i4 == 1) {
            d(i);
            return;
        }
        ((AbstractList) this).modCount++;
        int i5 = i3 - i2;
        int i6 = this.a;
        if (i < i5) {
            int iC = c((i - 1) + i6);
            int iC2 = c(this.a + (i2 - 1));
            while (i > 0) {
                int i7 = iC + 1;
                int iMin = Math.min(i, Math.min(i7, iC2 + 1));
                Object[] objArr = this.b;
                int i8 = iC2 - iMin;
                int i9 = iC - iMin;
                int i10 = i9 + 1;
                System.arraycopy(objArr, i10, objArr, i8 + 1, i7 - i10);
                iC = b(i9);
                iC2 = b(i8);
                i -= iMin;
            }
            int iC3 = c(this.a + i4);
            int i11 = this.a;
            Object[] objArr2 = this.b;
            if (i11 < iC3) {
                Arrays.fill(objArr2, i11, iC3, (Object) null);
            } else {
                Arrays.fill(objArr2, i11, objArr2.length, (Object) null);
                Arrays.fill(this.b, 0, iC3, (Object) null);
            }
            this.a = iC3;
        } else {
            int iC4 = c(i6 + i2);
            int iC5 = c(this.a + i);
            int i12 = this.c;
            while (true) {
                i12 -= i2;
                if (i12 <= 0) {
                    break;
                }
                Object[] objArr3 = this.b;
                i2 = Math.min(i12, Math.min(objArr3.length - iC4, objArr3.length - iC5));
                Object[] objArr4 = this.b;
                int i13 = iC4 + i2;
                System.arraycopy(objArr4, iC4, objArr4, iC5, i13 - iC4);
                iC4 = c(i13);
                iC5 = c(iC5 + i2);
            }
            int iC6 = c(this.a + this.c);
            int iB = b(iC6 - i4);
            Object[] objArr5 = this.b;
            if (iB < iC6) {
                Arrays.fill(objArr5, iB, iC6, (Object) null);
            } else {
                Arrays.fill(objArr5, iB, objArr5.length, (Object) null);
                Arrays.fill(this.b, 0, iC6, (Object) null);
            }
        }
        this.c -= i4;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        int iC;
        Object[] objArr;
        boolean z = false;
        if (!isEmpty() && this.b.length != 0) {
            int iC2 = c(this.a + this.c);
            int i = this.a;
            if (i < iC2) {
                iC = i;
                while (true) {
                    objArr = this.b;
                    if (i >= iC2) {
                        break;
                    }
                    Object obj = objArr[i];
                    if (collection.contains(obj)) {
                        this.b[iC] = obj;
                        iC++;
                    } else {
                        z = true;
                    }
                    i++;
                }
                Arrays.fill(objArr, iC, iC2, (Object) null);
            } else {
                int length = this.b.length;
                boolean z2 = false;
                int i2 = i;
                while (i < length) {
                    Object[] objArr2 = this.b;
                    Object obj2 = objArr2[i];
                    objArr2[i] = null;
                    if (collection.contains(obj2)) {
                        this.b[i2] = obj2;
                        i2++;
                    } else {
                        z2 = true;
                    }
                    i++;
                }
                iC = c(i2);
                for (int i3 = 0; i3 < iC2; i3++) {
                    Object[] objArr3 = this.b;
                    Object obj3 = objArr3[i3];
                    objArr3[i3] = null;
                    if (collection.contains(obj3)) {
                        Object[] objArr4 = this.b;
                        objArr4[iC] = obj3;
                        iC = iC == objArr4.length - 1 ? 0 : iC + 1;
                    } else {
                        z2 = true;
                    }
                }
                z = z2;
            }
            if (z) {
                ((AbstractList) this).modCount++;
                this.c = b(iC - this.a);
            }
        }
        return z;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        int i2 = this.c;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException("index: " + i + ", size: " + i2);
        }
        int iC = c(this.a + i);
        Object[] objArr = this.b;
        Object obj2 = objArr[iC];
        objArr[iC] = obj;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return toArray(new Object[this.c]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        d(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        int length = objArr.length;
        int i = this.c;
        if (length < i) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
        }
        int iC = c(this.a + this.c);
        int i2 = this.a;
        if (i2 < iC) {
            System.arraycopy(this.b, i2, objArr, 0, iC - i2);
        } else if (!isEmpty()) {
            Object[] objArr2 = this.b;
            int i3 = this.a;
            System.arraycopy(objArr2, i3, objArr, 0, objArr2.length - i3);
            Object[] objArr3 = this.b;
            System.arraycopy(objArr3, 0, objArr, objArr3.length - this.a, iC);
        }
        int i4 = this.c;
        if (i4 < objArr.length) {
            objArr[i4] = null;
        }
        return objArr;
    }

    public final void a(int i, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.b.length;
        while (i < length && it.hasNext()) {
            this.b[i] = it.next();
            i++;
        }
        int i2 = this.a;
        for (int i3 = 0; i3 < i2 && it.hasNext(); i3++) {
            this.b[i3] = it.next();
        }
        this.c = collection.size() + this.c;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        ((AbstractList) this).modCount++;
        a(collection.size() + this.c);
        a(c(this.a + this.c), collection);
        return true;
    }
}
