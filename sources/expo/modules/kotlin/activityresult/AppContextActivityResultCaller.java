package expo.modules.kotlin.activityresult;

import java.io.Serializable;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public interface AppContextActivityResultCaller {
    Object registerForActivityResult(AppContextActivityResultContract appContextActivityResultContract, AppContextActivityResultFallbackCallback appContextActivityResultFallbackCallback, Continuation continuation);

    public static final class DefaultImpls {
        public static /* synthetic */ Object registerForActivityResult$default(AppContextActivityResultCaller appContextActivityResultCaller, AppContextActivityResultContract appContextActivityResultContract, AppContextActivityResultFallbackCallback appContextActivityResultFallbackCallback, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: registerForActivityResult");
            }
            if ((i & 2) != 0) {
                appContextActivityResultFallbackCallback = new AppContextActivityResultFallbackCallback() { // from class: expo.modules.kotlin.activityresult.AppContextActivityResultCaller$DefaultImpls$$ExternalSyntheticLambda0
                    @Override // expo.modules.kotlin.activityresult.AppContextActivityResultFallbackCallback
                    public final void onActivityResult(Serializable serializable, Object obj2) {
                        Intrinsics.checkNotNullParameter(serializable, "<unused var>");
                    }
                };
            }
            return appContextActivityResultCaller.registerForActivityResult(appContextActivityResultContract, appContextActivityResultFallbackCallback, continuation);
        }
    }
}
