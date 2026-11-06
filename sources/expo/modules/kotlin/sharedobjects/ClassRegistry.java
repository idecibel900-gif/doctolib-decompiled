package expo.modules.kotlin.sharedobjects;

import expo.modules.kotlin.jni.JavaScriptObject;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ClassRegistry {
    private Map pairs = new LinkedHashMap();

    public final void add$expo_modules_core_release(final Class cls, JavaScriptObject js) {
        Intrinsics.checkNotNullParameter(cls, "native");
        Intrinsics.checkNotNullParameter(js, "js");
        js.defineDeallocator$expo_modules_core_release(new Function0() { // from class: expo.modules.kotlin.sharedobjects.ClassRegistry$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ClassRegistry.add$lambda$0(this.f$0, cls);
            }
        });
        this.pairs.put(cls, js);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit add$lambda$0(ClassRegistry classRegistry, Class cls) {
        classRegistry.delete(cls);
        return Unit.INSTANCE;
    }

    private final void delete(Class cls) {
        this.pairs.remove(cls);
    }

    public final JavaScriptObject toJavaScriptObject$expo_modules_core_release(Class cls) {
        Intrinsics.checkNotNullParameter(cls, "native");
        return (JavaScriptObject) this.pairs.get(cls);
    }
}
