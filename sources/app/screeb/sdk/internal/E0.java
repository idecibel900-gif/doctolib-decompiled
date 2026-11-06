package app.screeb.sdk.internal;

import android.graphics.Rect;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class E0 {
    public final K a;
    public boolean b;
    public C0[] c;
    public int d;

    public E0(K adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.a = adapter;
        C0[] c0Arr = new C0[64];
        for (int i = 0; i < 64; i++) {
            c0Arr[i] = new C0();
        }
        this.c = c0Arr;
    }

    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v7 */
    public final D0 a(N buf, int i, int i2, long j, AtomicLong atomicLong, long j2) throws Throwable {
        String str;
        C0 c0;
        ?? r6;
        int i3;
        View childAt;
        int i4;
        long j3;
        boolean z;
        T tA;
        String str2 = "buf";
        Intrinsics.checkNotNullParameter(buf, "buf");
        AtomicLong token = atomicLong;
        Intrinsics.checkNotNullParameter(token, "token");
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        int i5 = 0;
        while (this.d > 0) {
            int i6 = i5 + 1;
            if ((i6 & 15) == 0 && SystemClock.elapsedRealtimeNanos() - jElapsedRealtimeNanos > j) {
                return D0.YIELD;
            }
            if (token.get() != j2) {
                return D0.CANCELED;
            }
            C0 c1 = this.c[this.d - 1];
            View view = c1.a;
            Intrinsics.checkNotNull(view);
            if (c1.k == 0) {
                str = str2;
                c0 = c1;
                long jA = this.a.a(buf, view, c1.b, c1.c, c1.h, c1.i, c1.j, i, i2, c1.d, c1.e, c1.f, c1.g);
                int i7 = (int) jA;
                if (i7 >= 0) {
                    Rect rect = AbstractC0290a.a;
                    Intrinsics.checkNotNullParameter(view, "view");
                    String[] strArr = p0.a;
                    Intrinsics.checkNotNullParameter(view, "view");
                    String name = view.getClass().getName();
                    Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    Intrinsics.checkNotNullParameter(name, "name");
                    if (Intrinsics.areEqual(name, "io.flutter.embedding.android.FlutterView") || Intrinsics.areEqual(name, "io.flutter.view.FlutterView")) {
                        Intrinsics.checkNotNullParameter(view, "view");
                        long j4 = buf.b[i7];
                        i4 = c0.i;
                        j3 = j4;
                        z = this.b;
                        tA = this.a.a();
                    } else if (AbstractC0300f.a(view)) {
                        long j5 = buf.b[i7];
                        i4 = c0.i;
                        z = this.b;
                        T tA2 = this.a.a();
                        Intrinsics.checkNotNullParameter(view, "composeView");
                        Intrinsics.checkNotNullParameter(buf, str);
                        if (AbstractC0300f.a(view)) {
                            if (view.getAccessibilityNodeProvider() != null) {
                                str = str;
                                tA = tA2;
                                j3 = j5;
                            } else if (!AbstractC0300f.a) {
                                AbstractC0300f.a = true;
                                Z.a("Compose view has no AccessibilityNodeProvider — bounds only");
                            }
                        }
                        str = str;
                        a();
                        token = atomicLong;
                        i5 = i6;
                        str2 = str;
                    }
                    AbstractC0290a.a(view, buf, j3, i4, z, tA);
                    a();
                    token = atomicLong;
                    i5 = i6;
                    str2 = str;
                }
                if (i7 >= 0 && ((jA >>> 32) & 1) == 1 && (view instanceof ViewGroup)) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    c0.l = viewGroup.getChildCount();
                    r6 = 0;
                    c0.k = 0;
                    c0.c = buf.b[i7];
                    c0.d = Q.e;
                    c0.e = Q.f;
                    c0.f = true;
                    c0.g = c0.g && viewGroup.getMatrix().isIdentity();
                    c0.j = false;
                }
                a();
                token = atomicLong;
                i5 = i6;
                str2 = str;
            } else {
                str = str2;
                c0 = c1;
                r6 = 0;
            }
            if (!(view instanceof ViewGroup) || (i3 = c0.k) >= c0.l) {
                a();
            } else {
                try {
                    childAt = ((ViewGroup) view).getChildAt(i3);
                } catch (Throwable unused) {
                    childAt = null;
                }
                int i8 = c0.k;
                c0.k = i8 + 1;
                if (childAt != null) {
                    C0 c0B = b();
                    c0B.a = childAt;
                    c0B.b = view;
                    c0B.c = c0.c;
                    c0B.d = c0.d;
                    c0B.e = c0.e;
                    c0B.f = c0.f;
                    c0B.g = c0.g;
                    c0B.h = i8;
                    c0B.i = c0.i;
                    c0B.j = r6;
                    c0B.k = r6;
                    c0B.l = r6;
                }
            }
            token = atomicLong;
            i5 = i6;
            str2 = str;
        }
        return D0.COMPLETED;
    }

    public final void a() {
        int i = this.d;
        if (i > 0) {
            C0 c0 = this.c[i - 1];
            c0.a = null;
            c0.b = null;
            this.d = i - 1;
        }
    }

    public final void a(ArrayList roots) {
        Intrinsics.checkNotNullParameter(roots, "roots");
        int i = this.d;
        for (int i2 = 0; i2 < i; i2++) {
            C0 c0 = this.c[i2];
            c0.a = null;
            c0.b = null;
        }
        this.d = 0;
        int size = roots.size();
        for (int i3 = 0; i3 < size; i3++) {
            C0 c0B = b();
            c0B.a = (View) roots.get(i3);
            c0B.b = null;
            c0B.c = 0L;
            c0B.d = 0;
            c0B.e = 0;
            c0B.f = false;
            c0B.g = true;
            c0B.h = 0;
            c0B.i = i3;
            c0B.j = true;
            c0B.k = 0;
            c0B.l = 0;
        }
    }

    public final void a(boolean z) {
        this.b = z;
    }

    public final C0 b() {
        int i = this.d;
        C0[] c0Arr = this.c;
        if (i == c0Arr.length) {
            int length = c0Arr.length * 2;
            C0[] c0Arr2 = new C0[length];
            System.arraycopy(c0Arr, 0, c0Arr2, 0, c0Arr.length);
            for (int length2 = this.c.length; length2 < length; length2++) {
                c0Arr2[length2] = new C0();
            }
            this.c = c0Arr2;
        }
        C0[] c0Arr3 = this.c;
        int i2 = this.d;
        this.d = i2 + 1;
        return c0Arr3[i2];
    }

    public final void c() {
        int i = this.d;
        for (int i2 = 0; i2 < i; i2++) {
            C0 c0 = this.c[i2];
            c0.a = null;
            c0.b = null;
        }
        this.d = 0;
    }
}
