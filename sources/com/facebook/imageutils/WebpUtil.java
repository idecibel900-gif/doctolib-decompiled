package com.facebook.imageutils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.UShort;
import kotlin.collections.ArraysKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\tJ%\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\tJ%\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\tJ#\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\tJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0019\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u0018J\u0013\u0010\u001b\u001a\u00020\u0007*\u00020\u0004H\u0002¢\u0006\u0004\b\u001b\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/facebook/imageutils/WebpUtil;", "", "<init>", "()V", "Ljava/io/InputStream;", "stream", "Lkotlin/Pair;", "", "getSize", "(Ljava/io/InputStream;)Lkotlin/Pair;", "getVP8Dimension", "getVP8LDimension", "getVP8XDimension", "", "what", "", "with", "", "compare", "([BLjava/lang/String;)Z", "header", "getHeader", "([B)Ljava/lang/String;", "getInt", "(Ljava/io/InputStream;)I", "get2BytesAsInt", "read3Bytes", "getNextByteAsInt", "imagepipeline-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WebpUtil {
    public static final WebpUtil INSTANCE = new WebpUtil();

    private WebpUtil() {
    }

    public static final Pair<Integer, Integer> getSize(InputStream stream) {
        Pair<Integer, Integer> vP8Dimension;
        Intrinsics.checkNotNullParameter(stream, "stream");
        byte[] bArr = new byte[4];
        try {
            try {
                stream.read(bArr);
                WebpUtil webpUtil = INSTANCE;
                if (webpUtil.compare(bArr, "RIFF")) {
                    webpUtil.getInt(stream);
                    stream.read(bArr);
                    if (webpUtil.compare(bArr, "WEBP")) {
                        stream.read(bArr);
                        String header = webpUtil.getHeader(bArr);
                        int iHashCode = header.hashCode();
                        if (iHashCode == 2640674) {
                            if (header.equals("VP8 ")) {
                                vP8Dimension = webpUtil.getVP8Dimension(stream);
                                return vP8Dimension;
                            }
                            return null;
                        }
                        if (iHashCode == 2640718) {
                            if (!header.equals("VP8L")) {
                                return null;
                            }
                            vP8Dimension = webpUtil.getVP8LDimension(stream);
                            return vP8Dimension;
                        }
                        if (iHashCode != 2640730 || !header.equals("VP8X")) {
                            return null;
                        }
                        vP8Dimension = webpUtil.getVP8XDimension(stream);
                        try {
                            return vP8Dimension;
                        } catch (IOException e) {
                            return vP8Dimension;
                        }
                    }
                }
                try {
                    return null;
                } catch (IOException e2) {
                    return null;
                }
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        } finally {
            try {
                stream.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }
    }

    private final Pair getVP8Dimension(InputStream stream) throws IOException {
        stream.skip(7L);
        int nextByteAsInt = getNextByteAsInt(stream);
        int nextByteAsInt2 = getNextByteAsInt(stream);
        int nextByteAsInt3 = getNextByteAsInt(stream);
        if (nextByteAsInt == 157 && nextByteAsInt2 == 1 && nextByteAsInt3 == 42) {
            return new Pair(Integer.valueOf(get2BytesAsInt(stream)), Integer.valueOf(get2BytesAsInt(stream)));
        }
        return null;
    }

    private final Pair getVP8LDimension(InputStream stream) throws IOException {
        getInt(stream);
        if (getNextByteAsInt(stream) != 47) {
            return null;
        }
        int i = stream.read() & 255;
        int i2 = stream.read();
        return new Pair(Integer.valueOf((i | ((i2 & 63) << 8)) + 1), Integer.valueOf((((stream.read() & 15) << 10) | ((stream.read() & 255) << 2) | ((i2 & JfifUtil.MARKER_SOFn) >> 6)) + 1));
    }

    private final Pair getVP8XDimension(InputStream stream) throws IOException {
        stream.skip(8L);
        return new Pair(Integer.valueOf(read3Bytes(stream) + 1), Integer.valueOf(read3Bytes(stream) + 1));
    }

    private final boolean compare(byte[] what, String with) {
        if (what.length != with.length()) {
            return false;
        }
        Iterable indices = ArraysKt.getIndices(what);
        if ((indices instanceof Collection) && ((Collection) indices).isEmpty()) {
            return true;
        }
        Iterator it = indices.iterator();
        while (it.hasNext()) {
            int iNextInt = ((IntIterator) it).nextInt();
            if (((byte) with.charAt(iNextInt)) != what[iNextInt]) {
                return false;
            }
        }
        return true;
    }

    private final String getHeader(byte[] header) {
        StringBuilder sb = new StringBuilder();
        for (byte b : header) {
            sb.append((char) (UShort.m5320constructorimpl(b) & 65535));
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private final int getInt(InputStream stream) {
        int nextByteAsInt = getNextByteAsInt(stream);
        int nextByteAsInt2 = getNextByteAsInt(stream);
        return (getNextByteAsInt(stream) << 24) | (getNextByteAsInt(stream) << 16) | (nextByteAsInt2 << 8) | nextByteAsInt;
    }

    public static final int get2BytesAsInt(InputStream stream) throws IOException {
        Intrinsics.checkNotNullParameter(stream, "stream");
        WebpUtil webpUtil = INSTANCE;
        return (webpUtil.getNextByteAsInt(stream) << 8) | webpUtil.getNextByteAsInt(stream);
    }

    private final int read3Bytes(InputStream stream) {
        return (getNextByteAsInt(stream) << 16) | (getNextByteAsInt(stream) << 8) | getNextByteAsInt(stream);
    }

    private final int getNextByteAsInt(InputStream inputStream) {
        return inputStream.read() & 255;
    }
}
