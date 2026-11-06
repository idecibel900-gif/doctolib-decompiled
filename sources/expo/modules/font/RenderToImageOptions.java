package expo.modules.font;

import com.opentok.android.PublisherKit;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J8\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\bHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u0011R \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0015\u0012\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u0018¨\u0006%"}, d2 = {"Lexpo/modules/font/RenderToImageOptions;", "Lexpo/modules/kotlin/records/Record;", "fontFamily", "", "size", "", "lineHeight", "color", "", "<init>", "(Ljava/lang/String;FLjava/lang/Float;I)V", "getFontFamily$annotations", "()V", "getFontFamily", "()Ljava/lang/String;", "getSize$annotations", "getSize", "()F", "getLineHeight$annotations", "getLineHeight", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getColor$annotations", "getColor", "()I", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;FLjava/lang/Float;I)Lexpo/modules/font/RenderToImageOptions;", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "toString", "expo-font_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class RenderToImageOptions implements Record {
    private final int color;
    private final String fontFamily;
    private final Float lineHeight;
    private final float size;

    public RenderToImageOptions() {
        this(null, 0.0f, null, 0, 15, null);
    }

    public static /* synthetic */ RenderToImageOptions copy$default(RenderToImageOptions renderToImageOptions, String str, float f, Float f2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = renderToImageOptions.fontFamily;
        }
        if ((i2 & 2) != 0) {
            f = renderToImageOptions.size;
        }
        if ((i2 & 4) != 0) {
            f2 = renderToImageOptions.lineHeight;
        }
        if ((i2 & 8) != 0) {
            i = renderToImageOptions.color;
        }
        return renderToImageOptions.copy(str, f, f2, i);
    }

    @Field
    public static /* synthetic */ void getColor$annotations() {
    }

    @Field
    public static /* synthetic */ void getFontFamily$annotations() {
    }

    @Field
    public static /* synthetic */ void getLineHeight$annotations() {
    }

    @Field
    public static /* synthetic */ void getSize$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFontFamily() {
        return this.fontFamily;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getSize() {
        return this.size;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Float getLineHeight() {
        return this.lineHeight;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getColor() {
        return this.color;
    }

    public final RenderToImageOptions copy(String fontFamily, float size, Float lineHeight, int color) {
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        return new RenderToImageOptions(fontFamily, size, lineHeight, color);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RenderToImageOptions)) {
            return false;
        }
        RenderToImageOptions renderToImageOptions = (RenderToImageOptions) other;
        return Intrinsics.areEqual(this.fontFamily, renderToImageOptions.fontFamily) && Float.compare(this.size, renderToImageOptions.size) == 0 && Intrinsics.areEqual(this.lineHeight, renderToImageOptions.lineHeight) && this.color == renderToImageOptions.color;
    }

    public int hashCode() {
        int iHashCode = ((this.fontFamily.hashCode() * 31) + Float.hashCode(this.size)) * 31;
        Float f = this.lineHeight;
        return ((iHashCode + (f == null ? 0 : f.hashCode())) * 31) + Integer.hashCode(this.color);
    }

    public String toString() {
        return "RenderToImageOptions(fontFamily=" + this.fontFamily + ", size=" + this.size + ", lineHeight=" + this.lineHeight + ", color=" + this.color + ")";
    }

    public RenderToImageOptions(String fontFamily, float f, Float f2, int i) {
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        this.fontFamily = fontFamily;
        this.size = f;
        this.lineHeight = f2;
        this.color = i;
    }

    public final String getFontFamily() {
        return this.fontFamily;
    }

    public /* synthetic */ RenderToImageOptions(String str, float f, Float f2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 24.0f : f, (i2 & 4) != 0 ? null : f2, (i2 & 8) != 0 ? -16777216 : i);
    }

    public final float getSize() {
        return this.size;
    }

    public final Float getLineHeight() {
        return this.lineHeight;
    }

    public final int getColor() {
        return this.color;
    }
}
