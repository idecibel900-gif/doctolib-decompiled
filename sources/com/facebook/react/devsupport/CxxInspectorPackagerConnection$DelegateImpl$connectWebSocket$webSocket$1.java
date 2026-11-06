package com.facebook.react.devsupport;

import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

/* JADX INFO: loaded from: classes3.dex */
public final class CxxInspectorPackagerConnection$DelegateImpl$connectWebSocket$webSocket$1 extends WebSocketListener {
    final /* synthetic */ CxxInspectorPackagerConnection.WebSocketDelegate $delegate;
    final /* synthetic */ CxxInspectorPackagerConnection.DelegateImpl this$0;

    CxxInspectorPackagerConnection$DelegateImpl$connectWebSocket$webSocket$1(CxxInspectorPackagerConnection.DelegateImpl delegateImpl, CxxInspectorPackagerConnection.WebSocketDelegate webSocketDelegate) {
        this.this$0 = delegateImpl;
        this.$delegate = webSocketDelegate;
    }

    @Override // okhttp3.WebSocketListener
    public void onFailure(WebSocket webSocket, final Throwable t, Response response) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(t, "t");
        CxxInspectorPackagerConnection.DelegateImpl delegateImpl = this.this$0;
        final CxxInspectorPackagerConnection.WebSocketDelegate webSocketDelegate = this.$delegate;
        delegateImpl.scheduleCallback(new Runnable() { // from class: com.facebook.react.devsupport.CxxInspectorPackagerConnection$DelegateImpl$connectWebSocket$webSocket$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                CxxInspectorPackagerConnection$DelegateImpl$connectWebSocket$webSocket$1.onFailure$lambda$0(t, webSocketDelegate);
            }
        }, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onFailure$lambda$0(Throwable th, CxxInspectorPackagerConnection.WebSocketDelegate webSocketDelegate) {
        String message = th.getMessage();
        if (message == null) {
            message = "<Unknown error>";
        }
        webSocketDelegate.didFailWithError(null, message);
        webSocketDelegate.close();
    }

    @Override // okhttp3.WebSocketListener
    public void onMessage(WebSocket webSocket, final String text) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(text, "text");
        CxxInspectorPackagerConnection.DelegateImpl delegateImpl = this.this$0;
        final CxxInspectorPackagerConnection.WebSocketDelegate webSocketDelegate = this.$delegate;
        delegateImpl.scheduleCallback(new Runnable() { // from class: com.facebook.react.devsupport.CxxInspectorPackagerConnection$DelegateImpl$connectWebSocket$webSocket$1$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                webSocketDelegate.didReceiveMessage(text);
            }
        }, 0L);
    }

    @Override // okhttp3.WebSocketListener
    public void onOpen(WebSocket webSocket, Response response) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(response, "response");
        CxxInspectorPackagerConnection.DelegateImpl delegateImpl = this.this$0;
        final CxxInspectorPackagerConnection.WebSocketDelegate webSocketDelegate = this.$delegate;
        delegateImpl.scheduleCallback(new Runnable() { // from class: com.facebook.react.devsupport.CxxInspectorPackagerConnection$DelegateImpl$connectWebSocket$webSocket$1$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                webSocketDelegate.didOpen();
            }
        }, 0L);
    }

    @Override // okhttp3.WebSocketListener
    public void onClosed(WebSocket webSocket, int i, String reason) {
        Intrinsics.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics.checkNotNullParameter(reason, "reason");
        CxxInspectorPackagerConnection.DelegateImpl delegateImpl = this.this$0;
        final CxxInspectorPackagerConnection.WebSocketDelegate webSocketDelegate = this.$delegate;
        delegateImpl.scheduleCallback(new Runnable() { // from class: com.facebook.react.devsupport.CxxInspectorPackagerConnection$DelegateImpl$connectWebSocket$webSocket$1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                CxxInspectorPackagerConnection$DelegateImpl$connectWebSocket$webSocket$1.onClosed$lambda$3(webSocketDelegate);
            }
        }, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onClosed$lambda$3(CxxInspectorPackagerConnection.WebSocketDelegate webSocketDelegate) {
        webSocketDelegate.didClose();
        webSocketDelegate.close();
    }
}
