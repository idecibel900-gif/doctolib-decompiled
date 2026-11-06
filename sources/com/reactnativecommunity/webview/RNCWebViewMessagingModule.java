package com.reactnativecommunity.webview;

import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.WritableMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/reactnativecommunity/webview/RNCWebViewMessagingModule;", "Lcom/facebook/react/bridge/JavaScriptModule;", "onShouldStartLoadWithRequest", "", "event", "Lcom/facebook/react/bridge/WritableMap;", "onMessage", "react-native-webview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface RNCWebViewMessagingModule extends JavaScriptModule {
    void onMessage(WritableMap event);

    void onShouldStartLoadWithRequest(WritableMap event);
}
