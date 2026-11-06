package expo.modules.adapters.react;

import com.facebook.react.ReactPackage;
import expo.modules.core.interfaces.InternalModule;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ReactPackagesProvider implements InternalModule {
    private Collection mReactPackages = new ArrayList();

    @Override // expo.modules.core.interfaces.InternalModule
    public List getExportedInterfaces() {
        return Collections.singletonList(ReactPackagesProvider.class);
    }

    public void addPackage(ReactPackage reactPackage) {
        this.mReactPackages.add(reactPackage);
    }

    public Collection getReactPackages() {
        return this.mReactPackages;
    }
}
