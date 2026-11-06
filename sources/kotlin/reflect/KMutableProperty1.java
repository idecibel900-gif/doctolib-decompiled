package kotlin.reflect;

import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes5.dex */
public interface KMutableProperty1 extends KProperty1, KMutableProperty {

    public interface Setter extends KMutableProperty.Setter, Function2 {
    }

    @Override // kotlin.reflect.KMutableProperty
    Setter getSetter();
}
