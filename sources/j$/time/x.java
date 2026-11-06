package j$.time;

import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class x extends ZoneId {
    public static final /* synthetic */ int d = 0;
    private static final long serialVersionUID = 8386373296231747096L;
    public final String b;
    public final transient j$.time.zone.f c;

    public static x X(String str, boolean z) {
        j$.time.zone.f fVarA;
        Objects.requireNonNull(str, "zoneId");
        int length = str.length();
        if (length >= 2) {
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if ((cCharAt < 'a' || cCharAt > 'z') && ((cCharAt < 'A' || cCharAt > 'Z') && ((cCharAt != '/' || i == 0) && ((cCharAt < '0' || cCharAt > '9' || i == 0) && ((cCharAt != '~' || i == 0) && ((cCharAt != '.' || i == 0) && ((cCharAt != '_' || i == 0) && ((cCharAt != '+' || i == 0) && (cCharAt != '-' || i == 0))))))))) {
                    throw new c("Invalid ID for region-based ZoneId, invalid format: ".concat(str));
                }
            }
            try {
                fVarA = j$.time.zone.i.a(str);
            } catch (j$.time.zone.g e) {
                if (z) {
                    throw e;
                }
                fVarA = null;
            }
            return new x(str, fVarA);
        }
        throw new c("Invalid ID for region-based ZoneId, invalid format: ".concat(str));
    }

    public x(String str, j$.time.zone.f fVar) {
        this.b = str;
        this.c = fVar;
    }

    @Override // j$.time.ZoneId
    public final String q() {
        return this.b;
    }

    @Override // j$.time.ZoneId
    public final j$.time.zone.f s() {
        j$.time.zone.f fVar = this.c;
        return fVar != null ? fVar : j$.time.zone.i.a(this.b);
    }

    private Object writeReplace() {
        return new s((byte) 7, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // j$.time.ZoneId
    public final void Q(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(7);
        dataOutput.writeUTF(this.b);
    }
}
