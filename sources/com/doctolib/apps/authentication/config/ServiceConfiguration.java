package com.doctolib.apps.authentication.config;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class ServiceConfiguration {
    private final String authorizationEndpoint;
    private final String endSessionEndpoint;
    private final String tokenEndpoint;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ServiceConfiguration)) {
            return false;
        }
        ServiceConfiguration serviceConfiguration = (ServiceConfiguration) obj;
        return Intrinsics.areEqual(this.authorizationEndpoint, serviceConfiguration.authorizationEndpoint) && Intrinsics.areEqual(this.tokenEndpoint, serviceConfiguration.tokenEndpoint) && Intrinsics.areEqual(this.endSessionEndpoint, serviceConfiguration.endSessionEndpoint);
    }

    public int hashCode() {
        int iHashCode = ((this.authorizationEndpoint.hashCode() * 31) + this.tokenEndpoint.hashCode()) * 31;
        String str = this.endSessionEndpoint;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "ServiceConfiguration(authorizationEndpoint=" + this.authorizationEndpoint + ", tokenEndpoint=" + this.tokenEndpoint + ", endSessionEndpoint=" + this.endSessionEndpoint + ")";
    }

    public ServiceConfiguration(String authorizationEndpoint, String tokenEndpoint, String str) {
        Intrinsics.checkNotNullParameter(authorizationEndpoint, "authorizationEndpoint");
        Intrinsics.checkNotNullParameter(tokenEndpoint, "tokenEndpoint");
        this.authorizationEndpoint = authorizationEndpoint;
        this.tokenEndpoint = tokenEndpoint;
        this.endSessionEndpoint = str;
        if (!StringsKt.startsWith$default(authorizationEndpoint, "https://", false, 2, (Object) null) && !StringsKt.startsWith$default(authorizationEndpoint, "http://", false, 2, (Object) null)) {
            throw new IllegalArgumentException("authorizationEndpoint must be a valid HTTP(S) URL");
        }
        if (!StringsKt.startsWith$default(tokenEndpoint, "https://", false, 2, (Object) null) && !StringsKt.startsWith$default(tokenEndpoint, "http://", false, 2, (Object) null)) {
            throw new IllegalArgumentException("tokenEndpoint must be a valid HTTP(S) URL");
        }
        if (str != null && !StringsKt.startsWith$default(str, "https://", false, 2, (Object) null) && !StringsKt.startsWith$default(str, "http://", false, 2, (Object) null)) {
            throw new IllegalArgumentException("endSessionEndpoint must be a valid HTTP(S) URL");
        }
    }

    public final String getAuthorizationEndpoint() {
        return this.authorizationEndpoint;
    }

    public final String getTokenEndpoint() {
        return this.tokenEndpoint;
    }

    public final String getEndSessionEndpoint() {
        return this.endSessionEndpoint;
    }
}
