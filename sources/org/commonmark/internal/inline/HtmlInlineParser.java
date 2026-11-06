package org.commonmark.internal.inline;

import com.amazon.a.a.o.c.a.b;
import org.commonmark.internal.util.AsciiMatcher;
import org.commonmark.node.HtmlInline;

/* JADX INFO: loaded from: classes5.dex */
public class HtmlInlineParser implements InlineContentParser {
    private static final AsciiMatcher asciiLetter;
    private static final AsciiMatcher attributeContinue;
    private static final AsciiMatcher attributeStart;
    private static final AsciiMatcher attributeValueEnd;
    private static final AsciiMatcher tagNameContinue;
    private static final AsciiMatcher tagNameStart;

    static {
        AsciiMatcher asciiMatcherBuild = AsciiMatcher.builder().range('A', 'Z').range('a', 'z').build();
        asciiLetter = asciiMatcherBuild;
        tagNameStart = asciiMatcherBuild;
        tagNameContinue = asciiMatcherBuild.newBuilder().range('0', '9').c('-').build();
        AsciiMatcher asciiMatcherBuild2 = asciiMatcherBuild.newBuilder().c('_').c(':').build();
        attributeStart = asciiMatcherBuild2;
        attributeContinue = asciiMatcherBuild2.newBuilder().range('0', '9').c(b.a).c('-').build();
        attributeValueEnd = AsciiMatcher.builder().c(' ').c('\t').c('\n').c((char) 11).c('\f').c('\r').c('\"').c('\'').c('=').c('<').c('>').c('`').build();
    }

    @Override // org.commonmark.internal.inline.InlineContentParser
    public ParsedInline tryParse(InlineParserState inlineParserState) {
        Scanner scanner = inlineParserState.scanner();
        Position position = scanner.position();
        scanner.next();
        char cPeek = scanner.peek();
        if (tagNameStart.matches(cPeek)) {
            if (tryOpenTag(scanner)) {
                return htmlInline(position, scanner);
            }
        } else if (cPeek == '/') {
            if (tryClosingTag(scanner)) {
                return htmlInline(position, scanner);
            }
        } else if (cPeek == '?') {
            if (tryProcessingInstruction(scanner)) {
                return htmlInline(position, scanner);
            }
        } else if (cPeek == '!') {
            scanner.next();
            char cPeek2 = scanner.peek();
            if (cPeek2 == '-') {
                if (tryComment(scanner)) {
                    return htmlInline(position, scanner);
                }
            } else if (cPeek2 == '[') {
                if (tryCdata(scanner)) {
                    return htmlInline(position, scanner);
                }
            } else if (asciiLetter.matches(cPeek2) && tryDeclaration(scanner)) {
                return htmlInline(position, scanner);
            }
        }
        return ParsedInline.none();
    }

    private static ParsedInline htmlInline(Position position, Scanner scanner) {
        String content = scanner.getSource(position, scanner.position()).getContent();
        HtmlInline htmlInline = new HtmlInline();
        htmlInline.setLiteral(content);
        return ParsedInline.of(htmlInline, scanner.position());
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x006b -> B:4:0x0010). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:6:0x0013
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    private static boolean tryOpenTag(org.commonmark.internal.inline.Scanner r4) {
        /*
            r4.next()
            org.commonmark.internal.util.AsciiMatcher r0 = org.commonmark.internal.inline.HtmlInlineParser.tagNameContinue
            r4.match(r0)
            int r0 = r4.whitespace()
            r1 = 0
            r2 = 1
            if (r0 < r2) goto L12
        L10:
            r0 = r2
            goto L13
        L12:
            r0 = r1
        L13:
            if (r0 == 0) goto L6e
            org.commonmark.internal.util.AsciiMatcher r0 = org.commonmark.internal.inline.HtmlInlineParser.attributeStart
            int r0 = r4.match(r0)
            if (r0 < r2) goto L6e
            org.commonmark.internal.util.AsciiMatcher r0 = org.commonmark.internal.inline.HtmlInlineParser.attributeContinue
            r4.match(r0)
            int r0 = r4.whitespace()
            if (r0 < r2) goto L2a
            r0 = r2
            goto L2b
        L2a:
            r0 = r1
        L2b:
            r3 = 61
            boolean r3 = r4.next(r3)
            if (r3 == 0) goto L13
            r4.whitespace()
            char r0 = r4.peek()
            r3 = 39
            if (r0 != r3) goto L4c
            r4.next()
            int r0 = r4.find(r3)
            if (r0 >= 0) goto L48
            return r1
        L48:
            r4.next()
            goto L67
        L4c:
            r3 = 34
            if (r0 != r3) goto L5e
            r4.next()
            int r0 = r4.find(r3)
            if (r0 >= 0) goto L5a
            return r1
        L5a:
            r4.next()
            goto L67
        L5e:
            org.commonmark.internal.util.AsciiMatcher r0 = org.commonmark.internal.inline.HtmlInlineParser.attributeValueEnd
            int r0 = r4.find(r0)
            if (r0 > 0) goto L67
            return r1
        L67:
            int r0 = r4.whitespace()
            if (r0 < r2) goto L12
            goto L10
        L6e:
            r0 = 47
            r4.next(r0)
            r0 = 62
            boolean r4 = r4.next(r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.commonmark.internal.inline.HtmlInlineParser.tryOpenTag(org.commonmark.internal.inline.Scanner):boolean");
    }

    private static boolean tryClosingTag(Scanner scanner) {
        scanner.next();
        if (scanner.match(tagNameStart) < 1) {
            return false;
        }
        scanner.match(tagNameContinue);
        scanner.whitespace();
        return scanner.next('>');
    }

    private static boolean tryProcessingInstruction(Scanner scanner) {
        scanner.next();
        while (scanner.find('?') > 0) {
            scanner.next();
            if (scanner.next('>')) {
                return true;
            }
        }
        return false;
    }

    private static boolean tryComment(Scanner scanner) {
        scanner.next();
        if (scanner.next('-') && !scanner.next('>') && !scanner.next("->")) {
            while (scanner.find('-') >= 0) {
                if (scanner.next("--")) {
                    return scanner.next('>');
                }
                scanner.next();
            }
        }
        return false;
    }

    private static boolean tryCdata(Scanner scanner) {
        scanner.next();
        if (!scanner.next("CDATA[")) {
            return false;
        }
        while (scanner.find(']') >= 0) {
            if (scanner.next("]]>")) {
                return true;
            }
            scanner.next();
        }
        return false;
    }

    private static boolean tryDeclaration(Scanner scanner) {
        scanner.match(asciiLetter);
        if (scanner.whitespace() <= 0 || scanner.find('>') < 0) {
            return false;
        }
        scanner.next();
        return true;
    }
}
