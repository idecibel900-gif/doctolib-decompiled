package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;

/* JADX INFO: loaded from: classes.dex */
public final class TextButtonTokens {
    private static final ColorSchemeKeyTokens DisabledIconColor;
    private static final ColorSchemeKeyTokens DisabledLabelTextColor;
    private static final ColorSchemeKeyTokens FocusIconColor;
    private static final ColorSchemeKeyTokens FocusLabelTextColor;
    private static final ColorSchemeKeyTokens HoverIconColor;
    private static final ColorSchemeKeyTokens HoverLabelTextColor;
    private static final ColorSchemeKeyTokens IconColor;
    private static final float IconSize;
    private static final ColorSchemeKeyTokens LabelTextColor;
    private static final TypographyKeyTokens LabelTextFont;
    private static final ColorSchemeKeyTokens PressedIconColor;
    private static final ColorSchemeKeyTokens PressedLabelTextColor;
    public static final TextButtonTokens INSTANCE = new TextButtonTokens();
    private static final float ContainerHeight = Dp.m2551constructorimpl((float) 40.0d);
    private static final ShapeKeyTokens ContainerShape = ShapeKeyTokens.CornerFull;

    private TextButtonTokens() {
    }

    public final ShapeKeyTokens getContainerShape() {
        return ContainerShape;
    }

    public final ColorSchemeKeyTokens getDisabledLabelTextColor() {
        return DisabledLabelTextColor;
    }

    public final ColorSchemeKeyTokens getLabelTextColor() {
        return LabelTextColor;
    }

    static {
        ColorSchemeKeyTokens colorSchemeKeyTokens = ColorSchemeKeyTokens.OnSurface;
        DisabledLabelTextColor = colorSchemeKeyTokens;
        ColorSchemeKeyTokens colorSchemeKeyTokens2 = ColorSchemeKeyTokens.Primary;
        FocusLabelTextColor = colorSchemeKeyTokens2;
        HoverLabelTextColor = colorSchemeKeyTokens2;
        LabelTextColor = colorSchemeKeyTokens2;
        LabelTextFont = TypographyKeyTokens.LabelLarge;
        PressedLabelTextColor = colorSchemeKeyTokens2;
        DisabledIconColor = colorSchemeKeyTokens;
        FocusIconColor = colorSchemeKeyTokens2;
        HoverIconColor = colorSchemeKeyTokens2;
        IconColor = colorSchemeKeyTokens2;
        IconSize = Dp.m2551constructorimpl((float) 18.0d);
        PressedIconColor = colorSchemeKeyTokens2;
    }
}
