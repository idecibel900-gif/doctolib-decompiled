package androidx.constraintlayout.core.parser;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class CLObject extends CLContainer implements Iterable {
    public CLObject(char[] cArr) {
        super(cArr);
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new CLObjectIterator(this);
    }

    private static class CLObjectIterator implements Iterator {
        int mIndex = 0;
        CLObject mObject;

        CLObjectIterator(CLObject cLObject) {
            this.mObject = cLObject;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.mIndex < this.mObject.size();
        }

        @Override // java.util.Iterator
        public CLKey next() {
            CLKey cLKey = (CLKey) this.mObject.mElements.get(this.mIndex);
            this.mIndex++;
            return cLKey;
        }
    }

    @Override // androidx.constraintlayout.core.parser.CLContainer, androidx.constraintlayout.core.parser.CLElement
    /* JADX INFO: renamed from: clone */
    public CLObject mo2697clone() {
        return (CLObject) super.mo2697clone();
    }
}
