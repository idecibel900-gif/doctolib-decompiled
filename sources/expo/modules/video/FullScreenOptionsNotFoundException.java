package expo.modules.video;

import expo.modules.kotlin.exception.CodedException;

/* JADX INFO: loaded from: classes5.dex */
public final class FullScreenOptionsNotFoundException extends CodedException {
    public FullScreenOptionsNotFoundException() {
        super("Fullscreen options were not passed to the activity", null, 2, null);
    }
}
