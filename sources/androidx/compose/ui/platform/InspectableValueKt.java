package androidx.compose.ui.platform;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public abstract class InspectableValueKt {
    private static final Function1 NoInspectorInfo = new Function1() { // from class: androidx.compose.ui.platform.InspectableValueKt$NoInspectorInfo$1
        public final void invoke(InspectorInfo inspectorInfo) {
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((InspectorInfo) obj);
            return Unit.INSTANCE;
        }
    };
    private static boolean isDebugInspectorInfoEnabled;

    public static final Function1 getNoInspectorInfo() {
        return NoInspectorInfo;
    }

    public static final boolean isDebugInspectorInfoEnabled() {
        return isDebugInspectorInfoEnabled;
    }
}
