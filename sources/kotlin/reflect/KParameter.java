package kotlin.reflect;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
public interface KParameter extends KAnnotatedElement {

    public enum Kind {
        INSTANCE,
        EXTENSION_RECEIVER,
        VALUE;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    }

    int getIndex();

    Kind getKind();

    String getName();

    KType getType();

    boolean isOptional();

    boolean isVararg();
}
