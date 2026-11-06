package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;

/* JADX INFO: loaded from: classes.dex */
public interface TopAppBarScrollBehavior {
    DecayAnimationSpec getFlingAnimationSpec();

    NestedScrollConnection getNestedScrollConnection();

    AnimationSpec getSnapAnimationSpec();

    TopAppBarState getState();

    boolean isPinned();
}
