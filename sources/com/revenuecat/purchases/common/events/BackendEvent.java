package com.revenuecat.purchases.common.events;

import androidx.recyclerview.widget.LinearLayoutManager;
import com.amazon.a.a.o.b;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.customercenter.events.CustomerCenterDisplayMode;
import com.revenuecat.purchases.customercenter.events.CustomerCenterEventType;
import com.revenuecat.purchases.utils.Event;
import java.lang.annotation.Annotation;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import okhttp3.internal.http2.Http2;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u0000 \u00102\u00020\u0001:\u0006\u000f\u0010\u0011\u0012\u0013\u0014B\u0019\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0007J!\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eHÇ\u0001\u0082\u0001\u0004\u0015\u0016\u0017\u0018¨\u0006\u0019"}, d2 = {"Lcom/revenuecat/purchases/common/events/BackendEvent;", "Lcom/revenuecat/purchases/utils/Event;", "seen1", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "()V", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Ad", "Companion", "CustomPaywall", "CustomerCenter", "Paywalls", "PresentedOfferingContextData", "Lcom/revenuecat/purchases/common/events/BackendEvent$Ad;", "Lcom/revenuecat/purchases/common/events/BackendEvent$CustomPaywall;", "Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter;", "Lcom/revenuecat/purchases/common/events/BackendEvent$Paywalls;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class BackendEvent implements Event {
    public static final int AD_EVENT_SCHEMA_VERSION = 1;
    public static final int CUSTOMER_CENTER_EVENT_SCHEMA_VERSION = 1;
    public static final int CUSTOM_PAYWALL_EVENT_SCHEMA_VERSION = 1;
    public static final int PAYWALL_EVENT_SCHEMA_VERSION = 1;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.revenuecat.purchases.common.events.BackendEvent.Companion.1
        @Override // kotlin.jvm.functions.Function0
        public final KSerializer invoke() {
            return new SealedClassSerializer("com.revenuecat.purchases.common.events.BackendEvent", Reflection.getOrCreateKotlinClass(BackendEvent.class), new KClass[]{Reflection.getOrCreateKotlinClass(Ad.class), Reflection.getOrCreateKotlinClass(CustomPaywall.class), Reflection.getOrCreateKotlinClass(CustomerCenter.class), Reflection.getOrCreateKotlinClass(Paywalls.class)}, new KSerializer[]{BackendEvent$Ad$$serializer.INSTANCE, BackendEvent$CustomPaywall$$serializer.INSTANCE, BackendEvent$CustomerCenter$$serializer.INSTANCE, BackendEvent$Paywalls$$serializer.INSTANCE}, new Annotation[0]);
        }
    });

    public /* synthetic */ BackendEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final /* synthetic */ void write$Self(BackendEvent self, CompositeEncoder output, SerialDescriptor serialDesc) {
    }

    private BackendEvent() {
    }

    @Deprecated
    public /* synthetic */ BackendEvent(int i, SerializationConstructorMarker serializationConstructorMarker) {
    }

    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 O2\u00020\u0001:\u0002NOB\u0097\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0001\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010\u0018Bk\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0019J\t\u00104\u001a\u00020\u0005HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\bHÆ\u0003J\t\u0010:\u001a\u00020\u0005HÆ\u0003J\t\u0010;\u001a\u00020\u0005HÆ\u0003J\t\u0010<\u001a\u00020\fHÆ\u0003J\t\u0010=\u001a\u00020\u000eHÆ\u0003J\t\u0010>\u001a\u00020\u0005HÆ\u0003J\t\u0010?\u001a\u00020\u0011HÆ\u0003J\u0087\u0001\u0010@\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010A\u001a\u00020\u000e2\b\u0010B\u001a\u0004\u0018\u00010CHÖ\u0003J\t\u0010D\u001a\u00020\u0003HÖ\u0001J\t\u0010E\u001a\u00020\u0005HÖ\u0001J&\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\u00002\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020LHÁ\u0001¢\u0006\u0002\bMR\u001c\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001f\u0010\u001dR\u001c\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\"R\u001c\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u001b\u001a\u0004\b$\u0010%R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001dR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001c\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u001b\u001a\u0004\b+\u0010,R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010\u001b\u001a\u0004\b.\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001d¨\u0006P"}, d2 = {"Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter;", "Lcom/revenuecat/purchases/common/events/BackendEvent;", "seen1", "", DiagnosticsEntry.ID_KEY, "", "revisionID", "type", "Lcom/revenuecat/purchases/customercenter/events/CustomerCenterEventType;", "appUserID", "appSessionID", DiagnosticsEntry.TIMESTAMP_KEY, "", "darkMode", "", "locale", "displayMode", "Lcom/revenuecat/purchases/customercenter/events/CustomerCenterDisplayMode;", "path", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathType;", "url", "surveyOptionID", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ILcom/revenuecat/purchases/customercenter/events/CustomerCenterEventType;Ljava/lang/String;Ljava/lang/String;JZLjava/lang/String;Lcom/revenuecat/purchases/customercenter/events/CustomerCenterDisplayMode;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathType;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;ILcom/revenuecat/purchases/customercenter/events/CustomerCenterEventType;Ljava/lang/String;Ljava/lang/String;JZLjava/lang/String;Lcom/revenuecat/purchases/customercenter/events/CustomerCenterDisplayMode;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathType;Ljava/lang/String;Ljava/lang/String;)V", "getAppSessionID$annotations", "()V", "getAppSessionID", "()Ljava/lang/String;", "getAppUserID$annotations", "getAppUserID", "getDarkMode$annotations", "getDarkMode", "()Z", "getDisplayMode$annotations", "getDisplayMode", "()Lcom/revenuecat/purchases/customercenter/events/CustomerCenterDisplayMode;", "getId", "getLocale", "getPath", "()Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath$PathType;", "getRevisionID$annotations", "getRevisionID", "()I", "getSurveyOptionID$annotations", "getSurveyOptionID", "getTimestamp", "()J", "getType", "()Lcom/revenuecat/purchases/customercenter/events/CustomerCenterEventType;", "getUrl", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class CustomerCenter extends BackendEvent {
        private final String appSessionID;
        private final String appUserID;
        private final boolean darkMode;
        private final CustomerCenterDisplayMode displayMode;
        private final String id;
        private final String locale;
        private final CustomerCenterConfigData.HelpPath.PathType path;
        private final int revisionID;
        private final String surveyOptionID;
        private final long timestamp;
        private final CustomerCenterEventType type;
        private final String url;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer[] $childSerializers = {null, null, CustomerCenterEventType.INSTANCE.serializer(), null, null, null, null, null, CustomerCenterDisplayMode.INSTANCE.serializer(), CustomerCenterConfigData.HelpPath.PathType.INSTANCE.serializer(), null, null};

        public static /* synthetic */ CustomerCenter copy$default(CustomerCenter customerCenter, String str, int i, CustomerCenterEventType customerCenterEventType, String str2, String str3, long j, boolean z, String str4, CustomerCenterDisplayMode customerCenterDisplayMode, CustomerCenterConfigData.HelpPath.PathType pathType, String str5, String str6, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = customerCenter.id;
            }
            return customerCenter.copy(str, (i2 & 2) != 0 ? customerCenter.revisionID : i, (i2 & 4) != 0 ? customerCenter.type : customerCenterEventType, (i2 & 8) != 0 ? customerCenter.appUserID : str2, (i2 & 16) != 0 ? customerCenter.appSessionID : str3, (i2 & 32) != 0 ? customerCenter.timestamp : j, (i2 & 64) != 0 ? customerCenter.darkMode : z, (i2 & 128) != 0 ? customerCenter.locale : str4, (i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? customerCenter.displayMode : customerCenterDisplayMode, (i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? customerCenter.path : pathType, (i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? customerCenter.url : str5, (i2 & 2048) != 0 ? customerCenter.surveyOptionID : str6);
        }

        public static /* synthetic */ void getAppSessionID$annotations() {
        }

        public static /* synthetic */ void getAppUserID$annotations() {
        }

        public static /* synthetic */ void getDarkMode$annotations() {
        }

        public static /* synthetic */ void getDisplayMode$annotations() {
        }

        public static /* synthetic */ void getRevisionID$annotations() {
        }

        public static /* synthetic */ void getSurveyOptionID$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final CustomerCenterConfigData.HelpPath.PathType getPath() {
            return this.path;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final String getSurveyOptionID() {
            return this.surveyOptionID;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getRevisionID() {
            return this.revisionID;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final CustomerCenterEventType getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getAppUserID() {
            return this.appUserID;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getAppSessionID() {
            return this.appSessionID;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final boolean getDarkMode() {
            return this.darkMode;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getLocale() {
            return this.locale;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final CustomerCenterDisplayMode getDisplayMode() {
            return this.displayMode;
        }

        public final CustomerCenter copy(String id, int revisionID, CustomerCenterEventType type, String appUserID, String appSessionID, long timestamp, boolean darkMode, String locale, CustomerCenterDisplayMode displayMode, CustomerCenterConfigData.HelpPath.PathType path, String url, String surveyOptionID) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(appUserID, "appUserID");
            Intrinsics.checkNotNullParameter(appSessionID, "appSessionID");
            Intrinsics.checkNotNullParameter(locale, "locale");
            Intrinsics.checkNotNullParameter(displayMode, "displayMode");
            return new CustomerCenter(id, revisionID, type, appUserID, appSessionID, timestamp, darkMode, locale, displayMode, path, url, surveyOptionID);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CustomerCenter)) {
                return false;
            }
            CustomerCenter customerCenter = (CustomerCenter) other;
            return Intrinsics.areEqual(this.id, customerCenter.id) && this.revisionID == customerCenter.revisionID && this.type == customerCenter.type && Intrinsics.areEqual(this.appUserID, customerCenter.appUserID) && Intrinsics.areEqual(this.appSessionID, customerCenter.appSessionID) && this.timestamp == customerCenter.timestamp && this.darkMode == customerCenter.darkMode && Intrinsics.areEqual(this.locale, customerCenter.locale) && this.displayMode == customerCenter.displayMode && this.path == customerCenter.path && Intrinsics.areEqual(this.url, customerCenter.url) && Intrinsics.areEqual(this.surveyOptionID, customerCenter.surveyOptionID);
        }

        public int hashCode() {
            int iHashCode = ((((((((((((((((this.id.hashCode() * 31) + Integer.hashCode(this.revisionID)) * 31) + this.type.hashCode()) * 31) + this.appUserID.hashCode()) * 31) + this.appSessionID.hashCode()) * 31) + Long.hashCode(this.timestamp)) * 31) + Boolean.hashCode(this.darkMode)) * 31) + this.locale.hashCode()) * 31) + this.displayMode.hashCode()) * 31;
            CustomerCenterConfigData.HelpPath.PathType pathType = this.path;
            int iHashCode2 = (iHashCode + (pathType == null ? 0 : pathType.hashCode())) * 31;
            String str = this.url;
            int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.surveyOptionID;
            return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
        }

        @Override // com.revenuecat.purchases.utils.Event
        public String toString() {
            return "CustomerCenter(id=" + this.id + ", revisionID=" + this.revisionID + ", type=" + this.type + ", appUserID=" + this.appUserID + ", appSessionID=" + this.appSessionID + ", timestamp=" + this.timestamp + ", darkMode=" + this.darkMode + ", locale=" + this.locale + ", displayMode=" + this.displayMode + ", path=" + this.path + ", url=" + this.url + ", surveyOptionID=" + this.surveyOptionID + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/events/BackendEvent$CustomerCenter;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer serializer() {
                return BackendEvent$CustomerCenter$$serializer.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @Deprecated
        public /* synthetic */ CustomerCenter(int i, String str, int i2, CustomerCenterEventType customerCenterEventType, String str2, String str3, long j, boolean z, String str4, CustomerCenterDisplayMode customerCenterDisplayMode, CustomerCenterConfigData.HelpPath.PathType pathType, String str5, String str6, SerializationConstructorMarker serializationConstructorMarker) {
            super(i, serializationConstructorMarker);
            if (4095 != (i & 4095)) {
                PluginExceptionsKt.throwMissingFieldException(i, 4095, BackendEvent$CustomerCenter$$serializer.INSTANCE.getDescriptor());
            }
            this.id = str;
            this.revisionID = i2;
            this.type = customerCenterEventType;
            this.appUserID = str2;
            this.appSessionID = str3;
            this.timestamp = j;
            this.darkMode = z;
            this.locale = str4;
            this.displayMode = customerCenterDisplayMode;
            this.path = pathType;
            this.url = str5;
            this.surveyOptionID = str6;
        }

        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(CustomerCenter self, CompositeEncoder output, SerialDescriptor serialDesc) {
            BackendEvent.write$Self(self, output, serialDesc);
            KSerializer[] kSerializerArr = $childSerializers;
            output.encodeStringElement(serialDesc, 0, self.id);
            output.encodeIntElement(serialDesc, 1, self.revisionID);
            output.encodeSerializableElement(serialDesc, 2, kSerializerArr[2], self.type);
            output.encodeStringElement(serialDesc, 3, self.appUserID);
            output.encodeStringElement(serialDesc, 4, self.appSessionID);
            output.encodeLongElement(serialDesc, 5, self.timestamp);
            output.encodeBooleanElement(serialDesc, 6, self.darkMode);
            output.encodeStringElement(serialDesc, 7, self.locale);
            output.encodeSerializableElement(serialDesc, 8, kSerializerArr[8], self.displayMode);
            output.encodeNullableSerializableElement(serialDesc, 9, kSerializerArr[9], self.path);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            output.encodeNullableSerializableElement(serialDesc, 10, stringSerializer, self.url);
            output.encodeNullableSerializableElement(serialDesc, 11, stringSerializer, self.surveyOptionID);
        }

        public final String getId() {
            return this.id;
        }

        public final int getRevisionID() {
            return this.revisionID;
        }

        public final CustomerCenterEventType getType() {
            return this.type;
        }

        public final String getAppUserID() {
            return this.appUserID;
        }

        public final String getAppSessionID() {
            return this.appSessionID;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public final boolean getDarkMode() {
            return this.darkMode;
        }

        public final String getLocale() {
            return this.locale;
        }

        public final CustomerCenterDisplayMode getDisplayMode() {
            return this.displayMode;
        }

        public final CustomerCenterConfigData.HelpPath.PathType getPath() {
            return this.path;
        }

        public final String getUrl() {
            return this.url;
        }

        public final String getSurveyOptionID() {
            return this.surveyOptionID;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomerCenter(String id, int i, CustomerCenterEventType type, String appUserID, String appSessionID, long j, boolean z, String locale, CustomerCenterDisplayMode displayMode, CustomerCenterConfigData.HelpPath.PathType pathType, String str, String str2) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(appUserID, "appUserID");
            Intrinsics.checkNotNullParameter(appSessionID, "appSessionID");
            Intrinsics.checkNotNullParameter(locale, "locale");
            Intrinsics.checkNotNullParameter(displayMode, "displayMode");
            this.id = id;
            this.revisionID = i;
            this.type = type;
            this.appUserID = appUserID;
            this.appSessionID = appSessionID;
            this.timestamp = j;
            this.darkMode = z;
            this.locale = locale;
            this.displayMode = displayMode;
            this.path = pathType;
            this.url = str;
            this.surveyOptionID = str2;
        }
    }

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b|\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ¹\u00012\u00020\u0001:\u0004¸\u0001¹\u0001BÙ\u0003\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0001\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0001\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u001e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u001f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\"\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010#\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010%\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010&\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010'\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010(\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010)\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010*\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010+\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010,\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010-\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010.\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010/\u001a\u0004\u0018\u000100¢\u0006\u0002\u00101B\u009f\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u00102J\n\u0010\u0083\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010\u0084\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010\u0085\u0001\u001a\u00020\u0012HÆ\u0003J\n\u0010\u0086\u0001\u001a\u00020\u0006HÆ\u0003J\f\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\f\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010HJ\f\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\n\u0010\u008e\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010HJ\u0011\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010HJ\f\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010HJ\f\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\n\u0010\u0099\u0001\u001a\u00020\u0006HÆ\u0003J\f\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010 \u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010¡\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010¢\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\n\u0010£\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010¤\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010¥\u0001\u001a\u00020\u0006HÆ\u0003J\f\u0010¦\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\n\u0010§\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010¨\u0001\u001a\u00020\u000fHÆ\u0003JÂ\u0003\u0010©\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0003\u0010ª\u0001J\u0016\u0010«\u0001\u001a\u00020\u00122\n\u0010¬\u0001\u001a\u0005\u0018\u00010\u00ad\u0001HÖ\u0003J\n\u0010®\u0001\u001a\u00020\u0003HÖ\u0001J\n\u0010¯\u0001\u001a\u00020\u0006HÖ\u0001J.\u0010°\u0001\u001a\u00030±\u00012\u0007\u0010²\u0001\u001a\u00020\u00002\b\u0010³\u0001\u001a\u00030´\u00012\b\u0010µ\u0001\u001a\u00030¶\u0001HÁ\u0001¢\u0006\u0003\b·\u0001R\u001c\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b3\u00104\u001a\u0004\b5\u00106R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b7\u00104\u001a\u0004\b8\u00106R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b9\u00104\u001a\u0004\b:\u00106R\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b;\u00104\u001a\u0004\b<\u00106R\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b=\u00104\u001a\u0004\b>\u00106R\u001e\u0010+\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b?\u00104\u001a\u0004\b@\u00106R\u001e\u0010-\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bA\u00104\u001a\u0004\bB\u00106R\u001c\u0010\u0011\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bC\u00104\u001a\u0004\bD\u0010ER \u0010$\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010I\u0012\u0004\bF\u00104\u001a\u0004\bG\u0010HR\u001e\u0010'\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bJ\u00104\u001a\u0004\bK\u00106R\u001e\u0010*\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bL\u00104\u001a\u0004\bM\u00106R\u001e\u0010#\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bN\u00104\u001a\u0004\bO\u00106R \u0010!\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010I\u0012\u0004\bP\u00104\u001a\u0004\bQ\u0010HR\u001e\u0010&\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bR\u00104\u001a\u0004\bS\u00106R\u001e\u0010)\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bT\u00104\u001a\u0004\bU\u00106R\u001c\u0010\u0010\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bV\u00104\u001a\u0004\bW\u00106R \u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010I\u0012\u0004\bX\u00104\u001a\u0004\bY\u0010HR\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bZ\u00104\u001a\u0004\b[\u00106R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\\\u00104\u001a\u0004\b]\u00106R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b^\u00104\u001a\u0004\b_\u00106R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b`\u00106R\u001c\u0010\u0013\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\ba\u00104\u001a\u0004\bb\u00106R\u001c\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bc\u00104\u001a\u0004\bd\u00106R\u001e\u0010\"\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\be\u00104\u001a\u0004\bf\u00106R \u0010 \u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010I\u0012\u0004\bg\u00104\u001a\u0004\bh\u0010HR\u001e\u0010%\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bi\u00104\u001a\u0004\bj\u00106R\u001e\u0010(\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bk\u00104\u001a\u0004\bl\u00106R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bm\u00104\u001a\u0004\bn\u00106R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bo\u00104\u001a\u0004\bp\u00106R\u001c\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bq\u00104\u001a\u0004\br\u0010sR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bt\u00104\u001a\u0004\bu\u0010vR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bw\u00104\u001a\u0004\bx\u00106R\u001e\u0010,\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\by\u00104\u001a\u0004\bz\u00106R\u001e\u0010.\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b{\u00104\u001a\u0004\b|\u00106R\u001c\u0010\n\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b}\u00104\u001a\u0004\b~\u00106R\u0012\u0010\u000e\u001a\u00020\u000f¢\u0006\t\n\u0000\u001a\u0005\b\u007f\u0010\u0080\u0001R\u0012\u0010\b\u001a\u00020\u0006¢\u0006\t\n\u0000\u001a\u0005\b\u0081\u0001\u00106R\u0012\u0010\u0007\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0082\u0001\u0010s¨\u0006º\u0001"}, d2 = {"Lcom/revenuecat/purchases/common/events/BackendEvent$Paywalls;", "Lcom/revenuecat/purchases/common/events/BackendEvent;", "seen1", "", "seen2", DiagnosticsEntry.ID_KEY, "", DiagnosticsEntry.VERSION_KEY, "type", "appUserID", "sessionID", "offeringID", "paywallID", "paywallRevision", DiagnosticsEntry.TIMESTAMP_KEY, "", "displayMode", "darkMode", "", "localeIdentifier", "presentedOfferingContext", "Lcom/revenuecat/purchases/common/events/BackendEvent$PresentedOfferingContextData;", "exitOfferType", "exitOfferingID", "packageID", "productID", "errorCode", b.f, "componentType", "componentName", "componentValue", "componentUrl", "originIndex", "destinationIndex", "originContextName", "destinationContextName", "defaultIndex", "originPackageIdentifier", "destinationPackageIdentifier", "defaultPackageIdentifier", "originProductIdentifier", "destinationProductIdentifier", "defaultProductIdentifier", "currentPackageIdentifier", "resultingPackageIdentifier", "currentProductIdentifier", "resultingProductIdentifier", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;ZLjava/lang/String;Lcom/revenuecat/purchases/common/events/BackendEvent$PresentedOfferingContextData;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;ZLjava/lang/String;Lcom/revenuecat/purchases/common/events/BackendEvent$PresentedOfferingContextData;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppUserID$annotations", "()V", "getAppUserID", "()Ljava/lang/String;", "getComponentName$annotations", "getComponentName", "getComponentType$annotations", "getComponentType", "getComponentUrl$annotations", "getComponentUrl", "getComponentValue$annotations", "getComponentValue", "getCurrentPackageIdentifier$annotations", "getCurrentPackageIdentifier", "getCurrentProductIdentifier$annotations", "getCurrentProductIdentifier", "getDarkMode$annotations", "getDarkMode", "()Z", "getDefaultIndex$annotations", "getDefaultIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDefaultPackageIdentifier$annotations", "getDefaultPackageIdentifier", "getDefaultProductIdentifier$annotations", "getDefaultProductIdentifier", "getDestinationContextName$annotations", "getDestinationContextName", "getDestinationIndex$annotations", "getDestinationIndex", "getDestinationPackageIdentifier$annotations", "getDestinationPackageIdentifier", "getDestinationProductIdentifier$annotations", "getDestinationProductIdentifier", "getDisplayMode$annotations", "getDisplayMode", "getErrorCode$annotations", "getErrorCode", "getErrorMessage$annotations", "getErrorMessage", "getExitOfferType$annotations", "getExitOfferType", "getExitOfferingID$annotations", "getExitOfferingID", "getId", "getLocaleIdentifier$annotations", "getLocaleIdentifier", "getOfferingID$annotations", "getOfferingID", "getOriginContextName$annotations", "getOriginContextName", "getOriginIndex$annotations", "getOriginIndex", "getOriginPackageIdentifier$annotations", "getOriginPackageIdentifier", "getOriginProductIdentifier$annotations", "getOriginProductIdentifier", "getPackageID$annotations", "getPackageID", "getPaywallID$annotations", "getPaywallID", "getPaywallRevision$annotations", "getPaywallRevision", "()I", "getPresentedOfferingContext$annotations", "getPresentedOfferingContext", "()Lcom/revenuecat/purchases/common/events/BackendEvent$PresentedOfferingContextData;", "getProductID$annotations", "getProductID", "getResultingPackageIdentifier$annotations", "getResultingPackageIdentifier", "getResultingProductIdentifier$annotations", "getResultingProductIdentifier", "getSessionID$annotations", "getSessionID", "getTimestamp", "()J", "getType", "getVersion", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;ZLjava/lang/String;Lcom/revenuecat/purchases/common/events/BackendEvent$PresentedOfferingContextData;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/revenuecat/purchases/common/events/BackendEvent$Paywalls;", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Paywalls extends BackendEvent {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String appUserID;
        private final String componentName;
        private final String componentType;
        private final String componentUrl;
        private final String componentValue;
        private final String currentPackageIdentifier;
        private final String currentProductIdentifier;
        private final boolean darkMode;
        private final Integer defaultIndex;
        private final String defaultPackageIdentifier;
        private final String defaultProductIdentifier;
        private final String destinationContextName;
        private final Integer destinationIndex;
        private final String destinationPackageIdentifier;
        private final String destinationProductIdentifier;
        private final String displayMode;
        private final Integer errorCode;
        private final String errorMessage;
        private final String exitOfferType;
        private final String exitOfferingID;
        private final String id;
        private final String localeIdentifier;
        private final String offeringID;
        private final String originContextName;
        private final Integer originIndex;
        private final String originPackageIdentifier;
        private final String originProductIdentifier;
        private final String packageID;
        private final String paywallID;
        private final int paywallRevision;
        private final PresentedOfferingContextData presentedOfferingContext;
        private final String productID;
        private final String resultingPackageIdentifier;
        private final String resultingProductIdentifier;
        private final String sessionID;
        private final long timestamp;
        private final String type;
        private final int version;

        public static /* synthetic */ Paywalls copy$default(Paywalls paywalls, String str, int i, String str2, String str3, String str4, String str5, String str6, int i2, long j, String str7, boolean z, String str8, PresentedOfferingContextData presentedOfferingContextData, String str9, String str10, String str11, String str12, Integer num, String str13, String str14, String str15, String str16, String str17, Integer num2, Integer num3, String str18, String str19, Integer num4, String str20, String str21, String str22, String str23, String str24, String str25, String str26, String str27, String str28, String str29, int i3, int i4, Object obj) {
            String str30;
            String str31;
            String str32 = (i3 & 1) != 0 ? paywalls.id : str;
            int i5 = (i3 & 2) != 0 ? paywalls.version : i;
            String str33 = (i3 & 4) != 0 ? paywalls.type : str2;
            String str34 = (i3 & 8) != 0 ? paywalls.appUserID : str3;
            String str35 = (i3 & 16) != 0 ? paywalls.sessionID : str4;
            String str36 = (i3 & 32) != 0 ? paywalls.offeringID : str5;
            String str37 = (i3 & 64) != 0 ? paywalls.paywallID : str6;
            int i6 = (i3 & 128) != 0 ? paywalls.paywallRevision : i2;
            long j2 = (i3 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? paywalls.timestamp : j;
            String str38 = (i3 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? paywalls.displayMode : str7;
            boolean z2 = (i3 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? paywalls.darkMode : z;
            String str39 = (i3 & 2048) != 0 ? paywalls.localeIdentifier : str8;
            PresentedOfferingContextData presentedOfferingContextData2 = (i3 & 4096) != 0 ? paywalls.presentedOfferingContext : presentedOfferingContextData;
            String str40 = str32;
            String str41 = (i3 & 8192) != 0 ? paywalls.exitOfferType : str9;
            String str42 = (i3 & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? paywalls.exitOfferingID : str10;
            String str43 = (i3 & 32768) != 0 ? paywalls.packageID : str11;
            String str44 = (i3 & 65536) != 0 ? paywalls.productID : str12;
            Integer num5 = (i3 & 131072) != 0 ? paywalls.errorCode : num;
            String str45 = (i3 & 262144) != 0 ? paywalls.errorMessage : str13;
            String str46 = (i3 & 524288) != 0 ? paywalls.componentType : str14;
            String str47 = (i3 & 1048576) != 0 ? paywalls.componentName : str15;
            String str48 = (i3 & 2097152) != 0 ? paywalls.componentValue : str16;
            String str49 = (i3 & 4194304) != 0 ? paywalls.componentUrl : str17;
            Integer num6 = (i3 & 8388608) != 0 ? paywalls.originIndex : num2;
            Integer num7 = (i3 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? paywalls.destinationIndex : num3;
            String str50 = (i3 & 33554432) != 0 ? paywalls.originContextName : str18;
            String str51 = (i3 & 67108864) != 0 ? paywalls.destinationContextName : str19;
            Integer num8 = (i3 & 134217728) != 0 ? paywalls.defaultIndex : num4;
            String str52 = (i3 & 268435456) != 0 ? paywalls.originPackageIdentifier : str20;
            String str53 = (i3 & 536870912) != 0 ? paywalls.destinationPackageIdentifier : str21;
            String str54 = (i3 & 1073741824) != 0 ? paywalls.defaultPackageIdentifier : str22;
            String str55 = (i3 & LinearLayoutManager.INVALID_OFFSET) != 0 ? paywalls.originProductIdentifier : str23;
            String str56 = (i4 & 1) != 0 ? paywalls.destinationProductIdentifier : str24;
            String str57 = (i4 & 2) != 0 ? paywalls.defaultProductIdentifier : str25;
            String str58 = (i4 & 4) != 0 ? paywalls.currentPackageIdentifier : str26;
            String str59 = (i4 & 8) != 0 ? paywalls.resultingPackageIdentifier : str27;
            String str60 = (i4 & 16) != 0 ? paywalls.currentProductIdentifier : str28;
            if ((i4 & 32) != 0) {
                str31 = str60;
                str30 = paywalls.resultingProductIdentifier;
            } else {
                str30 = str29;
                str31 = str60;
            }
            return paywalls.copy(str40, i5, str33, str34, str35, str36, str37, i6, j2, str38, z2, str39, presentedOfferingContextData2, str41, str42, str43, str44, num5, str45, str46, str47, str48, str49, num6, num7, str50, str51, num8, str52, str53, str54, str55, str56, str57, str58, str59, str31, str30);
        }

        public static /* synthetic */ void getAppUserID$annotations() {
        }

        public static /* synthetic */ void getComponentName$annotations() {
        }

        public static /* synthetic */ void getComponentType$annotations() {
        }

        public static /* synthetic */ void getComponentUrl$annotations() {
        }

        public static /* synthetic */ void getComponentValue$annotations() {
        }

        public static /* synthetic */ void getCurrentPackageIdentifier$annotations() {
        }

        public static /* synthetic */ void getCurrentProductIdentifier$annotations() {
        }

        public static /* synthetic */ void getDarkMode$annotations() {
        }

        public static /* synthetic */ void getDefaultIndex$annotations() {
        }

        public static /* synthetic */ void getDefaultPackageIdentifier$annotations() {
        }

        public static /* synthetic */ void getDefaultProductIdentifier$annotations() {
        }

        public static /* synthetic */ void getDestinationContextName$annotations() {
        }

        public static /* synthetic */ void getDestinationIndex$annotations() {
        }

        public static /* synthetic */ void getDestinationPackageIdentifier$annotations() {
        }

        public static /* synthetic */ void getDestinationProductIdentifier$annotations() {
        }

        public static /* synthetic */ void getDisplayMode$annotations() {
        }

        public static /* synthetic */ void getErrorCode$annotations() {
        }

        public static /* synthetic */ void getErrorMessage$annotations() {
        }

        public static /* synthetic */ void getExitOfferType$annotations() {
        }

        public static /* synthetic */ void getExitOfferingID$annotations() {
        }

        public static /* synthetic */ void getLocaleIdentifier$annotations() {
        }

        public static /* synthetic */ void getOfferingID$annotations() {
        }

        public static /* synthetic */ void getOriginContextName$annotations() {
        }

        public static /* synthetic */ void getOriginIndex$annotations() {
        }

        public static /* synthetic */ void getOriginPackageIdentifier$annotations() {
        }

        public static /* synthetic */ void getOriginProductIdentifier$annotations() {
        }

        public static /* synthetic */ void getPackageID$annotations() {
        }

        public static /* synthetic */ void getPaywallID$annotations() {
        }

        public static /* synthetic */ void getPaywallRevision$annotations() {
        }

        public static /* synthetic */ void getPresentedOfferingContext$annotations() {
        }

        public static /* synthetic */ void getProductID$annotations() {
        }

        public static /* synthetic */ void getResultingPackageIdentifier$annotations() {
        }

        public static /* synthetic */ void getResultingProductIdentifier$annotations() {
        }

        public static /* synthetic */ void getSessionID$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getDisplayMode() {
            return this.displayMode;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final boolean getDarkMode() {
            return this.darkMode;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final String getLocaleIdentifier() {
            return this.localeIdentifier;
        }

        /* JADX INFO: renamed from: component13, reason: from getter */
        public final PresentedOfferingContextData getPresentedOfferingContext() {
            return this.presentedOfferingContext;
        }

        /* JADX INFO: renamed from: component14, reason: from getter */
        public final String getExitOfferType() {
            return this.exitOfferType;
        }

        /* JADX INFO: renamed from: component15, reason: from getter */
        public final String getExitOfferingID() {
            return this.exitOfferingID;
        }

        /* JADX INFO: renamed from: component16, reason: from getter */
        public final String getPackageID() {
            return this.packageID;
        }

        /* JADX INFO: renamed from: component17, reason: from getter */
        public final String getProductID() {
            return this.productID;
        }

        /* JADX INFO: renamed from: component18, reason: from getter */
        public final Integer getErrorCode() {
            return this.errorCode;
        }

        /* JADX INFO: renamed from: component19, reason: from getter */
        public final String getErrorMessage() {
            return this.errorMessage;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getVersion() {
            return this.version;
        }

        /* JADX INFO: renamed from: component20, reason: from getter */
        public final String getComponentType() {
            return this.componentType;
        }

        /* JADX INFO: renamed from: component21, reason: from getter */
        public final String getComponentName() {
            return this.componentName;
        }

        /* JADX INFO: renamed from: component22, reason: from getter */
        public final String getComponentValue() {
            return this.componentValue;
        }

        /* JADX INFO: renamed from: component23, reason: from getter */
        public final String getComponentUrl() {
            return this.componentUrl;
        }

        /* JADX INFO: renamed from: component24, reason: from getter */
        public final Integer getOriginIndex() {
            return this.originIndex;
        }

        /* JADX INFO: renamed from: component25, reason: from getter */
        public final Integer getDestinationIndex() {
            return this.destinationIndex;
        }

        /* JADX INFO: renamed from: component26, reason: from getter */
        public final String getOriginContextName() {
            return this.originContextName;
        }

        /* JADX INFO: renamed from: component27, reason: from getter */
        public final String getDestinationContextName() {
            return this.destinationContextName;
        }

        /* JADX INFO: renamed from: component28, reason: from getter */
        public final Integer getDefaultIndex() {
            return this.defaultIndex;
        }

        /* JADX INFO: renamed from: component29, reason: from getter */
        public final String getOriginPackageIdentifier() {
            return this.originPackageIdentifier;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component30, reason: from getter */
        public final String getDestinationPackageIdentifier() {
            return this.destinationPackageIdentifier;
        }

        /* JADX INFO: renamed from: component31, reason: from getter */
        public final String getDefaultPackageIdentifier() {
            return this.defaultPackageIdentifier;
        }

        /* JADX INFO: renamed from: component32, reason: from getter */
        public final String getOriginProductIdentifier() {
            return this.originProductIdentifier;
        }

        /* JADX INFO: renamed from: component33, reason: from getter */
        public final String getDestinationProductIdentifier() {
            return this.destinationProductIdentifier;
        }

        /* JADX INFO: renamed from: component34, reason: from getter */
        public final String getDefaultProductIdentifier() {
            return this.defaultProductIdentifier;
        }

        /* JADX INFO: renamed from: component35, reason: from getter */
        public final String getCurrentPackageIdentifier() {
            return this.currentPackageIdentifier;
        }

        /* JADX INFO: renamed from: component36, reason: from getter */
        public final String getResultingPackageIdentifier() {
            return this.resultingPackageIdentifier;
        }

        /* JADX INFO: renamed from: component37, reason: from getter */
        public final String getCurrentProductIdentifier() {
            return this.currentProductIdentifier;
        }

        /* JADX INFO: renamed from: component38, reason: from getter */
        public final String getResultingProductIdentifier() {
            return this.resultingProductIdentifier;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getAppUserID() {
            return this.appUserID;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getSessionID() {
            return this.sessionID;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getOfferingID() {
            return this.offeringID;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getPaywallID() {
            return this.paywallID;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final int getPaywallRevision() {
            return this.paywallRevision;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        public final Paywalls copy(String id, int version, String type, String appUserID, String sessionID, String offeringID, String paywallID, int paywallRevision, long timestamp, String displayMode, boolean darkMode, String localeIdentifier, PresentedOfferingContextData presentedOfferingContext, String exitOfferType, String exitOfferingID, String packageID, String productID, Integer errorCode, String errorMessage, String componentType, String componentName, String componentValue, String componentUrl, Integer originIndex, Integer destinationIndex, String originContextName, String destinationContextName, Integer defaultIndex, String originPackageIdentifier, String destinationPackageIdentifier, String defaultPackageIdentifier, String originProductIdentifier, String destinationProductIdentifier, String defaultProductIdentifier, String currentPackageIdentifier, String resultingPackageIdentifier, String currentProductIdentifier, String resultingProductIdentifier) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(appUserID, "appUserID");
            Intrinsics.checkNotNullParameter(sessionID, "sessionID");
            Intrinsics.checkNotNullParameter(offeringID, "offeringID");
            Intrinsics.checkNotNullParameter(displayMode, "displayMode");
            Intrinsics.checkNotNullParameter(localeIdentifier, "localeIdentifier");
            return new Paywalls(id, version, type, appUserID, sessionID, offeringID, paywallID, paywallRevision, timestamp, displayMode, darkMode, localeIdentifier, presentedOfferingContext, exitOfferType, exitOfferingID, packageID, productID, errorCode, errorMessage, componentType, componentName, componentValue, componentUrl, originIndex, destinationIndex, originContextName, destinationContextName, defaultIndex, originPackageIdentifier, destinationPackageIdentifier, defaultPackageIdentifier, originProductIdentifier, destinationProductIdentifier, defaultProductIdentifier, currentPackageIdentifier, resultingPackageIdentifier, currentProductIdentifier, resultingProductIdentifier);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Paywalls)) {
                return false;
            }
            Paywalls paywalls = (Paywalls) other;
            return Intrinsics.areEqual(this.id, paywalls.id) && this.version == paywalls.version && Intrinsics.areEqual(this.type, paywalls.type) && Intrinsics.areEqual(this.appUserID, paywalls.appUserID) && Intrinsics.areEqual(this.sessionID, paywalls.sessionID) && Intrinsics.areEqual(this.offeringID, paywalls.offeringID) && Intrinsics.areEqual(this.paywallID, paywalls.paywallID) && this.paywallRevision == paywalls.paywallRevision && this.timestamp == paywalls.timestamp && Intrinsics.areEqual(this.displayMode, paywalls.displayMode) && this.darkMode == paywalls.darkMode && Intrinsics.areEqual(this.localeIdentifier, paywalls.localeIdentifier) && Intrinsics.areEqual(this.presentedOfferingContext, paywalls.presentedOfferingContext) && Intrinsics.areEqual(this.exitOfferType, paywalls.exitOfferType) && Intrinsics.areEqual(this.exitOfferingID, paywalls.exitOfferingID) && Intrinsics.areEqual(this.packageID, paywalls.packageID) && Intrinsics.areEqual(this.productID, paywalls.productID) && Intrinsics.areEqual(this.errorCode, paywalls.errorCode) && Intrinsics.areEqual(this.errorMessage, paywalls.errorMessage) && Intrinsics.areEqual(this.componentType, paywalls.componentType) && Intrinsics.areEqual(this.componentName, paywalls.componentName) && Intrinsics.areEqual(this.componentValue, paywalls.componentValue) && Intrinsics.areEqual(this.componentUrl, paywalls.componentUrl) && Intrinsics.areEqual(this.originIndex, paywalls.originIndex) && Intrinsics.areEqual(this.destinationIndex, paywalls.destinationIndex) && Intrinsics.areEqual(this.originContextName, paywalls.originContextName) && Intrinsics.areEqual(this.destinationContextName, paywalls.destinationContextName) && Intrinsics.areEqual(this.defaultIndex, paywalls.defaultIndex) && Intrinsics.areEqual(this.originPackageIdentifier, paywalls.originPackageIdentifier) && Intrinsics.areEqual(this.destinationPackageIdentifier, paywalls.destinationPackageIdentifier) && Intrinsics.areEqual(this.defaultPackageIdentifier, paywalls.defaultPackageIdentifier) && Intrinsics.areEqual(this.originProductIdentifier, paywalls.originProductIdentifier) && Intrinsics.areEqual(this.destinationProductIdentifier, paywalls.destinationProductIdentifier) && Intrinsics.areEqual(this.defaultProductIdentifier, paywalls.defaultProductIdentifier) && Intrinsics.areEqual(this.currentPackageIdentifier, paywalls.currentPackageIdentifier) && Intrinsics.areEqual(this.resultingPackageIdentifier, paywalls.resultingPackageIdentifier) && Intrinsics.areEqual(this.currentProductIdentifier, paywalls.currentProductIdentifier) && Intrinsics.areEqual(this.resultingProductIdentifier, paywalls.resultingProductIdentifier);
        }

        public int hashCode() {
            int iHashCode = ((((((((((this.id.hashCode() * 31) + Integer.hashCode(this.version)) * 31) + this.type.hashCode()) * 31) + this.appUserID.hashCode()) * 31) + this.sessionID.hashCode()) * 31) + this.offeringID.hashCode()) * 31;
            String str = this.paywallID;
            int iHashCode2 = (((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.paywallRevision)) * 31) + Long.hashCode(this.timestamp)) * 31) + this.displayMode.hashCode()) * 31) + Boolean.hashCode(this.darkMode)) * 31) + this.localeIdentifier.hashCode()) * 31;
            PresentedOfferingContextData presentedOfferingContextData = this.presentedOfferingContext;
            int iHashCode3 = (iHashCode2 + (presentedOfferingContextData == null ? 0 : presentedOfferingContextData.hashCode())) * 31;
            String str2 = this.exitOfferType;
            int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.exitOfferingID;
            int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.packageID;
            int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.productID;
            int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
            Integer num = this.errorCode;
            int iHashCode8 = (iHashCode7 + (num == null ? 0 : num.hashCode())) * 31;
            String str6 = this.errorMessage;
            int iHashCode9 = (iHashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.componentType;
            int iHashCode10 = (iHashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
            String str8 = this.componentName;
            int iHashCode11 = (iHashCode10 + (str8 == null ? 0 : str8.hashCode())) * 31;
            String str9 = this.componentValue;
            int iHashCode12 = (iHashCode11 + (str9 == null ? 0 : str9.hashCode())) * 31;
            String str10 = this.componentUrl;
            int iHashCode13 = (iHashCode12 + (str10 == null ? 0 : str10.hashCode())) * 31;
            Integer num2 = this.originIndex;
            int iHashCode14 = (iHashCode13 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.destinationIndex;
            int iHashCode15 = (iHashCode14 + (num3 == null ? 0 : num3.hashCode())) * 31;
            String str11 = this.originContextName;
            int iHashCode16 = (iHashCode15 + (str11 == null ? 0 : str11.hashCode())) * 31;
            String str12 = this.destinationContextName;
            int iHashCode17 = (iHashCode16 + (str12 == null ? 0 : str12.hashCode())) * 31;
            Integer num4 = this.defaultIndex;
            int iHashCode18 = (iHashCode17 + (num4 == null ? 0 : num4.hashCode())) * 31;
            String str13 = this.originPackageIdentifier;
            int iHashCode19 = (iHashCode18 + (str13 == null ? 0 : str13.hashCode())) * 31;
            String str14 = this.destinationPackageIdentifier;
            int iHashCode20 = (iHashCode19 + (str14 == null ? 0 : str14.hashCode())) * 31;
            String str15 = this.defaultPackageIdentifier;
            int iHashCode21 = (iHashCode20 + (str15 == null ? 0 : str15.hashCode())) * 31;
            String str16 = this.originProductIdentifier;
            int iHashCode22 = (iHashCode21 + (str16 == null ? 0 : str16.hashCode())) * 31;
            String str17 = this.destinationProductIdentifier;
            int iHashCode23 = (iHashCode22 + (str17 == null ? 0 : str17.hashCode())) * 31;
            String str18 = this.defaultProductIdentifier;
            int iHashCode24 = (iHashCode23 + (str18 == null ? 0 : str18.hashCode())) * 31;
            String str19 = this.currentPackageIdentifier;
            int iHashCode25 = (iHashCode24 + (str19 == null ? 0 : str19.hashCode())) * 31;
            String str20 = this.resultingPackageIdentifier;
            int iHashCode26 = (iHashCode25 + (str20 == null ? 0 : str20.hashCode())) * 31;
            String str21 = this.currentProductIdentifier;
            int iHashCode27 = (iHashCode26 + (str21 == null ? 0 : str21.hashCode())) * 31;
            String str22 = this.resultingProductIdentifier;
            return iHashCode27 + (str22 != null ? str22.hashCode() : 0);
        }

        @Override // com.revenuecat.purchases.utils.Event
        public String toString() {
            return "Paywalls(id=" + this.id + ", version=" + this.version + ", type=" + this.type + ", appUserID=" + this.appUserID + ", sessionID=" + this.sessionID + ", offeringID=" + this.offeringID + ", paywallID=" + this.paywallID + ", paywallRevision=" + this.paywallRevision + ", timestamp=" + this.timestamp + ", displayMode=" + this.displayMode + ", darkMode=" + this.darkMode + ", localeIdentifier=" + this.localeIdentifier + ", presentedOfferingContext=" + this.presentedOfferingContext + ", exitOfferType=" + this.exitOfferType + ", exitOfferingID=" + this.exitOfferingID + ", packageID=" + this.packageID + ", productID=" + this.productID + ", errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ", componentType=" + this.componentType + ", componentName=" + this.componentName + ", componentValue=" + this.componentValue + ", componentUrl=" + this.componentUrl + ", originIndex=" + this.originIndex + ", destinationIndex=" + this.destinationIndex + ", originContextName=" + this.originContextName + ", destinationContextName=" + this.destinationContextName + ", defaultIndex=" + this.defaultIndex + ", originPackageIdentifier=" + this.originPackageIdentifier + ", destinationPackageIdentifier=" + this.destinationPackageIdentifier + ", defaultPackageIdentifier=" + this.defaultPackageIdentifier + ", originProductIdentifier=" + this.originProductIdentifier + ", destinationProductIdentifier=" + this.destinationProductIdentifier + ", defaultProductIdentifier=" + this.defaultProductIdentifier + ", currentPackageIdentifier=" + this.currentPackageIdentifier + ", resultingPackageIdentifier=" + this.resultingPackageIdentifier + ", currentProductIdentifier=" + this.currentProductIdentifier + ", resultingProductIdentifier=" + this.resultingProductIdentifier + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/common/events/BackendEvent$Paywalls$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/events/BackendEvent$Paywalls;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer serializer() {
                return BackendEvent$Paywalls$$serializer.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @Deprecated
        public /* synthetic */ Paywalls(int i, int i2, String str, int i3, String str2, String str3, String str4, String str5, String str6, int i4, long j, String str7, boolean z, String str8, PresentedOfferingContextData presentedOfferingContextData, String str9, String str10, String str11, String str12, Integer num, String str13, String str14, String str15, String str16, String str17, Integer num2, Integer num3, String str18, String str19, Integer num4, String str20, String str21, String str22, String str23, String str24, String str25, String str26, String str27, String str28, String str29, SerializationConstructorMarker serializationConstructorMarker) {
            super(i, serializationConstructorMarker);
            if (4095 != (i & 4095)) {
                PluginExceptionsKt.throwArrayMissingFieldException(new int[]{i, i2}, new int[]{4095, 0}, BackendEvent$Paywalls$$serializer.INSTANCE.getDescriptor());
            }
            this.id = str;
            this.version = i3;
            this.type = str2;
            this.appUserID = str3;
            this.sessionID = str4;
            this.offeringID = str5;
            this.paywallID = str6;
            this.paywallRevision = i4;
            this.timestamp = j;
            this.displayMode = str7;
            this.darkMode = z;
            this.localeIdentifier = str8;
            if ((i & 4096) == 0) {
                this.presentedOfferingContext = null;
            } else {
                this.presentedOfferingContext = presentedOfferingContextData;
            }
            if ((i & 8192) == 0) {
                this.exitOfferType = null;
            } else {
                this.exitOfferType = str9;
            }
            if ((i & Http2.INITIAL_MAX_FRAME_SIZE) == 0) {
                this.exitOfferingID = null;
            } else {
                this.exitOfferingID = str10;
            }
            if ((32768 & i) == 0) {
                this.packageID = null;
            } else {
                this.packageID = str11;
            }
            if ((65536 & i) == 0) {
                this.productID = null;
            } else {
                this.productID = str12;
            }
            if ((131072 & i) == 0) {
                this.errorCode = null;
            } else {
                this.errorCode = num;
            }
            if ((262144 & i) == 0) {
                this.errorMessage = null;
            } else {
                this.errorMessage = str13;
            }
            if ((524288 & i) == 0) {
                this.componentType = null;
            } else {
                this.componentType = str14;
            }
            if ((1048576 & i) == 0) {
                this.componentName = null;
            } else {
                this.componentName = str15;
            }
            if ((2097152 & i) == 0) {
                this.componentValue = null;
            } else {
                this.componentValue = str16;
            }
            if ((4194304 & i) == 0) {
                this.componentUrl = null;
            } else {
                this.componentUrl = str17;
            }
            if ((8388608 & i) == 0) {
                this.originIndex = null;
            } else {
                this.originIndex = num2;
            }
            if ((16777216 & i) == 0) {
                this.destinationIndex = null;
            } else {
                this.destinationIndex = num3;
            }
            if ((33554432 & i) == 0) {
                this.originContextName = null;
            } else {
                this.originContextName = str18;
            }
            if ((67108864 & i) == 0) {
                this.destinationContextName = null;
            } else {
                this.destinationContextName = str19;
            }
            if ((134217728 & i) == 0) {
                this.defaultIndex = null;
            } else {
                this.defaultIndex = num4;
            }
            if ((268435456 & i) == 0) {
                this.originPackageIdentifier = null;
            } else {
                this.originPackageIdentifier = str20;
            }
            if ((536870912 & i) == 0) {
                this.destinationPackageIdentifier = null;
            } else {
                this.destinationPackageIdentifier = str21;
            }
            if ((1073741824 & i) == 0) {
                this.defaultPackageIdentifier = null;
            } else {
                this.defaultPackageIdentifier = str22;
            }
            if ((i & LinearLayoutManager.INVALID_OFFSET) == 0) {
                this.originProductIdentifier = null;
            } else {
                this.originProductIdentifier = str23;
            }
            if ((i2 & 1) == 0) {
                this.destinationProductIdentifier = null;
            } else {
                this.destinationProductIdentifier = str24;
            }
            if ((i2 & 2) == 0) {
                this.defaultProductIdentifier = null;
            } else {
                this.defaultProductIdentifier = str25;
            }
            if ((i2 & 4) == 0) {
                this.currentPackageIdentifier = null;
            } else {
                this.currentPackageIdentifier = str26;
            }
            if ((i2 & 8) == 0) {
                this.resultingPackageIdentifier = null;
            } else {
                this.resultingPackageIdentifier = str27;
            }
            if ((i2 & 16) == 0) {
                this.currentProductIdentifier = null;
            } else {
                this.currentProductIdentifier = str28;
            }
            if ((i2 & 32) == 0) {
                this.resultingProductIdentifier = null;
            } else {
                this.resultingProductIdentifier = str29;
            }
        }

        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Paywalls self, CompositeEncoder output, SerialDescriptor serialDesc) {
            BackendEvent.write$Self(self, output, serialDesc);
            output.encodeStringElement(serialDesc, 0, self.id);
            output.encodeIntElement(serialDesc, 1, self.version);
            output.encodeStringElement(serialDesc, 2, self.type);
            output.encodeStringElement(serialDesc, 3, self.appUserID);
            output.encodeStringElement(serialDesc, 4, self.sessionID);
            output.encodeStringElement(serialDesc, 5, self.offeringID);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            output.encodeNullableSerializableElement(serialDesc, 6, stringSerializer, self.paywallID);
            output.encodeIntElement(serialDesc, 7, self.paywallRevision);
            output.encodeLongElement(serialDesc, 8, self.timestamp);
            output.encodeStringElement(serialDesc, 9, self.displayMode);
            output.encodeBooleanElement(serialDesc, 10, self.darkMode);
            output.encodeStringElement(serialDesc, 11, self.localeIdentifier);
            if (output.shouldEncodeElementDefault(serialDesc, 12) || self.presentedOfferingContext != null) {
                output.encodeNullableSerializableElement(serialDesc, 12, BackendEvent$PresentedOfferingContextData$$serializer.INSTANCE, self.presentedOfferingContext);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 13) || self.exitOfferType != null) {
                output.encodeNullableSerializableElement(serialDesc, 13, stringSerializer, self.exitOfferType);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 14) || self.exitOfferingID != null) {
                output.encodeNullableSerializableElement(serialDesc, 14, stringSerializer, self.exitOfferingID);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 15) || self.packageID != null) {
                output.encodeNullableSerializableElement(serialDesc, 15, stringSerializer, self.packageID);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 16) || self.productID != null) {
                output.encodeNullableSerializableElement(serialDesc, 16, stringSerializer, self.productID);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 17) || self.errorCode != null) {
                output.encodeNullableSerializableElement(serialDesc, 17, IntSerializer.INSTANCE, self.errorCode);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 18) || self.errorMessage != null) {
                output.encodeNullableSerializableElement(serialDesc, 18, stringSerializer, self.errorMessage);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 19) || self.componentType != null) {
                output.encodeNullableSerializableElement(serialDesc, 19, stringSerializer, self.componentType);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 20) || self.componentName != null) {
                output.encodeNullableSerializableElement(serialDesc, 20, stringSerializer, self.componentName);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 21) || self.componentValue != null) {
                output.encodeNullableSerializableElement(serialDesc, 21, stringSerializer, self.componentValue);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 22) || self.componentUrl != null) {
                output.encodeNullableSerializableElement(serialDesc, 22, stringSerializer, self.componentUrl);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 23) || self.originIndex != null) {
                output.encodeNullableSerializableElement(serialDesc, 23, IntSerializer.INSTANCE, self.originIndex);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 24) || self.destinationIndex != null) {
                output.encodeNullableSerializableElement(serialDesc, 24, IntSerializer.INSTANCE, self.destinationIndex);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 25) || self.originContextName != null) {
                output.encodeNullableSerializableElement(serialDesc, 25, stringSerializer, self.originContextName);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 26) || self.destinationContextName != null) {
                output.encodeNullableSerializableElement(serialDesc, 26, stringSerializer, self.destinationContextName);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 27) || self.defaultIndex != null) {
                output.encodeNullableSerializableElement(serialDesc, 27, IntSerializer.INSTANCE, self.defaultIndex);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 28) || self.originPackageIdentifier != null) {
                output.encodeNullableSerializableElement(serialDesc, 28, stringSerializer, self.originPackageIdentifier);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 29) || self.destinationPackageIdentifier != null) {
                output.encodeNullableSerializableElement(serialDesc, 29, stringSerializer, self.destinationPackageIdentifier);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 30) || self.defaultPackageIdentifier != null) {
                output.encodeNullableSerializableElement(serialDesc, 30, stringSerializer, self.defaultPackageIdentifier);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 31) || self.originProductIdentifier != null) {
                output.encodeNullableSerializableElement(serialDesc, 31, stringSerializer, self.originProductIdentifier);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 32) || self.destinationProductIdentifier != null) {
                output.encodeNullableSerializableElement(serialDesc, 32, stringSerializer, self.destinationProductIdentifier);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 33) || self.defaultProductIdentifier != null) {
                output.encodeNullableSerializableElement(serialDesc, 33, stringSerializer, self.defaultProductIdentifier);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 34) || self.currentPackageIdentifier != null) {
                output.encodeNullableSerializableElement(serialDesc, 34, stringSerializer, self.currentPackageIdentifier);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 35) || self.resultingPackageIdentifier != null) {
                output.encodeNullableSerializableElement(serialDesc, 35, stringSerializer, self.resultingPackageIdentifier);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 36) || self.currentProductIdentifier != null) {
                output.encodeNullableSerializableElement(serialDesc, 36, stringSerializer, self.currentProductIdentifier);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 37) && self.resultingProductIdentifier == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 37, stringSerializer, self.resultingProductIdentifier);
        }

        public /* synthetic */ Paywalls(String str, int i, String str2, String str3, String str4, String str5, String str6, int i2, long j, String str7, boolean z, String str8, PresentedOfferingContextData presentedOfferingContextData, String str9, String str10, String str11, String str12, Integer num, String str13, String str14, String str15, String str16, String str17, Integer num2, Integer num3, String str18, String str19, Integer num4, String str20, String str21, String str22, String str23, String str24, String str25, String str26, String str27, String str28, String str29, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, str2, str3, str4, str5, str6, i2, j, str7, z, str8, (i3 & 4096) != 0 ? null : presentedOfferingContextData, (i3 & 8192) != 0 ? null : str9, (i3 & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? null : str10, (32768 & i3) != 0 ? null : str11, (65536 & i3) != 0 ? null : str12, (131072 & i3) != 0 ? null : num, (262144 & i3) != 0 ? null : str13, (524288 & i3) != 0 ? null : str14, (1048576 & i3) != 0 ? null : str15, (2097152 & i3) != 0 ? null : str16, (4194304 & i3) != 0 ? null : str17, (8388608 & i3) != 0 ? null : num2, (16777216 & i3) != 0 ? null : num3, (33554432 & i3) != 0 ? null : str18, (67108864 & i3) != 0 ? null : str19, (134217728 & i3) != 0 ? null : num4, (268435456 & i3) != 0 ? null : str20, (536870912 & i3) != 0 ? null : str21, (1073741824 & i3) != 0 ? null : str22, (i3 & LinearLayoutManager.INVALID_OFFSET) != 0 ? null : str23, (i4 & 1) != 0 ? null : str24, (i4 & 2) != 0 ? null : str25, (i4 & 4) != 0 ? null : str26, (i4 & 8) != 0 ? null : str27, (i4 & 16) != 0 ? null : str28, (i4 & 32) != 0 ? null : str29);
        }

        public final String getId() {
            return this.id;
        }

        public final int getVersion() {
            return this.version;
        }

        public final String getType() {
            return this.type;
        }

        public final String getAppUserID() {
            return this.appUserID;
        }

        public final String getSessionID() {
            return this.sessionID;
        }

        public final String getOfferingID() {
            return this.offeringID;
        }

        public final String getPaywallID() {
            return this.paywallID;
        }

        public final int getPaywallRevision() {
            return this.paywallRevision;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public final String getDisplayMode() {
            return this.displayMode;
        }

        public final boolean getDarkMode() {
            return this.darkMode;
        }

        public final String getLocaleIdentifier() {
            return this.localeIdentifier;
        }

        public final PresentedOfferingContextData getPresentedOfferingContext() {
            return this.presentedOfferingContext;
        }

        public final String getExitOfferType() {
            return this.exitOfferType;
        }

        public final String getExitOfferingID() {
            return this.exitOfferingID;
        }

        public final String getPackageID() {
            return this.packageID;
        }

        public final String getProductID() {
            return this.productID;
        }

        public final Integer getErrorCode() {
            return this.errorCode;
        }

        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public final String getComponentType() {
            return this.componentType;
        }

        public final String getComponentName() {
            return this.componentName;
        }

        public final String getComponentValue() {
            return this.componentValue;
        }

        public final String getComponentUrl() {
            return this.componentUrl;
        }

        public final Integer getOriginIndex() {
            return this.originIndex;
        }

        public final Integer getDestinationIndex() {
            return this.destinationIndex;
        }

        public final String getOriginContextName() {
            return this.originContextName;
        }

        public final String getDestinationContextName() {
            return this.destinationContextName;
        }

        public final Integer getDefaultIndex() {
            return this.defaultIndex;
        }

        public final String getOriginPackageIdentifier() {
            return this.originPackageIdentifier;
        }

        public final String getDestinationPackageIdentifier() {
            return this.destinationPackageIdentifier;
        }

        public final String getDefaultPackageIdentifier() {
            return this.defaultPackageIdentifier;
        }

        public final String getOriginProductIdentifier() {
            return this.originProductIdentifier;
        }

        public final String getDestinationProductIdentifier() {
            return this.destinationProductIdentifier;
        }

        public final String getDefaultProductIdentifier() {
            return this.defaultProductIdentifier;
        }

        public final String getCurrentPackageIdentifier() {
            return this.currentPackageIdentifier;
        }

        public final String getResultingPackageIdentifier() {
            return this.resultingPackageIdentifier;
        }

        public final String getCurrentProductIdentifier() {
            return this.currentProductIdentifier;
        }

        public final String getResultingProductIdentifier() {
            return this.resultingProductIdentifier;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Paywalls(String id, int i, String type, String appUserID, String sessionID, String offeringID, String str, int i2, long j, String displayMode, boolean z, String localeIdentifier, PresentedOfferingContextData presentedOfferingContextData, String str2, String str3, String str4, String str5, Integer num, String str6, String str7, String str8, String str9, String str10, Integer num2, Integer num3, String str11, String str12, Integer num4, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(appUserID, "appUserID");
            Intrinsics.checkNotNullParameter(sessionID, "sessionID");
            Intrinsics.checkNotNullParameter(offeringID, "offeringID");
            Intrinsics.checkNotNullParameter(displayMode, "displayMode");
            Intrinsics.checkNotNullParameter(localeIdentifier, "localeIdentifier");
            this.id = id;
            this.version = i;
            this.type = type;
            this.appUserID = appUserID;
            this.sessionID = sessionID;
            this.offeringID = offeringID;
            this.paywallID = str;
            this.paywallRevision = i2;
            this.timestamp = j;
            this.displayMode = displayMode;
            this.darkMode = z;
            this.localeIdentifier = localeIdentifier;
            this.presentedOfferingContext = presentedOfferingContextData;
            this.exitOfferType = str2;
            this.exitOfferingID = str3;
            this.packageID = str4;
            this.productID = str5;
            this.errorCode = num;
            this.errorMessage = str6;
            this.componentType = str7;
            this.componentName = str8;
            this.componentValue = str9;
            this.componentUrl = str10;
            this.originIndex = num2;
            this.destinationIndex = num3;
            this.originContextName = str11;
            this.destinationContextName = str12;
            this.defaultIndex = num4;
            this.originPackageIdentifier = str13;
            this.destinationPackageIdentifier = str14;
            this.defaultPackageIdentifier = str15;
            this.originProductIdentifier = str16;
            this.destinationProductIdentifier = str17;
            this.defaultProductIdentifier = str18;
            this.currentPackageIdentifier = str19;
            this.resultingPackageIdentifier = str20;
            this.currentProductIdentifier = str21;
            this.resultingProductIdentifier = str22;
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0002()B=\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB)\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J2\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J&\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&HÁ\u0001¢\u0006\u0002\b'R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0013\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u000f¨\u0006*"}, d2 = {"Lcom/revenuecat/purchases/common/events/BackendEvent$PresentedOfferingContextData;", "", "seen1", "", "placementIdentifier", "", "targetingRevision", "targetingRuleId", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getPlacementIdentifier$annotations", "()V", "getPlacementIdentifier", "()Ljava/lang/String;", "getTargetingRevision$annotations", "getTargetingRevision", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTargetingRuleId$annotations", "getTargetingRuleId", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/revenuecat/purchases/common/events/BackendEvent$PresentedOfferingContextData;", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class PresentedOfferingContextData {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String placementIdentifier;
        private final Integer targetingRevision;
        private final String targetingRuleId;

        public PresentedOfferingContextData() {
            this((String) null, (Integer) null, (String) null, 7, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ PresentedOfferingContextData copy$default(PresentedOfferingContextData presentedOfferingContextData, String str, Integer num, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = presentedOfferingContextData.placementIdentifier;
            }
            if ((i & 2) != 0) {
                num = presentedOfferingContextData.targetingRevision;
            }
            if ((i & 4) != 0) {
                str2 = presentedOfferingContextData.targetingRuleId;
            }
            return presentedOfferingContextData.copy(str, num, str2);
        }

        public static /* synthetic */ void getPlacementIdentifier$annotations() {
        }

        public static /* synthetic */ void getTargetingRevision$annotations() {
        }

        public static /* synthetic */ void getTargetingRuleId$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getPlacementIdentifier() {
            return this.placementIdentifier;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getTargetingRevision() {
            return this.targetingRevision;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getTargetingRuleId() {
            return this.targetingRuleId;
        }

        public final PresentedOfferingContextData copy(String placementIdentifier, Integer targetingRevision, String targetingRuleId) {
            return new PresentedOfferingContextData(placementIdentifier, targetingRevision, targetingRuleId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PresentedOfferingContextData)) {
                return false;
            }
            PresentedOfferingContextData presentedOfferingContextData = (PresentedOfferingContextData) other;
            return Intrinsics.areEqual(this.placementIdentifier, presentedOfferingContextData.placementIdentifier) && Intrinsics.areEqual(this.targetingRevision, presentedOfferingContextData.targetingRevision) && Intrinsics.areEqual(this.targetingRuleId, presentedOfferingContextData.targetingRuleId);
        }

        public int hashCode() {
            String str = this.placementIdentifier;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            Integer num = this.targetingRevision;
            int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
            String str2 = this.targetingRuleId;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "PresentedOfferingContextData(placementIdentifier=" + this.placementIdentifier + ", targetingRevision=" + this.targetingRevision + ", targetingRuleId=" + this.targetingRuleId + ')';
        }

        @Deprecated
        public /* synthetic */ PresentedOfferingContextData(int i, String str, Integer num, String str2, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 1) == 0) {
                this.placementIdentifier = null;
            } else {
                this.placementIdentifier = str;
            }
            if ((i & 2) == 0) {
                this.targetingRevision = null;
            } else {
                this.targetingRevision = num;
            }
            if ((i & 4) == 0) {
                this.targetingRuleId = null;
            } else {
                this.targetingRuleId = str2;
            }
        }

        public PresentedOfferingContextData(String str, Integer num, String str2) {
            this.placementIdentifier = str;
            this.targetingRevision = num;
            this.targetingRuleId = str2;
        }

        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(PresentedOfferingContextData self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.placementIdentifier != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.placementIdentifier);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.targetingRevision != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.targetingRevision);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.targetingRuleId == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.targetingRuleId);
        }

        public /* synthetic */ PresentedOfferingContextData(String str, Integer num, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : str2);
        }

        public final String getPlacementIdentifier() {
            return this.placementIdentifier;
        }

        public final Integer getTargetingRevision() {
            return this.targetingRevision;
        }

        public final String getTargetingRuleId() {
            return this.targetingRuleId;
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bHÆ\u0001¨\u0006\t"}, d2 = {"Lcom/revenuecat/purchases/common/events/BackendEvent$PresentedOfferingContextData$Companion;", "", "()V", "fromContext", "Lcom/revenuecat/purchases/common/events/BackendEvent$PresentedOfferingContextData;", "context", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "serializer", "Lkotlinx/serialization/KSerializer;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer serializer() {
                return BackendEvent$PresentedOfferingContextData$$serializer.INSTANCE;
            }

            public final PresentedOfferingContextData fromContext(PresentedOfferingContext context) {
                Intrinsics.checkNotNullParameter(context, "context");
                if (context.getPlacementIdentifier() == null && context.getTargetingContext() == null) {
                    return null;
                }
                String placementIdentifier = context.getPlacementIdentifier();
                PresentedOfferingContext.TargetingContext targetingContext = context.getTargetingContext();
                Integer numValueOf = targetingContext != null ? Integer.valueOf(targetingContext.getRevision()) : null;
                PresentedOfferingContext.TargetingContext targetingContext2 = context.getTargetingContext();
                return new PresentedOfferingContextData(placementIdentifier, numValueOf, targetingContext2 != null ? targetingContext2.getRuleId() : null);
            }
        }
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 :2\u00020\u0001:\u00029:Bm\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010BQ\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0011J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u000bHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J_\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\u0003HÖ\u0001J\t\u00100\u001a\u00020\u0005HÖ\u0001J&\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207HÁ\u0001¢\u0006\u0002\b8R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006;"}, d2 = {"Lcom/revenuecat/purchases/common/events/BackendEvent$CustomPaywall;", "Lcom/revenuecat/purchases/common/events/BackendEvent;", "seen1", "", DiagnosticsEntry.ID_KEY, "", DiagnosticsEntry.VERSION_KEY, "type", "appUserID", "appSessionID", DiagnosticsEntry.TIMESTAMP_KEY, "", "paywallID", "offeringID", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "getAppSessionID$annotations", "()V", "getAppSessionID", "()Ljava/lang/String;", "getAppUserID$annotations", "getAppUserID", "getId", "getOfferingID$annotations", "getOfferingID", "getPaywallID$annotations", "getPaywallID", "getTimestamp", "()J", "getType", "getVersion", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class CustomPaywall extends BackendEvent {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String appSessionID;
        private final String appUserID;
        private final String id;
        private final String offeringID;
        private final String paywallID;
        private final long timestamp;
        private final String type;
        private final int version;

        public static /* synthetic */ CustomPaywall copy$default(CustomPaywall customPaywall, String str, int i, String str2, String str3, String str4, long j, String str5, String str6, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = customPaywall.id;
            }
            if ((i2 & 2) != 0) {
                i = customPaywall.version;
            }
            if ((i2 & 4) != 0) {
                str2 = customPaywall.type;
            }
            if ((i2 & 8) != 0) {
                str3 = customPaywall.appUserID;
            }
            if ((i2 & 16) != 0) {
                str4 = customPaywall.appSessionID;
            }
            if ((i2 & 32) != 0) {
                j = customPaywall.timestamp;
            }
            if ((i2 & 64) != 0) {
                str5 = customPaywall.paywallID;
            }
            if ((i2 & 128) != 0) {
                str6 = customPaywall.offeringID;
            }
            long j2 = j;
            String str7 = str3;
            String str8 = str4;
            String str9 = str2;
            return customPaywall.copy(str, i, str9, str7, str8, j2, str5, str6);
        }

        public static /* synthetic */ void getAppSessionID$annotations() {
        }

        public static /* synthetic */ void getAppUserID$annotations() {
        }

        public static /* synthetic */ void getOfferingID$annotations() {
        }

        public static /* synthetic */ void getPaywallID$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getVersion() {
            return this.version;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getAppUserID() {
            return this.appUserID;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getAppSessionID() {
            return this.appSessionID;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getPaywallID() {
            return this.paywallID;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getOfferingID() {
            return this.offeringID;
        }

        public final CustomPaywall copy(String id, int version, String type, String appUserID, String appSessionID, long timestamp, String paywallID, String offeringID) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(appUserID, "appUserID");
            return new CustomPaywall(id, version, type, appUserID, appSessionID, timestamp, paywallID, offeringID);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CustomPaywall)) {
                return false;
            }
            CustomPaywall customPaywall = (CustomPaywall) other;
            return Intrinsics.areEqual(this.id, customPaywall.id) && this.version == customPaywall.version && Intrinsics.areEqual(this.type, customPaywall.type) && Intrinsics.areEqual(this.appUserID, customPaywall.appUserID) && Intrinsics.areEqual(this.appSessionID, customPaywall.appSessionID) && this.timestamp == customPaywall.timestamp && Intrinsics.areEqual(this.paywallID, customPaywall.paywallID) && Intrinsics.areEqual(this.offeringID, customPaywall.offeringID);
        }

        public int hashCode() {
            int iHashCode = ((((((this.id.hashCode() * 31) + Integer.hashCode(this.version)) * 31) + this.type.hashCode()) * 31) + this.appUserID.hashCode()) * 31;
            String str = this.appSessionID;
            int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Long.hashCode(this.timestamp)) * 31;
            String str2 = this.paywallID;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.offeringID;
            return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
        }

        @Override // com.revenuecat.purchases.utils.Event
        public String toString() {
            return "CustomPaywall(id=" + this.id + ", version=" + this.version + ", type=" + this.type + ", appUserID=" + this.appUserID + ", appSessionID=" + this.appSessionID + ", timestamp=" + this.timestamp + ", paywallID=" + this.paywallID + ", offeringID=" + this.offeringID + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/common/events/BackendEvent$CustomPaywall$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/events/BackendEvent$CustomPaywall;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer serializer() {
                return BackendEvent$CustomPaywall$$serializer.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @Deprecated
        public /* synthetic */ CustomPaywall(int i, String str, int i2, String str2, String str3, String str4, long j, String str5, String str6, SerializationConstructorMarker serializationConstructorMarker) {
            super(i, serializationConstructorMarker);
            if (47 != (i & 47)) {
                PluginExceptionsKt.throwMissingFieldException(i, 47, BackendEvent$CustomPaywall$$serializer.INSTANCE.getDescriptor());
            }
            this.id = str;
            this.version = i2;
            this.type = str2;
            this.appUserID = str3;
            if ((i & 16) == 0) {
                this.appSessionID = null;
            } else {
                this.appSessionID = str4;
            }
            this.timestamp = j;
            if ((i & 64) == 0) {
                this.paywallID = null;
            } else {
                this.paywallID = str5;
            }
            if ((i & 128) == 0) {
                this.offeringID = null;
            } else {
                this.offeringID = str6;
            }
        }

        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(CustomPaywall self, CompositeEncoder output, SerialDescriptor serialDesc) {
            BackendEvent.write$Self(self, output, serialDesc);
            output.encodeStringElement(serialDesc, 0, self.id);
            output.encodeIntElement(serialDesc, 1, self.version);
            output.encodeStringElement(serialDesc, 2, self.type);
            output.encodeStringElement(serialDesc, 3, self.appUserID);
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.appSessionID != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.appSessionID);
            }
            output.encodeLongElement(serialDesc, 5, self.timestamp);
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.paywallID != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.paywallID);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 7) && self.offeringID == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.offeringID);
        }

        public /* synthetic */ CustomPaywall(String str, int i, String str2, String str3, String str4, long j, String str5, String str6, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, str2, str3, (i2 & 16) != 0 ? null : str4, j, (i2 & 64) != 0 ? null : str5, (i2 & 128) != 0 ? null : str6);
        }

        public final String getId() {
            return this.id;
        }

        public final int getVersion() {
            return this.version;
        }

        public final String getType() {
            return this.type;
        }

        public final String getAppUserID() {
            return this.appUserID;
        }

        public final String getAppSessionID() {
            return this.appSessionID;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public final String getPaywallID() {
            return this.paywallID;
        }

        public final String getOfferingID() {
            return this.offeringID;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomPaywall(String id, int i, String type, String appUserID, String str, long j, String str2, String str3) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(appUserID, "appUserID");
            this.id = id;
            this.version = i;
            this.type = type;
            this.appUserID = appUserID;
            this.appSessionID = str;
            this.timestamp = j;
            this.paywallID = str2;
            this.offeringID = str3;
        }
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b7\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ]2\u00020\u0001:\u0002\\]BÉ\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010\u0018B¡\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0019J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010>\u001a\u00020\u0005HÆ\u0003J\t\u0010?\u001a\u00020\u0005HÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u00104J\u000b\u0010A\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010*J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0005HÆ\u0003J\t\u0010F\u001a\u00020\tHÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010H\u001a\u00020\u0005HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010K\u001a\u00020\u0005HÆ\u0003J¾\u0001\u0010L\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010MJ\u0013\u0010N\u001a\u00020O2\b\u0010P\u001a\u0004\u0018\u00010QHÖ\u0003J\t\u0010R\u001a\u00020\u0003HÖ\u0001J\t\u0010S\u001a\u00020\u0005HÖ\u0001J&\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\u00002\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020ZHÁ\u0001¢\u0006\u0002\b[R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001f\u0010\u001dR\u001c\u0010\u0011\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u001dR\u001c\u0010\u0010\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u001b\u001a\u0004\b#\u0010\u001dR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u001b\u001a\u0004\b'\u0010\u001dR \u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010+\u0012\u0004\b(\u0010\u001b\u001a\u0004\b)\u0010*R\u001c\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u001b\u001a\u0004\b-\u0010\u001dR\u001e\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u001b\u001a\u0004\b/\u0010\u001dR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001dR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001dR \u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00105\u0012\u0004\b2\u0010\u001b\u001a\u0004\b3\u00104R\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b6\u0010\u001b\u001a\u0004\b7\u00108R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u001dR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;¨\u0006^"}, d2 = {"Lcom/revenuecat/purchases/common/events/BackendEvent$Ad;", "Lcom/revenuecat/purchases/common/events/BackendEvent;", "seen1", "", DiagnosticsEntry.ID_KEY, "", DiagnosticsEntry.VERSION_KEY, "type", DiagnosticsEntry.TIMESTAMP_KEY, "", "networkName", "mediatorName", "adFormat", "placement", "adUnitId", "impressionId", "appUserID", "appSessionID", "revenueMicros", b.a, "precision", "mediatorErrorCode", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getAdFormat$annotations", "()V", "getAdFormat", "()Ljava/lang/String;", "getAdUnitId$annotations", "getAdUnitId", "getAppSessionID$annotations", "getAppSessionID", "getAppUserID$annotations", "getAppUserID", "getCurrency", "getId", "getImpressionId$annotations", "getImpressionId", "getMediatorErrorCode$annotations", "getMediatorErrorCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMediatorName$annotations", "getMediatorName", "getNetworkName$annotations", "getNetworkName", "getPlacement", "getPrecision", "getRevenueMicros$annotations", "getRevenueMicros", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTimestamp$annotations", "getTimestamp", "()J", "getType", "getVersion", "()I", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/revenuecat/purchases/common/events/BackendEvent$Ad;", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Ad extends BackendEvent {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String adFormat;
        private final String adUnitId;
        private final String appSessionID;
        private final String appUserID;
        private final String currency;
        private final String id;
        private final String impressionId;
        private final Integer mediatorErrorCode;
        private final String mediatorName;
        private final String networkName;
        private final String placement;
        private final String precision;
        private final Long revenueMicros;
        private final long timestamp;
        private final String type;
        private final int version;

        public static /* synthetic */ void getAdFormat$annotations() {
        }

        public static /* synthetic */ void getAdUnitId$annotations() {
        }

        public static /* synthetic */ void getAppSessionID$annotations() {
        }

        public static /* synthetic */ void getAppUserID$annotations() {
        }

        public static /* synthetic */ void getImpressionId$annotations() {
        }

        public static /* synthetic */ void getMediatorErrorCode$annotations() {
        }

        public static /* synthetic */ void getMediatorName$annotations() {
        }

        public static /* synthetic */ void getNetworkName$annotations() {
        }

        public static /* synthetic */ void getRevenueMicros$annotations() {
        }

        public static /* synthetic */ void getTimestamp$annotations() {
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getImpressionId() {
            return this.impressionId;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final String getAppUserID() {
            return this.appUserID;
        }

        /* JADX INFO: renamed from: component12, reason: from getter */
        public final String getAppSessionID() {
            return this.appSessionID;
        }

        /* JADX INFO: renamed from: component13, reason: from getter */
        public final Long getRevenueMicros() {
            return this.revenueMicros;
        }

        /* JADX INFO: renamed from: component14, reason: from getter */
        public final String getCurrency() {
            return this.currency;
        }

        /* JADX INFO: renamed from: component15, reason: from getter */
        public final String getPrecision() {
            return this.precision;
        }

        /* JADX INFO: renamed from: component16, reason: from getter */
        public final Integer getMediatorErrorCode() {
            return this.mediatorErrorCode;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getVersion() {
            return this.version;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getNetworkName() {
            return this.networkName;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getMediatorName() {
            return this.mediatorName;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getAdFormat() {
            return this.adFormat;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getPlacement() {
            return this.placement;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getAdUnitId() {
            return this.adUnitId;
        }

        public final Ad copy(String id, int version, String type, long timestamp, String networkName, String mediatorName, String adFormat, String placement, String adUnitId, String impressionId, String appUserID, String appSessionID, Long revenueMicros, String currency, String precision, Integer mediatorErrorCode) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(mediatorName, "mediatorName");
            Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
            Intrinsics.checkNotNullParameter(appUserID, "appUserID");
            Intrinsics.checkNotNullParameter(appSessionID, "appSessionID");
            return new Ad(id, version, type, timestamp, networkName, mediatorName, adFormat, placement, adUnitId, impressionId, appUserID, appSessionID, revenueMicros, currency, precision, mediatorErrorCode);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Ad)) {
                return false;
            }
            Ad ad = (Ad) other;
            return Intrinsics.areEqual(this.id, ad.id) && this.version == ad.version && Intrinsics.areEqual(this.type, ad.type) && this.timestamp == ad.timestamp && Intrinsics.areEqual(this.networkName, ad.networkName) && Intrinsics.areEqual(this.mediatorName, ad.mediatorName) && Intrinsics.areEqual(this.adFormat, ad.adFormat) && Intrinsics.areEqual(this.placement, ad.placement) && Intrinsics.areEqual(this.adUnitId, ad.adUnitId) && Intrinsics.areEqual(this.impressionId, ad.impressionId) && Intrinsics.areEqual(this.appUserID, ad.appUserID) && Intrinsics.areEqual(this.appSessionID, ad.appSessionID) && Intrinsics.areEqual(this.revenueMicros, ad.revenueMicros) && Intrinsics.areEqual(this.currency, ad.currency) && Intrinsics.areEqual(this.precision, ad.precision) && Intrinsics.areEqual(this.mediatorErrorCode, ad.mediatorErrorCode);
        }

        public int hashCode() {
            int iHashCode = ((((((this.id.hashCode() * 31) + Integer.hashCode(this.version)) * 31) + this.type.hashCode()) * 31) + Long.hashCode(this.timestamp)) * 31;
            String str = this.networkName;
            int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.mediatorName.hashCode()) * 31;
            String str2 = this.adFormat;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.placement;
            int iHashCode4 = (((iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.adUnitId.hashCode()) * 31;
            String str4 = this.impressionId;
            int iHashCode5 = (((((iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.appUserID.hashCode()) * 31) + this.appSessionID.hashCode()) * 31;
            Long l = this.revenueMicros;
            int iHashCode6 = (iHashCode5 + (l == null ? 0 : l.hashCode())) * 31;
            String str5 = this.currency;
            int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.precision;
            int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
            Integer num = this.mediatorErrorCode;
            return iHashCode8 + (num != null ? num.hashCode() : 0);
        }

        @Override // com.revenuecat.purchases.utils.Event
        public String toString() {
            return "Ad(id=" + this.id + ", version=" + this.version + ", type=" + this.type + ", timestamp=" + this.timestamp + ", networkName=" + this.networkName + ", mediatorName=" + this.mediatorName + ", adFormat=" + this.adFormat + ", placement=" + this.placement + ", adUnitId=" + this.adUnitId + ", impressionId=" + this.impressionId + ", appUserID=" + this.appUserID + ", appSessionID=" + this.appSessionID + ", revenueMicros=" + this.revenueMicros + ", currency=" + this.currency + ", precision=" + this.precision + ", mediatorErrorCode=" + this.mediatorErrorCode + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/common/events/BackendEvent$Ad$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/events/BackendEvent$Ad;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer serializer() {
                return BackendEvent$Ad$$serializer.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @Deprecated
        public /* synthetic */ Ad(int i, String str, int i2, String str2, long j, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Long l, String str11, String str12, Integer num, SerializationConstructorMarker serializationConstructorMarker) {
            super(i, serializationConstructorMarker);
            if (4015 != (i & 4015)) {
                PluginExceptionsKt.throwMissingFieldException(i, 4015, BackendEvent$Ad$$serializer.INSTANCE.getDescriptor());
            }
            this.id = str;
            this.version = i2;
            this.type = str2;
            this.timestamp = j;
            if ((i & 16) == 0) {
                this.networkName = null;
            } else {
                this.networkName = str3;
            }
            this.mediatorName = str4;
            if ((i & 64) == 0) {
                this.adFormat = null;
            } else {
                this.adFormat = str5;
            }
            this.placement = str6;
            this.adUnitId = str7;
            this.impressionId = str8;
            this.appUserID = str9;
            this.appSessionID = str10;
            if ((i & 4096) == 0) {
                this.revenueMicros = null;
            } else {
                this.revenueMicros = l;
            }
            if ((i & 8192) == 0) {
                this.currency = null;
            } else {
                this.currency = str11;
            }
            if ((i & Http2.INITIAL_MAX_FRAME_SIZE) == 0) {
                this.precision = null;
            } else {
                this.precision = str12;
            }
            if ((i & 32768) == 0) {
                this.mediatorErrorCode = null;
            } else {
                this.mediatorErrorCode = num;
            }
        }

        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Ad self, CompositeEncoder output, SerialDescriptor serialDesc) {
            BackendEvent.write$Self(self, output, serialDesc);
            output.encodeStringElement(serialDesc, 0, self.id);
            output.encodeIntElement(serialDesc, 1, self.version);
            output.encodeStringElement(serialDesc, 2, self.type);
            output.encodeLongElement(serialDesc, 3, self.timestamp);
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.networkName != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.networkName);
            }
            output.encodeStringElement(serialDesc, 5, self.mediatorName);
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.adFormat != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.adFormat);
            }
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            output.encodeNullableSerializableElement(serialDesc, 7, stringSerializer, self.placement);
            output.encodeStringElement(serialDesc, 8, self.adUnitId);
            output.encodeNullableSerializableElement(serialDesc, 9, stringSerializer, self.impressionId);
            output.encodeStringElement(serialDesc, 10, self.appUserID);
            output.encodeStringElement(serialDesc, 11, self.appSessionID);
            if (output.shouldEncodeElementDefault(serialDesc, 12) || self.revenueMicros != null) {
                output.encodeNullableSerializableElement(serialDesc, 12, LongSerializer.INSTANCE, self.revenueMicros);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 13) || self.currency != null) {
                output.encodeNullableSerializableElement(serialDesc, 13, stringSerializer, self.currency);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 14) || self.precision != null) {
                output.encodeNullableSerializableElement(serialDesc, 14, stringSerializer, self.precision);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 15) && self.mediatorErrorCode == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 15, IntSerializer.INSTANCE, self.mediatorErrorCode);
        }

        public /* synthetic */ Ad(String str, int i, String str2, long j, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Long l, String str11, String str12, Integer num, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, str2, j, (i2 & 16) != 0 ? null : str3, str4, (i2 & 64) != 0 ? null : str5, str6, str7, str8, str9, str10, (i2 & 4096) != 0 ? null : l, (i2 & 8192) != 0 ? null : str11, (i2 & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? null : str12, (i2 & 32768) != 0 ? null : num);
        }

        public final String getId() {
            return this.id;
        }

        public final int getVersion() {
            return this.version;
        }

        public final String getType() {
            return this.type;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public final String getNetworkName() {
            return this.networkName;
        }

        public final String getMediatorName() {
            return this.mediatorName;
        }

        public final String getAdFormat() {
            return this.adFormat;
        }

        public final String getPlacement() {
            return this.placement;
        }

        public final String getAdUnitId() {
            return this.adUnitId;
        }

        public final String getImpressionId() {
            return this.impressionId;
        }

        public final String getAppUserID() {
            return this.appUserID;
        }

        public final String getAppSessionID() {
            return this.appSessionID;
        }

        public final Long getRevenueMicros() {
            return this.revenueMicros;
        }

        public final String getCurrency() {
            return this.currency;
        }

        public final String getPrecision() {
            return this.precision;
        }

        public final Integer getMediatorErrorCode() {
            return this.mediatorErrorCode;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Ad(String id, int i, String type, long j, String str, String mediatorName, String str2, String str3, String adUnitId, String str4, String appUserID, String appSessionID, Long l, String str5, String str6, Integer num) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(mediatorName, "mediatorName");
            Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
            Intrinsics.checkNotNullParameter(appUserID, "appUserID");
            Intrinsics.checkNotNullParameter(appSessionID, "appSessionID");
            this.id = id;
            this.version = i;
            this.type = type;
            this.timestamp = j;
            this.networkName = str;
            this.mediatorName = mediatorName;
            this.adFormat = str2;
            this.placement = str3;
            this.adUnitId = adUnitId;
            this.impressionId = str4;
            this.appUserID = appUserID;
            this.appSessionID = appSessionID;
            this.revenueMicros = l;
            this.currency = str5;
            this.precision = str6;
            this.mediatorErrorCode = num;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/revenuecat/purchases/common/events/BackendEvent$Companion;", "", "()V", "AD_EVENT_SCHEMA_VERSION", "", "CUSTOMER_CENTER_EVENT_SCHEMA_VERSION", "CUSTOM_PAYWALL_EVENT_SCHEMA_VERSION", "PAYWALL_EVENT_SCHEMA_VERSION", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/common/events/BackendEvent;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) BackendEvent.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer serializer() {
            return get$cachedSerializer();
        }
    }
}
