package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public abstract class TransformedTextFieldState {
    private static final Companion Companion = new Companion(null);

    public static final /* synthetic */ InputTransformation access$getInputTransformation$p(TransformedTextFieldState transformedTextFieldState) {
        throw null;
    }

    public static final /* synthetic */ TextFieldState access$getTextFieldState$p(TransformedTextFieldState transformedTextFieldState) {
        throw null;
    }

    /* JADX INFO: renamed from: replaceText-M8tDOmk$default, reason: not valid java name */
    public static /* synthetic */ void m597replaceTextM8tDOmk$default(TransformedTextFieldState transformedTextFieldState, CharSequence charSequence, long j, TextFieldEditUndoBehavior textFieldEditUndoBehavior, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            TextFieldEditUndoBehavior textFieldEditUndoBehavior2 = TextFieldEditUndoBehavior.MergeIfPossible;
        }
        throw null;
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
