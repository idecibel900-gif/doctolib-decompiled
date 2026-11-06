package androidx.compose.material3.tokens;

import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.GenericFontFamily;

/* JADX INFO: loaded from: classes.dex */
public final class TypographyTokens {
    private static final TextStyle BodyLarge;
    private static final TextStyle BodyMedium;
    private static final TextStyle BodySmall;
    private static final TextStyle DisplayLarge;
    private static final TextStyle DisplayMedium;
    private static final TextStyle DisplaySmall;
    private static final TextStyle HeadlineLarge;
    private static final TextStyle HeadlineMedium;
    private static final TextStyle HeadlineSmall;
    public static final TypographyTokens INSTANCE = new TypographyTokens();
    private static final TextStyle LabelLarge;
    private static final TextStyle LabelMedium;
    private static final TextStyle LabelSmall;
    private static final TextStyle TitleLarge;
    private static final TextStyle TitleMedium;
    private static final TextStyle TitleSmall;

    private TypographyTokens() {
    }

    public final TextStyle getBodyLarge() {
        return BodyLarge;
    }

    static {
        TextStyle defaultTextStyle = TypographyTokensKt.getDefaultTextStyle();
        TypeScaleTokens typeScaleTokens = TypeScaleTokens.INSTANCE;
        GenericFontFamily bodyLargeFont = typeScaleTokens.getBodyLargeFont();
        BodyLarge = TextStyle.m2226copyp1EtxEg$default(defaultTextStyle, 0L, typeScaleTokens.m1017getBodyLargeSizeXSAIIZE(), typeScaleTokens.getBodyLargeWeight(), null, null, bodyLargeFont, null, typeScaleTokens.m1018getBodyLargeTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, typeScaleTokens.m1016getBodyLargeLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle2 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily bodyMediumFont = typeScaleTokens.getBodyMediumFont();
        BodyMedium = TextStyle.m2226copyp1EtxEg$default(defaultTextStyle2, 0L, typeScaleTokens.m1020getBodyMediumSizeXSAIIZE(), typeScaleTokens.getBodyMediumWeight(), null, null, bodyMediumFont, null, typeScaleTokens.m1021getBodyMediumTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, typeScaleTokens.m1019getBodyMediumLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle3 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily bodySmallFont = typeScaleTokens.getBodySmallFont();
        BodySmall = TextStyle.m2226copyp1EtxEg$default(defaultTextStyle3, 0L, typeScaleTokens.m1023getBodySmallSizeXSAIIZE(), typeScaleTokens.getBodySmallWeight(), null, null, bodySmallFont, null, typeScaleTokens.m1024getBodySmallTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, typeScaleTokens.m1022getBodySmallLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle4 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily displayLargeFont = typeScaleTokens.getDisplayLargeFont();
        DisplayLarge = TextStyle.m2226copyp1EtxEg$default(defaultTextStyle4, 0L, typeScaleTokens.m1026getDisplayLargeSizeXSAIIZE(), typeScaleTokens.getDisplayLargeWeight(), null, null, displayLargeFont, null, typeScaleTokens.m1027getDisplayLargeTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, typeScaleTokens.m1025getDisplayLargeLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle5 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily displayMediumFont = typeScaleTokens.getDisplayMediumFont();
        DisplayMedium = TextStyle.m2226copyp1EtxEg$default(defaultTextStyle5, 0L, typeScaleTokens.m1029getDisplayMediumSizeXSAIIZE(), typeScaleTokens.getDisplayMediumWeight(), null, null, displayMediumFont, null, typeScaleTokens.m1030getDisplayMediumTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, typeScaleTokens.m1028getDisplayMediumLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle6 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily displaySmallFont = typeScaleTokens.getDisplaySmallFont();
        DisplaySmall = TextStyle.m2226copyp1EtxEg$default(defaultTextStyle6, 0L, typeScaleTokens.m1032getDisplaySmallSizeXSAIIZE(), typeScaleTokens.getDisplaySmallWeight(), null, null, displaySmallFont, null, typeScaleTokens.m1033getDisplaySmallTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, typeScaleTokens.m1031getDisplaySmallLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle7 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily headlineLargeFont = typeScaleTokens.getHeadlineLargeFont();
        HeadlineLarge = TextStyle.m2226copyp1EtxEg$default(defaultTextStyle7, 0L, typeScaleTokens.m1035getHeadlineLargeSizeXSAIIZE(), typeScaleTokens.getHeadlineLargeWeight(), null, null, headlineLargeFont, null, typeScaleTokens.m1036getHeadlineLargeTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, typeScaleTokens.m1034getHeadlineLargeLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle8 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily headlineMediumFont = typeScaleTokens.getHeadlineMediumFont();
        HeadlineMedium = TextStyle.m2226copyp1EtxEg$default(defaultTextStyle8, 0L, typeScaleTokens.m1038getHeadlineMediumSizeXSAIIZE(), typeScaleTokens.getHeadlineMediumWeight(), null, null, headlineMediumFont, null, typeScaleTokens.m1039getHeadlineMediumTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, typeScaleTokens.m1037getHeadlineMediumLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle9 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily headlineSmallFont = typeScaleTokens.getHeadlineSmallFont();
        HeadlineSmall = TextStyle.m2226copyp1EtxEg$default(defaultTextStyle9, 0L, typeScaleTokens.m1041getHeadlineSmallSizeXSAIIZE(), typeScaleTokens.getHeadlineSmallWeight(), null, null, headlineSmallFont, null, typeScaleTokens.m1042getHeadlineSmallTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, typeScaleTokens.m1040getHeadlineSmallLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle10 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily labelLargeFont = typeScaleTokens.getLabelLargeFont();
        LabelLarge = TextStyle.m2226copyp1EtxEg$default(defaultTextStyle10, 0L, typeScaleTokens.m1044getLabelLargeSizeXSAIIZE(), typeScaleTokens.getLabelLargeWeight(), null, null, labelLargeFont, null, typeScaleTokens.m1045getLabelLargeTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, typeScaleTokens.m1043getLabelLargeLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle11 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily labelMediumFont = typeScaleTokens.getLabelMediumFont();
        LabelMedium = TextStyle.m2226copyp1EtxEg$default(defaultTextStyle11, 0L, typeScaleTokens.m1047getLabelMediumSizeXSAIIZE(), typeScaleTokens.getLabelMediumWeight(), null, null, labelMediumFont, null, typeScaleTokens.m1048getLabelMediumTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, typeScaleTokens.m1046getLabelMediumLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle12 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily labelSmallFont = typeScaleTokens.getLabelSmallFont();
        LabelSmall = TextStyle.m2226copyp1EtxEg$default(defaultTextStyle12, 0L, typeScaleTokens.m1050getLabelSmallSizeXSAIIZE(), typeScaleTokens.getLabelSmallWeight(), null, null, labelSmallFont, null, typeScaleTokens.m1051getLabelSmallTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, typeScaleTokens.m1049getLabelSmallLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle13 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily titleLargeFont = typeScaleTokens.getTitleLargeFont();
        TitleLarge = TextStyle.m2226copyp1EtxEg$default(defaultTextStyle13, 0L, typeScaleTokens.m1053getTitleLargeSizeXSAIIZE(), typeScaleTokens.getTitleLargeWeight(), null, null, titleLargeFont, null, typeScaleTokens.m1054getTitleLargeTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, typeScaleTokens.m1052getTitleLargeLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle14 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily titleMediumFont = typeScaleTokens.getTitleMediumFont();
        TitleMedium = TextStyle.m2226copyp1EtxEg$default(defaultTextStyle14, 0L, typeScaleTokens.m1056getTitleMediumSizeXSAIIZE(), typeScaleTokens.getTitleMediumWeight(), null, null, titleMediumFont, null, typeScaleTokens.m1057getTitleMediumTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, typeScaleTokens.m1055getTitleMediumLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
        TextStyle defaultTextStyle15 = TypographyTokensKt.getDefaultTextStyle();
        GenericFontFamily titleSmallFont = typeScaleTokens.getTitleSmallFont();
        TitleSmall = TextStyle.m2226copyp1EtxEg$default(defaultTextStyle15, 0L, typeScaleTokens.m1059getTitleSmallSizeXSAIIZE(), typeScaleTokens.getTitleSmallWeight(), null, null, titleSmallFont, null, typeScaleTokens.m1060getTitleSmallTrackingXSAIIZE(), null, null, null, 0L, null, null, null, 0, 0, typeScaleTokens.m1058getTitleSmallLineHeightXSAIIZE(), null, null, null, 0, 0, null, 16645977, null);
    }

    public final TextStyle getBodyMedium() {
        return BodyMedium;
    }

    public final TextStyle getBodySmall() {
        return BodySmall;
    }

    public final TextStyle getDisplayLarge() {
        return DisplayLarge;
    }

    public final TextStyle getDisplayMedium() {
        return DisplayMedium;
    }

    public final TextStyle getDisplaySmall() {
        return DisplaySmall;
    }

    public final TextStyle getHeadlineLarge() {
        return HeadlineLarge;
    }

    public final TextStyle getHeadlineMedium() {
        return HeadlineMedium;
    }

    public final TextStyle getHeadlineSmall() {
        return HeadlineSmall;
    }

    public final TextStyle getLabelLarge() {
        return LabelLarge;
    }

    public final TextStyle getLabelMedium() {
        return LabelMedium;
    }

    public final TextStyle getLabelSmall() {
        return LabelSmall;
    }

    public final TextStyle getTitleLarge() {
        return TitleLarge;
    }

    public final TextStyle getTitleMedium() {
        return TitleMedium;
    }

    public final TextStyle getTitleSmall() {
        return TitleSmall;
    }
}
