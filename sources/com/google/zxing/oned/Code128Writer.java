package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class Code128Writer extends OneDimensionalCodeWriter {

    private enum CType {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    protected Collection getSupportedWriteFormats() {
        return Collections.singleton(BarcodeFormat.CODE_128);
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String str) {
        return encode(str, null);
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String str, Map map) {
        int iCheck = check(str, map);
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.CODE128_COMPACT;
            if (map.containsKey(encodeHintType) && Boolean.parseBoolean(map.get(encodeHintType).toString())) {
                return new MinimalEncoder(null).encode(str);
            }
        }
        return encodeFast(str, iCheck);
    }

    private static int check(String str, Map map) {
        int length = str.length();
        if (length < 1 || length > 80) {
            throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got " + length);
        }
        int i = -1;
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.FORCE_CODE_SET;
            if (map.containsKey(encodeHintType)) {
                String string = map.get(encodeHintType).toString();
                string.getClass();
                switch (string) {
                    case "A":
                        i = 101;
                        break;
                    case "B":
                        i = 100;
                        break;
                    case "C":
                        i = 99;
                        break;
                    default:
                        throw new IllegalArgumentException("Unsupported code set hint: " + string);
                }
            }
        }
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            switch (cCharAt) {
                case 241:
                case 242:
                case 243:
                case 244:
                    break;
                default:
                    if (cCharAt > 127) {
                        throw new IllegalArgumentException("Bad character in input: ASCII value=" + ((int) cCharAt));
                    }
                    break;
            }
            switch (i) {
                case 99:
                    if (cCharAt < '0' || ((cCharAt > '9' && cCharAt <= 127) || cCharAt == 242 || cCharAt == 243 || cCharAt == 244)) {
                        throw new IllegalArgumentException("Bad character in input for forced code set C: ASCII value=" + ((int) cCharAt));
                    }
                    break;
                    break;
                case 100:
                    if (cCharAt < ' ') {
                        throw new IllegalArgumentException("Bad character in input for forced code set B: ASCII value=" + ((int) cCharAt));
                    }
                    break;
                    break;
                case 101:
                    if (cCharAt > '_' && cCharAt <= 127) {
                        throw new IllegalArgumentException("Bad character in input for forced code set A: ASCII value=" + ((int) cCharAt));
                    }
                    break;
                    break;
            }
        }
        return i;
    }

    private static boolean[] encodeFast(String str, int i) {
        int length = str.length();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1;
        while (i2 < length) {
            int iChooseCode = i == -1 ? chooseCode(str, i2, i4) : i;
            int iCharAt = 100;
            if (iChooseCode == i4) {
                switch (str.charAt(i2)) {
                    case 241:
                        iCharAt = 102;
                        break;
                    case 242:
                        iCharAt = 97;
                        break;
                    case 243:
                        iCharAt = 96;
                        break;
                    case 244:
                        if (i4 == 101) {
                            iCharAt = 101;
                        }
                        break;
                    default:
                        if (i4 == 100) {
                            iCharAt = str.charAt(i2) - ' ';
                        } else if (i4 == 101) {
                            char cCharAt = str.charAt(i2);
                            iCharAt = cCharAt - ' ';
                            if (iCharAt < 0) {
                                iCharAt = cCharAt + '@';
                            }
                        } else {
                            int i6 = i2 + 1;
                            if (i6 == length) {
                                throw new IllegalArgumentException("Bad number of characters for digit only encoding.");
                            }
                            iCharAt = Integer.parseInt(str.substring(i2, i2 + 2));
                            i2 = i6;
                        }
                        break;
                }
                i2++;
            } else {
                if (i4 == 0) {
                    iCharAt = iChooseCode != 100 ? iChooseCode != 101 ? 105 : 103 : 104;
                } else {
                    iCharAt = iChooseCode;
                }
                i4 = iChooseCode;
            }
            arrayList.add(Code128Reader.CODE_PATTERNS[iCharAt]);
            i3 += iCharAt * i5;
            if (i2 != 0) {
                i5++;
            }
        }
        return produceResult(arrayList, i3);
    }

    static boolean[] produceResult(Collection collection, int i) {
        int[][] iArr = Code128Reader.CODE_PATTERNS;
        collection.add(iArr[i % 103]);
        collection.add(iArr[106]);
        Iterator it = collection.iterator();
        int iAppendPattern = 0;
        int i2 = 0;
        while (it.hasNext()) {
            for (int i3 : (int[]) it.next()) {
                i2 += i3;
            }
        }
        boolean[] zArr = new boolean[i2];
        Iterator it2 = collection.iterator();
        while (it2.hasNext()) {
            iAppendPattern += OneDimensionalCodeWriter.appendPattern(zArr, iAppendPattern, (int[]) it2.next(), true);
        }
        return zArr;
    }

    private static CType findCType(CharSequence charSequence, int i) {
        int length = charSequence.length();
        if (i >= length) {
            return CType.UNCODABLE;
        }
        char cCharAt = charSequence.charAt(i);
        if (cCharAt == 241) {
            return CType.FNC_1;
        }
        if (cCharAt < '0' || cCharAt > '9') {
            return CType.UNCODABLE;
        }
        int i2 = i + 1;
        if (i2 >= length) {
            return CType.ONE_DIGIT;
        }
        char cCharAt2 = charSequence.charAt(i2);
        if (cCharAt2 < '0' || cCharAt2 > '9') {
            return CType.ONE_DIGIT;
        }
        return CType.TWO_DIGITS;
    }

    private static int chooseCode(CharSequence charSequence, int i, int i2) {
        CType cTypeFindCType;
        CType cTypeFindCType2;
        char cCharAt;
        CType cTypeFindCType3 = findCType(charSequence, i);
        CType cType = CType.ONE_DIGIT;
        if (cTypeFindCType3 == cType) {
            return i2 == 101 ? 101 : 100;
        }
        CType cType2 = CType.UNCODABLE;
        if (cTypeFindCType3 == cType2) {
            return (i >= charSequence.length() || ((cCharAt = charSequence.charAt(i)) >= ' ' && (i2 != 101 || (cCharAt >= '`' && (cCharAt < 241 || cCharAt > 244))))) ? 100 : 101;
        }
        if (i2 == 101 && cTypeFindCType3 == CType.FNC_1) {
            return 101;
        }
        if (i2 == 99) {
            return 99;
        }
        if (i2 == 100) {
            CType cType3 = CType.FNC_1;
            if (cTypeFindCType3 == cType3 || (cTypeFindCType = findCType(charSequence, i + 2)) == cType2 || cTypeFindCType == cType) {
                return 100;
            }
            if (cTypeFindCType == cType3) {
                return findCType(charSequence, i + 3) == CType.TWO_DIGITS ? 99 : 100;
            }
            int i3 = i + 4;
            while (true) {
                cTypeFindCType2 = findCType(charSequence, i3);
                if (cTypeFindCType2 != CType.TWO_DIGITS) {
                    break;
                }
                i3 += 2;
            }
            return cTypeFindCType2 == CType.ONE_DIGIT ? 100 : 99;
        }
        if (cTypeFindCType3 == CType.FNC_1) {
            cTypeFindCType3 = findCType(charSequence, i + 1);
        }
        return cTypeFindCType3 == CType.TWO_DIGITS ? 99 : 100;
    }

    private static final class MinimalEncoder {
        private int[][] memoizedCost;
        private Latch[][] minPath;

        private enum Charset {
            A,
            B,
            C,
            NONE
        }

        private enum Latch {
            A,
            B,
            C,
            SHIFT,
            NONE
        }

        private static boolean isDigit(char c) {
            return c >= '0' && c <= '9';
        }

        private MinimalEncoder() {
        }

        /* synthetic */ MinimalEncoder(AnonymousClass1 anonymousClass1) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code duplicated, block: B:30:0x00a1  */
        /* JADX WARN: Code duplicated, block: B:32:0x00a9  */
        /* JADX WARN: Code duplicated, block: B:33:0x00ad  */
        /* JADX WARN: Code duplicated, block: B:35:0x00be  */
        /* JADX WARN: Code duplicated, block: B:36:0x00c0  */
        /* JADX WARN: Code duplicated, block: B:38:0x00c7  */
        /* JADX WARN: Code duplicated, block: B:39:0x00ce  */
        /* JADX WARN: Code duplicated, block: B:49:0x00e1  */
        /* JADX WARN: Code duplicated, block: B:50:0x00e4  */
        /* JADX WARN: Code duplicated, block: B:51:0x00e7  */
        /* JADX WARN: Code duplicated, block: B:69:0x00ff A[SYNTHETIC] */
        public boolean[] encode(String str) {
            boolean z;
            Charset charset;
            int i;
            boolean z2 = false;
            this.memoizedCost = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 4, str.length());
            this.minPath = (Latch[][]) Array.newInstance((Class<?>) Latch.class, 4, str.length());
            Charset charset2 = Charset.NONE;
            encode(str, charset2, 0);
            ArrayList arrayList = new ArrayList();
            int[] iArr = {0};
            int[] iArr2 = {1};
            int length = str.length();
            int i2 = 0;
            while (i2 < length) {
                Latch latch = this.minPath[charset2.ordinal()][i2];
                int i3 = AnonymousClass1.$SwitchMap$com$google$zxing$oned$Code128Writer$MinimalEncoder$Latch[latch.ordinal()];
                int iCharAt = 101;
                if (i3 == 1) {
                    z = z2;
                    charset = Charset.A;
                    addPattern(arrayList, i2 == 0 ? 103 : 101, iArr, iArr2, i2);
                } else if (i3 == 2) {
                    z = z2;
                    charset = Charset.B;
                    addPattern(arrayList, i2 == 0 ? 104 : 100, iArr, iArr2, i2);
                } else {
                    z = z2;
                    if (i3 == 3) {
                        charset = Charset.C;
                        addPattern(arrayList, i2 == 0 ? 105 : 99, iArr, iArr2, i2);
                    } else if (i3 == 4) {
                        addPattern(arrayList, 98, iArr, iArr2, i2);
                    }
                    if (charset2 == Charset.C) {
                        if (str.charAt(i2) == 241) {
                            addPattern(arrayList, 102, iArr, iArr2, i2);
                        } else {
                            addPattern(arrayList, Integer.parseInt(str.substring(i2, i2 + 2)), iArr, iArr2, i2);
                            i = i2 + 1;
                            if (i < length) {
                                i2 = i;
                            }
                        }
                    } else {
                        switch (str.charAt(i2)) {
                            case 241:
                                iCharAt = 102;
                                break;
                            case 242:
                                iCharAt = 97;
                                break;
                            case 243:
                                iCharAt = 96;
                                break;
                            case 244:
                                if ((charset2 != Charset.A || latch == Latch.SHIFT) && (charset2 != Charset.B || latch != Latch.SHIFT)) {
                                }
                                break;
                            default:
                                iCharAt = str.charAt(i2) - ' ';
                                break;
                        }
                        if (((charset2 != Charset.A && latch != Latch.SHIFT) || (charset2 == Charset.B && latch == Latch.SHIFT)) && iCharAt < 0) {
                        }
                        addPattern(arrayList, iCharAt, iArr, iArr2, i2);
                    }
                    i2++;
                    z2 = z;
                }
                charset2 = charset;
                if (charset2 == Charset.C) {
                    if (str.charAt(i2) == 241) {
                        addPattern(arrayList, 102, iArr, iArr2, i2);
                    } else {
                        addPattern(arrayList, Integer.parseInt(str.substring(i2, i2 + 2)), iArr, iArr2, i2);
                        i = i2 + 1;
                        if (i < length) {
                            i2 = i;
                        }
                    }
                } else {
                    switch (str.charAt(i2)) {
                        case 241:
                            iCharAt = 102;
                            break;
                        case 242:
                            iCharAt = 97;
                            break;
                        case 243:
                            iCharAt = 96;
                            break;
                        case 244:
                            iCharAt = charset2 != Charset.A ? 100 : 100;
                            break;
                        default:
                            iCharAt = str.charAt(i2) - ' ';
                            break;
                    }
                    iCharAt = charset2 != Charset.A ? iCharAt + 96 : iCharAt + 96;
                    addPattern(arrayList, iCharAt, iArr, iArr2, i2);
                }
                i2++;
                z2 = z;
            }
            this.memoizedCost = null;
            this.minPath = null;
            return Code128Writer.produceResult(arrayList, iArr[z2 ? 1 : 0]);
        }

        private static void addPattern(Collection collection, int i, int[] iArr, int[] iArr2, int i2) {
            collection.add(Code128Reader.CODE_PATTERNS[i]);
            if (i2 != 0) {
                iArr2[0] = iArr2[0] + 1;
            }
            iArr[0] = iArr[0] + (i * iArr2[0]);
        }

        private boolean canEncode(CharSequence charSequence, Charset charset, int i) {
            int i2;
            char cCharAt = charSequence.charAt(i);
            int i3 = AnonymousClass1.$SwitchMap$com$google$zxing$oned$Code128Writer$MinimalEncoder$Charset[charset.ordinal()];
            if (i3 == 1) {
                return cCharAt == 241 || cCharAt == 242 || cCharAt == 243 || cCharAt == 244 || " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001fÿ".indexOf(cCharAt) >= 0;
            }
            if (i3 == 2) {
                return cCharAt == 241 || cCharAt == 242 || cCharAt == 243 || cCharAt == 244 || " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u007fÿ".indexOf(cCharAt) >= 0;
            }
            if (i3 != 3) {
                return false;
            }
            return cCharAt == 241 || ((i2 = i + 1) < charSequence.length() && isDigit(cCharAt) && isDigit(charSequence.charAt(i2)));
        }

        private int encode(CharSequence charSequence, Charset charset, int i) {
            int iEncode;
            int iEncode2;
            int i2 = this.memoizedCost[charset.ordinal()][i];
            if (i2 > 0) {
                return i2;
            }
            Latch latch = Latch.NONE;
            int i3 = i + 1;
            int i4 = 0;
            boolean z = i3 >= charSequence.length();
            Charset[] charsetArr = {Charset.A, Charset.B};
            int i5 = Integer.MAX_VALUE;
            while (true) {
                if (i4 > 1) {
                    break;
                }
                if (canEncode(charSequence, charsetArr[i4], i)) {
                    Latch latchValueOf = Latch.NONE;
                    Charset charset2 = charsetArr[i4];
                    if (charset != charset2) {
                        latchValueOf = Latch.valueOf(charset2.toString());
                        iEncode2 = 2;
                    } else {
                        iEncode2 = 1;
                    }
                    if (!z) {
                        iEncode2 += encode(charSequence, charsetArr[i4], i3);
                    }
                    if (iEncode2 < i5) {
                        latch = latchValueOf;
                        i5 = iEncode2;
                    }
                    if (charset == charsetArr[(i4 + 1) % 2]) {
                        Latch latch2 = Latch.SHIFT;
                        int iEncode3 = z ? 2 : 2 + encode(charSequence, charset, i3);
                        if (iEncode3 < i5) {
                            i5 = iEncode3;
                            latch = latch2;
                        }
                    }
                }
                i4++;
            }
            Charset charset3 = Charset.C;
            if (canEncode(charSequence, charset3, i)) {
                Latch latch3 = Latch.NONE;
                if (charset != charset3) {
                    latch3 = Latch.C;
                    iEncode = 2;
                } else {
                    iEncode = 1;
                }
                int i6 = (charSequence.charAt(i) != 241 ? 2 : 1) + i;
                if (i6 < charSequence.length()) {
                    iEncode += encode(charSequence, charset3, i6);
                }
                if (iEncode < i5) {
                    latch = latch3;
                    i5 = iEncode;
                }
            }
            if (i5 == Integer.MAX_VALUE) {
                throw new IllegalArgumentException("Bad character in input: ASCII value=" + ((int) charSequence.charAt(i)));
            }
            this.memoizedCost[charset.ordinal()][i] = i5;
            this.minPath[charset.ordinal()][i] = latch;
            return i5;
        }
    }

    /* JADX INFO: renamed from: com.google.zxing.oned.Code128Writer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$zxing$oned$Code128Writer$MinimalEncoder$Charset;
        static final /* synthetic */ int[] $SwitchMap$com$google$zxing$oned$Code128Writer$MinimalEncoder$Latch;

        static {
            int[] iArr = new int[MinimalEncoder.Charset.values().length];
            $SwitchMap$com$google$zxing$oned$Code128Writer$MinimalEncoder$Charset = iArr;
            try {
                iArr[MinimalEncoder.Charset.A.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$zxing$oned$Code128Writer$MinimalEncoder$Charset[MinimalEncoder.Charset.B.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$zxing$oned$Code128Writer$MinimalEncoder$Charset[MinimalEncoder.Charset.C.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[MinimalEncoder.Latch.values().length];
            $SwitchMap$com$google$zxing$oned$Code128Writer$MinimalEncoder$Latch = iArr2;
            try {
                iArr2[MinimalEncoder.Latch.A.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$zxing$oned$Code128Writer$MinimalEncoder$Latch[MinimalEncoder.Latch.B.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$zxing$oned$Code128Writer$MinimalEncoder$Latch[MinimalEncoder.Latch.C.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$zxing$oned$Code128Writer$MinimalEncoder$Latch[MinimalEncoder.Latch.SHIFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }
}
