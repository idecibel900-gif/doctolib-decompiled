package org.commonmark.parser;

import java.util.List;
import org.commonmark.node.LinkReferenceDefinition;

/* JADX INFO: loaded from: classes5.dex */
public interface InlineParserContext {
    List getCustomDelimiterProcessors();

    LinkReferenceDefinition getLinkReferenceDefinition(String str);
}
