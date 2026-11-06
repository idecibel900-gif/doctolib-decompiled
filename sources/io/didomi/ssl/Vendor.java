package io.didomi.ssl;

import androidx.annotation.Keep;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.google.gson.annotations.SerializedName;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.didomi.ssl.models.DeviceStorageDisclosures;
import io.didomi.ssl.models.VendorNamespaces;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.http2.Http2;

/* JADX INFO: loaded from: classes5.dex */
@Keep
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\bA\b\u0087\b\u0018\u00002\u00020\u0001:\u0002yzB\u0099\u0002\b\u0007\u0012\b\b\u0002\u0010!\u001a\u00020\u0002\u0012\b\b\u0002\u0010\"\u001a\u00020\u0002\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010$\u001a\u00020\u0002\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u0012\u000e\b\u0002\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00020\r\u0012\u000e\b\u0002\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00020\r\u0012\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020\r\u0012\u000e\b\u0002\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00020\r\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010.\u001a\u00020\u0015\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u00100\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0018\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u001a\u0012\u0010\b\u0002\u00102\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\r\u0012\u000e\b\u0002\u00103\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\bw\u0010xJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tHÆ\u0003J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\tHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\rHÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\rHÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\rHÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\rHÆ\u0003J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0016\u001a\u00020\u0015HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0018HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\rHÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\tHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u001fHÆ\u0003J \u0002\u00105\u001a\u00020\u00002\b\b\u0002\u0010!\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020\u00022\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010$\u001a\u00020\u00022\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u000e\b\u0002\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\u000e\b\u0002\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\u000e\b\u0002\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010.\u001a\u00020\u00152\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u00100\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00182\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u001a2\u0010\b\u0002\u00102\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\r2\u000e\b\u0002\u00103\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u001fHÆ\u0001¢\u0006\u0004\b5\u00106J\t\u00107\u001a\u00020\u0002HÖ\u0001J\t\u00109\u001a\u000208HÖ\u0001J\u0013\u0010<\u001a\u00020\u00152\b\u0010;\u001a\u0004\u0018\u00010:HÖ\u0003R\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001a\u0010\"\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010=\u001a\u0004\bB\u0010?R\u001c\u0010#\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010=\u001a\u0004\bC\u0010?R\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010=\u001a\u0004\bD\u0010?\"\u0004\bE\u0010AR$\u0010%\u001a\u0004\u0018\u00010\u00078\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b%\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR(\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR(\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010K\u001a\u0004\bP\u0010M\"\u0004\bQ\u0010OR$\u0010(\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010=\u001a\u0004\bR\u0010?\"\u0004\bS\u0010AR(\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010K\u001a\u0004\bT\u0010M\"\u0004\bU\u0010OR \u0010*\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010K\u001a\u0004\bV\u0010MR \u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010K\u001a\u0004\bW\u0010MR(\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010K\u001a\u0004\bX\u0010M\"\u0004\bY\u0010OR\u001c\u0010-\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010Z\u001a\u0004\b[\u0010\u0014R\u001a\u0010.\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010\\\u001a\u0004\b]\u0010^R\u001c\u0010/\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010=\u001a\u0004\b_\u0010?R\"\u00100\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010`\u001a\u0004\ba\u0010bR\u001c\u00101\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b1\u0010c\u001a\u0004\bd\u0010eR\"\u00102\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010K\u001a\u0004\bf\u0010MR(\u00103\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010K\u001a\u0004\bg\u0010M\"\u0004\bh\u0010OR$\u00104\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\"\u0010n\u001a\u00020\u00158F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bn\u0010\\\u001a\u0004\bn\u0010^\"\u0004\bo\u0010pR\u001a\u0010q\u001a\u00020\u00158FX\u0087\u0004¢\u0006\f\u0012\u0004\br\u0010s\u001a\u0004\bq\u0010^R\u0011\u0010t\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\bt\u0010^R\u0011\u0010v\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\bu\u0010^¨\u0006{"}, d2 = {"Lio/didomi/sdk/Vendor;", "Lio/didomi/sdk/z7;", "", "component1", "component2", "component3", "component4", "Lio/didomi/sdk/models/VendorNamespaces;", "component5", "", "component6", "component7", "component8", "", "component9", "component10", "component11", "component12", "", "component13", "()Ljava/lang/Long;", "", "component14", "component15", "", "component16", "Lio/didomi/sdk/Vendor$a;", "component17", "Lio/didomi/sdk/Vendor$b;", "component18", "component19", "Lio/didomi/sdk/models/DeviceStorageDisclosures;", "component20", DiagnosticsEntry.ID_KEY, "name", "privacyPolicyUrl", "namespace", "namespaces", "purposeIds", "legIntPurposeIds", "iabId", "flexiblePurposeIds", "specialPurposeIds", "featureIds", "specialFeatureIds", "cookieMaxAgeSeconds", "usesNonCookieAccess", "deviceStorageDisclosureUrl", "dataDeclaration", "dataRetention", "urls", "essentialPurposeIds", "deviceStorageDisclosures", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/didomi/sdk/models/VendorNamespaces;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Long;ZLjava/lang/String;Ljava/util/Set;Lio/didomi/sdk/Vendor$a;Ljava/util/List;Ljava/util/List;Lio/didomi/sdk/models/DeviceStorageDisclosures;)Lio/didomi/sdk/Vendor;", "toString", "", "hashCode", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "equals", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getName", "getPrivacyPolicyUrl", "getNamespace", "setNamespace", "Lio/didomi/sdk/models/VendorNamespaces;", "getNamespaces", "()Lio/didomi/sdk/models/VendorNamespaces;", "setNamespaces", "(Lio/didomi/sdk/models/VendorNamespaces;)V", "Ljava/util/List;", "getPurposeIds", "()Ljava/util/List;", "setPurposeIds", "(Ljava/util/List;)V", "getLegIntPurposeIds", "setLegIntPurposeIds", "getIabId", "setIabId", "getFlexiblePurposeIds", "setFlexiblePurposeIds", "getSpecialPurposeIds", "getFeatureIds", "getSpecialFeatureIds", "setSpecialFeatureIds", "Ljava/lang/Long;", "getCookieMaxAgeSeconds", "Z", "getUsesNonCookieAccess", "()Z", "getDeviceStorageDisclosureUrl", "Ljava/util/Set;", "getDataDeclaration", "()Ljava/util/Set;", "Lio/didomi/sdk/Vendor$a;", "getDataRetention", "()Lio/didomi/sdk/Vendor$a;", "getUrls", "getEssentialPurposeIds", "setEssentialPurposeIds", "Lio/didomi/sdk/models/DeviceStorageDisclosures;", "getDeviceStorageDisclosures", "()Lio/didomi/sdk/models/DeviceStorageDisclosures;", "setDeviceStorageDisclosures", "(Lio/didomi/sdk/models/DeviceStorageDisclosures;)V", "isDeviceStorageDisclosureComplete", "setDeviceStorageDisclosureComplete", "(Z)V", "isIABVendor", "isIABVendor$annotations", "()V", "isIabVendor", "getHasLegIntClaim", "hasLegIntClaim", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/didomi/sdk/models/VendorNamespaces;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Long;ZLjava/lang/String;Ljava/util/Set;Lio/didomi/sdk/Vendor$a;Ljava/util/List;Ljava/util/List;Lio/didomi/sdk/models/DeviceStorageDisclosures;)V", "a", "b", "android_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class Vendor implements z7 {

    @SerializedName("cookieMaxAgeSeconds")
    private final Long cookieMaxAgeSeconds;

    @SerializedName("dataDeclaration")
    private final Set<String> dataDeclaration;

    @SerializedName("dataRetention")
    private final DataRetention dataRetention;

    @SerializedName("deviceStorageDisclosureUrl")
    private final String deviceStorageDisclosureUrl;
    private transient DeviceStorageDisclosures deviceStorageDisclosures;
    private transient List<String> essentialPurposeIds;

    @SerializedName(alternate = {"features"}, value = "featureIds")
    private final List<String> featureIds;

    @SerializedName(alternate = {"flexiblePurposes"}, value = "flexiblePurposeIds")
    private List<String> flexiblePurposeIds;

    @SerializedName("iabId")
    private String iabId;

    @SerializedName(DiagnosticsEntry.ID_KEY)
    private String id;
    private transient boolean isDeviceStorageDisclosureComplete;

    @SerializedName(alternate = {"legIntPurposes"}, value = "legIntPurposeIds")
    private List<String> legIntPurposeIds;

    @SerializedName("name")
    private final String name;

    @SerializedName("namespace")
    private String namespace;

    @SerializedName("namespaces")
    private VendorNamespaces namespaces;

    @SerializedName("policyUrl")
    private final String privacyPolicyUrl;

    @SerializedName(alternate = {Didomi.VIEW_PURPOSES}, value = "purposeIds")
    private List<String> purposeIds;

    @SerializedName(alternate = {"specialFeatures"}, value = "specialFeatureIds")
    private List<String> specialFeatureIds;

    @SerializedName(alternate = {"specialPurposes"}, value = "specialPurposeIds")
    private final List<String> specialPurposeIds;

    @SerializedName("urls")
    private final List<Url> urls;

    @SerializedName("usesNonCookieAccess")
    private final boolean usesNonCookieAccess;

    /* JADX INFO: renamed from: io.didomi.sdk.Vendor$a, reason: from toString */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e\u0012\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR(\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\t\u0010\u0011R(\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011¨\u0006\u0016"}, d2 = {"Lio/didomi/sdk/Vendor$a;", "", "", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "stdRetention", "", "b", "Ljava/util/Map;", "()Ljava/util/Map;", Didomi.VIEW_PURPOSES, "specialPurposes", "<init>", "(Ljava/lang/Integer;Ljava/util/Map;Ljava/util/Map;)V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class DataRetention {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
        @SerializedName("stdRetention")
        private final Integer stdRetention;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
        @SerializedName(Didomi.VIEW_PURPOSES)
        private final Map<String, Integer> purposes;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
        @SerializedName("specialPurposes")
        private final Map<String, Integer> specialPurposes;

        public DataRetention() {
            this(null, null, null, 7, null);
        }

        public final Map<String, Integer> a() {
            return this.purposes;
        }

        public final Map<String, Integer> b() {
            return this.specialPurposes;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final Integer getStdRetention() {
            return this.stdRetention;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DataRetention)) {
                return false;
            }
            DataRetention dataRetention = (DataRetention) other;
            return Intrinsics.areEqual(this.stdRetention, dataRetention.stdRetention) && Intrinsics.areEqual(this.purposes, dataRetention.purposes) && Intrinsics.areEqual(this.specialPurposes, dataRetention.specialPurposes);
        }

        public int hashCode() {
            Integer num = this.stdRetention;
            int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
            Map<String, Integer> map = this.purposes;
            int iHashCode2 = (iHashCode + (map == null ? 0 : map.hashCode())) * 31;
            Map<String, Integer> map2 = this.specialPurposes;
            return iHashCode2 + (map2 != null ? map2.hashCode() : 0);
        }

        public String toString() {
            return "DataRetention(stdRetention=" + this.stdRetention + ", purposes=" + this.purposes + ", specialPurposes=" + this.specialPurposes + ')';
        }

        public DataRetention(Integer num, Map<String, Integer> map, Map<String, Integer> map2) {
            this.stdRetention = num;
            this.purposes = map;
            this.specialPurposes = map2;
        }

        public /* synthetic */ DataRetention(Integer num, Map map, Map map2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : map, (i & 4) != 0 ? null : map2);
        }
    }

    /* JADX INFO: renamed from: io.didomi.sdk.Vendor$b, reason: from toString */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\r\u0010\u000b¨\u0006\u0013"}, d2 = {"Lio/didomi/sdk/Vendor$b;", "", "", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "langId", "b", "c", "privacy", "legIntClaim", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class Url {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
        @SerializedName("langId")
        private final String langId;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
        @SerializedName("privacy")
        private final String privacy;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
        @SerializedName("legIntClaim")
        private final String legIntClaim;

        public Url() {
            this(null, null, null, 7, null);
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final String getLangId() {
            return this.langId;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final String getLegIntClaim() {
            return this.legIntClaim;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final String getPrivacy() {
            return this.privacy;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Url)) {
                return false;
            }
            Url url = (Url) other;
            return Intrinsics.areEqual(this.langId, url.langId) && Intrinsics.areEqual(this.privacy, url.privacy) && Intrinsics.areEqual(this.legIntClaim, url.legIntClaim);
        }

        public int hashCode() {
            String str = this.langId;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.privacy;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.legIntClaim;
            return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            return "Url(langId=" + this.langId + ", privacy=" + this.privacy + ", legIntClaim=" + this.legIntClaim + ')';
        }

        public Url(String str, String str2, String str3) {
            this.langId = str;
            this.privacy = str2;
            this.legIntClaim = str3;
        }

        public /* synthetic */ Url(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
        }
    }

    public Vendor() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, 1048575, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Vendor copy$default(Vendor vendor, String str, String str2, String str3, String str4, VendorNamespaces vendorNamespaces, List list, List list2, String str5, List list3, List list4, List list5, List list6, Long l, boolean z, String str6, Set set, DataRetention dataRetention, List list7, List list8, DeviceStorageDisclosures deviceStorageDisclosures, int i, Object obj) {
        DeviceStorageDisclosures deviceStorageDisclosures2;
        List list9;
        String str7 = (i & 1) != 0 ? vendor.id : str;
        String str8 = (i & 2) != 0 ? vendor.name : str2;
        String str9 = (i & 4) != 0 ? vendor.privacyPolicyUrl : str3;
        String str10 = (i & 8) != 0 ? vendor.namespace : str4;
        VendorNamespaces vendorNamespaces2 = (i & 16) != 0 ? vendor.namespaces : vendorNamespaces;
        List list10 = (i & 32) != 0 ? vendor.purposeIds : list;
        List list11 = (i & 64) != 0 ? vendor.legIntPurposeIds : list2;
        String str11 = (i & 128) != 0 ? vendor.iabId : str5;
        List list12 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? vendor.flexiblePurposeIds : list3;
        List list13 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? vendor.specialPurposeIds : list4;
        List list14 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? vendor.featureIds : list5;
        List list15 = (i & 2048) != 0 ? vendor.specialFeatureIds : list6;
        Long l2 = (i & 4096) != 0 ? vendor.cookieMaxAgeSeconds : l;
        boolean z2 = (i & 8192) != 0 ? vendor.usesNonCookieAccess : z;
        String str12 = str7;
        String str13 = (i & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? vendor.deviceStorageDisclosureUrl : str6;
        Set set2 = (i & 32768) != 0 ? vendor.dataDeclaration : set;
        DataRetention dataRetention2 = (i & 65536) != 0 ? vendor.dataRetention : dataRetention;
        List list16 = (i & 131072) != 0 ? vendor.urls : list7;
        List list17 = (i & 262144) != 0 ? vendor.essentialPurposeIds : list8;
        if ((i & 524288) != 0) {
            list9 = list17;
            deviceStorageDisclosures2 = vendor.deviceStorageDisclosures;
        } else {
            deviceStorageDisclosures2 = deviceStorageDisclosures;
            list9 = list17;
        }
        return vendor.copy(str12, str8, str9, str10, vendorNamespaces2, list10, list11, str11, list12, list13, list14, list15, l2, z2, str13, set2, dataRetention2, list16, list9, deviceStorageDisclosures2);
    }

    @Deprecated
    public static /* synthetic */ void isIABVendor$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final List<String> component10() {
        return this.specialPurposeIds;
    }

    public final List<String> component11() {
        return this.featureIds;
    }

    public final List<String> component12() {
        return this.specialFeatureIds;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Long getCookieMaxAgeSeconds() {
        return this.cookieMaxAgeSeconds;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final boolean getUsesNonCookieAccess() {
        return this.usesNonCookieAccess;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getDeviceStorageDisclosureUrl() {
        return this.deviceStorageDisclosureUrl;
    }

    public final Set<String> component16() {
        return this.dataDeclaration;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final DataRetention getDataRetention() {
        return this.dataRetention;
    }

    public final List<Url> component18() {
        return this.urls;
    }

    public final List<String> component19() {
        return this.essentialPurposeIds;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final DeviceStorageDisclosures getDeviceStorageDisclosures() {
        return this.deviceStorageDisclosures;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPrivacyPolicyUrl() {
        return this.privacyPolicyUrl;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getNamespace() {
        return this.namespace;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final VendorNamespaces getNamespaces() {
        return this.namespaces;
    }

    public final List<String> component6() {
        return this.purposeIds;
    }

    public final List<String> component7() {
        return this.legIntPurposeIds;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getIabId() {
        return this.iabId;
    }

    public final List<String> component9() {
        return this.flexiblePurposeIds;
    }

    public final Vendor copy(String id, String name, String privacyPolicyUrl, String namespace, VendorNamespaces namespaces, List<String> purposeIds, List<String> legIntPurposeIds, String iabId, List<String> flexiblePurposeIds, List<String> specialPurposeIds, List<String> featureIds, List<String> specialFeatureIds, Long cookieMaxAgeSeconds, boolean usesNonCookieAccess, String deviceStorageDisclosureUrl, Set<String> dataDeclaration, DataRetention dataRetention, List<Url> urls, List<String> essentialPurposeIds, DeviceStorageDisclosures deviceStorageDisclosures) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(purposeIds, "purposeIds");
        Intrinsics.checkNotNullParameter(legIntPurposeIds, "legIntPurposeIds");
        Intrinsics.checkNotNullParameter(flexiblePurposeIds, "flexiblePurposeIds");
        Intrinsics.checkNotNullParameter(specialPurposeIds, "specialPurposeIds");
        Intrinsics.checkNotNullParameter(featureIds, "featureIds");
        Intrinsics.checkNotNullParameter(specialFeatureIds, "specialFeatureIds");
        Intrinsics.checkNotNullParameter(essentialPurposeIds, "essentialPurposeIds");
        return new Vendor(id, name, privacyPolicyUrl, namespace, namespaces, purposeIds, legIntPurposeIds, iabId, flexiblePurposeIds, specialPurposeIds, featureIds, specialFeatureIds, cookieMaxAgeSeconds, usesNonCookieAccess, deviceStorageDisclosureUrl, dataDeclaration, dataRetention, urls, essentialPurposeIds, deviceStorageDisclosures);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Vendor)) {
            return false;
        }
        Vendor vendor = (Vendor) other;
        return Intrinsics.areEqual(this.id, vendor.id) && Intrinsics.areEqual(this.name, vendor.name) && Intrinsics.areEqual(this.privacyPolicyUrl, vendor.privacyPolicyUrl) && Intrinsics.areEqual(this.namespace, vendor.namespace) && Intrinsics.areEqual(this.namespaces, vendor.namespaces) && Intrinsics.areEqual(this.purposeIds, vendor.purposeIds) && Intrinsics.areEqual(this.legIntPurposeIds, vendor.legIntPurposeIds) && Intrinsics.areEqual(this.iabId, vendor.iabId) && Intrinsics.areEqual(this.flexiblePurposeIds, vendor.flexiblePurposeIds) && Intrinsics.areEqual(this.specialPurposeIds, vendor.specialPurposeIds) && Intrinsics.areEqual(this.featureIds, vendor.featureIds) && Intrinsics.areEqual(this.specialFeatureIds, vendor.specialFeatureIds) && Intrinsics.areEqual(this.cookieMaxAgeSeconds, vendor.cookieMaxAgeSeconds) && this.usesNonCookieAccess == vendor.usesNonCookieAccess && Intrinsics.areEqual(this.deviceStorageDisclosureUrl, vendor.deviceStorageDisclosureUrl) && Intrinsics.areEqual(this.dataDeclaration, vendor.dataDeclaration) && Intrinsics.areEqual(this.dataRetention, vendor.dataRetention) && Intrinsics.areEqual(this.urls, vendor.urls) && Intrinsics.areEqual(this.essentialPurposeIds, vendor.essentialPurposeIds) && Intrinsics.areEqual(this.deviceStorageDisclosures, vendor.deviceStorageDisclosures);
    }

    public final Long getCookieMaxAgeSeconds() {
        return this.cookieMaxAgeSeconds;
    }

    public final Set<String> getDataDeclaration() {
        return this.dataDeclaration;
    }

    public final DataRetention getDataRetention() {
        return this.dataRetention;
    }

    public final String getDeviceStorageDisclosureUrl() {
        return this.deviceStorageDisclosureUrl;
    }

    public final DeviceStorageDisclosures getDeviceStorageDisclosures() {
        return this.deviceStorageDisclosures;
    }

    public final List<String> getEssentialPurposeIds() {
        return this.essentialPurposeIds;
    }

    public final List<String> getFeatureIds() {
        return this.featureIds;
    }

    public final List<String> getFlexiblePurposeIds() {
        return this.flexiblePurposeIds;
    }

    public final boolean getHasLegIntClaim() {
        List<Url> list = this.urls;
        if (list != null && !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                String legIntClaim = ((Url) it.next()).getLegIntClaim();
                if (!(legIntClaim == null || StringsKt.isBlank(legIntClaim))) {
                    return true;
                }
            }
        }
        return false;
    }

    public final String getIabId() {
        return this.iabId;
    }

    public final String getId() {
        return this.id;
    }

    public final List<String> getLegIntPurposeIds() {
        return this.legIntPurposeIds;
    }

    public final String getName() {
        return this.name;
    }

    public final String getNamespace() {
        return this.namespace;
    }

    public final String getPrivacyPolicyUrl() {
        return this.privacyPolicyUrl;
    }

    public final List<String> getPurposeIds() {
        return this.purposeIds;
    }

    public final List<String> getSpecialFeatureIds() {
        return this.specialFeatureIds;
    }

    public final List<String> getSpecialPurposeIds() {
        return this.specialPurposeIds;
    }

    public final List<Url> getUrls() {
        return this.urls;
    }

    public final boolean getUsesNonCookieAccess() {
        return this.usesNonCookieAccess;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v27, types: [int] */
    /* JADX WARN: Type inference failed for: r1v29, types: [int] */
    /* JADX WARN: Type inference failed for: r1v49 */
    /* JADX WARN: Type inference failed for: r1v54 */
    public int hashCode() {
        int iHashCode = ((this.id.hashCode() * 31) + this.name.hashCode()) * 31;
        String str = this.privacyPolicyUrl;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.namespace.hashCode()) * 31;
        VendorNamespaces vendorNamespaces = this.namespaces;
        int iHashCode3 = (((((iHashCode2 + (vendorNamespaces == null ? 0 : vendorNamespaces.hashCode())) * 31) + this.purposeIds.hashCode()) * 31) + this.legIntPurposeIds.hashCode()) * 31;
        String str2 = this.iabId;
        int iHashCode4 = (((((((((iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.flexiblePurposeIds.hashCode()) * 31) + this.specialPurposeIds.hashCode()) * 31) + this.featureIds.hashCode()) * 31) + this.specialFeatureIds.hashCode()) * 31;
        Long l = this.cookieMaxAgeSeconds;
        int iHashCode5 = (iHashCode4 + (l == null ? 0 : l.hashCode())) * 31;
        boolean z = this.usesNonCookieAccess;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode5 + r1) * 31;
        String str3 = this.deviceStorageDisclosureUrl;
        int iHashCode6 = (i + (str3 == null ? 0 : str3.hashCode())) * 31;
        Set<String> set = this.dataDeclaration;
        int iHashCode7 = (iHashCode6 + (set == null ? 0 : set.hashCode())) * 31;
        DataRetention dataRetention = this.dataRetention;
        int iHashCode8 = (iHashCode7 + (dataRetention == null ? 0 : dataRetention.hashCode())) * 31;
        List<Url> list = this.urls;
        int iHashCode9 = (((iHashCode8 + (list == null ? 0 : list.hashCode())) * 31) + this.essentialPurposeIds.hashCode()) * 31;
        DeviceStorageDisclosures deviceStorageDisclosures = this.deviceStorageDisclosures;
        return iHashCode9 + (deviceStorageDisclosures != null ? deviceStorageDisclosures.hashCode() : 0);
    }

    public final boolean isDeviceStorageDisclosureComplete() {
        return this.deviceStorageDisclosureUrl == null || this.isDeviceStorageDisclosureComplete;
    }

    public final boolean isIABVendor() {
        return isIabVendor();
    }

    public final boolean isIabVendor() {
        if (Intrinsics.areEqual(this.namespace, "iab")) {
            return true;
        }
        VendorNamespaces namespaces = getNamespaces();
        return (namespaces != null ? namespaces.getIab2() : null) != null;
    }

    public final void setDeviceStorageDisclosureComplete(boolean z) {
        this.isDeviceStorageDisclosureComplete = z;
    }

    public final void setDeviceStorageDisclosures(DeviceStorageDisclosures deviceStorageDisclosures) {
        this.deviceStorageDisclosures = deviceStorageDisclosures;
    }

    public final void setEssentialPurposeIds(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.essentialPurposeIds = list;
    }

    public final void setFlexiblePurposeIds(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.flexiblePurposeIds = list;
    }

    public final void setIabId(String str) {
        this.iabId = str;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final void setLegIntPurposeIds(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.legIntPurposeIds = list;
    }

    public final void setNamespace(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.namespace = str;
    }

    public void setNamespaces(VendorNamespaces vendorNamespaces) {
        this.namespaces = vendorNamespaces;
    }

    public final void setPurposeIds(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.purposeIds = list;
    }

    public final void setSpecialFeatureIds(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.specialFeatureIds = list;
    }

    public String toString() {
        return "Vendor(id=" + this.id + ", name=" + this.name + ", privacyPolicyUrl=" + this.privacyPolicyUrl + ", namespace=" + this.namespace + ", namespaces=" + this.namespaces + ", purposeIds=" + this.purposeIds + ", legIntPurposeIds=" + this.legIntPurposeIds + ", iabId=" + this.iabId + ", flexiblePurposeIds=" + this.flexiblePurposeIds + ", specialPurposeIds=" + this.specialPurposeIds + ", featureIds=" + this.featureIds + ", specialFeatureIds=" + this.specialFeatureIds + ", cookieMaxAgeSeconds=" + this.cookieMaxAgeSeconds + ", usesNonCookieAccess=" + this.usesNonCookieAccess + ", deviceStorageDisclosureUrl=" + this.deviceStorageDisclosureUrl + ", dataDeclaration=" + this.dataDeclaration + ", dataRetention=" + this.dataRetention + ", urls=" + this.urls + ", essentialPurposeIds=" + this.essentialPurposeIds + ", deviceStorageDisclosures=" + this.deviceStorageDisclosures + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Vendor(String id) {
        this(id, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, 1048574, null);
        Intrinsics.checkNotNullParameter(id, "id");
    }

    @Override // io.didomi.ssl.z7
    public VendorNamespaces getNamespaces() {
        return this.namespaces;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Vendor(String id, String name) {
        this(id, name, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, 1048572, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Vendor(String id, String name, String str) {
        this(id, name, str, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, 1048568, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Vendor(String id, String name, String str, String namespace) {
        this(id, name, str, namespace, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, 1048560, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(namespace, "namespace");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Vendor(String id, String name, String str, String namespace, VendorNamespaces vendorNamespaces) {
        this(id, name, str, namespace, vendorNamespaces, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, 1048544, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(namespace, "namespace");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Vendor(String id, String name, String str, String namespace, VendorNamespaces vendorNamespaces, List<String> purposeIds) {
        this(id, name, str, namespace, vendorNamespaces, purposeIds, null, null, null, null, null, null, null, false, null, null, null, null, null, null, 1048512, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(purposeIds, "purposeIds");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Vendor(String id, String name, String str, String namespace, VendorNamespaces vendorNamespaces, List<String> purposeIds, List<String> legIntPurposeIds) {
        this(id, name, str, namespace, vendorNamespaces, purposeIds, legIntPurposeIds, null, null, null, null, null, null, false, null, null, null, null, null, null, 1048448, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(purposeIds, "purposeIds");
        Intrinsics.checkNotNullParameter(legIntPurposeIds, "legIntPurposeIds");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Vendor(String id, String name, String str, String namespace, VendorNamespaces vendorNamespaces, List<String> purposeIds, List<String> legIntPurposeIds, String str2) {
        this(id, name, str, namespace, vendorNamespaces, purposeIds, legIntPurposeIds, str2, null, null, null, null, null, false, null, null, null, null, null, null, 1048320, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(purposeIds, "purposeIds");
        Intrinsics.checkNotNullParameter(legIntPurposeIds, "legIntPurposeIds");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Vendor(String id, String name, String str, String namespace, VendorNamespaces vendorNamespaces, List<String> purposeIds, List<String> legIntPurposeIds, String str2, List<String> flexiblePurposeIds) {
        this(id, name, str, namespace, vendorNamespaces, purposeIds, legIntPurposeIds, str2, flexiblePurposeIds, null, null, null, null, false, null, null, null, null, null, null, 1048064, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(purposeIds, "purposeIds");
        Intrinsics.checkNotNullParameter(legIntPurposeIds, "legIntPurposeIds");
        Intrinsics.checkNotNullParameter(flexiblePurposeIds, "flexiblePurposeIds");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Vendor(String id, String name, String str, String namespace, VendorNamespaces vendorNamespaces, List<String> purposeIds, List<String> legIntPurposeIds, String str2, List<String> flexiblePurposeIds, List<String> specialPurposeIds) {
        this(id, name, str, namespace, vendorNamespaces, purposeIds, legIntPurposeIds, str2, flexiblePurposeIds, specialPurposeIds, null, null, null, false, null, null, null, null, null, null, 1047552, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(purposeIds, "purposeIds");
        Intrinsics.checkNotNullParameter(legIntPurposeIds, "legIntPurposeIds");
        Intrinsics.checkNotNullParameter(flexiblePurposeIds, "flexiblePurposeIds");
        Intrinsics.checkNotNullParameter(specialPurposeIds, "specialPurposeIds");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Vendor(String id, String name, String str, String namespace, VendorNamespaces vendorNamespaces, List<String> purposeIds, List<String> legIntPurposeIds, String str2, List<String> flexiblePurposeIds, List<String> specialPurposeIds, List<String> featureIds) {
        this(id, name, str, namespace, vendorNamespaces, purposeIds, legIntPurposeIds, str2, flexiblePurposeIds, specialPurposeIds, featureIds, null, null, false, null, null, null, null, null, null, 1046528, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(purposeIds, "purposeIds");
        Intrinsics.checkNotNullParameter(legIntPurposeIds, "legIntPurposeIds");
        Intrinsics.checkNotNullParameter(flexiblePurposeIds, "flexiblePurposeIds");
        Intrinsics.checkNotNullParameter(specialPurposeIds, "specialPurposeIds");
        Intrinsics.checkNotNullParameter(featureIds, "featureIds");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Vendor(String id, String name, String str, String namespace, VendorNamespaces vendorNamespaces, List<String> purposeIds, List<String> legIntPurposeIds, String str2, List<String> flexiblePurposeIds, List<String> specialPurposeIds, List<String> featureIds, List<String> specialFeatureIds) {
        this(id, name, str, namespace, vendorNamespaces, purposeIds, legIntPurposeIds, str2, flexiblePurposeIds, specialPurposeIds, featureIds, specialFeatureIds, null, false, null, null, null, null, null, null, 1044480, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(purposeIds, "purposeIds");
        Intrinsics.checkNotNullParameter(legIntPurposeIds, "legIntPurposeIds");
        Intrinsics.checkNotNullParameter(flexiblePurposeIds, "flexiblePurposeIds");
        Intrinsics.checkNotNullParameter(specialPurposeIds, "specialPurposeIds");
        Intrinsics.checkNotNullParameter(featureIds, "featureIds");
        Intrinsics.checkNotNullParameter(specialFeatureIds, "specialFeatureIds");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Vendor(String id, String name, String str, String namespace, VendorNamespaces vendorNamespaces, List<String> purposeIds, List<String> legIntPurposeIds, String str2, List<String> flexiblePurposeIds, List<String> specialPurposeIds, List<String> featureIds, List<String> specialFeatureIds, Long l) {
        this(id, name, str, namespace, vendorNamespaces, purposeIds, legIntPurposeIds, str2, flexiblePurposeIds, specialPurposeIds, featureIds, specialFeatureIds, l, false, null, null, null, null, null, null, 1040384, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(purposeIds, "purposeIds");
        Intrinsics.checkNotNullParameter(legIntPurposeIds, "legIntPurposeIds");
        Intrinsics.checkNotNullParameter(flexiblePurposeIds, "flexiblePurposeIds");
        Intrinsics.checkNotNullParameter(specialPurposeIds, "specialPurposeIds");
        Intrinsics.checkNotNullParameter(featureIds, "featureIds");
        Intrinsics.checkNotNullParameter(specialFeatureIds, "specialFeatureIds");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Vendor(String id, String name, String str, String namespace, VendorNamespaces vendorNamespaces, List<String> purposeIds, List<String> legIntPurposeIds, String str2, List<String> flexiblePurposeIds, List<String> specialPurposeIds, List<String> featureIds, List<String> specialFeatureIds, Long l, boolean z) {
        this(id, name, str, namespace, vendorNamespaces, purposeIds, legIntPurposeIds, str2, flexiblePurposeIds, specialPurposeIds, featureIds, specialFeatureIds, l, z, null, null, null, null, null, null, 1032192, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(purposeIds, "purposeIds");
        Intrinsics.checkNotNullParameter(legIntPurposeIds, "legIntPurposeIds");
        Intrinsics.checkNotNullParameter(flexiblePurposeIds, "flexiblePurposeIds");
        Intrinsics.checkNotNullParameter(specialPurposeIds, "specialPurposeIds");
        Intrinsics.checkNotNullParameter(featureIds, "featureIds");
        Intrinsics.checkNotNullParameter(specialFeatureIds, "specialFeatureIds");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Vendor(String id, String name, String str, String namespace, VendorNamespaces vendorNamespaces, List<String> purposeIds, List<String> legIntPurposeIds, String str2, List<String> flexiblePurposeIds, List<String> specialPurposeIds, List<String> featureIds, List<String> specialFeatureIds, Long l, boolean z, String str3) {
        this(id, name, str, namespace, vendorNamespaces, purposeIds, legIntPurposeIds, str2, flexiblePurposeIds, specialPurposeIds, featureIds, specialFeatureIds, l, z, str3, null, null, null, null, null, 1015808, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(purposeIds, "purposeIds");
        Intrinsics.checkNotNullParameter(legIntPurposeIds, "legIntPurposeIds");
        Intrinsics.checkNotNullParameter(flexiblePurposeIds, "flexiblePurposeIds");
        Intrinsics.checkNotNullParameter(specialPurposeIds, "specialPurposeIds");
        Intrinsics.checkNotNullParameter(featureIds, "featureIds");
        Intrinsics.checkNotNullParameter(specialFeatureIds, "specialFeatureIds");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Vendor(String id, String name, String str, String namespace, VendorNamespaces vendorNamespaces, List<String> purposeIds, List<String> legIntPurposeIds, String str2, List<String> flexiblePurposeIds, List<String> specialPurposeIds, List<String> featureIds, List<String> specialFeatureIds, Long l, boolean z, String str3, Set<String> set) {
        this(id, name, str, namespace, vendorNamespaces, purposeIds, legIntPurposeIds, str2, flexiblePurposeIds, specialPurposeIds, featureIds, specialFeatureIds, l, z, str3, set, null, null, null, null, 983040, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(purposeIds, "purposeIds");
        Intrinsics.checkNotNullParameter(legIntPurposeIds, "legIntPurposeIds");
        Intrinsics.checkNotNullParameter(flexiblePurposeIds, "flexiblePurposeIds");
        Intrinsics.checkNotNullParameter(specialPurposeIds, "specialPurposeIds");
        Intrinsics.checkNotNullParameter(featureIds, "featureIds");
        Intrinsics.checkNotNullParameter(specialFeatureIds, "specialFeatureIds");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Vendor(String id, String name, String str, String namespace, VendorNamespaces vendorNamespaces, List<String> purposeIds, List<String> legIntPurposeIds, String str2, List<String> flexiblePurposeIds, List<String> specialPurposeIds, List<String> featureIds, List<String> specialFeatureIds, Long l, boolean z, String str3, Set<String> set, DataRetention dataRetention) {
        this(id, name, str, namespace, vendorNamespaces, purposeIds, legIntPurposeIds, str2, flexiblePurposeIds, specialPurposeIds, featureIds, specialFeatureIds, l, z, str3, set, dataRetention, null, null, null, 917504, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(purposeIds, "purposeIds");
        Intrinsics.checkNotNullParameter(legIntPurposeIds, "legIntPurposeIds");
        Intrinsics.checkNotNullParameter(flexiblePurposeIds, "flexiblePurposeIds");
        Intrinsics.checkNotNullParameter(specialPurposeIds, "specialPurposeIds");
        Intrinsics.checkNotNullParameter(featureIds, "featureIds");
        Intrinsics.checkNotNullParameter(specialFeatureIds, "specialFeatureIds");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Vendor(String id, String name, String str, String namespace, VendorNamespaces vendorNamespaces, List<String> purposeIds, List<String> legIntPurposeIds, String str2, List<String> flexiblePurposeIds, List<String> specialPurposeIds, List<String> featureIds, List<String> specialFeatureIds, Long l, boolean z, String str3, Set<String> set, DataRetention dataRetention, List<Url> list) {
        this(id, name, str, namespace, vendorNamespaces, purposeIds, legIntPurposeIds, str2, flexiblePurposeIds, specialPurposeIds, featureIds, specialFeatureIds, l, z, str3, set, dataRetention, list, null, null, 786432, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(purposeIds, "purposeIds");
        Intrinsics.checkNotNullParameter(legIntPurposeIds, "legIntPurposeIds");
        Intrinsics.checkNotNullParameter(flexiblePurposeIds, "flexiblePurposeIds");
        Intrinsics.checkNotNullParameter(specialPurposeIds, "specialPurposeIds");
        Intrinsics.checkNotNullParameter(featureIds, "featureIds");
        Intrinsics.checkNotNullParameter(specialFeatureIds, "specialFeatureIds");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Vendor(String id, String name, String str, String namespace, VendorNamespaces vendorNamespaces, List<String> purposeIds, List<String> legIntPurposeIds, String str2, List<String> flexiblePurposeIds, List<String> specialPurposeIds, List<String> featureIds, List<String> specialFeatureIds, Long l, boolean z, String str3, Set<String> set, DataRetention dataRetention, List<Url> list, List<String> essentialPurposeIds) {
        this(id, name, str, namespace, vendorNamespaces, purposeIds, legIntPurposeIds, str2, flexiblePurposeIds, specialPurposeIds, featureIds, specialFeatureIds, l, z, str3, set, dataRetention, list, essentialPurposeIds, null, 524288, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(purposeIds, "purposeIds");
        Intrinsics.checkNotNullParameter(legIntPurposeIds, "legIntPurposeIds");
        Intrinsics.checkNotNullParameter(flexiblePurposeIds, "flexiblePurposeIds");
        Intrinsics.checkNotNullParameter(specialPurposeIds, "specialPurposeIds");
        Intrinsics.checkNotNullParameter(featureIds, "featureIds");
        Intrinsics.checkNotNullParameter(specialFeatureIds, "specialFeatureIds");
        Intrinsics.checkNotNullParameter(essentialPurposeIds, "essentialPurposeIds");
    }

    public Vendor(String id, String name, String str, String namespace, VendorNamespaces vendorNamespaces, List<String> purposeIds, List<String> legIntPurposeIds, String str2, List<String> flexiblePurposeIds, List<String> specialPurposeIds, List<String> featureIds, List<String> specialFeatureIds, Long l, boolean z, String str3, Set<String> set, DataRetention dataRetention, List<Url> list, List<String> essentialPurposeIds, DeviceStorageDisclosures deviceStorageDisclosures) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        Intrinsics.checkNotNullParameter(purposeIds, "purposeIds");
        Intrinsics.checkNotNullParameter(legIntPurposeIds, "legIntPurposeIds");
        Intrinsics.checkNotNullParameter(flexiblePurposeIds, "flexiblePurposeIds");
        Intrinsics.checkNotNullParameter(specialPurposeIds, "specialPurposeIds");
        Intrinsics.checkNotNullParameter(featureIds, "featureIds");
        Intrinsics.checkNotNullParameter(specialFeatureIds, "specialFeatureIds");
        Intrinsics.checkNotNullParameter(essentialPurposeIds, "essentialPurposeIds");
        this.id = id;
        this.name = name;
        this.privacyPolicyUrl = str;
        this.namespace = namespace;
        this.namespaces = vendorNamespaces;
        this.purposeIds = purposeIds;
        this.legIntPurposeIds = legIntPurposeIds;
        this.iabId = str2;
        this.flexiblePurposeIds = flexiblePurposeIds;
        this.specialPurposeIds = specialPurposeIds;
        this.featureIds = featureIds;
        this.specialFeatureIds = specialFeatureIds;
        this.cookieMaxAgeSeconds = l;
        this.usesNonCookieAccess = z;
        this.deviceStorageDisclosureUrl = str3;
        this.dataDeclaration = set;
        this.dataRetention = dataRetention;
        this.urls = list;
        this.essentialPurposeIds = essentialPurposeIds;
        this.deviceStorageDisclosures = deviceStorageDisclosures;
    }

    public /* synthetic */ Vendor(String str, String str2, String str3, String str4, VendorNamespaces vendorNamespaces, List list, List list2, String str5, List list3, List list4, List list5, List list6, Long l, boolean z, String str6, Set set, DataRetention dataRetention, List list7, List list8, DeviceStorageDisclosures deviceStorageDisclosures, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? null : str3, (i & 8) == 0 ? str4 : "", (i & 16) != 0 ? null : vendorNamespaces, (i & 32) != 0 ? new ArrayList() : list, (i & 64) != 0 ? new ArrayList() : list2, (i & 128) != 0 ? null : str5, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? CollectionsKt.emptyList() : list3, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? CollectionsKt.emptyList() : list4, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? CollectionsKt.emptyList() : list5, (i & 2048) != 0 ? CollectionsKt.emptyList() : list6, (i & 4096) != 0 ? null : l, (i & 8192) != 0 ? false : z, (i & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? null : str6, (i & 32768) != 0 ? null : set, (i & 65536) != 0 ? null : dataRetention, (i & 131072) != 0 ? null : list7, (i & 262144) != 0 ? new ArrayList() : list8, (i & 524288) != 0 ? null : deviceStorageDisclosures);
    }
}
