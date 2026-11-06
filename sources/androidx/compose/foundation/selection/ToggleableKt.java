package androidx.compose.foundation.selection;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.Role;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes.dex */
public abstract class ToggleableKt {
    /* JADX INFO: renamed from: toggleable-O2vRcR0, reason: not valid java name */
    public static final Modifier m452toggleableO2vRcR0(Modifier modifier, final boolean z, MutableInteractionSource mutableInteractionSource, final Indication indication, final boolean z2, final Role role, final Function1 function1) {
        Modifier modifierComposed$default;
        if (indication instanceof IndicationNodeFactory) {
            modifierComposed$default = new ToggleableElement(z, mutableInteractionSource, (IndicationNodeFactory) indication, z2, role, function1, null);
        } else if (indication == null) {
            modifierComposed$default = new ToggleableElement(z, mutableInteractionSource, null, z2, role, function1, null);
        } else if (mutableInteractionSource != null) {
            modifierComposed$default = IndicationKt.indication(Modifier.Companion, mutableInteractionSource, indication).then(new ToggleableElement(z, mutableInteractionSource, null, z2, role, function1, null));
        } else {
            modifierComposed$default = ComposedModifierKt.composed$default(Modifier.Companion, null, new Function3() { // from class: androidx.compose.foundation.selection.ToggleableKt$toggleable-O2vRcR0$$inlined$clickableWithIndicationIfNeeded$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
                }

                public final Modifier invoke(Modifier modifier2, Composer composer, int i) {
                    composer.startReplaceGroup(-1525724089);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1525724089, i, -1, "androidx.compose.foundation.clickableWithIndicationIfNeeded.<anonymous> (Clickable.kt:375)");
                    }
                    Object objRememberedValue = composer.rememberedValue();
                    if (objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    MutableInteractionSource mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
                    Modifier modifierThen = IndicationKt.indication(Modifier.Companion, mutableInteractionSource2, indication).then(new ToggleableElement(z, mutableInteractionSource2, null, z2, role, function1, null));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer.endReplaceGroup();
                    return modifierThen;
                }
            }, 1, null);
        }
        return modifier.then(modifierComposed$default);
    }
}
