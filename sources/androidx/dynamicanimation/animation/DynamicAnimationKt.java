package androidx.dynamicanimation.animation;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public abstract class DynamicAnimationKt {
    public static final SpringAnimation springAnimationOf(Function1 function1, Function0 function0, float f) {
        FloatValueHolder floatValueHolderCreateFloatValueHolder = createFloatValueHolder(function1, function0);
        if (Float.isNaN(f)) {
            return new SpringAnimation(floatValueHolderCreateFloatValueHolder);
        }
        return new SpringAnimation(floatValueHolderCreateFloatValueHolder, f);
    }

    private static final FloatValueHolder createFloatValueHolder(final Function1 function1, final Function0 function0) {
        return new FloatValueHolder() { // from class: androidx.dynamicanimation.animation.DynamicAnimationKt.createFloatValueHolder.1
            @Override // androidx.dynamicanimation.animation.FloatValueHolder
            public float getValue() {
                return ((Number) function0.invoke()).floatValue();
            }

            @Override // androidx.dynamicanimation.animation.FloatValueHolder
            public void setValue(float f) {
                function1.invoke(Float.valueOf(f));
            }
        };
    }
}
