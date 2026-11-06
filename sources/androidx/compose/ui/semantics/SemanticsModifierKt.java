package androidx.compose.ui.semantics;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ValueElementSequence;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class SemanticsModifierKt {
    private static AtomicInteger lastIdentifier = new AtomicInteger(0);

    public static final int generateSemanticsId() {
        return lastIdentifier.addAndGet(1);
    }

    public static /* synthetic */ Modifier semantics$default(Modifier modifier, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return semantics(modifier, z, function1);
    }

    public static final Modifier semantics(Modifier modifier, boolean z, Function1 function1) {
        return modifier.then(new AppendedSemanticsElement(z, function1));
    }

    public static final Modifier clearAndSetSemantics(Modifier modifier, Function1 function1) {
        return modifier.then(new ClearAndSetSemanticsElement(function1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addSemanticsPropertiesFrom(InspectorInfo inspectorInfo, SemanticsConfiguration semanticsConfiguration) {
        ValueElementSequence properties = inspectorInfo.getProperties();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(semanticsConfiguration, 10)), 16));
        Iterator it = semanticsConfiguration.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            SemanticsPropertyKey semanticsPropertyKey = (SemanticsPropertyKey) entry.getKey();
            Pair pair = TuplesKt.to(semanticsPropertyKey.getName(), entry.getValue());
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        properties.set(DiagnosticsEntry.PROPERTIES_KEY, linkedHashMap);
    }
}
