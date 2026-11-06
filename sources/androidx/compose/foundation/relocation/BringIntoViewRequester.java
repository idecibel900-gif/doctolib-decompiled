package androidx.compose.foundation.relocation;

import androidx.compose.ui.geometry.Rect;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes.dex */
public interface BringIntoViewRequester {
    Object bringIntoView(Rect rect, Continuation continuation);
}
