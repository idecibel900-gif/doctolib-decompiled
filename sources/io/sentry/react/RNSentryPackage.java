package io.sentry.react;

import androidx.core.provider.FontRequestWorker$$ExternalSyntheticBackport1;
import com.facebook.react.TurboReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import io.sentry.react.replay.RNSentryReplayMaskManager;
import io.sentry.react.replay.RNSentryReplayUnmaskManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class RNSentryPackage extends TurboReactPackage {
    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    public NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        if (NativeRNSentrySpec.NAME.equals(str)) {
            return new RNSentryModule(reactApplicationContext);
        }
        return getFabricComponentNativeModule(str);
    }

    private NativeModule getFabricComponentNativeModule(String str) {
        if ("RNSentryReplayMask".equals(str)) {
            return new RNSentryReplayMaskManager();
        }
        if ("RNSentryReplayUnmask".equals(str)) {
            return new RNSentryReplayUnmaskManager();
        }
        return null;
    }

    @Override // com.facebook.react.BaseReactPackage
    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        return new ReactModuleInfoProvider() { // from class: io.sentry.react.RNSentryPackage$$ExternalSyntheticLambda1
            @Override // com.facebook.react.module.model.ReactModuleInfoProvider
            public final Map getReactModuleInfos() {
                return RNSentryPackage.m5227$r8$lambda$CnkYPMdzX9XcpOGMs3Rc84qUTg();
            }
        };
    }

    /* JADX INFO: renamed from: $r8$lambda$CnkYP-MdzX9XcpOGMs3Rc84qUTg, reason: not valid java name */
    public static /* synthetic */ Map m5227$r8$lambda$CnkYPMdzX9XcpOGMs3Rc84qUTg() {
        HashMap map = new HashMap();
        map.put(NativeRNSentrySpec.NAME, new ReactModuleInfo(NativeRNSentrySpec.NAME, NativeRNSentrySpec.NAME, false, false, true, false, true));
        map.put("RNSentryReplayMask", new ReactModuleInfo("RNSentryReplayMask", "RNSentryReplayMask", false, false, false, false, true));
        map.put("RNSentryReplayUnmask", new ReactModuleInfo("RNSentryReplayUnmask", "RNSentryReplayUnmask", false, false, false, false, true));
        return map;
    }

    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    public List createViewManagers(ReactApplicationContext reactApplicationContext) {
        return FontRequestWorker$$ExternalSyntheticBackport1.m(new Object[]{new RNSentryOnDrawReporterManager(reactApplicationContext), new RNSentryReplayMaskManager(), new RNSentryReplayUnmaskManager()});
    }
}
