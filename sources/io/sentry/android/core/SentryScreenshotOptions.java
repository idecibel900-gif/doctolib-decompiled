package io.sentry.android.core;

import io.sentry.SentryMaskingOptions;

/* JADX INFO: loaded from: classes5.dex */
public final class SentryScreenshotOptions extends SentryMaskingOptions {
    @Override // io.sentry.SentryMaskingOptions
    public void trackCustomMasking() {
    }

    @Override // io.sentry.SentryMaskingOptions
    public void setMaskAllImages(boolean z) {
        super.setMaskAllImages(z);
        if (z) {
            addSensitiveViewClasses();
        } else {
            removeSensitiveViewClasses();
        }
    }

    private void addSensitiveViewClasses() {
        addMaskViewClass("android.webkit.WebView");
        addMaskViewClass("android.widget.VideoView");
        addMaskViewClass("androidx.camera.view.PreviewView");
        addMaskViewClass("androidx.media3.ui.PlayerView");
        addMaskViewClass("com.google.android.exoplayer2.ui.PlayerView");
        addMaskViewClass("com.google.android.exoplayer2.ui.StyledPlayerView");
    }

    private void removeSensitiveViewClasses() {
        getMaskViewClasses().remove("android.webkit.WebView");
        getMaskViewClasses().remove("android.widget.VideoView");
        getMaskViewClasses().remove("androidx.camera.view.PreviewView");
        getMaskViewClasses().remove("androidx.media3.ui.PlayerView");
        getMaskViewClasses().remove("com.google.android.exoplayer2.ui.PlayerView");
        getMaskViewClasses().remove("com.google.android.exoplayer2.ui.StyledPlayerView");
    }
}
