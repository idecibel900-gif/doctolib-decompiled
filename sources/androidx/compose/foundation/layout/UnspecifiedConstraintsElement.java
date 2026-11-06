package androidx.compose.foundation.layout;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import com.opentok.android.PublisherKit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u000f\u001a\u00020\u000b*\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u001d\u0010\u0004\u001a\u00020\u00038\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0004\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u0005\u001a\u00020\u00038\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001c\u0010\u001b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/layout/UnspecifiedConstraintsElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/UnspecifiedConstraintsNode;", "Landroidx/compose/ui/unit/Dp;", "minWidth", "minHeight", "<init>", "(FFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "create", "()Landroidx/compose/foundation/layout/UnspecifiedConstraintsNode;", "node", "", "update", "(Landroidx/compose/foundation/layout/UnspecifiedConstraintsNode;)V", "Landroidx/compose/ui/platform/InspectorInfo;", "inspectableProperties", "(Landroidx/compose/ui/platform/InspectorInfo;)V", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "F", "getMinWidth-D9Ej5fM", "()F", "getMinHeight-D9Ej5fM", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class UnspecifiedConstraintsElement extends ModifierNodeElement {
    private final float minHeight;
    private final float minWidth;

    public /* synthetic */ UnspecifiedConstraintsElement(float f, float f2, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2);
    }

    private UnspecifiedConstraintsElement(float f, float f2) {
        this.minWidth = f;
        this.minHeight = f2;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: create */
    public UnspecifiedConstraintsNode getNode() {
        return new UnspecifiedConstraintsNode(this.minWidth, this.minHeight, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(UnspecifiedConstraintsNode node) {
        node.m346setMinWidth0680j_4(this.minWidth);
        node.m345setMinHeight0680j_4(this.minHeight);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.setName("defaultMinSize");
        inspectorInfo.getProperties().set("minWidth", Dp.m2549boximpl(this.minWidth));
        inspectorInfo.getProperties().set("minHeight", Dp.m2549boximpl(this.minHeight));
    }

    public boolean equals(Object other) {
        if (!(other instanceof UnspecifiedConstraintsElement)) {
            return false;
        }
        UnspecifiedConstraintsElement unspecifiedConstraintsElement = (UnspecifiedConstraintsElement) other;
        return Dp.m2553equalsimpl0(this.minWidth, unspecifiedConstraintsElement.minWidth) && Dp.m2553equalsimpl0(this.minHeight, unspecifiedConstraintsElement.minHeight);
    }

    public int hashCode() {
        return (Dp.m2554hashCodeimpl(this.minWidth) * 31) + Dp.m2554hashCodeimpl(this.minHeight);
    }
}
