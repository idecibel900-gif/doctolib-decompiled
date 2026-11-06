package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Density;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes.dex */
public abstract class WindowInsetsSizeKt {
    public static final Modifier windowInsetsTopHeight(Modifier modifier, final WindowInsets windowInsets) {
        return modifier.then(new DerivedHeightModifier(windowInsets, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1() { // from class: androidx.compose.foundation.layout.WindowInsetsSizeKt$windowInsetsTopHeight$$inlined$debugInspectorInfo$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("insetsTopHeight");
                inspectorInfo.getProperties().set("insets", windowInsets);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function2() { // from class: androidx.compose.foundation.layout.WindowInsetsSizeKt.windowInsetsTopHeight.2
            @Override // kotlin.jvm.functions.Function2
            public final Integer invoke(WindowInsets windowInsets2, Density density) {
                return Integer.valueOf(windowInsets2.getTop(density));
            }
        }));
    }

    public static final Modifier windowInsetsBottomHeight(Modifier modifier, final WindowInsets windowInsets) {
        return modifier.then(new DerivedHeightModifier(windowInsets, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1() { // from class: androidx.compose.foundation.layout.WindowInsetsSizeKt$windowInsetsBottomHeight$$inlined$debugInspectorInfo$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("insetsBottomHeight");
                inspectorInfo.getProperties().set("insets", windowInsets);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function2() { // from class: androidx.compose.foundation.layout.WindowInsetsSizeKt.windowInsetsBottomHeight.2
            @Override // kotlin.jvm.functions.Function2
            public final Integer invoke(WindowInsets windowInsets2, Density density) {
                return Integer.valueOf(windowInsets2.getBottom(density));
            }
        }));
    }
}
