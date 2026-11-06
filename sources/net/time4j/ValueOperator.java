package net.time4j;

import net.time4j.engine.ChronoOperator;

/* JADX INFO: loaded from: classes5.dex */
final class ValueOperator implements ChronoOperator {
    private final ChronoOperator delegate;
    private final Object value;

    private ValueOperator(ChronoOperator chronoOperator, Object obj) {
        this.delegate = chronoOperator;
        this.value = obj;
    }

    static ValueOperator of(ChronoOperator chronoOperator, Object obj) {
        return new ValueOperator(chronoOperator, obj);
    }

    @Override // net.time4j.engine.ChronoOperator
    public Object apply(Object obj) {
        return this.delegate.apply(obj);
    }
}
