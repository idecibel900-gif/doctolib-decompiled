package expo.modules.kotlin.objects;

import expo.modules.kotlin.jni.JNINoArgsFunctionBody;
import expo.modules.kotlin.jni.decorators.JSDecoratorsBridgingObject;
import expo.modules.kotlin.types.JSTypeConverterProvider;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ConstantComponent {
    private final Function0 getter;
    private final String name;

    public ConstantComponent(String name, Function0 getter) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(getter, "getter");
        this.name = name;
        this.getter = getter;
    }

    public final void attachToJSObject(JSDecoratorsBridgingObject jsObject) {
        Intrinsics.checkNotNullParameter(jsObject, "jsObject");
        jsObject.registerConstant(this.name, new JNINoArgsFunctionBody() { // from class: expo.modules.kotlin.objects.ConstantComponent$$ExternalSyntheticLambda0
            @Override // expo.modules.kotlin.jni.JNINoArgsFunctionBody
            public final Object invoke() {
                return ConstantComponent.attachToJSObject$lambda$0(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object attachToJSObject$lambda$0(ConstantComponent constantComponent) {
        return JSTypeConverterProvider.convertToJSValue$default(JSTypeConverterProvider.INSTANCE, constantComponent.getter.invoke(), null, false, 6, null);
    }
}
