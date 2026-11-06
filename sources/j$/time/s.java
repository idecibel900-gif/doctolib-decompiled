package j$.time;

import com.opentok.android.BaseVideoCapturer;
import com.revenuecat.purchases.common.verification.SigningManager;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class s implements Externalizable {
    private static final long serialVersionUID = -7683839454370182990L;
    public byte a;
    public Object b;

    public s() {
    }

    public s(byte b, Object obj) {
        this.a = b;
        this.b = obj;
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput objectOutput) throws IOException {
        byte b = this.a;
        Object obj = this.b;
        objectOutput.writeByte(b);
        switch (b) {
            case 1:
                Duration duration = (Duration) obj;
                objectOutput.writeLong(duration.a);
                objectOutput.writeInt(duration.b);
                return;
            case 2:
                Instant instant = (Instant) obj;
                objectOutput.writeLong(instant.a);
                objectOutput.writeInt(instant.b);
                return;
            case 3:
                LocalDate localDate = (LocalDate) obj;
                objectOutput.writeInt(localDate.a);
                objectOutput.writeByte(localDate.b);
                objectOutput.writeByte(localDate.c);
                return;
            case 4:
                ((k) obj).k0(objectOutput);
                return;
            case 5:
                LocalDateTime localDateTime = (LocalDateTime) obj;
                LocalDate localDate2 = localDateTime.a;
                objectOutput.writeInt(localDate2.a);
                objectOutput.writeByte(localDate2.b);
                objectOutput.writeByte(localDate2.c);
                localDateTime.b.k0(objectOutput);
                return;
            case 6:
                ZonedDateTime zonedDateTime = (ZonedDateTime) obj;
                LocalDateTime localDateTime2 = zonedDateTime.a;
                LocalDate localDate3 = localDateTime2.a;
                objectOutput.writeInt(localDate3.a);
                objectOutput.writeByte(localDate3.b);
                objectOutput.writeByte(localDate3.c);
                localDateTime2.b.k0(objectOutput);
                zonedDateTime.b.e0(objectOutput);
                zonedDateTime.c.Q(objectOutput);
                return;
            case 7:
                objectOutput.writeUTF(((x) obj).b);
                return;
            case 8:
                ((ZoneOffset) obj).e0(objectOutput);
                return;
            case 9:
                q qVar = (q) obj;
                qVar.a.k0(objectOutput);
                qVar.b.e0(objectOutput);
                return;
            case 10:
                OffsetDateTime offsetDateTime = (OffsetDateTime) obj;
                LocalDateTime localDateTime3 = offsetDateTime.a;
                LocalDate localDate4 = localDateTime3.a;
                objectOutput.writeInt(localDate4.a);
                objectOutput.writeByte(localDate4.b);
                objectOutput.writeByte(localDate4.c);
                localDateTime3.b.k0(objectOutput);
                offsetDateTime.b.e0(objectOutput);
                return;
            case BaseVideoCapturer.RGBA /* 11 */:
                objectOutput.writeInt(((u) obj).a);
                return;
            case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                w wVar = (w) obj;
                objectOutput.writeInt(wVar.a);
                objectOutput.writeByte(wVar.b);
                return;
            case 13:
                o oVar = (o) obj;
                objectOutput.writeByte(oVar.a);
                objectOutput.writeByte(oVar.b);
                return;
            case 14:
                r rVar = (r) obj;
                objectOutput.writeInt(rVar.a);
                objectOutput.writeInt(rVar.b);
                objectOutput.writeInt(rVar.c);
                return;
            default:
                throw new InvalidClassException("Unknown serialized type");
        }
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput objectInput) {
        byte b = objectInput.readByte();
        this.a = b;
        this.b = a(b, objectInput);
    }

    public static Object a(byte b, ObjectInput objectInput) throws IOException {
        switch (b) {
            case 1:
                Duration duration = Duration.c;
                long j = objectInput.readLong();
                long j2 = objectInput.readInt();
                return Duration.B(Math.addExact(j, Math.floorDiv(j2, 1000000000L)), (int) Math.floorMod(j2, 1000000000L));
            case 2:
                Instant instant = Instant.c;
                return Instant.ofEpochSecond(objectInput.readLong(), objectInput.readInt());
            case 3:
                LocalDate localDate = LocalDate.d;
                return LocalDate.e0(objectInput.readInt(), objectInput.readByte(), objectInput.readByte());
            case 4:
                return k.f0(objectInput);
            case 5:
                LocalDateTime localDateTime = LocalDateTime.c;
                LocalDate localDate2 = LocalDate.d;
                return LocalDateTime.J(LocalDate.e0(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), k.f0(objectInput));
            case 6:
                LocalDateTime localDateTime2 = LocalDateTime.c;
                LocalDate localDate3 = LocalDate.d;
                LocalDateTime localDateTimeJ = LocalDateTime.J(LocalDate.e0(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), k.f0(objectInput));
                ZoneOffset zoneOffsetD0 = ZoneOffset.d0(objectInput);
                ZoneId zoneId = (ZoneId) a(objectInput.readByte(), objectInput);
                Objects.requireNonNull(zoneId, "zone");
                if (!(zoneId instanceof ZoneOffset) || zoneOffsetD0.equals(zoneId)) {
                    return new ZonedDateTime(localDateTimeJ, zoneId, zoneOffsetD0);
                }
                throw new IllegalArgumentException("ZoneId must match ZoneOffset");
            case 7:
                int i = x.d;
                return ZoneId.B(objectInput.readUTF(), false);
            case 8:
                return ZoneOffset.d0(objectInput);
            case 9:
                int i2 = q.c;
                return new q(k.f0(objectInput), ZoneOffset.d0(objectInput));
            case 10:
                int i3 = OffsetDateTime.c;
                LocalDate localDate4 = LocalDate.d;
                return new OffsetDateTime(LocalDateTime.J(LocalDate.e0(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), k.f0(objectInput)), ZoneOffset.d0(objectInput));
            case BaseVideoCapturer.RGBA /* 11 */:
                int i4 = u.b;
                return u.s(objectInput.readInt());
            case SigningManager.NONCE_BYTES_SIZE /* 12 */:
                int i5 = w.c;
                int i6 = objectInput.readInt();
                byte b2 = objectInput.readByte();
                j$.time.temporal.a.YEAR.a0(i6);
                j$.time.temporal.a.MONTH_OF_YEAR.a0(b2);
                return new w(i6, b2);
            case 13:
                int i7 = o.c;
                byte b3 = objectInput.readByte();
                byte b4 = objectInput.readByte();
                m mVarJ = m.J(b3);
                Objects.requireNonNull(mVarJ, "month");
                j$.time.temporal.a.DAY_OF_MONTH.a0(b4);
                if (b4 <= mVarJ.G()) {
                    return new o(mVarJ.getValue(), b4);
                }
                throw new c("Illegal value for DayOfMonth field, value " + ((int) b4) + " is not valid for month " + mVarJ.name());
            case 14:
                r rVar = r.d;
                return r.a(objectInput.readInt(), objectInput.readInt(), objectInput.readInt());
            default:
                throw new StreamCorruptedException("Unknown serialized type");
        }
    }

    private Object readResolve() {
        return this.b;
    }
}
