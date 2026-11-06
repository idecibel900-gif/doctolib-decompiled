package expo.modules.video.records;

import com.opentok.android.PublisherKit;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import expo.modules.video.enums.FullscreenOrientation;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r¨\u0006\u001e"}, d2 = {"Lexpo/modules/video/records/FullscreenOptions;", "Lexpo/modules/kotlin/records/Record;", "Ljava/io/Serializable;", "enable", "", "orientation", "Lexpo/modules/video/enums/FullscreenOrientation;", "autoExitOnRotate", "<init>", "(ZLexpo/modules/video/enums/FullscreenOrientation;Z)V", "getEnable$annotations", "()V", "getEnable", "()Z", "getOrientation$annotations", "getOrientation", "()Lexpo/modules/video/enums/FullscreenOrientation;", "getAutoExitOnRotate$annotations", "getAutoExitOnRotate", "component1", "component2", "component3", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "", "expo-video_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class FullscreenOptions implements Record, Serializable {
    private final boolean autoExitOnRotate;
    private final boolean enable;
    private final FullscreenOrientation orientation;

    public FullscreenOptions() {
        this(false, null, false, 7, null);
    }

    public static /* synthetic */ FullscreenOptions copy$default(FullscreenOptions fullscreenOptions, boolean z, FullscreenOrientation fullscreenOrientation, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = fullscreenOptions.enable;
        }
        if ((i & 2) != 0) {
            fullscreenOrientation = fullscreenOptions.orientation;
        }
        if ((i & 4) != 0) {
            z2 = fullscreenOptions.autoExitOnRotate;
        }
        return fullscreenOptions.copy(z, fullscreenOrientation, z2);
    }

    @Field
    public static /* synthetic */ void getAutoExitOnRotate$annotations() {
    }

    @Field
    public static /* synthetic */ void getEnable$annotations() {
    }

    @Field
    public static /* synthetic */ void getOrientation$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final FullscreenOrientation getOrientation() {
        return this.orientation;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getAutoExitOnRotate() {
        return this.autoExitOnRotate;
    }

    public final FullscreenOptions copy(boolean enable, FullscreenOrientation orientation, boolean autoExitOnRotate) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        return new FullscreenOptions(enable, orientation, autoExitOnRotate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FullscreenOptions)) {
            return false;
        }
        FullscreenOptions fullscreenOptions = (FullscreenOptions) other;
        return this.enable == fullscreenOptions.enable && this.orientation == fullscreenOptions.orientation && this.autoExitOnRotate == fullscreenOptions.autoExitOnRotate;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.enable) * 31) + this.orientation.hashCode()) * 31) + Boolean.hashCode(this.autoExitOnRotate);
    }

    public String toString() {
        return "FullscreenOptions(enable=" + this.enable + ", orientation=" + this.orientation + ", autoExitOnRotate=" + this.autoExitOnRotate + ")";
    }

    public FullscreenOptions(boolean z, FullscreenOrientation orientation, boolean z2) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        this.enable = z;
        this.orientation = orientation;
        this.autoExitOnRotate = z2;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public /* synthetic */ FullscreenOptions(boolean z, FullscreenOrientation fullscreenOrientation, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? FullscreenOrientation.DEFAULT : fullscreenOrientation, (i & 4) != 0 ? false : z2);
    }

    public final FullscreenOrientation getOrientation() {
        return this.orientation;
    }

    public final boolean getAutoExitOnRotate() {
        return this.autoExitOnRotate;
    }
}
