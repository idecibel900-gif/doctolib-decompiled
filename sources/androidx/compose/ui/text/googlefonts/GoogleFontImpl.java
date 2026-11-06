package androidx.compose.ui.text.googlefonts;

import androidx.compose.ui.text.font.AndroidFont;
import androidx.compose.ui.text.font.FontLoadingStrategy;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontVariation;
import androidx.compose.ui.text.font.FontWeight;
import androidx.core.provider.FontRequest;
import com.amazon.a.a.o.b;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class GoogleFontImpl extends AndroidFont {
    private final boolean bestEffort;
    private final GoogleFont.Provider fontProvider;
    private final String name;
    private final int style;
    private final FontWeight weight;

    public /* synthetic */ GoogleFontImpl(String str, GoogleFont.Provider provider, FontWeight fontWeight, int i, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, provider, fontWeight, i, z);
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

    private GoogleFontImpl(String str, GoogleFont.Provider provider, FontWeight fontWeight, int i, boolean z) {
        super(FontLoadingStrategy.Companion.m2277getAsyncPKNRLFQ(), GoogleFontTypefaceLoader.INSTANCE, new FontVariation.Settings(new FontVariation.Setting[0]), null);
        this.name = str;
        this.fontProvider = provider;
        this.weight = fontWeight;
        this.style = i;
        this.bestEffort = z;
    }

    public final FontRequest toFontRequest() {
        String str = "name=" + this.name + "&weight=" + getWeight().getWeight() + "&italic=" + m2318toQueryParamnzbMABs(mo2254getStyle_LCdwA()) + "&besteffort=" + bestEffortQueryParam();
        List certificates$ui_text_google_fonts_release = this.fontProvider.getCertificates$ui_text_google_fonts_release();
        return certificates$ui_text_google_fonts_release != null ? new FontRequest(this.fontProvider.getProviderAuthority$ui_text_google_fonts_release(), this.fontProvider.getProviderPackage$ui_text_google_fonts_release(), str, certificates$ui_text_google_fonts_release) : new FontRequest(this.fontProvider.getProviderAuthority$ui_text_google_fonts_release(), this.fontProvider.getProviderPackage$ui_text_google_fonts_release(), str, this.fontProvider.getCertificatesRes$ui_text_google_fonts_release());
    }

    private final String bestEffortQueryParam() {
        return this.bestEffort ? b.af : b.ag;
    }

    /* JADX INFO: renamed from: toQueryParam-nzbMABs, reason: not valid java name */
    private final int m2318toQueryParamnzbMABs(int i) {
        return FontStyle.m2284equalsimpl0(i, FontStyle.Companion.m2288getItalic_LCdwA()) ? 1 : 0;
    }

    public final int toTypefaceStyle() {
        boolean zM2284equalsimpl0 = FontStyle.m2284equalsimpl0(mo2254getStyle_LCdwA(), FontStyle.Companion.m2288getItalic_LCdwA());
        boolean z = getWeight().compareTo(FontWeight.Companion.getBold()) >= 0;
        if (zM2284equalsimpl0 && z) {
            return 3;
        }
        if (zM2284equalsimpl0) {
            return 2;
        }
        return z ? 1 : 0;
    }

    public String toString() {
        return "Font(GoogleFont(\"" + this.name + "\", bestEffort=" + this.bestEffort + "), weight=" + getWeight() + ", style=" + ((Object) FontStyle.m2286toStringimpl(mo2254getStyle_LCdwA())) + ')';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GoogleFontImpl)) {
            return false;
        }
        GoogleFontImpl googleFontImpl = (GoogleFontImpl) obj;
        return Intrinsics.areEqual(this.name, googleFontImpl.name) && Intrinsics.areEqual(this.fontProvider, googleFontImpl.fontProvider) && Intrinsics.areEqual(getWeight(), googleFontImpl.getWeight()) && FontStyle.m2284equalsimpl0(mo2254getStyle_LCdwA(), googleFontImpl.mo2254getStyle_LCdwA()) && this.bestEffort == googleFontImpl.bestEffort;
    }

    public int hashCode() {
        return (((((((this.name.hashCode() * 31) + this.fontProvider.hashCode()) * 31) + getWeight().hashCode()) * 31) + FontStyle.m2285hashCodeimpl(mo2254getStyle_LCdwA())) * 31) + Boolean.hashCode(this.bestEffort);
    }
}
