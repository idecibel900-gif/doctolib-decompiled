package expo.modules.image.thumbhash;

import android.graphics.Bitmap;
import android.graphics.Color;
import java.util.ArrayList;
import kotlin.UByte;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ThumbhashDecoder {
    public static final ThumbhashDecoder INSTANCE = new ThumbhashDecoder();

    private ThumbhashDecoder() {
    }

    public final Image thumbHashToRGBA(byte[] hash) {
        int i;
        Channel channel;
        int i2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(hash, "hash");
        int i5 = (hash[0] & 255) | ((hash[1] & 255) << 8) | ((hash[2] & 255) << 16);
        int i6 = (hash[3] & 255) | ((hash[4] & 255) << 8);
        float f = (i5 & 63) / 63.0f;
        float f2 = 1.0f;
        float f3 = (((i5 >> 6) & 63) / 31.5f) - 1.0f;
        float f4 = (((i5 >> 12) & 63) / 31.5f) - 1.0f;
        float f5 = ((i5 >> 18) & 31) / 31.0f;
        boolean z = (i5 >> 23) != 0;
        float f6 = ((i6 >> 3) & 63) / 63.0f;
        float f7 = ((i6 >> 9) & 63) / 63.0f;
        boolean z2 = (i6 >> 15) != 0;
        int i7 = 7;
        if (z2) {
            i = z ? 5 : 7;
        } else {
            i = i6 & 7;
        }
        int iMax = Math.max(3, i);
        if (z2) {
            i7 = 7 & i6;
        } else if (z) {
            i7 = 5;
        }
        int iMax2 = Math.max(3, i7);
        float f8 = z ? (hash[5] & 15) / 15.0f : 1.0f;
        float f9 = ((hash[5] >> 4) & 15) / 15.0f;
        int i8 = z ? 6 : 5;
        Channel channel2 = new Channel(iMax, iMax2);
        Channel channel3 = new Channel(3, 3);
        boolean z3 = z;
        Channel channel4 = new Channel(3, 3);
        int iDecode = channel4.decode(hash, i8, channel3.decode(hash, i8, channel2.decode(hash, i8, 0, f5), f6 * 1.25f), f7 * 1.25f);
        float[] ac = null;
        if (z3) {
            channel = new Channel(5, 5);
            channel.decode(hash, i8, iDecode, f9);
        } else {
            channel = null;
        }
        float[] ac2 = channel2.getAc();
        float[] ac3 = channel3.getAc();
        float[] ac4 = channel4.getAc();
        if (z3) {
            Intrinsics.checkNotNull(channel);
            ac = channel.getAc();
        }
        float fThumbHashToApproximateAspectRatio = thumbHashToApproximateAspectRatio(hash);
        int iRound = Math.round(fThumbHashToApproximateAspectRatio > f2 ? 32.0f : fThumbHashToApproximateAspectRatio * 32.0f);
        int iRound2 = Math.round(fThumbHashToApproximateAspectRatio > f2 ? 32.0f / fThumbHashToApproximateAspectRatio : 32.0f);
        byte[] bArr = new byte[iRound * iRound2 * 4];
        int iMax3 = Math.max(iMax, z3 ? 5 : 3);
        int iMax4 = Math.max(iMax2, z3 ? 5 : 3);
        float[] fArr = new float[iMax3];
        float[] fArr2 = new float[iMax4];
        int i9 = 0;
        int i10 = 0;
        while (i9 < iRound2) {
            float[] fArr3 = ac4;
            int i11 = 0;
            while (i11 < iRound) {
                float[] fArr4 = ac2;
                int i12 = 0;
                while (i12 < iMax3) {
                    fArr[i12] = (float) Math.cos((3.141592653589793d / ((double) iRound)) * ((double) (i11 + 0.5f)) * ((double) i12));
                    i12++;
                    f = f;
                    iMax = iMax;
                }
                int i13 = iMax;
                float f10 = f;
                int i14 = 0;
                while (i14 < iMax4) {
                    fArr2[i14] = (float) Math.cos((3.141592653589793d / ((double) iRound2)) * ((double) (i9 + 0.5f)) * ((double) i14));
                    i14++;
                    i11 = i11;
                    i9 = i9;
                }
                int i15 = i9;
                int i16 = i11;
                float f11 = f10;
                int i17 = 0;
                int i18 = 0;
                while (i17 < iMax2) {
                    float f12 = fArr2[i17] * 2.0f;
                    int i19 = i17 > 0 ? 0 : 1;
                    int i20 = i17;
                    while (true) {
                        i4 = i18;
                        if (i19 * iMax2 < i13 * (iMax2 - i20)) {
                            f11 += fArr4[i4] * fArr[i19] * f12;
                            i19++;
                            i18 = i4 + 1;
                        }
                    }
                    i17 = i20 + 1;
                    i18 = i4;
                }
                float f13 = f3;
                float f14 = f4;
                int i21 = 0;
                int i22 = 0;
                while (i21 < 3) {
                    float f15 = fArr2[i21] * 2.0f;
                    int i23 = i21 > 0 ? 0 : 1;
                    while (true) {
                        i3 = i21;
                        if (i23 < 3 - i3) {
                            float f16 = fArr[i23] * f15;
                            f13 += ac3[i22] * f16;
                            f14 += fArr3[i22] * f16;
                            i23++;
                            i22++;
                            i21 = i3;
                        }
                    }
                    i21 = i3 + 1;
                }
                float f17 = f8;
                if (z3) {
                    int i24 = 0;
                    int i25 = 0;
                    while (i24 < 5) {
                        float f18 = fArr2[i24] * 2.0f;
                        int i26 = i24 > 0 ? 0 : 1;
                        while (true) {
                            i2 = i24;
                            if (i26 < 5 - i2) {
                                Intrinsics.checkNotNull(ac);
                                f17 += ac[i25] * fArr[i26] * f18;
                                i26++;
                                i25++;
                                i24 = i2;
                            }
                        }
                        i24 = i2 + 1;
                    }
                }
                float f19 = f11 - (f13 * 0.6666667f);
                float f20 = (((f11 * 3.0f) - f19) + f14) / 2.0f;
                bArr[i10] = (byte) Math.max(0, Math.round(Math.min(f2, f20) * 255.0f));
                bArr[i10 + 1] = (byte) Math.max(0, Math.round(Math.min(1.0f, f20 - f14) * 255.0f));
                bArr[i10 + 2] = (byte) Math.max(0, Math.round(Math.min(1.0f, f19) * 255.0f));
                bArr[i10 + 3] = (byte) Math.max(0, Math.round(Math.min(1.0f, f17) * 255.0f));
                i11 = i16 + 1;
                i10 += 4;
                f2 = 1.0f;
                ac2 = fArr4;
                f = f10;
                iMax = i13;
                i9 = i15;
            }
            i9++;
            ac4 = fArr3;
            ac2 = ac2;
            f = f;
        }
        return new Image(iRound, iRound2, bArr);
    }

    public final Bitmap thumbHashToBitmap(byte[] hash) {
        Intrinsics.checkNotNullParameter(hash, "hash");
        Image imageThumbHashToRGBA = thumbHashToRGBA(hash);
        int[] iArr = new int[imageThumbHashToRGBA.getWidth() * imageThumbHashToRGBA.getHeight()];
        byte[] rgba = imageThumbHashToRGBA.getRgba();
        ArrayList arrayList = new ArrayList(rgba.length);
        int i = 0;
        for (byte b : rgba) {
            arrayList.add(Integer.valueOf(UByte.m5253constructorimpl(b) & 255));
        }
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, arrayList.size() - 1, 4);
        if (progressionLastElement >= 0) {
            while (true) {
                iArr[i / 4] = Color.argb(((Number) arrayList.get(i + 3)).intValue(), ((Number) arrayList.get(i)).intValue(), ((Number) arrayList.get(i + 1)).intValue(), ((Number) arrayList.get(i + 2)).intValue());
                if (i == progressionLastElement) {
                    break;
                }
                i += 4;
            }
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iArr, imageThumbHashToRGBA.getWidth(), imageThumbHashToRGBA.getHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        return bitmapCreateBitmap;
    }

    public final float thumbHashToApproximateAspectRatio(byte[] hash) {
        int i;
        Intrinsics.checkNotNullParameter(hash, "hash");
        byte b = hash[3];
        boolean z = (hash[2] & 128) != 0;
        boolean z2 = (hash[4] & 128) != 0;
        int i2 = 5;
        if (z2) {
            i = z ? 5 : 7;
        } else {
            i = b & 7;
        }
        if (z2) {
            i2 = b & 7;
        } else if (!z) {
            i2 = 7;
        }
        return i / i2;
    }

    public static final class Image {
        private int height;
        private byte[] rgba;
        private int width;

        public Image(int i, int i2, byte[] rgba) {
            Intrinsics.checkNotNullParameter(rgba, "rgba");
            this.width = i;
            this.height = i2;
            this.rgba = rgba;
        }

        public final int getHeight() {
            return this.height;
        }

        public final byte[] getRgba() {
            return this.rgba;
        }

        public final int getWidth() {
            return this.width;
        }
    }

    private static final class Channel {
        private float[] ac;

        public Channel(int i, int i2) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2) {
                for (int i5 = i3 > 0 ? 0 : 1; i5 * i2 < (i2 - i3) * i; i5++) {
                    i4++;
                }
                i3++;
            }
            this.ac = new float[i4];
        }

        public final float[] getAc() {
            return this.ac;
        }

        public final int decode(byte[] hash, int i, int i2, float f) {
            Intrinsics.checkNotNullParameter(hash, "hash");
            int length = this.ac.length;
            for (int i3 = 0; i3 < length; i3++) {
                this.ac[i3] = ((((hash[(i2 >> 1) + i] >> ((i2 & 1) << 2)) & 15) / 7.5f) - 1.0f) * f;
                i2++;
            }
            return i2;
        }
    }
}
