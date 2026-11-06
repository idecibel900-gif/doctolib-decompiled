package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;

/* JADX INFO: loaded from: classes5.dex */
public final class AnnotationConstructorCaller implements Caller {
    private final CallMode callMode;
    private final List defaultValues;
    private final List erasedParameterTypes;
    private final Class jClass;
    private final List methods;
    private final List parameterNames;
    private final List parameterTypes;

    public enum CallMode {
        CALL_BY_NAME,
        POSITIONAL_CALL;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    }

    public enum Origin {
        JAVA,
        KOTLIN;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    }

    public Void getMember() {
        return null;
    }

    public AnnotationConstructorCaller(Class jClass, List parameterNames, CallMode callMode, Origin origin, List methods) {
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        Intrinsics.checkNotNullParameter(parameterNames, "parameterNames");
        Intrinsics.checkNotNullParameter(callMode, "callMode");
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(methods, "methods");
        this.jClass = jClass;
        this.parameterNames = parameterNames;
        this.callMode = callMode;
        this.methods = methods;
        List list = methods;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Method) it.next()).getGenericReturnType());
        }
        this.parameterTypes = arrayList;
        List list2 = this.methods;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            Class<?> returnType = ((Method) it2.next()).getReturnType();
            Intrinsics.checkNotNull(returnType);
            Class<?> wrapperByPrimitive = ReflectClassUtilKt.getWrapperByPrimitive(returnType);
            if (wrapperByPrimitive != null) {
                returnType = wrapperByPrimitive;
            }
            arrayList2.add(returnType);
        }
        this.erasedParameterTypes = arrayList2;
        List list3 = this.methods;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
        Iterator it3 = list3.iterator();
        while (it3.hasNext()) {
            arrayList3.add(((Method) it3.next()).getDefaultValue());
        }
        this.defaultValues = arrayList3;
        if (this.callMode == CallMode.POSITIONAL_CALL && origin == Origin.JAVA && !CollectionsKt.minus(this.parameterNames, "value").isEmpty()) {
            throw new UnsupportedOperationException("Positional call of a Java annotation constructor is allowed only if there are no parameters or one parameter named \"value\". This restriction exists because Java annotations (in contrast to Kotlin)do not impose any order on their arguments. Use KCallable#callBy instead.");
        }
    }

    public void checkArguments(Object[] objArr) {
        Caller.DefaultImpls.checkArguments(this, objArr);
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    /* JADX INFO: renamed from: getMember, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Member mo5350getMember() {
        return (Member) getMember();
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public boolean isBoundInstanceCallWithValueClasses() {
        return Caller.DefaultImpls.isBoundInstanceCallWithValueClasses(this);
    }

    public /* synthetic */ AnnotationConstructorCaller(Class cls, List list, CallMode callMode, Origin origin, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        List list3;
        if ((i & 16) != 0) {
            List list4 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
            Iterator it = list4.iterator();
            while (it.hasNext()) {
                arrayList.add(cls.getDeclaredMethod((String) it.next(), null));
            }
            list3 = arrayList;
        } else {
            list3 = list2;
        }
        this(cls, list, callMode, origin, list3);
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public Type getReturnType() {
        return this.jClass;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public List getParameterTypes() {
        return this.parameterTypes;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public Object call(Object[] args) {
        Intrinsics.checkNotNullParameter(args, "args");
        checkArguments(args);
        ArrayList arrayList = new ArrayList(args.length);
        int length = args.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            Object obj = args[i];
            int i3 = i2 + 1;
            Object objTransformKotlinToJvm = (obj == null && this.callMode == CallMode.CALL_BY_NAME) ? this.defaultValues.get(i2) : AnnotationConstructorCallerKt.transformKotlinToJvm(obj, (Class) this.erasedParameterTypes.get(i2));
            if (objTransformKotlinToJvm == null) {
                AnnotationConstructorCallerKt.throwIllegalArgumentType(i2, (String) this.parameterNames.get(i2), (Class) this.erasedParameterTypes.get(i2));
                throw new KotlinNothingValueException();
            }
            arrayList.add(objTransformKotlinToJvm);
            i++;
            i2 = i3;
        }
        return AnnotationConstructorCallerKt.createAnnotationInstance(this.jClass, MapsKt.toMap(CollectionsKt.zip(this.parameterNames, arrayList)), this.methods);
    }
}
