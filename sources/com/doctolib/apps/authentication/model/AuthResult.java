package com.doctolib.apps.authentication.model;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class AuthResult {
    private final String accessToken;
    private final String accessTokenExpirationDate;
    private final String authorizationCode;
    private final String codeVerifier;
    private final String idToken;
    private final List scopes;
    private final String tokenType;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthResult)) {
            return false;
        }
        AuthResult authResult = (AuthResult) obj;
        return Intrinsics.areEqual(this.accessToken, authResult.accessToken) && Intrinsics.areEqual(this.accessTokenExpirationDate, authResult.accessTokenExpirationDate) && Intrinsics.areEqual(this.idToken, authResult.idToken) && Intrinsics.areEqual(this.tokenType, authResult.tokenType) && Intrinsics.areEqual(this.scopes, authResult.scopes) && Intrinsics.areEqual(this.authorizationCode, authResult.authorizationCode) && Intrinsics.areEqual(this.codeVerifier, authResult.codeVerifier);
    }

    public int hashCode() {
        String str = this.accessToken;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.accessTokenExpirationDate;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.idToken;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.tokenType;
        int iHashCode4 = (((iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.scopes.hashCode()) * 31;
        String str5 = this.authorizationCode;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.codeVerifier;
        return iHashCode5 + (str6 != null ? str6.hashCode() : 0);
    }

    public String toString() {
        return "AuthResult(accessToken=" + this.accessToken + ", accessTokenExpirationDate=" + this.accessTokenExpirationDate + ", idToken=" + this.idToken + ", tokenType=" + this.tokenType + ", scopes=" + this.scopes + ", authorizationCode=" + this.authorizationCode + ", codeVerifier=" + this.codeVerifier + ")";
    }

    public AuthResult(String str, String str2, String str3, String str4, List scopes, String str5, String str6) {
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        this.accessToken = str;
        this.accessTokenExpirationDate = str2;
        this.idToken = str3;
        this.tokenType = str4;
        this.scopes = scopes;
        this.authorizationCode = str5;
        this.codeVerifier = str6;
    }

    public /* synthetic */ AuthResult(String str, String str2, String str3, String str4, List list, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3, str4, list, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6);
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

    public final List getScopes() {
        return this.scopes;
    }

    public final String getAuthorizationCode() {
        return this.authorizationCode;
    }

    public final String getCodeVerifier() {
        return this.codeVerifier;
    }
}
