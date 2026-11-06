package com.adjust.sdk.sig;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class v2 {
    public final x a;
    public final i1 b;
    public final p3 c;
    public final v2[] d;
    public final l1 e;
    public String f;
    public String g;

    public v2(x xVar, i1 i1Var, p3 p3Var, v2[] v2VarArr) {
        this.a = xVar;
        this.b = i1Var;
        this.c = p3Var;
        this.d = v2VarArr;
        this.e = i1Var.a;
        int iOrdinal = p3Var.ordinal();
        v2 v2Var = v2VarArr[iOrdinal];
        if (v2Var == null && v2Var == this) {
            return;
        }
        v2VarArr[iOrdinal] = this;
    }

    public final void a(r1 r1Var, Object obj) {
        String strDiscriminator;
        Set setC;
        int iA = w1.a(this.b.a.c);
        if (iA == 0) {
            strDiscriminator = null;
        } else {
            if (iA == 1) {
                p2 p2VarD = r1Var.a().d();
                if (g1.a(p2VarD, e3.a) || g1.a(p2VarD, h3.a)) {
                    Iterator it = r1Var.a().getAnnotations().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            strDiscriminator = "type";
                            break;
                        }
                        Annotation annotation = (Annotation) it.next();
                        if (annotation instanceof k1) {
                            strDiscriminator = ((k1) annotation).discriminator();
                            break;
                        }
                    }
                }
            } else if (iA != 2) {
                throw new y1();
            }
            strDiscriminator = null;
        }
        if (strDiscriminator != null) {
            i1 i1Var = this.b;
            l2 l2VarA = r1Var.a();
            g1.a(l2VarA.d(), e3.a);
            if (l2VarA instanceof h) {
                setC = ((h) l2VarA).c();
            } else {
                HashSet hashSet = new HashSet(l2VarA.e());
                int iE = l2VarA.e();
                for (int i = 0; i < iE; i++) {
                    hashSet.add(l2VarA.a(i));
                }
                setC = hashSet;
            }
            if (setC.contains(strDiscriminator)) {
                String strB = r1Var.a().b();
                String strB2 = r1Var.a().b();
                throw new m1("Class '" + strB2 + "' cannot be serialized " + ((i1Var.a.c == 2 && g1.a(strB, strB2)) ? "in ALL_JSON_OBJECTS class discriminator mode" : "as base class '" + strB + '\'') + " because it has property name that conflicts with JSON class discriminator '" + strDiscriminator + "'.", "You can either change class discriminator in JsonConfiguration, or rename property with @SerialName annotation.");
            }
            p2 p2VarD2 = r1Var.a().d();
            if (p2VarD2 instanceof o2) {
                throw new IllegalStateException("Enums cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead");
            }
            if (p2VarD2 instanceof f2) {
                throw new IllegalStateException("Primitives cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead");
            }
            String strB3 = r1Var.a().b();
            this.f = strDiscriminator;
            this.g = strB3;
        }
        r1Var.a(this, obj);
    }

    public final void a(String str) {
        byte b;
        o1 o1Var = this.a.a;
        o1Var.a(o1Var.b, str.length() + 2);
        char[] cArr = o1Var.a;
        int i = o1Var.b;
        int i2 = i + 1;
        cArr[i] = '\"';
        int length = str.length();
        str.getChars(0, length, cArr, i2);
        int i3 = length + i2;
        int i4 = i2;
        while (i4 < i3) {
            char c = cArr[i4];
            byte[] bArr = w2.b;
            if (c < bArr.length && bArr[c] != 0) {
                int length2 = str.length();
                for (int i5 = i4 - i2; i5 < length2; i5++) {
                    int iA = o1Var.a(i4, 2);
                    char cCharAt = str.charAt(i5);
                    byte[] bArr2 = w2.b;
                    if (cCharAt >= bArr2.length || (b = bArr2[cCharAt]) == 0) {
                        int i6 = iA + 1;
                        o1Var.a[iA] = cCharAt;
                        i4 = i6;
                    } else if (b == 1) {
                        String str2 = w2.a[cCharAt];
                        int iA2 = o1Var.a(iA, str2.length());
                        str2.getChars(0, str2.length(), o1Var.a, iA2);
                        int length3 = str2.length() + iA2;
                        o1Var.b = length3;
                        i4 = length3;
                    } else {
                        char[] cArr2 = o1Var.a;
                        cArr2[iA] = '\\';
                        cArr2[iA + 1] = (char) b;
                        i4 = iA + 2;
                        o1Var.b = i4;
                    }
                }
                int iA3 = o1Var.a(i4, 1);
                o1Var.a[iA3] = '\"';
                o1Var.b = iA3 + 1;
                return;
            }
            i4++;
        }
        cArr[i3] = '\"';
        o1Var.b = i3 + 1;
    }
}
