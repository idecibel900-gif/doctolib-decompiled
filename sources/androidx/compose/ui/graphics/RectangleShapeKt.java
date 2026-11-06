package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;

/* JADX INFO: loaded from: classes.dex */
public abstract class RectangleShapeKt {
    private static final Shape RectangleShape = new Shape() { // from class: androidx.compose.ui.graphics.RectangleShapeKt$RectangleShape$1
        @Override // androidx.compose.ui.graphics.Shape
        /* JADX INFO: renamed from: createOutline-Pq9zytI */
        public Outline.Rectangle mo145createOutlinePq9zytI(long j, LayoutDirection layoutDirection, Density density) {
            return new Outline.Rectangle(SizeKt.m1269toRectuvyYCjk(j));
        }

        public String toString() {
            return "RectangleShape";
        }
    };

    public static final Shape getRectangleShape() {
        return RectangleShape;
    }
}
