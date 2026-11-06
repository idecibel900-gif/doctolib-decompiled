package expo.modules.video;

import expo.modules.kotlin.exception.CodedException;

/* JADX INFO: loaded from: classes5.dex */
public final class PictureInPictureEnterException extends CodedException {
    /* JADX WARN: Code duplicated, block: B:5:0x0015  */
    /* JADX WARN: Illegal instructions before constructor call */
    public PictureInPictureEnterException(String str) {
        String str2;
        if (str != null) {
            str2 = ". " + str;
            str2 = str2 == null ? "" : str2;
        }
        super("Failed to enter Picture in Picture mode" + str2, null, 2, null);
    }
}
