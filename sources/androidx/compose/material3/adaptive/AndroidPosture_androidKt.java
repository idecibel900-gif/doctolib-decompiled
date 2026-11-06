package androidx.compose.material3.adaptive;

import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.window.layout.FoldingFeature;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class AndroidPosture_androidKt {
    public static final Posture calculatePosture(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        boolean z = false;
        while (it.hasNext()) {
            FoldingFeature foldingFeature = (FoldingFeature) it.next();
            if (Intrinsics.areEqual(foldingFeature.getOrientation(), FoldingFeature.Orientation.HORIZONTAL) && Intrinsics.areEqual(foldingFeature.getState(), FoldingFeature.State.HALF_OPENED)) {
                z = true;
            }
            arrayList.add(new HingeInfo(RectHelper_androidKt.toComposeRect(foldingFeature.getBounds()), Intrinsics.areEqual(foldingFeature.getState(), FoldingFeature.State.FLAT), Intrinsics.areEqual(foldingFeature.getOrientation(), FoldingFeature.Orientation.VERTICAL), foldingFeature.isSeparating(), Intrinsics.areEqual(foldingFeature.getOcclusionType(), FoldingFeature.OcclusionType.FULL)));
        }
        return new Posture(z, arrayList);
    }
}
