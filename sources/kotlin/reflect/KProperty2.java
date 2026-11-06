package kotlin.reflect;

import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes5.dex */
public interface KProperty2 extends KProperty, Function2 {

    public interface Getter extends KProperty.Getter, Function2 {
    }

    Object get(Object obj, Object obj2);

    @Override // kotlin.reflect.KProperty
    Getter getGetter();
}
