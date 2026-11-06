package app.screeb.sdk.internal;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.revenuecat.purchases.common.networking.HTTPTimeoutManager;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes3.dex */
public final class J {
    public final n0 A;
    public final N A0;
    public final BitSet B;
    public final N B0;
    public Bitmap C;
    public N C0;
    public long D;
    public N D0;
    public final Canvas E;
    public final O E0;
    public final Rect F;
    public final O F0;
    public final Rect G;
    public final ArrayList G0;
    public final AtomicBoolean H;
    public final ArrayList H0;
    public final Handler I;
    public volatile boolean I0;
    public final Runnable J;
    public volatile boolean J0;
    public final Runnable K;
    public volatile boolean K0;
    public final Runnable L;
    public long L0;
    public final long M;
    public final AtomicBoolean M0;
    public final x0 N;
    public long N0;
    public final v0 O;
    public final AtomicInteger O0;
    public final AtomicBoolean P;
    public volatile long P0;
    public volatile boolean Q;
    public volatile long Q0;
    public volatile int R;
    public final AtomicInteger R0;
    public volatile int S;
    public final B0 S0;
    public volatile int T;
    public volatile boolean T0;
    public volatile int U;
    public int U0;
    public int V;
    public final int[] V0;
    public volatile boolean W;
    public volatile int W0;
    public final AtomicBoolean X;
    public final H X0;
    public volatile long Y;
    public long Y0;
    public final AtomicLong Z;
    public final Runnable Z0;
    public final WeakReference a;
    public volatile double a0;
    public volatile WeakReference b;
    public volatile long b0;
    public volatile U c;
    public long c0;
    public volatile boolean d;
    public volatile double d0;
    public volatile boolean e;
    public volatile String e0;
    public final C0296d f;
    public volatile int f0;
    public final K0 g;
    public volatile int g0;
    public final C0319s h;
    public volatile int h0;
    public final C0321u i;
    public volatile boolean i0;
    public final P j;
    public volatile int j0;
    public final C0307i0 k;
    public volatile int k0;
    public E0 l;
    public volatile int l0;
    public C0309j0 m;
    public volatile int m0;
    public final O n;
    public volatile int n0;
    public final O o;
    public volatile int o0;
    public final w0 p;
    public final ArrayList p0;
    public short[] q;
    public final HashMap q0;
    public int r;
    public int r0;
    public final C0323w s;
    public int[] s0;
    public final long[] t;
    public int[] t0;
    public final long[] u;
    public int[] u0;
    public final boolean[] v;
    public int[] v0;
    public int w;
    public int w0;
    public final Bitmap.CompressFormat x;
    public final C0308j x0;
    public final y0 y;
    public ExecutorService y0;
    public final C0314m z;
    public volatile Future z0;

    public J(WeakReference webViewRef) {
        K k;
        Intrinsics.checkNotNullParameter(webViewRef, "webViewRef");
        this.a = webViewRef;
        this.c = U.OUTLINE;
        this.f = new C0296d();
        P p = new P();
        this.j = p;
        C0307i0 c0307i0 = new C0307i0();
        this.k = c0307i0;
        int i = Build.VERSION.SDK_INT;
        this.m = i >= 26 ? new C0309j0() : null;
        this.n = new O(4096);
        this.o = new O(4096);
        this.p = new w0();
        this.q = new short[0];
        this.s = new C0323w(IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING);
        this.t = new long[IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER];
        this.u = new long[IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER];
        this.v = new boolean[IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER];
        this.x = i >= 30 ? Bitmap.CompressFormat.WEBP_LOSSY : Bitmap.CompressFormat.WEBP;
        this.y = new y0();
        this.z = new C0314m();
        this.A = new n0();
        this.B = new BitSet();
        this.D = -1L;
        this.E = new Canvas();
        this.F = new Rect();
        this.G = new Rect();
        this.H = new AtomicBoolean(false);
        this.I = new Handler(Looper.getMainLooper());
        this.J = new Runnable() { // from class: app.screeb.sdk.internal.J$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                J.h(this.f$0);
            }
        };
        this.K = new Runnable() { // from class: app.screeb.sdk.internal.J$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                J.a(this.f$0);
            }
        };
        this.L = new Runnable() { // from class: app.screeb.sdk.internal.J$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                J.b(this.f$0);
            }
        };
        this.M = 1000L;
        this.N = new x0();
        this.O = new v0();
        this.P = new AtomicBoolean(false);
        this.Q = true;
        this.X = new AtomicBoolean(false);
        this.Z = new AtomicLong(0L);
        this.e0 = "-";
        this.p0 = new ArrayList(4);
        this.q0 = new HashMap(4);
        this.s0 = new int[4];
        this.t0 = new int[4];
        this.u0 = new int[4];
        this.v0 = new int[4];
        this.x0 = new C0308j();
        N n = new N();
        this.A0 = n;
        this.B0 = new N();
        this.C0 = n;
        this.E0 = new O(8192);
        this.F0 = new O(IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER);
        this.G0 = new ArrayList(4);
        this.H0 = new ArrayList(64);
        this.I0 = true;
        this.M0 = new AtomicBoolean(false);
        this.O0 = new AtomicInteger(0);
        this.R0 = new AtomicInteger(0);
        B0 b0 = new B0(new I(this));
        b0.b = new Function2() { // from class: app.screeb.sdk.internal.J$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(J.a(this.f$0, ((Integer) obj).intValue(), ((Integer) obj2).intValue()));
            }
        };
        this.S0 = b0;
        WebView webView = (WebView) webViewRef.get();
        if (webView == null) {
            throw new IllegalStateException("WebView already collected");
        }
        K0 k0 = new K0(webView);
        this.g = k0;
        this.h = new C0319s(new B(k0));
        this.i = new C0321u(new C(this));
        int iOrdinal = this.c.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            k = c0307i0;
        }
        k = p;
        this.l = new E0(k);
        this.V0 = new int[2];
        this.W0 = 80;
        this.X0 = new H(this);
        this.Z0 = new Runnable() { // from class: app.screeb.sdk.internal.J$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                J.c(this.f$0);
            }
        };
    }

    public static final Thread a(Runnable runnable) {
        Thread thread = new Thread(runnable, "screeb-mirror-diff");
        try {
            thread.setPriority(4);
        } catch (Throwable unused) {
        }
        return thread;
    }

    public static ExecutorService a() {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: app.screeb.sdk.internal.J$$ExternalSyntheticLambda11
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return J.a(runnable);
            }
        });
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
        return executorServiceNewSingleThreadExecutor;
    }

    public static final Unit a(J j, int i, long j2, boolean z, double d, int i2, int i3, int[] iArr, E e, int i4, int i5, long j3, boolean z2, int i6, int i7, C0309j0 c0309j0, boolean z3, Bitmap bitmap) {
        boolean z4;
        boolean z5;
        J j4 = j;
        if (j4.R0.get() != i) {
            return Unit.INSTANCE;
        }
        try {
            try {
                j4.a0 = (SystemClock.elapsedRealtimeNanos() - j2) / 1000000.0d;
                try {
                    if (j4.d && bitmap != null) {
                        j4.a(true);
                        if (z) {
                            try {
                                j4.O.a(bitmap, d, i2, i3);
                            } catch (Throwable unused) {
                            }
                        }
                        try {
                            int[] iArr2 = T.d;
                            S.a(iArr, bitmap, d, i2, i3);
                        } catch (Throwable unused2) {
                        }
                        if (e != null) {
                            j4.a(bitmap, i4, i5, i3, e, j3);
                            j4.W = true;
                        } else if (z2) {
                            j4.W = !j4.a(bitmap, i4, i5, i3, i2, i6, i7, d, j3, true);
                        } else {
                            j4.a(bitmap, i4, i5, i3, i2, i6, i7, d, j3, false);
                            j4 = j;
                        }
                        j4.a(c0309j0, i6, i7, d, j3, iArr);
                        z5 = false;
                        j4.i0 = z3;
                        j4.P.set(z5);
                        return Unit.INSTANCE;
                    }
                    z4 = true;
                    if (j4.d && bitmap == null) {
                        j4.a(false);
                    }
                    j4.W = true;
                    try {
                        j4.a((G0) null, 0, 0, 0, 0.0d, true);
                        j4.e();
                        Unit unit = Unit.INSTANCE;
                        j4.i0 = z3;
                        j4.P.set(false);
                        j4.h();
                        return unit;
                    } catch (Throwable th) {
                        th = th;
                        j4 = j4;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                z4 = true;
            }
            Z z6 = Z.b;
            Y.a();
            Z.b("Mirror", "screenshot emit threw: " + th.getClass().getSimpleName());
            z5 = false;
            j4.a(false);
            j4.W = z4;
            j4.e();
            j4.i0 = z3;
            j4.P.set(z5);
            return Unit.INSTANCE;
        } finally {
            j4.i0 = z3;
            j4.P.set(false);
            j4.h();
        }
    }

    public static final Unit a(J j, int i, F f, int i2, int[] iArr, double d, r0 r0Var, t0 t0Var, long j2, Bitmap bitmap) {
        if (j.R0.get() != i) {
            return Unit.INSTANCE;
        }
        try {
            if (j.d && bitmap != null) {
                j.a(true);
                try {
                    int[] iArr2 = T.d;
                    S.a(iArr, bitmap, d, r0Var.a(), r0Var.b());
                } catch (Throwable unused) {
                }
                int iA = j.a(bitmap, r0Var.a(), r0Var.b(), t0Var.b(), f, j2, Math.max(j.R, r0Var.a() + bitmap.getWidth()), Math.max(j.S, r0Var.b() + bitmap.getHeight()));
                f.a(iA);
                j.U = i2 + iA;
                if (iA > 0) {
                    j.I.post(j.L);
                }
                return Unit.INSTANCE;
            }
            if (j.d && bitmap == null) {
                j.a(false);
            }
            f.a(0);
            j.U = i2;
            return Unit.INSTANCE;
        } catch (Throwable th) {
            Z z = Z.b;
            Y.a();
            Z.b("Mirror", "surface emit threw: " + th.getClass().getSimpleName());
            j.a(false);
        }
    }

    public static final void a(WebView webView, final String str, final Function0 function0, final J j) {
        try {
            webView.evaluateJavascript(str, new ValueCallback() { // from class: app.screeb.sdk.internal.J$$ExternalSyntheticLambda13
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) {
                    J.a(this.f$0, str, function0, (String) obj);
                }
            });
        } catch (Throwable th) {
            Z z = Z.b;
            Y.a();
            Z.b("Mirror", "failed to inject mirror runtime: " + th.getClass().getSimpleName());
            function0.invoke();
        }
    }

    public static final void a(J j) {
        j.R = 0;
        j.S = 0;
        j.T = 0;
        j.I0 = true;
        j.i.c();
    }

    public static final void a(J j, N n, N n2, boolean z, long j2) {
        j.a(n, n2, z, j2);
    }

    public static final void a(J j, String str, Function0 function0, String str2) {
        j.T0 = true;
        Z z = Z.b;
        Y.a();
        Z.a("Mirror", "mirror runtime injected (" + str.length() + " bytes)");
        function0.invoke();
    }

    public static void a(y0 y0Var, C0312l c0312l) {
        int i = c0312l.i;
        int i2 = c0312l.j;
        if (i > i2) {
            return;
        }
        while (true) {
            int i3 = c0312l.g;
            int i4 = c0312l.h;
            if (i3 <= i4) {
                while (true) {
                    int i5 = (y0Var.a * i) + i3;
                    y0Var.d[i5] = ~y0Var.c[i5];
                    if (i3 == i4) {
                        break;
                    } else {
                        i3++;
                    }
                }
            }
            if (i == i2) {
                return;
            } else {
                i++;
            }
        }
    }

    public static final boolean a(J j, int i, int i2) {
        Object obj = j.a.get();
        C0303g0 c0303g0 = obj instanceof C0303g0 ? (C0303g0) obj : null;
        if (c0303g0 != null && c0303g0.isShown()) {
            if (!c0303g0.l) {
                if (!c0303g0.h.isEmpty()) {
                    c0303g0.getLocationOnScreen(c0303g0.C);
                    int[] iArr = c0303g0.C;
                    int i3 = i - iArr[0];
                    int i4 = i2 - iArr[1];
                    for (Object obj2 : c0303g0.h.values()) {
                        Intrinsics.checkNotNullExpressionValue(obj2, "next(...)");
                        if (((Rect) obj2).contains(i3, i4)) {
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    public static final void b(J j) {
        j.i.c();
    }

    public static final void c(J j) {
        j.M0.set(false);
        if (j.d) {
            j.i.c();
        }
    }

    public static final Unit d(J j) {
        j.H.set(false);
        if (j.b0 > 0) {
            SystemClock.elapsedRealtimeNanos();
            j.b0 = 0L;
        }
        j.I.removeCallbacks(j.J);
        j.h();
        return Unit.INSTANCE;
    }

    public static final Unit e(J j) {
        j.R = 0;
        j.S = 0;
        j.T = 0;
        j.I0 = true;
        j.i.c();
        return Unit.INSTANCE;
    }

    public static final Unit f(J j) {
        j.g.a();
        return Unit.INSTANCE;
    }

    public static final void g(J j) {
        x0 x0Var = j.N;
        synchronized (x0Var.b) {
            while (!x0Var.b.isEmpty()) {
                try {
                    ((Bitmap) x0Var.b.removeFirst()).recycle();
                } catch (Throwable th) {
                    throw th;
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        Bitmap bitmap = j.C;
        if (bitmap != null) {
            bitmap.recycle();
        }
        j.C = null;
        j.D = -1L;
    }

    public static final void h(J j) {
        if (j.H.get()) {
            Z.b("Mirror", "ACK watchdog fired — forcing ackPending=false");
            j.H.set(false);
            j.R = 0;
            j.S = 0;
            j.T = 0;
            j.I0 = true;
            j.i.c();
        }
    }

    public final int a(Bitmap bitmap) {
        int rowBytes = bitmap.getRowBytes() / 2;
        int height = bitmap.getHeight() * rowBytes;
        if (this.q.length < height) {
            this.q = new short[height];
        }
        bitmap.copyPixelsToBuffer(ShortBuffer.wrap(this.q, 0, height));
        this.r = rowBytes;
        return rowBytes;
    }

    public final int a(Bitmap bitmap, int i, int i2, int i3, F f, long j, int i4, int i5) {
        int iMin;
        int i6;
        int i7;
        int i8;
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        y0 y0Var = f.a;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i9 = (width + 63) / 64;
        int i10 = (height + 63) / 64;
        y0Var.e++;
        boolean z = (width == f.b && height == f.c) ? false : true;
        y0Var.a(i9, i10);
        if (z) {
            y0Var.a();
            f.b = width;
            f.c = height;
        }
        try {
            int iA = a(bitmap);
            this.n.a.clear();
            C0296d c0296d = this.f;
            synchronized (c0296d) {
                int iB = c0296d.b();
                int i11 = iB != 0 ? iB != 1 ? 16 : 32 : 64;
                int i12 = c0296d.j;
                iMin = Math.min(i11, i12 != 0 ? i12 != 1 ? 16 : 32 : 64);
            }
            int iCoerceAtMost = (z || this.Y == 0) ? i9 * i10 : f.e > 0 ? RangesKt.coerceAtMost(iMin * 2, 128) : RangesKt.coerceAtLeast(iMin / 2, 1);
            ArrayList arrayList = this.H0;
            arrayList.clear();
            int i13 = 0;
            int i14 = 0;
            while (i13 < i10) {
                int i15 = i13 * 64;
                int iMin2 = Math.min(64, height - i15);
                if (iMin2 > 0) {
                    int i16 = i14;
                    int i17 = 0;
                    while (i17 < i9) {
                        int i18 = i17 * 64;
                        int iMin3 = Math.min(64, width - i18);
                        int i19 = i13;
                        int i20 = i17;
                        long jA = y0.a(this.q, i18, i15, iMin3, iMin2, iA);
                        int i21 = (y0Var.a * i19) + i20;
                        y0Var.d[i21] = jA;
                        y0Var.f[i21] = y0Var.e;
                        if (y0Var.c[i21] != jA) {
                            arrayList.add(new C0312l(i18, i15, i + i18, i2 + i15, iMin3, iMin2, i20, i20, i19, jA, IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING));
                            i16++;
                        }
                        i17 = i20 + 1;
                        i13 = i19;
                    }
                    i14 = i16;
                }
                i13++;
            }
            List<C0312l> listA = z0.a(arrayList);
            this.o.a.clear();
            if (listA.size() > iCoerceAtMost) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    a(y0Var, (C0312l) it.next());
                }
                i6 = 0;
                i7 = 0;
            } else {
                int i22 = 0;
                int i23 = 0;
                for (C0312l c0312l : listA) {
                    if (a(bitmap, c0312l, i3 + 1, H0.SURFACE, this.o)) {
                        i23++;
                        i22 += ((c0312l.j - c0312l.i) + 1) * ((c0312l.h - c0312l.g) + 1);
                    } else {
                        a(y0Var, c0312l);
                    }
                }
                i6 = i22;
                i7 = i23;
            }
            System.arraycopy(y0Var.d, 0, y0Var.c, 0, y0Var.a * y0Var.b);
            if (i6 <= 0 || i6 != i14) {
                i8 = i6;
                if (i14 > 0) {
                    a((G0) null, i8, i7, 0, (SystemClock.elapsedRealtimeNanos() - jElapsedRealtimeNanos) / 1000000.0d, true);
                }
            } else {
                long jIncrementAndGet = this.Z.incrementAndGet();
                long j2 = this.Y;
                G0 g0 = (z && j2 == 0) ? G0.KEYFRAME : G0.DELTA;
                this.n.a.clear();
                F0.a(jIncrementAndGet, g0 == G0.KEYFRAME ? 0L : j2, g0, i4, i5, 0, i7, this.o, this.n, 224);
                a(g0, i6, i7, this.n.a.position(), (SystemClock.elapsedRealtimeNanos() - jElapsedRealtimeNanos) / 1000000.0d, false);
                i8 = i6;
                a(jIncrementAndGet, j);
            }
            if (i14 > i8) {
                this.I.post(this.L);
            }
            return i14;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public final void a(int i) {
        C0296d c0296d = this.f;
        synchronized (c0296d) {
            c0296d.i = RangesKt.coerceIn(i, 0, 2);
        }
        this.I.removeCallbacks(this.X0);
        if (i > 0) {
            this.I.postDelayed(this.X0, 15000L);
        }
    }

    public final void a(final long j) {
        Activity activity;
        WebView webView;
        SystemClock.elapsedRealtimeNanos();
        if (this.d && this.Q) {
            long jUptimeMillis = this.Q0 - SystemClock.uptimeMillis();
            if (jUptimeMillis > 0) {
                b(jUptimeMillis);
                return;
            }
            WeakReference weakReference = this.b;
            if (weakReference == null || (activity = (Activity) weakReference.get()) == null || (webView = (WebView) this.a.get()) == null) {
                return;
            }
            try {
                long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
                long jUptimeMillis2 = SystemClock.uptimeMillis();
                if (jUptimeMillis2 - this.Y0 >= 1000) {
                    this.Y0 = jUptimeMillis2;
                    d();
                }
                if (this.G0.isEmpty()) {
                    if (this.K0) {
                        this.K0 = false;
                        this.l.c();
                        return;
                    }
                    return;
                }
                if (!this.K0) {
                    long jUptimeMillis3 = SystemClock.uptimeMillis();
                    long jD = this.f.d();
                    long j2 = this.L0;
                    if (jUptimeMillis3 < j2) {
                        b(j2 - jUptimeMillis3);
                        return;
                    }
                    this.L0 = jUptimeMillis3 - j2 >= jD ? jUptimeMillis3 + jD : j2 + jD;
                    Future future = this.z0;
                    if (future != null) {
                        try {
                            future.get();
                        } catch (Throwable unused) {
                        }
                        this.z0 = null;
                    }
                    N n = this.C0;
                    N n2 = this.A0;
                    if (n == n2) {
                        n2 = this.B0;
                    }
                    this.C0 = n2;
                    n2.c();
                    Class cls = N.t;
                    M.a();
                    this.k.b().a();
                    this.l.a(this.G0);
                    this.K0 = true;
                }
                int width = webView.getWidth();
                Integer numValueOf = Integer.valueOf(width);
                if (width <= 0) {
                    numValueOf = null;
                }
                int iIntValue = numValueOf != null ? numValueOf.intValue() : ((View) this.G0.get(0)).getWidth();
                int height = webView.getHeight();
                Integer numValueOf2 = height > 0 ? Integer.valueOf(height) : null;
                int iIntValue2 = numValueOf2 != null ? numValueOf2.intValue() : ((View) this.G0.get(0)).getHeight();
                this.f.getClass();
                this.l.a(this.e && this.c == U.SCREENSHOT);
                int iOrdinal = this.l.a(this.C0, iIntValue, iIntValue2, 4000000L, this.i.a(), j).ordinal();
                if (iOrdinal != 0) {
                    if (iOrdinal == 1) {
                        this.i.b();
                        return;
                    } else {
                        if (iOrdinal != 2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        this.K0 = false;
                        this.l.c();
                        return;
                    }
                }
                this.K0 = false;
                final boolean z = this.I0;
                this.I0 = false;
                final N n3 = this.D0;
                final N n4 = this.C0;
                this.D0 = n4;
                ExecutorService executorService = this.y0;
                if (executorService != null) {
                    this.z0 = executorService.submit(new Runnable() { // from class: app.screeb.sdk.internal.J$$ExternalSyntheticLambda12
                        @Override // java.lang.Runnable
                        public final void run() {
                            J.a(this.f$0, n3, n4, z, j);
                        }
                    });
                } else {
                    a(n3, n4, z, j);
                }
                this.f.a((SystemClock.elapsedRealtimeNanos() - jElapsedRealtimeNanos) / 1000000.0d);
                U u = this.c;
                U u2 = U.OUTLINE;
                if (u != u2 && Build.VERSION.SDK_INT >= 26) {
                    a(activity, j);
                }
                if (n4.r) {
                    long jUptimeMillis4 = SystemClock.uptimeMillis();
                    if (jUptimeMillis4 - this.N0 >= 100) {
                        this.N0 = jUptimeMillis4;
                        this.i.b();
                    }
                }
                if (this.c == u2 || this.p0.isEmpty()) {
                    return;
                }
                b(500L);
            } catch (Throwable th) {
                this.K0 = false;
                Z z2 = Z.b;
                Y.a();
                Z.b("Mirror", "onFrame failed: " + th.getClass().getSimpleName());
                a(false);
            }
        }
    }

    public final void a(long j, long j2) {
        if (this.h.a(this.n, j2, EnumC0317p.VISUAL)) {
            this.I.post(this.K);
        }
        this.Y = j;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r16v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.dex.visitors.ModVisitor.anonymousCallArgMod(ModVisitor.java:535)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:528)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:111)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    public final void a(android.app.Activity r35, final long r36) {
        /*
            Method dump skipped, instruction units count: 1082
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: app.screeb.sdk.internal.J.a(android.app.Activity, long):void");
    }

    public final void a(Activity activity, U newMode) {
        K k;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(newMode, "newMode");
        this.b = new WeakReference(activity);
        if (newMode != this.c) {
            this.c = newMode;
            this.K0 = false;
            int iOrdinal = newMode.ordinal();
            if (iOrdinal == 0) {
                k = this.j;
            } else {
                if (iOrdinal != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                k = this.k;
            }
            E0 e0 = new E0(k);
            this.l = e0;
            e0.c();
            if (this.d) {
                f();
            }
        }
        if (this.d) {
            d();
            Window window = activity.getWindow();
            if (window == null) {
                return;
            }
            View root = window.getDecorView();
            Intrinsics.checkNotNullExpressionValue(root, "getDecorView(...)");
            B0 b0 = this.S0;
            b0.getClass();
            Intrinsics.checkNotNullParameter(window, "window");
            Intrinsics.checkNotNullParameter(root, "root");
            b0.a();
            b0.c = new WeakReference(window);
            b0.d = new WeakReference(root);
            Window.Callback callback = window.getCallback();
            b0.e = callback;
            window.setCallback(new A0(b0, callback));
            return;
        }
        if (this.m == null) {
            this.m = Build.VERSION.SDK_INT >= 26 ? new C0309j0() : null;
        }
        this.d = true;
        SystemClock.elapsedRealtimeNanos();
        this.I0 = true;
        this.P0 = 0L;
        this.Q0 = 0L;
        this.O0.set(0);
        if (this.y0 == null) {
            this.y0 = a();
        }
        C0319s c0319s = this.h;
        synchronized (c0319s.i) {
            if (!c0319s.h || c0319s.c == null) {
                HandlerThread handlerThread = new HandlerThread("screeb-mirror-encode", 10);
                handlerThread.start();
                c0319s.b = handlerThread;
                c0319s.c = new Handler(handlerThread.getLooper());
                c0319s.h = true;
                Unit unit = Unit.INSTANCE;
            }
        }
        this.g.e = new Function0() { // from class: app.screeb.sdk.internal.J$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return J.d(this.f$0);
            }
        };
        this.g.f = new Function0() { // from class: app.screeb.sdk.internal.J$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return J.e(this.f$0);
            }
        };
        a(activity, new Function0() { // from class: app.screeb.sdk.internal.J$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return J.f(this.f$0);
            }
        });
        d();
        Window window2 = activity.getWindow();
        if (window2 != null) {
            View root2 = window2.getDecorView();
            Intrinsics.checkNotNullExpressionValue(root2, "getDecorView(...)");
            B0 b1 = this.S0;
            b1.getClass();
            Intrinsics.checkNotNullParameter(window2, "window");
            Intrinsics.checkNotNullParameter(root2, "root");
            b1.a();
            b1.c = new WeakReference(window2);
            b1.d = new WeakReference(root2);
            Window.Callback callback2 = window2.getCallback();
            b1.e = callback2;
            window2.setCallback(new A0(b1, callback2));
        }
        C0321u c0321u = this.i;
        if (c0321u.c.compareAndSet(false, true)) {
            c0321u.c();
        }
    }

    public final void a(Activity activity, final Function0 function0) {
        if (this.T0) {
            function0.invoke();
            return;
        }
        final WebView webView = (WebView) this.a.get();
        if (webView == null) {
            function0.invoke();
            return;
        }
        try {
            InputStream inputStreamOpen = activity.getAssets().open("screeb-mirror-runtime.js");
            try {
                Intrinsics.checkNotNull(inputStreamOpen);
                final String str = new String(ByteStreamsKt.readBytes(inputStreamOpen), Charsets.UTF_8);
                CloseableKt.closeFinally(inputStreamOpen, null);
                webView.post(new Runnable() { // from class: app.screeb.sdk.internal.J$$ExternalSyntheticLambda10
                    @Override // java.lang.Runnable
                    public final void run() {
                        J.a(webView, str, function0, this);
                    }
                });
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(inputStreamOpen, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            Z z = Z.b;
            Y.a();
            Z.b("Mirror", "failed to load mirror runtime asset: " + th3.getClass().getSimpleName());
            function0.invoke();
        }
    }

    public final void a(Bitmap bitmap, int i, int i2, int i3, E e, long j) {
        ArrayList arrayList;
        int i4;
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        int i5 = 64;
        int i6 = (i + 63) / 64;
        ArrayList arrayList2 = this.H0;
        arrayList2.clear();
        int iCoerceAtMost = RangesKt.coerceAtMost(((bitmap.getHeight() + i3) + 63) / 64, (i2 + 63) / 64);
        int i7 = i3 / 64;
        while (i7 < iCoerceAtMost) {
            int i8 = i7 * 64;
            int i9 = i8 - i3;
            int iCoerceAtLeast = RangesKt.coerceAtLeast(Math.min(i5, bitmap.getHeight() - i9), 0);
            if (iCoerceAtLeast > 0) {
                arrayList = arrayList2;
                i4 = i5;
                arrayList.add(new C0312l(0, i9, 0, i8, i, iCoerceAtLeast, 0, i6 - 1, i7, 0L, 1536));
            } else {
                arrayList = arrayList2;
                i4 = i5;
            }
            i7++;
            arrayList2 = arrayList;
            iCoerceAtMost = iCoerceAtMost;
            i5 = i4;
        }
        ArrayList arrayList3 = arrayList2;
        List<C0312l> listA = z0.a(arrayList3);
        this.o.a.clear();
        try {
            a(bitmap);
        } catch (Throwable unused) {
            this.r = 0;
        }
        int i10 = 0;
        int i11 = 0;
        for (C0312l c0312l : listA) {
            if (a(bitmap, c0312l, 0, H0.WINDOW, this.o)) {
                i11++;
                i10 += ((c0312l.j - c0312l.i) + 1) * ((c0312l.h - c0312l.g) + 1);
            }
        }
        if (i10 == 0) {
            this.o0 = arrayList3.size();
            a((G0) null, i10, i11, 0, (SystemClock.elapsedRealtimeNanos() - jElapsedRealtimeNanos) / 1000000.0d, true);
            e();
            this.I.post(this.L);
            return;
        }
        int i12 = i10;
        int i13 = i11;
        boolean z = i12 < arrayList3.size();
        if (z) {
            this.n0++;
            this.o0 = arrayList3.size() - i12;
        } else {
            this.o0 = 0;
        }
        this.y.a();
        this.R = i;
        this.S = i2;
        this.T = this.o0;
        long jIncrementAndGet = this.Z.incrementAndGet();
        this.n.a.clear();
        long j2 = e.a;
        G0 g0 = G0.SCROLL;
        F0.a(jIncrementAndGet, j2, g0, i, i2, e.b, i13, this.o, this.n, 128);
        a(g0, i12, i13, this.n.a.position(), (SystemClock.elapsedRealtimeNanos() - jElapsedRealtimeNanos) / 1000000.0d, false);
        a(jIncrementAndGet, j);
        if (z) {
            this.I.post(this.L);
        }
    }

    /* JADX WARN: Failed to calculate best type for var: r11v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r11v0 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r11v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r11v1 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r4v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r4v3 ??, new type: android.view.ViewGroup
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r4v4 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r4v4 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r5v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v1 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r5v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v2 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r5v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r5v3 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r6v5 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v5 ??, new type: android.view.ViewGroup
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to set immutable type for var: r28v0 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r28v0 'this'  ??, new type: app.screeb.sdk.internal.J
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setImmutableType(TypeInferenceVisitor.java:111)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:102)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:102)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r16v0 ??, new type: char
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 5 more
        */
    public final void a(android.view.View r29, int r30, boolean r31, boolean r32) {
        /*
            Method dump skipped, instruction units count: 936
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: app.screeb.sdk.internal.J.a(android.view.View, int, boolean, boolean):void");
    }

    public final void a(G0 g0, int i, int i2, int i3, double d, boolean z) {
        String str;
        if (z) {
            this.m0++;
            str = "drop";
        } else {
            int i4 = g0 == null ? -1 : G.a[g0.ordinal()];
            if (i4 == -1) {
                str = "-";
            } else if (i4 == 1) {
                this.j0++;
                str = "keyframe";
            } else if (i4 == 2) {
                this.k0++;
                str = "delta";
            } else if (i4 == 3) {
                this.l0++;
                str = "scroll";
            } else {
                if (i4 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                str = "rect";
            }
        }
        this.e0 = str;
        this.h0 = i;
        this.g0 = i2;
        this.f0 = i3;
        this.d0 = d;
    }

    public final void a(N n, N n2, boolean z, long j) {
        try {
            this.E0.c();
            this.x0.a(n, n2, this.E0, z);
            D.a(this.F0, this.E0);
            if (this.E0.b() || !this.h.a(this.E0, j, EnumC0317p.STRUCTURAL)) {
                return;
            }
            Z z2 = Z.b;
            Y.a();
            Z.b("Mirror", "structural frame replaced before encode — scheduling full resend");
            this.I.post(this.K);
        } catch (Throwable th) {
            Z z3 = Z.b;
            Y.a();
            Z.b("Mirror", "diff failed: " + th.getClass().getSimpleName());
        }
    }

    public final void a(C0309j0 c0309j0, int i, int i2, final double d, final long j, final int[] iArr) {
        int i3 = 0;
        if (this.p0.isEmpty()) {
            this.U = 0;
            return;
        }
        if (this.e) {
            this.U = 0;
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        int size = this.p0.size();
        while (i3 < size) {
            int i4 = this.r0;
            this.r0 = (i4 + 1) % size;
            i3++;
            Object obj = this.p0.get(i4 % size);
            Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
            final t0 t0Var = (t0) obj;
            Rect rect = t0Var.d;
            final r0 r0VarA = s0.a(new q0(rect.left, rect.top, rect.right, rect.bottom), i, i2, d);
            if (r0VarA != null) {
                HashMap map = this.q0;
                Integer numValueOf = Integer.valueOf(t0Var.b);
                Object f = map.get(numValueOf);
                if (f == null) {
                    f = new F();
                    map.put(numValueOf, f);
                }
                final F f2 = (F) f;
                if (jUptimeMillis - f2.d >= 83) {
                    f2.d = jUptimeMillis;
                    q0 q0Var = r0VarA.a;
                    Rect rect2 = new Rect(q0Var.a, q0Var.b, q0Var.c, q0Var.d);
                    final int iB = b() - f2.e;
                    final int i5 = this.R0.get();
                    c0309j0.a(t0Var.a, rect2, r0VarA.d, r0VarA.e, new Function1() { // from class: app.screeb.sdk.internal.J$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return J.a(this.f$0, i5, f2, iB, iArr, d, r0VarA, t0Var, j, (Bitmap) obj2);
                        }
                    });
                    return;
                }
            }
        }
        this.U = b();
        if (this.U > 0) {
            this.I.post(this.L);
        }
    }

    public final void a(boolean z) {
        if (z) {
            this.O0.set(0);
            this.P0 = 0L;
            return;
        }
        if (this.O0.incrementAndGet() >= 12) {
            this.O0.set(0);
            long jCoerceIn = RangesKt.coerceIn(this.P0 * ((long) 2), 1000L, HTTPTimeoutManager.DEFAULT_TIMEOUT_MS);
            this.P0 = jCoerceIn;
            this.Q0 = SystemClock.uptimeMillis() + jCoerceIn;
            Z z2 = Z.b;
            Y.a();
            Z.b("Mirror", "session replay paused " + jCoerceIn + "ms after repeated capture failures");
        }
    }

    public final boolean a(Bitmap bitmap, int i, int i2, int i3, int i4, int i5, int i6, double d, long j, boolean z) {
        J j2;
        int iMin;
        int i7;
        J j3;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        J j4;
        int i13;
        J j5;
        int i14;
        int i15;
        int i16;
        int i17;
        J j6 = this;
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        int i18 = (i + 63) / 64;
        int i19 = (i2 + 63) / 64;
        j6.y.e++;
        if (i != j6.R || i2 != j6.S) {
            j6.y.a(i18, i19);
            j6.y.a();
            j6.R = i;
            j6.S = i2;
            j6.s.a();
            Arrays.fill(j6.v, false);
            j6.w = 0;
            long jElapsedRealtimeNanos2 = SystemClock.elapsedRealtimeNanos();
            j6.p.reset();
            try {
                bitmap.compress(j6.x, j6.W0, j6.p);
                j6.p.size();
                j6.o.a.clear();
                O out = j6.o;
                H0 h0 = H0.WINDOW;
                w0 bytes = j6.p;
                H0 layerKind = H0.WINDOW;
                Intrinsics.checkNotNullParameter(out, "out");
                Intrinsics.checkNotNullParameter(layerKind, "layerKind");
                Intrinsics.checkNotNullParameter(bytes, "bytes");
                out.b(1L);
                long j7 = 0;
                out.b(j7);
                out.b(1);
                out.b(j7);
                out.b(j7);
                out.b(i);
                out.b(i2);
                bytes.a(out);
                long jIncrementAndGet = j6.Z.incrementAndGet();
                j6.n.a.clear();
                G0 g0 = G0.KEYFRAME;
                F0.a(jIncrementAndGet, 0L, g0, i, i2, 0, 1, j6.o, j6.n, 224);
                j6.a(g0, 1, 1, j6.n.a.position(), (SystemClock.elapsedRealtimeNanos() - jElapsedRealtimeNanos2) / 1000000.0d, false);
                j2 = j6;
                j2.a(jIncrementAndGet, j);
            } catch (Throwable unused) {
                j2 = j6;
                j2.a((G0) null, 0, 0, 0, (SystemClock.elapsedRealtimeNanos() - jElapsedRealtimeNanos2) / 1000000.0d, true);
                j2.e();
                j2.a(2);
            }
            j2.f.a((SystemClock.elapsedRealtimeNanos() - jElapsedRealtimeNanos) / 1000000.0d, 1);
            y0 y0Var = j2.y;
            int i20 = y0Var.e + 1;
            y0Var.e = i20;
            Arrays.fill(y0Var.f, 0, y0Var.a * y0Var.b, i20);
            j2.T = 0;
            return true;
        }
        j6.y.a(i18, i19);
        try {
            int iA = a(bitmap);
            ArrayList arrayList = j6.H0;
            arrayList.clear();
            if (z) {
                i7 = Integer.MAX_VALUE;
            } else {
                C0296d c0296d = j6.f;
                synchronized (c0296d) {
                    int iB = c0296d.b();
                    int i21 = iB != 0 ? iB != 1 ? 16 : 32 : 64;
                    int i22 = c0296d.j;
                    iMin = Math.min(i21, i22 != 0 ? i22 != 1 ? 16 : 32 : 64);
                }
                i7 = iMin;
            }
            int i23 = i3 / 64;
            int iCoerceAtMost = RangesKt.coerceAtMost(((bitmap.getHeight() + i3) + 63) / 64, i19);
            int i24 = i4 / 64;
            int iCoerceAtMost2 = RangesKt.coerceAtMost(((bitmap.getWidth() + i4) + 63) / 64, i18);
            int size = j6.p0.size();
            if (j6.s0.length < size) {
                j6.s0 = new int[size];
                j6.t0 = new int[size];
                j6.u0 = new int[size];
                j6.v0 = new int[size];
            }
            int i25 = 0;
            int i26 = 0;
            while (i26 < size) {
                Object obj = j6.p0.get(i26);
                int i27 = i26;
                Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                Rect rect = ((t0) obj).d;
                int i28 = i23;
                int i29 = size;
                r0 r0VarA = s0.a(new q0(rect.left, rect.top, rect.right, rect.bottom), i5, i6, d);
                if (r0VarA != null) {
                    int[] iArr = j6.s0;
                    int i30 = r0VarA.b;
                    iArr[i25] = i30;
                    int[] iArr2 = j6.t0;
                    int i31 = r0VarA.c;
                    iArr2[i25] = i31;
                    j6.u0[i25] = i30 + r0VarA.d;
                    j6.v0[i25] = i31 + r0VarA.e;
                    i25++;
                }
                i26 = i27 + 1;
                i23 = i28;
                size = i29;
            }
            j6.w0 = i25;
            int i32 = 0;
            while (i23 < iCoerceAtMost) {
                int i33 = i23 * 64;
                int i34 = i33 - i3;
                int i35 = 64;
                int iCoerceAtLeast = RangesKt.coerceAtLeast(Math.min(64, bitmap.getHeight() - i34), 0);
                if (iCoerceAtLeast > 0) {
                    int i36 = i24;
                    while (i36 < iCoerceAtMost2) {
                        int i37 = i36 * 64;
                        int i38 = i37 - i4;
                        int i39 = i32;
                        int iMin2 = Math.min(i35, i - i37);
                        int i40 = j6.w0;
                        int i41 = 0;
                        while (true) {
                            if (i41 < i40) {
                                int i42 = i40;
                                i14 = iCoerceAtMost2;
                                if (j6.s0[i41] >= i37 + iMin2 || j6.u0[i41] <= i37 || j6.t0[i41] >= i33 + iCoerceAtLeast || j6.v0[i41] <= i33) {
                                    i41++;
                                    iCoerceAtMost2 = i14;
                                    i40 = i42;
                                } else {
                                    y0 y0Var2 = j6.y;
                                    int i43 = (y0Var2.a * i23) + i36;
                                    y0Var2.d[i43] = 0;
                                    y0Var2.f[i43] = y0Var2.e;
                                }
                            } else {
                                i14 = iCoerceAtMost2;
                                y0 y0Var3 = j6.y;
                                short[] sArr = j6.q;
                                y0Var3.getClass();
                                long jA = y0.a(sArr, i38, i34, iMin2, iCoerceAtLeast, iA);
                                y0 y0Var4 = j6.y;
                                int i44 = (y0Var4.a * i23) + i36;
                                y0Var4.d[i44] = jA;
                                y0Var4.f[i44] = y0Var4.e;
                                if (y0Var4.c[i44] != jA) {
                                    i32 = i39 + 1;
                                    i15 = i33;
                                    i16 = i36;
                                    i17 = i23;
                                    arrayList.add(new C0312l(i38, i34, i37, i15, iMin2, iCoerceAtLeast, i16, i36, i17, jA, IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING));
                                }
                                i36 = i16 + 1;
                                iCoerceAtMost2 = i14;
                                i33 = i15;
                                i23 = i17;
                                i35 = 64;
                            }
                            i15 = i33;
                            i16 = i36;
                            i17 = i23;
                            i32 = i39;
                            i36 = i16 + 1;
                            iCoerceAtMost2 = i14;
                            i33 = i15;
                            i23 = i17;
                            i35 = 64;
                        }
                    }
                }
                i23++;
                iCoerceAtMost2 = iCoerceAtMost2;
            }
            List<C0312l> listA = z0.a(arrayList);
            j6.o.a.clear();
            if (listA.size() > i7) {
                y0 y0Var5 = j6.y;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    a(y0Var5, (C0312l) it.next());
                }
                int i45 = j6.V + 1;
                j6.V = i45;
                if (i45 >= 3) {
                    j6.V = 0;
                    j6.I.post(j6.K);
                }
                i9 = i32;
                j3 = j6;
                i8 = 0;
                i10 = 0;
            } else {
                j6.V = 0;
                int i46 = 0;
                int i47 = 0;
                int i48 = 0;
                for (C0312l c0312l : listA) {
                    J j8 = j6;
                    if (j8.a(bitmap, c0312l, 0, H0.WINDOW, j6.o)) {
                        i48++;
                        i46 += ((c0312l.j - c0312l.i) + 1) * ((c0312l.h - c0312l.g) + 1);
                    } else {
                        i47 += ((c0312l.j - c0312l.i) + 1) * ((c0312l.h - c0312l.g) + 1);
                        a(j8.y, c0312l);
                    }
                    j6 = j8;
                }
                j3 = j6;
                i8 = i46;
                i9 = i47;
                i10 = i48;
            }
            y0 y0Var6 = j3.y;
            System.arraycopy(y0Var6.d, 0, y0Var6.c, 0, y0Var6.a * y0Var6.b);
            if (i8 > 0) {
                j3.f.a((SystemClock.elapsedRealtimeNanos() - jElapsedRealtimeNanos) / 1000000.0d, i8);
            }
            j3.T = i32;
            if (i32 == 0 || i8 == 0 || i8 < i32) {
                i11 = i8;
                i12 = i32;
                if (i12 > 0 && i11 < i12) {
                    y0 y0Var7 = j3.y;
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        a(y0Var7, (C0312l) it2.next());
                    }
                }
                J j9 = j3;
                j9.a((G0) null, i11, i10, 0, (SystemClock.elapsedRealtimeNanos() - jElapsedRealtimeNanos) / 1000000.0d, i12 > 0);
                j4 = j9;
                j4.e();
            } else {
                long jIncrementAndGet2 = j3.Z.incrementAndGet();
                i13 = i8;
                long j10 = j3.Y;
                j3.n.a.clear();
                G0 g1 = G0.DELTA;
                i12 = i32;
                j5 = j3;
                F0.a(jIncrementAndGet2, j10, g1, i, i2, 0, i10, j3.o, j3.n, 224);
                j5.a(g1, i13, i10, j5.n.a.position(), (SystemClock.elapsedRealtimeNanos() - jElapsedRealtimeNanos) / 1000000.0d, false);
                j5.a(jIncrementAndGet2, j);
            }
            if (i9 > 0) {
                i11 = i13;
                j4 = j5;
                j4.I.post(j4.L);
            }
            return i12 == 0 || (i11 > 0 && i9 == 0);
        } catch (Throwable unused2) {
            j6.e();
            return false;
        }
    }

    public final boolean a(Bitmap src, int i, int i2, int i3, int i4, int i5, int i6, int i7, H0 layerKind, O out, int i8, int i9) {
        Bitmap bitmap;
        Bitmap bitmap2;
        boolean z;
        this.p.reset();
        if (i5 == 64 && i6 == 64) {
            x0 x0Var = this.N;
            x0Var.getClass();
            Intrinsics.checkNotNullParameter(src, "src");
            try {
                Bitmap bitmapA = x0Var.a();
                try {
                    x0Var.e.setBitmap(bitmapA);
                    x0Var.c.set(i, i2, i + i5, i2 + i6);
                    x0Var.d.set(0, 0, i5, i6);
                    x0Var.e.drawBitmap(src, x0Var.c, x0Var.d, (Paint) null);
                    bitmap = bitmapA;
                } catch (Throwable unused) {
                    x0Var.a(bitmapA);
                    bitmap = null;
                }
            } catch (OutOfMemoryError unused2) {
                Z z2 = Z.b;
                Z z3 = Z.b;
                Z z4 = Z.b;
                Z.b("Mirror", "TileBitmapPool OOM");
            }
            if (bitmap == null) {
                return false;
            }
            bitmap2 = bitmap;
        } else {
            long j = (((long) i5) << 32) ^ (((long) i6) & 4294967295L);
            if (this.D != j) {
                Bitmap bitmap3 = this.C;
                if (bitmap3 != null) {
                    bitmap3.recycle();
                }
                this.C = Bitmap.createBitmap(i5, i6, Bitmap.Config.RGB_565);
                this.D = j;
            }
            bitmap = this.C;
            Intrinsics.checkNotNull(bitmap);
            this.E.setBitmap(bitmap);
            this.F.set(i, i2, i + i5, i2 + i6);
            this.G.set(0, 0, i5, i6);
            bitmap2 = null;
            this.E.drawBitmap(src, this.F, this.G, (Paint) null);
        }
        try {
            bitmap.compress(this.x, this.W0, this.p);
            z = true;
        } catch (Throwable unused3) {
            z = false;
        }
        if (bitmap2 != null) {
            this.N.a(bitmap2);
        }
        if (!z) {
            a(2);
            return false;
        }
        if (i8 >= 0) {
            Intrinsics.checkNotNullParameter(out, "out");
            Intrinsics.checkNotNullParameter(layerKind, "layerKind");
            out.b(4L);
            out.b(i7);
            out.b(layerKind.a);
            out.b(i3);
            out.b(i4);
            out.b(i5);
            out.b(i6);
            out.b(i8);
            out.b(((long) i9) & 4294967295L);
            this.p.a(out);
        } else {
            w0 bytes = this.p;
            Intrinsics.checkNotNullParameter(out, "out");
            Intrinsics.checkNotNullParameter(layerKind, "layerKind");
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            out.b(1L);
            out.b(i7);
            out.b(layerKind.a);
            out.b(i3);
            out.b(i4);
            out.b(i5);
            out.b(i6);
            bytes.a(out);
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00d6  */
    public final boolean a(Bitmap bitmap, C0312l c0312l, int i, H0 layerKind, O out) {
        int i2;
        int i3;
        long jA;
        long j;
        int i4 = this.r;
        int length = i4 > 0 ? this.q.length / i4 : 0;
        int i5 = c0312l.a;
        if (i5 >= 0 && (i2 = c0312l.b) >= 0) {
            int i6 = c0312l.e;
            if (i5 + i6 <= i4) {
                int i7 = c0312l.f;
                if (i2 + i7 <= length) {
                    short[] pixels = this.q;
                    Intrinsics.checkNotNullParameter(pixels, "pixels");
                    if (i6 <= 0 || i7 <= 0) {
                        i3 = -1;
                        break loop0;
                    }
                    short s = 65535;
                    i3 = pixels[(i2 * i4) + i5] & 65535;
                    loop0: for (int i8 = 0; i8 < i7; i8++) {
                        int i9 = ((i2 + i8) * i4) + i5;
                        int i10 = 0;
                        while (true) {
                            if (i10 < i6) {
                                short s2 = s;
                                if ((pixels[i9 + i10] & s2) != i3) {
                                    i3 = -1;
                                    break loop0;
                                }
                                i10++;
                                s = s2;
                            }
                        }
                    }
                    if (i3 != -1) {
                        int i11 = c0312l.c;
                        int i12 = c0312l.d;
                        int i13 = c0312l.e;
                        int i14 = c0312l.f;
                        int i15 = (i3 >>> 11) & 31;
                        int i16 = (i3 >>> 5) & 63;
                        int i17 = i3 & 31;
                        Intrinsics.checkNotNullParameter(out, "out");
                        Intrinsics.checkNotNullParameter(layerKind, "layerKind");
                        out.b(2L);
                        out.b(i);
                        out.b(layerKind.a);
                        out.b(i11);
                        out.b(i12);
                        out.b(i13);
                        out.b(i14);
                        j = ((long) ((((i15 >>> 2) | (i15 << 3)) << 16) | (((i16 >>> 4) | (i16 << 2)) << 8) | (i17 >>> 2) | (i17 << 3))) & 16777215;
                    } else {
                        if (c0312l.g == c0312l.h && c0312l.j == c0312l.i) {
                            jA = c0312l.k;
                            if (jA == 0) {
                                y0 y0Var = this.y;
                                short[] sArr = this.q;
                                int i18 = c0312l.a;
                                int i19 = c0312l.b;
                                int i20 = c0312l.e;
                                int i21 = c0312l.f;
                                int i22 = this.r;
                                y0Var.getClass();
                                jA = y0.a(sArr, i18, i19, i20, i21, i22);
                            }
                        } else {
                            y0 y0Var2 = this.y;
                            short[] sArr2 = this.q;
                            int i110 = c0312l.a;
                            int i111 = c0312l.b;
                            int i23 = c0312l.e;
                            int i24 = c0312l.f;
                            int i25 = this.r;
                            y0Var2.getClass();
                            jA = y0.a(sArr2, i110, i111, i23, i24, i25);
                        }
                        long j2 = jA;
                        int i26 = (int) (j2 & 4294967295L);
                        long j3 = (((long) c0312l.e) << 16) | ((long) c0312l.f);
                        boolean z = j2 != Long.MIN_VALUE;
                        int iA = z ? this.s.a(j2) : -1;
                        if (iA < 0 || this.u[iA] != j3) {
                            long j4 = Long.MIN_VALUE;
                            int i27 = this.w;
                            this.w = (i27 + 1) % IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER;
                            if (this.v[i27]) {
                                C0323w c0323w = this.s;
                                long j5 = this.t[i27];
                                c0323w.getClass();
                                int iB = C0323w.b(j5);
                                while (true) {
                                    int i28 = iB & c0323w.c;
                                    long j6 = c0323w.a[i28];
                                    if (j6 == Long.MIN_VALUE) {
                                        break;
                                    }
                                    if (j6 == j5) {
                                        loop3: while (true) {
                                            c0323w.a[i28] = j4;
                                            int i29 = i28;
                                            while (true) {
                                                long j7 = j4;
                                                i29 = (i29 + 1) & c0323w.c;
                                                long j8 = c0323w.a[i29];
                                                if (j8 == j7) {
                                                    break loop3;
                                                }
                                                int iB2 = C0323w.b(j8) & c0323w.c;
                                                if (i28 <= i29) {
                                                    if (i28 >= iB2 || iB2 > i29) {
                                                        long[] jArr = c0323w.a;
                                                        jArr[i28] = jArr[i29];
                                                        int[] iArr = c0323w.b;
                                                        iArr[i28] = iArr[i29];
                                                        i28 = i29;
                                                        j4 = j7;
                                                    } else {
                                                        j4 = j7;
                                                    }
                                                } else if (i28 < iB2 || iB2 <= i29) {
                                                    j4 = j7;
                                                } else {
                                                    long[] jArr2 = c0323w.a;
                                                    jArr2[i28] = jArr2[i29];
                                                    int[] iArr2 = c0323w.b;
                                                    iArr2[i28] = iArr2[i29];
                                                    i28 = i29;
                                                    j4 = j7;
                                                }
                                            }
                                        }
                                        c0323w.d--;
                                        break;
                                    }
                                    iB = i28 + 1;
                                }
                            }
                            boolean zA = a(bitmap, c0312l.a, c0312l.b, c0312l.c, c0312l.d, c0312l.e, c0312l.f, i, layerKind, out, i27, i26);
                            if (zA) {
                                this.v[i27] = true;
                                this.t[i27] = j2;
                                this.u[i27] = j3;
                                if (z) {
                                    this.s.a(j2, i27);
                                }
                            }
                            return zA;
                        }
                        int i30 = c0312l.c;
                        int i31 = c0312l.d;
                        int i32 = c0312l.e;
                        int i33 = c0312l.f;
                        Intrinsics.checkNotNullParameter(out, "out");
                        Intrinsics.checkNotNullParameter(layerKind, "layerKind");
                        out.b(5L);
                        out.b(i);
                        out.b(layerKind.a);
                        out.b(i30);
                        out.b(i31);
                        out.b(i32);
                        out.b(i33);
                        out.b(iA);
                        j = ((long) i26) & 4294967295L;
                    }
                    out.b(j);
                    return true;
                }
            }
        }
        return a(bitmap, i5, c0312l.b, c0312l.c, c0312l.d, c0312l.e, c0312l.f, i, layerKind, out, -1, 0);
    }

    public final int b() {
        Iterator it = this.p0.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            F f = (F) this.q0.get(Integer.valueOf(((t0) next).b));
            i += f != null ? f.e : 0;
        }
        return i;
    }

    public final void b(long j) {
        if (this.M0.compareAndSet(false, true)) {
            this.I.postDelayed(this.Z0, RangesKt.coerceAtLeast(j, 1L));
        }
    }

    public final void b(boolean z) {
        if (this.Q == z) {
            return;
        }
        this.Q = z;
        if (z) {
            return;
        }
        e();
        this.R0.incrementAndGet();
        this.P.set(false);
        N.y.clear();
    }

    public final String c() {
        double d;
        int iA;
        long jC;
        int i;
        int iB;
        C0296d c0296d = this.f;
        synchronized (c0296d) {
            d = c0296d.h;
            iA = c0296d.a(false);
            jC = c0296d.c();
            i = c0296d.j;
            iB = c0296d.b();
        }
        StringBuilder sb = new StringBuilder("mirror ");
        sb.append(this.d ? "on" : "off");
        sb.append(' ');
        sb.append(this.c.name());
        sb.append("\nres ");
        sb.append((int) d);
        sb.append("/");
        sb.append(this.f.a());
        sb.append(" q");
        sb.append(iA);
        sb.append("/");
        sb.append(this.f.a(true));
        sb.append(" interval ");
        sb.append(jC);
        sb.append("ms\ncapture ");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Locale locale = Locale.US;
        String str = String.format(locale, "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(this.a0)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        sb.append(str);
        sb.append("ms encode ");
        String str2 = String.format(locale, "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(this.d0)}, 1));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        sb.append(str2);
        sb.append("ms\nlast ");
        sb.append(this.e0);
        sb.append(" tiles ");
        sb.append(this.h0);
        sb.append(" patches ");
        sb.append(this.g0);
        sb.append(" bytes ");
        sb.append(this.f0 / IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET);
        sb.append("KB\nvisual #");
        sb.append(this.Y);
        sb.append(" dirty ");
        sb.append(this.T);
        sb.append(" surface ");
        sb.append(this.U);
        sb.append("\nk/d/s/drop ");
        sb.append(this.j0);
        sb.append('/');
        sb.append(this.k0);
        sb.append('/');
        sb.append(this.l0);
        sb.append('/');
        sb.append(this.m0);
        sb.append("\nscroll partial/debt ");
        sb.append(this.n0);
        sb.append('/');
        sb.append(this.o0);
        sb.append("\npressure ");
        sb.append(iB);
        sb.append(" encode ");
        sb.append(i);
        return sb.toString();
    }

    public final void d() {
        Activity activity;
        WeakReference weakReference = this.b;
        if (weakReference == null || (activity = (Activity) weakReference.get()) == null) {
            return;
        }
        Lazy lazy = L0.a;
        L0.a(activity, this.G0);
        C0321u c0321u = this.i;
        ArrayList<View> roots = this.G0;
        c0321u.getClass();
        Intrinsics.checkNotNullParameter(roots, "roots");
        Iterator it = c0321u.i.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            View view = (View) next;
            if (!roots.contains(view)) {
                c0321u.a(view);
                it.remove();
            }
        }
        for (View view2 : roots) {
            if (!c0321u.i.contains(view2)) {
                try {
                    ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
                    if (viewTreeObserver.isAlive()) {
                        viewTreeObserver.addOnPreDrawListener(c0321u.f);
                        viewTreeObserver.addOnGlobalLayoutListener(c0321u.g);
                    }
                } catch (Throwable unused) {
                }
                c0321u.i.add(view2);
            }
        }
    }

    public final void e() {
        this.H.set(false);
        this.I.removeCallbacks(this.J);
        h();
    }

    public final void f() {
        Future future = this.z0;
        if (future != null) {
            try {
                future.get();
            } catch (Throwable unused) {
            }
            this.z0 = null;
        }
        this.R0.incrementAndGet();
        this.P.set(false);
        this.I0 = true;
        this.K0 = false;
        this.L0 = 0L;
        this.M0.set(false);
        this.l.c();
        C0321u c0321u = this.i;
        c0321u.d.incrementAndGet();
        c0321u.c();
        N.y.clear();
        this.D0 = null;
        this.E0.a.clear();
        this.J0 = true;
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = 0;
        this.o0 = 0;
        this.W = false;
        this.X.set(false);
        this.A.a.clear();
        this.Y = 0L;
        this.Z.set(0L);
    }

    public final void g() {
        Handler handler;
        this.R0.incrementAndGet();
        e();
        this.I.removeCallbacks(this.X0);
        boolean zPost = false;
        this.P.set(false);
        this.M0.set(false);
        this.L0 = 0L;
        if (this.d) {
            this.d = false;
            Future future = this.z0;
            if (future != null) {
                try {
                    future.get();
                } catch (Throwable unused) {
                }
                this.z0 = null;
            }
            this.S0.a();
            this.i.d();
            this.h.c();
            this.g.d();
            if (Build.VERSION.SDK_INT >= 26) {
                C0309j0 c0309j0 = this.m;
                if (c0309j0 != null && (handler = c0309j0.b) != null) {
                    zPost = handler.post(new Runnable() { // from class: app.screeb.sdk.internal.J$$ExternalSyntheticLambda6
                        @Override // java.lang.Runnable
                        public final void run() {
                            J.g(this.f$0);
                        }
                    });
                }
                if (!zPost) {
                    Bitmap bitmap = this.C;
                    if (bitmap != null) {
                        bitmap.recycle();
                    }
                    this.C = null;
                    this.D = -1L;
                }
                C0309j0 c0309j1 = this.m;
                if (c0309j1 != null) {
                    c0309j1.a();
                }
            } else {
                Bitmap bitmap2 = this.C;
                if (bitmap2 != null) {
                    bitmap2.recycle();
                }
                this.C = null;
                this.D = -1L;
            }
            this.m = null;
            this.l.c();
            this.A0.c();
            this.B0.c();
            N.y.clear();
            this.D0 = null;
            this.E0.a.clear();
            synchronized (this.F0) {
                this.F0.a.clear();
                Unit unit = Unit.INSTANCE;
            }
            ExecutorService executorService = this.y0;
            if (executorService != null) {
                executorService.shutdown();
            }
            this.y0 = null;
        }
    }

    public final void h() {
        if (this.X.getAndSet(false)) {
            this.W = true;
            this.I.post(this.L);
        }
    }
}
