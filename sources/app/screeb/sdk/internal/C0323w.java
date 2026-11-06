package app.screeb.sdk.internal;

import kotlin.collections.ArraysKt;

/* JADX INFO: renamed from: app.screeb.sdk.internal.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0323w {
    public long[] a;
    public int[] b;
    public int c;
    public int d;

    public C0323w(int i) {
        int i2 = (i < 16 ? 16 : i) - 1;
        int i3 = i2 | (i2 >>> 1);
        int i4 = i3 | (i3 >>> 2);
        int i5 = i4 | (i4 >>> 4);
        int i6 = i5 | (i5 >>> 8);
        int i7 = i6 | (i6 >>> 16);
        int i8 = i7 + 1;
        long[] jArr = new long[i8];
        this.a = jArr;
        this.b = new int[i8];
        this.c = i7;
        ArraysKt.fill$default(jArr, Long.MIN_VALUE, 0, 0, 6, (Object) null);
    }

    public static int b(long j) {
        long j2 = (j ^ (j >>> 33)) * (-49064778989728563L);
        long j3 = (j2 ^ (j2 >>> 33)) * (-4265267296991594537L);
        return (int) (j3 ^ (j3 >>> 33));
    }

    public final int a(long j) {
        int iB = b(j);
        while (true) {
            int i = iB & this.c;
            long j2 = this.a[i];
            if (j2 == Long.MIN_VALUE) {
                return -1;
            }
            if (j2 == j) {
                return this.b[i];
            }
            iB = i + 1;
        }
    }

    public final void a() {
        if (this.d == 0) {
            return;
        }
        ArraysKt.fill$default(this.a, Long.MIN_VALUE, 0, 0, 6, (Object) null);
        this.d = 0;
    }

    public final void a(long j, int i) {
        int i2 = this.d * 2;
        long[] jArr = this.a;
        if (i2 >= jArr.length) {
            int[] iArr = this.b;
            int length = jArr.length * 2;
            long[] jArr2 = new long[length];
            ArraysKt.fill$default(jArr2, Long.MIN_VALUE, 0, 0, 6, (Object) null);
            this.a = jArr2;
            this.b = new int[length];
            this.c = length - 1;
            this.d = 0;
            int length2 = jArr.length;
            for (int i3 = 0; i3 < length2; i3++) {
                long j2 = jArr[i3];
                if (j2 != Long.MIN_VALUE) {
                    a(j2, iArr[i3]);
                }
            }
        }
        int iB = b(j);
        while (true) {
            int i4 = iB & this.c;
            long[] jArr3 = this.a;
            long j3 = jArr3[i4];
            if (j3 == Long.MIN_VALUE) {
                jArr3[i4] = j;
                this.b[i4] = i;
                this.d++;
                return;
            } else {
                if (j3 == j) {
                    this.b[i4] = i;
                    return;
                }
                iB = i4 + 1;
            }
        }
    }
}
