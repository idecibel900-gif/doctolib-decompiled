package androidx.webkit.internal;

import android.os.Build;
import android.webkit.WebView;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

/* JADX INFO: loaded from: classes.dex */
public abstract class WebViewGlueCommunicator {

    private static class LAZY_COMPAT_CONVERTER_HOLDER {
        static final WebkitToCompatConverter INSTANCE = new WebkitToCompatConverter(WebViewGlueCommunicator.getFactory().getWebkitToCompatConverter());
    }

    private static class LAZY_FACTORY_HOLDER {
        static final WebViewProviderFactory INSTANCE = WebViewGlueCommunicator.createGlueProviderFactory();
    }

    public static WebViewProviderFactory getFactory() {
        return LAZY_FACTORY_HOLDER.INSTANCE;
    }

    public static WebkitToCompatConverter getCompatConverter() {
        return LAZY_COMPAT_CONVERTER_HOLDER.INSTANCE;
    }

    private static InvocationHandler fetchGlueProviderFactoryImpl() {
        return (InvocationHandler) Class.forName("org.chromium.support_lib_glue.SupportLibReflectionUtil", false, getWebViewClassLoader()).getDeclaredMethod("createWebViewProviderFactory", null).invoke(null, null);
    }

    static WebViewProviderFactory createGlueProviderFactory() {
        try {
            return new WebViewProviderFactoryAdapter((WebViewProviderFactoryBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebViewProviderFactoryBoundaryInterface.class, fetchGlueProviderFactoryImpl()));
        } catch (ClassNotFoundException unused) {
            return new IncompatibleApkWebViewProviderFactory();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public static ClassLoader getWebViewClassLoader() {
        if (Build.VERSION.SDK_INT >= 28) {
            return ApiHelperForP.getWebViewClassLoader();
        }
        return getWebViewProviderFactory().getClass().getClassLoader();
    }

    private static Object getWebViewProviderFactory() {
        try {
            Method declaredMethod = WebView.class.getDeclaredMethod("getFactory", null);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(null, null);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
