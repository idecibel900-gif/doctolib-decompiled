package expo.modules.kotlin.functions;

import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.exception.ArgumentCastException;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.InvalidArgsNumberException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.jni.JavaScriptObject;
import expo.modules.kotlin.jni.decorators.JSDecoratorsBridgingObject;
import expo.modules.kotlin.types.AnyType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AnyFunction {
    private boolean canTakeOwner;
    private final AnyType[] desiredArgsTypes;
    private boolean isEnumerable;
    private final String name;
    private KType ownerType;
    private final int requiredArgumentsCount;

    public abstract void attachToJSObject(AppContext appContext, JSDecoratorsBridgingObject jSDecoratorsBridgingObject, String str);

    public AnyFunction(String name, AnyType[] desiredArgsTypes) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(desiredArgsTypes, "desiredArgsTypes");
        this.name = name;
        this.desiredArgsTypes = desiredArgsTypes;
        this.isEnumerable = true;
        Iterator it = ArraysKt.reversed(desiredArgsTypes).iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (!((AnyType) it.next()).getKType().isMarkedNullable()) {
                break;
            } else {
                i++;
            }
        }
        this.requiredArgumentsCount = i >= 0 ? this.desiredArgsTypes.length - i : 0;
    }

    protected final String getName() {
        return this.name;
    }

    protected final AnyType[] getDesiredArgsTypes() {
        return this.desiredArgsTypes;
    }

    public final void setCanTakeOwner(boolean z) {
        this.canTakeOwner = z;
    }

    public final KType getOwnerType() {
        return this.ownerType;
    }

    public final void setOwnerType(KType kType) {
        this.ownerType = kType;
    }

    public final boolean isEnumerable$expo_modules_core_release() {
        return this.isEnumerable;
    }

    public final boolean getTakesOwner$expo_modules_core_release() {
        KType kType;
        if (!this.canTakeOwner) {
            return false;
        }
        AnyType anyType = (AnyType) ArraysKt.firstOrNull(this.desiredArgsTypes);
        KClassifier classifier = (anyType == null || (kType = anyType.getKType()) == null) ? null : kType.getClassifier();
        KClass kClass = classifier instanceof KClass ? (KClass) classifier : null;
        if (kClass == null) {
            return false;
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(JavaScriptObject.class))) {
            return true;
        }
        KType kType2 = this.ownerType;
        KClassifier classifier2 = kType2 != null ? kType2.getClassifier() : null;
        KClass kClass2 = classifier2 instanceof KClass ? (KClass) classifier2 : null;
        if (kClass2 == null) {
            return false;
        }
        return Intrinsics.areEqual(kClass, kClass2);
    }

    public static /* synthetic */ Object[] convertArgs$default(AnyFunction anyFunction, Object[] objArr, AppContext appContext, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: convertArgs");
        }
        if ((i & 2) != 0) {
            appContext = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        return anyFunction.convertArgs(objArr, appContext, z);
    }

    protected final Object[] convertArgs(Object[] args, AppContext appContext, boolean z) throws InvalidArgsNumberException, ArgumentCastException {
        CodedException unexpectedException;
        CodedException codedException;
        Intrinsics.checkNotNullParameter(args, "args");
        if (this.requiredArgumentsCount <= args.length) {
            int length = args.length;
            AnyType[] anyTypeArr = this.desiredArgsTypes;
            if (length <= anyTypeArr.length) {
                Object[] objArr = anyTypeArr.length == args.length ? args : new Object[anyTypeArr.length];
                int length2 = args.length;
                for (int i = 0; i < length2; i++) {
                    Object obj = args[i];
                    AnyType anyType = this.desiredArgsTypes[i];
                    try {
                        objArr[i] = anyType.convert(obj, appContext, z);
                        Unit unit = Unit.INSTANCE;
                    } catch (Throwable th) {
                        if (th instanceof CodedException) {
                            codedException = (CodedException) th;
                        } else {
                            if (th instanceof expo.modules.core.errors.CodedException) {
                                expo.modules.core.errors.CodedException codedException2 = (expo.modules.core.errors.CodedException) th;
                                String code = codedException2.getCode();
                                Intrinsics.checkNotNullExpressionValue(code, "getCode(...)");
                                unexpectedException = new CodedException(code, codedException2.getMessage(), codedException2.getCause());
                            } else {
                                unexpectedException = new UnexpectedException(th);
                            }
                            codedException = unexpectedException;
                        }
                        throw new ArgumentCastException(anyType.getKType(), i, String.valueOf(obj != null ? obj.getClass() : null), codedException);
                    }
                }
                return objArr;
            }
        }
        throw new InvalidArgsNumberException(args.length, this.desiredArgsTypes.length, this.requiredArgumentsCount);
    }

    public final List getCppRequiredTypes$expo_modules_core_release() {
        AnyType[] anyTypeArr = this.desiredArgsTypes;
        ArrayList arrayList = new ArrayList(anyTypeArr.length);
        for (AnyType anyType : anyTypeArr) {
            arrayList.add(anyType.getCppRequiredTypes());
        }
        return arrayList;
    }

    public final AnyFunction enumerable(boolean z) {
        this.isEnumerable = z;
        return this;
    }
}
