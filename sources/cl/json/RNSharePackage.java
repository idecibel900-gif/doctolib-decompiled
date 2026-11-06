package cl.json;

import com.facebook.react.TurboReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class RNSharePackage extends TurboReactPackage {
    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    public NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        if (str.equals(NativeRNShareSpec.NAME)) {
            return new RNShare(reactApplicationContext);
        }
        return null;
    }

    @Override // com.facebook.react.BaseReactPackage
    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        return new ReactModuleInfoProvider() { // from class: cl.json.RNSharePackage$$ExternalSyntheticLambda0
            @Override // com.facebook.react.module.model.ReactModuleInfoProvider
            public final Map getReactModuleInfos() {
                return RNSharePackage.$r8$lambda$VY7Y8jT3RkOEceu98SerpnP1Qjs();
            }
        };
    }

    public static /* synthetic */ Map $r8$lambda$VY7Y8jT3RkOEceu98SerpnP1Qjs() {
        HashMap map = new HashMap();
        map.put(NativeRNShareSpec.NAME, new ReactModuleInfo(NativeRNShareSpec.NAME, NativeRNShareSpec.NAME, false, false, true, false, true));
        return map;
    }
}
