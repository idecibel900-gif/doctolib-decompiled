package app.screeb.sdk.internal;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class A0 implements Window.Callback {
    public final Window.Callback a;
    public final /* synthetic */ B0 b;

    public A0(B0 b0, Window.Callback callback) {
        this.b = b0;
        this.a = callback;
    }

    public final B0 a() {
        return this.b;
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        Window.Callback callback = this.a;
        if (callback != null) {
            return callback.dispatchGenericMotionEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        Window.Callback callback = this.a;
        if (callback != null) {
            return callback.dispatchKeyEvent(keyEvent);
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        Window.Callback callback = this.a;
        if (callback != null) {
            return callback.dispatchKeyShortcutEvent(keyEvent);
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        Window.Callback callback = this.a;
        if (callback != null) {
            return callback.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != null) {
            try {
                B0.a(this.b, motionEvent);
            } catch (Throwable unused) {
            }
        }
        Window.Callback callback = this.a;
        if (callback != null) {
            return callback.dispatchTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        Window.Callback callback = this.a;
        if (callback != null) {
            return callback.dispatchTrackballEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public final void onActionModeFinished(ActionMode actionMode) {
        Window.Callback callback = this.a;
        if (callback != null) {
            callback.onActionModeFinished(actionMode);
        }
    }

    @Override // android.view.Window.Callback
    public final void onActionModeStarted(ActionMode actionMode) {
        Window.Callback callback = this.a;
        if (callback != null) {
            callback.onActionModeStarted(actionMode);
        }
    }

    @Override // android.view.Window.Callback
    public final void onAttachedToWindow() {
        Window.Callback callback = this.a;
        if (callback != null) {
            callback.onAttachedToWindow();
        }
    }

    @Override // android.view.Window.Callback
    public final void onContentChanged() {
        Window.Callback callback = this.a;
        if (callback != null) {
            callback.onContentChanged();
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i, Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Window.Callback callback = this.a;
        if (callback != null) {
            return callback.onCreatePanelMenu(i, menu);
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public final View onCreatePanelView(int i) {
        Window.Callback callback = this.a;
        if (callback != null) {
            return callback.onCreatePanelView(i);
        }
        return null;
    }

    @Override // android.view.Window.Callback
    public final void onDetachedFromWindow() {
        Window.Callback callback = this.a;
        if (callback != null) {
            callback.onDetachedFromWindow();
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        Window.Callback callback = this.a;
        if (callback != null) {
            return callback.onMenuItemSelected(i, item);
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuOpened(int i, Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Window.Callback callback = this.a;
        if (callback != null) {
            return callback.onMenuOpened(i, menu);
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public final void onPanelClosed(int i, Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Window.Callback callback = this.a;
        if (callback != null) {
            callback.onPanelClosed(i, menu);
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onPreparePanel(int i, View view, Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Window.Callback callback = this.a;
        if (callback != null) {
            return callback.onPreparePanel(i, view, menu);
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested() {
        Window.Callback callback = this.a;
        if (callback != null) {
            return callback.onSearchRequested();
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested(SearchEvent searchEvent) {
        Window.Callback callback = this.a;
        if (callback != null) {
            return callback.onSearchRequested(searchEvent);
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public final void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        Window.Callback callback = this.a;
        if (callback != null) {
            callback.onWindowAttributesChanged(layoutParams);
        }
    }

    @Override // android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z) {
        Window.Callback callback = this.a;
        if (callback != null) {
            callback.onWindowFocusChanged(z);
        }
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        Window.Callback callback2 = this.a;
        if (callback2 != null) {
            return callback2.onWindowStartingActionMode(callback);
        }
        return null;
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        Window.Callback callback2 = this.a;
        if (callback2 != null) {
            return callback2.onWindowStartingActionMode(callback, i);
        }
        return null;
    }
}
