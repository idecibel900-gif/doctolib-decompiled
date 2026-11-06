package expo.modules.core.interfaces;

import android.content.Context;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface Package {
    default List createInternalModules(Context context) {
        return Collections.EMPTY_LIST;
    }

    default List createSingletonModules(Context context) {
        return Collections.EMPTY_LIST;
    }

    default List createApplicationLifecycleListeners(Context context) {
        return Collections.EMPTY_LIST;
    }

    default List createReactNativeHostHandlers(Context context) {
        return Collections.EMPTY_LIST;
    }

    default List createReactActivityLifecycleListeners(Context context) {
        return Collections.EMPTY_LIST;
    }

    default List createReactActivityHandlers(Context context) {
        return Collections.EMPTY_LIST;
    }
}
