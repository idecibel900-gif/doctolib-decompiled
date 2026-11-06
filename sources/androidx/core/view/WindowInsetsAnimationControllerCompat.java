package androidx.core.view;

import android.view.WindowInsetsAnimationController;
import androidx.core.graphics.Insets;

/* JADX INFO: loaded from: classes.dex */
public final class WindowInsetsAnimationControllerCompat {
    private final Impl mImpl;

    WindowInsetsAnimationControllerCompat(WindowInsetsAnimationController windowInsetsAnimationController) {
        this.mImpl = new Impl30(windowInsetsAnimationController);
    }

    public Insets getHiddenStateInsets() {
        return this.mImpl.getHiddenStateInsets();
    }

    public Insets getShownStateInsets() {
        return this.mImpl.getShownStateInsets();
    }

    public Insets getCurrentInsets() {
        return this.mImpl.getCurrentInsets();
    }

    public float getCurrentFraction() {
        return this.mImpl.getCurrentFraction();
    }

    public void setInsetsAndAlpha(Insets insets, float f, float f2) {
        this.mImpl.setInsetsAndAlpha(insets, f, f2);
    }

    public void finish(boolean z) {
        this.mImpl.finish(z);
    }

    private static class Impl {
        abstract void finish(boolean z);

        public abstract float getCurrentFraction();

        public abstract Insets getCurrentInsets();

        public abstract Insets getHiddenStateInsets();

        public abstract Insets getShownStateInsets();

        public abstract void setInsetsAndAlpha(Insets insets, float f, float f2);

        Impl() {
        }
    }

    private static class Impl30 extends Impl {
        private final WindowInsetsAnimationController mController;

        Impl30(WindowInsetsAnimationController windowInsetsAnimationController) {
            this.mController = windowInsetsAnimationController;
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        public Insets getHiddenStateInsets() {
            return Insets.toCompatInsets(this.mController.getHiddenStateInsets());
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        public Insets getShownStateInsets() {
            return Insets.toCompatInsets(this.mController.getShownStateInsets());
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        public Insets getCurrentInsets() {
            return Insets.toCompatInsets(this.mController.getCurrentInsets());
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        public float getCurrentFraction() {
            return this.mController.getCurrentFraction();
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        public void setInsetsAndAlpha(Insets insets, float f, float f2) {
            this.mController.setInsetsAndAlpha(insets == null ? null : insets.toPlatformInsets(), f, f2);
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        void finish(boolean z) {
            this.mController.finish(z);
        }
    }
}
