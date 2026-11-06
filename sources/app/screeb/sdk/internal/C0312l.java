package app.screeb.sdk.internal;

import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;

/* JADX INFO: renamed from: app.screeb.sdk.internal.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0312l {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    public final long k;

    public C0312l(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, long j) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
        this.g = i7;
        this.h = i8;
        this.i = i9;
        this.j = i10;
        this.k = j;
    }

    public /* synthetic */ C0312l(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j, int i10) {
        this(i, i2, i3, i4, i5, i6, i7, i8, i9, i9, (i10 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? 0L : j);
    }

    public static C0312l a(C0312l c0312l, int i, int i2, int i3, int i4, int i5) {
        int i6 = c0312l.a;
        int i7 = c0312l.b;
        int i8 = c0312l.c;
        int i9 = c0312l.d;
        if ((i5 & 16) != 0) {
            i = c0312l.e;
        }
        return new C0312l(i6, i7, i8, i9, i, (i5 & 32) != 0 ? c0312l.f : i2, c0312l.g, (i5 & 128) != 0 ? c0312l.h : i3, c0312l.i, (i5 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? c0312l.j : i4, c0312l.k);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0312l)) {
            return false;
        }
        C0312l c0312l = (C0312l) obj;
        return this.a == c0312l.a && this.b == c0312l.b && this.c == c0312l.c && this.d == c0312l.d && this.e == c0312l.e && this.f == c0312l.f && this.g == c0312l.g && this.h == c0312l.h && this.i == c0312l.i && this.j == c0312l.j && this.k == c0312l.k;
    }

    public final int hashCode() {
        return Long.hashCode(this.k) + AbstractC0310k.a(this.j, AbstractC0310k.a(this.i, AbstractC0310k.a(this.h, AbstractC0310k.a(this.g, AbstractC0310k.a(this.f, AbstractC0310k.a(this.e, AbstractC0310k.a(this.d, AbstractC0310k.a(this.c, AbstractC0310k.a(this.b, Integer.hashCode(this.a) * 31, 31), 31), 31), 31), 31), 31), 31), 31), 31);
    }

    public final String toString() {
        return "DirtyTileRect(bitmapX=" + this.a + ", bitmapY=" + this.b + ", worldX=" + this.c + ", worldY=" + this.d + ", w=" + this.e + ", h=" + this.f + ", tx0=" + this.g + ", tx1=" + this.h + ", ty=" + this.i + ", ty1=" + this.j + ", hash=" + this.k + ")";
    }
}
