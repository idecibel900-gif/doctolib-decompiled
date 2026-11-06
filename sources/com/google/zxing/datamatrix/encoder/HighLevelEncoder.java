package com.google.zxing.datamatrix.encoder;

import com.google.zxing.Dimension;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public abstract class HighLevelEncoder {
    static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    static boolean isExtendedASCII(char c) {
        return c >= 128 && c <= 255;
    }

    static boolean isNativeC40(char c) {
        if (c == ' ') {
            return true;
        }
        if (c < '0' || c > '9') {
            return c >= 'A' && c <= 'Z';
        }
        return true;
    }

    static boolean isNativeEDIFACT(char c) {
        return c >= ' ' && c <= '^';
    }

    static boolean isNativeText(char c) {
        if (c == ' ') {
            return true;
        }
        if (c < '0' || c > '9') {
            return c >= 'a' && c <= 'z';
        }
        return true;
    }

    private static boolean isSpecialB256(char c) {
        return false;
    }

    private static boolean isX12TermSep(char c) {
        return c == '\r' || c == '*' || c == '>';
    }

    private static char randomize253State(int i) {
        int i2 = (i * 149) % 253;
        int i3 = i2 + 130;
        if (i3 > 254) {
            i3 = i2 - 124;
        }
        return (char) i3;
    }

    public static String encodeHighLevel(String str, SymbolShapeHint symbolShapeHint, Dimension dimension, Dimension dimension2, boolean z) {
        C40Encoder c40Encoder = new C40Encoder();
        int newEncoding = 0;
        Encoder[] encoderArr = {new ASCIIEncoder(), c40Encoder, new TextEncoder(), new X12Encoder(), new EdifactEncoder(), new Base256Encoder()};
        EncoderContext encoderContext = new EncoderContext(str);
        encoderContext.setSymbolShape(symbolShapeHint);
        encoderContext.setSizeConstraints(dimension, dimension2);
        if (str.startsWith("[)>\u001e05\u001d") && str.endsWith("\u001e\u0004")) {
            encoderContext.writeCodeword((char) 236);
            encoderContext.setSkipAtEnd(2);
            encoderContext.pos += 7;
        } else if (str.startsWith("[)>\u001e06\u001d") && str.endsWith("\u001e\u0004")) {
            encoderContext.writeCodeword((char) 237);
            encoderContext.setSkipAtEnd(2);
            encoderContext.pos += 7;
        }
        if (z) {
            c40Encoder.encodeMaximal(encoderContext);
            newEncoding = encoderContext.getNewEncoding();
            encoderContext.resetEncoderSignal();
        }
        while (encoderContext.hasMoreCharacters()) {
            encoderArr[newEncoding].encode(encoderContext);
            if (encoderContext.getNewEncoding() >= 0) {
                newEncoding = encoderContext.getNewEncoding();
                encoderContext.resetEncoderSignal();
            }
        }
        int codewordCount = encoderContext.getCodewordCount();
        encoderContext.updateSymbolInfo();
        int dataCapacity = encoderContext.getSymbolInfo().getDataCapacity();
        if (codewordCount < dataCapacity && newEncoding != 0 && newEncoding != 5 && newEncoding != 4) {
            encoderContext.writeCodeword((char) 254);
        }
        StringBuilder codewords = encoderContext.getCodewords();
        if (codewords.length() < dataCapacity) {
            codewords.append((char) 129);
        }
        while (codewords.length() < dataCapacity) {
            codewords.append(randomize253State(codewords.length() + 1));
        }
        return encoderContext.getCodewords().toString();
    }

    static int lookAheadTest(CharSequence charSequence, int i, int i2) {
        int iLookAheadTestIntern = lookAheadTestIntern(charSequence, i, i2);
        if (i2 == 3 && iLookAheadTestIntern == 3) {
            int iMin = Math.min(i + 3, charSequence.length());
            while (i < iMin) {
                if (!isNativeX12(charSequence.charAt(i))) {
                    return 0;
                }
                i++;
            }
        } else if (i2 == 4 && iLookAheadTestIntern == 4) {
            int iMin2 = Math.min(i + 4, charSequence.length());
            while (i < iMin2) {
                if (!isNativeEDIFACT(charSequence.charAt(i))) {
                    return 0;
                }
                i++;
            }
        }
        return iLookAheadTestIntern;
    }

    static int lookAheadTestIntern(CharSequence charSequence, int i, int i2) {
        float[] fArr;
        float f;
        int i3;
        if (i >= charSequence.length()) {
            return i2;
        }
        float f2 = 2.0f;
        float f3 = 1.0f;
        int i4 = 5;
        int i5 = 2;
        if (i2 == 0) {
            fArr = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.25f};
        } else {
            fArr = new float[6];
            fArr[0] = 1.0f;
            fArr[1] = 2.0f;
            fArr[2] = 2.0f;
            fArr[3] = 2.0f;
            fArr[4] = 2.0f;
            fArr[5] = 2.25f;
            fArr[i2] = 0.0f;
        }
        byte[] bArr = new byte[6];
        int[] iArr = new int[6];
        int i6 = 0;
        while (true) {
            int i7 = i + i6;
            float f4 = f2;
            if (i7 == charSequence.length()) {
                Arrays.fill(bArr, (byte) 0);
                Arrays.fill(iArr, 0);
                int iFindMinimums = findMinimums(fArr, iArr, Integer.MAX_VALUE, bArr);
                int minimumCount = getMinimumCount(bArr);
                if (iArr[0] == iFindMinimums) {
                    return 0;
                }
                if (minimumCount == 1) {
                    if (bArr[i4] > 0) {
                        return i4;
                    }
                    if (bArr[4] > 0) {
                        return 4;
                    }
                    if (bArr[i5] > 0) {
                        return i5;
                    }
                    if (bArr[3] > 0) {
                        return 3;
                    }
                }
                return 1;
            }
            char cCharAt = charSequence.charAt(i7);
            i6++;
            if (isDigit(cCharAt)) {
                fArr[0] = fArr[0] + 0.5f;
                f = f3;
            } else if (isExtendedASCII(cCharAt)) {
                f = f3;
                float fCeil = (float) Math.ceil(fArr[0]);
                fArr[0] = fCeil;
                fArr[0] = fCeil + f4;
            } else {
                f = f3;
                float fCeil2 = (float) Math.ceil(fArr[0]);
                fArr[0] = fCeil2;
                fArr[0] = fCeil2 + f;
            }
            if (isNativeC40(cCharAt)) {
                fArr[1] = fArr[1] + 0.6666667f;
            } else if (isExtendedASCII(cCharAt)) {
                fArr[1] = fArr[1] + 2.6666667f;
            } else {
                fArr[1] = fArr[1] + 1.3333334f;
            }
            if (isNativeText(cCharAt)) {
                fArr[i5] = fArr[i5] + 0.6666667f;
            } else if (isExtendedASCII(cCharAt)) {
                fArr[i5] = fArr[i5] + 2.6666667f;
            } else {
                fArr[i5] = fArr[i5] + 1.3333334f;
            }
            if (isNativeX12(cCharAt)) {
                fArr[3] = fArr[3] + 0.6666667f;
            } else if (isExtendedASCII(cCharAt)) {
                fArr[3] = fArr[3] + 4.3333335f;
            } else {
                fArr[3] = fArr[3] + 3.3333333f;
            }
            if (isNativeEDIFACT(cCharAt)) {
                fArr[4] = fArr[4] + 0.75f;
            } else if (isExtendedASCII(cCharAt)) {
                fArr[4] = fArr[4] + 4.25f;
            } else {
                fArr[4] = fArr[4] + 3.25f;
            }
            if (isSpecialB256(cCharAt)) {
                fArr[i4] = fArr[i4] + 4.0f;
            } else {
                fArr[i4] = fArr[i4] + f;
            }
            if (i6 >= 4) {
                Arrays.fill(bArr, (byte) 0);
                Arrays.fill(iArr, 0);
                findMinimums(fArr, iArr, Integer.MAX_VALUE, bArr);
                i3 = i5;
                if (iArr[0] < min(iArr[i4], iArr[1], iArr[i5], iArr[3], iArr[4])) {
                    return 0;
                }
                int i8 = iArr[i4];
                if (i8 < iArr[0] || i8 + 1 < min(iArr[1], iArr[i3], iArr[3], iArr[4])) {
                    return i4;
                }
                if (iArr[4] + 1 < min(iArr[i4], iArr[1], iArr[i3], iArr[3], iArr[0])) {
                    return 4;
                }
                if (iArr[i3] + 1 < min(iArr[i4], iArr[1], iArr[4], iArr[3], iArr[0])) {
                    return i3;
                }
                if (iArr[3] + 1 < min(iArr[i4], iArr[1], iArr[4], iArr[i3], iArr[0])) {
                    return 3;
                }
                if (iArr[1] + 1 >= min(iArr[0], iArr[i4], iArr[4], iArr[i3])) {
                    continue;
                } else {
                    int i9 = iArr[1];
                    int i10 = iArr[3];
                    if (i9 < i10) {
                        return 1;
                    }
                    if (i9 == i10) {
                        for (int i11 = i + i6 + 1; i11 < charSequence.length(); i11++) {
                            char cCharAt2 = charSequence.charAt(i11);
                            if (isX12TermSep(cCharAt2)) {
                                return 3;
                            }
                            if (!isNativeX12(cCharAt2)) {
                                break;
                            }
                        }
                        return 1;
                    }
                }
            } else {
                i3 = i5;
            }
            f2 = f4;
            f3 = f;
            i4 = i4;
            i5 = i3;
        }
    }

    private static int min(int i, int i2, int i3, int i4, int i5) {
        return Math.min(min(i, i2, i3, i4), i5);
    }

    private static int min(int i, int i2, int i3, int i4) {
        return Math.min(i, Math.min(i2, Math.min(i3, i4)));
    }

    private static int findMinimums(float[] fArr, int[] iArr, int i, byte[] bArr) {
        for (int i2 = 0; i2 < 6; i2++) {
            int iCeil = (int) Math.ceil(fArr[i2]);
            iArr[i2] = iCeil;
            if (i > iCeil) {
                Arrays.fill(bArr, (byte) 0);
                i = iCeil;
            }
            if (i == iCeil) {
                bArr[i2] = (byte) (bArr[i2] + 1);
            }
        }
        return i;
    }

    private static int getMinimumCount(byte[] bArr) {
        int i = 0;
        for (int i2 = 0; i2 < 6; i2++) {
            i += bArr[i2];
        }
        return i;
    }

    static boolean isNativeX12(char c) {
        if (isX12TermSep(c) || c == ' ') {
            return true;
        }
        if (c < '0' || c > '9') {
            return c >= 'A' && c <= 'Z';
        }
        return true;
    }

    public static int determineConsecutiveDigitCount(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = i;
        while (i2 < length && isDigit(charSequence.charAt(i2))) {
            i2++;
        }
        return i2 - i;
    }

    static void illegalCharacter(char c) {
        String hexString = Integer.toHexString(c);
        throw new IllegalArgumentException("Illegal character: " + c + " (0x" + ("0000".substring(0, 4 - hexString.length()) + hexString) + ')');
    }
}
