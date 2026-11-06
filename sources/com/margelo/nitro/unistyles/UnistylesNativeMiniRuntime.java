package com.margelo.nitro.unistyles;

import androidx.annotation.Keep;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.opentok.android.PublisherKit;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@DoNotStrip
@Keep
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u000f\b\u0087\b\u0018\u0000 52\u00020\u0001:\u00015B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u000e¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010$\u001a\u00020\u000e2\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010&\u001a\u00020'H\u0016J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0007HÆ\u0003J\t\u0010+\u001a\u00020\tHÆ\u0003J\t\u0010,\u001a\u00020\u000bHÆ\u0003J\t\u0010-\u001a\u00020\u000bHÆ\u0003J\t\u0010.\u001a\u00020\u000eHÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u000eHÆ\u0003J\t\u00102\u001a\u00020\u000eHÆ\u0003Jw\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u000eHÆ\u0001J\t\u00104\u001a\u00020\u0007HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0016\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0016\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0016\u0010\u0010\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u0016\u0010\u0011\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010!R\u0016\u0010\u0012\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010!¨\u00066"}, d2 = {"Lcom/margelo/nitro/unistyles/UnistylesNativeMiniRuntime;", "", "colorScheme", "Lcom/margelo/nitro/unistyles/ColorScheme;", "screen", "Lcom/margelo/nitro/unistyles/Dimensions;", "contentSizeCategory", "", "insets", "Lcom/margelo/nitro/unistyles/Insets;", "pixelRatio", "", "fontScale", "rtl", "", "statusBar", "navigationBar", "isPortrait", "isLandscape", "<init>", "(Lcom/margelo/nitro/unistyles/ColorScheme;Lcom/margelo/nitro/unistyles/Dimensions;Ljava/lang/String;Lcom/margelo/nitro/unistyles/Insets;DDZLcom/margelo/nitro/unistyles/Dimensions;Lcom/margelo/nitro/unistyles/Dimensions;ZZ)V", "getColorScheme", "()Lcom/margelo/nitro/unistyles/ColorScheme;", "getScreen", "()Lcom/margelo/nitro/unistyles/Dimensions;", "getContentSizeCategory", "()Ljava/lang/String;", "getInsets", "()Lcom/margelo/nitro/unistyles/Insets;", "getPixelRatio", "()D", "getFontScale", "getRtl", "()Z", "getStatusBar", "getNavigationBar", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "toString", "Companion", "react-native-unistyles_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class UnistylesNativeMiniRuntime {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @DoNotStrip
    @Keep
    private final ColorScheme colorScheme;

    @DoNotStrip
    @Keep
    private final String contentSizeCategory;

    @DoNotStrip
    @Keep
    private final double fontScale;

    @DoNotStrip
    @Keep
    private final Insets insets;

    @DoNotStrip
    @Keep
    private final boolean isLandscape;

    @DoNotStrip
    @Keep
    private final boolean isPortrait;

    @DoNotStrip
    @Keep
    private final Dimensions navigationBar;

    @DoNotStrip
    @Keep
    private final double pixelRatio;

    @DoNotStrip
    @Keep
    private final boolean rtl;

    @DoNotStrip
    @Keep
    private final Dimensions screen;

    @DoNotStrip
    @Keep
    private final Dimensions statusBar;

    public static /* synthetic */ UnistylesNativeMiniRuntime copy$default(UnistylesNativeMiniRuntime unistylesNativeMiniRuntime, ColorScheme colorScheme, Dimensions dimensions, String str, Insets insets, double d, double d2, boolean z, Dimensions dimensions2, Dimensions dimensions3, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            colorScheme = unistylesNativeMiniRuntime.colorScheme;
        }
        return unistylesNativeMiniRuntime.copy(colorScheme, (i & 2) != 0 ? unistylesNativeMiniRuntime.screen : dimensions, (i & 4) != 0 ? unistylesNativeMiniRuntime.contentSizeCategory : str, (i & 8) != 0 ? unistylesNativeMiniRuntime.insets : insets, (i & 16) != 0 ? unistylesNativeMiniRuntime.pixelRatio : d, (i & 32) != 0 ? unistylesNativeMiniRuntime.fontScale : d2, (i & 64) != 0 ? unistylesNativeMiniRuntime.rtl : z, (i & 128) != 0 ? unistylesNativeMiniRuntime.statusBar : dimensions2, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? unistylesNativeMiniRuntime.navigationBar : dimensions3, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? unistylesNativeMiniRuntime.isPortrait : z2, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? unistylesNativeMiniRuntime.isLandscape : z3);
    }

    @DoNotStrip
    @Keep
    private static final UnistylesNativeMiniRuntime fromCpp(ColorScheme colorScheme, Dimensions dimensions, String str, Insets insets, double d, double d2, boolean z, Dimensions dimensions2, Dimensions dimensions3, boolean z2, boolean z3) {
        return INSTANCE.fromCpp(colorScheme, dimensions, str, insets, d, d2, z, dimensions2, dimensions3, z2, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ColorScheme getColorScheme() {
        return this.colorScheme;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getIsPortrait() {
        return this.isPortrait;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getIsLandscape() {
        return this.isLandscape;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Dimensions getScreen() {
        return this.screen;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getContentSizeCategory() {
        return this.contentSizeCategory;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Insets getInsets() {
        return this.insets;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final double getPixelRatio() {
        return this.pixelRatio;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final double getFontScale() {
        return this.fontScale;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getRtl() {
        return this.rtl;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Dimensions getStatusBar() {
        return this.statusBar;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Dimensions getNavigationBar() {
        return this.navigationBar;
    }

    public final UnistylesNativeMiniRuntime copy(ColorScheme colorScheme, Dimensions screen, String contentSizeCategory, Insets insets, double pixelRatio, double fontScale, boolean rtl, Dimensions statusBar, Dimensions navigationBar, boolean isPortrait, boolean isLandscape) {
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        Intrinsics.checkNotNullParameter(screen, "screen");
        Intrinsics.checkNotNullParameter(contentSizeCategory, "contentSizeCategory");
        Intrinsics.checkNotNullParameter(insets, "insets");
        Intrinsics.checkNotNullParameter(statusBar, "statusBar");
        Intrinsics.checkNotNullParameter(navigationBar, "navigationBar");
        return new UnistylesNativeMiniRuntime(colorScheme, screen, contentSizeCategory, insets, pixelRatio, fontScale, rtl, statusBar, navigationBar, isPortrait, isLandscape);
    }

    public String toString() {
        return "UnistylesNativeMiniRuntime(colorScheme=" + this.colorScheme + ", screen=" + this.screen + ", contentSizeCategory=" + this.contentSizeCategory + ", insets=" + this.insets + ", pixelRatio=" + this.pixelRatio + ", fontScale=" + this.fontScale + ", rtl=" + this.rtl + ", statusBar=" + this.statusBar + ", navigationBar=" + this.navigationBar + ", isPortrait=" + this.isPortrait + ", isLandscape=" + this.isLandscape + ")";
    }

    public UnistylesNativeMiniRuntime(ColorScheme colorScheme, Dimensions screen, String contentSizeCategory, Insets insets, double d, double d2, boolean z, Dimensions statusBar, Dimensions navigationBar, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        Intrinsics.checkNotNullParameter(screen, "screen");
        Intrinsics.checkNotNullParameter(contentSizeCategory, "contentSizeCategory");
        Intrinsics.checkNotNullParameter(insets, "insets");
        Intrinsics.checkNotNullParameter(statusBar, "statusBar");
        Intrinsics.checkNotNullParameter(navigationBar, "navigationBar");
        this.colorScheme = colorScheme;
        this.screen = screen;
        this.contentSizeCategory = contentSizeCategory;
        this.insets = insets;
        this.pixelRatio = d;
        this.fontScale = d2;
        this.rtl = z;
        this.statusBar = statusBar;
        this.navigationBar = navigationBar;
        this.isPortrait = z2;
        this.isLandscape = z3;
    }

    public final ColorScheme getColorScheme() {
        return this.colorScheme;
    }

    public final Dimensions getScreen() {
        return this.screen;
    }

    public final String getContentSizeCategory() {
        return this.contentSizeCategory;
    }

    public final Insets getInsets() {
        return this.insets;
    }

    public final double getPixelRatio() {
        return this.pixelRatio;
    }

    public final double getFontScale() {
        return this.fontScale;
    }

    public final boolean getRtl() {
        return this.rtl;
    }

    public final Dimensions getStatusBar() {
        return this.statusBar;
    }

    public final Dimensions getNavigationBar() {
        return this.navigationBar;
    }

    public final boolean isPortrait() {
        return this.isPortrait;
    }

    public final boolean isLandscape() {
        return this.isLandscape;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UnistylesNativeMiniRuntime)) {
            return false;
        }
        UnistylesNativeMiniRuntime unistylesNativeMiniRuntime = (UnistylesNativeMiniRuntime) other;
        return Objects.deepEquals(this.colorScheme, unistylesNativeMiniRuntime.colorScheme) && Objects.deepEquals(this.screen, unistylesNativeMiniRuntime.screen) && Objects.deepEquals(this.contentSizeCategory, unistylesNativeMiniRuntime.contentSizeCategory) && Objects.deepEquals(this.insets, unistylesNativeMiniRuntime.insets) && Objects.deepEquals(Double.valueOf(this.pixelRatio), Double.valueOf(unistylesNativeMiniRuntime.pixelRatio)) && Objects.deepEquals(Double.valueOf(this.fontScale), Double.valueOf(unistylesNativeMiniRuntime.fontScale)) && Objects.deepEquals(Boolean.valueOf(this.rtl), Boolean.valueOf(unistylesNativeMiniRuntime.rtl)) && Objects.deepEquals(this.statusBar, unistylesNativeMiniRuntime.statusBar) && Objects.deepEquals(this.navigationBar, unistylesNativeMiniRuntime.navigationBar) && Objects.deepEquals(Boolean.valueOf(this.isPortrait), Boolean.valueOf(unistylesNativeMiniRuntime.isPortrait)) && Objects.deepEquals(Boolean.valueOf(this.isLandscape), Boolean.valueOf(unistylesNativeMiniRuntime.isLandscape));
    }

    public int hashCode() {
        return ArraysKt.contentDeepHashCode(new Object[]{this.colorScheme, this.screen, this.contentSizeCategory, this.insets, Double.valueOf(this.pixelRatio), Double.valueOf(this.fontScale), Boolean.valueOf(this.rtl), this.statusBar, this.navigationBar, Boolean.valueOf(this.isPortrait), Boolean.valueOf(this.isLandscape)});
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J`\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0012H\u0003¨\u0006\u0017"}, d2 = {"Lcom/margelo/nitro/unistyles/UnistylesNativeMiniRuntime$Companion;", "", "<init>", "()V", "fromCpp", "Lcom/margelo/nitro/unistyles/UnistylesNativeMiniRuntime;", "colorScheme", "Lcom/margelo/nitro/unistyles/ColorScheme;", "screen", "Lcom/margelo/nitro/unistyles/Dimensions;", "contentSizeCategory", "", "insets", "Lcom/margelo/nitro/unistyles/Insets;", "pixelRatio", "", "fontScale", "rtl", "", "statusBar", "navigationBar", "isPortrait", "isLandscape", "react-native-unistyles_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @DoNotStrip
        @Keep
        public final UnistylesNativeMiniRuntime fromCpp(ColorScheme colorScheme, Dimensions screen, String contentSizeCategory, Insets insets, double pixelRatio, double fontScale, boolean rtl, Dimensions statusBar, Dimensions navigationBar, boolean isPortrait, boolean isLandscape) {
            return new UnistylesNativeMiniRuntime(colorScheme, screen, contentSizeCategory, insets, pixelRatio, fontScale, rtl, statusBar, navigationBar, isPortrait, isLandscape);
        }
    }
}
