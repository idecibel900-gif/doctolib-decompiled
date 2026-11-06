package org.commonmark.internal.inline;

import com.opentok.android.BaseVideoCapturer;
import com.revenuecat.purchases.common.verification.SigningManager;
import java.util.List;
import org.commonmark.internal.util.CharMatcher;
import org.commonmark.node.SourceSpan;
import org.commonmark.parser.SourceLine;
import org.commonmark.parser.SourceLines;

/* JADX INFO: loaded from: classes5.dex */
public class Scanner {
    private int index;
    private int lineIndex;
    private final List lines;
    private SourceLine line = SourceLine.of("", null);
    private int lineLength = 0;

    Scanner(List list, int i, int i2) {
        this.lines = list;
        this.lineIndex = i;
        this.index = i2;
        if (list.isEmpty()) {
            return;
        }
        checkPosition(i, i2);
        setLine((SourceLine) list.get(i));
    }

    public static Scanner of(SourceLines sourceLines) {
        return new Scanner(sourceLines.getLines(), 0, 0);
    }

    public char peek() {
        if (this.index < this.lineLength) {
            return this.line.getContent().charAt(this.index);
        }
        return this.lineIndex < this.lines.size() + (-1) ? '\n' : (char) 0;
    }

    public int peekCodePoint() {
        if (this.index >= this.lineLength) {
            return this.lineIndex < this.lines.size() + (-1) ? 10 : 0;
        }
        char cCharAt = this.line.getContent().charAt(this.index);
        if (!Character.isHighSurrogate(cCharAt) || this.index + 1 >= this.lineLength) {
            return cCharAt;
        }
        char cCharAt2 = this.line.getContent().charAt(this.index + 1);
        return Character.isLowSurrogate(cCharAt2) ? Character.toCodePoint(cCharAt, cCharAt2) : cCharAt;
    }

    public int peekPreviousCodePoint() {
        int i = this.index;
        if (i <= 0) {
            return this.lineIndex > 0 ? 10 : 0;
        }
        int i2 = i - 1;
        char cCharAt = this.line.getContent().charAt(i2);
        if (Character.isLowSurrogate(cCharAt) && i2 > 0) {
            char cCharAt2 = this.line.getContent().charAt(i - 2);
            if (Character.isHighSurrogate(cCharAt2)) {
                return Character.toCodePoint(cCharAt2, cCharAt);
            }
        }
        return cCharAt;
    }

    public boolean hasNext() {
        return this.index < this.lineLength || this.lineIndex < this.lines.size() - 1;
    }

    public void next() {
        int i = this.index + 1;
        this.index = i;
        if (i > this.lineLength) {
            int i2 = this.lineIndex + 1;
            this.lineIndex = i2;
            if (i2 < this.lines.size()) {
                setLine((SourceLine) this.lines.get(this.lineIndex));
            } else {
                setLine(SourceLine.of("", null));
            }
            this.index = 0;
        }
    }

    public boolean next(char c) {
        if (peek() != c) {
            return false;
        }
        next();
        return true;
    }

    public boolean next(String str) {
        int i = this.index;
        if (i >= this.lineLength || i + str.length() > this.lineLength) {
            return false;
        }
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (this.line.getContent().charAt(this.index + i2) != str.charAt(i2)) {
                return false;
            }
        }
        this.index += str.length();
        return true;
    }

    public int matchMultiple(char c) {
        int i = 0;
        while (peek() == c) {
            i++;
            next();
        }
        return i;
    }

    public int match(CharMatcher charMatcher) {
        int i = 0;
        while (charMatcher.matches(peek())) {
            i++;
            next();
        }
        return i;
    }

    public int whitespace() {
        int i = 0;
        while (true) {
            char cPeek = peek();
            if (cPeek != ' ') {
                switch (cPeek) {
                    case '\t':
                    case '\n':
                    case BaseVideoCapturer.RGBA /* 11 */:
                    case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                    case '\r':
                        break;
                    default:
                        return i;
                }
            }
            i++;
            next();
        }
    }

    public int find(char c) {
        int i = 0;
        while (true) {
            char cPeek = peek();
            if (cPeek == 0) {
                return -1;
            }
            if (cPeek == c) {
                return i;
            }
            i++;
            next();
        }
    }

    public int find(CharMatcher charMatcher) {
        int i = 0;
        while (true) {
            char cPeek = peek();
            if (cPeek == 0) {
                return -1;
            }
            if (charMatcher.matches(cPeek)) {
                return i;
            }
            i++;
            next();
        }
    }

    public Position position() {
        return new Position(this.lineIndex, this.index);
    }

    public void setPosition(Position position) {
        checkPosition(position.lineIndex, position.index);
        int i = position.lineIndex;
        this.lineIndex = i;
        this.index = position.index;
        setLine((SourceLine) this.lines.get(i));
    }

    public SourceLines getSource(Position position, Position position2) {
        int i = position.lineIndex;
        if (i == position2.lineIndex) {
            SourceLine sourceLine = (SourceLine) this.lines.get(i);
            CharSequence charSequenceSubSequence = sourceLine.getContent().subSequence(position.index, position2.index);
            SourceSpan sourceSpan = sourceLine.getSourceSpan();
            return SourceLines.of(SourceLine.of(charSequenceSubSequence, sourceSpan != null ? SourceSpan.of(sourceSpan.getLineIndex(), sourceSpan.getColumnIndex() + position.index, charSequenceSubSequence.length()) : null));
        }
        SourceLines sourceLinesEmpty = SourceLines.empty();
        SourceLine sourceLine2 = (SourceLine) this.lines.get(position.lineIndex);
        sourceLinesEmpty.addLine(sourceLine2.substring(position.index, sourceLine2.getContent().length()));
        int i2 = position.lineIndex;
        while (true) {
            i2++;
            int i3 = position2.lineIndex;
            if (i2 < i3) {
                sourceLinesEmpty.addLine((SourceLine) this.lines.get(i2));
            } else {
                sourceLinesEmpty.addLine(((SourceLine) this.lines.get(i3)).substring(0, position2.index));
                return sourceLinesEmpty;
            }
        }
    }

    private void setLine(SourceLine sourceLine) {
        this.line = sourceLine;
        this.lineLength = sourceLine.getContent().length();
    }

    private void checkPosition(int i, int i2) {
        if (i < 0 || i >= this.lines.size()) {
            throw new IllegalArgumentException("Line index " + i + " out of range, number of lines: " + this.lines.size());
        }
        SourceLine sourceLine = (SourceLine) this.lines.get(i);
        if (i2 < 0 || i2 > sourceLine.getContent().length()) {
            throw new IllegalArgumentException("Index " + i2 + " out of range, line length: " + sourceLine.getContent().length());
        }
    }
}
