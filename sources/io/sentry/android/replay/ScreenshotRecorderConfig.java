package io.sentry.android.replay;

import android.content.Context;
import io.sentry.SentryReplayOptions;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes5.dex */
public final class ScreenshotRecorderConfig {
    public static final Companion Companion = new Companion(null);
    private final int bitRate;
    private final int frameRate;
    private final int recordingHeight;
    private final int recordingWidth;
    private final float scaleFactorX;
    private final float scaleFactorY;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScreenshotRecorderConfig)) {
            return false;
        }
        ScreenshotRecorderConfig screenshotRecorderConfig = (ScreenshotRecorderConfig) obj;
        return this.recordingWidth == screenshotRecorderConfig.recordingWidth && this.recordingHeight == screenshotRecorderConfig.recordingHeight && Float.compare(this.scaleFactorX, screenshotRecorderConfig.scaleFactorX) == 0 && Float.compare(this.scaleFactorY, screenshotRecorderConfig.scaleFactorY) == 0 && this.frameRate == screenshotRecorderConfig.frameRate && this.bitRate == screenshotRecorderConfig.bitRate;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.recordingWidth) * 31) + Integer.hashCode(this.recordingHeight)) * 31) + Float.hashCode(this.scaleFactorX)) * 31) + Float.hashCode(this.scaleFactorY)) * 31) + Integer.hashCode(this.frameRate)) * 31) + Integer.hashCode(this.bitRate);
    }

    public String toString() {
        return "ScreenshotRecorderConfig(recordingWidth=" + this.recordingWidth + ", recordingHeight=" + this.recordingHeight + ", scaleFactorX=" + this.scaleFactorX + ", scaleFactorY=" + this.scaleFactorY + ", frameRate=" + this.frameRate + ", bitRate=" + this.bitRate + ')';
    }

    public ScreenshotRecorderConfig(int i, int i2, float f, float f2, int i3, int i4) {
        this.recordingWidth = i;
        this.recordingHeight = i2;
        this.scaleFactorX = f;
        this.scaleFactorY = f2;
        this.frameRate = i3;
        this.bitRate = i4;
    }

    public final int getRecordingWidth() {
        return this.recordingWidth;
    }

    public final int getRecordingHeight() {
        return this.recordingHeight;
    }

    public final float getScaleFactorX() {
        return this.scaleFactorX;
    }

    public final float getScaleFactorY() {
        return this.scaleFactorY;
    }

    public final int getFrameRate() {
        return this.frameRate;
    }

    public final int getBitRate() {
        return this.bitRate;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final int adjustToBlockSize(int i) {
            int i2 = i % 16;
            return i2 <= 8 ? Math.max(16, i - i2) : i + (16 - i2);
        }

        public final ScreenshotRecorderConfig fromSize(Context context, SentryReplayOptions sessionReplay, int i, int i2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(sessionReplay, "sessionReplay");
            float f = i2;
            float f2 = i;
            Pair pair = TuplesKt.to(Integer.valueOf(adjustToBlockSize(MathKt.roundToInt((f / context.getResources().getDisplayMetrics().density) * sessionReplay.getQuality().sizeScale))), Integer.valueOf(adjustToBlockSize(MathKt.roundToInt((f2 / context.getResources().getDisplayMetrics().density) * sessionReplay.getQuality().sizeScale))));
            int iIntValue = ((Number) pair.getFirst()).intValue();
            int iIntValue2 = ((Number) pair.getSecond()).intValue();
            return new ScreenshotRecorderConfig(iIntValue2, iIntValue, iIntValue2 / f2, iIntValue / f, sessionReplay.getFrameRate(), sessionReplay.getQuality().bitRate);
        }
    }
}
