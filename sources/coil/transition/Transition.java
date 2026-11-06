package coil.transition;

import coil.request.ImageResult;

/* JADX INFO: loaded from: classes3.dex */
public interface Transition {
    void transition();

    public interface Factory {
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final Factory NONE = new NoneTransition.Factory();

        Transition create(TransitionTarget transitionTarget, ImageResult imageResult);

        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }
        }
    }
}
