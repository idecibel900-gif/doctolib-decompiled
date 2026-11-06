package kotlin.reflect.jvm.internal;

import com.amazon.a.a.o.c.a.b;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectJavaClassFinderKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
public abstract class KDeclarationContainerImpl implements ClassBasedDeclarationContainer {
    public static final Companion Companion = new Companion(null);
    private static final Class DEFAULT_CONSTRUCTOR_MARKER = DefaultConstructorMarker.class;
    private static final Regex LOCAL_PROPERTY_SIGNATURE = new Regex("<v#(\\d+)>");

    public abstract Collection getConstructorDescriptors();

    public abstract Collection getFunctions(Name name);

    public abstract PropertyDescriptor getLocalProperty(int i);

    public abstract Collection getProperties(Name name);

    public abstract class Data {
        static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Data.class, "moduleData", "getModuleData()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;", 0))};
        private final ReflectProperties.LazySoftVal moduleData$delegate;

        public Data() {
            this.moduleData$delegate = ReflectProperties.lazySoft(new Function0(KDeclarationContainerImpl.this) { // from class: kotlin.reflect.jvm.internal.KDeclarationContainerImpl$Data$$Lambda$0
                private final KDeclarationContainerImpl arg$0;

                {
                    this.arg$0 = kDeclarationContainerImpl;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    return KDeclarationContainerImpl.Data.moduleData_delegate$lambda$0(this.arg$0);
                }
            });
        }

        public final RuntimeModuleData getModuleData() {
            Object value = this.moduleData$delegate.getValue(this, $$delegatedProperties[0]);
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (RuntimeModuleData) value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final RuntimeModuleData moduleData_delegate$lambda$0(KDeclarationContainerImpl kDeclarationContainerImpl) {
            return ModuleByClassLoaderKt.getOrCreateModule(kDeclarationContainerImpl.getJClass());
        }
    }

    protected Class getMethodOwner() {
        Class wrapperByPrimitive = ReflectClassUtilKt.getWrapperByPrimitive(getJClass());
        return wrapperByPrimitive == null ? getJClass() : wrapperByPrimitive;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x004e  */
    protected final Collection getMembers(MemberScope scope, MemberBelonginess belonginess) {
        KCallableImpl kCallableImpl;
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(belonginess, "belonginess");
        CreateKCallableVisitor createKCallableVisitor = new CreateKCallableVisitor(this) { // from class: kotlin.reflect.jvm.internal.KDeclarationContainerImpl$getMembers$visitor$1
            {
                super(this);
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorVisitorEmptyBodies, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
            public KCallableImpl visitConstructorDescriptor(ConstructorDescriptor descriptor, Unit data) {
                Intrinsics.checkNotNullParameter(descriptor, "descriptor");
                Intrinsics.checkNotNullParameter(data, "data");
                throw new IllegalStateException("No constructors should appear here: " + descriptor);
            }
        };
        Collection<DeclarationDescriptor> contributedDescriptors$default = ResolutionScope.DefaultImpls.getContributedDescriptors$default(scope, null, null, 3, null);
        ArrayList arrayList = new ArrayList();
        for (DeclarationDescriptor declarationDescriptor : contributedDescriptors$default) {
            if (declarationDescriptor instanceof CallableMemberDescriptor) {
                CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) declarationDescriptor;
                if (Intrinsics.areEqual(callableMemberDescriptor.getVisibility(), DescriptorVisibilities.INVISIBLE_FAKE) || !belonginess.accept(callableMemberDescriptor)) {
                    kCallableImpl = null;
                } else {
                    kCallableImpl = (KCallableImpl) declarationDescriptor.accept(createKCallableVisitor, Unit.INSTANCE);
                }
            } else {
                kCallableImpl = null;
            }
            if (kCallableImpl != null) {
                arrayList.add(kCallableImpl);
            }
        }
        return CollectionsKt.toList(arrayList);
    }

    protected enum MemberBelonginess {
        DECLARED,
        INHERITED;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public final boolean accept(CallableMemberDescriptor member) {
            Intrinsics.checkNotNullParameter(member, "member");
            return member.getKind().isReal() == (this == DECLARED);
        }
    }

    public final PropertyDescriptor findPropertyDescriptor(String name, String signature) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(signature, "signature");
        MatchResult matchResultMatchEntire = LOCAL_PROPERTY_SIGNATURE.matchEntire(signature);
        if (matchResultMatchEntire != null) {
            String str = (String) matchResultMatchEntire.getDestructured().getMatch().getGroupValues().get(1);
            PropertyDescriptor localProperty = getLocalProperty(Integer.parseInt(str));
            if (localProperty != null) {
                return localProperty;
            }
            throw new KotlinReflectionInternalError("Local property #" + str + " not found in " + getJClass());
        }
        Name nameIdentifier = Name.identifier(name);
        Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
        Collection properties = getProperties(nameIdentifier);
        ArrayList arrayList = new ArrayList();
        for (Object obj : properties) {
            if (Intrinsics.areEqual(RuntimeTypeMapper.INSTANCE.mapPropertySignature((PropertyDescriptor) obj).asString(), signature)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            throw new KotlinReflectionInternalError("Property '" + name + "' (JVM signature: " + signature + ") not resolved in " + this);
        }
        if (arrayList.size() == 1) {
            return (PropertyDescriptor) CollectionsKt.single((List) arrayList);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj2 : arrayList) {
            DescriptorVisibility visibility = ((PropertyDescriptor) obj2).getVisibility();
            Object arrayList2 = linkedHashMap.get(visibility);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap.put(visibility, arrayList2);
            }
            ((List) arrayList2).add(obj2);
        }
        final KDeclarationContainerImpl$$Lambda$0 kDeclarationContainerImpl$$Lambda$0 = new Function2() { // from class: kotlin.reflect.jvm.internal.KDeclarationContainerImpl$$Lambda$0
            @Override // kotlin.jvm.functions.Function2
            public Object invoke(Object obj3, Object obj4) {
                return Integer.valueOf(KDeclarationContainerImpl.findPropertyDescriptor$lambda$3((DescriptorVisibility) obj3, (DescriptorVisibility) obj4));
            }
        };
        Collection collectionValues = MapsKt.toSortedMap(linkedHashMap, new Comparator(kDeclarationContainerImpl$$Lambda$0) { // from class: kotlin.reflect.jvm.internal.KDeclarationContainerImpl$$Lambda$1
            private final Function2 arg$0;

            {
                this.arg$0 = kDeclarationContainerImpl$$Lambda$0;
            }

            @Override // java.util.Comparator
            public int compare(Object obj3, Object obj4) {
                return KDeclarationContainerImpl.findPropertyDescriptor$lambda$4(this.arg$0, obj3, obj4);
            }
        }).values();
        Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
        List list = (List) CollectionsKt.last(collectionValues);
        if (list.size() == 1) {
            Intrinsics.checkNotNull(list);
            return (PropertyDescriptor) CollectionsKt.first(list);
        }
        Name nameIdentifier2 = Name.identifier(name);
        Intrinsics.checkNotNullExpressionValue(nameIdentifier2, "identifier(...)");
        String strJoinToString$default = CollectionsKt.joinToString$default(getProperties(nameIdentifier2), "\n", null, null, 0, null, new Function1() { // from class: kotlin.reflect.jvm.internal.KDeclarationContainerImpl$$Lambda$2
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj3) {
                return KDeclarationContainerImpl.findPropertyDescriptor$lambda$5((PropertyDescriptor) obj3);
            }
        }, 30, null);
        StringBuilder sb = new StringBuilder();
        sb.append("Property '");
        sb.append(name);
        sb.append("' (JVM signature: ");
        sb.append(signature);
        sb.append(") not resolved in ");
        sb.append(this);
        sb.append(':');
        sb.append(strJoinToString$default.length() == 0 ? " no members found" : '\n' + strJoinToString$default);
        throw new KotlinReflectionInternalError(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int findPropertyDescriptor$lambda$4(Function2 function2, Object obj, Object obj2) {
        return ((Number) function2.invoke(obj, obj2)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int findPropertyDescriptor$lambda$3(DescriptorVisibility descriptorVisibility, DescriptorVisibility descriptorVisibility2) {
        Integer numCompare = DescriptorVisibilities.compare(descriptorVisibility, descriptorVisibility2);
        if (numCompare != null) {
            return numCompare.intValue();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence findPropertyDescriptor$lambda$5(PropertyDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return DescriptorRenderer.DEBUG_TEXT.render(descriptor) + " | " + RuntimeTypeMapper.INSTANCE.mapPropertySignature(descriptor).asString();
    }

    /* JADX WARN: Code duplicated, block: B:18:0x00ad  */
    public final FunctionDescriptor findFunctionDescriptor(String name, String signature) {
        List functions;
        ArrayList arrayList;
        String strAsString;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(signature, "signature");
        if (Intrinsics.areEqual(name, "<init>")) {
            functions = CollectionsKt.toList(getConstructorDescriptors());
            arrayList = new ArrayList();
            for (Object obj : functions) {
                ConstructorDescriptor constructorDescriptor = (ConstructorDescriptor) obj;
                if (constructorDescriptor.isPrimary()) {
                    ClassifierDescriptorWithTypeParameters containingDeclaration = constructorDescriptor.getContainingDeclaration();
                    Intrinsics.checkNotNullExpressionValue(containingDeclaration, "getContainingDeclaration(...)");
                    if (InlineClassesUtilsKt.isMultiFieldValueClass(containingDeclaration)) {
                        String strAsString2 = RuntimeTypeMapper.INSTANCE.mapSignature(constructorDescriptor).asString();
                        if (!StringsKt.startsWith$default(strAsString2, "constructor-impl", false, 2, (Object) null) || !StringsKt.endsWith$default(strAsString2, ")V", false, 2, (Object) null)) {
                            throw new IllegalArgumentException(("Invalid signature of " + constructorDescriptor + ": " + strAsString2).toString());
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append(StringsKt.removeSuffix(strAsString2, "V"));
                        ClassifierDescriptorWithTypeParameters containingDeclaration2 = constructorDescriptor.getContainingDeclaration();
                        Intrinsics.checkNotNullExpressionValue(containingDeclaration2, "getContainingDeclaration(...)");
                        sb.append(ValueClassAwareCallerKt.toJvmDescriptor(containingDeclaration2));
                        strAsString = sb.toString();
                    } else {
                        strAsString = RuntimeTypeMapper.INSTANCE.mapSignature(constructorDescriptor).asString();
                    }
                } else {
                    strAsString = RuntimeTypeMapper.INSTANCE.mapSignature(constructorDescriptor).asString();
                }
                if (Intrinsics.areEqual(strAsString, signature)) {
                    arrayList.add(obj);
                }
            }
        } else {
            Name nameIdentifier = Name.identifier(name);
            Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
            functions = getFunctions(nameIdentifier);
            arrayList = new ArrayList();
            for (Object obj2 : functions) {
                if (Intrinsics.areEqual(RuntimeTypeMapper.INSTANCE.mapSignature((FunctionDescriptor) obj2).asString(), signature)) {
                    arrayList.add(obj2);
                }
            }
        }
        if (arrayList.size() == 1) {
            return (FunctionDescriptor) CollectionsKt.single((List) arrayList);
        }
        String strJoinToString$default = CollectionsKt.joinToString$default(functions, "\n", null, null, 0, null, new Function1() { // from class: kotlin.reflect.jvm.internal.KDeclarationContainerImpl$$Lambda$3
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj3) {
                return KDeclarationContainerImpl.findFunctionDescriptor$lambda$9((FunctionDescriptor) obj3);
            }
        }, 30, null);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Function '");
        sb2.append(name);
        sb2.append("' (JVM signature: ");
        sb2.append(signature);
        sb2.append(") not resolved in ");
        sb2.append(this);
        sb2.append(':');
        sb2.append(strJoinToString$default.length() == 0 ? " no members found" : '\n' + strJoinToString$default);
        throw new KotlinReflectionInternalError(sb2.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence findFunctionDescriptor$lambda$9(FunctionDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return DescriptorRenderer.DEBUG_TEXT.render(descriptor) + " | " + RuntimeTypeMapper.INSTANCE.mapSignature(descriptor).asString();
    }

    private final Method lookupMethod(Class cls, String str, Class[] clsArr, Class cls2, boolean z) {
        String str2;
        Class[] clsArr2;
        Class cls3;
        boolean z2;
        if (z) {
            clsArr[0] = cls;
        }
        Method methodTryGetMethod = tryGetMethod(cls, str, clsArr, cls2);
        if (methodTryGetMethod != null) {
            return methodTryGetMethod;
        }
        Class superclass = cls.getSuperclass();
        if (superclass != null) {
            Method methodLookupMethod = lookupMethod(superclass, str, clsArr, cls2, z);
            str2 = str;
            clsArr2 = clsArr;
            cls3 = cls2;
            z2 = z;
            if (methodLookupMethod != null) {
                return methodLookupMethod;
            }
        } else {
            str2 = str;
            clsArr2 = clsArr;
            cls3 = cls2;
            z2 = z;
        }
        Iterator it = ArrayIteratorKt.iterator(cls.getInterfaces());
        while (it.hasNext()) {
            Class cls4 = (Class) it.next();
            Intrinsics.checkNotNull(cls4);
            Method methodLookupMethod2 = lookupMethod(cls4, str2, clsArr2, cls3, z2);
            if (methodLookupMethod2 != null) {
                return methodLookupMethod2;
            }
            if (z2) {
                Class clsTryLoadClass = ReflectJavaClassFinderKt.tryLoadClass(ReflectClassUtilKt.getSafeClassLoader(cls4), cls4.getName() + "$DefaultImpls");
                if (clsTryLoadClass != null) {
                    clsArr2[0] = cls4;
                    Method methodTryGetMethod2 = tryGetMethod(clsTryLoadClass, str2, clsArr2, cls3);
                    if (methodTryGetMethod2 != null) {
                        return methodTryGetMethod2;
                    }
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    private final Method tryGetMethod(Class cls, String str, Class[] clsArr, Class cls2) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
            if (Intrinsics.areEqual(declaredMethod.getReturnType(), cls2)) {
                return declaredMethod;
            }
            Method[] declaredMethods = cls.getDeclaredMethods();
            Intrinsics.checkNotNullExpressionValue(declaredMethods, "getDeclaredMethods(...)");
            for (Method method : declaredMethods) {
                if (Intrinsics.areEqual(method.getName(), str) && Intrinsics.areEqual(method.getReturnType(), cls2) && Arrays.equals(method.getParameterTypes(), clsArr)) {
                    return method;
                }
            }
        } catch (NoSuchMethodException unused) {
        }
        return null;
    }

    private final Constructor tryGetConstructor(Class cls, List list) {
        try {
            Class[] clsArr = (Class[]) list.toArray(new Class[0]);
            return cls.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public final Method findMethodBySignature(String name, String desc) {
        Method methodLookupMethod;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(desc, "desc");
        if (Intrinsics.areEqual(name, "<init>")) {
            return null;
        }
        FunctionJvmDescriptor jvmDescriptor = parseJvmDescriptor(desc, true);
        Class[] clsArr = (Class[]) jvmDescriptor.getParameters().toArray(new Class[0]);
        Class returnType = jvmDescriptor.getReturnType();
        Intrinsics.checkNotNull(returnType);
        Method methodLookupMethod2 = lookupMethod(getMethodOwner(), name, clsArr, returnType, false);
        if (methodLookupMethod2 != null) {
            return methodLookupMethod2;
        }
        if (!getMethodOwner().isInterface() || (methodLookupMethod = lookupMethod(Object.class, name, clsArr, returnType, false)) == null) {
            return null;
        }
        return methodLookupMethod;
    }

    public final Method findDefaultMethod(String name, String desc, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(desc, "desc");
        if (Intrinsics.areEqual(name, "<init>")) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (z) {
            arrayList.add(getJClass());
        }
        FunctionJvmDescriptor jvmDescriptor = parseJvmDescriptor(desc, true);
        addParametersAndMasks(arrayList, jvmDescriptor.getParameters(), false);
        Class methodOwner = getMethodOwner();
        String str = name + "$default";
        Class[] clsArr = (Class[]) arrayList.toArray(new Class[0]);
        Class returnType = jvmDescriptor.getReturnType();
        Intrinsics.checkNotNull(returnType);
        return lookupMethod(methodOwner, str, clsArr, returnType, z);
    }

    public final Constructor findConstructorBySignature(String desc) {
        Intrinsics.checkNotNullParameter(desc, "desc");
        return tryGetConstructor(getJClass(), parseJvmDescriptor(desc, false).getParameters());
    }

    public final Constructor findDefaultConstructor(String desc) {
        Intrinsics.checkNotNullParameter(desc, "desc");
        Class jClass = getJClass();
        ArrayList arrayList = new ArrayList();
        addParametersAndMasks(arrayList, parseJvmDescriptor(desc, false).getParameters(), true);
        Unit unit = Unit.INSTANCE;
        return tryGetConstructor(jClass, arrayList);
    }

    private final void addParametersAndMasks(List list, List list2, boolean z) {
        if (Intrinsics.areEqual(CollectionsKt.lastOrNull(list2), DEFAULT_CONSTRUCTOR_MARKER)) {
            list2 = list2.subList(0, list2.size() - 1);
        }
        list.addAll(list2);
        int size = (list2.size() + 31) / 32;
        for (int i = 0; i < size; i++) {
            Class TYPE = Integer.TYPE;
            Intrinsics.checkNotNullExpressionValue(TYPE, "TYPE");
            list.add(TYPE);
        }
        Class<Object> cls = z ? DEFAULT_CONSTRUCTOR_MARKER : Object.class;
        Intrinsics.checkNotNull(cls);
        list.add(cls);
    }

    private static final class FunctionJvmDescriptor {
        private final List parameters;
        private final Class returnType;

        public FunctionJvmDescriptor(List parameters, Class cls) {
            Intrinsics.checkNotNullParameter(parameters, "parameters");
            this.parameters = parameters;
            this.returnType = cls;
        }

        public final List getParameters() {
            return this.parameters;
        }

        public final Class getReturnType() {
            return this.returnType;
        }
    }

    private final FunctionJvmDescriptor parseJvmDescriptor(String str, boolean z) {
        String str2;
        int iIndexOf$default;
        ArrayList arrayList = new ArrayList();
        int i = 1;
        while (true) {
            if (str.charAt(i) != ')') {
                int i2 = i;
                while (str.charAt(i2) == '[') {
                    i2++;
                }
                char cCharAt = str.charAt(i2);
                if (StringsKt.contains$default((CharSequence) "VZCBSIFJD", cCharAt, false, 2, (Object) null)) {
                    int i3 = i2 + 1;
                    str2 = str;
                    iIndexOf$default = i3;
                } else if (cCharAt == 'L') {
                    str2 = str;
                    iIndexOf$default = StringsKt.indexOf$default((CharSequence) str2, ';', i, false, 4, (Object) null) + 1;
                } else {
                    throw new KotlinReflectionInternalError("Unknown type prefix in the method signature: " + str);
                }
                arrayList.add(parseType(str2, i, iIndexOf$default));
                i = iIndexOf$default;
                str = str2;
            } else {
                String str3 = str;
                return new FunctionJvmDescriptor(arrayList, z ? parseType(str3, i + 1, str3.length()) : null);
            }
        }
    }

    private final Class parseType(String str, int i, int i2) throws ClassNotFoundException {
        char cCharAt = str.charAt(i);
        if (cCharAt == 'F') {
            return Float.TYPE;
        }
        if (cCharAt == 'L') {
            ClassLoader safeClassLoader = ReflectClassUtilKt.getSafeClassLoader(getJClass());
            String strSubstring = str.substring(i + 1, i2 - 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            Class<?> clsLoadClass = safeClassLoader.loadClass(StringsKt.replace$default(strSubstring, '/', b.a, false, 4, (Object) null));
            Intrinsics.checkNotNullExpressionValue(clsLoadClass, "loadClass(...)");
            return clsLoadClass;
        }
        if (cCharAt == 'S') {
            return Short.TYPE;
        }
        if (cCharAt == 'V') {
            Class TYPE = Void.TYPE;
            Intrinsics.checkNotNullExpressionValue(TYPE, "TYPE");
            return TYPE;
        }
        if (cCharAt == 'I') {
            return Integer.TYPE;
        }
        if (cCharAt == 'J') {
            return Long.TYPE;
        }
        if (cCharAt == 'Z') {
            return Boolean.TYPE;
        }
        if (cCharAt == '[') {
            return UtilKt.createArrayType(parseType(str, i + 1, i2));
        }
        switch (cCharAt) {
            case 'B':
                return Byte.TYPE;
            case 'C':
                return Character.TYPE;
            case 'D':
                return Double.TYPE;
            default:
                throw new KotlinReflectionInternalError("Unknown type prefix in the method signature: " + str);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Regex getLOCAL_PROPERTY_SIGNATURE$kotlin_reflection() {
            return KDeclarationContainerImpl.LOCAL_PROPERTY_SIGNATURE;
        }
    }
}
