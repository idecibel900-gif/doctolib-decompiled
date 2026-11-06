package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;

/* JADX INFO: loaded from: classes5.dex */
public abstract class CallerImpl implements Caller {
    public static final Companion Companion = new Companion(null);
    private final Class instanceClass;
    private final Member member;
    private final List parameterTypes;
    private final Type returnType;

    public /* synthetic */ CallerImpl(Member member, Type type, Class cls, Type[] typeArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(member, type, cls, typeArr);
    }

    /* JADX WARN: Code duplicated, block: B:6:0x0027  */
    private CallerImpl(Member member, Type type, Class cls, Type[] typeArr) {
        List list;
        this.member = member;
        this.returnType = type;
        this.instanceClass = cls;
        if (cls != null) {
            SpreadBuilder spreadBuilder = new SpreadBuilder(2);
            spreadBuilder.add(cls);
            spreadBuilder.addSpread(typeArr);
            list = CollectionsKt.listOf(spreadBuilder.toArray(new Type[spreadBuilder.size()]));
            list = list == null ? ArraysKt.toList(typeArr) : list;
        }
        this.parameterTypes = list;
    }

    public void checkArguments(Object[] objArr) {
        Caller.DefaultImpls.checkArguments(this, objArr);
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public boolean isBoundInstanceCallWithValueClasses() {
        return Caller.DefaultImpls.isBoundInstanceCallWithValueClasses(this);
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    /* JADX INFO: renamed from: getMember */
    public final Member mo5350getMember() {
        return this.member;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public final Type getReturnType() {
        return this.returnType;
    }

    public final Class getInstanceClass() {
        return this.instanceClass;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public List getParameterTypes() {
        return this.parameterTypes;
    }

    protected final void checkObjectInstance(Object obj) {
        if (obj == null || !this.member.getDeclaringClass().isInstance(obj)) {
            throw new IllegalArgumentException("An object member requires the object instance passed as the first argument.");
        }
    }

    public static final class Constructor extends CallerImpl {
        /* JADX WARN: Illegal instructions before constructor call */
        public Constructor(java.lang.reflect.Constructor constructor) {
            Intrinsics.checkNotNullParameter(constructor, "constructor");
            Class declaringClass = constructor.getDeclaringClass();
            Intrinsics.checkNotNullExpressionValue(declaringClass, "getDeclaringClass(...)");
            Class declaringClass2 = constructor.getDeclaringClass();
            Class<?> declaringClass3 = declaringClass2.getDeclaringClass();
            Class<?> cls = (declaringClass3 == null || Modifier.isStatic(declaringClass2.getModifiers())) ? null : declaringClass3;
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            Intrinsics.checkNotNullExpressionValue(genericParameterTypes, "getGenericParameterTypes(...)");
            super(constructor, declaringClass, cls, genericParameterTypes, null);
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        public Object call(Object[] args) {
            Intrinsics.checkNotNullParameter(args, "args");
            checkArguments(args);
            return ((java.lang.reflect.Constructor) mo5350getMember()).newInstance(Arrays.copyOf(args, args.length));
        }
    }

    public static final class BoundConstructor extends CallerImpl implements BoundCaller {
        private final Object boundReceiver;

        /* JADX WARN: Illegal instructions before constructor call */
        public BoundConstructor(java.lang.reflect.Constructor constructor, Object obj) {
            Intrinsics.checkNotNullParameter(constructor, "constructor");
            Class declaringClass = constructor.getDeclaringClass();
            Intrinsics.checkNotNullExpressionValue(declaringClass, "getDeclaringClass(...)");
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            Intrinsics.checkNotNullExpressionValue(genericParameterTypes, "getGenericParameterTypes(...)");
            super(constructor, declaringClass, null, genericParameterTypes, null);
            this.boundReceiver = obj;
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        public Object call(Object[] args) {
            Intrinsics.checkNotNullParameter(args, "args");
            checkArguments(args);
            java.lang.reflect.Constructor constructor = (java.lang.reflect.Constructor) mo5350getMember();
            SpreadBuilder spreadBuilder = new SpreadBuilder(2);
            spreadBuilder.add(this.boundReceiver);
            spreadBuilder.addSpread(args);
            return constructor.newInstance(spreadBuilder.toArray(new Object[spreadBuilder.size()]));
        }
    }

    public static final class AccessorForHiddenConstructor extends CallerImpl {
        /* JADX WARN: Illegal instructions before constructor call */
        public AccessorForHiddenConstructor(java.lang.reflect.Constructor constructor) {
            Intrinsics.checkNotNullParameter(constructor, "constructor");
            Class declaringClass = constructor.getDeclaringClass();
            Intrinsics.checkNotNullExpressionValue(declaringClass, "getDeclaringClass(...)");
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            Intrinsics.checkNotNullExpressionValue(genericParameterTypes, "getGenericParameterTypes(...)");
            super(constructor, declaringClass, null, (Type[]) (genericParameterTypes.length <= 1 ? new Type[0] : ArraysKt.copyOfRange(genericParameterTypes, 0, genericParameterTypes.length - 1)), null);
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        public Object call(Object[] args) {
            Intrinsics.checkNotNullParameter(args, "args");
            checkArguments(args);
            java.lang.reflect.Constructor constructor = (java.lang.reflect.Constructor) mo5350getMember();
            SpreadBuilder spreadBuilder = new SpreadBuilder(2);
            spreadBuilder.addSpread(args);
            spreadBuilder.add(null);
            return constructor.newInstance(spreadBuilder.toArray(new Object[spreadBuilder.size()]));
        }
    }

    public static final class AccessorForHiddenBoundConstructor extends CallerImpl implements BoundCaller {
        private final Object boundReceiver;

        /* JADX WARN: Illegal instructions before constructor call */
        public AccessorForHiddenBoundConstructor(java.lang.reflect.Constructor constructor, Object obj) {
            Intrinsics.checkNotNullParameter(constructor, "constructor");
            Class declaringClass = constructor.getDeclaringClass();
            Intrinsics.checkNotNullExpressionValue(declaringClass, "getDeclaringClass(...)");
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            Intrinsics.checkNotNullExpressionValue(genericParameterTypes, "getGenericParameterTypes(...)");
            super(constructor, declaringClass, null, (Type[]) (genericParameterTypes.length <= 2 ? new Type[0] : ArraysKt.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length - 1)), null);
            this.boundReceiver = obj;
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        public Object call(Object[] args) {
            Intrinsics.checkNotNullParameter(args, "args");
            checkArguments(args);
            java.lang.reflect.Constructor constructor = (java.lang.reflect.Constructor) mo5350getMember();
            SpreadBuilder spreadBuilder = new SpreadBuilder(3);
            spreadBuilder.add(this.boundReceiver);
            spreadBuilder.addSpread(args);
            spreadBuilder.add(null);
            return constructor.newInstance(spreadBuilder.toArray(new Object[spreadBuilder.size()]));
        }
    }

    public static abstract class Method extends CallerImpl {
        private final boolean isVoidMethod;

        public /* synthetic */ Method(java.lang.reflect.Method method, boolean z, Type[] typeArr, DefaultConstructorMarker defaultConstructorMarker) {
            this(method, z, typeArr);
        }

        public /* synthetic */ Method(java.lang.reflect.Method method, boolean z, Type[] typeArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(method, (i & 2) != 0 ? !Modifier.isStatic(method.getModifiers()) : z, (i & 4) != 0 ? method.getGenericParameterTypes() : typeArr, null);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        private Method(java.lang.reflect.Method method, boolean z, Type[] typeArr) {
            Type genericReturnType = method.getGenericReturnType();
            Intrinsics.checkNotNullExpressionValue(genericReturnType, "getGenericReturnType(...)");
            super(method, genericReturnType, z ? method.getDeclaringClass() : null, typeArr, null);
            this.isVoidMethod = Intrinsics.areEqual(getReturnType(), Void.TYPE);
        }

        protected final Object callMethod(Object obj, Object[] args) {
            Intrinsics.checkNotNullParameter(args, "args");
            return this.isVoidMethod ? Unit.INSTANCE : ((java.lang.reflect.Method) mo5350getMember()).invoke(obj, Arrays.copyOf(args, args.length));
        }

        public static final class Static extends Method {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Static(java.lang.reflect.Method method) {
                super(method, false, null, 6, null);
                Intrinsics.checkNotNullParameter(method, "method");
            }

            @Override // kotlin.reflect.jvm.internal.calls.Caller
            public Object call(Object[] args) {
                Intrinsics.checkNotNullParameter(args, "args");
                checkArguments(args);
                return callMethod(null, args);
            }
        }

        public static final class Instance extends Method {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Instance(java.lang.reflect.Method method) {
                super(method, false, null, 6, null);
                Intrinsics.checkNotNullParameter(method, "method");
            }

            @Override // kotlin.reflect.jvm.internal.calls.Caller
            public Object call(Object[] args) {
                Intrinsics.checkNotNullParameter(args, "args");
                checkArguments(args);
                return callMethod(args[0], args.length <= 1 ? new Object[0] : ArraysKt.copyOfRange(args, 1, args.length));
            }
        }

        public static final class JvmStaticInObject extends Method {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public JvmStaticInObject(java.lang.reflect.Method method) {
                super(method, true, null, 4, null);
                Intrinsics.checkNotNullParameter(method, "method");
            }

            @Override // kotlin.reflect.jvm.internal.calls.Caller
            public Object call(Object[] args) {
                Intrinsics.checkNotNullParameter(args, "args");
                checkArguments(args);
                checkObjectInstance(ArraysKt.firstOrNull(args));
                return callMethod(null, args.length <= 1 ? new Object[0] : ArraysKt.copyOfRange(args, 1, args.length));
            }
        }

        public static final class BoundStatic extends Method implements BoundCaller {
            private final Object boundReceiver;
            private final boolean isCallByToValueClassMangledMethod;

            public final Object getBoundReceiver$kotlin_reflection() {
                return this.boundReceiver;
            }

            public final boolean isCallByToValueClassMangledMethod$kotlin_reflection() {
                return this.isCallByToValueClassMangledMethod;
            }

            /* JADX WARN: Illegal instructions before constructor call */
            public BoundStatic(java.lang.reflect.Method method, boolean z, Object obj) {
                Intrinsics.checkNotNullParameter(method, "method");
                Type[] genericParameterTypes = method.getGenericParameterTypes();
                Intrinsics.checkNotNullExpressionValue(genericParameterTypes, "getGenericParameterTypes(...)");
                super(method, false, (Type[]) (genericParameterTypes.length <= 1 ? new Type[0] : ArraysKt.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length)), null);
                this.isCallByToValueClassMangledMethod = z;
                this.boundReceiver = obj;
            }

            @Override // kotlin.reflect.jvm.internal.calls.Caller
            public Object call(Object[] args) {
                Intrinsics.checkNotNullParameter(args, "args");
                checkArguments(args);
                SpreadBuilder spreadBuilder = new SpreadBuilder(2);
                spreadBuilder.add(this.boundReceiver);
                spreadBuilder.addSpread(args);
                return callMethod(null, spreadBuilder.toArray(new Object[spreadBuilder.size()]));
            }
        }

        public static final class BoundStaticMultiFieldValueClass extends Method implements BoundCaller {
            private final Object[] boundReceiverComponents;

            public final Object[] getBoundReceiverComponents$kotlin_reflection() {
                return this.boundReceiverComponents;
            }

            /* JADX WARN: Illegal instructions before constructor call */
            public BoundStaticMultiFieldValueClass(java.lang.reflect.Method method, Object[] boundReceiverComponents) {
                Intrinsics.checkNotNullParameter(method, "method");
                Intrinsics.checkNotNullParameter(boundReceiverComponents, "boundReceiverComponents");
                Type[] genericParameterTypes = method.getGenericParameterTypes();
                Intrinsics.checkNotNullExpressionValue(genericParameterTypes, "getGenericParameterTypes(...)");
                super(method, false, (Type[]) ArraysKt.drop(genericParameterTypes, boundReceiverComponents.length).toArray(new Type[0]), null);
                this.boundReceiverComponents = boundReceiverComponents;
            }

            @Override // kotlin.reflect.jvm.internal.calls.Caller
            public Object call(Object[] args) {
                Intrinsics.checkNotNullParameter(args, "args");
                checkArguments(args);
                SpreadBuilder spreadBuilder = new SpreadBuilder(2);
                spreadBuilder.addSpread(this.boundReceiverComponents);
                spreadBuilder.addSpread(args);
                return callMethod(null, spreadBuilder.toArray(new Object[spreadBuilder.size()]));
            }

            public final int getReceiverComponentsCount() {
                return this.boundReceiverComponents.length;
            }
        }

        public static final class BoundInstance extends Method implements BoundCaller {
            private final Object boundReceiver;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public BoundInstance(java.lang.reflect.Method method, Object obj) {
                super(method, false, null, 4, null);
                Intrinsics.checkNotNullParameter(method, "method");
                this.boundReceiver = obj;
            }

            @Override // kotlin.reflect.jvm.internal.calls.Caller
            public Object call(Object[] args) {
                Intrinsics.checkNotNullParameter(args, "args");
                checkArguments(args);
                return callMethod(this.boundReceiver, args);
            }
        }

        public static final class BoundJvmStaticInObject extends Method implements BoundCaller {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public BoundJvmStaticInObject(java.lang.reflect.Method method) {
                super(method, false, null, 4, null);
                Intrinsics.checkNotNullParameter(method, "method");
            }

            @Override // kotlin.reflect.jvm.internal.calls.Caller
            public Object call(Object[] args) {
                Intrinsics.checkNotNullParameter(args, "args");
                checkArguments(args);
                return callMethod(null, args);
            }
        }
    }

    public static abstract class FieldGetter extends CallerImpl {
        public /* synthetic */ FieldGetter(Field field, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
            this(field, z);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        private FieldGetter(Field field, boolean z) {
            Type genericType = field.getGenericType();
            Intrinsics.checkNotNullExpressionValue(genericType, "getGenericType(...)");
            super(field, genericType, z ? field.getDeclaringClass() : null, new Type[0], null);
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        public Object call(Object[] args) {
            Intrinsics.checkNotNullParameter(args, "args");
            checkArguments(args);
            return ((Field) mo5350getMember()).get(getInstanceClass() != null ? ArraysKt.first(args) : null);
        }

        public static final class Static extends FieldGetter {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Static(Field field) {
                super(field, false, null);
                Intrinsics.checkNotNullParameter(field, "field");
            }
        }

        public static final class Instance extends FieldGetter {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Instance(Field field) {
                super(field, true, null);
                Intrinsics.checkNotNullParameter(field, "field");
            }
        }

        public static final class JvmStaticInObject extends FieldGetter {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public JvmStaticInObject(Field field) {
                super(field, true, null);
                Intrinsics.checkNotNullParameter(field, "field");
            }

            @Override // kotlin.reflect.jvm.internal.calls.CallerImpl
            public void checkArguments(Object[] args) {
                Intrinsics.checkNotNullParameter(args, "args");
                super.checkArguments(args);
                checkObjectInstance(ArraysKt.firstOrNull(args));
            }
        }

        public static final class BoundInstance extends FieldGetter implements BoundCaller {
            private final Object boundReceiver;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public BoundInstance(Field field, Object obj) {
                super(field, false, null);
                Intrinsics.checkNotNullParameter(field, "field");
                this.boundReceiver = obj;
            }

            @Override // kotlin.reflect.jvm.internal.calls.CallerImpl.FieldGetter, kotlin.reflect.jvm.internal.calls.Caller
            public Object call(Object[] args) {
                Intrinsics.checkNotNullParameter(args, "args");
                checkArguments(args);
                return ((Field) mo5350getMember()).get(this.boundReceiver);
            }
        }

        public static final class BoundJvmStaticInObject extends FieldGetter implements BoundCaller {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public BoundJvmStaticInObject(Field field) {
                super(field, false, null);
                Intrinsics.checkNotNullParameter(field, "field");
            }
        }
    }

    public static abstract class FieldSetter extends CallerImpl {
        private final boolean notNull;

        public /* synthetic */ FieldSetter(Field field, boolean z, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
            this(field, z, z2);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        private FieldSetter(Field field, boolean z, boolean z2) {
            Class TYPE = Void.TYPE;
            Intrinsics.checkNotNullExpressionValue(TYPE, "TYPE");
            super(field, TYPE, z2 ? field.getDeclaringClass() : null, new Type[]{field.getGenericType()}, null);
            this.notNull = z;
        }

        @Override // kotlin.reflect.jvm.internal.calls.CallerImpl
        public void checkArguments(Object[] args) {
            Intrinsics.checkNotNullParameter(args, "args");
            super.checkArguments(args);
            if (this.notNull && ArraysKt.last(args) == null) {
                throw new IllegalArgumentException("null is not allowed as a value for this property.");
            }
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        public Object call(Object[] args) throws IllegalAccessException {
            Intrinsics.checkNotNullParameter(args, "args");
            checkArguments(args);
            ((Field) mo5350getMember()).set(getInstanceClass() != null ? ArraysKt.first(args) : null, ArraysKt.last(args));
            return Unit.INSTANCE;
        }

        public static final class Static extends FieldSetter {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Static(Field field, boolean z) {
                super(field, z, false, null);
                Intrinsics.checkNotNullParameter(field, "field");
            }
        }

        public static final class Instance extends FieldSetter {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Instance(Field field, boolean z) {
                super(field, z, true, null);
                Intrinsics.checkNotNullParameter(field, "field");
            }
        }

        public static final class JvmStaticInObject extends FieldSetter {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public JvmStaticInObject(Field field, boolean z) {
                super(field, z, true, null);
                Intrinsics.checkNotNullParameter(field, "field");
            }

            @Override // kotlin.reflect.jvm.internal.calls.CallerImpl.FieldSetter, kotlin.reflect.jvm.internal.calls.CallerImpl
            public void checkArguments(Object[] args) {
                Intrinsics.checkNotNullParameter(args, "args");
                super.checkArguments(args);
                checkObjectInstance(ArraysKt.firstOrNull(args));
            }
        }

        public static final class BoundInstance extends FieldSetter implements BoundCaller {
            private final Object boundReceiver;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public BoundInstance(Field field, boolean z, Object obj) {
                super(field, z, false, null);
                Intrinsics.checkNotNullParameter(field, "field");
                this.boundReceiver = obj;
            }

            @Override // kotlin.reflect.jvm.internal.calls.CallerImpl.FieldSetter, kotlin.reflect.jvm.internal.calls.Caller
            public Object call(Object[] args) throws IllegalAccessException {
                Intrinsics.checkNotNullParameter(args, "args");
                checkArguments(args);
                ((Field) mo5350getMember()).set(this.boundReceiver, ArraysKt.first(args));
                return Unit.INSTANCE;
            }
        }

        public static final class BoundJvmStaticInObject extends FieldSetter implements BoundCaller {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public BoundJvmStaticInObject(Field field, boolean z) {
                super(field, z, false, null);
                Intrinsics.checkNotNullParameter(field, "field");
            }

            @Override // kotlin.reflect.jvm.internal.calls.CallerImpl.FieldSetter, kotlin.reflect.jvm.internal.calls.Caller
            public Object call(Object[] args) throws IllegalAccessException {
                Intrinsics.checkNotNullParameter(args, "args");
                checkArguments(args);
                ((Field) mo5350getMember()).set(null, ArraysKt.last(args));
                return Unit.INSTANCE;
            }
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
