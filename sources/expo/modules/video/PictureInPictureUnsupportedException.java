package expo.modules.video;

import expo.modules.kotlin.exception.CodedException;

/* JADX INFO: loaded from: classes5.dex */
public final class PictureInPictureUnsupportedException extends CodedException {
    public PictureInPictureUnsupportedException() {
        super("Picture in Picture mode is not supported on this device", null, 2, null);
    }
}
