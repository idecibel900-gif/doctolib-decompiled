package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import com.opentok.android.PublisherKit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0012\u001a\u00020\u000e*\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010%\u001a\u0004\b&\u0010'¨\u0006("}, d2 = {"Landroidx/compose/foundation/text/input/internal/LegacyAdaptingPlatformTextInputModifier;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/text/input/internal/LegacyAdaptingPlatformTextInputModifierNode;", "Landroidx/compose/foundation/text/input/internal/LegacyPlatformTextInputServiceAdapter;", "serviceAdapter", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "legacyTextFieldState", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "textFieldSelectionManager", "<init>", "(Landroidx/compose/foundation/text/input/internal/LegacyPlatformTextInputServiceAdapter;Landroidx/compose/foundation/text/LegacyTextFieldState;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;)V", "create", "()Landroidx/compose/foundation/text/input/internal/LegacyAdaptingPlatformTextInputModifierNode;", "node", "", "update", "(Landroidx/compose/foundation/text/input/internal/LegacyAdaptingPlatformTextInputModifierNode;)V", "Landroidx/compose/ui/platform/InspectorInfo;", "inspectableProperties", "(Landroidx/compose/ui/platform/InspectorInfo;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "(Ljava/lang/Object;)Z", "Landroidx/compose/foundation/text/input/internal/LegacyPlatformTextInputServiceAdapter;", "getServiceAdapter", "()Landroidx/compose/foundation/text/input/internal/LegacyPlatformTextInputServiceAdapter;", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "getLegacyTextFieldState", "()Landroidx/compose/foundation/text/LegacyTextFieldState;", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "getTextFieldSelectionManager", "()Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final /* data */ class LegacyAdaptingPlatformTextInputModifier extends ModifierNodeElement {
    private final LegacyTextFieldState legacyTextFieldState;
    private final LegacyPlatformTextInputServiceAdapter serviceAdapter;
    private final TextFieldSelectionManager textFieldSelectionManager;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LegacyAdaptingPlatformTextInputModifier)) {
            return false;
        }
        LegacyAdaptingPlatformTextInputModifier legacyAdaptingPlatformTextInputModifier = (LegacyAdaptingPlatformTextInputModifier) other;
        return Intrinsics.areEqual(this.serviceAdapter, legacyAdaptingPlatformTextInputModifier.serviceAdapter) && Intrinsics.areEqual(this.legacyTextFieldState, legacyAdaptingPlatformTextInputModifier.legacyTextFieldState) && Intrinsics.areEqual(this.textFieldSelectionManager, legacyAdaptingPlatformTextInputModifier.textFieldSelectionManager);
    }

    public int hashCode() {
        return (((this.serviceAdapter.hashCode() * 31) + this.legacyTextFieldState.hashCode()) * 31) + this.textFieldSelectionManager.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
    }

    public String toString() {
        return "LegacyAdaptingPlatformTextInputModifier(serviceAdapter=" + this.serviceAdapter + ", legacyTextFieldState=" + this.legacyTextFieldState + ", textFieldSelectionManager=" + this.textFieldSelectionManager + ')';
    }

    public LegacyAdaptingPlatformTextInputModifier(LegacyPlatformTextInputServiceAdapter legacyPlatformTextInputServiceAdapter, LegacyTextFieldState legacyTextFieldState, TextFieldSelectionManager textFieldSelectionManager) {
        this.serviceAdapter = legacyPlatformTextInputServiceAdapter;
        this.legacyTextFieldState = legacyTextFieldState;
        this.textFieldSelectionManager = textFieldSelectionManager;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: create */
    public LegacyAdaptingPlatformTextInputModifierNode getNode() {
        return new LegacyAdaptingPlatformTextInputModifierNode(this.serviceAdapter, this.legacyTextFieldState, this.textFieldSelectionManager);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(LegacyAdaptingPlatformTextInputModifierNode node) {
        node.setServiceAdapter(this.serviceAdapter);
        node.setLegacyTextFieldState(this.legacyTextFieldState);
        node.setTextFieldSelectionManager(this.textFieldSelectionManager);
    }
}
