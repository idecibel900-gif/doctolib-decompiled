package androidx.constraintlayout.core.parser;

import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class CLKey extends CLContainer {
    private static ArrayList sSections;

    static {
        ArrayList arrayList = new ArrayList();
        sSections = arrayList;
        arrayList.add("ConstraintSets");
        sSections.add("Variables");
        sSections.add("Generate");
        sSections.add("Transitions");
        sSections.add("KeyFrames");
        sSections.add("KeyAttributes");
        sSections.add("KeyPositions");
        sSections.add("KeyCycles");
    }

    public CLKey(char[] cArr) {
        super(cArr);
    }

    public static CLElement allocate(String str, CLElement cLElement) {
        CLKey cLKey = new CLKey(str.toCharArray());
        cLKey.setStart(0L);
        cLKey.setEnd(str.length() - 1);
        cLKey.set(cLElement);
        return cLKey;
    }

    public String getName() {
        return content();
    }

    public void set(CLElement cLElement) {
        if (this.mElements.size() > 0) {
            this.mElements.set(0, cLElement);
        } else {
            this.mElements.add(cLElement);
        }
    }

    public CLElement getValue() {
        if (this.mElements.size() > 0) {
            return (CLElement) this.mElements.get(0);
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.parser.CLContainer, androidx.constraintlayout.core.parser.CLElement
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CLKey) || Objects.equals(getName(), ((CLKey) obj).getName())) {
            return super.equals(obj);
        }
        return false;
    }

    @Override // androidx.constraintlayout.core.parser.CLContainer, androidx.constraintlayout.core.parser.CLElement
    public int hashCode() {
        return super.hashCode();
    }
}
