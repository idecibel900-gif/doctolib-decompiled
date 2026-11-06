package com.revenuecat.purchases.ui.revenuecatui.data;

import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.ui.text.intl.LocaleList;
import com.amazon.a.a.o.b;
import com.facebook.react.modules.appstate.AppStateModule;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import com.revenuecat.purchases.ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.ui.revenuecatui.components.ktx.LocalizationKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.ui.revenuecatui.composables.SimpleSheetState;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableDataProvider;
import com.revenuecat.purchases.ui.revenuecatui.extensions.PackageExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.LocaleHelpersKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Logger;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptySet;
import com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallWarning;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResolvedOffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import okhttp3.internal.http2.Http2;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bq\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState;", "", "Error", "Loaded", "Loading", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Error;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loading;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface PaywallState {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loading;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState;", "()V", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Loading implements PaywallState {
        public static final int $stable = 0;
        public static final Loading INSTANCE = new Loading();

        private Loading() {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Error;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState;", b.f, "", "(Ljava/lang/String;)V", "getErrorMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Error implements PaywallState {
        public static final int $stable = 0;
        private final String errorMessage;

        public static /* synthetic */ Error copy$default(Error error, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = error.errorMessage;
            }
            return error.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public final Error copy(String errorMessage) {
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            return new Error(errorMessage);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Error) && Intrinsics.areEqual(this.errorMessage, ((Error) other).errorMessage);
        }

        public int hashCode() {
            return this.errorMessage.hashCode();
        }

        public String toString() {
            return "Error(errorMessage=" + this.errorMessage + ')';
        }

        public Error(String errorMessage) {
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            this.errorMessage = errorMessage;
            Logger.INSTANCE.e("Paywall transitioned to error state: " + errorMessage);
        }

        public final String getErrorMessage() {
            return this.errorMessage;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001:\u0002\u0006\u0007R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState;", "offering", "Lcom/revenuecat/purchases/Offering;", "getOffering", "()Lcom/revenuecat/purchases/Offering;", "Components", "Legacy", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Loaded extends PaywallState {
        Offering getOffering();

        @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B3\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\r\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\rHÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u000bHÆ\u0003JC\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0007J\t\u0010'\u001a\u00020(HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006)"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded;", "offering", "Lcom/revenuecat/purchases/Offering;", "templateConfiguration", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration;", "selectedPackage", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;", "shouldDisplayDismissButton", "", "validationWarning", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning;", "(Lcom/revenuecat/purchases/Offering;Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration;Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;ZLcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning;)V", "Landroidx/compose/runtime/MutableState;", "(Lcom/revenuecat/purchases/Offering;Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration;Landroidx/compose/runtime/MutableState;ZLcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning;)V", "getOffering", "()Lcom/revenuecat/purchases/Offering;", "getSelectedPackage", "()Landroidx/compose/runtime/MutableState;", "getShouldDisplayDismissButton", "()Z", "getTemplateConfiguration", "()Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration;", "getValidationWarning", "()Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallWarning;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "selectPackage", "", "packageInfo", "toString", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final /* data */ class Legacy implements Loaded {
            public static final int $stable = 0;
            private final Offering offering;
            private final MutableState selectedPackage;
            private final boolean shouldDisplayDismissButton;
            private final TemplateConfiguration templateConfiguration;
            private final PaywallWarning validationWarning;

            public static /* synthetic */ Legacy copy$default(Legacy legacy, Offering offering, TemplateConfiguration templateConfiguration, MutableState mutableState, boolean z, PaywallWarning paywallWarning, int i, Object obj) {
                if ((i & 1) != 0) {
                    offering = legacy.offering;
                }
                if ((i & 2) != 0) {
                    templateConfiguration = legacy.templateConfiguration;
                }
                if ((i & 4) != 0) {
                    mutableState = legacy.selectedPackage;
                }
                if ((i & 8) != 0) {
                    z = legacy.shouldDisplayDismissButton;
                }
                if ((i & 16) != 0) {
                    paywallWarning = legacy.validationWarning;
                }
                PaywallWarning paywallWarning2 = paywallWarning;
                MutableState mutableState2 = mutableState;
                return legacy.copy(offering, templateConfiguration, mutableState2, z, paywallWarning2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Offering getOffering() {
                return this.offering;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final TemplateConfiguration getTemplateConfiguration() {
                return this.templateConfiguration;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final MutableState getSelectedPackage() {
                return this.selectedPackage;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final boolean getShouldDisplayDismissButton() {
                return this.shouldDisplayDismissButton;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final PaywallWarning getValidationWarning() {
                return this.validationWarning;
            }

            public final Legacy copy(Offering offering, TemplateConfiguration templateConfiguration, MutableState selectedPackage, boolean shouldDisplayDismissButton, PaywallWarning validationWarning) {
                Intrinsics.checkNotNullParameter(offering, "offering");
                Intrinsics.checkNotNullParameter(templateConfiguration, "templateConfiguration");
                Intrinsics.checkNotNullParameter(selectedPackage, "selectedPackage");
                return new Legacy(offering, templateConfiguration, selectedPackage, shouldDisplayDismissButton, validationWarning);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Legacy)) {
                    return false;
                }
                Legacy legacy = (Legacy) other;
                return Intrinsics.areEqual(this.offering, legacy.offering) && Intrinsics.areEqual(this.templateConfiguration, legacy.templateConfiguration) && Intrinsics.areEqual(this.selectedPackage, legacy.selectedPackage) && this.shouldDisplayDismissButton == legacy.shouldDisplayDismissButton && Intrinsics.areEqual(this.validationWarning, legacy.validationWarning);
            }

            public int hashCode() {
                int iHashCode = ((((((this.offering.hashCode() * 31) + this.templateConfiguration.hashCode()) * 31) + this.selectedPackage.hashCode()) * 31) + Boolean.hashCode(this.shouldDisplayDismissButton)) * 31;
                PaywallWarning paywallWarning = this.validationWarning;
                return iHashCode + (paywallWarning == null ? 0 : paywallWarning.hashCode());
            }

            public String toString() {
                return "Legacy(offering=" + this.offering + ", templateConfiguration=" + this.templateConfiguration + ", selectedPackage=" + this.selectedPackage + ", shouldDisplayDismissButton=" + this.shouldDisplayDismissButton + ", validationWarning=" + this.validationWarning + ')';
            }

            public Legacy(Offering offering, TemplateConfiguration templateConfiguration, MutableState selectedPackage, boolean z, PaywallWarning paywallWarning) {
                Intrinsics.checkNotNullParameter(offering, "offering");
                Intrinsics.checkNotNullParameter(templateConfiguration, "templateConfiguration");
                Intrinsics.checkNotNullParameter(selectedPackage, "selectedPackage");
                this.offering = offering;
                this.templateConfiguration = templateConfiguration;
                this.selectedPackage = selectedPackage;
                this.shouldDisplayDismissButton = z;
                this.validationWarning = paywallWarning;
            }

            public /* synthetic */ Legacy(Offering offering, TemplateConfiguration templateConfiguration, MutableState mutableState, boolean z, PaywallWarning paywallWarning, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(offering, templateConfiguration, mutableState, z, (i & 16) != 0 ? null : paywallWarning);
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallState.Loaded
            public Offering getOffering() {
                return this.offering;
            }

            public final TemplateConfiguration getTemplateConfiguration() {
                return this.templateConfiguration;
            }

            public final MutableState getSelectedPackage() {
                return this.selectedPackage;
            }

            public final boolean getShouldDisplayDismissButton() {
                return this.shouldDisplayDismissButton;
            }

            public final PaywallWarning getValidationWarning() {
                return this.validationWarning;
            }

            public /* synthetic */ Legacy(Offering offering, TemplateConfiguration templateConfiguration, TemplateConfiguration.PackageInfo packageInfo, boolean z, PaywallWarning paywallWarning, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(offering, templateConfiguration, packageInfo, z, (i & 16) != 0 ? null : paywallWarning);
            }

            /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
            public Legacy(Offering offering, TemplateConfiguration templateConfiguration, TemplateConfiguration.PackageInfo selectedPackage, boolean z, PaywallWarning paywallWarning) {
                this(offering, templateConfiguration, SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(selectedPackage, null, 2, null), z, paywallWarning);
                Intrinsics.checkNotNullParameter(offering, "offering");
                Intrinsics.checkNotNullParameter(templateConfiguration, "templateConfiguration");
                Intrinsics.checkNotNullParameter(selectedPackage, "selectedPackage");
            }

            public final void selectPackage(TemplateConfiguration.PackageInfo packageInfo) {
                Intrinsics.checkNotNullParameter(packageInfo, "packageInfo");
                this.selectedPackage.setValue(packageInfo);
            }
        }

        @Metadata(d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0004\u0093\u0001\u0094\u0001BÕ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001d0\u001c\u0012\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001d0\u001c\u0012\b\b\u0002\u0010\u001f\u001a\u00020 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010#\u001a\u00020$\u0012\u0006\u0010%\u001a\u00020&¢\u0006\u0002\u0010'J\n\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0082\u0001J\u0015\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0084\u00012\u0007\u0010\u0085\u0001\u001a\u00020\u0015H\u0002J\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0015J\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010iJ\b\u0010\u0088\u0001\u001a\u00030\u0089\u0001J4\u0010\u008a\u0001\u001a\u00030\u0089\u00012\f\b\u0002\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u00012\n\b\u0002\u0010q\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\t¢\u0006\u0003\u0010\u008d\u0001J\u0010\u0010\u008a\u0001\u001a\u00030\u0089\u00012\u0006\u0010m\u001a\u00020\u0015J\u001c\u0010X\u001a\u0004\u0018\u00010Y*\n\u0012\u0005\u0012\u00030\u0084\u00010\u008e\u0001H\u0002¢\u0006\u0003\u0010\u008f\u0001J\u001c\u0010\u0090\u0001\u001a\u00020\u0013*\u00020 H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001R+\u0010)\u001a\u00020\t2\u0006\u0010(\u001a\u00020\t8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R'\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u0002010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b2\u00103R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u001b\u00108\u001a\u0002098FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b:\u0010;R\u0011\u0010>\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b?\u0010@R\u001d\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001d0\u001c¢\u0006\b\n\u0000\u001a\u0004\bA\u00103R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001d0\u001c¢\u0006\b\n\u0000\u001a\u0004\bB\u00103R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR&\u0010E\u001a\u00020\"2\u0006\u0010(\u001a\u00020\"8F@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u0010\u0010J\u001a\u0004\u0018\u00010\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u0004\u0018\u00010\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010L\u001a\u0002098FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bN\u0010=\u001a\u0004\bM\u0010;R1\u0010O\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u00138B@BX\u0082\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\bT\u0010/\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bU\u0010+R\u001d\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001d0\u001c¢\u0006\b\n\u0000\u001a\u0004\bW\u00103R\u001d\u0010X\u001a\u0004\u0018\u00010Y8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\\\u0010=\u001a\u0004\bZ\u0010[R\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010^R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00150`X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010a\u001a\u00020b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\be\u0010=\u001a\u0004\bc\u0010dR\u001c\u0010f\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0006\u0012\u0004\u0018\u00010\u00150gX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010h\u001a\u0004\u0018\u00010i8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bl\u0010=\u001a\u0004\bj\u0010kR/\u0010m\u001a\u0004\u0018\u00010\u00152\b\u0010(\u001a\u0004\u0018\u00010\u00158B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bp\u0010/\u001a\u0004\bn\u0010Q\"\u0004\bo\u0010SR+\u0010q\u001a\u00020\"2\u0006\u0010(\u001a\u00020\"8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bt\u0010u\u001a\u0004\br\u0010G\"\u0004\bs\u0010IR\u0011\u0010v\u001a\u00020$¢\u0006\b\n\u0000\u001a\u0004\bw\u0010xR\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\by\u0010+R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bz\u0010DR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b{\u0010DR\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010|\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0`0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b}\u0010~R\u0012\u0010\r\u001a\u00020\u000e¢\u0006\t\n\u0000\u001a\u0005\b\u007f\u0010\u0080\u0001\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0095\u0001"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded;", "stack", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;", "header", "stickyFooter", AppStateModule.APP_STATE_BACKGROUND, "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyles;", "mainStackHasHeroImage", "", "showPricesWithDecimals", "variableConfig", "Lcom/revenuecat/purchases/UiConfig$VariableConfig;", "variableDataProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/VariableDataProvider;", "offering", "Lcom/revenuecat/purchases/Offering;", "locales", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptySet;", "Lcom/revenuecat/purchases/paywalls/components/common/LocaleId;", "storefrontCountryCode", "", "dateProvider", "Lkotlin/Function0;", "Ljava/util/Date;", "packages", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$AvailablePackages;", "customVariables", "", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "defaultCustomVariables", "initialLocaleList", "Landroidx/compose/ui/text/intl/LocaleList;", "initialSelectedTabIndex", "", "initialSheetState", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/SimpleSheetState;", "purchases", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PurchasesType;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyles;ZZLcom/revenuecat/purchases/UiConfig$VariableConfig;Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/VariableDataProvider;Lcom/revenuecat/purchases/Offering;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptySet;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$AvailablePackages;Ljava/util/Map;Ljava/util/Map;Landroidx/compose/ui/text/intl/LocaleList;Ljava/lang/Integer;Lcom/revenuecat/purchases/ui/revenuecatui/composables/SimpleSheetState;Lcom/revenuecat/purchases/ui/revenuecatui/data/PurchasesType;)V", "<set-?>", "actionInProgress", "getActionInProgress", "()Z", "setActionInProgress", "(Z)V", "actionInProgress$delegate", "Landroidx/compose/runtime/MutableState;", "availableStorefrontCountryLocalesByLanguage", "Ljava/util/Locale;", "getAvailableStorefrontCountryLocalesByLanguage", "()Ljava/util/Map;", "availableStorefrontCountryLocalesByLanguage$delegate", "Lkotlin/Lazy;", "getBackground", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyles;", "currencyLocale", "Landroidx/compose/ui/text/intl/Locale;", "getCurrencyLocale", "()Landroidx/compose/ui/text/intl/Locale;", "currencyLocale$delegate", "Landroidx/compose/runtime/State;", "currentDate", "getCurrentDate", "()Ljava/util/Date;", "getCustomVariables", "getDefaultCustomVariables", "getHeader", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;", "headerHeightPx", "getHeaderHeightPx", "()I", "setHeaderHeightPx$revenuecatui_defaultsBc8Release", "(I)V", "initialSelectedPackageOutsideTabs", "initialSelectedPackageUniqueId", "locale", "getLocale", "locale$delegate", "localeId", "getLocaleId-uqtKvyA", "()Ljava/lang/String;", "setLocaleId-_KYeFs0", "(Ljava/lang/String;)V", "localeId$delegate", "getMainStackHasHeroImage", "mergedCustomVariables", "getMergedCustomVariables", "mostExpensivePricePerMonthMicros", "", "getMostExpensivePricePerMonthMicros", "()Ljava/lang/Long;", "mostExpensivePricePerMonthMicros$delegate", "getOffering", "()Lcom/revenuecat/purchases/Offering;", "packagesOutsideTabsUniqueIds", "", "selectedOfferEligibility", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "getSelectedOfferEligibility", "()Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "selectedOfferEligibility$delegate", "selectedPackageByTab", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "selectedPackageInfo", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$SelectedPackageInfo;", "getSelectedPackageInfo", "()Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$SelectedPackageInfo;", "selectedPackageInfo$delegate", "selectedPackageUniqueId", "getSelectedPackageUniqueId", "setSelectedPackageUniqueId", "selectedPackageUniqueId$delegate", "selectedTabIndex", "getSelectedTabIndex", "setSelectedTabIndex", "selectedTabIndex$delegate", "Landroidx/compose/runtime/MutableIntState;", "sheet", "getSheet", "()Lcom/revenuecat/purchases/ui/revenuecatui/composables/SimpleSheetState;", "getShowPricesWithDecimals", "getStack", "getStickyFooter", "tabsByUniqueId", "getVariableConfig", "()Lcom/revenuecat/purchases/UiConfig$VariableConfig;", "getVariableDataProvider", "()Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/VariableDataProvider;", "defaultPackageForPackageRowAnalytics", "Lcom/revenuecat/purchases/Package;", "findPackageInfoByUniqueId", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$AvailablePackages$Info;", "uniqueId", "peekDefaultPackageUniqueIdAfterSheetDismiss", "peekSelectedPackageInfoAfterSheetDismiss", "resetToDefaultPackage", "", "update", "localeList", "Landroid/os/LocaleList;", "(Landroid/os/LocaleList;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "", "(Ljava/util/List;)Ljava/lang/Long;", "toLocaleId", "toLocaleId-8pYHj4M", "(Landroidx/compose/ui/text/intl/LocaleList;)Ljava/lang/String;", "AvailablePackages", "SelectedPackageInfo", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Components implements Loaded {
            public static final int $stable = 0;

            /* JADX INFO: renamed from: actionInProgress$delegate, reason: from kotlin metadata */
            private final MutableState actionInProgress;

            /* JADX INFO: renamed from: availableStorefrontCountryLocalesByLanguage$delegate, reason: from kotlin metadata */
            private final Lazy availableStorefrontCountryLocalesByLanguage;
            private final BackgroundStyles background;

            /* JADX INFO: renamed from: currencyLocale$delegate, reason: from kotlin metadata */
            private final State currencyLocale;
            private final Map<String, CustomVariableValue> customVariables;
            private final Function0 dateProvider;
            private final Map<String, CustomVariableValue> defaultCustomVariables;
            private final ComponentStyle header;
            private int headerHeightPx;
            private final String initialSelectedPackageOutsideTabs;
            private final String initialSelectedPackageUniqueId;

            /* JADX INFO: renamed from: locale$delegate, reason: from kotlin metadata */
            private final State locale;

            /* JADX INFO: renamed from: localeId$delegate, reason: from kotlin metadata */
            private final MutableState localeId;
            private final NonEmptySet<LocaleId> locales;
            private final boolean mainStackHasHeroImage;
            private final Map<String, CustomVariableValue> mergedCustomVariables;

            /* JADX INFO: renamed from: mostExpensivePricePerMonthMicros$delegate, reason: from kotlin metadata */
            private final State mostExpensivePricePerMonthMicros;
            private final Offering offering;
            private final AvailablePackages packages;
            private final Set<String> packagesOutsideTabsUniqueIds;
            private final PurchasesType purchases;

            /* JADX INFO: renamed from: selectedOfferEligibility$delegate, reason: from kotlin metadata */
            private final State selectedOfferEligibility;
            private final SnapshotStateMap selectedPackageByTab;

            /* JADX INFO: renamed from: selectedPackageInfo$delegate, reason: from kotlin metadata */
            private final State selectedPackageInfo;

            /* JADX INFO: renamed from: selectedPackageUniqueId$delegate, reason: from kotlin metadata */
            private final MutableState selectedPackageUniqueId;

            /* JADX INFO: renamed from: selectedTabIndex$delegate, reason: from kotlin metadata */
            private final MutableIntState selectedTabIndex;
            private final SimpleSheetState sheet;
            private final boolean showPricesWithDecimals;
            private final ComponentStyle stack;
            private final ComponentStyle stickyFooter;
            private final String storefrontCountryCode;
            private final Map<String, Set<Integer>> tabsByUniqueId;
            private final UiConfig.VariableConfig variableConfig;
            private final VariableDataProvider variableDataProvider;

            /* JADX WARN: Multi-variable type inference failed */
            public Components(ComponentStyle stack, ComponentStyle componentStyle, ComponentStyle componentStyle2, BackgroundStyles background, boolean z, boolean z2, UiConfig.VariableConfig variableConfig, VariableDataProvider variableDataProvider, Offering offering, NonEmptySet<LocaleId> locales, String str, Function0 dateProvider, AvailablePackages packages, Map<String, ? extends CustomVariableValue> customVariables, Map<String, ? extends CustomVariableValue> defaultCustomVariables, LocaleList initialLocaleList, Integer num, SimpleSheetState initialSheetState, PurchasesType purchases) {
                Object next;
                AvailablePackages.Info info;
                Object next2;
                Intrinsics.checkNotNullParameter(stack, "stack");
                Intrinsics.checkNotNullParameter(background, "background");
                Intrinsics.checkNotNullParameter(variableConfig, "variableConfig");
                Intrinsics.checkNotNullParameter(variableDataProvider, "variableDataProvider");
                Intrinsics.checkNotNullParameter(offering, "offering");
                Intrinsics.checkNotNullParameter(locales, "locales");
                Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
                Intrinsics.checkNotNullParameter(packages, "packages");
                Intrinsics.checkNotNullParameter(customVariables, "customVariables");
                Intrinsics.checkNotNullParameter(defaultCustomVariables, "defaultCustomVariables");
                Intrinsics.checkNotNullParameter(initialLocaleList, "initialLocaleList");
                Intrinsics.checkNotNullParameter(initialSheetState, "initialSheetState");
                Intrinsics.checkNotNullParameter(purchases, "purchases");
                this.stack = stack;
                this.header = componentStyle;
                this.stickyFooter = componentStyle2;
                this.background = background;
                this.mainStackHasHeroImage = z;
                this.showPricesWithDecimals = z2;
                this.variableConfig = variableConfig;
                this.variableDataProvider = variableDataProvider;
                this.offering = offering;
                this.locales = locales;
                this.storefrontCountryCode = str;
                this.dateProvider = dateProvider;
                this.packages = packages;
                this.customVariables = customVariables;
                this.defaultCustomVariables = defaultCustomVariables;
                this.purchases = purchases;
                this.mergedCustomVariables = MapsKt.plus(defaultCustomVariables, customVariables);
                Iterator<T> it = packages.getPackagesOutsideTabs().iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!((AvailablePackages.Info) next).isSelectedByDefault());
                AvailablePackages.Info info2 = (AvailablePackages.Info) next;
                this.initialSelectedPackageOutsideTabs = info2 != null ? info2.getUniqueId() : null;
                List<AvailablePackages.Info> packagesOutsideTabs = this.packages.getPackagesOutsideTabs();
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                Iterator<T> it2 = packagesOutsideTabs.iterator();
                while (it2.hasNext()) {
                    linkedHashSet.add(((AvailablePackages.Info) it2.next()).getUniqueId());
                }
                this.packagesOutsideTabsUniqueIds = linkedHashSet;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<Integer, List<AvailablePackages.Info>> entry : this.packages.getPackagesByTab().entrySet()) {
                    int iIntValue = entry.getKey().intValue();
                    Iterator<T> it3 = entry.getValue().iterator();
                    while (it3.hasNext()) {
                        String uniqueId = ((AvailablePackages.Info) it3.next()).getUniqueId();
                        linkedHashMap.put(uniqueId, SetsKt.plus((Set) linkedHashMap.getOrDefault(uniqueId, SetsKt.emptySet()), Integer.valueOf(iIntValue)));
                    }
                }
                this.tabsByUniqueId = linkedHashMap;
                this.localeId = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(LocaleId.m3953boximpl(m4419toLocaleId8pYHj4M(initialLocaleList)), null, 2, null);
                this.availableStorefrontCountryLocalesByLanguage = LazyKt.lazy(new Function0() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Components$availableStorefrontCountryLocalesByLanguage$2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Map<String, Locale> invoke() {
                        String str2 = this.this$0.storefrontCountryCode;
                        if (str2 == null || StringsKt.isBlank(str2)) {
                            return MapsKt.emptyMap();
                        }
                        PaywallState.Loaded.Components components = this.this$0;
                        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
                        Locale[] availableLocales = Locale.getAvailableLocales();
                        Intrinsics.checkNotNullExpressionValue(availableLocales, "getAvailableLocales()");
                        for (Locale availableLocale : availableLocales) {
                            if (StringsKt.equals(availableLocale.getCountry(), components.storefrontCountryCode, true)) {
                                String language = availableLocale.getLanguage();
                                Intrinsics.checkNotNullExpressionValue(language, "availableLocale.language");
                                String lowerCase = language.toLowerCase(Locale.ROOT);
                                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                Intrinsics.checkNotNullExpressionValue(availableLocale, "availableLocale");
                                mapCreateMapBuilder.put(lowerCase, availableLocale);
                            }
                        }
                        return MapsKt.build(mapCreateMapBuilder);
                    }
                });
                this.locale = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Components$locale$2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final androidx.compose.ui.text.intl.Locale invoke() {
                        return LocalizationKt.m4083toComposeLocale_KYeFs0(this.this$0.m4417getLocaleIduqtKvyA());
                    }
                });
                this.currencyLocale = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Components$currencyLocale$2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final androidx.compose.ui.text.intl.Locale invoke() {
                        String str2 = this.this$0.storefrontCountryCode;
                        if (str2 == null || StringsKt.isBlank(str2)) {
                            return this.this$0.getLocale();
                        }
                        String language = this.this$0.getLocale().getLanguage();
                        Locale locale = Locale.ROOT;
                        String lowerCase = language.toLowerCase(locale);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        Locale javaLocale = (Locale) this.this$0.getAvailableStorefrontCountryLocalesByLanguage().get(lowerCase);
                        if (javaLocale == null && (javaLocale = (Locale) CollectionsKt.firstOrNull(this.this$0.getAvailableStorefrontCountryLocalesByLanguage().values())) == null) {
                            Locale.Builder locale2 = new Locale.Builder().setLocale(LocalizationKt.toJavaLocale(this.this$0.getLocale()));
                            String upperCase = this.this$0.storefrontCountryCode.toUpperCase(locale);
                            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                            javaLocale = locale2.setRegion(upperCase).build();
                        }
                        Intrinsics.checkNotNullExpressionValue(javaLocale, "javaLocale");
                        return LocalizationKt.toComposeLocale(javaLocale);
                    }
                });
                SnapshotStateMap snapshotStateMapMutableStateMapOf = SnapshotStateKt.mutableStateMapOf();
                Map<Integer, List<AvailablePackages.Info>> packagesByTab = this.packages.getPackagesByTab();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(packagesByTab.size()));
                Iterator<T> it4 = packagesByTab.entrySet().iterator();
                while (it4.hasNext()) {
                    Map.Entry entry2 = (Map.Entry) it4.next();
                    Object key = entry2.getKey();
                    Iterator it5 = ((List) entry2.getValue()).iterator();
                    do {
                        if (!it5.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it5.next();
                    } while (!((AvailablePackages.Info) next2).isSelectedByDefault());
                    AvailablePackages.Info info3 = (AvailablePackages.Info) next2;
                    linkedHashMap2.put(key, info3 != null ? info3.getUniqueId() : null);
                }
                snapshotStateMapMutableStateMapOf.putAll(linkedHashMap2);
                this.selectedPackageByTab = snapshotStateMapMutableStateMapOf;
                this.selectedTabIndex = SnapshotIntStateKt.mutableIntStateOf(num != null ? num.intValue() : 0);
                String uniqueId2 = this.initialSelectedPackageOutsideTabs;
                if (uniqueId2 == null && (uniqueId2 = (String) snapshotStateMapMutableStateMapOf.get(Integer.valueOf(getSelectedTabIndex()))) == null) {
                    List<AvailablePackages.Info> list = this.packages.getPackagesByTab().get(Integer.valueOf(getSelectedTabIndex()));
                    uniqueId2 = (list == null || (info = (AvailablePackages.Info) CollectionsKt.firstOrNull((List) list)) == null) ? null : info.getUniqueId();
                }
                this.initialSelectedPackageUniqueId = uniqueId2;
                this.selectedPackageUniqueId = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(uniqueId2, null, 2, null);
                this.selectedPackageInfo = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Components$selectedPackageInfo$2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final PaywallState.Loaded.Components.SelectedPackageInfo invoke() {
                        PaywallState.Loaded.Components.AvailablePackages.Info infoFindPackageInfoByUniqueId;
                        String selectedPackageUniqueId = this.this$0.getSelectedPackageUniqueId();
                        if (selectedPackageUniqueId == null || (infoFindPackageInfoByUniqueId = this.this$0.findPackageInfoByUniqueId(selectedPackageUniqueId)) == null) {
                            return null;
                        }
                        return new PaywallState.Loaded.Components.SelectedPackageInfo(infoFindPackageInfoByUniqueId.getPkg(), infoFindPackageInfoByUniqueId.getResolvedOffer(), selectedPackageUniqueId, PackageExtensionsKt.calculateOfferEligibility(infoFindPackageInfoByUniqueId.getResolvedOffer(), infoFindPackageInfoByUniqueId.getPkg()));
                    }
                });
                this.selectedOfferEligibility = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Components$selectedOfferEligibility$2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final OfferEligibility invoke() {
                        OfferEligibility offerEligibility;
                        PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo = this.this$0.getSelectedPackageInfo();
                        return (selectedPackageInfo == null || (offerEligibility = selectedPackageInfo.getOfferEligibility()) == null) ? OfferEligibility.Ineligible.INSTANCE : offerEligibility;
                    }
                });
                this.mostExpensivePricePerMonthMicros = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Components$mostExpensivePricePerMonthMicros$2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Long invoke() {
                        PaywallState.Loaded.Components components = this.this$0;
                        List<PaywallState.Loaded.Components.AvailablePackages.Info> packagesOutsideTabs2 = components.packages.getPackagesOutsideTabs();
                        List<PaywallState.Loaded.Components.AvailablePackages.Info> listEmptyList = this.this$0.packages.getPackagesByTab().get(Integer.valueOf(this.this$0.getSelectedTabIndex()));
                        if (listEmptyList == null) {
                            listEmptyList = CollectionsKt.emptyList();
                        }
                        return components.mostExpensivePricePerMonthMicros(CollectionsKt.plus((Collection) packagesOutsideTabs2, (Iterable) listEmptyList));
                    }
                });
                this.actionInProgress = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                this.sheet = initialSheetState;
            }

            public final ComponentStyle getStack() {
                return this.stack;
            }

            public final ComponentStyle getHeader() {
                return this.header;
            }

            public final ComponentStyle getStickyFooter() {
                return this.stickyFooter;
            }

            public final BackgroundStyles getBackground() {
                return this.background;
            }

            public final boolean getMainStackHasHeroImage() {
                return this.mainStackHasHeroImage;
            }

            public final boolean getShowPricesWithDecimals() {
                return this.showPricesWithDecimals;
            }

            public final UiConfig.VariableConfig getVariableConfig() {
                return this.variableConfig;
            }

            public final VariableDataProvider getVariableDataProvider() {
                return this.variableDataProvider;
            }

            @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallState.Loaded
            public Offering getOffering() {
                return this.offering;
            }

            public /* synthetic */ Components(ComponentStyle componentStyle, ComponentStyle componentStyle2, ComponentStyle componentStyle3, BackgroundStyles backgroundStyles, boolean z, boolean z2, UiConfig.VariableConfig variableConfig, VariableDataProvider variableDataProvider, Offering offering, NonEmptySet nonEmptySet, String str, Function0 function0, AvailablePackages availablePackages, Map map, Map map2, LocaleList localeList, Integer num, SimpleSheetState simpleSheetState, PurchasesType purchasesType, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(componentStyle, componentStyle2, componentStyle3, backgroundStyles, (i & 16) != 0 ? false : z, z2, variableConfig, variableDataProvider, offering, nonEmptySet, str, function0, availablePackages, (i & 8192) != 0 ? MapsKt.emptyMap() : map, (i & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? MapsKt.emptyMap() : map2, (32768 & i) != 0 ? LocaleList.Companion.getCurrent() : localeList, (65536 & i) != 0 ? null : num, (i & 131072) != 0 ? new SimpleSheetState() : simpleSheetState, purchasesType);
            }

            public final Map<String, CustomVariableValue> getCustomVariables() {
                return this.customVariables;
            }

            public final Map<String, CustomVariableValue> getDefaultCustomVariables() {
                return this.defaultCustomVariables;
            }

            public final Map<String, CustomVariableValue> getMergedCustomVariables() {
                return this.mergedCustomVariables;
            }

            @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u001bB-\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0006¢\u0006\u0002\u0010\bJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u001b\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0006HÆ\u0003J5\u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u001a\b\u0002\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001J\u0010\u0010\u0017\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u0000J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR#\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$AvailablePackages;", "", "packagesOutsideTabs", "", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$AvailablePackages$Info;", "packagesByTab", "", "", "(Ljava/util/List;Ljava/util/Map;)V", "hasAnyPackages", "", "getHasAnyPackages", "()Z", "getPackagesByTab", "()Ljava/util/Map;", "getPackagesOutsideTabs", "()Ljava/util/List;", "component1", "component2", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "merge", "with", "toString", "", "Info", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final /* data */ class AvailablePackages {
                public static final int $stable = 8;
                private final Map<Integer, List<Info>> packagesByTab;
                private final List<Info> packagesOutsideTabs;

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ AvailablePackages copy$default(AvailablePackages availablePackages, List list, Map map, int i, Object obj) {
                    if ((i & 1) != 0) {
                        list = availablePackages.packagesOutsideTabs;
                    }
                    if ((i & 2) != 0) {
                        map = availablePackages.packagesByTab;
                    }
                    return availablePackages.copy(list, map);
                }

                public final List<Info> component1() {
                    return this.packagesOutsideTabs;
                }

                public final Map<Integer, List<Info>> component2() {
                    return this.packagesByTab;
                }

                public final AvailablePackages copy(List<Info> packagesOutsideTabs, Map<Integer, ? extends List<Info>> packagesByTab) {
                    Intrinsics.checkNotNullParameter(packagesOutsideTabs, "packagesOutsideTabs");
                    Intrinsics.checkNotNullParameter(packagesByTab, "packagesByTab");
                    return new AvailablePackages(packagesOutsideTabs, packagesByTab);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof AvailablePackages)) {
                        return false;
                    }
                    AvailablePackages availablePackages = (AvailablePackages) other;
                    return Intrinsics.areEqual(this.packagesOutsideTabs, availablePackages.packagesOutsideTabs) && Intrinsics.areEqual(this.packagesByTab, availablePackages.packagesByTab);
                }

                public int hashCode() {
                    return (this.packagesOutsideTabs.hashCode() * 31) + this.packagesByTab.hashCode();
                }

                public String toString() {
                    return "AvailablePackages(packagesOutsideTabs=" + this.packagesOutsideTabs + ", packagesByTab=" + this.packagesByTab + ')';
                }

                /* JADX WARN: Multi-variable type inference failed */
                public AvailablePackages(List<Info> packagesOutsideTabs, Map<Integer, ? extends List<Info>> packagesByTab) {
                    Intrinsics.checkNotNullParameter(packagesOutsideTabs, "packagesOutsideTabs");
                    Intrinsics.checkNotNullParameter(packagesByTab, "packagesByTab");
                    this.packagesOutsideTabs = packagesOutsideTabs;
                    this.packagesByTab = packagesByTab;
                }

                public final List<Info> getPackagesOutsideTabs() {
                    return this.packagesOutsideTabs;
                }

                public final Map<Integer, List<Info>> getPackagesByTab() {
                    return this.packagesByTab;
                }

                @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$AvailablePackages$Info;", "", "pkg", "Lcom/revenuecat/purchases/Package;", "isSelectedByDefault", "", "resolvedOffer", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "(Lcom/revenuecat/purchases/Package;ZLcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;)V", "()Z", "getPkg", "()Lcom/revenuecat/purchases/Package;", "getResolvedOffer", "()Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "uniqueId", "", "getUniqueId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
                public static final /* data */ class Info {
                    public static final int $stable = 8;
                    private final boolean isSelectedByDefault;
                    private final Package pkg;
                    private final ResolvedOffer resolvedOffer;
                    private final String uniqueId;

                    public static /* synthetic */ Info copy$default(Info info, Package r1, boolean z, ResolvedOffer resolvedOffer, int i, Object obj) {
                        if ((i & 1) != 0) {
                            r1 = info.pkg;
                        }
                        if ((i & 2) != 0) {
                            z = info.isSelectedByDefault;
                        }
                        if ((i & 4) != 0) {
                            resolvedOffer = info.resolvedOffer;
                        }
                        return info.copy(r1, z, resolvedOffer);
                    }

                    /* JADX INFO: renamed from: component1, reason: from getter */
                    public final Package getPkg() {
                        return this.pkg;
                    }

                    /* JADX INFO: renamed from: component2, reason: from getter */
                    public final boolean getIsSelectedByDefault() {
                        return this.isSelectedByDefault;
                    }

                    /* JADX INFO: renamed from: component3, reason: from getter */
                    public final ResolvedOffer getResolvedOffer() {
                        return this.resolvedOffer;
                    }

                    public final Info copy(Package pkg, boolean isSelectedByDefault, ResolvedOffer resolvedOffer) {
                        Intrinsics.checkNotNullParameter(pkg, "pkg");
                        return new Info(pkg, isSelectedByDefault, resolvedOffer);
                    }

                    public boolean equals(Object other) {
                        if (this == other) {
                            return true;
                        }
                        if (!(other instanceof Info)) {
                            return false;
                        }
                        Info info = (Info) other;
                        return Intrinsics.areEqual(this.pkg, info.pkg) && this.isSelectedByDefault == info.isSelectedByDefault && Intrinsics.areEqual(this.resolvedOffer, info.resolvedOffer);
                    }

                    public int hashCode() {
                        int iHashCode = ((this.pkg.hashCode() * 31) + Boolean.hashCode(this.isSelectedByDefault)) * 31;
                        ResolvedOffer resolvedOffer = this.resolvedOffer;
                        return iHashCode + (resolvedOffer == null ? 0 : resolvedOffer.hashCode());
                    }

                    public String toString() {
                        return "Info(pkg=" + this.pkg + ", isSelectedByDefault=" + this.isSelectedByDefault + ", resolvedOffer=" + this.resolvedOffer + ')';
                    }

                    public Info(Package pkg, boolean z, ResolvedOffer resolvedOffer) {
                        String identifier;
                        SubscriptionOption option;
                        Intrinsics.checkNotNullParameter(pkg, "pkg");
                        this.pkg = pkg;
                        this.isSelectedByDefault = z;
                        this.resolvedOffer = resolvedOffer;
                        String str = null;
                        ResolvedOffer.ConfiguredOffer configuredOffer = resolvedOffer instanceof ResolvedOffer.ConfiguredOffer ? (ResolvedOffer.ConfiguredOffer) resolvedOffer : null;
                        if (configuredOffer != null && (option = configuredOffer.getOption()) != null) {
                            str = option.get$id();
                        }
                        if (str != null) {
                            identifier = pkg.getIdentifier() + ':' + str;
                        } else {
                            identifier = pkg.getIdentifier();
                        }
                        this.uniqueId = identifier;
                    }

                    public /* synthetic */ Info(Package r1, boolean z, ResolvedOffer resolvedOffer, int i, DefaultConstructorMarker defaultConstructorMarker) {
                        this(r1, z, (i & 4) != 0 ? null : resolvedOffer);
                    }

                    public final Package getPkg() {
                        return this.pkg;
                    }

                    public final boolean isSelectedByDefault() {
                        return this.isSelectedByDefault;
                    }

                    public final ResolvedOffer getResolvedOffer() {
                        return this.resolvedOffer;
                    }

                    public final String getUniqueId() {
                        return this.uniqueId;
                    }
                }

                public final AvailablePackages merge(AvailablePackages with) {
                    List<Info> list = this.packagesOutsideTabs;
                    List<Info> listEmptyList = with != null ? with.packagesOutsideTabs : null;
                    if (listEmptyList == null) {
                        listEmptyList = CollectionsKt.emptyList();
                    }
                    List listPlus = CollectionsKt.plus((Collection) list, (Iterable) listEmptyList);
                    Map<Integer, List<Info>> mapEmptyMap = this.packagesByTab;
                    if (mapEmptyMap.isEmpty()) {
                        Map<Integer, List<Info>> map = with != null ? with.packagesByTab : null;
                        mapEmptyMap = map == null ? MapsKt.emptyMap() : map;
                    }
                    return new AvailablePackages(listPlus, mapEmptyMap);
                }

                public final boolean getHasAnyPackages() {
                    return (this.packagesOutsideTabs.isEmpty() && this.packagesByTab.isEmpty()) ? false : true;
                }
            }

            @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J3\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$SelectedPackageInfo;", "", "rcPackage", "Lcom/revenuecat/purchases/Package;", "resolvedOffer", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "uniqueId", "", "offerEligibility", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "(Lcom/revenuecat/purchases/Package;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;Ljava/lang/String;Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;)V", "getOfferEligibility", "()Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "getRcPackage", "()Lcom/revenuecat/purchases/Package;", "getResolvedOffer", "()Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "getUniqueId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "", "toString", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final /* data */ class SelectedPackageInfo {
                public static final int $stable = 8;
                private final OfferEligibility offerEligibility;
                private final Package rcPackage;
                private final ResolvedOffer resolvedOffer;
                private final String uniqueId;

                public static /* synthetic */ SelectedPackageInfo copy$default(SelectedPackageInfo selectedPackageInfo, Package r1, ResolvedOffer resolvedOffer, String str, OfferEligibility offerEligibility, int i, Object obj) {
                    if ((i & 1) != 0) {
                        r1 = selectedPackageInfo.rcPackage;
                    }
                    if ((i & 2) != 0) {
                        resolvedOffer = selectedPackageInfo.resolvedOffer;
                    }
                    if ((i & 4) != 0) {
                        str = selectedPackageInfo.uniqueId;
                    }
                    if ((i & 8) != 0) {
                        offerEligibility = selectedPackageInfo.offerEligibility;
                    }
                    return selectedPackageInfo.copy(r1, resolvedOffer, str, offerEligibility);
                }

                /* JADX INFO: renamed from: component1, reason: from getter */
                public final Package getRcPackage() {
                    return this.rcPackage;
                }

                /* JADX INFO: renamed from: component2, reason: from getter */
                public final ResolvedOffer getResolvedOffer() {
                    return this.resolvedOffer;
                }

                /* JADX INFO: renamed from: component3, reason: from getter */
                public final String getUniqueId() {
                    return this.uniqueId;
                }

                /* JADX INFO: renamed from: component4, reason: from getter */
                public final OfferEligibility getOfferEligibility() {
                    return this.offerEligibility;
                }

                public final SelectedPackageInfo copy(Package rcPackage, ResolvedOffer resolvedOffer, String uniqueId, OfferEligibility offerEligibility) {
                    Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
                    Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
                    Intrinsics.checkNotNullParameter(offerEligibility, "offerEligibility");
                    return new SelectedPackageInfo(rcPackage, resolvedOffer, uniqueId, offerEligibility);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof SelectedPackageInfo)) {
                        return false;
                    }
                    SelectedPackageInfo selectedPackageInfo = (SelectedPackageInfo) other;
                    return Intrinsics.areEqual(this.rcPackage, selectedPackageInfo.rcPackage) && Intrinsics.areEqual(this.resolvedOffer, selectedPackageInfo.resolvedOffer) && Intrinsics.areEqual(this.uniqueId, selectedPackageInfo.uniqueId) && Intrinsics.areEqual(this.offerEligibility, selectedPackageInfo.offerEligibility);
                }

                public int hashCode() {
                    int iHashCode = this.rcPackage.hashCode() * 31;
                    ResolvedOffer resolvedOffer = this.resolvedOffer;
                    return ((((iHashCode + (resolvedOffer == null ? 0 : resolvedOffer.hashCode())) * 31) + this.uniqueId.hashCode()) * 31) + this.offerEligibility.hashCode();
                }

                public String toString() {
                    return "SelectedPackageInfo(rcPackage=" + this.rcPackage + ", resolvedOffer=" + this.resolvedOffer + ", uniqueId=" + this.uniqueId + ", offerEligibility=" + this.offerEligibility + ')';
                }

                public SelectedPackageInfo(Package rcPackage, ResolvedOffer resolvedOffer, String uniqueId, OfferEligibility offerEligibility) {
                    Intrinsics.checkNotNullParameter(rcPackage, "rcPackage");
                    Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
                    Intrinsics.checkNotNullParameter(offerEligibility, "offerEligibility");
                    this.rcPackage = rcPackage;
                    this.resolvedOffer = resolvedOffer;
                    this.uniqueId = uniqueId;
                    this.offerEligibility = offerEligibility;
                }

                public /* synthetic */ SelectedPackageInfo(Package r1, ResolvedOffer resolvedOffer, String str, OfferEligibility offerEligibility, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this(r1, (i & 2) != 0 ? null : resolvedOffer, str, offerEligibility);
                }

                public final Package getRcPackage() {
                    return this.rcPackage;
                }

                public final ResolvedOffer getResolvedOffer() {
                    return this.resolvedOffer;
                }

                public final String getUniqueId() {
                    return this.uniqueId;
                }

                public final OfferEligibility getOfferEligibility() {
                    return this.offerEligibility;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX INFO: renamed from: getLocaleId-uqtKvyA, reason: not valid java name */
            public final String m4417getLocaleIduqtKvyA() {
                return ((LocaleId) this.localeId.getValue()).m3959unboximpl();
            }

            /* JADX INFO: renamed from: setLocaleId-_KYeFs0, reason: not valid java name */
            private final void m4418setLocaleId_KYeFs0(String str) {
                this.localeId.setValue(LocaleId.m3953boximpl(str));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final Map<String, Locale> getAvailableStorefrontCountryLocalesByLanguage() {
                return (Map) this.availableStorefrontCountryLocalesByLanguage.getValue();
            }

            public final androidx.compose.ui.text.intl.Locale getLocale() {
                return (androidx.compose.ui.text.intl.Locale) this.locale.getValue();
            }

            public final androidx.compose.ui.text.intl.Locale getCurrencyLocale() {
                return (androidx.compose.ui.text.intl.Locale) this.currencyLocale.getValue();
            }

            private final void setSelectedTabIndex(int i) {
                this.selectedTabIndex.setIntValue(i);
            }

            public final int getSelectedTabIndex() {
                return this.selectedTabIndex.getIntValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final String getSelectedPackageUniqueId() {
                return (String) this.selectedPackageUniqueId.getValue();
            }

            private final void setSelectedPackageUniqueId(String str) {
                this.selectedPackageUniqueId.setValue(str);
            }

            public final SelectedPackageInfo getSelectedPackageInfo() {
                return (SelectedPackageInfo) this.selectedPackageInfo.getValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final AvailablePackages.Info findPackageInfoByUniqueId(String uniqueId) {
                Object obj;
                Object next;
                Iterator<T> it = this.packages.getPackagesOutsideTabs().iterator();
                do {
                    obj = null;
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.areEqual(((AvailablePackages.Info) next).getUniqueId(), uniqueId));
                AvailablePackages.Info info = (AvailablePackages.Info) next;
                if (info != null) {
                    return info;
                }
                for (Object obj2 : CollectionsKt.flatten(this.packages.getPackagesByTab().values())) {
                    if (Intrinsics.areEqual(((AvailablePackages.Info) obj2).getUniqueId(), uniqueId)) {
                        obj = obj2;
                        break;
                    }
                }
                return (AvailablePackages.Info) obj;
            }

            public final OfferEligibility getSelectedOfferEligibility() {
                return (OfferEligibility) this.selectedOfferEligibility.getValue();
            }

            public final Long getMostExpensivePricePerMonthMicros() {
                return (Long) this.mostExpensivePricePerMonthMicros.getValue();
            }

            public final Date getCurrentDate() {
                return (Date) this.dateProvider.invoke();
            }

            public final /* synthetic */ int getHeaderHeightPx() {
                return this.headerHeightPx;
            }

            public final /* synthetic */ void setHeaderHeightPx$revenuecatui_defaultsBc8Release(int i) {
                this.headerHeightPx = i;
            }

            private final void setActionInProgress(boolean z) {
                this.actionInProgress.setValue(Boolean.valueOf(z));
            }

            public final boolean getActionInProgress() {
                return ((Boolean) this.actionInProgress.getValue()).booleanValue();
            }

            public final SimpleSheetState getSheet() {
                return this.sheet;
            }

            public static /* synthetic */ void update$default(Components components, android.os.LocaleList localeList, Integer num, Boolean bool, int i, Object obj) {
                if ((i & 1) != 0) {
                    localeList = null;
                }
                if ((i & 2) != 0) {
                    num = null;
                }
                if ((i & 4) != 0) {
                    bool = null;
                }
                components.update(localeList, num, bool);
            }

            public final void update(android.os.LocaleList localeList, Integer selectedTabIndex, Boolean actionInProgress) {
                AvailablePackages.Info info;
                if (localeList != null) {
                    String languageTags = localeList.toLanguageTags();
                    Intrinsics.checkNotNullExpressionValue(languageTags, "localeList.toLanguageTags()");
                    m4418setLocaleId_KYeFs0(m4419toLocaleId8pYHj4M(new LocaleList(languageTags)));
                }
                if (selectedTabIndex != null) {
                    setSelectedTabIndex(selectedTabIndex.intValue());
                    if (getSelectedPackageUniqueId() != null && CollectionsKt.contains(this.packagesOutsideTabsUniqueIds, getSelectedPackageUniqueId())) {
                        return;
                    }
                    String uniqueId = (String) this.selectedPackageByTab.get(selectedTabIndex);
                    if (uniqueId == null && (uniqueId = this.initialSelectedPackageOutsideTabs) == null) {
                        List<AvailablePackages.Info> list = this.packages.getPackagesByTab().get(selectedTabIndex);
                        if (list == null || (info = (AvailablePackages.Info) CollectionsKt.firstOrNull((List) list)) == null || (uniqueId = info.getUniqueId()) == null) {
                            uniqueId = null;
                        } else {
                            Logger.INSTANCE.w("Could not find default package for tab " + selectedTabIndex + ". Using first package instead. This could be caused by not having any package marked as selected by default.");
                        }
                    }
                    setSelectedPackageUniqueId(uniqueId);
                }
                if (actionInProgress != null) {
                    setActionInProgress(actionInProgress.booleanValue());
                }
            }

            public final void update(String selectedPackageUniqueId) {
                Intrinsics.checkNotNullParameter(selectedPackageUniqueId, "selectedPackageUniqueId");
                setSelectedPackageUniqueId(selectedPackageUniqueId);
                int selectedTabIndex = getSelectedTabIndex();
                Set<Integer> set = this.tabsByUniqueId.get(selectedPackageUniqueId);
                if (set == null || !set.contains(Integer.valueOf(selectedTabIndex))) {
                    return;
                }
                this.selectedPackageByTab.put(Integer.valueOf(selectedTabIndex), selectedPackageUniqueId);
            }

            /* JADX WARN: Code duplicated, block: B:15:0x003b  */
            /* JADX WARN: Code duplicated, block: B:17:0x003f  */
            public final void resetToDefaultPackage() {
                String uniqueId;
                Object next;
                List<AvailablePackages.Info> list = this.packages.getPackagesByTab().get(Integer.valueOf(getSelectedTabIndex()));
                if (list != null) {
                    Iterator<T> it = list.iterator();
                    do {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                    } while (!((AvailablePackages.Info) next).isSelectedByDefault());
                    AvailablePackages.Info info = (AvailablePackages.Info) next;
                    if (info == null || (uniqueId = info.getUniqueId()) == null) {
                        uniqueId = this.initialSelectedPackageOutsideTabs;
                        if (uniqueId == null) {
                            uniqueId = (String) this.selectedPackageByTab.get(Integer.valueOf(getSelectedTabIndex()));
                        }
                    }
                } else {
                    uniqueId = this.initialSelectedPackageOutsideTabs;
                    if (uniqueId == null) {
                        uniqueId = (String) this.selectedPackageByTab.get(Integer.valueOf(getSelectedTabIndex()));
                    }
                }
                setSelectedPackageUniqueId(uniqueId);
            }

            public final String peekDefaultPackageUniqueIdAfterSheetDismiss() {
                Object next;
                String uniqueId;
                List<AvailablePackages.Info> list = this.packages.getPackagesByTab().get(Integer.valueOf(getSelectedTabIndex()));
                if (list != null) {
                    Iterator<T> it = list.iterator();
                    do {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                    } while (!((AvailablePackages.Info) next).isSelectedByDefault());
                    AvailablePackages.Info info = (AvailablePackages.Info) next;
                    if (info != null && (uniqueId = info.getUniqueId()) != null) {
                        return uniqueId;
                    }
                }
                String str = this.initialSelectedPackageOutsideTabs;
                return str == null ? (String) this.selectedPackageByTab.get(Integer.valueOf(getSelectedTabIndex())) : str;
            }

            public final SelectedPackageInfo peekSelectedPackageInfoAfterSheetDismiss() {
                String strPeekDefaultPackageUniqueIdAfterSheetDismiss = peekDefaultPackageUniqueIdAfterSheetDismiss();
                AvailablePackages.Info infoFindPackageInfoByUniqueId = strPeekDefaultPackageUniqueIdAfterSheetDismiss != null ? findPackageInfoByUniqueId(strPeekDefaultPackageUniqueIdAfterSheetDismiss) : null;
                if (strPeekDefaultPackageUniqueIdAfterSheetDismiss == null || infoFindPackageInfoByUniqueId == null) {
                    return null;
                }
                return new SelectedPackageInfo(infoFindPackageInfoByUniqueId.getPkg(), infoFindPackageInfoByUniqueId.getResolvedOffer(), strPeekDefaultPackageUniqueIdAfterSheetDismiss, PackageExtensionsKt.calculateOfferEligibility(infoFindPackageInfoByUniqueId.getResolvedOffer(), infoFindPackageInfoByUniqueId.getPkg()));
            }

            public final Package defaultPackageForPackageRowAnalytics() {
                AvailablePackages.Info infoFindPackageInfoByUniqueId;
                String strPeekDefaultPackageUniqueIdAfterSheetDismiss = peekDefaultPackageUniqueIdAfterSheetDismiss();
                if (strPeekDefaultPackageUniqueIdAfterSheetDismiss == null || (infoFindPackageInfoByUniqueId = findPackageInfoByUniqueId(strPeekDefaultPackageUniqueIdAfterSheetDismiss)) == null) {
                    return null;
                }
                return infoFindPackageInfoByUniqueId.getPkg();
            }

            /* JADX INFO: renamed from: toLocaleId-8pYHj4M, reason: not valid java name */
            private final String m4419toLocaleId8pYHj4M(LocaleList localeList) {
                String localeId;
                String preferredUILocaleOverride = this.purchases.getPreferredUILocaleOverride();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(localeList, 10));
                Iterator<E> it = localeList.iterator();
                while (it.hasNext()) {
                    arrayList.add(LocaleId.m3953boximpl(LocalizationKt.toLocaleId((androidx.compose.ui.text.intl.Locale) it.next())));
                }
                List listPlus = CollectionsKt.plus((Collection) arrayList, this.locales.getHead());
                LocaleId localeId2 = null;
                if (preferredUILocaleOverride != null) {
                    try {
                        localeId = LocalizationKt.toLocaleId(LocalizationKt.toComposeLocale(LocaleHelpersKt.createLocaleFromString(preferredUILocaleOverride)));
                    } catch (Exception unused) {
                        localeId = null;
                    }
                    if (localeId != null) {
                        listPlus = CollectionsKt.plus((Collection) CollectionsKt.listOf(LocaleId.m3953boximpl(localeId)), (Iterable) listPlus);
                    }
                }
                Iterator it2 = listPlus.iterator();
                while (it2.hasNext()) {
                    String strM4078getBestMatch64pKzr8 = LocalizationKt.m4078getBestMatch64pKzr8(this.locales, ((LocaleId) it2.next()).m3959unboximpl());
                    LocaleId localeIdM3953boximpl = strM4078getBestMatch64pKzr8 != null ? LocaleId.m3953boximpl(strM4078getBestMatch64pKzr8) : null;
                    if (localeIdM3953boximpl != null) {
                        localeId2 = localeIdM3953boximpl;
                        break;
                    }
                }
                if (localeId2 != null) {
                    return localeId2.m3959unboximpl();
                }
                throw new NoSuchElementException("No element of the collection was transformed to a non-null value.");
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final Long mostExpensivePricePerMonthMicros(List<AvailablePackages.Info> list) {
                Object next;
                Iterator it = SequencesKt.mapNotNull(SequencesKt.map(CollectionsKt.asSequence(list), new Function1() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Components$mostExpensivePricePerMonthMicros$4
                    @Override // kotlin.jvm.functions.Function1
                    public final StoreProduct invoke(PaywallState.Loaded.Components.AvailablePackages.Info info) {
                        Intrinsics.checkNotNullParameter(info, "info");
                        return info.getPkg().getProduct();
                    }
                }), new Function1() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Components$mostExpensivePricePerMonthMicros$5
                    @Override // kotlin.jvm.functions.Function1
                    public final Price invoke(StoreProduct product) {
                        Intrinsics.checkNotNullParameter(product, "product");
                        return StoreProduct.pricePerMonth$default(product, null, 1, null);
                    }
                }).iterator();
                if (it.hasNext()) {
                    next = it.next();
                    if (it.hasNext()) {
                        long amountMicros = ((Price) next).getAmountMicros();
                        do {
                            Object next2 = it.next();
                            long amountMicros2 = ((Price) next2).getAmountMicros();
                            if (amountMicros < amountMicros2) {
                                next = next2;
                                amountMicros = amountMicros2;
                            }
                        } while (it.hasNext());
                    }
                } else {
                    next = null;
                }
                Price price = (Price) next;
                if (price != null) {
                    return Long.valueOf(price.getAmountMicros());
                }
                return null;
            }
        }
    }
}
