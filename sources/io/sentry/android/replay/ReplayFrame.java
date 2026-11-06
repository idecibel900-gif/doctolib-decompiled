package io.sentry.android.replay;

import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class ReplayFrame {
    private final String screen;
    private final File screenshot;
    private final long timestamp;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReplayFrame)) {
            return false;
        }
        ReplayFrame replayFrame = (ReplayFrame) obj;
        return Intrinsics.areEqual(this.screenshot, replayFrame.screenshot) && this.timestamp == replayFrame.timestamp && Intrinsics.areEqual(this.screen, replayFrame.screen);
    }

    public int hashCode() {
        int iHashCode = ((this.screenshot.hashCode() * 31) + Long.hashCode(this.timestamp)) * 31;
        String str = this.screen;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "ReplayFrame(screenshot=" + this.screenshot + ", timestamp=" + this.timestamp + ", screen=" + this.screen + ')';
    }

    public ReplayFrame(File screenshot, long j, String str) {
        Intrinsics.checkNotNullParameter(screenshot, "screenshot");
        this.screenshot = screenshot;
        this.timestamp = j;
        this.screen = str;
    }

    public final File getScreenshot() {
        return this.screenshot;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getScreen() {
        return this.screen;
    }
}
