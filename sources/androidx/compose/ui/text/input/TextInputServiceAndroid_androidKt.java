package androidx.compose.ui.text.input;

import android.view.Choreographer;
import android.view.inputmethod.EditorInfo;
import androidx.compose.ui.text.TextRange;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.emoji2.text.EmojiCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.concurrent.Executor;
import okhttp3.internal.http2.Http2;

/* JADX INFO: loaded from: classes.dex */
public abstract class TextInputServiceAndroid_androidKt {
    private static final boolean hasFlag(int i, int i2) {
        return (i & i2) == i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateWithEmojiCompat(EditorInfo editorInfo) {
        if (EmojiCompat.isConfigured()) {
            EmojiCompat.get().updateEditorInfo(editorInfo);
        }
    }

    public static final void update(EditorInfo editorInfo, ImeOptions imeOptions, TextFieldValue textFieldValue) {
        int iM2342getImeActioneUduSuo = imeOptions.m2342getImeActioneUduSuo();
        ImeAction.Companion companion = ImeAction.Companion;
        int i = 6;
        if (ImeAction.m2328equalsimpl0(iM2342getImeActioneUduSuo, companion.m2332getDefaulteUduSuo())) {
            if (!imeOptions.getSingleLine()) {
                i = 0;
            }
        } else if (ImeAction.m2328equalsimpl0(iM2342getImeActioneUduSuo, companion.m2336getNoneeUduSuo())) {
            i = 1;
        } else if (ImeAction.m2328equalsimpl0(iM2342getImeActioneUduSuo, companion.m2334getGoeUduSuo())) {
            i = 2;
        } else if (ImeAction.m2328equalsimpl0(iM2342getImeActioneUduSuo, companion.m2335getNexteUduSuo())) {
            i = 5;
        } else if (ImeAction.m2328equalsimpl0(iM2342getImeActioneUduSuo, companion.m2337getPreviouseUduSuo())) {
            i = 7;
        } else if (ImeAction.m2328equalsimpl0(iM2342getImeActioneUduSuo, companion.m2338getSearcheUduSuo())) {
            i = 3;
        } else if (ImeAction.m2328equalsimpl0(iM2342getImeActioneUduSuo, companion.m2339getSendeUduSuo())) {
            i = 4;
        } else if (!ImeAction.m2328equalsimpl0(iM2342getImeActioneUduSuo, companion.m2333getDoneeUduSuo())) {
            throw new IllegalStateException("invalid ImeAction");
        }
        editorInfo.imeOptions = i;
        imeOptions.getPlatformImeOptions();
        int iM2343getKeyboardTypePjHm6EE = imeOptions.m2343getKeyboardTypePjHm6EE();
        KeyboardType.Companion companion2 = KeyboardType.Companion;
        if (KeyboardType.m2360equalsimpl0(iM2343getKeyboardTypePjHm6EE, companion2.m2371getTextPjHm6EE())) {
            editorInfo.inputType = 1;
        } else if (KeyboardType.m2360equalsimpl0(iM2343getKeyboardTypePjHm6EE, companion2.m2364getAsciiPjHm6EE())) {
            editorInfo.inputType = 1;
            editorInfo.imeOptions |= LinearLayoutManager.INVALID_OFFSET;
        } else if (KeyboardType.m2360equalsimpl0(iM2343getKeyboardTypePjHm6EE, companion2.m2367getNumberPjHm6EE())) {
            editorInfo.inputType = 2;
        } else if (KeyboardType.m2360equalsimpl0(iM2343getKeyboardTypePjHm6EE, companion2.m2370getPhonePjHm6EE())) {
            editorInfo.inputType = 3;
        } else if (KeyboardType.m2360equalsimpl0(iM2343getKeyboardTypePjHm6EE, companion2.m2373getUriPjHm6EE())) {
            editorInfo.inputType = 17;
        } else if (KeyboardType.m2360equalsimpl0(iM2343getKeyboardTypePjHm6EE, companion2.m2366getEmailPjHm6EE())) {
            editorInfo.inputType = 33;
        } else if (KeyboardType.m2360equalsimpl0(iM2343getKeyboardTypePjHm6EE, companion2.m2369getPasswordPjHm6EE())) {
            editorInfo.inputType = 129;
        } else if (KeyboardType.m2360equalsimpl0(iM2343getKeyboardTypePjHm6EE, companion2.m2368getNumberPasswordPjHm6EE())) {
            editorInfo.inputType = 18;
        } else if (KeyboardType.m2360equalsimpl0(iM2343getKeyboardTypePjHm6EE, companion2.m2365getDecimalPjHm6EE())) {
            editorInfo.inputType = 8194;
        } else {
            throw new IllegalStateException("Invalid Keyboard Type");
        }
        if (!imeOptions.getSingleLine() && hasFlag(editorInfo.inputType, 1)) {
            editorInfo.inputType |= 131072;
            if (ImeAction.m2328equalsimpl0(imeOptions.m2342getImeActioneUduSuo(), companion.m2332getDefaulteUduSuo())) {
                editorInfo.imeOptions |= 1073741824;
            }
        }
        if (hasFlag(editorInfo.inputType, 1)) {
            int iM2341getCapitalizationIUNYP9k = imeOptions.m2341getCapitalizationIUNYP9k();
            KeyboardCapitalization.Companion companion3 = KeyboardCapitalization.Companion;
            if (KeyboardCapitalization.m2348equalsimpl0(iM2341getCapitalizationIUNYP9k, companion3.m2352getCharactersIUNYP9k())) {
                editorInfo.inputType |= 4096;
            } else if (KeyboardCapitalization.m2348equalsimpl0(iM2341getCapitalizationIUNYP9k, companion3.m2356getWordsIUNYP9k())) {
                editorInfo.inputType |= 8192;
            } else if (KeyboardCapitalization.m2348equalsimpl0(iM2341getCapitalizationIUNYP9k, companion3.m2354getSentencesIUNYP9k())) {
                editorInfo.inputType |= Http2.INITIAL_MAX_FRAME_SIZE;
            }
            if (imeOptions.getAutoCorrect()) {
                editorInfo.inputType |= 32768;
            }
        }
        editorInfo.initialSelStart = TextRange.m2217getStartimpl(textFieldValue.m2379getSelectiond9O1mEE());
        editorInfo.initialSelEnd = TextRange.m2212getEndimpl(textFieldValue.m2379getSelectiond9O1mEE());
        EditorInfoCompat.setInitialSurroundingText(editorInfo, textFieldValue.getText());
        editorInfo.imeOptions |= 33554432;
    }

    public static final Executor asExecutor(final Choreographer choreographer) {
        return new Executor() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid_androidKt$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                TextInputServiceAndroid_androidKt.asExecutor$lambda$2(choreographer, runnable);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void asExecutor$lambda$2(Choreographer choreographer, final Runnable runnable) {
        choreographer.postFrameCallback(new Choreographer.FrameCallback() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid_androidKt$$ExternalSyntheticLambda1
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j) {
                runnable.run();
            }
        });
    }
}
