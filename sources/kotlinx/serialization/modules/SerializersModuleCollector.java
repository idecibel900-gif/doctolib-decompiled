package kotlinx.serialization.modules;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;

/* JADX INFO: loaded from: classes5.dex */
public interface SerializersModuleCollector {
    void contextual(KClass kClass, Function1 function1);

    void contextual(KClass kClass, KSerializer kSerializer);

    void polymorphic(KClass kClass, KClass kClass2, KSerializer kSerializer);

    void polymorphicDefaultDeserializer(KClass kClass, Function1 function1);

    void polymorphicDefaultSerializer(KClass kClass, Function1 function1);

    public static final class DefaultImpls {
        public static void contextual(SerializersModuleCollector serializersModuleCollector, KClass kClass, final KSerializer serializer) {
            Intrinsics.checkNotNullParameter(kClass, "kClass");
            Intrinsics.checkNotNullParameter(serializer, "serializer");
            serializersModuleCollector.contextual(kClass, new Function1() { // from class: kotlinx.serialization.modules.SerializersModuleCollector.contextual.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final KSerializer invoke(List it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return serializer;
                }
            });
        }
    }
}
