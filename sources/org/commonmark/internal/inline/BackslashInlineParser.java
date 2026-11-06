package org.commonmark.internal.inline;

import java.util.regex.Pattern;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.Text;

/* JADX INFO: loaded from: classes5.dex */
public class BackslashInlineParser implements InlineContentParser {
    private static final Pattern ESCAPABLE = Pattern.compile("^[!\"#$%&'()*+,./:;<=>?@\\[\\\\\\]^_`{|}~-]");

    @Override // org.commonmark.internal.inline.InlineContentParser
    public ParsedInline tryParse(InlineParserState inlineParserState) {
        Scanner scanner = inlineParserState.scanner();
        scanner.next();
        char cPeek = scanner.peek();
        if (cPeek == '\n') {
            scanner.next();
            return ParsedInline.of(new HardLineBreak(), scanner.position());
        }
        if (ESCAPABLE.matcher(String.valueOf(cPeek)).matches()) {
            scanner.next();
            return ParsedInline.of(new Text(String.valueOf(cPeek)), scanner.position());
        }
        return ParsedInline.of(new Text("\\"), scanner.position());
    }
}
