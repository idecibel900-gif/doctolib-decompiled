package androidx.compose.ui.platform;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes.dex */
public abstract class ShapeContainingUtilKt {
    public static /* synthetic */ boolean isInOutline$default(Outline outline, float f, float f2, Path path, Path path2, int i, Object obj) {
        if ((i & 8) != 0) {
            path = null;
        }
        if ((i & 16) != 0) {
            path2 = null;
        }
        return isInOutline(outline, f, f2, path, path2);
    }

    public static final boolean isInOutline(Outline outline, float f, float f2, Path path, Path path2) {
        if (outline instanceof Outline.Rectangle) {
            return isInRectangle(((Outline.Rectangle) outline).getRect(), f, f2);
        }
        if (outline instanceof Outline.Rounded) {
            return isInRoundedRect((Outline.Rounded) outline, f, f2, path, path2);
        }
        if (outline instanceof Outline.Generic) {
            return isInPath(((Outline.Generic) outline).getPath(), f, f2, path, path2);
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final boolean isInRectangle(Rect rect, float f, float f2) {
        return rect.getLeft() <= f && f < rect.getRight() && rect.getTop() <= f2 && f2 < rect.getBottom();
    }

    private static final boolean isInRoundedRect(Outline.Rounded rounded, float f, float f2, Path path, Path path2) {
        RoundRect roundRect = rounded.getRoundRect();
        if (f < roundRect.getLeft() || f >= roundRect.getRight() || f2 < roundRect.getTop() || f2 >= roundRect.getBottom()) {
            return false;
        }
        if (!cornersFit(roundRect)) {
            Path Path = path2 == null ? AndroidPath_androidKt.Path() : path2;
            Path.addRoundRect$default(Path, roundRect, null, 2, null);
            return isInPath(Path, f, f2, path, path2);
        }
        float fM1209getXimpl = CornerRadius.m1209getXimpl(roundRect.m1250getTopLeftCornerRadiuskKHJgLs()) + roundRect.getLeft();
        float fM1210getYimpl = CornerRadius.m1210getYimpl(roundRect.m1250getTopLeftCornerRadiuskKHJgLs()) + roundRect.getTop();
        float right = roundRect.getRight() - CornerRadius.m1209getXimpl(roundRect.m1251getTopRightCornerRadiuskKHJgLs());
        float top = roundRect.getTop() + CornerRadius.m1210getYimpl(roundRect.m1251getTopRightCornerRadiuskKHJgLs());
        float right2 = roundRect.getRight() - CornerRadius.m1209getXimpl(roundRect.m1249getBottomRightCornerRadiuskKHJgLs());
        float bottom = roundRect.getBottom() - CornerRadius.m1210getYimpl(roundRect.m1249getBottomRightCornerRadiuskKHJgLs());
        float bottom2 = roundRect.getBottom() - CornerRadius.m1210getYimpl(roundRect.m1248getBottomLeftCornerRadiuskKHJgLs());
        float left = roundRect.getLeft() + CornerRadius.m1209getXimpl(roundRect.m1248getBottomLeftCornerRadiuskKHJgLs());
        if (f < fM1209getXimpl && f2 < fM1210getYimpl) {
            return m2082isWithinEllipseVE1yxkc(f, f2, roundRect.m1250getTopLeftCornerRadiuskKHJgLs(), fM1209getXimpl, fM1210getYimpl);
        }
        if (f < left && f2 > bottom2) {
            return m2082isWithinEllipseVE1yxkc(f, f2, roundRect.m1248getBottomLeftCornerRadiuskKHJgLs(), left, bottom2);
        }
        if (f > right && f2 < top) {
            return m2082isWithinEllipseVE1yxkc(f, f2, roundRect.m1251getTopRightCornerRadiuskKHJgLs(), right, top);
        }
        if (f <= right2 || f2 <= bottom) {
            return true;
        }
        return m2082isWithinEllipseVE1yxkc(f, f2, roundRect.m1249getBottomRightCornerRadiuskKHJgLs(), right2, bottom);
    }

    private static final boolean cornersFit(RoundRect roundRect) {
        return CornerRadius.m1209getXimpl(roundRect.m1250getTopLeftCornerRadiuskKHJgLs()) + CornerRadius.m1209getXimpl(roundRect.m1251getTopRightCornerRadiuskKHJgLs()) <= roundRect.getWidth() && CornerRadius.m1209getXimpl(roundRect.m1248getBottomLeftCornerRadiuskKHJgLs()) + CornerRadius.m1209getXimpl(roundRect.m1249getBottomRightCornerRadiuskKHJgLs()) <= roundRect.getWidth() && CornerRadius.m1210getYimpl(roundRect.m1250getTopLeftCornerRadiuskKHJgLs()) + CornerRadius.m1210getYimpl(roundRect.m1248getBottomLeftCornerRadiuskKHJgLs()) <= roundRect.getHeight() && CornerRadius.m1210getYimpl(roundRect.m1251getTopRightCornerRadiuskKHJgLs()) + CornerRadius.m1210getYimpl(roundRect.m1249getBottomRightCornerRadiuskKHJgLs()) <= roundRect.getHeight();
    }

    /* JADX INFO: renamed from: isWithinEllipse-VE1yxkc, reason: not valid java name */
    private static final boolean m2082isWithinEllipseVE1yxkc(float f, float f2, long j, float f3, float f4) {
        float f5 = f - f3;
        float f6 = f2 - f4;
        float fM1209getXimpl = CornerRadius.m1209getXimpl(j);
        float fM1210getYimpl = CornerRadius.m1210getYimpl(j);
        return ((f5 * f5) / (fM1209getXimpl * fM1209getXimpl)) + ((f6 * f6) / (fM1210getYimpl * fM1210getYimpl)) <= 1.0f;
    }

    private static final boolean isInPath(Path path, float f, float f2, Path path2, Path path3) {
        Rect rect = new Rect(f - 0.005f, f2 - 0.005f, f + 0.005f, f2 + 0.005f);
        if (path2 == null) {
            path2 = AndroidPath_androidKt.Path();
        }
        Path.addRect$default(path2, rect, null, 2, null);
        if (path3 == null) {
            path3 = AndroidPath_androidKt.Path();
        }
        path3.mo1305opN5in7k0(path, path2, PathOperation.Companion.m1472getIntersectb3I0S0c());
        boolean zIsEmpty = path3.isEmpty();
        path3.reset();
        path2.reset();
        return !zIsEmpty;
    }
}
