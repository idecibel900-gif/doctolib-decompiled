package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FieldDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$MemberKind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Modality;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedSimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.NonEmptyDeserializedAnnotations;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: loaded from: classes5.dex */
public final class MemberDeserializer {
    private final AnnotationDeserializer annotationDeserializer;
    private final DeserializationContext c;

    private final int loadOldFlags(int i) {
        return (i & 63) + ((i >> 8) << 6);
    }

    public MemberDeserializer(DeserializationContext c) {
        Intrinsics.checkNotNullParameter(c, "c");
        this.c = c;
        this.annotationDeserializer = new AnnotationDeserializer(c.getComponents().getModuleDescriptor(), c.getComponents().getNotFoundClasses());
    }

    public final PropertyDescriptor loadProperty(final ProtoBuf$Property proto) {
        Annotations empty;
        Flags.FlagField flagField;
        PropertyGetterDescriptorImpl propertyGetterDescriptorImplCreateDefaultGetter;
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl;
        boolean z;
        PropertySetterDescriptorImpl propertySetterDescriptorImpl;
        KotlinType kotlinTypeType;
        Intrinsics.checkNotNullParameter(proto, "proto");
        int flags = proto.hasFlags() ? proto.getFlags() : loadOldFlags(proto.getOldFlags());
        DeclarationDescriptor containingDeclaration = this.c.getContainingDeclaration();
        Annotations annotations = getAnnotations(proto, flags, AnnotatedCallableKind.PROPERTY);
        ProtoEnumFlags protoEnumFlags = ProtoEnumFlags.INSTANCE;
        Modality modality = protoEnumFlags.modality((ProtoBuf$Modality) Flags.MODALITY.get(flags));
        DescriptorVisibility descriptorVisibility = ProtoEnumFlagsUtilsKt.descriptorVisibility(protoEnumFlags, (ProtoBuf$Visibility) Flags.VISIBILITY.get(flags));
        Boolean bool = Flags.IS_VAR.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool, "get(...)");
        boolean zBooleanValue = bool.booleanValue();
        Name name = NameResolverUtilKt.getName(this.c.getNameResolver(), proto.getName());
        CallableMemberDescriptor.Kind kindMemberKind = ProtoEnumFlagsUtilsKt.memberKind(protoEnumFlags, (ProtoBuf$MemberKind) Flags.MEMBER_KIND.get(flags));
        Boolean bool2 = Flags.IS_LATEINIT.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool2, "get(...)");
        boolean zBooleanValue2 = bool2.booleanValue();
        Boolean bool3 = Flags.IS_CONST.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool3, "get(...)");
        boolean zBooleanValue3 = bool3.booleanValue();
        Boolean bool4 = Flags.IS_EXTERNAL_PROPERTY.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool4, "get(...)");
        boolean zBooleanValue4 = bool4.booleanValue();
        Boolean bool5 = Flags.IS_DELEGATED.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool5, "get(...)");
        boolean zBooleanValue5 = bool5.booleanValue();
        Boolean bool6 = Flags.IS_EXPECT_PROPERTY.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool6, "get(...)");
        int i = flags;
        final DeserializedPropertyDescriptor deserializedPropertyDescriptor = new DeserializedPropertyDescriptor(containingDeclaration, null, annotations, modality, descriptorVisibility, zBooleanValue, name, kindMemberKind, zBooleanValue2, zBooleanValue3, zBooleanValue4, zBooleanValue5, bool6.booleanValue(), proto, this.c.getNameResolver(), this.c.getTypeTable(), this.c.getVersionRequirementTable(), this.c.getContainerSource());
        DeserializationContext deserializationContext = this.c;
        List typeParameterList = proto.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(typeParameterList, "getTypeParameterList(...)");
        DeserializationContext deserializationContextChildContext$default = DeserializationContext.childContext$default(deserializationContext, deserializedPropertyDescriptor, typeParameterList, null, null, null, null, 60, null);
        Boolean bool7 = Flags.HAS_GETTER.get(i);
        Intrinsics.checkNotNullExpressionValue(bool7, "get(...)");
        boolean zBooleanValue6 = bool7.booleanValue();
        if (zBooleanValue6 && ProtoTypeTableUtilKt.hasReceiver(proto)) {
            empty = getReceiverParameterAnnotations(proto, AnnotatedCallableKind.PROPERTY_GETTER);
        } else {
            empty = Annotations.Companion.getEMPTY();
        }
        KotlinType kotlinTypeType2 = deserializationContextChildContext$default.getTypeDeserializer().type(ProtoTypeTableUtilKt.returnType(proto, this.c.getTypeTable()));
        List ownTypeParameters = deserializationContextChildContext$default.getTypeDeserializer().getOwnTypeParameters();
        ReceiverParameterDescriptor dispatchReceiverParameter = getDispatchReceiverParameter();
        ProtoBuf$Type protoBuf$TypeReceiverType = ProtoTypeTableUtilKt.receiverType(proto, this.c.getTypeTable());
        ReceiverParameterDescriptor receiverParameterDescriptorCreateExtensionReceiverParameterForCallable = (protoBuf$TypeReceiverType == null || (kotlinTypeType = deserializationContextChildContext$default.getTypeDeserializer().type(protoBuf$TypeReceiverType)) == null) ? null : DescriptorFactory.createExtensionReceiverParameterForCallable(deserializedPropertyDescriptor, kotlinTypeType, empty);
        List listContextReceiverTypes = ProtoTypeTableUtilKt.contextReceiverTypes(proto, this.c.getTypeTable());
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listContextReceiverTypes, 10));
        int i2 = 0;
        for (Object obj : listContextReceiverTypes) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(toContextReceiver((ProtoBuf$Type) obj, deserializationContextChildContext$default, deserializedPropertyDescriptor, i2));
            i2 = i3;
        }
        deserializedPropertyDescriptor.setType(kotlinTypeType2, ownTypeParameters, dispatchReceiverParameter, receiverParameterDescriptorCreateExtensionReceiverParameterForCallable, arrayList);
        Boolean bool8 = Flags.HAS_ANNOTATIONS.get(i);
        Intrinsics.checkNotNullExpressionValue(bool8, "get(...)");
        boolean zBooleanValue7 = bool8.booleanValue();
        Flags.FlagField flagField2 = Flags.VISIBILITY;
        ProtoBuf$Visibility protoBuf$Visibility = (ProtoBuf$Visibility) flagField2.get(i);
        Flags.FlagField flagField3 = Flags.MODALITY;
        int accessorFlags = Flags.getAccessorFlags(zBooleanValue7, protoBuf$Visibility, (ProtoBuf$Modality) flagField3.get(i), false, false, false);
        if (zBooleanValue6) {
            int getterFlags = proto.hasGetterFlags() ? proto.getGetterFlags() : accessorFlags;
            Boolean bool9 = Flags.IS_NOT_DEFAULT.get(getterFlags);
            Intrinsics.checkNotNullExpressionValue(bool9, "get(...)");
            boolean zBooleanValue8 = bool9.booleanValue();
            Boolean bool10 = Flags.IS_EXTERNAL_ACCESSOR.get(getterFlags);
            Intrinsics.checkNotNullExpressionValue(bool10, "get(...)");
            boolean zBooleanValue9 = bool10.booleanValue();
            Boolean bool11 = Flags.IS_INLINE_ACCESSOR.get(getterFlags);
            Intrinsics.checkNotNullExpressionValue(bool11, "get(...)");
            boolean zBooleanValue10 = bool11.booleanValue();
            Annotations annotations2 = getAnnotations(proto, getterFlags, AnnotatedCallableKind.PROPERTY_GETTER);
            if (zBooleanValue8) {
                ProtoEnumFlags protoEnumFlags2 = ProtoEnumFlags.INSTANCE;
                flagField = flagField3;
                propertyGetterDescriptorImplCreateDefaultGetter = new PropertyGetterDescriptorImpl(deserializedPropertyDescriptor, annotations2, protoEnumFlags2.modality((ProtoBuf$Modality) flagField3.get(getterFlags)), ProtoEnumFlagsUtilsKt.descriptorVisibility(protoEnumFlags2, (ProtoBuf$Visibility) flagField2.get(getterFlags)), !zBooleanValue8, zBooleanValue9, zBooleanValue10, deserializedPropertyDescriptor.getKind(), null, SourceElement.NO_SOURCE);
            } else {
                flagField = flagField3;
                propertyGetterDescriptorImplCreateDefaultGetter = DescriptorFactory.createDefaultGetter(deserializedPropertyDescriptor, annotations2);
                Intrinsics.checkNotNull(propertyGetterDescriptorImplCreateDefaultGetter);
            }
            propertyGetterDescriptorImplCreateDefaultGetter.initialize(deserializedPropertyDescriptor.getReturnType());
        } else {
            deserializationContextChildContext$default = deserializationContextChildContext$default;
            flagField2 = flagField2;
            flagField = flagField3;
            propertyGetterDescriptorImplCreateDefaultGetter = null;
        }
        if (Flags.HAS_SETTER.get(i).booleanValue()) {
            if (proto.hasSetterFlags()) {
                accessorFlags = proto.getSetterFlags();
            }
            int i4 = accessorFlags;
            Boolean bool12 = Flags.IS_NOT_DEFAULT.get(i4);
            Intrinsics.checkNotNullExpressionValue(bool12, "get(...)");
            boolean zBooleanValue11 = bool12.booleanValue();
            Boolean bool13 = Flags.IS_EXTERNAL_ACCESSOR.get(i4);
            Intrinsics.checkNotNullExpressionValue(bool13, "get(...)");
            boolean zBooleanValue12 = bool13.booleanValue();
            Boolean bool14 = Flags.IS_INLINE_ACCESSOR.get(i4);
            Intrinsics.checkNotNullExpressionValue(bool14, "get(...)");
            boolean zBooleanValue13 = bool14.booleanValue();
            AnnotatedCallableKind annotatedCallableKind = AnnotatedCallableKind.PROPERTY_SETTER;
            Annotations annotations3 = getAnnotations(proto, i4, annotatedCallableKind);
            if (zBooleanValue11) {
                ProtoEnumFlags protoEnumFlags3 = ProtoEnumFlags.INSTANCE;
                propertyGetterDescriptorImpl = propertyGetterDescriptorImplCreateDefaultGetter;
                z = true;
                PropertySetterDescriptorImpl propertySetterDescriptorImpl2 = new PropertySetterDescriptorImpl(deserializedPropertyDescriptor, annotations3, protoEnumFlags3.modality((ProtoBuf$Modality) flagField.get(i4)), ProtoEnumFlagsUtilsKt.descriptorVisibility(protoEnumFlags3, (ProtoBuf$Visibility) flagField2.get(i4)), !zBooleanValue11, zBooleanValue12, zBooleanValue13, deserializedPropertyDescriptor.getKind(), null, SourceElement.NO_SOURCE);
                propertySetterDescriptorImpl = propertySetterDescriptorImpl2;
                propertySetterDescriptorImpl.initialize((ValueParameterDescriptor) CollectionsKt.single(DeserializationContext.childContext$default(deserializationContextChildContext$default, propertySetterDescriptorImpl2, CollectionsKt.emptyList(), null, null, null, null, 60, null).getMemberDeserializer().valueParameters(CollectionsKt.listOf(proto.getSetterValueParameter()), proto, annotatedCallableKind)));
            } else {
                propertyGetterDescriptorImpl = propertyGetterDescriptorImplCreateDefaultGetter;
                z = true;
                PropertySetterDescriptorImpl propertySetterDescriptorImplCreateDefaultSetter = DescriptorFactory.createDefaultSetter(deserializedPropertyDescriptor, annotations3, Annotations.Companion.getEMPTY());
                Intrinsics.checkNotNull(propertySetterDescriptorImplCreateDefaultSetter);
                propertySetterDescriptorImpl = propertySetterDescriptorImplCreateDefaultSetter;
            }
        } else {
            propertyGetterDescriptorImpl = propertyGetterDescriptorImplCreateDefaultGetter;
            z = true;
            propertySetterDescriptorImpl = null;
        }
        if (Flags.HAS_CONSTANT.get(i).booleanValue()) {
            deserializedPropertyDescriptor.setCompileTimeInitializerFactory(new Function0(this, proto, deserializedPropertyDescriptor) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$$Lambda$0
                private final MemberDeserializer arg$0;
                private final ProtoBuf$Property arg$1;
                private final DeserializedPropertyDescriptor arg$2;

                {
                    this.arg$0 = this;
                    this.arg$1 = proto;
                    this.arg$2 = deserializedPropertyDescriptor;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    return MemberDeserializer.loadProperty$lambda$3(this.arg$0, this.arg$1, this.arg$2);
                }
            });
        }
        DeclarationDescriptor containingDeclaration2 = this.c.getContainingDeclaration();
        ClassDescriptor classDescriptor = containingDeclaration2 instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration2 : null;
        if ((classDescriptor != null ? classDescriptor.getKind() : null) == ClassKind.ANNOTATION_CLASS) {
            deserializedPropertyDescriptor.setCompileTimeInitializerFactory(new Function0(this, proto, deserializedPropertyDescriptor) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$$Lambda$1
                private final MemberDeserializer arg$0;
                private final ProtoBuf$Property arg$1;
                private final DeserializedPropertyDescriptor arg$2;

                {
                    this.arg$0 = this;
                    this.arg$1 = proto;
                    this.arg$2 = deserializedPropertyDescriptor;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    return MemberDeserializer.loadProperty$lambda$5(this.arg$0, this.arg$1, this.arg$2);
                }
            });
        }
        deserializedPropertyDescriptor.initialize(propertyGetterDescriptorImpl, propertySetterDescriptorImpl, new FieldDescriptorImpl(getPropertyFieldAnnotations(proto, false), deserializedPropertyDescriptor), new FieldDescriptorImpl(getPropertyFieldAnnotations(proto, z), deserializedPropertyDescriptor));
        return deserializedPropertyDescriptor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NullableLazyValue loadProperty$lambda$3(final MemberDeserializer memberDeserializer, final ProtoBuf$Property protoBuf$Property, final DeserializedPropertyDescriptor deserializedPropertyDescriptor) {
        return memberDeserializer.c.getStorageManager().createNullableLazyValue(new Function0(memberDeserializer, protoBuf$Property, deserializedPropertyDescriptor) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$$Lambda$6
            private final MemberDeserializer arg$0;
            private final ProtoBuf$Property arg$1;
            private final DeserializedPropertyDescriptor arg$2;

            {
                this.arg$0 = memberDeserializer;
                this.arg$1 = protoBuf$Property;
                this.arg$2 = deserializedPropertyDescriptor;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return MemberDeserializer.loadProperty$lambda$3$lambda$2(this.arg$0, this.arg$1, this.arg$2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConstantValue loadProperty$lambda$3$lambda$2(MemberDeserializer memberDeserializer, ProtoBuf$Property protoBuf$Property, DeserializedPropertyDescriptor deserializedPropertyDescriptor) {
        ProtoContainer protoContainerAsProtoContainer = memberDeserializer.asProtoContainer(memberDeserializer.c.getContainingDeclaration());
        Intrinsics.checkNotNull(protoContainerAsProtoContainer);
        AnnotationAndConstantLoader annotationAndConstantLoader = memberDeserializer.c.getComponents().getAnnotationAndConstantLoader();
        KotlinType returnType = deserializedPropertyDescriptor.getReturnType();
        Intrinsics.checkNotNullExpressionValue(returnType, "getReturnType(...)");
        return (ConstantValue) annotationAndConstantLoader.loadPropertyConstant(protoContainerAsProtoContainer, protoBuf$Property, returnType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NullableLazyValue loadProperty$lambda$5(final MemberDeserializer memberDeserializer, final ProtoBuf$Property protoBuf$Property, final DeserializedPropertyDescriptor deserializedPropertyDescriptor) {
        return memberDeserializer.c.getStorageManager().createNullableLazyValue(new Function0(memberDeserializer, protoBuf$Property, deserializedPropertyDescriptor) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$$Lambda$7
            private final MemberDeserializer arg$0;
            private final ProtoBuf$Property arg$1;
            private final DeserializedPropertyDescriptor arg$2;

            {
                this.arg$0 = memberDeserializer;
                this.arg$1 = protoBuf$Property;
                this.arg$2 = deserializedPropertyDescriptor;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return MemberDeserializer.loadProperty$lambda$5$lambda$4(this.arg$0, this.arg$1, this.arg$2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConstantValue loadProperty$lambda$5$lambda$4(MemberDeserializer memberDeserializer, ProtoBuf$Property protoBuf$Property, DeserializedPropertyDescriptor deserializedPropertyDescriptor) {
        ProtoContainer protoContainerAsProtoContainer = memberDeserializer.asProtoContainer(memberDeserializer.c.getContainingDeclaration());
        Intrinsics.checkNotNull(protoContainerAsProtoContainer);
        AnnotationAndConstantLoader annotationAndConstantLoader = memberDeserializer.c.getComponents().getAnnotationAndConstantLoader();
        KotlinType returnType = deserializedPropertyDescriptor.getReturnType();
        Intrinsics.checkNotNullExpressionValue(returnType, "getReturnType(...)");
        return (ConstantValue) annotationAndConstantLoader.loadAnnotationDefaultValue(protoContainerAsProtoContainer, protoBuf$Property, returnType);
    }

    private final void initializeWithCoroutinesExperimentalityStatus(DeserializedSimpleFunctionDescriptor deserializedSimpleFunctionDescriptor, ReceiverParameterDescriptor receiverParameterDescriptor, ReceiverParameterDescriptor receiverParameterDescriptor2, List list, List list2, List list3, KotlinType kotlinType, Modality modality, DescriptorVisibility descriptorVisibility, Map map) {
        deserializedSimpleFunctionDescriptor.initialize(receiverParameterDescriptor, receiverParameterDescriptor2, list, list2, list3, kotlinType, modality, descriptorVisibility, map);
    }

    public final SimpleFunctionDescriptor loadFunction(ProtoBuf$Function proto) {
        Annotations empty;
        VersionRequirementTable versionRequirementTable;
        KotlinType kotlinTypeType;
        Intrinsics.checkNotNullParameter(proto, "proto");
        int flags = proto.hasFlags() ? proto.getFlags() : loadOldFlags(proto.getOldFlags());
        AnnotatedCallableKind annotatedCallableKind = AnnotatedCallableKind.FUNCTION;
        Annotations annotations = getAnnotations(proto, flags, annotatedCallableKind);
        if (ProtoTypeTableUtilKt.hasReceiver(proto)) {
            empty = getReceiverParameterAnnotations(proto, annotatedCallableKind);
        } else {
            empty = Annotations.Companion.getEMPTY();
        }
        if (Intrinsics.areEqual(DescriptorUtilsKt.getFqNameSafe(this.c.getContainingDeclaration()).child(NameResolverUtilKt.getName(this.c.getNameResolver(), proto.getName())), SuspendFunctionTypeUtilKt.KOTLIN_SUSPEND_BUILT_IN_FUNCTION_FQ_NAME)) {
            versionRequirementTable = VersionRequirementTable.Companion.getEMPTY();
        } else {
            versionRequirementTable = this.c.getVersionRequirementTable();
        }
        Annotations annotations2 = empty;
        DeserializedSimpleFunctionDescriptor deserializedSimpleFunctionDescriptor = new DeserializedSimpleFunctionDescriptor(this.c.getContainingDeclaration(), null, annotations, NameResolverUtilKt.getName(this.c.getNameResolver(), proto.getName()), ProtoEnumFlagsUtilsKt.memberKind(ProtoEnumFlags.INSTANCE, (ProtoBuf$MemberKind) Flags.MEMBER_KIND.get(flags)), proto, this.c.getNameResolver(), this.c.getTypeTable(), versionRequirementTable, this.c.getContainerSource(), null, IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET, null);
        DeserializationContext deserializationContext = this.c;
        List typeParameterList = proto.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(typeParameterList, "getTypeParameterList(...)");
        DeserializationContext deserializationContextChildContext$default = DeserializationContext.childContext$default(deserializationContext, deserializedSimpleFunctionDescriptor, typeParameterList, null, null, null, null, 60, null);
        ProtoBuf$Type protoBuf$TypeReceiverType = ProtoTypeTableUtilKt.receiverType(proto, this.c.getTypeTable());
        ReceiverParameterDescriptor receiverParameterDescriptorCreateExtensionReceiverParameterForCallable = (protoBuf$TypeReceiverType == null || (kotlinTypeType = deserializationContextChildContext$default.getTypeDeserializer().type(protoBuf$TypeReceiverType)) == null) ? null : DescriptorFactory.createExtensionReceiverParameterForCallable(deserializedSimpleFunctionDescriptor, kotlinTypeType, annotations2);
        ReceiverParameterDescriptor dispatchReceiverParameter = getDispatchReceiverParameter();
        List listContextReceiverTypes = ProtoTypeTableUtilKt.contextReceiverTypes(proto, this.c.getTypeTable());
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object obj : listContextReceiverTypes) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ReceiverParameterDescriptor contextReceiver = toContextReceiver((ProtoBuf$Type) obj, deserializationContextChildContext$default, deserializedSimpleFunctionDescriptor, i);
            if (contextReceiver != null) {
                arrayList.add(contextReceiver);
            }
            i = i2;
        }
        List ownTypeParameters = deserializationContextChildContext$default.getTypeDeserializer().getOwnTypeParameters();
        MemberDeserializer memberDeserializer = deserializationContextChildContext$default.getMemberDeserializer();
        List valueParameterList = proto.getValueParameterList();
        Intrinsics.checkNotNullExpressionValue(valueParameterList, "getValueParameterList(...)");
        List listValueParameters = memberDeserializer.valueParameters(valueParameterList, proto, AnnotatedCallableKind.FUNCTION);
        KotlinType kotlinTypeType2 = deserializationContextChildContext$default.getTypeDeserializer().type(ProtoTypeTableUtilKt.returnType(proto, this.c.getTypeTable()));
        ProtoEnumFlags protoEnumFlags = ProtoEnumFlags.INSTANCE;
        initializeWithCoroutinesExperimentalityStatus(deserializedSimpleFunctionDescriptor, receiverParameterDescriptorCreateExtensionReceiverParameterForCallable, dispatchReceiverParameter, arrayList, ownTypeParameters, listValueParameters, kotlinTypeType2, protoEnumFlags.modality((ProtoBuf$Modality) Flags.MODALITY.get(flags)), ProtoEnumFlagsUtilsKt.descriptorVisibility(protoEnumFlags, (ProtoBuf$Visibility) Flags.VISIBILITY.get(flags)), MapsKt.emptyMap());
        Boolean bool = Flags.IS_OPERATOR.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool, "get(...)");
        deserializedSimpleFunctionDescriptor.setOperator(bool.booleanValue());
        Boolean bool2 = Flags.IS_INFIX.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool2, "get(...)");
        deserializedSimpleFunctionDescriptor.setInfix(bool2.booleanValue());
        Boolean bool3 = Flags.IS_EXTERNAL_FUNCTION.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool3, "get(...)");
        deserializedSimpleFunctionDescriptor.setExternal(bool3.booleanValue());
        Boolean bool4 = Flags.IS_INLINE.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool4, "get(...)");
        deserializedSimpleFunctionDescriptor.setInline(bool4.booleanValue());
        Boolean bool5 = Flags.IS_TAILREC.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool5, "get(...)");
        deserializedSimpleFunctionDescriptor.setTailrec(bool5.booleanValue());
        Boolean bool6 = Flags.IS_SUSPEND.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool6, "get(...)");
        deserializedSimpleFunctionDescriptor.setSuspend(bool6.booleanValue());
        Boolean bool7 = Flags.IS_EXPECT_FUNCTION.get(flags);
        Intrinsics.checkNotNullExpressionValue(bool7, "get(...)");
        deserializedSimpleFunctionDescriptor.setExpect(bool7.booleanValue());
        deserializedSimpleFunctionDescriptor.setHasStableParameterNames(!Flags.IS_FUNCTION_WITH_NON_STABLE_PARAMETER_NAMES.get(flags).booleanValue());
        Pair pairDeserializeContractFromFunction = this.c.getComponents().getContractDeserializer().deserializeContractFromFunction(proto, deserializedSimpleFunctionDescriptor, this.c.getTypeTable(), deserializationContextChildContext$default.getTypeDeserializer());
        if (pairDeserializeContractFromFunction != null) {
            deserializedSimpleFunctionDescriptor.putInUserDataMap((CallableDescriptor.UserDataKey) pairDeserializeContractFromFunction.getFirst(), pairDeserializeContractFromFunction.getSecond());
        }
        return deserializedSimpleFunctionDescriptor;
    }

    public final TypeAliasDescriptor loadTypeAlias(ProtoBuf$TypeAlias proto) {
        Intrinsics.checkNotNullParameter(proto, "proto");
        Annotations.Companion companion = Annotations.Companion;
        List annotationList = proto.getAnnotationList();
        Intrinsics.checkNotNullExpressionValue(annotationList, "getAnnotationList(...)");
        List<ProtoBuf$Annotation> list = annotationList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (ProtoBuf$Annotation protoBuf$Annotation : list) {
            AnnotationDeserializer annotationDeserializer = this.annotationDeserializer;
            Intrinsics.checkNotNull(protoBuf$Annotation);
            arrayList.add(annotationDeserializer.deserializeAnnotation(protoBuf$Annotation, this.c.getNameResolver()));
        }
        DeserializedTypeAliasDescriptor deserializedTypeAliasDescriptor = new DeserializedTypeAliasDescriptor(this.c.getStorageManager(), this.c.getContainingDeclaration(), companion.create(arrayList), NameResolverUtilKt.getName(this.c.getNameResolver(), proto.getName()), ProtoEnumFlagsUtilsKt.descriptorVisibility(ProtoEnumFlags.INSTANCE, (ProtoBuf$Visibility) Flags.VISIBILITY.get(proto.getFlags())), proto, this.c.getNameResolver(), this.c.getTypeTable(), this.c.getVersionRequirementTable(), this.c.getContainerSource());
        DeserializationContext deserializationContext = this.c;
        List typeParameterList = proto.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(typeParameterList, "getTypeParameterList(...)");
        DeserializationContext deserializationContextChildContext$default = DeserializationContext.childContext$default(deserializationContext, deserializedTypeAliasDescriptor, typeParameterList, null, null, null, null, 60, null);
        deserializedTypeAliasDescriptor.initialize(deserializationContextChildContext$default.getTypeDeserializer().getOwnTypeParameters(), deserializationContextChildContext$default.getTypeDeserializer().simpleType(ProtoTypeTableUtilKt.underlyingType(proto, this.c.getTypeTable()), false), deserializationContextChildContext$default.getTypeDeserializer().simpleType(ProtoTypeTableUtilKt.expandedType(proto, this.c.getTypeTable()), false));
        return deserializedTypeAliasDescriptor;
    }

    private final ReceiverParameterDescriptor getDispatchReceiverParameter() {
        DeclarationDescriptor containingDeclaration = this.c.getContainingDeclaration();
        ClassDescriptor classDescriptor = containingDeclaration instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration : null;
        if (classDescriptor != null) {
            return classDescriptor.getThisAsReceiverParameter();
        }
        return null;
    }

    public final ClassConstructorDescriptor loadConstructor(ProtoBuf$Constructor proto, boolean z) {
        Intrinsics.checkNotNullParameter(proto, "proto");
        DeclarationDescriptor containingDeclaration = this.c.getContainingDeclaration();
        Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        ClassDescriptor classDescriptor = (ClassDescriptor) containingDeclaration;
        int flags = proto.getFlags();
        AnnotatedCallableKind annotatedCallableKind = AnnotatedCallableKind.FUNCTION;
        DeserializedClassConstructorDescriptor deserializedClassConstructorDescriptor = new DeserializedClassConstructorDescriptor(classDescriptor, null, getAnnotations(proto, flags, annotatedCallableKind), z, CallableMemberDescriptor.Kind.DECLARATION, proto, this.c.getNameResolver(), this.c.getTypeTable(), this.c.getVersionRequirementTable(), this.c.getContainerSource(), null, IntBufferBatchMountItem.INSTRUCTION_UPDATE_OVERFLOW_INSET, null);
        MemberDeserializer memberDeserializer = DeserializationContext.childContext$default(this.c, deserializedClassConstructorDescriptor, CollectionsKt.emptyList(), null, null, null, null, 60, null).getMemberDeserializer();
        List valueParameterList = proto.getValueParameterList();
        Intrinsics.checkNotNullExpressionValue(valueParameterList, "getValueParameterList(...)");
        deserializedClassConstructorDescriptor.initialize(memberDeserializer.valueParameters(valueParameterList, proto, annotatedCallableKind), ProtoEnumFlagsUtilsKt.descriptorVisibility(ProtoEnumFlags.INSTANCE, (ProtoBuf$Visibility) Flags.VISIBILITY.get(proto.getFlags())));
        deserializedClassConstructorDescriptor.setReturnType(classDescriptor.getDefaultType());
        deserializedClassConstructorDescriptor.setExpect(classDescriptor.isExpect());
        deserializedClassConstructorDescriptor.setHasStableParameterNames(!Flags.IS_CONSTRUCTOR_WITH_NON_STABLE_PARAMETER_NAMES.get(proto.getFlags()).booleanValue());
        return deserializedClassConstructorDescriptor;
    }

    private final Annotations getAnnotations(final MessageLite messageLite, int i, final AnnotatedCallableKind annotatedCallableKind) {
        if (!Flags.HAS_ANNOTATIONS.get(i).booleanValue()) {
            return Annotations.Companion.getEMPTY();
        }
        return new NonEmptyDeserializedAnnotations(this.c.getStorageManager(), new Function0(this, messageLite, annotatedCallableKind) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$$Lambda$2
            private final MemberDeserializer arg$0;
            private final MessageLite arg$1;
            private final AnnotatedCallableKind arg$2;

            {
                this.arg$0 = this;
                this.arg$1 = messageLite;
                this.arg$2 = annotatedCallableKind;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return MemberDeserializer.getAnnotations$lambda$11(this.arg$0, this.arg$1, this.arg$2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getAnnotations$lambda$11(MemberDeserializer memberDeserializer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        ProtoContainer protoContainerAsProtoContainer = memberDeserializer.asProtoContainer(memberDeserializer.c.getContainingDeclaration());
        List list = protoContainerAsProtoContainer != null ? CollectionsKt.toList(memberDeserializer.c.getComponents().getAnnotationAndConstantLoader().loadCallableAnnotations(protoContainerAsProtoContainer, messageLite, annotatedCallableKind)) : null;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    private final Annotations getPropertyFieldAnnotations(final ProtoBuf$Property protoBuf$Property, final boolean z) {
        if (!Flags.HAS_ANNOTATIONS.get(protoBuf$Property.getFlags()).booleanValue()) {
            return Annotations.Companion.getEMPTY();
        }
        return new NonEmptyDeserializedAnnotations(this.c.getStorageManager(), new Function0(this, z, protoBuf$Property) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$$Lambda$3
            private final MemberDeserializer arg$0;
            private final boolean arg$1;
            private final ProtoBuf$Property arg$2;

            {
                this.arg$0 = this;
                this.arg$1 = z;
                this.arg$2 = protoBuf$Property;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return MemberDeserializer.getPropertyFieldAnnotations$lambda$13(this.arg$0, this.arg$1, this.arg$2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getPropertyFieldAnnotations$lambda$13(MemberDeserializer memberDeserializer, boolean z, ProtoBuf$Property protoBuf$Property) {
        List list;
        ProtoContainer protoContainerAsProtoContainer = memberDeserializer.asProtoContainer(memberDeserializer.c.getContainingDeclaration());
        if (protoContainerAsProtoContainer == null) {
            list = null;
        } else if (z) {
            list = CollectionsKt.toList(memberDeserializer.c.getComponents().getAnnotationAndConstantLoader().loadPropertyDelegateFieldAnnotations(protoContainerAsProtoContainer, protoBuf$Property));
        } else {
            list = CollectionsKt.toList(memberDeserializer.c.getComponents().getAnnotationAndConstantLoader().loadPropertyBackingFieldAnnotations(protoContainerAsProtoContainer, protoBuf$Property));
        }
        return list == null ? CollectionsKt.emptyList() : list;
    }

    private final Annotations getReceiverParameterAnnotations(final MessageLite messageLite, final AnnotatedCallableKind annotatedCallableKind) {
        return new DeserializedAnnotations(this.c.getStorageManager(), new Function0(this, messageLite, annotatedCallableKind) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$$Lambda$4
            private final MemberDeserializer arg$0;
            private final MessageLite arg$1;
            private final AnnotatedCallableKind arg$2;

            {
                this.arg$0 = this;
                this.arg$1 = messageLite;
                this.arg$2 = annotatedCallableKind;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return MemberDeserializer.getReceiverParameterAnnotations$lambda$15(this.arg$0, this.arg$1, this.arg$2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getReceiverParameterAnnotations$lambda$15(MemberDeserializer memberDeserializer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        ProtoContainer protoContainerAsProtoContainer = memberDeserializer.asProtoContainer(memberDeserializer.c.getContainingDeclaration());
        List listLoadExtensionReceiverParameterAnnotations = protoContainerAsProtoContainer != null ? memberDeserializer.c.getComponents().getAnnotationAndConstantLoader().loadExtensionReceiverParameterAnnotations(protoContainerAsProtoContainer, messageLite, annotatedCallableKind) : null;
        return listLoadExtensionReceiverParameterAnnotations == null ? CollectionsKt.emptyList() : listLoadExtensionReceiverParameterAnnotations;
    }

    private final List valueParameters(List list, final MessageLite messageLite, final AnnotatedCallableKind annotatedCallableKind) {
        Annotations empty;
        DeclarationDescriptor containingDeclaration = this.c.getContainingDeclaration();
        Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
        CallableDescriptor callableDescriptor = (CallableDescriptor) containingDeclaration;
        DeclarationDescriptor containingDeclaration2 = callableDescriptor.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(containingDeclaration2, "getContainingDeclaration(...)");
        final ProtoContainer protoContainerAsProtoContainer = asProtoContainer(containingDeclaration2);
        List list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        final int i = 0;
        for (Object obj : list2) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            final ProtoBuf$ValueParameter protoBuf$ValueParameter = (ProtoBuf$ValueParameter) obj;
            int flags = protoBuf$ValueParameter.hasFlags() ? protoBuf$ValueParameter.getFlags() : 0;
            if (protoContainerAsProtoContainer != null && Flags.HAS_ANNOTATIONS.get(flags).booleanValue()) {
                empty = new NonEmptyDeserializedAnnotations(this.c.getStorageManager(), new Function0(this, protoContainerAsProtoContainer, messageLite, annotatedCallableKind, i, protoBuf$ValueParameter) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer$$Lambda$5
                    private final MemberDeserializer arg$0;
                    private final ProtoContainer arg$1;
                    private final MessageLite arg$2;
                    private final AnnotatedCallableKind arg$3;
                    private final int arg$4;
                    private final ProtoBuf$ValueParameter arg$5;

                    {
                        this.arg$0 = this;
                        this.arg$1 = protoContainerAsProtoContainer;
                        this.arg$2 = messageLite;
                        this.arg$3 = annotatedCallableKind;
                        this.arg$4 = i;
                        this.arg$5 = protoBuf$ValueParameter;
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public Object invoke() {
                        return MemberDeserializer.valueParameters$lambda$18$lambda$16(this.arg$0, this.arg$1, this.arg$2, this.arg$3, this.arg$4, this.arg$5);
                    }
                });
            } else {
                empty = Annotations.Companion.getEMPTY();
            }
            Name name = NameResolverUtilKt.getName(this.c.getNameResolver(), protoBuf$ValueParameter.getName());
            KotlinType kotlinTypeType = this.c.getTypeDeserializer().type(ProtoTypeTableUtilKt.type(protoBuf$ValueParameter, this.c.getTypeTable()));
            Boolean bool = Flags.DECLARES_DEFAULT_VALUE.get(flags);
            Intrinsics.checkNotNullExpressionValue(bool, "get(...)");
            boolean zBooleanValue = bool.booleanValue();
            Boolean bool2 = Flags.IS_CROSSINLINE.get(flags);
            Intrinsics.checkNotNullExpressionValue(bool2, "get(...)");
            boolean zBooleanValue2 = bool2.booleanValue();
            Boolean bool3 = Flags.IS_NOINLINE.get(flags);
            Intrinsics.checkNotNullExpressionValue(bool3, "get(...)");
            boolean zBooleanValue3 = bool3.booleanValue();
            ProtoBuf$Type protoBuf$TypeVarargElementType = ProtoTypeTableUtilKt.varargElementType(protoBuf$ValueParameter, this.c.getTypeTable());
            KotlinType kotlinTypeType2 = protoBuf$TypeVarargElementType != null ? this.c.getTypeDeserializer().type(protoBuf$TypeVarargElementType) : null;
            SourceElement NO_SOURCE = SourceElement.NO_SOURCE;
            Intrinsics.checkNotNullExpressionValue(NO_SOURCE, "NO_SOURCE");
            CallableDescriptor callableDescriptor2 = callableDescriptor;
            arrayList.add(new ValueParameterDescriptorImpl(callableDescriptor2, null, i, empty, name, kotlinTypeType, zBooleanValue, zBooleanValue2, zBooleanValue3, kotlinTypeType2, NO_SOURCE));
            callableDescriptor = callableDescriptor2;
            i = i2;
        }
        return CollectionsKt.toList(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List valueParameters$lambda$18$lambda$16(MemberDeserializer memberDeserializer, ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind, int i, ProtoBuf$ValueParameter protoBuf$ValueParameter) {
        return CollectionsKt.toList(memberDeserializer.c.getComponents().getAnnotationAndConstantLoader().loadValueParameterAnnotations(protoContainer, messageLite, annotatedCallableKind, i, protoBuf$ValueParameter));
    }

    private final ProtoContainer asProtoContainer(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor instanceof PackageFragmentDescriptor) {
            return new ProtoContainer.Package(((PackageFragmentDescriptor) declarationDescriptor).getFqName(), this.c.getNameResolver(), this.c.getTypeTable(), this.c.getContainerSource());
        }
        if (declarationDescriptor instanceof DeserializedClassDescriptor) {
            return ((DeserializedClassDescriptor) declarationDescriptor).getThisAsProtoContainer$deserialization();
        }
        return null;
    }

    private final ReceiverParameterDescriptor toContextReceiver(ProtoBuf$Type protoBuf$Type, DeserializationContext deserializationContext, CallableDescriptor callableDescriptor, int i) {
        return DescriptorFactory.createContextReceiverParameterForCallable(callableDescriptor, deserializationContext.getTypeDeserializer().type(protoBuf$Type), null, Annotations.Companion.getEMPTY(), i);
    }
}
