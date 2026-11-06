package androidx.compose.runtime;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class Updater {
    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static Composer m1086constructorimpl(Composer composer) {
        return composer;
    }

    /* JADX INFO: renamed from: set-impl, reason: not valid java name */
    public static final void m1088setimpl(Composer composer, Object obj, Function2 function2) {
        if (composer.getInserting() || !Intrinsics.areEqual(composer.rememberedValue(), obj)) {
            composer.updateRememberedValue(obj);
            composer.apply(obj, function2);
        }
    }

    /* JADX INFO: renamed from: init-impl, reason: not valid java name */
    public static final void m1087initimpl(Composer composer, final Function1 function1) {
        if (composer.getInserting()) {
            composer.apply(Unit.INSTANCE, new Function2() { // from class: androidx.compose.runtime.Updater$init$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke(obj, (Unit) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(Object obj, Unit unit) {
                    function1.invoke(obj);
                }
            });
        }
    }
}
