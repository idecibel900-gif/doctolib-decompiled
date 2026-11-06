package androidx.compose.ui.text.font;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class TypefaceRequest {
    private final FontFamily fontFamily;
    private final int fontStyle;
    private final int fontSynthesis;
    private final FontWeight fontWeight;
    private final Object resourceLoaderCacheKey;

    public /* synthetic */ TypefaceRequest(FontFamily fontFamily, FontWeight fontWeight, int i, int i2, Object obj, DefaultConstructorMarker defaultConstructorMarker) {
        this(fontFamily, fontWeight, i, i2, obj);
    }

    /* JADX INFO: renamed from: copy-e1PVR60$default, reason: not valid java name */
    public static /* synthetic */ TypefaceRequest m2314copye1PVR60$default(TypefaceRequest typefaceRequest, FontFamily fontFamily, FontWeight fontWeight, int i, int i2, Object obj, int i3, Object obj2) {
        if ((i3 & 1) != 0) {
            fontFamily = typefaceRequest.fontFamily;
        }
        if ((i3 & 2) != 0) {
            fontWeight = typefaceRequest.fontWeight;
        }
        if ((i3 & 4) != 0) {
            i = typefaceRequest.fontStyle;
        }
        if ((i3 & 8) != 0) {
            i2 = typefaceRequest.fontSynthesis;
        }
        if ((i3 & 16) != 0) {
            obj = typefaceRequest.resourceLoaderCacheKey;
        }
        Object obj3 = obj;
        int i4 = i;
        return typefaceRequest.m2315copye1PVR60(fontFamily, fontWeight, i4, i2, obj3);
    }

    /* JADX INFO: renamed from: copy-e1PVR60, reason: not valid java name */
    public final TypefaceRequest m2315copye1PVR60(FontFamily fontFamily, FontWeight fontWeight, int i, int i2, Object obj) {
        return new TypefaceRequest(fontFamily, fontWeight, i, i2, obj, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TypefaceRequest)) {
            return false;
        }
        TypefaceRequest typefaceRequest = (TypefaceRequest) obj;
        return Intrinsics.areEqual(this.fontFamily, typefaceRequest.fontFamily) && Intrinsics.areEqual(this.fontWeight, typefaceRequest.fontWeight) && FontStyle.m2284equalsimpl0(this.fontStyle, typefaceRequest.fontStyle) && FontSynthesis.m2293equalsimpl0(this.fontSynthesis, typefaceRequest.fontSynthesis) && Intrinsics.areEqual(this.resourceLoaderCacheKey, typefaceRequest.resourceLoaderCacheKey);
    }

    public int hashCode() {
        FontFamily fontFamily = this.fontFamily;
        int iHashCode = (((((((fontFamily == null ? 0 : fontFamily.hashCode()) * 31) + this.fontWeight.hashCode()) * 31) + FontStyle.m2285hashCodeimpl(this.fontStyle)) * 31) + FontSynthesis.m2294hashCodeimpl(this.fontSynthesis)) * 31;
        Object obj = this.resourceLoaderCacheKey;
        return iHashCode + (obj != null ? obj.hashCode() : 0);
    }

    public String toString() {
        return "TypefaceRequest(fontFamily=" + this.fontFamily + ", fontWeight=" + this.fontWeight + ", fontStyle=" + ((Object) FontStyle.m2286toStringimpl(this.fontStyle)) + ", fontSynthesis=" + ((Object) FontSynthesis.m2297toStringimpl(this.fontSynthesis)) + ", resourceLoaderCacheKey=" + this.resourceLoaderCacheKey + ')';
    }

    private TypefaceRequest(FontFamily fontFamily, FontWeight fontWeight, int i, int i2, Object obj) {
        this.fontFamily = fontFamily;
        this.fontWeight = fontWeight;
        this.fontStyle = i;
        this.fontSynthesis = i2;
        this.resourceLoaderCacheKey = obj;
    }

    public final FontFamily getFontFamily() {
        return this.fontFamily;
    }

    public final FontWeight getFontWeight() {
        return this.fontWeight;
    }

    /* JADX INFO: renamed from: getFontStyle-_-LCdwA, reason: not valid java name */
    public final int m2316getFontStyle_LCdwA() {
        return this.fontStyle;
    }

    /* JADX INFO: renamed from: getFontSynthesis-GVVA2EU, reason: not valid java name */
    public final int m2317getFontSynthesisGVVA2EU() {
        return this.fontSynthesis;
    }
}
