package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class ComposerForUnquotedLiterals extends Composer {
    private final boolean forceQuoting;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposerForUnquotedLiterals(JsonWriter writer, boolean z) {
        super(writer);
        Intrinsics.checkNotNullParameter(writer, "writer");
        this.forceQuoting = z;
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void printQuoted(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (this.forceQuoting) {
            super.printQuoted(value);
        } else {
            super.print(value);
        }
    }
}
