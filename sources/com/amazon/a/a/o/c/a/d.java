package com.amazon.a.a.o.c.a;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public enum d implements Serializable {
    SENSITIVE("Sensitive", true),
    INSENSITIVE("Insensitive", false),
    SYSTEM("System", !b.a());

    private static final long d = -6343169151696340687L;
    private final String e;
    private final transient boolean f;

    public static d a(String str) {
        for (d dVar : values()) {
            if (dVar.a().equals(str)) {
                return dVar;
            }
        }
        throw new IllegalArgumentException("Invalid IOCase name: " + str);
    }

    d(String str, boolean z) {
        this.e = str;
        this.f = z;
    }

    private Object c() {
        return a(this.e);
    }

    public String a() {
        return this.e;
    }

    public boolean b() {
        return this.f;
    }

    public int a(String str, String str2) {
        if (str == null || str2 == null) {
            throw new NullPointerException("The strings must not be null");
        }
        return this.f ? str.compareTo(str2) : str.compareToIgnoreCase(str2);
    }

    public boolean b(String str, String str2) {
        if (str == null || str2 == null) {
            throw new NullPointerException("The strings must not be null");
        }
        return this.f ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public boolean c(String str, String str2) {
        return str.regionMatches(!this.f, 0, str2, 0, str2.length());
    }

    public boolean d(String str, String str2) {
        int length = str2.length();
        return str.regionMatches(!this.f, str.length() - length, str2, 0, length);
    }

    public int a(String str, int i, String str2) {
        int length = str.length() - str2.length();
        if (length < i) {
            return -1;
        }
        while (i <= length) {
            if (b(str, i, str2)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public boolean b(String str, int i, String str2) {
        return str.regionMatches(!this.f, i, str2, 0, str2.length());
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.e;
    }
}
