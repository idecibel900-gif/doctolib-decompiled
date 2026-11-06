package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.internal.http2.Http2;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: loaded from: classes.dex */
public final class ColorScheme {
    private final long background;
    private ButtonColors defaultButtonColorsCached;
    private IconButtonColors defaultIconButtonColorsCached;
    private TopAppBarColors defaultLargeTopAppBarColorsCached;
    private ButtonColors defaultOutlinedButtonColorsCached;
    private TextFieldColors defaultOutlinedTextFieldColorsCached;
    private ButtonColors defaultTextButtonColorsCached;
    private TopAppBarColors defaultTopAppBarColorsCached;
    private final long error;
    private final long errorContainer;
    private final long inverseOnSurface;
    private final long inversePrimary;
    private final long inverseSurface;
    private final long onBackground;
    private final long onError;
    private final long onErrorContainer;
    private final long onPrimary;
    private final long onPrimaryContainer;
    private final long onSecondary;
    private final long onSecondaryContainer;
    private final long onSurface;
    private final long onSurfaceVariant;
    private final long onTertiary;
    private final long onTertiaryContainer;
    private final long outline;
    private final long outlineVariant;
    private final long primary;
    private final long primaryContainer;
    private final long scrim;
    private final long secondary;
    private final long secondaryContainer;
    private final long surface;
    private final long surfaceBright;
    private final long surfaceContainer;
    private final long surfaceContainerHigh;
    private final long surfaceContainerHighest;
    private final long surfaceContainerLow;
    private final long surfaceContainerLowest;
    private final long surfaceDim;
    private final long surfaceTint;
    private final long surfaceVariant;
    private final long tertiary;
    private final long tertiaryContainer;

    public /* synthetic */ ColorScheme(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30, j31, j32, j33, j34, j35, j36);
    }

    public /* synthetic */ ColorScheme(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29);
    }

    private ColorScheme(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36) {
        this.primary = j;
        this.onPrimary = j2;
        this.primaryContainer = j3;
        this.onPrimaryContainer = j4;
        this.inversePrimary = j5;
        this.secondary = j6;
        this.onSecondary = j7;
        this.secondaryContainer = j8;
        this.onSecondaryContainer = j9;
        this.tertiary = j10;
        this.onTertiary = j11;
        this.tertiaryContainer = j12;
        this.onTertiaryContainer = j13;
        this.background = j14;
        this.onBackground = j15;
        this.surface = j16;
        this.onSurface = j17;
        this.surfaceVariant = j18;
        this.onSurfaceVariant = j19;
        this.surfaceTint = j20;
        this.inverseSurface = j21;
        this.inverseOnSurface = j22;
        this.error = j23;
        this.onError = j24;
        this.errorContainer = j25;
        this.onErrorContainer = j26;
        this.outline = j27;
        this.outlineVariant = j28;
        this.scrim = j29;
        this.surfaceBright = j30;
        this.surfaceDim = j31;
        this.surfaceContainer = j32;
        this.surfaceContainerHigh = j33;
        this.surfaceContainerHighest = j34;
        this.surfaceContainerLow = j35;
        this.surfaceContainerLowest = j36;
    }

    /* JADX INFO: renamed from: getPrimary-0d7_KjU, reason: not valid java name */
    public final long m735getPrimary0d7_KjU() {
        return this.primary;
    }

    /* JADX INFO: renamed from: getOnPrimary-0d7_KjU, reason: not valid java name */
    public final long m725getOnPrimary0d7_KjU() {
        return this.onPrimary;
    }

    /* JADX INFO: renamed from: getPrimaryContainer-0d7_KjU, reason: not valid java name */
    public final long m736getPrimaryContainer0d7_KjU() {
        return this.primaryContainer;
    }

    /* JADX INFO: renamed from: getOnPrimaryContainer-0d7_KjU, reason: not valid java name */
    public final long m726getOnPrimaryContainer0d7_KjU() {
        return this.onPrimaryContainer;
    }

    /* JADX INFO: renamed from: getInversePrimary-0d7_KjU, reason: not valid java name */
    public final long m720getInversePrimary0d7_KjU() {
        return this.inversePrimary;
    }

    /* JADX INFO: renamed from: getSecondary-0d7_KjU, reason: not valid java name */
    public final long m738getSecondary0d7_KjU() {
        return this.secondary;
    }

    /* JADX INFO: renamed from: getOnSecondary-0d7_KjU, reason: not valid java name */
    public final long m727getOnSecondary0d7_KjU() {
        return this.onSecondary;
    }

    /* JADX INFO: renamed from: getSecondaryContainer-0d7_KjU, reason: not valid java name */
    public final long m739getSecondaryContainer0d7_KjU() {
        return this.secondaryContainer;
    }

    /* JADX INFO: renamed from: getOnSecondaryContainer-0d7_KjU, reason: not valid java name */
    public final long m728getOnSecondaryContainer0d7_KjU() {
        return this.onSecondaryContainer;
    }

    /* JADX INFO: renamed from: getTertiary-0d7_KjU, reason: not valid java name */
    public final long m750getTertiary0d7_KjU() {
        return this.tertiary;
    }

    /* JADX INFO: renamed from: getOnTertiary-0d7_KjU, reason: not valid java name */
    public final long m731getOnTertiary0d7_KjU() {
        return this.onTertiary;
    }

    /* JADX INFO: renamed from: getTertiaryContainer-0d7_KjU, reason: not valid java name */
    public final long m751getTertiaryContainer0d7_KjU() {
        return this.tertiaryContainer;
    }

    /* JADX INFO: renamed from: getOnTertiaryContainer-0d7_KjU, reason: not valid java name */
    public final long m732getOnTertiaryContainer0d7_KjU() {
        return this.onTertiaryContainer;
    }

    /* JADX INFO: renamed from: getBackground-0d7_KjU, reason: not valid java name */
    public final long m716getBackground0d7_KjU() {
        return this.background;
    }

    /* JADX INFO: renamed from: getOnBackground-0d7_KjU, reason: not valid java name */
    public final long m722getOnBackground0d7_KjU() {
        return this.onBackground;
    }

    /* JADX INFO: renamed from: getSurface-0d7_KjU, reason: not valid java name */
    public final long m740getSurface0d7_KjU() {
        return this.surface;
    }

    /* JADX INFO: renamed from: getOnSurface-0d7_KjU, reason: not valid java name */
    public final long m729getOnSurface0d7_KjU() {
        return this.onSurface;
    }

    /* JADX INFO: renamed from: getSurfaceVariant-0d7_KjU, reason: not valid java name */
    public final long m749getSurfaceVariant0d7_KjU() {
        return this.surfaceVariant;
    }

    /* JADX INFO: renamed from: getOnSurfaceVariant-0d7_KjU, reason: not valid java name */
    public final long m730getOnSurfaceVariant0d7_KjU() {
        return this.onSurfaceVariant;
    }

    /* JADX INFO: renamed from: getSurfaceTint-0d7_KjU, reason: not valid java name */
    public final long m748getSurfaceTint0d7_KjU() {
        return this.surfaceTint;
    }

    /* JADX INFO: renamed from: getInverseSurface-0d7_KjU, reason: not valid java name */
    public final long m721getInverseSurface0d7_KjU() {
        return this.inverseSurface;
    }

    /* JADX INFO: renamed from: getInverseOnSurface-0d7_KjU, reason: not valid java name */
    public final long m719getInverseOnSurface0d7_KjU() {
        return this.inverseOnSurface;
    }

    /* JADX INFO: renamed from: getError-0d7_KjU, reason: not valid java name */
    public final long m717getError0d7_KjU() {
        return this.error;
    }

    /* JADX INFO: renamed from: getOnError-0d7_KjU, reason: not valid java name */
    public final long m723getOnError0d7_KjU() {
        return this.onError;
    }

    /* JADX INFO: renamed from: getErrorContainer-0d7_KjU, reason: not valid java name */
    public final long m718getErrorContainer0d7_KjU() {
        return this.errorContainer;
    }

    /* JADX INFO: renamed from: getOnErrorContainer-0d7_KjU, reason: not valid java name */
    public final long m724getOnErrorContainer0d7_KjU() {
        return this.onErrorContainer;
    }

    /* JADX INFO: renamed from: getOutline-0d7_KjU, reason: not valid java name */
    public final long m733getOutline0d7_KjU() {
        return this.outline;
    }

    /* JADX INFO: renamed from: getOutlineVariant-0d7_KjU, reason: not valid java name */
    public final long m734getOutlineVariant0d7_KjU() {
        return this.outlineVariant;
    }

    /* JADX INFO: renamed from: getScrim-0d7_KjU, reason: not valid java name */
    public final long m737getScrim0d7_KjU() {
        return this.scrim;
    }

    /* JADX INFO: renamed from: getSurfaceBright-0d7_KjU, reason: not valid java name */
    public final long m741getSurfaceBright0d7_KjU() {
        return this.surfaceBright;
    }

    /* JADX INFO: renamed from: getSurfaceDim-0d7_KjU, reason: not valid java name */
    public final long m747getSurfaceDim0d7_KjU() {
        return this.surfaceDim;
    }

    /* JADX INFO: renamed from: getSurfaceContainer-0d7_KjU, reason: not valid java name */
    public final long m742getSurfaceContainer0d7_KjU() {
        return this.surfaceContainer;
    }

    /* JADX INFO: renamed from: getSurfaceContainerHigh-0d7_KjU, reason: not valid java name */
    public final long m743getSurfaceContainerHigh0d7_KjU() {
        return this.surfaceContainerHigh;
    }

    /* JADX INFO: renamed from: getSurfaceContainerHighest-0d7_KjU, reason: not valid java name */
    public final long m744getSurfaceContainerHighest0d7_KjU() {
        return this.surfaceContainerHighest;
    }

    /* JADX INFO: renamed from: getSurfaceContainerLow-0d7_KjU, reason: not valid java name */
    public final long m745getSurfaceContainerLow0d7_KjU() {
        return this.surfaceContainerLow;
    }

    /* JADX INFO: renamed from: getSurfaceContainerLowest-0d7_KjU, reason: not valid java name */
    public final long m746getSurfaceContainerLowest0d7_KjU() {
        return this.surfaceContainerLowest;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private ColorScheme(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29) {
        Color.Companion companion = Color.Companion;
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, companion.m1385getUnspecified0d7_KjU(), companion.m1385getUnspecified0d7_KjU(), companion.m1385getUnspecified0d7_KjU(), companion.m1385getUnspecified0d7_KjU(), companion.m1385getUnspecified0d7_KjU(), companion.m1385getUnspecified0d7_KjU(), companion.m1385getUnspecified0d7_KjU(), null);
    }

    /* JADX INFO: renamed from: copy-C-Xl9yA$default, reason: not valid java name */
    public static /* synthetic */ ColorScheme m714copyCXl9yA$default(ColorScheme colorScheme, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, int i, int i2, Object obj) {
        long j37;
        long j38;
        long j39 = (i & 1) != 0 ? colorScheme.primary : j;
        long j40 = (i & 2) != 0 ? colorScheme.onPrimary : j2;
        long j41 = (i & 4) != 0 ? colorScheme.primaryContainer : j3;
        long j42 = (i & 8) != 0 ? colorScheme.onPrimaryContainer : j4;
        long j43 = (i & 16) != 0 ? colorScheme.inversePrimary : j5;
        long j44 = (i & 32) != 0 ? colorScheme.secondary : j6;
        long j45 = (i & 64) != 0 ? colorScheme.onSecondary : j7;
        long j46 = j39;
        long j47 = (i & 128) != 0 ? colorScheme.secondaryContainer : j8;
        long j48 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? colorScheme.onSecondaryContainer : j9;
        long j49 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? colorScheme.tertiary : j10;
        long j50 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? colorScheme.onTertiary : j11;
        long j51 = (i & 2048) != 0 ? colorScheme.tertiaryContainer : j12;
        long j52 = (i & 4096) != 0 ? colorScheme.onTertiaryContainer : j13;
        long j53 = (i & 8192) != 0 ? colorScheme.background : j14;
        long j54 = (i & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? colorScheme.onBackground : j15;
        long j55 = (i & 32768) != 0 ? colorScheme.surface : j16;
        long j56 = (i & 65536) != 0 ? colorScheme.onSurface : j17;
        long j57 = (i & 131072) != 0 ? colorScheme.surfaceVariant : j18;
        long j58 = (i & 262144) != 0 ? colorScheme.onSurfaceVariant : j19;
        long j59 = (i & 524288) != 0 ? colorScheme.surfaceTint : j20;
        long j60 = (i & 1048576) != 0 ? colorScheme.inverseSurface : j21;
        long j61 = (i & 2097152) != 0 ? colorScheme.inverseOnSurface : j22;
        long j62 = (i & 4194304) != 0 ? colorScheme.error : j23;
        long j63 = (i & 8388608) != 0 ? colorScheme.onError : j24;
        long j64 = (i & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? colorScheme.errorContainer : j25;
        long j65 = (i & 33554432) != 0 ? colorScheme.onErrorContainer : j26;
        long j66 = (i & 67108864) != 0 ? colorScheme.outline : j27;
        long j67 = (i & 134217728) != 0 ? colorScheme.outlineVariant : j28;
        long j68 = (i & 268435456) != 0 ? colorScheme.scrim : j29;
        long j69 = (i & 536870912) != 0 ? colorScheme.surfaceBright : j30;
        long j70 = (i & 1073741824) != 0 ? colorScheme.surfaceDim : j31;
        long j71 = (i & LinearLayoutManager.INVALID_OFFSET) != 0 ? colorScheme.surfaceContainer : j32;
        long j72 = (i2 & 1) != 0 ? colorScheme.surfaceContainerHigh : j33;
        long j73 = (i2 & 2) != 0 ? colorScheme.surfaceContainerHighest : j34;
        long j74 = (i2 & 4) != 0 ? colorScheme.surfaceContainerLow : j35;
        if ((i2 & 8) != 0) {
            j38 = j74;
            j37 = colorScheme.surfaceContainerLowest;
        } else {
            j37 = j36;
            j38 = j74;
        }
        return colorScheme.m715copyCXl9yA(j46, j40, j41, j42, j43, j44, j45, j47, j48, j49, j50, j51, j52, j53, j54, j55, j56, j57, j58, j59, j60, j61, j62, j63, j64, j65, j66, j67, j68, j69, j70, j71, j72, j73, j38, j37);
    }

    /* JADX INFO: renamed from: copy-C-Xl9yA, reason: not valid java name */
    public final ColorScheme m715copyCXl9yA(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36) {
        return new ColorScheme(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30, j31, j32, j33, j34, j35, j36, null);
    }

    public String toString() {
        return "ColorScheme(primary=" + ((Object) Color.m1374toStringimpl(this.primary)) + "onPrimary=" + ((Object) Color.m1374toStringimpl(this.onPrimary)) + "primaryContainer=" + ((Object) Color.m1374toStringimpl(this.primaryContainer)) + "onPrimaryContainer=" + ((Object) Color.m1374toStringimpl(this.onPrimaryContainer)) + "inversePrimary=" + ((Object) Color.m1374toStringimpl(this.inversePrimary)) + "secondary=" + ((Object) Color.m1374toStringimpl(this.secondary)) + "onSecondary=" + ((Object) Color.m1374toStringimpl(this.onSecondary)) + "secondaryContainer=" + ((Object) Color.m1374toStringimpl(this.secondaryContainer)) + "onSecondaryContainer=" + ((Object) Color.m1374toStringimpl(this.onSecondaryContainer)) + "tertiary=" + ((Object) Color.m1374toStringimpl(this.tertiary)) + "onTertiary=" + ((Object) Color.m1374toStringimpl(this.onTertiary)) + "tertiaryContainer=" + ((Object) Color.m1374toStringimpl(this.tertiaryContainer)) + "onTertiaryContainer=" + ((Object) Color.m1374toStringimpl(this.onTertiaryContainer)) + "background=" + ((Object) Color.m1374toStringimpl(this.background)) + "onBackground=" + ((Object) Color.m1374toStringimpl(this.onBackground)) + "surface=" + ((Object) Color.m1374toStringimpl(this.surface)) + "onSurface=" + ((Object) Color.m1374toStringimpl(this.onSurface)) + "surfaceVariant=" + ((Object) Color.m1374toStringimpl(this.surfaceVariant)) + "onSurfaceVariant=" + ((Object) Color.m1374toStringimpl(this.onSurfaceVariant)) + "surfaceTint=" + ((Object) Color.m1374toStringimpl(this.surfaceTint)) + "inverseSurface=" + ((Object) Color.m1374toStringimpl(this.inverseSurface)) + "inverseOnSurface=" + ((Object) Color.m1374toStringimpl(this.inverseOnSurface)) + "error=" + ((Object) Color.m1374toStringimpl(this.error)) + "onError=" + ((Object) Color.m1374toStringimpl(this.onError)) + "errorContainer=" + ((Object) Color.m1374toStringimpl(this.errorContainer)) + "onErrorContainer=" + ((Object) Color.m1374toStringimpl(this.onErrorContainer)) + "outline=" + ((Object) Color.m1374toStringimpl(this.outline)) + "outlineVariant=" + ((Object) Color.m1374toStringimpl(this.outlineVariant)) + "scrim=" + ((Object) Color.m1374toStringimpl(this.scrim)) + "surfaceBright=" + ((Object) Color.m1374toStringimpl(this.surfaceBright)) + "surfaceDim=" + ((Object) Color.m1374toStringimpl(this.surfaceDim)) + "surfaceContainer=" + ((Object) Color.m1374toStringimpl(this.surfaceContainer)) + "surfaceContainerHigh=" + ((Object) Color.m1374toStringimpl(this.surfaceContainerHigh)) + "surfaceContainerHighest=" + ((Object) Color.m1374toStringimpl(this.surfaceContainerHighest)) + "surfaceContainerLow=" + ((Object) Color.m1374toStringimpl(this.surfaceContainerLow)) + "surfaceContainerLowest=" + ((Object) Color.m1374toStringimpl(this.surfaceContainerLowest)) + ')';
    }

    public final ButtonColors getDefaultButtonColorsCached$material3_release() {
        return this.defaultButtonColorsCached;
    }

    public final void setDefaultButtonColorsCached$material3_release(ButtonColors buttonColors) {
        this.defaultButtonColorsCached = buttonColors;
    }

    public final ButtonColors getDefaultOutlinedButtonColorsCached$material3_release() {
        return this.defaultOutlinedButtonColorsCached;
    }

    public final void setDefaultOutlinedButtonColorsCached$material3_release(ButtonColors buttonColors) {
        this.defaultOutlinedButtonColorsCached = buttonColors;
    }

    public final ButtonColors getDefaultTextButtonColorsCached$material3_release() {
        return this.defaultTextButtonColorsCached;
    }

    public final void setDefaultTextButtonColorsCached$material3_release(ButtonColors buttonColors) {
        this.defaultTextButtonColorsCached = buttonColors;
    }

    public final TopAppBarColors getDefaultTopAppBarColorsCached$material3_release() {
        return this.defaultTopAppBarColorsCached;
    }

    public final void setDefaultTopAppBarColorsCached$material3_release(TopAppBarColors topAppBarColors) {
        this.defaultTopAppBarColorsCached = topAppBarColors;
    }

    public final TopAppBarColors getDefaultLargeTopAppBarColorsCached$material3_release() {
        return this.defaultLargeTopAppBarColorsCached;
    }

    public final void setDefaultLargeTopAppBarColorsCached$material3_release(TopAppBarColors topAppBarColors) {
        this.defaultLargeTopAppBarColorsCached = topAppBarColors;
    }

    public final IconButtonColors getDefaultIconButtonColorsCached$material3_release() {
        return this.defaultIconButtonColorsCached;
    }

    public final void setDefaultIconButtonColorsCached$material3_release(IconButtonColors iconButtonColors) {
        this.defaultIconButtonColorsCached = iconButtonColors;
    }

    public final TextFieldColors getDefaultOutlinedTextFieldColorsCached$material3_release() {
        return this.defaultOutlinedTextFieldColorsCached;
    }

    public final void setDefaultOutlinedTextFieldColorsCached$material3_release(TextFieldColors textFieldColors) {
        this.defaultOutlinedTextFieldColorsCached = textFieldColors;
    }
}
