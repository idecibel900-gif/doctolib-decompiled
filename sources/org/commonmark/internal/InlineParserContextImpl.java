package org.commonmark.internal;

import java.util.List;
import org.commonmark.node.LinkReferenceDefinition;
import org.commonmark.parser.InlineParserContext;

/* JADX INFO: loaded from: classes5.dex */
public class InlineParserContextImpl implements InlineParserContext {
    private final List delimiterProcessors;
    private final LinkReferenceDefinitions linkReferenceDefinitions;

    public InlineParserContextImpl(List list, LinkReferenceDefinitions linkReferenceDefinitions) {
        this.delimiterProcessors = list;
        this.linkReferenceDefinitions = linkReferenceDefinitions;
    }

    @Override // org.commonmark.parser.InlineParserContext
    public List getCustomDelimiterProcessors() {
        return this.delimiterProcessors;
    }

    @Override // org.commonmark.parser.InlineParserContext
    public LinkReferenceDefinition getLinkReferenceDefinition(String str) {
        return this.linkReferenceDefinitions.get(str);
    }
}
