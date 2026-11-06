package androidx.webkit.internal;

import android.net.Uri;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebMessagePortCompat;
import androidx.webkit.WebViewCompat;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

/* JADX INFO: loaded from: classes.dex */
public class WebViewProviderAdapter {
    final WebViewProviderBoundaryInterface mImpl;

    public WebViewProviderAdapter(WebViewProviderBoundaryInterface webViewProviderBoundaryInterface) {
        this.mImpl = webViewProviderBoundaryInterface;
    }

    public WebMessagePortCompat[] createWebMessageChannel() {
        InvocationHandler[] invocationHandlerArrCreateWebMessageChannel = this.mImpl.createWebMessageChannel();
        WebMessagePortCompat[] webMessagePortCompatArr = new WebMessagePortCompat[invocationHandlerArrCreateWebMessageChannel.length];
        for (int i = 0; i < invocationHandlerArrCreateWebMessageChannel.length; i++) {
            webMessagePortCompatArr[i] = new WebMessagePortImpl(invocationHandlerArrCreateWebMessageChannel[i]);
        }
        return webMessagePortCompatArr;
    }

    public void postWebMessage(WebMessageCompat webMessageCompat, Uri uri) {
        this.mImpl.postMessageToMainFrame(BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(new WebMessageAdapter(webMessageCompat)), uri);
    }

    public void addWebMessageListener(String str, String[] strArr, WebViewCompat.WebMessageListener webMessageListener) {
        this.mImpl.addWebMessageListener(str, strArr, BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(new WebMessageListenerAdapter(webMessageListener)));
    }
}
