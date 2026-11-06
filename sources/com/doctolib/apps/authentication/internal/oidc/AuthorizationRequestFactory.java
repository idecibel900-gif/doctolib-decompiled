package com.doctolib.apps.authentication.internal.oidc;

import android.net.Uri;
import com.doctolib.apps.authentication.config.AuthConfig;
import com.google.firebase.messaging.Constants;
import java.util.Arrays;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.openid.appauth.AuthorizationRequest;
import net.openid.appauth.AuthorizationServiceConfiguration;
import net.openid.appauth.ResponseTypeValues;

/* JADX INFO: loaded from: classes3.dex */
public final class AuthorizationRequestFactory {
    private static final Companion Companion = new Companion(null);

    public final AuthorizationRequest create(AuthorizationServiceConfiguration serviceConfig, AuthConfig config, Map map) {
        Intrinsics.checkNotNullParameter(serviceConfig, "serviceConfig");
        Intrinsics.checkNotNullParameter(config, "config");
        Map additionalParameters = config.getAdditionalParameters();
        if (additionalParameters == null) {
            additionalParameters = MapsKt.emptyMap();
        }
        if (map == null) {
            map = MapsKt.emptyMap();
        }
        Map mapPlus = MapsKt.plus(additionalParameters, map);
        String str = (String) mapPlus.get("ui_locales");
        if (str == null || StringsKt.isBlank(str)) {
            str = null;
        }
        String str2 = (String) mapPlus.get("prompt");
        if (str2 == null || StringsKt.isBlank(str2)) {
            str2 = null;
        }
        String str3 = (String) mapPlus.get("login_hint");
        if (str3 == null || StringsKt.isBlank(str3)) {
            str3 = null;
        }
        String str4 = (String) mapPlus.get(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION);
        if (str4 == null || StringsKt.isBlank(str4)) {
            str4 = null;
        }
        Map<String, String> mapMinus = MapsKt.minus(MapsKt.minus(MapsKt.minus(MapsKt.minus(mapPlus, "ui_locales"), "prompt"), "login_hint"), Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION);
        AuthorizationRequest.Builder builder = new AuthorizationRequest.Builder(serviceConfig, config.getClientId(), ResponseTypeValues.CODE, Uri.parse(config.getRedirectUrl()));
        String[] strArr = (String[]) config.getScopes().toArray(new String[0]);
        builder.setScopes((String[]) Arrays.copyOf(strArr, strArr.length));
        if (!config.getUsePKCE()) {
            builder.setCodeVerifier(null);
        }
        if (!config.getUseNonce()) {
            builder.setNonce(null);
        }
        if (str != null) {
            builder.setUiLocales(str);
        }
        if (str2 != null) {
            builder.setPrompt(str2);
        }
        if (str3 != null) {
            builder.setLoginHint(str3);
        }
        if (str4 != null) {
            builder.setDisplay(str4);
        }
        if (!mapMinus.isEmpty()) {
            builder.setAdditionalParameters(mapMinus);
        }
        AuthorizationRequest authorizationRequestBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(authorizationRequestBuild, "build(...)");
        return authorizationRequestBuild;
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
