package org.commonmark.parser;

import android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.commonmark.Extension;
import org.commonmark.internal.DocumentParser;
import org.commonmark.internal.InlineParserContextImpl;
import org.commonmark.internal.InlineParserImpl;
import org.commonmark.internal.LinkReferenceDefinitions;
import org.commonmark.node.Node;
import org.commonmark.parser.delimiter.DelimiterProcessor;

/* JADX INFO: loaded from: classes5.dex */
public class Parser {
    private final List blockParserFactories;
    private final List delimiterProcessors;
    private final IncludeSourceSpans includeSourceSpans;
    private final InlineParserFactory inlineParserFactory;
    private final List postProcessors;

    public interface ParserExtension extends Extension {
        void extend(Builder builder);
    }

    private Parser(Builder builder) {
        this.blockParserFactories = DocumentParser.calculateBlockParserFactories(builder.blockParserFactories, builder.enabledBlockTypes);
        InlineParserFactory inlineParserFactory = builder.getInlineParserFactory();
        this.inlineParserFactory = inlineParserFactory;
        this.postProcessors = builder.postProcessors;
        List list = builder.delimiterProcessors;
        this.delimiterProcessors = list;
        this.includeSourceSpans = builder.includeSourceSpans;
        inlineParserFactory.create(new InlineParserContextImpl(list, new LinkReferenceDefinitions()));
    }

    public static Builder builder() {
        return new Builder();
    }

    public Node parse(String str) {
        if (str == null) {
            throw new NullPointerException("input must not be null");
        }
        return postProcess(createDocumentParser().parse(str));
    }

    private DocumentParser createDocumentParser() {
        return new DocumentParser(this.blockParserFactories, this.inlineParserFactory, this.delimiterProcessors, this.includeSourceSpans);
    }

    private Node postProcess(Node node) {
        Iterator it = this.postProcessors.iterator();
        if (!it.hasNext()) {
            return node;
        }
        MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver$$ExternalSyntheticThrowCCEIfNotNull0.m(it.next());
        throw null;
    }

    public static class Builder {
        private InlineParserFactory inlineParserFactory;
        private final List blockParserFactories = new ArrayList();
        private final List delimiterProcessors = new ArrayList();
        private final List postProcessors = new ArrayList();
        private Set enabledBlockTypes = DocumentParser.getDefaultBlockParserTypes();
        private IncludeSourceSpans includeSourceSpans = IncludeSourceSpans.NONE;

        public Parser build() {
            return new Parser(this);
        }

        public Builder extensions(Iterable iterable) {
            if (iterable == null) {
                throw new NullPointerException("extensions must not be null");
            }
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                Extension extension = (Extension) it.next();
                if (extension instanceof ParserExtension) {
                    ((ParserExtension) extension).extend(this);
                }
            }
            return this;
        }

        public Builder customDelimiterProcessor(DelimiterProcessor delimiterProcessor) {
            if (delimiterProcessor == null) {
                throw new NullPointerException("delimiterProcessor must not be null");
            }
            this.delimiterProcessors.add(delimiterProcessor);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public InlineParserFactory getInlineParserFactory() {
            InlineParserFactory inlineParserFactory = this.inlineParserFactory;
            return inlineParserFactory != null ? inlineParserFactory : new InlineParserFactory() { // from class: org.commonmark.parser.Parser.Builder.1
                @Override // org.commonmark.parser.InlineParserFactory
                public InlineParser create(InlineParserContext inlineParserContext) {
                    return new InlineParserImpl(inlineParserContext);
                }
            };
        }
    }
}
