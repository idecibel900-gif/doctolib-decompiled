package expo.modules.kotlin.types;

import com.amazon.a.a.o.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u0001*\b\b\u0002\u0010\u0004*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005B+\u0012\u0006\u0010\u0006\u001a\u00020\u0001\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0013\u001a\u00028\u00022\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00020\u000fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lexpo/modules/kotlin/types/EitherOfThree;", "", "FirstType", "SecondType", "ThirdType", "Lexpo/modules/kotlin/types/Either;", "bareValue", "", "Lexpo/modules/kotlin/types/DeferredValue;", "deferredValue", "", "Lkotlin/reflect/KType;", "types", "<init>", "(Ljava/lang/Object;Ljava/util/List;Ljava/util/List;)V", "Lkotlin/reflect/KClass;", "type", "getThirdType", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", b.au, "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class EitherOfThree<FirstType, SecondType, ThirdType> extends Either<FirstType, SecondType> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EitherOfThree(Object bareValue, List deferredValue, List types) {
        super(bareValue, deferredValue, types);
        Intrinsics.checkNotNullParameter(bareValue, "bareValue");
        Intrinsics.checkNotNullParameter(deferredValue, "deferredValue");
        Intrinsics.checkNotNullParameter(types, "types");
    }

    public final Object getThirdType(KClass type) {
        Intrinsics.checkNotNullParameter(type, "type");
        Object obj = get$expo_modules_core_release(2);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type ThirdType of expo.modules.kotlin.types.EitherOfThree");
        return obj;
    }
}
