package expo.modules.video.utils;

import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes5.dex */
public final class MutableWeakReference {
    private final Function2 didSet;
    private WeakReference ref;

    public MutableWeakReference(Object obj, Function2 function2) {
        this.didSet = function2;
        this.ref = new WeakReference(obj);
    }

    public final Object getValue(Object obj, KProperty property) {
        Intrinsics.checkNotNullParameter(property, "property");
        return get();
    }

    public final void setValue(Object obj, KProperty property, Object obj2) {
        Intrinsics.checkNotNullParameter(property, "property");
        set(obj2);
    }

    public final Object get() {
        return this.ref.get();
    }

    public final void set(Object obj) {
        Object obj2 = this.ref.get();
        this.ref = new WeakReference(obj);
        Function2 function2 = this.didSet;
        if (function2 != null) {
            function2.invoke(obj2, obj);
        }
    }
}
