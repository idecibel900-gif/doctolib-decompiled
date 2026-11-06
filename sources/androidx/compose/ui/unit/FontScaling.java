package androidx.compose.ui.unit;

import androidx.compose.ui.unit.fontscaling.FontScaleConverter;
import androidx.compose.ui.unit.fontscaling.FontScaleConverterFactory;

/* JADX INFO: loaded from: classes.dex */
public interface FontScaling {
    float getFontScale();

    /* JADX INFO: renamed from: toSp-0xMU5do */
    default long mo233toSp0xMU5do(float f) {
        FontScaleConverterFactory fontScaleConverterFactory = FontScaleConverterFactory.INSTANCE;
        if (!fontScaleConverterFactory.isNonLinearFontScalingActive(getFontScale())) {
            return TextUnitKt.getSp(f / getFontScale());
        }
        FontScaleConverter fontScaleConverterForScale = fontScaleConverterFactory.forScale(getFontScale());
        return TextUnitKt.getSp(fontScaleConverterForScale != null ? fontScaleConverterForScale.convertDpToSp(f) : f / getFontScale());
    }

    /* JADX INFO: renamed from: toDp-GaN1DYA */
    default float mo226toDpGaN1DYA(long j) {
        if (!TextUnitType.m2635equalsimpl0(TextUnit.m2621getTypeUIouoOA(j), TextUnitType.Companion.m2640getSpUIouoOA())) {
            InlineClassHelperKt.throwIllegalStateException("Only Sp can convert to Px");
        }
        FontScaleConverterFactory fontScaleConverterFactory = FontScaleConverterFactory.INSTANCE;
        if (!fontScaleConverterFactory.isNonLinearFontScalingActive(getFontScale())) {
            return Dp.m2551constructorimpl(TextUnit.m2622getValueimpl(j) * getFontScale());
        }
        FontScaleConverter fontScaleConverterForScale = fontScaleConverterFactory.forScale(getFontScale());
        float fM2622getValueimpl = TextUnit.m2622getValueimpl(j);
        return fontScaleConverterForScale == null ? Dp.m2551constructorimpl(fM2622getValueimpl * getFontScale()) : Dp.m2551constructorimpl(fontScaleConverterForScale.convertSpToDp(fM2622getValueimpl));
    }
}
