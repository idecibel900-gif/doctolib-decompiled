package app.screeb.sdk.internal;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class N {
    public static final Class t;
    public static final Lazy u;
    public static final Lazy v;
    public static final HashMap w;
    public static final HashMap x;
    public static final IdentityHashMap y;
    public int a;
    public boolean r;
    public long[] b = new long[IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER];
    public long[] c = new long[IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER];
    public byte[] d = new byte[IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER];
    public byte[] e = new byte[IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER];
    public int[] f = new int[IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER];
    public int[] g = new int[IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER];
    public int[] h = new int[IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER];
    public int[] i = new int[IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER];
    public int[] j = new int[IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER];
    public int[] k = new int[IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER];
    public int[] l = new int[IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER];
    public int[] m = new int[IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER];
    public long[] n = new long[IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER];
    public int[] o = new int[IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER];
    public final StringBuilder p = new StringBuilder(8192);
    public final StringBuilder q = new StringBuilder(2048);
    public final HashSet s = new HashSet();

    static {
        Class<RecyclerView> cls;
        try {
            cls = RecyclerView.class;
            int i = RecyclerView.$r8$clinit;
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        t = cls;
        u = LazyKt.lazy(new Function0() { // from class: app.screeb.sdk.internal.N$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return N.b();
            }
        });
        v = LazyKt.lazy(new Function0() { // from class: app.screeb.sdk.internal.N$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return N.a();
            }
        });
        w = new HashMap();
        x = new HashMap();
        y = new IdentityHashMap();
    }

    public static final Method a() {
        try {
            Class cls = t;
            if (cls != null) {
                return cls.getMethod("getAdapter", null);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final Method b() {
        try {
            Class cls = t;
            if (cls != null) {
                return cls.getMethod("getChildAdapterPosition", View.class);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public final int a(long j, long j2, byte b, byte b2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j3) {
        int i10 = this.a;
        long[] jArr = this.b;
        if (i10 == jArr.length) {
            int length = jArr.length * 2;
            long[] jArrCopyOf = Arrays.copyOf(jArr, length);
            Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
            this.b = jArrCopyOf;
            long[] jArrCopyOf2 = Arrays.copyOf(this.c, length);
            Intrinsics.checkNotNullExpressionValue(jArrCopyOf2, "copyOf(...)");
            this.c = jArrCopyOf2;
            byte[] bArrCopyOf = Arrays.copyOf(this.d, length);
            Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
            this.d = bArrCopyOf;
            byte[] bArrCopyOf2 = Arrays.copyOf(this.e, length);
            Intrinsics.checkNotNullExpressionValue(bArrCopyOf2, "copyOf(...)");
            this.e = bArrCopyOf2;
            int[] iArrCopyOf = Arrays.copyOf(this.f, length);
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
            this.f = iArrCopyOf;
            int[] iArrCopyOf2 = Arrays.copyOf(this.g, length);
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf2, "copyOf(...)");
            this.g = iArrCopyOf2;
            int[] iArrCopyOf3 = Arrays.copyOf(this.h, length);
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf3, "copyOf(...)");
            this.h = iArrCopyOf3;
            int[] iArrCopyOf4 = Arrays.copyOf(this.i, length);
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf4, "copyOf(...)");
            this.i = iArrCopyOf4;
            int[] iArrCopyOf5 = Arrays.copyOf(this.j, length);
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf5, "copyOf(...)");
            this.j = iArrCopyOf5;
            int[] iArrCopyOf6 = Arrays.copyOf(this.k, length);
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf6, "copyOf(...)");
            this.k = iArrCopyOf6;
            int[] iArrCopyOf7 = Arrays.copyOf(this.l, length);
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf7, "copyOf(...)");
            this.l = iArrCopyOf7;
            int[] iArrCopyOf8 = Arrays.copyOf(this.m, length);
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf8, "copyOf(...)");
            this.m = iArrCopyOf8;
            long[] jArrCopyOf3 = Arrays.copyOf(this.n, length);
            Intrinsics.checkNotNullExpressionValue(jArrCopyOf3, "copyOf(...)");
            this.n = jArrCopyOf3;
            int[] iArrCopyOf9 = Arrays.copyOf(this.o, length);
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf9, "copyOf(...)");
            this.o = iArrCopyOf9;
        }
        int i11 = this.a;
        this.b[i11] = j;
        this.c[i11] = j2;
        this.d[i11] = b;
        this.e[i11] = b2;
        this.f[i11] = i;
        this.g[i11] = i2;
        this.h[i11] = i3;
        this.i[i11] = i4;
        this.j[i11] = i5;
        this.k[i11] = i6;
        this.l[i11] = i7;
        this.m[i11] = i8;
        this.o[i11] = i9;
        this.n[i11] = j3;
        this.a = i11 + 1;
        return i11;
    }

    public final void c() {
        this.a = 0;
        this.p.setLength(0);
        this.q.setLength(0);
        this.r = false;
        this.s.clear();
    }
}
