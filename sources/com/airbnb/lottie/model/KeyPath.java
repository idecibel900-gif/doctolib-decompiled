package com.airbnb.lottie.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class KeyPath {
    public static final KeyPath COMPOSITION = new KeyPath("COMPOSITION");
    private final List keys;
    private KeyPathElement resolvedElement;

    public KeyPath(String... strArr) {
        this.keys = Arrays.asList(strArr);
    }

    private KeyPath(KeyPath keyPath) {
        this.keys = new ArrayList(keyPath.keys);
        this.resolvedElement = keyPath.resolvedElement;
    }

    public KeyPath addKey(String str) {
        KeyPath keyPath = new KeyPath(this);
        keyPath.keys.add(str);
        return keyPath;
    }

    public KeyPath resolve(KeyPathElement keyPathElement) {
        KeyPath keyPath = new KeyPath(this);
        keyPath.resolvedElement = keyPathElement;
        return keyPath;
    }

    public KeyPathElement getResolvedElement() {
        return this.resolvedElement;
    }

    public boolean matches(String str, int i) {
        if (isContainer(str)) {
            return true;
        }
        if (i >= this.keys.size()) {
            return false;
        }
        return ((String) this.keys.get(i)).equals(str) || ((String) this.keys.get(i)).equals("**") || ((String) this.keys.get(i)).equals("*");
    }

    public int incrementDepthBy(String str, int i) {
        if (isContainer(str)) {
            return 0;
        }
        if (((String) this.keys.get(i)).equals("**")) {
            return (i != this.keys.size() - 1 && ((String) this.keys.get(i + 1)).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    public boolean fullyResolvesTo(String str, int i) {
        if (i >= this.keys.size()) {
            return false;
        }
        boolean z = i == this.keys.size() - 1;
        String str2 = (String) this.keys.get(i);
        if (!str2.equals("**")) {
            return (z || (i == this.keys.size() + (-2) && endsWithGlobstar())) && (str2.equals(str) || str2.equals("*"));
        }
        if (!z && ((String) this.keys.get(i + 1)).equals(str)) {
            return i == this.keys.size() + (-2) || (i == this.keys.size() + (-3) && endsWithGlobstar());
        }
        if (z) {
            return true;
        }
        int i2 = i + 1;
        if (i2 < this.keys.size() - 1) {
            return false;
        }
        return ((String) this.keys.get(i2)).equals(str);
    }

    public boolean propagateToChildren(String str, int i) {
        return "__container".equals(str) || i < this.keys.size() - 1 || ((String) this.keys.get(i)).equals("**");
    }

    private boolean isContainer(String str) {
        return "__container".equals(str);
    }

    private boolean endsWithGlobstar() {
        List list = this.keys;
        return ((String) list.get(list.size() - 1)).equals("**");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            KeyPath keyPath = (KeyPath) obj;
            if (!this.keys.equals(keyPath.keys)) {
                return false;
            }
            KeyPathElement keyPathElement = this.resolvedElement;
            KeyPathElement keyPathElement2 = keyPath.resolvedElement;
            if (keyPathElement != null) {
                return keyPathElement.equals(keyPathElement2);
            }
            if (keyPathElement2 == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = this.keys.hashCode() * 31;
        KeyPathElement keyPathElement = this.resolvedElement;
        return iHashCode + (keyPathElement != null ? keyPathElement.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KeyPath{keys=");
        sb.append(this.keys);
        sb.append(",resolved=");
        sb.append(this.resolvedElement != null);
        sb.append('}');
        return sb.toString();
    }
}
