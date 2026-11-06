package expo.modules.updates;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import expo.modules.updates.codesigning.CodeSigningConfiguration;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class UpdatesConfiguration {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = UpdatesConfiguration.class.getSimpleName();
    private final Map cachedOverrideMap;
    private final CheckAutomaticallyConfiguration checkOnLaunch;
    private final boolean codeSigningAllowUnsignedManifests;
    private final String codeSigningCertificate;
    private final Lazy codeSigningConfiguration$delegate;
    private final boolean codeSigningIncludeManifestResponseCertificateChain;
    private final Map codeSigningMetadata;
    private final boolean disableAntiBrickingMeasures;
    private final boolean enableBsdiffPatchSupport;
    private final boolean enableExpoUpdatesProtocolV0CompatibilityMode;
    private final boolean hasEmbeddedUpdate;
    private final boolean hasUpdatesOverride;
    private final int launchWaitMs;
    private final Map originalEmbeddedRequestHeaders;
    private final Uri originalEmbeddedUpdateUrl;
    private final boolean originalHasEmbeddedUpdate;
    private final Map requestHeaders;
    private final String runtimeVersionRaw;
    private final String scopeKey;
    private final Uri updateUrl;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpdatesConfiguration)) {
            return false;
        }
        UpdatesConfiguration updatesConfiguration = (UpdatesConfiguration) obj;
        return Intrinsics.areEqual(this.scopeKey, updatesConfiguration.scopeKey) && Intrinsics.areEqual(this.updateUrl, updatesConfiguration.updateUrl) && Intrinsics.areEqual(this.originalEmbeddedUpdateUrl, updatesConfiguration.originalEmbeddedUpdateUrl) && Intrinsics.areEqual(this.runtimeVersionRaw, updatesConfiguration.runtimeVersionRaw) && this.launchWaitMs == updatesConfiguration.launchWaitMs && this.checkOnLaunch == updatesConfiguration.checkOnLaunch && this.hasEmbeddedUpdate == updatesConfiguration.hasEmbeddedUpdate && this.originalHasEmbeddedUpdate == updatesConfiguration.originalHasEmbeddedUpdate && Intrinsics.areEqual(this.requestHeaders, updatesConfiguration.requestHeaders) && Intrinsics.areEqual(this.originalEmbeddedRequestHeaders, updatesConfiguration.originalEmbeddedRequestHeaders) && Intrinsics.areEqual(this.codeSigningCertificate, updatesConfiguration.codeSigningCertificate) && Intrinsics.areEqual(this.codeSigningMetadata, updatesConfiguration.codeSigningMetadata) && this.codeSigningIncludeManifestResponseCertificateChain == updatesConfiguration.codeSigningIncludeManifestResponseCertificateChain && this.codeSigningAllowUnsignedManifests == updatesConfiguration.codeSigningAllowUnsignedManifests && this.enableExpoUpdatesProtocolV0CompatibilityMode == updatesConfiguration.enableExpoUpdatesProtocolV0CompatibilityMode && this.enableBsdiffPatchSupport == updatesConfiguration.enableBsdiffPatchSupport && this.disableAntiBrickingMeasures == updatesConfiguration.disableAntiBrickingMeasures && this.hasUpdatesOverride == updatesConfiguration.hasUpdatesOverride && Intrinsics.areEqual(this.cachedOverrideMap, updatesConfiguration.cachedOverrideMap);
    }

    public int hashCode() {
        int iHashCode = ((((this.scopeKey.hashCode() * 31) + this.updateUrl.hashCode()) * 31) + this.originalEmbeddedUpdateUrl.hashCode()) * 31;
        String str = this.runtimeVersionRaw;
        int iHashCode2 = (((((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.launchWaitMs)) * 31) + this.checkOnLaunch.hashCode()) * 31) + Boolean.hashCode(this.hasEmbeddedUpdate)) * 31) + Boolean.hashCode(this.originalHasEmbeddedUpdate)) * 31) + this.requestHeaders.hashCode()) * 31) + this.originalEmbeddedRequestHeaders.hashCode()) * 31;
        String str2 = this.codeSigningCertificate;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Map map = this.codeSigningMetadata;
        int iHashCode4 = (((((((((((((iHashCode3 + (map == null ? 0 : map.hashCode())) * 31) + Boolean.hashCode(this.codeSigningIncludeManifestResponseCertificateChain)) * 31) + Boolean.hashCode(this.codeSigningAllowUnsignedManifests)) * 31) + Boolean.hashCode(this.enableExpoUpdatesProtocolV0CompatibilityMode)) * 31) + Boolean.hashCode(this.enableBsdiffPatchSupport)) * 31) + Boolean.hashCode(this.disableAntiBrickingMeasures)) * 31) + Boolean.hashCode(this.hasUpdatesOverride)) * 31;
        Map map2 = this.cachedOverrideMap;
        return iHashCode4 + (map2 != null ? map2.hashCode() : 0);
    }

    public String toString() {
        return "UpdatesConfiguration(scopeKey=" + this.scopeKey + ", updateUrl=" + this.updateUrl + ", originalEmbeddedUpdateUrl=" + this.originalEmbeddedUpdateUrl + ", runtimeVersionRaw=" + this.runtimeVersionRaw + ", launchWaitMs=" + this.launchWaitMs + ", checkOnLaunch=" + this.checkOnLaunch + ", hasEmbeddedUpdate=" + this.hasEmbeddedUpdate + ", originalHasEmbeddedUpdate=" + this.originalHasEmbeddedUpdate + ", requestHeaders=" + this.requestHeaders + ", originalEmbeddedRequestHeaders=" + this.originalEmbeddedRequestHeaders + ", codeSigningCertificate=" + this.codeSigningCertificate + ", codeSigningMetadata=" + this.codeSigningMetadata + ", codeSigningIncludeManifestResponseCertificateChain=" + this.codeSigningIncludeManifestResponseCertificateChain + ", codeSigningAllowUnsignedManifests=" + this.codeSigningAllowUnsignedManifests + ", enableExpoUpdatesProtocolV0CompatibilityMode=" + this.enableExpoUpdatesProtocolV0CompatibilityMode + ", enableBsdiffPatchSupport=" + this.enableBsdiffPatchSupport + ", disableAntiBrickingMeasures=" + this.disableAntiBrickingMeasures + ", hasUpdatesOverride=" + this.hasUpdatesOverride + ", cachedOverrideMap=" + this.cachedOverrideMap + ")";
    }

    public UpdatesConfiguration(String scopeKey, Uri updateUrl, Uri originalEmbeddedUpdateUrl, String str, int i, CheckAutomaticallyConfiguration checkOnLaunch, boolean z, boolean z2, Map requestHeaders, Map originalEmbeddedRequestHeaders, String str2, Map map, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, Map map2) {
        Intrinsics.checkNotNullParameter(scopeKey, "scopeKey");
        Intrinsics.checkNotNullParameter(updateUrl, "updateUrl");
        Intrinsics.checkNotNullParameter(originalEmbeddedUpdateUrl, "originalEmbeddedUpdateUrl");
        Intrinsics.checkNotNullParameter(checkOnLaunch, "checkOnLaunch");
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        Intrinsics.checkNotNullParameter(originalEmbeddedRequestHeaders, "originalEmbeddedRequestHeaders");
        this.scopeKey = scopeKey;
        this.updateUrl = updateUrl;
        this.originalEmbeddedUpdateUrl = originalEmbeddedUpdateUrl;
        this.runtimeVersionRaw = str;
        this.launchWaitMs = i;
        this.checkOnLaunch = checkOnLaunch;
        this.hasEmbeddedUpdate = z;
        this.originalHasEmbeddedUpdate = z2;
        this.requestHeaders = requestHeaders;
        this.originalEmbeddedRequestHeaders = originalEmbeddedRequestHeaders;
        this.codeSigningCertificate = str2;
        this.codeSigningMetadata = map;
        this.codeSigningIncludeManifestResponseCertificateChain = z3;
        this.codeSigningAllowUnsignedManifests = z4;
        this.enableExpoUpdatesProtocolV0CompatibilityMode = z5;
        this.enableBsdiffPatchSupport = z6;
        this.disableAntiBrickingMeasures = z7;
        this.hasUpdatesOverride = z8;
        this.cachedOverrideMap = map2;
        this.codeSigningConfiguration$delegate = LazyKt.lazy(new Function0() { // from class: expo.modules.updates.UpdatesConfiguration$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return UpdatesConfiguration.codeSigningConfiguration_delegate$lambda$5(this.f$0);
            }
        });
    }

    public final String getScopeKey() {
        return this.scopeKey;
    }

    public final Uri getUpdateUrl() {
        return this.updateUrl;
    }

    public final Uri getOriginalEmbeddedUpdateUrl() {
        return this.originalEmbeddedUpdateUrl;
    }

    public final String getRuntimeVersionRaw() {
        return this.runtimeVersionRaw;
    }

    public final int getLaunchWaitMs() {
        return this.launchWaitMs;
    }

    public final CheckAutomaticallyConfiguration getCheckOnLaunch() {
        return this.checkOnLaunch;
    }

    public final boolean getHasEmbeddedUpdate() {
        return this.hasEmbeddedUpdate;
    }

    public final boolean getOriginalHasEmbeddedUpdate() {
        return this.originalHasEmbeddedUpdate;
    }

    public final Map getRequestHeaders() {
        return this.requestHeaders;
    }

    public final Map getOriginalEmbeddedRequestHeaders() {
        return this.originalEmbeddedRequestHeaders;
    }

    public final boolean getEnableExpoUpdatesProtocolV0CompatibilityMode() {
        return this.enableExpoUpdatesProtocolV0CompatibilityMode;
    }

    public final boolean getEnableBsdiffPatchSupport() {
        return this.enableBsdiffPatchSupport;
    }

    public final boolean getDisableAntiBrickingMeasures() {
        return this.disableAntiBrickingMeasures;
    }

    public final boolean getHasUpdatesOverride() {
        return this.hasUpdatesOverride;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class CheckAutomaticallyConfiguration {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ CheckAutomaticallyConfiguration[] $VALUES;
        public static final CheckAutomaticallyConfiguration NEVER = new NEVER("NEVER", 0);
        public static final CheckAutomaticallyConfiguration ERROR_RECOVERY_ONLY = new ERROR_RECOVERY_ONLY("ERROR_RECOVERY_ONLY", 1);
        public static final CheckAutomaticallyConfiguration WIFI_ONLY = new WIFI_ONLY("WIFI_ONLY", 2);
        public static final CheckAutomaticallyConfiguration ALWAYS = new ALWAYS("ALWAYS", 3);

        private static final /* synthetic */ CheckAutomaticallyConfiguration[] $values() {
            return new CheckAutomaticallyConfiguration[]{NEVER, ERROR_RECOVERY_ONLY, WIFI_ONLY, ALWAYS};
        }

        public /* synthetic */ CheckAutomaticallyConfiguration(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i);
        }

        public abstract String toJSString();

        static final class NEVER extends CheckAutomaticallyConfiguration {
            NEVER(String str, int i) {
                super(str, i, null);
            }

            @Override // expo.modules.updates.UpdatesConfiguration.CheckAutomaticallyConfiguration
            public String toJSString() {
                return "NEVER";
            }
        }

        private CheckAutomaticallyConfiguration(String str, int i) {
            super(str, i);
        }

        static {
            CheckAutomaticallyConfiguration[] checkAutomaticallyConfigurationArr$values = $values();
            $VALUES = checkAutomaticallyConfigurationArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(checkAutomaticallyConfigurationArr$values);
        }

        static final class ERROR_RECOVERY_ONLY extends CheckAutomaticallyConfiguration {
            ERROR_RECOVERY_ONLY(String str, int i) {
                super(str, i, null);
            }

            @Override // expo.modules.updates.UpdatesConfiguration.CheckAutomaticallyConfiguration
            public String toJSString() {
                return "ERROR_RECOVERY_ONLY";
            }
        }

        static final class WIFI_ONLY extends CheckAutomaticallyConfiguration {
            WIFI_ONLY(String str, int i) {
                super(str, i, null);
            }

            @Override // expo.modules.updates.UpdatesConfiguration.CheckAutomaticallyConfiguration
            public String toJSString() {
                return "WIFI_ONLY";
            }
        }

        static final class ALWAYS extends CheckAutomaticallyConfiguration {
            ALWAYS(String str, int i) {
                super(str, i, null);
            }

            @Override // expo.modules.updates.UpdatesConfiguration.CheckAutomaticallyConfiguration
            public String toJSString() {
                return "ALWAYS";
            }
        }

        public static CheckAutomaticallyConfiguration valueOf(String str) {
            return (CheckAutomaticallyConfiguration) Enum.valueOf(CheckAutomaticallyConfiguration.class, str);
        }

        public static CheckAutomaticallyConfiguration[] values() {
            return (CheckAutomaticallyConfiguration[]) $VALUES.clone();
        }
    }

    public UpdatesConfiguration(Context context, Map map) {
        this(context, map, Companion.getDisableAntiBrickingMeasures(context, map), context != null ? UpdatesConfigurationOverride.Companion.load$expo_updates_release(context) : null);
    }

    /* JADX WARN: Code duplicated, block: B:113:0x02d4  */
    /* JADX WARN: Code duplicated, block: B:126:0x0321  */
    /* JADX WARN: Code duplicated, block: B:128:0x0329  */
    /* JADX WARN: Code duplicated, block: B:129:0x032b  */
    /* JADX WARN: Code duplicated, block: B:134:0x0338  */
    /* JADX WARN: Code duplicated, block: B:135:0x033c  */
    /* JADX WARN: Code duplicated, block: B:137:0x0362 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:138:0x0364  */
    /* JADX WARN: Code duplicated, block: B:140:0x037c  */
    /* JADX WARN: Code duplicated, block: B:141:0x0380  */
    /* JADX WARN: Code duplicated, block: B:143:0x0390  */
    /* JADX WARN: Code duplicated, block: B:144:0x0395  */
    /* JADX WARN: Code duplicated, block: B:146:0x039f  */
    /* JADX WARN: Code duplicated, block: B:147:0x03aa  */
    /* JADX WARN: Code duplicated, block: B:149:0x03b4  */
    /* JADX WARN: Code duplicated, block: B:14:0x0053 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:150:0x03bf  */
    /* JADX WARN: Code duplicated, block: B:153:0x03c8  */
    /* JADX WARN: Code duplicated, block: B:158:0x03d6  */
    /* JADX WARN: Code duplicated, block: B:15:0x0055  */
    /* JADX WARN: Code duplicated, block: B:160:0x03de  */
    /* JADX WARN: Code duplicated, block: B:161:0x03e2  */
    /* JADX WARN: Code duplicated, block: B:165:0x03f0  */
    /* JADX WARN: Code duplicated, block: B:166:0x03f8  */
    /* JADX WARN: Code duplicated, block: B:168:0x041e  */
    /* JADX WARN: Code duplicated, block: B:170:0x0422  */
    /* JADX WARN: Code duplicated, block: B:173:0x043b  */
    /* JADX WARN: Code duplicated, block: B:175:0x044b  */
    /* JADX WARN: Code duplicated, block: B:176:0x0452  */
    /* JADX WARN: Code duplicated, block: B:178:0x045c  */
    /* JADX WARN: Code duplicated, block: B:179:0x0465  */
    /* JADX WARN: Code duplicated, block: B:17:0x006b  */
    /* JADX WARN: Code duplicated, block: B:181:0x046f  */
    /* JADX WARN: Code duplicated, block: B:182:0x047a  */
    /* JADX WARN: Code duplicated, block: B:183:0x0481  */
    /* JADX WARN: Code duplicated, block: B:185:0x0486  */
    /* JADX WARN: Code duplicated, block: B:186:0x048b  */
    /* JADX WARN: Code duplicated, block: B:188:0x048e  */
    /* JADX WARN: Code duplicated, block: B:18:0x006d  */
    /* JADX WARN: Code duplicated, block: B:190:0x0496  */
    /* JADX WARN: Code duplicated, block: B:191:0x0498  */
    /* JADX WARN: Code duplicated, block: B:195:0x04a4  */
    /* JADX WARN: Code duplicated, block: B:196:0x04ac  */
    /* JADX WARN: Code duplicated, block: B:198:0x04d2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:199:0x04d4  */
    /* JADX WARN: Code duplicated, block: B:202:0x04ed  */
    /* JADX WARN: Code duplicated, block: B:204:0x04fd  */
    /* JADX WARN: Code duplicated, block: B:205:0x0504  */
    /* JADX WARN: Code duplicated, block: B:207:0x050e  */
    /* JADX WARN: Code duplicated, block: B:208:0x0517  */
    /* JADX WARN: Code duplicated, block: B:20:0x007b  */
    /* JADX WARN: Code duplicated, block: B:210:0x0521  */
    /* JADX WARN: Code duplicated, block: B:211:0x052c  */
    /* JADX WARN: Code duplicated, block: B:212:0x0533  */
    /* JADX WARN: Code duplicated, block: B:214:0x0538  */
    /* JADX WARN: Code duplicated, block: B:215:0x053d  */
    /* JADX WARN: Code duplicated, block: B:217:0x0540  */
    /* JADX WARN: Code duplicated, block: B:219:0x0548  */
    /* JADX WARN: Code duplicated, block: B:220:0x054a  */
    /* JADX WARN: Code duplicated, block: B:224:0x0556  */
    /* JADX WARN: Code duplicated, block: B:225:0x055e  */
    /* JADX WARN: Code duplicated, block: B:227:0x0584 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:228:0x0586  */
    /* JADX WARN: Code duplicated, block: B:22:0x0081  */
    /* JADX WARN: Code duplicated, block: B:231:0x059f  */
    /* JADX WARN: Code duplicated, block: B:233:0x05af  */
    /* JADX WARN: Code duplicated, block: B:234:0x05b6  */
    /* JADX WARN: Code duplicated, block: B:236:0x05c0  */
    /* JADX WARN: Code duplicated, block: B:237:0x05c9  */
    /* JADX WARN: Code duplicated, block: B:239:0x05d3  */
    /* JADX WARN: Code duplicated, block: B:240:0x05de  */
    /* JADX WARN: Code duplicated, block: B:241:0x05e5  */
    /* JADX WARN: Code duplicated, block: B:243:0x05ea  */
    /* JADX WARN: Code duplicated, block: B:244:0x05ef  */
    /* JADX WARN: Code duplicated, block: B:246:0x05f2  */
    /* JADX WARN: Code duplicated, block: B:248:0x05fa  */
    /* JADX WARN: Code duplicated, block: B:249:0x05fc  */
    /* JADX WARN: Code duplicated, block: B:24:0x008b  */
    /* JADX WARN: Code duplicated, block: B:253:0x0608  */
    /* JADX WARN: Code duplicated, block: B:255:0x0610  */
    /* JADX WARN: Code duplicated, block: B:257:0x0636 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:258:0x0638  */
    /* JADX WARN: Code duplicated, block: B:25:0x0096  */
    /* JADX WARN: Code duplicated, block: B:261:0x0651  */
    /* JADX WARN: Code duplicated, block: B:263:0x065f  */
    /* JADX WARN: Code duplicated, block: B:264:0x0666  */
    /* JADX WARN: Code duplicated, block: B:266:0x0670  */
    /* JADX WARN: Code duplicated, block: B:267:0x0679  */
    /* JADX WARN: Code duplicated, block: B:269:0x0683  */
    /* JADX WARN: Code duplicated, block: B:270:0x068e  */
    /* JADX WARN: Code duplicated, block: B:272:0x0697  */
    /* JADX WARN: Code duplicated, block: B:274:0x069b  */
    /* JADX WARN: Code duplicated, block: B:275:0x06a1  */
    /* JADX WARN: Code duplicated, block: B:278:0x06a9  */
    /* JADX WARN: Code duplicated, block: B:27:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:280:0x06c9  */
    /* JADX WARN: Code duplicated, block: B:28:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:41:0x0117 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x0119  */
    /* JADX WARN: Code duplicated, block: B:45:0x0132  */
    /* JADX WARN: Code duplicated, block: B:47:0x0144  */
    /* JADX WARN: Code duplicated, block: B:48:0x014b  */
    /* JADX WARN: Code duplicated, block: B:50:0x0155  */
    /* JADX WARN: Code duplicated, block: B:51:0x0160  */
    /* JADX WARN: Code duplicated, block: B:53:0x016a  */
    /* JADX WARN: Code duplicated, block: B:54:0x0173  */
    /* JADX WARN: Code duplicated, block: B:55:0x017a  */
    /* JADX WARN: Code duplicated, block: B:57:0x017f  */
    /* JADX WARN: Code duplicated, block: B:58:0x0184  */
    /* JADX WARN: Code duplicated, block: B:75:0x01ea A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:76:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:78:0x0204  */
    /* JADX WARN: Code duplicated, block: B:79:0x0208  */
    /* JADX WARN: Code duplicated, block: B:81:0x0218  */
    /* JADX WARN: Code duplicated, block: B:82:0x021d  */
    /* JADX WARN: Code duplicated, block: B:84:0x0227  */
    /* JADX WARN: Code duplicated, block: B:85:0x0232  */
    /* JADX WARN: Code duplicated, block: B:87:0x023c  */
    /* JADX WARN: Code duplicated, block: B:88:0x0247  */
    /* JADX WARN: Code duplicated, block: B:91:0x0250  */
    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Instruction removed from duplicated block: B:135:0x033c, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:166:0x03f8, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:196:0x04ac, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:225:0x055e, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:255:0x0610, please report this as an issue */
    public UpdatesConfiguration(Context context, Map map, boolean z, UpdatesConfigurationOverride updatesConfigurationOverride) throws Exception {
        String str;
        Bundle bundle;
        KClass orCreateKotlinClass;
        String string;
        Class cls;
        Integer numValueOf;
        int iIntValue;
        Bundle bundle2;
        KClass orCreateKotlinClass2;
        Class cls2;
        String string2;
        CheckAutomaticallyConfiguration checkAutomaticallyConfigurationValueOf;
        Bundle bundle3;
        KClass orCreateKotlinClass3;
        String string3;
        String str2;
        String string4;
        Map mapFromJSONString;
        Bundle bundle4;
        KClass orCreateKotlinClass4;
        Class<Boolean> cls3;
        Map map2;
        Boolean boolValueOf;
        boolean zBooleanValue;
        Bundle bundle5;
        KClass orCreateKotlinClass5;
        boolean z2;
        Boolean boolValueOf2;
        boolean zBooleanValue2;
        Bundle bundle6;
        KClass orCreateKotlinClass6;
        boolean z3;
        Boolean boolValueOf3;
        boolean zBooleanValue3;
        Bundle bundle7;
        KClass orCreateKotlinClass7;
        Boolean bool;
        boolean z4;
        boolean zBooleanValue4;
        Bundle bundle8;
        KClass orCreateKotlinClass8;
        Boolean boolValueOf4;
        boolean z5;
        Object obj;
        Boolean bool2;
        Object obj2;
        Boolean bool3;
        Object obj3;
        Boolean bool4;
        Object obj4;
        Boolean bool5;
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        Object obj9;
        Class cls4 = Integer.TYPE;
        Class cls5 = Boolean.TYPE;
        if (map != null) {
            if (map.containsKey("scopeKey")) {
                obj9 = map.get("scopeKey");
                if (!(obj9 instanceof String)) {
                    Intrinsics.checkNotNull(obj9);
                    throw new AssertionError("UpdatesConfiguration failed to initialize: bad value of type " + obj9.getClass().getSimpleName() + " provided for key scopeKey");
                }
            } else {
                obj9 = null;
            }
            str = (String) obj9;
            if (str == null) {
                if (context != null) {
                    bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                    if (bundle.containsKey("expo.modules.updates.EXPO_SCOPE_KEY")) {
                        orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                            string = bundle.getString("expo.modules.updates.EXPO_SCOPE_KEY");
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls5))) {
                            string = (String) Boolean.valueOf(bundle.getBoolean("expo.modules.updates.EXPO_SCOPE_KEY"));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls4))) {
                            string = (String) Integer.valueOf(bundle.getInt("expo.modules.updates.EXPO_SCOPE_KEY"));
                        } else {
                            string = (String) bundle.get("expo.modules.updates.EXPO_SCOPE_KEY");
                        }
                        str = string;
                    } else {
                        str = null;
                    }
                } else {
                    str = null;
                }
            }
        } else if (context != null) {
            bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle.containsKey("expo.modules.updates.EXPO_SCOPE_KEY")) {
                str = null;
            } else {
                orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                    string = bundle.getString("expo.modules.updates.EXPO_SCOPE_KEY");
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls5))) {
                    string = (String) Boolean.valueOf(bundle.getBoolean("expo.modules.updates.EXPO_SCOPE_KEY"));
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls4))) {
                    string = (String) Integer.valueOf(bundle.getInt("expo.modules.updates.EXPO_SCOPE_KEY"));
                } else {
                    string = (String) bundle.get("expo.modules.updates.EXPO_SCOPE_KEY");
                }
                str = string;
            }
        } else {
            str = null;
        }
        Companion companion = Companion;
        Uri updateUrl = companion.getUpdateUrl(context, map, z, updatesConfigurationOverride);
        Intrinsics.checkNotNull(updateUrl);
        String strMaybeGetDefaultScopeKey = UpdatesConfigurationKt.maybeGetDefaultScopeKey(str, updateUrl);
        Uri updateUrl2 = companion.getUpdateUrl(context, map, z, updatesConfigurationOverride);
        Intrinsics.checkNotNull(updateUrl2);
        Uri originalEmbeddedUpdateUrl = companion.getOriginalEmbeddedUpdateUrl(context, map);
        Intrinsics.checkNotNull(originalEmbeddedUpdateUrl);
        String runtimeVersion = companion.getRuntimeVersion(context, map);
        if (map == null) {
            if (context != null) {
                bundle2 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                if (bundle2.containsKey("expo.modules.updates.EXPO_UPDATES_LAUNCH_WAIT_MS")) {
                    orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Integer.class);
                    cls = cls4;
                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                        numValueOf = (Integer) bundle2.getString("expo.modules.updates.EXPO_UPDATES_LAUNCH_WAIT_MS");
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls5))) {
                        numValueOf = (Integer) Boolean.valueOf(bundle2.getBoolean("expo.modules.updates.EXPO_UPDATES_LAUNCH_WAIT_MS"));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls))) {
                        numValueOf = Integer.valueOf(bundle2.getInt("expo.modules.updates.EXPO_UPDATES_LAUNCH_WAIT_MS"));
                    } else {
                        numValueOf = (Integer) bundle2.get("expo.modules.updates.EXPO_UPDATES_LAUNCH_WAIT_MS");
                    }
                } else {
                    cls = cls4;
                    numValueOf = null;
                }
            } else {
                cls = cls4;
                numValueOf = null;
            }
            if (numValueOf != null) {
                iIntValue = numValueOf.intValue();
            } else {
                iIntValue = 0;
            }
        } else {
            if (map.containsKey("launchWaitMs")) {
                obj8 = map.get("launchWaitMs");
                if (!(obj8 instanceof Integer)) {
                    Intrinsics.checkNotNull(obj8);
                    throw new AssertionError("UpdatesConfiguration failed to initialize: bad value of type " + obj8.getClass().getSimpleName() + " provided for key launchWaitMs");
                }
            } else {
                obj8 = null;
            }
            Integer num = (Integer) obj8;
            if (num != null) {
                iIntValue = num.intValue();
                cls = cls4;
            } else {
                if (context != null) {
                    bundle2 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                    if (bundle2.containsKey("expo.modules.updates.EXPO_UPDATES_LAUNCH_WAIT_MS")) {
                        cls = cls4;
                        numValueOf = null;
                    } else {
                        orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Integer.class);
                        cls = cls4;
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                            numValueOf = (Integer) bundle2.getString("expo.modules.updates.EXPO_UPDATES_LAUNCH_WAIT_MS");
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls5))) {
                            numValueOf = (Integer) Boolean.valueOf(bundle2.getBoolean("expo.modules.updates.EXPO_UPDATES_LAUNCH_WAIT_MS"));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls))) {
                            numValueOf = Integer.valueOf(bundle2.getInt("expo.modules.updates.EXPO_UPDATES_LAUNCH_WAIT_MS"));
                        } else {
                            numValueOf = (Integer) bundle2.get("expo.modules.updates.EXPO_UPDATES_LAUNCH_WAIT_MS");
                        }
                    }
                } else {
                    cls = cls4;
                    numValueOf = null;
                }
                if (numValueOf != null) {
                    iIntValue = numValueOf.intValue();
                } else {
                    iIntValue = 0;
                }
            }
        }
        if (map == null) {
            try {
                if (context != null) {
                    bundle3 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                    if (bundle3.containsKey("expo.modules.updates.EXPO_UPDATES_CHECK_ON_LAUNCH")) {
                        orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(String.class);
                        cls2 = cls5;
                        if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                            string2 = bundle3.getString("expo.modules.updates.EXPO_UPDATES_CHECK_ON_LAUNCH");
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(cls2))) {
                            string2 = (String) Boolean.valueOf(bundle3.getBoolean("expo.modules.updates.EXPO_UPDATES_CHECK_ON_LAUNCH"));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(cls))) {
                            string2 = (String) Integer.valueOf(bundle3.getInt("expo.modules.updates.EXPO_UPDATES_CHECK_ON_LAUNCH"));
                        } else {
                            string2 = (String) bundle3.get("expo.modules.updates.EXPO_UPDATES_CHECK_ON_LAUNCH");
                        }
                    } else {
                        cls2 = cls5;
                        string2 = null;
                    }
                    if (string2 == null) {
                    }
                    checkAutomaticallyConfigurationValueOf = CheckAutomaticallyConfiguration.valueOf(string2);
                } else {
                    cls2 = cls5;
                }
                checkAutomaticallyConfigurationValueOf = CheckAutomaticallyConfiguration.valueOf(string2);
            } catch (IllegalArgumentException unused) {
                checkAutomaticallyConfigurationValueOf = CheckAutomaticallyConfiguration.ALWAYS;
            }
            string2 = "ALWAYS";
        } else {
            if (map.containsKey("checkOnLaunch")) {
                obj7 = map.get("checkOnLaunch");
                if (!(obj7 instanceof String)) {
                    Intrinsics.checkNotNull(obj7);
                    throw new AssertionError("UpdatesConfiguration failed to initialize: bad value of type " + obj7.getClass().getSimpleName() + " provided for key checkOnLaunch");
                }
            } else {
                obj7 = null;
            }
            String str3 = (String) obj7;
            if (str3 != null) {
                try {
                    checkAutomaticallyConfigurationValueOf = CheckAutomaticallyConfiguration.valueOf(str3);
                    if (checkAutomaticallyConfigurationValueOf == null) {
                        if (context != null) {
                            bundle3 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                            if (bundle3.containsKey("expo.modules.updates.EXPO_UPDATES_CHECK_ON_LAUNCH")) {
                                cls2 = cls5;
                                string2 = null;
                            } else {
                                orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(String.class);
                                cls2 = cls5;
                                if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                                    string2 = bundle3.getString("expo.modules.updates.EXPO_UPDATES_CHECK_ON_LAUNCH");
                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(cls2))) {
                                    string2 = (String) Boolean.valueOf(bundle3.getBoolean("expo.modules.updates.EXPO_UPDATES_CHECK_ON_LAUNCH"));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(cls))) {
                                    string2 = (String) Integer.valueOf(bundle3.getInt("expo.modules.updates.EXPO_UPDATES_CHECK_ON_LAUNCH"));
                                } else {
                                    string2 = (String) bundle3.get("expo.modules.updates.EXPO_UPDATES_CHECK_ON_LAUNCH");
                                }
                            }
                            if (string2 == null) {
                            }
                            checkAutomaticallyConfigurationValueOf = CheckAutomaticallyConfiguration.valueOf(string2);
                        } else {
                            cls2 = cls5;
                        }
                        string2 = "ALWAYS";
                        checkAutomaticallyConfigurationValueOf = CheckAutomaticallyConfiguration.valueOf(string2);
                    } else {
                        cls2 = cls5;
                    }
                } catch (IllegalArgumentException unused2) {
                    throw new AssertionError("UpdatesConfiguration failed to initialize: invalid value " + str3 + " provided for checkOnLaunch");
                }
            } else {
                if (context != null) {
                    bundle3 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                    if (bundle3.containsKey("expo.modules.updates.EXPO_UPDATES_CHECK_ON_LAUNCH")) {
                        cls2 = cls5;
                        string2 = null;
                    } else {
                        orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(String.class);
                        cls2 = cls5;
                        if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                            string2 = bundle3.getString("expo.modules.updates.EXPO_UPDATES_CHECK_ON_LAUNCH");
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(cls2))) {
                            string2 = (String) Boolean.valueOf(bundle3.getBoolean("expo.modules.updates.EXPO_UPDATES_CHECK_ON_LAUNCH"));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(cls))) {
                            string2 = (String) Integer.valueOf(bundle3.getInt("expo.modules.updates.EXPO_UPDATES_CHECK_ON_LAUNCH"));
                        } else {
                            string2 = (String) bundle3.get("expo.modules.updates.EXPO_UPDATES_CHECK_ON_LAUNCH");
                        }
                    }
                    if (string2 == null) {
                    }
                    checkAutomaticallyConfigurationValueOf = CheckAutomaticallyConfiguration.valueOf(string2);
                } else {
                    cls2 = cls5;
                }
                string2 = "ALWAYS";
                checkAutomaticallyConfigurationValueOf = CheckAutomaticallyConfiguration.valueOf(string2);
            }
        }
        Companion companion2 = Companion;
        boolean hasEmbeddedUpdate = companion2.getHasEmbeddedUpdate(context, map, z, updatesConfigurationOverride);
        boolean originalHasEmbeddedUpdate = companion2.getOriginalHasEmbeddedUpdate(context, map);
        Map requestHeaders = companion2.getRequestHeaders(context, map, z, updatesConfigurationOverride);
        Map originalEmbeddedRequestHeaders = companion2.getOriginalEmbeddedRequestHeaders(context, map);
        if (map != null) {
            if (map.containsKey("codeSigningCertificate")) {
                obj6 = map.get("codeSigningCertificate");
                if (!(obj6 instanceof String)) {
                    Intrinsics.checkNotNull(obj6);
                    throw new AssertionError("UpdatesConfiguration failed to initialize: bad value of type " + obj6.getClass().getSimpleName() + " provided for key codeSigningCertificate");
                }
            } else {
                obj6 = null;
            }
            string3 = (String) obj6;
            if (string3 == null) {
            }
            if (map == null) {
                if (context != null) {
                    bundle4 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                    if (bundle4.containsKey("expo.modules.updates.CODE_SIGNING_METADATA")) {
                        orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
                        str2 = string3;
                        if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                            string4 = bundle4.getString("expo.modules.updates.CODE_SIGNING_METADATA");
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls2))) {
                            string4 = (String) Boolean.valueOf(bundle4.getBoolean("expo.modules.updates.CODE_SIGNING_METADATA"));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls))) {
                            string4 = (String) Integer.valueOf(bundle4.getInt("expo.modules.updates.CODE_SIGNING_METADATA"));
                        } else {
                            string4 = (String) bundle4.get("expo.modules.updates.CODE_SIGNING_METADATA");
                        }
                    } else {
                        str2 = string3;
                        string4 = null;
                    }
                    if (string4 == null) {
                    }
                    mapFromJSONString = UpdatesUtils.INSTANCE.getMapFromJSONString(string4);
                } else {
                    str2 = string3;
                }
                string4 = "{}";
                mapFromJSONString = UpdatesUtils.INSTANCE.getMapFromJSONString(string4);
            } else {
                if (map.containsKey("codeSigningMetadata")) {
                    obj5 = map.get("codeSigningMetadata");
                    if (!(obj5 instanceof Map)) {
                        Intrinsics.checkNotNull(obj5);
                        throw new AssertionError("UpdatesConfiguration failed to initialize: bad value of type " + obj5.getClass().getSimpleName() + " provided for key codeSigningMetadata");
                    }
                } else {
                    obj5 = null;
                }
                mapFromJSONString = (Map) obj5;
                if (mapFromJSONString == null) {
                    if (context != null) {
                        bundle4 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                        if (bundle4.containsKey("expo.modules.updates.CODE_SIGNING_METADATA")) {
                            str2 = string3;
                            string4 = null;
                        } else {
                            orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
                            str2 = string3;
                            if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                                string4 = bundle4.getString("expo.modules.updates.CODE_SIGNING_METADATA");
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls2))) {
                                string4 = (String) Boolean.valueOf(bundle4.getBoolean("expo.modules.updates.CODE_SIGNING_METADATA"));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls))) {
                                string4 = (String) Integer.valueOf(bundle4.getInt("expo.modules.updates.CODE_SIGNING_METADATA"));
                            } else {
                                string4 = (String) bundle4.get("expo.modules.updates.CODE_SIGNING_METADATA");
                            }
                        }
                        if (string4 == null) {
                        }
                        mapFromJSONString = UpdatesUtils.INSTANCE.getMapFromJSONString(string4);
                    } else {
                        str2 = string3;
                    }
                    string4 = "{}";
                    mapFromJSONString = UpdatesUtils.INSTANCE.getMapFromJSONString(string4);
                } else {
                    str2 = string3;
                }
            }
            cls3 = Boolean.class;
            if (map != null) {
                if (map.containsKey("codeSigningIncludeManifestResponseCertificateChain")) {
                    obj4 = map.get("codeSigningIncludeManifestResponseCertificateChain");
                    if (!(obj4 instanceof Boolean)) {
                        Intrinsics.checkNotNull(obj4);
                        throw new AssertionError("UpdatesConfiguration failed to initialize: bad value of type " + obj4.getClass().getSimpleName() + " provided for key codeSigningIncludeManifestResponseCertificateChain");
                    }
                } else {
                    obj4 = null;
                }
                bool5 = (Boolean) obj4;
                if (bool5 != null) {
                    zBooleanValue = bool5.booleanValue();
                    map2 = mapFromJSONString;
                }
                if (map == null) {
                    if (context != null) {
                        bundle6 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                        if (bundle6.containsKey("expo.modules.updates.CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS")) {
                            orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(cls3);
                            z2 = zBooleanValue;
                            if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(String.class))) {
                                boolValueOf2 = (Boolean) bundle6.getString("expo.modules.updates.CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS");
                            } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(cls2))) {
                                boolValueOf2 = Boolean.valueOf(bundle6.getBoolean("expo.modules.updates.CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS"));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(cls))) {
                                boolValueOf2 = (Boolean) Integer.valueOf(bundle6.getInt("expo.modules.updates.CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS"));
                            } else {
                                boolValueOf2 = (Boolean) bundle6.get("expo.modules.updates.CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS");
                            }
                        } else {
                            z2 = zBooleanValue;
                            boolValueOf2 = null;
                        }
                    } else {
                        z2 = zBooleanValue;
                        boolValueOf2 = null;
                    }
                    if (boolValueOf2 != null) {
                        zBooleanValue2 = boolValueOf2.booleanValue();
                    } else {
                        zBooleanValue2 = false;
                    }
                } else {
                    if (map.containsKey("codeSigningAllowUnsignedManifests")) {
                        obj3 = map.get("codeSigningAllowUnsignedManifests");
                        if (!(obj3 instanceof Boolean)) {
                            Intrinsics.checkNotNull(obj3);
                            throw new AssertionError("UpdatesConfiguration failed to initialize: bad value of type " + obj3.getClass().getSimpleName() + " provided for key codeSigningAllowUnsignedManifests");
                        }
                    } else {
                        obj3 = null;
                    }
                    bool4 = (Boolean) obj3;
                    if (bool4 != null) {
                        zBooleanValue2 = bool4.booleanValue();
                        z2 = zBooleanValue;
                    } else {
                        if (context != null) {
                            bundle6 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                            if (bundle6.containsKey("expo.modules.updates.CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS")) {
                                z2 = zBooleanValue;
                                boolValueOf2 = null;
                            } else {
                                orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(cls3);
                                z2 = zBooleanValue;
                                if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(String.class))) {
                                    boolValueOf2 = (Boolean) bundle6.getString("expo.modules.updates.CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS");
                                } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(cls2))) {
                                    boolValueOf2 = Boolean.valueOf(bundle6.getBoolean("expo.modules.updates.CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS"));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(cls))) {
                                    boolValueOf2 = (Boolean) Integer.valueOf(bundle6.getInt("expo.modules.updates.CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS"));
                                } else {
                                    boolValueOf2 = (Boolean) bundle6.get("expo.modules.updates.CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS");
                                }
                            }
                        } else {
                            z2 = zBooleanValue;
                            boolValueOf2 = null;
                        }
                        if (boolValueOf2 != null) {
                            zBooleanValue2 = boolValueOf2.booleanValue();
                        } else {
                            zBooleanValue2 = false;
                        }
                    }
                }
                if (map == null) {
                    if (context != null) {
                        bundle7 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                        if (bundle7.containsKey("expo.modules.updates.ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE")) {
                            orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(cls3);
                            z3 = zBooleanValue2;
                            if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(String.class))) {
                                boolValueOf3 = (Boolean) bundle7.getString("expo.modules.updates.ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE");
                            } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(cls2))) {
                                boolValueOf3 = Boolean.valueOf(bundle7.getBoolean("expo.modules.updates.ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE"));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(cls))) {
                                boolValueOf3 = (Boolean) Integer.valueOf(bundle7.getInt("expo.modules.updates.ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE"));
                            } else {
                                boolValueOf3 = (Boolean) bundle7.get("expo.modules.updates.ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE");
                            }
                        } else {
                            z3 = zBooleanValue2;
                            boolValueOf3 = null;
                        }
                    } else {
                        z3 = zBooleanValue2;
                        boolValueOf3 = null;
                    }
                    if (boolValueOf3 != null) {
                        zBooleanValue3 = boolValueOf3.booleanValue();
                    } else {
                        zBooleanValue3 = false;
                    }
                } else {
                    if (map.containsKey("enableExpoUpdatesProtocolCompatibilityMode")) {
                        obj2 = map.get("enableExpoUpdatesProtocolCompatibilityMode");
                        if (!(obj2 instanceof Boolean)) {
                            Intrinsics.checkNotNull(obj2);
                            throw new AssertionError("UpdatesConfiguration failed to initialize: bad value of type " + obj2.getClass().getSimpleName() + " provided for key enableExpoUpdatesProtocolCompatibilityMode");
                        }
                    } else {
                        obj2 = null;
                    }
                    bool3 = (Boolean) obj2;
                    if (bool3 != null) {
                        zBooleanValue3 = bool3.booleanValue();
                        z3 = zBooleanValue2;
                    } else {
                        if (context != null) {
                            bundle7 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                            if (bundle7.containsKey("expo.modules.updates.ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE")) {
                                z3 = zBooleanValue2;
                                boolValueOf3 = null;
                            } else {
                                orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(cls3);
                                z3 = zBooleanValue2;
                                if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(String.class))) {
                                    boolValueOf3 = (Boolean) bundle7.getString("expo.modules.updates.ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE");
                                } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(cls2))) {
                                    boolValueOf3 = Boolean.valueOf(bundle7.getBoolean("expo.modules.updates.ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE"));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(cls))) {
                                    boolValueOf3 = (Boolean) Integer.valueOf(bundle7.getInt("expo.modules.updates.ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE"));
                                } else {
                                    boolValueOf3 = (Boolean) bundle7.get("expo.modules.updates.ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE");
                                }
                            }
                        } else {
                            z3 = zBooleanValue2;
                            boolValueOf3 = null;
                        }
                        if (boolValueOf3 != null) {
                            zBooleanValue3 = boolValueOf3.booleanValue();
                        } else {
                            zBooleanValue3 = false;
                        }
                    }
                }
                if (map == null) {
                    if (context != null) {
                        bundle8 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                        if (bundle8.containsKey("expo.modules.updates.ENABLE_BSDIFF_PATCH_SUPPORT")) {
                            orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(cls3);
                            if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(String.class))) {
                                boolValueOf4 = (Boolean) bundle8.getString("expo.modules.updates.ENABLE_BSDIFF_PATCH_SUPPORT");
                            } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(cls2))) {
                                boolValueOf4 = Boolean.valueOf(bundle8.getBoolean("expo.modules.updates.ENABLE_BSDIFF_PATCH_SUPPORT"));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(cls))) {
                                boolValueOf4 = (Boolean) Integer.valueOf(bundle8.getInt("expo.modules.updates.ENABLE_BSDIFF_PATCH_SUPPORT"));
                            } else {
                                boolValueOf4 = (Boolean) bundle8.get("expo.modules.updates.ENABLE_BSDIFF_PATCH_SUPPORT");
                            }
                            bool = boolValueOf4;
                        } else {
                            bool = null;
                        }
                    } else {
                        bool = null;
                    }
                    if (bool != null) {
                        zBooleanValue4 = bool.booleanValue();
                        z4 = zBooleanValue4;
                    } else {
                        z4 = false;
                    }
                } else {
                    if (map.containsKey("enableBsdiffPatchSupport")) {
                        obj = map.get("enableBsdiffPatchSupport");
                        if (!(obj instanceof Boolean)) {
                            Intrinsics.checkNotNull(obj);
                            throw new AssertionError("UpdatesConfiguration failed to initialize: bad value of type " + obj.getClass().getSimpleName() + " provided for key enableBsdiffPatchSupport");
                        }
                    } else {
                        obj = null;
                    }
                    bool2 = (Boolean) obj;
                    if (bool2 != null) {
                        zBooleanValue4 = bool2.booleanValue();
                    } else {
                        if (context != null) {
                            bundle8 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                            if (bundle8.containsKey("expo.modules.updates.ENABLE_BSDIFF_PATCH_SUPPORT")) {
                                bool = null;
                            } else {
                                orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(cls3);
                                if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(String.class))) {
                                    boolValueOf4 = (Boolean) bundle8.getString("expo.modules.updates.ENABLE_BSDIFF_PATCH_SUPPORT");
                                } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(cls2))) {
                                    boolValueOf4 = Boolean.valueOf(bundle8.getBoolean("expo.modules.updates.ENABLE_BSDIFF_PATCH_SUPPORT"));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(cls))) {
                                    boolValueOf4 = (Boolean) Integer.valueOf(bundle8.getInt("expo.modules.updates.ENABLE_BSDIFF_PATCH_SUPPORT"));
                                } else {
                                    boolValueOf4 = (Boolean) bundle8.get("expo.modules.updates.ENABLE_BSDIFF_PATCH_SUPPORT");
                                }
                                bool = boolValueOf4;
                            }
                        } else {
                            bool = null;
                        }
                        if (bool != null) {
                            zBooleanValue4 = bool.booleanValue();
                        } else {
                            z4 = false;
                        }
                    }
                    z4 = zBooleanValue4;
                }
                boolean disableAntiBrickingMeasures = companion2.getDisableAntiBrickingMeasures(context, map);
                if (updatesConfigurationOverride != null) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                this(strMaybeGetDefaultScopeKey, updateUrl2, originalEmbeddedUpdateUrl, runtimeVersion, iIntValue, checkAutomaticallyConfigurationValueOf, hasEmbeddedUpdate, originalHasEmbeddedUpdate, requestHeaders, originalEmbeddedRequestHeaders, str2, map2, z2, z3, zBooleanValue3, z4, disableAntiBrickingMeasures, z5, map);
            }
            cls3 = cls3;
            if (context != null) {
                bundle5 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                if (bundle5.containsKey("expo.modules.updates.CODE_SIGNING_INCLUDE_MANIFEST_RESPONSE_CERTIFICATE_CHAIN")) {
                    orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(cls3);
                    map2 = mapFromJSONString;
                    if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(String.class))) {
                        boolValueOf = (Boolean) bundle5.getString("expo.modules.updates.CODE_SIGNING_INCLUDE_MANIFEST_RESPONSE_CERTIFICATE_CHAIN");
                    } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(cls2))) {
                        boolValueOf = Boolean.valueOf(bundle5.getBoolean("expo.modules.updates.CODE_SIGNING_INCLUDE_MANIFEST_RESPONSE_CERTIFICATE_CHAIN"));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(cls))) {
                        boolValueOf = (Boolean) Integer.valueOf(bundle5.getInt("expo.modules.updates.CODE_SIGNING_INCLUDE_MANIFEST_RESPONSE_CERTIFICATE_CHAIN"));
                    } else {
                        boolValueOf = (Boolean) bundle5.get("expo.modules.updates.CODE_SIGNING_INCLUDE_MANIFEST_RESPONSE_CERTIFICATE_CHAIN");
                    }
                } else {
                    map2 = mapFromJSONString;
                    boolValueOf = null;
                }
            } else {
                map2 = mapFromJSONString;
                boolValueOf = null;
            }
            if (boolValueOf != null) {
                zBooleanValue = boolValueOf.booleanValue();
            } else {
                zBooleanValue = false;
            }
            if (map == null) {
                if (context != null) {
                    bundle6 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                    if (bundle6.containsKey("expo.modules.updates.CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS")) {
                        z2 = zBooleanValue;
                        boolValueOf2 = null;
                    } else {
                        orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(cls3);
                        z2 = zBooleanValue;
                        if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(String.class))) {
                            boolValueOf2 = (Boolean) bundle6.getString("expo.modules.updates.CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS");
                        } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(cls2))) {
                            boolValueOf2 = Boolean.valueOf(bundle6.getBoolean("expo.modules.updates.CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS"));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(cls))) {
                            boolValueOf2 = (Boolean) Integer.valueOf(bundle6.getInt("expo.modules.updates.CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS"));
                        } else {
                            boolValueOf2 = (Boolean) bundle6.get("expo.modules.updates.CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS");
                        }
                    }
                } else {
                    z2 = zBooleanValue;
                    boolValueOf2 = null;
                }
                if (boolValueOf2 != null) {
                    zBooleanValue2 = boolValueOf2.booleanValue();
                } else {
                    zBooleanValue2 = false;
                }
            } else {
                if (map.containsKey("codeSigningAllowUnsignedManifests")) {
                    obj3 = null;
                } else {
                    obj3 = map.get("codeSigningAllowUnsignedManifests");
                    if (!(obj3 instanceof Boolean)) {
                        Intrinsics.checkNotNull(obj3);
                        throw new AssertionError("UpdatesConfiguration failed to initialize: bad value of type " + obj3.getClass().getSimpleName() + " provided for key codeSigningAllowUnsignedManifests");
                    }
                }
                bool4 = (Boolean) obj3;
                if (bool4 != null) {
                    zBooleanValue2 = bool4.booleanValue();
                    z2 = zBooleanValue;
                } else {
                    if (context != null) {
                        bundle6 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                        if (bundle6.containsKey("expo.modules.updates.CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS")) {
                            z2 = zBooleanValue;
                            boolValueOf2 = null;
                        } else {
                            orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(cls3);
                            z2 = zBooleanValue;
                            if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(String.class))) {
                                boolValueOf2 = (Boolean) bundle6.getString("expo.modules.updates.CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS");
                            } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(cls2))) {
                                boolValueOf2 = Boolean.valueOf(bundle6.getBoolean("expo.modules.updates.CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS"));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(cls))) {
                                boolValueOf2 = (Boolean) Integer.valueOf(bundle6.getInt("expo.modules.updates.CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS"));
                            } else {
                                boolValueOf2 = (Boolean) bundle6.get("expo.modules.updates.CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS");
                            }
                        }
                    } else {
                        z2 = zBooleanValue;
                        boolValueOf2 = null;
                    }
                    if (boolValueOf2 != null) {
                        zBooleanValue2 = boolValueOf2.booleanValue();
                    } else {
                        zBooleanValue2 = false;
                    }
                }
            }
            if (map == null) {
                if (context != null) {
                    bundle7 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                    if (bundle7.containsKey("expo.modules.updates.ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE")) {
                        z3 = zBooleanValue2;
                        boolValueOf3 = null;
                    } else {
                        orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(cls3);
                        z3 = zBooleanValue2;
                        if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(String.class))) {
                            boolValueOf3 = (Boolean) bundle7.getString("expo.modules.updates.ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE");
                        } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(cls2))) {
                            boolValueOf3 = Boolean.valueOf(bundle7.getBoolean("expo.modules.updates.ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE"));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(cls))) {
                            boolValueOf3 = (Boolean) Integer.valueOf(bundle7.getInt("expo.modules.updates.ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE"));
                        } else {
                            boolValueOf3 = (Boolean) bundle7.get("expo.modules.updates.ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE");
                        }
                    }
                } else {
                    z3 = zBooleanValue2;
                    boolValueOf3 = null;
                }
                if (boolValueOf3 != null) {
                    zBooleanValue3 = boolValueOf3.booleanValue();
                } else {
                    zBooleanValue3 = false;
                }
            } else {
                if (map.containsKey("enableExpoUpdatesProtocolCompatibilityMode")) {
                    obj2 = null;
                } else {
                    obj2 = map.get("enableExpoUpdatesProtocolCompatibilityMode");
                    if (!(obj2 instanceof Boolean)) {
                        Intrinsics.checkNotNull(obj2);
                        throw new AssertionError("UpdatesConfiguration failed to initialize: bad value of type " + obj2.getClass().getSimpleName() + " provided for key enableExpoUpdatesProtocolCompatibilityMode");
                    }
                }
                bool3 = (Boolean) obj2;
                if (bool3 != null) {
                    zBooleanValue3 = bool3.booleanValue();
                    z3 = zBooleanValue2;
                } else {
                    if (context != null) {
                        bundle7 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                        if (bundle7.containsKey("expo.modules.updates.ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE")) {
                            z3 = zBooleanValue2;
                            boolValueOf3 = null;
                        } else {
                            orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(cls3);
                            z3 = zBooleanValue2;
                            if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(String.class))) {
                                boolValueOf3 = (Boolean) bundle7.getString("expo.modules.updates.ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE");
                            } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(cls2))) {
                                boolValueOf3 = Boolean.valueOf(bundle7.getBoolean("expo.modules.updates.ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE"));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(cls))) {
                                boolValueOf3 = (Boolean) Integer.valueOf(bundle7.getInt("expo.modules.updates.ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE"));
                            } else {
                                boolValueOf3 = (Boolean) bundle7.get("expo.modules.updates.ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE");
                            }
                        }
                    } else {
                        z3 = zBooleanValue2;
                        boolValueOf3 = null;
                    }
                    if (boolValueOf3 != null) {
                        zBooleanValue3 = boolValueOf3.booleanValue();
                    } else {
                        zBooleanValue3 = false;
                    }
                }
            }
            if (map == null) {
                if (context != null) {
                    bundle8 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                    if (bundle8.containsKey("expo.modules.updates.ENABLE_BSDIFF_PATCH_SUPPORT")) {
                        bool = null;
                    } else {
                        orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(cls3);
                        if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(String.class))) {
                            boolValueOf4 = (Boolean) bundle8.getString("expo.modules.updates.ENABLE_BSDIFF_PATCH_SUPPORT");
                        } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(cls2))) {
                            boolValueOf4 = Boolean.valueOf(bundle8.getBoolean("expo.modules.updates.ENABLE_BSDIFF_PATCH_SUPPORT"));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(cls))) {
                            boolValueOf4 = (Boolean) Integer.valueOf(bundle8.getInt("expo.modules.updates.ENABLE_BSDIFF_PATCH_SUPPORT"));
                        } else {
                            boolValueOf4 = (Boolean) bundle8.get("expo.modules.updates.ENABLE_BSDIFF_PATCH_SUPPORT");
                        }
                        bool = boolValueOf4;
                    }
                } else {
                    bool = null;
                }
                if (bool != null) {
                    zBooleanValue4 = bool.booleanValue();
                    z4 = zBooleanValue4;
                } else {
                    z4 = false;
                }
            } else {
                if (map.containsKey("enableBsdiffPatchSupport")) {
                    obj = null;
                } else {
                    obj = map.get("enableBsdiffPatchSupport");
                    if (!(obj instanceof Boolean)) {
                        Intrinsics.checkNotNull(obj);
                        throw new AssertionError("UpdatesConfiguration failed to initialize: bad value of type " + obj.getClass().getSimpleName() + " provided for key enableBsdiffPatchSupport");
                    }
                }
                bool2 = (Boolean) obj;
                if (bool2 != null) {
                    zBooleanValue4 = bool2.booleanValue();
                } else {
                    if (context != null) {
                        bundle8 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                        if (bundle8.containsKey("expo.modules.updates.ENABLE_BSDIFF_PATCH_SUPPORT")) {
                            bool = null;
                        } else {
                            orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(cls3);
                            if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(String.class))) {
                                boolValueOf4 = (Boolean) bundle8.getString("expo.modules.updates.ENABLE_BSDIFF_PATCH_SUPPORT");
                            } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(cls2))) {
                                boolValueOf4 = Boolean.valueOf(bundle8.getBoolean("expo.modules.updates.ENABLE_BSDIFF_PATCH_SUPPORT"));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(cls))) {
                                boolValueOf4 = (Boolean) Integer.valueOf(bundle8.getInt("expo.modules.updates.ENABLE_BSDIFF_PATCH_SUPPORT"));
                            } else {
                                boolValueOf4 = (Boolean) bundle8.get("expo.modules.updates.ENABLE_BSDIFF_PATCH_SUPPORT");
                            }
                            bool = boolValueOf4;
                        }
                    } else {
                        bool = null;
                    }
                    if (bool != null) {
                        zBooleanValue4 = bool.booleanValue();
                    } else {
                        z4 = false;
                    }
                }
                z4 = zBooleanValue4;
            }
            boolean disableAntiBrickingMeasures2 = companion2.getDisableAntiBrickingMeasures(context, map);
            if (updatesConfigurationOverride != null) {
                z5 = true;
            } else {
                z5 = false;
            }
            this(strMaybeGetDefaultScopeKey, updateUrl2, originalEmbeddedUpdateUrl, runtimeVersion, iIntValue, checkAutomaticallyConfigurationValueOf, hasEmbeddedUpdate, originalHasEmbeddedUpdate, requestHeaders, originalEmbeddedRequestHeaders, str2, map2, z2, z3, zBooleanValue3, z4, disableAntiBrickingMeasures2, z5, map);
        }
        checkAutomaticallyConfigurationValueOf = checkAutomaticallyConfigurationValueOf;
        if (context != null) {
            Bundle bundle9 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle9.containsKey("expo.modules.updates.CODE_SIGNING_CERTIFICATE")) {
                KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(String.class);
                string3 = Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(String.class)) ? bundle9.getString("expo.modules.updates.CODE_SIGNING_CERTIFICATE") : Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(cls2)) ? (String) Boolean.valueOf(bundle9.getBoolean("expo.modules.updates.CODE_SIGNING_CERTIFICATE")) : Intrinsics.areEqual(orCreateKotlinClass9, Reflection.getOrCreateKotlinClass(cls)) ? (String) Integer.valueOf(bundle9.getInt("expo.modules.updates.CODE_SIGNING_CERTIFICATE")) : (String) bundle9.get("expo.modules.updates.CODE_SIGNING_CERTIFICATE");
            } else {
                string3 = null;
            }
        } else {
            string3 = null;
        }
        if (map == null) {
            if (context != null) {
                bundle4 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                if (bundle4.containsKey("expo.modules.updates.CODE_SIGNING_METADATA")) {
                    str2 = string3;
                    string4 = null;
                } else {
                    orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
                    str2 = string3;
                    if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                        string4 = bundle4.getString("expo.modules.updates.CODE_SIGNING_METADATA");
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls2))) {
                        string4 = (String) Boolean.valueOf(bundle4.getBoolean("expo.modules.updates.CODE_SIGNING_METADATA"));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls))) {
                        string4 = (String) Integer.valueOf(bundle4.getInt("expo.modules.updates.CODE_SIGNING_METADATA"));
                    } else {
                        string4 = (String) bundle4.get("expo.modules.updates.CODE_SIGNING_METADATA");
                    }
                }
                if (string4 == null) {
                }
                mapFromJSONString = UpdatesUtils.INSTANCE.getMapFromJSONString(string4);
            } else {
                str2 = string3;
            }
            string4 = "{}";
            mapFromJSONString = UpdatesUtils.INSTANCE.getMapFromJSONString(string4);
        } else {
            if (map.containsKey("codeSigningMetadata")) {
                obj5 = null;
            } else {
                obj5 = map.get("codeSigningMetadata");
                if (!(obj5 instanceof Map)) {
                    Intrinsics.checkNotNull(obj5);
                    throw new AssertionError("UpdatesConfiguration failed to initialize: bad value of type " + obj5.getClass().getSimpleName() + " provided for key codeSigningMetadata");
                }
            }
            mapFromJSONString = (Map) obj5;
            if (mapFromJSONString == null) {
                if (context != null) {
                    bundle4 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                    if (bundle4.containsKey("expo.modules.updates.CODE_SIGNING_METADATA")) {
                        str2 = string3;
                        string4 = null;
                    } else {
                        orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
                        str2 = string3;
                        if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                            string4 = bundle4.getString("expo.modules.updates.CODE_SIGNING_METADATA");
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls2))) {
                            string4 = (String) Boolean.valueOf(bundle4.getBoolean("expo.modules.updates.CODE_SIGNING_METADATA"));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(cls))) {
                            string4 = (String) Integer.valueOf(bundle4.getInt("expo.modules.updates.CODE_SIGNING_METADATA"));
                        } else {
                            string4 = (String) bundle4.get("expo.modules.updates.CODE_SIGNING_METADATA");
                        }
                    }
                    if (string4 == null) {
                    }
                    mapFromJSONString = UpdatesUtils.INSTANCE.getMapFromJSONString(string4);
                } else {
                    str2 = string3;
                }
                string4 = "{}";
                mapFromJSONString = UpdatesUtils.INSTANCE.getMapFromJSONString(string4);
            } else {
                str2 = string3;
            }
        }
        cls3 = Boolean.class;
        if (map != null) {
            if (map.containsKey("codeSigningIncludeManifestResponseCertificateChain")) {
                obj4 = null;
            } else {
                obj4 = map.get("codeSigningIncludeManifestResponseCertificateChain");
                if (!(obj4 instanceof Boolean)) {
                    Intrinsics.checkNotNull(obj4);
                    throw new AssertionError("UpdatesConfiguration failed to initialize: bad value of type " + obj4.getClass().getSimpleName() + " provided for key codeSigningIncludeManifestResponseCertificateChain");
                }
            }
            bool5 = (Boolean) obj4;
            if (bool5 != null) {
                zBooleanValue = bool5.booleanValue();
                map2 = mapFromJSONString;
            }
            if (map == null) {
                if (context != null) {
                    bundle6 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                    if (bundle6.containsKey("expo.modules.updates.CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS")) {
                        z2 = zBooleanValue;
                        boolValueOf2 = null;
                    } else {
                        orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(cls3);
                        z2 = zBooleanValue;
                        if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(String.class))) {
                            boolValueOf2 = (Boolean) bundle6.getString("expo.modules.updates.CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS");
                        } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(cls2))) {
                            boolValueOf2 = Boolean.valueOf(bundle6.getBoolean("expo.modules.updates.CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS"));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(cls))) {
                            boolValueOf2 = (Boolean) Integer.valueOf(bundle6.getInt("expo.modules.updates.CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS"));
                        } else {
                            boolValueOf2 = (Boolean) bundle6.get("expo.modules.updates.CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS");
                        }
                    }
                } else {
                    z2 = zBooleanValue;
                    boolValueOf2 = null;
                }
                if (boolValueOf2 != null) {
                    zBooleanValue2 = boolValueOf2.booleanValue();
                } else {
                    zBooleanValue2 = false;
                }
            } else {
                if (map.containsKey("codeSigningAllowUnsignedManifests")) {
                    obj3 = null;
                } else {
                    obj3 = map.get("codeSigningAllowUnsignedManifests");
                    if (!(obj3 instanceof Boolean)) {
                        Intrinsics.checkNotNull(obj3);
                        throw new AssertionError("UpdatesConfiguration failed to initialize: bad value of type " + obj3.getClass().getSimpleName() + " provided for key codeSigningAllowUnsignedManifests");
                    }
                }
                bool4 = (Boolean) obj3;
                if (bool4 != null) {
                    zBooleanValue2 = bool4.booleanValue();
                    z2 = zBooleanValue;
                } else {
                    if (context != null) {
                        bundle6 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                        if (bundle6.containsKey("expo.modules.updates.CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS")) {
                            z2 = zBooleanValue;
                            boolValueOf2 = null;
                        } else {
                            orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(cls3);
                            z2 = zBooleanValue;
                            if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(String.class))) {
                                boolValueOf2 = (Boolean) bundle6.getString("expo.modules.updates.CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS");
                            } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(cls2))) {
                                boolValueOf2 = Boolean.valueOf(bundle6.getBoolean("expo.modules.updates.CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS"));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(cls))) {
                                boolValueOf2 = (Boolean) Integer.valueOf(bundle6.getInt("expo.modules.updates.CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS"));
                            } else {
                                boolValueOf2 = (Boolean) bundle6.get("expo.modules.updates.CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS");
                            }
                        }
                    } else {
                        z2 = zBooleanValue;
                        boolValueOf2 = null;
                    }
                    if (boolValueOf2 != null) {
                        zBooleanValue2 = boolValueOf2.booleanValue();
                    } else {
                        zBooleanValue2 = false;
                    }
                }
            }
            if (map == null) {
                if (context != null) {
                    bundle7 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                    if (bundle7.containsKey("expo.modules.updates.ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE")) {
                        z3 = zBooleanValue2;
                        boolValueOf3 = null;
                    } else {
                        orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(cls3);
                        z3 = zBooleanValue2;
                        if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(String.class))) {
                            boolValueOf3 = (Boolean) bundle7.getString("expo.modules.updates.ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE");
                        } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(cls2))) {
                            boolValueOf3 = Boolean.valueOf(bundle7.getBoolean("expo.modules.updates.ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE"));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(cls))) {
                            boolValueOf3 = (Boolean) Integer.valueOf(bundle7.getInt("expo.modules.updates.ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE"));
                        } else {
                            boolValueOf3 = (Boolean) bundle7.get("expo.modules.updates.ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE");
                        }
                    }
                } else {
                    z3 = zBooleanValue2;
                    boolValueOf3 = null;
                }
                if (boolValueOf3 != null) {
                    zBooleanValue3 = boolValueOf3.booleanValue();
                } else {
                    zBooleanValue3 = false;
                }
            } else {
                if (map.containsKey("enableExpoUpdatesProtocolCompatibilityMode")) {
                    obj2 = null;
                } else {
                    obj2 = map.get("enableExpoUpdatesProtocolCompatibilityMode");
                    if (!(obj2 instanceof Boolean)) {
                        Intrinsics.checkNotNull(obj2);
                        throw new AssertionError("UpdatesConfiguration failed to initialize: bad value of type " + obj2.getClass().getSimpleName() + " provided for key enableExpoUpdatesProtocolCompatibilityMode");
                    }
                }
                bool3 = (Boolean) obj2;
                if (bool3 != null) {
                    zBooleanValue3 = bool3.booleanValue();
                    z3 = zBooleanValue2;
                } else {
                    if (context != null) {
                        bundle7 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                        if (bundle7.containsKey("expo.modules.updates.ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE")) {
                            z3 = zBooleanValue2;
                            boolValueOf3 = null;
                        } else {
                            orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(cls3);
                            z3 = zBooleanValue2;
                            if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(String.class))) {
                                boolValueOf3 = (Boolean) bundle7.getString("expo.modules.updates.ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE");
                            } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(cls2))) {
                                boolValueOf3 = Boolean.valueOf(bundle7.getBoolean("expo.modules.updates.ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE"));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(cls))) {
                                boolValueOf3 = (Boolean) Integer.valueOf(bundle7.getInt("expo.modules.updates.ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE"));
                            } else {
                                boolValueOf3 = (Boolean) bundle7.get("expo.modules.updates.ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE");
                            }
                        }
                    } else {
                        z3 = zBooleanValue2;
                        boolValueOf3 = null;
                    }
                    if (boolValueOf3 != null) {
                        zBooleanValue3 = boolValueOf3.booleanValue();
                    } else {
                        zBooleanValue3 = false;
                    }
                }
            }
            if (map == null) {
                if (context != null) {
                    bundle8 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                    if (bundle8.containsKey("expo.modules.updates.ENABLE_BSDIFF_PATCH_SUPPORT")) {
                        bool = null;
                    } else {
                        orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(cls3);
                        if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(String.class))) {
                            boolValueOf4 = (Boolean) bundle8.getString("expo.modules.updates.ENABLE_BSDIFF_PATCH_SUPPORT");
                        } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(cls2))) {
                            boolValueOf4 = Boolean.valueOf(bundle8.getBoolean("expo.modules.updates.ENABLE_BSDIFF_PATCH_SUPPORT"));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(cls))) {
                            boolValueOf4 = (Boolean) Integer.valueOf(bundle8.getInt("expo.modules.updates.ENABLE_BSDIFF_PATCH_SUPPORT"));
                        } else {
                            boolValueOf4 = (Boolean) bundle8.get("expo.modules.updates.ENABLE_BSDIFF_PATCH_SUPPORT");
                        }
                        bool = boolValueOf4;
                    }
                } else {
                    bool = null;
                }
                if (bool != null) {
                    zBooleanValue4 = bool.booleanValue();
                    z4 = zBooleanValue4;
                } else {
                    z4 = false;
                }
            } else {
                if (map.containsKey("enableBsdiffPatchSupport")) {
                    obj = null;
                } else {
                    obj = map.get("enableBsdiffPatchSupport");
                    if (!(obj instanceof Boolean)) {
                        Intrinsics.checkNotNull(obj);
                        throw new AssertionError("UpdatesConfiguration failed to initialize: bad value of type " + obj.getClass().getSimpleName() + " provided for key enableBsdiffPatchSupport");
                    }
                }
                bool2 = (Boolean) obj;
                if (bool2 != null) {
                    zBooleanValue4 = bool2.booleanValue();
                } else {
                    if (context != null) {
                        bundle8 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                        if (bundle8.containsKey("expo.modules.updates.ENABLE_BSDIFF_PATCH_SUPPORT")) {
                            bool = null;
                        } else {
                            orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(cls3);
                            if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(String.class))) {
                                boolValueOf4 = (Boolean) bundle8.getString("expo.modules.updates.ENABLE_BSDIFF_PATCH_SUPPORT");
                            } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(cls2))) {
                                boolValueOf4 = Boolean.valueOf(bundle8.getBoolean("expo.modules.updates.ENABLE_BSDIFF_PATCH_SUPPORT"));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(cls))) {
                                boolValueOf4 = (Boolean) Integer.valueOf(bundle8.getInt("expo.modules.updates.ENABLE_BSDIFF_PATCH_SUPPORT"));
                            } else {
                                boolValueOf4 = (Boolean) bundle8.get("expo.modules.updates.ENABLE_BSDIFF_PATCH_SUPPORT");
                            }
                            bool = boolValueOf4;
                        }
                    } else {
                        bool = null;
                    }
                    if (bool != null) {
                        zBooleanValue4 = bool.booleanValue();
                    } else {
                        z4 = false;
                    }
                }
                z4 = zBooleanValue4;
            }
            boolean disableAntiBrickingMeasures3 = companion2.getDisableAntiBrickingMeasures(context, map);
            if (updatesConfigurationOverride != null) {
                z5 = true;
            } else {
                z5 = false;
            }
            this(strMaybeGetDefaultScopeKey, updateUrl2, originalEmbeddedUpdateUrl, runtimeVersion, iIntValue, checkAutomaticallyConfigurationValueOf, hasEmbeddedUpdate, originalHasEmbeddedUpdate, requestHeaders, originalEmbeddedRequestHeaders, str2, map2, z2, z3, zBooleanValue3, z4, disableAntiBrickingMeasures3, z5, map);
        }
        cls3 = cls3;
        if (context != null) {
            bundle5 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle5.containsKey("expo.modules.updates.CODE_SIGNING_INCLUDE_MANIFEST_RESPONSE_CERTIFICATE_CHAIN")) {
                map2 = mapFromJSONString;
                boolValueOf = null;
            } else {
                orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(cls3);
                map2 = mapFromJSONString;
                if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(String.class))) {
                    boolValueOf = (Boolean) bundle5.getString("expo.modules.updates.CODE_SIGNING_INCLUDE_MANIFEST_RESPONSE_CERTIFICATE_CHAIN");
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(cls2))) {
                    boolValueOf = Boolean.valueOf(bundle5.getBoolean("expo.modules.updates.CODE_SIGNING_INCLUDE_MANIFEST_RESPONSE_CERTIFICATE_CHAIN"));
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(cls))) {
                    boolValueOf = (Boolean) Integer.valueOf(bundle5.getInt("expo.modules.updates.CODE_SIGNING_INCLUDE_MANIFEST_RESPONSE_CERTIFICATE_CHAIN"));
                } else {
                    boolValueOf = (Boolean) bundle5.get("expo.modules.updates.CODE_SIGNING_INCLUDE_MANIFEST_RESPONSE_CERTIFICATE_CHAIN");
                }
            }
        } else {
            map2 = mapFromJSONString;
            boolValueOf = null;
        }
        if (boolValueOf != null) {
            zBooleanValue = boolValueOf.booleanValue();
        } else {
            zBooleanValue = false;
        }
        if (map == null) {
            if (context != null) {
                bundle6 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                if (bundle6.containsKey("expo.modules.updates.CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS")) {
                    z2 = zBooleanValue;
                    boolValueOf2 = null;
                } else {
                    orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(cls3);
                    z2 = zBooleanValue;
                    if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(String.class))) {
                        boolValueOf2 = (Boolean) bundle6.getString("expo.modules.updates.CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS");
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(cls2))) {
                        boolValueOf2 = Boolean.valueOf(bundle6.getBoolean("expo.modules.updates.CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS"));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(cls))) {
                        boolValueOf2 = (Boolean) Integer.valueOf(bundle6.getInt("expo.modules.updates.CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS"));
                    } else {
                        boolValueOf2 = (Boolean) bundle6.get("expo.modules.updates.CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS");
                    }
                }
            } else {
                z2 = zBooleanValue;
                boolValueOf2 = null;
            }
            if (boolValueOf2 != null) {
                zBooleanValue2 = boolValueOf2.booleanValue();
            } else {
                zBooleanValue2 = false;
            }
        } else {
            if (map.containsKey("codeSigningAllowUnsignedManifests")) {
                obj3 = null;
            } else {
                obj3 = map.get("codeSigningAllowUnsignedManifests");
                if (!(obj3 instanceof Boolean)) {
                    Intrinsics.checkNotNull(obj3);
                    throw new AssertionError("UpdatesConfiguration failed to initialize: bad value of type " + obj3.getClass().getSimpleName() + " provided for key codeSigningAllowUnsignedManifests");
                }
            }
            bool4 = (Boolean) obj3;
            if (bool4 != null) {
                zBooleanValue2 = bool4.booleanValue();
                z2 = zBooleanValue;
            } else {
                if (context != null) {
                    bundle6 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                    if (bundle6.containsKey("expo.modules.updates.CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS")) {
                        z2 = zBooleanValue;
                        boolValueOf2 = null;
                    } else {
                        orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(cls3);
                        z2 = zBooleanValue;
                        if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(String.class))) {
                            boolValueOf2 = (Boolean) bundle6.getString("expo.modules.updates.CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS");
                        } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(cls2))) {
                            boolValueOf2 = Boolean.valueOf(bundle6.getBoolean("expo.modules.updates.CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS"));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(cls))) {
                            boolValueOf2 = (Boolean) Integer.valueOf(bundle6.getInt("expo.modules.updates.CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS"));
                        } else {
                            boolValueOf2 = (Boolean) bundle6.get("expo.modules.updates.CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS");
                        }
                    }
                } else {
                    z2 = zBooleanValue;
                    boolValueOf2 = null;
                }
                if (boolValueOf2 != null) {
                    zBooleanValue2 = boolValueOf2.booleanValue();
                } else {
                    zBooleanValue2 = false;
                }
            }
        }
        if (map == null) {
            if (context != null) {
                bundle7 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                if (bundle7.containsKey("expo.modules.updates.ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE")) {
                    z3 = zBooleanValue2;
                    boolValueOf3 = null;
                } else {
                    orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(cls3);
                    z3 = zBooleanValue2;
                    if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(String.class))) {
                        boolValueOf3 = (Boolean) bundle7.getString("expo.modules.updates.ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE");
                    } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(cls2))) {
                        boolValueOf3 = Boolean.valueOf(bundle7.getBoolean("expo.modules.updates.ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE"));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(cls))) {
                        boolValueOf3 = (Boolean) Integer.valueOf(bundle7.getInt("expo.modules.updates.ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE"));
                    } else {
                        boolValueOf3 = (Boolean) bundle7.get("expo.modules.updates.ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE");
                    }
                }
            } else {
                z3 = zBooleanValue2;
                boolValueOf3 = null;
            }
            if (boolValueOf3 != null) {
                zBooleanValue3 = boolValueOf3.booleanValue();
            } else {
                zBooleanValue3 = false;
            }
        } else {
            if (map.containsKey("enableExpoUpdatesProtocolCompatibilityMode")) {
                obj2 = null;
            } else {
                obj2 = map.get("enableExpoUpdatesProtocolCompatibilityMode");
                if (!(obj2 instanceof Boolean)) {
                    Intrinsics.checkNotNull(obj2);
                    throw new AssertionError("UpdatesConfiguration failed to initialize: bad value of type " + obj2.getClass().getSimpleName() + " provided for key enableExpoUpdatesProtocolCompatibilityMode");
                }
            }
            bool3 = (Boolean) obj2;
            if (bool3 != null) {
                zBooleanValue3 = bool3.booleanValue();
                z3 = zBooleanValue2;
            } else {
                if (context != null) {
                    bundle7 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                    if (bundle7.containsKey("expo.modules.updates.ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE")) {
                        z3 = zBooleanValue2;
                        boolValueOf3 = null;
                    } else {
                        orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(cls3);
                        z3 = zBooleanValue2;
                        if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(String.class))) {
                            boolValueOf3 = (Boolean) bundle7.getString("expo.modules.updates.ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE");
                        } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(cls2))) {
                            boolValueOf3 = Boolean.valueOf(bundle7.getBoolean("expo.modules.updates.ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE"));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(cls))) {
                            boolValueOf3 = (Boolean) Integer.valueOf(bundle7.getInt("expo.modules.updates.ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE"));
                        } else {
                            boolValueOf3 = (Boolean) bundle7.get("expo.modules.updates.ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE");
                        }
                    }
                } else {
                    z3 = zBooleanValue2;
                    boolValueOf3 = null;
                }
                if (boolValueOf3 != null) {
                    zBooleanValue3 = boolValueOf3.booleanValue();
                } else {
                    zBooleanValue3 = false;
                }
            }
        }
        if (map == null) {
            if (context != null) {
                bundle8 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                if (bundle8.containsKey("expo.modules.updates.ENABLE_BSDIFF_PATCH_SUPPORT")) {
                    bool = null;
                } else {
                    orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(cls3);
                    if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(String.class))) {
                        boolValueOf4 = (Boolean) bundle8.getString("expo.modules.updates.ENABLE_BSDIFF_PATCH_SUPPORT");
                    } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(cls2))) {
                        boolValueOf4 = Boolean.valueOf(bundle8.getBoolean("expo.modules.updates.ENABLE_BSDIFF_PATCH_SUPPORT"));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(cls))) {
                        boolValueOf4 = (Boolean) Integer.valueOf(bundle8.getInt("expo.modules.updates.ENABLE_BSDIFF_PATCH_SUPPORT"));
                    } else {
                        boolValueOf4 = (Boolean) bundle8.get("expo.modules.updates.ENABLE_BSDIFF_PATCH_SUPPORT");
                    }
                    bool = boolValueOf4;
                }
            } else {
                bool = null;
            }
            if (bool != null) {
                zBooleanValue4 = bool.booleanValue();
                z4 = zBooleanValue4;
            } else {
                z4 = false;
            }
        } else {
            if (map.containsKey("enableBsdiffPatchSupport")) {
                obj = null;
            } else {
                obj = map.get("enableBsdiffPatchSupport");
                if (!(obj instanceof Boolean)) {
                    Intrinsics.checkNotNull(obj);
                    throw new AssertionError("UpdatesConfiguration failed to initialize: bad value of type " + obj.getClass().getSimpleName() + " provided for key enableBsdiffPatchSupport");
                }
            }
            bool2 = (Boolean) obj;
            if (bool2 != null) {
                zBooleanValue4 = bool2.booleanValue();
            } else {
                if (context != null) {
                    bundle8 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                    if (bundle8.containsKey("expo.modules.updates.ENABLE_BSDIFF_PATCH_SUPPORT")) {
                        bool = null;
                    } else {
                        orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(cls3);
                        if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(String.class))) {
                            boolValueOf4 = (Boolean) bundle8.getString("expo.modules.updates.ENABLE_BSDIFF_PATCH_SUPPORT");
                        } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(cls2))) {
                            boolValueOf4 = Boolean.valueOf(bundle8.getBoolean("expo.modules.updates.ENABLE_BSDIFF_PATCH_SUPPORT"));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass8, Reflection.getOrCreateKotlinClass(cls))) {
                            boolValueOf4 = (Boolean) Integer.valueOf(bundle8.getInt("expo.modules.updates.ENABLE_BSDIFF_PATCH_SUPPORT"));
                        } else {
                            boolValueOf4 = (Boolean) bundle8.get("expo.modules.updates.ENABLE_BSDIFF_PATCH_SUPPORT");
                        }
                        bool = boolValueOf4;
                    }
                } else {
                    bool = null;
                }
                if (bool != null) {
                    zBooleanValue4 = bool.booleanValue();
                } else {
                    z4 = false;
                }
            }
            z4 = zBooleanValue4;
        }
        boolean disableAntiBrickingMeasures4 = companion2.getDisableAntiBrickingMeasures(context, map);
        if (updatesConfigurationOverride != null) {
            z5 = true;
        } else {
            z5 = false;
        }
        this(strMaybeGetDefaultScopeKey, updateUrl2, originalEmbeddedUpdateUrl, runtimeVersion, iIntValue, checkAutomaticallyConfigurationValueOf, hasEmbeddedUpdate, originalHasEmbeddedUpdate, requestHeaders, originalEmbeddedRequestHeaders, str2, map2, z2, z3, zBooleanValue3, z4, disableAntiBrickingMeasures4, z5, map);
    }

    public final CodeSigningConfiguration getCodeSigningConfiguration() {
        return (CodeSigningConfiguration) this.codeSigningConfiguration$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CodeSigningConfiguration codeSigningConfiguration_delegate$lambda$5(UpdatesConfiguration updatesConfiguration) {
        String str = updatesConfiguration.codeSigningCertificate;
        if (str != null) {
            return new CodeSigningConfiguration(str, updatesConfiguration.codeSigningMetadata, updatesConfiguration.codeSigningIncludeManifestResponseCertificateChain, updatesConfiguration.codeSigningAllowUnsignedManifests);
        }
        return null;
    }

    public final String getRuntimeVersion() throws Exception {
        String str = this.runtimeVersionRaw;
        if (str != null && str.length() != 0) {
            return this.runtimeVersionRaw;
        }
        throw new Exception("No runtime version provided in configuration");
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean getHasEmbeddedUpdate(Context context, Map map, boolean z, UpdatesConfigurationOverride updatesConfigurationOverride) {
            if (!z || updatesConfigurationOverride == null) {
                return getOriginalHasEmbeddedUpdate(context, map);
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Uri getUpdateUrl(Context context, Map map, boolean z, UpdatesConfigurationOverride updatesConfigurationOverride) {
            if (z && updatesConfigurationOverride != null) {
                return updatesConfigurationOverride.getUpdateUrl();
            }
            return getOriginalEmbeddedUpdateUrl(context, map);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Map getRequestHeaders(Context context, Map map, boolean z, UpdatesConfigurationOverride updatesConfigurationOverride) {
            Map requestHeaders;
            if (updatesConfigurationOverride != null && (requestHeaders = updatesConfigurationOverride.getRequestHeaders()) != null) {
                if (UpdatesConfiguration.Companion.isValidRequestHeadersOverride(context, map, requestHeaders) || z) {
                    return requestHeaders;
                }
                String unused = UpdatesConfiguration.TAG;
                requestHeaders.toString();
            }
            return getOriginalEmbeddedRequestHeaders(context, map);
        }

        public final boolean isValidRequestHeadersOverride$expo_updates_release(Map originalEmbeddedRequestHeaders, Map map) {
            Intrinsics.checkNotNullParameter(originalEmbeddedRequestHeaders, "originalEmbeddedRequestHeaders");
            if (map == null) {
                return true;
            }
            Set setKeySet = originalEmbeddedRequestHeaders.keySet();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(setKeySet, 10));
            Iterator it = setKeySet.iterator();
            while (it.hasNext()) {
                String lowerCase = ((String) it.next()).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                arrayList.add(StringsKt.trim(lowerCase).toString());
            }
            Set set = CollectionsKt.toSet(arrayList);
            Set of = SetsKt.setOf(DiagnosticsTracker.HOST_KEY);
            Set setKeySet2 = map.keySet();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(setKeySet2, 10));
            Iterator it2 = setKeySet2.iterator();
            while (it2.hasNext()) {
                String lowerCase2 = ((String) it2.next()).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                arrayList2.add(StringsKt.trim(lowerCase2).toString());
            }
            if (!arrayList2.isEmpty()) {
                Iterator it3 = arrayList2.iterator();
                while (it3.hasNext()) {
                    if (of.contains((String) it3.next())) {
                        return false;
                    }
                }
            }
            if (!arrayList2.isEmpty()) {
                Iterator it4 = arrayList2.iterator();
                while (it4.hasNext()) {
                    if (!set.contains((String) it4.next())) {
                        return false;
                    }
                }
            }
            return true;
        }

        private final boolean isValidRequestHeadersOverride(Context context, Map map, Map map2) {
            return isValidRequestHeadersOverride$expo_updates_release(getOriginalEmbeddedRequestHeaders(context, map), map2);
        }

        public final UpdatesConfigurationValidationResult getUpdatesConfigurationValidationResult(Context context, Map map) throws IOException {
            if (!getIsEnabled(context, map)) {
                return UpdatesConfigurationValidationResult.INVALID_NOT_ENABLED;
            }
            if (getUpdateUrl(context, map, getDisableAntiBrickingMeasures(context, map), context != null ? UpdatesConfigurationOverride.Companion.load$expo_updates_release(context) : null) == null) {
                return UpdatesConfigurationValidationResult.INVALID_MISSING_URL;
            }
            String runtimeVersion = getRuntimeVersion(context, map);
            if (runtimeVersion == null || runtimeVersion.length() == 0) {
                return UpdatesConfigurationValidationResult.INVALID_MISSING_RUNTIME_VERSION;
            }
            return UpdatesConfigurationValidationResult.VALID;
        }

        public final UpdatesConfiguration create(Context context, UpdatesConfiguration config, UpdatesConfigurationOverride updatesConfigurationOverride) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(config, "config");
            Map map = config.cachedOverrideMap;
            return new UpdatesConfiguration(context, map, getDisableAntiBrickingMeasures(context, map), updatesConfigurationOverride);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean getDisableAntiBrickingMeasures(Context context, Map map) {
            Boolean boolValueOf;
            Object obj;
            Boolean bool = null;
            if (map != null) {
                if (map.containsKey("disableAntiBrickingMeasures")) {
                    obj = map.get("disableAntiBrickingMeasures");
                    if (!(obj instanceof Boolean)) {
                        Intrinsics.checkNotNull(obj);
                        throw new AssertionError("UpdatesConfiguration failed to initialize: bad value of type " + obj.getClass().getSimpleName() + " provided for key disableAntiBrickingMeasures");
                    }
                } else {
                    obj = null;
                }
                Boolean bool2 = (Boolean) obj;
                if (bool2 != null) {
                    return bool2.booleanValue();
                }
            }
            if (context != null) {
                Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                if (bundle.containsKey("expo.modules.updates.DISABLE_ANTI_BRICKING_MEASURES")) {
                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Boolean.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                        boolValueOf = (Boolean) bundle.getString("expo.modules.updates.DISABLE_ANTI_BRICKING_MEASURES");
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        boolValueOf = Boolean.valueOf(bundle.getBoolean("expo.modules.updates.DISABLE_ANTI_BRICKING_MEASURES"));
                    } else {
                        boolValueOf = Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE)) ? (Boolean) Integer.valueOf(bundle.getInt("expo.modules.updates.DISABLE_ANTI_BRICKING_MEASURES")) : (Boolean) bundle.get("expo.modules.updates.DISABLE_ANTI_BRICKING_MEASURES");
                    }
                    bool = boolValueOf;
                }
            }
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        }

        private final boolean getIsEnabled(Context context, Map map) {
            Boolean boolValueOf;
            Object obj;
            Boolean bool = null;
            if (map != null) {
                if (map.containsKey("enabled")) {
                    obj = map.get("enabled");
                    if (!(obj instanceof Boolean)) {
                        Intrinsics.checkNotNull(obj);
                        throw new AssertionError("UpdatesConfiguration failed to initialize: bad value of type " + obj.getClass().getSimpleName() + " provided for key enabled");
                    }
                } else {
                    obj = null;
                }
                Boolean bool2 = (Boolean) obj;
                if (bool2 != null) {
                    return bool2.booleanValue();
                }
            }
            if (context != null) {
                Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                if (bundle.containsKey("expo.modules.updates.ENABLED")) {
                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Boolean.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                        boolValueOf = (Boolean) bundle.getString("expo.modules.updates.ENABLED");
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        boolValueOf = Boolean.valueOf(bundle.getBoolean("expo.modules.updates.ENABLED"));
                    } else {
                        boolValueOf = Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE)) ? (Boolean) Integer.valueOf(bundle.getInt("expo.modules.updates.ENABLED")) : (Boolean) bundle.get("expo.modules.updates.ENABLED");
                    }
                    bool = boolValueOf;
                }
            }
            if (bool != null) {
                return bool.booleanValue();
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code duplicated, block: B:31:0x00ad  */
        public final Map getOriginalEmbeddedRequestHeaders(Context context, Map map) {
            String string;
            Object obj;
            String str = null;
            if (map != null) {
                if (map.containsKey("requestHeaders")) {
                    obj = map.get("requestHeaders");
                    if (!(obj instanceof Map)) {
                        Intrinsics.checkNotNull(obj);
                        throw new AssertionError("UpdatesConfiguration failed to initialize: bad value of type " + obj.getClass().getSimpleName() + " provided for key requestHeaders");
                    }
                } else {
                    obj = null;
                }
                Map map2 = (Map) obj;
                if (map2 != null) {
                    return map2;
                }
            }
            if (context == null) {
                str = "{}";
            } else {
                Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                if (bundle.containsKey("expo.modules.updates.UPDATES_CONFIGURATION_REQUEST_HEADERS_KEY")) {
                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                        string = bundle.getString("expo.modules.updates.UPDATES_CONFIGURATION_REQUEST_HEADERS_KEY");
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        string = (String) Boolean.valueOf(bundle.getBoolean("expo.modules.updates.UPDATES_CONFIGURATION_REQUEST_HEADERS_KEY"));
                    } else {
                        string = Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE)) ? (String) Integer.valueOf(bundle.getInt("expo.modules.updates.UPDATES_CONFIGURATION_REQUEST_HEADERS_KEY")) : (String) bundle.get("expo.modules.updates.UPDATES_CONFIGURATION_REQUEST_HEADERS_KEY");
                    }
                    str = string;
                }
                if (str == null) {
                    str = "{}";
                }
            }
            return UpdatesUtils.INSTANCE.getMapFromJSONString(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Uri getOriginalEmbeddedUpdateUrl(Context context, Map map) {
            String string;
            Object obj;
            if (map != null) {
                if (map.containsKey("updateUrl")) {
                    obj = map.get("updateUrl");
                    if (!(obj instanceof Uri)) {
                        Intrinsics.checkNotNull(obj);
                        throw new AssertionError("UpdatesConfiguration failed to initialize: bad value of type " + obj.getClass().getSimpleName() + " provided for key updateUrl");
                    }
                } else {
                    obj = null;
                }
                Uri uri = (Uri) obj;
                if (uri != null) {
                    return uri;
                }
            }
            if (context != null) {
                Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                if (bundle.containsKey("expo.modules.updates.EXPO_UPDATE_URL")) {
                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                        string = bundle.getString("expo.modules.updates.EXPO_UPDATE_URL");
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        string = (String) Boolean.valueOf(bundle.getBoolean("expo.modules.updates.EXPO_UPDATE_URL"));
                    } else {
                        string = Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE)) ? (String) Integer.valueOf(bundle.getInt("expo.modules.updates.EXPO_UPDATE_URL")) : (String) bundle.get("expo.modules.updates.EXPO_UPDATE_URL");
                    }
                } else {
                    string = null;
                }
                if (string != null) {
                    return Uri.parse(string);
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean getOriginalHasEmbeddedUpdate(Context context, Map map) {
            Boolean boolValueOf;
            Object obj;
            Boolean bool = null;
            if (map != null) {
                if (map.containsKey("hasEmbeddedUpdate")) {
                    obj = map.get("hasEmbeddedUpdate");
                    if (!(obj instanceof Boolean)) {
                        Intrinsics.checkNotNull(obj);
                        throw new AssertionError("UpdatesConfiguration failed to initialize: bad value of type " + obj.getClass().getSimpleName() + " provided for key hasEmbeddedUpdate");
                    }
                } else {
                    obj = null;
                }
                Boolean bool2 = (Boolean) obj;
                if (bool2 != null) {
                    return bool2.booleanValue();
                }
            }
            if (context != null) {
                Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                if (bundle.containsKey("expo.modules.updates.HAS_EMBEDDED_UPDATE")) {
                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Boolean.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                        boolValueOf = (Boolean) bundle.getString("expo.modules.updates.HAS_EMBEDDED_UPDATE");
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        boolValueOf = Boolean.valueOf(bundle.getBoolean("expo.modules.updates.HAS_EMBEDDED_UPDATE"));
                    } else {
                        boolValueOf = Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE)) ? (Boolean) Integer.valueOf(bundle.getInt("expo.modules.updates.HAS_EMBEDDED_UPDATE")) : (Boolean) bundle.get("expo.modules.updates.HAS_EMBEDDED_UPDATE");
                    }
                    bool = boolValueOf;
                }
            }
            if (bool != null) {
                return bool.booleanValue();
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code duplicated, block: B:14:0x0044 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:15:0x0046  */
        /* JADX WARN: Code duplicated, block: B:17:0x005e  */
        /* JADX WARN: Code duplicated, block: B:18:0x0060  */
        /* JADX WARN: Code duplicated, block: B:20:0x0072  */
        /* JADX WARN: Code duplicated, block: B:21:0x0077  */
        /* JADX WARN: Code duplicated, block: B:23:0x0083  */
        /* JADX WARN: Code duplicated, block: B:24:0x008c  */
        /* JADX WARN: Code duplicated, block: B:26:0x0098  */
        /* JADX WARN: Code duplicated, block: B:27:0x00a1  */
        /* JADX WARN: Code duplicated, block: B:32:0x00bb  */
        public final String getRuntimeVersion(Context context, Map map) throws IOException {
            String strReplaceFirst;
            Bundle bundle;
            KClass orCreateKotlinClass;
            Object objValueOf;
            String string;
            Object obj;
            if (map != null) {
                if (map.containsKey("runtimeVersion")) {
                    obj = map.get("runtimeVersion");
                    if (!(obj instanceof String)) {
                        Intrinsics.checkNotNull(obj);
                        throw new AssertionError("UpdatesConfiguration failed to initialize: bad value of type " + obj.getClass().getSimpleName() + " provided for key runtimeVersion");
                    }
                } else {
                    obj = null;
                }
                strReplaceFirst = (String) obj;
                if (strReplaceFirst == null) {
                    if (context != null) {
                        bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                        if (bundle.containsKey("expo.modules.updates.EXPO_RUNTIME_VERSION")) {
                            orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                                objValueOf = bundle.getString("expo.modules.updates.EXPO_RUNTIME_VERSION");
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                objValueOf = Boolean.valueOf(bundle.getBoolean("expo.modules.updates.EXPO_RUNTIME_VERSION"));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                                objValueOf = Integer.valueOf(bundle.getInt("expo.modules.updates.EXPO_RUNTIME_VERSION"));
                            } else {
                                objValueOf = bundle.get("expo.modules.updates.EXPO_RUNTIME_VERSION");
                            }
                        } else {
                            objValueOf = null;
                        }
                        if (objValueOf != null) {
                            strReplaceFirst = null;
                        } else {
                            strReplaceFirst = null;
                        }
                    } else {
                        strReplaceFirst = null;
                    }
                }
            } else if (context != null) {
                bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                if (bundle.containsKey("expo.modules.updates.EXPO_RUNTIME_VERSION")) {
                    objValueOf = null;
                } else {
                    orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                        objValueOf = bundle.getString("expo.modules.updates.EXPO_RUNTIME_VERSION");
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        objValueOf = Boolean.valueOf(bundle.getBoolean("expo.modules.updates.EXPO_RUNTIME_VERSION"));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                        objValueOf = Integer.valueOf(bundle.getInt("expo.modules.updates.EXPO_RUNTIME_VERSION"));
                    } else {
                        objValueOf = bundle.get("expo.modules.updates.EXPO_RUNTIME_VERSION");
                    }
                }
                if (objValueOf != null || (string = objValueOf.toString()) == null) {
                    strReplaceFirst = null;
                } else {
                    strReplaceFirst = new Regex("^string:").replaceFirst(string, "");
                }
            } else {
                strReplaceFirst = null;
            }
            if (context == null || !Intrinsics.areEqual(strReplaceFirst, "file:fingerprint")) {
                return strReplaceFirst;
            }
            InputStream inputStreamOpen = context.getAssets().open("fingerprint");
            try {
                Intrinsics.checkNotNull(inputStreamOpen);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen, Charsets.UTF_8), 8192);
                try {
                    String text = TextStreamsKt.readText(bufferedReader);
                    CloseableKt.closeFinally(bufferedReader, null);
                    CloseableKt.closeFinally(inputStreamOpen, null);
                    return text;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(bufferedReader, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    CloseableKt.closeFinally(inputStreamOpen, th3);
                    throw th4;
                }
            }
        }
    }
}
