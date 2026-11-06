package io.sentry.android.replay;

import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class GeneratedVideo {
    private final long duration;
    private final int frameCount;
    private final File video;

    public final File component1() {
        return this.video;
    }

    public final int component2() {
        return this.frameCount;
    }

    public final long component3() {
        return this.duration;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GeneratedVideo)) {
            return false;
        }
        GeneratedVideo generatedVideo = (GeneratedVideo) obj;
        return Intrinsics.areEqual(this.video, generatedVideo.video) && this.frameCount == generatedVideo.frameCount && this.duration == generatedVideo.duration;
    }

    public int hashCode() {
        return (((this.video.hashCode() * 31) + Integer.hashCode(this.frameCount)) * 31) + Long.hashCode(this.duration);
    }

    public String toString() {
        return "GeneratedVideo(video=" + this.video + ", frameCount=" + this.frameCount + ", duration=" + this.duration + ')';
    }

    public GeneratedVideo(File video, int i, long j) {
        Intrinsics.checkNotNullParameter(video, "video");
        this.video = video;
        this.frameCount = i;
        this.duration = j;
    }
}
