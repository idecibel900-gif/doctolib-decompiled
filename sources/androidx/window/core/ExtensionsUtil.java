package androidx.window.core;

import androidx.window.extensions.WindowExtensionsProvider;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes.dex */
public final class ExtensionsUtil {
    public static final ExtensionsUtil INSTANCE = new ExtensionsUtil();
    private static final String TAG = Reflection.getOrCreateKotlinClass(ExtensionsUtil.class).getSimpleName();

    private ExtensionsUtil() {
    }

    public final int getSafeVendorApiLevel() {
        try {
            return WindowExtensionsProvider.getWindowExtensions().getVendorApiLevel();
        } catch (NoClassDefFoundError unused) {
            BuildConfig.INSTANCE.getVerificationMode();
            VerificationMode verificationMode = VerificationMode.STRICT;
            return 0;
        } catch (UnsupportedOperationException unused2) {
            BuildConfig.INSTANCE.getVerificationMode();
            VerificationMode verificationMode2 = VerificationMode.STRICT;
            return 0;
        }
    }
}
