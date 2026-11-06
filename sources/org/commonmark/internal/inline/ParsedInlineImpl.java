package org.commonmark.internal.inline;

import org.commonmark.node.Node;

/* JADX INFO: loaded from: classes5.dex */
public class ParsedInlineImpl extends ParsedInline {
    private final Node node;
    private final Position position;

    ParsedInlineImpl(Node node, Position position) {
        this.node = node;
        this.position = position;
    }

    public Node getNode() {
        return this.node;
    }

    public Position getPosition() {
        return this.position;
    }
}
