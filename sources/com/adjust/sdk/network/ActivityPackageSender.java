package com.adjust.sdk.network;

import android.content.Context;
import android.net.Uri;
import com.adjust.sdk.ActivityKind;
import com.adjust.sdk.ActivityPackage;
import com.adjust.sdk.AdjustFactory;
import com.adjust.sdk.AdjustSigner;
import com.adjust.sdk.Constants;
import com.adjust.sdk.ILogger;
import com.adjust.sdk.PackageBuilder;
import com.adjust.sdk.ResponseData;
import com.adjust.sdk.SharedPreferencesManager;
import com.adjust.sdk.TrackingState;
import com.adjust.sdk.Util;
import com.adjust.sdk.scheduler.SingleThreadCachedScheduler;
import com.adjust.sdk.scheduler.ThreadExecutor;
import com.amazon.a.a.o.b.f;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;
import net.openid.appauth.AuthorizationManagementUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ActivityPackageSender implements IActivityPackageSender {
    private String basePath;
    private String clientSdk;
    private int connectionTimeout;
    private Context context;
    private String gdprPath;
    private String purchaseVerificationPath;
    private String subscriptionPath;
    private UrlStrategy urlStrategy;
    private ILogger logger = AdjustFactory.getLogger();
    private ThreadExecutor executor = new SingleThreadCachedScheduler("ActivityPackageSender");
    private UtilNetworking.IHttpsURLConnectionProvider httpsURLConnectionProvider = AdjustFactory.getHttpsURLConnectionProvider();
    private UtilNetworking.IConnectionOptions connectionOptions = AdjustFactory.getConnectionOptions();

    public ActivityPackageSender(List<String> list, boolean z, String str, String str2, String str3, String str4, String str5, int i, Context context) {
        this.basePath = str;
        this.gdprPath = str2;
        this.subscriptionPath = str3;
        this.purchaseVerificationPath = str4;
        this.clientSdk = str5;
        this.connectionTimeout = i;
        this.context = context;
        this.urlStrategy = new UrlStrategy(AdjustFactory.getBaseUrl(), AdjustFactory.getGdprUrl(), AdjustFactory.getSubscriptionUrl(), AdjustFactory.getPurchaseVerificationUrl(), list, z);
    }

    private DataOutputStream configConnectionForGET(HttpsURLConnection httpsURLConnection) throws ProtocolException {
        httpsURLConnection.setRequestMethod("GET");
        return null;
    }

    private DataOutputStream configConnectionForPOST(HttpsURLConnection httpsURLConnection, Map<String, String> map, Map<String, String> map2, Map<String, String> map3) throws IOException {
        httpsURLConnection.setRequestMethod("POST");
        httpsURLConnection.setUseCaches(false);
        httpsURLConnection.setDoInput(true);
        httpsURLConnection.setDoOutput(true);
        String strGeneratePOSTBodyString = generatePOSTBodyString(map, map2, map3);
        if (strGeneratePOSTBodyString == null) {
            return null;
        }
        DataOutputStream dataOutputStream = new DataOutputStream(httpsURLConnection.getOutputStream());
        dataOutputStream.writeBytes(strGeneratePOSTBodyString);
        return dataOutputStream;
    }

    private String errorMessage(Throwable th, String str, ActivityPackage activityPackage) {
        return Util.formatString("%s. (%s)", activityPackage.getFailureMessage(), Util.getReasonString(str, th));
    }

    private static String extractAuthorizationHeader(Map<String, String> map) {
        return map.remove(AuthorizationManagementUtil.REQUEST_TYPE_AUTHORIZATION);
    }

    private static String extractTargetUrl(Map<String, String> map, ActivityKind activityKind, UrlStrategy urlStrategy) {
        String strRemove = map.remove("endpoint");
        return strRemove != null ? strRemove : urlStrategy.targetUrlByActivityKind(activityKind);
    }

    private String generatePOSTBodyString(Map<String, String> map, Map<String, String> map2, Map<String, String> map3) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        if (map3 == null || map3.isEmpty()) {
            if (map != null && !map.isEmpty()) {
                injectParametersToPOSTStringBuilder(map, sb);
            }
            if (map2 != null && !map2.isEmpty()) {
                injectParametersToPOSTStringBuilder(map2, sb);
            }
        } else {
            injectParametersToPOSTStringBuilder(map3, sb);
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '&') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private String generateUrlStringForGET(ActivityKind activityKind, String str, Map<String, String> map, Map<String, String> map2, Map<String, String> map3) {
        URL url = new URL(urlWithExtraPathByActivityKind(activityKind, extractTargetUrl(map3, activityKind, this.urlStrategy)));
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(url.getProtocol());
        builder.encodedAuthority(url.getAuthority());
        builder.path(url.getPath());
        builder.appendPath(str);
        this.logger.debug("Making request to url: %s", builder.toString());
        if (map3 == null || map3.isEmpty()) {
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    builder.appendQueryParameter(entry.getKey(), entry.getValue());
                }
            }
            if (map2 != null) {
                for (Map.Entry<String, String> entry2 : map2.entrySet()) {
                    builder.appendQueryParameter(entry2.getKey(), entry2.getValue());
                }
            }
        } else {
            for (Map.Entry<String, String> entry3 : map3.entrySet()) {
                builder.appendQueryParameter(entry3.getKey(), entry3.getValue());
            }
        }
        return builder.build().toString();
    }

    private String generateUrlStringForPOST(ActivityKind activityKind, String str, Map<String, String> map) {
        String string = Util.formatString("%s%s", urlWithExtraPathByActivityKind(activityKind, extractTargetUrl(map, activityKind, this.urlStrategy)), str);
        this.logger.debug("Making request to url : %s", string);
        return string;
    }

    private void injectParametersToPOSTStringBuilder(Map<String, String> map, StringBuilder sb) throws UnsupportedEncodingException {
        if (map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String strEncode = URLEncoder.encode(entry.getKey(), Constants.ENCODING);
            String value = entry.getValue();
            String strEncode2 = value != null ? URLEncoder.encode(value, Constants.ENCODING) : "";
            sb.append(strEncode);
            sb.append(f.b);
            sb.append(strEncode2);
            sb.append("&");
        }
    }

    private void localError(Throwable th, String str, ResponseData responseData, int i) {
        String strErrorMessage = errorMessage(th, str, responseData.activityPackage);
        this.logger.error(strErrorMessage, new Object[0]);
        responseData.message = strErrorMessage;
        responseData.willRetry = false;
        responseData.activityPackage.addError(i);
    }

    private void parseResponse(ResponseData responseData, String str) {
        JSONObject jSONObject;
        if (str.length() == 0) {
            this.logger.error("Empty response string", new Object[0]);
            return;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            this.logger.error(errorMessage(e, "Failed to parse JSON response", responseData.activityPackage), new Object[0]);
            jSONObject = null;
        }
        if (jSONObject == null) {
            return;
        }
        responseData.jsonResponse = jSONObject;
        responseData.message = UtilNetworking.extractJsonString(jSONObject, "message");
        responseData.adid = UtilNetworking.extractJsonString(jSONObject, "adid");
        responseData.timestamp = UtilNetworking.extractJsonString(jSONObject, DiagnosticsEntry.TIMESTAMP_KEY);
        String strExtractJsonString = UtilNetworking.extractJsonString(jSONObject, "tracking_state");
        if (strExtractJsonString != null && strExtractJsonString.equals("opted_out")) {
            responseData.trackingState = TrackingState.OPTED_OUT;
        }
        responseData.askIn = UtilNetworking.extractJsonLong(jSONObject, "ask_in");
        responseData.retryIn = UtilNetworking.extractJsonLong(jSONObject, "retry_in");
        responseData.continueIn = UtilNetworking.extractJsonLong(jSONObject, "continue_in");
        responseData.attribution = Util.attributionFromJson(jSONObject.optJSONObject("attribution"), Util.getSdkPrefixPlatform(this.clientSdk));
        responseData.resolvedDeeplink = UtilNetworking.extractJsonString(jSONObject, "resolved_click_url");
        responseData.controlParams = jSONObject.optJSONObject("control_params");
    }

    private void remoteError(Throwable th, String str, ResponseData responseData, Integer num) {
        String str2 = errorMessage(th, str, responseData.activityPackage) + " Will retry later";
        this.logger.error(str2, new Object[0]);
        responseData.message = str2;
        responseData.willRetry = true;
        responseData.activityPackage.addError(num.intValue());
    }

    private boolean shouldRetryToSendWithUrlStrategy(ResponseData responseData) {
        if (responseData.jsonResponse != null) {
            this.logger.debug("Will not retry with current url strategy, already got a valid json response", new Object[0]);
            this.urlStrategy.resetAfterSuccess();
            return false;
        }
        boolean zShouldRetryAfterFailure = this.urlStrategy.shouldRetryAfterFailure(responseData.activityKind);
        ILogger iLogger = this.logger;
        if (zShouldRetryAfterFailure) {
            iLogger.error("Failed with current url strategy, but it will retry with new", new Object[0]);
            return true;
        }
        iLogger.error("Failed with current url strategy and it will not retry", new Object[0]);
        return false;
    }

    private Map<String, String> signParameters(ActivityPackage activityPackage, Map<String, String> map) {
        HashMap map2 = new HashMap(activityPackage.getParameters());
        if (map != null) {
            map2.putAll(map);
        }
        HashMap map3 = new HashMap();
        map3.put("client_sdk", activityPackage.getClientSdk());
        map3.put("activity_kind", activityPackage.getActivityKind().toString());
        map3.put("endpoint", this.urlStrategy.targetUrlByActivityKind(activityPackage.getActivityKind()));
        JSONObject controlParamsJson = SharedPreferencesManager.getDefaultInstance(this.context).getControlParamsJson();
        if (controlParamsJson != null) {
            Iterator<String> itKeys = controlParamsJson.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                try {
                    if (controlParamsJson.get(next) instanceof String) {
                        map3.put(next, (String) controlParamsJson.get(next));
                    }
                } catch (JSONException unused) {
                    this.logger.error("JSONException while iterating control params", new Object[0]);
                }
            }
        }
        return AdjustSigner.sign(map2, map3, this.context, this.logger);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void tryToGetResponse(ResponseData responseData) {
        ActivityPackageSender activityPackageSender;
        ActivityPackageSender activityPackageSender2;
        ActivityPackageSender activityPackageSender3;
        ActivityPackageSender activityPackageSender4;
        ActivityPackageSender activityPackageSender5;
        ActivityPackageSender activityPackageSender6;
        ActivityPackageSender activityPackageSender7;
        ActivityPackageSender activityPackageSender8;
        ActivityPackageSender activityPackageSender9;
        String strGenerateUrlStringForPOST;
        String str = "Flushing and closing connection output stream";
        DataOutputStream dataOutputStream = null;
        try {
            try {
                String strExtractAuthorizationHeader = extractAuthorizationHeader(responseData.signedParameters);
                this.logger.verbose("authorizationHeader: %s", strExtractAuthorizationHeader);
                boolean z = true;
                boolean z2 = responseData.activityPackage.getActivityKind() == ActivityKind.ATTRIBUTION;
                ActivityPackage activityPackage = responseData.activityPackage;
                try {
                    if (z2) {
                        ActivityPackageSender activityPackageSender10 = this;
                        strGenerateUrlStringForPOST = activityPackageSender10.generateUrlStringForGET(activityPackage.getActivityKind(), responseData.activityPackage.getPath(), responseData.activityPackage.getParameters(), responseData.sendingParameters, responseData.signedParameters);
                        activityPackageSender9 = activityPackageSender10;
                    } else {
                        activityPackageSender9 = this;
                        strGenerateUrlStringForPOST = generateUrlStringForPOST(activityPackage.getActivityKind(), responseData.activityPackage.getPath(), responseData.signedParameters);
                    }
                    HttpsURLConnection httpsURLConnectionGenerateHttpsURLConnection = activityPackageSender9.httpsURLConnectionProvider.generateHttpsURLConnection(new URL(strGenerateUrlStringForPOST));
                    activityPackageSender9.connectionOptions.applyConnectionOptions(httpsURLConnectionGenerateHttpsURLConnection, activityPackageSender9.clientSdk, activityPackageSender9.connectionTimeout);
                    if (strExtractAuthorizationHeader != null) {
                        httpsURLConnectionGenerateHttpsURLConnection.setRequestProperty("Authorization", strExtractAuthorizationHeader);
                    }
                    DataOutputStream dataOutputStreamConfigConnectionForGET = z2 ? configConnectionForGET(httpsURLConnectionGenerateHttpsURLConnection) : configConnectionForPOST(httpsURLConnectionGenerateHttpsURLConnection, responseData.activityPackage.getParameters(), responseData.sendingParameters, responseData.signedParameters);
                    Integer connectionResponse = readConnectionResponse(httpsURLConnectionGenerateHttpsURLConnection, responseData);
                    responseData.success = responseData.jsonResponse != null && responseData.retryIn == null && connectionResponse != null && connectionResponse.intValue() == 200;
                    JSONObject jSONObject = responseData.jsonResponse;
                    if (jSONObject != null && responseData.retryIn == null) {
                        z = false;
                    }
                    responseData.willRetry = z;
                    if (jSONObject == null) {
                        responseData.activityPackage.addError(1000);
                    } else if (responseData.retryIn != null) {
                        responseData.activityPackage.addError(1001);
                    }
                    if (dataOutputStreamConfigConnectionForGET != null) {
                        try {
                            dataOutputStreamConfigConnectionForGET.flush();
                            dataOutputStreamConfigConnectionForGET.close();
                        } catch (IOException e) {
                            activityPackageSender9.logger.error(errorMessage(e, "Flushing and closing connection output stream", responseData.activityPackage), new Object[0]);
                        }
                    }
                } catch (UnsupportedEncodingException e2) {
                    e = e2;
                    localError(e, "Failed to encode parameters", responseData, ErrorCodes.UNSUPPORTED_ENCODING_EXCEPTION);
                    str = "Flushing and closing connection output stream";
                    activityPackageSender8 = activityPackageSender7;
                    responseData = responseData;
                    if (0 != 0) {
                        try {
                            dataOutputStream.flush();
                            dataOutputStream.close();
                            str = "Flushing and closing connection output stream";
                            activityPackageSender8 = activityPackageSender7;
                            responseData = responseData;
                        } catch (IOException e3) {
                            String strErrorMessage = errorMessage(e3, "Flushing and closing connection output stream", responseData.activityPackage);
                            Object[] objArr = new Object[0];
                            activityPackageSender7.logger.error(strErrorMessage, objArr);
                            str = objArr;
                            activityPackageSender8 = activityPackageSender7;
                            responseData = strErrorMessage;
                        }
                    }
                } catch (MalformedURLException e4) {
                    e = e4;
                    localError(e, "Malformed URL", responseData, ErrorCodes.MALFORMED_URL_EXCEPTION);
                    str = "Flushing and closing connection output stream";
                    activityPackageSender8 = activityPackageSender6;
                    responseData = responseData;
                    if (0 != 0) {
                        try {
                            dataOutputStream.flush();
                            dataOutputStream.close();
                            str = "Flushing and closing connection output stream";
                            activityPackageSender8 = activityPackageSender6;
                            responseData = responseData;
                        } catch (IOException e5) {
                            String strErrorMessage2 = errorMessage(e5, "Flushing and closing connection output stream", responseData.activityPackage);
                            Object[] objArr2 = new Object[0];
                            activityPackageSender6.logger.error(strErrorMessage2, objArr2);
                            str = objArr2;
                            activityPackageSender8 = activityPackageSender6;
                            responseData = strErrorMessage2;
                        }
                    }
                } catch (ProtocolException e6) {
                    e = e6;
                    localError(e, "Protocol Error", responseData, ErrorCodes.PROTOCOL_EXCEPTION);
                    str = "Flushing and closing connection output stream";
                    activityPackageSender8 = activityPackageSender5;
                    responseData = responseData;
                    if (0 != 0) {
                        try {
                            dataOutputStream.flush();
                            dataOutputStream.close();
                            str = "Flushing and closing connection output stream";
                            activityPackageSender8 = activityPackageSender5;
                            responseData = responseData;
                        } catch (IOException e7) {
                            String strErrorMessage3 = errorMessage(e7, "Flushing and closing connection output stream", responseData.activityPackage);
                            Object[] objArr3 = new Object[0];
                            activityPackageSender5.logger.error(strErrorMessage3, objArr3);
                            str = objArr3;
                            activityPackageSender8 = activityPackageSender5;
                            responseData = strErrorMessage3;
                        }
                    }
                } catch (SocketTimeoutException e8) {
                    e = e8;
                    remoteError(e, "Request timed out", responseData, 1005);
                    str = "Flushing and closing connection output stream";
                    activityPackageSender8 = activityPackageSender4;
                    responseData = responseData;
                    if (0 != 0) {
                        try {
                            dataOutputStream.flush();
                            dataOutputStream.close();
                            str = "Flushing and closing connection output stream";
                            activityPackageSender8 = activityPackageSender4;
                            responseData = responseData;
                        } catch (IOException e9) {
                            String strErrorMessage4 = errorMessage(e9, "Flushing and closing connection output stream", responseData.activityPackage);
                            Object[] objArr4 = new Object[0];
                            activityPackageSender4.logger.error(strErrorMessage4, objArr4);
                            str = objArr4;
                            activityPackageSender8 = activityPackageSender4;
                            responseData = strErrorMessage4;
                        }
                    }
                } catch (SSLHandshakeException e10) {
                    e = e10;
                    remoteError(e, "Certificate failed", responseData, Integer.valueOf(ErrorCodes.SSL_HANDSHAKE_EXCEPTION));
                    str = "Flushing and closing connection output stream";
                    activityPackageSender8 = activityPackageSender3;
                    responseData = responseData;
                    if (0 != 0) {
                        try {
                            dataOutputStream.flush();
                            dataOutputStream.close();
                            str = "Flushing and closing connection output stream";
                            activityPackageSender8 = activityPackageSender3;
                            responseData = responseData;
                        } catch (IOException e11) {
                            String strErrorMessage5 = errorMessage(e11, "Flushing and closing connection output stream", responseData.activityPackage);
                            Object[] objArr5 = new Object[0];
                            activityPackageSender3.logger.error(strErrorMessage5, objArr5);
                            str = objArr5;
                            activityPackageSender8 = activityPackageSender3;
                            responseData = strErrorMessage5;
                        }
                    }
                } catch (IOException e12) {
                    e = e12;
                    remoteError(e, "Request failed", responseData, Integer.valueOf(ErrorCodes.IO_EXCEPTION));
                    str = "Flushing and closing connection output stream";
                    activityPackageSender8 = activityPackageSender2;
                    responseData = responseData;
                    if (0 != 0) {
                        try {
                            dataOutputStream.flush();
                            dataOutputStream.close();
                            str = "Flushing and closing connection output stream";
                            activityPackageSender8 = activityPackageSender2;
                            responseData = responseData;
                        } catch (IOException e13) {
                            String strErrorMessage6 = errorMessage(e13, "Flushing and closing connection output stream", responseData.activityPackage);
                            Object[] objArr6 = new Object[0];
                            activityPackageSender2.logger.error(strErrorMessage6, objArr6);
                            str = objArr6;
                            activityPackageSender8 = activityPackageSender2;
                            responseData = strErrorMessage6;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    localError(th, "Sending SDK package", responseData, ErrorCodes.THROWABLE);
                    str = "Flushing and closing connection output stream";
                    activityPackageSender8 = activityPackageSender;
                    responseData = responseData;
                    if (0 != 0) {
                        try {
                            dataOutputStream.flush();
                            dataOutputStream.close();
                            str = "Flushing and closing connection output stream";
                            activityPackageSender8 = activityPackageSender;
                            responseData = responseData;
                        } catch (IOException e14) {
                            String strErrorMessage7 = errorMessage(e14, "Flushing and closing connection output stream", responseData.activityPackage);
                            Object[] objArr7 = new Object[0];
                            activityPackageSender.logger.error(strErrorMessage7, objArr7);
                            str = objArr7;
                            activityPackageSender8 = activityPackageSender;
                            responseData = strErrorMessage7;
                        }
                    }
                }
            } catch (Throwable th2) {
                if (0 == 0) {
                    throw th2;
                }
                try {
                    dataOutputStream.flush();
                    dataOutputStream.close();
                    throw th2;
                } catch (IOException e15) {
                    activityPackageSender8.logger.error(errorMessage(e15, str, responseData.activityPackage), new Object[0]);
                    throw th2;
                }
            }
        } catch (UnsupportedEncodingException e16) {
            e = e16;
            activityPackageSender7 = this;
        } catch (MalformedURLException e17) {
            e = e17;
            activityPackageSender6 = this;
        } catch (ProtocolException e18) {
            e = e18;
            activityPackageSender5 = this;
        } catch (SocketTimeoutException e19) {
            e = e19;
            activityPackageSender4 = this;
        } catch (SSLHandshakeException e20) {
            e = e20;
            activityPackageSender3 = this;
        } catch (IOException e21) {
            e = e21;
            activityPackageSender2 = this;
        } catch (Throwable th3) {
            th = th3;
            activityPackageSender = this;
        }
    }

    private Map<String, String> updateSendingParameters(Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        PackageBuilder.addString(map, "sent_at", Util.dateFormatter.format(Long.valueOf(System.currentTimeMillis())));
        return map;
    }

    private String urlWithExtraPathByActivityKind(ActivityKind activityKind, String str) {
        if (activityKind == ActivityKind.GDPR) {
            if (this.gdprPath != null) {
                return str + this.gdprPath;
            }
        } else if (activityKind == ActivityKind.SUBSCRIPTION) {
            if (this.subscriptionPath != null) {
                return str + this.subscriptionPath;
            }
        } else if (activityKind == ActivityKind.PURCHASE_VERIFICATION) {
            if (this.purchaseVerificationPath != null) {
                return str + this.purchaseVerificationPath;
            }
        } else if (this.basePath != null) {
            return str + this.basePath;
        }
        return str;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0052  */
    /* JADX WARN: Code duplicated, block: B:23:0x005c  */
    /* JADX WARN: Code duplicated, block: B:25:0x0066  */
    /* JADX WARN: Code duplicated, block: B:27:0x006e  */
    /* JADX WARN: Code duplicated, block: B:29:0x0082  */
    /* JADX WARN: Code duplicated, block: B:33:0x0092  */
    /* JADX WARN: Code duplicated, block: B:35:0x009e  */
    /* JADX WARN: Code duplicated, block: B:36:0x00a6  */
    public Integer readConnectionResponse(HttpsURLConnection httpsURLConnection, ResponseData responseData) {
        int iIntValue;
        ILogger iLogger;
        String str;
        int iIntValue2;
        ILogger iLogger2;
        StringBuilder sb = new StringBuilder();
        Integer numValueOf = null;
        try {
            try {
                httpsURLConnection.connect();
                int responseCode = httpsURLConnection.getResponseCode();
                numValueOf = Integer.valueOf(responseCode);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(responseCode >= 400 ? httpsURLConnection.getErrorStream() : httpsURLConnection.getInputStream()));
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line);
                }
            } catch (IOException e) {
                this.logger.error(errorMessage(e, "Connecting and reading response", responseData.activityPackage), new Object[0]);
                if (httpsURLConnection != null) {
                    break;
                }
                if (sb.length() == 0) {
                    this.logger.error("Empty response string buffer", new Object[0]);
                    return numValueOf;
                }
                iIntValue = numValueOf.intValue();
                iLogger = this.logger;
                if (iIntValue == 429) {
                    iLogger.error("Too frequent requests to the endpoint (429)", new Object[0]);
                    return numValueOf;
                }
                String string = sb.toString();
                iLogger.debug("Response string: %s", string);
                parseResponse(responseData, string);
                if (responseData.controlParams != null) {
                    SharedPreferencesManager.getDefaultInstance(this.context).saveControlParams(responseData.controlParams);
                }
                str = responseData.message;
                if (str != null) {
                    iIntValue2 = numValueOf.intValue();
                    iLogger2 = this.logger;
                    if (iIntValue2 == 200) {
                        iLogger2.info("Response message: %s", str);
                    } else {
                        iLogger2.error("Response message: %s", str);
                    }
                }
                return numValueOf;
            }
            httpsURLConnection.disconnect();
            if (sb.length() == 0) {
                this.logger.error("Empty response string buffer", new Object[0]);
                return numValueOf;
            }
            iIntValue = numValueOf.intValue();
            iLogger = this.logger;
            if (iIntValue == 429) {
                iLogger.error("Too frequent requests to the endpoint (429)", new Object[0]);
                return numValueOf;
            }
            String string2 = sb.toString();
            iLogger.debug("Response string: %s", string2);
            parseResponse(responseData, string2);
            if (responseData.controlParams != null) {
                SharedPreferencesManager.getDefaultInstance(this.context).saveControlParams(responseData.controlParams);
            }
            str = responseData.message;
            if (str != null) {
                iIntValue2 = numValueOf.intValue();
                iLogger2 = this.logger;
                if (iIntValue2 == 200) {
                    iLogger2.info("Response message: %s", str);
                } else {
                    iLogger2.error("Response message: %s", str);
                }
            }
            return numValueOf;
        } catch (Throwable th) {
            if (httpsURLConnection != null) {
                httpsURLConnection.disconnect();
            }
            throw th;
        }
    }

    @Override // com.adjust.sdk.network.IActivityPackageSender
    public void sendActivityPackage(final ActivityPackage activityPackage, final Map<String, String> map, final IActivityPackageSender.ResponseDataCallbackSubscriber responseDataCallbackSubscriber) {
        this.executor.submit(new Runnable() { // from class: com.adjust.sdk.network.ActivityPackageSender.1
            @Override // java.lang.Runnable
            public final void run() {
                responseDataCallbackSubscriber.onResponseDataCallback(ActivityPackageSender.this.sendActivityPackageSync(activityPackage, map));
            }
        });
    }

    @Override // com.adjust.sdk.network.IActivityPackageSender
    public ResponseData sendActivityPackageSync(ActivityPackage activityPackage, Map<String, String> map) {
        ResponseData responseDataBuildResponseData;
        do {
            Map<String, String> mapUpdateSendingParameters = updateSendingParameters(map);
            responseDataBuildResponseData = ResponseData.buildResponseData(activityPackage, mapUpdateSendingParameters, signParameters(activityPackage, mapUpdateSendingParameters));
            tryToGetResponse(responseDataBuildResponseData);
        } while (shouldRetryToSendWithUrlStrategy(responseDataBuildResponseData));
        return responseDataBuildResponseData;
    }
}
