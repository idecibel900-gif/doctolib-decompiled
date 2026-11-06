package com.facebook.fresco.urimod;

/* JADX INFO: loaded from: classes3.dex */
public final class UriModifier {
    public static final UriModifier INSTANCE = new UriModifier();

    /* JADX INFO: renamed from: INSTANCE, reason: collision with other field name */
    public static UriModifierInterface f50INSTANCE = NopUriModifier.INSTANCE;

    private UriModifier() {
    }
}
