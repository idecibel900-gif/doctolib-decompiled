package expo.modules.updates.reloadscreen;

import android.net.Uri;
import com.opentok.android.PublisherKit;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J>\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0011\u0012\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0011\u0012\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\u0010R \u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0011\u0012\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\u0010¨\u0006$"}, d2 = {"Lexpo/modules/updates/reloadscreen/ReloadScreenImageSource;", "Lexpo/modules/kotlin/records/Record;", "url", "Landroid/net/Uri;", "width", "", "height", "scale", "<init>", "(Landroid/net/Uri;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)V", "getUrl$annotations", "()V", "getUrl", "()Landroid/net/Uri;", "getWidth$annotations", "getWidth", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getHeight$annotations", "getHeight", "getScale$annotations", "getScale", "component1", "component2", "component3", "component4", "copy", "(Landroid/net/Uri;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)Lexpo/modules/updates/reloadscreen/ReloadScreenImageSource;", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "", "expo-updates_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class ReloadScreenImageSource implements Record {
    private final Double height;
    private final Double scale;
    private final Uri url;
    private final Double width;

    public ReloadScreenImageSource() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ ReloadScreenImageSource copy$default(ReloadScreenImageSource reloadScreenImageSource, Uri uri, Double d, Double d2, Double d3, int i, Object obj) {
        if ((i & 1) != 0) {
            uri = reloadScreenImageSource.url;
        }
        if ((i & 2) != 0) {
            d = reloadScreenImageSource.width;
        }
        if ((i & 4) != 0) {
            d2 = reloadScreenImageSource.height;
        }
        if ((i & 8) != 0) {
            d3 = reloadScreenImageSource.scale;
        }
        return reloadScreenImageSource.copy(uri, d, d2, d3);
    }

    @Field
    public static /* synthetic */ void getHeight$annotations() {
    }

    @Field
    public static /* synthetic */ void getScale$annotations() {
    }

    @Field
    public static /* synthetic */ void getUrl$annotations() {
    }

    @Field
    public static /* synthetic */ void getWidth$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Uri getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Double getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Double getHeight() {
        return this.height;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Double getScale() {
        return this.scale;
    }

    public final ReloadScreenImageSource copy(Uri url, Double width, Double height, Double scale) {
        return new ReloadScreenImageSource(url, width, height, scale);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReloadScreenImageSource)) {
            return false;
        }
        ReloadScreenImageSource reloadScreenImageSource = (ReloadScreenImageSource) other;
        return Intrinsics.areEqual(this.url, reloadScreenImageSource.url) && Intrinsics.areEqual(this.width, reloadScreenImageSource.width) && Intrinsics.areEqual(this.height, reloadScreenImageSource.height) && Intrinsics.areEqual(this.scale, reloadScreenImageSource.scale);
    }

    public int hashCode() {
        Uri uri = this.url;
        int iHashCode = (uri == null ? 0 : uri.hashCode()) * 31;
        Double d = this.width;
        int iHashCode2 = (iHashCode + (d == null ? 0 : d.hashCode())) * 31;
        Double d2 = this.height;
        int iHashCode3 = (iHashCode2 + (d2 == null ? 0 : d2.hashCode())) * 31;
        Double d3 = this.scale;
        return iHashCode3 + (d3 != null ? d3.hashCode() : 0);
    }

    public String toString() {
        return "ReloadScreenImageSource(url=" + this.url + ", width=" + this.width + ", height=" + this.height + ", scale=" + this.scale + ")";
    }

    public ReloadScreenImageSource(Uri uri, Double d, Double d2, Double d3) {
        this.url = uri;
        this.width = d;
        this.height = d2;
        this.scale = d3;
    }

    public /* synthetic */ ReloadScreenImageSource(Uri uri, Double d, Double d2, Double d3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : uri, (i & 2) != 0 ? null : d, (i & 4) != 0 ? null : d2, (i & 8) != 0 ? null : d3);
    }

    public final Uri getUrl() {
        return this.url;
    }

    public final Double getWidth() {
        return this.width;
    }

    public final Double getHeight() {
        return this.height;
    }

    public final Double getScale() {
        return this.scale;
    }
}
