package net.openid.appauth;

import android.content.Intent;
import android.net.Uri;
import androidx.collection.ArrayMap;
import com.adjust.sdk.network.ErrorCodes;
import java.util.Collections;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class AuthorizationException extends Exception {
    public static final String EXTRA_EXCEPTION = "net.openid.appauth.AuthorizationException";
    private static final int HASH_MULTIPLIER = 31;
    static final String KEY_CODE = "code";
    static final String KEY_ERROR = "error";
    static final String KEY_ERROR_DESCRIPTION = "errorDescription";
    static final String KEY_ERROR_URI = "errorUri";
    static final String KEY_TYPE = "type";
    public static final String PARAM_ERROR = "error";
    public static final String PARAM_ERROR_DESCRIPTION = "error_description";
    public static final String PARAM_ERROR_URI = "error_uri";
    public static final int TYPE_GENERAL_ERROR = 0;
    public static final int TYPE_OAUTH_AUTHORIZATION_ERROR = 1;
    public static final int TYPE_OAUTH_REGISTRATION_ERROR = 4;
    public static final int TYPE_OAUTH_TOKEN_ERROR = 2;
    public static final int TYPE_RESOURCE_SERVER_AUTHORIZATION_ERROR = 3;
    public final int code;
    public final String error;
    public final String errorDescription;
    public final Uri errorUri;
    public final int type;

    public static final class GeneralErrors {
        public static final AuthorizationException INVALID_DISCOVERY_DOCUMENT = AuthorizationException.generalEx(0, "Invalid discovery document");
        public static final AuthorizationException USER_CANCELED_AUTH_FLOW = AuthorizationException.generalEx(1, "User cancelled flow");
        public static final AuthorizationException PROGRAM_CANCELED_AUTH_FLOW = AuthorizationException.generalEx(2, "Flow cancelled programmatically");
        public static final AuthorizationException NETWORK_ERROR = AuthorizationException.generalEx(3, "Network error");
        public static final AuthorizationException SERVER_ERROR = AuthorizationException.generalEx(4, "Server error");
        public static final AuthorizationException JSON_DESERIALIZATION_ERROR = AuthorizationException.generalEx(5, "JSON deserialization error");
        public static final AuthorizationException TOKEN_RESPONSE_CONSTRUCTION_ERROR = AuthorizationException.generalEx(6, "Token response construction error");
        public static final AuthorizationException INVALID_REGISTRATION_RESPONSE = AuthorizationException.generalEx(7, "Invalid registration response");
        public static final AuthorizationException ID_TOKEN_PARSING_ERROR = AuthorizationException.generalEx(8, "Unable to parse ID Token");
        public static final AuthorizationException ID_TOKEN_VALIDATION_ERROR = AuthorizationException.generalEx(9, "Invalid ID Token");
    }

    public static final class AuthorizationRequestErrors {
        public static final AuthorizationException ACCESS_DENIED;
        public static final AuthorizationException CLIENT_ERROR;
        public static final AuthorizationException INVALID_REQUEST;
        public static final AuthorizationException INVALID_SCOPE;
        public static final AuthorizationException OTHER;
        public static final AuthorizationException SERVER_ERROR;
        public static final AuthorizationException STATE_MISMATCH;
        private static final Map<String, AuthorizationException> STRING_TO_EXCEPTION;
        public static final AuthorizationException TEMPORARILY_UNAVAILABLE;
        public static final AuthorizationException UNAUTHORIZED_CLIENT;
        public static final AuthorizationException UNSUPPORTED_RESPONSE_TYPE;

        static {
            AuthorizationException authorizationExceptionAuthEx = AuthorizationException.authEx(1000, "invalid_request");
            INVALID_REQUEST = authorizationExceptionAuthEx;
            AuthorizationException authorizationExceptionAuthEx2 = AuthorizationException.authEx(1001, "unauthorized_client");
            UNAUTHORIZED_CLIENT = authorizationExceptionAuthEx2;
            AuthorizationException authorizationExceptionAuthEx3 = AuthorizationException.authEx(ErrorCodes.UNSUPPORTED_ENCODING_EXCEPTION, "access_denied");
            ACCESS_DENIED = authorizationExceptionAuthEx3;
            AuthorizationException authorizationExceptionAuthEx4 = AuthorizationException.authEx(ErrorCodes.MALFORMED_URL_EXCEPTION, "unsupported_response_type");
            UNSUPPORTED_RESPONSE_TYPE = authorizationExceptionAuthEx4;
            AuthorizationException authorizationExceptionAuthEx5 = AuthorizationException.authEx(ErrorCodes.PROTOCOL_EXCEPTION, "invalid_scope");
            INVALID_SCOPE = authorizationExceptionAuthEx5;
            AuthorizationException authorizationExceptionAuthEx6 = AuthorizationException.authEx(1005, "server_error");
            SERVER_ERROR = authorizationExceptionAuthEx6;
            AuthorizationException authorizationExceptionAuthEx7 = AuthorizationException.authEx(ErrorCodes.SSL_HANDSHAKE_EXCEPTION, "temporarily_unavailable");
            TEMPORARILY_UNAVAILABLE = authorizationExceptionAuthEx7;
            AuthorizationException authorizationExceptionAuthEx8 = AuthorizationException.authEx(ErrorCodes.IO_EXCEPTION, null);
            CLIENT_ERROR = authorizationExceptionAuthEx8;
            AuthorizationException authorizationExceptionAuthEx9 = AuthorizationException.authEx(1008, null);
            OTHER = authorizationExceptionAuthEx9;
            STATE_MISMATCH = AuthorizationException.generalEx(9, "Response state param did not match request state");
            STRING_TO_EXCEPTION = AuthorizationException.exceptionMapByString(authorizationExceptionAuthEx, authorizationExceptionAuthEx2, authorizationExceptionAuthEx3, authorizationExceptionAuthEx4, authorizationExceptionAuthEx5, authorizationExceptionAuthEx6, authorizationExceptionAuthEx7, authorizationExceptionAuthEx8, authorizationExceptionAuthEx9);
        }

        public static AuthorizationException byString(String str) {
            AuthorizationException authorizationException = STRING_TO_EXCEPTION.get(str);
            return authorizationException != null ? authorizationException : OTHER;
        }
    }

    public static final class TokenRequestErrors {
        public static final AuthorizationException CLIENT_ERROR;
        public static final AuthorizationException INVALID_CLIENT;
        public static final AuthorizationException INVALID_GRANT;
        public static final AuthorizationException INVALID_REQUEST;
        public static final AuthorizationException INVALID_SCOPE;
        public static final AuthorizationException OTHER;
        private static final Map<String, AuthorizationException> STRING_TO_EXCEPTION;
        public static final AuthorizationException UNAUTHORIZED_CLIENT;
        public static final AuthorizationException UNSUPPORTED_GRANT_TYPE;

        static {
            AuthorizationException authorizationException = AuthorizationException.tokenEx(2000, "invalid_request");
            INVALID_REQUEST = authorizationException;
            AuthorizationException authorizationException2 = AuthorizationException.tokenEx(2001, "invalid_client");
            INVALID_CLIENT = authorizationException2;
            AuthorizationException authorizationException3 = AuthorizationException.tokenEx(2002, "invalid_grant");
            INVALID_GRANT = authorizationException3;
            AuthorizationException authorizationException4 = AuthorizationException.tokenEx(2003, "unauthorized_client");
            UNAUTHORIZED_CLIENT = authorizationException4;
            AuthorizationException authorizationException5 = AuthorizationException.tokenEx(2004, "unsupported_grant_type");
            UNSUPPORTED_GRANT_TYPE = authorizationException5;
            AuthorizationException authorizationException6 = AuthorizationException.tokenEx(2005, "invalid_scope");
            INVALID_SCOPE = authorizationException6;
            AuthorizationException authorizationException7 = AuthorizationException.tokenEx(2006, null);
            CLIENT_ERROR = authorizationException7;
            AuthorizationException authorizationException8 = AuthorizationException.tokenEx(2007, null);
            OTHER = authorizationException8;
            STRING_TO_EXCEPTION = AuthorizationException.exceptionMapByString(authorizationException, authorizationException2, authorizationException3, authorizationException4, authorizationException5, authorizationException6, authorizationException7, authorizationException8);
        }

        public static AuthorizationException byString(String str) {
            AuthorizationException authorizationException = STRING_TO_EXCEPTION.get(str);
            return authorizationException != null ? authorizationException : OTHER;
        }
    }

    public static final class RegistrationRequestErrors {
        public static final AuthorizationException CLIENT_ERROR;
        public static final AuthorizationException INVALID_CLIENT_METADATA;
        public static final AuthorizationException INVALID_REDIRECT_URI;
        public static final AuthorizationException INVALID_REQUEST;
        public static final AuthorizationException OTHER;
        private static final Map<String, AuthorizationException> STRING_TO_EXCEPTION;

        static {
            AuthorizationException authorizationExceptionRegistrationEx = AuthorizationException.registrationEx(4000, "invalid_request");
            INVALID_REQUEST = authorizationExceptionRegistrationEx;
            AuthorizationException authorizationExceptionRegistrationEx2 = AuthorizationException.registrationEx(4001, "invalid_redirect_uri");
            INVALID_REDIRECT_URI = authorizationExceptionRegistrationEx2;
            AuthorizationException authorizationExceptionRegistrationEx3 = AuthorizationException.registrationEx(4002, "invalid_client_metadata");
            INVALID_CLIENT_METADATA = authorizationExceptionRegistrationEx3;
            AuthorizationException authorizationExceptionRegistrationEx4 = AuthorizationException.registrationEx(4003, null);
            CLIENT_ERROR = authorizationExceptionRegistrationEx4;
            AuthorizationException authorizationExceptionRegistrationEx5 = AuthorizationException.registrationEx(4004, null);
            OTHER = authorizationExceptionRegistrationEx5;
            STRING_TO_EXCEPTION = AuthorizationException.exceptionMapByString(authorizationExceptionRegistrationEx, authorizationExceptionRegistrationEx2, authorizationExceptionRegistrationEx3, authorizationExceptionRegistrationEx4, authorizationExceptionRegistrationEx5);
        }

        public static AuthorizationException byString(String str) {
            AuthorizationException authorizationException = STRING_TO_EXCEPTION.get(str);
            return authorizationException != null ? authorizationException : OTHER;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AuthorizationException generalEx(int i, String str) {
        return new AuthorizationException(0, i, null, str, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AuthorizationException authEx(int i, String str) {
        return new AuthorizationException(1, i, str, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AuthorizationException tokenEx(int i, String str) {
        return new AuthorizationException(2, i, str, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AuthorizationException registrationEx(int i, String str) {
        return new AuthorizationException(4, i, str, null, null, null);
    }

    public static AuthorizationException fromTemplate(AuthorizationException authorizationException, Throwable th) {
        return new AuthorizationException(authorizationException.type, authorizationException.code, authorizationException.error, authorizationException.errorDescription, authorizationException.errorUri, th);
    }

    public static AuthorizationException fromOAuthTemplate(AuthorizationException authorizationException, String str, String str2, Uri uri) {
        int i = authorizationException.type;
        int i2 = authorizationException.code;
        if (str == null) {
            str = authorizationException.error;
        }
        String str3 = str;
        if (str2 == null) {
            str2 = authorizationException.errorDescription;
        }
        String str4 = str2;
        if (uri == null) {
            uri = authorizationException.errorUri;
        }
        return new AuthorizationException(i, i2, str3, str4, uri, null);
    }

    public static AuthorizationException fromOAuthRedirect(Uri uri) {
        String queryParameter = uri.getQueryParameter("error");
        String queryParameter2 = uri.getQueryParameter(PARAM_ERROR_DESCRIPTION);
        String queryParameter3 = uri.getQueryParameter(PARAM_ERROR_URI);
        AuthorizationException authorizationExceptionByString = AuthorizationRequestErrors.byString(queryParameter);
        int i = authorizationExceptionByString.type;
        int i2 = authorizationExceptionByString.code;
        if (queryParameter2 == null) {
            queryParameter2 = authorizationExceptionByString.errorDescription;
        }
        return new AuthorizationException(i, i2, queryParameter, queryParameter2, queryParameter3 != null ? Uri.parse(queryParameter3) : authorizationExceptionByString.errorUri, null);
    }

    public static AuthorizationException fromJson(String str) throws JSONException {
        Preconditions.checkNotEmpty(str, "jsonStr cannot be null or empty");
        return fromJson(new JSONObject(str));
    }

    public static AuthorizationException fromJson(JSONObject jSONObject) throws JSONException {
        Preconditions.checkNotNull(jSONObject, "json cannot be null");
        return new AuthorizationException(jSONObject.getInt(KEY_TYPE), jSONObject.getInt("code"), JsonUtil.getStringIfDefined(jSONObject, "error"), JsonUtil.getStringIfDefined(jSONObject, KEY_ERROR_DESCRIPTION), JsonUtil.getUriIfDefined(jSONObject, KEY_ERROR_URI), null);
    }

    public static AuthorizationException fromIntent(Intent intent) {
        Preconditions.checkNotNull(intent);
        if (!intent.hasExtra(EXTRA_EXCEPTION)) {
            return null;
        }
        try {
            return fromJson(intent.getStringExtra(EXTRA_EXCEPTION));
        } catch (JSONException e) {
            throw new IllegalArgumentException("Intent contains malformed exception data", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, AuthorizationException> exceptionMapByString(AuthorizationException... authorizationExceptionArr) {
        ArrayMap arrayMap = new ArrayMap(authorizationExceptionArr != null ? authorizationExceptionArr.length : 0);
        if (authorizationExceptionArr != null) {
            for (AuthorizationException authorizationException : authorizationExceptionArr) {
                String str = authorizationException.error;
                if (str != null) {
                    arrayMap.put(str, authorizationException);
                }
            }
        }
        return Collections.unmodifiableMap(arrayMap);
    }

    public AuthorizationException(int i, int i2, String str, String str2, Uri uri, Throwable th) {
        super(str2, th);
        this.type = i;
        this.code = i2;
        this.error = str;
        this.errorDescription = str2;
        this.errorUri = uri;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        JsonUtil.put(jSONObject, KEY_TYPE, this.type);
        JsonUtil.put(jSONObject, "code", this.code);
        JsonUtil.putIfNotNull(jSONObject, "error", this.error);
        JsonUtil.putIfNotNull(jSONObject, KEY_ERROR_DESCRIPTION, this.errorDescription);
        JsonUtil.putIfNotNull(jSONObject, KEY_ERROR_URI, this.errorUri);
        return jSONObject;
    }

    public String toJsonString() {
        return toJson().toString();
    }

    public Intent toIntent() {
        Intent intent = new Intent();
        intent.putExtra(EXTRA_EXCEPTION, toJsonString());
        return intent;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof AuthorizationException)) {
            AuthorizationException authorizationException = (AuthorizationException) obj;
            if (this.type == authorizationException.type && this.code == authorizationException.code) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.type + 31) * 31) + this.code;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "AuthorizationException: " + toJsonString();
    }
}
