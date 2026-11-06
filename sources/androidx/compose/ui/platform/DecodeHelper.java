package androidx.compose.ui.platform;

import android.os.Parcel;
import android.util.Base64;
import androidx.compose.ui.geometry.OffsetKt;
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
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes.dex */
public final class DecodeHelper {
    private final Parcel parcel;

    public DecodeHelper(String str) {
        Parcel parcelObtain = Parcel.obtain();
        this.parcel = parcelObtain;
        byte[] bArrDecode = Base64.decode(str, 0);
        parcelObtain.unmarshall(bArrDecode, 0, bArrDecode.length);
        parcelObtain.setDataPosition(0);
    }

    public final SpanStyle decodeSpanStyle() {
        MutableSpanStyle mutableSpanStyle = new MutableSpanStyle(0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, 16383, null);
        while (this.parcel.dataAvail() > 1) {
            byte bDecodeByte = decodeByte();
            if (bDecodeByte != 1) {
                if (bDecodeByte != 2) {
                    if (bDecodeByte != 3) {
                        if (bDecodeByte != 4) {
                            if (bDecodeByte != 5) {
                                if (bDecodeByte != 6) {
                                    if (bDecodeByte != 7) {
                                        if (bDecodeByte != 8) {
                                            if (bDecodeByte != 9) {
                                                if (bDecodeByte != 10) {
                                                    if (bDecodeByte != 11) {
                                                        if (bDecodeByte == 12) {
                                                            if (dataAvailable() < 20) {
                                                                break;
                                                            }
                                                            mutableSpanStyle.setShadow(decodeShadow());
                                                        } else {
                                                            continue;
                                                        }
                                                    } else {
                                                        if (dataAvailable() < 4) {
                                                            break;
                                                        }
                                                        mutableSpanStyle.setTextDecoration(decodeTextDecoration());
                                                    }
                                                } else {
                                                    if (dataAvailable() < 8) {
                                                        break;
                                                    }
                                                    mutableSpanStyle.m2071setBackground8_81llA(m2053decodeColor0d7_KjU());
                                                }
                                            } else {
                                                if (dataAvailable() < 8) {
                                                    break;
                                                }
                                                mutableSpanStyle.setTextGeometricTransform(decodeTextGeometricTransform());
                                            }
                                        } else {
                                            if (dataAvailable() < 4) {
                                                break;
                                            }
                                            mutableSpanStyle.m2072setBaselineShift_isdbwI(BaselineShift.m2408boximpl(m2051decodeBaselineShifty9eOQZs()));
                                        }
                                    } else {
                                        if (dataAvailable() < 5) {
                                            break;
                                        }
                                        mutableSpanStyle.m2077setLetterSpacingR2X_6o(m2056decodeTextUnitXSAIIZE());
                                    }
                                } else {
                                    mutableSpanStyle.setFontFeatureSettings(decodeString());
                                }
                            } else {
                                if (dataAvailable() < 1) {
                                    break;
                                }
                                mutableSpanStyle.m2076setFontSynthesistDdu0R4(FontSynthesis.m2290boximpl(m2055decodeFontSynthesisGVVA2EU()));
                            }
                        } else {
                            if (dataAvailable() < 1) {
                                break;
                            }
                            mutableSpanStyle.m2075setFontStylemLjRB2g(FontStyle.m2281boximpl(m2054decodeFontStyle_LCdwA()));
                        }
                    } else {
                        if (dataAvailable() < 4) {
                            break;
                        }
                        mutableSpanStyle.setFontWeight(decodeFontWeight());
                    }
                } else {
                    if (dataAvailable() < 5) {
                        break;
                    }
                    mutableSpanStyle.m2074setFontSizeR2X_6o(m2056decodeTextUnitXSAIIZE());
                }
            } else {
                if (dataAvailable() < 8) {
                    break;
                }
                mutableSpanStyle.m2073setColor8_81llA(m2053decodeColor0d7_KjU());
            }
        }
        return mutableSpanStyle.toSpanStyle();
    }

    /* JADX INFO: renamed from: decodeColor-0d7_KjU, reason: not valid java name */
    public final long m2053decodeColor0d7_KjU() {
        return Color.m1362constructorimpl(m2052decodeULongsVKNKU());
    }

    /* JADX INFO: renamed from: decodeTextUnit-XSAIIZE, reason: not valid java name */
    public final long m2056decodeTextUnitXSAIIZE() {
        long jM2641getUnspecifiedUIouoOA;
        byte bDecodeByte = decodeByte();
        if (bDecodeByte == 1) {
            jM2641getUnspecifiedUIouoOA = TextUnitType.Companion.m2640getSpUIouoOA();
        } else if (bDecodeByte == 2) {
            jM2641getUnspecifiedUIouoOA = TextUnitType.Companion.m2639getEmUIouoOA();
        } else {
            jM2641getUnspecifiedUIouoOA = TextUnitType.Companion.m2641getUnspecifiedUIouoOA();
        }
        if (TextUnitType.m2635equalsimpl0(jM2641getUnspecifiedUIouoOA, TextUnitType.Companion.m2641getUnspecifiedUIouoOA())) {
            return TextUnit.Companion.m2626getUnspecifiedXSAIIZE();
        }
        return TextUnitKt.m2627TextUnitanM5pPY(decodeFloat(), jM2641getUnspecifiedUIouoOA);
    }

    public final FontWeight decodeFontWeight() {
        return new FontWeight(decodeInt());
    }

    /* JADX INFO: renamed from: decodeFontStyle-_-LCdwA, reason: not valid java name */
    public final int m2054decodeFontStyle_LCdwA() {
        byte bDecodeByte = decodeByte();
        if (bDecodeByte == 0) {
            return FontStyle.Companion.m2289getNormal_LCdwA();
        }
        if (bDecodeByte == 1) {
            return FontStyle.Companion.m2288getItalic_LCdwA();
        }
        return FontStyle.Companion.m2289getNormal_LCdwA();
    }

    /* JADX INFO: renamed from: decodeFontSynthesis-GVVA2EU, reason: not valid java name */
    public final int m2055decodeFontSynthesisGVVA2EU() {
        byte bDecodeByte = decodeByte();
        if (bDecodeByte == 0) {
            return FontSynthesis.Companion.m2300getNoneGVVA2EU();
        }
        if (bDecodeByte == 1) {
            return FontSynthesis.Companion.m2299getAllGVVA2EU();
        }
        if (bDecodeByte == 3) {
            return FontSynthesis.Companion.m2301getStyleGVVA2EU();
        }
        if (bDecodeByte == 2) {
            return FontSynthesis.Companion.m2302getWeightGVVA2EU();
        }
        return FontSynthesis.Companion.m2300getNoneGVVA2EU();
    }

    /* JADX INFO: renamed from: decodeBaselineShift-y9eOQZs, reason: not valid java name */
    private final float m2051decodeBaselineShifty9eOQZs() {
        return BaselineShift.m2409constructorimpl(decodeFloat());
    }

    private final TextGeometricTransform decodeTextGeometricTransform() {
        return new TextGeometricTransform(decodeFloat(), decodeFloat());
    }

    private final TextDecoration decodeTextDecoration() {
        int iDecodeInt = decodeInt();
        TextDecoration.Companion companion = TextDecoration.Companion;
        boolean z = (companion.getLineThrough().getMask() & iDecodeInt) != 0;
        boolean z2 = (iDecodeInt & companion.getUnderline().getMask()) != 0;
        if (z && z2) {
            return companion.combine(CollectionsKt.listOf((Object[]) new TextDecoration[]{companion.getLineThrough(), companion.getUnderline()}));
        }
        if (z) {
            return companion.getLineThrough();
        }
        if (z2) {
            return companion.getUnderline();
        }
        return companion.getNone();
    }

    private final Shadow decodeShadow() {
        return new Shadow(m2053decodeColor0d7_KjU(), OffsetKt.Offset(decodeFloat(), decodeFloat()), decodeFloat(), null);
    }

    private final byte decodeByte() {
        return this.parcel.readByte();
    }

    private final int decodeInt() {
        return this.parcel.readInt();
    }

    /* JADX INFO: renamed from: decodeULong-s-VKNKU, reason: not valid java name */
    private final long m2052decodeULongsVKNKU() {
        return ULong.m5297constructorimpl(this.parcel.readLong());
    }

    private final float decodeFloat() {
        return this.parcel.readFloat();
    }

    private final String decodeString() {
        return this.parcel.readString();
    }

    private final int dataAvailable() {
        return this.parcel.dataAvail();
    }
}
