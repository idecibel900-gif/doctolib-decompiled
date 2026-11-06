package net.time4j;

import net.time4j.format.DisplayElement;

/* JADX INFO: loaded from: classes5.dex */
abstract class AbstractDateElement extends DisplayElement implements AdjustableElement {
    private final transient ElementOperator maximizer;
    private final transient ElementOperator minimizer;

    AbstractDateElement(String str) {
        super(str);
        this.minimizer = new DateOperator(this, 0);
        this.maximizer = new DateOperator(this, 1);
    }

    public ElementOperator setLenient(Comparable comparable) {
        return new DateOperator(this, 6, comparable);
    }
}
