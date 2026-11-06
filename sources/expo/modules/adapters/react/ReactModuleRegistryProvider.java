package expo.modules.adapters.react;

import android.content.Context;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.ReactApplicationContext;
import expo.modules.core.ModuleRegistry;
import expo.modules.core.ModuleRegistryProvider;
import expo.modules.core.interfaces.Package;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ReactModuleRegistryProvider extends ModuleRegistryProvider {
    private Collection mReactViewManagers;
    private Collection mSingletonModules;

    public ReactModuleRegistryProvider(List list, List list2) {
        super(list);
        this.mSingletonModules = list2;
    }

    public ModuleRegistry get(Context context) {
        ArrayList arrayList = new ArrayList();
        ReactPackagesProvider reactPackagesProvider = new ReactPackagesProvider();
        for (Package r3 : getPackages()) {
            arrayList.addAll(r3.createInternalModules(context));
            if (r3 instanceof ReactPackage) {
                reactPackagesProvider.addPackage((ReactPackage) r3);
            }
        }
        arrayList.add(reactPackagesProvider);
        return new ModuleRegistry(arrayList, getSingletonModules(context));
    }

    private Collection getSingletonModules(Context context) {
        Collection collection = this.mSingletonModules;
        if (collection != null) {
            return collection;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = getPackages().iterator();
        while (it.hasNext()) {
            arrayList.addAll(((Package) it.next()).createSingletonModules(context));
        }
        return arrayList;
    }

    public Collection getReactViewManagers(ReactApplicationContext reactApplicationContext) {
        Collection collection = this.mReactViewManagers;
        if (collection != null) {
            return collection;
        }
        this.mReactViewManagers = new HashSet();
        for (Package r1 : getPackages()) {
            if (r1 instanceof ReactPackage) {
                this.mReactViewManagers.addAll(((ReactPackage) r1).createViewManagers(reactApplicationContext));
            }
        }
        return this.mReactViewManagers;
    }
}
