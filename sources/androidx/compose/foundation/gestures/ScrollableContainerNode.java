package androidx.compose.foundation.gestures;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.TraversableNode;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class ScrollableContainerNode extends Modifier.Node implements TraversableNode {
    private boolean enabled;
    private final Object traverseKey = TraverseKey;
    public static final TraverseKey TraverseKey = new TraverseKey(null);
    public static final int $stable = 8;

    public ScrollableContainerNode(boolean z) {
        this.enabled = z;
    }

    @Override // androidx.compose.ui.node.TraversableNode
    public Object getTraverseKey() {
        return this.traverseKey;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public static final class TraverseKey {
        public /* synthetic */ TraverseKey(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private TraverseKey() {
        }
    }

    public final void update(boolean z) {
        this.enabled = z;
    }
}
