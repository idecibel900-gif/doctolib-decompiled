package io.sentry.android.replay.screenshot;

import android.view.View;

/* JADX INFO: loaded from: classes5.dex */
public interface ScreenshotStrategy {
    void capture(View view);

    void close();

    void emitLastScreenshot();

    boolean lastCaptureSuccessful();

    void onContentChanged();
}
