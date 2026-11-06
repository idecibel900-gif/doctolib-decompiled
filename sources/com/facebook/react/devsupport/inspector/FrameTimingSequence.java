package com.facebook.react.devsupport.inspector;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class FrameTimingSequence {
    private final long beginTimestamp;
    private final long endTimestamp;
    private final int id;
    private final byte[] screenshot;
    private final int threadId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FrameTimingSequence)) {
            return false;
        }
        FrameTimingSequence frameTimingSequence = (FrameTimingSequence) obj;
        return this.id == frameTimingSequence.id && this.threadId == frameTimingSequence.threadId && this.beginTimestamp == frameTimingSequence.beginTimestamp && this.endTimestamp == frameTimingSequence.endTimestamp && Intrinsics.areEqual(this.screenshot, frameTimingSequence.screenshot);
    }

    public int hashCode() {
        int iHashCode = ((((((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.threadId)) * 31) + Long.hashCode(this.beginTimestamp)) * 31) + Long.hashCode(this.endTimestamp)) * 31;
        byte[] bArr = this.screenshot;
        return iHashCode + (bArr == null ? 0 : Arrays.hashCode(bArr));
    }

    public String toString() {
        return "FrameTimingSequence(id=" + this.id + ", threadId=" + this.threadId + ", beginTimestamp=" + this.beginTimestamp + ", endTimestamp=" + this.endTimestamp + ", screenshot=" + Arrays.toString(this.screenshot) + ")";
    }

    public FrameTimingSequence(int i, int i2, long j, long j2, byte[] bArr) {
        this.id = i;
        this.threadId = i2;
        this.beginTimestamp = j;
        this.endTimestamp = j2;
        this.screenshot = bArr;
    }
}
