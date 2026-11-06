package com.facebook.common.internal;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Suppliers {
    public static final Supplier BOOLEAN_TRUE = new Supplier() { // from class: com.facebook.common.internal.Suppliers.2
        @Override // com.facebook.common.internal.Supplier
        public Boolean get() {
            return Boolean.TRUE;
        }
    };
    public static final Supplier BOOLEAN_FALSE = new Supplier() { // from class: com.facebook.common.internal.Suppliers.3
        @Override // com.facebook.common.internal.Supplier
        public Boolean get() {
            return Boolean.FALSE;
        }
    };
    public static final Supplier STRING_EMPTY = new Supplier() { // from class: com.facebook.common.internal.Suppliers.4
        @Override // com.facebook.common.internal.Supplier
        public String get() {
            return "";
        }
    };

    public static Supplier of(final Object obj) {
        return new Supplier() { // from class: com.facebook.common.internal.Suppliers.1
            @Override // com.facebook.common.internal.Supplier
            public Object get() {
                return obj;
            }
        };
    }
}
