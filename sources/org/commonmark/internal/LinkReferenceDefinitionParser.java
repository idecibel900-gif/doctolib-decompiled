package org.commonmark.internal;

import java.util.ArrayList;
import java.util.List;
import org.commonmark.internal.inline.Position;
import org.commonmark.internal.inline.Scanner;
import org.commonmark.internal.util.Escaping;
import org.commonmark.internal.util.LinkScanner;
import org.commonmark.node.LinkReferenceDefinition;
import org.commonmark.node.SourceSpan;
import org.commonmark.parser.SourceLine;
import org.commonmark.parser.SourceLines;

/* JADX INFO: loaded from: classes5.dex */
public class LinkReferenceDefinitionParser {
    private String destination;
    private StringBuilder label;
    private StringBuilder title;
    private char titleDelimiter;
    private State state = State.START_DEFINITION;
    private final List paragraphLines = new ArrayList();
    private final List definitions = new ArrayList();
    private final List sourceSpans = new ArrayList();
    private boolean referenceValid = false;

    enum State {
        START_DEFINITION,
        LABEL,
        DESTINATION,
        START_TITLE,
        TITLE,
        PARAGRAPH
    }

    public void parse(SourceLine sourceLine) {
        boolean zStartDefinition;
        this.paragraphLines.add(sourceLine);
        if (this.state == State.PARAGRAPH) {
            return;
        }
        Scanner scannerOf = Scanner.of(SourceLines.of(sourceLine));
        while (scannerOf.hasNext()) {
            int i = AnonymousClass1.$SwitchMap$org$commonmark$internal$LinkReferenceDefinitionParser$State[this.state.ordinal()];
            if (i == 1) {
                zStartDefinition = startDefinition(scannerOf);
            } else if (i == 2) {
                zStartDefinition = label(scannerOf);
            } else if (i == 3) {
                zStartDefinition = destination(scannerOf);
            } else if (i == 4) {
                zStartDefinition = startTitle(scannerOf);
            } else if (i == 5) {
                zStartDefinition = title(scannerOf);
            } else {
                throw new IllegalStateException("Unknown parsing state: " + this.state);
            }
            if (!zStartDefinition) {
                this.state = State.PARAGRAPH;
                return;
            }
        }
    }

    /* JADX INFO: renamed from: org.commonmark.internal.LinkReferenceDefinitionParser$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$commonmark$internal$LinkReferenceDefinitionParser$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$org$commonmark$internal$LinkReferenceDefinitionParser$State = iArr;
            try {
                iArr[State.START_DEFINITION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$commonmark$internal$LinkReferenceDefinitionParser$State[State.LABEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$commonmark$internal$LinkReferenceDefinitionParser$State[State.DESTINATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$commonmark$internal$LinkReferenceDefinitionParser$State[State.START_TITLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$commonmark$internal$LinkReferenceDefinitionParser$State[State.TITLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public void addSourceSpan(SourceSpan sourceSpan) {
        this.sourceSpans.add(sourceSpan);
    }

    SourceLines getParagraphLines() {
        return SourceLines.of(this.paragraphLines);
    }

    List getParagraphSourceSpans() {
        return this.sourceSpans;
    }

    List getDefinitions() {
        finishReference();
        return this.definitions;
    }

    private boolean startDefinition(Scanner scanner) {
        scanner.whitespace();
        if (!scanner.next('[')) {
            return false;
        }
        this.state = State.LABEL;
        this.label = new StringBuilder();
        if (scanner.hasNext()) {
            return true;
        }
        this.label.append('\n');
        return true;
    }

    private boolean label(Scanner scanner) {
        Position position = scanner.position();
        if (!LinkScanner.scanLinkLabelContent(scanner)) {
            return false;
        }
        this.label.append(scanner.getSource(position, scanner.position()).getContent());
        if (!scanner.hasNext()) {
            this.label.append('\n');
            return true;
        }
        if (!scanner.next(']') || !scanner.next(':') || this.label.length() > 999 || Escaping.normalizeLabelContent(this.label.toString()).isEmpty()) {
            return false;
        }
        this.state = State.DESTINATION;
        scanner.whitespace();
        return true;
    }

    private boolean destination(Scanner scanner) {
        scanner.whitespace();
        Position position = scanner.position();
        if (!LinkScanner.scanLinkDestination(scanner)) {
            return false;
        }
        String content = scanner.getSource(position, scanner.position()).getContent();
        if (content.startsWith("<")) {
            content = content.substring(1, content.length() - 1);
        }
        this.destination = content;
        int iWhitespace = scanner.whitespace();
        if (!scanner.hasNext()) {
            this.referenceValid = true;
            this.paragraphLines.clear();
        } else if (iWhitespace == 0) {
            return false;
        }
        this.state = State.START_TITLE;
        return true;
    }

    private boolean startTitle(Scanner scanner) {
        scanner.whitespace();
        if (!scanner.hasNext()) {
            this.state = State.START_DEFINITION;
            return true;
        }
        this.titleDelimiter = (char) 0;
        char cPeek = scanner.peek();
        if (cPeek == '\"' || cPeek == '\'') {
            this.titleDelimiter = cPeek;
        } else if (cPeek == '(') {
            this.titleDelimiter = ')';
        }
        if (this.titleDelimiter != 0) {
            this.state = State.TITLE;
            this.title = new StringBuilder();
            scanner.next();
            if (!scanner.hasNext()) {
                this.title.append('\n');
            }
        } else {
            finishReference();
            this.state = State.START_DEFINITION;
        }
        return true;
    }

    private boolean title(Scanner scanner) {
        Position position = scanner.position();
        if (!LinkScanner.scanLinkTitleContent(scanner, this.titleDelimiter)) {
            return false;
        }
        this.title.append(scanner.getSource(position, scanner.position()).getContent());
        if (!scanner.hasNext()) {
            this.title.append('\n');
            return true;
        }
        scanner.next();
        scanner.whitespace();
        if (scanner.hasNext()) {
            return false;
        }
        this.referenceValid = true;
        finishReference();
        this.paragraphLines.clear();
        this.state = State.START_DEFINITION;
        return true;
    }

    private void finishReference() {
        if (this.referenceValid) {
            String strUnescapeString = Escaping.unescapeString(this.destination);
            StringBuilder sb = this.title;
            LinkReferenceDefinition linkReferenceDefinition = new LinkReferenceDefinition(this.label.toString(), strUnescapeString, sb != null ? Escaping.unescapeString(sb.toString()) : null);
            linkReferenceDefinition.setSourceSpans(this.sourceSpans);
            this.sourceSpans.clear();
            this.definitions.add(linkReferenceDefinition);
            this.label = null;
            this.referenceValid = false;
            this.destination = null;
            this.title = null;
        }
    }
}
