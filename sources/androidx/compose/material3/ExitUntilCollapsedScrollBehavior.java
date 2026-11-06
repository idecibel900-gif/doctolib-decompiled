package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes.dex */
final class ExitUntilCollapsedScrollBehavior implements TopAppBarScrollBehavior {
    private final Function0 canScroll;
    private final DecayAnimationSpec flingAnimationSpec;
    private final boolean isPinned;
    private NestedScrollConnection nestedScrollConnection = new ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1(this);
    private final AnimationSpec snapAnimationSpec;
    private final TopAppBarState state;

    public ExitUntilCollapsedScrollBehavior(TopAppBarState topAppBarState, AnimationSpec animationSpec, DecayAnimationSpec decayAnimationSpec, Function0 function0) {
        this.state = topAppBarState;
        this.snapAnimationSpec = animationSpec;
        this.flingAnimationSpec = decayAnimationSpec;
        this.canScroll = function0;
    }

    @Override // androidx.compose.material3.TopAppBarScrollBehavior
    public TopAppBarState getState() {
        return this.state;
    }

    @Override // androidx.compose.material3.TopAppBarScrollBehavior
    public AnimationSpec getSnapAnimationSpec() {
        return this.snapAnimationSpec;
    }

    @Override // androidx.compose.material3.TopAppBarScrollBehavior
    public DecayAnimationSpec getFlingAnimationSpec() {
        return this.flingAnimationSpec;
    }

    public final Function0 getCanScroll() {
        return this.canScroll;
    }

    @Override // androidx.compose.material3.TopAppBarScrollBehavior
    public boolean isPinned() {
        return this.isPinned;
    }

    @Override // androidx.compose.material3.TopAppBarScrollBehavior
    public NestedScrollConnection getNestedScrollConnection() {
        return this.nestedScrollConnection;
    }
}
