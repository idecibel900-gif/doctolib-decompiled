package androidx.compose.ui.geometry;

/* JADX INFO: loaded from: classes.dex */
public abstract class RoundRectKt {
    public static final RoundRect RoundRect(float f, float f2, float f3, float f4, float f5, float f6) {
        long jCornerRadius = CornerRadiusKt.CornerRadius(f5, f6);
        return new RoundRect(f, f2, f3, f4, jCornerRadius, jCornerRadius, jCornerRadius, jCornerRadius, null);
    }

    /* JADX INFO: renamed from: RoundRect-gG7oq9Y, reason: not valid java name */
    public static final RoundRect m1253RoundRectgG7oq9Y(float f, float f2, float f3, float f4, long j) {
        return RoundRect(f, f2, f3, f4, CornerRadius.m1209getXimpl(j), CornerRadius.m1210getYimpl(j));
    }

    /* JADX INFO: renamed from: RoundRect-ZAM2FJo, reason: not valid java name */
    public static final RoundRect m1252RoundRectZAM2FJo(Rect rect, long j, long j2, long j3, long j4) {
        return new RoundRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), j, j2, j3, j4, null);
    }

    /* JADX INFO: renamed from: translate-Uv8p0NA, reason: not valid java name */
    public static final RoundRect m1254translateUv8p0NA(RoundRect roundRect, long j) {
        return new RoundRect(roundRect.getLeft() + Offset.m1223getXimpl(j), roundRect.getTop() + Offset.m1224getYimpl(j), roundRect.getRight() + Offset.m1223getXimpl(j), roundRect.getBottom() + Offset.m1224getYimpl(j), roundRect.m1250getTopLeftCornerRadiuskKHJgLs(), roundRect.m1251getTopRightCornerRadiuskKHJgLs(), roundRect.m1249getBottomRightCornerRadiuskKHJgLs(), roundRect.m1248getBottomLeftCornerRadiuskKHJgLs(), null);
    }

    public static final Rect getBoundingRect(RoundRect roundRect) {
        return new Rect(roundRect.getLeft(), roundRect.getTop(), roundRect.getRight(), roundRect.getBottom());
    }

    public static final boolean isSimple(RoundRect roundRect) {
        return CornerRadius.m1209getXimpl(roundRect.m1250getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m1210getYimpl(roundRect.m1250getTopLeftCornerRadiuskKHJgLs()) && CornerRadius.m1209getXimpl(roundRect.m1250getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m1209getXimpl(roundRect.m1251getTopRightCornerRadiuskKHJgLs()) && CornerRadius.m1209getXimpl(roundRect.m1250getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m1210getYimpl(roundRect.m1251getTopRightCornerRadiuskKHJgLs()) && CornerRadius.m1209getXimpl(roundRect.m1250getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m1209getXimpl(roundRect.m1249getBottomRightCornerRadiuskKHJgLs()) && CornerRadius.m1209getXimpl(roundRect.m1250getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m1210getYimpl(roundRect.m1249getBottomRightCornerRadiuskKHJgLs()) && CornerRadius.m1209getXimpl(roundRect.m1250getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m1209getXimpl(roundRect.m1248getBottomLeftCornerRadiuskKHJgLs()) && CornerRadius.m1209getXimpl(roundRect.m1250getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m1210getYimpl(roundRect.m1248getBottomLeftCornerRadiuskKHJgLs());
    }
}
