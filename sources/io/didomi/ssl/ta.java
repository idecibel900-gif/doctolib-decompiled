package io.didomi.ssl;

import android.graphics.Bitmap;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\n"}, d2 = {"Lio/didomi/sdk/ta;", "", "", "str", "", "size", "Landroid/graphics/Bitmap;", "a", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
public final class ta {
    public static final ta a = new ta();

    private ta() {
    }

    public final Bitmap a(String str, int size) {
        try {
            BitMatrix bitMatrixEncode = new MultiFormatWriter().encode(str, BarcodeFormat.QR_CODE, size, size, null);
            Intrinsics.checkNotNullExpressionValue(bitMatrixEncode, "{\n            MultiForma…l\n            )\n        }");
            int width = bitMatrixEncode.getWidth();
            int height = bitMatrixEncode.getHeight();
            int[] iArr = new int[width * height];
            for (int i = 0; i < height; i++) {
                int i2 = i * width;
                for (int i3 = 0; i3 < width; i3++) {
                    iArr[i2 + i3] = bitMatrixEncode.get(i3, i) ? -16777216 : -1;
                }
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            bitmapCreateBitmap.setPixels(iArr, 0, size, 0, 0, width, height);
            return bitmapCreateBitmap;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}
