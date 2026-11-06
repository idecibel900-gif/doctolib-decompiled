package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes.dex */
public abstract class ModifierNodeElement implements Modifier.Element {
    public static final int $stable = 0;
    private InspectorInfo _inspectorValues;

    public abstract Modifier.Node create();

    public abstract void inspectableProperties(InspectorInfo inspectorInfo);

    public abstract void update(Modifier.Node node);

    private final InspectorInfo getInspectorValues() {
        InspectorInfo inspectorInfo = this._inspectorValues;
        if (inspectorInfo != null) {
            return inspectorInfo;
        }
        InspectorInfo inspectorInfo2 = new InspectorInfo();
        inspectorInfo2.setName(Reflection.getOrCreateKotlinClass(getClass()).getSimpleName());
        inspectableProperties(inspectorInfo2);
        this._inspectorValues = inspectorInfo2;
        return inspectorInfo2;
    }

    public final String getNameFallback() {
        return getInspectorValues().getName();
    }

    public final Object getValueOverride() {
        return getInspectorValues().getValue();
    }

    public final Sequence getInspectableElements() {
        return getInspectorValues().getProperties();
    }
}
