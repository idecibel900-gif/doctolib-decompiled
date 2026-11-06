package com.reactnativemenu;

import android.R;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SubMenu;
import android.view.TouchDelegate;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.PopupMenu;
import com.amazon.a.a.o.b;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.view.ReactViewGroup;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.lang.reflect.Field;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class MenuView extends ReactViewGroup {
    private ReadableArray mActions;
    private final ReactContext mContext;
    private GestureDetector mGestureDetector;
    private Rect mHitSlopRect;
    private boolean mIsAnchoredToRight;
    private boolean mIsMenuDisplayed;
    private boolean mIsOnLongPress;
    private final PopupMenu mPopupMenu;

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MenuView(ReactContext mContext) {
        super(mContext);
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
        this.mPopupMenu = new PopupMenu(getContext(), this);
        this.mGestureDetector = new GestureDetector(mContext, new GestureDetector.SimpleOnGestureListener() { // from class: com.reactnativemenu.MenuView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent e) {
                Intrinsics.checkNotNullParameter(e, "e");
                if (MenuView.this.mIsOnLongPress) {
                    MenuView.this.prepareMenu();
                }
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent e) {
                Intrinsics.checkNotNullParameter(e, "e");
                if (MenuView.this.mIsOnLongPress) {
                    return true;
                }
                MenuView.this.prepareMenu();
                return true;
            }
        });
    }

    private final void setMHitSlopRect(Rect rect) {
        super.setHitSlopRect(rect);
        setMHitSlopRect(rect);
        updateTouchDelegate();
    }

    public final void show() {
        prepareMenu();
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        this.mGestureDetector.onTouchEvent(ev);
        return true;
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        updateTouchDelegate();
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        updateTouchDelegate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mIsMenuDisplayed) {
            this.mPopupMenu.dismiss();
        }
    }

    public final void setActions(ReadableArray actions) {
        Intrinsics.checkNotNullParameter(actions, "actions");
        this.mActions = actions;
    }

    public final void setIsAnchoredToRight(boolean z) {
        if (this.mIsAnchoredToRight == z) {
            return;
        }
        this.mIsAnchoredToRight = z;
    }

    public final void setIsOpenOnLongPress(boolean z) {
        this.mIsOnLongPress = z;
    }

    private final int getGetActionsCount() {
        ReadableArray readableArray = this.mActions;
        if (readableArray == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActions");
            readableArray = null;
        }
        return readableArray.size();
    }

    private final void prepareMenuItem(MenuItem menuItem, ReadableMap readableMap) {
        int drawableIdWithName;
        Integer numValueOf = (readableMap == null || !readableMap.hasKey("titleColor") || readableMap.isNull("titleColor")) ? null : Integer.valueOf(readableMap.getInt("titleColor"));
        String string = (readableMap == null || !readableMap.hasKey("image") || readableMap.isNull("image")) ? null : readableMap.getString("image");
        Integer numValueOf2 = (readableMap == null || !readableMap.hasKey("imageColor") || readableMap.isNull("imageColor")) ? null : Integer.valueOf(readableMap.getInt("imageColor"));
        ReadableMap map = (readableMap == null || !readableMap.hasKey("attributes") || readableMap.isNull("attributes")) ? null : readableMap.getMap("attributes");
        final ReadableArray array = (readableMap == null || !readableMap.hasKey("subactions") || readableMap.isNull("subactions")) ? null : readableMap.getArray("subactions");
        String string2 = readableMap != null ? readableMap.getString("state") : null;
        if (numValueOf != null) {
            menuItem.setTitle(getMenuItemTextWithColor(String.valueOf(menuItem.getTitle()), numValueOf.intValue()));
        }
        if (string != null && (drawableIdWithName = getDrawableIdWithName(string)) != 0) {
            Drawable drawable = getResources().getDrawable(drawableIdWithName, getContext().getTheme());
            if (numValueOf2 != null) {
                drawable.setTintList(ColorStateList.valueOf(numValueOf2.intValue()));
            }
            menuItem.setIcon(drawable);
        }
        if (map != null) {
            menuItem.setEnabled(!((!map.hasKey("disabled") || map.isNull("disabled")) ? false : map.getBoolean("disabled")));
            if (!menuItem.isEnabled()) {
                menuItem.setTitle(getMenuItemTextWithColor(String.valueOf(menuItem.getTitle()), 2005436552));
                if (string != null) {
                    Drawable icon = menuItem.getIcon();
                    if (icon != null) {
                        icon.setTintList(ColorStateList.valueOf(2005436552));
                    }
                    menuItem.setIcon(icon);
                }
            }
            menuItem.setVisible(!((!map.hasKey("hidden") || map.isNull("hidden")) ? false : map.getBoolean("hidden")));
            if ((!map.hasKey("destructive") || map.isNull("destructive")) ? false : map.getBoolean("destructive")) {
                menuItem.setTitle(getMenuItemTextWithColor(String.valueOf(menuItem.getTitle()), -65536));
                if (string != null) {
                    Drawable icon2 = menuItem.getIcon();
                    if (icon2 != null) {
                        icon2.setTintList(ColorStateList.valueOf(-65536));
                    }
                    menuItem.setIcon(icon2);
                }
            }
        }
        if (Intrinsics.areEqual(string2, "on") || Intrinsics.areEqual(string2, "off")) {
            menuItem.setCheckable(true);
            menuItem.setChecked(Intrinsics.areEqual(string2, "on"));
        } else {
            menuItem.setCheckable(false);
        }
        if (array == null || !menuItem.hasSubMenu()) {
            return;
        }
        int size = array.size();
        for (int i = 0; i < size; i++) {
            if (!array.isNull(i)) {
                ReadableMap map2 = array.getMap(i);
                SubMenu subMenu = menuItem.getSubMenu();
                MenuItem menuItemAdd = subMenu != null ? subMenu.add(0, 0, i, map2 != null ? map2.getString(b.S) : null) : null;
                if (menuItemAdd != null) {
                    prepareMenuItem(menuItemAdd, map2);
                    menuItemAdd.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: com.reactnativemenu.MenuView$$ExternalSyntheticLambda3
                        @Override // android.view.MenuItem.OnMenuItemClickListener
                        public final boolean onMenuItemClick(MenuItem menuItem2) {
                            return MenuView.prepareMenuItem$lambda$0(this.f$0, array, menuItem2);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean prepareMenuItem$lambda$0(MenuView menuView, ReadableArray readableArray, MenuItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.hasSubMenu()) {
            return false;
        }
        menuView.mIsMenuDisplayed = false;
        if (readableArray.isNull(it.getOrder())) {
            return true;
        }
        ReadableMap map = readableArray.getMap(it.getOrder());
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(menuView.mContext, menuView.getId());
        int surfaceId = UIManagerHelper.getSurfaceId(menuView);
        if (eventDispatcherForReactTag == null) {
            return true;
        }
        eventDispatcherForReactTag.dispatchEvent(new MenuOnPressActionEvent(surfaceId, menuView.getId(), map != null ? map.getString(DiagnosticsEntry.ID_KEY) : null, menuView.getId()));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void prepareMenu() {
        int i;
        if (getGetActionsCount() > 0) {
            this.mPopupMenu.getMenu().clear();
            int i2 = Build.VERSION.SDK_INT;
            PopupMenu popupMenu = this.mPopupMenu;
            boolean z = this.mIsAnchoredToRight;
            if (z) {
                i = 5;
            } else {
                if (z) {
                    throw new NoWhenBranchMatchedException();
                }
                i = 3;
            }
            popupMenu.setGravity(i);
            if (i2 >= 29) {
                this.mPopupMenu.setForceShowIcon(true);
            }
            for (int i3 = 0; i3 < getGetActionsCount(); i3++) {
                ReadableArray readableArray = this.mActions;
                if (readableArray == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mActions");
                    readableArray = null;
                }
                if (!readableArray.isNull(i3)) {
                    ReadableArray readableArray2 = this.mActions;
                    if (readableArray2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mActions");
                        readableArray2 = null;
                    }
                    ReadableMap map = readableArray2.getMap(i3);
                    MenuItem menuItemAdd = (map == null || !map.hasKey("subactions") || map.isNull("subactions")) ? this.mPopupMenu.getMenu().add(0, 0, i3, map != null ? map.getString(b.S) : null) : this.mPopupMenu.getMenu().addSubMenu(0, 0, i3, map.getString(b.S)).getItem();
                    Intrinsics.checkNotNull(menuItemAdd);
                    prepareMenuItem(menuItemAdd, map);
                    menuItemAdd.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: com.reactnativemenu.MenuView$$ExternalSyntheticLambda1
                        @Override // android.view.MenuItem.OnMenuItemClickListener
                        public final boolean onMenuItemClick(MenuItem menuItem) {
                            return MenuView.prepareMenu$lambda$1(this.f$0, menuItem);
                        }
                    });
                }
            }
            this.mPopupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() { // from class: com.reactnativemenu.MenuView$$ExternalSyntheticLambda2
                @Override // android.widget.PopupMenu.OnDismissListener
                public final void onDismiss(PopupMenu popupMenu2) {
                    MenuView.prepareMenu$lambda$2(this.f$0, popupMenu2);
                }
            });
            this.mIsMenuDisplayed = true;
            EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(this.mContext, getId());
            int surfaceId = UIManagerHelper.getSurfaceId(this);
            if (eventDispatcherForReactTag != null) {
                eventDispatcherForReactTag.dispatchEvent(new MenuOnOpenEvent(surfaceId, getId(), getId()));
            }
            this.mPopupMenu.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean prepareMenu$lambda$1(MenuView menuView, MenuItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.hasSubMenu()) {
            return false;
        }
        menuView.mIsMenuDisplayed = false;
        ReadableArray readableArray = menuView.mActions;
        if (readableArray == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActions");
            readableArray = null;
        }
        if (readableArray.isNull(it.getOrder())) {
            return true;
        }
        ReadableArray readableArray2 = menuView.mActions;
        if (readableArray2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mActions");
            readableArray2 = null;
        }
        ReadableMap map = readableArray2.getMap(it.getOrder());
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(menuView.mContext, menuView.getId());
        int surfaceId = UIManagerHelper.getSurfaceId(menuView);
        if (eventDispatcherForReactTag == null) {
            return true;
        }
        eventDispatcherForReactTag.dispatchEvent(new MenuOnPressActionEvent(surfaceId, menuView.getId(), map != null ? map.getString(DiagnosticsEntry.ID_KEY) : null, menuView.getId()));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void prepareMenu$lambda$2(MenuView menuView, PopupMenu popupMenu) {
        menuView.mIsMenuDisplayed = false;
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(menuView.mContext, menuView.getId());
        int surfaceId = UIManagerHelper.getSurfaceId(menuView);
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(new MenuOnCloseEvent(surfaceId, menuView.getId(), menuView.getId()));
        }
    }

    private final void updateTouchDelegate() {
        post(new Runnable() { // from class: com.reactnativemenu.MenuView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MenuView.updateTouchDelegate$lambda$5(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateTouchDelegate$lambda$5(MenuView menuView) {
        Rect rect = new Rect();
        menuView.getHitRect(rect);
        Rect rect2 = menuView.mHitSlopRect;
        if (rect2 != null) {
            rect.left -= rect2.left;
            rect.top -= rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        ViewParent parent = menuView.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.setTouchDelegate(new TouchDelegate(rect, menuView));
        }
    }

    private final int getDrawableIdWithName(String str) {
        Resources resources = getContext().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        int identifier = resources.getIdentifier(str, "drawable", getContext().getPackageName());
        return identifier == 0 ? getResId(str, R.drawable.class) : identifier;
    }

    private final int getResId(String str, Class cls) {
        try {
            Intrinsics.checkNotNull(str);
            Field declaredField = cls.getDeclaredField(str);
            Intrinsics.checkNotNullExpressionValue(declaredField, "getDeclaredField(...)");
            return declaredField.getInt(declaredField);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private final SpannableStringBuilder getMenuItemTextWithColor(String str, int i) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(i), 0, str.length(), 33);
        return spannableStringBuilder;
    }
}
