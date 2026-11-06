package androidx.compose.ui.graphics.vector;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class PathNodeKt {
    public static final void addPathNodes(char c, ArrayList arrayList, float[] fArr, int i) {
        if (c == 'z' || c == 'Z') {
            arrayList.add(PathNode.Close.INSTANCE);
            return;
        }
        if (c == 'm') {
            pathRelativeMoveNodeFromArgs(arrayList, fArr, i);
            return;
        }
        if (c == 'M') {
            pathMoveNodeFromArgs(arrayList, fArr, i);
            return;
        }
        int i2 = 0;
        if (c == 'l') {
            int i3 = i - 2;
            while (i2 <= i3) {
                arrayList.add(new PathNode.RelativeLineTo(fArr[i2], fArr[i2 + 1]));
                i2 += 2;
            }
            return;
        }
        if (c == 'L') {
            int i4 = i - 2;
            while (i2 <= i4) {
                arrayList.add(new PathNode.LineTo(fArr[i2], fArr[i2 + 1]));
                i2 += 2;
            }
            return;
        }
        if (c == 'h') {
            int i5 = i - 1;
            while (i2 <= i5) {
                arrayList.add(new PathNode.RelativeHorizontalTo(fArr[i2]));
                i2++;
            }
            return;
        }
        if (c == 'H') {
            int i6 = i - 1;
            while (i2 <= i6) {
                arrayList.add(new PathNode.HorizontalTo(fArr[i2]));
                i2++;
            }
            return;
        }
        if (c == 'v') {
            int i7 = i - 1;
            while (i2 <= i7) {
                arrayList.add(new PathNode.RelativeVerticalTo(fArr[i2]));
                i2++;
            }
            return;
        }
        if (c == 'V') {
            int i8 = i - 1;
            while (i2 <= i8) {
                arrayList.add(new PathNode.VerticalTo(fArr[i2]));
                i2++;
            }
            return;
        }
        if (c == 'c') {
            int i9 = i - 6;
            while (i2 <= i9) {
                arrayList.add(new PathNode.RelativeCurveTo(fArr[i2], fArr[i2 + 1], fArr[i2 + 2], fArr[i2 + 3], fArr[i2 + 4], fArr[i2 + 5]));
                i2 += 6;
            }
            return;
        }
        if (c == 'C') {
            int i10 = i - 6;
            while (i2 <= i10) {
                arrayList.add(new PathNode.CurveTo(fArr[i2], fArr[i2 + 1], fArr[i2 + 2], fArr[i2 + 3], fArr[i2 + 4], fArr[i2 + 5]));
                i2 += 6;
            }
            return;
        }
        if (c == 's') {
            int i11 = i - 4;
            while (i2 <= i11) {
                arrayList.add(new PathNode.RelativeReflectiveCurveTo(fArr[i2], fArr[i2 + 1], fArr[i2 + 2], fArr[i2 + 3]));
                i2 += 4;
            }
            return;
        }
        if (c == 'S') {
            int i12 = i - 4;
            while (i2 <= i12) {
                arrayList.add(new PathNode.ReflectiveCurveTo(fArr[i2], fArr[i2 + 1], fArr[i2 + 2], fArr[i2 + 3]));
                i2 += 4;
            }
            return;
        }
        if (c == 'q') {
            int i13 = i - 4;
            while (i2 <= i13) {
                arrayList.add(new PathNode.RelativeQuadTo(fArr[i2], fArr[i2 + 1], fArr[i2 + 2], fArr[i2 + 3]));
                i2 += 4;
            }
            return;
        }
        if (c == 'Q') {
            int i14 = i - 4;
            while (i2 <= i14) {
                arrayList.add(new PathNode.QuadTo(fArr[i2], fArr[i2 + 1], fArr[i2 + 2], fArr[i2 + 3]));
                i2 += 4;
            }
            return;
        }
        if (c == 't') {
            int i15 = i - 2;
            while (i2 <= i15) {
                arrayList.add(new PathNode.RelativeReflectiveQuadTo(fArr[i2], fArr[i2 + 1]));
                i2 += 2;
            }
            return;
        }
        if (c == 'T') {
            int i16 = i - 2;
            while (i2 <= i16) {
                arrayList.add(new PathNode.ReflectiveQuadTo(fArr[i2], fArr[i2 + 1]));
                i2 += 2;
            }
            return;
        }
        if (c == 'a') {
            int i17 = i - 7;
            for (int i18 = 0; i18 <= i17; i18 += 7) {
                arrayList.add(new PathNode.RelativeArcTo(fArr[i18], fArr[i18 + 1], fArr[i18 + 2], Float.compare(fArr[i18 + 3], 0.0f) != 0, Float.compare(fArr[i18 + 4], 0.0f) != 0, fArr[i18 + 5], fArr[i18 + 6]));
            }
            return;
        }
        if (c != 'A') {
            throw new IllegalArgumentException("Unknown command for: " + c);
        }
        int i19 = i - 7;
        for (int i20 = 0; i20 <= i19; i20 += 7) {
            arrayList.add(new PathNode.ArcTo(fArr[i20], fArr[i20 + 1], fArr[i20 + 2], Float.compare(fArr[i20 + 3], 0.0f) != 0, Float.compare(fArr[i20 + 4], 0.0f) != 0, fArr[i20 + 5], fArr[i20 + 6]));
        }
    }

    private static final void pathMoveNodeFromArgs(List list, float[] fArr, int i) {
        int i2 = i - 2;
        if (i2 >= 0) {
            list.add(new PathNode.MoveTo(fArr[0], fArr[1]));
            for (int i3 = 2; i3 <= i2; i3 += 2) {
                list.add(new PathNode.LineTo(fArr[i3], fArr[i3 + 1]));
            }
        }
    }

    private static final void pathRelativeMoveNodeFromArgs(List list, float[] fArr, int i) {
        int i2 = i - 2;
        if (i2 >= 0) {
            list.add(new PathNode.RelativeMoveTo(fArr[0], fArr[1]));
            for (int i3 = 2; i3 <= i2; i3 += 2) {
                list.add(new PathNode.RelativeLineTo(fArr[i3], fArr[i3 + 1]));
            }
        }
    }
}
