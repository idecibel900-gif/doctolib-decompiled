package app.screeb.sdk.internal;

import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: app.screeb.sdk.internal.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0308j {
    public C0323w a = new C0323w(IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER);
    public C0323w b = new C0323w(IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER);
    public N c;

    public static void a(N n, int i, int i2, O o) {
        if ((i2 & 4) != 0) {
            a(o, n.p, n.f[i], n.g[i]);
        }
        if ((i2 & 1) != 0) {
            a(o, n.q, n.h[i], n.i[i]);
        }
        if ((i2 & 2) != 0) {
            a(o, n.q, n.j[i], n.k[i]);
        }
        if ((i2 & 8) != 0) {
            a(o, n.q, n.l[i], n.m[i]);
        }
    }

    public static void a(N n, int i, O o) {
        o.a((byte) 1, n.b[i]);
        byte b = n.d[i];
        o.a(1);
        o.a.put(b);
        o.a(n.c[i]);
        o.b(n.o[i]);
        int i2 = n.e[i] & 255;
        o.a(1);
        o.a.put((byte) i2);
        a(n, i, i2, o);
    }

    public static void a(O o, StringBuilder arena, int i, int i2) {
        if (i < 0 || i2 <= 0) {
            o.b(0L);
            return;
        }
        o.getClass();
        Intrinsics.checkNotNullParameter(arena, "arena");
        if (i2 <= 0) {
            o.b(0L);
            return;
        }
        int iMaxBytesPerChar = (int) ((o.c.maxBytesPerChar() * i2) + 1);
        if (o.d.capacity() < iMaxBytesPerChar) {
            o.d = ByteBuffer.allocate(iMaxBytesPerChar * 2);
        }
        o.d.clear();
        o.c.reset();
        o.c.encode(CharBuffer.wrap(arena, i, i2 + i), o.d, true);
        o.c.flush(o.d);
        int iPosition = o.d.position();
        o.d.flip();
        o.a(iPosition + 10);
        ByteBuffer buf = o.a;
        long j = iPosition;
        Intrinsics.checkNotNullParameter(buf, "buf");
        while (((-128) & j) != 0) {
            buf.put((byte) ((127 & j) | 128));
            j >>>= 7;
        }
        buf.put((byte) (j & 127));
        o.a.put(o.d);
    }

    public static boolean a(StringBuilder sb, int i, int i2, StringBuilder sb2, int i3, int i4) {
        if (i2 != i4) {
            return false;
        }
        if (i2 <= 0) {
            return true;
        }
        for (int i5 = 0; i5 < i2; i5++) {
            if (sb.charAt(i + i5) != sb2.charAt(i3 + i5)) {
                return false;
            }
        }
        return true;
    }

    public final void a(N n, N current, O out, boolean z) {
        Intrinsics.checkNotNullParameter(current, "current");
        Intrinsics.checkNotNullParameter(out, "out");
        int i = 0;
        if (z || n == null || n.a == 0) {
            this.c = null;
            out.a((byte) 0, 0L);
            int i2 = current.a;
            while (i < i2) {
                a(current, i, out);
                i++;
            }
            return;
        }
        if (n == this.c) {
            C0323w c0323w = this.a;
            this.a = this.b;
            this.b = c0323w;
            c0323w.a();
            int i3 = current.a;
            for (int i4 = 0; i4 < i3; i4++) {
                this.b.a(current.b[i4], i4);
            }
        } else {
            this.a.a();
            this.b.a();
            int i5 = n.a;
            for (int i6 = 0; i6 < i5; i6++) {
                this.a.a(n.b[i6], i6);
            }
            int i7 = current.a;
            for (int i8 = 0; i8 < i7; i8++) {
                this.b.a(current.b[i8], i8);
            }
        }
        this.c = current;
        int i9 = current.a;
        for (int i10 = 0; i10 < i9; i10++) {
            long j = current.b[i10];
            int iA = this.a.a(j);
            if (iA < 0) {
                a(current, i10, out);
            } else {
                if (current.c[i10] != n.c[iA] || current.o[i10] != n.o[iA]) {
                    out.a((byte) 4, j);
                    out.a(current.c[i10]);
                    out.b(current.o[i10]);
                }
                if (current.n[i10] != n.n[iA]) {
                    int i11 = a(current.p, current.f[i10], current.g[i10], n.p, n.f[iA], n.g[iA]) ? 0 : 4;
                    if (!a(current.q, current.l[i10], current.m[i10], n.q, n.l[iA], n.m[iA])) {
                        i11 |= 8;
                    }
                    if (!a(current.q, current.h[i10], current.i[i10], n.q, n.h[iA], n.i[iA])) {
                        i11 |= 1;
                    }
                    if (!a(current.q, current.j[i10], current.k[i10], n.q, n.j[iA], n.k[iA])) {
                        i11 |= 2;
                    }
                    if (i11 != 0) {
                        out.a((byte) 2, current.b[i10]);
                        out.a(1);
                        out.a.put((byte) i11);
                        a(current, i10, i11, out);
                    }
                }
            }
        }
        int i12 = n.a;
        while (i < i12) {
            long j2 = n.b[i];
            if (this.b.a(j2) < 0) {
                out.a((byte) 3, j2);
            }
            i++;
        }
    }
}
