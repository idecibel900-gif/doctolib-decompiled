package com.revenuecat.purchases.ui.revenuecatui.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import androidx.compose.ui.text.font.AndroidTypeface_androidKt;
import androidx.core.content.res.ResourcesCompat;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.ui.revenuecatui.R;
import com.revenuecat.purchases.ui.revenuecatui.fonts.CustomFontProvider;
import com.revenuecat.purchases.ui.revenuecatui.fonts.FontProvider;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Logger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/views/PaywallViewAttributesReader;", "", "()V", "Companion", "PaywallViewAttributes", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PaywallViewAttributesReader {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final boolean DEFAULT_CONDENSED = false;
    private static final Map<int[], Map<Companion.Attributes, Integer>> styleablesByStyleSet;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R&\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/views/PaywallViewAttributesReader$Companion;", "", "()V", "DEFAULT_CONDENSED", "", "styleablesByStyleSet", "", "", "Lcom/revenuecat/purchases/ui/revenuecatui/views/PaywallViewAttributesReader$Companion$Attributes;", "", "parseAttributes", "Lcom/revenuecat/purchases/ui/revenuecatui/views/PaywallViewAttributesReader$PaywallViewAttributes;", "context", "Landroid/content/Context;", "attrsSet", "Landroid/util/AttributeSet;", "styleAttrs", "Attributes", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/views/PaywallViewAttributesReader$Companion$Attributes;", "", "(Ljava/lang/String;I)V", "OfferingId", "ShouldDisplayDismissButton", "FontFamily", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        private enum Attributes {
            OfferingId,
            ShouldDisplayDismissButton,
            FontFamily
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Code duplicated, block: B:26:0x0084  */
        public final PaywallViewAttributes parseAttributes(Context context, AttributeSet attrsSet, int[] styleAttrs) {
            Boolean boolValueOf;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(styleAttrs, "styleAttrs");
            CustomFontProvider customFontProvider = null;
            if (attrsSet == null) {
                return null;
            }
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrsSet, styleAttrs, 0, 0);
            try {
                Map map = (Map) PaywallViewAttributesReader.styleablesByStyleSet.get(styleAttrs);
                if (map == null) {
                    Logger.INSTANCE.e("Styleable not found for PaywallView");
                    typedArrayObtainStyledAttributes.recycle();
                    return null;
                }
                Integer num = (Integer) map.get(Attributes.FontFamily);
                ref$ObjectRef.element = num != null ? Integer.valueOf(typedArrayObtainStyledAttributes.getResourceId(num.intValue(), 0)) : null;
                Integer num2 = (Integer) map.get(Attributes.OfferingId);
                ref$ObjectRef2.element = num2 != null ? typedArrayObtainStyledAttributes.getString(num2.intValue()) : null;
                Integer num3 = (Integer) map.get(Attributes.ShouldDisplayDismissButton);
                if (num3 != null) {
                    int iIntValue = num3.intValue();
                    if (typedArrayObtainStyledAttributes.hasValue(iIntValue)) {
                        boolValueOf = Boolean.valueOf(typedArrayObtainStyledAttributes.getBoolean(iIntValue, false));
                    } else {
                        boolValueOf = null;
                    }
                } else {
                    boolValueOf = null;
                }
                Boolean boolValueOf2 = typedArrayObtainStyledAttributes.hasValue(R.styleable.PaywallFooterView_condensed) ? Boolean.valueOf(typedArrayObtainStyledAttributes.getBoolean(R.styleable.PaywallFooterView_condensed, false)) : null;
                typedArrayObtainStyledAttributes.recycle();
                Integer num4 = (Integer) ref$ObjectRef.element;
                if (num4 != null) {
                    if (num4.intValue() <= 0) {
                        num4 = null;
                    }
                    if (num4 != null) {
                        Typeface font = ResourcesCompat.getFont(context, num4.intValue());
                        if (font == null) {
                            Logger.INSTANCE.e("Font given for PaywallView not found");
                        } else {
                            customFontProvider = new CustomFontProvider(AndroidTypeface_androidKt.FontFamily(font));
                        }
                    }
                }
                return new PaywallViewAttributes((String) ref$ObjectRef2.element, customFontProvider, boolValueOf, boolValueOf2);
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        }
    }

    static {
        int[] iArr = R.styleable.PaywallView;
        Companion.Attributes attributes = Companion.Attributes.OfferingId;
        Pair pair = TuplesKt.to(attributes, Integer.valueOf(R.styleable.PaywallView_offeringIdentifier));
        Pair pair2 = TuplesKt.to(Companion.Attributes.ShouldDisplayDismissButton, Integer.valueOf(R.styleable.PaywallView_shouldDisplayDismissButton));
        Companion.Attributes attributes2 = Companion.Attributes.FontFamily;
        styleablesByStyleSet = MapsKt.mapOf(TuplesKt.to(iArr, MapsKt.mapOf(pair, pair2, TuplesKt.to(attributes2, Integer.valueOf(R.styleable.PaywallView_android_fontFamily)))), TuplesKt.to(R.styleable.PaywallFooterView, MapsKt.mapOf(TuplesKt.to(attributes, Integer.valueOf(R.styleable.PaywallFooterView_offeringIdentifier)), TuplesKt.to(attributes2, Integer.valueOf(R.styleable.PaywallFooterView_android_fontFamily)))));
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJ>\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/views/PaywallViewAttributesReader$PaywallViewAttributes;", "", "offeringId", "", "fontProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/fonts/FontProvider;", "shouldDisplayDismissButton", "", "condensed", "(Ljava/lang/String;Lcom/revenuecat/purchases/ui/revenuecatui/fonts/FontProvider;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getCondensed", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getFontProvider", "()Lcom/revenuecat/purchases/ui/revenuecatui/fonts/FontProvider;", "getOfferingId", "()Ljava/lang/String;", "getShouldDisplayDismissButton", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Lcom/revenuecat/purchases/ui/revenuecatui/fonts/FontProvider;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/revenuecat/purchases/ui/revenuecatui/views/PaywallViewAttributesReader$PaywallViewAttributes;", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class PaywallViewAttributes {
        public static final int $stable = 8;
        private final Boolean condensed;
        private final FontProvider fontProvider;
        private final String offeringId;
        private final Boolean shouldDisplayDismissButton;

        public static /* synthetic */ PaywallViewAttributes copy$default(PaywallViewAttributes paywallViewAttributes, String str, FontProvider fontProvider, Boolean bool, Boolean bool2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = paywallViewAttributes.offeringId;
            }
            if ((i & 2) != 0) {
                fontProvider = paywallViewAttributes.fontProvider;
            }
            if ((i & 4) != 0) {
                bool = paywallViewAttributes.shouldDisplayDismissButton;
            }
            if ((i & 8) != 0) {
                bool2 = paywallViewAttributes.condensed;
            }
            return paywallViewAttributes.copy(str, fontProvider, bool, bool2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getOfferingId() {
            return this.offeringId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final FontProvider getFontProvider() {
            return this.fontProvider;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Boolean getShouldDisplayDismissButton() {
            return this.shouldDisplayDismissButton;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Boolean getCondensed() {
            return this.condensed;
        }

        public final PaywallViewAttributes copy(String offeringId, FontProvider fontProvider, Boolean shouldDisplayDismissButton, Boolean condensed) {
            return new PaywallViewAttributes(offeringId, fontProvider, shouldDisplayDismissButton, condensed);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PaywallViewAttributes)) {
                return false;
            }
            PaywallViewAttributes paywallViewAttributes = (PaywallViewAttributes) other;
            return Intrinsics.areEqual(this.offeringId, paywallViewAttributes.offeringId) && Intrinsics.areEqual(this.fontProvider, paywallViewAttributes.fontProvider) && Intrinsics.areEqual(this.shouldDisplayDismissButton, paywallViewAttributes.shouldDisplayDismissButton) && Intrinsics.areEqual(this.condensed, paywallViewAttributes.condensed);
        }

        public int hashCode() {
            String str = this.offeringId;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            FontProvider fontProvider = this.fontProvider;
            int iHashCode2 = (iHashCode + (fontProvider == null ? 0 : fontProvider.hashCode())) * 31;
            Boolean bool = this.shouldDisplayDismissButton;
            int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
            Boolean bool2 = this.condensed;
            return iHashCode3 + (bool2 != null ? bool2.hashCode() : 0);
        }

        public String toString() {
            return "PaywallViewAttributes(offeringId=" + this.offeringId + ", fontProvider=" + this.fontProvider + ", shouldDisplayDismissButton=" + this.shouldDisplayDismissButton + ", condensed=" + this.condensed + ')';
        }

        public PaywallViewAttributes(String str, FontProvider fontProvider, Boolean bool, Boolean bool2) {
            this.offeringId = str;
            this.fontProvider = fontProvider;
            this.shouldDisplayDismissButton = bool;
            this.condensed = bool2;
        }

        public final String getOfferingId() {
            return this.offeringId;
        }

        public final FontProvider getFontProvider() {
            return this.fontProvider;
        }

        public final Boolean getShouldDisplayDismissButton() {
            return this.shouldDisplayDismissButton;
        }

        public final Boolean getCondensed() {
            return this.condensed;
        }
    }
}
