package com.facebook.debug.debugoverlay.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class DebugOverlayTag {
    private final int color;
    private final String description;
    private final String name;

    public DebugOverlayTag(String name, String description, int i) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        this.name = name;
        this.description = description;
        this.color = i;
    }
}
