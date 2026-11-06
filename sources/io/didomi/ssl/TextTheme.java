package io.didomi.ssl;

import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import com.facebook.react.modules.appstate.AppStateModule;
import com.opentok.android.PublisherKit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: io.didomi.sdk.xg, reason: from toString */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0003\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\t\u0010\n\u001a\u00020\tHÖ\u0001J\t\u0010\u000b\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u000f\u001a\u0004\b\b\u0010\u0010R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016¨\u0006\u0019"}, d2 = {"Lio/didomi/sdk/xg;", "", "Landroid/graphics/drawable/GradientDrawable;", AppStateModule.APP_STATE_BACKGROUND, "", "textColor", "Landroid/graphics/Typeface;", "typeface", "a", "", "toString", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "Landroid/graphics/drawable/GradientDrawable;", "()Landroid/graphics/drawable/GradientDrawable;", "b", "I", "()I", "c", "Landroid/graphics/Typeface;", "()Landroid/graphics/Typeface;", "<init>", "(Landroid/graphics/drawable/GradientDrawable;ILandroid/graphics/Typeface;)V", "android_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class TextTheme {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
    private final GradientDrawable background;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
    private final int textColor;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
    private final Typeface typeface;

    public TextTheme(GradientDrawable gradientDrawable, int i, Typeface typeface) {
        this.background = gradientDrawable;
        this.textColor = i;
        this.typeface = typeface;
    }

    public final TextTheme a(GradientDrawable background, int textColor, Typeface typeface) {
        return new TextTheme(background, textColor, typeface);
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final int getTextColor() {
        return this.textColor;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final Typeface getTypeface() {
        return this.typeface;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextTheme)) {
            return false;
        }
        TextTheme textTheme = (TextTheme) other;
        return Intrinsics.areEqual(this.background, textTheme.background) && this.textColor == textTheme.textColor && Intrinsics.areEqual(this.typeface, textTheme.typeface);
    }

    public int hashCode() {
        GradientDrawable gradientDrawable = this.background;
        int iHashCode = (((gradientDrawable == null ? 0 : gradientDrawable.hashCode()) * 31) + Integer.hashCode(this.textColor)) * 31;
        Typeface typeface = this.typeface;
        return iHashCode + (typeface != null ? typeface.hashCode() : 0);
    }

    public String toString() {
        return "TextTheme(background=" + this.background + ", textColor=" + this.textColor + ", typeface=" + this.typeface + ')';
    }

    public static /* synthetic */ TextTheme a(TextTheme textTheme, GradientDrawable gradientDrawable, int i, Typeface typeface, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            gradientDrawable = textTheme.background;
        }
        if ((i2 & 2) != 0) {
            i = textTheme.textColor;
        }
        if ((i2 & 4) != 0) {
            typeface = textTheme.typeface;
        }
        return textTheme.a(gradientDrawable, i, typeface);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final GradientDrawable getBackground() {
        return this.background;
    }

    public /* synthetic */ TextTheme(GradientDrawable gradientDrawable, int i, Typeface typeface, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : gradientDrawable, i, (i2 & 4) != 0 ? null : typeface);
    }
}
