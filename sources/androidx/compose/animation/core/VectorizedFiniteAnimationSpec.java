package androidx.compose.animation.core;

/* JADX INFO: loaded from: classes.dex */
public interface VectorizedFiniteAnimationSpec extends VectorizedAnimationSpec {
    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    default boolean isInfinite() {
        return false;
    }
}
