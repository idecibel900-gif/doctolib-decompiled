package androidx.compose.ui.platform.actionmodecallback;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import androidx.compose.ui.geometry.Rect;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class TextActionModeCallback {
    private final Function0 onActionModeDestroy;
    private Function0 onCopyRequested;
    private Function0 onCutRequested;
    private Function0 onPasteRequested;
    private Function0 onSelectAllRequested;
    private Rect rect;

    public TextActionModeCallback(Function0 function0, Rect rect, Function0 function1, Function0 function2, Function0 function3, Function0 function4) {
        this.onActionModeDestroy = function0;
        this.rect = rect;
        this.onCopyRequested = function1;
        this.onPasteRequested = function2;
        this.onCutRequested = function3;
        this.onSelectAllRequested = function4;
    }

    public /* synthetic */ TextActionModeCallback(Function0 function0, Rect rect, Function0 function1, Function0 function2, Function0 function3, Function0 function4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : function0, (i & 2) != 0 ? Rect.Companion.getZero() : rect, (i & 4) != 0 ? null : function1, (i & 8) != 0 ? null : function2, (i & 16) != 0 ? null : function3, (i & 32) != 0 ? null : function4);
    }

    public final Rect getRect() {
        return this.rect;
    }

    public final void setRect(Rect rect) {
        this.rect = rect;
    }

    public final void setOnCopyRequested(Function0 function0) {
        this.onCopyRequested = function0;
    }

    public final void setOnPasteRequested(Function0 function0) {
        this.onPasteRequested = function0;
    }

    public final void setOnCutRequested(Function0 function0) {
        this.onCutRequested = function0;
    }

    public final void setOnSelectAllRequested(Function0 function0) {
        this.onSelectAllRequested = function0;
    }

    public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (menu == null) {
            throw new IllegalArgumentException("onCreateActionMode requires a non-null menu");
        }
        if (actionMode == null) {
            throw new IllegalArgumentException("onCreateActionMode requires a non-null mode");
        }
        if (this.onCopyRequested != null) {
            addMenuItem$ui_release(menu, MenuItemOption.Copy);
        }
        if (this.onPasteRequested != null) {
            addMenuItem$ui_release(menu, MenuItemOption.Paste);
        }
        if (this.onCutRequested != null) {
            addMenuItem$ui_release(menu, MenuItemOption.Cut);
        }
        if (this.onSelectAllRequested == null) {
            return true;
        }
        addMenuItem$ui_release(menu, MenuItemOption.SelectAll);
        return true;
    }

    public final boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        if (actionMode == null || menu == null) {
            return false;
        }
        updateMenuItems$ui_release(menu);
        return true;
    }

    public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        Intrinsics.checkNotNull(menuItem);
        int itemId = menuItem.getItemId();
        if (itemId == MenuItemOption.Copy.getId()) {
            Function0 function0 = this.onCopyRequested;
            if (function0 != null) {
                function0.invoke();
            }
        } else if (itemId == MenuItemOption.Paste.getId()) {
            Function0 function1 = this.onPasteRequested;
            if (function1 != null) {
                function1.invoke();
            }
        } else if (itemId == MenuItemOption.Cut.getId()) {
            Function0 function2 = this.onCutRequested;
            if (function2 != null) {
                function2.invoke();
            }
        } else {
            if (itemId != MenuItemOption.SelectAll.getId()) {
                return false;
            }
            Function0 function3 = this.onSelectAllRequested;
            if (function3 != null) {
                function3.invoke();
            }
        }
        if (actionMode == null) {
            return true;
        }
        actionMode.finish();
        return true;
    }

    public final void onDestroyActionMode() {
        Function0 function0 = this.onActionModeDestroy;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void updateMenuItems$ui_release(Menu menu) {
        addOrRemoveMenuItem(menu, MenuItemOption.Copy, this.onCopyRequested);
        addOrRemoveMenuItem(menu, MenuItemOption.Paste, this.onPasteRequested);
        addOrRemoveMenuItem(menu, MenuItemOption.Cut, this.onCutRequested);
        addOrRemoveMenuItem(menu, MenuItemOption.SelectAll, this.onSelectAllRequested);
    }

    public final void addMenuItem$ui_release(Menu menu, MenuItemOption menuItemOption) {
        menu.add(0, menuItemOption.getId(), menuItemOption.getOrder(), menuItemOption.getTitleResource()).setShowAsAction(1);
    }

    private final void addOrRemoveMenuItem(Menu menu, MenuItemOption menuItemOption, Function0 function0) {
        if (function0 != null && menu.findItem(menuItemOption.getId()) == null) {
            addMenuItem$ui_release(menu, menuItemOption);
        } else {
            if (function0 != null || menu.findItem(menuItemOption.getId()) == null) {
                return;
            }
            menu.removeItem(menuItemOption.getId());
        }
    }
}
