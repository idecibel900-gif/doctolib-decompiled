package expo.modules.video.records;

import android.net.Uri;
import androidx.media3.common.Format;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\b\u0007\u0018\u0000 42\u00020\u00012\u00020\u0002:\u00014Bq\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0017\u001a\u0004\b!\u0010\u0019R\u001c\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0017\u001a\u0004\b\n\u0010#R \u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010'\u0012\u0004\b$\u0010\u0017\u001a\u0004\b%\u0010&R \u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010'\u0012\u0004\b(\u0010\u0017\u001a\u0004\b)\u0010&R \u0010\u000f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010'\u0012\u0004\b*\u0010\u0017\u001a\u0004\b+\u0010&R \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010/\u0012\u0004\b,\u0010\u0017\u001a\u0004\b-\u0010.R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u00065"}, d2 = {"Lexpo/modules/video/records/VideoTrack;", "Lexpo/modules/kotlin/records/Record;", "Ljava/io/Serializable;", DiagnosticsEntry.ID_KEY, "", "url", "Landroid/net/Uri;", "size", "Lexpo/modules/video/records/VideoSize;", "mimeType", "isSupported", "", "bitrate", "", "averageBitrate", "peakBitrate", "frameRate", "", "format", "Landroidx/media3/common/Format;", "<init>", "(Ljava/lang/String;Landroid/net/Uri;Lexpo/modules/video/records/VideoSize;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Float;Landroidx/media3/common/Format;)V", "getId$annotations", "()V", "getId", "()Ljava/lang/String;", "getUrl$annotations", "getUrl", "()Landroid/net/Uri;", "getSize$annotations", "getSize", "()Lexpo/modules/video/records/VideoSize;", "getMimeType$annotations", "getMimeType", "isSupported$annotations", "()Z", "getBitrate$annotations", "getBitrate", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAverageBitrate$annotations", "getAverageBitrate", "getPeakBitrate$annotations", "getPeakBitrate", "getFrameRate$annotations", "getFrameRate", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getFormat", "()Landroidx/media3/common/Format;", "setFormat", "(Landroidx/media3/common/Format;)V", "Companion", "expo-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoTrack implements Record, Serializable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Integer averageBitrate;
    private final Integer bitrate;
    private Format format;
    private final Float frameRate;
    private final String id;
    private final boolean isSupported;
    private final String mimeType;
    private final Integer peakBitrate;
    private final VideoSize size;
    private final Uri url;

    @Field
    public static /* synthetic */ void getAverageBitrate$annotations() {
    }

    @Field
    public static /* synthetic */ void getBitrate$annotations() {
    }

    @Field
    public static /* synthetic */ void getFrameRate$annotations() {
    }

    @Field
    public static /* synthetic */ void getId$annotations() {
    }

    @Field
    public static /* synthetic */ void getMimeType$annotations() {
    }

    @Field
    public static /* synthetic */ void getPeakBitrate$annotations() {
    }

    @Field
    public static /* synthetic */ void getSize$annotations() {
    }

    @Field
    public static /* synthetic */ void getUrl$annotations() {
    }

    @Field
    public static /* synthetic */ void isSupported$annotations() {
    }

    public VideoTrack(String id, Uri uri, VideoSize size, String str, boolean z, Integer num, Integer num2, Integer num3, Float f, Format format) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(size, "size");
        this.id = id;
        this.url = uri;
        this.size = size;
        this.mimeType = str;
        this.isSupported = z;
        this.bitrate = num;
        this.averageBitrate = num2;
        this.peakBitrate = num3;
        this.frameRate = f;
        this.format = format;
    }

    public /* synthetic */ VideoTrack(String str, Uri uri, VideoSize videoSize, String str2, boolean z, Integer num, Integer num2, Integer num3, Float f, Format format, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, uri, videoSize, str2, (i & 16) != 0 ? true : z, (i & 32) != 0 ? null : num, (i & 64) != 0 ? null : num2, (i & 128) != 0 ? null : num3, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? null : f, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? null : format);
    }

    public final String getId() {
        return this.id;
    }

    public final Uri getUrl() {
        return this.url;
    }

    public final VideoSize getSize() {
        return this.size;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    /* JADX INFO: renamed from: isSupported, reason: from getter */
    public final boolean getIsSupported() {
        return this.isSupported;
    }

    public final Integer getBitrate() {
        return this.bitrate;
    }

    public final Integer getAverageBitrate() {
        return this.averageBitrate;
    }

    public final Integer getPeakBitrate() {
        return this.peakBitrate;
    }

    public final Float getFrameRate() {
        return this.frameRate;
    }

    public final Format getFormat() {
        return this.format;
    }

    public final void setFormat(Format format) {
        this.format = format;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final VideoTrack fromFormat(Format format, boolean z, Uri uri) {
            String str;
            if (format == null || (str = format.id) == null) {
                return null;
            }
            VideoSize videoSize = new VideoSize(format);
            String str2 = format.sampleMimeType;
            Integer numValueOf = Integer.valueOf(format.averageBitrate);
            Integer num = numValueOf.intValue() != -1 ? numValueOf : null;
            Integer numValueOf2 = Integer.valueOf(format.peakBitrate);
            Integer num2 = numValueOf2.intValue() != -1 ? numValueOf2 : null;
            Float fValueOf = Float.valueOf(format.frameRate);
            return new VideoTrack(str, uri, videoSize, str2, z, num == null ? num2 : num, num, num2, !((fValueOf.floatValue() > (-1.0f) ? 1 : (fValueOf.floatValue() == (-1.0f) ? 0 : -1)) == 0) ? fValueOf : null, format);
        }
    }
}
