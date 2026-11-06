package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;

/* JADX INFO: loaded from: classes5.dex */
public interface JvmTypeFactory {
    Object boxType(Object obj);

    Object createFromString(String str);

    Object createObjectType(String str);

    Object createPrimitiveType(PrimitiveType primitiveType);

    Object getJavaLangClassType();

    String toString(Object obj);
}
