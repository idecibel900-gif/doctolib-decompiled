package androidx.webkit.internal;

import androidx.webkit.JavaScriptReplyProxy;
import java.lang.reflect.InvocationHandler;
import java.util.concurrent.Callable;
import org.chromium.support_lib_boundary.JsReplyProxyBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

/* JADX INFO: loaded from: classes.dex */
public class JavaScriptReplyProxyImpl extends JavaScriptReplyProxy {
    private final JsReplyProxyBoundaryInterface mBoundaryInterface;

    public JavaScriptReplyProxyImpl(JsReplyProxyBoundaryInterface jsReplyProxyBoundaryInterface) {
        this.mBoundaryInterface = jsReplyProxyBoundaryInterface;
    }

    public static JavaScriptReplyProxyImpl forInvocationHandler(InvocationHandler invocationHandler) {
        final JsReplyProxyBoundaryInterface jsReplyProxyBoundaryInterface = (JsReplyProxyBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(JsReplyProxyBoundaryInterface.class, invocationHandler);
        return (JavaScriptReplyProxyImpl) jsReplyProxyBoundaryInterface.getOrCreatePeer(new Callable() { // from class: androidx.webkit.internal.JavaScriptReplyProxyImpl$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return JavaScriptReplyProxyImpl.m2928$r8$lambda$05zhUQJag_W78l1vIN5l8vJcBk(jsReplyProxyBoundaryInterface);
            }
        });
    }

    /* JADX INFO: renamed from: $r8$lambda$05zhUQJag_W78l1vIN5-l8vJcBk, reason: not valid java name */
    public static /* synthetic */ Object m2928$r8$lambda$05zhUQJag_W78l1vIN5l8vJcBk(JsReplyProxyBoundaryInterface jsReplyProxyBoundaryInterface) {
        return new JavaScriptReplyProxyImpl(jsReplyProxyBoundaryInterface);
    }
}
