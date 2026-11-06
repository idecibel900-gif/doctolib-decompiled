package io.opentracing.tag;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractTag {
    protected final String key;

    public AbstractTag(String str) {
        this.key = str;
    }

    public String getKey() {
        return this.key;
    }
}
