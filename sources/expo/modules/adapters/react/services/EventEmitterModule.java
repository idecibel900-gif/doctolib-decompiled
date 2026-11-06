package expo.modules.adapters.react.services;

import android.os.Bundle;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import expo.modules.core.interfaces.InternalModule;
import expo.modules.core.interfaces.services.EventEmitter;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class EventEmitterModule implements EventEmitter, InternalModule {
    private ReactContext mReactContext;

    public EventEmitterModule(ReactContext reactContext) {
        this.mReactContext = reactContext;
    }

    @Override // expo.modules.core.interfaces.services.EventEmitter
    public void emit(String str, Bundle bundle) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.mReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, Arguments.fromBundle(bundle));
    }

    @Override // expo.modules.core.interfaces.InternalModule
    public List getExportedInterfaces() {
        return Collections.singletonList(EventEmitter.class);
    }
}
