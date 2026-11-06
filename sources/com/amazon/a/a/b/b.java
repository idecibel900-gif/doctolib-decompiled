package com.amazon.a.a.b;

import android.app.Application;
import com.amazon.a.a.c.f;
import com.amazon.a.a.k.d;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: classes3.dex */
public class b implements a, d, Thread.UncaughtExceptionHandler {
    private static final com.amazon.a.a.o.c a = new com.amazon.a.a.o.c("CrashManagerImpl");
    private static final String b = "s-";
    private static final String c = ".amzst";
    private static final int d = 99999;
    private static final int e = 5;

    @com.amazon.a.a.k.a
    private f f;

    @com.amazon.a.a.k.a
    private Application g;
    private Thread.UncaughtExceptionHandler h;
    private Map<c, String> i = new HashMap();

    @Override // com.amazon.a.a.k.d
    public void e() {
        com.amazon.a.a.o.a.a.a();
        b();
    }

    private void b() {
        if (Thread.getDefaultUncaughtExceptionHandler() instanceof a) {
            return;
        }
        if (com.amazon.a.a.o.c.a) {
            a.a("Registering Crash Handler");
        }
        this.h = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (com.amazon.a.a.o.c.a) {
            a.a("Crash detected", th);
        }
        try {
            a(th);
            this.f.a(new com.amazon.a.a.b.a.a());
        } catch (Throwable th2) {
            if (com.amazon.a.a.o.c.a) {
                a.a("Error occured while handling exception", th2);
            }
        }
        if (com.amazon.a.a.o.c.a) {
            a.a("Calling previous handler");
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.h;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    private void a(Throwable th) {
        try {
            a(a(new c(this.g, th)));
        } catch (Throwable th2) {
            if (com.amazon.a.a.o.c.b) {
                a.b("Could not handle uncaught exception", th2);
            }
        }
    }

    private String a(c cVar) {
        return com.amazon.a.a.o.c.a.a(cVar);
    }

    private synchronized void a(String str) {
        FileOutputStream fileOutputStreamOpenFileOutput = null;
        try {
            try {
                fileOutputStreamOpenFileOutput = this.g.openFileOutput(b + new Random().nextInt(d) + c, 0);
                fileOutputStreamOpenFileOutput.write(str.getBytes());
            } catch (Exception e2) {
                if (com.amazon.a.a.o.c.b) {
                    a.b("Coud not save crash report to file", e2);
                }
            }
            com.amazon.a.a.o.a.a(fileOutputStreamOpenFileOutput);
        } catch (Throwable th) {
            com.amazon.a.a.o.a.a(fileOutputStreamOpenFileOutput);
            throw th;
        }
    }

    @Override // com.amazon.a.a.b.a
    public List<c> a() {
        if (c()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        String[] strArrD = d();
        for (int i = 0; i < strArrD.length && !c(); i++) {
            String strE = e(strArrD[i]);
            c cVarB = b(strE);
            if (cVarB != null) {
                this.i.put(cVarB, strE);
                arrayList.add(cVarB);
            } else {
                d(strE);
            }
        }
        return arrayList;
    }

    private boolean c() {
        return this.i.size() >= 5;
    }

    private c b(String str) {
        try {
            return (c) com.amazon.a.a.o.c.a.a(c(str));
        } catch (Exception unused) {
            if (!com.amazon.a.a.o.c.b) {
                return null;
            }
            a.b("Failed to load crash report: " + str);
            return null;
        }
    }

    private String c(String str) throws Throwable {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(str));
            while (bufferedReader2.ready()) {
                try {
                    sb.append(bufferedReader2.readLine());
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    com.amazon.a.a.o.a.a(bufferedReader);
                    throw th;
                }
            }
            com.amazon.a.a.o.a.a(bufferedReader2);
            return sb.toString();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private String[] d() {
        return new File(this.g.getFilesDir().getAbsolutePath() + "/").list(new FilenameFilter() { // from class: com.amazon.a.a.b.b.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.endsWith(b.c) && !b.this.i.containsValue(str);
            }
        });
    }

    @Override // com.amazon.a.a.b.a
    public void a(List<c> list) {
        for (c cVar : list) {
            d(this.i.get(cVar));
            this.i.remove(cVar);
        }
    }

    private void d(String str) {
        try {
            new File(str).delete();
        } catch (Exception e2) {
            if (com.amazon.a.a.o.c.b) {
                a.b("Cannot delete file: " + str, e2);
            }
        }
    }

    private String e(String str) {
        return this.g.getFilesDir().getAbsolutePath() + "/" + str;
    }
}
