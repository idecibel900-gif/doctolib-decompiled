package org.commonmark.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.commonmark.internal.inline.AsteriskDelimiterProcessor;
import org.commonmark.internal.inline.AutolinkInlineParser;
import org.commonmark.internal.inline.BackslashInlineParser;
import org.commonmark.internal.inline.BackticksInlineParser;
import org.commonmark.internal.inline.EntityInlineParser;
import org.commonmark.internal.inline.HtmlInlineParser;
import org.commonmark.internal.inline.InlineContentParser;
import org.commonmark.internal.inline.InlineParserState;
import org.commonmark.internal.inline.ParsedInline;
import org.commonmark.internal.inline.ParsedInlineImpl;
import org.commonmark.internal.inline.Position;
import org.commonmark.internal.inline.Scanner;
import org.commonmark.internal.inline.UnderscoreDelimiterProcessor;
import org.commonmark.internal.util.Escaping;
import org.commonmark.internal.util.LinkScanner;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.Image;
import org.commonmark.node.Link;
import org.commonmark.node.LinkReferenceDefinition;
import org.commonmark.node.Node;
import org.commonmark.node.SoftLineBreak;
import org.commonmark.node.SourceSpans;
import org.commonmark.node.Text;
import org.commonmark.parser.InlineParser;
import org.commonmark.parser.InlineParserContext;
import org.commonmark.parser.SourceLines;
import org.commonmark.parser.delimiter.DelimiterProcessor;

/* JADX INFO: loaded from: classes5.dex */
public class InlineParserImpl implements InlineParser, InlineParserState {
    private final InlineParserContext context;
    private final Map delimiterProcessors;
    private boolean includeSourceSpans;
    private final Map inlineParsers;
    private Bracket lastBracket;
    private Delimiter lastDelimiter;
    private Scanner scanner;
    private final BitSet specialCharacters;
    private int trailingSpaces;

    public InlineParserImpl(InlineParserContext inlineParserContext) {
        Map mapCalculateDelimiterProcessors = calculateDelimiterProcessors(inlineParserContext.getCustomDelimiterProcessors());
        this.delimiterProcessors = mapCalculateDelimiterProcessors;
        this.context = inlineParserContext;
        HashMap map = new HashMap();
        this.inlineParsers = map;
        map.put('\\', Collections.singletonList(new BackslashInlineParser()));
        map.put('`', Collections.singletonList(new BackticksInlineParser()));
        map.put('&', Collections.singletonList(new EntityInlineParser()));
        map.put('<', Arrays.asList(new AutolinkInlineParser(), new HtmlInlineParser()));
        this.specialCharacters = calculateSpecialCharacters(mapCalculateDelimiterProcessors.keySet(), map.keySet());
    }

    public static BitSet calculateSpecialCharacters(Set set, Set set2) {
        BitSet bitSet = new BitSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            bitSet.set(((Character) it.next()).charValue());
        }
        Iterator it2 = set2.iterator();
        while (it2.hasNext()) {
            bitSet.set(((Character) it2.next()).charValue());
        }
        bitSet.set(91);
        bitSet.set(93);
        bitSet.set(33);
        bitSet.set(10);
        return bitSet;
    }

    public static Map calculateDelimiterProcessors(List list) {
        HashMap map = new HashMap();
        addDelimiterProcessors(Arrays.asList(new AsteriskDelimiterProcessor(), new UnderscoreDelimiterProcessor()), map);
        addDelimiterProcessors(list, map);
        return map;
    }

    @Override // org.commonmark.internal.inline.InlineParserState
    public Scanner scanner() {
        return this.scanner;
    }

    private static void addDelimiterProcessors(Iterable iterable, Map map) {
        StaggeredDelimiterProcessor staggeredDelimiterProcessor;
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            DelimiterProcessor delimiterProcessor = (DelimiterProcessor) it.next();
            char openingCharacter = delimiterProcessor.getOpeningCharacter();
            char closingCharacter = delimiterProcessor.getClosingCharacter();
            if (openingCharacter == closingCharacter) {
                DelimiterProcessor delimiterProcessor2 = (DelimiterProcessor) map.get(Character.valueOf(openingCharacter));
                if (delimiterProcessor2 != null && delimiterProcessor2.getOpeningCharacter() == delimiterProcessor2.getClosingCharacter()) {
                    if (delimiterProcessor2 instanceof StaggeredDelimiterProcessor) {
                        staggeredDelimiterProcessor = (StaggeredDelimiterProcessor) delimiterProcessor2;
                    } else {
                        StaggeredDelimiterProcessor staggeredDelimiterProcessor2 = new StaggeredDelimiterProcessor(openingCharacter);
                        staggeredDelimiterProcessor2.add(delimiterProcessor2);
                        staggeredDelimiterProcessor = staggeredDelimiterProcessor2;
                    }
                    staggeredDelimiterProcessor.add(delimiterProcessor);
                    map.put(Character.valueOf(openingCharacter), staggeredDelimiterProcessor);
                } else {
                    addDelimiterProcessorForChar(openingCharacter, delimiterProcessor, map);
                }
            } else {
                addDelimiterProcessorForChar(openingCharacter, delimiterProcessor, map);
                addDelimiterProcessorForChar(closingCharacter, delimiterProcessor, map);
            }
        }
    }

    private static void addDelimiterProcessorForChar(char c, DelimiterProcessor delimiterProcessor, Map map) {
        if (((DelimiterProcessor) map.put(Character.valueOf(c), delimiterProcessor)) == null) {
            return;
        }
        throw new IllegalArgumentException("Delimiter processor conflict with delimiter char '" + c + "'");
    }

    @Override // org.commonmark.parser.InlineParser
    public void parse(SourceLines sourceLines, Node node) {
        reset(sourceLines);
        while (true) {
            List inline = parseInline();
            if (inline != null) {
                Iterator it = inline.iterator();
                while (it.hasNext()) {
                    node.appendChild((Node) it.next());
                }
            } else {
                processDelimiters(null);
                mergeChildTextNodes(node);
                return;
            }
        }
    }

    void reset(SourceLines sourceLines) {
        this.scanner = Scanner.of(sourceLines);
        this.includeSourceSpans = !sourceLines.getSourceSpans().isEmpty();
        this.trailingSpaces = 0;
        this.lastDelimiter = null;
        this.lastBracket = null;
    }

    private Text text(SourceLines sourceLines) {
        Text text = new Text(sourceLines.getContent());
        text.setSourceSpans(sourceLines.getSourceSpans());
        return text;
    }

    private List parseInline() {
        List delimiters;
        char cPeek = this.scanner.peek();
        if (cPeek == 0) {
            return null;
        }
        if (cPeek == '\n') {
            return Collections.singletonList(parseLineBreak());
        }
        if (cPeek == '!') {
            return Collections.singletonList(parseBang());
        }
        if (cPeek == '[') {
            return Collections.singletonList(parseOpenBracket());
        }
        if (cPeek == ']') {
            return Collections.singletonList(parseCloseBracket());
        }
        if (!this.specialCharacters.get(cPeek)) {
            return Collections.singletonList(parseText());
        }
        List list = (List) this.inlineParsers.get(Character.valueOf(cPeek));
        if (list != null) {
            Position position = this.scanner.position();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ParsedInline parsedInlineTryParse = ((InlineContentParser) it.next()).tryParse(this);
                if (parsedInlineTryParse instanceof ParsedInlineImpl) {
                    ParsedInlineImpl parsedInlineImpl = (ParsedInlineImpl) parsedInlineTryParse;
                    Node node = parsedInlineImpl.getNode();
                    this.scanner.setPosition(parsedInlineImpl.getPosition());
                    if (this.includeSourceSpans && node.getSourceSpans().isEmpty()) {
                        Scanner scanner = this.scanner;
                        node.setSourceSpans(scanner.getSource(position, scanner.position()).getSourceSpans());
                    }
                    return Collections.singletonList(node);
                }
                this.scanner.setPosition(position);
            }
        }
        DelimiterProcessor delimiterProcessor = (DelimiterProcessor) this.delimiterProcessors.get(Character.valueOf(cPeek));
        return (delimiterProcessor == null || (delimiters = parseDelimiters(delimiterProcessor, cPeek)) == null) ? Collections.singletonList(parseText()) : delimiters;
    }

    private List parseDelimiters(DelimiterProcessor delimiterProcessor, char c) {
        DelimiterData delimiterDataScanDelimiters = scanDelimiters(delimiterProcessor, c);
        if (delimiterDataScanDelimiters == null) {
            return null;
        }
        List list = delimiterDataScanDelimiters.characters;
        Delimiter delimiter = new Delimiter(list, c, delimiterDataScanDelimiters.canOpen, delimiterDataScanDelimiters.canClose, this.lastDelimiter);
        this.lastDelimiter = delimiter;
        Delimiter delimiter2 = delimiter.previous;
        if (delimiter2 != null) {
            delimiter2.next = delimiter;
        }
        return list;
    }

    private Node parseOpenBracket() {
        Position position = this.scanner.position();
        this.scanner.next();
        Position position2 = this.scanner.position();
        Text text = text(this.scanner.getSource(position, position2));
        addBracket(Bracket.link(text, position, position2, this.lastBracket, this.lastDelimiter));
        return text;
    }

    private Node parseBang() {
        Position position = this.scanner.position();
        this.scanner.next();
        if (this.scanner.next('[')) {
            Position position2 = this.scanner.position();
            Text text = text(this.scanner.getSource(position, position2));
            addBracket(Bracket.image(text, position, position2, this.lastBracket, this.lastDelimiter));
            return text;
        }
        Scanner scanner = this.scanner;
        return text(scanner.getSource(position, scanner.position()));
    }

    private Node parseCloseBracket() {
        String title;
        LinkReferenceDefinition linkReferenceDefinition;
        Position position = this.scanner.position();
        this.scanner.next();
        Position position2 = this.scanner.position();
        Bracket bracket = this.lastBracket;
        if (bracket == null) {
            return text(this.scanner.getSource(position, position2));
        }
        if (!bracket.allowed) {
            removeLastBracket();
            return text(this.scanner.getSource(position, position2));
        }
        String destination = null;
        if (this.scanner.next('(')) {
            this.scanner.whitespace();
            String linkDestination = parseLinkDestination(this.scanner);
            if (linkDestination == null) {
                this.scanner.setPosition(position2);
                title = null;
            } else {
                if (this.scanner.whitespace() >= 1) {
                    title = parseLinkTitle(this.scanner);
                    this.scanner.whitespace();
                } else {
                    title = null;
                }
                if (!this.scanner.next(')')) {
                    this.scanner.setPosition(position2);
                    title = null;
                }
            }
            destination = linkDestination;
        } else {
            title = null;
        }
        if (destination == null) {
            String linkLabel = parseLinkLabel(this.scanner);
            if (linkLabel == null) {
                this.scanner.setPosition(position2);
            }
            if ((linkLabel == null || linkLabel.isEmpty()) && !bracket.bracketAfter) {
                linkLabel = this.scanner.getSource(bracket.contentPosition, position).getContent();
            }
            if (linkLabel != null && (linkReferenceDefinition = this.context.getLinkReferenceDefinition(linkLabel)) != null) {
                destination = linkReferenceDefinition.getDestination();
                title = linkReferenceDefinition.getTitle();
            }
        }
        if (destination != null) {
            Node image = bracket.image ? new Image(destination, title) : new Link(destination, title);
            Node next = bracket.node.getNext();
            while (next != null) {
                Node next2 = next.getNext();
                image.appendChild(next);
                next = next2;
            }
            if (this.includeSourceSpans) {
                Scanner scanner = this.scanner;
                image.setSourceSpans(scanner.getSource(bracket.markerPosition, scanner.position()).getSourceSpans());
            }
            processDelimiters(bracket.previousDelimiter);
            mergeChildTextNodes(image);
            bracket.node.unlink();
            removeLastBracket();
            if (!bracket.image) {
                for (Bracket bracket2 = this.lastBracket; bracket2 != null; bracket2 = bracket2.previous) {
                    if (!bracket2.image) {
                        bracket2.allowed = false;
                    }
                }
            }
            return image;
        }
        removeLastBracket();
        this.scanner.setPosition(position2);
        return text(this.scanner.getSource(position, position2));
    }

    private void addBracket(Bracket bracket) {
        Bracket bracket2 = this.lastBracket;
        if (bracket2 != null) {
            bracket2.bracketAfter = true;
        }
        this.lastBracket = bracket;
    }

    private void removeLastBracket() {
        this.lastBracket = this.lastBracket.previous;
    }

    private String parseLinkDestination(Scanner scanner) {
        String content;
        char cPeek = scanner.peek();
        Position position = scanner.position();
        if (!LinkScanner.scanLinkDestination(scanner)) {
            return null;
        }
        if (cPeek == '<') {
            String content2 = scanner.getSource(position, scanner.position()).getContent();
            content = content2.substring(1, content2.length() - 1);
        } else {
            content = scanner.getSource(position, scanner.position()).getContent();
        }
        return Escaping.unescapeString(content);
    }

    private String parseLinkTitle(Scanner scanner) {
        Position position = scanner.position();
        if (!LinkScanner.scanLinkTitle(scanner)) {
            return null;
        }
        String content = scanner.getSource(position, scanner.position()).getContent();
        return Escaping.unescapeString(content.substring(1, content.length() - 1));
    }

    String parseLinkLabel(Scanner scanner) {
        if (!scanner.next('[')) {
            return null;
        }
        Position position = scanner.position();
        if (!LinkScanner.scanLinkLabelContent(scanner)) {
            return null;
        }
        Position position2 = scanner.position();
        if (!scanner.next(']')) {
            return null;
        }
        String content = scanner.getSource(position, position2).getContent();
        if (content.length() > 999) {
            return null;
        }
        return content;
    }

    private Node parseLineBreak() {
        this.scanner.next();
        if (this.trailingSpaces >= 2) {
            return new HardLineBreak();
        }
        return new SoftLineBreak();
    }

    private Node parseText() {
        char cPeek;
        Position position = this.scanner.position();
        this.scanner.next();
        while (true) {
            cPeek = this.scanner.peek();
            if (cPeek == 0 || this.specialCharacters.get(cPeek)) {
                break;
            }
            this.scanner.next();
        }
        Scanner scanner = this.scanner;
        SourceLines source = scanner.getSource(position, scanner.position());
        String content = source.getContent();
        if (cPeek == '\n') {
            int iSkipBackwards = Parsing.skipBackwards(' ', content, content.length() - 1, 0) + 1;
            this.trailingSpaces = content.length() - iSkipBackwards;
            content = content.substring(0, iSkipBackwards);
        } else if (cPeek == 0) {
            content = content.substring(0, Parsing.skipSpaceTabBackwards(content, content.length() - 1, 0) + 1);
        }
        Text text = new Text(content);
        text.setSourceSpans(source.getSourceSpans());
        return text;
    }

    private DelimiterData scanDelimiters(DelimiterProcessor delimiterProcessor, char c) {
        boolean z;
        int iPeekPreviousCodePoint = this.scanner.peekPreviousCodePoint();
        Position position = this.scanner.position();
        if (this.scanner.matchMultiple(c) < delimiterProcessor.getMinLength()) {
            this.scanner.setPosition(position);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        this.scanner.setPosition(position);
        while (this.scanner.next(c)) {
            Scanner scanner = this.scanner;
            arrayList.add(text(scanner.getSource(position, scanner.position())));
            position = this.scanner.position();
        }
        int iPeekCodePoint = this.scanner.peekCodePoint();
        boolean z2 = true;
        boolean z3 = iPeekPreviousCodePoint == 0 || Parsing.isPunctuationCodePoint(iPeekPreviousCodePoint);
        boolean z4 = iPeekPreviousCodePoint == 0 || Parsing.isWhitespaceCodePoint(iPeekPreviousCodePoint);
        boolean z5 = iPeekCodePoint == 0 || Parsing.isPunctuationCodePoint(iPeekCodePoint);
        boolean z6 = iPeekCodePoint == 0 || Parsing.isWhitespaceCodePoint(iPeekCodePoint);
        boolean z7 = !z6 && (!z5 || z4 || z3);
        boolean z8 = !z4 && (!z3 || z6 || z5);
        if (c == '_') {
            z = z7 && (!z8 || z3);
            if (!z8 || (z7 && !z5)) {
                z2 = false;
            }
        } else {
            boolean z9 = z7 && c == delimiterProcessor.getOpeningCharacter();
            z2 = z8 && c == delimiterProcessor.getClosingCharacter();
            z = z9;
        }
        return new DelimiterData(arrayList, z, z2);
    }

    private void processDelimiters(Delimiter delimiter) {
        boolean z;
        HashMap map = new HashMap();
        Delimiter delimiter2 = this.lastDelimiter;
        while (delimiter2 != null) {
            Delimiter delimiter3 = delimiter2.previous;
            if (delimiter3 == delimiter) {
                break;
            } else {
                delimiter2 = delimiter3;
            }
        }
        while (delimiter2 != null) {
            char c = delimiter2.delimiterChar;
            DelimiterProcessor delimiterProcessor = (DelimiterProcessor) this.delimiterProcessors.get(Character.valueOf(c));
            if (!delimiter2.canClose() || delimiterProcessor == null) {
                delimiter2 = delimiter2.next;
            } else {
                char openingCharacter = delimiterProcessor.getOpeningCharacter();
                Delimiter delimiter4 = delimiter2.previous;
                int iProcess = 0;
                boolean z2 = false;
                while (true) {
                    if (delimiter4 == null || delimiter4 == delimiter || delimiter4 == map.get(Character.valueOf(c))) {
                        z = false;
                        break;
                    }
                    if (delimiter4.canOpen() && delimiter4.delimiterChar == openingCharacter) {
                        iProcess = delimiterProcessor.process(delimiter4, delimiter2);
                        if (iProcess > 0) {
                            z = true;
                            z2 = true;
                            break;
                        }
                        z2 = true;
                    }
                    delimiter4 = delimiter4.previous;
                }
                if (!z) {
                    if (!z2) {
                        map.put(Character.valueOf(c), delimiter2.previous);
                        if (!delimiter2.canOpen()) {
                            removeDelimiterKeepNode(delimiter2);
                        }
                    }
                    delimiter2 = delimiter2.next;
                } else {
                    for (int i = 0; i < iProcess; i++) {
                        List list = delimiter4.characters;
                        ((Text) list.remove(list.size() - 1)).unlink();
                    }
                    for (int i2 = 0; i2 < iProcess; i2++) {
                        ((Text) delimiter2.characters.remove(0)).unlink();
                    }
                    removeDelimitersBetween(delimiter4, delimiter2);
                    if (delimiter4.length() == 0) {
                        removeDelimiterAndNodes(delimiter4);
                    }
                    if (delimiter2.length() == 0) {
                        Delimiter delimiter5 = delimiter2.next;
                        removeDelimiterAndNodes(delimiter2);
                        delimiter2 = delimiter5;
                    }
                }
            }
        }
        while (true) {
            Delimiter delimiter6 = this.lastDelimiter;
            if (delimiter6 == null || delimiter6 == delimiter) {
                return;
            } else {
                removeDelimiterKeepNode(delimiter6);
            }
        }
    }

    private void removeDelimitersBetween(Delimiter delimiter, Delimiter delimiter2) {
        Delimiter delimiter3 = delimiter2.previous;
        while (delimiter3 != null && delimiter3 != delimiter) {
            Delimiter delimiter4 = delimiter3.previous;
            removeDelimiterKeepNode(delimiter3);
            delimiter3 = delimiter4;
        }
    }

    private void removeDelimiterAndNodes(Delimiter delimiter) {
        removeDelimiter(delimiter);
    }

    private void removeDelimiterKeepNode(Delimiter delimiter) {
        removeDelimiter(delimiter);
    }

    private void removeDelimiter(Delimiter delimiter) {
        Delimiter delimiter2 = delimiter.previous;
        if (delimiter2 != null) {
            delimiter2.next = delimiter.next;
        }
        Delimiter delimiter3 = delimiter.next;
        if (delimiter3 == null) {
            this.lastDelimiter = delimiter2;
        } else {
            delimiter3.previous = delimiter2;
        }
    }

    private void mergeChildTextNodes(Node node) {
        if (node.getFirstChild() == null) {
            return;
        }
        mergeTextNodesInclusive(node.getFirstChild(), node.getLastChild());
    }

    private void mergeTextNodesInclusive(Node node, Node node2) {
        Text text = null;
        Text text2 = null;
        int length = 0;
        while (node != null) {
            if (node instanceof Text) {
                text2 = (Text) node;
                if (text == null) {
                    text = text2;
                }
                length += text2.getLiteral().length();
            } else {
                mergeIfNeeded(text, text2, length);
                mergeChildTextNodes(node);
                text = null;
                text2 = null;
                length = 0;
            }
            if (node == node2) {
                break;
            } else {
                node = node.getNext();
            }
        }
        mergeIfNeeded(text, text2, length);
    }

    private void mergeIfNeeded(Text text, Text text2, int i) {
        SourceSpans sourceSpans;
        if (text == null || text2 == null || text == text2) {
            return;
        }
        StringBuilder sb = new StringBuilder(i);
        sb.append(text.getLiteral());
        if (this.includeSourceSpans) {
            sourceSpans = new SourceSpans();
            sourceSpans.addAll(text.getSourceSpans());
        } else {
            sourceSpans = null;
        }
        Node next = text.getNext();
        Node next2 = text2.getNext();
        while (next != next2) {
            sb.append(((Text) next).getLiteral());
            if (sourceSpans != null) {
                sourceSpans.addAll(next.getSourceSpans());
            }
            Node next3 = next.getNext();
            next.unlink();
            next = next3;
        }
        text.setLiteral(sb.toString());
        if (sourceSpans != null) {
            text.setSourceSpans(sourceSpans.getSourceSpans());
        }
    }

    private static class DelimiterData {
        final boolean canClose;
        final boolean canOpen;
        final List characters;

        DelimiterData(List list, boolean z, boolean z2) {
            this.characters = list;
            this.canOpen = z;
            this.canClose = z2;
        }
    }
}
