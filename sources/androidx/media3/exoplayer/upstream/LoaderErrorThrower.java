package androidx.media3.exoplayer.upstream;

/* JADX INFO: loaded from: classes.dex */
public interface LoaderErrorThrower {

    public static final class Placeholder implements LoaderErrorThrower {
        @Override // androidx.media3.exoplayer.upstream.LoaderErrorThrower
        public void maybeThrowError() {
        }
    }

    void maybeThrowError();
}
