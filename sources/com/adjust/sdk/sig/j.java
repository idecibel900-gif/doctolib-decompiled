package com.adjust.sdk.sig;

import com.adjust.sdk.Constants;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
public abstract class j {
    public static final Charset a = Charset.forName(Constants.ENCODING);

    static {
        Charset.forName("UTF-16");
        Charset.forName("UTF-16BE");
        Charset.forName("UTF-16LE");
        Charset.forName("US-ASCII");
        Charset.forName("ISO-8859-1");
    }
}
