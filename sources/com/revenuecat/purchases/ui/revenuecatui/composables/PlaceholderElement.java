package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import com.opentok.android.PublisherKit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\f\u0010\u0017\u001a\u00020\u0015*\u00020\u0018H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0019"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/composables/PlaceholderElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/PlaceholderNode;", "placeholder", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/Placeholder;", "(Lcom/revenuecat/purchases/ui/revenuecatui/composables/Placeholder;)V", "getPlaceholder", "()Lcom/revenuecat/purchases/ui/revenuecatui/composables/Placeholder;", "setPlaceholder", "component1", "copy", "create", "equals", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final /* data */ class PlaceholderElement extends ModifierNodeElement {
    private Placeholder placeholder;

    public static /* synthetic */ PlaceholderElement copy$default(PlaceholderElement placeholderElement, Placeholder placeholder, int i, Object obj) {
        if ((i & 1) != 0) {
            placeholder = placeholderElement.placeholder;
        }
        return placeholderElement.copy(placeholder);
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
    public final Placeholder getPlaceholder() {
        return this.placeholder;
    }

    public final PlaceholderElement copy(Placeholder placeholder) {
        Intrinsics.checkNotNullParameter(placeholder, "placeholder");
        return new PlaceholderElement(placeholder);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PlaceholderElement) && Intrinsics.areEqual(this.placeholder, ((PlaceholderElement) other).placeholder);
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
        return this.placeholder.hashCode();
    }

    @Override // androidx.compose.ui.Modifier
    public /* bridge */ /* synthetic */ Modifier then(Modifier modifier) {
        return super.then(modifier);
    }

    public String toString() {
        return "PlaceholderElement(placeholder=" + this.placeholder + ')';
    }

    public final Placeholder getPlaceholder() {
        return this.placeholder;
    }

    public final void setPlaceholder(Placeholder placeholder) {
        Intrinsics.checkNotNullParameter(placeholder, "<set-?>");
        this.placeholder = placeholder;
    }

    public PlaceholderElement(Placeholder placeholder) {
        Intrinsics.checkNotNullParameter(placeholder, "placeholder");
        this.placeholder = placeholder;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: create */
    public PlaceholderNode getNode() {
        return new PlaceholderNode(this.placeholder);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(PlaceholderNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        node.setPlaceholder(this.placeholder);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "<this>");
        inspectorInfo.setName("placeholder");
        inspectorInfo.getProperties().set("placeholder", this.placeholder);
        inspectorInfo.getProperties().set("loadingDescription", "Loading..");
    }
}
