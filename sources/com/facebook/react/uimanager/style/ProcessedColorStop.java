package com.facebook.react.uimanager.style;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class ProcessedColorStop {
    private Integer color;
    private final Float position;

    public ProcessedColorStop(Integer num, Float f) {
        this.color = num;
        this.position = f;
    }

    public /* synthetic */ ProcessedColorStop(Integer num, Float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : f);
    }

    public final Integer getColor() {
        return this.color;
    }

    public final Float getPosition() {
        return this.position;
    }

    public final void setColor(Integer num) {
        this.color = num;
    }
}
