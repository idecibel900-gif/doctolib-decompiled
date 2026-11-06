package androidx.window.layout.adapter.extensions;

import androidx.window.core.ConsumerAdapter;
import androidx.window.core.ExtensionsUtil;
import androidx.window.extensions.layout.WindowLayoutComponent;
import androidx.window.layout.adapter.WindowBackend;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ExtensionWindowBackend implements WindowBackend {
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final WindowBackend newInstance(WindowLayoutComponent component, ConsumerAdapter adapter) {
            Intrinsics.checkNotNullParameter(component, "component");
            Intrinsics.checkNotNullParameter(adapter, "adapter");
            int safeVendorApiLevel = ExtensionsUtil.INSTANCE.getSafeVendorApiLevel();
            if (safeVendorApiLevel >= 2) {
                return new ExtensionWindowBackendApi2(component);
            }
            if (safeVendorApiLevel == 1) {
                return new ExtensionWindowBackendApi1(component, adapter);
            }
            return new ExtensionWindowBackendApi0();
        }
    }
}
