package androidx.media3.exoplayer.video.spherical;

import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import java.util.ArrayList;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes.dex */
abstract class ProjectionDecoder {
    private static int decodeZigZag(int i) {
        return (-(i & 1)) ^ (i >> 1);
    }

    public static Projection decode(byte[] bArr, int i) {
        ArrayList proj;
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr);
        try {
            proj = isProj(parsableByteArray) ? parseProj(parsableByteArray) : parseMshp(parsableByteArray);
        } catch (ArrayIndexOutOfBoundsException unused) {
            proj = null;
        }
        if (proj == null) {
            return null;
        }
        int size = proj.size();
        if (size == 1) {
            return new Projection((Projection.Mesh) proj.get(0), i);
        }
        if (size != 2) {
            return null;
        }
        return new Projection((Projection.Mesh) proj.get(0), (Projection.Mesh) proj.get(1), i);
    }

    private static boolean isProj(ParsableByteArray parsableByteArray) {
        parsableByteArray.skipBytes(4);
        int i = parsableByteArray.readInt();
        parsableByteArray.setPosition(0);
        return i == 1886547818;
    }

    private static ArrayList parseProj(ParsableByteArray parsableByteArray) {
        int i;
        parsableByteArray.skipBytes(8);
        int position = parsableByteArray.getPosition();
        int iLimit = parsableByteArray.limit();
        while (position < iLimit && (i = parsableByteArray.readInt() + position) > position && i <= iLimit) {
            int i2 = parsableByteArray.readInt();
            if (i2 == 2037673328 || i2 == 1836279920) {
                parsableByteArray.setLimit(i);
                return parseMshp(parsableByteArray);
            }
            parsableByteArray.setPosition(i);
            position = i;
        }
        return null;
    }

    private static ArrayList parseMshp(ParsableByteArray parsableByteArray) {
        if (parsableByteArray.readUnsignedByte() != 0) {
            return null;
        }
        parsableByteArray.skipBytes(7);
        int i = parsableByteArray.readInt();
        if (i == 1684433976) {
            ParsableByteArray parsableByteArray2 = new ParsableByteArray();
            Inflater inflater = new Inflater(true);
            try {
                if (!Util.inflate(parsableByteArray, parsableByteArray2, inflater)) {
                    inflater.end();
                    return null;
                }
                inflater.end();
                parsableByteArray = parsableByteArray2;
            } catch (Throwable th) {
                inflater.end();
                throw th;
            }
        } else if (i != 1918990112) {
            return null;
        }
        return parseRawMshpData(parsableByteArray);
    }

    private static ArrayList parseRawMshpData(ParsableByteArray parsableByteArray) {
        ArrayList arrayList = new ArrayList();
        int position = parsableByteArray.getPosition();
        int iLimit = parsableByteArray.limit();
        while (position < iLimit) {
            int i = parsableByteArray.readInt() + position;
            if (i <= position || i > iLimit) {
                return null;
            }
            if (parsableByteArray.readInt() == 1835365224) {
                Projection.Mesh mesh = parseMesh(parsableByteArray);
                if (mesh == null) {
                    return null;
                }
                arrayList.add(mesh);
            }
            parsableByteArray.setPosition(i);
            position = i;
        }
        return arrayList;
    }

    private static Projection.Mesh parseMesh(ParsableByteArray parsableByteArray) {
        int i = parsableByteArray.readInt();
        Projection.Mesh mesh = null;
        if (i > 10000) {
            return null;
        }
        float[] fArr = new float[i];
        for (int i2 = 0; i2 < i; i2++) {
            fArr[i2] = parsableByteArray.readFloat();
        }
        int i3 = parsableByteArray.readInt();
        if (i3 > 32000) {
            return null;
        }
        double d = 2.0d;
        double dLog = Math.log(2.0d);
        int iCeil = (int) Math.ceil(Math.log(((double) i) * 2.0d) / dLog);
        ParsableBitArray parsableBitArray = new ParsableBitArray(parsableByteArray.getData());
        int i4 = 8;
        parsableBitArray.setPosition(parsableByteArray.getPosition() * 8);
        float[] fArr2 = new float[i3 * 5];
        int[] iArr = new int[5];
        int i5 = 0;
        int i6 = 0;
        while (i5 < i3) {
            Projection.Mesh mesh2 = mesh;
            int i7 = 0;
            while (i7 < 5) {
                int iDecodeZigZag = iArr[i7] + decodeZigZag(parsableBitArray.readBits(iCeil));
                if (iDecodeZigZag >= i || iDecodeZigZag < 0) {
                    return mesh2;
                }
                fArr2[i6] = fArr[iDecodeZigZag];
                iArr[i7] = iDecodeZigZag;
                i7++;
                i6++;
            }
            i5++;
            mesh = mesh2;
        }
        Projection.Mesh mesh3 = mesh;
        parsableBitArray.setPosition((parsableBitArray.getPosition() + 7) & (-8));
        int i8 = 32;
        int bits = parsableBitArray.readBits(32);
        Projection.SubMesh[] subMeshArr = new Projection.SubMesh[bits];
        int i9 = 0;
        while (i9 < bits) {
            int bits2 = parsableBitArray.readBits(i4);
            int bits3 = parsableBitArray.readBits(i4);
            int bits4 = parsableBitArray.readBits(i8);
            if (bits4 > 128000) {
                return mesh3;
            }
            int i10 = bits;
            int iCeil2 = (int) Math.ceil(Math.log(((double) i3) * d) / dLog);
            float[] fArr3 = new float[bits4 * 3];
            float[] fArr4 = new float[bits4 * 2];
            int i11 = 0;
            int i12 = 0;
            while (i11 < bits4) {
                int iDecodeZigZag2 = i12 + decodeZigZag(parsableBitArray.readBits(iCeil2));
                if (iDecodeZigZag2 < 0 || iDecodeZigZag2 >= i3) {
                    return mesh3;
                }
                int i13 = i11 * 3;
                int i14 = iDecodeZigZag2 * 5;
                fArr3[i13] = fArr2[i14];
                fArr3[i13 + 1] = fArr2[i14 + 1];
                fArr3[i13 + 2] = fArr2[i14 + 2];
                int i15 = i11 * 2;
                fArr4[i15] = fArr2[i14 + 3];
                fArr4[i15 + 1] = fArr2[i14 + 4];
                i11++;
                i12 = iDecodeZigZag2;
            }
            subMeshArr[i9] = new Projection.SubMesh(bits2, fArr3, fArr4, bits3);
            i9++;
            bits = i10;
            i8 = 32;
            d = 2.0d;
            i4 = 8;
        }
        return new Projection.Mesh(subMeshArr);
    }
}
