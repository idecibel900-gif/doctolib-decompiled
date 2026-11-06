package androidx.compose.ui.text.font;

import android.content.Context;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
final class DeviceFontFamilyNameFont extends AndroidFont {
    private final String familyName;
    private final int style;
    private final FontWeight weight;

    public /* synthetic */ DeviceFontFamilyNameFont(String str, FontWeight fontWeight, int i, FontVariation.Settings settings, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, fontWeight, i, settings);
    }

    @Override // androidx.compose.ui.text.font.Font
    public FontWeight getWeight() {
        return this.weight;
    }

    @Override // androidx.compose.ui.text.font.Font
    /* JADX INFO: renamed from: getStyle-_-LCdwA */
    public int mo2254getStyle_LCdwA() {
        return this.style;
    }

    private DeviceFontFamilyNameFont(String str, FontWeight fontWeight, int i, FontVariation.Settings settings) {
        super(FontLoadingStrategy.Companion.m2279getOptionalLocalPKNRLFQ(), NamedFontLoader.INSTANCE, settings, null);
        this.familyName = str;
        this.weight = fontWeight;
        this.style = i;
    }

    public final android.graphics.Typeface loadCached(Context context) {
        return PlatformTypefaces_androidKt.PlatformTypefaces().mo2309optionalOnDeviceFontFamilyByName78DK7lM(this.familyName, getWeight(), mo2254getStyle_LCdwA(), getVariationSettings(), context);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceFontFamilyNameFont)) {
            return false;
        }
        DeviceFontFamilyNameFont deviceFontFamilyNameFont = (DeviceFontFamilyNameFont) obj;
        return DeviceFontFamilyName.m2264equalsimpl0(this.familyName, deviceFontFamilyNameFont.familyName) && Intrinsics.areEqual(getWeight(), deviceFontFamilyNameFont.getWeight()) && FontStyle.m2284equalsimpl0(mo2254getStyle_LCdwA(), deviceFontFamilyNameFont.mo2254getStyle_LCdwA()) && Intrinsics.areEqual(getVariationSettings(), deviceFontFamilyNameFont.getVariationSettings());
    }

    public int hashCode() {
        return (((((DeviceFontFamilyName.m2265hashCodeimpl(this.familyName) * 31) + getWeight().hashCode()) * 31) + FontStyle.m2285hashCodeimpl(mo2254getStyle_LCdwA())) * 31) + getVariationSettings().hashCode();
    }

    public String toString() {
        return "Font(familyName=\"" + ((Object) DeviceFontFamilyName.m2266toStringimpl(this.familyName)) + "\", weight=" + getWeight() + ", style=" + ((Object) FontStyle.m2286toStringimpl(mo2254getStyle_LCdwA())) + ')';
    }
}
