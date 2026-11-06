package expo.modules.kotlin.viewevent;

import android.content.Context;
import android.view.View;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import expo.modules.adapters.react.NativeModulesProxy;
import expo.modules.core.logging.Logger;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.CoreLoggerKt;
import expo.modules.kotlin.ModuleHolder;
import expo.modules.kotlin.ReactExtensionsKt;
import expo.modules.kotlin.events.EventEmitter;
import expo.modules.kotlin.types.JSTypeConverterHelperKt;
import expo.modules.kotlin.types.JSTypeConverterProvider;
import expo.modules.kotlin.views.CallbacksDefinition;
import expo.modules.kotlin.views.ViewManagerDefinition;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public class ViewEvent implements ViewEventCallback {
    private final Function1 coalescingKey;
    private boolean isValidated;
    private final String name;
    private final View view;

    public ViewEvent(String name, View view, Function1 function1) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(view, "view");
        this.name = name;
        this.view = view;
        this.coalescingKey = function1;
    }

    @Override // expo.modules.kotlin.viewevent.ViewEventCallback
    public void invoke(Object obj) {
        Context context = this.view.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        NativeModulesProxy unimoduleProxy = ReactExtensionsKt.getUnimoduleProxy((ReactContext) context);
        if (unimoduleProxy == null) {
            return;
        }
        AppContext appContext = unimoduleProxy.getKotlinInteropModuleRegistry().getAppContext();
        if (!this.isValidated) {
            ModuleHolder moduleHolder = appContext.getRegistry().getModuleHolder(this.view.getClass());
            if (moduleHolder == null) {
                Logger.warn$default(CoreLoggerKt.getLogger(), "⚠️ Cannot get module holder for " + this.view.getClass(), null, 2, null);
                return;
            }
            ViewManagerDefinition viewDefinition = appContext.getRegistry().getViewDefinition(moduleHolder, this.view.getClass());
            CallbacksDefinition callbacksDefinition = viewDefinition != null ? viewDefinition.getCallbacksDefinition() : null;
            if (callbacksDefinition == null) {
                Logger.warn$default(CoreLoggerKt.getLogger(), "⚠️ Cannot get callbacks for " + moduleHolder.getModule().getClass(), null, 2, null);
                return;
            }
            String[] names = callbacksDefinition.getNames();
            int length = names.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    if (Intrinsics.areEqual(names[i], this.name)) {
                        this.isValidated = true;
                        break;
                    }
                    i++;
                } else {
                    Logger.warn$default(CoreLoggerKt.getLogger(), "⚠️ Event " + this.name + " wasn't exported from " + moduleHolder.getModule().getClass(), null, 2, null);
                    return;
                }
            }
        }
        EventEmitter callbackInvoker$expo_modules_core_release = appContext.getCallbackInvoker$expo_modules_core_release();
        if (callbackInvoker$expo_modules_core_release != null) {
            View view = this.view;
            String str = this.name;
            WritableMap writableMapConvertEventBody = convertEventBody(obj);
            Function1 function1 = this.coalescingKey;
            callbackInvoker$expo_modules_core_release.emit(view, str, writableMapConvertEventBody, function1 != null ? (Short) function1.invoke(obj) : null);
        }
    }

    private final WritableMap convertEventBody(Object obj) {
        Object objConvertToJSValue$default = JSTypeConverterProvider.convertToJSValue$default(JSTypeConverterProvider.INSTANCE, obj, null, false, 6, null);
        if ((objConvertToJSValue$default instanceof Unit) || objConvertToJSValue$default == null) {
            return null;
        }
        if (objConvertToJSValue$default instanceof WritableMap) {
            return (WritableMap) objConvertToJSValue$default;
        }
        WritableMap writableMapCreateMap = JSTypeConverterProvider.DefaultContainerProvider.INSTANCE.createMap();
        JSTypeConverterHelperKt.putGeneric(writableMapCreateMap, "payload", objConvertToJSValue$default);
        return writableMapCreateMap;
    }
}
