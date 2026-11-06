package app.screeb.sdk.internal;

import android.os.Handler;
import android.os.HandlerThread;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: renamed from: app.screeb.sdk.internal.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0319s {
    public final B a;
    public HandlerThread b;
    public Handler c;
    public ByteBuffer d;
    public O e;
    public long f;
    public final ArrayDeque g;
    public volatile boolean h;
    public final Object i;
    public final AtomicBoolean j;
    public final java.util.ArrayDeque k;
    public final r l;
    public final Runnable m;

    public C0319s(B sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        this.a = sink;
        this.g = new ArrayDeque(4);
        this.i = new Object();
        this.j = new AtomicBoolean(false);
        this.k = new java.util.ArrayDeque(4);
        this.l = new r(this);
        this.m = new Runnable() { // from class: app.screeb.sdk.internal.s$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C0319s.a(this.f$0);
            }
        };
    }

    public static final void a(C0319s c0319s) {
        c0319s.a();
    }

    public static final void a(C0319s c0319s, byte[] bArr) {
        c0319s.getClass();
        if (bArr.length > 262144) {
            return;
        }
        synchronized (c0319s.k) {
            try {
                if (c0319s.k.size() < 4) {
                    c0319s.k.addLast(bArr);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(byte[] bArr, int i, int i2, int i3) {
        bArr[0] = 83;
        bArr[1] = 82;
        bArr[2] = 1;
        bArr[3] = 0;
        bArr[4] = (byte) (i & 255);
        bArr[5] = (byte) ((i >> 8) & 255);
        bArr[6] = (byte) ((i >> 16) & 255);
        bArr[7] = (byte) ((i >> 24) & 255);
        bArr[8] = (byte) (i2 & 255);
        bArr[9] = (byte) ((i2 >> 8) & 255);
        bArr[10] = (byte) (i3 & 255);
        bArr[11] = (byte) ((i3 >> 8) & 255);
    }

    public final void a() {
        ByteBuffer byteBufferC;
        O oB;
        long jA;
        this.j.set(false);
        while (true) {
            synchronized (this.i) {
                try {
                    if (!this.h) {
                        return;
                    }
                    C0318q c0318q = (C0318q) this.g.removeFirstOrNull();
                    if (c0318q != null) {
                        byteBufferC = c0318q.c();
                        oB = c0318q.b();
                        jA = c0318q.a();
                    } else {
                        byteBufferC = this.d;
                        if (byteBufferC == null) {
                            return;
                        }
                        oB = this.e;
                        if (oB == null) {
                            return;
                        }
                        jA = this.f;
                        this.d = null;
                        this.e = null;
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
            try {
                a(byteBufferC, jA);
            } catch (Throwable th2) {
                try {
                    Z z = Z.b;
                    Y.a();
                    Z z2 = Z.b;
                    Z.a("Mirror", "encode failed — dropping frame #" + jA, th2, 8);
                    b();
                } catch (Throwable th3) {
                    oB.a(byteBufferC);
                    throw th3;
                }
            }
            oB.a(byteBufferC);
        }
    }

    public final void a(ByteBuffer payload, long j) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        ByteBuffer byteBufferDuplicate = payload.duplicate();
        int iRemaining = byteBufferDuplicate.remaining();
        int iCoerceAtLeast = RangesKt.coerceAtLeast((262131 + iRemaining) / 262132, 1);
        if (iCoerceAtLeast > 65535) {
            return;
        }
        int i = (int) j;
        int i2 = 0;
        if (iCoerceAtLeast == 1) {
            int i3 = iRemaining + 12;
            byte[] bArrA = a(i3);
            a(bArrA, i, 0, 1);
            if (iRemaining > 0) {
                byteBufferDuplicate.get(bArrA, 12, iRemaining);
            }
            this.a.invoke(new C0316o(bArrA, i3, this.l));
            return;
        }
        int i4 = 0;
        while (i2 < iRemaining) {
            int iCoerceAtMost = RangesKt.coerceAtMost(iRemaining - i2, 262132);
            int i5 = iCoerceAtMost + 12;
            byte[] bArrA2 = a(i5);
            a(bArrA2, i, i4, iCoerceAtLeast);
            int i6 = i2 + iCoerceAtMost;
            byteBufferDuplicate.limit(i6);
            byteBufferDuplicate.position(i2);
            byteBufferDuplicate.get(bArrA2, 12, iCoerceAtMost);
            this.a.invoke(new C0316o(bArrA2, i5, this.l));
            i4++;
            i2 = i6;
        }
    }

    public final boolean a(O stream, long j, EnumC0317p channel) {
        boolean z;
        Intrinsics.checkNotNullParameter(stream, "stream");
        Intrinsics.checkNotNullParameter(channel, "channel");
        if (stream.b()) {
            return false;
        }
        ByteBuffer byteBufferA = stream.a();
        synchronized (this.i) {
            Handler handler = this.c;
            if (handler == null) {
                stream.a(byteBufferA);
                return false;
            }
            int iOrdinal = channel.ordinal();
            if (iOrdinal == 0) {
                ByteBuffer byteBuffer = this.d;
                if (byteBuffer != null) {
                    O o = this.e;
                    if (o != null) {
                        o.a(byteBuffer);
                    }
                    z = true;
                } else {
                    z = false;
                }
                this.d = byteBufferA;
                this.e = stream;
                this.f = j;
            } else {
                if (iOrdinal != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                if (this.g.size() >= 4) {
                    C0318q c0318q = (C0318q) this.g.removeFirst();
                    c0318q.b().a(c0318q.c());
                    Z z2 = Z.b;
                    Y.a();
                    Z.b("Mirror", "visual encode queue full — dropped frame #" + c0318q.a());
                    z = true;
                } else {
                    z = false;
                }
                this.g.addLast(new C0318q(byteBufferA, stream, j));
            }
            Unit unit = Unit.INSTANCE;
            if (this.j.compareAndSet(false, true)) {
                handler.post(this.m);
            }
            return z;
        }
    }

    public final byte[] a(int i) {
        synchronized (this.k) {
            Iterator it = this.k.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                byte[] bArr = (byte[]) it.next();
                if (bArr.length == i) {
                    it.remove();
                    Intrinsics.checkNotNull(bArr);
                    return bArr;
                }
            }
            Unit unit = Unit.INSTANCE;
            return new byte[i];
        }
    }

    public final void b() {
        ByteBuffer byteBuffer;
        synchronized (this.i) {
            try {
                O o = this.e;
                if (o != null && (byteBuffer = this.d) != null) {
                    o.a(byteBuffer);
                }
                this.d = null;
                this.e = null;
                while (!this.g.isEmpty()) {
                    C0318q c0318q = (C0318q) this.g.removeFirst();
                    c0318q.b.a(c0318q.a);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c() {
        HandlerThread handlerThread;
        ByteBuffer byteBuffer;
        synchronized (this.i) {
            try {
                O o = this.e;
                if (o != null && (byteBuffer = this.d) != null) {
                    o.a(byteBuffer);
                }
                this.d = null;
                this.e = null;
                while (!this.g.isEmpty()) {
                    C0318q c0318q = (C0318q) this.g.removeFirst();
                    c0318q.b.a(c0318q.a);
                }
                this.h = false;
                this.c = null;
                handlerThread = this.b;
                this.b = null;
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.j.set(false);
        if (handlerThread != null) {
            try {
                handlerThread.quitSafely();
            } catch (Throwable unused) {
            }
        }
        synchronized (this.k) {
            this.k.clear();
            Unit unit2 = Unit.INSTANCE;
        }
    }
}
