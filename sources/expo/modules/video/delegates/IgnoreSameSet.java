package expo.modules.video.delegates;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes5.dex */
public final class IgnoreSameSet {
    private final Function2 didSet;
    private final Function1 propertyMapper;
    private Object value;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object _init_$lambda$0(Object obj) {
        return obj;
    }

    public IgnoreSameSet(Object obj, Function1 propertyMapper, Function2 function2) {
        Intrinsics.checkNotNullParameter(propertyMapper, "propertyMapper");
        this.value = obj;
        this.propertyMapper = propertyMapper;
        this.didSet = function2;
    }

    public /* synthetic */ IgnoreSameSet(Object obj, Function1 function1, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i & 2) != 0 ? new Function1() { // from class: expo.modules.video.delegates.IgnoreSameSet$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return IgnoreSameSet._init_$lambda$0(obj2);
            }
        } : function1, (i & 4) != 0 ? null : function2);
    }

    public final Object getValue(Object obj, KProperty property) {
        Intrinsics.checkNotNullParameter(property, "property");
        return this.value;
    }

    public final void setValue(Object obj, KProperty property, Object obj2) {
        Intrinsics.checkNotNullParameter(property, "property");
        Object obj3 = this.value;
        if (obj3 != null ? obj3.equals(this.propertyMapper.invoke(obj2)) : false) {
            return;
        }
        Object obj4 = this.value;
        Object objInvoke = this.propertyMapper.invoke(obj2);
        this.value = objInvoke;
        Function2 function2 = this.didSet;
        if (function2 != null) {
            function2.invoke(objInvoke, obj4);
        }
    }
}
