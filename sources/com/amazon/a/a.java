package com.amazon.a;

import android.app.Application;
import android.content.Context;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements com.amazon.a.a.k.d {
    protected static final String a = "ActivityName";
    protected static final String b = "EventName";
    protected static final String c = "Timestamp";
    private static final com.amazon.a.a.o.c d = new com.amazon.a.a.o.c("AppstoreSDK");
    private static final com.amazon.a.a.g.c e = new com.amazon.a.a.g.a();
    private static a f;

    @com.amazon.a.a.k.a
    private com.amazon.a.a.a.a g;

    @com.amazon.a.a.k.a
    private com.amazon.a.a.l.b h;

    @com.amazon.a.a.k.a
    private com.amazon.a.a.c.f i;

    @com.amazon.a.a.k.a
    private com.amazon.a.a.n.b j;

    @com.amazon.a.a.k.a
    private com.amazon.a.a.i.e k;

    @com.amazon.a.a.k.a
    private com.amazon.a.a.m.c l;

    @com.amazon.a.a.k.a
    private Application m;

    @com.amazon.a.a.k.a
    private com.amazon.a.a.o.b.b n;

    @com.amazon.a.a.k.a
    private com.amazon.a.a.g.c o;

    private a(Application application) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (com.amazon.a.a.o.c.a) {
            d.a("Starting initialization process for application: " + application.getPackageName());
        }
        b(application);
        if (com.amazon.a.a.o.c.a) {
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            d.a("AppstoreSDK.Constructor Time: " + (jCurrentTimeMillis2 - jCurrentTimeMillis));
        }
    }

    private void b(Application application) {
        Object bVar;
        com.amazon.a.a.k.c cVar = new com.amazon.a.a.k.c();
        cVar.a(application);
        cVar.a(new com.amazon.a.a.n.d());
        cVar.a(new com.amazon.a.a.m.c());
        cVar.a(new com.amazon.a.a.l.c());
        cVar.a(new com.amazon.a.a.a.c());
        cVar.a(new com.amazon.a.a.i.f());
        cVar.a(new com.amazon.a.a.c.g());
        cVar.a(new com.amazon.a.a.b.b());
        cVar.a(new com.amazon.a.a.h.d());
        cVar.a(new com.amazon.a.a.n.a.d());
        cVar.a(new com.amazon.a.a.o.b.d());
        cVar.a(new com.amazon.a.a.n.a.b());
        if (a(application)) {
            bVar = new com.amazon.a.a.g.d();
        } else {
            bVar = new com.amazon.a.a.g.b();
        }
        cVar.a(bVar);
        cVar.a();
        cVar.b(this);
    }

    public static void a(Context context) {
        if (d()) {
            return;
        }
        synchronized (a.class) {
            try {
                if (!d()) {
                    Application application = (Application) context.getApplicationContext();
                    f = new a(application);
                    application.registerActivityLifecycleCallbacks(com.amazon.a.a.f.a.a());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean a(Application application) throws Throwable {
        boolean z = (application.getApplicationInfo().flags & 2) != 0;
        boolean zL = l();
        if (z && zL) {
            d.a("Sandbox Mode: Debug build and debug.amazon.sandboxmode property is set on device");
            return true;
        }
        d.a("Production Mode: Release build or debug.amazon.sandboxmode property is not set on device");
        return false;
    }

    private static boolean l() throws Throwable {
        String strA;
        try {
            strA = (String) Class.forName(com.amazon.a.a.o.b.at).getMethod(com.amazon.a.a.o.b.au, String.class).invoke(null, com.amazon.a.a.o.b.aq);
        } catch (Throwable unused) {
            d.b("Unable to retrieve Sandbox property through reflection, using getProp");
            strA = a(com.amazon.a.a.o.b.aq);
        }
        return "debug".equals(strA);
    }

    private static String a(String str) throws Throwable {
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(new String[]{com.amazon.a.a.o.b.as, str}).getInputStream()));
                try {
                    String line = bufferedReader2.readLine();
                    try {
                        bufferedReader2.close();
                        return line;
                    } catch (Exception unused) {
                        d.b("Unable to close BufferedReader instance");
                        return line;
                    }
                } catch (IOException e2) {
                    e = e2;
                    bufferedReader = bufferedReader2;
                    d.a("Can't get system property", e);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                            return "";
                        } catch (Exception unused2) {
                            d.b("Unable to close BufferedReader instance");
                            return "";
                        }
                    }
                    return "";
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused3) {
                            d.b("Unable to close BufferedReader instance");
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e3) {
            e = e3;
        }
    }

    @Deprecated
    public static void a(com.amazon.a.a.n.a.a aVar) {
        if (com.amazon.a.a.o.c.a) {
            d.a("WARNING: Use of deprecated method detected.");
        }
        if (d()) {
            c(aVar);
        } else {
            d.b("AppstoreSDK subsystem is not fully initialized.  Cannot process task.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(com.amazon.a.a.n.a.a aVar) {
        if (!d()) {
            d.b("AppstoreSDK subsystem is not fully initialized.  Cannot process task.");
        } else {
            f.j.a(com.amazon.a.a.n.b.d.COMMAND, aVar);
        }
    }

    public static void a(com.amazon.a.a.n.a.a aVar, Context context) {
        if (!d()) {
            if (context != null && context.getApplicationContext() != null) {
                f = new a((Application) context.getApplicationContext());
            } else {
                d.b("AppstoreSDK subsystem cannot be initialized because of null context. Unable to enqueue task.");
                return;
            }
        }
        c(aVar);
    }

    public static com.amazon.a.a.i.e a() {
        if (!d()) {
            d.b("Appstore SDK is not initialized. Cannot get PromptManager returning null");
            return null;
        }
        return f.k;
    }

    public static com.amazon.a.a.a.a b() {
        if (!d()) {
            d.b("Appstore SDK is not initialized. Cannot get ContextManager returning null");
            return null;
        }
        return f.g;
    }

    public static com.amazon.a.a.g.c c() {
        if (!d()) {
            d.a("Appstore SDK is not initialized. Returning default log handler");
            return e;
        }
        return f.o;
    }

    public static boolean a(String str, String str2) {
        if (d()) {
            try {
                return com.amazon.a.a.o.b.e.a(str, str2, f.n.a());
            } catch (com.amazon.a.a.o.b.a.a e2) {
                d.a("Unable to validate signature: " + e2.getMessage());
                return false;
            }
        }
        d.a("AppstoreSDK was not yet initialized - cannot do the IAP call");
        return false;
    }

    public static boolean a(String str, Context context) {
        com.amazon.a.a.o.a.a.a();
        if (com.amazon.a.a.o.c.a) {
            d.a(str + ": " + context);
        }
        if (d()) {
            return true;
        }
        b(str, context);
        return false;
    }

    public static boolean d() {
        return f != null;
    }

    private static void b(String str, Context context) {
        if (com.amazon.a.a.o.c.a) {
            d.a(str + " called on context: " + context + " when AppstoreSDK is dead, ignoring...");
        }
    }

    @Override // com.amazon.a.a.k.d
    public void e() {
        h();
        j();
        f();
        g();
    }

    public void f() {
        this.i.a(new com.amazon.a.a.c.c<com.amazon.a.a.a.a.a>() { // from class: com.amazon.a.a.1
            @Override // com.amazon.a.a.c.c
            public com.amazon.a.a.c.b a() {
                return com.amazon.a.a.a.a.b.PAUSE;
            }

            @Override // com.amazon.a.a.c.c
            public com.amazon.a.a.c.d b() {
                return com.amazon.a.a.c.d.MIDDLE;
            }

            @Override // com.amazon.a.a.c.c
            public void a(com.amazon.a.a.a.a.a aVar) {
                HashMap map = new HashMap();
                map.put(a.b, com.amazon.a.a.a.a.b.PAUSE.name());
                map.put(a.a, aVar.b().getClass().getName());
                map.put(a.c, Long.valueOf(System.currentTimeMillis()));
                com.amazon.a.a.f.b bVar = new com.amazon.a.a.f.b(map);
                if (com.amazon.a.a.o.c.a) {
                    a.d.a("Adding lifecycle PAUSE command to pipeline");
                }
                a.c(bVar);
            }
        });
    }

    public void g() {
        this.i.a(new com.amazon.a.a.c.c<com.amazon.a.a.a.a.a>() { // from class: com.amazon.a.a.2
            @Override // com.amazon.a.a.c.c
            public com.amazon.a.a.c.b a() {
                return com.amazon.a.a.a.a.b.RESUME;
            }

            @Override // com.amazon.a.a.c.c
            public com.amazon.a.a.c.d b() {
                return com.amazon.a.a.c.d.MIDDLE;
            }

            @Override // com.amazon.a.a.c.c
            public void a(com.amazon.a.a.a.a.a aVar) {
                HashMap map = new HashMap();
                map.put(a.b, com.amazon.a.a.a.a.b.RESUME.name());
                map.put(a.a, aVar.b().getClass().getName());
                map.put(a.c, Long.valueOf(System.currentTimeMillis()));
                com.amazon.a.a.f.b bVar = new com.amazon.a.a.f.b(map);
                if (com.amazon.a.a.o.c.a) {
                    a.d.a("Adding lifecycle RESUME command to pipeline");
                }
                a.c(bVar);
            }
        });
    }

    public void h() {
        this.i.a(new com.amazon.a.a.c.c<com.amazon.a.a.a.a.c>() { // from class: com.amazon.a.a.3
            @Override // com.amazon.a.a.c.c
            public com.amazon.a.a.c.b a() {
                return com.amazon.a.a.a.a.d.CREATE;
            }

            @Override // com.amazon.a.a.c.c
            public com.amazon.a.a.c.d b() {
                return com.amazon.a.a.c.d.LAST;
            }

            @Override // com.amazon.a.a.c.c
            public void a(com.amazon.a.a.a.a.c cVar) {
                a.this.i();
            }
        });
    }

    public void i() {
        if (com.amazon.a.a.o.c.a) {
            d.a("Enqueuing launch workflow");
        }
        if (a(this.m)) {
            return;
        }
        this.j.a(com.amazon.a.a.n.b.d.COMMAND, m());
    }

    private com.amazon.a.a.n.a m() {
        return new e();
    }

    public void j() {
        this.i.a(new com.amazon.a.a.c.c<com.amazon.a.a.a.a.c>() { // from class: com.amazon.a.a.4
            @Override // com.amazon.a.a.c.c
            public com.amazon.a.a.c.b a() {
                return com.amazon.a.a.a.a.d.DESTROY;
            }

            @Override // com.amazon.a.a.c.c
            public com.amazon.a.a.c.d b() {
                return com.amazon.a.a.c.d.LAST;
            }

            @Override // com.amazon.a.a.c.c
            public void a(com.amazon.a.a.a.a.c cVar) {
                if (com.amazon.a.a.o.c.a) {
                    a.d.a("Beginning shutdown process for application: " + a.this.m.getPackageName());
                }
                a unused = a.f = null;
            }
        });
    }
}
