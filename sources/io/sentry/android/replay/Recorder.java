package io.sentry.android.replay;

import java.io.Closeable;

/* JADX INFO: loaded from: classes5.dex */
public interface Recorder extends Closeable {
    void onConfigurationChanged(ScreenshotRecorderConfig screenshotRecorderConfig);

    void pause();

    void reset();

    void resume();

    void start();

    void stop();
}
