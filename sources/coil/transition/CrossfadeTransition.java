package coil.transition;

import android.graphics.drawable.Drawable;
import coil.decode.DataSource;
import coil.drawable.CrossfadeDrawable;
import coil.request.ErrorResult;
import coil.request.ImageResult;
import coil.request.SuccessResult;
import coil.size.Scale;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class CrossfadeTransition implements Transition {
    private final int durationMillis;
    private final boolean preferExactIntrinsicSize;
    private final ImageResult result;
    private final TransitionTarget target;

    public CrossfadeTransition(TransitionTarget transitionTarget, ImageResult imageResult, int i, boolean z) {
        this.target = transitionTarget;
        this.result = imageResult;
        this.durationMillis = i;
        this.preferExactIntrinsicSize = z;
        if (i <= 0) {
            throw new IllegalArgumentException("durationMillis must be > 0.");
        }
    }

    public final int getDurationMillis() {
        return this.durationMillis;
    }

    public final boolean getPreferExactIntrinsicSize() {
        return this.preferExactIntrinsicSize;
    }

    @Override // coil.transition.Transition
    public void transition() {
        Drawable drawable = this.target.getDrawable();
        Drawable drawable2 = this.result.getDrawable();
        Scale scale = this.result.getRequest().getScale();
        int i = this.durationMillis;
        ImageResult imageResult = this.result;
        CrossfadeDrawable crossfadeDrawable = new CrossfadeDrawable(drawable, drawable2, scale, i, ((imageResult instanceof SuccessResult) && ((SuccessResult) imageResult).isPlaceholderCached()) ? false : true, this.preferExactIntrinsicSize);
        ImageResult imageResult2 = this.result;
        if (imageResult2 instanceof SuccessResult) {
            this.target.onSuccess(crossfadeDrawable);
        } else if (imageResult2 instanceof ErrorResult) {
            this.target.onError(crossfadeDrawable);
        }
    }

    public static final class Factory implements Transition.Factory {
        private final int durationMillis;
        private final boolean preferExactIntrinsicSize;

        public Factory(int i, boolean z) {
            this.durationMillis = i;
            this.preferExactIntrinsicSize = z;
            if (i <= 0) {
                throw new IllegalArgumentException("durationMillis must be > 0.");
            }
        }

        public /* synthetic */ Factory(int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 100 : i, (i2 & 2) != 0 ? false : z);
        }

        @Override // coil.transition.Transition.Factory
        public Transition create(TransitionTarget transitionTarget, ImageResult imageResult) {
            if (!(imageResult instanceof SuccessResult)) {
                return Transition.Factory.NONE.create(transitionTarget, imageResult);
            }
            if (((SuccessResult) imageResult).getDataSource() == DataSource.MEMORY_CACHE) {
                return Transition.Factory.NONE.create(transitionTarget, imageResult);
            }
            return new CrossfadeTransition(transitionTarget, imageResult, this.durationMillis, this.preferExactIntrinsicSize);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Factory)) {
                return false;
            }
            Factory factory = (Factory) obj;
            return this.durationMillis == factory.durationMillis && this.preferExactIntrinsicSize == factory.preferExactIntrinsicSize;
        }

        public int hashCode() {
            return (this.durationMillis * 31) + Boolean.hashCode(this.preferExactIntrinsicSize);
        }
    }
}
