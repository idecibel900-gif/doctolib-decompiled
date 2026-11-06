package expo.modules.kotlin.services;

import expo.modules.kotlin.AppContext;
import java.lang.annotation.Annotation;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ServicesRegistry {
    private final WeakReference appContextHolder;
    private final Map registry;

    public ServicesRegistry(WeakReference appContextHolder) {
        Intrinsics.checkNotNullParameter(appContextHolder, "appContextHolder");
        this.appContextHolder = appContextHolder;
        this.registry = new LinkedHashMap();
    }

    public final Map getRegistry() {
        return this.registry;
    }

    public final ServicesRegistry register(Class serviceClass) {
        Intrinsics.checkNotNullParameter(serviceClass, "serviceClass");
        Object obj = this.appContextHolder.get();
        if (obj == null) {
            throw new IllegalArgumentException("Cannot register a service to an invalid app context.");
        }
        Service serviceConstruct = Service.INSTANCE.construct(serviceClass, (AppContext) obj);
        Iterator it = getServiceInterfaces(serviceConstruct).iterator();
        while (it.hasNext()) {
            this.registry.put((Class) it.next(), serviceConstruct);
        }
        return this;
    }

    public final ServicesRegistry register(List serviceClasses) {
        Intrinsics.checkNotNullParameter(serviceClasses, "serviceClasses");
        Iterator it = serviceClasses.iterator();
        while (it.hasNext()) {
            register((Class) it.next());
        }
        return this;
    }

    private final List getServiceInterfaces(Service service) {
        Class<?> cls = service.getClass();
        Annotation[] annotationsByType = cls.getAnnotationsByType(ServiceInterface.class);
        Intrinsics.checkNotNullExpressionValue(annotationsByType, "getAnnotationsByType(...)");
        ArrayList arrayList = new ArrayList(annotationsByType.length);
        for (Annotation annotation : annotationsByType) {
            arrayList.add(((ServiceInterface) annotation).clazz());
        }
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        return arrayList == null ? CollectionsKt.listOf(cls) : arrayList;
    }
}
