package com.revenuecat.purchases.ui.revenuecatui.activity;

import android.os.Parcel;
import android.os.Parcelable;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.ui.revenuecatui.OfferingSelection;
import com.revenuecat.purchases.ui.revenuecatui.fonts.ParcelizableFontProvider;
import com.revenuecat.purchases.ui.revenuecatui.fonts.PaywallFontFamily;
import com.revenuecat.purchases.ui.revenuecatui.fonts.TypographyType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001Bi\b\u0016\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e0\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011Bw\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0018\b\u0002\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\r\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e0\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0015J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0019\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\rHÆ\u0003J\t\u0010'\u001a\u00020\tHÆ\u0003J\t\u0010(\u001a\u00020\tHÆ\u0003J\t\u0010)\u001a\u00020\tHÆ\u0003J\u0015\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0080\u0001\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0018\b\u0002\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\r2\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e0\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u0010-J\t\u0010.\u001a\u00020\u0010HÖ\u0001J\u0013\u0010/\u001a\u00020\t2\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u00020\u0010HÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001J\u0019\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0010HÖ\u0001R\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R!\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019¨\u00069"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallActivityArgs;", "Landroid/os/Parcelable;", "requiredEntitlementIdentifier", "", "offeringIdAndPresentedOfferingContext", "Lcom/revenuecat/purchases/ui/revenuecatui/OfferingSelection$IdAndPresentedOfferingContext;", "fontProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/fonts/ParcelizableFontProvider;", "shouldDisplayDismissButton", "", "edgeToEdge", "wasLaunchedThroughSDK", "customVariables", "", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "nonSerializableArgsKey", "", "(Ljava/lang/String;Lcom/revenuecat/purchases/ui/revenuecatui/OfferingSelection$IdAndPresentedOfferingContext;Lcom/revenuecat/purchases/ui/revenuecatui/fonts/ParcelizableFontProvider;ZZZLjava/util/Map;Ljava/lang/Integer;)V", "fonts", "Lcom/revenuecat/purchases/ui/revenuecatui/fonts/TypographyType;", "Lcom/revenuecat/purchases/ui/revenuecatui/fonts/PaywallFontFamily;", "(Ljava/lang/String;Lcom/revenuecat/purchases/ui/revenuecatui/OfferingSelection$IdAndPresentedOfferingContext;Ljava/util/Map;ZZZLjava/util/Map;Ljava/lang/Integer;)V", "getCustomVariables", "()Ljava/util/Map;", "getEdgeToEdge", "()Z", "getFonts", "getNonSerializableArgsKey", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getOfferingIdAndPresentedOfferingContext", "()Lcom/revenuecat/purchases/ui/revenuecatui/OfferingSelection$IdAndPresentedOfferingContext;", "getRequiredEntitlementIdentifier", "()Ljava/lang/String;", "getShouldDisplayDismissButton", "getWasLaunchedThroughSDK", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Lcom/revenuecat/purchases/ui/revenuecatui/OfferingSelection$IdAndPresentedOfferingContext;Ljava/util/Map;ZZZLjava/util/Map;Ljava/lang/Integer;)Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallActivityArgs;", "describeContents", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PaywallActivityArgs implements Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<PaywallActivityArgs> CREATOR = new Creator();
    private final Map<String, CustomVariableValue> customVariables;
    private final boolean edgeToEdge;
    private final Map<TypographyType, PaywallFontFamily> fonts;
    private final Integer nonSerializableArgsKey;
    private final OfferingSelection.IdAndPresentedOfferingContext offeringIdAndPresentedOfferingContext;
    private final String requiredEntitlementIdentifier;
    private final boolean shouldDisplayDismissButton;
    private final boolean wasLaunchedThroughSDK;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PaywallActivityArgs> {
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Parcelable.Creator
        public final PaywallActivityArgs createFromParcel(Parcel parcel) {
            LinkedHashMap linkedHashMap;
            int i;
            boolean z;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            OfferingSelection.IdAndPresentedOfferingContext idAndPresentedOfferingContextCreateFromParcel = parcel.readInt() == 0 ? null : OfferingSelection.IdAndPresentedOfferingContext.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() == 0) {
                linkedHashMap = null;
            } else {
                int i2 = parcel.readInt();
                linkedHashMap = new LinkedHashMap(i2);
                for (int i3 = 0; i3 != i2; i3++) {
                    linkedHashMap.put(TypographyType.valueOf(parcel.readString()), parcel.readInt() == 0 ? null : PaywallFontFamily.CREATOR.createFromParcel(parcel));
                }
            }
            boolean z2 = 1;
            if (parcel.readInt() != 0) {
                i = 0;
                z = true;
            } else {
                i = 0;
                z = false;
            }
            if (parcel.readInt() == 0) {
                z2 = i;
            }
            boolean z3 = parcel.readInt() == 0 ? i : 1;
            int i4 = parcel.readInt();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(i4);
            while (i != i4) {
                linkedHashMap2.put(parcel.readString(), parcel.readParcelable(PaywallActivityArgs.class.getClassLoader()));
                i++;
            }
            return new PaywallActivityArgs(string, idAndPresentedOfferingContextCreateFromParcel, linkedHashMap, z, z2, z3, linkedHashMap2, parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PaywallActivityArgs[] newArray(int i) {
            return new PaywallActivityArgs[i];
        }
    }

    public PaywallActivityArgs() {
        this((String) null, (OfferingSelection.IdAndPresentedOfferingContext) null, (Map) null, false, false, false, (Map) null, (Integer) null, 255, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PaywallActivityArgs copy$default(PaywallActivityArgs paywallActivityArgs, String str, OfferingSelection.IdAndPresentedOfferingContext idAndPresentedOfferingContext, Map map, boolean z, boolean z2, boolean z3, Map map2, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = paywallActivityArgs.requiredEntitlementIdentifier;
        }
        if ((i & 2) != 0) {
            idAndPresentedOfferingContext = paywallActivityArgs.offeringIdAndPresentedOfferingContext;
        }
        if ((i & 4) != 0) {
            map = paywallActivityArgs.fonts;
        }
        if ((i & 8) != 0) {
            z = paywallActivityArgs.shouldDisplayDismissButton;
        }
        if ((i & 16) != 0) {
            z2 = paywallActivityArgs.edgeToEdge;
        }
        if ((i & 32) != 0) {
            z3 = paywallActivityArgs.wasLaunchedThroughSDK;
        }
        if ((i & 64) != 0) {
            map2 = paywallActivityArgs.customVariables;
        }
        if ((i & 128) != 0) {
            num = paywallActivityArgs.nonSerializableArgsKey;
        }
        Map map3 = map2;
        Integer num2 = num;
        boolean z4 = z2;
        boolean z5 = z3;
        return paywallActivityArgs.copy(str, idAndPresentedOfferingContext, map, z, z4, z5, map3, num2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getRequiredEntitlementIdentifier() {
        return this.requiredEntitlementIdentifier;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final OfferingSelection.IdAndPresentedOfferingContext getOfferingIdAndPresentedOfferingContext() {
        return this.offeringIdAndPresentedOfferingContext;
    }

    public final Map<TypographyType, PaywallFontFamily> component3() {
        return this.fonts;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getShouldDisplayDismissButton() {
        return this.shouldDisplayDismissButton;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getEdgeToEdge() {
        return this.edgeToEdge;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getWasLaunchedThroughSDK() {
        return this.wasLaunchedThroughSDK;
    }

    public final Map<String, CustomVariableValue> component7() {
        return this.customVariables;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Integer getNonSerializableArgsKey() {
        return this.nonSerializableArgsKey;
    }

    public final PaywallActivityArgs copy(String requiredEntitlementIdentifier, OfferingSelection.IdAndPresentedOfferingContext offeringIdAndPresentedOfferingContext, Map<TypographyType, PaywallFontFamily> fonts, boolean shouldDisplayDismissButton, boolean edgeToEdge, boolean wasLaunchedThroughSDK, Map<String, ? extends CustomVariableValue> customVariables, Integer nonSerializableArgsKey) {
        Intrinsics.checkNotNullParameter(customVariables, "customVariables");
        return new PaywallActivityArgs(requiredEntitlementIdentifier, offeringIdAndPresentedOfferingContext, fonts, shouldDisplayDismissButton, edgeToEdge, wasLaunchedThroughSDK, customVariables, nonSerializableArgsKey);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PaywallActivityArgs)) {
            return false;
        }
        PaywallActivityArgs paywallActivityArgs = (PaywallActivityArgs) other;
        return Intrinsics.areEqual(this.requiredEntitlementIdentifier, paywallActivityArgs.requiredEntitlementIdentifier) && Intrinsics.areEqual(this.offeringIdAndPresentedOfferingContext, paywallActivityArgs.offeringIdAndPresentedOfferingContext) && Intrinsics.areEqual(this.fonts, paywallActivityArgs.fonts) && this.shouldDisplayDismissButton == paywallActivityArgs.shouldDisplayDismissButton && this.edgeToEdge == paywallActivityArgs.edgeToEdge && this.wasLaunchedThroughSDK == paywallActivityArgs.wasLaunchedThroughSDK && Intrinsics.areEqual(this.customVariables, paywallActivityArgs.customVariables) && Intrinsics.areEqual(this.nonSerializableArgsKey, paywallActivityArgs.nonSerializableArgsKey);
    }

    public int hashCode() {
        String str = this.requiredEntitlementIdentifier;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        OfferingSelection.IdAndPresentedOfferingContext idAndPresentedOfferingContext = this.offeringIdAndPresentedOfferingContext;
        int iHashCode2 = (iHashCode + (idAndPresentedOfferingContext == null ? 0 : idAndPresentedOfferingContext.hashCode())) * 31;
        Map<TypographyType, PaywallFontFamily> map = this.fonts;
        int iHashCode3 = (((((((((iHashCode2 + (map == null ? 0 : map.hashCode())) * 31) + Boolean.hashCode(this.shouldDisplayDismissButton)) * 31) + Boolean.hashCode(this.edgeToEdge)) * 31) + Boolean.hashCode(this.wasLaunchedThroughSDK)) * 31) + this.customVariables.hashCode()) * 31;
        Integer num = this.nonSerializableArgsKey;
        return iHashCode3 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "PaywallActivityArgs(requiredEntitlementIdentifier=" + this.requiredEntitlementIdentifier + ", offeringIdAndPresentedOfferingContext=" + this.offeringIdAndPresentedOfferingContext + ", fonts=" + this.fonts + ", shouldDisplayDismissButton=" + this.shouldDisplayDismissButton + ", edgeToEdge=" + this.edgeToEdge + ", wasLaunchedThroughSDK=" + this.wasLaunchedThroughSDK + ", customVariables=" + this.customVariables + ", nonSerializableArgsKey=" + this.nonSerializableArgsKey + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.requiredEntitlementIdentifier);
        OfferingSelection.IdAndPresentedOfferingContext idAndPresentedOfferingContext = this.offeringIdAndPresentedOfferingContext;
        if (idAndPresentedOfferingContext == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            idAndPresentedOfferingContext.writeToParcel(parcel, flags);
        }
        Map<TypographyType, PaywallFontFamily> map = this.fonts;
        if (map == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(map.size());
            for (Map.Entry<TypographyType, PaywallFontFamily> entry : map.entrySet()) {
                parcel.writeString(entry.getKey().name());
                PaywallFontFamily value = entry.getValue();
                if (value == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    value.writeToParcel(parcel, flags);
                }
            }
        }
        parcel.writeInt(this.shouldDisplayDismissButton ? 1 : 0);
        parcel.writeInt(this.edgeToEdge ? 1 : 0);
        parcel.writeInt(this.wasLaunchedThroughSDK ? 1 : 0);
        Map<String, CustomVariableValue> map2 = this.customVariables;
        parcel.writeInt(map2.size());
        for (Map.Entry<String, CustomVariableValue> entry2 : map2.entrySet()) {
            parcel.writeString(entry2.getKey());
            parcel.writeParcelable(entry2.getValue(), flags);
        }
        Integer num = this.nonSerializableArgsKey;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PaywallActivityArgs(String str, OfferingSelection.IdAndPresentedOfferingContext idAndPresentedOfferingContext, Map<TypographyType, PaywallFontFamily> map, boolean z, boolean z2, boolean z3, Map<String, ? extends CustomVariableValue> customVariables, Integer num) {
        Intrinsics.checkNotNullParameter(customVariables, "customVariables");
        this.requiredEntitlementIdentifier = str;
        this.offeringIdAndPresentedOfferingContext = idAndPresentedOfferingContext;
        this.fonts = map;
        this.shouldDisplayDismissButton = z;
        this.edgeToEdge = z2;
        this.wasLaunchedThroughSDK = z3;
        this.customVariables = customVariables;
        this.nonSerializableArgsKey = num;
    }

    public final String getRequiredEntitlementIdentifier() {
        return this.requiredEntitlementIdentifier;
    }

    public final OfferingSelection.IdAndPresentedOfferingContext getOfferingIdAndPresentedOfferingContext() {
        return this.offeringIdAndPresentedOfferingContext;
    }

    public final Map<TypographyType, PaywallFontFamily> getFonts() {
        return this.fonts;
    }

    public final boolean getShouldDisplayDismissButton() {
        return this.shouldDisplayDismissButton;
    }

    public /* synthetic */ PaywallActivityArgs(String str, OfferingSelection.IdAndPresentedOfferingContext idAndPresentedOfferingContext, Map map, boolean z, boolean z2, boolean z3, Map map2, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : idAndPresentedOfferingContext, (Map<TypographyType, PaywallFontFamily>) ((i & 4) != 0 ? null : map), (i & 8) != 0 ? true : z, (i & 16) != 0 ? PaywallActivityArgsKt.getDefaultEdgeToEdge() : z2, (i & 32) != 0 ? true : z3, (Map<String, ? extends CustomVariableValue>) ((i & 64) != 0 ? MapsKt.emptyMap() : map2), (i & 128) != 0 ? null : num);
    }

    public final boolean getEdgeToEdge() {
        return this.edgeToEdge;
    }

    public final boolean getWasLaunchedThroughSDK() {
        return this.wasLaunchedThroughSDK;
    }

    public final Map<String, CustomVariableValue> getCustomVariables() {
        return this.customVariables;
    }

    public final Integer getNonSerializableArgsKey() {
        return this.nonSerializableArgsKey;
    }

    public /* synthetic */ PaywallActivityArgs(String str, OfferingSelection.IdAndPresentedOfferingContext idAndPresentedOfferingContext, ParcelizableFontProvider parcelizableFontProvider, boolean z, boolean z2, boolean z3, Map map, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : idAndPresentedOfferingContext, parcelizableFontProvider, (i & 8) != 0 ? true : z, (i & 16) != 0 ? PaywallActivityArgsKt.getDefaultEdgeToEdge() : z2, (i & 32) != 0 ? true : z3, (Map<String, ? extends CustomVariableValue>) ((i & 64) != 0 ? MapsKt.emptyMap() : map), (i & 128) != 0 ? null : num);
    }

    public PaywallActivityArgs(String str, OfferingSelection.IdAndPresentedOfferingContext idAndPresentedOfferingContext, ParcelizableFontProvider parcelizableFontProvider, boolean z, boolean z2, boolean z3, Map<String, ? extends CustomVariableValue> customVariables, Integer num) {
        LinkedHashMap linkedHashMap;
        Intrinsics.checkNotNullParameter(customVariables, "customVariables");
        if (parcelizableFontProvider != null) {
            TypographyType[] typographyTypeArrValues = TypographyType.values();
            linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(typographyTypeArrValues.length), 16));
            for (TypographyType typographyType : typographyTypeArrValues) {
                linkedHashMap.put(typographyType, parcelizableFontProvider.getFont(typographyType));
            }
        } else {
            linkedHashMap = null;
        }
        this(str, idAndPresentedOfferingContext, linkedHashMap, z, z2, z3, customVariables, num);
    }
}
