package j$.time.chrono;

import j$.time.LocalDate;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class F implements Externalizable {
    private static final long serialVersionUID = -6103370247208168577L;
    public byte a;
    public Object b;

    public F() {
    }

    public F(byte b, Object obj) {
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
                objectOutput.writeUTF(((AbstractC1167a) obj).q());
                return;
            case 2:
                C1173g c1173g = (C1173g) obj;
                objectOutput.writeObject(c1173g.a);
                objectOutput.writeObject(c1173g.b);
                return;
            case 3:
                l lVar = (l) obj;
                objectOutput.writeObject(lVar.a);
                objectOutput.writeObject(lVar.b);
                objectOutput.writeObject(lVar.c);
                return;
            case 4:
                y yVar = (y) obj;
                yVar.getClass();
                objectOutput.writeInt(yVar.e(j$.time.temporal.a.YEAR));
                objectOutput.writeByte(yVar.e(j$.time.temporal.a.MONTH_OF_YEAR));
                objectOutput.writeByte(yVar.e(j$.time.temporal.a.DAY_OF_MONTH));
                return;
            case 5:
                objectOutput.writeByte(((z) obj).a);
                return;
            case 6:
                r rVar = (r) obj;
                objectOutput.writeObject(rVar.a);
                objectOutput.writeInt(rVar.e(j$.time.temporal.a.YEAR));
                objectOutput.writeByte(rVar.e(j$.time.temporal.a.MONTH_OF_YEAR));
                objectOutput.writeByte(rVar.e(j$.time.temporal.a.DAY_OF_MONTH));
                return;
            case 7:
                D d = (D) obj;
                d.getClass();
                objectOutput.writeInt(d.e(j$.time.temporal.a.YEAR));
                objectOutput.writeByte(d.e(j$.time.temporal.a.MONTH_OF_YEAR));
                objectOutput.writeByte(d.e(j$.time.temporal.a.DAY_OF_MONTH));
                return;
            case 8:
                J j = (J) obj;
                j.getClass();
                objectOutput.writeInt(j.e(j$.time.temporal.a.YEAR));
                objectOutput.writeByte(j.e(j$.time.temporal.a.MONTH_OF_YEAR));
                objectOutput.writeByte(j.e(j$.time.temporal.a.DAY_OF_MONTH));
                return;
            case 9:
                C1174h c1174h = (C1174h) obj;
                objectOutput.writeUTF(c1174h.a.q());
                objectOutput.writeInt(c1174h.b);
                objectOutput.writeInt(c1174h.c);
                objectOutput.writeInt(c1174h.d);
                return;
            default:
                throw new InvalidClassException("Unknown serialized type");
        }
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput objectInput) throws IOException {
        Object objOf;
        byte b = objectInput.readByte();
        this.a = b;
        switch (b) {
            case 1:
                ConcurrentHashMap concurrentHashMap = AbstractC1167a.a;
                objOf = m.of(objectInput.readUTF());
                break;
            case 2:
                objOf = ((InterfaceC1168b) objectInput.readObject()).M((j$.time.k) objectInput.readObject());
                break;
            case 3:
                objOf = ((InterfaceC1171e) objectInput.readObject()).F((ZoneOffset) objectInput.readObject()).E((ZoneId) objectInput.readObject());
                break;
            case 4:
                LocalDate localDate = y.d;
                int i = objectInput.readInt();
                byte b2 = objectInput.readByte();
                byte b3 = objectInput.readByte();
                w.c.getClass();
                objOf = new y(LocalDate.e0(i, b2, b3));
                break;
            case 5:
                z zVar = z.d;
                objOf = z.r(objectInput.readByte());
                break;
            case 6:
                p pVar = (p) objectInput.readObject();
                int i2 = objectInput.readInt();
                byte b4 = objectInput.readByte();
                byte b5 = objectInput.readByte();
                pVar.getClass();
                objOf = new r(pVar, i2, b4, b5);
                break;
            case 7:
                int i3 = objectInput.readInt();
                byte b6 = objectInput.readByte();
                byte b7 = objectInput.readByte();
                B.c.getClass();
                objOf = new D(LocalDate.e0(i3 + 1911, b6, b7));
                break;
            case 8:
                int i4 = objectInput.readInt();
                byte b8 = objectInput.readByte();
                byte b9 = objectInput.readByte();
                H.c.getClass();
                objOf = new J(LocalDate.e0(i4 - 543, b8, b9));
                break;
            case 9:
                int i5 = C1174h.e;
                objOf = new C1174h(m.of(objectInput.readUTF()), objectInput.readInt(), objectInput.readInt(), objectInput.readInt());
                break;
            default:
                throw new StreamCorruptedException("Unknown serialized type");
        }
        this.b = objOf;
    }

    private Object readResolve() {
        return this.b;
    }
}
