package jp.wasabeef.glide.transformations.internal;

import android.graphics.Bitmap;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes5.dex */
public abstract class FastBlur {
    public static Bitmap blur(Bitmap bitmap, int i, boolean z) {
        int i2;
        int i3 = i;
        Bitmap bitmapCopy = z ? bitmap : bitmap.copy(bitmap.getConfig(), true);
        if (i3 < 1) {
            return null;
        }
        int width = bitmapCopy.getWidth();
        int height = bitmapCopy.getHeight();
        int i4 = width * height;
        int[] iArr = new int[i4];
        bitmapCopy.getPixels(iArr, 0, width, 0, 0, width, height);
        int i5 = width - 1;
        int i6 = height - 1;
        int i7 = i3 + i3;
        int i8 = i7 + 1;
        int[] iArr2 = new int[i4];
        int[] iArr3 = new int[i4];
        int[] iArr4 = new int[i4];
        int[] iArr5 = new int[Math.max(width, height)];
        int i9 = (i7 + 2) >> 1;
        int i10 = i9 * i9;
        int i11 = i10 * IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER;
        int[] iArr6 = new int[i11];
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            iArr6[i13] = i13 / i10;
        }
        int[][] iArr7 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i8, 3);
        int i14 = i3 + 1;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        while (i15 < height) {
            int[] iArr8 = iArr6;
            int i18 = -i3;
            int i19 = i12;
            int i20 = i19;
            int i21 = i20;
            int i22 = i21;
            int i23 = i22;
            int i24 = i23;
            int i25 = i24;
            int i26 = i25;
            int i27 = i26;
            while (i18 <= i3) {
                int[] iArr9 = iArr4;
                Bitmap bitmap2 = bitmapCopy;
                int i28 = i12;
                int i29 = iArr[i16 + Math.min(i5, Math.max(i18, i28))];
                int[] iArr10 = iArr7[i18 + i3];
                iArr10[i28] = (i29 & 16711680) >> 16;
                iArr10[1] = (i29 & 65280) >> 8;
                iArr10[2] = i29 & 255;
                int iAbs = i14 - Math.abs(i18);
                int i30 = iArr10[i28];
                i27 += i30 * iAbs;
                int i31 = iArr10[1];
                i19 += i31 * iAbs;
                int i32 = iArr10[2];
                i20 += iAbs * i32;
                if (i18 > 0) {
                    i24 += i30;
                    i25 += i31;
                    i26 += i32;
                } else {
                    i21 += i30;
                    i22 += i31;
                    i23 += i32;
                }
                i18++;
                iArr4 = iArr9;
                bitmapCopy = bitmap2;
                i12 = 0;
            }
            int[] iArr11 = iArr4;
            Bitmap bitmap3 = bitmapCopy;
            int i33 = i3;
            int i34 = 0;
            while (i34 < width) {
                iArr2[i16] = iArr8[i27];
                iArr3[i16] = iArr8[i19];
                iArr11[i16] = iArr8[i20];
                int i35 = i27 - i21;
                int i36 = i19 - i22;
                int i37 = i20 - i23;
                int[] iArr12 = iArr7[((i33 - i3) + i8) % i8];
                int i38 = i21 - iArr12[0];
                int i39 = i22 - iArr12[1];
                int i40 = i23 - iArr12[2];
                if (i15 == 0) {
                    i2 = i34;
                    iArr5[i2] = Math.min(i34 + i3 + 1, i5);
                } else {
                    i2 = i34;
                }
                int i41 = iArr[i17 + iArr5[i2]];
                int i42 = (i41 & 16711680) >> 16;
                iArr12[0] = i42;
                int i43 = (i41 & 65280) >> 8;
                iArr12[1] = i43;
                int i44 = i41 & 255;
                iArr12[2] = i44;
                int i45 = i24 + i42;
                int i46 = i25 + i43;
                int i47 = i26 + i44;
                i27 = i35 + i45;
                i19 = i36 + i46;
                i20 = i37 + i47;
                i33 = (i33 + 1) % i8;
                int[] iArr13 = iArr7[i33 % i8];
                int i48 = iArr13[0];
                i21 = i38 + i48;
                int i49 = iArr13[1];
                i22 = i39 + i49;
                int i50 = iArr13[2];
                i23 = i40 + i50;
                i24 = i45 - i48;
                i25 = i46 - i49;
                i26 = i47 - i50;
                i16++;
                i34 = i2 + 1;
            }
            i17 += width;
            i15++;
            iArr6 = iArr8;
            iArr4 = iArr11;
            bitmapCopy = bitmap3;
            i12 = 0;
        }
        int[] iArr14 = iArr6;
        int[] iArr15 = iArr4;
        Bitmap bitmap4 = bitmapCopy;
        int i51 = 0;
        while (i51 < width) {
            int i52 = -i3;
            int i53 = i51;
            int i54 = i52 * width;
            int i55 = 0;
            int i56 = 0;
            int i57 = 0;
            int i58 = 0;
            int i59 = 0;
            int i60 = 0;
            int i61 = 0;
            int i62 = 0;
            int i63 = 0;
            while (i52 <= i3) {
                int iMax = Math.max(0, i54) + i53;
                int[] iArr16 = iArr7[i52 + i];
                iArr16[0] = iArr2[iMax];
                iArr16[1] = iArr3[iMax];
                iArr16[2] = iArr15[iMax];
                int iAbs2 = i14 - Math.abs(i52);
                i63 += iArr2[iMax] * iAbs2;
                i55 += iArr3[iMax] * iAbs2;
                i56 += iArr15[iMax] * iAbs2;
                if (i52 > 0) {
                    i60 += iArr16[0];
                    i61 += iArr16[1];
                    i62 += iArr16[2];
                } else {
                    i57 += iArr16[0];
                    i58 += iArr16[1];
                    i59 += iArr16[2];
                }
                if (i52 < i6) {
                    i54 += width;
                }
                i52++;
                i3 = i;
            }
            int i64 = i63;
            int i65 = i53;
            int i66 = i;
            for (int i67 = 0; i67 < height; i67++) {
                iArr[i65] = (iArr[i65] & (-16777216)) | (iArr14[i64] << 16) | (iArr14[i55] << 8) | iArr14[i56];
                int i68 = i64 - i57;
                int i69 = i55 - i58;
                int i70 = i56 - i59;
                int[] iArr17 = iArr7[((i66 - i) + i8) % i8];
                int i71 = i57 - iArr17[0];
                int i72 = i58 - iArr17[1];
                int i73 = i59 - iArr17[2];
                int i74 = i65;
                if (i53 == 0) {
                    iArr5[i67] = Math.min(i67 + i14, i6) * width;
                }
                int i75 = i53 + iArr5[i67];
                int i76 = iArr2[i75];
                iArr17[0] = i76;
                int i77 = iArr3[i75];
                iArr17[1] = i77;
                int i78 = iArr15[i75];
                iArr17[2] = i78;
                int i79 = i60 + i76;
                int i80 = i61 + i77;
                int i81 = i62 + i78;
                i64 = i68 + i79;
                i55 = i69 + i80;
                i56 = i70 + i81;
                i66 = (i66 + 1) % i8;
                int[] iArr18 = iArr7[i66];
                int i82 = iArr18[0];
                i57 = i71 + i82;
                int i83 = iArr18[1];
                i58 = i72 + i83;
                int i84 = iArr18[2];
                i59 = i73 + i84;
                i60 = i79 - i82;
                i61 = i80 - i83;
                i62 = i81 - i84;
                i65 = i74 + width;
            }
            i51 = i53 + 1;
            i3 = i;
        }
        bitmap4.setPixels(iArr, 0, width, 0, 0, width, height);
        return bitmap4;
    }
}
