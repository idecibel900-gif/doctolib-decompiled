package androidx.compose.ui.text.style;

import androidx.compose.ui.text.SpanStyleKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class TextIndentKt {
    public static final TextIndent lerp(TextIndent textIndent, TextIndent textIndent2, float f) {
        return new TextIndent(SpanStyleKt.m2193lerpTextUnitInheritableC3pnCVY(textIndent.m2503getFirstLineXSAIIZE(), textIndent2.m2503getFirstLineXSAIIZE(), f), SpanStyleKt.m2193lerpTextUnitInheritableC3pnCVY(textIndent.m2504getRestLineXSAIIZE(), textIndent2.m2504getRestLineXSAIIZE(), f), null);
    }
}
