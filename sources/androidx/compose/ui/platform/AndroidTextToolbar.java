package androidx.compose.ui.platform;

import android.view.ActionMode;
import android.view.View;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.platform.actionmodecallback.FloatingTextActionModeCallback;
import androidx.compose.ui.platform.actionmodecallback.TextActionModeCallback;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidTextToolbar implements TextToolbar {
    private ActionMode actionMode;
    private final View view;
    private final TextActionModeCallback textActionModeCallback = new TextActionModeCallback(new Function0() { // from class: androidx.compose.ui.platform.AndroidTextToolbar$textActionModeCallback$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m2045invoke();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m2045invoke() {
            this.this$0.actionMode = null;
        }
    }, null, null, null, null, null, 62, null);
    private TextToolbarStatus status = TextToolbarStatus.Hidden;

    public AndroidTextToolbar(View view) {
        this.view = view;
    }

    @Override // androidx.compose.ui.platform.TextToolbar
    public TextToolbarStatus getStatus() {
        return this.status;
    }

    @Override // androidx.compose.ui.platform.TextToolbar
    public void showMenu(Rect rect, Function0 function0, Function0 function1, Function0 function2, Function0 function3) {
        this.textActionModeCallback.setRect(rect);
        this.textActionModeCallback.setOnCopyRequested(function0);
        this.textActionModeCallback.setOnCutRequested(function2);
        this.textActionModeCallback.setOnPasteRequested(function1);
        this.textActionModeCallback.setOnSelectAllRequested(function3);
        ActionMode actionMode = this.actionMode;
        if (actionMode == null) {
            this.status = TextToolbarStatus.Shown;
            this.actionMode = TextToolbarHelperMethods.INSTANCE.startActionMode(this.view, new FloatingTextActionModeCallback(this.textActionModeCallback), 1);
        } else if (actionMode != null) {
            actionMode.invalidate();
        }
    }

    @Override // androidx.compose.ui.platform.TextToolbar
    public void hide() {
        this.status = TextToolbarStatus.Hidden;
        ActionMode actionMode = this.actionMode;
        if (actionMode != null) {
            actionMode.finish();
        }
        this.actionMode = null;
    }
}
