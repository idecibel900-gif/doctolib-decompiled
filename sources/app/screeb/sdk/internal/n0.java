package app.screeb.sdk.internal;

import android.graphics.Rect;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.WeakHashMap;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class n0 {
    public static final Method g;
    public static final Method h;
    public static final Method i;
    public static final Method j;
    public static final Method k;
    public static final Method l;
    public static final HashSet m;
    public int c;
    public int d;
    public final WeakHashMap a = new WeakHashMap();
    public int b = -1;
    public final Rect e = new Rect();
    public final HashMap f = new HashMap(32);

    static {
        C0311k0 c0311k0 = new C0311k0();
        g = C0311k0.a(c0311k0, "computeHorizontalScrollOffset");
        h = C0311k0.a(c0311k0, "computeVerticalScrollOffset");
        i = C0311k0.a(c0311k0, "computeHorizontalScrollRange");
        j = C0311k0.a(c0311k0, "computeVerticalScrollRange");
        k = C0311k0.a(c0311k0, "computeHorizontalScrollExtent");
        l = C0311k0.a(c0311k0, "computeVerticalScrollExtent");
        m = SetsKt.hashSetOf("androidx.recyclerview.widget.RecyclerView", "android.widget.AbsListView", "android.widget.ScrollView", "android.widget.HorizontalScrollView", "android.widget.NumberPicker", "androidx.core.widget.NestedScrollView", "androidx.viewpager.widget.ViewPager", "androidx.viewpager2.widget.ViewPager2", "android.webkit.WebView");
    }

    public final void a() {
        this.b = -1;
        this.c = 0;
        this.d = 0;
        this.e.setEmpty();
    }

    public final C0313l0 b() {
        if (this.b < 0) {
            return null;
        }
        int i2 = this.c;
        int i3 = this.d;
        Rect rect = this.e;
        return new C0313l0(i2, i3, rect.left, rect.top, rect.right, rect.bottom);
    }
}
