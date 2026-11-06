package com.google.common.base;

import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class Joiner {
    private final String separator;

    public static Joiner on(String str) {
        return new Joiner(str);
    }

    public static Joiner on(char c) {
        return new Joiner(String.valueOf(c));
    }

    private Joiner(String str) {
        this.separator = (String) Preconditions.checkNotNull(str);
    }

    public Appendable appendTo(Appendable appendable, Iterator it) throws IOException {
        Preconditions.checkNotNull(appendable);
        if (it.hasNext()) {
            appendable.append(toString(it.next()));
            while (it.hasNext()) {
                appendable.append(this.separator);
                appendable.append(toString(it.next()));
            }
        }
        return appendable;
    }

    public final StringBuilder appendTo(StringBuilder sb, Iterable iterable) {
        return appendTo(sb, iterable.iterator());
    }

    public final StringBuilder appendTo(StringBuilder sb, Iterator it) {
        try {
            appendTo((Appendable) sb, it);
            return sb;
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public String join(Iterable iterable) {
        return join(iterable.iterator());
    }

    public final String join(Iterator it) {
        return appendTo(new StringBuilder(), it).toString();
    }

    CharSequence toString(Object obj) {
        Objects.requireNonNull(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }
}
