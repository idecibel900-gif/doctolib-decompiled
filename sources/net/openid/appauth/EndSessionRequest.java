package net.openid.appauth;

import android.net.Uri;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import net.openid.appauth.internal.UriUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class EndSessionRequest implements AuthorizationManagementRequest {
    private static final Set<String> BUILT_IN_PARAMS = AdditionalParamsProcessor.builtInParams("id_token_hint", "post_logout_redirect_uri", "state", "ui_locales");
    private static final String KEY_ADDITIONAL_PARAMETERS = "additionalParameters";
    private static final String KEY_CONFIGURATION = "configuration";
    private static final String KEY_ID_TOKEN_HINT = "id_token_hint";
    private static final String KEY_POST_LOGOUT_REDIRECT_URI = "post_logout_redirect_uri";
    private static final String KEY_STATE = "state";
    private static final String KEY_UI_LOCALES = "ui_locales";
    static final String PARAM_ID_TOKEN_HINT = "id_token_hint";
    static final String PARAM_POST_LOGOUT_REDIRECT_URI = "post_logout_redirect_uri";
    static final String PARAM_STATE = "state";
    static final String PARAM_UI_LOCALES = "ui_locales";
    public final Map<String, String> additionalParameters;
    public final AuthorizationServiceConfiguration configuration;
    public final String idTokenHint;
    public final Uri postLogoutRedirectUri;
    public final String state;
    public final String uiLocales;

    public static final class Builder {
        private Map<String, String> mAdditionalParameters = new HashMap();
        private AuthorizationServiceConfiguration mConfiguration;
        private String mIdTokenHint;
        private Uri mPostLogoutRedirectUri;
        private String mState;
        private String mUiLocales;

        public Builder(AuthorizationServiceConfiguration authorizationServiceConfiguration) {
            setAuthorizationServiceConfiguration(authorizationServiceConfiguration);
            setState(AuthorizationManagementUtil.generateRandomState());
        }

        public Builder setAuthorizationServiceConfiguration(AuthorizationServiceConfiguration authorizationServiceConfiguration) {
            this.mConfiguration = (AuthorizationServiceConfiguration) Preconditions.checkNotNull(authorizationServiceConfiguration, "configuration cannot be null");
            return this;
        }

        public Builder setIdTokenHint(String str) {
            this.mIdTokenHint = Preconditions.checkNullOrNotEmpty(str, "idTokenHint must not be empty");
            return this;
        }

        public Builder setPostLogoutRedirectUri(Uri uri) {
            this.mPostLogoutRedirectUri = uri;
            return this;
        }

        public Builder setState(String str) {
            this.mState = Preconditions.checkNullOrNotEmpty(str, "state must not be empty");
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

        public Builder setAdditionalParameters(Map<String, String> map) {
            this.mAdditionalParameters = AdditionalParamsProcessor.checkAdditionalParams(map, EndSessionRequest.BUILT_IN_PARAMS);
            return this;
        }

        public EndSessionRequest build() {
            return new EndSessionRequest(this.mConfiguration, this.mIdTokenHint, this.mPostLogoutRedirectUri, this.mState, this.mUiLocales, Collections.unmodifiableMap(new HashMap(this.mAdditionalParameters)));
        }
    }

    private EndSessionRequest(AuthorizationServiceConfiguration authorizationServiceConfiguration, String str, Uri uri, String str2, String str3, Map<String, String> map) {
        this.configuration = authorizationServiceConfiguration;
        this.idTokenHint = str;
        this.postLogoutRedirectUri = uri;
        this.state = str2;
        this.uiLocales = str3;
        this.additionalParameters = map;
    }

    @Override // net.openid.appauth.AuthorizationManagementRequest
    public String getState() {
        return this.state;
    }

    public Set<String> getUiLocales() {
        return AsciiStringListUtil.stringToSet(this.uiLocales);
    }

    @Override // net.openid.appauth.AuthorizationManagementRequest
    public Uri toUri() {
        Uri.Builder builderBuildUpon = this.configuration.endSessionEndpoint.buildUpon();
        UriUtil.appendQueryParameterIfNotNull(builderBuildUpon, "id_token_hint", this.idTokenHint);
        UriUtil.appendQueryParameterIfNotNull(builderBuildUpon, "state", this.state);
        UriUtil.appendQueryParameterIfNotNull(builderBuildUpon, "ui_locales", this.uiLocales);
        Uri uri = this.postLogoutRedirectUri;
        if (uri != null) {
            builderBuildUpon.appendQueryParameter("post_logout_redirect_uri", uri.toString());
        }
        for (Map.Entry<String, String> entry : this.additionalParameters.entrySet()) {
            builderBuildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        return builderBuildUpon.build();
    }

    @Override // net.openid.appauth.AuthorizationManagementRequest
    public JSONObject jsonSerialize() {
        JSONObject jSONObject = new JSONObject();
        JsonUtil.put(jSONObject, KEY_CONFIGURATION, this.configuration.toJson());
        JsonUtil.putIfNotNull(jSONObject, "id_token_hint", this.idTokenHint);
        JsonUtil.putIfNotNull(jSONObject, "post_logout_redirect_uri", this.postLogoutRedirectUri);
        JsonUtil.putIfNotNull(jSONObject, "state", this.state);
        JsonUtil.putIfNotNull(jSONObject, "ui_locales", this.uiLocales);
        JsonUtil.put(jSONObject, KEY_ADDITIONAL_PARAMETERS, JsonUtil.mapToJsonObject(this.additionalParameters));
        return jSONObject;
    }

    @Override // net.openid.appauth.AuthorizationManagementRequest
    public String jsonSerializeString() {
        return jsonSerialize().toString();
    }

    public static EndSessionRequest jsonDeserialize(JSONObject jSONObject) throws JSONException {
        Preconditions.checkNotNull(jSONObject, "json cannot be null");
        return new EndSessionRequest(AuthorizationServiceConfiguration.fromJson(jSONObject.getJSONObject(KEY_CONFIGURATION)), JsonUtil.getStringIfDefined(jSONObject, "id_token_hint"), JsonUtil.getUriIfDefined(jSONObject, "post_logout_redirect_uri"), JsonUtil.getStringIfDefined(jSONObject, "state"), JsonUtil.getStringIfDefined(jSONObject, "ui_locales"), JsonUtil.getStringMap(jSONObject, KEY_ADDITIONAL_PARAMETERS));
    }

    public static EndSessionRequest jsonDeserialize(String str) throws JSONException {
        Preconditions.checkNotNull(str, "json string cannot be null");
        return jsonDeserialize(new JSONObject(str));
    }
}
