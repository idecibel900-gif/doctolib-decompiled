package expo.modules.kotlin.activityresult;

import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class DefaultAppContextActivityResultCaller implements AppContextActivityResultCaller {
    private final ActivityResultsManager activityResultsManager;

    public DefaultAppContextActivityResultCaller(ActivityResultsManager activityResultsManager) {
        Intrinsics.checkNotNullParameter(activityResultsManager, "activityResultsManager");
        this.activityResultsManager = activityResultsManager;
    }

    @Override // expo.modules.kotlin.activityresult.AppContextActivityResultCaller
    public Object registerForActivityResult(AppContextActivityResultContract appContextActivityResultContract, AppContextActivityResultFallbackCallback appContextActivityResultFallbackCallback, Continuation continuation) {
        return this.activityResultsManager.registerForActivityResult(appContextActivityResultContract, appContextActivityResultFallbackCallback, continuation);
    }
}
