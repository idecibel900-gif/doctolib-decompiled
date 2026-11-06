package org.commonmark.internal.inline;

import java.util.regex.Pattern;
import org.commonmark.node.Link;
import org.commonmark.node.Text;
import org.commonmark.parser.SourceLines;

/* JADX INFO: loaded from: classes5.dex */
public class AutolinkInlineParser implements InlineContentParser {
    private static final Pattern URI = Pattern.compile("^[a-zA-Z][a-zA-Z0-9.+-]{1,31}:[^<>\u0000- ]*$");
    private static final Pattern EMAIL = Pattern.compile("^([a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*)$");

    @Override // org.commonmark.internal.inline.InlineContentParser
    public ParsedInline tryParse(InlineParserState inlineParserState) {
        String str;
        Scanner scanner = inlineParserState.scanner();
        scanner.next();
        Position position = scanner.position();
        if (scanner.find('>') > 0) {
            SourceLines source = scanner.getSource(position, scanner.position());
            String content = source.getContent();
            scanner.next();
            if (URI.matcher(content).matches()) {
                str = content;
            } else if (EMAIL.matcher(content).matches()) {
                str = "mailto:" + content;
            } else {
                str = null;
            }
            if (str != null) {
                Link link = new Link(str, null);
                Text text = new Text(content);
                text.setSourceSpans(source.getSourceSpans());
                link.appendChild(text);
                return ParsedInline.of(link, scanner.position());
            }
        }
        return ParsedInline.none();
    }
}
