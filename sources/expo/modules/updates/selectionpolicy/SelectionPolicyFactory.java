package expo.modules.updates.selectionpolicy;

import expo.modules.updates.UpdatesConfiguration;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class SelectionPolicyFactory {
    public static final SelectionPolicyFactory INSTANCE = new SelectionPolicyFactory();

    private SelectionPolicyFactory() {
    }

    public static final SelectionPolicy createFilterAwarePolicy(String runtimeVersion, UpdatesConfiguration config) {
        Intrinsics.checkNotNullParameter(runtimeVersion, "runtimeVersion");
        Intrinsics.checkNotNullParameter(config, "config");
        return new SelectionPolicy(new LauncherSelectionPolicyFilterAware(runtimeVersion, config), new LoaderSelectionPolicyFilterAware(config), new ReaperSelectionPolicyFilterAware());
    }
}
