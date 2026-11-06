package androidx.compose.animation;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class ContentTransform {
    private final ExitTransition initialContentExit;
    private SizeTransform sizeTransform;
    private final EnterTransition targetContentEnter;
    private final MutableFloatState targetContentZIndex$delegate;

    public ContentTransform(EnterTransition enterTransition, ExitTransition exitTransition, float f, SizeTransform sizeTransform) {
        this.targetContentEnter = enterTransition;
        this.initialContentExit = exitTransition;
        this.targetContentZIndex$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(f);
        this.sizeTransform = sizeTransform;
    }

    public final EnterTransition getTargetContentEnter() {
        return this.targetContentEnter;
    }

    public final ExitTransition getInitialContentExit() {
        return this.initialContentExit;
    }

    public /* synthetic */ ContentTransform(EnterTransition enterTransition, ExitTransition exitTransition, float f, SizeTransform sizeTransform, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(enterTransition, exitTransition, (i & 4) != 0 ? 0.0f : f, (i & 8) != 0 ? AnimatedContentKt.SizeTransform$default(false, null, 3, null) : sizeTransform);
    }

    public final float getTargetContentZIndex() {
        return this.targetContentZIndex$delegate.getFloatValue();
    }

    public final SizeTransform getSizeTransform() {
        return this.sizeTransform;
    }
}
