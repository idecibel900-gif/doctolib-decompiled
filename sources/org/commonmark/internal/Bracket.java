package org.commonmark.internal;

import org.commonmark.internal.inline.Position;
import org.commonmark.node.Text;

/* JADX INFO: loaded from: classes5.dex */
public class Bracket {
    public boolean allowed = true;
    public boolean bracketAfter = false;
    public final Position contentPosition;
    public final boolean image;
    public final Position markerPosition;
    public final Text node;
    public final Bracket previous;
    public final Delimiter previousDelimiter;

    public static Bracket link(Text text, Position position, Position position2, Bracket bracket, Delimiter delimiter) {
        return new Bracket(text, position, position2, bracket, delimiter, false);
    }

    public static Bracket image(Text text, Position position, Position position2, Bracket bracket, Delimiter delimiter) {
        return new Bracket(text, position, position2, bracket, delimiter, true);
    }

    private Bracket(Text text, Position position, Position position2, Bracket bracket, Delimiter delimiter, boolean z) {
        this.node = text;
        this.markerPosition = position;
        this.contentPosition = position2;
        this.image = z;
        this.previous = bracket;
        this.previousDelimiter = delimiter;
    }
}
