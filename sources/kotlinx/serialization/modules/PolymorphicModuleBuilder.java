package kotlinx.serialization.modules;

import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;

/* JADX INFO: loaded from: classes5.dex */
public final class PolymorphicModuleBuilder {
    private final KClass baseClass;
    private final KSerializer baseSerializer;
    private Function1 defaultDeserializerProvider;
    private Function1 defaultSerializerProvider;
    private final List subclasses;

    public PolymorphicModuleBuilder(KClass baseClass, KSerializer kSerializer) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        this.baseClass = baseClass;
        this.baseSerializer = kSerializer;
        this.subclasses = new ArrayList();
    }

    public final void subclass(KClass subclass, KSerializer serializer) {
        Intrinsics.checkNotNullParameter(subclass, "subclass");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        this.subclasses.add(TuplesKt.to(subclass, serializer));
    }

    public final void buildTo(SerializersModuleBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        KSerializer kSerializer = this.baseSerializer;
        if (kSerializer != null) {
            KClass kClass = this.baseClass;
            SerializersModuleBuilder.registerPolymorphicSerializer$default(builder, kClass, kClass, kSerializer, false, 8, null);
        }
        for (Pair pair : this.subclasses) {
            KClass kClass2 = (KClass) pair.getFirst();
            KSerializer kSerializer2 = (KSerializer) pair.getSecond();
            KClass kClass3 = this.baseClass;
            Intrinsics.checkNotNull(kClass2, "null cannot be cast to non-null type kotlin.reflect.KClass<Base of kotlinx.serialization.modules.PolymorphicModuleBuilder.buildTo$lambda$1>");
            Intrinsics.checkNotNull(kSerializer2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            SerializersModuleBuilder.registerPolymorphicSerializer$default(builder, kClass3, kClass2, kSerializer2, false, 8, null);
        }
        Function1 function1 = this.defaultSerializerProvider;
        if (function1 != null) {
            builder.registerDefaultPolymorphicSerializer(this.baseClass, function1, false);
        }
        Function1 function2 = this.defaultDeserializerProvider;
        if (function2 != null) {
            builder.registerDefaultPolymorphicDeserializer(this.baseClass, function2, false);
        }
    }
}
