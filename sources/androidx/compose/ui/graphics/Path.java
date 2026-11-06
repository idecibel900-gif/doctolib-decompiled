package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;

/* JADX INFO: loaded from: classes.dex */
public interface Path {
    public static final Companion Companion = Companion.$$INSTANCE;

    public enum Direction {
        CounterClockwise,
        Clockwise
    }

    void addOval(Rect rect, Direction direction);

    /* JADX INFO: renamed from: addPath-Uv8p0NA */
    void mo1303addPathUv8p0NA(Path path, long j);

    void addRect(Rect rect, Direction direction);

    void addRoundRect(RoundRect roundRect, Direction direction);

    void close();

    void cubicTo(float f, float f2, float f3, float f4, float f5, float f6);

    Rect getBounds();

    /* JADX INFO: renamed from: getFillType-Rg-k1Os */
    int mo1304getFillTypeRgk1Os();

    boolean isConvex();

    boolean isEmpty();

    void lineTo(float f, float f2);

    void moveTo(float f, float f2);

    /* JADX INFO: renamed from: op-N5in7k0 */
    boolean mo1305opN5in7k0(Path path, Path path2, int i);

    void quadraticTo(float f, float f2, float f3, float f4);

    void relativeCubicTo(float f, float f2, float f3, float f4, float f5, float f6);

    void relativeLineTo(float f, float f2);

    void relativeMoveTo(float f, float f2);

    void relativeQuadraticTo(float f, float f2, float f3, float f4);

    void reset();

    void rewind();

    /* JADX INFO: renamed from: setFillType-oQ8Xj4U */
    void mo1306setFillTypeoQ8Xj4U(int i);

    /* JADX INFO: renamed from: translate-k-4lQ0M */
    void mo1307translatek4lQ0M(long j);

    static /* synthetic */ void addRect$default(Path path, Rect rect, Direction direction, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addRect");
        }
        if ((i & 2) != 0) {
            direction = Direction.CounterClockwise;
        }
        path.addRect(rect, direction);
    }

    static /* synthetic */ void addOval$default(Path path, Rect rect, Direction direction, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addOval");
        }
        if ((i & 2) != 0) {
            direction = Direction.CounterClockwise;
        }
        path.addOval(rect, direction);
    }

    static /* synthetic */ void addRoundRect$default(Path path, RoundRect roundRect, Direction direction, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addRoundRect");
        }
        if ((i & 2) != 0) {
            direction = Direction.CounterClockwise;
        }
        path.addRoundRect(roundRect, direction);
    }

    /* JADX INFO: renamed from: addPath-Uv8p0NA$default, reason: not valid java name */
    static /* synthetic */ void m1463addPathUv8p0NA$default(Path path, Path path2, long j, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addPath-Uv8p0NA");
        }
        if ((i & 2) != 0) {
            j = Offset.Companion.m1235getZeroF1C5BW0();
        }
        path.mo1303addPathUv8p0NA(path2, j);
    }

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }
}
