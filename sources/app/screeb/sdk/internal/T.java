package app.screeb.sdk.internal;

import android.graphics.Color;
import android.graphics.Paint;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class T {
    public static final int[] d = new int[0];
    public static final Paint e;
    public int[] a = new int[64];
    public int[] b = new int[16];
    public int c;

    static {
        Paint paint = new Paint();
        paint.setColor(Color.rgb(204, 204, 204));
        paint.setStyle(Paint.Style.FILL);
        e = paint;
    }

    public final void a() {
        this.c = 0;
    }

    public final void a(int i, int i2, int i3, int i4, int i5, boolean z) {
        if (i3 <= i || i4 <= i2) {
            return;
        }
        int i6 = this.c + 4;
        int[] iArr = this.a;
        if (i6 > iArr.length) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length * 2);
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
            this.a = iArrCopyOf;
            int[] iArr2 = this.b;
            int[] iArrCopyOf2 = Arrays.copyOf(iArr2, iArr2.length * 2);
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf2, "copyOf(...)");
            this.b = iArrCopyOf2;
        }
        int[] iArr3 = this.a;
        int i7 = this.c;
        iArr3[i7] = i;
        iArr3[i7 + 1] = i2;
        iArr3[i7 + 2] = i3;
        iArr3[i7 + 3] = i4;
        this.b[i7 / 4] = ((i5 << 1) | (z ? 1 : 0)) == true ? 1 : 0;
        this.c = i7 + 4;
    }

    public final int[] b() {
        int i;
        if (this.c == 0) {
            return d;
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = this.c;
            if (i2 >= i) {
                break;
            }
            if ((this.b[i2 / 4] >> 1) == 0) {
                i3 += 4;
            }
            i2 += 4;
        }
        if (i3 == i) {
            int[] iArrCopyOf = Arrays.copyOf(this.a, i);
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
            return iArrCopyOf;
        }
        if (i3 == 0) {
            return d;
        }
        int[] iArr = new int[i3];
        int i4 = 0;
        for (int i5 = 0; i5 < this.c; i5 += 4) {
            if ((this.b[i5 / 4] >> 1) == 0) {
                int[] iArr2 = this.a;
                iArr[i4] = iArr2[i5];
                iArr[i4 + 1] = iArr2[i5 + 1];
                iArr[i4 + 2] = iArr2[i5 + 2];
                iArr[i4 + 3] = iArr2[i5 + 3];
                i4 += 4;
            }
        }
        return iArr;
    }
}
