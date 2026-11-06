package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class SizeKt {
    private static final FillElement FillWholeMaxHeight;
    private static final FillElement FillWholeMaxSize;
    private static final FillElement FillWholeMaxWidth;
    private static final WrapContentElement WrapContentHeightCenter;
    private static final WrapContentElement WrapContentHeightTop;
    private static final WrapContentElement WrapContentSizeCenter;
    private static final WrapContentElement WrapContentSizeTopStart;
    private static final WrapContentElement WrapContentWidthCenter;
    private static final WrapContentElement WrapContentWidthStart;

    /* JADX INFO: renamed from: width-3ABfNKs, reason: not valid java name */
    public static final Modifier m337width3ABfNKs(Modifier modifier, final float f) {
        return modifier.then(new SizeElement(f, 0.0f, f, 0.0f, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1() { // from class: androidx.compose.foundation.layout.SizeKt$width-3ABfNKs$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("width");
                inspectorInfo.setValue(Dp.m2549boximpl(f));
            }
        } : InspectableValueKt.getNoInspectorInfo(), 10, null));
    }

    /* JADX INFO: renamed from: height-3ABfNKs, reason: not valid java name */
    public static final Modifier m324height3ABfNKs(Modifier modifier, final float f) {
        return modifier.then(new SizeElement(0.0f, f, 0.0f, f, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1() { // from class: androidx.compose.foundation.layout.SizeKt$height-3ABfNKs$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("height");
                inspectorInfo.setValue(Dp.m2549boximpl(f));
            }
        } : InspectableValueKt.getNoInspectorInfo(), 5, null));
    }

    /* JADX INFO: renamed from: requiredSize-3ABfNKs, reason: not valid java name */
    public static final Modifier m328requiredSize3ABfNKs(Modifier modifier, final float f) {
        return modifier.then(new SizeElement(f, f, f, f, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1() { // from class: androidx.compose.foundation.layout.SizeKt$requiredSize-3ABfNKs$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("requiredSize");
                inspectorInfo.setValue(Dp.m2549boximpl(f));
            }
        } : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* JADX INFO: renamed from: requiredSize-VpY3zN4, reason: not valid java name */
    public static final Modifier m329requiredSizeVpY3zN4(Modifier modifier, final float f, final float f2) {
        return modifier.then(new SizeElement(f, f2, f, f2, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1() { // from class: androidx.compose.foundation.layout.SizeKt$requiredSize-VpY3zN4$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("requiredSize");
                inspectorInfo.getProperties().set("width", Dp.m2549boximpl(f));
                inspectorInfo.getProperties().set("height", Dp.m2549boximpl(f2));
            }
        } : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* JADX INFO: renamed from: size-3ABfNKs, reason: not valid java name */
    public static final Modifier m333size3ABfNKs(Modifier modifier, final float f) {
        return modifier.then(new SizeElement(f, f, f, f, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1() { // from class: androidx.compose.foundation.layout.SizeKt$size-3ABfNKs$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("size");
                inspectorInfo.setValue(Dp.m2549boximpl(f));
            }
        } : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* JADX INFO: renamed from: size-VpY3zN4, reason: not valid java name */
    public static final Modifier m334sizeVpY3zN4(Modifier modifier, final float f, final float f2) {
        return modifier.then(new SizeElement(f, f2, f, f2, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1() { // from class: androidx.compose.foundation.layout.SizeKt$size-VpY3zN4$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("size");
                inspectorInfo.getProperties().set("width", Dp.m2549boximpl(f));
                inspectorInfo.getProperties().set("height", Dp.m2549boximpl(f2));
            }
        } : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* JADX INFO: renamed from: widthIn-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m339widthInVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.Companion.m2560getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = Dp.Companion.m2560getUnspecifiedD9Ej5fM();
        }
        return m338widthInVpY3zN4(modifier, f, f2);
    }

    /* JADX INFO: renamed from: widthIn-VpY3zN4, reason: not valid java name */
    public static final Modifier m338widthInVpY3zN4(Modifier modifier, final float f, final float f2) {
        return modifier.then(new SizeElement(f, 0.0f, f2, 0.0f, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1() { // from class: androidx.compose.foundation.layout.SizeKt$widthIn-VpY3zN4$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("widthIn");
                inspectorInfo.getProperties().set("min", Dp.m2549boximpl(f));
                inspectorInfo.getProperties().set("max", Dp.m2549boximpl(f2));
            }
        } : InspectableValueKt.getNoInspectorInfo(), 10, null));
    }

    /* JADX INFO: renamed from: heightIn-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m326heightInVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.Companion.m2560getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = Dp.Companion.m2560getUnspecifiedD9Ej5fM();
        }
        return m325heightInVpY3zN4(modifier, f, f2);
    }

    /* JADX INFO: renamed from: heightIn-VpY3zN4, reason: not valid java name */
    public static final Modifier m325heightInVpY3zN4(Modifier modifier, final float f, final float f2) {
        return modifier.then(new SizeElement(0.0f, f, 0.0f, f2, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1() { // from class: androidx.compose.foundation.layout.SizeKt$heightIn-VpY3zN4$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("heightIn");
                inspectorInfo.getProperties().set("min", Dp.m2549boximpl(f));
                inspectorInfo.getProperties().set("max", Dp.m2549boximpl(f2));
            }
        } : InspectableValueKt.getNoInspectorInfo(), 5, null));
    }

    /* JADX INFO: renamed from: sizeIn-qDBjuR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m336sizeInqDBjuR0$default(Modifier modifier, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.Companion.m2560getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = Dp.Companion.m2560getUnspecifiedD9Ej5fM();
        }
        if ((i & 4) != 0) {
            f3 = Dp.Companion.m2560getUnspecifiedD9Ej5fM();
        }
        if ((i & 8) != 0) {
            f4 = Dp.Companion.m2560getUnspecifiedD9Ej5fM();
        }
        return m335sizeInqDBjuR0(modifier, f, f2, f3, f4);
    }

    /* JADX INFO: renamed from: sizeIn-qDBjuR0, reason: not valid java name */
    public static final Modifier m335sizeInqDBjuR0(Modifier modifier, final float f, final float f2, final float f3, final float f4) {
        return modifier.then(new SizeElement(f, f2, f3, f4, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1() { // from class: androidx.compose.foundation.layout.SizeKt$sizeIn-qDBjuR0$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("sizeIn");
                inspectorInfo.getProperties().set("minWidth", Dp.m2549boximpl(f));
                inspectorInfo.getProperties().set("minHeight", Dp.m2549boximpl(f2));
                inspectorInfo.getProperties().set("maxWidth", Dp.m2549boximpl(f3));
                inspectorInfo.getProperties().set("maxHeight", Dp.m2549boximpl(f4));
            }
        } : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* JADX INFO: renamed from: requiredWidth-3ABfNKs, reason: not valid java name */
    public static final Modifier m332requiredWidth3ABfNKs(Modifier modifier, final float f) {
        return modifier.then(new SizeElement(f, 0.0f, f, 0.0f, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1() { // from class: androidx.compose.foundation.layout.SizeKt$requiredWidth-3ABfNKs$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("requiredWidth");
                inspectorInfo.setValue(Dp.m2549boximpl(f));
            }
        } : InspectableValueKt.getNoInspectorInfo(), 10, null));
    }

    /* JADX INFO: renamed from: requiredHeight-3ABfNKs, reason: not valid java name */
    public static final Modifier m327requiredHeight3ABfNKs(Modifier modifier, final float f) {
        return modifier.then(new SizeElement(0.0f, f, 0.0f, f, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1() { // from class: androidx.compose.foundation.layout.SizeKt$requiredHeight-3ABfNKs$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("requiredHeight");
                inspectorInfo.setValue(Dp.m2549boximpl(f));
            }
        } : InspectableValueKt.getNoInspectorInfo(), 5, null));
    }

    /* JADX INFO: renamed from: requiredSizeIn-qDBjuR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m331requiredSizeInqDBjuR0$default(Modifier modifier, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.Companion.m2560getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = Dp.Companion.m2560getUnspecifiedD9Ej5fM();
        }
        if ((i & 4) != 0) {
            f3 = Dp.Companion.m2560getUnspecifiedD9Ej5fM();
        }
        if ((i & 8) != 0) {
            f4 = Dp.Companion.m2560getUnspecifiedD9Ej5fM();
        }
        return m330requiredSizeInqDBjuR0(modifier, f, f2, f3, f4);
    }

    /* JADX INFO: renamed from: requiredSizeIn-qDBjuR0, reason: not valid java name */
    public static final Modifier m330requiredSizeInqDBjuR0(Modifier modifier, final float f, final float f2, final float f3, final float f4) {
        return modifier.then(new SizeElement(f, f2, f3, f4, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1() { // from class: androidx.compose.foundation.layout.SizeKt$requiredSizeIn-qDBjuR0$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("requiredSizeIn");
                inspectorInfo.getProperties().set("minWidth", Dp.m2549boximpl(f));
                inspectorInfo.getProperties().set("minHeight", Dp.m2549boximpl(f2));
                inspectorInfo.getProperties().set("maxWidth", Dp.m2549boximpl(f3));
                inspectorInfo.getProperties().set("maxHeight", Dp.m2549boximpl(f4));
            }
        } : InspectableValueKt.getNoInspectorInfo(), null));
    }

    public static /* synthetic */ Modifier fillMaxWidth$default(Modifier modifier, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        return fillMaxWidth(modifier, f);
    }

    public static final Modifier fillMaxWidth(Modifier modifier, float f) {
        return modifier.then(f == 1.0f ? FillWholeMaxWidth : FillElement.INSTANCE.width(f));
    }

    static {
        FillElement.Companion companion = FillElement.INSTANCE;
        FillWholeMaxWidth = companion.width(1.0f);
        FillWholeMaxHeight = companion.height(1.0f);
        FillWholeMaxSize = companion.size(1.0f);
        WrapContentElement.Companion companion2 = WrapContentElement.INSTANCE;
        Alignment.Companion companion3 = Alignment.Companion;
        WrapContentWidthCenter = companion2.width(companion3.getCenterHorizontally(), false);
        WrapContentWidthStart = companion2.width(companion3.getStart(), false);
        WrapContentHeightCenter = companion2.height(companion3.getCenterVertically(), false);
        WrapContentHeightTop = companion2.height(companion3.getTop(), false);
        WrapContentSizeCenter = companion2.size(companion3.getCenter(), false);
        WrapContentSizeTopStart = companion2.size(companion3.getTopStart(), false);
    }

    public static /* synthetic */ Modifier fillMaxHeight$default(Modifier modifier, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        return fillMaxHeight(modifier, f);
    }

    public static final Modifier fillMaxHeight(Modifier modifier, float f) {
        return modifier.then(f == 1.0f ? FillWholeMaxHeight : FillElement.INSTANCE.height(f));
    }

    public static /* synthetic */ Modifier fillMaxSize$default(Modifier modifier, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        return fillMaxSize(modifier, f);
    }

    public static final Modifier fillMaxSize(Modifier modifier, float f) {
        return modifier.then(f == 1.0f ? FillWholeMaxSize : FillElement.INSTANCE.size(f));
    }

    public static /* synthetic */ Modifier wrapContentWidth$default(Modifier modifier, Alignment.Horizontal horizontal, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            horizontal = Alignment.Companion.getCenterHorizontally();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return wrapContentWidth(modifier, horizontal, z);
    }

    public static final Modifier wrapContentWidth(Modifier modifier, Alignment.Horizontal horizontal, boolean z) {
        WrapContentElement wrapContentElementWidth;
        Alignment.Companion companion = Alignment.Companion;
        if (Intrinsics.areEqual(horizontal, companion.getCenterHorizontally()) && !z) {
            wrapContentElementWidth = WrapContentWidthCenter;
        } else if (Intrinsics.areEqual(horizontal, companion.getStart()) && !z) {
            wrapContentElementWidth = WrapContentWidthStart;
        } else {
            wrapContentElementWidth = WrapContentElement.INSTANCE.width(horizontal, z);
        }
        return modifier.then(wrapContentElementWidth);
    }

    public static /* synthetic */ Modifier wrapContentHeight$default(Modifier modifier, Alignment.Vertical vertical, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            vertical = Alignment.Companion.getCenterVertically();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return wrapContentHeight(modifier, vertical, z);
    }

    public static final Modifier wrapContentHeight(Modifier modifier, Alignment.Vertical vertical, boolean z) {
        WrapContentElement wrapContentElementHeight;
        Alignment.Companion companion = Alignment.Companion;
        if (Intrinsics.areEqual(vertical, companion.getCenterVertically()) && !z) {
            wrapContentElementHeight = WrapContentHeightCenter;
        } else if (Intrinsics.areEqual(vertical, companion.getTop()) && !z) {
            wrapContentElementHeight = WrapContentHeightTop;
        } else {
            wrapContentElementHeight = WrapContentElement.INSTANCE.height(vertical, z);
        }
        return modifier.then(wrapContentElementHeight);
    }

    public static /* synthetic */ Modifier wrapContentSize$default(Modifier modifier, Alignment alignment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            alignment = Alignment.Companion.getCenter();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return wrapContentSize(modifier, alignment, z);
    }

    public static final Modifier wrapContentSize(Modifier modifier, Alignment alignment, boolean z) {
        WrapContentElement size;
        Alignment.Companion companion = Alignment.Companion;
        if (Intrinsics.areEqual(alignment, companion.getCenter()) && !z) {
            size = WrapContentSizeCenter;
        } else if (Intrinsics.areEqual(alignment, companion.getTopStart()) && !z) {
            size = WrapContentSizeTopStart;
        } else {
            size = WrapContentElement.INSTANCE.size(alignment, z);
        }
        return modifier.then(size);
    }

    /* JADX INFO: renamed from: defaultMinSize-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m323defaultMinSizeVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.Companion.m2560getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = Dp.Companion.m2560getUnspecifiedD9Ej5fM();
        }
        return m322defaultMinSizeVpY3zN4(modifier, f, f2);
    }

    /* JADX INFO: renamed from: defaultMinSize-VpY3zN4, reason: not valid java name */
    public static final Modifier m322defaultMinSizeVpY3zN4(Modifier modifier, float f, float f2) {
        return modifier.then(new UnspecifiedConstraintsElement(f, f2, null));
    }
}
