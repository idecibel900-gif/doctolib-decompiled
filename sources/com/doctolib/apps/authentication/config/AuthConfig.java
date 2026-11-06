package com.doctolib.apps.authentication.config;

import com.doctolib.apps.authentication.model.DeviceKeyRegistrarKind;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class AuthConfig {
    private final Map additionalParameters;
    private final String clientId;
    private final String clientSecret;
    private final Map customHeaders;
    private final String deviceKeyIssuer;
    private final DeviceKeyRegistrarKind deviceKeyRegistrarKind;
    private final String issuer;
    private final String redirectUrl;
    private final List scopes;
    private final ServiceConfiguration serviceConfiguration;
    private final boolean skipCodeExchange;
    private final boolean useNonce;
    private final boolean usePKCE;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthConfig)) {
            return false;
        }
        AuthConfig authConfig = (AuthConfig) obj;
        return Intrinsics.areEqual(this.issuer, authConfig.issuer) && Intrinsics.areEqual(this.serviceConfiguration, authConfig.serviceConfiguration) && Intrinsics.areEqual(this.clientId, authConfig.clientId) && Intrinsics.areEqual(this.redirectUrl, authConfig.redirectUrl) && Intrinsics.areEqual(this.scopes, authConfig.scopes) && Intrinsics.areEqual(this.clientSecret, authConfig.clientSecret) && Intrinsics.areEqual(this.additionalParameters, authConfig.additionalParameters) && this.usePKCE == authConfig.usePKCE && this.useNonce == authConfig.useNonce && this.skipCodeExchange == authConfig.skipCodeExchange && Intrinsics.areEqual(this.customHeaders, authConfig.customHeaders) && Intrinsics.areEqual(this.deviceKeyIssuer, authConfig.deviceKeyIssuer) && this.deviceKeyRegistrarKind == authConfig.deviceKeyRegistrarKind;
    }

    public int hashCode() {
        String str = this.issuer;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        ServiceConfiguration serviceConfiguration = this.serviceConfiguration;
        int iHashCode2 = (((((((iHashCode + (serviceConfiguration == null ? 0 : serviceConfiguration.hashCode())) * 31) + this.clientId.hashCode()) * 31) + this.redirectUrl.hashCode()) * 31) + this.scopes.hashCode()) * 31;
        String str2 = this.clientSecret;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Map map = this.additionalParameters;
        int iHashCode4 = (((((((iHashCode3 + (map == null ? 0 : map.hashCode())) * 31) + Boolean.hashCode(this.usePKCE)) * 31) + Boolean.hashCode(this.useNonce)) * 31) + Boolean.hashCode(this.skipCodeExchange)) * 31;
        Map map2 = this.customHeaders;
        int iHashCode5 = (iHashCode4 + (map2 == null ? 0 : map2.hashCode())) * 31;
        String str3 = this.deviceKeyIssuer;
        return ((iHashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.deviceKeyRegistrarKind.hashCode();
    }

    public String toString() {
        return "AuthConfig(issuer=" + this.issuer + ", serviceConfiguration=" + this.serviceConfiguration + ", clientId=" + this.clientId + ", redirectUrl=" + this.redirectUrl + ", scopes=" + this.scopes + ", clientSecret=" + this.clientSecret + ", additionalParameters=" + this.additionalParameters + ", usePKCE=" + this.usePKCE + ", useNonce=" + this.useNonce + ", skipCodeExchange=" + this.skipCodeExchange + ", customHeaders=" + this.customHeaders + ", deviceKeyIssuer=" + this.deviceKeyIssuer + ", deviceKeyRegistrarKind=" + this.deviceKeyRegistrarKind + ")";
    }

    public AuthConfig(String str, ServiceConfiguration serviceConfiguration, String clientId, String redirectUrl, List scopes, String str2, Map map, boolean z, boolean z2, boolean z3, Map map2, String str3, DeviceKeyRegistrarKind deviceKeyRegistrarKind) {
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(redirectUrl, "redirectUrl");
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        Intrinsics.checkNotNullParameter(deviceKeyRegistrarKind, "deviceKeyRegistrarKind");
        this.issuer = str;
        this.serviceConfiguration = serviceConfiguration;
        this.clientId = clientId;
        this.redirectUrl = redirectUrl;
        this.scopes = scopes;
        this.clientSecret = str2;
        this.additionalParameters = map;
        this.usePKCE = z;
        this.useNonce = z2;
        this.skipCodeExchange = z3;
        this.customHeaders = map2;
        this.deviceKeyIssuer = str3;
        this.deviceKeyRegistrarKind = deviceKeyRegistrarKind;
        if (StringsKt.isBlank(clientId)) {
            throw new IllegalArgumentException("clientId must not be blank");
        }
        if (StringsKt.isBlank(redirectUrl)) {
            throw new IllegalArgumentException("redirectUrl must not be blank");
        }
        if (scopes.isEmpty()) {
            throw new IllegalArgumentException("scopes must not be empty");
        }
        if (str == null && serviceConfiguration == null) {
            throw new IllegalArgumentException("Either issuer or serviceConfiguration must be provided");
        }
        if (str != null && serviceConfiguration != null) {
            throw new IllegalArgumentException("Cannot provide both issuer and serviceConfiguration");
        }
        if (str != null && !StringsKt.startsWith$default(str, "https://", false, 2, (Object) null) && !StringsKt.startsWith$default(str, "http://", false, 2, (Object) null)) {
            throw new IllegalArgumentException("issuer must be a valid HTTP(S) URL");
        }
        if (!StringsKt.contains$default((CharSequence) redirectUrl, (CharSequence) "://", false, 2, (Object) null)) {
            throw new IllegalArgumentException("redirectUrl must be a valid URI with a scheme");
        }
        if (map2 != null && !map2.isEmpty()) {
            for (Map.Entry entry : map2.entrySet()) {
                String str4 = (String) entry.getKey();
                String str5 = (String) entry.getValue();
                if (StringsKt.isBlank(str4) || StringsKt.isBlank(str5)) {
                    throw new IllegalArgumentException("customHeaders must not contain blank header names or values");
                }
            }
        }
        String str6 = this.deviceKeyIssuer;
        if (!(str6 != null ? true ^ StringsKt.isBlank(str6) : true)) {
            throw new IllegalArgumentException("deviceKeyIssuer must not be blank");
        }
    }

    public final String getIssuer() {
        return this.issuer;
    }

    public final ServiceConfiguration getServiceConfiguration() {
        return this.serviceConfiguration;
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    public final List getScopes() {
        return this.scopes;
    }

    public final String getClientSecret() {
        return this.clientSecret;
    }

    public final Map getAdditionalParameters() {
        return this.additionalParameters;
    }

    public final boolean getUsePKCE() {
        return this.usePKCE;
    }

    public final boolean getUseNonce() {
        return this.useNonce;
    }

    public final boolean getSkipCodeExchange() {
        return this.skipCodeExchange;
    }

    public final Map getCustomHeaders() {
        return this.customHeaders;
    }

    public final String getDeviceKeyIssuer() {
        return this.deviceKeyIssuer;
    }

    public /* synthetic */ AuthConfig(String str, ServiceConfiguration serviceConfiguration, String str2, String str3, List list, String str4, Map map, boolean z, boolean z2, boolean z3, Map map2, String str5, DeviceKeyRegistrarKind deviceKeyRegistrarKind, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : serviceConfiguration, str2, str3, list, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : map, (i & 128) != 0 ? true : z, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? true : z2, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? false : z3, (i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET) != 0 ? null : map2, (i & 2048) != 0 ? null : str5, (i & 4096) != 0 ? DeviceKeyRegistrarKind.KEYCLOAK : deviceKeyRegistrarKind);
    }

    public final DeviceKeyRegistrarKind getDeviceKeyRegistrarKind() {
        return this.deviceKeyRegistrarKind;
    }
}
