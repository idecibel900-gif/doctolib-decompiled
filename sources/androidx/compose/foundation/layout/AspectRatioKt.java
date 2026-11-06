package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public abstract class AspectRatioKt {
    public static /* synthetic */ Modifier aspectRatio$default(Modifier modifier, float f, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return aspectRatio(modifier, f, z);
    }

    public static final Modifier aspectRatio(Modifier modifier, final float f, final boolean z) {
        return modifier.then(new AspectRatioElement(f, z, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1() { // from class: androidx.compose.foundation.layout.AspectRatioKt$aspectRatio$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("aspectRatio");
                inspectorInfo.getProperties().set("ratio", Float.valueOf(f));
                inspectorInfo.getProperties().set("matchHeightConstraintsFirst", Boolean.valueOf(z));
            }
        } : InspectableValueKt.getNoInspectorInfo()));
    }
}
