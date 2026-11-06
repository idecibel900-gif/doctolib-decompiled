package com.doctolib.apps.authentication.internal.devicekey;

import android.net.Uri;
import com.doctolib.apps.authentication.error.AppAuthErrorCode;
import com.doctolib.apps.authentication.error.AuthError;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class KeycloakDeviceKeyRegistrar implements DeviceKeyRegistrar {
    private static final Companion Companion = new Companion(null);
    private final Map customHeaders;

    public KeycloakDeviceKeyRegistrar(Map map) {
        this.customHeaders = map;
    }

    /* JADX INFO: renamed from: com.doctolib.apps.authentication.internal.devicekey.KeycloakDeviceKeyRegistrar$register$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2 {
        final /* synthetic */ String $accessToken;
        final /* synthetic */ String $issuer;
        final /* synthetic */ String $publicJwk;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, String str2, String str3, Continuation continuation) {
            super(2, continuation);
            this.$issuer = str;
            this.$accessToken = str2;
            this.$publicJwk = str3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return KeycloakDeviceKeyRegistrar.this.new AnonymousClass2(this.$issuer, this.$accessToken, this.$publicJwk, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws AuthError {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                KeycloakDeviceKeyRegistrar keycloakDeviceKeyRegistrar = KeycloakDeviceKeyRegistrar.this;
                String strDeviceKeyUrl = keycloakDeviceKeyRegistrar.deviceKeyUrl(this.$issuer);
                String str = this.$accessToken;
                final String str2 = this.$publicJwk;
                Response responseSend = keycloakDeviceKeyRegistrar.send(strDeviceKeyUrl, "POST", str, new Function1() { // from class: com.doctolib.apps.authentication.internal.devicekey.KeycloakDeviceKeyRegistrar$register$2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return KeycloakDeviceKeyRegistrar.AnonymousClass2.invokeSuspend$lambda$1(str2, (HttpURLConnection) obj2);
                    }
                });
                AuthError authErrorRegistrationError = KeycloakDeviceKeyRegistrar.this.registrationError(responseSend);
                if (authErrorRegistrationError == null) {
                    String strSubjectFrom = KeycloakDeviceKeyRegistrar.this.subjectFrom(responseSend.getBody());
                    if (strSubjectFrom != null) {
                        return strSubjectFrom;
                    }
                    throw new AuthError(AppAuthErrorCode.DEVICE_KEY_REGISTRATION_FAILED, "Device key registration returned no subject: " + KeycloakDeviceKeyRegistrar.this.excerpt(responseSend.getBody()), null, 4, null);
                }
                throw authErrorRegistrationError;
            } catch (Exception e) {
                throw new AuthError(AppAuthErrorCode.DEVICE_KEY_REGISTRATION_FAILED, "Device key registration call failed: " + e.getMessage(), e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$1(String str, HttpURLConnection httpURLConnection) throws IOException {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                byte[] bytes = str.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                outputStream.write(bytes);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(outputStream, null);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(outputStream, th);
                    throw th2;
                }
            }
        }
    }

    @Override // com.doctolib.apps.authentication.internal.devicekey.DeviceKeyRegistrar
    public Object register(String str, String str2, String str3, Continuation continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(str3, str2, str, null), continuation);
    }

    /* JADX INFO: renamed from: com.doctolib.apps.authentication.internal.devicekey.KeycloakDeviceKeyRegistrar$revoke$2, reason: invalid class name and case insensitive filesystem */
    static final class C04832 extends SuspendLambda implements Function2 {
        final /* synthetic */ String $accessToken;
        final /* synthetic */ String $issuer;
        final /* synthetic */ String $kid;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04832(String str, String str2, String str3, Continuation continuation) {
            super(2, continuation);
            this.$issuer = str;
            this.$kid = str2;
            this.$accessToken = str3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            C04832 c04832 = KeycloakDeviceKeyRegistrar.this.new C04832(this.$issuer, this.$kid, this.$accessToken, continuation);
            c04832.L$0 = obj;
            return c04832;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C04832) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objM5243constructorimpl;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                String string = Uri.parse(KeycloakDeviceKeyRegistrar.this.deviceKeyUrl(this.$issuer)).buildUpon().appendPath(this.$kid).build().toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                KeycloakDeviceKeyRegistrar keycloakDeviceKeyRegistrar = KeycloakDeviceKeyRegistrar.this;
                String str = this.$accessToken;
                try {
                    Result.Companion companion = Result.Companion;
                    objM5243constructorimpl = Result.m5243constructorimpl(Boxing.boxInt(KeycloakDeviceKeyRegistrar.send$default(keycloakDeviceKeyRegistrar, string, "DELETE", str, null, 8, null).getStatus()));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    objM5243constructorimpl = Result.m5243constructorimpl(ResultKt.createFailure(th));
                }
                if (Result.m5248isFailureimpl(objM5243constructorimpl)) {
                    objM5243constructorimpl = null;
                }
                Integer num = (Integer) objM5243constructorimpl;
                return Boxing.boxBoolean((num == null || num.intValue() >= 500 || SetsKt.setOf((Object[]) new Integer[]{Boxing.boxInt(408), Boxing.boxInt(429)}).contains(num)) ? false : true);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.doctolib.apps.authentication.internal.devicekey.DeviceKeyRegistrar
    public Object revoke(String str, String str2, String str3, Continuation continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C04832(str3, str, str2, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String deviceKeyUrl(String str) {
        String string = Uri.parse(str).buildUpon().appendPath("device-key").build().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    static /* synthetic */ Response send$default(KeycloakDeviceKeyRegistrar keycloakDeviceKeyRegistrar, String str, String str2, String str3, Function1 function1, int i, Object obj) {
        if ((i & 8) != 0) {
            function1 = new Function1() { // from class: com.doctolib.apps.authentication.internal.devicekey.KeycloakDeviceKeyRegistrar$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return KeycloakDeviceKeyRegistrar.send$lambda$0((HttpURLConnection) obj2);
                }
            };
        }
        return keycloakDeviceKeyRegistrar.send(str, str2, str3, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit send$lambda$0(HttpURLConnection it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Response send(String str, String str2, String str3, Function1 function1) throws IOException {
        URLConnection uRLConnectionOpenConnection = new URL(str).openConnection();
        Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setConnectTimeout(ColorExtractionConstants.MAX_PIXEL_SAMPLES);
        httpURLConnection.setReadTimeout(ColorExtractionConstants.MAX_PIXEL_SAMPLES);
        httpURLConnection.setRequestProperty("Authorization", "Bearer " + str3);
        httpURLConnection.setRequestProperty("Cookie", "");
        Map map = this.customHeaders;
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
        try {
            function1.invoke(httpURLConnection);
            return new Response(httpURLConnection.getResponseCode(), readBody(httpURLConnection), httpURLConnection.getHeaderField("WWW-Authenticate"));
        } finally {
            httpURLConnection.disconnect();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AuthError registrationError(Response response) {
        int status = response.getStatus();
        if (200 <= status && status < 300) {
            return null;
        }
        if (response.getStatus() == 401) {
            if (StringsKt.contains$default((CharSequence) (response.getChallenge() + " " + response.getBody()), (CharSequence) "insufficient_user_authentication", false, 2, (Object) null)) {
                AppAuthErrorCode appAuthErrorCode = AppAuthErrorCode.DEVICE_KEY_STEP_UP_REQUIRED;
                String challenge = response.getChallenge();
                if (challenge == null) {
                    challenge = excerpt(response.getBody());
                }
                return new AuthError(appAuthErrorCode, "Device key registration requires a fresher authentication: " + challenge, null, 4, null);
            }
        }
        if (response.getStatus() == 403) {
            return new AuthError(AppAuthErrorCode.UNAUTHORIZED_CLIENT, "Device key registration rejected this client: " + excerpt(response.getBody()), null, 4, null);
        }
        return new AuthError(AppAuthErrorCode.DEVICE_KEY_REGISTRATION_FAILED, "Device key registration failed with HTTP " + response.getStatus() + ": " + excerpt(response.getBody()), null, 4, null);
    }

    private static final class Response {
        private final String body;
        private final String challenge;
        private final int status;

        public Response(int i, String body, String str) {
            Intrinsics.checkNotNullParameter(body, "body");
            this.status = i;
            this.body = body;
            this.challenge = str;
        }

        public final String getBody() {
            return this.body;
        }

        public final String getChallenge() {
            return this.challenge;
        }

        public final int getStatus() {
            return this.status;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String subjectFrom(String str) {
        try {
            String strOptString = new JSONObject(str).optString("sub");
            Intrinsics.checkNotNull(strOptString);
            if (strOptString.length() > 0) {
                return strOptString;
            }
            return null;
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String excerpt(String str) {
        return str.length() == 0 ? "no response body" : StringsKt.take(str, IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING);
    }

    private final String readBody(HttpURLConnection httpURLConnection) {
        Object objM5243constructorimpl;
        String text;
        try {
            Result.Companion companion = Result.Companion;
            int responseCode = httpURLConnection.getResponseCode();
            InputStream errorStream = (200 > responseCode || responseCode >= 300) ? httpURLConnection.getErrorStream() : httpURLConnection.getInputStream();
            if (errorStream != null) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(errorStream, Charsets.UTF_8), 8192);
                try {
                    text = TextStreamsKt.readText(bufferedReader);
                    CloseableKt.closeFinally(bufferedReader, null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(bufferedReader, th);
                        throw th2;
                    }
                }
            } else {
                text = null;
            }
            objM5243constructorimpl = Result.m5243constructorimpl(text);
        } catch (Throwable th3) {
            Result.Companion companion2 = Result.Companion;
            objM5243constructorimpl = Result.m5243constructorimpl(ResultKt.createFailure(th3));
        }
        String str = (String) (Result.m5248isFailureimpl(objM5243constructorimpl) ? null : objM5243constructorimpl);
        return str == null ? "" : str;
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
