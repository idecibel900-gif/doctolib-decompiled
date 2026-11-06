package kotlin.reflect;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes5.dex */
public interface KProperty1 extends KProperty, Function1 {

    public interface Getter extends KProperty.Getter, Function1 {
    }

    Object get(Object obj);

    Object getDelegate(Object obj);

    @Override // kotlin.reflect.KProperty
    Getter getGetter();
}
