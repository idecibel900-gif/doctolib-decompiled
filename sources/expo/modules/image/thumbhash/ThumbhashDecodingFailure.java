package expo.modules.image.thumbhash;

import expo.modules.kotlin.exception.CodedException;

/* JADX INFO: loaded from: classes4.dex */
public final class ThumbhashDecodingFailure extends CodedException {
    public ThumbhashDecodingFailure(String str, Exception exc) {
        super("Cannot decode provided thumbhash '" + str + "' " + exc, null, 2, null);
    }
}
