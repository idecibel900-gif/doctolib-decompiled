package expo.modules.logbox;

import android.content.Context;
import expo.modules.core.interfaces.Package;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lexpo/modules/logbox/ExpoLogBoxPackage;", "Lexpo/modules/core/interfaces/Package;", "<init>", "()V", "createReactActivityLifecycleListeners", "", "Lexpo/modules/core/interfaces/ReactActivityLifecycleListener;", "activityContext", "Landroid/content/Context;", "expo-log-box_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExpoLogBoxPackage implements Package {
    @Override // expo.modules.core.interfaces.Package
    public List createReactActivityLifecycleListeners(Context activityContext) {
        return CollectionsKt.emptyList();
    }
}
