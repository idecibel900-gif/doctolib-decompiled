package expo.modules.webview;

import com.opentok.android.PublisherKit;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lexpo/modules/webview/ScrollToParam;", "Lexpo/modules/kotlin/records/Record;", "x", "", "y", "animated", "", "<init>", "(DDZ)V", "getX$annotations", "()V", "getX", "()D", "getY$annotations", "getY", "getAnimated$annotations", "getAnimated", "()Z", "component1", "component2", "component3", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "", "expo-dom-webview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class ScrollToParam implements Record {
    private final boolean animated;
    private final double x;
    private final double y;

    public ScrollToParam() {
        this(0.0d, 0.0d, false, 7, null);
    }

    public static /* synthetic */ ScrollToParam copy$default(ScrollToParam scrollToParam, double d, double d2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            d = scrollToParam.x;
        }
        double d3 = d;
        if ((i & 2) != 0) {
            d2 = scrollToParam.y;
        }
        double d4 = d2;
        if ((i & 4) != 0) {
            z = scrollToParam.animated;
        }
        return scrollToParam.copy(d3, d4, z);
    }

    @Field
    public static /* synthetic */ void getAnimated$annotations() {
    }

    @Field
    public static /* synthetic */ void getX$annotations() {
    }

    @Field
    public static /* synthetic */ void getY$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final double getX() {
        return this.x;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final double getY() {
        return this.y;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getAnimated() {
        return this.animated;
    }

    public final ScrollToParam copy(double x, double y, boolean animated) {
        return new ScrollToParam(x, y, animated);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScrollToParam)) {
            return false;
        }
        ScrollToParam scrollToParam = (ScrollToParam) other;
        return Double.compare(this.x, scrollToParam.x) == 0 && Double.compare(this.y, scrollToParam.y) == 0 && this.animated == scrollToParam.animated;
    }

    public int hashCode() {
        return (((Double.hashCode(this.x) * 31) + Double.hashCode(this.y)) * 31) + Boolean.hashCode(this.animated);
    }

    public String toString() {
        return "ScrollToParam(x=" + this.x + ", y=" + this.y + ", animated=" + this.animated + ")";
    }

    public ScrollToParam(double d, double d2, boolean z) {
        this.x = d;
        this.y = d2;
        this.animated = z;
    }

    public /* synthetic */ ScrollToParam(double d, double d2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0.0d : d, (i & 2) != 0 ? 0.0d : d2, (i & 4) != 0 ? true : z);
    }

    public final double getX() {
        return this.x;
    }

    public final double getY() {
        return this.y;
    }

    public final boolean getAnimated() {
        return this.animated;
    }
}
