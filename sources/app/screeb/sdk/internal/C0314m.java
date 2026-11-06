package app.screeb.sdk.internal;

import android.graphics.Rect;
import java.util.BitSet;
import kotlin.ranges.RangesKt;

/* JADX INFO: renamed from: app.screeb.sdk.internal.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0314m {
    public int h;
    public BitSet a = new BitSet();
    public BitSet b = new BitSet();
    public final Rect c = new Rect();
    public int[] d = new int[64];
    public int[] e = new int[64];
    public int[] f = new int[64];
    public int[] g = new int[64];
    public int i = Integer.MAX_VALUE;
    public int j = -1;
    public int k = Integer.MAX_VALUE;
    public int l = -1;

    public final int a() {
        return this.l;
    }

    public final void a(double d, int i, int i2) {
        int i3 = this.h;
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = this.d[i4];
            int i6 = (int) (((double) this.e[i4]) * d);
            int iCoerceAtLeast = RangesKt.coerceAtLeast(((int) (((double) i5) * d)) / 64, 0);
            int iCoerceAtMost = RangesKt.coerceAtMost((i6 + 63) / 64, i - 1);
            if (iCoerceAtLeast <= iCoerceAtMost) {
                this.a.set(iCoerceAtLeast, iCoerceAtMost + 1);
            }
            int i7 = this.f[i4];
            int i8 = (int) (((double) this.g[i4]) * d);
            int iCoerceAtLeast2 = RangesKt.coerceAtLeast(((int) (((double) i7) * d)) / 64, 0);
            int iCoerceAtMost2 = RangesKt.coerceAtMost((i8 + 63) / 64, i2 - 1);
            if (iCoerceAtLeast2 <= iCoerceAtMost2) {
                if (iCoerceAtLeast2 < this.i) {
                    this.i = iCoerceAtLeast2;
                }
                if (iCoerceAtMost2 > this.j) {
                    this.j = iCoerceAtMost2;
                }
            }
        }
        this.h = 0;
    }

    public final int b() {
        return this.k;
    }

    public final BitSet c() {
        this.k = this.i;
        this.l = this.j;
        this.i = Integer.MAX_VALUE;
        this.j = -1;
        BitSet bitSet = this.a;
        BitSet bitSet2 = this.b;
        bitSet2.clear();
        this.a = bitSet2;
        this.b = bitSet;
        return bitSet;
    }
}
