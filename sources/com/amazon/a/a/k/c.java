package com.amazon.a.a.k;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class c implements b {
    public static final com.amazon.a.a.o.c a = new com.amazon.a.a.o.c("ResourceManagerImpl");
    private List<Object> b = new ArrayList();
    private boolean c = false;

    public c() {
        a(this);
    }

    @Override // com.amazon.a.a.k.b
    public void a(Object obj) {
        if (com.amazon.a.a.o.c.a) {
            a.a("Registering resource: " + obj);
        }
        com.amazon.a.a.o.a.a.a();
        if (this.c) {
            throw new IllegalStateException("Attempt made to register resource after population has begun!");
        }
        com.amazon.a.a.o.a.a.b(c(obj), "Resource already registered: " + obj);
        this.b.add(obj);
    }

    private boolean c(Object obj) {
        com.amazon.a.a.o.a.a.a(obj, "resource");
        return a(obj.getClass()) != null;
    }

    private Object a(Class<?> cls) {
        for (Object obj : this.b) {
            if (cls.isAssignableFrom(obj.getClass())) {
                return obj;
            }
        }
        return null;
    }

    @Override // com.amazon.a.a.k.b
    public void b(Object obj) {
        com.amazon.a.a.o.a.a.a(obj, "target");
        if (com.amazon.a.a.o.c.a) {
            a.a("Populating: " + obj);
        }
        if (!d(obj)) {
            a.a("Ignoring: " + obj + ", not a kiwi class");
            return;
        }
        for (Class<?> superclass = obj.getClass(); superclass != Object.class; superclass = superclass.getSuperclass()) {
            for (Field field : superclass.getDeclaredFields()) {
                if (a(field)) {
                    a(obj, field);
                }
            }
        }
        if (obj instanceof d) {
            ((d) obj).e();
        }
    }

    private boolean d(Object obj) {
        return obj.getClass().getName().startsWith("com.amazon.");
    }

    private boolean a(Field field) {
        return field.getAnnotation(a.class) != null;
    }

    private void a(Object obj, Field field) {
        Class<?> type = field.getType();
        Object objA = a(type);
        com.amazon.a.a.o.a.a.b(objA, "no resource found for type: " + type);
        field.setAccessible(true);
        try {
            field.set(obj, objA);
        } catch (Exception e) {
            com.amazon.a.a.o.a.a.a("Failed to populate field: " + field, (Throwable) e);
        }
    }

    @Override // com.amazon.a.a.k.b
    public void a() {
        Iterator<Object> it = this.b.iterator();
        while (it.hasNext()) {
            b(it.next());
        }
    }
}
