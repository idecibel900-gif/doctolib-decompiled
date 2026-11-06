package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public final class JsonArray extends JsonElement implements Iterable {
    private final ArrayList elements;

    public JsonArray() {
        this.elements = new ArrayList();
    }

    public JsonArray(int i) {
        this.elements = new ArrayList(i);
    }

    public void add(Number number) {
        this.elements.add(number == null ? JsonNull.INSTANCE : new JsonPrimitive(number));
    }

    public void add(String str) {
        this.elements.add(str == null ? JsonNull.INSTANCE : new JsonPrimitive(str));
    }

    public void add(JsonElement jsonElement) {
        if (jsonElement == null) {
            jsonElement = JsonNull.INSTANCE;
        }
        this.elements.add(jsonElement);
    }

    public int size() {
        return this.elements.size();
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return this.elements.iterator();
    }

    private JsonElement getAsSingleElement() {
        int size = this.elements.size();
        if (size == 1) {
            return (JsonElement) this.elements.get(0);
        }
        throw new IllegalStateException("Array must have size 1, but has size " + size);
    }

    @Override // com.google.gson.JsonElement
    public Number getAsNumber() {
        return getAsSingleElement().getAsNumber();
    }

    @Override // com.google.gson.JsonElement
    public String getAsString() {
        return getAsSingleElement().getAsString();
    }

    @Override // com.google.gson.JsonElement
    public long getAsLong() {
        return getAsSingleElement().getAsLong();
    }

    @Override // com.google.gson.JsonElement
    public int getAsInt() {
        return getAsSingleElement().getAsInt();
    }

    @Override // com.google.gson.JsonElement
    public boolean getAsBoolean() {
        return getAsSingleElement().getAsBoolean();
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof JsonArray) && ((JsonArray) obj).elements.equals(this.elements);
        }
        return true;
    }

    public int hashCode() {
        return this.elements.hashCode();
    }
}
