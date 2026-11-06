package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;

/* JADX INFO: loaded from: classes4.dex */
public abstract class SerializationDelegatingTypeAdapter<T> extends TypeAdapter {
    public abstract TypeAdapter getSerializationDelegate();
}
