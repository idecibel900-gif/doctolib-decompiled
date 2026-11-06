package androidx.compose.ui.text.style;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.SolidColor;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public interface TextForegroundStyle {
    public static final Companion Companion = Companion.$$INSTANCE;

    float getAlpha();

    Brush getBrush();

    /* JADX INFO: renamed from: getColor-0d7_KjU */
    long mo2417getColor0d7_KjU();

    default TextForegroundStyle merge(TextForegroundStyle textForegroundStyle) {
        boolean z = textForegroundStyle instanceof BrushStyle;
        if (z && (this instanceof BrushStyle)) {
            return new BrushStyle(((BrushStyle) textForegroundStyle).getValue(), TextDrawStyleKt.takeOrElse(textForegroundStyle.getAlpha(), new Function0() { // from class: androidx.compose.ui.text.style.TextForegroundStyle.merge.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Float invoke() {
                    return Float.valueOf(TextForegroundStyle.this.getAlpha());
                }
            }));
        }
        if (!z || (this instanceof BrushStyle)) {
            return (z || !(this instanceof BrushStyle)) ? textForegroundStyle.takeOrElse(new Function0() { // from class: androidx.compose.ui.text.style.TextForegroundStyle.merge.2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final TextForegroundStyle invoke() {
                    return TextForegroundStyle.this;
                }
            }) : this;
        }
        return textForegroundStyle;
    }

    default TextForegroundStyle takeOrElse(Function0 function0) {
        return !Intrinsics.areEqual(this, Unspecified.INSTANCE) ? this : (TextForegroundStyle) function0.invoke();
    }

    public static final class Unspecified implements TextForegroundStyle {
        public static final Unspecified INSTANCE = new Unspecified();

        @Override // androidx.compose.ui.text.style.TextForegroundStyle
        public float getAlpha() {
            return Float.NaN;
        }

        @Override // androidx.compose.ui.text.style.TextForegroundStyle
        public Brush getBrush() {
            return null;
        }

        private Unspecified() {
        }

        @Override // androidx.compose.ui.text.style.TextForegroundStyle
        /* JADX INFO: renamed from: getColor-0d7_KjU */
        public long mo2417getColor0d7_KjU() {
            return Color.Companion.m1385getUnspecified0d7_KjU();
        }
    }

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        /* JADX INFO: renamed from: from-8_81llA, reason: not valid java name */
        public final TextForegroundStyle m2502from8_81llA(long j) {
            return j != 16 ? new ColorStyle(j, null) : Unspecified.INSTANCE;
        }

        public final TextForegroundStyle from(Brush brush, float f) {
            if (brush == null) {
                return Unspecified.INSTANCE;
            }
            if (brush instanceof SolidColor) {
                return m2502from8_81llA(TextDrawStyleKt.m2501modulateDxMtmZc(((SolidColor) brush).m1495getValue0d7_KjU(), f));
            }
            if (brush instanceof ShaderBrush) {
                return new BrushStyle((ShaderBrush) brush, f);
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
