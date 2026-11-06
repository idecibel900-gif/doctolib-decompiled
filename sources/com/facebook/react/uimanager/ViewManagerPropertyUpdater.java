package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReadableArray;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ViewManagerPropertyUpdater {
    public static final ViewManagerPropertyUpdater INSTANCE = new ViewManagerPropertyUpdater();
    private static final Map VIEW_MANAGER_SETTER_MAP = new HashMap();
    private static final Map SHADOW_NODE_SETTER_MAP = new HashMap();

    public interface Settable {
        void getProperties(Map map);
    }

    public interface ShadowNodeSetter extends Settable {
        void setProperty(ReactShadowNode reactShadowNode, String str, Object obj);
    }

    public interface ViewManagerSetter extends Settable {
        void setProperty(ViewManager viewManager, View view, String str, Object obj);
    }

    private ViewManagerPropertyUpdater() {
    }

    public static final void clear() {
        ViewManagersPropertyCache.clear();
        VIEW_MANAGER_SETTER_MAP.clear();
        SHADOW_NODE_SETTER_MAP.clear();
    }

    public static final void updateProps(ReactShadowNode node, ReactStylesDiffMap props) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(props, "props");
        ShadowNodeSetter shadowNodeSetterFindNodeSetter = INSTANCE.findNodeSetter(node.getClass());
        Iterator<Map.Entry<String, Object>> entryIterator = props.internal_backingMap().getEntryIterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, Object> next = entryIterator.next();
            shadowNodeSetterFindNodeSetter.setProperty(node, next.getKey(), next.getValue());
        }
    }

    public static final Map getNativeProps(Class viewManagerTopClass, Class cls) {
        Intrinsics.checkNotNullParameter(viewManagerTopClass, "viewManagerTopClass");
        HashMap map = new HashMap();
        ViewManagerPropertyUpdater viewManagerPropertyUpdater = INSTANCE;
        viewManagerPropertyUpdater.findManagerSetter(viewManagerTopClass).getProperties(map);
        if (cls != null) {
            viewManagerPropertyUpdater.findNodeSetter(cls).getProperties(map);
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ViewManagerSetter findManagerSetter(Class cls) {
        Map map = VIEW_MANAGER_SETTER_MAP;
        ViewManagerSetter fallbackViewManagerSetter = (ViewManagerSetter) map.get(cls);
        if (fallbackViewManagerSetter == null) {
            fallbackViewManagerSetter = (ViewManagerSetter) findGeneratedSetter(cls);
            if (fallbackViewManagerSetter == null) {
                fallbackViewManagerSetter = new FallbackViewManagerSetter(cls);
            }
            map.put(cls, fallbackViewManagerSetter);
        }
        return fallbackViewManagerSetter;
    }

    private final ShadowNodeSetter findNodeSetter(Class cls) {
        Map map = SHADOW_NODE_SETTER_MAP;
        ShadowNodeSetter fallbackShadowNodeSetter = (ShadowNodeSetter) map.get(cls);
        if (fallbackShadowNodeSetter == null) {
            fallbackShadowNodeSetter = (ShadowNodeSetter) findGeneratedSetter(cls);
            if (fallbackShadowNodeSetter == null) {
                Intrinsics.checkNotNull(cls, "null cannot be cast to non-null type java.lang.Class<kotlin.Nothing>");
                fallbackShadowNodeSetter = new FallbackShadowNodeSetter(cls);
            }
            map.put(cls, fallbackShadowNodeSetter);
        }
        return fallbackShadowNodeSetter;
    }

    private final Object findGeneratedSetter(Class cls) {
        String name = cls.getName();
        try {
            return Class.forName(name + "$$PropsSetter").newInstance();
        } catch (ClassNotFoundException unused) {
            FLog.w("ViewManagerPropertyUpdater", "Could not find generated setter for " + cls);
            return null;
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Unable to instantiate methods getter for " + name, e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("Unable to instantiate methods getter for " + name, e2);
        }
    }

    private static final class FallbackViewManagerSetter implements ViewManagerSetter {
        private final Map propSetters;

        public FallbackViewManagerSetter(Class viewManagerClass) {
            Intrinsics.checkNotNullParameter(viewManagerClass, "viewManagerClass");
            Map nativePropSettersForViewManagerClass = ViewManagersPropertyCache.getNativePropSettersForViewManagerClass(viewManagerClass);
            Intrinsics.checkNotNullExpressionValue(nativePropSettersForViewManagerClass, "getNativePropSettersForViewManagerClass(...)");
            this.propSetters = nativePropSettersForViewManagerClass;
        }

        @Override // com.facebook.react.uimanager.ViewManagerPropertyUpdater.ViewManagerSetter
        public void setProperty(ViewManager manager, View view, String name, Object obj) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(name, "name");
            ViewManagersPropertyCache.PropSetter propSetter = (ViewManagersPropertyCache.PropSetter) this.propSetters.get(name);
            if (propSetter != null) {
                propSetter.updateViewProp(manager, view, obj);
            }
        }

        @Override // com.facebook.react.uimanager.ViewManagerPropertyUpdater.Settable
        public void getProperties(Map props) {
            Intrinsics.checkNotNullParameter(props, "props");
            for (ViewManagersPropertyCache.PropSetter propSetter : this.propSetters.values()) {
                props.put(propSetter.getPropName(), propSetter.getPropType());
            }
        }
    }

    private static final class FallbackShadowNodeSetter implements ShadowNodeSetter {
        private final Map propSetters;

        public FallbackShadowNodeSetter(Class shadowNodeClass) {
            Intrinsics.checkNotNullParameter(shadowNodeClass, "shadowNodeClass");
            Map nativePropSettersForShadowNodeClass = ViewManagersPropertyCache.getNativePropSettersForShadowNodeClass(shadowNodeClass);
            Intrinsics.checkNotNullExpressionValue(nativePropSettersForShadowNodeClass, "getNativePropSettersForShadowNodeClass(...)");
            this.propSetters = nativePropSettersForShadowNodeClass;
        }

        @Override // com.facebook.react.uimanager.ViewManagerPropertyUpdater.ShadowNodeSetter
        public void setProperty(ReactShadowNode node, String name, Object obj) {
            Intrinsics.checkNotNullParameter(node, "node");
            Intrinsics.checkNotNullParameter(name, "name");
            ViewManagersPropertyCache.PropSetter propSetter = (ViewManagersPropertyCache.PropSetter) this.propSetters.get(name);
            if (propSetter != null) {
                propSetter.updateShadowNodeProp(node, obj);
            }
        }

        @Override // com.facebook.react.uimanager.ViewManagerPropertyUpdater.Settable
        public void getProperties(Map props) {
            Intrinsics.checkNotNullParameter(props, "props");
            for (ViewManagersPropertyCache.PropSetter propSetter : this.propSetters.values()) {
                props.put(propSetter.getPropName(), propSetter.getPropType());
            }
        }
    }

    public static final class GenericViewManagerDelegate implements ViewManagerDelegate {
        private final ViewManager manager;
        private final ViewManagerSetter setter;

        @Override // com.facebook.react.uimanager.ViewManagerDelegate
        /* JADX INFO: renamed from: receiveCommand, reason: merged with bridge method [inline-methods] */
        public void kotlinCompat$receiveCommand(View view, String commandName, ReadableArray args) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(commandName, "commandName");
            Intrinsics.checkNotNullParameter(args, "args");
        }

        public GenericViewManagerDelegate(ViewManager manager) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            this.manager = manager;
            this.setter = ViewManagerPropertyUpdater.INSTANCE.findManagerSetter(manager.getClass());
        }

        @Override // com.facebook.react.uimanager.ViewManagerDelegate
        public void setProperty(View view, String propName, Object obj) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(propName, "propName");
            this.setter.setProperty(this.manager, view, propName, obj);
        }
    }
}
