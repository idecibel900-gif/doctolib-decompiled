package com.doctolib.apps.authentication.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class RefreshResult {
    private final String accessToken;
    private final String accessTokenExpirationDate;
    private final String idToken;
    private final String tokenType;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RefreshResult)) {
            return false;
        }
        RefreshResult refreshResult = (RefreshResult) obj;
        return Intrinsics.areEqual(this.accessToken, refreshResult.accessToken) && Intrinsics.areEqual(this.accessTokenExpirationDate, refreshResult.accessTokenExpirationDate) && Intrinsics.areEqual(this.idToken, refreshResult.idToken) && Intrinsics.areEqual(this.tokenType, refreshResult.tokenType);
    }

    public int hashCode() {
        int iHashCode = ((this.accessToken.hashCode() * 31) + this.accessTokenExpirationDate.hashCode()) * 31;
        String str = this.idToken;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.tokenType.hashCode();
    }

    public String toString() {
        return "RefreshResult(accessToken=" + this.accessToken + ", accessTokenExpirationDate=" + this.accessTokenExpirationDate + ", idToken=" + this.idToken + ", tokenType=" + this.tokenType + ")";
    }

    public RefreshResult(String accessToken, String accessTokenExpirationDate, String str, String tokenType) {
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(accessTokenExpirationDate, "accessTokenExpirationDate");
        Intrinsics.checkNotNullParameter(tokenType, "tokenType");
        this.accessToken = accessToken;
        this.accessTokenExpirationDate = accessTokenExpirationDate;
        this.idToken = str;
        this.tokenType = tokenType;
    }

    public final String getAccessToken() {
        return this.accessToken;
    }

    public final String getAccessTokenExpirationDate() {
        return this.accessTokenExpirationDate;
    }

    public final String getIdToken() {
        return this.idToken;
    }

    public final String getTokenType() {
        return this.tokenType;
    }
}
