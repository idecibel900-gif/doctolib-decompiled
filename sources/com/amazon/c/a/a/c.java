package com.amazon.c.a.a;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes3.dex */
public class c {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 0;
    public static final int d = 2;
    public static final int e = 4;
    public static final int f = 8;
    public static final int g = 16;
    public static final int h = 32;
    static final /* synthetic */ boolean i = true;
    private static final int j = 76;
    private static final String m = "US-ASCII";
    private static final byte[] p = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte n = -5;
    private static final byte k = 61;
    private static final byte o = -1;
    private static final byte l = 10;
    private static final byte[] q = {-9, -9, -9, -9, -9, -9, -9, -9, -9, n, n, -9, -9, n, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, n, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, k, -9, -9, -9, o, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, l, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    private static final byte[] r = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private static final byte[] s = {-9, -9, -9, -9, -9, -9, -9, -9, -9, n, n, -9, -9, n, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, n, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, k, -9, -9, -9, o, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, l, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    private static final byte[] t = {45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};
    private static final byte[] u = {-9, -9, -9, -9, -9, -9, -9, -9, -9, n, n, -9, -9, n, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, n, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, l, -9, -9, -9, o, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, k, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    private c() {
    }

    private static final byte[] b(int i2) {
        if ((i2 & 16) == 16) {
            return r;
        }
        if ((i2 & 32) == 32) {
            return t;
        }
        return p;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final byte[] c(int i2) {
        if ((i2 & 16) == 16) {
            return s;
        }
        if ((i2 & 32) == 32) {
            return u;
        }
        return q;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] b(byte[] bArr, byte[] bArr2, int i2, int i3) {
        b(bArr2, 0, i2, bArr, 0, i3);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] b(byte[] bArr, int i2, int i3, byte[] bArr2, int i4, int i5) {
        byte[] bArrB = b(i5);
        int i6 = (i3 > 0 ? (bArr[i2] << 24) >>> 8 : 0) | (i3 > 1 ? (bArr[i2 + 1] << 24) >>> 16 : 0) | (i3 > 2 ? (bArr[i2 + 2] << 24) >>> 24 : 0);
        if (i3 == 1) {
            bArr2[i4] = bArrB[i6 >>> 18];
            bArr2[i4 + 1] = bArrB[(i6 >>> 12) & 63];
            bArr2[i4 + 2] = k;
            bArr2[i4 + 3] = k;
            return bArr2;
        }
        if (i3 == 2) {
            bArr2[i4] = bArrB[i6 >>> 18];
            bArr2[i4 + 1] = bArrB[(i6 >>> 12) & 63];
            bArr2[i4 + 2] = bArrB[(i6 >>> 6) & 63];
            bArr2[i4 + 3] = k;
            return bArr2;
        }
        if (i3 != 3) {
            return bArr2;
        }
        bArr2[i4] = bArrB[i6 >>> 18];
        bArr2[i4 + 1] = bArrB[(i6 >>> 12) & 63];
        bArr2[i4 + 2] = bArrB[(i6 >>> 6) & 63];
        bArr2[i4 + 3] = bArrB[i6 & 63];
        return bArr2;
    }

    public static void a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        byte[] bArr = new byte[3];
        byte[] bArr2 = new byte[4];
        while (byteBuffer.hasRemaining()) {
            int iMin = Math.min(3, byteBuffer.remaining());
            byteBuffer.get(bArr, 0, iMin);
            b(bArr2, bArr, iMin, 0);
            byteBuffer2.put(bArr2);
        }
    }

    public static void a(ByteBuffer byteBuffer, CharBuffer charBuffer) {
        byte[] bArr = new byte[3];
        byte[] bArr2 = new byte[4];
        while (byteBuffer.hasRemaining()) {
            int iMin = Math.min(3, byteBuffer.remaining());
            byteBuffer.get(bArr, 0, iMin);
            b(bArr2, bArr, iMin, 0);
            for (int i2 = 0; i2 < 4; i2++) {
                charBuffer.put((char) (bArr2[i2] & o));
            }
        }
    }

    public static String a(Serializable serializable) throws IOException {
        return a(serializable, 0);
    }

    public static String a(Serializable serializable, int i2) throws Throwable {
        OutputStream gZIPOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        b bVar;
        ObjectOutputStream objectOutputStream;
        if (serializable == null) {
            throw new NullPointerException("Cannot serialize a null object.");
        }
        ObjectOutputStream objectOutputStream2 = null;
        objectOutputStream2 = null;
        objectOutputStream2 = null;
        objectOutputStream2 = null;
        objectOutputStream2 = null;
        objectOutputStream2 = null;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                bVar = new b(byteArrayOutputStream, i2 | 1);
                try {
                    if ((i2 & 2) != 0) {
                        gZIPOutputStream = new GZIPOutputStream(bVar);
                        try {
                            objectOutputStream2 = new ObjectOutputStream(gZIPOutputStream);
                            gZIPOutputStream = gZIPOutputStream;
                        } catch (IOException e2) {
                            e = e2;
                            objectOutputStream = objectOutputStream2;
                            byteArrayOutputStream2 = byteArrayOutputStream;
                            gZIPOutputStream = gZIPOutputStream;
                            try {
                                throw e;
                            } catch (Throwable th) {
                                th = th;
                                ObjectOutputStream objectOutputStream3 = objectOutputStream;
                                byteArrayOutputStream = byteArrayOutputStream2;
                                objectOutputStream2 = objectOutputStream3;
                                try {
                                    objectOutputStream2.close();
                                } catch (Exception unused) {
                                }
                                try {
                                    gZIPOutputStream.close();
                                } catch (Exception unused2) {
                                }
                                try {
                                    bVar.close();
                                } catch (Exception unused3) {
                                }
                                try {
                                    byteArrayOutputStream.close();
                                    throw th;
                                } catch (Exception unused4) {
                                    throw th;
                                }
                            }
                        }
                    } else {
                        objectOutputStream2 = new ObjectOutputStream(bVar);
                        gZIPOutputStream = null;
                    }
                    objectOutputStream2.writeObject(serializable);
                    try {
                        objectOutputStream2.close();
                    } catch (Exception unused5) {
                    }
                    try {
                        gZIPOutputStream.close();
                    } catch (Exception unused6) {
                    }
                    try {
                        bVar.close();
                    } catch (Exception unused7) {
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception unused8) {
                    }
                    try {
                        return new String(byteArrayOutputStream.toByteArray(), m);
                    } catch (UnsupportedEncodingException unused9) {
                        return new String(byteArrayOutputStream.toByteArray());
                    }
                } catch (IOException e3) {
                    e = e3;
                    ObjectOutputStream objectOutputStream4 = objectOutputStream2;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    objectOutputStream = objectOutputStream4;
                    gZIPOutputStream = objectOutputStream4;
                } catch (Throwable th2) {
                    th = th2;
                    gZIPOutputStream = objectOutputStream2;
                }
            } catch (IOException e4) {
                e = e4;
                gZIPOutputStream = null;
                bVar = null;
                byteArrayOutputStream2 = byteArrayOutputStream;
                objectOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                gZIPOutputStream = null;
                bVar = null;
            }
        } catch (IOException e5) {
            e = e5;
            gZIPOutputStream = null;
            objectOutputStream = null;
            bVar = null;
        } catch (Throwable th4) {
            th = th4;
            gZIPOutputStream = null;
            byteArrayOutputStream = null;
            bVar = null;
        }
    }

    public static String a(byte[] bArr) throws Throwable {
        String strA;
        try {
            strA = a(bArr, 0, bArr.length, 0);
        } catch (IOException e2) {
            if (!i) {
                throw new AssertionError(e2.getMessage());
            }
            strA = null;
        }
        if (i || strA != null) {
            return strA;
        }
        throw new AssertionError();
    }

    public static String a(byte[] bArr, int i2) throws IOException {
        return a(bArr, 0, bArr.length, i2);
    }

    public static String a(byte[] bArr, int i2, int i3) throws Throwable {
        String strA;
        try {
            strA = a(bArr, i2, i3, 0);
        } catch (IOException e2) {
            if (!i) {
                throw new AssertionError(e2.getMessage());
            }
            strA = null;
        }
        if (i || strA != null) {
            return strA;
        }
        throw new AssertionError();
    }

    public static String a(byte[] bArr, int i2, int i3, int i4) throws Throwable {
        byte[] bArrB = b(bArr, i2, i3, i4);
        try {
            return new String(bArrB, m);
        } catch (UnsupportedEncodingException unused) {
            return new String(bArrB);
        }
    }

    public static byte[] b(byte[] bArr) {
        try {
            return b(bArr, 0, bArr.length, 0);
        } catch (IOException e2) {
            if (i) {
                return null;
            }
            throw new AssertionError("IOExceptions only come from GZipping, which is turned off: " + e2.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static byte[] b(byte[] bArr, int i2, int i3, int i4) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        b bVar;
        GZIPOutputStream gZIPOutputStream;
        byte[] bArr2 = bArr;
        if (bArr2 == null) {
            throw new NullPointerException("Cannot serialize a null array.");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("Cannot have negative offset: " + i2);
        }
        if (i3 < 0) {
            throw new IllegalArgumentException("Cannot have length offset: " + i3);
        }
        if (i2 + i3 > bArr2.length) {
            throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(bArr2.length)));
        }
        if ((i4 & 2) != 0) {
            GZIPOutputStream gZIPOutputStream2 = null;
            gZIPOutputStream2 = null;
            gZIPOutputStream2 = null;
            ByteArrayOutputStream byteArrayOutputStream2 = null;
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    bVar = new b(byteArrayOutputStream, i4 | 1);
                    try {
                        gZIPOutputStream = new GZIPOutputStream(bVar);
                        try {
                            gZIPOutputStream.write(bArr2, i2, i3);
                            gZIPOutputStream.close();
                            try {
                                gZIPOutputStream.close();
                            } catch (Exception unused) {
                            }
                            try {
                                bVar.close();
                            } catch (Exception unused2) {
                            }
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception unused3) {
                            }
                            return byteArrayOutputStream.toByteArray();
                        } catch (IOException e2) {
                            e = e2;
                            byteArrayOutputStream2 = byteArrayOutputStream;
                            try {
                                throw e;
                            } catch (Throwable th) {
                                th = th;
                                byteArrayOutputStream = byteArrayOutputStream2;
                                gZIPOutputStream2 = gZIPOutputStream;
                                try {
                                    gZIPOutputStream2.close();
                                } catch (Exception unused4) {
                                }
                                try {
                                    bVar.close();
                                } catch (Exception unused5) {
                                }
                                try {
                                    byteArrayOutputStream.close();
                                    throw th;
                                } catch (Exception unused6) {
                                    throw th;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            gZIPOutputStream2 = gZIPOutputStream;
                            gZIPOutputStream2.close();
                            bVar.close();
                            byteArrayOutputStream.close();
                            throw th;
                        }
                    } catch (IOException e3) {
                        e = e3;
                        gZIPOutputStream = null;
                    }
                } catch (IOException e4) {
                    e = e4;
                    bVar = null;
                    gZIPOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    bVar = null;
                }
            } catch (IOException e5) {
                e = e5;
                bVar = null;
                gZIPOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                byteArrayOutputStream = null;
                bVar = null;
            }
        } else {
            Object[] objArr = (i4 & 8) != 0;
            int i5 = ((i3 / 3) * 4) + (i3 % 3 > 0 ? 4 : 0);
            if (objArr != false) {
                i5 += i5 / j;
            }
            int i6 = i5;
            byte[] bArr3 = new byte[i6];
            int i7 = i3 - 2;
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            while (i9 < i7) {
                b(bArr2, i9 + i2, 3, bArr3, i8, i4);
                i10 += 4;
                if (objArr != false && i10 >= j) {
                    bArr3[i8 + 4] = l;
                    i8++;
                    i10 = 0;
                }
                i9 += 3;
                i8 += 4;
                bArr2 = bArr;
            }
            if (i9 < i3) {
                b(bArr, i9 + i2, i3 - i9, bArr3, i8, i4);
                i8 += 4;
            }
            if (i8 > i6 - 1) {
                return bArr3;
            }
            byte[] bArr4 = new byte[i8];
            System.arraycopy(bArr3, 0, bArr4, 0, i8);
            return bArr4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        int i5;
        int i6;
        if (bArr == null) {
            throw new NullPointerException("Source array was null.");
        }
        if (bArr2 == null) {
            throw new NullPointerException("Destination array was null.");
        }
        if (i2 < 0 || (i5 = i2 + 3) >= bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i2)));
        }
        if (i3 < 0 || (i6 = i3 + 2) >= bArr2.length) {
            throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", Integer.valueOf(bArr2.length), Integer.valueOf(i3)));
        }
        byte[] bArrC = c(i4);
        byte b2 = bArr[i2 + 2];
        if (b2 == 61) {
            bArr2[i3] = (byte) ((((bArrC[bArr[i2 + 1]] & o) << 12) | ((bArrC[bArr[i2]] & o) << 18)) >>> 16);
            return 1;
        }
        byte b3 = bArr[i5];
        if (b3 == 61) {
            int i7 = ((bArrC[bArr[i2 + 1]] & o) << 12) | ((bArrC[bArr[i2]] & o) << 18) | ((bArrC[b2] & o) << 6);
            bArr2[i3] = (byte) (i7 >>> 16);
            bArr2[i3 + 1] = (byte) (i7 >>> 8);
            return 2;
        }
        int i8 = ((bArrC[bArr[i2 + 1]] & o) << 12) | ((bArrC[bArr[i2]] & o) << 18) | ((bArrC[b2] & o) << 6) | (bArrC[b3] & o);
        bArr2[i3] = (byte) (i8 >> 16);
        bArr2[i3 + 1] = (byte) (i8 >> 8);
        bArr2[i6] = (byte) i8;
        return 3;
    }

    public static byte[] c(byte[] bArr) throws IOException {
        return c(bArr, 0, bArr.length, 0);
    }

    public static byte[] c(byte[] bArr, int i2, int i3, int i4) throws IOException {
        int i5;
        if (bArr == null) {
            throw new NullPointerException("Cannot decode null source array.");
        }
        if (i2 < 0 || (i5 = i2 + i3) > bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)));
        }
        if (i3 == 0) {
            return new byte[0];
        }
        if (i3 < 4) {
            throw new IllegalArgumentException("Base64-encoded string must have at least four characters, but length specified was " + i3);
        }
        byte[] bArrC = c(i4);
        byte[] bArr2 = new byte[(i3 * 3) / 4];
        byte[] bArr3 = new byte[4];
        int i6 = 0;
        int iB = 0;
        while (i2 < i5) {
            byte b2 = bArr[i2];
            byte b3 = bArrC[b2 & o];
            if (b3 < -5) {
                throw new IOException(String.format("Bad Base64 input character decimal %d in array position %d", Integer.valueOf(bArr[i2] & o), Integer.valueOf(i2)));
            }
            if (b3 >= -1) {
                int i7 = i6 + 1;
                bArr3[i6] = b2;
                if (i7 > 3) {
                    iB += b(bArr3, 0, bArr2, iB, i4);
                    if (bArr[i2] == 61) {
                        break;
                    }
                    i6 = 0;
                } else {
                    i6 = i7;
                }
            }
            i2++;
        }
        byte[] bArr4 = new byte[iB];
        System.arraycopy(bArr2, 0, bArr4, 0, iB);
        return bArr4;
    }

    public static byte[] a(String str) throws IOException {
        return a(str, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v7 */
    public static byte[] a(String str, int i2) throws Throwable {
        byte[] bytes;
        ByteArrayInputStream length;
        ByteArrayInputStream byteArrayInputStream;
        GZIPInputStream gZIPInputStream;
        if (str == null) {
            throw new NullPointerException("Input string was null.");
        }
        try {
            bytes = str.getBytes(m);
        } catch (UnsupportedEncodingException unused) {
            bytes = str.getBytes();
        }
        byte[] bArrC = c(bytes, 0, bytes.length, i2);
        boolean z = (i2 & 4) != 0;
        if (bArrC != null && (length = bArrC.length) >= 4 && !z && 35615 == ((bArrC[0] & o) | ((bArrC[1] << 8) & 65280))) {
            byte[] bArr = new byte[2048];
            ByteArrayOutputStream byteArrayOutputStream = null;
            try {
                try {
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    try {
                        byteArrayInputStream = new ByteArrayInputStream(bArrC);
                        try {
                            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                            while (true) {
                                try {
                                    int i3 = gZIPInputStream.read(bArr);
                                    if (i3 < 0) {
                                        break;
                                    }
                                    byteArrayOutputStream2.write(bArr, 0, i3);
                                } catch (IOException e2) {
                                    e = e2;
                                    byteArrayOutputStream = byteArrayOutputStream2;
                                    byteArrayInputStream = byteArrayInputStream;
                                    try {
                                        e.printStackTrace();
                                        byteArrayOutputStream.close();
                                        length = byteArrayInputStream;
                                    } catch (Throwable th) {
                                        th = th;
                                        try {
                                            byteArrayOutputStream.close();
                                        } catch (Exception unused2) {
                                        }
                                        try {
                                            gZIPInputStream.close();
                                        } catch (Exception unused3) {
                                        }
                                        try {
                                            byteArrayInputStream.close();
                                            throw th;
                                        } catch (Exception unused4) {
                                            throw th;
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    byteArrayOutputStream = byteArrayOutputStream2;
                                    byteArrayOutputStream.close();
                                    gZIPInputStream.close();
                                    byteArrayInputStream.close();
                                    throw th;
                                }
                            }
                            bArrC = byteArrayOutputStream2.toByteArray();
                            byteArrayOutputStream2.close();
                            length = byteArrayInputStream;
                        } catch (IOException e3) {
                            e = e3;
                            gZIPInputStream = null;
                        } catch (Throwable th3) {
                            th = th3;
                            gZIPInputStream = null;
                        }
                    } catch (IOException e4) {
                        e = e4;
                        byteArrayInputStream = null;
                        gZIPInputStream = null;
                    } catch (Throwable th4) {
                        th = th4;
                        byteArrayInputStream = null;
                        gZIPInputStream = null;
                    }
                } catch (Exception unused5) {
                }
            } catch (IOException e5) {
                e = e5;
                byteArrayInputStream = null;
                gZIPInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                byteArrayInputStream = null;
                gZIPInputStream = null;
            }
            try {
                gZIPInputStream.close();
            } catch (Exception unused6) {
            }
            try {
                length.close();
            } catch (Exception unused7) {
            }
        }
        return bArrC;
    }

    public static void a(byte[] bArr, String str) throws Throwable {
        if (bArr == null) {
            throw new NullPointerException("Data to encode was null.");
        }
        b bVar = null;
        try {
            try {
                b bVar2 = new b(new FileOutputStream(str), 1);
                try {
                    bVar2.write(bArr);
                    try {
                        bVar2.close();
                    } catch (Exception unused) {
                    }
                } catch (IOException e2) {
                } catch (Throwable th) {
                    th = th;
                    bVar = bVar2;
                    try {
                        bVar.close();
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e3) {
            throw e3;
        }
    }

    public static void a(String str, String str2) throws Throwable {
        b bVar = null;
        try {
            try {
                b bVar2 = new b(new FileOutputStream(str2), 0);
                try {
                    bVar2.write(str.getBytes(m));
                    try {
                        bVar2.close();
                    } catch (Exception unused) {
                    }
                } catch (IOException e2) {
                } catch (Throwable th) {
                    th = th;
                    bVar = bVar2;
                    try {
                        bVar.close();
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
            } catch (IOException e3) {
                throw e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static byte[] b(String str) throws Throwable {
        a aVar = null;
        try {
            try {
                File file = new File(str);
                if (file.length() > 2147483647L) {
                    throw new IOException("File is too big for this convenience method (" + file.length() + " bytes).");
                }
                byte[] bArr = new byte[(int) file.length()];
                a aVar2 = new a(new BufferedInputStream(new FileInputStream(file)), 0);
                int i2 = 0;
                while (true) {
                    try {
                        int i3 = aVar2.read(bArr, i2, 4096);
                        if (i3 < 0) {
                            break;
                        }
                        i2 += i3;
                    } catch (IOException e2) {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        aVar = aVar2;
                        try {
                            aVar.close();
                        } catch (Exception unused) {
                        }
                        throw th;
                    }
                }
                byte[] bArr2 = new byte[i2];
                System.arraycopy(bArr, 0, bArr2, 0, i2);
                try {
                    aVar2.close();
                } catch (Exception unused2) {
                }
                return bArr2;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e3) {
            throw e3;
        }
    }

    public static String c(String str) throws Throwable {
        a aVar = null;
        try {
            File file = new File(str);
            byte[] bArr = new byte[Math.max((int) ((file.length() * 1.4d) + 1.0d), 40)];
            a aVar2 = new a(new BufferedInputStream(new FileInputStream(file)), 1);
            int i2 = 0;
            while (true) {
                try {
                    int i3 = aVar2.read(bArr, i2, 4096);
                    if (i3 < 0) {
                        break;
                    }
                    i2 += i3;
                } catch (IOException e2) {
                    aVar = aVar2;
                    throw e2;
                } catch (Throwable th) {
                    th = th;
                    aVar = aVar2;
                    try {
                        aVar.close();
                    } catch (Exception unused) {
                    }
                    throw th;
                }
            }
            String str2 = new String(bArr, 0, i2, m);
            try {
                aVar2.close();
            } catch (Exception unused2) {
            }
            return str2;
        } catch (IOException e3) {
            throw e3;
        }
    }

    public static void b(String str, String str2) throws Throwable {
        String strC = c(str);
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(str2));
                try {
                    bufferedOutputStream2.write(strC.getBytes(m));
                    try {
                        bufferedOutputStream2.close();
                    } catch (Exception unused) {
                    }
                } catch (IOException e2) {
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream = bufferedOutputStream2;
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e3) {
            throw e3;
        }
    }

    public static void c(String str, String str2) throws Throwable {
        byte[] bArrB = b(str);
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(str2));
                try {
                    bufferedOutputStream2.write(bArrB);
                    try {
                        bufferedOutputStream2.close();
                    } catch (Exception unused) {
                    }
                } catch (IOException e2) {
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream = bufferedOutputStream2;
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e3) {
            throw e3;
        }
    }

    public static class a extends FilterInputStream {
        private boolean a;
        private int b;
        private byte[] c;
        private int d;
        private int e;
        private int f;
        private boolean g;
        private int h;
        private byte[] i;

        public a(InputStream inputStream) {
            this(inputStream, 0);
        }

        public a(InputStream inputStream, int i) {
            super(inputStream);
            this.h = i;
            this.g = (i & 8) > 0;
            boolean z = (i & 1) > 0;
            this.a = z;
            int i2 = z ? 4 : 3;
            this.d = i2;
            this.c = new byte[i2];
            this.b = -1;
            this.f = 0;
            this.i = c.c(i);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int i;
            if (this.b < 0) {
                if (this.a) {
                    byte[] bArr = new byte[3];
                    int i2 = 0;
                    for (int i3 = 0; i3 < 3; i3++) {
                        int i4 = ((FilterInputStream) this).in.read();
                        if (i4 < 0) {
                            break;
                        }
                        bArr[i3] = (byte) i4;
                        i2++;
                    }
                    if (i2 <= 0) {
                        return -1;
                    }
                    c.b(bArr, 0, i2, this.c, 0, this.h);
                    this.b = 0;
                    this.e = 4;
                } else {
                    byte[] bArr2 = new byte[4];
                    int i5 = 0;
                    while (i5 < 4) {
                        do {
                            i = ((FilterInputStream) this).in.read();
                            if (i < 0) {
                                break;
                            }
                        } while (this.i[i & 127] <= -5);
                        if (i < 0) {
                            break;
                        }
                        bArr2[i5] = (byte) i;
                        i5++;
                    }
                    if (i5 != 4) {
                        if (i5 == 0) {
                            return -1;
                        }
                        throw new IOException("Improperly padded Base64 input.");
                    }
                    this.e = c.b(bArr2, 0, this.c, 0, this.h);
                    this.b = 0;
                }
            }
            int i6 = this.b;
            if (i6 >= 0) {
                if (i6 >= this.e) {
                    return -1;
                }
                if (this.a && this.g && this.f >= c.j) {
                    this.f = 0;
                    return 10;
                }
                this.f++;
                byte[] bArr3 = this.c;
                int i7 = i6 + 1;
                this.b = i7;
                byte b = bArr3[i6];
                if (i7 >= this.d) {
                    this.b = -1;
                }
                return b & c.o;
            }
            throw new IOException("Error in Base64 code reading stream.");
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3 = 0;
            while (i3 < i2) {
                int i4 = read();
                if (i4 >= 0) {
                    bArr[i + i3] = (byte) i4;
                    i3++;
                } else if (i3 == 0) {
                    return -1;
                }
            }
            return i3;
        }
    }

    public static class b extends FilterOutputStream {
        private boolean a;
        private int b;
        private byte[] c;
        private int d;
        private int e;
        private boolean f;
        private byte[] g;
        private boolean h;
        private int i;
        private byte[] j;

        public b(OutputStream outputStream) {
            this(outputStream, 1);
        }

        public b(OutputStream outputStream, int i) {
            super(outputStream);
            this.f = (i & 8) != 0;
            boolean z = (i & 1) != 0;
            this.a = z;
            int i2 = z ? 3 : 4;
            this.d = i2;
            this.c = new byte[i2];
            this.b = 0;
            this.e = 0;
            this.h = false;
            this.g = new byte[4];
            this.i = i;
            this.j = c.c(i);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i) throws IOException {
            if (this.h) {
                ((FilterOutputStream) this).out.write(i);
                return;
            }
            if (this.a) {
                byte[] bArr = this.c;
                int i2 = this.b;
                int i3 = i2 + 1;
                this.b = i3;
                bArr[i2] = (byte) i;
                int i4 = this.d;
                if (i3 >= i4) {
                    ((FilterOutputStream) this).out.write(c.b(this.g, bArr, i4, this.i));
                    int i5 = this.e + 4;
                    this.e = i5;
                    if (this.f && i5 >= c.j) {
                        ((FilterOutputStream) this).out.write(10);
                        this.e = 0;
                    }
                    this.b = 0;
                    return;
                }
                return;
            }
            byte b = this.j[i & 127];
            if (b <= -5) {
                if (b != -5) {
                    throw new IOException("Invalid character in Base64 data.");
                }
                return;
            }
            byte[] bArr2 = this.c;
            int i6 = this.b;
            int i7 = i6 + 1;
            this.b = i7;
            bArr2[i6] = (byte) i;
            if (i7 >= this.d) {
                ((FilterOutputStream) this).out.write(this.g, 0, c.b(bArr2, 0, this.g, 0, this.i));
                this.b = 0;
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            if (this.h) {
                ((FilterOutputStream) this).out.write(bArr, i, i2);
                return;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                write(bArr[i + i3]);
            }
        }

        public void a() throws IOException {
            int i = this.b;
            if (i > 0) {
                if (this.a) {
                    ((FilterOutputStream) this).out.write(c.b(this.g, this.c, i, this.i));
                    this.b = 0;
                    return;
                }
                throw new IOException("Base64 input not properly padded.");
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            a();
            super.close();
            this.c = null;
            ((FilterOutputStream) this).out = null;
        }

        public void b() throws IOException {
            a();
            this.h = true;
        }

        public void c() {
            this.h = false;
        }
    }
}
