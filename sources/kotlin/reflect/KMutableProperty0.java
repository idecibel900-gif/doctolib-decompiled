package kotlin.reflect;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes5.dex */
public interface KMutableProperty0 extends KProperty0, KMutableProperty {

    public interface Setter extends KMutableProperty.Setter, Function1 {
    }

    @Override // kotlin.reflect.KMutableProperty
    Setter getSetter();
}
