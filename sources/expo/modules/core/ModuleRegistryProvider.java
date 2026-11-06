package expo.modules.core;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ModuleRegistryProvider {
    private List mPackages;

    public ModuleRegistryProvider(List list) {
        this.mPackages = list;
    }

    protected List getPackages() {
        return this.mPackages;
    }
}
