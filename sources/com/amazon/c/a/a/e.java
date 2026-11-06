package com.amazon.c.a.a;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/* JADX INFO: loaded from: classes3.dex */
public class e {
    private static final String a = String.format("A valid instance of %s is required to have at least one non-blank ID, either developerId or certificateId, and at least one non-blank name, either developerName or commonName.", e.class.getSimpleName());
    private static final String b = String.format("A valid instance of %s is required to have a certificate ID.", e.class.getSimpleName());
    private String c;
    private String d;
    private String e;
    private String f;

    public static String a() {
        return a;
    }

    public static String b() {
        return b;
    }

    public boolean c() {
        return (StringUtils.isBlank(e()) || StringUtils.isBlank(f())) ? false : true;
    }

    public boolean d() {
        return !StringUtils.isBlank(e());
    }

    public String e() {
        if (StringUtils.isBlank(this.e)) {
            return this.c;
        }
        return this.e;
    }

    public String f() {
        if (StringUtils.isBlank(this.f)) {
            return this.d;
        }
        return this.f;
    }

    public String g() {
        return this.c;
    }

    public e a(String str) {
        this.c = str;
        return this;
    }

    public void b(String str) {
        this.c = str;
    }

    public String h() {
        return this.d;
    }

    public e c(String str) {
        this.d = str;
        return this;
    }

    public void d(String str) {
        this.d = str;
    }

    public String i() {
        return this.e;
    }

    public e e(String str) {
        this.e = str;
        return this;
    }

    public void f(String str) {
        this.e = str;
    }

    public String j() {
        return this.f;
    }

    public e g(String str) {
        this.f = str;
        return this;
    }

    public void h(String str) {
        this.f = str;
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return new EqualsBuilder().append(this.e, eVar.e).append(this.f, eVar.f).append(this.c, eVar.c).append(this.d, eVar.d).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder().append(this.e).append(this.f).append(this.c).append(this.d).toHashCode();
    }
}
