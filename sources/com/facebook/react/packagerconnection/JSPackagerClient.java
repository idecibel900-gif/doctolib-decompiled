package com.facebook.react.packagerconnection;

import android.net.Uri;
import com.facebook.common.logging.FLog;
import com.facebook.react.devsupport.inspector.DevSupportHttpClient;
import com.facebook.react.modules.systeminfo.AndroidInfoHelpers;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class JSPackagerClient implements ReconnectingWebSocket.MessageCallback {
    private static final Companion Companion = new Companion(null);
    private static final String TAG;
    private final Map requestHandlers;
    private final ReconnectingWebSocket webSocket;

    public JSPackagerClient(String clientId, PackagerConnectionSettings settings, Map requestHandlers, ReconnectingWebSocket.ConnectionCallback connectionCallback) {
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(settings, "settings");
        Intrinsics.checkNotNullParameter(requestHandlers, "requestHandlers");
        this.requestHandlers = requestHandlers;
        String string = new Uri.Builder().scheme(DevSupportHttpClient.INSTANCE.wsScheme$ReactAndroid_release(settings.getDebugServerHost())).encodedAuthority(settings.getDebugServerHost()).appendPath("message").appendQueryParameter("device", AndroidInfoHelpers.getFriendlyDeviceName()).appendQueryParameter("app", settings.getPackageName()).appendQueryParameter("clientid", clientId).build().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        this.webSocket = new ReconnectingWebSocket(string, this, connectionCallback);
    }

    public final void init() {
        this.webSocket.connect();
    }

    public final void close() {
        this.webSocket.closeQuietly();
    }

    @Override // com.facebook.react.packagerconnection.ReconnectingWebSocket.MessageCallback
    public void onMessage(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        try {
            JSONObject jSONObject = new JSONObject(text);
            int iOptInt = jSONObject.optInt(DiagnosticsEntry.VERSION_KEY);
            String strOptString = jSONObject.optString("method");
            Object objOpt = jSONObject.opt(DiagnosticsEntry.ID_KEY);
            Object objOpt2 = jSONObject.opt("params");
            if (iOptInt != 2) {
                FLog.e(TAG, "Message with incompatible or missing version of protocol received: " + iOptInt);
                return;
            }
            if (strOptString == null) {
                abortOnMessage(objOpt, "No method provided");
                return;
            }
            RequestHandler requestHandler = (RequestHandler) this.requestHandlers.get(strOptString);
            if (requestHandler == null) {
                abortOnMessage(objOpt, "No request handler for method: " + strOptString);
                return;
            }
            if (objOpt == null) {
                requestHandler.onNotification(objOpt2);
            } else {
                requestHandler.onRequest(objOpt2, new ResponderImpl(this, objOpt));
            }
        } catch (Exception e) {
            FLog.e(TAG, "Handling the message failed", e);
        }
    }

    @Override // com.facebook.react.packagerconnection.ReconnectingWebSocket.MessageCallback
    public void onMessage(ByteString bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        FLog.w(TAG, "Websocket received message with payload of unexpected type binary");
    }

    private final void abortOnMessage(Object obj, String str) {
        if (obj != null) {
            new ResponderImpl(this, obj).error(str);
        }
        FLog.e(TAG, "Handling the message failed with reason: " + str);
    }

    private final class ResponderImpl implements Responder {
        private final Object id;
        final /* synthetic */ JSPackagerClient this$0;

        public ResponderImpl(JSPackagerClient jSPackagerClient, Object id) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.this$0 = jSPackagerClient;
            this.id = id;
        }

        @Override // com.facebook.react.packagerconnection.Responder
        public void respond(Object result) {
            Intrinsics.checkNotNullParameter(result, "result");
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(DiagnosticsEntry.VERSION_KEY, 2);
                jSONObject.put(DiagnosticsEntry.ID_KEY, this.id);
                jSONObject.put("result", result);
                ReconnectingWebSocket reconnectingWebSocket = this.this$0.webSocket;
                String string = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                reconnectingWebSocket.sendMessage(string);
            } catch (Exception e) {
                FLog.e(JSPackagerClient.TAG, "Responding failed", e);
            }
        }

        @Override // com.facebook.react.packagerconnection.Responder
        public void error(Object error) {
            Intrinsics.checkNotNullParameter(error, "error");
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(DiagnosticsEntry.VERSION_KEY, 2);
                jSONObject.put(DiagnosticsEntry.ID_KEY, this.id);
                jSONObject.put("error", error);
                ReconnectingWebSocket reconnectingWebSocket = this.this$0.webSocket;
                String string = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                reconnectingWebSocket.sendMessage(string);
            } catch (Exception e) {
                FLog.e(JSPackagerClient.TAG, "Responding with error failed", e);
            }
        }
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        String simpleName = JSPackagerClient.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        TAG = simpleName;
    }
}
