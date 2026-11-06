package androidx.compose.ui.text.font;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class ResourceFont implements Font {
    private final int loadingStrategy;
    private final int resId;
    private final int style;
    private final FontVariation.Settings variationSettings;
    private final FontWeight weight;

    public /* synthetic */ ResourceFont(int i, FontWeight fontWeight, int i2, FontVariation.Settings settings, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, fontWeight, i2, settings, i3);
    }

    private ResourceFont(int i, FontWeight fontWeight, int i2, FontVariation.Settings settings, int i3) {
        this.resId = i;
        this.weight = fontWeight;
        this.style = i2;
        this.variationSettings = settings;
        this.loadingStrategy = i3;
    }

    public final int getResId() {
        return this.resId;
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

    public final FontVariation.Settings getVariationSettings() {
        return this.variationSettings;
    }

    @Override // androidx.compose.ui.text.font.Font
    /* JADX INFO: renamed from: getLoadingStrategy-PKNRLFQ */
    public int mo2248getLoadingStrategyPKNRLFQ() {
        return this.loadingStrategy;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResourceFont)) {
            return false;
        }
        ResourceFont resourceFont = (ResourceFont) obj;
        return this.resId == resourceFont.resId && Intrinsics.areEqual(getWeight(), resourceFont.getWeight()) && FontStyle.m2284equalsimpl0(mo2254getStyle_LCdwA(), resourceFont.mo2254getStyle_LCdwA()) && Intrinsics.areEqual(this.variationSettings, resourceFont.variationSettings) && FontLoadingStrategy.m2274equalsimpl0(mo2248getLoadingStrategyPKNRLFQ(), resourceFont.mo2248getLoadingStrategyPKNRLFQ());
    }

    public int hashCode() {
        return (((((((this.resId * 31) + getWeight().hashCode()) * 31) + FontStyle.m2285hashCodeimpl(mo2254getStyle_LCdwA())) * 31) + FontLoadingStrategy.m2275hashCodeimpl(mo2248getLoadingStrategyPKNRLFQ())) * 31) + this.variationSettings.hashCode();
    }

    public String toString() {
        return "ResourceFont(resId=" + this.resId + ", weight=" + getWeight() + ", style=" + ((Object) FontStyle.m2286toStringimpl(mo2254getStyle_LCdwA())) + ", loadingStrategy=" + ((Object) FontLoadingStrategy.m2276toStringimpl(mo2248getLoadingStrategyPKNRLFQ())) + ')';
    }
}
