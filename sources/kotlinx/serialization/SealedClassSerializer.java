package kotlinx.serialization;

import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.Grouping;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KClass;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;

/* JADX INFO: loaded from: classes5.dex */
public final class SealedClassSerializer extends AbstractPolymorphicSerializer {
    private List _annotations;
    private final KClass baseClass;
    private final Map class2Serializer;
    private final Lazy descriptor$delegate;
    private final Map serialName2Serializer;

    @Override // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    public KClass getBaseClass() {
        return this.baseClass;
    }

    public SealedClassSerializer(final String serialName, KClass baseClass, KClass[] subclasses, KSerializer[] subclassSerializers) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(subclasses, "subclasses");
        Intrinsics.checkNotNullParameter(subclassSerializers, "subclassSerializers");
        this.baseClass = baseClass;
        this._annotations = CollectionsKt.emptyList();
        this.descriptor$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kotlinx.serialization.SealedClassSerializer$descriptor$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final SerialDescriptor invoke() {
                final SealedClassSerializer sealedClassSerializer = this;
                return SerialDescriptorsKt.buildSerialDescriptor(serialName, PolymorphicKind.SEALED.INSTANCE, new SerialDescriptor[0], new Function1() { // from class: kotlinx.serialization.SealedClassSerializer$descriptor$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((ClassSerialDescriptorBuilder) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ClassSerialDescriptorBuilder buildSerialDescriptor) {
                        Intrinsics.checkNotNullParameter(buildSerialDescriptor, "$this$buildSerialDescriptor");
                        ClassSerialDescriptorBuilder.element$default(buildSerialDescriptor, "type", BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE).getDescriptor(), null, false, 12, null);
                        final SealedClassSerializer sealedClassSerializer2 = sealedClassSerializer;
                        ClassSerialDescriptorBuilder.element$default(buildSerialDescriptor, "value", SerialDescriptorsKt.buildSerialDescriptor("kotlinx.serialization.Sealed<" + sealedClassSerializer.getBaseClass().getSimpleName() + '>', SerialKind.CONTEXTUAL.INSTANCE, new SerialDescriptor[0], new Function1() { // from class: kotlinx.serialization.SealedClassSerializer$descriptor$2$1$elementDescriptor$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ClassSerialDescriptorBuilder) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ClassSerialDescriptorBuilder buildSerialDescriptor2) {
                                Intrinsics.checkNotNullParameter(buildSerialDescriptor2, "$this$buildSerialDescriptor");
                                for (Map.Entry entry : sealedClassSerializer2.serialName2Serializer.entrySet()) {
                                    ClassSerialDescriptorBuilder.element$default(buildSerialDescriptor2, (String) entry.getKey(), ((KSerializer) entry.getValue()).getDescriptor(), null, false, 12, null);
                                }
                            }
                        }), null, false, 12, null);
                        buildSerialDescriptor.setAnnotations(sealedClassSerializer._annotations);
                    }
                });
            }
        });
        if (subclasses.length != subclassSerializers.length) {
            throw new IllegalArgumentException("All subclasses of sealed class " + getBaseClass().getSimpleName() + " should be marked @Serializable");
        }
        Map map = MapsKt.toMap(ArraysKt.zip(subclasses, subclassSerializers));
        this.class2Serializer = map;
        final Set setEntrySet = map.entrySet();
        Grouping grouping = new Grouping() { // from class: kotlinx.serialization.SealedClassSerializer$special$$inlined$groupingBy$1
            @Override // kotlin.collections.Grouping
            public Iterator sourceIterator() {
                return setEntrySet.iterator();
            }

            @Override // kotlin.collections.Grouping
            public Object keyOf(Object obj) {
                return ((KSerializer) ((Map.Entry) obj).getValue()).getDescriptor().getSerialName();
            }
        };
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator itSourceIterator = grouping.sourceIterator();
        while (itSourceIterator.hasNext()) {
            Object next = itSourceIterator.next();
            Object objKeyOf = grouping.keyOf(next);
            Object obj = linkedHashMap.get(objKeyOf);
            if (obj == null) {
                linkedHashMap.containsKey(objKeyOf);
            }
            Map.Entry entry = (Map.Entry) next;
            Map.Entry entry2 = (Map.Entry) obj;
            String str = (String) objKeyOf;
            if (entry2 != null) {
                throw new IllegalStateException(("Multiple sealed subclasses of '" + getBaseClass() + "' have the same serial name '" + str + "': '" + entry2.getKey() + "', '" + entry.getKey() + '\'').toString());
            }
            linkedHashMap.put(objKeyOf, entry);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry3 : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry3.getKey(), (KSerializer) ((Map.Entry) entry3.getValue()).getValue());
        }
        this.serialName2Serializer = linkedHashMap2;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SealedClassSerializer(String serialName, KClass baseClass, KClass[] subclasses, KSerializer[] subclassSerializers, Annotation[] classAnnotations) {
        this(serialName, baseClass, subclasses, subclassSerializers);
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(subclasses, "subclasses");
        Intrinsics.checkNotNullParameter(subclassSerializers, "subclassSerializers");
        Intrinsics.checkNotNullParameter(classAnnotations, "classAnnotations");
        this._annotations = ArraysKt.asList(classAnnotations);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return (SerialDescriptor) this.descriptor$delegate.getValue();
    }

    @Override // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    public DeserializationStrategy findPolymorphicSerializerOrNull(CompositeDecoder decoder, String str) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        KSerializer kSerializer = (KSerializer) this.serialName2Serializer.get(str);
        return kSerializer != null ? kSerializer : super.findPolymorphicSerializerOrNull(decoder, str);
    }

    @Override // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    public SerializationStrategy findPolymorphicSerializerOrNull(Encoder encoder, Object value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerializationStrategy serializationStrategyFindPolymorphicSerializerOrNull = (KSerializer) this.class2Serializer.get(Reflection.getOrCreateKotlinClass(value.getClass()));
        if (serializationStrategyFindPolymorphicSerializerOrNull == null) {
            serializationStrategyFindPolymorphicSerializerOrNull = super.findPolymorphicSerializerOrNull(encoder, value);
        }
        if (serializationStrategyFindPolymorphicSerializerOrNull != null) {
            return serializationStrategyFindPolymorphicSerializerOrNull;
        }
        return null;
    }
}
