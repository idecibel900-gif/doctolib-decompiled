package com.google.zxing.common;

import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

/* JADX INFO: loaded from: classes4.dex */
public abstract class StringUtils {
    private static final boolean ASSUME_SHIFT_JIS;
    private static final Charset EUC_JP;
    public static final Charset GB2312_CHARSET;
    private static final Charset PLATFORM_DEFAULT_ENCODING = Charset.defaultCharset();
    public static final Charset SHIFT_JIS_CHARSET = Charset.forName("SJIS");

    static {
        Charset charsetForName;
        try {
            charsetForName = Charset.forName("GB2312");
        } catch (UnsupportedCharsetException unused) {
            charsetForName = null;
        }
        GB2312_CHARSET = charsetForName;
        Charset charsetForName2 = Charset.forName("EUC_JP");
        EUC_JP = charsetForName2;
        Charset charset = SHIFT_JIS_CHARSET;
        Charset charset2 = PLATFORM_DEFAULT_ENCODING;
        ASSUME_SHIFT_JIS = charset.equals(charset2) || charsetForName2.equals(charset2);
    }
}
