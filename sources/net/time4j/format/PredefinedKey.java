package net.time4j.format;

import net.time4j.engine.AttributeKey;

/* JADX INFO: loaded from: classes5.dex */
final class PredefinedKey implements AttributeKey {
    private final String name;
    private final Class type;

    private PredefinedKey(String str, Class cls) {
        if (str == null) {
            throw new NullPointerException("Missing name of attribute key.");
        }
        if (cls == null) {
            throw new NullPointerException("Missing type of attribute.");
        }
        this.name = str;
        this.type = cls;
    }

    static PredefinedKey valueOf(String str, Class cls) {
        return new PredefinedKey(str, cls);
    }

    @Override // net.time4j.engine.AttributeKey
    public String name() {
        return this.name;
    }

    @Override // net.time4j.engine.AttributeKey
    public Class type() {
        return this.type;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PredefinedKey) {
            PredefinedKey predefinedKey = (PredefinedKey) obj;
            if (this.name.equals(predefinedKey.name) && this.type.equals(predefinedKey.type)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public String toString() {
        return this.type.getName() + "@" + this.name;
    }
}
