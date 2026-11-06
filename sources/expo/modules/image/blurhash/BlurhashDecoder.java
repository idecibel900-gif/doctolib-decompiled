package expo.modules.image.blurhash;

import android.graphics.Bitmap;
import android.graphics.Color;
import com.amazon.a.a.o.c.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
public final class BlurhashDecoder {
    public static final BlurhashDecoder INSTANCE = new BlurhashDecoder();
    private static final HashMap cacheCosinesX = new HashMap();
    private static final HashMap cacheCosinesY = new HashMap();
    private static final Map charMap;

    private BlurhashDecoder() {
    }

    static {
        List listListOf = CollectionsKt.listOf((Object[]) new Character[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '#', '$', '%', '*', '+', ',', '-', Character.valueOf(b.a), ':', ';', '=', '?', '@', '[', ']', '^', '_', '{', '|', '}', '~'});
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listListOf, 10));
        int i = 0;
        for (Object obj : listListOf) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Character ch = (Character) obj;
            ch.charValue();
            arrayList.add(TuplesKt.to(ch, Integer.valueOf(i)));
            i = i2;
        }
        charMap = MapsKt.toMap(arrayList);
    }

    public final void clearCache() {
        cacheCosinesX.clear();
        cacheCosinesY.clear();
    }

    public static /* synthetic */ Bitmap decode$default(BlurhashDecoder blurhashDecoder, String str, int i, int i2, float f, boolean z, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            f = 1.0f;
        }
        float f2 = f;
        if ((i3 & 16) != 0) {
            z = true;
        }
        return blurhashDecoder.decode(str, i, i2, f2, z);
    }

    public final Bitmap decode(String str, int i, int i2, float f, boolean z) {
        float[] fArrDecodeAc;
        if (str == null || str.length() < 6) {
            return null;
        }
        int iDecode83 = decode83(str, 0, 1);
        int i3 = (iDecode83 % 9) + 1;
        int i4 = (iDecode83 / 9) + 1;
        if (str.length() != (i3 * 2 * i4) + 4) {
            return null;
        }
        float fDecode83 = (decode83(str, 1, 2) + 1) / 166.0f;
        int i5 = i3 * i4;
        float[][] fArr = new float[i5][];
        for (int i6 = 0; i6 < i5; i6++) {
            if (i6 == 0) {
                BlurhashDecoder blurhashDecoder = INSTANCE;
                fArrDecodeAc = blurhashDecoder.decodeDc(blurhashDecoder.decode83(str, 2, 6));
            } else {
                int i7 = i6 * 2;
                BlurhashDecoder blurhashDecoder2 = INSTANCE;
                fArrDecodeAc = blurhashDecoder2.decodeAc(blurhashDecoder2.decode83(str, i7 + 4, i7 + 6), fDecode83 * f);
            }
            fArr[i6] = fArrDecodeAc;
        }
        return composeBitmap(i, i2, i3, i4, fArr, z);
    }

    private final int decode83(String str, int i, int i2) {
        int i3 = 0;
        while (i < i2) {
            Integer num = (Integer) charMap.get(Character.valueOf(str.charAt(i)));
            int iIntValue = num != null ? num.intValue() : -1;
            if (iIntValue != -1) {
                i3 = (i3 * 83) + iIntValue;
            }
            i++;
        }
        return i3;
    }

    private final float[] decodeDc(int i) {
        BlurhashHelpers blurhashHelpers = BlurhashHelpers.INSTANCE;
        return new float[]{blurhashHelpers.srgbToLinear(i >> 16), blurhashHelpers.srgbToLinear((i >> 8) & 255), blurhashHelpers.srgbToLinear(i & 255)};
    }

    private final float[] decodeAc(int i, float f) {
        return new float[]{signedPow2(((i / 361) - 9) / 9.0f) * f, signedPow2((((i / 19) % 19) - 9) / 9.0f) * f, signedPow2(((i % 19) - 9) / 9.0f) * f};
    }

    private final float signedPow2(float f) {
        return Math.copySign((float) Math.pow(f, 2.0f), f);
    }

    private final Bitmap composeBitmap(int i, int i2, int i3, int i4, float[][] fArr, boolean z) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        int[] iArr = new int[i5 * i6];
        boolean z2 = (z && cacheCosinesX.containsKey(Integer.valueOf(i5 * i7))) ? false : true;
        double[] arrayForCosinesX = getArrayForCosinesX(z2, i5, i7);
        boolean z3 = (z && cacheCosinesY.containsKey(Integer.valueOf(i6 * i8))) ? false : true;
        double[] arrayForCosinesY = getArrayForCosinesY(z3, i6, i8);
        int i9 = 0;
        while (i9 < i6) {
            int i10 = 0;
            while (i10 < i5) {
                float f = 0.0f;
                float f2 = 0.0f;
                float f3 = 0.0f;
                int i11 = 0;
                while (i11 < i8) {
                    float f4 = f3;
                    float f5 = f2;
                    float f6 = f;
                    int i12 = 0;
                    while (i12 < i7) {
                        double cos = getCos(arrayForCosinesX, z2, i12, i7, i10, i5);
                        int i13 = i6;
                        int i14 = i8;
                        double[] dArr = arrayForCosinesX;
                        double[] dArr2 = arrayForCosinesY;
                        int i15 = i12;
                        int i16 = i11;
                        boolean z4 = z2;
                        boolean z5 = z3;
                        int i17 = i10;
                        int i18 = i9;
                        float cos2 = (float) (cos * getCos(dArr2, z5, i16, i14, i18, i13));
                        float[] fArr2 = fArr[(i16 * i3) + i15];
                        f6 += fArr2[0] * cos2;
                        f4 += fArr2[1] * cos2;
                        f5 += fArr2[2] * cos2;
                        int i19 = i15 + 1;
                        i6 = i13;
                        i5 = i5;
                        arrayForCosinesY = dArr2;
                        i9 = i18;
                        z2 = z4;
                        i10 = i17;
                        i7 = i3;
                        z3 = z5;
                        i11 = i16;
                        i12 = i19;
                        arrayForCosinesX = dArr;
                        i8 = i4;
                    }
                    i6 = i6;
                    i5 = i5;
                    f = f6;
                    z2 = z2;
                    i10 = i10;
                    f2 = f5;
                    f3 = f4;
                    i7 = i3;
                    z3 = z3;
                    i11++;
                    arrayForCosinesX = arrayForCosinesX;
                    i8 = i4;
                }
                int i20 = i6;
                int i21 = i5;
                double[] dArr3 = arrayForCosinesX;
                boolean z6 = z3;
                int i22 = i10;
                iArr[(i21 * i9) + i22] = Color.rgb(linearToSrgb(f), linearToSrgb(f3), linearToSrgb(f2));
                int i23 = i22 + 1;
                i6 = i20;
                i5 = i21;
                z3 = z6;
                z2 = z2;
                i7 = i3;
                i10 = i23;
                arrayForCosinesX = dArr3;
                i8 = i4;
            }
            i9++;
            i6 = i6;
            i5 = i5;
            arrayForCosinesX = arrayForCosinesX;
            i7 = i3;
            i8 = i4;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iArr, i5, i6, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        return bitmapCreateBitmap;
    }

    private final double[] getArrayForCosinesY(boolean z, int i, int i2) {
        if (z) {
            int i3 = i * i2;
            double[] dArr = new double[i3];
            cacheCosinesY.put(Integer.valueOf(i3), dArr);
            return dArr;
        }
        Object obj = cacheCosinesY.get(Integer.valueOf(i * i2));
        Intrinsics.checkNotNull(obj);
        return (double[]) obj;
    }

    private final double[] getArrayForCosinesX(boolean z, int i, int i2) {
        if (z) {
            int i3 = i * i2;
            double[] dArr = new double[i3];
            cacheCosinesX.put(Integer.valueOf(i3), dArr);
            return dArr;
        }
        Object obj = cacheCosinesX.get(Integer.valueOf(i * i2));
        Intrinsics.checkNotNull(obj);
        return (double[]) obj;
    }

    private final double getCos(double[] dArr, boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            dArr[(i2 * i3) + i] = Math.cos(((((double) i3) * 3.141592653589793d) * ((double) i)) / ((double) i4));
        }
        return dArr[i + (i2 * i3)];
    }

    private final int linearToSrgb(float f) {
        float fPow;
        float f2;
        float fCoerceIn = RangesKt.coerceIn(f, 0.0f, 1.0f);
        if (fCoerceIn <= 0.0031308f) {
            fPow = fCoerceIn * 12.92f;
            f2 = 255.0f;
        } else {
            fPow = (((float) Math.pow(fCoerceIn, 0.41666666f)) * 1.055f) - 0.055f;
            f2 = 255;
        }
        return (int) ((fPow * f2) + 0.5f);
    }
}
