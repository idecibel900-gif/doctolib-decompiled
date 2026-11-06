package net.time4j.tz.model;

import io.didomi.ssl.config.app.SyncConfiguration;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import net.time4j.Month;
import net.time4j.PlainTime;
import net.time4j.Weekday;
import net.time4j.base.MathUtils;
import net.time4j.tz.ZonalOffset;
import net.time4j.tz.ZonalTransition;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes5.dex */
final class SPX implements Externalizable {
    private static final long serialVersionUID = 6526945678752534989L;
    private transient Object obj;
    private transient int type;

    private static int toTimeIndexR(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 3600) {
            return 2;
        }
        if (i == 7200) {
            return 3;
        }
        if (i == 10800) {
            return 4;
        }
        if (i == 79200) {
            return 5;
        }
        if (i != 82800) {
            return i != 86400 ? 0 : 7;
        }
        return 6;
    }

    private static int toTimeIndexT(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 60) {
            return 2;
        }
        if (i == 3600) {
            return 3;
        }
        if (i == 7200) {
            return 4;
        }
        if (i == 10800) {
            return 5;
        }
        if (i != 14400) {
            return i != 18000 ? 0 : 7;
        }
        return 6;
    }

    private static int toTimeOfDayR(int i) {
        switch (i) {
            case 1:
                return 0;
            case 2:
                return 3600;
            case 3:
                return 7200;
            case 4:
                return 10800;
            case 5:
                return 79200;
            case 6:
                return 82800;
            case 7:
                return SyncConfiguration.DEFAULT_FREQUENCY;
            default:
                return -1;
        }
    }

    private static int toTimeOfDayT(int i) {
        switch (i) {
            case 1:
                return 0;
            case 2:
                return 60;
            case 3:
                return 3600;
            case 4:
                return 7200;
            case 5:
                return 10800;
            case 6:
                return 14400;
            case 7:
                return 18000;
            default:
                return -1;
        }
    }

    public SPX() {
    }

    SPX(Object obj, int i) {
        this.obj = obj;
        this.type = i;
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(this.type);
        switch (this.type) {
            case 120:
                writeFixedDayPattern(this.obj, objectOutput);
                return;
            case 121:
                writeDayOfWeekInMonthPattern(this.obj, objectOutput);
                return;
            case 122:
                writeLastDayOfWeekPattern(this.obj, objectOutput);
                return;
            case 123:
            case 124:
            default:
                throw new InvalidClassException("Unknown serialized type.");
            case 125:
                writeRuleBasedTransitionModel(this.obj, objectOutput);
                return;
            case WebSocketProtocol.PAYLOAD_SHORT /* 126 */:
                writeArrayTransitionModel(this.obj, objectOutput);
                return;
            case 127:
                writeCompositeTransitionModel(this.obj, objectOutput);
                return;
        }
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        switch (objectInput.readByte()) {
            case 120:
                this.obj = readFixedDayPattern(objectInput);
                return;
            case 121:
                this.obj = readDayOfWeekInMonthPattern(objectInput);
                return;
            case 122:
                this.obj = readLastDayOfWeekPattern(objectInput);
                return;
            case 123:
            case 124:
            default:
                throw new StreamCorruptedException("Unknown serialized type.");
            case 125:
                this.obj = readRuleBasedTransitionModel(objectInput);
                return;
            case WebSocketProtocol.PAYLOAD_SHORT /* 126 */:
                this.obj = readArrayTransitionModel(objectInput);
                return;
            case 127:
                this.obj = readCompositeTransitionModel(objectInput);
                return;
        }
    }

    static void writeTransitions(ZonalTransition[] zonalTransitionArr, int i, DataOutput dataOutput) throws IOException {
        int iMin = Math.min(i, zonalTransitionArr.length);
        dataOutput.writeInt(iMin);
        if (iMin > 0) {
            int previousOffset = zonalTransitionArr[0].getPreviousOffset();
            writeOffset(dataOutput, previousOffset);
            for (int i2 = 0; i2 < iMin; i2++) {
                previousOffset = writeTransition(zonalTransitionArr[i2], previousOffset, dataOutput);
            }
        }
    }

    private static List readTransitions(ObjectInput objectInput) throws IOException {
        long j;
        int offset;
        int i = objectInput.readInt();
        if (i == 0) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList(i);
        int offset2 = readOffset(objectInput);
        long j2 = Long.MIN_VALUE;
        int i2 = offset2;
        int i3 = 0;
        while (i3 < i) {
            byte b = objectInput.readByte();
            boolean z = b < 0;
            int i4 = (b >>> 5) & 3;
            int timeOfDayT = toTimeOfDayT((b >>> 2) & 7);
            if (timeOfDayT == -1) {
                j = objectInput.readLong();
            } else {
                j = ((((((long) ((((b & 3) << 16) | ((objectInput.readByte() & 255) << 8)) | (objectInput.readByte() & 255))) * 86400) - 4575744000L) + ((long) timeOfDayT)) - 7200) - ((long) offset2);
            }
            long j3 = j;
            if (j3 <= j2) {
                throw new StreamCorruptedException("Wrong order of transitions.");
            }
            if (i4 == 1) {
                offset = 0;
            } else if (i4 != 2) {
                offset = i4 != 3 ? readOffset(objectInput) : 7200;
            } else {
                offset = 3600;
            }
            if (z) {
                offset2 = readOffset(objectInput);
            }
            int i5 = offset2 + (offset == Integer.MAX_VALUE ? 0 : offset);
            arrayList.add(new ZonalTransition(j3, i2, i5, offset));
            i3++;
            j2 = j3;
            i2 = i5;
        }
        return arrayList;
    }

    private static void writeRules(List list, ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            DaylightSavingRule daylightSavingRule = (DaylightSavingRule) it.next();
            objectOutput.writeByte(daylightSavingRule.getType());
            switch (daylightSavingRule.getType()) {
                case 120:
                    writeFixedDayPattern(daylightSavingRule, objectOutput);
                    break;
                case 121:
                    writeDayOfWeekInMonthPattern(daylightSavingRule, objectOutput);
                    break;
                case 122:
                    writeLastDayOfWeekPattern(daylightSavingRule, objectOutput);
                    break;
                default:
                    objectOutput.writeObject(daylightSavingRule);
                    break;
            }
        }
    }

    private static List readRules(ObjectInput objectInput) throws IOException {
        DaylightSavingRule fixedDayPattern;
        byte b = objectInput.readByte();
        if (b == 0) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList(b);
        DaylightSavingRule daylightSavingRule = null;
        int i = 0;
        while (i < b) {
            switch (objectInput.readByte()) {
                case 120:
                    fixedDayPattern = readFixedDayPattern(objectInput);
                    break;
                case 121:
                    fixedDayPattern = readDayOfWeekInMonthPattern(objectInput);
                    break;
                case 122:
                    fixedDayPattern = readLastDayOfWeekPattern(objectInput);
                    break;
                default:
                    fixedDayPattern = (DaylightSavingRule) objectInput.readObject();
                    break;
            }
            if (daylightSavingRule != null && RuleComparator.INSTANCE.compare(daylightSavingRule, fixedDayPattern) >= 0) {
                throw new InvalidObjectException("Order of daylight saving rules is not ascending.");
            }
            arrayList.add(fixedDayPattern);
            i++;
            daylightSavingRule = fixedDayPattern;
        }
        return arrayList;
    }

    private static void writeOffset(DataOutput dataOutput, int i) throws IOException {
        if (i % 900 == 0) {
            dataOutput.writeByte(i / 900);
        } else {
            dataOutput.writeByte(127);
            dataOutput.writeInt(i);
        }
    }

    private static int readOffset(DataInput dataInput) throws IOException {
        byte b = dataInput.readByte();
        return b == 127 ? dataInput.readInt() : b * 900;
    }

    private static int readSavings(int i) {
        int i2 = i / 3;
        if (i2 == 0) {
            return 0;
        }
        if (i2 == 1) {
            return 1800;
        }
        if (i2 != 2) {
            return i2 != 3 ? -1 : 7200;
        }
        return 3600;
    }

    private static int toTimeOfDay(GregorianTimezoneRule gregorianTimezoneRule) {
        return gregorianTimezoneRule.getTimeOfDay().getInt(PlainTime.SECOND_OF_DAY) + MathUtils.safeCast(gregorianTimezoneRule.getDayOverflow() * 86400);
    }

    private static void writeFixedDayPattern(Object obj, DataOutput dataOutput) throws IOException {
        FixedDayPattern fixedDayPattern = (FixedDayPattern) obj;
        boolean zWriteMonthIndicatorOffset = writeMonthIndicatorOffset(fixedDayPattern, dataOutput);
        int dayOfMonth = fixedDayPattern.getDayOfMonth() << 3;
        int timeOfDay = toTimeOfDay(fixedDayPattern);
        int timeIndexR = toTimeIndexR(timeOfDay);
        dataOutput.writeByte((dayOfMonth | timeIndexR) & 255);
        if (!zWriteMonthIndicatorOffset) {
            writeOffset(dataOutput, fixedDayPattern.getSavings());
        }
        if (timeIndexR == 0) {
            dataOutput.writeInt(timeOfDay);
        }
    }

    private static DaylightSavingRule readFixedDayPattern(DataInput dataInput) throws IOException {
        byte b = dataInput.readByte();
        int i = (b & 255) >>> 4;
        int i2 = b & 15;
        OffsetIndicator offsetIndicator = OffsetIndicator.VALUES[i2 % 3];
        int savings = readSavings(i2);
        byte b2 = dataInput.readByte();
        int i3 = (b2 & 255) >>> 3;
        int timeOfDayR = toTimeOfDayR(b2 & 7);
        if (savings == -1) {
            savings = readOffset(dataInput);
        }
        int i4 = savings;
        if (timeOfDayR == -1) {
            timeOfDayR = dataInput.readInt();
        }
        return new FixedDayPattern(Month.valueOf(i), i3, timeOfDayR, offsetIndicator, i4);
    }

    private static void writeDayOfWeekInMonthPattern(Object obj, DataOutput dataOutput) throws IOException {
        int i;
        DayOfWeekInMonthPattern dayOfWeekInMonthPattern = (DayOfWeekInMonthPattern) obj;
        boolean zWriteMonthIndicatorOffset = writeMonthIndicatorOffset(dayOfWeekInMonthPattern, dataOutput);
        dataOutput.writeByte(((dayOfWeekInMonthPattern.getDayOfMonth() << 3) | dayOfWeekInMonthPattern.getDayOfWeek()) & 255);
        boolean z = false;
        int i2 = dayOfWeekInMonthPattern.isAfter() ? 128 : 0;
        int timeOfDay = toTimeOfDay(dayOfWeekInMonthPattern);
        if (timeOfDay % 1800 == 0) {
            i = i2 | (timeOfDay / 1800);
            z = true;
        } else {
            i = i2 | 63;
        }
        dataOutput.writeByte(i & 255);
        if (!zWriteMonthIndicatorOffset) {
            writeOffset(dataOutput, dayOfWeekInMonthPattern.getSavings());
        }
        if (z) {
            return;
        }
        dataOutput.writeInt(timeOfDay);
    }

    private static DaylightSavingRule readDayOfWeekInMonthPattern(DataInput dataInput) throws IOException {
        byte b = dataInput.readByte();
        Month monthValueOf = Month.valueOf((b & 255) >>> 4);
        int i = b & 15;
        OffsetIndicator offsetIndicator = OffsetIndicator.VALUES[i % 3];
        int savings = readSavings(i);
        byte b2 = dataInput.readByte();
        int i2 = (b2 & 255) >>> 3;
        Weekday weekdayValueOf = Weekday.valueOf(b2 & 7);
        byte b3 = dataInput.readByte();
        boolean z = ((b3 & 255) >>> 7) == 1;
        int i3 = b3 & 63;
        if (savings == -1) {
            savings = readOffset(dataInput);
        }
        return new DayOfWeekInMonthPattern(monthValueOf, i2, weekdayValueOf, i3 == 63 ? dataInput.readInt() : i3 * 1800, offsetIndicator, savings, z);
    }

    private static void writeLastDayOfWeekPattern(Object obj, DataOutput dataOutput) throws IOException {
        int i;
        boolean z;
        LastWeekdayPattern lastWeekdayPattern = (LastWeekdayPattern) obj;
        boolean zWriteMonthIndicatorOffset = writeMonthIndicatorOffset(lastWeekdayPattern, dataOutput);
        int dayOfWeek = lastWeekdayPattern.getDayOfWeek() << 5;
        int timeOfDay = toTimeOfDay(lastWeekdayPattern);
        if (timeOfDay % 3600 == 0) {
            i = dayOfWeek | (timeOfDay / 3600);
            z = true;
        } else {
            i = dayOfWeek | 31;
            z = false;
        }
        dataOutput.writeByte(i & 255);
        if (!zWriteMonthIndicatorOffset) {
            writeOffset(dataOutput, lastWeekdayPattern.getSavings());
        }
        if (z) {
            return;
        }
        dataOutput.writeInt(timeOfDay);
    }

    private static DaylightSavingRule readLastDayOfWeekPattern(DataInput dataInput) throws IOException {
        byte b = dataInput.readByte();
        Month monthValueOf = Month.valueOf((b & 255) >>> 4);
        int i = b & 15;
        OffsetIndicator offsetIndicator = OffsetIndicator.VALUES[i % 3];
        int savings = readSavings(i);
        byte b2 = dataInput.readByte();
        Weekday weekdayValueOf = Weekday.valueOf((b2 & 255) >>> 5);
        int i2 = b2 & 31;
        if (savings == -1) {
            savings = readOffset(dataInput);
        }
        return new LastWeekdayPattern(monthValueOf, weekdayValueOf, i2 == 31 ? dataInput.readInt() : i2 * 3600, offsetIndicator, savings);
    }

    private static void writeRuleBasedTransitionModel(Object obj, ObjectOutput objectOutput) throws IOException {
        RuleBasedTransitionModel ruleBasedTransitionModel = (RuleBasedTransitionModel) obj;
        ZonalTransition initialTransition = ruleBasedTransitionModel.getInitialTransition();
        long posixTime = initialTransition.getPosixTime();
        if (posixTime >= -4575744000L && posixTime < 10464767099L && posixTime % 900 == 0) {
            int i = (int) ((posixTime - (-4575744000L)) / 900);
            objectOutput.writeByte((i >>> 16) & 255);
            objectOutput.writeByte((i >>> 8) & 255);
            objectOutput.writeByte(i & 255);
        } else {
            objectOutput.writeByte(255);
            objectOutput.writeLong(initialTransition.getPosixTime());
        }
        writeOffset(objectOutput, initialTransition.getPreviousOffset());
        writeOffset(objectOutput, initialTransition.getTotalOffset());
        writeOffset(objectOutput, initialTransition.getDaylightSavingOffset());
        writeRules(ruleBasedTransitionModel.getRules(), objectOutput);
    }

    private static Object readRuleBasedTransitionModel(ObjectInput objectInput) throws IOException {
        long j;
        int i = objectInput.readByte() & 255;
        if (i == 255) {
            j = objectInput.readLong();
        } else {
            j = (((long) (((i << 16) + ((objectInput.readByte() & 255) << 8)) + (255 & objectInput.readByte()))) * 900) - 4575744000L;
        }
        return new RuleBasedTransitionModel(new ZonalTransition(j, readOffset(objectInput), readOffset(objectInput), readOffset(objectInput)), readRules(objectInput), false);
    }

    private static void writeArrayTransitionModel(Object obj, ObjectOutput objectOutput) {
        ((ArrayTransitionModel) obj).writeTransitions(objectOutput);
    }

    private static Object readArrayTransitionModel(ObjectInput objectInput) {
        return new ArrayTransitionModel(readTransitions(objectInput), false, false);
    }

    private static void writeCompositeTransitionModel(Object obj, ObjectOutput objectOutput) throws IOException {
        CompositeTransitionModel compositeTransitionModel = (CompositeTransitionModel) obj;
        compositeTransitionModel.writeTransitions(objectOutput);
        writeRules(compositeTransitionModel.getRules(), objectOutput);
    }

    private static Object readCompositeTransitionModel(ObjectInput objectInput) throws IOException {
        List transitions = readTransitions(objectInput);
        return TransitionModel.of(ZonalOffset.ofTotalSeconds(((ZonalTransition) transitions.get(0)).getPreviousOffset()), transitions, readRules(objectInput), false, false);
    }

    private static int writeTransition(ZonalTransition zonalTransition, int i, DataOutput dataOutput) throws IOException {
        int standardOffset = zonalTransition.getStandardOffset();
        int i2 = 1;
        int timeIndexT = 0;
        boolean z = standardOffset != i;
        byte b = z ? (byte) 128 : (byte) 0;
        int daylightSavingOffset = zonalTransition.getDaylightSavingOffset();
        if (daylightSavingOffset != 0) {
            if (daylightSavingOffset != 3600) {
                i2 = daylightSavingOffset != 7200 ? 0 : 3;
            } else {
                i2 = 2;
            }
        }
        byte b2 = (byte) (b | (i2 << 5));
        long posixTime = zonalTransition.getPosixTime() + ((long) i);
        long j = 7200 + posixTime;
        if (j >= -4575744000L && j < 18067104000L) {
            timeIndexT = toTimeIndexT(MathUtils.floorModulo(j, SyncConfiguration.DEFAULT_FREQUENCY));
        }
        byte b3 = (byte) ((timeIndexT << 2) | b2);
        if (timeIndexT == 0) {
            dataOutput.writeByte(b3);
            dataOutput.writeLong(zonalTransition.getPosixTime());
        } else {
            int i3 = (int) ((posixTime + 4575751200L) / 86400);
            dataOutput.writeByte((byte) (b3 | ((byte) ((i3 >>> 16) & 3))));
            dataOutput.writeByte((i3 >>> 8) & 255);
            dataOutput.writeByte(i3 & 255);
        }
        if (i2 == 0) {
            writeOffset(dataOutput, daylightSavingOffset);
        }
        if (z) {
            writeOffset(dataOutput, standardOffset);
        }
        return standardOffset;
    }

    private static boolean writeMonthIndicatorOffset(GregorianTimezoneRule gregorianTimezoneRule, DataOutput dataOutput) throws IOException {
        int i;
        int monthValue = gregorianTimezoneRule.getMonthValue() << 4;
        int iOrdinal = gregorianTimezoneRule.getIndicator().ordinal();
        int savings = gregorianTimezoneRule.getSavings();
        boolean z = true;
        if (savings == 0) {
            i = monthValue | iOrdinal;
        } else {
            if (savings == 1800) {
                iOrdinal += 3;
            } else if (savings == 3600) {
                iOrdinal += 6;
            } else if (savings != 7200) {
                i = monthValue | (iOrdinal + 12);
                z = false;
            } else {
                iOrdinal += 9;
            }
            i = monthValue | iOrdinal;
        }
        dataOutput.writeByte(i & 255);
        return z;
    }

    private Object readResolve() throws ObjectStreamException {
        return this.obj;
    }
}
