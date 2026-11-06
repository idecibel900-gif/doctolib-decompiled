package io.sentry.android.core.internal.threaddump;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public final class Lines {
    private final ArrayList mList;
    private final int mMax;
    private final int mMin = 0;
    public int pos;

    public static Lines readLines(BufferedReader bufferedReader) throws IOException {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            String line = bufferedReader.readLine();
            if (line != null) {
                i++;
                arrayList.add(new Line(i, line));
            } else {
                return new Lines(arrayList);
            }
        }
    }

    public Lines(ArrayList arrayList) {
        this.mList = arrayList;
        this.mMax = arrayList.size();
    }

    public boolean hasNext() {
        return this.pos < this.mMax;
    }

    public Line next() {
        int i = this.pos;
        if (i < this.mMin || i >= this.mMax) {
            return null;
        }
        ArrayList arrayList = this.mList;
        this.pos = i + 1;
        return (Line) arrayList.get(i);
    }

    public void rewind() {
        this.pos--;
    }
}
