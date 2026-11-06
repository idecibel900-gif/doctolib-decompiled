package org.commonmark.internal.inline;

import org.commonmark.internal.util.AsciiMatcher;
import org.commonmark.internal.util.Html5Entities;
import org.commonmark.node.Text;

/* JADX INFO: loaded from: classes5.dex */
public class EntityInlineParser implements InlineContentParser {
    private static final AsciiMatcher entityContinue;
    private static final AsciiMatcher entityStart;
    private static final AsciiMatcher hex = AsciiMatcher.builder().range('0', '9').range('A', 'F').range('a', 'f').build();
    private static final AsciiMatcher dec = AsciiMatcher.builder().range('0', '9').build();

    static {
        AsciiMatcher asciiMatcherBuild = AsciiMatcher.builder().range('A', 'Z').range('a', 'z').build();
        entityStart = asciiMatcherBuild;
        entityContinue = asciiMatcherBuild.newBuilder().range('0', '9').build();
    }

    @Override // org.commonmark.internal.inline.InlineContentParser
    public ParsedInline tryParse(InlineParserState inlineParserState) {
        Scanner scanner = inlineParserState.scanner();
        Position position = scanner.position();
        scanner.next();
        char cPeek = scanner.peek();
        if (cPeek == '#') {
            scanner.next();
            if (scanner.next('x') || scanner.next('X')) {
                int iMatch = scanner.match(hex);
                if (1 <= iMatch && iMatch <= 6 && scanner.next(';')) {
                    return entity(scanner, position);
                }
            } else {
                int iMatch2 = scanner.match(dec);
                if (1 <= iMatch2 && iMatch2 <= 7 && scanner.next(';')) {
                    return entity(scanner, position);
                }
            }
        } else if (entityStart.matches(cPeek)) {
            scanner.match(entityContinue);
            if (scanner.next(';')) {
                return entity(scanner, position);
            }
        }
        return ParsedInline.none();
    }

    private ParsedInline entity(Scanner scanner, Position position) {
        return ParsedInline.of(new Text(Html5Entities.entityToString(scanner.getSource(position, scanner.position()).getContent())), scanner.position());
    }
}
