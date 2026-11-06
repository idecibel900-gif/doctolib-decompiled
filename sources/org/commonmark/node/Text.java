package org.commonmark.node;

/* JADX INFO: loaded from: classes5.dex */
public class Text extends Node {
    private String literal;

    public Text(String str) {
        this.literal = str;
    }

    public String getLiteral() {
        return this.literal;
    }

    public void setLiteral(String str) {
        this.literal = str;
    }

    @Override // org.commonmark.node.Node
    protected String toStringAttributes() {
        return "literal=" + this.literal;
    }
}
