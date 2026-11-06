package com.revenuecat.purchases.ui.revenuecatui.helpers;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.google.firebase.messaging.Constants;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.DangerousSettings;
import com.revenuecat.purchases.EntitlementVerificationMode;
import com.revenuecat.purchases.PurchasesAreCompletedBy;
import com.revenuecat.purchases.PurchasesConfiguration;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0081\b\u0018\u0000 ;2\u00020\u0001:\u0001;BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\b¢\u0006\u0002\u0010\u0011J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\t\u0010$\u001a\u00020\bHÆ\u0003J\t\u0010%\u001a\u00020\nHÆ\u0003J\t\u0010&\u001a\u00020\bHÆ\u0003J\t\u0010'\u001a\u00020\rHÆ\u0003J\t\u0010(\u001a\u00020\u000fHÆ\u0003J\t\u0010)\u001a\u00020\bHÆ\u0003Je\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\bHÆ\u0001J\t\u0010+\u001a\u00020,HÖ\u0001J\u0013\u0010-\u001a\u00020\b2\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u00020,HÖ\u0001J\u000e\u00101\u001a\u0002022\u0006\u00103\u001a\u000204J\t\u00105\u001a\u00020\u0003HÖ\u0001J\u0019\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020,HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0010\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006<"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/helpers/SdkConfigurationState;", "Landroid/os/Parcelable;", "apiKey", "", "appUserId", "purchasesAreCompletedBy", "Lcom/revenuecat/purchases/PurchasesAreCompletedBy;", "showInAppMessagesAutomatically", "", ProductResponseJsonKeys.STORE, "Lcom/revenuecat/purchases/Store;", "diagnosticsEnabled", "verificationMode", "Lcom/revenuecat/purchases/EntitlementVerificationMode;", "dangerousSettings", "Lcom/revenuecat/purchases/DangerousSettings;", "pendingTransactionsForPrepaidPlansEnabled", "(Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/PurchasesAreCompletedBy;ZLcom/revenuecat/purchases/Store;ZLcom/revenuecat/purchases/EntitlementVerificationMode;Lcom/revenuecat/purchases/DangerousSettings;Z)V", "getApiKey", "()Ljava/lang/String;", "getAppUserId", "getDangerousSettings", "()Lcom/revenuecat/purchases/DangerousSettings;", "getDiagnosticsEnabled", "()Z", "getPendingTransactionsForPrepaidPlansEnabled", "getPurchasesAreCompletedBy", "()Lcom/revenuecat/purchases/PurchasesAreCompletedBy;", "getShowInAppMessagesAutomatically", "getStore", "()Lcom/revenuecat/purchases/Store;", "getVerificationMode", "()Lcom/revenuecat/purchases/EntitlementVerificationMode;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "toConfiguration", "Lcom/revenuecat/purchases/PurchasesConfiguration;", "context", "Landroid/content/Context;", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SdkConfigurationState implements Parcelable {
    private final String apiKey;
    private final String appUserId;
    private final DangerousSettings dangerousSettings;
    private final boolean diagnosticsEnabled;
    private final boolean pendingTransactionsForPrepaidPlansEnabled;
    private final PurchasesAreCompletedBy purchasesAreCompletedBy;
    private final boolean showInAppMessagesAutomatically;
    private final Store store;
    private final EntitlementVerificationMode verificationMode;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    public static final Parcelable.Creator<SdkConfigurationState> CREATOR = new Creator();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SdkConfigurationState> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SdkConfigurationState createFromParcel(Parcel parcel) {
            boolean z;
            boolean z2;
            DangerousSettings dangerousSettings;
            boolean z3;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            PurchasesAreCompletedBy purchasesAreCompletedByValueOf = PurchasesAreCompletedBy.valueOf(parcel.readString());
            boolean z4 = false;
            if (parcel.readInt() != 0) {
                z4 = true;
            }
            Store storeValueOf = Store.valueOf(parcel.readString());
            if (parcel.readInt() != 0) {
                z = true;
                z2 = true;
            } else {
                z = true;
                z2 = z4;
            }
            EntitlementVerificationMode entitlementVerificationModeValueOf = EntitlementVerificationMode.valueOf(parcel.readString());
            DangerousSettings dangerousSettings2 = (DangerousSettings) parcel.readParcelable(SdkConfigurationState.class.getClassLoader());
            if (parcel.readInt() != 0) {
                z3 = z;
                dangerousSettings = dangerousSettings2;
            } else {
                dangerousSettings = dangerousSettings2;
                z3 = false;
            }
            return new SdkConfigurationState(string, string2, purchasesAreCompletedByValueOf, z4, storeValueOf, z2, entitlementVerificationModeValueOf, dangerousSettings, z3);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SdkConfigurationState[] newArray(int i) {
            return new SdkConfigurationState[i];
        }
    }

    public static /* synthetic */ SdkConfigurationState copy$default(SdkConfigurationState sdkConfigurationState, String str, String str2, PurchasesAreCompletedBy purchasesAreCompletedBy, boolean z, Store store, boolean z2, EntitlementVerificationMode entitlementVerificationMode, DangerousSettings dangerousSettings, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sdkConfigurationState.apiKey;
        }
        if ((i & 2) != 0) {
            str2 = sdkConfigurationState.appUserId;
        }
        if ((i & 4) != 0) {
            purchasesAreCompletedBy = sdkConfigurationState.purchasesAreCompletedBy;
        }
        if ((i & 8) != 0) {
            z = sdkConfigurationState.showInAppMessagesAutomatically;
        }
        if ((i & 16) != 0) {
            store = sdkConfigurationState.store;
        }
        if ((i & 32) != 0) {
            z2 = sdkConfigurationState.diagnosticsEnabled;
        }
        if ((i & 64) != 0) {
            entitlementVerificationMode = sdkConfigurationState.verificationMode;
        }
        if ((i & 128) != 0) {
            dangerousSettings = sdkConfigurationState.dangerousSettings;
        }
        if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0) {
            z3 = sdkConfigurationState.pendingTransactionsForPrepaidPlansEnabled;
        }
        DangerousSettings dangerousSettings2 = dangerousSettings;
        boolean z4 = z3;
        boolean z5 = z2;
        EntitlementVerificationMode entitlementVerificationMode2 = entitlementVerificationMode;
        Store store2 = store;
        PurchasesAreCompletedBy purchasesAreCompletedBy2 = purchasesAreCompletedBy;
        return sdkConfigurationState.copy(str, str2, purchasesAreCompletedBy2, z, store2, z5, entitlementVerificationMode2, dangerousSettings2, z4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getApiKey() {
        return this.apiKey;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAppUserId() {
        return this.appUserId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final PurchasesAreCompletedBy getPurchasesAreCompletedBy() {
        return this.purchasesAreCompletedBy;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getShowInAppMessagesAutomatically() {
        return this.showInAppMessagesAutomatically;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Store getStore() {
        return this.store;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getDiagnosticsEnabled() {
        return this.diagnosticsEnabled;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final EntitlementVerificationMode getVerificationMode() {
        return this.verificationMode;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final DangerousSettings getDangerousSettings() {
        return this.dangerousSettings;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getPendingTransactionsForPrepaidPlansEnabled() {
        return this.pendingTransactionsForPrepaidPlansEnabled;
    }

    public final SdkConfigurationState copy(String apiKey, String appUserId, PurchasesAreCompletedBy purchasesAreCompletedBy, boolean showInAppMessagesAutomatically, Store store, boolean diagnosticsEnabled, EntitlementVerificationMode verificationMode, DangerousSettings dangerousSettings, boolean pendingTransactionsForPrepaidPlansEnabled) {
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(purchasesAreCompletedBy, "purchasesAreCompletedBy");
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(verificationMode, "verificationMode");
        Intrinsics.checkNotNullParameter(dangerousSettings, "dangerousSettings");
        return new SdkConfigurationState(apiKey, appUserId, purchasesAreCompletedBy, showInAppMessagesAutomatically, store, diagnosticsEnabled, verificationMode, dangerousSettings, pendingTransactionsForPrepaidPlansEnabled);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SdkConfigurationState)) {
            return false;
        }
        SdkConfigurationState sdkConfigurationState = (SdkConfigurationState) other;
        return Intrinsics.areEqual(this.apiKey, sdkConfigurationState.apiKey) && Intrinsics.areEqual(this.appUserId, sdkConfigurationState.appUserId) && this.purchasesAreCompletedBy == sdkConfigurationState.purchasesAreCompletedBy && this.showInAppMessagesAutomatically == sdkConfigurationState.showInAppMessagesAutomatically && this.store == sdkConfigurationState.store && this.diagnosticsEnabled == sdkConfigurationState.diagnosticsEnabled && this.verificationMode == sdkConfigurationState.verificationMode && Intrinsics.areEqual(this.dangerousSettings, sdkConfigurationState.dangerousSettings) && this.pendingTransactionsForPrepaidPlansEnabled == sdkConfigurationState.pendingTransactionsForPrepaidPlansEnabled;
    }

    public int hashCode() {
        int iHashCode = this.apiKey.hashCode() * 31;
        String str = this.appUserId;
        return ((((((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.purchasesAreCompletedBy.hashCode()) * 31) + Boolean.hashCode(this.showInAppMessagesAutomatically)) * 31) + this.store.hashCode()) * 31) + Boolean.hashCode(this.diagnosticsEnabled)) * 31) + this.verificationMode.hashCode()) * 31) + this.dangerousSettings.hashCode()) * 31) + Boolean.hashCode(this.pendingTransactionsForPrepaidPlansEnabled);
    }

    public String toString() {
        return "SdkConfigurationState(apiKey=" + this.apiKey + ", appUserId=" + this.appUserId + ", purchasesAreCompletedBy=" + this.purchasesAreCompletedBy + ", showInAppMessagesAutomatically=" + this.showInAppMessagesAutomatically + ", store=" + this.store + ", diagnosticsEnabled=" + this.diagnosticsEnabled + ", verificationMode=" + this.verificationMode + ", dangerousSettings=" + this.dangerousSettings + ", pendingTransactionsForPrepaidPlansEnabled=" + this.pendingTransactionsForPrepaidPlansEnabled + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.apiKey);
        parcel.writeString(this.appUserId);
        parcel.writeString(this.purchasesAreCompletedBy.name());
        parcel.writeInt(this.showInAppMessagesAutomatically ? 1 : 0);
        parcel.writeString(this.store.name());
        parcel.writeInt(this.diagnosticsEnabled ? 1 : 0);
        parcel.writeString(this.verificationMode.name());
        parcel.writeParcelable(this.dangerousSettings, flags);
        parcel.writeInt(this.pendingTransactionsForPrepaidPlansEnabled ? 1 : 0);
    }

    public SdkConfigurationState(String apiKey, String str, PurchasesAreCompletedBy purchasesAreCompletedBy, boolean z, Store store, boolean z2, EntitlementVerificationMode verificationMode, DangerousSettings dangerousSettings, boolean z3) {
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(purchasesAreCompletedBy, "purchasesAreCompletedBy");
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(verificationMode, "verificationMode");
        Intrinsics.checkNotNullParameter(dangerousSettings, "dangerousSettings");
        this.apiKey = apiKey;
        this.appUserId = str;
        this.purchasesAreCompletedBy = purchasesAreCompletedBy;
        this.showInAppMessagesAutomatically = z;
        this.store = store;
        this.diagnosticsEnabled = z2;
        this.verificationMode = verificationMode;
        this.dangerousSettings = dangerousSettings;
        this.pendingTransactionsForPrepaidPlansEnabled = z3;
    }

    public final String getApiKey() {
        return this.apiKey;
    }

    public final String getAppUserId() {
        return this.appUserId;
    }

    public final PurchasesAreCompletedBy getPurchasesAreCompletedBy() {
        return this.purchasesAreCompletedBy;
    }

    public final boolean getShowInAppMessagesAutomatically() {
        return this.showInAppMessagesAutomatically;
    }

    public final Store getStore() {
        return this.store;
    }

    public final boolean getDiagnosticsEnabled() {
        return this.diagnosticsEnabled;
    }

    public final EntitlementVerificationMode getVerificationMode() {
        return this.verificationMode;
    }

    public final DangerousSettings getDangerousSettings() {
        return this.dangerousSettings;
    }

    public final boolean getPendingTransactionsForPrepaidPlansEnabled() {
        return this.pendingTransactionsForPrepaidPlansEnabled;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/helpers/SdkConfigurationState$Companion;", "", "()V", Constants.MessagePayloadKeys.FROM, "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/SdkConfigurationState;", "configuration", "Lcom/revenuecat/purchases/PurchasesConfiguration;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SdkConfigurationState from(PurchasesConfiguration configuration) {
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            return new SdkConfigurationState(configuration.getApiKey(), configuration.getAppUserID(), configuration.getPurchasesAreCompletedBy(), configuration.getShowInAppMessagesAutomatically(), configuration.getStore(), configuration.getDiagnosticsEnabled(), configuration.getVerificationMode(), configuration.getDangerousSettings(), configuration.getPendingTransactionsForPrepaidPlansEnabled());
        }
    }

    public final PurchasesConfiguration toConfiguration(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new PurchasesConfiguration.Builder(context, this.apiKey).appUserID(this.appUserId).purchasesAreCompletedBy(this.purchasesAreCompletedBy).showInAppMessagesAutomatically(this.showInAppMessagesAutomatically).store(this.store).diagnosticsEnabled(this.diagnosticsEnabled).entitlementVerificationMode(this.verificationMode).dangerousSettings(this.dangerousSettings).pendingTransactionsForPrepaidPlansEnabled(this.pendingTransactionsForPrepaidPlansEnabled).build();
    }
}
