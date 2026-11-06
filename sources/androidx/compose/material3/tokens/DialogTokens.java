package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;

/* JADX INFO: loaded from: classes.dex */
public final class DialogTokens {
    private static final ColorSchemeKeyTokens ActionFocusLabelTextColor;
    private static final ColorSchemeKeyTokens ActionHoverLabelTextColor;
    private static final ColorSchemeKeyTokens ActionLabelTextColor;
    private static final TypographyKeyTokens ActionLabelTextFont;
    private static final ColorSchemeKeyTokens ActionPressedLabelTextColor;
    private static final ColorSchemeKeyTokens ContainerColor;
    private static final float ContainerElevation;
    private static final ShapeKeyTokens ContainerShape;
    private static final ColorSchemeKeyTokens HeadlineColor;
    private static final TypographyKeyTokens HeadlineFont;
    public static final DialogTokens INSTANCE = new DialogTokens();
    private static final ColorSchemeKeyTokens IconColor;
    private static final float IconSize;
    private static final ColorSchemeKeyTokens SupportingTextColor;
    private static final TypographyKeyTokens SupportingTextFont;

    private DialogTokens() {
    }

    static {
        ColorSchemeKeyTokens colorSchemeKeyTokens = ColorSchemeKeyTokens.Primary;
        ActionFocusLabelTextColor = colorSchemeKeyTokens;
        ActionHoverLabelTextColor = colorSchemeKeyTokens;
        ActionLabelTextColor = colorSchemeKeyTokens;
        ActionLabelTextFont = TypographyKeyTokens.LabelLarge;
        ActionPressedLabelTextColor = colorSchemeKeyTokens;
        ContainerColor = ColorSchemeKeyTokens.SurfaceContainerHigh;
        ContainerElevation = ElevationTokens.INSTANCE.m946getLevel3D9Ej5fM();
        ContainerShape = ShapeKeyTokens.CornerExtraLarge;
        HeadlineColor = ColorSchemeKeyTokens.OnSurface;
        HeadlineFont = TypographyKeyTokens.HeadlineSmall;
        SupportingTextColor = ColorSchemeKeyTokens.OnSurfaceVariant;
        SupportingTextFont = TypographyKeyTokens.BodyMedium;
        IconColor = ColorSchemeKeyTokens.Secondary;
        IconSize = Dp.m2551constructorimpl((float) 24.0d);
    }

    public final ColorSchemeKeyTokens getActionLabelTextColor() {
        return ActionLabelTextColor;
    }

    public final TypographyKeyTokens getActionLabelTextFont() {
        return ActionLabelTextFont;
    }

    public final ColorSchemeKeyTokens getContainerColor() {
        return ContainerColor;
    }

    public final ShapeKeyTokens getContainerShape() {
        return ContainerShape;
    }

    public final ColorSchemeKeyTokens getHeadlineColor() {
        return HeadlineColor;
    }

    public final TypographyKeyTokens getHeadlineFont() {
        return HeadlineFont;
    }

    public final ColorSchemeKeyTokens getSupportingTextColor() {
        return SupportingTextColor;
    }

    public final TypographyKeyTokens getSupportingTextFont() {
        return SupportingTextFont;
    }

    public final ColorSchemeKeyTokens getIconColor() {
        return IconColor;
    }
}
