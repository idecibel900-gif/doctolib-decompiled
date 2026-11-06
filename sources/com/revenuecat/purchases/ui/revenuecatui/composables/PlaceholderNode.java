package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.node.DrawModifierNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\f\u0010\t\u001a\u00020\n*\u00020\u000bH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\f"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/composables/PlaceholderNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "placeholder", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/Placeholder;", "(Lcom/revenuecat/purchases/ui/revenuecatui/composables/Placeholder;)V", "getPlaceholder", "()Lcom/revenuecat/purchases/ui/revenuecatui/composables/Placeholder;", "setPlaceholder", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class PlaceholderNode extends Modifier.Node implements DrawModifierNode {
    private Placeholder placeholder;

    @Override // androidx.compose.ui.node.DrawModifierNode
    public /* bridge */ /* synthetic */ void onMeasureResultChanged() {
        super.onMeasureResultChanged();
    }

    public final Placeholder getPlaceholder() {
        return this.placeholder;
    }

    public final void setPlaceholder(Placeholder placeholder) {
        Intrinsics.checkNotNullParameter(placeholder, "<set-?>");
        this.placeholder = placeholder;
    }

    public PlaceholderNode(Placeholder placeholder) {
        Intrinsics.checkNotNullParameter(placeholder, "placeholder");
        this.placeholder = placeholder;
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        this.placeholder.draw$revenuecatui_defaultsBc8Release(contentDrawScope);
    }
}
