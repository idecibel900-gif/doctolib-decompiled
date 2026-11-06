package expo.modules.kotlin.views;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.bridge.ReactContext;
import expo.modules.adapters.react.NativeModulesProxy;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.ReactExtensionsKt;
import expo.modules.kotlin.defaultmodules.JSLoggerModule;
import expo.modules.kotlin.exception.CodedException;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ViewManagerDefinition {
    private final List asyncFunctions;
    private final CallbacksDefinition callbacksDefinition;
    private final String name;
    private final Function1 onViewDestroys;
    private final Function1 onViewDidUpdateProps;
    private final Map props;
    private final List propsNames;
    private final Function2 viewFactory;
    private final Class viewType;

    public final ViewGroupDefinition getViewGroupDefinition() {
        return null;
    }

    public ViewManagerDefinition(Function2 viewFactory, Class viewType, Map props, String name, Function1 function1, CallbacksDefinition callbacksDefinition, ViewGroupDefinition viewGroupDefinition, Function1 function2, List asyncFunctions) {
        Intrinsics.checkNotNullParameter(viewFactory, "viewFactory");
        Intrinsics.checkNotNullParameter(viewType, "viewType");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(asyncFunctions, "asyncFunctions");
        this.viewFactory = viewFactory;
        this.viewType = viewType;
        this.props = props;
        this.name = name;
        this.onViewDestroys = function1;
        this.callbacksDefinition = callbacksDefinition;
        this.onViewDidUpdateProps = function2;
        this.asyncFunctions = asyncFunctions;
        this.propsNames = CollectionsKt.toList(props.keySet());
    }

    public final Class getViewType$expo_modules_core_release() {
        return this.viewType;
    }

    public final Map getProps$expo_modules_core_release() {
        return this.props;
    }

    public final String getName$expo_modules_core_release() {
        return this.name;
    }

    public final Function1 getOnViewDestroys() {
        return this.onViewDestroys;
    }

    public final CallbacksDefinition getCallbacksDefinition() {
        return this.callbacksDefinition;
    }

    public final Function1 getOnViewDidUpdateProps() {
        return this.onViewDidUpdateProps;
    }

    public final List getAsyncFunctions() {
        return this.asyncFunctions;
    }

    public final View createView(Context context, AppContext appContext) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        return (View) this.viewFactory.invoke(context, appContext);
    }

    public final List getPropsNames() {
        return this.propsNames;
    }

    public final ViewManagerType getViewManagerType() {
        if (ViewGroup.class.isAssignableFrom(this.viewType)) {
            return ViewManagerType.GROUP;
        }
        return ViewManagerType.SIMPLE;
    }

    public final void handleException(View view, CodedException exception) {
        NativeModulesProxy unimoduleProxy;
        JSLoggerModule errorManager;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(exception, "exception");
        Context context = view.getContext();
        ReactContext reactContext = context instanceof ReactContext ? (ReactContext) context : null;
        if (reactContext == null || (unimoduleProxy = ReactExtensionsKt.getUnimoduleProxy(reactContext)) == null || (errorManager = unimoduleProxy.getKotlinInteropModuleRegistry().getAppContext().getErrorManager()) == null) {
            return;
        }
        errorManager.reportExceptionToLogBox(exception);
    }
}
