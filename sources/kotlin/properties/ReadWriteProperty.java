package kotlin.properties;

import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes5.dex */
public interface ReadWriteProperty extends ReadOnlyProperty {
    @Override // kotlin.properties.ReadOnlyProperty
    Object getValue(Object obj, KProperty kProperty);

    void setValue(Object obj, KProperty kProperty, Object obj2);
}
