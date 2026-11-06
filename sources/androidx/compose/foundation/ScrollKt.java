package androidx.compose.foundation;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes.dex */
public abstract class ScrollKt {
    public static final ScrollState rememberScrollState(final int i, Composer composer, int i2, int i3) {
        boolean z = true;
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1464256199, i2, -1, "androidx.compose.foundation.rememberScrollState (Scroll.kt:69)");
        }
        Object[] objArr = new Object[0];
        Saver saver = ScrollState.Companion.getSaver();
        if ((((i2 & 14) ^ 6) <= 4 || !composer.changed(i)) && (i2 & 6) != 4) {
            z = false;
        }
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new Function0() { // from class: androidx.compose.foundation.ScrollKt$rememberScrollState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final ScrollState invoke() {
                    return new ScrollState(i);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ScrollState scrollState = (ScrollState) RememberSaveableKt.rememberSaveable(objArr, saver, null, (Function0) objRememberedValue, composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return scrollState;
    }

    private static final Modifier scroll(Modifier modifier, ScrollState scrollState, boolean z, FlingBehavior flingBehavior, boolean z2, boolean z3) {
        final ScrollState scrollState2;
        final boolean z4;
        final FlingBehavior flingBehavior2;
        final boolean z5;
        final boolean z6;
        Function1 noInspectorInfo;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            scrollState2 = scrollState;
            z4 = z;
            flingBehavior2 = flingBehavior;
            z5 = z2;
            z6 = z3;
            noInspectorInfo = new Function1() { // from class: androidx.compose.foundation.ScrollKt$scroll$$inlined$debugInspectorInfo$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((InspectorInfo) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(InspectorInfo inspectorInfo) {
                    inspectorInfo.setName("scroll");
                    inspectorInfo.getProperties().set("state", scrollState2);
                    inspectorInfo.getProperties().set("reverseScrolling", Boolean.valueOf(z4));
                    inspectorInfo.getProperties().set("flingBehavior", flingBehavior2);
                    inspectorInfo.getProperties().set("isScrollable", Boolean.valueOf(z5));
                    inspectorInfo.getProperties().set("isVertical", Boolean.valueOf(z6));
                }
            };
        } else {
            scrollState2 = scrollState;
            z4 = z;
            flingBehavior2 = flingBehavior;
            z5 = z2;
            z6 = z3;
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        final boolean z7 = z6;
        final boolean z8 = z5;
        final FlingBehavior flingBehavior3 = flingBehavior2;
        final boolean z9 = z4;
        final ScrollState scrollState3 = scrollState2;
        return ComposedModifierKt.composed(modifier, noInspectorInfo, new Function3() { // from class: androidx.compose.foundation.ScrollKt.scroll.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }

            public final Modifier invoke(Modifier modifier2, Composer composer, int i) {
                composer.startReplaceGroup(1478351300);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1478351300, i, -1, "androidx.compose.foundation.scroll.<anonymous> (Scroll.kt:276)");
                }
                Modifier modifierThen = Modifier.Companion.then(new ScrollSemanticsElement(scrollState3, z9, flingBehavior3, z8, z7));
                ScrollState scrollState4 = scrollState3;
                Modifier modifierThen2 = ScrollingContainerKt.scrollingContainer(modifierThen, scrollState4, z7 ? Orientation.Vertical : Orientation.Horizontal, z8, z9, flingBehavior3, scrollState4.getInternalInteractionSource$foundation_release(), null, composer, 0, 64).then(new ScrollingLayoutElement(scrollState3, z9, z7));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return modifierThen2;
            }
        });
    }

    public static /* synthetic */ Modifier verticalScroll$default(Modifier modifier, ScrollState scrollState, boolean z, FlingBehavior flingBehavior, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            flingBehavior = null;
        }
        if ((i & 8) != 0) {
            z2 = false;
        }
        return verticalScroll(modifier, scrollState, z, flingBehavior, z2);
    }

    public static final Modifier verticalScroll(Modifier modifier, ScrollState scrollState, boolean z, FlingBehavior flingBehavior, boolean z2) {
        return scroll(modifier, scrollState, z2, flingBehavior, z, true);
    }

    public static /* synthetic */ Modifier horizontalScroll$default(Modifier modifier, ScrollState scrollState, boolean z, FlingBehavior flingBehavior, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            flingBehavior = null;
        }
        if ((i & 8) != 0) {
            z2 = false;
        }
        return horizontalScroll(modifier, scrollState, z, flingBehavior, z2);
    }

    public static final Modifier horizontalScroll(Modifier modifier, ScrollState scrollState, boolean z, FlingBehavior flingBehavior, boolean z2) {
        return scroll(modifier, scrollState, z2, flingBehavior, z, false);
    }
}
