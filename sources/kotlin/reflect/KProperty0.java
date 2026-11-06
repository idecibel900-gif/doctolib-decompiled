package kotlin.reflect;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes5.dex */
public interface KProperty0 extends KProperty, Function0 {

    public interface Getter extends KProperty.Getter, Function0 {
    }

    Object get();

    @Override // kotlin.reflect.KProperty
    Getter getGetter();
}
