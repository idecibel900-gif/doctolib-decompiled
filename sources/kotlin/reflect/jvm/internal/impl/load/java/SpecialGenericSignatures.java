package kotlin.reflect.jvm.internal.impl.load.java;

import com.amazon.a.a.o.b;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* JADX INFO: loaded from: classes5.dex */
public abstract class SpecialGenericSignatures {
    public static final Companion Companion = new Companion(null);
    private static final List ERASED_COLLECTION_PARAMETER_NAMES;
    private static final List ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES;
    private static final List ERASED_COLLECTION_PARAMETER_SIGNATURES;
    private static final Set ERASED_VALUE_PARAMETERS_SHORT_NAMES;
    private static final Set ERASED_VALUE_PARAMETERS_SIGNATURES;
    private static final Map GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP;
    private static final Map JVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP;
    private static final Set JVM_SIGNATURES_FOR_RENAMED_BUILT_INS;
    private static final Map NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP;
    private static final Set ORIGINAL_SHORT_NAMES;
    private static final Companion.NameAndSignature REMOVE_AT_NAME_AND_SIGNATURE;
    private static final Map SIGNATURE_TO_DEFAULT_VALUES_MAP;
    private static final Map SIGNATURE_TO_JVM_REPRESENTATION_NAME;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class TypeSafeBarrierDescription {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ TypeSafeBarrierDescription[] $VALUES;
        private final Object defaultValue;
        public static final TypeSafeBarrierDescription NULL = new TypeSafeBarrierDescription("NULL", 0, null);
        public static final TypeSafeBarrierDescription INDEX = new TypeSafeBarrierDescription("INDEX", 1, -1);
        public static final TypeSafeBarrierDescription FALSE = new TypeSafeBarrierDescription("FALSE", 2, Boolean.FALSE);
        public static final TypeSafeBarrierDescription MAP_GET_OR_DEFAULT = new MAP_GET_OR_DEFAULT("MAP_GET_OR_DEFAULT", 3);

        private static final /* synthetic */ TypeSafeBarrierDescription[] $values() {
            return new TypeSafeBarrierDescription[]{NULL, INDEX, FALSE, MAP_GET_OR_DEFAULT};
        }

        public /* synthetic */ TypeSafeBarrierDescription(String str, int i, Object obj, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, obj);
        }

        private TypeSafeBarrierDescription(String str, int i, Object obj) {
            super(str, i);
            this.defaultValue = obj;
        }

        static {
            TypeSafeBarrierDescription[] typeSafeBarrierDescriptionArr$values = $values();
            $VALUES = typeSafeBarrierDescriptionArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(typeSafeBarrierDescriptionArr$values);
        }

        static final class MAP_GET_OR_DEFAULT extends TypeSafeBarrierDescription {
            /* JADX WARN: Illegal instructions before constructor call */
            MAP_GET_OR_DEFAULT(String str, int i) {
                DefaultConstructorMarker defaultConstructorMarker = null;
                super(str, i, defaultConstructorMarker, defaultConstructorMarker);
            }
        }

        public static TypeSafeBarrierDescription valueOf(String str) {
            return (TypeSafeBarrierDescription) Enum.valueOf(TypeSafeBarrierDescription.class, str);
        }

        public static TypeSafeBarrierDescription[] values() {
            return (TypeSafeBarrierDescription[]) $VALUES.clone();
        }
    }

    public enum SpecialSignatureInfo {
        ONE_COLLECTION_PARAMETER("Ljava/util/Collection<+Ljava/lang/Object;>;", false),
        OBJECT_PARAMETER_NON_GENERIC(null, true),
        OBJECT_PARAMETER_GENERIC("Ljava/lang/Object;", true);

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
        private final boolean isObjectReplacedWithTypeParameter;
        private final String valueParametersSignature;

        SpecialSignatureInfo(String str, boolean z) {
            this.valueParametersSignature = str;
            this.isObjectReplacedWithTypeParameter = z;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SpecialSignatureInfo getSpecialSignatureInfo(String builtinSignature) {
            Intrinsics.checkNotNullParameter(builtinSignature, "builtinSignature");
            if (getERASED_COLLECTION_PARAMETER_SIGNATURES().contains(builtinSignature)) {
                return SpecialSignatureInfo.ONE_COLLECTION_PARAMETER;
            }
            if (((TypeSafeBarrierDescription) MapsKt.getValue(getSIGNATURE_TO_DEFAULT_VALUES_MAP(), builtinSignature)) == TypeSafeBarrierDescription.NULL) {
                return SpecialSignatureInfo.OBJECT_PARAMETER_GENERIC;
            }
            return SpecialSignatureInfo.OBJECT_PARAMETER_NON_GENERIC;
        }

        public static final class NameAndSignature {
            private final String classInternalName;
            private final Name name;
            private final String parameters;
            private final String returnType;
            private final String signature;

            public static /* synthetic */ NameAndSignature copy$default(NameAndSignature nameAndSignature, String str, Name name, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = nameAndSignature.classInternalName;
                }
                if ((i & 2) != 0) {
                    name = nameAndSignature.name;
                }
                if ((i & 4) != 0) {
                    str2 = nameAndSignature.parameters;
                }
                if ((i & 8) != 0) {
                    str3 = nameAndSignature.returnType;
                }
                return nameAndSignature.copy(str, name, str2, str3);
            }

            public final NameAndSignature copy(String classInternalName, Name name, String parameters, String returnType) {
                Intrinsics.checkNotNullParameter(classInternalName, "classInternalName");
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(parameters, "parameters");
                Intrinsics.checkNotNullParameter(returnType, "returnType");
                return new NameAndSignature(classInternalName, name, parameters, returnType);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof NameAndSignature)) {
                    return false;
                }
                NameAndSignature nameAndSignature = (NameAndSignature) obj;
                return Intrinsics.areEqual(this.classInternalName, nameAndSignature.classInternalName) && Intrinsics.areEqual(this.name, nameAndSignature.name) && Intrinsics.areEqual(this.parameters, nameAndSignature.parameters) && Intrinsics.areEqual(this.returnType, nameAndSignature.returnType);
            }

            public int hashCode() {
                return (((((this.classInternalName.hashCode() * 31) + this.name.hashCode()) * 31) + this.parameters.hashCode()) * 31) + this.returnType.hashCode();
            }

            public String toString() {
                return "NameAndSignature(classInternalName=" + this.classInternalName + ", name=" + this.name + ", parameters=" + this.parameters + ", returnType=" + this.returnType + ')';
            }

            public NameAndSignature(String classInternalName, Name name, String parameters, String returnType) {
                Intrinsics.checkNotNullParameter(classInternalName, "classInternalName");
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(parameters, "parameters");
                Intrinsics.checkNotNullParameter(returnType, "returnType");
                this.classInternalName = classInternalName;
                this.name = name;
                this.parameters = parameters;
                this.returnType = returnType;
                this.signature = SignatureBuildingComponents.INSTANCE.signature(classInternalName, name + '(' + parameters + ')' + returnType);
            }

            public final Name getName() {
                return this.name;
            }

            public final String getSignature() {
                return this.signature;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final NameAndSignature method(String str, String str2, String str3, String str4) {
            Name nameIdentifier = Name.identifier(str2);
            Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
            return new NameAndSignature(str, nameIdentifier, str3, str4);
        }

        public final List getERASED_COLLECTION_PARAMETER_SIGNATURES() {
            return SpecialGenericSignatures.ERASED_COLLECTION_PARAMETER_SIGNATURES;
        }

        public final Map getSIGNATURE_TO_DEFAULT_VALUES_MAP() {
            return SpecialGenericSignatures.SIGNATURE_TO_DEFAULT_VALUES_MAP;
        }

        public final Set getERASED_VALUE_PARAMETERS_SHORT_NAMES() {
            return SpecialGenericSignatures.ERASED_VALUE_PARAMETERS_SHORT_NAMES;
        }

        public final Set getERASED_VALUE_PARAMETERS_SIGNATURES() {
            return SpecialGenericSignatures.ERASED_VALUE_PARAMETERS_SIGNATURES;
        }

        public final NameAndSignature getREMOVE_AT_NAME_AND_SIGNATURE() {
            return SpecialGenericSignatures.REMOVE_AT_NAME_AND_SIGNATURE;
        }

        public final Map getSIGNATURE_TO_JVM_REPRESENTATION_NAME() {
            return SpecialGenericSignatures.SIGNATURE_TO_JVM_REPRESENTATION_NAME;
        }

        public final Set getORIGINAL_SHORT_NAMES() {
            return SpecialGenericSignatures.ORIGINAL_SHORT_NAMES;
        }

        public final Map getJVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP() {
            return SpecialGenericSignatures.JVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP;
        }

        public final Name getBuiltinFunctionNamesByJvmName(Name name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return (Name) getJVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP().get(name);
        }

        public final boolean getSameAsRenamedInJvmBuiltin(Name name) {
            Intrinsics.checkNotNullParameter(name, "<this>");
            return getORIGINAL_SHORT_NAMES().contains(name);
        }
    }

    static {
        Set<String> of = SetsKt.setOf((Object[]) new String[]{"containsAll", "removeAll", "retainAll"});
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(of, 10));
        for (String str : of) {
            Companion companion = Companion;
            String desc = JvmPrimitiveType.BOOLEAN.getDesc();
            Intrinsics.checkNotNullExpressionValue(desc, "getDesc(...)");
            arrayList.add(companion.method("java/util/Collection", str, "Ljava/util/Collection;", desc));
        }
        ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES = arrayList;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(((Companion.NameAndSignature) it.next()).getSignature());
        }
        ERASED_COLLECTION_PARAMETER_SIGNATURES = arrayList3;
        List list = ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList4.add(((Companion.NameAndSignature) it2.next()).getName().asString());
        }
        ERASED_COLLECTION_PARAMETER_NAMES = arrayList4;
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        Companion companion2 = Companion;
        String strJavaUtil = signatureBuildingComponents.javaUtil("Collection");
        JvmPrimitiveType jvmPrimitiveType = JvmPrimitiveType.BOOLEAN;
        String desc2 = jvmPrimitiveType.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc2, "getDesc(...)");
        Companion.NameAndSignature nameAndSignatureMethod = companion2.method(strJavaUtil, "contains", "Ljava/lang/Object;", desc2);
        TypeSafeBarrierDescription typeSafeBarrierDescription = TypeSafeBarrierDescription.FALSE;
        Pair pair = TuplesKt.to(nameAndSignatureMethod, typeSafeBarrierDescription);
        String strJavaUtil2 = signatureBuildingComponents.javaUtil("Collection");
        String desc3 = jvmPrimitiveType.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc3, "getDesc(...)");
        Pair pair2 = TuplesKt.to(companion2.method(strJavaUtil2, "remove", "Ljava/lang/Object;", desc3), typeSafeBarrierDescription);
        String strJavaUtil3 = signatureBuildingComponents.javaUtil("Map");
        String desc4 = jvmPrimitiveType.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc4, "getDesc(...)");
        Pair pair3 = TuplesKt.to(companion2.method(strJavaUtil3, "containsKey", "Ljava/lang/Object;", desc4), typeSafeBarrierDescription);
        String strJavaUtil4 = signatureBuildingComponents.javaUtil("Map");
        String desc5 = jvmPrimitiveType.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc5, "getDesc(...)");
        Pair pair4 = TuplesKt.to(companion2.method(strJavaUtil4, "containsValue", "Ljava/lang/Object;", desc5), typeSafeBarrierDescription);
        String strJavaUtil5 = signatureBuildingComponents.javaUtil("Map");
        String desc6 = jvmPrimitiveType.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc6, "getDesc(...)");
        Pair pair5 = TuplesKt.to(companion2.method(strJavaUtil5, "remove", "Ljava/lang/Object;Ljava/lang/Object;", desc6), typeSafeBarrierDescription);
        Pair pair6 = TuplesKt.to(companion2.method(signatureBuildingComponents.javaUtil("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), TypeSafeBarrierDescription.MAP_GET_OR_DEFAULT);
        Companion.NameAndSignature nameAndSignatureMethod2 = companion2.method(signatureBuildingComponents.javaUtil("Map"), b.au, "Ljava/lang/Object;", "Ljava/lang/Object;");
        TypeSafeBarrierDescription typeSafeBarrierDescription2 = TypeSafeBarrierDescription.NULL;
        Pair pair7 = TuplesKt.to(nameAndSignatureMethod2, typeSafeBarrierDescription2);
        Pair pair8 = TuplesKt.to(companion2.method(signatureBuildingComponents.javaUtil("Map"), "remove", "Ljava/lang/Object;", "Ljava/lang/Object;"), typeSafeBarrierDescription2);
        String strJavaUtil6 = signatureBuildingComponents.javaUtil("List");
        JvmPrimitiveType jvmPrimitiveType2 = JvmPrimitiveType.INT;
        String desc7 = jvmPrimitiveType2.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc7, "getDesc(...)");
        Companion.NameAndSignature nameAndSignatureMethod3 = companion2.method(strJavaUtil6, "indexOf", "Ljava/lang/Object;", desc7);
        TypeSafeBarrierDescription typeSafeBarrierDescription3 = TypeSafeBarrierDescription.INDEX;
        Pair pair9 = TuplesKt.to(nameAndSignatureMethod3, typeSafeBarrierDescription3);
        String strJavaUtil7 = signatureBuildingComponents.javaUtil("List");
        String desc8 = jvmPrimitiveType2.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc8, "getDesc(...)");
        Map mapMapOf = MapsKt.mapOf(pair, pair2, pair3, pair4, pair5, pair6, pair7, pair8, pair9, TuplesKt.to(companion2.method(strJavaUtil7, "lastIndexOf", "Ljava/lang/Object;", desc8), typeSafeBarrierDescription3));
        GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP = mapMapOf;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(mapMapOf.size()));
        for (Map.Entry entry : mapMapOf.entrySet()) {
            linkedHashMap.put(((Companion.NameAndSignature) entry.getKey()).getSignature(), entry.getValue());
        }
        SIGNATURE_TO_DEFAULT_VALUES_MAP = linkedHashMap;
        Set setPlus = SetsKt.plus(GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP.keySet(), (Iterable) ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES);
        ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(setPlus, 10));
        Iterator it3 = setPlus.iterator();
        while (it3.hasNext()) {
            arrayList5.add(((Companion.NameAndSignature) it3.next()).getName());
        }
        ERASED_VALUE_PARAMETERS_SHORT_NAMES = CollectionsKt.toSet(arrayList5);
        ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(setPlus, 10));
        Iterator it4 = setPlus.iterator();
        while (it4.hasNext()) {
            arrayList6.add(((Companion.NameAndSignature) it4.next()).getSignature());
        }
        ERASED_VALUE_PARAMETERS_SIGNATURES = CollectionsKt.toSet(arrayList6);
        Companion companion3 = Companion;
        JvmPrimitiveType jvmPrimitiveType3 = JvmPrimitiveType.INT;
        String desc9 = jvmPrimitiveType3.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc9, "getDesc(...)");
        Companion.NameAndSignature nameAndSignatureMethod4 = companion3.method("java/util/List", "removeAt", desc9, "Ljava/lang/Object;");
        REMOVE_AT_NAME_AND_SIGNATURE = nameAndSignatureMethod4;
        SignatureBuildingComponents signatureBuildingComponents2 = SignatureBuildingComponents.INSTANCE;
        String strJavaLang = signatureBuildingComponents2.javaLang("Number");
        String desc10 = JvmPrimitiveType.BYTE.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc10, "getDesc(...)");
        Pair pair10 = TuplesKt.to(companion3.method(strJavaLang, "toByte", "", desc10), Name.identifier("byteValue"));
        String strJavaLang2 = signatureBuildingComponents2.javaLang("Number");
        String desc11 = JvmPrimitiveType.SHORT.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc11, "getDesc(...)");
        Pair pair11 = TuplesKt.to(companion3.method(strJavaLang2, "toShort", "", desc11), Name.identifier("shortValue"));
        String strJavaLang3 = signatureBuildingComponents2.javaLang("Number");
        String desc12 = jvmPrimitiveType3.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc12, "getDesc(...)");
        Pair pair12 = TuplesKt.to(companion3.method(strJavaLang3, "toInt", "", desc12), Name.identifier("intValue"));
        String strJavaLang4 = signatureBuildingComponents2.javaLang("Number");
        String desc13 = JvmPrimitiveType.LONG.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc13, "getDesc(...)");
        Pair pair13 = TuplesKt.to(companion3.method(strJavaLang4, "toLong", "", desc13), Name.identifier("longValue"));
        String strJavaLang5 = signatureBuildingComponents2.javaLang("Number");
        String desc14 = JvmPrimitiveType.FLOAT.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc14, "getDesc(...)");
        Pair pair14 = TuplesKt.to(companion3.method(strJavaLang5, "toFloat", "", desc14), Name.identifier("floatValue"));
        String strJavaLang6 = signatureBuildingComponents2.javaLang("Number");
        String desc15 = JvmPrimitiveType.DOUBLE.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc15, "getDesc(...)");
        Pair pair15 = TuplesKt.to(companion3.method(strJavaLang6, "toDouble", "", desc15), Name.identifier("doubleValue"));
        Pair pair16 = TuplesKt.to(nameAndSignatureMethod4, Name.identifier("remove"));
        String strJavaLang7 = signatureBuildingComponents2.javaLang("CharSequence");
        String desc16 = jvmPrimitiveType3.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc16, "getDesc(...)");
        String desc17 = JvmPrimitiveType.CHAR.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc17, "getDesc(...)");
        Map mapMapOf2 = MapsKt.mapOf(pair10, pair11, pair12, pair13, pair14, pair15, pair16, TuplesKt.to(companion3.method(strJavaLang7, b.au, desc16, desc17), Name.identifier("charAt")), TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicInteger"), "load", "", "I"), Name.identifier(b.au)), TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicInteger"), ProductResponseJsonKeys.STORE, "I", "V"), Name.identifier("set")), TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicInteger"), "exchange", "I", "I"), Name.identifier("getAndSet")), TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicInteger"), "fetchAndAdd", "I", "I"), Name.identifier("getAndAdd")), TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicInteger"), "addAndFetch", "I", "I"), Name.identifier("addAndGet")), TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicLong"), "load", "", "J"), Name.identifier(b.au)), TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicLong"), ProductResponseJsonKeys.STORE, "J", "V"), Name.identifier("set")), TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicLong"), "exchange", "J", "J"), Name.identifier("getAndSet")), TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicLong"), "fetchAndAdd", "J", "J"), Name.identifier("getAndAdd")), TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicLong"), "addAndFetch", "J", "J"), Name.identifier("addAndGet")), TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicBoolean"), "load", "", "Z"), Name.identifier(b.au)), TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicBoolean"), ProductResponseJsonKeys.STORE, "Z", "V"), Name.identifier("set")), TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicBoolean"), "exchange", "Z", "Z"), Name.identifier("getAndSet")), TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicReference"), "load", "", "Ljava/lang/Object;"), Name.identifier(b.au)), TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicReference"), ProductResponseJsonKeys.STORE, "Ljava/lang/Object;", "V"), Name.identifier("set")), TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicReference"), "exchange", "Ljava/lang/Object;", "Ljava/lang/Object;"), Name.identifier("getAndSet")), TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicIntegerArray"), "loadAt", "I", "I"), Name.identifier(b.au)), TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicIntegerArray"), "storeAt", "II", "V"), Name.identifier("set")), TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicIntegerArray"), "exchangeAt", "II", "I"), Name.identifier("getAndSet")), TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicIntegerArray"), "compareAndSetAt", "III", "Z"), Name.identifier("compareAndSet")), TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicIntegerArray"), "fetchAndAddAt", "II", "I"), Name.identifier("getAndAdd")), TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicIntegerArray"), "addAndFetchAt", "II", "I"), Name.identifier("addAndGet")), TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicLongArray"), "loadAt", "I", "J"), Name.identifier(b.au)), TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicLongArray"), "storeAt", "IJ", "V"), Name.identifier("set")), TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicLongArray"), "exchangeAt", "IJ", "J"), Name.identifier("getAndSet")), TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicLongArray"), "compareAndSetAt", "IJJ", "Z"), Name.identifier("compareAndSet")), TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicLongArray"), "fetchAndAddAt", "IJ", "J"), Name.identifier("getAndAdd")), TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicLongArray"), "addAndFetchAt", "IJ", "J"), Name.identifier("addAndGet")), TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicReferenceArray"), "loadAt", "I", "Ljava/lang/Object;"), Name.identifier(b.au)), TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicReferenceArray"), "storeAt", "ILjava/lang/Object;", "V"), Name.identifier("set")), TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicReferenceArray"), "exchangeAt", "ILjava/lang/Object;", "Ljava/lang/Object;"), Name.identifier("getAndSet")), TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicReferenceArray"), "compareAndSetAt", "ILjava/lang/Object;Ljava/lang/Object;", "Z"), Name.identifier("compareAndSet")));
        NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP = mapMapOf2;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(mapMapOf2.size()));
        for (Map.Entry entry2 : mapMapOf2.entrySet()) {
            linkedHashMap2.put(((Companion.NameAndSignature) entry2.getKey()).getSignature(), entry2.getValue());
        }
        SIGNATURE_TO_JVM_REPRESENTATION_NAME = linkedHashMap2;
        Map map = NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Map.Entry entry3 : map.entrySet()) {
            linkedHashSet.add(Companion.NameAndSignature.copy$default((Companion.NameAndSignature) entry3.getKey(), null, (Name) entry3.getValue(), null, null, 13, null).getSignature());
        }
        JVM_SIGNATURES_FOR_RENAMED_BUILT_INS = linkedHashSet;
        Set setKeySet = NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP.keySet();
        HashSet hashSet = new HashSet();
        Iterator it5 = setKeySet.iterator();
        while (it5.hasNext()) {
            hashSet.add(((Companion.NameAndSignature) it5.next()).getName());
        }
        ORIGINAL_SHORT_NAMES = hashSet;
        Set<Map.Entry> setEntrySet = NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP.entrySet();
        ArrayList<Pair> arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10));
        for (Map.Entry entry4 : setEntrySet) {
            arrayList7.add(new Pair(((Companion.NameAndSignature) entry4.getKey()).getName(), entry4.getValue()));
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList7, 10)), 16));
        for (Pair pair17 : arrayList7) {
            linkedHashMap3.put((Name) pair17.getSecond(), (Name) pair17.getFirst());
        }
        JVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP = linkedHashMap3;
    }
}
