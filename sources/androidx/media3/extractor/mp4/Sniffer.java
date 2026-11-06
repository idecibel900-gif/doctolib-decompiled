package androidx.media3.extractor.mp4;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.SniffFailure;

/* JADX INFO: loaded from: classes.dex */
public abstract class Sniffer {
    private static final int[] COMPATIBLE_BRANDS = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    public static SniffFailure sniffFragmented(ExtractorInput extractorInput) {
        return sniffInternal(extractorInput, true, false);
    }

    public static SniffFailure sniffUnfragmented(ExtractorInput extractorInput, boolean z) {
        return sniffInternal(extractorInput, false, z);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x007b  */
    /* JADX WARN: Code duplicated, block: B:78:0x012f  */
    /* JADX WARN: Code duplicated, block: B:80:0x0132  */
    /* JADX WARN: Code duplicated, block: B:82:0x0136 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:83:0x0138  */
    /* JADX WARN: Code duplicated, block: B:85:0x013b  */
    /* JADX WARN: Code duplicated, block: B:87:0x013e A[RETURN] */
    private static SniffFailure sniffInternal(ExtractorInput extractorInput, boolean z, boolean z2) {
        SniffFailure sniffFailure;
        int i;
        int i2;
        int i3;
        int[] iArr;
        long length = extractorInput.getLength();
        long j = -1;
        long j2 = 4096;
        if (length != -1 && length <= 4096) {
            j2 = length;
        }
        int i4 = (int) j2;
        ParsableByteArray parsableByteArray = new ParsableByteArray(64);
        int i5 = 0;
        int i6 = 0;
        boolean z3 = false;
        while (true) {
            if (i6 < i4) {
                parsableByteArray.reset(8);
                boolean z4 = true;
                if (extractorInput.peekFully(parsableByteArray.getData(), i5, 8, true)) {
                    long unsignedInt = parsableByteArray.readUnsignedInt();
                    int i7 = parsableByteArray.readInt();
                    if (unsignedInt == 1) {
                        j = j;
                        extractorInput.peekFully(parsableByteArray.getData(), 8, 8);
                        i2 = 16;
                        parsableByteArray.setLimit(16);
                        unsignedInt = parsableByteArray.readLong();
                        i6 = i6;
                    } else {
                        j = j;
                        if (unsignedInt == 0) {
                            long length2 = extractorInput.getLength();
                            if (length2 != j) {
                                unsignedInt = (length2 - extractorInput.getPeekPosition()) + ((long) 8);
                            }
                        }
                        i2 = 8;
                    }
                    long j3 = unsignedInt;
                    long j4 = i2;
                    if (j3 < j4) {
                        return new AtomSizeTooSmallSniffFailure(i7, j3, i2);
                    }
                    int i8 = i6 + i2;
                    sniffFailure = null;
                    if (i7 == 1836019574) {
                        i4 += (int) j3;
                        if (length != -1 && i4 > length) {
                            i4 = (int) length;
                        }
                        i6 = i8;
                        i5 = 0;
                    } else if (i7 == 1836019558 || i7 == 1836475768) {
                        i = 1;
                    } else {
                        if (i7 == 1835295092) {
                            z3 = true;
                        }
                        long j5 = length;
                        if ((((long) i8) + j3) - j4 >= i4) {
                            i = 0;
                        } else {
                            int i9 = (int) (j3 - j4);
                            i6 = i8 + i9;
                            if (i7 != 1718909296) {
                                i3 = 0;
                                if (i9 != 0) {
                                    extractorInput.advancePeekPosition(i9);
                                }
                            } else {
                                if (i9 < 8) {
                                    return new AtomSizeTooSmallSniffFailure(i7, i9, 8);
                                }
                                parsableByteArray.reset(i9);
                                i3 = 0;
                                extractorInput.peekFully(parsableByteArray.getData(), 0, i9);
                                int i10 = parsableByteArray.readInt();
                                if (isCompatibleBrand(i10, z2)) {
                                    z3 = true;
                                }
                                parsableByteArray.skipBytes(4);
                                int iBytesLeft = parsableByteArray.bytesLeft() / 4;
                                if (!z3 && iBytesLeft > 0) {
                                    iArr = new int[iBytesLeft];
                                    int i11 = 0;
                                    while (true) {
                                        if (i11 >= iBytesLeft) {
                                            z4 = z3;
                                            break;
                                        }
                                        int i12 = parsableByteArray.readInt();
                                        iArr[i11] = i12;
                                        if (isCompatibleBrand(i12, z2)) {
                                            break;
                                        }
                                        i11++;
                                    }
                                } else {
                                    z4 = z3;
                                    iArr = null;
                                }
                                if (!z4) {
                                    return new UnsupportedBrandsSniffFailure(i10, iArr);
                                }
                                z3 = z4;
                            }
                            i5 = i3;
                            length = j5;
                        }
                    }
                }
                if (!z3) {
                    return NoDeclaredBrandSniffFailure.INSTANCE;
                }
                if (z != i) {
                    return sniffFailure;
                }
                if (i != 0) {
                    return IncorrectFragmentationSniffFailure.FILE_FRAGMENTED;
                }
                return IncorrectFragmentationSniffFailure.FILE_NOT_FRAGMENTED;
            }
            sniffFailure = null;
            i = i5;
            if (!z3) {
                return NoDeclaredBrandSniffFailure.INSTANCE;
            }
            if (z != i) {
                return sniffFailure;
            }
            if (i != 0) {
                return IncorrectFragmentationSniffFailure.FILE_FRAGMENTED;
            }
            return IncorrectFragmentationSniffFailure.FILE_NOT_FRAGMENTED;
        }
    }

    private static boolean isCompatibleBrand(int i, boolean z) {
        if ((i >>> 8) == 3368816) {
            return true;
        }
        if (i == 1751476579 && z) {
            return true;
        }
        for (int i2 : COMPATIBLE_BRANDS) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }
}
