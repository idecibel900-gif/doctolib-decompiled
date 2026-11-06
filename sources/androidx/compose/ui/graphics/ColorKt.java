package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.colorspace.ColorModel;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.DoubleFunction;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.util.MathHelpersKt;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes.dex */
public abstract class ColorKt {
    public static /* synthetic */ long Color$default(float f, float f2, float f3, float f4, ColorSpace colorSpace, int i, Object obj) {
        if ((i & 8) != 0) {
            f4 = 1.0f;
        }
        if ((i & 16) != 0) {
            colorSpace = ColorSpaces.INSTANCE.getSrgb();
        }
        return Color(f, f2, f3, f4, colorSpace);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0144  */
    /* JADX WARN: Code duplicated, block: B:101:0x0147  */
    /* JADX WARN: Code duplicated, block: B:103:0x014d  */
    /* JADX WARN: Code duplicated, block: B:105:0x0157  */
    /* JADX WARN: Code duplicated, block: B:110:0x016f  */
    /* JADX WARN: Code duplicated, block: B:114:0x0176  */
    /* JADX WARN: Code duplicated, block: B:117:0x0183 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:118:0x0185  */
    /* JADX WARN: Code duplicated, block: B:120:0x018a  */
    /* JADX WARN: Code duplicated, block: B:122:0x018e  */
    /* JADX WARN: Code duplicated, block: B:123:0x0192 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:124:0x0194 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:125:0x0196  */
    /* JADX WARN: Code duplicated, block: B:127:0x019f  */
    /* JADX WARN: Code duplicated, block: B:129:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:130:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:132:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:134:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:139:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:143:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:80:0x010c  */
    /* JADX WARN: Code duplicated, block: B:84:0x0113  */
    /* JADX WARN: Code duplicated, block: B:87:0x0121 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:88:0x0123  */
    /* JADX WARN: Code duplicated, block: B:89:0x0126  */
    /* JADX WARN: Code duplicated, block: B:91:0x0129  */
    /* JADX WARN: Code duplicated, block: B:93:0x012d  */
    /* JADX WARN: Code duplicated, block: B:94:0x0131 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:95:0x0133 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:96:0x0135  */
    /* JADX WARN: Code duplicated, block: B:98:0x013e  */
    public static final long Color(float f, float f2, float f3, float f4, ColorSpace colorSpace) {
        int i;
        int i2;
        int i3;
        float minValue;
        float maxValue;
        int iFloatToRawIntBits;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        float minValue2;
        float maxValue2;
        int iFloatToRawIntBits2;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        float f5;
        if (colorSpace.isSrgb()) {
            float f6 = f4 < 0.0f ? 0.0f : f4;
            if (f6 > 1.0f) {
                f6 = 1.0f;
            }
            int i20 = ((int) ((f6 * 255.0f) + 0.5f)) << 24;
            float f7 = f < 0.0f ? 0.0f : f;
            if (f7 > 1.0f) {
                f7 = 1.0f;
            }
            int i21 = i20 | (((int) ((f7 * 255.0f) + 0.5f)) << 16);
            float f8 = f2 < 0.0f ? 0.0f : f2;
            if (f8 > 1.0f) {
                f8 = 1.0f;
            }
            int i22 = i21 | (((int) ((f8 * 255.0f) + 0.5f)) << 8);
            f5 = f3 >= 0.0f ? f3 : 0.0f;
            return Color.m1362constructorimpl(ULong.m5297constructorimpl(ULong.m5297constructorimpl(i22 | ((int) (((f5 <= 1.0f ? f5 : 1.0f) * 255.0f) + 0.5f))) << 32));
        }
        int i23 = 0;
        if (!(colorSpace.getComponentCount() == 3)) {
            InlineClassHelperKt.throwIllegalArgumentException("Color only works with ColorSpaces with 3 components");
        }
        int id$ui_graphics_release = colorSpace.getId$ui_graphics_release();
        if (!(id$ui_graphics_release != -1)) {
            InlineClassHelperKt.throwIllegalArgumentException("Unknown color space, please use a color space in ColorSpaces");
        }
        float minValue3 = colorSpace.getMinValue(0);
        float maxValue3 = colorSpace.getMaxValue(0);
        if (f >= minValue3) {
            minValue3 = f;
        }
        if (minValue3 <= maxValue3) {
            maxValue3 = minValue3;
        }
        int iFloatToRawIntBits3 = Float.floatToRawIntBits(maxValue3);
        int i24 = iFloatToRawIntBits3 >>> 31;
        int i25 = (iFloatToRawIntBits3 >>> 23) & 255;
        int i26 = iFloatToRawIntBits3 & 8388607;
        if (i25 == 255) {
            i2 = i26 != 0 ? 512 : 0;
            i = 31;
        } else {
            i = i25 - 112;
            if (i >= 31) {
                i2 = 0;
                i = 49;
            } else {
                if (i > 0) {
                    int i27 = i26 >> 13;
                    if ((iFloatToRawIntBits3 & 4096) != 0) {
                        i3 = (((i << 10) | i27) + 1) | (i24 << 15);
                    } else {
                        i2 = i27;
                    }
                    short s = (short) i3;
                    minValue = colorSpace.getMinValue(1);
                    maxValue = colorSpace.getMaxValue(1);
                    if (f2 >= minValue) {
                        minValue = f2;
                    }
                    if (minValue <= maxValue) {
                        maxValue = minValue;
                    }
                    iFloatToRawIntBits = Float.floatToRawIntBits(maxValue);
                    i4 = iFloatToRawIntBits >>> 31;
                    i5 = (iFloatToRawIntBits >>> 23) & 255;
                    i6 = iFloatToRawIntBits & 8388607;
                    if (i5 == 255) {
                        if (i6 != 0) {
                            i9 = 512;
                        } else {
                            i9 = 0;
                        }
                        i7 = 31;
                    } else {
                        i7 = i5 - 112;
                        if (i7 >= 31) {
                            i9 = 0;
                            i7 = 49;
                        } else {
                            if (i7 <= 0) {
                                i8 = i6 >> 13;
                                if ((iFloatToRawIntBits & 4096) != 0) {
                                    i10 = (((i7 << 10) | i8) + 1) | (i4 << 15);
                                } else {
                                    i9 = i8;
                                }
                                short s2 = (short) i10;
                                minValue2 = colorSpace.getMinValue(2);
                                maxValue2 = colorSpace.getMaxValue(2);
                                if (f3 >= minValue2) {
                                    minValue2 = f3;
                                }
                                if (minValue2 <= maxValue2) {
                                    maxValue2 = minValue2;
                                }
                                iFloatToRawIntBits2 = Float.floatToRawIntBits(maxValue2);
                                i12 = iFloatToRawIntBits2 >>> 31;
                                i13 = (iFloatToRawIntBits2 >>> 23) & 255;
                                i14 = 8388607 & iFloatToRawIntBits2;
                                if (i13 == 255) {
                                    i17 = i14 != 0 ? 512 : 0;
                                    i23 = 31;
                                } else {
                                    i15 = i13 - 112;
                                    if (i15 >= 31) {
                                        i17 = 0;
                                        i23 = 49;
                                    } else {
                                        if (i15 <= 0) {
                                            i16 = i14 >> 13;
                                            if ((iFloatToRawIntBits2 & 4096) != 0) {
                                                i18 = (((i15 << 10) | i16) + 1) | (i12 << 15);
                                            } else {
                                                i17 = i16;
                                                i23 = i15;
                                            }
                                            short s3 = (short) i18;
                                            f5 = f4 >= 0.0f ? f4 : 0.0f;
                                            return Color.m1362constructorimpl(ULong.m5297constructorimpl((((long) id$ui_graphics_release) & 63) | ((((long) s) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) s2) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((WebSocketProtocol.PAYLOAD_SHORT_MAX & ((long) s3)) << 16) | ((((long) ((int) (((f5 <= 1.0f ? f5 : 1.0f) * 1023.0f) + 0.5f))) & 1023) << 6)));
                                        }
                                        if (i15 >= -10) {
                                            i19 = (i14 | 8388608) >> (1 - i15);
                                            if ((i19 & 4096) != 0) {
                                                i19 += 8192;
                                            }
                                            i17 = i19 >> 13;
                                        } else {
                                            i17 = 0;
                                        }
                                    }
                                }
                                i18 = i17 | (i12 << 15) | (i23 << 10);
                                short s4 = (short) i18;
                                if (f4 >= 0.0f) {
                                }
                                return Color.m1362constructorimpl(ULong.m5297constructorimpl((((long) id$ui_graphics_release) & 63) | ((((long) s) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) s2) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((WebSocketProtocol.PAYLOAD_SHORT_MAX & ((long) s4)) << 16) | ((((long) ((int) (((f5 <= 1.0f ? f5 : 1.0f) * 1023.0f) + 0.5f))) & 1023) << 6)));
                            }
                            if (i7 >= -10) {
                                i11 = (i6 | 8388608) >> (1 - i7);
                                if ((i11 & 4096) != 0) {
                                    i11 += 8192;
                                }
                                i9 = i11 >> 13;
                                i7 = 0;
                            } else {
                                i9 = 0;
                                i7 = 0;
                            }
                        }
                    }
                    i10 = i9 | (i4 << 15) | (i7 << 10);
                    short s5 = (short) i10;
                    minValue2 = colorSpace.getMinValue(2);
                    maxValue2 = colorSpace.getMaxValue(2);
                    if (f3 >= minValue2) {
                        minValue2 = f3;
                    }
                    if (minValue2 <= maxValue2) {
                        maxValue2 = minValue2;
                    }
                    iFloatToRawIntBits2 = Float.floatToRawIntBits(maxValue2);
                    i12 = iFloatToRawIntBits2 >>> 31;
                    i13 = (iFloatToRawIntBits2 >>> 23) & 255;
                    i14 = 8388607 & iFloatToRawIntBits2;
                    if (i13 == 255) {
                        i17 = i14 != 0 ? 512 : 0;
                        i23 = 31;
                    } else {
                        i15 = i13 - 112;
                        if (i15 >= 31) {
                            i17 = 0;
                            i23 = 49;
                        } else {
                            if (i15 <= 0) {
                                i16 = i14 >> 13;
                                if ((iFloatToRawIntBits2 & 4096) != 0) {
                                    i18 = (((i15 << 10) | i16) + 1) | (i12 << 15);
                                } else {
                                    i17 = i16;
                                    i23 = i15;
                                }
                                short s6 = (short) i18;
                                if (f4 >= 0.0f) {
                                }
                                return Color.m1362constructorimpl(ULong.m5297constructorimpl((((long) id$ui_graphics_release) & 63) | ((((long) s) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) s5) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((WebSocketProtocol.PAYLOAD_SHORT_MAX & ((long) s6)) << 16) | ((((long) ((int) (((f5 <= 1.0f ? f5 : 1.0f) * 1023.0f) + 0.5f))) & 1023) << 6)));
                            }
                            if (i15 >= -10) {
                                i19 = (i14 | 8388608) >> (1 - i15);
                                if ((i19 & 4096) != 0) {
                                    i19 += 8192;
                                }
                                i17 = i19 >> 13;
                            } else {
                                i17 = 0;
                            }
                        }
                    }
                    i18 = i17 | (i12 << 15) | (i23 << 10);
                    short s7 = (short) i18;
                    if (f4 >= 0.0f) {
                    }
                    return Color.m1362constructorimpl(ULong.m5297constructorimpl((((long) id$ui_graphics_release) & 63) | ((((long) s) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) s5) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((WebSocketProtocol.PAYLOAD_SHORT_MAX & ((long) s7)) << 16) | ((((long) ((int) (((f5 <= 1.0f ? f5 : 1.0f) * 1023.0f) + 0.5f))) & 1023) << 6)));
                }
                if (i >= -10) {
                    int i28 = (i26 | 8388608) >> (1 - i);
                    if ((i28 & 4096) != 0) {
                        i28 += 8192;
                    }
                    i2 = i28 >> 13;
                    i = 0;
                } else {
                    i2 = 0;
                    i = 0;
                }
            }
        }
        i3 = i2 | (i24 << 15) | (i << 10);
        short s8 = (short) i3;
        minValue = colorSpace.getMinValue(1);
        maxValue = colorSpace.getMaxValue(1);
        if (f2 >= minValue) {
            minValue = f2;
        }
        if (minValue <= maxValue) {
            maxValue = minValue;
        }
        iFloatToRawIntBits = Float.floatToRawIntBits(maxValue);
        i4 = iFloatToRawIntBits >>> 31;
        i5 = (iFloatToRawIntBits >>> 23) & 255;
        i6 = iFloatToRawIntBits & 8388607;
        if (i5 == 255) {
            if (i6 != 0) {
                i9 = 512;
            } else {
                i9 = 0;
            }
            i7 = 31;
        } else {
            i7 = i5 - 112;
            if (i7 >= 31) {
                i9 = 0;
                i7 = 49;
            } else {
                if (i7 <= 0) {
                    i8 = i6 >> 13;
                    if ((iFloatToRawIntBits & 4096) != 0) {
                        i10 = (((i7 << 10) | i8) + 1) | (i4 << 15);
                    } else {
                        i9 = i8;
                    }
                    short s9 = (short) i10;
                    minValue2 = colorSpace.getMinValue(2);
                    maxValue2 = colorSpace.getMaxValue(2);
                    if (f3 >= minValue2) {
                        minValue2 = f3;
                    }
                    if (minValue2 <= maxValue2) {
                        maxValue2 = minValue2;
                    }
                    iFloatToRawIntBits2 = Float.floatToRawIntBits(maxValue2);
                    i12 = iFloatToRawIntBits2 >>> 31;
                    i13 = (iFloatToRawIntBits2 >>> 23) & 255;
                    i14 = 8388607 & iFloatToRawIntBits2;
                    if (i13 == 255) {
                        i17 = i14 != 0 ? 512 : 0;
                        i23 = 31;
                    } else {
                        i15 = i13 - 112;
                        if (i15 >= 31) {
                            i17 = 0;
                            i23 = 49;
                        } else {
                            if (i15 <= 0) {
                                i16 = i14 >> 13;
                                if ((iFloatToRawIntBits2 & 4096) != 0) {
                                    i18 = (((i15 << 10) | i16) + 1) | (i12 << 15);
                                } else {
                                    i17 = i16;
                                    i23 = i15;
                                }
                                short s10 = (short) i18;
                                if (f4 >= 0.0f) {
                                }
                                return Color.m1362constructorimpl(ULong.m5297constructorimpl((((long) id$ui_graphics_release) & 63) | ((((long) s8) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) s9) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((WebSocketProtocol.PAYLOAD_SHORT_MAX & ((long) s10)) << 16) | ((((long) ((int) (((f5 <= 1.0f ? f5 : 1.0f) * 1023.0f) + 0.5f))) & 1023) << 6)));
                            }
                            if (i15 >= -10) {
                                i19 = (i14 | 8388608) >> (1 - i15);
                                if ((i19 & 4096) != 0) {
                                    i19 += 8192;
                                }
                                i17 = i19 >> 13;
                            } else {
                                i17 = 0;
                            }
                        }
                    }
                    i18 = i17 | (i12 << 15) | (i23 << 10);
                    short s11 = (short) i18;
                    if (f4 >= 0.0f) {
                    }
                    return Color.m1362constructorimpl(ULong.m5297constructorimpl((((long) id$ui_graphics_release) & 63) | ((((long) s8) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) s9) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((WebSocketProtocol.PAYLOAD_SHORT_MAX & ((long) s11)) << 16) | ((((long) ((int) (((f5 <= 1.0f ? f5 : 1.0f) * 1023.0f) + 0.5f))) & 1023) << 6)));
                }
                if (i7 >= -10) {
                    i11 = (i6 | 8388608) >> (1 - i7);
                    if ((i11 & 4096) != 0) {
                        i11 += 8192;
                    }
                    i9 = i11 >> 13;
                    i7 = 0;
                } else {
                    i9 = 0;
                    i7 = 0;
                }
            }
        }
        i10 = i9 | (i4 << 15) | (i7 << 10);
        short s12 = (short) i10;
        minValue2 = colorSpace.getMinValue(2);
        maxValue2 = colorSpace.getMaxValue(2);
        if (f3 >= minValue2) {
            minValue2 = f3;
        }
        if (minValue2 <= maxValue2) {
            maxValue2 = minValue2;
        }
        iFloatToRawIntBits2 = Float.floatToRawIntBits(maxValue2);
        i12 = iFloatToRawIntBits2 >>> 31;
        i13 = (iFloatToRawIntBits2 >>> 23) & 255;
        i14 = 8388607 & iFloatToRawIntBits2;
        if (i13 == 255) {
            i17 = i14 != 0 ? 512 : 0;
            i23 = 31;
        } else {
            i15 = i13 - 112;
            if (i15 >= 31) {
                i17 = 0;
                i23 = 49;
            } else {
                if (i15 <= 0) {
                    i16 = i14 >> 13;
                    if ((iFloatToRawIntBits2 & 4096) != 0) {
                        i18 = (((i15 << 10) | i16) + 1) | (i12 << 15);
                    } else {
                        i17 = i16;
                        i23 = i15;
                    }
                    short s13 = (short) i18;
                    if (f4 >= 0.0f) {
                    }
                    return Color.m1362constructorimpl(ULong.m5297constructorimpl((((long) id$ui_graphics_release) & 63) | ((((long) s8) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) s12) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((WebSocketProtocol.PAYLOAD_SHORT_MAX & ((long) s13)) << 16) | ((((long) ((int) (((f5 <= 1.0f ? f5 : 1.0f) * 1023.0f) + 0.5f))) & 1023) << 6)));
                }
                if (i15 >= -10) {
                    i19 = (i14 | 8388608) >> (1 - i15);
                    if ((i19 & 4096) != 0) {
                        i19 += 8192;
                    }
                    i17 = i19 >> 13;
                } else {
                    i17 = 0;
                }
            }
        }
        i18 = i17 | (i12 << 15) | (i23 << 10);
        short s14 = (short) i18;
        if (f4 >= 0.0f) {
        }
        return Color.m1362constructorimpl(ULong.m5297constructorimpl((((long) id$ui_graphics_release) & 63) | ((((long) s8) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) s12) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((WebSocketProtocol.PAYLOAD_SHORT_MAX & ((long) s14)) << 16) | ((((long) ((int) (((f5 <= 1.0f ? f5 : 1.0f) * 1023.0f) + 0.5f))) & 1023) << 6)));
    }

    /* JADX WARN: Code duplicated, block: B:30:0x009d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:31:0x009f  */
    /* JADX WARN: Code duplicated, block: B:32:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:34:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:36:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:37:0x00ab A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:38:0x00ad A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:39:0x00af  */
    /* JADX WARN: Code duplicated, block: B:41:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:43:0x00be  */
    /* JADX WARN: Code duplicated, block: B:44:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:46:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:48:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:52:0x00e9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:54:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:56:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:59:0x00f5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:60:0x00f7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:61:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:63:0x0103  */
    /* JADX WARN: Code duplicated, block: B:65:0x010a  */
    /* JADX WARN: Code duplicated, block: B:66:0x010c  */
    /* JADX WARN: Code duplicated, block: B:68:0x0112  */
    /* JADX WARN: Code duplicated, block: B:70:0x011c  */
    public static final long UncheckedColor(float f, float f2, float f3, float f4, ColorSpace colorSpace) {
        int i;
        int i2;
        int i3;
        int iFloatToRawIntBits;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int iFloatToRawIntBits2;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        if (colorSpace.isSrgb()) {
            return Color.m1362constructorimpl(ULong.m5297constructorimpl(ULong.m5297constructorimpl((((((int) ((f4 * 255.0f) + 0.5f)) << 24) | (((int) ((f * 255.0f) + 0.5f)) << 16)) | (((int) ((f2 * 255.0f) + 0.5f)) << 8)) | ((int) ((255.0f * f3) + 0.5f))) << 32));
        }
        int iFloatToRawIntBits3 = Float.floatToRawIntBits(f);
        int i18 = iFloatToRawIntBits3 >>> 31;
        int i19 = (iFloatToRawIntBits3 >>> 23) & 255;
        int i20 = iFloatToRawIntBits3 & 8388607;
        int i21 = 49;
        int i22 = IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING;
        int i23 = 0;
        if (i19 == 255) {
            i2 = i20 != 0 ? 512 : 0;
            i = 31;
        } else {
            i = i19 - 112;
            if (i >= 31) {
                i = 49;
                i2 = 0;
            } else {
                if (i > 0) {
                    int i24 = i20 >> 13;
                    if ((iFloatToRawIntBits3 & 4096) != 0) {
                        i3 = (((i << 10) | i24) + 1) | (i18 << 15);
                    } else {
                        i2 = i24;
                    }
                    short s = (short) i3;
                    iFloatToRawIntBits = Float.floatToRawIntBits(f2);
                    i4 = iFloatToRawIntBits >>> 31;
                    i5 = (iFloatToRawIntBits >>> 23) & 255;
                    i6 = iFloatToRawIntBits & 8388607;
                    if (i5 == 255) {
                        if (i6 != 0) {
                            i9 = 512;
                        } else {
                            i9 = 0;
                        }
                        i7 = 31;
                    } else {
                        i7 = i5 - 112;
                        if (i7 >= 31) {
                            i7 = 49;
                            i9 = 0;
                        } else {
                            if (i7 <= 0) {
                                i8 = i6 >> 13;
                                if ((iFloatToRawIntBits & 4096) != 0) {
                                    i10 = (((i7 << 10) | i8) + 1) | (i4 << 15);
                                } else {
                                    i9 = i8;
                                }
                                short s2 = (short) i10;
                                iFloatToRawIntBits2 = Float.floatToRawIntBits(f3);
                                i12 = iFloatToRawIntBits2 >>> 31;
                                i13 = (iFloatToRawIntBits2 >>> 23) & 255;
                                i14 = 8388607 & iFloatToRawIntBits2;
                                if (i13 == 255) {
                                    i15 = i13 - 112;
                                    if (i15 < 31) {
                                        if (i15 <= 0) {
                                            i23 = i14 >> 13;
                                            if ((iFloatToRawIntBits2 & 4096) != 0) {
                                                i16 = (((i15 << 10) | i23) + 1) | (i12 << 15);
                                            } else {
                                                i21 = i15;
                                            }
                                        } else if (i15 >= -10) {
                                            i17 = (i14 | 8388608) >> (1 - i15);
                                            if ((i17 & 4096) != 0) {
                                                i17 += 8192;
                                            }
                                            i21 = 0;
                                            i23 = i17 >> 13;
                                        } else {
                                            i21 = 0;
                                        }
                                    }
                                    return Color.m1362constructorimpl(ULong.m5297constructorimpl(((((long) ((short) i16)) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | ((((long) s) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) s2) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((((long) ((int) ((Math.max(0.0f, Math.min(f4, 1.0f)) * 1023.0f) + 0.5f))) & 1023) << 6) | (((long) colorSpace.getId$ui_graphics_release()) & 63)));
                                }
                                if (i14 == 0) {
                                    i22 = 0;
                                }
                                i23 = i22;
                                i21 = 31;
                                i16 = (i12 << 15) | (i21 << 10) | i23;
                                return Color.m1362constructorimpl(ULong.m5297constructorimpl(((((long) ((short) i16)) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | ((((long) s) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) s2) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((((long) ((int) ((Math.max(0.0f, Math.min(f4, 1.0f)) * 1023.0f) + 0.5f))) & 1023) << 6) | (((long) colorSpace.getId$ui_graphics_release()) & 63)));
                            }
                            if (i7 >= -10) {
                                i11 = (i6 | 8388608) >> (1 - i7);
                                if ((i11 & 4096) != 0) {
                                    i11 += 8192;
                                }
                                i9 = i11 >> 13;
                                i7 = 0;
                            } else {
                                i9 = 0;
                                i7 = 0;
                            }
                        }
                    }
                    i10 = i9 | (i4 << 15) | (i7 << 10);
                    short s3 = (short) i10;
                    iFloatToRawIntBits2 = Float.floatToRawIntBits(f3);
                    i12 = iFloatToRawIntBits2 >>> 31;
                    i13 = (iFloatToRawIntBits2 >>> 23) & 255;
                    i14 = 8388607 & iFloatToRawIntBits2;
                    if (i13 == 255) {
                        i15 = i13 - 112;
                        if (i15 < 31) {
                            if (i15 <= 0) {
                                i23 = i14 >> 13;
                                if ((iFloatToRawIntBits2 & 4096) != 0) {
                                    i16 = (((i15 << 10) | i23) + 1) | (i12 << 15);
                                } else {
                                    i21 = i15;
                                }
                            } else if (i15 >= -10) {
                                i17 = (i14 | 8388608) >> (1 - i15);
                                if ((i17 & 4096) != 0) {
                                    i17 += 8192;
                                }
                                i21 = 0;
                                i23 = i17 >> 13;
                            } else {
                                i21 = 0;
                            }
                        }
                        return Color.m1362constructorimpl(ULong.m5297constructorimpl(((((long) ((short) i16)) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | ((((long) s) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) s3) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((((long) ((int) ((Math.max(0.0f, Math.min(f4, 1.0f)) * 1023.0f) + 0.5f))) & 1023) << 6) | (((long) colorSpace.getId$ui_graphics_release()) & 63)));
                    }
                    if (i14 == 0) {
                        i22 = 0;
                    }
                    i23 = i22;
                    i21 = 31;
                    i16 = (i12 << 15) | (i21 << 10) | i23;
                    return Color.m1362constructorimpl(ULong.m5297constructorimpl(((((long) ((short) i16)) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | ((((long) s) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) s3) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((((long) ((int) ((Math.max(0.0f, Math.min(f4, 1.0f)) * 1023.0f) + 0.5f))) & 1023) << 6) | (((long) colorSpace.getId$ui_graphics_release()) & 63)));
                }
                if (i >= -10) {
                    int i25 = (i20 | 8388608) >> (1 - i);
                    if ((i25 & 4096) != 0) {
                        i25 += 8192;
                    }
                    i2 = i25 >> 13;
                    i = 0;
                } else {
                    i2 = 0;
                    i = 0;
                }
            }
        }
        i3 = i2 | (i18 << 15) | (i << 10);
        short s4 = (short) i3;
        iFloatToRawIntBits = Float.floatToRawIntBits(f2);
        i4 = iFloatToRawIntBits >>> 31;
        i5 = (iFloatToRawIntBits >>> 23) & 255;
        i6 = iFloatToRawIntBits & 8388607;
        if (i5 == 255) {
            if (i6 != 0) {
                i9 = 512;
            } else {
                i9 = 0;
            }
            i7 = 31;
        } else {
            i7 = i5 - 112;
            if (i7 >= 31) {
                i7 = 49;
                i9 = 0;
            } else {
                if (i7 <= 0) {
                    i8 = i6 >> 13;
                    if ((iFloatToRawIntBits & 4096) != 0) {
                        i10 = (((i7 << 10) | i8) + 1) | (i4 << 15);
                    } else {
                        i9 = i8;
                    }
                    short s5 = (short) i10;
                    iFloatToRawIntBits2 = Float.floatToRawIntBits(f3);
                    i12 = iFloatToRawIntBits2 >>> 31;
                    i13 = (iFloatToRawIntBits2 >>> 23) & 255;
                    i14 = 8388607 & iFloatToRawIntBits2;
                    if (i13 == 255) {
                        i15 = i13 - 112;
                        if (i15 < 31) {
                            if (i15 <= 0) {
                                i23 = i14 >> 13;
                                if ((iFloatToRawIntBits2 & 4096) != 0) {
                                    i16 = (((i15 << 10) | i23) + 1) | (i12 << 15);
                                } else {
                                    i21 = i15;
                                }
                            } else if (i15 >= -10) {
                                i17 = (i14 | 8388608) >> (1 - i15);
                                if ((i17 & 4096) != 0) {
                                    i17 += 8192;
                                }
                                i21 = 0;
                                i23 = i17 >> 13;
                            } else {
                                i21 = 0;
                            }
                        }
                        return Color.m1362constructorimpl(ULong.m5297constructorimpl(((((long) ((short) i16)) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | ((((long) s4) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) s5) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((((long) ((int) ((Math.max(0.0f, Math.min(f4, 1.0f)) * 1023.0f) + 0.5f))) & 1023) << 6) | (((long) colorSpace.getId$ui_graphics_release()) & 63)));
                    }
                    if (i14 == 0) {
                        i22 = 0;
                    }
                    i23 = i22;
                    i21 = 31;
                    i16 = (i12 << 15) | (i21 << 10) | i23;
                    return Color.m1362constructorimpl(ULong.m5297constructorimpl(((((long) ((short) i16)) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | ((((long) s4) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) s5) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((((long) ((int) ((Math.max(0.0f, Math.min(f4, 1.0f)) * 1023.0f) + 0.5f))) & 1023) << 6) | (((long) colorSpace.getId$ui_graphics_release()) & 63)));
                }
                if (i7 >= -10) {
                    i11 = (i6 | 8388608) >> (1 - i7);
                    if ((i11 & 4096) != 0) {
                        i11 += 8192;
                    }
                    i9 = i11 >> 13;
                    i7 = 0;
                } else {
                    i9 = 0;
                    i7 = 0;
                }
            }
        }
        i10 = i9 | (i4 << 15) | (i7 << 10);
        short s6 = (short) i10;
        iFloatToRawIntBits2 = Float.floatToRawIntBits(f3);
        i12 = iFloatToRawIntBits2 >>> 31;
        i13 = (iFloatToRawIntBits2 >>> 23) & 255;
        i14 = 8388607 & iFloatToRawIntBits2;
        if (i13 == 255) {
            i15 = i13 - 112;
            if (i15 < 31) {
                if (i15 <= 0) {
                    i23 = i14 >> 13;
                    if ((iFloatToRawIntBits2 & 4096) != 0) {
                        i16 = (((i15 << 10) | i23) + 1) | (i12 << 15);
                    } else {
                        i21 = i15;
                    }
                } else if (i15 >= -10) {
                    i17 = (i14 | 8388608) >> (1 - i15);
                    if ((i17 & 4096) != 0) {
                        i17 += 8192;
                    }
                    i21 = 0;
                    i23 = i17 >> 13;
                } else {
                    i21 = 0;
                }
            }
            return Color.m1362constructorimpl(ULong.m5297constructorimpl(((((long) ((short) i16)) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | ((((long) s4) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) s6) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((((long) ((int) ((Math.max(0.0f, Math.min(f4, 1.0f)) * 1023.0f) + 0.5f))) & 1023) << 6) | (((long) colorSpace.getId$ui_graphics_release()) & 63)));
        }
        if (i14 == 0) {
            i22 = 0;
        }
        i23 = i22;
        i21 = 31;
        i16 = (i12 << 15) | (i21 << 10) | i23;
        return Color.m1362constructorimpl(ULong.m5297constructorimpl(((((long) ((short) i16)) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16) | ((((long) s4) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) | ((((long) s6) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32) | ((((long) ((int) ((Math.max(0.0f, Math.min(f4, 1.0f)) * 1023.0f) + 0.5f))) & 1023) << 6) | (((long) colorSpace.getId$ui_graphics_release()) & 63)));
    }

    public static final long Color(int i) {
        return Color.m1362constructorimpl(ULong.m5297constructorimpl(ULong.m5297constructorimpl(i) << 32));
    }

    public static final long Color(long j) {
        return Color.m1362constructorimpl(ULong.m5297constructorimpl(j << 32));
    }

    public static /* synthetic */ long Color$default(int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            i4 = 255;
        }
        return Color(i, i2, i3, i4);
    }

    public static final long Color(int i, int i2, int i3, int i4) {
        return Color(((i & 255) << 16) | ((i4 & 255) << 24) | ((i2 & 255) << 8) | (i3 & 255));
    }

    /* JADX INFO: renamed from: lerp-jxsXWHM, reason: not valid java name */
    public static final long m1391lerpjxsXWHM(long j, long j2, float f) {
        ColorSpace oklab = ColorSpaces.INSTANCE.getOklab();
        long jM1363convertvNxB06k = Color.m1363convertvNxB06k(j, oklab);
        long jM1363convertvNxB06k2 = Color.m1363convertvNxB06k(j2, oklab);
        float fM1368getAlphaimpl = Color.m1368getAlphaimpl(jM1363convertvNxB06k);
        float fM1372getRedimpl = Color.m1372getRedimpl(jM1363convertvNxB06k);
        float fM1371getGreenimpl = Color.m1371getGreenimpl(jM1363convertvNxB06k);
        float fM1369getBlueimpl = Color.m1369getBlueimpl(jM1363convertvNxB06k);
        float fM1368getAlphaimpl2 = Color.m1368getAlphaimpl(jM1363convertvNxB06k2);
        float fM1372getRedimpl2 = Color.m1372getRedimpl(jM1363convertvNxB06k2);
        float fM1371getGreenimpl2 = Color.m1371getGreenimpl(jM1363convertvNxB06k2);
        float fM1369getBlueimpl2 = Color.m1369getBlueimpl(jM1363convertvNxB06k2);
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        return Color.m1363convertvNxB06k(UncheckedColor(MathHelpersKt.lerp(fM1372getRedimpl, fM1372getRedimpl2, f), MathHelpersKt.lerp(fM1371getGreenimpl, fM1371getGreenimpl2, f), MathHelpersKt.lerp(fM1369getBlueimpl, fM1369getBlueimpl2, f), MathHelpersKt.lerp(fM1368getAlphaimpl, fM1368getAlphaimpl2, f), oklab), Color.m1370getColorSpaceimpl(j2));
    }

    /* JADX INFO: renamed from: compositeOver--OWjLjI, reason: not valid java name */
    public static final long m1390compositeOverOWjLjI(long j, long j2) {
        long jM1363convertvNxB06k = Color.m1363convertvNxB06k(j, Color.m1370getColorSpaceimpl(j2));
        float fM1368getAlphaimpl = Color.m1368getAlphaimpl(j2);
        float fM1368getAlphaimpl2 = Color.m1368getAlphaimpl(jM1363convertvNxB06k);
        float f = 1.0f - fM1368getAlphaimpl2;
        float f2 = (fM1368getAlphaimpl * f) + fM1368getAlphaimpl2;
        return UncheckedColor(f2 == 0.0f ? 0.0f : ((Color.m1372getRedimpl(jM1363convertvNxB06k) * fM1368getAlphaimpl2) + ((Color.m1372getRedimpl(j2) * fM1368getAlphaimpl) * f)) / f2, f2 == 0.0f ? 0.0f : ((Color.m1371getGreenimpl(jM1363convertvNxB06k) * fM1368getAlphaimpl2) + ((Color.m1371getGreenimpl(j2) * fM1368getAlphaimpl) * f)) / f2, f2 != 0.0f ? ((Color.m1369getBlueimpl(jM1363convertvNxB06k) * fM1368getAlphaimpl2) + ((Color.m1369getBlueimpl(j2) * fM1368getAlphaimpl) * f)) / f2 : 0.0f, f2, Color.m1370getColorSpaceimpl(j2));
    }

    /* JADX INFO: renamed from: luminance-8_81llA, reason: not valid java name */
    public static final float m1392luminance8_81llA(long j) {
        ColorSpace colorSpaceM1370getColorSpaceimpl = Color.m1370getColorSpaceimpl(j);
        if (!ColorModel.m1531equalsimpl0(colorSpaceM1370getColorSpaceimpl.m1538getModelxdoWZVw(), ColorModel.Companion.m1536getRgbxdoWZVw())) {
            InlineClassHelperKt.throwIllegalArgumentException("The specified color must be encoded in an RGB color space. The supplied color space is " + ((Object) ColorModel.m1534toStringimpl(colorSpaceM1370getColorSpaceimpl.m1538getModelxdoWZVw())));
        }
        Intrinsics.checkNotNull(colorSpaceM1370getColorSpaceimpl, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
        DoubleFunction eotfFunc$ui_graphics_release = ((Rgb) colorSpaceM1370getColorSpaceimpl).getEotfFunc$ui_graphics_release();
        float fInvoke = (float) ((eotfFunc$ui_graphics_release.invoke(Color.m1372getRedimpl(j)) * 0.2126d) + (eotfFunc$ui_graphics_release.invoke(Color.m1371getGreenimpl(j)) * 0.7152d) + (eotfFunc$ui_graphics_release.invoke(Color.m1369getBlueimpl(j)) * 0.0722d));
        if (fInvoke < 0.0f) {
            fInvoke = 0.0f;
        }
        if (fInvoke > 1.0f) {
            return 1.0f;
        }
        return fInvoke;
    }

    /* JADX INFO: renamed from: toArgb-8_81llA, reason: not valid java name */
    public static final int m1393toArgb8_81llA(long j) {
        return (int) ULong.m5297constructorimpl(Color.m1363convertvNxB06k(j, ColorSpaces.INSTANCE.getSrgb()) >>> 32);
    }
}
