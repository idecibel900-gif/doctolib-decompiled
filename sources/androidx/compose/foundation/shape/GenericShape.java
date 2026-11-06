package androidx.compose.foundation.shape;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes.dex */
public final class GenericShape implements Shape {
    private final Function3 builder;

    public GenericShape(Function3 function3) {
        this.builder = function3;
    }

    @Override // androidx.compose.ui.graphics.Shape
    /* JADX INFO: renamed from: createOutline-Pq9zytI */
    public Outline mo145createOutlinePq9zytI(long j, LayoutDirection layoutDirection, Density density) {
        Path Path = AndroidPath_androidKt.Path();
        this.builder.invoke(Path, Size.m1255boximpl(j), layoutDirection);
        Path.close();
        return new Outline.Generic(Path);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        GenericShape genericShape = obj instanceof GenericShape ? (GenericShape) obj : null;
        return (genericShape != null ? genericShape.builder : null) == this.builder;
    }

    public int hashCode() {
        return this.builder.hashCode();
    }
}
