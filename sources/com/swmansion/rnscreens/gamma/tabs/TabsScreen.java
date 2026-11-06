package com.swmansion.rnscreens.gamma.tabs;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.facebook.react.uimanager.ThemedReactContext;
import com.swmansion.rnscreens.gamma.common.FragmentProviding;
import com.swmansion.rnscreens.gamma.helpers.SystemDrawableKt;
import com.swmansion.rnscreens.utils.RNSLog;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class TabsScreen extends ViewGroup implements FragmentProviding {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(TabsScreen.class, "tabTitle", "getTabTitle()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(TabsScreen.class, "badgeValue", "getBadgeValue()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(TabsScreen.class, "tabBarItemBadgeTextColor", "getTabBarItemBadgeTextColor()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(TabsScreen.class, "tabBarItemBadgeBackgroundColor", "getTabBarItemBadgeBackgroundColor()Ljava/lang/Integer;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(TabsScreen.class, "tabBarItemTestID", "getTabBarItemTestID()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(TabsScreen.class, "tabBarItemAccessibilityLabel", "getTabBarItemAccessibilityLabel()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(TabsScreen.class, "drawableIconResourceName", "getDrawableIconResourceName()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(TabsScreen.class, "icon", "getIcon()Landroid/graphics/drawable/Drawable;", 0))};
    public static final Companion Companion = new Companion(null);
    private final ReadWriteProperty badgeValue$delegate;
    private final ReadWriteProperty drawableIconResourceName$delegate;
    public TabsScreenEventEmitter eventEmitter;
    private final ReadWriteProperty icon$delegate;
    private boolean isFocusedTab;
    private final ThemedReactContext reactContext;
    private boolean shouldUseRepeatedTabSelectionPopToRootSpecialEffect;
    private boolean shouldUseRepeatedTabSelectionScrollToTopSpecialEffect;
    private final ReadWriteProperty tabBarItemAccessibilityLabel$delegate;
    private final ReadWriteProperty tabBarItemBadgeBackgroundColor$delegate;
    private final ReadWriteProperty tabBarItemBadgeTextColor$delegate;
    private final ReadWriteProperty tabBarItemTestID$delegate;
    private String tabKey;
    private final ReadWriteProperty tabTitle$delegate;
    private WeakReference tabsScreenDelegate;

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public final ThemedReactContext getReactContext() {
        return this.reactContext;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabsScreen(ThemedReactContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        final Object obj = null;
        this.tabsScreenDelegate = new WeakReference(null);
        Delegates delegates = Delegates.INSTANCE;
        this.tabTitle$delegate = new ObservableProperty(obj) { // from class: com.swmansion.rnscreens.gamma.tabs.TabsScreen$special$$inlined$observable$1
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty property, Object obj2, Object obj3) {
                Intrinsics.checkNotNullParameter(property, "property");
                TabsScreen tabsScreen = this;
                tabsScreen.updateMenuItemAttributesIfNeeded((String) obj2, (String) obj3);
            }
        };
        this.badgeValue$delegate = new ObservableProperty(obj) { // from class: com.swmansion.rnscreens.gamma.tabs.TabsScreen$special$$inlined$observable$2
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty property, Object obj2, Object obj3) {
                Intrinsics.checkNotNullParameter(property, "property");
                TabsScreen tabsScreen = this;
                tabsScreen.updateMenuItemAttributesIfNeeded((String) obj2, (String) obj3);
            }
        };
        this.tabBarItemBadgeTextColor$delegate = new ObservableProperty(obj) { // from class: com.swmansion.rnscreens.gamma.tabs.TabsScreen$special$$inlined$observable$3
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty property, Object obj2, Object obj3) {
                Intrinsics.checkNotNullParameter(property, "property");
                TabsScreen tabsScreen = this;
                tabsScreen.updateMenuItemAttributesIfNeeded((Integer) obj2, (Integer) obj3);
            }
        };
        this.tabBarItemBadgeBackgroundColor$delegate = new ObservableProperty(obj) { // from class: com.swmansion.rnscreens.gamma.tabs.TabsScreen$special$$inlined$observable$4
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty property, Object obj2, Object obj3) {
                Intrinsics.checkNotNullParameter(property, "property");
                TabsScreen tabsScreen = this;
                tabsScreen.updateMenuItemAttributesIfNeeded((Integer) obj2, (Integer) obj3);
            }
        };
        this.tabBarItemTestID$delegate = new ObservableProperty(obj) { // from class: com.swmansion.rnscreens.gamma.tabs.TabsScreen$special$$inlined$observable$5
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty property, Object obj2, Object obj3) {
                Intrinsics.checkNotNullParameter(property, "property");
                TabsScreen tabsScreen = this;
                tabsScreen.updateMenuItemAttributesIfNeeded((String) obj2, (String) obj3);
            }
        };
        this.tabBarItemAccessibilityLabel$delegate = new ObservableProperty(obj) { // from class: com.swmansion.rnscreens.gamma.tabs.TabsScreen$special$$inlined$observable$6
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty property, Object obj2, Object obj3) {
                Intrinsics.checkNotNullParameter(property, "property");
                TabsScreen tabsScreen = this;
                tabsScreen.updateMenuItemAttributesIfNeeded((String) obj2, (String) obj3);
            }
        };
        this.drawableIconResourceName$delegate = new ObservableProperty(obj) { // from class: com.swmansion.rnscreens.gamma.tabs.TabsScreen$special$$inlined$observable$7
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty property, Object obj2, Object obj3) {
                Intrinsics.checkNotNullParameter(property, "property");
                String str = (String) obj3;
                if (Intrinsics.areEqual(str, (String) obj2)) {
                    return;
                }
                TabsScreen tabsScreen = this;
                tabsScreen.setIcon(SystemDrawableKt.getSystemDrawableResource(tabsScreen.getReactContext(), str));
            }
        };
        this.icon$delegate = new ObservableProperty(obj) { // from class: com.swmansion.rnscreens.gamma.tabs.TabsScreen$special$$inlined$observable$8
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty property, Object obj2, Object obj3) {
                Intrinsics.checkNotNullParameter(property, "property");
                TabsScreen tabsScreen = this;
                tabsScreen.updateMenuItemAttributesIfNeeded((Drawable) obj2, (Drawable) obj3);
            }
        };
        this.shouldUseRepeatedTabSelectionScrollToTopSpecialEffect = true;
        this.shouldUseRepeatedTabSelectionPopToRootSpecialEffect = true;
    }

    public final TabsScreenEventEmitter getEventEmitter$react_native_screens_release() {
        TabsScreenEventEmitter tabsScreenEventEmitter = this.eventEmitter;
        if (tabsScreenEventEmitter != null) {
            return tabsScreenEventEmitter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("eventEmitter");
        return null;
    }

    public final void setEventEmitter$react_native_screens_release(TabsScreenEventEmitter tabsScreenEventEmitter) {
        Intrinsics.checkNotNullParameter(tabsScreenEventEmitter, "<set-?>");
        this.eventEmitter = tabsScreenEventEmitter;
    }

    public final String getTabKey() {
        return this.tabKey;
    }

    public final void setTabKey(String str) {
        if (str != null && StringsKt.isBlank(str)) {
            str = null;
        }
        this.tabKey = str;
    }

    public final String getTabTitle() {
        return (String) this.tabTitle$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final void setTabTitle(String str) {
        this.tabTitle$delegate.setValue(this, $$delegatedProperties[0], str);
    }

    public final String getBadgeValue() {
        return (String) this.badgeValue$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final void setBadgeValue(String str) {
        this.badgeValue$delegate.setValue(this, $$delegatedProperties[1], str);
    }

    public final Integer getTabBarItemBadgeTextColor() {
        return (Integer) this.tabBarItemBadgeTextColor$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final void setTabBarItemBadgeTextColor(Integer num) {
        this.tabBarItemBadgeTextColor$delegate.setValue(this, $$delegatedProperties[2], num);
    }

    public final Integer getTabBarItemBadgeBackgroundColor() {
        return (Integer) this.tabBarItemBadgeBackgroundColor$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final void setTabBarItemBadgeBackgroundColor(Integer num) {
        this.tabBarItemBadgeBackgroundColor$delegate.setValue(this, $$delegatedProperties[3], num);
    }

    public final String getTabBarItemTestID() {
        return (String) this.tabBarItemTestID$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public final void setTabBarItemTestID(String str) {
        this.tabBarItemTestID$delegate.setValue(this, $$delegatedProperties[4], str);
    }

    public final String getTabBarItemAccessibilityLabel() {
        return (String) this.tabBarItemAccessibilityLabel$delegate.getValue(this, $$delegatedProperties[5]);
    }

    public final void setTabBarItemAccessibilityLabel(String str) {
        this.tabBarItemAccessibilityLabel$delegate.setValue(this, $$delegatedProperties[5], str);
    }

    public final String getDrawableIconResourceName() {
        return (String) this.drawableIconResourceName$delegate.getValue(this, $$delegatedProperties[6]);
    }

    public final void setDrawableIconResourceName(String str) {
        this.drawableIconResourceName$delegate.setValue(this, $$delegatedProperties[6], str);
    }

    public final Drawable getIcon() {
        return (Drawable) this.icon$delegate.getValue(this, $$delegatedProperties[7]);
    }

    public final void setIcon(Drawable drawable) {
        this.icon$delegate.setValue(this, $$delegatedProperties[7], drawable);
    }

    public final boolean getShouldUseRepeatedTabSelectionScrollToTopSpecialEffect() {
        return this.shouldUseRepeatedTabSelectionScrollToTopSpecialEffect;
    }

    public final void setShouldUseRepeatedTabSelectionScrollToTopSpecialEffect(boolean z) {
        this.shouldUseRepeatedTabSelectionScrollToTopSpecialEffect = z;
    }

    public final boolean getShouldUseRepeatedTabSelectionPopToRootSpecialEffect() {
        return this.shouldUseRepeatedTabSelectionPopToRootSpecialEffect;
    }

    public final void setShouldUseRepeatedTabSelectionPopToRootSpecialEffect(boolean z) {
        this.shouldUseRepeatedTabSelectionPopToRootSpecialEffect = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateMenuItemAttributesIfNeeded(Object obj, Object obj2) {
        if (Intrinsics.areEqual(obj2, obj)) {
            return;
        }
        onMenuItemAttributesChange();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        RNSLog.INSTANCE.d("TabsScreen", "TabsScreen [" + getId() + "] attached to window");
        super.onAttachedToWindow();
    }

    public final boolean isFocusedTab() {
        return this.isFocusedTab;
    }

    public final void setFocusedTab(boolean z) {
        if (this.isFocusedTab != z) {
            this.isFocusedTab = z;
            onTabFocusChangedFromJS();
        }
    }

    public final void setTabsScreenDelegate$react_native_screens_release(TabsScreenDelegate tabsScreenDelegate) {
        this.tabsScreenDelegate = new WeakReference(tabsScreenDelegate);
    }

    @Override // com.swmansion.rnscreens.gamma.common.FragmentProviding
    public Fragment getAssociatedFragment() {
        TabsScreenDelegate tabsScreenDelegate = (TabsScreenDelegate) this.tabsScreenDelegate.get();
        if (tabsScreenDelegate != null) {
            return tabsScreenDelegate.getFragmentForTabsScreen(this);
        }
        return null;
    }

    private final void onTabFocusChangedFromJS() {
        TabsScreenDelegate tabsScreenDelegate = (TabsScreenDelegate) this.tabsScreenDelegate.get();
        if (tabsScreenDelegate != null) {
            tabsScreenDelegate.onTabFocusChangedFromJS(this, this.isFocusedTab);
        }
    }

    private final void onMenuItemAttributesChange() {
        TabsScreenDelegate tabsScreenDelegate = (TabsScreenDelegate) this.tabsScreenDelegate.get();
        if (tabsScreenDelegate != null) {
            tabsScreenDelegate.onMenuItemAttributesChange(this);
        }
    }

    public final void onViewManagerAddEventEmitters$react_native_screens_release() {
        if (getId() == -1) {
            throw new IllegalStateException("[RNScreens] TabsScreen must have its tag set when registering event emitters");
        }
        setEventEmitter$react_native_screens_release(new TabsScreenEventEmitter(this.reactContext, getId()));
    }

    public final void onFragmentConfigurationChange$react_native_screens_release(TabsScreenFragment fragment, Configuration config) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(config, "config");
        TabsScreenDelegate tabsScreenDelegate = (TabsScreenDelegate) this.tabsScreenDelegate.get();
        if (tabsScreenDelegate != null) {
            tabsScreenDelegate.onFragmentConfigurationChange(this, config);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
