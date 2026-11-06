package com.facebook.react.views.debuggingoverlay;

import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class TraceUpdate {
    private final int color;
    private final int id;
    private final RectF rectangle;

    public TraceUpdate(int i, RectF rectangle, int i2) {
        Intrinsics.checkNotNullParameter(rectangle, "rectangle");
        this.id = i;
        this.rectangle = rectangle;
        this.color = i2;
    }

    public final int getColor() {
        return this.color;
    }

    public final int getId() {
        return this.id;
    }

    public final RectF getRectangle() {
        return this.rectangle;
    }
}
