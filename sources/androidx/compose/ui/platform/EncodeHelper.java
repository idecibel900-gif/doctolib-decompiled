package androidx.compose.ui.platform;

import android.os.Parcel;
import android.util.Base64;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;

/* JADX INFO: loaded from: classes.dex */
public final class EncodeHelper {
    private Parcel parcel = Parcel.obtain();

    public final void reset() {
        this.parcel.recycle();
        this.parcel = Parcel.obtain();
    }

    public final String encodedString() {
        return Base64.encodeToString(this.parcel.marshall(), 0);
    }

    public final void encode(SpanStyle spanStyle) {
        long jM2187getColor0d7_KjU = spanStyle.m2187getColor0d7_KjU();
        Color.Companion companion = Color.Companion;
        if (!Color.m1367equalsimpl0(jM2187getColor0d7_KjU, companion.m1385getUnspecified0d7_KjU())) {
            encode((byte) 1);
            m2062encode8_81llA(spanStyle.m2187getColor0d7_KjU());
        }
        long jM2188getFontSizeXSAIIZE = spanStyle.m2188getFontSizeXSAIIZE();
        TextUnit.Companion companion2 = TextUnit.Companion;
        if (!TextUnit.m2619equalsimpl0(jM2188getFontSizeXSAIIZE, companion2.m2626getUnspecifiedXSAIIZE())) {
            encode((byte) 2);
            m2059encodeR2X_6o(spanStyle.m2188getFontSizeXSAIIZE());
        }
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight != null) {
            encode((byte) 3);
            encode(fontWeight);
        }
        FontStyle fontStyleM2189getFontStyle4Lr2A7w = spanStyle.m2189getFontStyle4Lr2A7w();
        if (fontStyleM2189getFontStyle4Lr2A7w != null) {
            int iM2287unboximpl = fontStyleM2189getFontStyle4Lr2A7w.m2287unboximpl();
            encode((byte) 4);
            m2064encodenzbMABs(iM2287unboximpl);
        }
        FontSynthesis fontSynthesisM2190getFontSynthesisZQGJjVo = spanStyle.m2190getFontSynthesisZQGJjVo();
        if (fontSynthesisM2190getFontSynthesisZQGJjVo != null) {
            int iM2298unboximpl = fontSynthesisM2190getFontSynthesisZQGJjVo.m2298unboximpl();
            encode((byte) 5);
            m2061encode6p3vJLY(iM2298unboximpl);
        }
        String fontFeatureSettings = spanStyle.getFontFeatureSettings();
        if (fontFeatureSettings != null) {
            encode((byte) 6);
            encode(fontFeatureSettings);
        }
        if (!TextUnit.m2619equalsimpl0(spanStyle.m2191getLetterSpacingXSAIIZE(), companion2.m2626getUnspecifiedXSAIIZE())) {
            encode((byte) 7);
            m2059encodeR2X_6o(spanStyle.m2191getLetterSpacingXSAIIZE());
        }
        BaselineShift baselineShiftM2186getBaselineShift5SSeXJ0 = spanStyle.m2186getBaselineShift5SSeXJ0();
        if (baselineShiftM2186getBaselineShift5SSeXJ0 != null) {
            float fM2414unboximpl = baselineShiftM2186getBaselineShift5SSeXJ0.m2414unboximpl();
            encode((byte) 8);
            m2060encode4Dl_Bck(fM2414unboximpl);
        }
        TextGeometricTransform textGeometricTransform = spanStyle.getTextGeometricTransform();
        if (textGeometricTransform != null) {
            encode((byte) 9);
            encode(textGeometricTransform);
        }
        if (!Color.m1367equalsimpl0(spanStyle.m2185getBackground0d7_KjU(), companion.m1385getUnspecified0d7_KjU())) {
            encode((byte) 10);
            m2062encode8_81llA(spanStyle.m2185getBackground0d7_KjU());
        }
        TextDecoration textDecoration = spanStyle.getTextDecoration();
        if (textDecoration != null) {
            encode((byte) 11);
            encode(textDecoration);
        }
        Shadow shadow = spanStyle.getShadow();
        if (shadow != null) {
            encode((byte) 12);
            encode(shadow);
        }
    }

    /* JADX INFO: renamed from: encode-8_81llA, reason: not valid java name */
    public final void m2062encode8_81llA(long j) {
        m2063encodeVKZWuLQ(j);
    }

    /* JADX INFO: renamed from: encode--R2X_6o, reason: not valid java name */
    public final void m2059encodeR2X_6o(long j) {
        long jM2621getTypeUIouoOA = TextUnit.m2621getTypeUIouoOA(j);
        TextUnitType.Companion companion = TextUnitType.Companion;
        byte b = 0;
        if (!TextUnitType.m2635equalsimpl0(jM2621getTypeUIouoOA, companion.m2641getUnspecifiedUIouoOA())) {
            if (TextUnitType.m2635equalsimpl0(jM2621getTypeUIouoOA, companion.m2640getSpUIouoOA())) {
                b = 1;
            } else if (TextUnitType.m2635equalsimpl0(jM2621getTypeUIouoOA, companion.m2639getEmUIouoOA())) {
                b = 2;
            }
        }
        encode(b);
        if (TextUnitType.m2635equalsimpl0(TextUnit.m2621getTypeUIouoOA(j), companion.m2641getUnspecifiedUIouoOA())) {
            return;
        }
        encode(TextUnit.m2622getValueimpl(j));
    }

    public final void encode(FontWeight fontWeight) {
        encode(fontWeight.getWeight());
    }

    /* JADX INFO: renamed from: encode-nzbMABs, reason: not valid java name */
    public final void m2064encodenzbMABs(int i) {
        FontStyle.Companion companion = FontStyle.Companion;
        byte b = 0;
        if (!FontStyle.m2284equalsimpl0(i, companion.m2289getNormal_LCdwA()) && FontStyle.m2284equalsimpl0(i, companion.m2288getItalic_LCdwA())) {
            b = 1;
        }
        encode(b);
    }

    /* JADX INFO: renamed from: encode-6p3vJLY, reason: not valid java name */
    public final void m2061encode6p3vJLY(int i) {
        FontSynthesis.Companion companion = FontSynthesis.Companion;
        byte b = 0;
        if (!FontSynthesis.m2293equalsimpl0(i, companion.m2300getNoneGVVA2EU())) {
            if (FontSynthesis.m2293equalsimpl0(i, companion.m2299getAllGVVA2EU())) {
                b = 1;
            } else if (FontSynthesis.m2293equalsimpl0(i, companion.m2302getWeightGVVA2EU())) {
                b = 2;
            } else if (FontSynthesis.m2293equalsimpl0(i, companion.m2301getStyleGVVA2EU())) {
                b = 3;
            }
        }
        encode(b);
    }

    /* JADX INFO: renamed from: encode-4Dl_Bck, reason: not valid java name */
    public final void m2060encode4Dl_Bck(float f) {
        encode(f);
    }

    public final void encode(TextGeometricTransform textGeometricTransform) {
        encode(textGeometricTransform.getScaleX());
        encode(textGeometricTransform.getSkewX());
    }

    public final void encode(TextDecoration textDecoration) {
        encode(textDecoration.getMask());
    }

    public final void encode(Shadow shadow) {
        m2062encode8_81llA(shadow.m1485getColor0d7_KjU());
        encode(Offset.m1223getXimpl(shadow.m1486getOffsetF1C5BW0()));
        encode(Offset.m1224getYimpl(shadow.m1486getOffsetF1C5BW0()));
        encode(shadow.getBlurRadius());
    }

    public final void encode(byte b) {
        this.parcel.writeByte(b);
    }

    public final void encode(int i) {
        this.parcel.writeInt(i);
    }

    public final void encode(float f) {
        this.parcel.writeFloat(f);
    }

    /* JADX INFO: renamed from: encode-VKZWuLQ, reason: not valid java name */
    public final void m2063encodeVKZWuLQ(long j) {
        this.parcel.writeLong(j);
    }

    public final void encode(String str) {
        this.parcel.writeString(str);
    }
}
