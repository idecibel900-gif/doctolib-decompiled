package net.time4j.engine;

/* JADX INFO: loaded from: classes5.dex */
public interface AttributeQuery {
    boolean contains(AttributeKey attributeKey);

    Object get(AttributeKey attributeKey);

    Object get(AttributeKey attributeKey, Object obj);
}
