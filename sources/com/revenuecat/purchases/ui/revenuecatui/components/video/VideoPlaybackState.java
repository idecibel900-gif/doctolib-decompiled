package com.revenuecat.purchases.ui.revenuecatui.components.video;

import android.os.Parcel;
import android.os.Parcelable;
import com.opentok.android.PublisherKit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/video/VideoPlaybackState;", "Landroid/os/Parcelable;", "positionMs", "", "playWhenReady", "", "(IZ)V", "getPlayWhenReady", "()Z", "getPositionMs", "()I", "component1", "component2", "copy", "describeContents", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class VideoPlaybackState implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<VideoPlaybackState> CREATOR = new Creator();
    private final boolean playWhenReady;
    private final int positionMs;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<VideoPlaybackState> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VideoPlaybackState createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new VideoPlaybackState(parcel.readInt(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VideoPlaybackState[] newArray(int i) {
            return new VideoPlaybackState[i];
        }
    }

    public static /* synthetic */ VideoPlaybackState copy$default(VideoPlaybackState videoPlaybackState, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = videoPlaybackState.positionMs;
        }
        if ((i2 & 2) != 0) {
            z = videoPlaybackState.playWhenReady;
        }
        return videoPlaybackState.copy(i, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getPositionMs() {
        return this.positionMs;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getPlayWhenReady() {
        return this.playWhenReady;
    }

    public final VideoPlaybackState copy(int positionMs, boolean playWhenReady) {
        return new VideoPlaybackState(positionMs, playWhenReady);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoPlaybackState)) {
            return false;
        }
        VideoPlaybackState videoPlaybackState = (VideoPlaybackState) other;
        return this.positionMs == videoPlaybackState.positionMs && this.playWhenReady == videoPlaybackState.playWhenReady;
    }

    public int hashCode() {
        return (Integer.hashCode(this.positionMs) * 31) + Boolean.hashCode(this.playWhenReady);
    }

    public String toString() {
        return "VideoPlaybackState(positionMs=" + this.positionMs + ", playWhenReady=" + this.playWhenReady + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.positionMs);
        parcel.writeInt(this.playWhenReady ? 1 : 0);
    }

    public VideoPlaybackState(int i, boolean z) {
        this.positionMs = i;
        this.playWhenReady = z;
    }

    public final int getPositionMs() {
        return this.positionMs;
    }

    public final boolean getPlayWhenReady() {
        return this.playWhenReady;
    }
}
