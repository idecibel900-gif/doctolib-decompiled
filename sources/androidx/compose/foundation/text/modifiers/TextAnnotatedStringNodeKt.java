package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.text.AnnotatedString;

/* JADX INFO: loaded from: classes.dex */
public abstract class TextAnnotatedStringNodeKt {
    public static final boolean hasLinks(AnnotatedString annotatedString) {
        return annotatedString.hasLinkAnnotations(0, annotatedString.length());
    }
}
