package androidx.collection;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class ObjectList {
    public int _size;
    public Object[] content;

    public /* synthetic */ ObjectList(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }

    private ObjectList(int i) {
        Object[] objArr;
        if (i == 0) {
            objArr = ObjectListKt.EmptyArray;
        } else {
            objArr = new Object[i];
        }
        this.content = objArr;
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    public int hashCode() {
        Object[] objArr = this.content;
        int i = this._size;
        int iHashCode = 0;
        for (int i2 = 0; i2 < i; i2++) {
            Object obj = objArr[i2];
            iHashCode += (obj != null ? obj.hashCode() : 0) * 31;
        }
        return iHashCode;
    }

    public final int indexOf(Object obj) {
        int i = 0;
        if (obj == null) {
            Object[] objArr = this.content;
            int i2 = this._size;
            while (i < i2) {
                if (objArr[i] == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        Object[] objArr2 = this.content;
        int i3 = this._size;
        while (i < i3) {
            if (obj.equals(objArr2[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static /* synthetic */ String joinToString$default(ObjectList objectList, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        }
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i2 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i2 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i2 & 8) != 0) {
            i = -1;
        }
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i2 & 32) != 0) {
            function1 = null;
        }
        CharSequence charSequence5 = charSequence4;
        Function1 function2 = function1;
        return objectList.joinToString(charSequence, charSequence2, charSequence3, i, charSequence5, function2);
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int i, CharSequence truncated, Function1 function1) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        Object[] objArr = this.content;
        int i2 = this._size;
        for (int i3 = 0; i3 < i2; i3++) {
            Object obj = objArr[i3];
            if (i3 == i) {
                sb.append(truncated);
                String string = sb.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                return string;
            }
            if (i3 != 0) {
                sb.append(separator);
            }
            if (function1 == null) {
                sb.append(obj);
            } else {
                sb.append((CharSequence) function1.invoke(obj));
            }
        }
        sb.append(postfix);
        String string2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        return string2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ObjectList) {
            ObjectList objectList = (ObjectList) obj;
            int i = objectList._size;
            int i2 = this._size;
            if (i == i2) {
                Object[] objArr = this.content;
                Object[] objArr2 = objectList.content;
                IntRange intRangeUntil = RangesKt.until(0, i2);
                int first = intRangeUntil.getFirst();
                int last = intRangeUntil.getLast();
                if (first > last) {
                    return true;
                }
                while (Intrinsics.areEqual(objArr[first], objArr2[first])) {
                    if (first == last) {
                        return true;
                    }
                    first++;
                }
                return false;
            }
        }
        return false;
    }

    public String toString() {
        return joinToString$default(this, null, "[", "]", 0, null, new Function1() { // from class: androidx.collection.ObjectList.toString.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(Object obj) {
                if (obj == ObjectList.this) {
                    return "(this)";
                }
                return String.valueOf(obj);
            }
        }, 25, null);
    }
}
