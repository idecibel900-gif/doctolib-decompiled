package expo.modules.video;

import expo.modules.kotlin.exception.CodedException;

/* JADX INFO: loaded from: classes5.dex */
public final class FullScreenVideoViewNotFoundException extends CodedException {
    public FullScreenVideoViewNotFoundException() {
        super("VideoView id wasn't passed to the activity", null, 2, null);
    }
}
