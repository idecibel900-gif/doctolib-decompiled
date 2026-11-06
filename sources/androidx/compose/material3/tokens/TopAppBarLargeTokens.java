package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;

/* JADX INFO: loaded from: classes.dex */
public final class TopAppBarLargeTokens {
    private static final ColorSchemeKeyTokens HeadlineColor;
    private static final TypographyKeyTokens HeadlineFont;
    private static final ColorSchemeKeyTokens LeadingIconColor;
    private static final float LeadingIconSize;
    private static final ColorSchemeKeyTokens TrailingIconColor;
    private static final float TrailingIconSize;
    public static final TopAppBarLargeTokens INSTANCE = new TopAppBarLargeTokens();
    private static final ColorSchemeKeyTokens ContainerColor = ColorSchemeKeyTokens.Surface;
    private static final float ContainerElevation = ElevationTokens.INSTANCE.m943getLevel0D9Ej5fM();
    private static final float ContainerHeight = Dp.m2551constructorimpl((float) 152.0d);
    private static final ShapeKeyTokens ContainerShape = ShapeKeyTokens.CornerNone;
    private static final ColorSchemeKeyTokens ContainerSurfaceTintLayerColor = ColorSchemeKeyTokens.SurfaceTint;

    private TopAppBarLargeTokens() {
    }

    static {
        ColorSchemeKeyTokens colorSchemeKeyTokens = ColorSchemeKeyTokens.OnSurface;
        HeadlineColor = colorSchemeKeyTokens;
        HeadlineFont = TypographyKeyTokens.HeadlineMedium;
        LeadingIconColor = colorSchemeKeyTokens;
        float f = (float) 24.0d;
        LeadingIconSize = Dp.m2551constructorimpl(f);
        TrailingIconColor = ColorSchemeKeyTokens.OnSurfaceVariant;
        TrailingIconSize = Dp.m2551constructorimpl(f);
    }

    public final ColorSchemeKeyTokens getContainerColor() {
        return ContainerColor;
    }

    /* JADX INFO: renamed from: getContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m1013getContainerHeightD9Ej5fM() {
        return ContainerHeight;
    }

    public final ColorSchemeKeyTokens getHeadlineColor() {
        return HeadlineColor;
    }

    public final TypographyKeyTokens getHeadlineFont() {
        return HeadlineFont;
    }

    public final ColorSchemeKeyTokens getLeadingIconColor() {
        return LeadingIconColor;
    }

    public final ColorSchemeKeyTokens getTrailingIconColor() {
        return TrailingIconColor;
    }
}
