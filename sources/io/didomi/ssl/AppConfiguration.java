package io.didomi.ssl;

import com.adjust.sdk.Constants;
import com.amazon.a.a.o.b;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.google.gson.annotations.SerializedName;
import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import io.didomi.ssl.config.app.SyncConfiguration;
import io.didomi.ssl.models.GoogleConfig;
import io.didomi.ssl.purpose.common.model.PurposeCategory;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import net.openid.appauth.AuthorizationRequest;

/* JADX INFO: renamed from: io.didomi.sdk.l, reason: from toString */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u0000 B2\u00020\u0001:\t\n\u000f\u0011\u0016\u001b$ &+B\u008f\u0001\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0019\u0012\b\b\u0002\u0010\"\u001a\u00020\u001e\u0012 \b\u0002\u0010(\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020#0#\u0012\b\b\u0002\u0010-\u001a\u00020)\u0012\b\b\u0002\u00102\u001a\u00020.\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010:\u001a\u000207\u0012\b\b\u0002\u0010?\u001a\u00020;¢\u0006\u0004\b@\u0010AJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001a\u0010\r\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u001a\u0010\u0013\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0018\u001a\u00020\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001d\u001a\u00020\u00198\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\"\u001a\u00020\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001f\u001a\u0004\b \u0010!R2\u0010(\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020#0#8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001a\u0010-\u001a\u00020)8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010*\u001a\u0004\b+\u0010,R\u001a\u00102\u001a\u00020.8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010/\u001a\u0004\b0\u00101R\u001c\u00106\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u00103\u001a\u0004\b4\u00105R\u001a\u0010:\u001a\u0002078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b0\u00108\u001a\u0004\b$\u00109R\u001a\u0010?\u001a\u00020;8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b\u000f\u0010>¨\u0006C"}, d2 = {"Lio/didomi/sdk/l;", "", "", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "Lio/didomi/sdk/l$a;", "a", "Lio/didomi/sdk/l$a;", "()Lio/didomi/sdk/l$a;", "app", "Lio/didomi/sdk/l$d;", "b", "Lio/didomi/sdk/l$d;", "c", "()Lio/didomi/sdk/l$d;", "languages", "Lio/didomi/sdk/l$e;", "Lio/didomi/sdk/l$e;", "d", "()Lio/didomi/sdk/l$e;", "notice", "Lio/didomi/sdk/l$f;", "Lio/didomi/sdk/l$f;", "e", "()Lio/didomi/sdk/l$f;", "preferences", "Lio/didomi/sdk/config/app/SyncConfiguration;", "Lio/didomi/sdk/config/app/SyncConfiguration;", "g", "()Lio/didomi/sdk/config/app/SyncConfiguration;", BaseJavaModule.METHOD_TYPE_SYNC, "", "f", "Ljava/util/Map;", "h", "()Ljava/util/Map;", "textsConfiguration", "Lio/didomi/sdk/l$h;", "Lio/didomi/sdk/l$h;", "i", "()Lio/didomi/sdk/l$h;", "theme", "Lio/didomi/sdk/l$i;", "Lio/didomi/sdk/l$i;", "j", "()Lio/didomi/sdk/l$i;", "user", "Ljava/lang/String;", "getVersion", "()Ljava/lang/String;", DiagnosticsEntry.VERSION_KEY, "Lio/didomi/sdk/l$g;", "Lio/didomi/sdk/l$g;", "()Lio/didomi/sdk/l$g;", "regulation", "Lio/didomi/sdk/l$c;", "k", "Lio/didomi/sdk/l$c;", "()Lio/didomi/sdk/l$c;", "featureFlags", "<init>", "(Lio/didomi/sdk/l$a;Lio/didomi/sdk/l$d;Lio/didomi/sdk/l$e;Lio/didomi/sdk/l$f;Lio/didomi/sdk/config/app/SyncConfiguration;Ljava/util/Map;Lio/didomi/sdk/l$h;Lio/didomi/sdk/l$i;Ljava/lang/String;Lio/didomi/sdk/l$g;Lio/didomi/sdk/l$c;)V", "l", "android_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class AppConfiguration {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
    @SerializedName("app")
    private final App app;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
    @SerializedName("languages")
    private final Languages languages;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
    @SerializedName("notice")
    private final Notice notice;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
    @SerializedName("preferences")
    private final Preferences preferences;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata and from toString */
    @SerializedName(BaseJavaModule.METHOD_TYPE_SYNC)
    private final SyncConfiguration sync;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata and from toString */
    @SerializedName("texts")
    private final Map<String, Map<String, String>> textsConfiguration;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata and from toString */
    @SerializedName("theme")
    private final Theme theme;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata and from toString */
    @SerializedName("user")
    private final User user;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata and from toString */
    @SerializedName(DiagnosticsEntry.VERSION_KEY)
    private final String version;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata and from toString */
    @SerializedName("regulation")
    private final Regulation regulation;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata and from toString */
    @SerializedName("featureFlags")
    private final FeatureFlags featureFlags;

    /* JADX INFO: renamed from: io.didomi.sdk.l$a, reason: from toString */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\t\u000eB£\u0001\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020 0\u001f\u0012\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00020\u001f\u0012\b\b\u0002\u0010)\u001a\u00020\u0001\u0012\b\b\u0002\u0010*\u001a\u00020\u0001\u0012\b\b\u0002\u0010,\u001a\u00020\u0002\u0012\b\b\u0002\u0010.\u001a\u00020\u0007\u0012\b\b\u0002\u00101\u001a\u00020\u0002\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u000103¢\u0006\u0004\b7\u00108J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u001a\u0010\u0016\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u001b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001d\u0010\u001aR \u0010$\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u0012\u0010#R \u0010&\u001a\b\u0012\u0004\u0012\u00020\u00020\u001f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\"\u001a\u0004\b%\u0010#R\u001a\u0010)\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010'\u001a\u0004\b\t\u0010(R\u001a\u0010*\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010'\u001a\u0004\b\u001c\u0010(R\u001a\u0010,\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010\n\u001a\u0004\b+\u0010\fR\u001a\u0010.\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b-\u0010\u001aR\"\u00101\u001a\u00020\u00028\u0000@\u0000X\u0081\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u000e\u0010\f\"\u0004\b/\u00100R\u001c\u00102\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010\n\u001a\u0004\b!\u0010\fR\u001c\u00106\u001a\u0004\u0018\u0001038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u00104\u001a\u0004\b\u0017\u00105¨\u00069"}, d2 = {"Lio/didomi/sdk/l$a;", "", "", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "Ljava/lang/String;", "k", "()Ljava/lang/String;", "name", "b", "l", "privacyPolicyURL", "Lio/didomi/sdk/l$a$b;", "c", "Lio/didomi/sdk/l$a$b;", "n", "()Lio/didomi/sdk/l$a$b;", Didomi.VIEW_VENDORS, "d", "Z", "h", "()Z", "gdprAppliesGlobally", "e", "i", "gdprAppliesWhenUnknown", "", "Lio/didomi/sdk/CustomPurpose;", "f", "Ljava/util/List;", "()Ljava/util/List;", "customPurposes", "g", "essentialPurposes", "Ljava/lang/Object;", "()Ljava/lang/Object;", "consentDuration", "deniedConsentDuration", "j", "logoUrl", "m", "shouldHideDidomiLogo", "setCountry$android_release", "(Ljava/lang/String;)V", "country", "deploymentId", "Lio/didomi/sdk/l$a$a;", "Lio/didomi/sdk/l$a$a;", "()Lio/didomi/sdk/l$a$a;", "dcsConfig", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lio/didomi/sdk/l$a$b;ZZLjava/util/List;Ljava/util/List;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Lio/didomi/sdk/l$a$a;)V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class App {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
        @SerializedName("name")
        private final String name;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
        @SerializedName("privacyPolicyURL")
        private final String privacyPolicyURL;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
        @SerializedName(Didomi.VIEW_VENDORS)
        private final Vendors vendors;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
        @SerializedName("gdprAppliesGlobally")
        private final boolean gdprAppliesGlobally;

        /* JADX INFO: renamed from: e, reason: from kotlin metadata and from toString */
        @SerializedName("gdprAppliesWhenUnknown")
        private final boolean gdprAppliesWhenUnknown;

        /* JADX INFO: renamed from: f, reason: from kotlin metadata and from toString */
        @SerializedName("customPurposes")
        private final List<CustomPurpose> customPurposes;

        /* JADX INFO: renamed from: g, reason: from kotlin metadata and from toString */
        @SerializedName("essentialPurposes")
        private final List<String> essentialPurposes;

        /* JADX INFO: renamed from: h, reason: from kotlin metadata and from toString */
        @SerializedName("consentDuration")
        private final Object consentDuration;

        /* JADX INFO: renamed from: i, reason: from kotlin metadata and from toString */
        @SerializedName("deniedConsentDuration")
        private final Object deniedConsentDuration;

        /* JADX INFO: renamed from: j, reason: from kotlin metadata and from toString */
        @SerializedName("logoUrl")
        private final String logoUrl;

        /* JADX INFO: renamed from: k, reason: from kotlin metadata and from toString */
        @SerializedName("shouldHideDidomiLogo")
        private final boolean shouldHideDidomiLogo;

        /* JADX INFO: renamed from: l, reason: from kotlin metadata and from toString */
        @SerializedName("country")
        private String country;

        /* JADX INFO: renamed from: m, reason: from kotlin metadata and from toString */
        @SerializedName("deploymentId")
        private final String deploymentId;

        /* JADX INFO: renamed from: n, reason: from kotlin metadata and from toString */
        @SerializedName("consentString")
        private final DCSConfig dcsConfig;

        /* JADX INFO: renamed from: io.didomi.sdk.l$a$a, reason: collision with other inner class name and from toString */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001a\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u001a\u0010\u0011\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lio/didomi/sdk/l$a$a;", "", "", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "I", "()I", "schemaVersion", "b", "Z", "getSignatureEnabled", "()Z", "signatureEnabled", "<init>", "(IZ)V", "android_release"}, k = 1, mv = {1, 8, 0})
        public static final /* data */ class DCSConfig {

            /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
            @SerializedName(DiagnosticsEntry.VERSION_KEY)
            private final int schemaVersion;

            /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
            @SerializedName("signatureEnabled")
            private final boolean signatureEnabled;

            /* JADX WARN: Multi-variable type inference failed */
            public DCSConfig() {
                this(0, 0 == true ? 1 : 0, 3, null);
            }

            /* JADX INFO: renamed from: a, reason: from getter */
            public final int getSchemaVersion() {
                return this.schemaVersion;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof DCSConfig)) {
                    return false;
                }
                DCSConfig dCSConfig = (DCSConfig) other;
                return this.schemaVersion == dCSConfig.schemaVersion && this.signatureEnabled == dCSConfig.signatureEnabled;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v3, types: [int] */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v2 */
            /* JADX WARN: Type inference failed for: r1v3 */
            public int hashCode() {
                int iHashCode = Integer.hashCode(this.schemaVersion) * 31;
                boolean z = this.signatureEnabled;
                ?? r1 = z;
                if (z) {
                    r1 = 1;
                }
                return iHashCode + r1;
            }

            public String toString() {
                return "DCSConfig(schemaVersion=" + this.schemaVersion + ", signatureEnabled=" + this.signatureEnabled + ')';
            }

            public DCSConfig(int i, boolean z) {
                this.schemaVersion = i;
                this.signatureEnabled = z;
            }

            public /* synthetic */ DCSConfig(int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                this((i2 & 1) != 0 ? 2 : i, (i2 & 2) != 0 ? false : z);
            }
        }

        /* JADX INFO: renamed from: io.didomi.sdk.l$a$b, reason: from toString */
        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\nB=\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0014\u0012\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u000f¢\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0011\u001a\u0004\b\n\u0010\u0012¨\u0006\u001d"}, d2 = {"Lio/didomi/sdk/l$a$b;", "", "", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "Lio/didomi/sdk/l$a$b$a;", "a", "Lio/didomi/sdk/l$a$b$a;", "d", "()Lio/didomi/sdk/l$a$b$a;", "iab", "", "b", "Ljava/util/Set;", "()Ljava/util/Set;", "didomi", "Lio/didomi/sdk/models/GoogleConfig;", "c", "Lio/didomi/sdk/models/GoogleConfig;", "()Lio/didomi/sdk/models/GoogleConfig;", "googleConfig", "Lio/didomi/sdk/g7;", "custom", "<init>", "(Lio/didomi/sdk/l$a$b$a;Ljava/util/Set;Lio/didomi/sdk/models/GoogleConfig;Ljava/util/Set;)V", "android_release"}, k = 1, mv = {1, 8, 0})
        public static final /* data */ class Vendors {

            /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
            @SerializedName("iab")
            private final IABVendors iab;

            /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
            @SerializedName("didomi")
            private final Set<String> didomi;

            /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
            @SerializedName(Constants.REFERRER_API_GOOGLE)
            private final GoogleConfig googleConfig;

            /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
            @SerializedName("custom")
            private final Set<InternalVendor> custom;

            /* JADX INFO: renamed from: io.didomi.sdk.l$a$b$a, reason: collision with other inner class name and from toString */
            @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\"\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0086\b\u0018\u0000 62\u00020\u0001:\u0002\t\rB\u0091\u0001\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017\u0012\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020!0 \u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b4\u00105J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u001a\u0010\u0011\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0016\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u0018\u0010\u001bR\u001a\u0010\u001f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R \u0010&\u001a\b\u0012\u0004\u0012\u00020!0 8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001c\u0010*\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b\"\u0010)R\u001c\u0010+\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010(\u001a\u0004\b'\u0010)R\u001c\u0010,\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010(\u001a\u0004\b\u001d\u0010)R\u0016\u0010-\u001a\u0004\u0018\u00010\u00048\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010(R\"\u00100\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010\u000e\u001a\u0004\b\r\u0010\u0010\"\u0004\b\t\u0010/R\u001d\u00103\u001a\u0004\u0018\u00010\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b.\u0010)¨\u00067"}, d2 = {"Lio/didomi/sdk/l$a$b$a;", "", "", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "all", "b", "Z", "i", "()Z", "requireUpdatedGVL", "c", "I", "k", "()I", "updateGVLTimeout", "", "d", "Ljava/util/Set;", "f", "()Ljava/util/Set;", "include", "e", "exclude", "enabled", "", "Lio/didomi/sdk/l$a$b$a$b;", "g", "Ljava/util/List;", "j", "()Ljava/util/List;", "restrictions", "h", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "majorVersion", "minorVersion", "gvlSpecificationVersion", "internalCmpId", "l", "(Z)V", "canBeEnabled", "m", "Lkotlin/Lazy;", "validCmpId", "<init>", "(Ljava/lang/Boolean;ZILjava/util/Set;Ljava/util/Set;ZLjava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "n", "android_release"}, k = 1, mv = {1, 8, 0})
            public static final /* data */ class IABVendors {

                /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
                @SerializedName("all")
                private final Boolean all;

                /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
                @SerializedName("requireUpdatedGVL")
                private final boolean requireUpdatedGVL;

                /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
                @SerializedName("updateGVLTimeout")
                private final int updateGVLTimeout;

                /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
                @SerializedName("include")
                private final Set<String> include;

                /* JADX INFO: renamed from: e, reason: from kotlin metadata and from toString */
                @SerializedName("exclude")
                private final Set<String> exclude;

                /* JADX INFO: renamed from: f, reason: from kotlin metadata and from toString */
                @SerializedName("enabled")
                private final boolean enabled;

                /* JADX INFO: renamed from: g, reason: from kotlin metadata and from toString */
                @SerializedName("restrictions")
                private final List<PublisherRestriction> restrictions;

                /* JADX INFO: renamed from: h, reason: from kotlin metadata and from toString */
                @SerializedName(DiagnosticsEntry.VERSION_KEY)
                private final Integer majorVersion;

                /* JADX INFO: renamed from: i, reason: from kotlin metadata and from toString */
                @SerializedName("minorVersion")
                private final Integer minorVersion;

                /* JADX INFO: renamed from: j, reason: from kotlin metadata and from toString */
                @SerializedName("gvlSpecificationVersion")
                private final Integer gvlSpecificationVersion;

                /* JADX INFO: renamed from: k, reason: from kotlin metadata and from toString */
                @SerializedName("cmpId")
                private final Integer internalCmpId;

                /* JADX INFO: renamed from: l, reason: from kotlin metadata */
                private boolean canBeEnabled;

                /* JADX INFO: renamed from: m, reason: from kotlin metadata */
                private final Lazy validCmpId;

                /* JADX INFO: renamed from: io.didomi.sdk.l$a$b$a$b, reason: collision with other inner class name and from toString */
                @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\t\rJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u0016"}, d2 = {"Lio/didomi/sdk/l$a$b$a$b;", "", "", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", DiagnosticsEntry.ID_KEY, "b", "purposeId", "Lio/didomi/sdk/l$a$b$a$b$a;", "c", "Lio/didomi/sdk/l$a$b$a$b$a;", "d", "()Lio/didomi/sdk/l$a$b$a$b$a;", Didomi.VIEW_VENDORS, "restrictionType", "android_release"}, k = 1, mv = {1, 8, 0})
                public static final /* data */ class PublisherRestriction {

                    /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
                    @SerializedName(DiagnosticsEntry.ID_KEY)
                    private final String id;

                    /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
                    @SerializedName("purposeId")
                    private final String purposeId;

                    /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
                    @SerializedName(Didomi.VIEW_VENDORS)
                    private final RestrictionVendors vendors;

                    /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
                    @SerializedName("restrictionType")
                    private final String restrictionType;

                    /* JADX INFO: renamed from: io.didomi.sdk.l$a$b$a$b$a, reason: collision with other inner class name and from toString */
                    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\tB!\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\f¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\u000fR\u001b\u0010\u0015\u001a\u00020\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\r\u0010\u0014¨\u0006\u0018"}, d2 = {"Lio/didomi/sdk/l$a$b$a$b$a;", "", "", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "Ljava/lang/String;", "typeAsString", "", "b", "Ljava/util/Set;", "()Ljava/util/Set;", "ids", "Lio/didomi/sdk/l$a$b$a$b$a$a;", "c", "Lkotlin/Lazy;", "()Lio/didomi/sdk/l$a$b$a$b$a$a;", "restrictionVendorsType", "<init>", "(Ljava/lang/String;Ljava/util/Set;)V", "android_release"}, k = 1, mv = {1, 8, 0})
                    public static final /* data */ class RestrictionVendors {

                        /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
                        @SerializedName("type")
                        private final String typeAsString;

                        /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
                        @SerializedName("ids")
                        private final Set<String> ids;

                        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
                        private final Lazy restrictionVendorsType;

                        /* JADX INFO: renamed from: io.didomi.sdk.l$a$b$a$b$a$a, reason: collision with other inner class name */
                        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0003B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lio/didomi/sdk/l$a$b$a$b$a$a;", "", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "value", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "c", "d", "e", "android_release"}, k = 1, mv = {1, 8, 0})
                        public enum EnumC0145a {
                            ALL("all"),
                            LIST("list"),
                            UNKNOWN("unknown");


                            /* JADX INFO: renamed from: b, reason: from kotlin metadata */
                            public static final Companion INSTANCE = new Companion(null);

                            /* JADX INFO: renamed from: a, reason: from kotlin metadata */
                            private final String value;

                            /* JADX INFO: renamed from: io.didomi.sdk.l$a$b$a$b$a$a$a, reason: collision with other inner class name and from kotlin metadata */
                            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lio/didomi/sdk/l$a$b$a$b$a$a$a;", "", "", "value", "Lio/didomi/sdk/l$a$b$a$b$a$a;", "a", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
                            public static final class Companion {
                                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                                    this();
                                }

                                public final EnumC0145a a(String value) {
                                    Intrinsics.checkNotNullParameter(value, "value");
                                    Locale ENGLISH = Locale.ENGLISH;
                                    Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
                                    String lowerCase = value.toLowerCase(ENGLISH);
                                    Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                                    EnumC0145a enumC0145a = EnumC0145a.ALL;
                                    if (Intrinsics.areEqual(lowerCase, enumC0145a.getValue())) {
                                        return enumC0145a;
                                    }
                                    EnumC0145a enumC0145a2 = EnumC0145a.LIST;
                                    return Intrinsics.areEqual(lowerCase, enumC0145a2.getValue()) ? enumC0145a2 : EnumC0145a.UNKNOWN;
                                }

                                private Companion() {
                                }
                            }

                            EnumC0145a(String str) {
                                this.value = str;
                            }

                            /* JADX INFO: renamed from: b, reason: from getter */
                            public final String getValue() {
                                return this.value;
                            }
                        }

                        /* JADX INFO: renamed from: io.didomi.sdk.l$a$b$a$b$a$b, reason: collision with other inner class name */
                        @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lio/didomi/sdk/l$a$b$a$b$a$a;", "a", "()Lio/didomi/sdk/l$a$b$a$b$a$a;"}, k = 3, mv = {1, 8, 0})
                        static final class C0147b extends Lambda implements Function0 {
                            C0147b() {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                            public final EnumC0145a invoke() {
                                return EnumC0145a.INSTANCE.a(RestrictionVendors.this.typeAsString);
                            }
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        public RestrictionVendors() {
                            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
                        }

                        public final EnumC0145a b() {
                            return (EnumC0145a) this.restrictionVendorsType.getValue();
                        }

                        public boolean equals(Object other) {
                            if (this == other) {
                                return true;
                            }
                            if (!(other instanceof RestrictionVendors)) {
                                return false;
                            }
                            RestrictionVendors restrictionVendors = (RestrictionVendors) other;
                            return Intrinsics.areEqual(this.typeAsString, restrictionVendors.typeAsString) && Intrinsics.areEqual(this.ids, restrictionVendors.ids);
                        }

                        public int hashCode() {
                            return (this.typeAsString.hashCode() * 31) + this.ids.hashCode();
                        }

                        public String toString() {
                            return "RestrictionVendors(typeAsString=" + this.typeAsString + ", ids=" + this.ids + ')';
                        }

                        public RestrictionVendors(String typeAsString, Set<String> ids) {
                            Intrinsics.checkNotNullParameter(typeAsString, "typeAsString");
                            Intrinsics.checkNotNullParameter(ids, "ids");
                            this.typeAsString = typeAsString;
                            this.ids = ids;
                            this.restrictionVendorsType = LazyKt.lazy(new C0147b());
                        }

                        public final Set<String> a() {
                            return this.ids;
                        }

                        public /* synthetic */ RestrictionVendors(String str, Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
                            this((i & 1) != 0 ? EnumC0145a.UNKNOWN.getValue() : str, (i & 2) != 0 ? SetsKt.emptySet() : set);
                        }
                    }

                    /* JADX INFO: renamed from: io.didomi.sdk.l$a$b$a$b$b, reason: collision with other inner class name */
                    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0003B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lio/didomi/sdk/l$a$b$a$b$b;", "", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "value", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "c", "d", "e", "f", "g", "android_release"}, k = 1, mv = {1, 8, 0})
                    public enum EnumC0148b {
                        ALLOW("allow"),
                        DISALLOW("disallow"),
                        REQUIRE_CONSENT("req-consent"),
                        REQUIRE_LI("req-li"),
                        UNKNOWN("unknown");


                        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
                        public static final Companion INSTANCE = new Companion(null);

                        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
                        private final String value;

                        /* JADX INFO: renamed from: io.didomi.sdk.l$a$b$a$b$b$a, reason: collision with other inner class name and from kotlin metadata */
                        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lio/didomi/sdk/l$a$b$a$b$b$a;", "", "", "value", "Lio/didomi/sdk/l$a$b$a$b$b;", "a", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
                        public static final class Companion {
                            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                                this();
                            }

                            public final EnumC0148b a(String value) {
                                Intrinsics.checkNotNullParameter(value, "value");
                                Locale ENGLISH = Locale.ENGLISH;
                                Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
                                String lowerCase = value.toLowerCase(ENGLISH);
                                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                                EnumC0148b enumC0148b = EnumC0148b.ALLOW;
                                if (Intrinsics.areEqual(lowerCase, enumC0148b.getValue())) {
                                    return enumC0148b;
                                }
                                EnumC0148b enumC0148b2 = EnumC0148b.DISALLOW;
                                if (Intrinsics.areEqual(lowerCase, enumC0148b2.getValue())) {
                                    return enumC0148b2;
                                }
                                EnumC0148b enumC0148b3 = EnumC0148b.REQUIRE_CONSENT;
                                if (Intrinsics.areEqual(lowerCase, enumC0148b3.getValue())) {
                                    return enumC0148b3;
                                }
                                EnumC0148b enumC0148b4 = EnumC0148b.REQUIRE_LI;
                                return Intrinsics.areEqual(lowerCase, enumC0148b4.getValue()) ? enumC0148b4 : EnumC0148b.UNKNOWN;
                            }

                            private Companion() {
                            }
                        }

                        EnumC0148b(String str) {
                            this.value = str;
                        }

                        /* JADX INFO: renamed from: b, reason: from getter */
                        public final String getValue() {
                            return this.value;
                        }
                    }

                    /* JADX INFO: renamed from: a, reason: from getter */
                    public final String getId() {
                        return this.id;
                    }

                    /* JADX INFO: renamed from: b, reason: from getter */
                    public final String getPurposeId() {
                        return this.purposeId;
                    }

                    /* JADX INFO: renamed from: c, reason: from getter */
                    public final String getRestrictionType() {
                        return this.restrictionType;
                    }

                    /* JADX INFO: renamed from: d, reason: from getter */
                    public final RestrictionVendors getVendors() {
                        return this.vendors;
                    }

                    public boolean equals(Object other) {
                        if (this == other) {
                            return true;
                        }
                        if (!(other instanceof PublisherRestriction)) {
                            return false;
                        }
                        PublisherRestriction publisherRestriction = (PublisherRestriction) other;
                        return Intrinsics.areEqual(this.id, publisherRestriction.id) && Intrinsics.areEqual(this.purposeId, publisherRestriction.purposeId) && Intrinsics.areEqual(this.vendors, publisherRestriction.vendors) && Intrinsics.areEqual(this.restrictionType, publisherRestriction.restrictionType);
                    }

                    public int hashCode() {
                        String str = this.id;
                        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                        String str2 = this.purposeId;
                        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                        RestrictionVendors restrictionVendors = this.vendors;
                        int iHashCode3 = (iHashCode2 + (restrictionVendors == null ? 0 : restrictionVendors.hashCode())) * 31;
                        String str3 = this.restrictionType;
                        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
                    }

                    public String toString() {
                        return "PublisherRestriction(id=" + this.id + ", purposeId=" + this.purposeId + ", vendors=" + this.vendors + ", restrictionType=" + this.restrictionType + ')';
                    }
                }

                /* JADX INFO: renamed from: io.didomi.sdk.l$a$b$a$c */
                @Metadata(d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0})
                static final class c extends Lambda implements Function0 {
                    c() {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public final Integer invoke() {
                        Integer num = IABVendors.this.internalCmpId;
                        if (num != null) {
                            int iIntValue = num.intValue();
                            if (2 > iIntValue || iIntValue >= 4096) {
                                num = null;
                            }
                            if (num != null) {
                                Log.i$default("Using CMP Id " + num.intValue(), null, 2, null);
                                return num;
                            }
                        }
                        return null;
                    }
                }

                public IABVendors() {
                    this(null, false, 0, null, null, false, null, null, null, null, null, 2047, null);
                }

                /* JADX INFO: renamed from: b, reason: from getter */
                public final boolean getCanBeEnabled() {
                    return this.canBeEnabled;
                }

                /* JADX INFO: renamed from: c, reason: from getter */
                public final boolean getEnabled() {
                    return this.enabled;
                }

                public final Set<String> d() {
                    return this.exclude;
                }

                /* JADX INFO: renamed from: e, reason: from getter */
                public final Integer getGvlSpecificationVersion() {
                    return this.gvlSpecificationVersion;
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof IABVendors)) {
                        return false;
                    }
                    IABVendors iABVendors = (IABVendors) other;
                    return Intrinsics.areEqual(this.all, iABVendors.all) && this.requireUpdatedGVL == iABVendors.requireUpdatedGVL && this.updateGVLTimeout == iABVendors.updateGVLTimeout && Intrinsics.areEqual(this.include, iABVendors.include) && Intrinsics.areEqual(this.exclude, iABVendors.exclude) && this.enabled == iABVendors.enabled && Intrinsics.areEqual(this.restrictions, iABVendors.restrictions) && Intrinsics.areEqual(this.majorVersion, iABVendors.majorVersion) && Intrinsics.areEqual(this.minorVersion, iABVendors.minorVersion) && Intrinsics.areEqual(this.gvlSpecificationVersion, iABVendors.gvlSpecificationVersion) && Intrinsics.areEqual(this.internalCmpId, iABVendors.internalCmpId);
                }

                public final Set<String> f() {
                    return this.include;
                }

                /* JADX INFO: renamed from: g, reason: from getter */
                public final Integer getMajorVersion() {
                    return this.majorVersion;
                }

                /* JADX INFO: renamed from: h, reason: from getter */
                public final Integer getMinorVersion() {
                    return this.minorVersion;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r0v4, types: [int] */
                /* JADX WARN: Type inference failed for: r2v1, types: [int] */
                /* JADX WARN: Type inference failed for: r2v24 */
                /* JADX WARN: Type inference failed for: r2v25 */
                /* JADX WARN: Type inference failed for: r3v0 */
                /* JADX WARN: Type inference failed for: r3v1, types: [int] */
                /* JADX WARN: Type inference failed for: r3v2 */
                public int hashCode() {
                    Boolean bool = this.all;
                    int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
                    boolean z = this.requireUpdatedGVL;
                    ?? r2 = z;
                    if (z) {
                        r2 = 1;
                    }
                    int iHashCode2 = (((((((iHashCode + r2) * 31) + Integer.hashCode(this.updateGVLTimeout)) * 31) + this.include.hashCode()) * 31) + this.exclude.hashCode()) * 31;
                    boolean z2 = this.enabled;
                    int iHashCode3 = (((iHashCode2 + (z2 ? 1 : z2)) * 31) + this.restrictions.hashCode()) * 31;
                    Integer num = this.majorVersion;
                    int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
                    Integer num2 = this.minorVersion;
                    int iHashCode5 = (iHashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
                    Integer num3 = this.gvlSpecificationVersion;
                    int iHashCode6 = (iHashCode5 + (num3 == null ? 0 : num3.hashCode())) * 31;
                    Integer num4 = this.internalCmpId;
                    return iHashCode6 + (num4 != null ? num4.hashCode() : 0);
                }

                /* JADX INFO: renamed from: i, reason: from getter */
                public final boolean getRequireUpdatedGVL() {
                    return this.requireUpdatedGVL;
                }

                public final List<PublisherRestriction> j() {
                    return this.restrictions;
                }

                /* JADX INFO: renamed from: k, reason: from getter */
                public final int getUpdateGVLTimeout() {
                    return this.updateGVLTimeout;
                }

                public final Integer l() {
                    return (Integer) this.validCmpId.getValue();
                }

                public String toString() {
                    return "IABVendors(all=" + this.all + ", requireUpdatedGVL=" + this.requireUpdatedGVL + ", updateGVLTimeout=" + this.updateGVLTimeout + ", include=" + this.include + ", exclude=" + this.exclude + ", enabled=" + this.enabled + ", restrictions=" + this.restrictions + ", majorVersion=" + this.majorVersion + ", minorVersion=" + this.minorVersion + ", gvlSpecificationVersion=" + this.gvlSpecificationVersion + ", internalCmpId=" + this.internalCmpId + ')';
                }

                public IABVendors(Boolean bool, boolean z, int i, Set<String> include, Set<String> exclude, boolean z2, List<PublisherRestriction> restrictions, Integer num, Integer num2, Integer num3, Integer num4) {
                    Intrinsics.checkNotNullParameter(include, "include");
                    Intrinsics.checkNotNullParameter(exclude, "exclude");
                    Intrinsics.checkNotNullParameter(restrictions, "restrictions");
                    this.all = bool;
                    this.requireUpdatedGVL = z;
                    this.updateGVLTimeout = i;
                    this.include = include;
                    this.exclude = exclude;
                    this.enabled = z2;
                    this.restrictions = restrictions;
                    this.majorVersion = num;
                    this.minorVersion = num2;
                    this.gvlSpecificationVersion = num3;
                    this.internalCmpId = num4;
                    this.canBeEnabled = true;
                    this.validCmpId = LazyKt.lazy(new c());
                }

                /* JADX INFO: renamed from: a, reason: from getter */
                public final Boolean getAll() {
                    return this.all;
                }

                public final void a(boolean z) {
                    this.canBeEnabled = z;
                }

                public /* synthetic */ IABVendors(Boolean bool, boolean z, int i, Set set, Set set2, boolean z2, List list, Integer num, Integer num2, Integer num3, Integer num4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i2 & 1) != 0 ? null : bool, (i2 & 2) != 0 ? true : z, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? SetsKt.emptySet() : set, (i2 & 16) != 0 ? SetsKt.emptySet() : set2, (i2 & 32) != 0 ? true : z2, (i2 & 64) != 0 ? CollectionsKt.emptyList() : list, (i2 & 128) != 0 ? 2 : num, (i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? null : num2, (i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? null : num3, (i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? null : num4);
                }
            }

            public Vendors() {
                this(null, null, null, null, 15, null);
            }

            public final Set<InternalVendor> a() {
                return this.custom;
            }

            public final Set<String> b() {
                return this.didomi;
            }

            /* JADX INFO: renamed from: c, reason: from getter */
            public final GoogleConfig getGoogleConfig() {
                return this.googleConfig;
            }

            /* JADX INFO: renamed from: d, reason: from getter */
            public final IABVendors getIab() {
                return this.iab;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Vendors)) {
                    return false;
                }
                Vendors vendors = (Vendors) other;
                return Intrinsics.areEqual(this.iab, vendors.iab) && Intrinsics.areEqual(this.didomi, vendors.didomi) && Intrinsics.areEqual(this.googleConfig, vendors.googleConfig) && Intrinsics.areEqual(this.custom, vendors.custom);
            }

            public int hashCode() {
                int iHashCode = ((this.iab.hashCode() * 31) + this.didomi.hashCode()) * 31;
                GoogleConfig googleConfig = this.googleConfig;
                return ((iHashCode + (googleConfig == null ? 0 : googleConfig.hashCode())) * 31) + this.custom.hashCode();
            }

            public String toString() {
                return "Vendors(iab=" + this.iab + ", didomi=" + this.didomi + ", googleConfig=" + this.googleConfig + ", custom=" + this.custom + ')';
            }

            public Vendors(IABVendors iab, Set<String> didomi, GoogleConfig googleConfig, Set<InternalVendor> custom) {
                Intrinsics.checkNotNullParameter(iab, "iab");
                Intrinsics.checkNotNullParameter(didomi, "didomi");
                Intrinsics.checkNotNullParameter(custom, "custom");
                this.iab = iab;
                this.didomi = didomi;
                this.googleConfig = googleConfig;
                this.custom = custom;
            }

            public /* synthetic */ Vendors(IABVendors iABVendors, Set set, GoogleConfig googleConfig, Set set2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? new IABVendors(null, false, 0, null, null, false, null, null, null, null, null, 2047, null) : iABVendors, (i & 2) != 0 ? SetsKt.emptySet() : set, (i & 4) != 0 ? null : googleConfig, (i & 8) != 0 ? SetsKt.emptySet() : set2);
            }
        }

        public App() {
            this(null, null, null, false, false, null, null, null, null, null, false, null, null, null, 16383, null);
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final Object getConsentDuration() {
            return this.consentDuration;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final String getCountry() {
            return this.country;
        }

        public final List<CustomPurpose> c() {
            return this.customPurposes;
        }

        /* JADX INFO: renamed from: d, reason: from getter */
        public final DCSConfig getDcsConfig() {
            return this.dcsConfig;
        }

        /* JADX INFO: renamed from: e, reason: from getter */
        public final Object getDeniedConsentDuration() {
            return this.deniedConsentDuration;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof App)) {
                return false;
            }
            App app2 = (App) other;
            return Intrinsics.areEqual(this.name, app2.name) && Intrinsics.areEqual(this.privacyPolicyURL, app2.privacyPolicyURL) && Intrinsics.areEqual(this.vendors, app2.vendors) && this.gdprAppliesGlobally == app2.gdprAppliesGlobally && this.gdprAppliesWhenUnknown == app2.gdprAppliesWhenUnknown && Intrinsics.areEqual(this.customPurposes, app2.customPurposes) && Intrinsics.areEqual(this.essentialPurposes, app2.essentialPurposes) && Intrinsics.areEqual(this.consentDuration, app2.consentDuration) && Intrinsics.areEqual(this.deniedConsentDuration, app2.deniedConsentDuration) && Intrinsics.areEqual(this.logoUrl, app2.logoUrl) && this.shouldHideDidomiLogo == app2.shouldHideDidomiLogo && Intrinsics.areEqual(this.country, app2.country) && Intrinsics.areEqual(this.deploymentId, app2.deploymentId) && Intrinsics.areEqual(this.dcsConfig, app2.dcsConfig);
        }

        /* JADX INFO: renamed from: f, reason: from getter */
        public final String getDeploymentId() {
            return this.deploymentId;
        }

        public final List<String> g() {
            return this.essentialPurposes;
        }

        /* JADX INFO: renamed from: h, reason: from getter */
        public final boolean getGdprAppliesGlobally() {
            return this.gdprAppliesGlobally;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v21, types: [int] */
        /* JADX WARN: Type inference failed for: r0v7, types: [int] */
        /* JADX WARN: Type inference failed for: r0v9, types: [int] */
        /* JADX WARN: Type inference failed for: r1v26 */
        /* JADX WARN: Type inference failed for: r1v27 */
        /* JADX WARN: Type inference failed for: r1v28 */
        /* JADX WARN: Type inference failed for: r1v29 */
        /* JADX WARN: Type inference failed for: r1v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v7, types: [int] */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v5 */
        public int hashCode() {
            int iHashCode = ((((this.name.hashCode() * 31) + this.privacyPolicyURL.hashCode()) * 31) + this.vendors.hashCode()) * 31;
            boolean z = this.gdprAppliesGlobally;
            ?? r1 = z;
            if (z) {
                r1 = 1;
            }
            int i = (iHashCode + r1) * 31;
            boolean z2 = this.gdprAppliesWhenUnknown;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int iHashCode2 = (((((((((((i + r2) * 31) + this.customPurposes.hashCode()) * 31) + this.essentialPurposes.hashCode()) * 31) + this.consentDuration.hashCode()) * 31) + this.deniedConsentDuration.hashCode()) * 31) + this.logoUrl.hashCode()) * 31;
            boolean z3 = this.shouldHideDidomiLogo;
            int iHashCode3 = (((iHashCode2 + (z3 ? 1 : z3)) * 31) + this.country.hashCode()) * 31;
            String str = this.deploymentId;
            int iHashCode4 = (iHashCode3 + (str == null ? 0 : str.hashCode())) * 31;
            DCSConfig dCSConfig = this.dcsConfig;
            return iHashCode4 + (dCSConfig != null ? dCSConfig.hashCode() : 0);
        }

        /* JADX INFO: renamed from: i, reason: from getter */
        public final boolean getGdprAppliesWhenUnknown() {
            return this.gdprAppliesWhenUnknown;
        }

        /* JADX INFO: renamed from: j, reason: from getter */
        public final String getLogoUrl() {
            return this.logoUrl;
        }

        /* JADX INFO: renamed from: k, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: l, reason: from getter */
        public final String getPrivacyPolicyURL() {
            return this.privacyPolicyURL;
        }

        /* JADX INFO: renamed from: m, reason: from getter */
        public final boolean getShouldHideDidomiLogo() {
            return this.shouldHideDidomiLogo;
        }

        /* JADX INFO: renamed from: n, reason: from getter */
        public final Vendors getVendors() {
            return this.vendors;
        }

        public String toString() {
            return "App(name=" + this.name + ", privacyPolicyURL=" + this.privacyPolicyURL + ", vendors=" + this.vendors + ", gdprAppliesGlobally=" + this.gdprAppliesGlobally + ", gdprAppliesWhenUnknown=" + this.gdprAppliesWhenUnknown + ", customPurposes=" + this.customPurposes + ", essentialPurposes=" + this.essentialPurposes + ", consentDuration=" + this.consentDuration + ", deniedConsentDuration=" + this.deniedConsentDuration + ", logoUrl=" + this.logoUrl + ", shouldHideDidomiLogo=" + this.shouldHideDidomiLogo + ", country=" + this.country + ", deploymentId=" + this.deploymentId + ", dcsConfig=" + this.dcsConfig + ')';
        }

        public App(String name, String privacyPolicyURL, Vendors vendors, boolean z, boolean z2, List<CustomPurpose> customPurposes, List<String> essentialPurposes, Object consentDuration, Object deniedConsentDuration, String logoUrl, boolean z3, String country, String str, DCSConfig dCSConfig) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(privacyPolicyURL, "privacyPolicyURL");
            Intrinsics.checkNotNullParameter(vendors, "vendors");
            Intrinsics.checkNotNullParameter(customPurposes, "customPurposes");
            Intrinsics.checkNotNullParameter(essentialPurposes, "essentialPurposes");
            Intrinsics.checkNotNullParameter(consentDuration, "consentDuration");
            Intrinsics.checkNotNullParameter(deniedConsentDuration, "deniedConsentDuration");
            Intrinsics.checkNotNullParameter(logoUrl, "logoUrl");
            Intrinsics.checkNotNullParameter(country, "country");
            this.name = name;
            this.privacyPolicyURL = privacyPolicyURL;
            this.vendors = vendors;
            this.gdprAppliesGlobally = z;
            this.gdprAppliesWhenUnknown = z2;
            this.customPurposes = customPurposes;
            this.essentialPurposes = essentialPurposes;
            this.consentDuration = consentDuration;
            this.deniedConsentDuration = deniedConsentDuration;
            this.logoUrl = logoUrl;
            this.shouldHideDidomiLogo = z3;
            this.country = country;
            this.deploymentId = str;
            this.dcsConfig = dCSConfig;
        }

        public /* synthetic */ App(String str, String str2, Vendors vendors, boolean z, boolean z2, List list, List list2, Object obj, Object obj2, String str3, boolean z3, String str4, String str5, DCSConfig dCSConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? new Vendors(null, null, null, null, 15, null) : vendors, (i & 8) != 0 ? true : z, (i & 16) == 0 ? z2 : true, (i & 32) != 0 ? CollectionsKt.emptyList() : list, (i & 64) != 0 ? CollectionsKt.emptyList() : list2, (i & 128) != 0 ? 31622400L : obj, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? -1L : obj2, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) == 0 ? str3 : "", (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? false : z3, (i & 2048) != 0 ? "AA" : str4, (i & 4096) != 0 ? null : str5, (i & 8192) != 0 ? null : dCSConfig);
        }
    }

    /* JADX INFO: renamed from: io.didomi.sdk.l$c, reason: from toString */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000b¨\u0006\u0011"}, d2 = {"Lio/didomi/sdk/l$c;", "", "", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "Z", "()Z", "enableDCS", "b", "testUCPA", "<init>", "(ZZ)V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class FeatureFlags {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
        @SerializedName("enableDCS")
        private final boolean enableDCS;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
        @SerializedName("testUCPA")
        private final boolean testUCPA;

        /* JADX WARN: Illegal instructions before constructor call */
        public FeatureFlags() {
            boolean z = false;
            this(z, z, 3, null);
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final boolean getEnableDCS() {
            return this.enableDCS;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final boolean getTestUCPA() {
            return this.testUCPA;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FeatureFlags)) {
                return false;
            }
            FeatureFlags featureFlags = (FeatureFlags) other;
            return this.enableDCS == featureFlags.enableDCS && this.testUCPA == featureFlags.testUCPA;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        public int hashCode() {
            boolean z = this.enableDCS;
            ?? r0 = z;
            if (z) {
                r0 = 1;
            }
            int i = r0 * 31;
            boolean z2 = this.testUCPA;
            return i + (z2 ? 1 : z2);
        }

        public String toString() {
            return "FeatureFlags(enableDCS=" + this.enableDCS + ", testUCPA=" + this.testUCPA + ')';
        }

        public FeatureFlags(boolean z, boolean z2) {
            this.enableDCS = z;
            this.testUCPA = z2;
        }

        public /* synthetic */ FeatureFlags(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2);
        }
    }

    /* JADX INFO: renamed from: io.didomi.sdk.l$d, reason: from toString */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\n\u0010\u0010¨\u0006\u0014"}, d2 = {"Lio/didomi/sdk/l$d;", "", "", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "", "a", "Ljava/util/Set;", "b", "()Ljava/util/Set;", "enabled", "Ljava/lang/String;", "()Ljava/lang/String;", "defaultLanguage", "<init>", "(Ljava/util/Set;Ljava/lang/String;)V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class Languages {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
        @SerializedName("enabled")
        private final Set<String> enabled;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
        @SerializedName("default")
        private final String defaultLanguage;

        /* JADX WARN: Multi-variable type inference failed */
        public Languages() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final String getDefaultLanguage() {
            return this.defaultLanguage;
        }

        public final Set<String> b() {
            return this.enabled;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Languages)) {
                return false;
            }
            Languages languages = (Languages) other;
            return Intrinsics.areEqual(this.enabled, languages.enabled) && Intrinsics.areEqual(this.defaultLanguage, languages.defaultLanguage);
        }

        public int hashCode() {
            return (this.enabled.hashCode() * 31) + this.defaultLanguage.hashCode();
        }

        public String toString() {
            return "Languages(enabled=" + this.enabled + ", defaultLanguage=" + this.defaultLanguage + ')';
        }

        public Languages(Set<String> enabled, String defaultLanguage) {
            Intrinsics.checkNotNullParameter(enabled, "enabled");
            Intrinsics.checkNotNullParameter(defaultLanguage, "defaultLanguage");
            this.enabled = enabled;
            this.defaultLanguage = defaultLanguage;
        }

        public /* synthetic */ Languages(Set set, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? SetsKt.emptySet() : set, (i & 2) != 0 ? "en" : str);
        }
    }

    /* JADX INFO: renamed from: io.didomi.sdk.l$e, reason: from toString */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u0000 -2\u00020\u0001:\u0004\t\u000b\u0015\u0019Bo\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0002\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\"\u001a\u00020\u0007\u0012\b\b\u0002\u0010$\u001a\u00020\u0007\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010%\u0012\b\b\u0002\u0010)\u001a\u00020\u0007\u0012\b\b\u0002\u0010*\u001a\u00020\u0007¢\u0006\u0004\b+\u0010,J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0013\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0018\u001a\u00020\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\t\u0010\u0017R\u001a\u0010\u001d\u001a\u00020\u00028\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010 \u001a\u0004\u0018\u00010\u00028\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\u001cR\u001a\u0010\"\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\f\n\u0004\b!\u0010\u0010\u001a\u0004\b\u001e\u0010\u0012R\u001a\u0010$\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\f\n\u0004\b#\u0010\u0010\u001a\u0004\b\u0019\u0010\u0012R\u001c\u0010(\u001a\u0004\u0018\u00010%8\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u0011\u0010&\u001a\u0004\b!\u0010'R\u001a\u0010)\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R\u001a\u0010*\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0010\u001a\u0004\b#\u0010\u0012¨\u0006."}, d2 = {"Lio/didomi/sdk/l$e;", "", "", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "I", "b", "()I", "setDaysBeforeShowingAgain", "(I)V", "daysBeforeShowingAgain", "Z", "h", "()Z", "enabled", "Lio/didomi/sdk/l$e$b;", "c", "Lio/didomi/sdk/l$e$b;", "()Lio/didomi/sdk/l$e$b;", "content", "d", "Ljava/lang/String;", "i", "()Ljava/lang/String;", "positionAsString", "e", "j", "type", "f", "denyAsPrimary", "g", "denyAsLink", "Lio/didomi/sdk/l$e$c;", "Lio/didomi/sdk/l$e$c;", "()Lio/didomi/sdk/l$e$c;", "denyOptions", "denyAppliesToLI", "enableBulkActionOnPurposes", "<init>", "(IZLio/didomi/sdk/l$e$b;Ljava/lang/String;Ljava/lang/String;ZZLio/didomi/sdk/l$e$c;ZZ)V", "k", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class Notice {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
        @SerializedName("daysBeforeShowingAgain")
        private int daysBeforeShowingAgain;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
        @SerializedName("enable")
        private final boolean enabled;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
        @SerializedName("content")
        private final Content content;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
        @SerializedName("position")
        private final String positionAsString;

        /* JADX INFO: renamed from: e, reason: from kotlin metadata and from toString */
        @SerializedName("type")
        private final String type;

        /* JADX INFO: renamed from: f, reason: from kotlin metadata and from toString */
        @SerializedName("denyAsPrimary")
        private final boolean denyAsPrimary;

        /* JADX INFO: renamed from: g, reason: from kotlin metadata and from toString */
        @SerializedName("denyAsLink")
        private final boolean denyAsLink;

        /* JADX INFO: renamed from: h, reason: from kotlin metadata and from toString */
        @SerializedName("denyOptions")
        private final DenyOptions denyOptions;

        /* JADX INFO: renamed from: i, reason: from kotlin metadata and from toString */
        @SerializedName("denyAppliesToLI")
        private final boolean denyAppliesToLI;

        /* JADX INFO: renamed from: j, reason: from kotlin metadata and from toString */
        @SerializedName("enableBulkActionOnPurposes")
        private final boolean enableBulkActionOnPurposes;

        /* JADX INFO: renamed from: io.didomi.sdk.l$e$b, reason: from toString */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B·\u0001\u0012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t\u0012\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t\u0012\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t\u0012\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t\u0012\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t\u0012\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t\u0012\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t\u0012\u0014\b\u0002\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t¢\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R&\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR&\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR&\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\n\u0010\rR&\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0012\u0010\rR&\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0014\u0010\rR&\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u000f\u0010\rR&\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u0019\u0010\rR&\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u000b\u001a\u0004\b\u0017\u0010\r¨\u0006\u001f"}, d2 = {"Lio/didomi/sdk/l$e$b;", "", "", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "", "a", "Ljava/util/Map;", "g", "()Ljava/util/Map;", b.S, "b", "e", "noticeText", "c", "agreeButtonLabel", "d", "learnMoreButtonLabel", "manageSpiChoicesButtonLabel", "f", "disagreeButtonLabel", "getPartnersButtonLabel", "partnersButtonLabel", "h", "privacyButtonLabel", "<init>", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "android_release"}, k = 1, mv = {1, 8, 0})
        public static final /* data */ class Content {

            /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
            @SerializedName(b.S)
            private final Map<String, String> title;

            /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
            @SerializedName("notice")
            private final Map<String, String> noticeText;

            /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
            @SerializedName("dismiss")
            private final Map<String, String> agreeButtonLabel;

            /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
            @SerializedName("learnMore")
            private final Map<String, String> learnMoreButtonLabel;

            /* JADX INFO: renamed from: e, reason: from kotlin metadata and from toString */
            @SerializedName("manageSpiChoices")
            private final Map<String, String> manageSpiChoicesButtonLabel;

            /* JADX INFO: renamed from: f, reason: from kotlin metadata and from toString */
            @SerializedName("deny")
            private final Map<String, String> disagreeButtonLabel;

            /* JADX INFO: renamed from: g, reason: from kotlin metadata and from toString */
            @SerializedName("viewOurPartners")
            private final Map<String, String> partnersButtonLabel;

            /* JADX INFO: renamed from: h, reason: from kotlin metadata and from toString */
            @SerializedName("privacyPolicy")
            private final Map<String, String> privacyButtonLabel;

            public Content() {
                this(null, null, null, null, null, null, null, null, 255, null);
            }

            public final Map<String, String> a() {
                return this.agreeButtonLabel;
            }

            public final Map<String, String> b() {
                return this.disagreeButtonLabel;
            }

            public final Map<String, String> c() {
                return this.learnMoreButtonLabel;
            }

            public final Map<String, String> d() {
                return this.manageSpiChoicesButtonLabel;
            }

            public final Map<String, String> e() {
                return this.noticeText;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Content)) {
                    return false;
                }
                Content content = (Content) other;
                return Intrinsics.areEqual(this.title, content.title) && Intrinsics.areEqual(this.noticeText, content.noticeText) && Intrinsics.areEqual(this.agreeButtonLabel, content.agreeButtonLabel) && Intrinsics.areEqual(this.learnMoreButtonLabel, content.learnMoreButtonLabel) && Intrinsics.areEqual(this.manageSpiChoicesButtonLabel, content.manageSpiChoicesButtonLabel) && Intrinsics.areEqual(this.disagreeButtonLabel, content.disagreeButtonLabel) && Intrinsics.areEqual(this.partnersButtonLabel, content.partnersButtonLabel) && Intrinsics.areEqual(this.privacyButtonLabel, content.privacyButtonLabel);
            }

            public final Map<String, String> f() {
                return this.privacyButtonLabel;
            }

            public final Map<String, String> g() {
                return this.title;
            }

            public int hashCode() {
                return (((((((((((((this.title.hashCode() * 31) + this.noticeText.hashCode()) * 31) + this.agreeButtonLabel.hashCode()) * 31) + this.learnMoreButtonLabel.hashCode()) * 31) + this.manageSpiChoicesButtonLabel.hashCode()) * 31) + this.disagreeButtonLabel.hashCode()) * 31) + this.partnersButtonLabel.hashCode()) * 31) + this.privacyButtonLabel.hashCode();
            }

            public String toString() {
                return "Content(title=" + this.title + ", noticeText=" + this.noticeText + ", agreeButtonLabel=" + this.agreeButtonLabel + ", learnMoreButtonLabel=" + this.learnMoreButtonLabel + ", manageSpiChoicesButtonLabel=" + this.manageSpiChoicesButtonLabel + ", disagreeButtonLabel=" + this.disagreeButtonLabel + ", partnersButtonLabel=" + this.partnersButtonLabel + ", privacyButtonLabel=" + this.privacyButtonLabel + ')';
            }

            public Content(Map<String, String> title, Map<String, String> noticeText, Map<String, String> agreeButtonLabel, Map<String, String> learnMoreButtonLabel, Map<String, String> manageSpiChoicesButtonLabel, Map<String, String> disagreeButtonLabel, Map<String, String> partnersButtonLabel, Map<String, String> privacyButtonLabel) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(noticeText, "noticeText");
                Intrinsics.checkNotNullParameter(agreeButtonLabel, "agreeButtonLabel");
                Intrinsics.checkNotNullParameter(learnMoreButtonLabel, "learnMoreButtonLabel");
                Intrinsics.checkNotNullParameter(manageSpiChoicesButtonLabel, "manageSpiChoicesButtonLabel");
                Intrinsics.checkNotNullParameter(disagreeButtonLabel, "disagreeButtonLabel");
                Intrinsics.checkNotNullParameter(partnersButtonLabel, "partnersButtonLabel");
                Intrinsics.checkNotNullParameter(privacyButtonLabel, "privacyButtonLabel");
                this.title = title;
                this.noticeText = noticeText;
                this.agreeButtonLabel = agreeButtonLabel;
                this.learnMoreButtonLabel = learnMoreButtonLabel;
                this.manageSpiChoicesButtonLabel = manageSpiChoicesButtonLabel;
                this.disagreeButtonLabel = disagreeButtonLabel;
                this.partnersButtonLabel = partnersButtonLabel;
                this.privacyButtonLabel = privacyButtonLabel;
            }

            public /* synthetic */ Content(Map map, Map map2, Map map3, Map map4, Map map5, Map map6, Map map7, Map map8, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? MapsKt.emptyMap() : map, (i & 2) != 0 ? MapsKt.emptyMap() : map2, (i & 4) != 0 ? MapsKt.emptyMap() : map3, (i & 8) != 0 ? MapsKt.emptyMap() : map4, (i & 16) != 0 ? MapsKt.emptyMap() : map5, (i & 32) != 0 ? MapsKt.emptyMap() : map6, (i & 64) != 0 ? MapsKt.emptyMap() : map7, (i & 128) != 0 ? MapsKt.emptyMap() : map8);
            }
        }

        /* JADX INFO: renamed from: io.didomi.sdk.l$e$c, reason: from toString */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001a\u0010\f\u001a\u00020\u00028\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000fR\u001a\u0010\u0012\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0015"}, d2 = {"Lio/didomi/sdk/l$e$c;", "", "", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "buttonAsString", "b", "Z", "()Z", "cross", "c", "link", "<init>", "(Ljava/lang/String;ZZ)V", "android_release"}, k = 1, mv = {1, 8, 0})
        public static final /* data */ class DenyOptions {

            /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
            @SerializedName("button")
            private final String buttonAsString;

            /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
            @SerializedName("cross")
            private final boolean cross;

            /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
            @SerializedName("link")
            private final boolean link;

            public DenyOptions() {
                this(null, false, false, 7, null);
            }

            /* JADX INFO: renamed from: a, reason: from getter */
            public final String getButtonAsString() {
                return this.buttonAsString;
            }

            /* JADX INFO: renamed from: b, reason: from getter */
            public final boolean getCross() {
                return this.cross;
            }

            /* JADX INFO: renamed from: c, reason: from getter */
            public final boolean getLink() {
                return this.link;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof DenyOptions)) {
                    return false;
                }
                DenyOptions denyOptions = (DenyOptions) other;
                return Intrinsics.areEqual(this.buttonAsString, denyOptions.buttonAsString) && this.cross == denyOptions.cross && this.link == denyOptions.link;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v3, types: [int] */
            /* JADX WARN: Type inference failed for: r0v5, types: [int] */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v3 */
            /* JADX WARN: Type inference failed for: r1v4 */
            /* JADX WARN: Type inference failed for: r2v0 */
            /* JADX WARN: Type inference failed for: r2v1, types: [int] */
            /* JADX WARN: Type inference failed for: r2v2 */
            public int hashCode() {
                int iHashCode = this.buttonAsString.hashCode() * 31;
                boolean z = this.cross;
                ?? r1 = z;
                if (z) {
                    r1 = 1;
                }
                int i = (iHashCode + r1) * 31;
                boolean z2 = this.link;
                return i + (z2 ? 1 : z2);
            }

            public String toString() {
                return "DenyOptions(buttonAsString=" + this.buttonAsString + ", cross=" + this.cross + ", link=" + this.link + ')';
            }

            public DenyOptions(String buttonAsString, boolean z, boolean z2) {
                Intrinsics.checkNotNullParameter(buttonAsString, "buttonAsString");
                this.buttonAsString = buttonAsString;
                this.cross = z;
                this.link = z2;
            }

            public /* synthetic */ DenyOptions(String str, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? Theme.a.NONE.getValue() : str, (i & 2) != 0 ? false : z, (i & 4) != 0 ? false : z2);
            }
        }

        /* JADX INFO: renamed from: io.didomi.sdk.l$e$d */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0003B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lio/didomi/sdk/l$e$d;", "", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "value", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "c", "d", "android_release"}, k = 1, mv = {1, 8, 0})
        public enum d {
            BOTTOM("bottom"),
            POPUP(AuthorizationRequest.Display.POPUP);


            /* JADX INFO: renamed from: b, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);

            /* JADX INFO: renamed from: a, reason: from kotlin metadata */
            private final String value;

            /* JADX INFO: renamed from: io.didomi.sdk.l$e$d$a, reason: from kotlin metadata */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lio/didomi/sdk/l$e$d$a;", "", "", "value", "Lio/didomi/sdk/l$e$d;", "a", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final d a(String value) {
                    Intrinsics.checkNotNullParameter(value, "value");
                    Locale ENGLISH = Locale.ENGLISH;
                    Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
                    String lowerCase = value.toLowerCase(ENGLISH);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                    d dVar = d.POPUP;
                    return Intrinsics.areEqual(lowerCase, dVar.getValue()) ? dVar : d.BOTTOM;
                }

                private Companion() {
                }
            }

            d(String str) {
                this.value = str;
            }

            /* JADX INFO: renamed from: b, reason: from getter */
            public final String getValue() {
                return this.value;
            }
        }

        public Notice() {
            this(0, false, null, null, null, false, false, null, false, false, 1023, null);
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final Content getContent() {
            return this.content;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final int getDaysBeforeShowingAgain() {
            return this.daysBeforeShowingAgain;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final boolean getDenyAppliesToLI() {
            return this.denyAppliesToLI;
        }

        /* JADX INFO: renamed from: d, reason: from getter */
        public final boolean getDenyAsLink() {
            return this.denyAsLink;
        }

        /* JADX INFO: renamed from: e, reason: from getter */
        public final boolean getDenyAsPrimary() {
            return this.denyAsPrimary;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Notice)) {
                return false;
            }
            Notice notice = (Notice) other;
            return this.daysBeforeShowingAgain == notice.daysBeforeShowingAgain && this.enabled == notice.enabled && Intrinsics.areEqual(this.content, notice.content) && Intrinsics.areEqual(this.positionAsString, notice.positionAsString) && Intrinsics.areEqual(this.type, notice.type) && this.denyAsPrimary == notice.denyAsPrimary && this.denyAsLink == notice.denyAsLink && Intrinsics.areEqual(this.denyOptions, notice.denyOptions) && this.denyAppliesToLI == notice.denyAppliesToLI && this.enableBulkActionOnPurposes == notice.enableBulkActionOnPurposes;
        }

        /* JADX INFO: renamed from: f, reason: from getter */
        public final DenyOptions getDenyOptions() {
            return this.denyOptions;
        }

        /* JADX INFO: renamed from: g, reason: from getter */
        public final boolean getEnableBulkActionOnPurposes() {
            return this.enableBulkActionOnPurposes;
        }

        /* JADX INFO: renamed from: h, reason: from getter */
        public final boolean getEnabled() {
            return this.enabled;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11, types: [int] */
        /* JADX WARN: Type inference failed for: r0v17, types: [int] */
        /* JADX WARN: Type inference failed for: r0v19, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v10, types: [int] */
        /* JADX WARN: Type inference failed for: r1v12, types: [int] */
        /* JADX WARN: Type inference failed for: r1v15, types: [int] */
        /* JADX WARN: Type inference failed for: r1v17 */
        /* JADX WARN: Type inference failed for: r1v18 */
        /* JADX WARN: Type inference failed for: r1v19 */
        /* JADX WARN: Type inference failed for: r1v21 */
        /* JADX WARN: Type inference failed for: r1v22 */
        /* JADX WARN: Type inference failed for: r1v23 */
        /* JADX WARN: Type inference failed for: r1v24 */
        /* JADX WARN: Type inference failed for: r1v25 */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
        public int hashCode() {
            int iHashCode = Integer.hashCode(this.daysBeforeShowingAgain) * 31;
            boolean z = this.enabled;
            ?? r1 = z;
            if (z) {
                r1 = 1;
            }
            int iHashCode2 = (((((iHashCode + r1) * 31) + this.content.hashCode()) * 31) + this.positionAsString.hashCode()) * 31;
            String str = this.type;
            int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            boolean z2 = this.denyAsPrimary;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int i = (iHashCode3 + r2) * 31;
            boolean z3 = this.denyAsLink;
            ?? r3 = z3;
            if (z3) {
                r3 = 1;
            }
            int i2 = (i + r3) * 31;
            DenyOptions denyOptions = this.denyOptions;
            int iHashCode4 = (i2 + (denyOptions != null ? denyOptions.hashCode() : 0)) * 31;
            boolean z4 = this.denyAppliesToLI;
            ?? r4 = z4;
            if (z4) {
                r4 = 1;
            }
            int i3 = (iHashCode4 + r4) * 31;
            boolean z5 = this.enableBulkActionOnPurposes;
            return i3 + (z5 ? 1 : z5);
        }

        /* JADX INFO: renamed from: i, reason: from getter */
        public final String getPositionAsString() {
            return this.positionAsString;
        }

        /* JADX INFO: renamed from: j, reason: from getter */
        public final String getType() {
            return this.type;
        }

        public String toString() {
            return "Notice(daysBeforeShowingAgain=" + this.daysBeforeShowingAgain + ", enabled=" + this.enabled + ", content=" + this.content + ", positionAsString=" + this.positionAsString + ", type=" + this.type + ", denyAsPrimary=" + this.denyAsPrimary + ", denyAsLink=" + this.denyAsLink + ", denyOptions=" + this.denyOptions + ", denyAppliesToLI=" + this.denyAppliesToLI + ", enableBulkActionOnPurposes=" + this.enableBulkActionOnPurposes + ')';
        }

        public Notice(int i, boolean z, Content content, String positionAsString, String str, boolean z2, boolean z3, DenyOptions denyOptions, boolean z4, boolean z5) {
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(positionAsString, "positionAsString");
            this.daysBeforeShowingAgain = i;
            this.enabled = z;
            this.content = content;
            this.positionAsString = positionAsString;
            this.type = str;
            this.denyAsPrimary = z2;
            this.denyAsLink = z3;
            this.denyOptions = denyOptions;
            this.denyAppliesToLI = z4;
            this.enableBulkActionOnPurposes = z5;
        }

        public /* synthetic */ Notice(int i, boolean z, Content content, String str, String str2, boolean z2, boolean z3, DenyOptions denyOptions, boolean z4, boolean z5, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? true : z, (i2 & 4) != 0 ? new Content(null, null, null, null, null, null, null, null, 255, null) : content, (i2 & 8) != 0 ? d.POPUP.getValue() : str, (i2 & 16) != 0 ? null : str2, (i2 & 32) != 0 ? false : z2, (i2 & 64) != 0 ? false : z3, (i2 & 128) == 0 ? denyOptions : null, (i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) == 0 ? z4 : false, (i2 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? true : z5);
        }
    }

    /* JADX INFO: renamed from: io.didomi.sdk.l$f, reason: from toString */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\tBU\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010$¢\u0006\u0004\b(\u0010)J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\"\u0010\u0013\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0018\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001a\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0019\u0010\u0017R\u001a\u0010\u001d\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\n\u001a\u0004\b\u001c\u0010\u000bR \u0010#\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001b\u0010\"R\u001c\u0010'\u001a\u0004\u0018\u00010$8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010%\u001a\u0004\b \u0010&¨\u0006*"}, d2 = {"Lio/didomi/sdk/l$f;", "", "", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "Z", "()Z", "canCloseWhenConsentIsMissing", "Lio/didomi/sdk/l$f$a;", "b", "Lio/didomi/sdk/l$f$a;", "()Lio/didomi/sdk/l$f$a;", "setContent", "(Lio/didomi/sdk/l$f$a;)V", "content", "c", "d", "setDisableButtonsUntilScroll", "(Z)V", "disableButtonsUntilScroll", "setDenyAppliesToLI", "denyAppliesToLI", "e", "g", "showWhenConsentIsMissing", "", "Lio/didomi/sdk/purpose/common/model/PurposeCategory;", "f", "Ljava/util/List;", "()Ljava/util/List;", "purposeCategories", "Lio/didomi/sdk/cc;", "Lio/didomi/sdk/cc;", "()Lio/didomi/sdk/cc;", "sensitivePersonalInformation", "<init>", "(ZLio/didomi/sdk/l$f$a;ZZZLjava/util/List;Lio/didomi/sdk/cc;)V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class Preferences {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
        @SerializedName("canCloseWhenConsentIsMissing")
        private final boolean canCloseWhenConsentIsMissing;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
        @SerializedName("content")
        private Content content;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
        @SerializedName("disableButtonsUntilScroll")
        private boolean disableButtonsUntilScroll;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
        @SerializedName("denyAppliesToLI")
        private boolean denyAppliesToLI;

        /* JADX INFO: renamed from: e, reason: from kotlin metadata and from toString */
        @SerializedName("showWhenConsentIsMissing")
        private final boolean showWhenConsentIsMissing;

        /* JADX INFO: renamed from: f, reason: from kotlin metadata and from toString */
        @SerializedName("categories")
        private final List<PurposeCategory> purposeCategories;

        /* JADX INFO: renamed from: g, reason: from kotlin metadata and from toString */
        @SerializedName("sensitivePersonalInformation")
        private final SensitivePersonalInformation sensitivePersonalInformation;

        /* JADX INFO: renamed from: io.didomi.sdk.l$f$a, reason: from toString */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001B§\u0002\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t\u0012\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t\u0012\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t\u0012\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t\u0012\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t\u0012\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t\u0012\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t\u0012\u0016\b\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t\u0012\u0016\b\u0002\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t\u0012\u0016\b\u0002\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t\u0012\u0016\b\u0002\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t\u0012\u0016\b\u0002\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t¢\u0006\u0004\b$\u0010%J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R(\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR(\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\fR(\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\fR(\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0014\u0010\fR(\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\fR(\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\fR(\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u001c\u0010\fR(\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u001e\u0010\fR(\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u000b\u001a\u0004\b\u0019\u0010\fR(\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u000e\u0010\fR(\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u0016\u0010\fR(\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0011\u0010\f¨\u0006&"}, d2 = {"Lio/didomi/sdk/l$f$a;", "", "", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "", "a", "Ljava/util/Map;", "()Ljava/util/Map;", "agreeToAll", "b", "d", "disagreeToAll", "c", "g", "save", "h", "saveAndClose", "e", "j", "text", "f", "l", b.S, "k", "textVendors", "i", "subTextVendors", "purposesTitleLabel", "bulkActionLabel", "ourPartnersLabel", "bulkActionOnVendorsLabel", "<init>", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "android_release"}, k = 1, mv = {1, 8, 0})
        public static final /* data */ class Content {

            /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
            @SerializedName("agreeToAll")
            private final Map<String, String> agreeToAll;

            /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
            @SerializedName("disagreeToAll")
            private final Map<String, String> disagreeToAll;

            /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
            @SerializedName("save")
            private final Map<String, String> save;

            /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
            @SerializedName("saveAndClose")
            private final Map<String, String> saveAndClose;

            /* JADX INFO: renamed from: e, reason: from kotlin metadata and from toString */
            @SerializedName("text")
            private final Map<String, String> text;

            /* JADX INFO: renamed from: f, reason: from kotlin metadata and from toString */
            @SerializedName(b.S)
            private final Map<String, String> title;

            /* JADX INFO: renamed from: g, reason: from kotlin metadata and from toString */
            @SerializedName("textVendors")
            private final Map<String, String> textVendors;

            /* JADX INFO: renamed from: h, reason: from kotlin metadata and from toString */
            @SerializedName("subTextVendors")
            private final Map<String, String> subTextVendors;

            /* JADX INFO: renamed from: i, reason: from kotlin metadata and from toString */
            @SerializedName("viewAllPurposes")
            private final Map<String, String> purposesTitleLabel;

            /* JADX INFO: renamed from: j, reason: from kotlin metadata and from toString */
            @SerializedName("bulkActionOnPurposes")
            private final Map<String, String> bulkActionLabel;

            /* JADX INFO: renamed from: k, reason: from kotlin metadata and from toString */
            @SerializedName("viewOurPartners")
            private final Map<String, String> ourPartnersLabel;

            /* JADX INFO: renamed from: l, reason: from kotlin metadata and from toString */
            @SerializedName("bulkActionOnVendors")
            private final Map<String, String> bulkActionOnVendorsLabel;

            public Content() {
                this(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null);
            }

            public final Map<String, String> a() {
                return this.agreeToAll;
            }

            public final Map<String, String> b() {
                return this.bulkActionLabel;
            }

            public final Map<String, String> c() {
                return this.bulkActionOnVendorsLabel;
            }

            public final Map<String, String> d() {
                return this.disagreeToAll;
            }

            public final Map<String, String> e() {
                return this.ourPartnersLabel;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Content)) {
                    return false;
                }
                Content content = (Content) other;
                return Intrinsics.areEqual(this.agreeToAll, content.agreeToAll) && Intrinsics.areEqual(this.disagreeToAll, content.disagreeToAll) && Intrinsics.areEqual(this.save, content.save) && Intrinsics.areEqual(this.saveAndClose, content.saveAndClose) && Intrinsics.areEqual(this.text, content.text) && Intrinsics.areEqual(this.title, content.title) && Intrinsics.areEqual(this.textVendors, content.textVendors) && Intrinsics.areEqual(this.subTextVendors, content.subTextVendors) && Intrinsics.areEqual(this.purposesTitleLabel, content.purposesTitleLabel) && Intrinsics.areEqual(this.bulkActionLabel, content.bulkActionLabel) && Intrinsics.areEqual(this.ourPartnersLabel, content.ourPartnersLabel) && Intrinsics.areEqual(this.bulkActionOnVendorsLabel, content.bulkActionOnVendorsLabel);
            }

            public final Map<String, String> f() {
                return this.purposesTitleLabel;
            }

            public final Map<String, String> g() {
                return this.save;
            }

            public final Map<String, String> h() {
                return this.saveAndClose;
            }

            public int hashCode() {
                Map<String, String> map = this.agreeToAll;
                int iHashCode = (map == null ? 0 : map.hashCode()) * 31;
                Map<String, String> map2 = this.disagreeToAll;
                int iHashCode2 = (iHashCode + (map2 == null ? 0 : map2.hashCode())) * 31;
                Map<String, String> map3 = this.save;
                int iHashCode3 = (iHashCode2 + (map3 == null ? 0 : map3.hashCode())) * 31;
                Map<String, String> map4 = this.saveAndClose;
                int iHashCode4 = (iHashCode3 + (map4 == null ? 0 : map4.hashCode())) * 31;
                Map<String, String> map5 = this.text;
                int iHashCode5 = (iHashCode4 + (map5 == null ? 0 : map5.hashCode())) * 31;
                Map<String, String> map6 = this.title;
                int iHashCode6 = (iHashCode5 + (map6 == null ? 0 : map6.hashCode())) * 31;
                Map<String, String> map7 = this.textVendors;
                int iHashCode7 = (iHashCode6 + (map7 == null ? 0 : map7.hashCode())) * 31;
                Map<String, String> map8 = this.subTextVendors;
                int iHashCode8 = (iHashCode7 + (map8 == null ? 0 : map8.hashCode())) * 31;
                Map<String, String> map9 = this.purposesTitleLabel;
                int iHashCode9 = (iHashCode8 + (map9 == null ? 0 : map9.hashCode())) * 31;
                Map<String, String> map10 = this.bulkActionLabel;
                int iHashCode10 = (iHashCode9 + (map10 == null ? 0 : map10.hashCode())) * 31;
                Map<String, String> map11 = this.ourPartnersLabel;
                int iHashCode11 = (iHashCode10 + (map11 == null ? 0 : map11.hashCode())) * 31;
                Map<String, String> map12 = this.bulkActionOnVendorsLabel;
                return iHashCode11 + (map12 != null ? map12.hashCode() : 0);
            }

            public final Map<String, String> i() {
                return this.subTextVendors;
            }

            public final Map<String, String> j() {
                return this.text;
            }

            public final Map<String, String> k() {
                return this.textVendors;
            }

            public final Map<String, String> l() {
                return this.title;
            }

            public String toString() {
                return "Content(agreeToAll=" + this.agreeToAll + ", disagreeToAll=" + this.disagreeToAll + ", save=" + this.save + ", saveAndClose=" + this.saveAndClose + ", text=" + this.text + ", title=" + this.title + ", textVendors=" + this.textVendors + ", subTextVendors=" + this.subTextVendors + ", purposesTitleLabel=" + this.purposesTitleLabel + ", bulkActionLabel=" + this.bulkActionLabel + ", ourPartnersLabel=" + this.ourPartnersLabel + ", bulkActionOnVendorsLabel=" + this.bulkActionOnVendorsLabel + ')';
            }

            public Content(Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, String> map4, Map<String, String> map5, Map<String, String> map6, Map<String, String> map7, Map<String, String> map8, Map<String, String> map9, Map<String, String> map10, Map<String, String> map11, Map<String, String> map12) {
                this.agreeToAll = map;
                this.disagreeToAll = map2;
                this.save = map3;
                this.saveAndClose = map4;
                this.text = map5;
                this.title = map6;
                this.textVendors = map7;
                this.subTextVendors = map8;
                this.purposesTitleLabel = map9;
                this.bulkActionLabel = map10;
                this.ourPartnersLabel = map11;
                this.bulkActionOnVendorsLabel = map12;
            }

            public /* synthetic */ Content(Map map, Map map2, Map map3, Map map4, Map map5, Map map6, Map map7, Map map8, Map map9, Map map10, Map map11, Map map12, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : map, (i & 2) != 0 ? null : map2, (i & 4) != 0 ? null : map3, (i & 8) != 0 ? null : map4, (i & 16) != 0 ? null : map5, (i & 32) != 0 ? null : map6, (i & 64) != 0 ? null : map7, (i & 128) != 0 ? null : map8, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? null : map9, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? null : map10, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? null : map11, (i & 2048) != 0 ? null : map12);
            }
        }

        public Preferences() {
            this(false, null, false, false, false, null, null, 127, null);
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final boolean getCanCloseWhenConsentIsMissing() {
            return this.canCloseWhenConsentIsMissing;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final Content getContent() {
            return this.content;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final boolean getDenyAppliesToLI() {
            return this.denyAppliesToLI;
        }

        /* JADX INFO: renamed from: d, reason: from getter */
        public final boolean getDisableButtonsUntilScroll() {
            return this.disableButtonsUntilScroll;
        }

        public final List<PurposeCategory> e() {
            return this.purposeCategories;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Preferences)) {
                return false;
            }
            Preferences preferences = (Preferences) other;
            return this.canCloseWhenConsentIsMissing == preferences.canCloseWhenConsentIsMissing && Intrinsics.areEqual(this.content, preferences.content) && this.disableButtonsUntilScroll == preferences.disableButtonsUntilScroll && this.denyAppliesToLI == preferences.denyAppliesToLI && this.showWhenConsentIsMissing == preferences.showWhenConsentIsMissing && Intrinsics.areEqual(this.purposeCategories, preferences.purposeCategories) && Intrinsics.areEqual(this.sensitivePersonalInformation, preferences.sensitivePersonalInformation);
        }

        /* JADX INFO: renamed from: f, reason: from getter */
        public final SensitivePersonalInformation getSensitivePersonalInformation() {
            return this.sensitivePersonalInformation;
        }

        /* JADX INFO: renamed from: g, reason: from getter */
        public final boolean getShowWhenConsentIsMissing() {
            return this.showWhenConsentIsMissing;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v14 */
        /* JADX WARN: Type inference failed for: r0v15 */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r0v7, types: [int] */
        /* JADX WARN: Type inference failed for: r0v9, types: [int] */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v8 */
        /* JADX WARN: Type inference failed for: r2v10 */
        /* JADX WARN: Type inference failed for: r2v3, types: [int] */
        /* JADX WARN: Type inference failed for: r2v5, types: [int] */
        /* JADX WARN: Type inference failed for: r2v7 */
        /* JADX WARN: Type inference failed for: r2v8 */
        /* JADX WARN: Type inference failed for: r2v9 */
        public int hashCode() {
            boolean z = this.canCloseWhenConsentIsMissing;
            ?? r0 = z;
            if (z) {
                r0 = 1;
            }
            int iHashCode = ((r0 * 31) + this.content.hashCode()) * 31;
            boolean z2 = this.disableButtonsUntilScroll;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int i = (iHashCode + r2) * 31;
            boolean z3 = this.denyAppliesToLI;
            ?? r3 = z3;
            if (z3) {
                r3 = 1;
            }
            int i2 = (i + r3) * 31;
            boolean z4 = this.showWhenConsentIsMissing;
            int iHashCode2 = (((i2 + (z4 ? 1 : z4)) * 31) + this.purposeCategories.hashCode()) * 31;
            SensitivePersonalInformation ccVar = this.sensitivePersonalInformation;
            return iHashCode2 + (ccVar == null ? 0 : ccVar.hashCode());
        }

        public String toString() {
            return "Preferences(canCloseWhenConsentIsMissing=" + this.canCloseWhenConsentIsMissing + ", content=" + this.content + ", disableButtonsUntilScroll=" + this.disableButtonsUntilScroll + ", denyAppliesToLI=" + this.denyAppliesToLI + ", showWhenConsentIsMissing=" + this.showWhenConsentIsMissing + ", purposeCategories=" + this.purposeCategories + ", sensitivePersonalInformation=" + this.sensitivePersonalInformation + ')';
        }

        public Preferences(boolean z, Content content, boolean z2, boolean z3, boolean z4, List<PurposeCategory> purposeCategories, SensitivePersonalInformation ccVar) {
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(purposeCategories, "purposeCategories");
            this.canCloseWhenConsentIsMissing = z;
            this.content = content;
            this.disableButtonsUntilScroll = z2;
            this.denyAppliesToLI = z3;
            this.showWhenConsentIsMissing = z4;
            this.purposeCategories = purposeCategories;
            this.sensitivePersonalInformation = ccVar;
        }

        public /* synthetic */ Preferences(boolean z, Content content, boolean z2, boolean z3, boolean z4, List list, SensitivePersonalInformation ccVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? true : z, (i & 2) != 0 ? new Content(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null) : content, (i & 4) != 0 ? false : z2, (i & 8) == 0 ? z3 : true, (i & 16) == 0 ? z4 : false, (i & 32) != 0 ? new ArrayList() : list, (i & 64) != 0 ? null : ccVar);
        }
    }

    /* JADX INFO: renamed from: io.didomi.sdk.l$g, reason: from toString */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\t\u000bB+\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lio/didomi/sdk/l$g;", "", "", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "name", "Lio/didomi/sdk/l$g$a;", "Lio/didomi/sdk/l$g$a;", "()Lio/didomi/sdk/l$g$a;", "ccpa", "Lio/didomi/sdk/l$g$b;", "c", "Lio/didomi/sdk/l$g$b;", "getGroup", "()Lio/didomi/sdk/l$g$b;", "group", "<init>", "(Ljava/lang/String;Lio/didomi/sdk/l$g$a;Lio/didomi/sdk/l$g$b;)V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class Regulation {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
        @SerializedName("name")
        private final String name;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
        @SerializedName("ccpa")
        private final Ccpa ccpa;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
        @SerializedName("group")
        private final Group group;

        /* JADX INFO: renamed from: io.didomi.sdk.l$g$a, reason: from toString */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\tB\u001b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lio/didomi/sdk/l$g$a;", "", "", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "Z", "()Z", "lspa", "Lio/didomi/sdk/l$g$a$a;", "b", "Lio/didomi/sdk/l$g$a$a;", "getUspString", "()Lio/didomi/sdk/l$g$a$a;", "uspString", "<init>", "(ZLio/didomi/sdk/l$g$a$a;)V", "android_release"}, k = 1, mv = {1, 8, 0})
        public static final /* data */ class Ccpa {

            /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
            @SerializedName("lspa")
            private final boolean lspa;

            /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
            @SerializedName("uspString")
            private final UspString uspString;

            /* JADX INFO: renamed from: io.didomi.sdk.l$g$a$a, reason: collision with other inner class name and from toString */
            @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001a\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lio/didomi/sdk/l$g$a$a;", "", "", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "I", "getVersion", "()I", DiagnosticsEntry.VERSION_KEY, "<init>", "(I)V", "android_release"}, k = 1, mv = {1, 8, 0})
            public static final /* data */ class UspString {

                /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
                @SerializedName(DiagnosticsEntry.VERSION_KEY)
                private final int version;

                public UspString() {
                    this(0, 1, null);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    return (other instanceof UspString) && this.version == ((UspString) other).version;
                }

                public int hashCode() {
                    return Integer.hashCode(this.version);
                }

                public String toString() {
                    return "UspString(version=" + this.version + ')';
                }

                public UspString(int i) {
                    this.version = i;
                }

                public /* synthetic */ UspString(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i2 & 1) != 0 ? 1 : i);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public Ccpa() {
                this(false, null, 3, 0 == true ? 1 : 0);
            }

            /* JADX INFO: renamed from: a, reason: from getter */
            public final boolean getLspa() {
                return this.lspa;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Ccpa)) {
                    return false;
                }
                Ccpa ccpa = (Ccpa) other;
                return this.lspa == ccpa.lspa && Intrinsics.areEqual(this.uspString, ccpa.uspString);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v4 */
            /* JADX WARN: Type inference failed for: r0v5 */
            public int hashCode() {
                boolean z = this.lspa;
                ?? r0 = z;
                if (z) {
                    r0 = 1;
                }
                return (r0 * 31) + this.uspString.hashCode();
            }

            public String toString() {
                return "Ccpa(lspa=" + this.lspa + ", uspString=" + this.uspString + ')';
            }

            public Ccpa(boolean z, UspString uspString) {
                Intrinsics.checkNotNullParameter(uspString, "uspString");
                this.lspa = z;
                this.uspString = uspString;
            }

            public /* synthetic */ Ccpa(boolean z, UspString uspString, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? false : z, (i & 2) != 0 ? new UspString(0, 1, null) : uspString);
            }
        }

        /* JADX INFO: renamed from: io.didomi.sdk.l$g$b, reason: from toString */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lio/didomi/sdk/l$g$b;", "", "", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "name", "<init>", "(Ljava/lang/String;)V", "android_release"}, k = 1, mv = {1, 8, 0})
        public static final /* data */ class Group {

            /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
            @SerializedName("name")
            private final String name;

            /* JADX WARN: Multi-variable type inference failed */
            public Group() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Group) && Intrinsics.areEqual(this.name, ((Group) other).name);
            }

            public int hashCode() {
                return this.name.hashCode();
            }

            public String toString() {
                return "Group(name=" + this.name + ')';
            }

            public Group(String name) {
                Intrinsics.checkNotNullParameter(name, "name");
                this.name = name;
            }

            public /* synthetic */ Group(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? "" : str);
            }
        }

        public Regulation() {
            this(null, null, null, 7, null);
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final Ccpa getCcpa() {
            return this.ccpa;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Regulation)) {
                return false;
            }
            Regulation regulation = (Regulation) other;
            return Intrinsics.areEqual(this.name, regulation.name) && Intrinsics.areEqual(this.ccpa, regulation.ccpa) && Intrinsics.areEqual(this.group, regulation.group);
        }

        public int hashCode() {
            String str = this.name;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            Ccpa ccpa = this.ccpa;
            int iHashCode2 = (iHashCode + (ccpa == null ? 0 : ccpa.hashCode())) * 31;
            Group group = this.group;
            return iHashCode2 + (group != null ? group.hashCode() : 0);
        }

        public String toString() {
            return "Regulation(name=" + this.name + ", ccpa=" + this.ccpa + ", group=" + this.group + ')';
        }

        public Regulation(String str, Ccpa ccpa, Group group) {
            this.name = str;
            this.ccpa = ccpa;
            this.group = group;
        }

        public /* synthetic */ Regulation(String str, Ccpa ccpa, Group group, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : ccpa, (i & 4) != 0 ? null : group);
        }
    }

    /* JADX INFO: renamed from: io.didomi.sdk.l$h, reason: from toString */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001:\u0003\t\r\u000eBM\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0017\u0012\b\b\u0002\u0010 \u001a\u00020\u0007¢\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u0010\u0010\u000bR\u001a\u0010\u0016\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\r\u0010\u0015R\u001a\u0010\u001b\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001d\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR\u001a\u0010 \u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001e\u001a\u0004\b\u0013\u0010\u001f¨\u0006#"}, d2 = {"Lio/didomi/sdk/l$h;", "", "", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "backgroundColor", "b", "c", "color", "e", "linkColor", "Lio/didomi/sdk/l$h$b;", "d", "Lio/didomi/sdk/l$h$b;", "()Lio/didomi/sdk/l$h$b;", "buttonsThemeConfig", "Lio/didomi/sdk/l$h$c;", "Lio/didomi/sdk/l$h$c;", "f", "()Lio/didomi/sdk/l$h$c;", "notice", "g", "preferences", "Z", "()Z", "fullscreen", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/didomi/sdk/l$h$b;Lio/didomi/sdk/l$h$c;Lio/didomi/sdk/l$h$c;Z)V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class Theme {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
        @SerializedName("backgroundColor")
        private final String backgroundColor;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
        @SerializedName("color")
        private final String color;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
        @SerializedName("linkColor")
        private final String linkColor;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
        @SerializedName("buttons")
        private final ButtonsThemeConfig buttonsThemeConfig;

        /* JADX INFO: renamed from: e, reason: from kotlin metadata and from toString */
        @SerializedName("notice")
        private final ContentThemeConfig notice;

        /* JADX INFO: renamed from: f, reason: from kotlin metadata and from toString */
        @SerializedName("preferences")
        private final ContentThemeConfig preferences;

        /* JADX INFO: renamed from: g, reason: from kotlin metadata and from toString */
        @SerializedName("fullscreen")
        private final boolean fullscreen;

        /* JADX INFO: renamed from: io.didomi.sdk.l$h$a */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0003B\u0013\b\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lio/didomi/sdk/l$h$a;", "", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "value", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "c", "d", "e", "android_release"}, k = 1, mv = {1, 8, 0})
        public enum a {
            PRIMARY("primary"),
            SECONDARY("secondary"),
            NONE("none");


            /* JADX INFO: renamed from: b, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);

            /* JADX INFO: renamed from: a, reason: from kotlin metadata */
            private final String value;

            /* JADX INFO: renamed from: io.didomi.sdk.l$h$a$a, reason: collision with other inner class name and from kotlin metadata */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lio/didomi/sdk/l$h$a$a;", "", "", "value", "Lio/didomi/sdk/l$h$a;", "a", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final a a(String value) {
                    Intrinsics.checkNotNullParameter(value, "value");
                    Locale ENGLISH = Locale.ENGLISH;
                    Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
                    String lowerCase = value.toLowerCase(ENGLISH);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                    a aVar = a.PRIMARY;
                    if (Intrinsics.areEqual(lowerCase, aVar.getValue())) {
                        return aVar;
                    }
                    a aVar2 = a.SECONDARY;
                    return Intrinsics.areEqual(lowerCase, aVar2.getValue()) ? aVar2 : a.NONE;
                }

                private Companion() {
                }
            }

            a(String str) {
                this.value = str;
            }

            /* JADX INFO: renamed from: b, reason: from getter */
            public final String getValue() {
                return this.value;
            }
        }

        /* JADX INFO: renamed from: io.didomi.sdk.l$h$b, reason: from toString */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\nB\u001b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\n\u0010\r¨\u0006\u0012"}, d2 = {"Lio/didomi/sdk/l$h$b;", "", "", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "Lio/didomi/sdk/l$h$b$a;", "a", "Lio/didomi/sdk/l$h$b$a;", "b", "()Lio/didomi/sdk/l$h$b$a;", "regular", "highlight", "<init>", "(Lio/didomi/sdk/l$h$b$a;Lio/didomi/sdk/l$h$b$a;)V", "android_release"}, k = 1, mv = {1, 8, 0})
        public static final /* data */ class ButtonsThemeConfig {

            /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
            @SerializedName("regularButtons")
            private final ButtonTheme regular;

            /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
            @SerializedName("highlightButtons")
            private final ButtonTheme highlight;

            /* JADX INFO: renamed from: io.didomi.sdk.l$h$b$a, reason: from toString */
            @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\t¢\u0006\u0004\b\u001b\u0010\u001cJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0013\u0010\rR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0015\u0010\rR\u001a\u0010\u001a\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lio/didomi/sdk/l$h$b$a;", "", "", "a", "b", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "backgroundColor", "getTextColor", "textColor", "d", "borderColor", "f", "borderWidth", "e", "borderRadius", "Z", "g", "()Z", "sizesInDp", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "android_release"}, k = 1, mv = {1, 8, 0})
            public static final /* data */ class ButtonTheme {

                /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
                @SerializedName("backgroundColor")
                private final String backgroundColor;

                /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
                @SerializedName("textColor")
                private final String textColor;

                /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
                @SerializedName("borderColor")
                private final String borderColor;

                /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
                @SerializedName("borderWidth")
                private final String borderWidth;

                /* JADX INFO: renamed from: e, reason: from kotlin metadata and from toString */
                @SerializedName("borderRadius")
                private final String borderRadius;

                /* JADX INFO: renamed from: f, reason: from kotlin metadata and from toString */
                @SerializedName("sizesInDp")
                private final boolean sizesInDp;

                public ButtonTheme() {
                    this(null, null, null, null, null, false, 63, null);
                }

                /* JADX INFO: renamed from: a, reason: from getter */
                public final String getBackgroundColor() {
                    return this.backgroundColor;
                }

                /* JADX INFO: renamed from: b, reason: from getter */
                public final String getTextColor() {
                    return this.textColor;
                }

                public final String c() {
                    return this.backgroundColor;
                }

                /* JADX INFO: renamed from: d, reason: from getter */
                public final String getBorderColor() {
                    return this.borderColor;
                }

                /* JADX INFO: renamed from: e, reason: from getter */
                public final String getBorderRadius() {
                    return this.borderRadius;
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof ButtonTheme)) {
                        return false;
                    }
                    ButtonTheme buttonTheme = (ButtonTheme) other;
                    return Intrinsics.areEqual(this.backgroundColor, buttonTheme.backgroundColor) && Intrinsics.areEqual(this.textColor, buttonTheme.textColor) && Intrinsics.areEqual(this.borderColor, buttonTheme.borderColor) && Intrinsics.areEqual(this.borderWidth, buttonTheme.borderWidth) && Intrinsics.areEqual(this.borderRadius, buttonTheme.borderRadius) && this.sizesInDp == buttonTheme.sizesInDp;
                }

                /* JADX INFO: renamed from: f, reason: from getter */
                public final String getBorderWidth() {
                    return this.borderWidth;
                }

                /* JADX INFO: renamed from: g, reason: from getter */
                public final boolean getSizesInDp() {
                    return this.sizesInDp;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r0v12, types: [int] */
                /* JADX WARN: Type inference failed for: r1v3, types: [int] */
                /* JADX WARN: Type inference failed for: r1v4 */
                /* JADX WARN: Type inference failed for: r1v6 */
                public int hashCode() {
                    String str = this.backgroundColor;
                    int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                    String str2 = this.textColor;
                    int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                    String str3 = this.borderColor;
                    int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
                    String str4 = this.borderWidth;
                    int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
                    String str5 = this.borderRadius;
                    int iHashCode5 = (iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
                    boolean z = this.sizesInDp;
                    ?? r1 = z;
                    if (z) {
                        r1 = 1;
                    }
                    return iHashCode5 + r1;
                }

                public String toString() {
                    return "ButtonTheme(backgroundColor=" + this.backgroundColor + ", textColor=" + this.textColor + ", borderColor=" + this.borderColor + ", borderWidth=" + this.borderWidth + ", borderRadius=" + this.borderRadius + ", sizesInDp=" + this.sizesInDp + ')';
                }

                public ButtonTheme(String str, String str2, String str3, String str4, String str5, boolean z) {
                    this.backgroundColor = str;
                    this.textColor = str2;
                    this.borderColor = str3;
                    this.borderWidth = str4;
                    this.borderRadius = str5;
                    this.sizesInDp = z;
                }

                public /* synthetic */ ButtonTheme(String str, String str2, String str3, String str4, String str5, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? false : z);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public ButtonsThemeConfig() {
                this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
            }

            /* JADX INFO: renamed from: a, reason: from getter */
            public final ButtonTheme getHighlight() {
                return this.highlight;
            }

            /* JADX INFO: renamed from: b, reason: from getter */
            public final ButtonTheme getRegular() {
                return this.regular;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ButtonsThemeConfig)) {
                    return false;
                }
                ButtonsThemeConfig buttonsThemeConfig = (ButtonsThemeConfig) other;
                return Intrinsics.areEqual(this.regular, buttonsThemeConfig.regular) && Intrinsics.areEqual(this.highlight, buttonsThemeConfig.highlight);
            }

            public int hashCode() {
                return (this.regular.hashCode() * 31) + this.highlight.hashCode();
            }

            public String toString() {
                return "ButtonsThemeConfig(regular=" + this.regular + ", highlight=" + this.highlight + ')';
            }

            public ButtonsThemeConfig(ButtonTheme regular, ButtonTheme highlight) {
                Intrinsics.checkNotNullParameter(regular, "regular");
                Intrinsics.checkNotNullParameter(highlight, "highlight");
                this.regular = regular;
                this.highlight = highlight;
            }

            public /* synthetic */ ButtonsThemeConfig(ButtonTheme buttonTheme, ButtonTheme buttonTheme2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                if ((i & 1) != 0) {
                    buttonTheme = new ButtonTheme(null, null, null, null, null, false, 63, null);
                }
                if ((i & 2) != 0) {
                    buttonTheme2 = new ButtonTheme(null, null, null, null, null, false, 63, null);
                }
                this(buttonTheme, buttonTheme2);
            }
        }

        /* JADX INFO: renamed from: io.didomi.sdk.l$h$c, reason: from toString */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b$\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\tB\u009f\u0001\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010(\u001a\u00020\u0007¢\u0006\u0004\b)\u0010*J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001a\u0010\f\u001a\u00020\u00028\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000bR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\u000bR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\u000bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0010\u0010\u000bR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u001a\u0010\u000bR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\n\u001a\u0004\b\u001c\u0010\u000bR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u0012\u0010\u000bR\u001c\u0010\"\u001a\u0004\u0018\u00010\u00048\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u000e\u0010 \u001a\u0004\b\u001e\u0010!R\u001c\u0010$\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010 \u001a\u0004\b#\u0010!R\u001c\u0010%\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010 \u001a\u0004\b\u0015\u0010!R\u001a\u0010(\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010&\u001a\u0004\b\u0019\u0010'¨\u0006+"}, d2 = {"Lio/didomi/sdk/l$h$c;", "", "", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "alignment", "b", "j", "titleAlignment", "c", "descriptionAlignment", "d", "f", "fontFamily", "e", "k", "titleFontFamily", "descriptionFontFamily", "g", "h", "textColor", "l", "titleTextColor", "i", "descriptionTextColor", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "textSize", "m", "titleTextSize", "descriptionTextSize", "Z", "()Z", "stickyButtons", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Z)V", "android_release"}, k = 1, mv = {1, 8, 0})
        public static final /* data */ class ContentThemeConfig {

            /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
            @SerializedName("alignment")
            private final String alignment;

            /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
            @SerializedName("titleAlignment")
            private final String titleAlignment;

            /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
            @SerializedName("descriptionAlignment")
            private final String descriptionAlignment;

            /* JADX INFO: renamed from: d, reason: from kotlin metadata and from toString */
            @SerializedName("fontFamily")
            private final String fontFamily;

            /* JADX INFO: renamed from: e, reason: from kotlin metadata and from toString */
            @SerializedName("titleFontFamily")
            private final String titleFontFamily;

            /* JADX INFO: renamed from: f, reason: from kotlin metadata and from toString */
            @SerializedName("descriptionFontFamily")
            private final String descriptionFontFamily;

            /* JADX INFO: renamed from: g, reason: from kotlin metadata and from toString */
            @SerializedName("textColor")
            private final String textColor;

            /* JADX INFO: renamed from: h, reason: from kotlin metadata and from toString */
            @SerializedName("titleTextColor")
            private final String titleTextColor;

            /* JADX INFO: renamed from: i, reason: from kotlin metadata and from toString */
            @SerializedName("descriptionTextColor")
            private final String descriptionTextColor;

            /* JADX INFO: renamed from: j, reason: from kotlin metadata and from toString */
            @SerializedName("textSize")
            private final Integer textSize;

            /* JADX INFO: renamed from: k, reason: from kotlin metadata and from toString */
            @SerializedName("titleTextSize")
            private final Integer titleTextSize;

            /* JADX INFO: renamed from: l, reason: from kotlin metadata and from toString */
            @SerializedName("descriptionTextSize")
            private final Integer descriptionTextSize;

            /* JADX INFO: renamed from: m, reason: from kotlin metadata and from toString */
            @SerializedName("stickyButtons")
            private final boolean stickyButtons;

            /* JADX INFO: renamed from: io.didomi.sdk.l$h$c$a */
            @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0003B%\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001f\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b8\u0006¢\u0006\f\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lio/didomi/sdk/l$h$c$a;", "", "", "a", "I", "b", "()I", "gravity", "", "", "[Ljava/lang/String;", "c", "()[Ljava/lang/String;", "values", "<init>", "(Ljava/lang/String;II[Ljava/lang/String;)V", "d", "e", "f", "g", "android_release"}, k = 1, mv = {1, 8, 0})
            public enum a {
                CENTER(17, "center", "middle"),
                START(8388611, "start", "left"),
                END(8388613, "end", "right"),
                JUSTIFY(8388611, "justify", "justified");


                /* JADX INFO: renamed from: c, reason: from kotlin metadata */
                public static final Companion INSTANCE = new Companion(null);

                /* JADX INFO: renamed from: a, reason: from kotlin metadata */
                private final int gravity;

                /* JADX INFO: renamed from: b, reason: from kotlin metadata */
                private final String[] values;

                /* JADX INFO: renamed from: io.didomi.sdk.l$h$c$a$a, reason: collision with other inner class name and from kotlin metadata */
                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lio/didomi/sdk/l$h$c$a$a;", "", "", "value", "Lio/didomi/sdk/l$h$c$a;", "a", "<init>", "()V", "android_release"}, k = 1, mv = {1, 8, 0})
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    public final a a(String value) {
                        Intrinsics.checkNotNullParameter(value, "value");
                        a aVar = a.CENTER;
                        String[] values = aVar.getValues();
                        Locale locale = Locale.ROOT;
                        String lowerCase = value.toLowerCase(locale);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                        if (ArraysKt.contains(values, lowerCase)) {
                            return aVar;
                        }
                        a aVar2 = a.START;
                        String[] values2 = aVar2.getValues();
                        String lowerCase2 = value.toLowerCase(locale);
                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                        if (!ArraysKt.contains(values2, lowerCase2)) {
                            a aVar3 = a.END;
                            String[] values3 = aVar3.getValues();
                            String lowerCase3 = value.toLowerCase(locale);
                            Intrinsics.checkNotNullExpressionValue(lowerCase3, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                            if (ArraysKt.contains(values3, lowerCase3)) {
                                return aVar3;
                            }
                            a aVar4 = a.JUSTIFY;
                            String[] values4 = aVar4.getValues();
                            String lowerCase4 = value.toLowerCase(locale);
                            Intrinsics.checkNotNullExpressionValue(lowerCase4, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                            if (ArraysKt.contains(values4, lowerCase4)) {
                                return aVar4;
                            }
                        }
                        return aVar2;
                    }

                    private Companion() {
                    }
                }

                a(int i, String... strArr) {
                    this.gravity = i;
                    this.values = strArr;
                }

                /* JADX INFO: renamed from: b, reason: from getter */
                public final int getGravity() {
                    return this.gravity;
                }

                /* JADX INFO: renamed from: c, reason: from getter */
                public final String[] getValues() {
                    return this.values;
                }
            }

            public ContentThemeConfig() {
                this(null, null, null, null, null, null, null, null, null, null, null, null, false, 8191, null);
            }

            /* JADX INFO: renamed from: a, reason: from getter */
            public final String getAlignment() {
                return this.alignment;
            }

            /* JADX INFO: renamed from: b, reason: from getter */
            public final String getDescriptionAlignment() {
                return this.descriptionAlignment;
            }

            /* JADX INFO: renamed from: c, reason: from getter */
            public final String getDescriptionFontFamily() {
                return this.descriptionFontFamily;
            }

            /* JADX INFO: renamed from: d, reason: from getter */
            public final String getDescriptionTextColor() {
                return this.descriptionTextColor;
            }

            /* JADX INFO: renamed from: e, reason: from getter */
            public final Integer getDescriptionTextSize() {
                return this.descriptionTextSize;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ContentThemeConfig)) {
                    return false;
                }
                ContentThemeConfig contentThemeConfig = (ContentThemeConfig) other;
                return Intrinsics.areEqual(this.alignment, contentThemeConfig.alignment) && Intrinsics.areEqual(this.titleAlignment, contentThemeConfig.titleAlignment) && Intrinsics.areEqual(this.descriptionAlignment, contentThemeConfig.descriptionAlignment) && Intrinsics.areEqual(this.fontFamily, contentThemeConfig.fontFamily) && Intrinsics.areEqual(this.titleFontFamily, contentThemeConfig.titleFontFamily) && Intrinsics.areEqual(this.descriptionFontFamily, contentThemeConfig.descriptionFontFamily) && Intrinsics.areEqual(this.textColor, contentThemeConfig.textColor) && Intrinsics.areEqual(this.titleTextColor, contentThemeConfig.titleTextColor) && Intrinsics.areEqual(this.descriptionTextColor, contentThemeConfig.descriptionTextColor) && Intrinsics.areEqual(this.textSize, contentThemeConfig.textSize) && Intrinsics.areEqual(this.titleTextSize, contentThemeConfig.titleTextSize) && Intrinsics.areEqual(this.descriptionTextSize, contentThemeConfig.descriptionTextSize) && this.stickyButtons == contentThemeConfig.stickyButtons;
            }

            /* JADX INFO: renamed from: f, reason: from getter */
            public final String getFontFamily() {
                return this.fontFamily;
            }

            /* JADX INFO: renamed from: g, reason: from getter */
            public final boolean getStickyButtons() {
                return this.stickyButtons;
            }

            /* JADX INFO: renamed from: h, reason: from getter */
            public final String getTextColor() {
                return this.textColor;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v25, types: [int] */
            /* JADX WARN: Type inference failed for: r1v32, types: [int] */
            /* JADX WARN: Type inference failed for: r1v33 */
            /* JADX WARN: Type inference failed for: r1v44 */
            public int hashCode() {
                int iHashCode = this.alignment.hashCode() * 31;
                String str = this.titleAlignment;
                int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.descriptionAlignment;
                int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.fontFamily;
                int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
                String str4 = this.titleFontFamily;
                int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
                String str5 = this.descriptionFontFamily;
                int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
                String str6 = this.textColor;
                int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
                String str7 = this.titleTextColor;
                int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
                String str8 = this.descriptionTextColor;
                int iHashCode9 = (iHashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
                Integer num = this.textSize;
                int iHashCode10 = (iHashCode9 + (num == null ? 0 : num.hashCode())) * 31;
                Integer num2 = this.titleTextSize;
                int iHashCode11 = (iHashCode10 + (num2 == null ? 0 : num2.hashCode())) * 31;
                Integer num3 = this.descriptionTextSize;
                int iHashCode12 = (iHashCode11 + (num3 != null ? num3.hashCode() : 0)) * 31;
                boolean z = this.stickyButtons;
                ?? r1 = z;
                if (z) {
                    r1 = 1;
                }
                return iHashCode12 + r1;
            }

            /* JADX INFO: renamed from: i, reason: from getter */
            public final Integer getTextSize() {
                return this.textSize;
            }

            /* JADX INFO: renamed from: j, reason: from getter */
            public final String getTitleAlignment() {
                return this.titleAlignment;
            }

            /* JADX INFO: renamed from: k, reason: from getter */
            public final String getTitleFontFamily() {
                return this.titleFontFamily;
            }

            /* JADX INFO: renamed from: l, reason: from getter */
            public final String getTitleTextColor() {
                return this.titleTextColor;
            }

            /* JADX INFO: renamed from: m, reason: from getter */
            public final Integer getTitleTextSize() {
                return this.titleTextSize;
            }

            public String toString() {
                return "ContentThemeConfig(alignment=" + this.alignment + ", titleAlignment=" + this.titleAlignment + ", descriptionAlignment=" + this.descriptionAlignment + ", fontFamily=" + this.fontFamily + ", titleFontFamily=" + this.titleFontFamily + ", descriptionFontFamily=" + this.descriptionFontFamily + ", textColor=" + this.textColor + ", titleTextColor=" + this.titleTextColor + ", descriptionTextColor=" + this.descriptionTextColor + ", textSize=" + this.textSize + ", titleTextSize=" + this.titleTextSize + ", descriptionTextSize=" + this.descriptionTextSize + ", stickyButtons=" + this.stickyButtons + ')';
            }

            public ContentThemeConfig(String alignment, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Integer num, Integer num2, Integer num3, boolean z) {
                Intrinsics.checkNotNullParameter(alignment, "alignment");
                this.alignment = alignment;
                this.titleAlignment = str;
                this.descriptionAlignment = str2;
                this.fontFamily = str3;
                this.titleFontFamily = str4;
                this.descriptionFontFamily = str5;
                this.textColor = str6;
                this.titleTextColor = str7;
                this.descriptionTextColor = str8;
                this.textSize = num;
                this.titleTextSize = num2;
                this.descriptionTextSize = num3;
                this.stickyButtons = z;
            }

            public /* synthetic */ ContentThemeConfig(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Integer num, Integer num2, Integer num3, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? (String) ArraysKt.first(a.START.getValues()) : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? null : str9, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? null : num, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? null : num2, (i & 2048) == 0 ? num3 : null, (i & 4096) != 0 ? false : z);
            }
        }

        public Theme() {
            this(null, null, null, null, null, null, false, 127, null);
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final String getBackgroundColor() {
            return this.backgroundColor;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final ButtonsThemeConfig getButtonsThemeConfig() {
            return this.buttonsThemeConfig;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final String getColor() {
            return this.color;
        }

        /* JADX INFO: renamed from: d, reason: from getter */
        public final boolean getFullscreen() {
            return this.fullscreen;
        }

        /* JADX INFO: renamed from: e, reason: from getter */
        public final String getLinkColor() {
            return this.linkColor;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Theme)) {
                return false;
            }
            Theme theme = (Theme) other;
            return Intrinsics.areEqual(this.backgroundColor, theme.backgroundColor) && Intrinsics.areEqual(this.color, theme.color) && Intrinsics.areEqual(this.linkColor, theme.linkColor) && Intrinsics.areEqual(this.buttonsThemeConfig, theme.buttonsThemeConfig) && Intrinsics.areEqual(this.notice, theme.notice) && Intrinsics.areEqual(this.preferences, theme.preferences) && this.fullscreen == theme.fullscreen;
        }

        /* JADX INFO: renamed from: f, reason: from getter */
        public final ContentThemeConfig getNotice() {
            return this.notice;
        }

        /* JADX INFO: renamed from: g, reason: from getter */
        public final ContentThemeConfig getPreferences() {
            return this.preferences;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v13, types: [int] */
        /* JADX WARN: Type inference failed for: r1v11, types: [int] */
        /* JADX WARN: Type inference failed for: r1v12 */
        /* JADX WARN: Type inference failed for: r1v13 */
        public int hashCode() {
            int iHashCode = ((((((((((this.backgroundColor.hashCode() * 31) + this.color.hashCode()) * 31) + this.linkColor.hashCode()) * 31) + this.buttonsThemeConfig.hashCode()) * 31) + this.notice.hashCode()) * 31) + this.preferences.hashCode()) * 31;
            boolean z = this.fullscreen;
            ?? r1 = z;
            if (z) {
                r1 = 1;
            }
            return iHashCode + r1;
        }

        public String toString() {
            return "Theme(backgroundColor=" + this.backgroundColor + ", color=" + this.color + ", linkColor=" + this.linkColor + ", buttonsThemeConfig=" + this.buttonsThemeConfig + ", notice=" + this.notice + ", preferences=" + this.preferences + ", fullscreen=" + this.fullscreen + ')';
        }

        public Theme(String backgroundColor, String color, String linkColor, ButtonsThemeConfig buttonsThemeConfig, ContentThemeConfig notice, ContentThemeConfig preferences, boolean z) {
            Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
            Intrinsics.checkNotNullParameter(color, "color");
            Intrinsics.checkNotNullParameter(linkColor, "linkColor");
            Intrinsics.checkNotNullParameter(buttonsThemeConfig, "buttonsThemeConfig");
            Intrinsics.checkNotNullParameter(notice, "notice");
            Intrinsics.checkNotNullParameter(preferences, "preferences");
            this.backgroundColor = backgroundColor;
            this.color = color;
            this.linkColor = linkColor;
            this.buttonsThemeConfig = buttonsThemeConfig;
            this.notice = notice;
            this.preferences = preferences;
            this.fullscreen = z;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ Theme(String str, String str2, String str3, ButtonsThemeConfig buttonsThemeConfig, ContentThemeConfig contentThemeConfig, ContentThemeConfig contentThemeConfig2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            ButtonsThemeConfig buttonsThemeConfig2;
            String str4 = (i & 1) != 0 ? "#FFFFFF" : str;
            String str5 = (i & 2) != 0 ? "#05687b" : str2;
            String str6 = (i & 4) == 0 ? str3 : "#05687b";
            if ((i & 8) != 0) {
                buttonsThemeConfig2 = new ButtonsThemeConfig(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
            } else {
                buttonsThemeConfig2 = buttonsThemeConfig;
            }
            this(str4, str5, str6, buttonsThemeConfig2, (i & 16) != 0 ? new ContentThemeConfig(null, null, null, null, null, null, null, null, null, null, null, null, false, 8191, null) : contentThemeConfig, (i & 32) != 0 ? new ContentThemeConfig(null, null, null, null, null, null, null, null, null, null, null, null, false, 8191, null) : contentThemeConfig2, (i & 64) != 0 ? false : z);
        }
    }

    /* JADX INFO: renamed from: io.didomi.sdk.l$i, reason: from toString */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b¨\u0006\u000f"}, d2 = {"Lio/didomi/sdk/l$i;", "", "", "toString", "", "hashCode", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "ignoreConsentBeforeAsString", "<init>", "(Ljava/lang/String;)V", "android_release"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class User {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata and from toString */
        @SerializedName("ignoreConsentBefore")
        private final String ignoreConsentBeforeAsString;

        /* JADX WARN: Multi-variable type inference failed */
        public User() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final String getIgnoreConsentBeforeAsString() {
            return this.ignoreConsentBeforeAsString;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof User) && Intrinsics.areEqual(this.ignoreConsentBeforeAsString, ((User) other).ignoreConsentBeforeAsString);
        }

        public int hashCode() {
            String str = this.ignoreConsentBeforeAsString;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "User(ignoreConsentBeforeAsString=" + this.ignoreConsentBeforeAsString + ')';
        }

        public User(String str) {
            this.ignoreConsentBeforeAsString = str;
        }

        public /* synthetic */ User(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }
    }

    public AppConfiguration() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final App getApp() {
        return this.app;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final FeatureFlags getFeatureFlags() {
        return this.featureFlags;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final Languages getLanguages() {
        return this.languages;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final Notice getNotice() {
        return this.notice;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final Preferences getPreferences() {
        return this.preferences;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppConfiguration)) {
            return false;
        }
        AppConfiguration appConfiguration = (AppConfiguration) other;
        return Intrinsics.areEqual(this.app, appConfiguration.app) && Intrinsics.areEqual(this.languages, appConfiguration.languages) && Intrinsics.areEqual(this.notice, appConfiguration.notice) && Intrinsics.areEqual(this.preferences, appConfiguration.preferences) && Intrinsics.areEqual(this.sync, appConfiguration.sync) && Intrinsics.areEqual(this.textsConfiguration, appConfiguration.textsConfiguration) && Intrinsics.areEqual(this.theme, appConfiguration.theme) && Intrinsics.areEqual(this.user, appConfiguration.user) && Intrinsics.areEqual(this.version, appConfiguration.version) && Intrinsics.areEqual(this.regulation, appConfiguration.regulation) && Intrinsics.areEqual(this.featureFlags, appConfiguration.featureFlags);
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final Regulation getRegulation() {
        return this.regulation;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final SyncConfiguration getSync() {
        return this.sync;
    }

    public final Map<String, Map<String, String>> h() {
        return this.textsConfiguration;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((this.app.hashCode() * 31) + this.languages.hashCode()) * 31) + this.notice.hashCode()) * 31) + this.preferences.hashCode()) * 31) + this.sync.hashCode()) * 31) + this.textsConfiguration.hashCode()) * 31) + this.theme.hashCode()) * 31) + this.user.hashCode()) * 31;
        String str = this.version;
        return ((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.regulation.hashCode()) * 31) + this.featureFlags.hashCode();
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final Theme getTheme() {
        return this.theme;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    public String toString() {
        return "AppConfiguration(app=" + this.app + ", languages=" + this.languages + ", notice=" + this.notice + ", preferences=" + this.preferences + ", sync=" + this.sync + ", textsConfiguration=" + this.textsConfiguration + ", theme=" + this.theme + ", user=" + this.user + ", version=" + this.version + ", regulation=" + this.regulation + ", featureFlags=" + this.featureFlags + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AppConfiguration(App app2, Languages languages, Notice notice, Preferences preferences, SyncConfiguration sync, Map<String, ? extends Map<String, String>> textsConfiguration, Theme theme, User user, String str, Regulation regulation, FeatureFlags featureFlags) {
        Intrinsics.checkNotNullParameter(app2, "app");
        Intrinsics.checkNotNullParameter(languages, "languages");
        Intrinsics.checkNotNullParameter(notice, "notice");
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        Intrinsics.checkNotNullParameter(sync, "sync");
        Intrinsics.checkNotNullParameter(textsConfiguration, "textsConfiguration");
        Intrinsics.checkNotNullParameter(theme, "theme");
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(regulation, "regulation");
        Intrinsics.checkNotNullParameter(featureFlags, "featureFlags");
        this.app = app2;
        this.languages = languages;
        this.notice = notice;
        this.preferences = preferences;
        this.sync = sync;
        this.textsConfiguration = textsConfiguration;
        this.theme = theme;
        this.user = user;
        this.version = str;
        this.regulation = regulation;
        this.featureFlags = featureFlags;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ AppConfiguration(App app2, Languages languages, Notice notice, Preferences preferences, SyncConfiguration syncConfiguration, Map map, Theme theme, User user, String str, Regulation regulation, FeatureFlags featureFlags, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Languages languages2;
        User user2;
        FeatureFlags featureFlags2;
        App app3 = (i & 1) != 0 ? new App(null, null, null, false, false, null, null, null, null, null, false, null, null, null, 16383, null) : app2;
        int i2 = 3;
        Set set = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        if ((i & 2) != 0) {
            languages2 = new Languages(set, objArr5 == true ? 1 : 0, i2, objArr4 == true ? 1 : 0);
        } else {
            languages2 = languages;
        }
        Notice notice2 = (i & 4) != 0 ? new Notice(0, false, null, null, null, false, false, null, false, false, 1023, null) : notice;
        Preferences preferences2 = (i & 8) != 0 ? new Preferences(false, null, false, false, false, null, null, 127, null) : preferences;
        SyncConfiguration syncConfiguration2 = (i & 16) != 0 ? new SyncConfiguration(false, 0, 0, 7, null) : syncConfiguration;
        Map mapEmptyMap = (i & 32) != 0 ? MapsKt.emptyMap() : map;
        Theme theme2 = (i & 64) != 0 ? new Theme(null, null, null, null, null, null, false, 127, null) : theme;
        if ((i & 128) != 0) {
            user2 = new User(objArr3 == true ? 1 : 0, 1, objArr2 == true ? 1 : 0);
        } else {
            user2 = user;
        }
        String str2 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? null : str;
        Regulation regulation2 = (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? new Regulation(null, null, null, 7, null) : regulation;
        if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0) {
            boolean z = false;
            featureFlags2 = new FeatureFlags(z, z, i2, objArr == true ? 1 : 0);
        } else {
            featureFlags2 = featureFlags;
        }
        this(app3, languages2, notice2, preferences2, syncConfiguration2, mapEmptyMap, theme2, user2, str2, regulation2, featureFlags2);
    }
}
