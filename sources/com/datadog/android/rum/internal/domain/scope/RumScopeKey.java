package com.datadog.android.rum.internal.domain.scope;

import android.app.Activity;
import android.content.ComponentName;
import com.amazon.a.a.o.c.a.b;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class RumScopeKey {
    public static final Companion Companion = new Companion(null);
    private final String id;
    private final String name;
    private final String url;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RumScopeKey)) {
            return false;
        }
        RumScopeKey rumScopeKey = (RumScopeKey) obj;
        return Intrinsics.areEqual(this.id, rumScopeKey.id) && Intrinsics.areEqual(this.url, rumScopeKey.url) && Intrinsics.areEqual(this.name, rumScopeKey.name);
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + this.url.hashCode()) * 31) + this.name.hashCode();
    }

    public String toString() {
        return "RumScopeKey(id=" + this.id + ", url=" + this.url + ", name=" + this.name + ")";
    }

    public RumScopeKey(String id, String url, String name) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = id;
        this.url = url;
        this.name = name;
    }

    public final String getId() {
        return this.id;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getName() {
        return this.name;
    }

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ RumScopeKey from$default(Companion companion, Object obj, String str, int i, Object obj2) {
            if ((i & 2) != 0) {
                str = null;
            }
            return companion.from(obj, str);
        }

        public final RumScopeKey from(Object key, String str) {
            Intrinsics.checkNotNullParameter(key, "key");
            ComponentName componentNameResolveComponent = resolveComponent(key);
            if (componentNameResolveComponent == null) {
                String strResolveId = resolveId(key);
                String strResolveUrl = resolveUrl(key);
                if (str == null) {
                    str = resolveName(key);
                }
                return new RumScopeKey(strResolveId, strResolveUrl, str);
            }
            String str2 = componentNameResolveComponent.getClassName() + "@" + System.identityHashCode(key);
            String strResolveComponentUrl = resolveComponentUrl(componentNameResolveComponent);
            if (str == null) {
                str = componentNameResolveComponent.getClassName();
                Intrinsics.checkNotNullExpressionValue(str, "componentName.className");
            }
            return new RumScopeKey(str2, strResolveComponentUrl, str);
        }

        private final String resolveId(Object obj) {
            if (obj instanceof String) {
                return (String) obj;
            }
            if (obj instanceof Number) {
                return obj.toString();
            }
            if (!(obj instanceof Enum)) {
                return obj.toString();
            }
            return obj.getClass().getName() + "@" + ((Enum) obj).name();
        }

        private final String resolveUrl(Object obj) {
            if (obj instanceof String) {
                return (String) obj;
            }
            if (obj instanceof Number) {
                return obj.toString();
            }
            if (!(obj instanceof Enum)) {
                String canonicalName = obj.getClass().getCanonicalName();
                if (canonicalName == null) {
                    canonicalName = obj.getClass().getSimpleName();
                }
                Intrinsics.checkNotNullExpressionValue(canonicalName, "key.javaClass.canonicalN… key.javaClass.simpleName");
                return canonicalName;
            }
            return obj.getClass().getName() + "." + ((Enum) obj).name();
        }

        private final String resolveName(Object obj) {
            if (obj instanceof String) {
                return (String) obj;
            }
            if (obj instanceof Number) {
                return obj.toString();
            }
            if (obj instanceof Enum) {
                return ((Enum) obj).name();
            }
            String name = obj.getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "key.javaClass.name");
            return name;
        }

        private final String resolveComponentUrl(ComponentName componentName) {
            String packageName = componentName.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "key.packageName");
            if (packageName.length() == 0) {
                String className = componentName.getClassName();
                Intrinsics.checkNotNullExpressionValue(className, "key.className");
                return className;
            }
            String className2 = componentName.getClassName();
            Intrinsics.checkNotNullExpressionValue(className2, "key.className");
            if (StringsKt.startsWith$default(className2, componentName.getPackageName() + ".", false, 2, (Object) null)) {
                String className3 = componentName.getClassName();
                Intrinsics.checkNotNullExpressionValue(className3, "key.className");
                return className3;
            }
            String className4 = componentName.getClassName();
            Intrinsics.checkNotNullExpressionValue(className4, "key.className");
            if (StringsKt.contains$default((CharSequence) className4, b.a, false, 2, (Object) null)) {
                String className5 = componentName.getClassName();
                Intrinsics.checkNotNullExpressionValue(className5, "key.className");
                return className5;
            }
            return componentName.getPackageName() + "." + componentName.getClassName();
        }

        private final ComponentName resolveComponent(Object obj) {
            if (obj instanceof Activity) {
                return ((Activity) obj).getComponentName();
            }
            return null;
        }
    }
}
