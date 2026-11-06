package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public abstract class PaddingKt {
    /* JADX INFO: renamed from: padding-qDBjuR0, reason: not valid java name */
    public static final Modifier m313paddingqDBjuR0(Modifier modifier, final float f, final float f2, final float f3, final float f4) {
        return modifier.then(new PaddingElement(f, f2, f3, f4, true, new Function1() { // from class: androidx.compose.foundation.layout.PaddingKt.padding.1
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
                inspectorInfo.setName("padding");
                inspectorInfo.getProperties().set("start", Dp.m2549boximpl(f));
                inspectorInfo.getProperties().set("top", Dp.m2549boximpl(f2));
                inspectorInfo.getProperties().set("end", Dp.m2549boximpl(f3));
                inspectorInfo.getProperties().set("bottom", Dp.m2549boximpl(f4));
            }
        }, null));
    }

    /* JADX INFO: renamed from: padding-VpY3zN4, reason: not valid java name */
    public static final Modifier m311paddingVpY3zN4(Modifier modifier, final float f, final float f2) {
        return modifier.then(new PaddingElement(f, f2, f, f2, true, new Function1() { // from class: androidx.compose.foundation.layout.PaddingKt.padding.2
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
                inspectorInfo.setName("padding");
                inspectorInfo.getProperties().set("horizontal", Dp.m2549boximpl(f));
                inspectorInfo.getProperties().set("vertical", Dp.m2549boximpl(f2));
            }
        }, null));
    }

    /* JADX INFO: renamed from: padding-3ABfNKs, reason: not valid java name */
    public static final Modifier m310padding3ABfNKs(Modifier modifier, final float f) {
        return modifier.then(new PaddingElement(f, f, f, f, true, new Function1() { // from class: androidx.compose.foundation.layout.PaddingKt.padding.3
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
                inspectorInfo.setName("padding");
                inspectorInfo.setValue(Dp.m2549boximpl(f));
            }
        }, null));
    }

    public static final Modifier padding(Modifier modifier, final PaddingValues paddingValues) {
        return modifier.then(new PaddingValuesElement(paddingValues, new Function1() { // from class: androidx.compose.foundation.layout.PaddingKt.padding.4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("padding");
                inspectorInfo.getProperties().set("paddingValues", paddingValues);
            }
        }));
    }

    /* JADX INFO: renamed from: PaddingValues-YgX7TsA$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m307PaddingValuesYgX7TsA$default(float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.m2551constructorimpl(0);
        }
        if ((i & 2) != 0) {
            f2 = Dp.m2551constructorimpl(0);
        }
        return m306PaddingValuesYgX7TsA(f, f2);
    }

    /* JADX INFO: renamed from: PaddingValues-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m309PaddingValuesa9UjIt4$default(float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.m2551constructorimpl(0);
        }
        if ((i & 2) != 0) {
            f2 = Dp.m2551constructorimpl(0);
        }
        if ((i & 4) != 0) {
            f3 = Dp.m2551constructorimpl(0);
        }
        if ((i & 8) != 0) {
            f4 = Dp.m2551constructorimpl(0);
        }
        return m308PaddingValuesa9UjIt4(f, f2, f3, f4);
    }

    /* JADX INFO: renamed from: padding-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m312paddingVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.m2551constructorimpl(0);
        }
        if ((i & 2) != 0) {
            f2 = Dp.m2551constructorimpl(0);
        }
        return m311paddingVpY3zN4(modifier, f, f2);
    }

    /* JADX INFO: renamed from: padding-qDBjuR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m314paddingqDBjuR0$default(Modifier modifier, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.m2551constructorimpl(0);
        }
        if ((i & 2) != 0) {
            f2 = Dp.m2551constructorimpl(0);
        }
        if ((i & 4) != 0) {
            f3 = Dp.m2551constructorimpl(0);
        }
        if ((i & 8) != 0) {
            f4 = Dp.m2551constructorimpl(0);
        }
        return m313paddingqDBjuR0(modifier, f, f2, f3, f4);
    }

    public static final float calculateStartPadding(PaddingValues paddingValues, LayoutDirection layoutDirection) {
        if (layoutDirection == LayoutDirection.Ltr) {
            return paddingValues.mo295calculateLeftPaddingu2uoSUM(layoutDirection);
        }
        return paddingValues.mo296calculateRightPaddingu2uoSUM(layoutDirection);
    }

    public static final float calculateEndPadding(PaddingValues paddingValues, LayoutDirection layoutDirection) {
        if (layoutDirection == LayoutDirection.Ltr) {
            return paddingValues.mo296calculateRightPaddingu2uoSUM(layoutDirection);
        }
        return paddingValues.mo295calculateLeftPaddingu2uoSUM(layoutDirection);
    }

    /* JADX INFO: renamed from: PaddingValues-0680j_4, reason: not valid java name */
    public static final PaddingValues m305PaddingValues0680j_4(float f) {
        return new PaddingValuesImpl(f, f, f, f, null);
    }

    /* JADX INFO: renamed from: PaddingValues-YgX7TsA, reason: not valid java name */
    public static final PaddingValues m306PaddingValuesYgX7TsA(float f, float f2) {
        return new PaddingValuesImpl(f, f2, f, f2, null);
    }

    /* JADX INFO: renamed from: PaddingValues-a9UjIt4, reason: not valid java name */
    public static final PaddingValues m308PaddingValuesa9UjIt4(float f, float f2, float f3, float f4) {
        return new PaddingValuesImpl(f, f2, f3, f4, null);
    }
}
