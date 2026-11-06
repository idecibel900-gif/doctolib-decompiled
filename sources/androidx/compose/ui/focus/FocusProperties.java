package androidx.compose.ui.focus;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public interface FocusProperties {
    boolean getCanFocus();

    void setCanFocus(boolean z);

    default void setEnter(Function1 function1) {
    }

    default void setExit(Function1 function1) {
    }

    default FocusRequester getNext() {
        return FocusRequester.Companion.getDefault();
    }

    default FocusRequester getPrevious() {
        return FocusRequester.Companion.getDefault();
    }

    default FocusRequester getUp() {
        return FocusRequester.Companion.getDefault();
    }

    default FocusRequester getDown() {
        return FocusRequester.Companion.getDefault();
    }

    default FocusRequester getLeft() {
        return FocusRequester.Companion.getDefault();
    }

    default FocusRequester getRight() {
        return FocusRequester.Companion.getDefault();
    }

    default FocusRequester getStart() {
        return FocusRequester.Companion.getDefault();
    }

    default FocusRequester getEnd() {
        return FocusRequester.Companion.getDefault();
    }

    default Function1 getEnter() {
        return new Function1() { // from class: androidx.compose.ui.focus.FocusProperties$enter$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return m1181invoke3ESFkO8(((FocusDirection) obj).m1158unboximpl());
            }

            /* JADX INFO: renamed from: invoke-3ESFkO8, reason: not valid java name */
            public final FocusRequester m1181invoke3ESFkO8(int i) {
                return FocusRequester.Companion.getDefault();
            }
        };
    }

    default Function1 getExit() {
        return new Function1() { // from class: androidx.compose.ui.focus.FocusProperties$exit$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return m1182invoke3ESFkO8(((FocusDirection) obj).m1158unboximpl());
            }

            /* JADX INFO: renamed from: invoke-3ESFkO8, reason: not valid java name */
            public final FocusRequester m1182invoke3ESFkO8(int i) {
                return FocusRequester.Companion.getDefault();
            }
        };
    }
}
