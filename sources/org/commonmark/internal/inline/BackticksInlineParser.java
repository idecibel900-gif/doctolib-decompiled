package org.commonmark.internal.inline;

import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Code;
import org.commonmark.node.Text;

/* JADX INFO: loaded from: classes5.dex */
public class BackticksInlineParser implements InlineContentParser {
    @Override // org.commonmark.internal.inline.InlineContentParser
    public ParsedInline tryParse(InlineParserState inlineParserState) {
        Scanner scanner = inlineParserState.scanner();
        Position position = scanner.position();
        int iMatchMultiple = scanner.matchMultiple('`');
        Position position2 = scanner.position();
        while (scanner.find('`') > 0) {
            Position position3 = scanner.position();
            if (scanner.matchMultiple('`') == iMatchMultiple) {
                Code code = new Code();
                String strReplace = scanner.getSource(position2, position3).getContent().replace('\n', ' ');
                if (strReplace.length() >= 3 && strReplace.charAt(0) == ' ' && strReplace.charAt(strReplace.length() - 1) == ' ' && Parsing.hasNonSpace(strReplace)) {
                    strReplace = strReplace.substring(1, strReplace.length() - 1);
                }
                code.setLiteral(strReplace);
                return ParsedInline.of(code, scanner.position());
            }
        }
        return ParsedInline.of(new Text(scanner.getSource(position, position2).getContent()), position2);
    }
}
