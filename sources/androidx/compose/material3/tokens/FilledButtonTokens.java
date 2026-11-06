package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;

/* JADX INFO: loaded from: classes.dex */
public final class FilledButtonTokens {
    private static final float ContainerElevation;
    private static final float ContainerHeight;
    private static final ShapeKeyTokens ContainerShape;
    private static final ColorSchemeKeyTokens DisabledContainerColor;
    private static final float DisabledContainerElevation;
    private static final ColorSchemeKeyTokens DisabledIconColor;
    private static final ColorSchemeKeyTokens DisabledLabelTextColor;
    private static final float FocusContainerElevation;
    private static final ColorSchemeKeyTokens FocusIconColor;
    private static final ColorSchemeKeyTokens FocusLabelTextColor;
    private static final float HoverContainerElevation;
    private static final ColorSchemeKeyTokens HoverIconColor;
    private static final ColorSchemeKeyTokens HoverLabelTextColor;
    private static final ColorSchemeKeyTokens IconColor;
    private static final float IconSize;
    private static final ColorSchemeKeyTokens LabelTextColor;
    private static final TypographyKeyTokens LabelTextFont;
    private static final float PressedContainerElevation;
    private static final ColorSchemeKeyTokens PressedIconColor;
    private static final ColorSchemeKeyTokens PressedLabelTextColor;
    public static final FilledButtonTokens INSTANCE = new FilledButtonTokens();
    private static final ColorSchemeKeyTokens ContainerColor = ColorSchemeKeyTokens.Primary;

    private FilledButtonTokens() {
    }

    static {
        ElevationTokens elevationTokens = ElevationTokens.INSTANCE;
        ContainerElevation = elevationTokens.m943getLevel0D9Ej5fM();
        ContainerHeight = Dp.m2551constructorimpl((float) 40.0d);
        ContainerShape = ShapeKeyTokens.CornerFull;
        ColorSchemeKeyTokens colorSchemeKeyTokens = ColorSchemeKeyTokens.OnSurface;
        DisabledContainerColor = colorSchemeKeyTokens;
        DisabledContainerElevation = elevationTokens.m943getLevel0D9Ej5fM();
        DisabledLabelTextColor = colorSchemeKeyTokens;
        FocusContainerElevation = elevationTokens.m943getLevel0D9Ej5fM();
        ColorSchemeKeyTokens colorSchemeKeyTokens2 = ColorSchemeKeyTokens.OnPrimary;
        FocusLabelTextColor = colorSchemeKeyTokens2;
        HoverContainerElevation = elevationTokens.m944getLevel1D9Ej5fM();
        HoverLabelTextColor = colorSchemeKeyTokens2;
        LabelTextColor = colorSchemeKeyTokens2;
        LabelTextFont = TypographyKeyTokens.LabelLarge;
        PressedContainerElevation = elevationTokens.m943getLevel0D9Ej5fM();
        PressedLabelTextColor = colorSchemeKeyTokens2;
        DisabledIconColor = colorSchemeKeyTokens;
        FocusIconColor = colorSchemeKeyTokens2;
        HoverIconColor = colorSchemeKeyTokens2;
        IconColor = colorSchemeKeyTokens2;
        IconSize = Dp.m2551constructorimpl((float) 18.0d);
        PressedIconColor = colorSchemeKeyTokens2;
    }

    public final ColorSchemeKeyTokens getContainerColor() {
        return ContainerColor;
    }

    /* JADX INFO: renamed from: getContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m947getContainerElevationD9Ej5fM() {
        return ContainerElevation;
    }

    public final ShapeKeyTokens getContainerShape() {
        return ContainerShape;
    }

    public final ColorSchemeKeyTokens getDisabledContainerColor() {
        return DisabledContainerColor;
    }

    /* JADX INFO: renamed from: getDisabledContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m948getDisabledContainerElevationD9Ej5fM() {
        return DisabledContainerElevation;
    }

    public final ColorSchemeKeyTokens getDisabledLabelTextColor() {
        return DisabledLabelTextColor;
    }

    /* JADX INFO: renamed from: getFocusContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m949getFocusContainerElevationD9Ej5fM() {
        return FocusContainerElevation;
    }

    /* JADX INFO: renamed from: getHoverContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m950getHoverContainerElevationD9Ej5fM() {
        return HoverContainerElevation;
    }

    public final ColorSchemeKeyTokens getLabelTextColor() {
        return LabelTextColor;
    }

    /* JADX INFO: renamed from: getPressedContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m952getPressedContainerElevationD9Ej5fM() {
        return PressedContainerElevation;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m951getIconSizeD9Ej5fM() {
        return IconSize;
    }
}
