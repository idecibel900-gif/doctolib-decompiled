package org.commonmark.internal;

import java.util.List;
import org.commonmark.node.Block;
import org.commonmark.node.Paragraph;
import org.commonmark.node.SourceSpan;
import org.commonmark.parser.InlineParser;
import org.commonmark.parser.SourceLine;
import org.commonmark.parser.SourceLines;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.ParserState;

/* JADX INFO: loaded from: classes5.dex */
public class ParagraphParser extends AbstractBlockParser {
    private final Paragraph block = new Paragraph();
    private final LinkReferenceDefinitionParser linkReferenceDefinitionParser = new LinkReferenceDefinitionParser();

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public boolean canHaveLazyContinuationLines() {
        return true;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public Block getBlock() {
        return this.block;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public BlockContinue tryContinue(ParserState parserState) {
        if (!parserState.isBlank()) {
            return BlockContinue.atIndex(parserState.getIndex());
        }
        return BlockContinue.none();
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void addLine(SourceLine sourceLine) {
        this.linkReferenceDefinitionParser.parse(sourceLine);
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void addSourceSpan(SourceSpan sourceSpan) {
        this.linkReferenceDefinitionParser.addSourceSpan(sourceSpan);
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void closeBlock() {
        if (this.linkReferenceDefinitionParser.getParagraphLines().isEmpty()) {
            this.block.unlink();
        } else {
            this.block.setSourceSpans(this.linkReferenceDefinitionParser.getParagraphSourceSpans());
        }
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void parseInlines(InlineParser inlineParser) {
        SourceLines paragraphLines = this.linkReferenceDefinitionParser.getParagraphLines();
        if (paragraphLines.isEmpty()) {
            return;
        }
        inlineParser.parse(paragraphLines, this.block);
    }

    public SourceLines getParagraphLines() {
        return this.linkReferenceDefinitionParser.getParagraphLines();
    }

    public List getDefinitions() {
        return this.linkReferenceDefinitionParser.getDefinitions();
    }
}
