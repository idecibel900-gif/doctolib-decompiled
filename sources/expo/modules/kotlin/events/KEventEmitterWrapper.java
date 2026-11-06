package expo.modules.kotlin.events;

import android.os.Bundle;
import android.view.View;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcher;
import expo.modules.kotlin.types.JSTypeConverterProvider;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public class KEventEmitterWrapper implements EventEmitter, expo.modules.core.interfaces.services.EventEmitter {
    private final expo.modules.core.interfaces.services.EventEmitter legacyEventEmitter;
    private final WeakReference reactContextHolder;

    @Override // expo.modules.core.interfaces.services.EventEmitter
    public void emit(String str, Bundle bundle) {
        this.legacyEventEmitter.emit(str, bundle);
    }

    public KEventEmitterWrapper(expo.modules.core.interfaces.services.EventEmitter legacyEventEmitter, WeakReference reactContextHolder) {
        Intrinsics.checkNotNullParameter(legacyEventEmitter, "legacyEventEmitter");
        Intrinsics.checkNotNullParameter(reactContextHolder, "reactContextHolder");
        this.legacyEventEmitter = legacyEventEmitter;
        this.reactContextHolder = reactContextHolder;
    }

    private final DeviceEventManagerModule.RCTDeviceEventEmitter getDeviceEventEmitter() {
        ReactApplicationContext reactApplicationContext = (ReactApplicationContext) this.reactContextHolder.get();
        if (reactApplicationContext != null) {
            return (DeviceEventManagerModule.RCTDeviceEventEmitter) reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
        }
        return null;
    }

    @Override // expo.modules.kotlin.events.EventEmitter
    public void emit(String eventName, Map map) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        DeviceEventManagerModule.RCTDeviceEventEmitter deviceEventEmitter = getDeviceEventEmitter();
        if (deviceEventEmitter != null) {
            deviceEventEmitter.emit(eventName, JSTypeConverterProvider.legacyConvertToJSValue$default(JSTypeConverterProvider.INSTANCE, map, null, 2, null));
        }
    }

    @Override // expo.modules.kotlin.events.EventEmitter
    public void emit(View view, String eventName, WritableMap writableMap, Short sh) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        ReactApplicationContext reactApplicationContext = (ReactApplicationContext) this.reactContextHolder.get();
        if (reactApplicationContext == null) {
            return;
        }
        UIEvent uIEvent = new UIEvent(UIManagerHelper.getSurfaceId(view), view.getId(), eventName, writableMap, sh);
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(reactApplicationContext, view.getId());
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(uIEvent);
        }
    }

    private static final class UIEvent extends Event {
        private final Short coalescingKey;
        private final WritableMap eventBody;
        private final String eventNameInternal;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UIEvent(int i, int i2, String eventNameInternal, WritableMap writableMap, Short sh) {
            super(i, i2);
            Intrinsics.checkNotNullParameter(eventNameInternal, "eventNameInternal");
            this.eventNameInternal = eventNameInternal;
            this.eventBody = writableMap;
            this.coalescingKey = sh;
        }

        @Override // com.facebook.react.uimanager.events.Event
        public String getEventName() {
            return KModuleEventEmitterWrapperKt.normalizeEventName(this.eventNameInternal);
        }

        @Override // com.facebook.react.uimanager.events.Event
        public boolean canCoalesce() {
            return this.coalescingKey != null;
        }

        @Override // com.facebook.react.uimanager.events.Event
        public short getCoalescingKey() {
            Short sh = this.coalescingKey;
            if (sh != null) {
                return sh.shortValue();
            }
            return (short) 0;
        }

        @Override // com.facebook.react.uimanager.events.Event
        protected WritableMap getEventData() {
            WritableMap writableMap = this.eventBody;
            return writableMap == null ? Arguments.createMap() : writableMap;
        }
    }
}
