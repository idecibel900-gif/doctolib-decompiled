package androidx.compose.ui.platform;

import androidx.compose.ui.geometry.Rect;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes.dex */
public interface TextToolbar {
    TextToolbarStatus getStatus();

    void hide();

    void showMenu(Rect rect, Function0 function0, Function0 function1, Function0 function2, Function0 function3);
}
