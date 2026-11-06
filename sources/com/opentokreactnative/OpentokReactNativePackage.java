package com.opentokreactnative;

import com.facebook.react.BaseReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class OpentokReactNativePackage extends BaseReactPackage {
    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    public NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        if (str.equals("OpentokReactNative")) {
            return new OpentokReactNativeModule(reactApplicationContext);
        }
        return null;
    }

    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    public List createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Arrays.asList(new OTRNPublisherManager(reactApplicationContext), new OTRNSubscriberManager(reactApplicationContext));
    }

    @Override // com.facebook.react.BaseReactPackage
    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        return new ReactModuleInfoProvider() { // from class: com.opentokreactnative.OpentokReactNativePackage.1
            @Override // com.facebook.react.module.model.ReactModuleInfoProvider
            public Map getReactModuleInfos() {
                HashMap map = new HashMap();
                map.put("OpentokReactNative", new ReactModuleInfo("OpentokReactNative", "OpentokReactNative", false, false, false, true));
                map.put(OTRNPublisherManager.REACT_CLASS, new ReactModuleInfo(OTRNPublisherManager.REACT_CLASS, OTRNPublisherManager.REACT_CLASS, false, false, false, true));
                map.put(OTRNSubscriberManager.REACT_CLASS, new ReactModuleInfo(OTRNSubscriberManager.REACT_CLASS, OTRNSubscriberManager.REACT_CLASS, false, false, false, true));
                return map;
            }
        };
    }
}
