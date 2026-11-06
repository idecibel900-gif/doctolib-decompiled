package expo.modules.video.records;

import androidx.media3.common.Format;
import com.opentok.android.PublisherKit;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\u0006\u0010\rJ\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u001e"}, d2 = {"Lexpo/modules/video/records/VideoSize;", "Lexpo/modules/kotlin/records/Record;", "Ljava/io/Serializable;", "width", "", "height", "<init>", "(II)V", "size", "Landroidx/media3/common/VideoSize;", "(Landroidx/media3/common/VideoSize;)V", "format", "Landroidx/media3/common/Format;", "(Landroidx/media3/common/Format;)V", "getWidth$annotations", "()V", "getWidth", "()I", "getHeight$annotations", "getHeight", "component1", "component2", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "toString", "", "expo-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class VideoSize implements Record, Serializable {
    private final int height;
    private final int width;

    /* JADX WARN: Illegal instructions before constructor call */
    public VideoSize() {
        int i = 0;
        this(i, i, 3, null);
    }

    public static /* synthetic */ VideoSize copy$default(VideoSize videoSize, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = videoSize.width;
        }
        if ((i3 & 2) != 0) {
            i2 = videoSize.height;
        }
        return videoSize.copy(i, i2);
    }

    @Field
    public static /* synthetic */ void getHeight$annotations() {
    }

    @Field
    public static /* synthetic */ void getWidth$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    public final VideoSize copy(int width, int height) {
        return new VideoSize(width, height);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoSize)) {
            return false;
        }
        VideoSize videoSize = (VideoSize) other;
        return this.width == videoSize.width && this.height == videoSize.height;
    }

    public int hashCode() {
        return (Integer.hashCode(this.width) * 31) + Integer.hashCode(this.height);
    }

    public String toString() {
        return "VideoSize(width=" + this.width + ", height=" + this.height + ")";
    }

    public VideoSize(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public /* synthetic */ VideoSize(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VideoSize(androidx.media3.common.VideoSize size) {
        this(size.width, size.height);
        Intrinsics.checkNotNullParameter(size, "size");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VideoSize(Format format) {
        this(format.width, format.height);
        Intrinsics.checkNotNullParameter(format, "format");
    }
}
