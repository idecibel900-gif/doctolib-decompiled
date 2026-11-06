package io.sentry.android.replay.video;

import java.io.File;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class MuxerConfig {
    private final int bitRate;
    private final File file;
    private final int frameRate;
    private final String mimeType;
    private int recordingHeight;
    private int recordingWidth;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MuxerConfig)) {
            return false;
        }
        MuxerConfig muxerConfig = (MuxerConfig) obj;
        return Intrinsics.areEqual(this.file, muxerConfig.file) && this.recordingWidth == muxerConfig.recordingWidth && this.recordingHeight == muxerConfig.recordingHeight && this.frameRate == muxerConfig.frameRate && this.bitRate == muxerConfig.bitRate && Intrinsics.areEqual(this.mimeType, muxerConfig.mimeType);
    }

    public int hashCode() {
        return (((((((((this.file.hashCode() * 31) + Integer.hashCode(this.recordingWidth)) * 31) + Integer.hashCode(this.recordingHeight)) * 31) + Integer.hashCode(this.frameRate)) * 31) + Integer.hashCode(this.bitRate)) * 31) + this.mimeType.hashCode();
    }

    public String toString() {
        return "MuxerConfig(file=" + this.file + ", recordingWidth=" + this.recordingWidth + ", recordingHeight=" + this.recordingHeight + ", frameRate=" + this.frameRate + ", bitRate=" + this.bitRate + ", mimeType=" + this.mimeType + ')';
    }

    public MuxerConfig(File file, int i, int i2, int i3, int i4, String mimeType) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        this.file = file;
        this.recordingWidth = i;
        this.recordingHeight = i2;
        this.frameRate = i3;
        this.bitRate = i4;
        this.mimeType = mimeType;
    }

    public final File getFile() {
        return this.file;
    }

    public final int getRecordingWidth() {
        return this.recordingWidth;
    }

    public final int getRecordingHeight() {
        return this.recordingHeight;
    }

    public final int getFrameRate() {
        return this.frameRate;
    }

    public final int getBitRate() {
        return this.bitRate;
    }

    public /* synthetic */ MuxerConfig(File file, int i, int i2, int i3, int i4, String str, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, i, i2, i3, i4, (i5 & 32) != 0 ? "video/avc" : str);
    }

    public final String getMimeType() {
        return this.mimeType;
    }
}
