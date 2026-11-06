package com.facebook.react.packagerconnection;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.logging.FLog;
import com.facebook.react.devsupport.inspector.DevSupportHttpClient;
import java.nio.channels.ClosedChannelException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
public final class ReconnectingWebSocket extends WebSocketListener {
    private static final Companion Companion = new Companion(null);
    private static final String TAG;
    private boolean closed;
    private final ConnectionCallback connectionCallback;
    private final Handler handler;
    private MessageCallback messageCallback;
    private final OkHttpClient okHttpClient;
    private boolean suppressConnectionErrors;
    private final String url;
    private WebSocket webSocket;

    public interface ConnectionCallback {
        void onConnected();

        void onDisconnected();
    }

    public interface MessageCallback {
        void onMessage(String str);

        void onMessage(ByteString byteString);
    }

    public ReconnectingWebSocket(String url, MessageCallback messageCallback, ConnectionCallback connectionCallback) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
        this.messageCallback = messageCallback;
        this.connectionCallback = connectionCallback;
        this.handler = new Handler(Looper.getMainLooper());
        this.okHttpClient = DevSupportHttpClient.INSTANCE.getWebsocketClient$ReactAndroid_release();
    }

    public final void connect() {
        if (this.closed) {
            throw new IllegalStateException("Can't connect closed client");
        }
        this.okHttpClient.newWebSocket(new Request.Builder().url(this.url).build(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void delayedReconnect() {
        if (!this.closed) {
            connect();
        }
    }

    private final void reconnect() {
        if (this.closed) {
            throw new IllegalStateException("Can't reconnect closed client");
        }
        if (!this.suppressConnectionErrors) {
            FLog.w(TAG, "Couldn't connect to \"" + this.url + "\", will silently retry");
            this.suppressConnectionErrors = true;
        }
        this.handler.postDelayed(new Runnable() { // from class: com.facebook.react.packagerconnection.ReconnectingWebSocket$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.delayedReconnect();
            }
        }, 2000L);
    }

    public final void closeQuietly() {
        this.closed = true;
        closeWebSocketQuietly();
        this.messageCallback = null;
        ConnectionCallback connectionCallback = this.connectionCallback;
        if (connectionCallback != null) {
            connectionCallback.onDisconnected();
        }
    }

    private final void closeWebSocketQuietly() {
        try {
            WebSocket webSocket = this.webSocket;
            if (webSocket != null) {
                webSocket.close(1000, "End of session");
            }
        } catch (Exception unused) {
        }
        this.webSocket = null;
    }

    private final void abort(String str, Throwable th) {
        FLog.e(TAG, "Error occurred, shutting down websocket connection: " + str, th);
        closeWebSocketQuietly();
    }

    @Override // okhttp3.WebSocketListener
    public synchronized void onOpen(WebSocket webSocket, Response response) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(response, "response");
        this.webSocket = webSocket;
        this.suppressConnectionErrors = false;
        ConnectionCallback connectionCallback = this.connectionCallback;
        if (connectionCallback != null) {
            connectionCallback.onConnected();
        }
    }

    @Override // okhttp3.WebSocketListener
    public synchronized void onFailure(WebSocket webSocket, Throwable t, Response response) {
        try {
            Intrinsics.checkNotNullParameter(webSocket, "webSocket");
            Intrinsics.checkNotNullParameter(t, "t");
            if (this.webSocket != null) {
                abort("Websocket exception", t);
            }
            if (!this.closed) {
                ConnectionCallback connectionCallback = this.connectionCallback;
                if (connectionCallback != null) {
                    connectionCallback.onDisconnected();
                }
                reconnect();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // okhttp3.WebSocketListener
    public synchronized void onMessage(WebSocket webSocket, String text) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(text, "text");
        MessageCallback messageCallback = this.messageCallback;
        if (messageCallback != null) {
            messageCallback.onMessage(text);
        }
    }

    @Override // okhttp3.WebSocketListener
    public synchronized void onMessage(WebSocket webSocket, ByteString bytes) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        MessageCallback messageCallback = this.messageCallback;
        if (messageCallback != null) {
            messageCallback.onMessage(bytes);
        }
    }

    @Override // okhttp3.WebSocketListener
    public synchronized void onClosed(WebSocket webSocket, int i, String reason) {
        try {
            Intrinsics.checkNotNullParameter(webSocket, "webSocket");
            Intrinsics.checkNotNullParameter(reason, "reason");
            this.webSocket = null;
            if (!this.closed) {
                ConnectionCallback connectionCallback = this.connectionCallback;
                if (connectionCallback != null) {
                    connectionCallback.onDisconnected();
                }
                reconnect();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void sendMessage(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        WebSocket webSocket = this.webSocket;
        if (webSocket == null) {
            throw new ClosedChannelException();
        }
        webSocket.send(message);
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        String simpleName = ReconnectingWebSocket.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        TAG = simpleName;
    }
}
