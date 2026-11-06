package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import com.opentok.android.PublisherKit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\u0013\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J\f\u0010\u001a\u001a\u00020\u0018*\u00020\u001bH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/composables/ThumbElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/ThumbNode;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "checked", "", "(Landroidx/compose/foundation/interaction/InteractionSource;Z)V", "getChecked", "()Z", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "component1", "component2", "copy", "create", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final /* data */ class ThumbElement extends ModifierNodeElement {
    private final boolean checked;
    private final InteractionSource interactionSource;

    public static /* synthetic */ ThumbElement copy$default(ThumbElement thumbElement, InteractionSource interactionSource, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            interactionSource = thumbElement.interactionSource;
        }
        if ((i & 2) != 0) {
            z = thumbElement.checked;
        }
        return thumbElement.copy(interactionSource, z);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* bridge */ /* synthetic */ boolean all(Function1 function1) {
        return super.all(function1);
    }

    @Override // androidx.compose.ui.Modifier.Element
    public /* bridge */ /* synthetic */ boolean any(Function1 function1) {
        return super.any(function1);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final InteractionSource getInteractionSource() {
        return this.interactionSource;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getChecked() {
        return this.checked;
    }

    public final ThumbElement copy(InteractionSource interactionSource, boolean checked) {
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        return new ThumbElement(interactionSource, checked);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThumbElement)) {
            return false;
        }
        ThumbElement thumbElement = (ThumbElement) other;
        return Intrinsics.areEqual(this.interactionSource, thumbElement.interactionSource) && this.checked == thumbElement.checked;
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* bridge */ /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return super.foldIn(obj, function2);
    }

    @Override // androidx.compose.ui.Modifier.Element
    public /* bridge */ /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return super.foldOut(obj, function2);
    }

    public int hashCode() {
        return (this.interactionSource.hashCode() * 31) + Boolean.hashCode(this.checked);
    }

    @Override // androidx.compose.ui.Modifier
    public /* bridge */ /* synthetic */ Modifier then(Modifier modifier) {
        return super.then(modifier);
    }

    public String toString() {
        return "ThumbElement(interactionSource=" + this.interactionSource + ", checked=" + this.checked + ')';
    }

    public final InteractionSource getInteractionSource() {
        return this.interactionSource;
    }

    public final boolean getChecked() {
        return this.checked;
    }

    public ThumbElement(InteractionSource interactionSource, boolean z) {
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        this.interactionSource = interactionSource;
        this.checked = z;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: create */
    public ThumbNode getNode() {
        return new ThumbNode(this.interactionSource, this.checked);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(ThumbNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        node.setInteractionSource(this.interactionSource);
        if (node.getChecked() != this.checked) {
            LayoutModifierNodeKt.invalidateMeasurement(node);
        }
        node.setChecked(this.checked);
        node.update();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "<this>");
        inspectorInfo.setName("switchThumb");
        inspectorInfo.getProperties().set("interactionSource", this.interactionSource);
        inspectorInfo.getProperties().set("checked", Boolean.valueOf(this.checked));
    }
}
