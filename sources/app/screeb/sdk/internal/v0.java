package app.screeb.sdk.internal;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class v0 {
    public final ArrayList a = new ArrayList(32);
    public final int[] b = new int[2];
    public final Rect c = new Rect();
    public final Paint d = new Paint(1);
    public final Paint e;
    public final StringBuilder f;
    public int g;
    public int h;

    public v0() {
        Paint paint = new Paint(1);
        paint.setColor(-16777216);
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setSubpixelText(true);
        this.e = paint;
        this.f = new StringBuilder(64);
    }

    public final void a() {
        this.a.clear();
    }

    public final void a(Bitmap bitmap, double d, int i, int i2) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        if (this.a.isEmpty()) {
            return;
        }
        Canvas canvas = new Canvas(bitmap);
        Iterator it = this.a.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            u0 u0Var = (u0) next;
            int iCoerceIn = RangesKt.coerceIn(((int) Math.floor(((double) u0Var.a) * d)) - i, 0, bitmap.getWidth());
            int iCoerceIn2 = RangesKt.coerceIn(((int) Math.floor(((double) u0Var.b) * d)) - i2, 0, bitmap.getHeight());
            int iCoerceIn3 = RangesKt.coerceIn(((int) Math.ceil(((double) u0Var.c) * d)) - i, 0, bitmap.getWidth());
            int iCoerceIn4 = RangesKt.coerceIn(((int) Math.ceil(((double) u0Var.d) * d)) - i2, 0, bitmap.getHeight());
            if (iCoerceIn3 > iCoerceIn && iCoerceIn4 > iCoerceIn2) {
                this.d.setColor(u0Var.g);
                canvas.save();
                canvas.clipRect(iCoerceIn, iCoerceIn2, iCoerceIn3, iCoerceIn4);
                float f = iCoerceIn;
                float f2 = iCoerceIn2;
                canvas.drawRect(f, f2, iCoerceIn3, iCoerceIn4, this.d);
                if (!u0Var.h && u0Var.e > 0) {
                    float f3 = iCoerceIn4 - iCoerceIn2;
                    float f4 = iCoerceIn3 - iCoerceIn;
                    this.e.setTextSize(RangesKt.coerceIn((float) (((double) u0Var.f) * d), 6.0f, Math.max(6.0f, 0.9f * f3)));
                    Paint paint = this.e;
                    int i3 = u0Var.g;
                    paint.setColor(((int) ((((double) Color.blue(i3)) * 0.114d) + ((((double) Color.green(i3)) * 0.587d) + (((double) Color.red(i3)) * 0.299d)))) < 128 ? -1 : -16777216);
                    int iCoerceAtMost = RangesKt.coerceAtMost(u0Var.e, RangesKt.coerceAtLeast((int) (f4 / RangesKt.coerceAtLeast(this.e.measureText("*"), 1.0f)), 1));
                    this.f.setLength(0);
                    for (int i4 = 0; i4 < iCoerceAtMost; i4++) {
                        this.f.append('*');
                    }
                    canvas.drawText(this.f, 0, iCoerceAtMost, f, ((f3 * 0.5f) + f2) - ((this.e.descent() + this.e.ascent()) * 0.5f), this.e);
                }
                canvas.restore();
            }
        }
    }

    public final void a(View root) {
        Intrinsics.checkNotNullParameter(root, "root");
        this.a.clear();
        float f = root.getResources().getDisplayMetrics().density;
        root.getLocationInWindow(this.b);
        int[] iArr = this.b;
        int i = iArr[0];
        int i2 = iArr[1];
        root.getLocationOnScreen(iArr);
        int[] iArr2 = this.b;
        this.g = iArr2[0] - i;
        this.h = iArr2[1] - i2;
    }

    public final void a(AccessibilityNodeInfo accessibilityNodeInfo, int i) {
        AccessibilityNodeInfo child;
        if (this.a.size() < 256 && i <= 32) {
            CharSequence text = accessibilityNodeInfo.getText();
            if (text == null) {
                text = accessibilityNodeInfo.getContentDescription();
            }
            if (text != null && text.length() != 0 && accessibilityNodeInfo.isVisibleToUser()) {
                accessibilityNodeInfo.getBoundsInScreen(this.c);
                int iWidth = this.c.width();
                int iHeight = this.c.height();
                if (iWidth > 0 && iHeight > 0) {
                    ArrayList arrayList = this.a;
                    Rect rect = this.c;
                    int i2 = rect.left;
                    int i3 = this.g;
                    int i4 = rect.top;
                    int i5 = this.h;
                    arrayList.add(new u0(i2 - i3, i4 - i5, rect.right - i3, rect.bottom - i5, RangesKt.coerceAtMost(text.length(), 200), iHeight * 0.7f, -1, false));
                }
            }
            int childCount = accessibilityNodeInfo.getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                try {
                    child = accessibilityNodeInfo.getChild(i6);
                } catch (Throwable unused) {
                    child = null;
                }
                if (child != null) {
                    try {
                        a(child, i + 1);
                        if (Build.VERSION.SDK_INT < 33) {
                            try {
                                child.recycle();
                            } catch (Throwable unused2) {
                            }
                        }
                    } catch (Throwable th) {
                        if (Build.VERSION.SDK_INT >= 33) {
                            throw th;
                        }
                        try {
                            child.recycle();
                            throw th;
                        } catch (Throwable unused3) {
                            throw th;
                        }
                    }
                }
            }
        }
    }
}
