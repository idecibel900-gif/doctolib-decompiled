package kotlinx.serialization.modules;

import java.util.HashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;

/* JADX INFO: loaded from: classes5.dex */
public final class SerializersModuleBuilder implements SerializersModuleCollector {
    private final Map class2ContextualProvider = new HashMap();
    private final Map polyBase2Serializers = new HashMap();
    private final Map polyBase2DefaultSerializerProvider = new HashMap();
    private final Map polyBase2NamedSerializers = new HashMap();
    private final Map polyBase2DefaultDeserializerProvider = new HashMap();

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public void contextual(KClass kClass, KSerializer serializer) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        registerSerializer$default(this, kClass, new ContextualProvider.Argless(serializer), false, 4, null);
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public void contextual(KClass kClass, Function1 provider) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(provider, "provider");
        registerSerializer$default(this, kClass, new ContextualProvider.WithTypeArguments(provider), false, 4, null);
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public void polymorphic(KClass baseClass, KClass actualClass, KSerializer actualSerializer) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(actualClass, "actualClass");
        Intrinsics.checkNotNullParameter(actualSerializer, "actualSerializer");
        registerPolymorphicSerializer$default(this, baseClass, actualClass, actualSerializer, false, 8, null);
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public void polymorphicDefaultSerializer(KClass baseClass, Function1 defaultSerializerProvider) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(defaultSerializerProvider, "defaultSerializerProvider");
        registerDefaultPolymorphicSerializer(baseClass, defaultSerializerProvider, false);
    }

    @Override // kotlinx.serialization.modules.SerializersModuleCollector
    public void polymorphicDefaultDeserializer(KClass baseClass, Function1 defaultDeserializerProvider) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(defaultDeserializerProvider, "defaultDeserializerProvider");
        registerDefaultPolymorphicDeserializer(baseClass, defaultDeserializerProvider, false);
    }

    public static /* synthetic */ void registerSerializer$default(SerializersModuleBuilder serializersModuleBuilder, KClass kClass, ContextualProvider contextualProvider, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        serializersModuleBuilder.registerSerializer(kClass, contextualProvider, z);
    }

    public final void registerSerializer(KClass forClass, ContextualProvider provider, boolean z) {
        ContextualProvider contextualProvider;
        Intrinsics.checkNotNullParameter(forClass, "forClass");
        Intrinsics.checkNotNullParameter(provider, "provider");
        if (!z && (contextualProvider = (ContextualProvider) this.class2ContextualProvider.get(forClass)) != null && !Intrinsics.areEqual(contextualProvider, provider)) {
            throw new SerializerAlreadyRegisteredException("Contextual serializer or serializer provider for " + forClass + " already registered in this module");
        }
        this.class2ContextualProvider.put(forClass, provider);
    }

    public final void registerDefaultPolymorphicSerializer(KClass baseClass, Function1 defaultSerializerProvider, boolean z) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(defaultSerializerProvider, "defaultSerializerProvider");
        Function1 function1 = (Function1) this.polyBase2DefaultSerializerProvider.get(baseClass);
        if (function1 != null && !Intrinsics.areEqual(function1, defaultSerializerProvider) && !z) {
            throw new IllegalArgumentException("Default serializers provider for " + baseClass + " is already registered: " + function1);
        }
        this.polyBase2DefaultSerializerProvider.put(baseClass, defaultSerializerProvider);
    }

    public final void registerDefaultPolymorphicDeserializer(KClass baseClass, Function1 defaultDeserializerProvider, boolean z) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(defaultDeserializerProvider, "defaultDeserializerProvider");
        Function1 function1 = (Function1) this.polyBase2DefaultDeserializerProvider.get(baseClass);
        if (function1 != null && !Intrinsics.areEqual(function1, defaultDeserializerProvider) && !z) {
            throw new IllegalArgumentException("Default deserializers provider for " + baseClass + " is already registered: " + function1);
        }
        this.polyBase2DefaultDeserializerProvider.put(baseClass, defaultDeserializerProvider);
    }

    public static /* synthetic */ void registerPolymorphicSerializer$default(SerializersModuleBuilder serializersModuleBuilder, KClass kClass, KClass kClass2, KSerializer kSerializer, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        serializersModuleBuilder.registerPolymorphicSerializer(kClass, kClass2, kSerializer, z);
    }

    public final void registerPolymorphicSerializer(KClass baseClass, KClass concreteClass, KSerializer concreteSerializer, boolean z) {
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(concreteClass, "concreteClass");
        Intrinsics.checkNotNullParameter(concreteSerializer, "concreteSerializer");
        String serialName = concreteSerializer.getDescriptor().getSerialName();
        Map map = this.polyBase2Serializers;
        Object map2 = map.get(baseClass);
        if (map2 == null) {
            map2 = new HashMap();
            map.put(baseClass, map2);
        }
        Map map3 = (Map) map2;
        KSerializer kSerializer = (KSerializer) map3.get(concreteClass);
        Map map4 = this.polyBase2NamedSerializers;
        Object map5 = map4.get(baseClass);
        if (map5 == null) {
            map5 = new HashMap();
            map4.put(baseClass, map5);
        }
        Map map6 = (Map) map5;
        if (z) {
            if (kSerializer != null) {
                map6.remove(kSerializer.getDescriptor().getSerialName());
            }
            map3.put(concreteClass, concreteSerializer);
            map6.put(serialName, concreteSerializer);
            return;
        }
        if (kSerializer != null) {
            if (!Intrinsics.areEqual(kSerializer, concreteSerializer)) {
                throw new SerializerAlreadyRegisteredException(baseClass, concreteClass);
            }
            map6.remove(kSerializer.getDescriptor().getSerialName());
        }
        KSerializer kSerializer2 = (KSerializer) map6.get(serialName);
        if (kSerializer2 != null) {
            Object obj = this.polyBase2Serializers.get(baseClass);
            Intrinsics.checkNotNull(obj);
            for (Object obj2 : MapsKt.asSequence((Map) obj)) {
                if (((Map.Entry) obj2).getValue() == kSerializer2) {
                    throw new IllegalArgumentException("Multiple polymorphic serializers for base class '" + baseClass + "' have the same serial name '" + serialName + "': '" + concreteClass + "' and '" + ((Map.Entry) obj2) + '\'');
                }
            }
            obj2 = null;
            throw new IllegalArgumentException("Multiple polymorphic serializers for base class '" + baseClass + "' have the same serial name '" + serialName + "': '" + concreteClass + "' and '" + ((Map.Entry) obj2) + '\'');
        }
        map3.put(concreteClass, concreteSerializer);
        map6.put(serialName, concreteSerializer);
    }

    public final SerializersModule build() {
        return new SerialModuleImpl(this.class2ContextualProvider, this.polyBase2Serializers, this.polyBase2DefaultSerializerProvider, this.polyBase2NamedSerializers, this.polyBase2DefaultDeserializerProvider);
    }
}
