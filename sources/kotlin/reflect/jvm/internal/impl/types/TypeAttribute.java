package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes5.dex */
public abstract class TypeAttribute {
    public abstract TypeAttribute add(TypeAttribute typeAttribute);

    public abstract KClass getKey();

    public abstract TypeAttribute intersect(TypeAttribute typeAttribute);
}
