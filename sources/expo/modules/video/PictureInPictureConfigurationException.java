package expo.modules.video;

import expo.modules.kotlin.exception.CodedException;

/* JADX INFO: loaded from: classes5.dex */
public final class PictureInPictureConfigurationException extends CodedException {
    public PictureInPictureConfigurationException() {
        super("Current activity does not support picture-in-picture. Make sure you have configured the `expo-video` config plugin correctly.", null, 2, null);
    }
}
