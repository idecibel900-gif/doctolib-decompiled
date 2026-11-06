package kotlin.reflect.jvm.internal.impl.types.model;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
public enum TypeVariance {
    IN("in"),
    OUT("out"),
    INV("");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String presentation;

    TypeVariance(String str) {
        this.presentation = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.presentation;
    }
}
