package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import com.amazon.device.iap.internal.c.b;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public abstract class OffsetKt {
    /* JADX INFO: renamed from: offset-VpY3zN4, reason: not valid java name */
    public static final Modifier m299offsetVpY3zN4(Modifier modifier, final float f, final float f2) {
        return modifier.then(new OffsetModifierElement(f, f2, true, new Function1() { // from class: androidx.compose.foundation.layout.OffsetKt$offset$1
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
                inspectorInfo.setName(b.as);
                inspectorInfo.getProperties().set("x", Dp.m2549boximpl(f));
                inspectorInfo.getProperties().set("y", Dp.m2549boximpl(f2));
            }
        }, null));
    }

    /* JADX INFO: renamed from: offset-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m300offsetVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.m2551constructorimpl(0);
        }
        if ((i & 2) != 0) {
            f2 = Dp.m2551constructorimpl(0);
        }
        return m299offsetVpY3zN4(modifier, f, f2);
    }
}
