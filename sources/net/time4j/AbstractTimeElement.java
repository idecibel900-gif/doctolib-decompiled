package net.time4j;

import net.time4j.format.DisplayElement;

/* JADX INFO: loaded from: classes5.dex */
abstract class AbstractTimeElement extends DisplayElement implements AdjustableElement {
    private final transient ElementOperator maximizer;
    private final transient ElementOperator minimizer;

    AbstractTimeElement(String str) {
        super(str);
        this.minimizer = new TimeOperator(this, 0);
        this.maximizer = new TimeOperator(this, 1);
    }

    public ElementOperator setLenient(Comparable comparable) {
        return new TimeOperator(this, 6, comparable);
    }
}
