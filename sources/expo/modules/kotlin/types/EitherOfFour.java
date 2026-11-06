package expo.modules.kotlin.types;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u0001*\b\b\u0002\u0010\u0004*\u00020\u0001*\b\b\u0003\u0010\u0005*\u00020\u00012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0006B+\u0012\u0006\u0010\u0007\u001a\u00020\u0001\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lexpo/modules/kotlin/types/EitherOfFour;", "", "FirstType", "SecondType", "ThirdType", "FourthType", "Lexpo/modules/kotlin/types/EitherOfThree;", "bareValue", "", "Lexpo/modules/kotlin/types/DeferredValue;", "deferredValue", "", "Lkotlin/reflect/KType;", "types", "<init>", "(Ljava/lang/Object;Ljava/util/List;Ljava/util/List;)V", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EitherOfFour<FirstType, SecondType, ThirdType, FourthType> extends EitherOfThree<FirstType, SecondType, ThirdType> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EitherOfFour(Object bareValue, List deferredValue, List types) {
        super(bareValue, deferredValue, types);
        Intrinsics.checkNotNullParameter(bareValue, "bareValue");
        Intrinsics.checkNotNullParameter(deferredValue, "deferredValue");
        Intrinsics.checkNotNullParameter(types, "types");
    }
}
