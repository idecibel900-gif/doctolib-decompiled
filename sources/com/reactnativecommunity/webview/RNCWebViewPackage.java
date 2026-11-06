package com.reactnativecommunity.webview;

import com.facebook.react.TurboReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class RNCWebViewPackage extends TurboReactPackage {
    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    public List createViewManagers(ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RNCWebViewManager());
        return arrayList;
    }

    @Override // com.facebook.react.BaseReactPackage
    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        return new ReactModuleInfoProvider() { // from class: com.reactnativecommunity.webview.RNCWebViewPackage$$ExternalSyntheticLambda0
            @Override // com.facebook.react.module.model.ReactModuleInfoProvider
            public final Map getReactModuleInfos() {
                return RNCWebViewPackage.$r8$lambda$i8wQ1LFjZt4quxNcJHW2VSUZQUg();
            }
        };
    }

    public static /* synthetic */ Map $r8$lambda$i8wQ1LFjZt4quxNcJHW2VSUZQUg() {
        HashMap map = new HashMap();
        map.put(NativeRNCWebViewModuleSpec.NAME, new ReactModuleInfo(NativeRNCWebViewModuleSpec.NAME, NativeRNCWebViewModuleSpec.NAME, false, false, true, false, true));
        return map;
    }

    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    public NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        if (str.equals(NativeRNCWebViewModuleSpec.NAME)) {
            return new RNCWebViewModule(reactApplicationContext);
        }
        return null;
    }
}
