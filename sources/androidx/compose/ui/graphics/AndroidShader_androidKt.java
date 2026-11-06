package androidx.compose.ui.graphics;

import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.os.Build;
import androidx.compose.ui.geometry.Offset;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class AndroidShader_androidKt {
    /* JADX INFO: renamed from: ActualLinearGradientShader-VjE6UOU, reason: not valid java name */
    public static final Shader m1308ActualLinearGradientShaderVjE6UOU(long j, long j2, List list, List list2, int i) {
        validateColorStops(list, list2);
        int iCountTransparentColors = countTransparentColors(list);
        return new android.graphics.LinearGradient(Offset.m1223getXimpl(j), Offset.m1224getYimpl(j), Offset.m1223getXimpl(j2), Offset.m1224getYimpl(j2), makeTransparentColors(list, iCountTransparentColors), makeTransparentStops(list2, list, iCountTransparentColors), AndroidTileMode_androidKt.m1310toAndroidTileMode0vamqd0(i));
    }

    /* JADX INFO: renamed from: ActualRadialGradientShader-8uybcMk, reason: not valid java name */
    public static final Shader m1309ActualRadialGradientShader8uybcMk(long j, float f, List list, List list2, int i) {
        validateColorStops(list, list2);
        int iCountTransparentColors = countTransparentColors(list);
        return new RadialGradient(Offset.m1223getXimpl(j), Offset.m1224getYimpl(j), f, makeTransparentColors(list, iCountTransparentColors), makeTransparentStops(list2, list, iCountTransparentColors), AndroidTileMode_androidKt.m1310toAndroidTileMode0vamqd0(i));
    }

    public static final int countTransparentColors(List list) {
        int i = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            return 0;
        }
        int lastIndex = CollectionsKt.getLastIndex(list);
        for (int i2 = 1; i2 < lastIndex; i2++) {
            if (Color.m1368getAlphaimpl(((Color) list.get(i2)).m1375unboximpl()) == 0.0f) {
                i++;
            }
        }
        return i;
    }

    public static final int[] makeTransparentColors(List list, int i) {
        int i2;
        int i3 = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            int size = list.size();
            int[] iArr = new int[size];
            while (i3 < size) {
                iArr[i3] = ColorKt.m1393toArgb8_81llA(((Color) list.get(i3)).m1375unboximpl());
                i3++;
            }
            return iArr;
        }
        int[] iArr2 = new int[list.size() + i];
        int lastIndex = CollectionsKt.getLastIndex(list);
        int size2 = list.size();
        int i4 = 0;
        while (i3 < size2) {
            long jM1375unboximpl = ((Color) list.get(i3)).m1375unboximpl();
            if (Color.m1368getAlphaimpl(jM1375unboximpl) == 0.0f) {
                if (i3 == 0) {
                    i2 = i4 + 1;
                    iArr2[i4] = ColorKt.m1393toArgb8_81llA(Color.m1365copywmQWz5c$default(((Color) list.get(1)).m1375unboximpl(), 0.0f, 0.0f, 0.0f, 0.0f, 14, null));
                } else if (i3 == lastIndex) {
                    i2 = i4 + 1;
                    iArr2[i4] = ColorKt.m1393toArgb8_81llA(Color.m1365copywmQWz5c$default(((Color) list.get(i3 - 1)).m1375unboximpl(), 0.0f, 0.0f, 0.0f, 0.0f, 14, null));
                } else {
                    int i5 = i4 + 1;
                    iArr2[i4] = ColorKt.m1393toArgb8_81llA(Color.m1365copywmQWz5c$default(((Color) list.get(i3 - 1)).m1375unboximpl(), 0.0f, 0.0f, 0.0f, 0.0f, 14, null));
                    i4 += 2;
                    iArr2[i5] = ColorKt.m1393toArgb8_81llA(Color.m1365copywmQWz5c$default(((Color) list.get(i3 + 1)).m1375unboximpl(), 0.0f, 0.0f, 0.0f, 0.0f, 14, null));
                }
                i4 = i2;
            } else {
                iArr2[i4] = ColorKt.m1393toArgb8_81llA(jM1375unboximpl);
                i4++;
            }
            i3++;
        }
        return iArr2;
    }

    public static final float[] makeTransparentStops(List list, List list2, int i) {
        if (i == 0) {
            if (list != null) {
                return CollectionsKt.toFloatArray(list);
            }
            return null;
        }
        float[] fArr = new float[list2.size() + i];
        fArr[0] = list != null ? ((Number) list.get(0)).floatValue() : 0.0f;
        int lastIndex = CollectionsKt.getLastIndex(list2);
        int i2 = 1;
        for (int i3 = 1; i3 < lastIndex; i3++) {
            long jM1375unboximpl = ((Color) list2.get(i3)).m1375unboximpl();
            float fFloatValue = list != null ? ((Number) list.get(i3)).floatValue() : i3 / CollectionsKt.getLastIndex(list2);
            int i4 = i2 + 1;
            fArr[i2] = fFloatValue;
            if (Color.m1368getAlphaimpl(jM1375unboximpl) == 0.0f) {
                i2 += 2;
                fArr[i4] = fFloatValue;
            } else {
                i2 = i4;
            }
        }
        fArr[i2] = list != null ? ((Number) list.get(CollectionsKt.getLastIndex(list2))).floatValue() : 1.0f;
        return fArr;
    }

    private static final void validateColorStops(List list, List list2) {
        if (list2 == null) {
            if (list.size() < 2) {
                throw new IllegalArgumentException("colors must have length of at least 2 if colorStops is omitted.");
            }
        } else if (list.size() != list2.size()) {
            throw new IllegalArgumentException("colors and colorStops arguments must have equal length.");
        }
    }
}
