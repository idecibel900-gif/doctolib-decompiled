package org.commonmark.node;

/* JADX INFO: loaded from: classes5.dex */
public class Link extends Node {
    private String destination;
    private String title;

    public Link(String str, String str2) {
        this.destination = str;
        this.title = str2;
    }

    public String getDestination() {
        return this.destination;
    }

    @Override // org.commonmark.node.Node
    protected String toStringAttributes() {
        return "destination=" + this.destination + ", title=" + this.title;
    }
}
