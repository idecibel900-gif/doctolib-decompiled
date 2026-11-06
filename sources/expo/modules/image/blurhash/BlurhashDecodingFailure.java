package expo.modules.image.blurhash;

import expo.modules.kotlin.exception.CodedException;

/* JADX INFO: loaded from: classes4.dex */
public final class BlurhashDecodingFailure extends CodedException {
    public BlurhashDecodingFailure(String str) {
        super("Cannot decode provided blurhash '" + str + "'", null, 2, null);
    }
}
