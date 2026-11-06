package com.facebook.react.uimanager;

import com.facebook.common.logging.FLog;
import com.facebook.react.common.build.ReactBuildConfig;
import com.facebook.react.internal.featureflags.ReactNativeNewArchitectureFeatureFlags;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class UIManagerModuleConstantsHelper {
    public static final UIManagerModuleConstantsHelper INSTANCE = new UIManagerModuleConstantsHelper();

    private UIManagerModuleConstantsHelper() {
    }

    public static final Map internal_createConstants(ViewManagerResolver resolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        return MapsKt.plus(UIManagerModuleConstants.constants, MapsKt.mapOf(TuplesKt.to("ViewManagerNames", new ArrayList(resolver.getViewManagerNames())), TuplesKt.to("LazyViewManagersEnabled", Boolean.TRUE)));
    }

    public static final Map getDefaultExportableEventTypes() {
        return MapsKt.mapOf(TuplesKt.to("bubblingEventTypes", UIManagerModuleConstants.bubblingEventTypeConstants), TuplesKt.to("directEventTypes", UIManagerModuleConstants.directEventTypeConstants));
    }

    private final void validateDirectEventNames(String str, Map map) {
        String str2;
        if (!ReactBuildConfig.DEBUG || map == null) {
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            String str3 = (String) entry.getKey();
            Object value = entry.getValue();
            if (TypeIntrinsics.isMutableMap(value) && (str2 = (String) ((Map) value).get("registrationName")) != null && StringsKt.startsWith$default(str3, "top", false, 2, (Object) null) && StringsKt.startsWith$default(str2, "on", false, 2, (Object) null)) {
                String strSubstring = str3.substring(3);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                String strSubstring2 = str2.substring(2);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                if (!Intrinsics.areEqual(strSubstring, strSubstring2)) {
                    FLog.e("UIManagerModuleConstantsHelper", "Direct event name for '" + str + "' doesn't correspond to the naming convention, expected 'topEventName'->'onEventName', got '" + str3 + "'->'" + str2 + "'");
                }
            }
        }
    }

    public static final Map internal_createConstants(List viewManagers, Map map, Map map2) {
        Intrinsics.checkNotNullParameter(viewManagers, "viewManagers");
        Map mutableMap = MapsKt.toMutableMap(UIManagerModuleConstants.constants);
        Map map3 = UIManagerModuleConstants.bubblingEventTypeConstants;
        Map map4 = UIManagerModuleConstants.directEventTypeConstants;
        if (map != null) {
            map.putAll(map3);
        }
        if (map2 != null) {
            map2.putAll(map4);
        }
        Iterator it = viewManagers.iterator();
        while (it.hasNext()) {
            ViewManager viewManager = (ViewManager) it.next();
            String name = viewManager.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            Map mapInternal_createConstantsForViewManager = internal_createConstantsForViewManager(viewManager, null, null, map, map2);
            if (!mapInternal_createConstantsForViewManager.isEmpty()) {
                mutableMap.put(name, mapInternal_createConstantsForViewManager);
            }
        }
        mutableMap.put("genericBubblingEventTypes", map3);
        mutableMap.put("genericDirectEventTypes", map4);
        return mutableMap;
    }

    public static final Map internal_createConstantsForViewManager(ViewManager viewManager, Map map, Map map2, Map map3, Map map4) {
        Intrinsics.checkNotNullParameter(viewManager, "viewManager");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Map exportedCustomBubblingEventTypeConstants = viewManager.getExportedCustomBubblingEventTypeConstants();
        if (exportedCustomBubblingEventTypeConstants != null) {
            if (ReactNativeNewArchitectureFeatureFlags.enableFabricRenderer() && ReactNativeNewArchitectureFeatureFlags.useFabricInterop()) {
                exportedCustomBubblingEventTypeConstants = INSTANCE.normalizeEventTypes$ReactAndroid_release(exportedCustomBubblingEventTypeConstants);
            }
            UIManagerModuleConstantsHelper uIManagerModuleConstantsHelper = INSTANCE;
            uIManagerModuleConstantsHelper.recursiveMerge(map3, exportedCustomBubblingEventTypeConstants);
            uIManagerModuleConstantsHelper.recursiveMerge(exportedCustomBubblingEventTypeConstants, map);
            linkedHashMap.put("bubblingEventTypes", exportedCustomBubblingEventTypeConstants);
        } else if (map != null) {
            linkedHashMap.put("bubblingEventTypes", map);
        }
        Map exportedCustomDirectEventTypeConstants = viewManager.getExportedCustomDirectEventTypeConstants();
        UIManagerModuleConstantsHelper uIManagerModuleConstantsHelper2 = INSTANCE;
        String name = viewManager.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        uIManagerModuleConstantsHelper2.validateDirectEventNames(name, exportedCustomDirectEventTypeConstants);
        if (exportedCustomDirectEventTypeConstants != null) {
            if (ReactNativeNewArchitectureFeatureFlags.enableFabricRenderer() && ReactNativeNewArchitectureFeatureFlags.useFabricInterop()) {
                exportedCustomDirectEventTypeConstants = uIManagerModuleConstantsHelper2.normalizeEventTypes$ReactAndroid_release(exportedCustomDirectEventTypeConstants);
            }
            uIManagerModuleConstantsHelper2.recursiveMerge(map4, exportedCustomDirectEventTypeConstants);
            uIManagerModuleConstantsHelper2.recursiveMerge(exportedCustomDirectEventTypeConstants, map2);
            linkedHashMap.put("directEventTypes", exportedCustomDirectEventTypeConstants);
        } else if (map2 != null) {
            linkedHashMap.put("directEventTypes", map2);
        }
        Map<String, Object> exportedViewConstants = viewManager.getExportedViewConstants();
        if (exportedViewConstants != null) {
            linkedHashMap.put("Constants", exportedViewConstants);
        }
        Map<String, Integer> commandsMap = viewManager.getCommandsMap();
        if (commandsMap != null) {
            linkedHashMap.put("Commands", commandsMap);
        }
        Map<String, String> nativeProps = viewManager.getNativeProps();
        if (!nativeProps.isEmpty()) {
            Intrinsics.checkNotNull(nativeProps);
            linkedHashMap.put("NativeProps", nativeProps);
        }
        return linkedHashMap;
    }

    public final Map normalizeEventTypes$ReactAndroid_release(Map eventsToNormalize) {
        String strSubstring;
        Intrinsics.checkNotNullParameter(eventsToNormalize, "eventsToNormalize");
        HashSet<String> hashSet = new HashSet();
        for (String str : eventsToNormalize.keySet()) {
            if (!StringsKt.startsWith$default(str, "top", false, 2, (Object) null)) {
                hashSet.add(str);
            }
        }
        if (!(eventsToNormalize instanceof HashMap)) {
            eventsToNormalize = new HashMap(eventsToNormalize);
        }
        for (String str2 : hashSet) {
            Object obj = eventsToNormalize.get(str2);
            if (obj == null) {
                throw new IllegalStateException("Required value was null.");
            }
            if (StringsKt.startsWith$default(str2, "on", false, 2, (Object) null)) {
                strSubstring = str2.substring(2);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            } else {
                String strSubstring2 = str2.substring(0, 1);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                String upperCase = strSubstring2.toUpperCase(locale);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                String strSubstring3 = str2.substring(1);
                Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
                strSubstring = upperCase + strSubstring3;
            }
            eventsToNormalize.put("top" + strSubstring, obj);
        }
        return eventsToNormalize;
    }

    private final void recursiveMerge(Map map, Map map2) {
        if (map == null || map2 == null || map2.isEmpty()) {
            return;
        }
        for (Map.Entry entry : map2.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            Object obj = map.get(str);
            if (obj != null && TypeIntrinsics.isMutableMap(value) && TypeIntrinsics.isMutableMap(obj)) {
                if (!(obj instanceof HashMap)) {
                    HashMap map3 = new HashMap((Map) obj);
                    map.replace(str, TypeIntrinsics.asMutableMap(map3));
                    obj = map3;
                }
                Map mapAsMutableMap = TypeIntrinsics.asMutableMap(obj);
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any>");
                recursiveMerge(mapAsMutableMap, TypeIntrinsics.asMutableMap(value));
            } else {
                map.put(str, value);
            }
        }
    }
}
