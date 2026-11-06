package expo.modules.kotlin.objects;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public class ConstantComponentBuilder {
    private Function0 getter;
    private final String name;

    public ConstantComponentBuilder(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
    }

    public final void setGetter(Function0 function0) {
        this.getter = function0;
    }

    public final ConstantComponent build() {
        String str = this.name;
        Function0 function0 = this.getter;
        if (function0 != null) {
            return new ConstantComponent(str, function0);
        }
        throw new IllegalArgumentException(("The constant '" + str + "' doesn't have getter.").toString());
    }
}
