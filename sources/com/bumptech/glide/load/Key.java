package com.bumptech.glide.load;

import com.adjust.sdk.Constants;
import java.nio.charset.Charset;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes3.dex */
public interface Key {
    public static final Charset CHARSET = Charset.forName(Constants.ENCODING);

    boolean equals(Object obj);

    int hashCode();

    void updateDiskCacheKey(MessageDigest messageDigest);
}
