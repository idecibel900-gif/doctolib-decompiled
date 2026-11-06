package kotlinx.serialization.json.internal;

import com.datadog.trace.api.DD128bTraceId$$ExternalSyntheticBackport1;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class ComposerForUnsignedNumbers extends Composer {
    private final boolean forceQuoting;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposerForUnsignedNumbers(JsonWriter writer, boolean z) {
        super(writer);
        Intrinsics.checkNotNullParameter(writer, "writer");
        this.forceQuoting = z;
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void print(int i) {
        boolean z = this.forceQuoting;
        String string = Long.toString(((long) UInt.m5275constructorimpl(i)) & 4294967295L, 10);
        if (z) {
            printQuoted(string);
        } else {
            print(string);
        }
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void print(long j) {
        boolean z = this.forceQuoting;
        long jM5297constructorimpl = ULong.m5297constructorimpl(j);
        if (z) {
            printQuoted(DD128bTraceId$$ExternalSyntheticBackport1.m(jM5297constructorimpl, 10));
        } else {
            print(DD128bTraceId$$ExternalSyntheticBackport1.m(jM5297constructorimpl, 10));
        }
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void print(byte b) {
        boolean z = this.forceQuoting;
        String strM5256toStringimpl = UByte.m5256toStringimpl(UByte.m5253constructorimpl(b));
        if (z) {
            printQuoted(strM5256toStringimpl);
        } else {
            print(strM5256toStringimpl);
        }
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void print(short s) {
        boolean z = this.forceQuoting;
        String strM5323toStringimpl = UShort.m5323toStringimpl(UShort.m5320constructorimpl(s));
        if (z) {
            printQuoted(strM5323toStringimpl);
        } else {
            print(strM5323toStringimpl);
        }
    }
}
