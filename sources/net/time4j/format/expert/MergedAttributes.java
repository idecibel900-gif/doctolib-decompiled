package net.time4j.format.expert;

import net.time4j.engine.AttributeKey;
import net.time4j.engine.AttributeQuery;

/* JADX INFO: loaded from: classes5.dex */
final class MergedAttributes implements AttributeQuery {
    private final AttributeQuery inner;
    private final AttributeQuery outer;

    MergedAttributes(AttributeQuery attributeQuery, AttributeQuery attributeQuery2) {
        this.outer = attributeQuery;
        this.inner = attributeQuery2;
    }

    @Override // net.time4j.engine.AttributeQuery
    public boolean contains(AttributeKey attributeKey) {
        return this.outer.contains(attributeKey) || this.inner.contains(attributeKey);
    }

    @Override // net.time4j.engine.AttributeQuery
    public Object get(AttributeKey attributeKey) {
        if (this.outer.contains(attributeKey)) {
            return this.outer.get(attributeKey);
        }
        return this.inner.get(attributeKey);
    }

    @Override // net.time4j.engine.AttributeQuery
    public Object get(AttributeKey attributeKey, Object obj) {
        if (this.outer.contains(attributeKey)) {
            return this.outer.get(attributeKey);
        }
        return this.inner.get(attributeKey, obj);
    }
}
