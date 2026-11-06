package com.google.zxing.oned;

import com.facebook.imageutils.TiffUtil;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Code93Reader extends OneDReader {
    private static final char[] ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".toCharArray();
    static final int ASTERISK_ENCODING;
    static final int[] CHARACTER_ENCODINGS;

    static {
        int[] iArr = {276, 328, 324, 322, 296, 292, 290, 336, TiffUtil.TIFF_TAG_ORIENTATION, 266, 424, 420, 418, RCHTTPStatusCodes.NOT_FOUND, 402, 394, 360, 356, 354, StatusLine.HTTP_PERM_REDIRECT, 282, 344, 332, 326, 300, 278, 436, 434, 428, 422, 406, 410, 364, 358, 310, 314, 302, 468, 466, 458, 366, 374, 430, 294, 474, 470, 306, 350};
        CHARACTER_ENCODINGS = iArr;
        ASTERISK_ENCODING = iArr[47];
    }
}
