package expo.modules.image.records;

import android.graphics.Color;
import com.opentok.android.PublisherKit;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lexpo/modules/image/records/ImageLoadOptions;", "Lexpo/modules/kotlin/records/Record;", "maxWidth", "", "maxHeight", "tintColor", "Landroid/graphics/Color;", "<init>", "(IILandroid/graphics/Color;)V", "getMaxWidth$annotations", "()V", "getMaxWidth", "()I", "getMaxHeight$annotations", "getMaxHeight", "getTintColor$annotations", "getTintColor", "()Landroid/graphics/Color;", "component1", "component2", "component3", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "toString", "", "expo-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class ImageLoadOptions implements Record {
    private final int maxHeight;
    private final int maxWidth;
    private final Color tintColor;

    public ImageLoadOptions() {
        this(0, 0, null, 7, null);
    }

    public static /* synthetic */ ImageLoadOptions copy$default(ImageLoadOptions imageLoadOptions, int i, int i2, Color color, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = imageLoadOptions.maxWidth;
        }
        if ((i3 & 2) != 0) {
            i2 = imageLoadOptions.maxHeight;
        }
        if ((i3 & 4) != 0) {
            color = imageLoadOptions.tintColor;
        }
        return imageLoadOptions.copy(i, i2, color);
    }

    @Field
    public static /* synthetic */ void getMaxHeight$annotations() {
    }

    @Field
    public static /* synthetic */ void getMaxWidth$annotations() {
    }

    @Field
    public static /* synthetic */ void getTintColor$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getMaxWidth() {
        return this.maxWidth;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getMaxHeight() {
        return this.maxHeight;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Color getTintColor() {
        return this.tintColor;
    }

    public final ImageLoadOptions copy(int maxWidth, int maxHeight, Color tintColor) {
        return new ImageLoadOptions(maxWidth, maxHeight, tintColor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageLoadOptions)) {
            return false;
        }
        ImageLoadOptions imageLoadOptions = (ImageLoadOptions) other;
        return this.maxWidth == imageLoadOptions.maxWidth && this.maxHeight == imageLoadOptions.maxHeight && Intrinsics.areEqual(this.tintColor, imageLoadOptions.tintColor);
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.maxWidth) * 31) + Integer.hashCode(this.maxHeight)) * 31;
        Color color = this.tintColor;
        return iHashCode + (color == null ? 0 : color.hashCode());
    }

    public String toString() {
        return "ImageLoadOptions(maxWidth=" + this.maxWidth + ", maxHeight=" + this.maxHeight + ", tintColor=" + this.tintColor + ")";
    }

    public ImageLoadOptions(int i, int i2, Color color) {
        this.maxWidth = i;
        this.maxHeight = i2;
        this.tintColor = color;
    }

    public /* synthetic */ ImageLoadOptions(int i, int i2, Color color, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? Integer.MIN_VALUE : i, (i3 & 2) != 0 ? Integer.MIN_VALUE : i2, (i3 & 4) != 0 ? null : color);
    }

    public final int getMaxWidth() {
        return this.maxWidth;
    }

    public final int getMaxHeight() {
        return this.maxHeight;
    }

    public final Color getTintColor() {
        return this.tintColor;
    }
}
