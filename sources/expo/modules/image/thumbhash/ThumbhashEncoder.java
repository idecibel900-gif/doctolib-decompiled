package expo.modules.image.thumbhash;

import android.graphics.Bitmap;
import android.graphics.Color;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ThumbhashEncoder {
    public static final ThumbhashEncoder INSTANCE = new ThumbhashEncoder();

    private ThumbhashEncoder() {
    }

    public final byte[] encode(Bitmap bitmap) {
        int length;
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Bitmap bitmapResizeKeepingAspectRatio = resizeKeepingAspectRatio(bitmap, 100);
        int width = bitmapResizeKeepingAspectRatio.getWidth();
        int height = bitmapResizeKeepingAspectRatio.getHeight();
        int i = width * height;
        int[] iArr = new int[i];
        bitmapResizeKeepingAspectRatio.getPixels(iArr, 0, width, 0, 0, width, height);
        float f = 0.0f;
        float fRed = 0.0f;
        float fGreen = 0.0f;
        float fBlue = 0.0f;
        for (int i2 = 0; i2 < i; i2++) {
            float fAlpha = Color.alpha(iArr[i2]) / 255.0f;
            float f2 = fAlpha / 255.0f;
            fRed += Color.red(iArr[i2]) * f2;
            fGreen += Color.green(iArr[i2]) * f2;
            fBlue += f2 * Color.blue(iArr[i2]);
            f += fAlpha;
        }
        if (f > 0.0f) {
            fRed /= f;
            fGreen /= f;
            fBlue /= f;
        }
        boolean z = f < ((float) i);
        int i3 = z ? 5 : 7;
        int iMax = Math.max(1, Math.round((i3 * width) / Math.max(width, height)));
        int iMax2 = Math.max(1, Math.round((i3 * height) / Math.max(width, height)));
        float[] fArr = new float[i];
        float[] fArr2 = new float[i];
        float[] fArr3 = new float[i];
        float[] fArr4 = new float[i];
        int i4 = 0;
        while (i4 < i) {
            int i5 = i;
            float fAlpha2 = (Color.alpha(iArr[i4]) & 255) / 255.0f;
            float f3 = 1.0f - fAlpha2;
            float f4 = fAlpha2 / 255.0f;
            float fRed2 = (fRed * f3) + (Color.red(iArr[i4]) * f4);
            float fGreen2 = (fGreen * f3) + (Color.green(iArr[i4]) * f4);
            float fBlue2 = (f3 * fBlue) + (f4 * Color.blue(iArr[i4]));
            float f5 = fRed2 + fGreen2;
            fArr[i4] = (f5 + fBlue2) / 3.0f;
            fArr2[i4] = (f5 / 2.0f) - fBlue2;
            fArr3[i4] = fRed2 - fGreen2;
            fArr4[i4] = fAlpha2;
            i4++;
            i = i5;
        }
        Channel channelEncode = new Channel(Math.max(3, iMax), Math.max(3, iMax2)).encode(width, height, fArr);
        Channel channelEncode2 = new Channel(3, 3).encode(width, height, fArr2);
        Channel channelEncode3 = new Channel(3, 3).encode(width, height, fArr3);
        Channel channelEncode4 = z ? new Channel(5, 5).encode(width, height, fArr4) : null;
        boolean z2 = width > height;
        int iRound = Math.round(channelEncode.getDc() * 63.0f) | (Math.round((channelEncode2.getDc() * 31.5f) + 31.5f) << 6) | (Math.round((channelEncode3.getDc() * 31.5f) + 31.5f) << 12) | (Math.round(channelEncode.getScale() * 31.0f) << 18) | (z ? 8388608 : 0);
        if (z2) {
            iMax = iMax2;
        }
        int iRound2 = (z2 ? 32768 : 0) | (Math.round(channelEncode3.getScale() * 63.0f) << 9) | (Math.round(channelEncode2.getScale() * 63.0f) << 3) | iMax;
        int i6 = z ? 6 : 5;
        int length2 = channelEncode.getAc().length + channelEncode2.getAc().length + channelEncode3.getAc().length;
        if (z) {
            Intrinsics.checkNotNull(channelEncode4);
            length = channelEncode4.getAc().length;
        } else {
            length = 0;
        }
        byte[] bArr = new byte[(((length2 + length) + 1) / 2) + i6];
        bArr[0] = (byte) iRound;
        bArr[1] = (byte) (iRound >> 8);
        bArr[2] = (byte) (iRound >> 16);
        bArr[3] = (byte) iRound2;
        bArr[4] = (byte) (iRound2 >> 8);
        if (z) {
            Intrinsics.checkNotNull(channelEncode4);
            bArr[5] = (byte) (Math.round(channelEncode4.getDc() * 15.0f) | (Math.round(channelEncode4.getScale() * 15.0f) << 4));
        }
        int iWriteTo = channelEncode3.writeTo(bArr, i6, channelEncode2.writeTo(bArr, i6, channelEncode.writeTo(bArr, i6, 0)));
        if (z) {
            Intrinsics.checkNotNull(channelEncode4);
            channelEncode4.writeTo(bArr, i6, iWriteTo);
        }
        return bArr;
    }

    private final Bitmap resizeKeepingAspectRatio(Bitmap bitmap, int i) {
        int i2;
        float width = bitmap.getWidth() / bitmap.getHeight();
        if (width > 1.0f) {
            i2 = (int) (i / width);
        } else {
            int i3 = (int) (i * width);
            i2 = i;
            i = i3;
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, i2, true);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateScaledBitmap, "createScaledBitmap(...)");
        return bitmapCreateScaledBitmap;
    }

    private static final class Channel {
        private float[] ac;
        private float dc;
        private int nx;
        private int ny;
        private float scale;

        public Channel(int i, int i2) {
            this.nx = i;
            this.ny = i2;
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2) {
                int i5 = i3 > 0 ? 0 : 1;
                while (true) {
                    int i6 = this.ny;
                    if (i5 * i6 < this.nx * (i6 - i3)) {
                        i4++;
                        i5++;
                    }
                }
                i3++;
            }
            this.ac = new float[i4];
        }

        public final float getDc() {
            return this.dc;
        }

        public final float[] getAc() {
            return this.ac;
        }

        public final float getScale() {
            return this.scale;
        }

        public final Channel encode(int i, int i2, float[] channel) {
            double d;
            Intrinsics.checkNotNullParameter(channel, "channel");
            float[] fArr = new float[i];
            int i3 = this.ny;
            int i4 = 0;
            for (int i5 = 0; i5 < i3; i5++) {
                int i6 = 0;
                while (true) {
                    int i7 = this.ny;
                    if (i6 * i7 < this.nx * (i7 - i5)) {
                        int i8 = 0;
                        while (true) {
                            d = 3.141592653589793d;
                            if (i8 >= i) {
                                break;
                            }
                            fArr[i8] = (float) Math.cos((3.141592653589793d / ((double) i)) * ((double) i6) * ((double) (i8 + 0.5f)));
                            i8++;
                        }
                        int i9 = 0;
                        float f = 0.0f;
                        while (i9 < i2) {
                            double d2 = d;
                            float fCos = (float) Math.cos((d2 / ((double) i2)) * ((double) i5) * ((double) (i9 + 0.5f)));
                            for (int i10 = 0; i10 < i; i10++) {
                                f += channel[(i9 * i) + i10] * fArr[i10] * fCos;
                            }
                            i9++;
                            i2 = i2;
                            d = d2;
                        }
                        float f2 = f / (i * i2);
                        if (i6 > 0 || i5 > 0) {
                            this.ac[i4] = f2;
                            this.scale = Math.max(this.scale, Math.abs(f2));
                            i4++;
                        } else {
                            this.dc = f2;
                        }
                        i6++;
                        i2 = i2;
                    }
                }
            }
            if (this.scale > 0.0f) {
                int length = this.ac.length;
                for (int i11 = 0; i11 < length; i11++) {
                    float[] fArr2 = this.ac;
                    fArr2[i11] = ((0.5f / this.scale) * fArr2[i11]) + 0.5f;
                }
            }
            return this;
        }

        public final int writeTo(byte[] hash, int i, int i2) {
            Intrinsics.checkNotNullParameter(hash, "hash");
            for (float f : this.ac) {
                int i3 = (i2 >> 1) + i;
                hash[i3] = (byte) ((Math.round(f * 15.0f) << ((i2 & 1) << 2)) | hash[i3]);
                i2++;
            }
            return i2;
        }
    }
}
