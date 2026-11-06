package com.facebook.imageformat;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.ArraysKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ImageFormatCheckerUtils {
    public static final ImageFormatCheckerUtils INSTANCE = new ImageFormatCheckerUtils();

    private ImageFormatCheckerUtils() {
    }

    public static final byte[] asciiBytes(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        try {
            Charset charsetForName = Charset.forName("ASCII");
            Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
            byte[] bytes = value.getBytes(charsetForName);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            return bytes;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("ASCII not found!", e);
        }
    }

    public static final boolean startsWithPattern(byte[] byteArray, byte[] pattern) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        return hasPatternAt(byteArray, pattern, 0);
    }

    public static final boolean hasPatternAt(byte[] byteArray, byte[] pattern, int i) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        if (pattern.length + i > byteArray.length) {
            return false;
        }
        Iterable indices = ArraysKt.getIndices(pattern);
        if ((indices instanceof Collection) && ((Collection) indices).isEmpty()) {
            return true;
        }
        Iterator it = indices.iterator();
        while (it.hasNext()) {
            int iNextInt = ((IntIterator) it).nextInt();
            if (byteArray[i + iNextInt] != pattern[iNextInt]) {
                return false;
            }
        }
        return true;
    }
}
