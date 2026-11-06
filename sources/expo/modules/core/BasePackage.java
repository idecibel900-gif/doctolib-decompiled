package expo.modules.core;

import android.content.Context;
import expo.modules.core.interfaces.Package;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class BasePackage implements Package {
    @Override // expo.modules.core.interfaces.Package
    public List createInternalModules(Context context) {
        return Collections.EMPTY_LIST;
    }

    @Override // expo.modules.core.interfaces.Package
    public List createSingletonModules(Context context) {
        return Collections.EMPTY_LIST;
    }

    @Override // expo.modules.core.interfaces.Package
    public List createApplicationLifecycleListeners(Context context) {
        return Collections.EMPTY_LIST;
    }

    @Override // expo.modules.core.interfaces.Package
    public List createReactNativeHostHandlers(Context context) {
        return Collections.EMPTY_LIST;
    }

    @Override // expo.modules.core.interfaces.Package
    public List createReactActivityLifecycleListeners(Context context) {
        return Collections.EMPTY_LIST;
    }

    @Override // expo.modules.core.interfaces.Package
    public List createReactActivityHandlers(Context context) {
        return Collections.EMPTY_LIST;
    }
}
