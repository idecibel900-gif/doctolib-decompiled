package androidx.compose.foundation.text.input.internal;

import android.view.inputmethod.EditorInfo;
import androidx.compose.foundation.text.handwriting.StylusHandwriting_androidKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import okhttp3.internal.http2.Http2;

/* JADX INFO: loaded from: classes.dex */
public abstract class EditorInfo_androidKt {
    private static final boolean hasFlag(int i, int i2) {
        return (i & i2) == i2;
    }

    /* JADX INFO: renamed from: update-pLxbY9I$default, reason: not valid java name */
    public static /* synthetic */ void m568updatepLxbY9I$default(EditorInfo editorInfo, CharSequence charSequence, long j, ImeOptions imeOptions, String[] strArr, int i, Object obj) {
        if ((i & 8) != 0) {
            strArr = null;
        }
        m567updatepLxbY9I(editorInfo, charSequence, j, imeOptions, strArr);
    }

    /* JADX INFO: renamed from: update-pLxbY9I, reason: not valid java name */
    public static final void m567updatepLxbY9I(EditorInfo editorInfo, CharSequence charSequence, long j, ImeOptions imeOptions, String[] strArr) {
        int iM2342getImeActioneUduSuo = imeOptions.m2342getImeActioneUduSuo();
        ImeAction.Companion companion = ImeAction.Companion;
        int i = 3;
        int i2 = 6;
        if (ImeAction.m2328equalsimpl0(iM2342getImeActioneUduSuo, companion.m2332getDefaulteUduSuo())) {
            if (!imeOptions.getSingleLine()) {
                i2 = 0;
            }
        } else if (ImeAction.m2328equalsimpl0(iM2342getImeActioneUduSuo, companion.m2336getNoneeUduSuo())) {
            i2 = 1;
        } else if (ImeAction.m2328equalsimpl0(iM2342getImeActioneUduSuo, companion.m2334getGoeUduSuo())) {
            i2 = 2;
        } else if (ImeAction.m2328equalsimpl0(iM2342getImeActioneUduSuo, companion.m2335getNexteUduSuo())) {
            i2 = 5;
        } else if (ImeAction.m2328equalsimpl0(iM2342getImeActioneUduSuo, companion.m2337getPreviouseUduSuo())) {
            i2 = 7;
        } else if (ImeAction.m2328equalsimpl0(iM2342getImeActioneUduSuo, companion.m2338getSearcheUduSuo())) {
            i2 = 3;
        } else if (ImeAction.m2328equalsimpl0(iM2342getImeActioneUduSuo, companion.m2339getSendeUduSuo())) {
            i2 = 4;
        } else if (!ImeAction.m2328equalsimpl0(iM2342getImeActioneUduSuo, companion.m2333getDoneeUduSuo())) {
            throw new IllegalStateException("invalid ImeAction");
        }
        editorInfo.imeOptions = i2;
        imeOptions.getPlatformImeOptions();
        LocaleListHelper.INSTANCE.setHintLocales(editorInfo, imeOptions.getHintLocales());
        int iM2343getKeyboardTypePjHm6EE = imeOptions.m2343getKeyboardTypePjHm6EE();
        KeyboardType.Companion companion2 = KeyboardType.Companion;
        if (KeyboardType.m2360equalsimpl0(iM2343getKeyboardTypePjHm6EE, companion2.m2371getTextPjHm6EE())) {
            i = 1;
        } else if (KeyboardType.m2360equalsimpl0(iM2343getKeyboardTypePjHm6EE, companion2.m2364getAsciiPjHm6EE())) {
            editorInfo.imeOptions |= LinearLayoutManager.INVALID_OFFSET;
            i = 1;
        } else if (KeyboardType.m2360equalsimpl0(iM2343getKeyboardTypePjHm6EE, companion2.m2367getNumberPjHm6EE())) {
            i = 2;
        } else if (!KeyboardType.m2360equalsimpl0(iM2343getKeyboardTypePjHm6EE, companion2.m2370getPhonePjHm6EE())) {
            if (KeyboardType.m2360equalsimpl0(iM2343getKeyboardTypePjHm6EE, companion2.m2373getUriPjHm6EE())) {
                i = 17;
            } else if (KeyboardType.m2360equalsimpl0(iM2343getKeyboardTypePjHm6EE, companion2.m2366getEmailPjHm6EE())) {
                i = 33;
            } else if (KeyboardType.m2360equalsimpl0(iM2343getKeyboardTypePjHm6EE, companion2.m2369getPasswordPjHm6EE())) {
                i = 129;
            } else if (KeyboardType.m2360equalsimpl0(iM2343getKeyboardTypePjHm6EE, companion2.m2368getNumberPasswordPjHm6EE())) {
                i = 18;
            } else {
                if (!KeyboardType.m2360equalsimpl0(iM2343getKeyboardTypePjHm6EE, companion2.m2365getDecimalPjHm6EE())) {
                    throw new IllegalStateException("Invalid Keyboard Type");
                }
                i = 8194;
            }
        }
        editorInfo.inputType = i;
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
        editorInfo.initialSelStart = TextRange.m2217getStartimpl(j);
        editorInfo.initialSelEnd = TextRange.m2212getEndimpl(j);
        EditorInfoCompat.setInitialSurroundingText(editorInfo, charSequence);
        if (strArr != null) {
            EditorInfoCompat.setContentMimeTypes(editorInfo, strArr);
        }
        editorInfo.imeOptions |= 33554432;
        if (StylusHandwriting_androidKt.isStylusHandwritingSupported() && !KeyboardType.m2360equalsimpl0(imeOptions.m2343getKeyboardTypePjHm6EE(), companion2.m2369getPasswordPjHm6EE()) && !KeyboardType.m2360equalsimpl0(imeOptions.m2343getKeyboardTypePjHm6EE(), companion2.m2368getNumberPasswordPjHm6EE())) {
            EditorInfoCompat.setStylusHandwritingEnabled(editorInfo, true);
            EditorInfoApi34.INSTANCE.setHandwritingGestures(editorInfo);
        } else {
            EditorInfoCompat.setStylusHandwritingEnabled(editorInfo, false);
        }
    }
}
