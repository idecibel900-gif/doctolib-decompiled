package androidx.window.layout;

import android.content.Context;
import androidx.window.core.ConsumerAdapter;
import androidx.window.extensions.layout.WindowLayoutComponent;
import androidx.window.layout.adapter.WindowBackend;
import androidx.window.layout.adapter.extensions.ExtensionWindowBackend;
import androidx.window.layout.adapter.sidecar.SidecarWindowBackend;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes3.dex */
public interface WindowInfoTracker {
    public static final Companion Companion = Companion.$$INSTANCE;

    Flow windowLayoutInfo(Context context);

    public static final class Companion {
        private static final boolean DEBUG = false;
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final String TAG = Reflection.getOrCreateKotlinClass(WindowInfoTracker.class).getSimpleName();
        private static final Lazy extensionBackend$delegate = LazyKt.lazy(new Function0() { // from class: androidx.window.layout.WindowInfoTracker$Companion$extensionBackend$2
            @Override // kotlin.jvm.functions.Function0
            public final WindowBackend invoke() {
                WindowLayoutComponent windowLayoutComponent;
                try {
                    ClassLoader loader = WindowInfoTracker.class.getClassLoader();
                    SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = loader != null ? new SafeWindowLayoutComponentProvider(loader, new ConsumerAdapter(loader)) : null;
                    if (safeWindowLayoutComponentProvider == null || (windowLayoutComponent = safeWindowLayoutComponentProvider.getWindowLayoutComponent()) == null) {
                        return null;
                    }
                    ExtensionWindowBackend.Companion companion = ExtensionWindowBackend.Companion;
                    Intrinsics.checkNotNullExpressionValue(loader, "loader");
                    return companion.newInstance(windowLayoutComponent, new ConsumerAdapter(loader));
                } catch (Throwable unused) {
                    if (WindowInfoTracker.Companion.DEBUG) {
                        String unused2 = WindowInfoTracker.Companion.TAG;
                    }
                    return null;
                }
            }
        });
        private static WindowInfoTrackerDecorator decorator = EmptyDecorator.INSTANCE;

        private Companion() {
        }

        public final WindowBackend getExtensionBackend$window_release() {
            return (WindowBackend) extensionBackend$delegate.getValue();
        }

        public final WindowInfoTracker getOrCreate(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            WindowBackend extensionBackend$window_release = getExtensionBackend$window_release();
            if (extensionBackend$window_release == null) {
                extensionBackend$window_release = SidecarWindowBackend.Companion.getInstance(context);
            }
            return decorator.decorate(new WindowInfoTrackerImpl(WindowMetricsCalculatorCompat.INSTANCE, extensionBackend$window_release));
        }
    }
}
