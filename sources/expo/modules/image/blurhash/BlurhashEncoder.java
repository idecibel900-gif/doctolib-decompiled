package expo.modules.image.blurhash;

import android.graphics.Bitmap;
import android.graphics.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class BlurhashEncoder {
    public static final BlurhashEncoder INSTANCE = new BlurhashEncoder();

    private BlurhashEncoder() {
    }

    public final String encode(Bitmap image, Pair numberOfComponents) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(numberOfComponents, "numberOfComponents");
        int[] iArr = new int[image.getWidth() * image.getHeight()];
        image.getPixels(iArr, 0, image.getWidth(), 0, 0, image.getWidth(), image.getHeight());
        List listCalculateBlurFactors = calculateBlurFactors(iArr, image.getWidth(), image.getHeight(), numberOfComponents);
        Triple triple = (Triple) CollectionsKt.first(listCalculateBlurFactors);
        List listDrop = CollectionsKt.drop(listCalculateBlurFactors, 1);
        StringBuilder sb = new StringBuilder();
        encodeFlag(numberOfComponents, sb);
        float fEncodeMaximumValue = encodeMaximumValue(listDrop, sb);
        sb.append(encode83(encodeDC(triple), 4));
        Iterator it = listDrop.iterator();
        while (it.hasNext()) {
            sb.append(encode83(encodeAC((Triple) it.next(), fEncodeMaximumValue), 2));
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private final void encodeFlag(Pair pair, StringBuilder sb) {
        sb.append(encode83((((Number) pair.getFirst()).intValue() - 1) + ((((Number) pair.getSecond()).intValue() - 1) * 9), 1));
    }

    private final float encodeMaximumValue(List list, StringBuilder sb) {
        if (!list.isEmpty()) {
            Iterator it = list.iterator();
            if (!it.hasNext()) {
                throw new NoSuchElementException();
            }
            Triple triple = (Triple) it.next();
            float fMax = Math.max(Math.max(Math.abs(((Number) triple.getFirst()).floatValue()), Math.abs(((Number) triple.getSecond()).floatValue())), Math.abs(((Number) triple.getThird()).floatValue()));
            while (it.hasNext()) {
                Triple triple2 = (Triple) it.next();
                fMax = Math.max(fMax, Math.max(Math.max(Math.abs(((Number) triple2.getFirst()).floatValue()), Math.abs(((Number) triple2.getSecond()).floatValue())), Math.abs(((Number) triple2.getThird()).floatValue())));
            }
            int iMax = (int) Math.max(0.0f, Math.min(82.0f, (float) Math.floor((fMax * 166.0f) - 0.5f)));
            float f = (iMax + 1) / 166.0f;
            sb.append(encode83(iMax, 1));
            return f;
        }
        sb.append(encode83(0, 1));
        return 1.0f;
    }

    private final List calculateBlurFactors(int[] iArr, int i, int i2, Pair pair) {
        ArrayList arrayList = new ArrayList();
        int iIntValue = ((Number) pair.getSecond()).intValue();
        int i3 = 0;
        while (i3 < iIntValue) {
            int iIntValue2 = ((Number) pair.getFirst()).intValue();
            int i4 = 0;
            while (i4 < iIntValue2) {
                int[] iArr2 = iArr;
                int i5 = i;
                int i6 = i2;
                arrayList.add(multiplyBasisFunction(iArr2, i5, i6, i4, i3, (i4 == 0 && i3 == 0) ? 1.0f : 2.0f));
                i4++;
                iArr = iArr2;
                i = i5;
                i2 = i6;
            }
            i3++;
        }
        return arrayList;
    }

    private final String encode83(int i, int i2) {
        String str = "";
        int i3 = 1;
        if (1 <= i2) {
            while (true) {
                str = str + "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz#$%*+,-.:;=?@[]^_{|}~".charAt((int) ((i / ((float) Math.pow(83.0f, i2 - i3))) % 83.0f));
                if (i3 == i2) {
                    break;
                }
                i3++;
            }
        }
        return str;
    }

    private final int encodeDC(Triple triple) {
        BlurhashHelpers blurhashHelpers = BlurhashHelpers.INSTANCE;
        int iLinearTosRGB = blurhashHelpers.linearTosRGB(((Number) triple.getFirst()).floatValue());
        int iLinearTosRGB2 = blurhashHelpers.linearTosRGB(((Number) triple.getSecond()).floatValue());
        return (iLinearTosRGB << 16) + (iLinearTosRGB2 << 8) + blurhashHelpers.linearTosRGB(((Number) triple.getThird()).floatValue());
    }

    private final int encodeAC(Triple triple, float f) {
        BlurhashHelpers blurhashHelpers = BlurhashHelpers.INSTANCE;
        return (int) ((Math.max(0.0f, Math.min(18.0f, (float) Math.floor((blurhashHelpers.signPow(((Number) triple.getFirst()).floatValue() / f, 0.5f) * 9.0f) + 9.5f))) * 19.0f * 19.0f) + (Math.max(0.0f, Math.min(18.0f, (float) Math.floor((blurhashHelpers.signPow(((Number) triple.getSecond()).floatValue() / f, 0.5f) * 9.0f) + 9.5f))) * 19.0f) + Math.max(0.0f, Math.min(18.0f, (float) Math.floor((blurhashHelpers.signPow(((Number) triple.getThird()).floatValue() / f, 0.5f) * 9.0f) + 9.5f))));
    }

    private final Triple multiplyBasisFunction(int[] iArr, int i, int i2, int i3, int i4, float f) {
        float fSrgbToLinear = 0.0f;
        float fSrgbToLinear2 = 0.0f;
        float fSrgbToLinear3 = 0.0f;
        for (int i5 = 0; i5 < i2; i5++) {
            for (int i6 = 0; i6 < i; i6++) {
                float fCos = ((float) Math.cos(((i3 * 3.1415927f) * i6) / i)) * f * ((float) Math.cos(((i4 * 3.1415927f) * i5) / i2));
                int i7 = iArr[(i5 * i) + i6];
                BlurhashHelpers blurhashHelpers = BlurhashHelpers.INSTANCE;
                fSrgbToLinear += blurhashHelpers.srgbToLinear(Color.red(i7)) * fCos;
                fSrgbToLinear2 += blurhashHelpers.srgbToLinear(Color.green(i7)) * fCos;
                fSrgbToLinear3 += fCos * blurhashHelpers.srgbToLinear(Color.blue(i7));
            }
        }
        float f2 = 1.0f / (i * i2);
        return new Triple(Float.valueOf(fSrgbToLinear * f2), Float.valueOf(fSrgbToLinear2 * f2), Float.valueOf(fSrgbToLinear3 * f2));
    }
}
