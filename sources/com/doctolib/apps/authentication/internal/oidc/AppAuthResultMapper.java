package com.doctolib.apps.authentication.internal.oidc;

import com.doctolib.apps.authentication.error.AppAuthErrorCode;
import com.doctolib.apps.authentication.error.AuthError;
import com.doctolib.apps.authentication.internal.utils.TimeExtensionsKt;
import com.doctolib.apps.authentication.model.AuthResult;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.openid.appauth.AuthorizationException;
import net.openid.appauth.AuthorizationResponse;
import net.openid.appauth.TokenResponse;

/* JADX INFO: loaded from: classes3.dex */
public final class AppAuthResultMapper {
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final AuthResult mapSuccess(TokenResponse tokenResponse, List scopes) throws AuthError {
        Intrinsics.checkNotNullParameter(tokenResponse, "tokenResponse");
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        Long l = tokenResponse.accessTokenExpirationTime;
        if (l == null) {
            throw new AuthError(AppAuthErrorCode.TOKEN_EXCHANGE_FAILED, "Access token expiration time is missing", null, 4, null);
        }
        long jLongValue = l.longValue();
        String str = tokenResponse.accessToken;
        if (str == null) {
            throw new AuthError(AppAuthErrorCode.TOKEN_EXCHANGE_FAILED, "Access token is missing", null, 4, null);
        }
        String isoUtcString = TimeExtensionsKt.toIsoUtcString(jLongValue);
        String str2 = tokenResponse.idToken;
        String str3 = tokenResponse.tokenType;
        if (str3 == null) {
            str3 = TokenResponse.TOKEN_TYPE_BEARER;
        }
        return new AuthResult(str, isoUtcString, str2, str3, scopes, null, null);
    }

    public final AuthResult mapCodeOnly(AuthorizationResponse authResponse, List scopes) throws AuthError {
        Intrinsics.checkNotNullParameter(authResponse, "authResponse");
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        String str = authResponse.authorizationCode;
        if (str == null) {
            throw new AuthError(AppAuthErrorCode.AUTHENTICATION_FAILED, "Authorization code is missing from response", null, 4, null);
        }
        return new AuthResult(null, null, null, null, scopes, str, authResponse.request.codeVerifier);
    }

    public static /* synthetic */ AuthError mapError$default(AppAuthResultMapper appAuthResultMapper, AuthorizationException authorizationException, AppAuthErrorCode appAuthErrorCode, int i, Object obj) {
        if ((i & 2) != 0) {
            appAuthErrorCode = AppAuthErrorCode.AUTHENTICATION_FAILED;
        }
        return appAuthResultMapper.mapError(authorizationException, appAuthErrorCode);
    }

    public final AuthError mapError(AuthorizationException exception, AppAuthErrorCode defaultCode) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        Intrinsics.checkNotNullParameter(defaultCode, "defaultCode");
        AppAuthErrorCode oAuthErrorCode = getOAuthErrorCode(exception);
        if (oAuthErrorCode != null) {
            return new AuthError(oAuthErrorCode, exception.errorDescription, exception);
        }
        if (exception.type == 0) {
            return mapGeneralError(exception, defaultCode);
        }
        return new AuthError(defaultCode, exception.errorDescription, exception);
    }

    private final AppAuthErrorCode getOAuthErrorCode(AuthorizationException authorizationException) {
        int i = authorizationException.type;
        if (i == 1) {
            return getAuthorizationErrorCode(authorizationException);
        }
        if (i == 2) {
            return getTokenErrorCode(authorizationException);
        }
        if (i != 4) {
            return null;
        }
        return getRegistrationErrorCode(authorizationException);
    }

    private final AppAuthErrorCode getAuthorizationErrorCode(AuthorizationException authorizationException) {
        int i = authorizationException.code;
        if (i == AuthorizationException.AuthorizationRequestErrors.INVALID_REQUEST.code) {
            return AppAuthErrorCode.INVALID_REQUEST;
        }
        if (i == AuthorizationException.AuthorizationRequestErrors.UNAUTHORIZED_CLIENT.code) {
            return AppAuthErrorCode.UNAUTHORIZED_CLIENT;
        }
        if (i == AuthorizationException.AuthorizationRequestErrors.ACCESS_DENIED.code) {
            return AppAuthErrorCode.ACCESS_DENIED;
        }
        if (i == AuthorizationException.AuthorizationRequestErrors.UNSUPPORTED_RESPONSE_TYPE.code) {
            return AppAuthErrorCode.UNSUPPORTED_RESPONSE_TYPE;
        }
        if (i == AuthorizationException.AuthorizationRequestErrors.INVALID_SCOPE.code) {
            return AppAuthErrorCode.INVALID_SCOPE;
        }
        if (i == AuthorizationException.AuthorizationRequestErrors.SERVER_ERROR.code) {
            return AppAuthErrorCode.SERVER_ERROR;
        }
        if (i == AuthorizationException.AuthorizationRequestErrors.TEMPORARILY_UNAVAILABLE.code) {
            return AppAuthErrorCode.TEMPORARILY_UNAVAILABLE;
        }
        return null;
    }

    private final AppAuthErrorCode getTokenErrorCode(AuthorizationException authorizationException) {
        int i = authorizationException.code;
        if (i == AuthorizationException.TokenRequestErrors.INVALID_REQUEST.code) {
            return AppAuthErrorCode.INVALID_REQUEST;
        }
        if (i == AuthorizationException.TokenRequestErrors.INVALID_CLIENT.code) {
            return AppAuthErrorCode.INVALID_CLIENT;
        }
        if (i == AuthorizationException.TokenRequestErrors.INVALID_GRANT.code) {
            return AppAuthErrorCode.INVALID_GRANT;
        }
        if (i == AuthorizationException.TokenRequestErrors.UNAUTHORIZED_CLIENT.code) {
            return AppAuthErrorCode.UNAUTHORIZED_CLIENT;
        }
        if (i == AuthorizationException.TokenRequestErrors.UNSUPPORTED_GRANT_TYPE.code) {
            return AppAuthErrorCode.UNSUPPORTED_GRANT_TYPE;
        }
        if (i == AuthorizationException.TokenRequestErrors.INVALID_SCOPE.code) {
            return AppAuthErrorCode.INVALID_SCOPE;
        }
        return null;
    }

    private final AppAuthErrorCode getRegistrationErrorCode(AuthorizationException authorizationException) {
        int i = authorizationException.code;
        if (i == AuthorizationException.RegistrationRequestErrors.INVALID_REQUEST.code) {
            return AppAuthErrorCode.INVALID_REQUEST;
        }
        if (i == AuthorizationException.RegistrationRequestErrors.INVALID_REDIRECT_URI.code) {
            return AppAuthErrorCode.INVALID_REDIRECT_URI;
        }
        if (i == AuthorizationException.RegistrationRequestErrors.INVALID_CLIENT_METADATA.code) {
            return AppAuthErrorCode.INVALID_CLIENT_METADATA;
        }
        return null;
    }

    private final AuthError mapGeneralError(AuthorizationException authorizationException, AppAuthErrorCode appAuthErrorCode) {
        int i = authorizationException.code;
        if (i == AuthorizationException.GeneralErrors.USER_CANCELED_AUTH_FLOW.code) {
            appAuthErrorCode = AppAuthErrorCode.USER_CANCELLED;
        } else if (i == AuthorizationException.GeneralErrors.INVALID_REGISTRATION_RESPONSE.code) {
            appAuthErrorCode = AppAuthErrorCode.REGISTRATION_FAILED;
        }
        return new AuthError(appAuthErrorCode, authorizationException.errorDescription, authorizationException);
    }
}
