package androidx.compose.foundation.selection;

import androidx.compose.foundation.ClickableNode;
import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
final class SelectableNode extends ClickableNode {
    private boolean selected;

    public /* synthetic */ SelectableNode(boolean z, MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z2, Role role, Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, mutableInteractionSource, indicationNodeFactory, z2, role, function0);
    }

    private SelectableNode(boolean z, MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z2, Role role, Function0 function0) {
        super(mutableInteractionSource, indicationNodeFactory, z2, null, role, function0, null);
        this.selected = z;
    }

    /* JADX INFO: renamed from: update-QzZPfjk, reason: not valid java name */
    public final void m451updateQzZPfjk(boolean z, MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z2, Role role, Function0 function0) {
        if (this.selected != z) {
            this.selected = z;
            SemanticsModifierNodeKt.invalidateSemantics(this);
        }
        super.m139updateQzZPfjk(mutableInteractionSource, indicationNodeFactory, z2, (String) null, role, function0);
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    public void applyAdditionalSemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setSelected(semanticsPropertyReceiver, this.selected);
    }
}
