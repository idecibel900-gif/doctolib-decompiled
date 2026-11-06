package androidx.compose.foundation.text;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class KeyboardActions {
    public static final Companion Companion = new Companion(null);
    private static final KeyboardActions Default = new KeyboardActions(null, null, null, null, null, null, 63, null);
    private final Function1 onDone;
    private final Function1 onGo;
    private final Function1 onNext;
    private final Function1 onPrevious;
    private final Function1 onSearch;
    private final Function1 onSend;

    public KeyboardActions(Function1 function1, Function1 function2, Function1 function3, Function1 function4, Function1 function5, Function1 function6) {
        this.onDone = function1;
        this.onGo = function2;
        this.onNext = function3;
        this.onPrevious = function4;
        this.onSearch = function5;
        this.onSend = function6;
    }

    public /* synthetic */ KeyboardActions(Function1 function1, Function1 function2, Function1 function3, Function1 function4, Function1 function5, Function1 function6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : function1, (i & 2) != 0 ? null : function2, (i & 4) != 0 ? null : function3, (i & 8) != 0 ? null : function4, (i & 16) != 0 ? null : function5, (i & 32) != 0 ? null : function6);
    }

    public final Function1 getOnDone() {
        return this.onDone;
    }

    public final Function1 getOnGo() {
        return this.onGo;
    }

    public final Function1 getOnNext() {
        return this.onNext;
    }

    public final Function1 getOnPrevious() {
        return this.onPrevious;
    }

    public final Function1 getOnSearch() {
        return this.onSearch;
    }

    public final Function1 getOnSend() {
        return this.onSend;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KeyboardActions)) {
            return false;
        }
        KeyboardActions keyboardActions = (KeyboardActions) obj;
        return this.onDone == keyboardActions.onDone && this.onGo == keyboardActions.onGo && this.onNext == keyboardActions.onNext && this.onPrevious == keyboardActions.onPrevious && this.onSearch == keyboardActions.onSearch && this.onSend == keyboardActions.onSend;
    }

    public int hashCode() {
        Function1 function1 = this.onDone;
        int iHashCode = (function1 != null ? function1.hashCode() : 0) * 31;
        Function1 function2 = this.onGo;
        int iHashCode2 = (iHashCode + (function2 != null ? function2.hashCode() : 0)) * 31;
        Function1 function3 = this.onNext;
        int iHashCode3 = (iHashCode2 + (function3 != null ? function3.hashCode() : 0)) * 31;
        Function1 function4 = this.onPrevious;
        int iHashCode4 = (iHashCode3 + (function4 != null ? function4.hashCode() : 0)) * 31;
        Function1 function5 = this.onSearch;
        int iHashCode5 = (iHashCode4 + (function5 != null ? function5.hashCode() : 0)) * 31;
        Function1 function6 = this.onSend;
        return iHashCode5 + (function6 != null ? function6.hashCode() : 0);
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KeyboardActions getDefault() {
            return KeyboardActions.Default;
        }
    }
}
