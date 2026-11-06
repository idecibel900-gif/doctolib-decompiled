package expo.modules.kotlin.views;

import android.content.Context;
import android.view.View;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import expo.modules.kotlin.CoreLoggerKt;
import expo.modules.kotlin.ModuleHolder;
import expo.modules.kotlin.events.KModuleEventEmitterWrapperKt;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.OnViewDidUpdatePropsException;
import expo.modules.kotlin.exception.UnexpectedException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ViewManagerWrapperDelegate {
    private final ViewManagerDefinition definition;
    private final String delegateName;
    private ModuleHolder moduleHolder;

    public ViewManagerWrapperDelegate(ModuleHolder moduleHolder, ViewManagerDefinition definition, String str) {
        Intrinsics.checkNotNullParameter(moduleHolder, "moduleHolder");
        Intrinsics.checkNotNullParameter(definition, "definition");
        this.moduleHolder = moduleHolder;
        this.definition = definition;
        this.delegateName = str;
    }

    public final ModuleHolder getModuleHolder$expo_modules_core_release() {
        return this.moduleHolder;
    }

    public final void setModuleHolder$expo_modules_core_release(ModuleHolder moduleHolder) {
        Intrinsics.checkNotNullParameter(moduleHolder, "<set-?>");
        this.moduleHolder = moduleHolder;
    }

    public final ViewGroupDefinition getViewGroupDefinition$expo_modules_core_release() {
        this.definition.getViewGroupDefinition();
        return null;
    }

    public final String getName() {
        String str = this.delegateName;
        if (str != null) {
            return str;
        }
        return this.moduleHolder.getName() + "_" + this.definition.getName$expo_modules_core_release();
    }

    public final Map getProps() {
        return this.definition.getProps$expo_modules_core_release();
    }

    public final View createView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.definition.createView(context, this.moduleHolder.getModule().getAppContext());
    }

    public final void onViewDidUpdateProps(View view) {
        CodedException unexpectedException;
        CodedException unexpectedException2;
        Intrinsics.checkNotNullParameter(view, "view");
        Function1 onViewDidUpdateProps = this.definition.getOnViewDidUpdateProps();
        if (onViewDidUpdateProps != null) {
            try {
                onViewDidUpdateProps.invoke(view);
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                try {
                    if (th instanceof CodedException) {
                        unexpectedException2 = (CodedException) th;
                    } else if (th instanceof expo.modules.core.errors.CodedException) {
                        String code = ((expo.modules.core.errors.CodedException) th).getCode();
                        Intrinsics.checkNotNullExpressionValue(code, "getCode(...)");
                        unexpectedException2 = new CodedException(code, ((expo.modules.core.errors.CodedException) th).getMessage(), ((expo.modules.core.errors.CodedException) th).getCause());
                    } else {
                        unexpectedException2 = new UnexpectedException(th);
                    }
                    throw new OnViewDidUpdatePropsException(JvmClassMappingKt.getKotlinClass(view.getClass()), unexpectedException2);
                } catch (Throwable th2) {
                    if (ErrorViewKt.isErrorView(view)) {
                        return;
                    }
                    if (th2 instanceof CodedException) {
                        unexpectedException = (CodedException) th2;
                    } else if (th2 instanceof expo.modules.core.errors.CodedException) {
                        expo.modules.core.errors.CodedException codedException = (expo.modules.core.errors.CodedException) th2;
                        String code2 = codedException.getCode();
                        Intrinsics.checkNotNullExpressionValue(code2, "getCode(...)");
                        unexpectedException = new CodedException(code2, codedException.getMessage(), codedException.getCause());
                    } else {
                        unexpectedException = new UnexpectedException(th2);
                    }
                    CoreLoggerKt.getLogger().error("❌ Error occurred when invoking 'onViewDidUpdateProps' on '" + view.getClass().getSimpleName() + "'", unexpectedException);
                    this.definition.handleException(view, unexpectedException);
                }
            }
        }
    }

    public final List updateProperties(View view, ReadableMap propsMap) {
        CodedException unexpectedException;
        CodedException codedException;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(propsMap, "propsMap");
        Map props = getProps();
        ArrayList arrayList = new ArrayList();
        ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = propsMap.keySetIterator();
        while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
            String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
            AnyViewProp anyViewProp = (AnyViewProp) props.get(strNextKey);
            if (anyViewProp != null) {
                try {
                    anyViewProp.set(propsMap.getDynamic(strNextKey), view, this.moduleHolder.getModule().getAppContext());
                } catch (Throwable th) {
                    try {
                        if (!ErrorViewKt.isErrorView(view)) {
                            if (th instanceof CodedException) {
                                codedException = (CodedException) th;
                            } else {
                                if (th instanceof expo.modules.core.errors.CodedException) {
                                    String code = ((expo.modules.core.errors.CodedException) th).getCode();
                                    Intrinsics.checkNotNullExpressionValue(code, "getCode(...)");
                                    unexpectedException = new CodedException(code, ((expo.modules.core.errors.CodedException) th).getMessage(), ((expo.modules.core.errors.CodedException) th).getCause());
                                } else {
                                    unexpectedException = new UnexpectedException(th);
                                }
                                codedException = unexpectedException;
                            }
                            CoreLoggerKt.getLogger().error("❌ Cannot set the '" + getName() + "' prop on the '" + view + "'", codedException);
                            this.definition.handleException(view, codedException);
                        }
                    } catch (Throwable th2) {
                        arrayList.add(strNextKey);
                        throw th2;
                    }
                }
                arrayList.add(strNextKey);
            }
        }
        return arrayList;
    }

    public final void onDestroy(View view) {
        CodedException unexpectedException;
        CodedException codedException;
        Intrinsics.checkNotNullParameter(view, "view");
        try {
            Function1 onViewDestroys = this.definition.getOnViewDestroys();
            if (onViewDestroys != null) {
                onViewDestroys.invoke(view);
            }
        } catch (Throwable th) {
            if (ErrorViewKt.isErrorView(view)) {
                return;
            }
            if (th instanceof CodedException) {
                codedException = (CodedException) th;
            } else {
                if (th instanceof expo.modules.core.errors.CodedException) {
                    expo.modules.core.errors.CodedException codedException2 = (expo.modules.core.errors.CodedException) th;
                    String code = codedException2.getCode();
                    Intrinsics.checkNotNullExpressionValue(code, "getCode(...)");
                    unexpectedException = new CodedException(code, codedException2.getMessage(), codedException2.getCause());
                } else {
                    unexpectedException = new UnexpectedException(th);
                }
                codedException = unexpectedException;
            }
            CoreLoggerKt.getLogger().error("❌ '" + view + "' wasn't able to destroy itself", codedException);
            this.definition.handleException(view, codedException);
        }
    }

    public final Map getExportedCustomDirectEventTypeConstants() {
        String[] names;
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        CallbacksDefinition callbacksDefinition = this.definition.getCallbacksDefinition();
        if (callbacksDefinition != null && (names = callbacksDefinition.getNames()) != null) {
            for (String str : names) {
                mapCreateMapBuilder.put(KModuleEventEmitterWrapperKt.normalizeEventName(str), MapsKt.mapOf(TuplesKt.to("registrationName", str)));
            }
        }
        return MapsKt.build(mapCreateMapBuilder);
    }
}
