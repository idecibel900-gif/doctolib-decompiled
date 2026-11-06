package net.openid.appauth;

import android.net.Uri;
import android.text.TextUtils;
import com.google.firebase.messaging.Constants;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import net.openid.appauth.internal.UriUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class AuthorizationRequest implements AuthorizationManagementRequest {
    public static final String CODE_CHALLENGE_METHOD_PLAIN = "plain";
    public static final String CODE_CHALLENGE_METHOD_S256 = "S256";
    private static final String KEY_ADDITIONAL_PARAMETERS = "additionalParameters";
    private static final String KEY_CLAIMS = "claims";
    private static final String KEY_CLAIMS_LOCALES = "claimsLocales";
    private static final String KEY_CLIENT_ID = "clientId";
    private static final String KEY_CODE_VERIFIER = "codeVerifier";
    private static final String KEY_CODE_VERIFIER_CHALLENGE = "codeVerifierChallenge";
    private static final String KEY_CODE_VERIFIER_CHALLENGE_METHOD = "codeVerifierChallengeMethod";
    private static final String KEY_CONFIGURATION = "configuration";
    private static final String KEY_DISPLAY = "display";
    private static final String KEY_LOGIN_HINT = "login_hint";
    private static final String KEY_NONCE = "nonce";
    private static final String KEY_PROMPT = "prompt";
    private static final String KEY_REDIRECT_URI = "redirectUri";
    private static final String KEY_RESPONSE_MODE = "responseMode";
    private static final String KEY_RESPONSE_TYPE = "responseType";
    private static final String KEY_SCOPE = "scope";
    private static final String KEY_STATE = "state";
    private static final String KEY_UI_LOCALES = "ui_locales";
    static final String PARAM_CLAIMS = "claims";
    static final String PARAM_CLIENT_ID = "client_id";
    static final String PARAM_DISPLAY = "display";
    static final String PARAM_LOGIN_HINT = "login_hint";
    static final String PARAM_NONCE = "nonce";
    static final String PARAM_PROMPT = "prompt";
    static final String PARAM_SCOPE = "scope";
    static final String PARAM_STATE = "state";
    static final String PARAM_UI_LOCALES = "ui_locales";
    public final Map<String, String> additionalParameters;
    public final JSONObject claims;
    public final String claimsLocales;
    public final String clientId;
    public final String codeVerifier;
    public final String codeVerifierChallenge;
    public final String codeVerifierChallengeMethod;
    public final AuthorizationServiceConfiguration configuration;
    public final String display;
    public final String loginHint;
    public final String nonce;
    public final String prompt;
    public final Uri redirectUri;
    public final String responseMode;
    public final String responseType;
    public final String scope;
    public final String state;
    public final String uiLocales;
    static final String PARAM_CODE_CHALLENGE = "code_challenge";
    static final String PARAM_CODE_CHALLENGE_METHOD = "code_challenge_method";
    static final String PARAM_REDIRECT_URI = "redirect_uri";
    static final String PARAM_RESPONSE_MODE = "response_mode";
    static final String PARAM_RESPONSE_TYPE = "response_type";
    static final String PARAM_CLAIMS_LOCALES = "claims_locales";
    private static final Set<String> BUILT_IN_PARAMS = AdditionalParamsProcessor.builtInParams("client_id", PARAM_CODE_CHALLENGE, PARAM_CODE_CHALLENGE_METHOD, Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION, "login_hint", "prompt", "ui_locales", PARAM_REDIRECT_URI, PARAM_RESPONSE_MODE, PARAM_RESPONSE_TYPE, "scope", "state", "claims", PARAM_CLAIMS_LOCALES);

    public static final class Display {
        public static final String PAGE = "page";
        public static final String POPUP = "popup";
        public static final String TOUCH = "touch";
        public static final String WAP = "wap";
    }

    public static final class Prompt {
        public static final String CONSENT = "consent";
        public static final String LOGIN = "login";
        public static final String NONE = "none";
        public static final String SELECT_ACCOUNT = "select_account";
    }

    public static final class ResponseMode {
        public static final String FRAGMENT = "fragment";
        public static final String QUERY = "query";
    }

    public static final class Scope {
        public static final String ADDRESS = "address";
        public static final String EMAIL = "email";
        public static final String OFFLINE_ACCESS = "offline_access";
        public static final String OPENID = "openid";
        public static final String PHONE = "phone";
        public static final String PROFILE = "profile";
    }

    public static final class Builder {
        private Map<String, String> mAdditionalParameters = new HashMap();
        private JSONObject mClaims;
        private String mClaimsLocales;
        private String mClientId;
        private String mCodeVerifier;
        private String mCodeVerifierChallenge;
        private String mCodeVerifierChallengeMethod;
        private AuthorizationServiceConfiguration mConfiguration;
        private String mDisplay;
        private String mLoginHint;
        private String mNonce;
        private String mPrompt;
        private Uri mRedirectUri;
        private String mResponseMode;
        private String mResponseType;
        private String mScope;
        private String mState;
        private String mUiLocales;

        public Builder(AuthorizationServiceConfiguration authorizationServiceConfiguration, String str, String str2, Uri uri) {
            setAuthorizationServiceConfiguration(authorizationServiceConfiguration);
            setClientId(str);
            setResponseType(str2);
            setRedirectUri(uri);
            setState(AuthorizationManagementUtil.generateRandomState());
            setNonce(AuthorizationManagementUtil.generateRandomState());
            setCodeVerifier(CodeVerifierUtil.generateRandomCodeVerifier());
        }

        public Builder setAuthorizationServiceConfiguration(AuthorizationServiceConfiguration authorizationServiceConfiguration) {
            this.mConfiguration = (AuthorizationServiceConfiguration) Preconditions.checkNotNull(authorizationServiceConfiguration, "configuration cannot be null");
            return this;
        }

        public Builder setClientId(String str) {
            this.mClientId = Preconditions.checkNotEmpty(str, "client ID cannot be null or empty");
            return this;
        }

        public Builder setDisplay(String str) {
            this.mDisplay = Preconditions.checkNullOrNotEmpty(str, "display must be null or not empty");
            return this;
        }

        public Builder setLoginHint(String str) {
            this.mLoginHint = Preconditions.checkNullOrNotEmpty(str, "login hint must be null or not empty");
            return this;
        }

        public Builder setPrompt(String str) {
            this.mPrompt = Preconditions.checkNullOrNotEmpty(str, "prompt must be null or non-empty");
            return this;
        }

        public Builder setPromptValues(String... strArr) {
            if (strArr == null) {
                this.mPrompt = null;
                return this;
            }
            return setPromptValues(Arrays.asList(strArr));
        }

        public Builder setPromptValues(Iterable<String> iterable) {
            this.mPrompt = AsciiStringListUtil.iterableToString(iterable);
            return this;
        }

        public Builder setUiLocales(String str) {
            this.mUiLocales = Preconditions.checkNullOrNotEmpty(str, "uiLocales must be null or not empty");
            return this;
        }

        public Builder setUiLocalesValues(String... strArr) {
            if (strArr == null) {
                this.mUiLocales = null;
                return this;
            }
            return setUiLocalesValues(Arrays.asList(strArr));
        }

        public Builder setUiLocalesValues(Iterable<String> iterable) {
            this.mUiLocales = AsciiStringListUtil.iterableToString(iterable);
            return this;
        }

        public Builder setResponseType(String str) {
            this.mResponseType = Preconditions.checkNotEmpty(str, "expected response type cannot be null or empty");
            return this;
        }

        public Builder setRedirectUri(Uri uri) {
            this.mRedirectUri = (Uri) Preconditions.checkNotNull(uri, "redirect URI cannot be null or empty");
            return this;
        }

        public Builder setScope(String str) {
            if (TextUtils.isEmpty(str)) {
                this.mScope = null;
                return this;
            }
            setScopes(str.split(" +"));
            return this;
        }

        public Builder setScopes(String... strArr) {
            if (strArr == null) {
                strArr = new String[0];
            }
            setScopes(Arrays.asList(strArr));
            return this;
        }

        public Builder setScopes(Iterable<String> iterable) {
            this.mScope = AsciiStringListUtil.iterableToString(iterable);
            return this;
        }

        public Builder setState(String str) {
            this.mState = Preconditions.checkNullOrNotEmpty(str, "state cannot be empty if defined");
            return this;
        }

        public Builder setNonce(String str) {
            this.mNonce = Preconditions.checkNullOrNotEmpty(str, "nonce cannot be empty if defined");
            return this;
        }

        public Builder setCodeVerifier(String str) {
            if (str != null) {
                CodeVerifierUtil.checkCodeVerifier(str);
                this.mCodeVerifier = str;
                this.mCodeVerifierChallenge = CodeVerifierUtil.deriveCodeVerifierChallenge(str);
                this.mCodeVerifierChallengeMethod = CodeVerifierUtil.getCodeVerifierChallengeMethod();
                return this;
            }
            this.mCodeVerifier = null;
            this.mCodeVerifierChallenge = null;
            this.mCodeVerifierChallengeMethod = null;
            return this;
        }

        public Builder setCodeVerifier(String str, String str2, String str3) {
            if (str != null) {
                CodeVerifierUtil.checkCodeVerifier(str);
                Preconditions.checkNotEmpty(str2, "code verifier challenge cannot be null or empty if verifier is set");
                Preconditions.checkNotEmpty(str3, "code verifier challenge method cannot be null or empty if verifier is set");
            } else {
                Preconditions.checkArgument(str2 == null, "code verifier challenge must be null if verifier is null");
                Preconditions.checkArgument(str3 == null, "code verifier challenge method must be null if verifier is null");
            }
            this.mCodeVerifier = str;
            this.mCodeVerifierChallenge = str2;
            this.mCodeVerifierChallengeMethod = str3;
            return this;
        }

        public Builder setResponseMode(String str) {
            Preconditions.checkNullOrNotEmpty(str, "responseMode must not be empty");
            this.mResponseMode = str;
            return this;
        }

        public Builder setClaims(JSONObject jSONObject) {
            this.mClaims = jSONObject;
            return this;
        }

        public Builder setClaimsLocales(String str) {
            this.mClaimsLocales = Preconditions.checkNullOrNotEmpty(str, "claimsLocales must be null or not empty");
            return this;
        }

        public Builder setClaimsLocalesValues(String... strArr) {
            if (strArr == null) {
                this.mClaimsLocales = null;
                return this;
            }
            return setClaimsLocalesValues(Arrays.asList(strArr));
        }

        public Builder setClaimsLocalesValues(Iterable<String> iterable) {
            this.mClaimsLocales = AsciiStringListUtil.iterableToString(iterable);
            return this;
        }

        public Builder setAdditionalParameters(Map<String, String> map) {
            this.mAdditionalParameters = AdditionalParamsProcessor.checkAdditionalParams(map, AuthorizationRequest.BUILT_IN_PARAMS);
            return this;
        }

        public AuthorizationRequest build() {
            return new AuthorizationRequest(this.mConfiguration, this.mClientId, this.mResponseType, this.mRedirectUri, this.mDisplay, this.mLoginHint, this.mPrompt, this.mUiLocales, this.mScope, this.mState, this.mNonce, this.mCodeVerifier, this.mCodeVerifierChallenge, this.mCodeVerifierChallengeMethod, this.mResponseMode, this.mClaims, this.mClaimsLocales, Collections.unmodifiableMap(new HashMap(this.mAdditionalParameters)));
        }
    }

    private AuthorizationRequest(AuthorizationServiceConfiguration authorizationServiceConfiguration, String str, String str2, Uri uri, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, JSONObject jSONObject, String str14, Map<String, String> map) {
        this.configuration = authorizationServiceConfiguration;
        this.clientId = str;
        this.responseType = str2;
        this.redirectUri = uri;
        this.additionalParameters = map;
        this.display = str3;
        this.loginHint = str4;
        this.prompt = str5;
        this.uiLocales = str6;
        this.scope = str7;
        this.state = str8;
        this.nonce = str9;
        this.codeVerifier = str10;
        this.codeVerifierChallenge = str11;
        this.codeVerifierChallengeMethod = str12;
        this.responseMode = str13;
        this.claims = jSONObject;
        this.claimsLocales = str14;
    }

    public Set<String> getScopeSet() {
        return AsciiStringListUtil.stringToSet(this.scope);
    }

    public Set<String> getPromptValues() {
        return AsciiStringListUtil.stringToSet(this.prompt);
    }

    public Set<String> getUiLocales() {
        return AsciiStringListUtil.stringToSet(this.uiLocales);
    }

    @Override // net.openid.appauth.AuthorizationManagementRequest
    public String getState() {
        return this.state;
    }

    public Set<String> getClaimsLocales() {
        return AsciiStringListUtil.stringToSet(this.claimsLocales);
    }

    @Override // net.openid.appauth.AuthorizationManagementRequest
    public Uri toUri() {
        Uri.Builder builderAppendQueryParameter = this.configuration.authorizationEndpoint.buildUpon().appendQueryParameter(PARAM_REDIRECT_URI, this.redirectUri.toString()).appendQueryParameter("client_id", this.clientId).appendQueryParameter(PARAM_RESPONSE_TYPE, this.responseType);
        UriUtil.appendQueryParameterIfNotNull(builderAppendQueryParameter, Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION, this.display);
        UriUtil.appendQueryParameterIfNotNull(builderAppendQueryParameter, "login_hint", this.loginHint);
        UriUtil.appendQueryParameterIfNotNull(builderAppendQueryParameter, "prompt", this.prompt);
        UriUtil.appendQueryParameterIfNotNull(builderAppendQueryParameter, "ui_locales", this.uiLocales);
        UriUtil.appendQueryParameterIfNotNull(builderAppendQueryParameter, "state", this.state);
        UriUtil.appendQueryParameterIfNotNull(builderAppendQueryParameter, "nonce", this.nonce);
        UriUtil.appendQueryParameterIfNotNull(builderAppendQueryParameter, "scope", this.scope);
        UriUtil.appendQueryParameterIfNotNull(builderAppendQueryParameter, PARAM_RESPONSE_MODE, this.responseMode);
        if (this.codeVerifier != null) {
            builderAppendQueryParameter.appendQueryParameter(PARAM_CODE_CHALLENGE, this.codeVerifierChallenge).appendQueryParameter(PARAM_CODE_CHALLENGE_METHOD, this.codeVerifierChallengeMethod);
        }
        UriUtil.appendQueryParameterIfNotNull(builderAppendQueryParameter, "claims", this.claims);
        UriUtil.appendQueryParameterIfNotNull(builderAppendQueryParameter, PARAM_CLAIMS_LOCALES, this.claimsLocales);
        for (Map.Entry<String, String> entry : this.additionalParameters.entrySet()) {
            builderAppendQueryParameter.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        return builderAppendQueryParameter.build();
    }

    @Override // net.openid.appauth.AuthorizationManagementRequest
    public JSONObject jsonSerialize() {
        JSONObject jSONObject = new JSONObject();
        JsonUtil.put(jSONObject, KEY_CONFIGURATION, this.configuration.toJson());
        JsonUtil.put(jSONObject, KEY_CLIENT_ID, this.clientId);
        JsonUtil.put(jSONObject, KEY_RESPONSE_TYPE, this.responseType);
        JsonUtil.put(jSONObject, KEY_REDIRECT_URI, this.redirectUri.toString());
        JsonUtil.putIfNotNull(jSONObject, Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION, this.display);
        JsonUtil.putIfNotNull(jSONObject, "login_hint", this.loginHint);
        JsonUtil.putIfNotNull(jSONObject, "scope", this.scope);
        JsonUtil.putIfNotNull(jSONObject, "prompt", this.prompt);
        JsonUtil.putIfNotNull(jSONObject, "ui_locales", this.uiLocales);
        JsonUtil.putIfNotNull(jSONObject, "state", this.state);
        JsonUtil.putIfNotNull(jSONObject, "nonce", this.nonce);
        JsonUtil.putIfNotNull(jSONObject, KEY_CODE_VERIFIER, this.codeVerifier);
        JsonUtil.putIfNotNull(jSONObject, KEY_CODE_VERIFIER_CHALLENGE, this.codeVerifierChallenge);
        JsonUtil.putIfNotNull(jSONObject, KEY_CODE_VERIFIER_CHALLENGE_METHOD, this.codeVerifierChallengeMethod);
        JsonUtil.putIfNotNull(jSONObject, KEY_RESPONSE_MODE, this.responseMode);
        JsonUtil.putIfNotNull(jSONObject, "claims", this.claims);
        JsonUtil.putIfNotNull(jSONObject, KEY_CLAIMS_LOCALES, this.claimsLocales);
        JsonUtil.put(jSONObject, KEY_ADDITIONAL_PARAMETERS, JsonUtil.mapToJsonObject(this.additionalParameters));
        return jSONObject;
    }

    @Override // net.openid.appauth.AuthorizationManagementRequest
    public String jsonSerializeString() {
        return jsonSerialize().toString();
    }

    public static AuthorizationRequest jsonDeserialize(JSONObject jSONObject) throws JSONException {
        Preconditions.checkNotNull(jSONObject, "json cannot be null");
        return new AuthorizationRequest(AuthorizationServiceConfiguration.fromJson(jSONObject.getJSONObject(KEY_CONFIGURATION)), JsonUtil.getString(jSONObject, KEY_CLIENT_ID), JsonUtil.getString(jSONObject, KEY_RESPONSE_TYPE), JsonUtil.getUri(jSONObject, KEY_REDIRECT_URI), JsonUtil.getStringIfDefined(jSONObject, Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION), JsonUtil.getStringIfDefined(jSONObject, "login_hint"), JsonUtil.getStringIfDefined(jSONObject, "prompt"), JsonUtil.getStringIfDefined(jSONObject, "ui_locales"), JsonUtil.getStringIfDefined(jSONObject, "scope"), JsonUtil.getStringIfDefined(jSONObject, "state"), JsonUtil.getStringIfDefined(jSONObject, "nonce"), JsonUtil.getStringIfDefined(jSONObject, KEY_CODE_VERIFIER), JsonUtil.getStringIfDefined(jSONObject, KEY_CODE_VERIFIER_CHALLENGE), JsonUtil.getStringIfDefined(jSONObject, KEY_CODE_VERIFIER_CHALLENGE_METHOD), JsonUtil.getStringIfDefined(jSONObject, KEY_RESPONSE_MODE), JsonUtil.getJsonObjectIfDefined(jSONObject, "claims"), JsonUtil.getStringIfDefined(jSONObject, KEY_CLAIMS_LOCALES), JsonUtil.getStringMap(jSONObject, KEY_ADDITIONAL_PARAMETERS));
    }

    public static AuthorizationRequest jsonDeserialize(String str) throws JSONException {
        Preconditions.checkNotNull(str, "json string cannot be null");
        return jsonDeserialize(new JSONObject(str));
    }
}
