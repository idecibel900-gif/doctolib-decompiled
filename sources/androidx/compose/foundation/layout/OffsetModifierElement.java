package androidx.compose.foundation.layout;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import com.opentok.android.PublisherKit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: androidx.compose.foundation.layout.OffsetElement, reason: from toString */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B3\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\n*\u00020\tH\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u001d\u0010\u0004\u001a\u00020\u00038\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0004\u0010\u001f\u001a\u0004\b \u0010!R\u001d\u0010\u0005\u001a\u00020\u00038\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b\"\u0010!R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010#\u001a\u0004\b$\u0010%R#\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b8\u0006¢\u0006\f\n\u0004\b\u000b\u0010&\u001a\u0004\b'\u0010(\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006)"}, d2 = {"Landroidx/compose/foundation/layout/OffsetElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/OffsetNode;", "Landroidx/compose/ui/unit/Dp;", "x", "y", "", "rtlAware", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "inspectorInfo", "<init>", "(FFZLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "create", "()Landroidx/compose/foundation/layout/OffsetNode;", "node", "update", "(Landroidx/compose/foundation/layout/OffsetNode;)V", "", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "inspectableProperties", "(Landroidx/compose/ui/platform/InspectorInfo;)V", "F", "getX-D9Ej5fM", "()F", "getY-D9Ej5fM", "Z", "getRtlAware", "()Z", "Lkotlin/jvm/functions/Function1;", "getInspectorInfo", "()Lkotlin/jvm/functions/Function1;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class OffsetModifierElement extends ModifierNodeElement {
    private final Function1 inspectorInfo;
    private final boolean rtlAware;
    private final float x;
    private final float y;

    public /* synthetic */ OffsetModifierElement(float f, float f2, boolean z, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, z, function1);
    }

    private OffsetModifierElement(float f, float f2, boolean z, Function1 function1) {
        this.x = f;
        this.y = f2;
        this.rtlAware = z;
        this.inspectorInfo = function1;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: create */
    public OffsetNode getNode() {
        return new OffsetNode(this.x, this.y, this.rtlAware, null);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(OffsetNode node) {
        node.m303setX0680j_4(this.x);
        node.m304setY0680j_4(this.y);
        node.setRtlAware(this.rtlAware);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        OffsetModifierElement offsetModifierElement = other instanceof OffsetModifierElement ? (OffsetModifierElement) other : null;
        return offsetModifierElement != null && Dp.m2553equalsimpl0(this.x, offsetModifierElement.x) && Dp.m2553equalsimpl0(this.y, offsetModifierElement.y) && this.rtlAware == offsetModifierElement.rtlAware;
    }

    public int hashCode() {
        return (((Dp.m2554hashCodeimpl(this.x) * 31) + Dp.m2554hashCodeimpl(this.y)) * 31) + Boolean.hashCode(this.rtlAware);
    }

    public String toString() {
        return "OffsetModifierElement(x=" + ((Object) Dp.m2555toStringimpl(this.x)) + ", y=" + ((Object) Dp.m2555toStringimpl(this.y)) + ", rtlAware=" + this.rtlAware + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        this.inspectorInfo.invoke(inspectorInfo);
    }
}
