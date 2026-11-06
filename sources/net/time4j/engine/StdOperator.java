package net.time4j.engine;

/* JADX INFO: loaded from: classes5.dex */
public final class StdOperator implements ChronoOperator {
    private final ChronoElement element;
    private final int mode;
    private final Object value;

    private StdOperator(int i, ChronoElement chronoElement) {
        this(i, chronoElement, null);
    }

    private StdOperator(int i, ChronoElement chronoElement, Object obj) {
        if (chronoElement == null) {
            throw new NullPointerException("Missing chronological element.");
        }
        this.mode = i;
        this.element = chronoElement;
        this.value = obj;
    }

    @Override // net.time4j.engine.ChronoOperator
    public ChronoEntity apply(ChronoEntity chronoEntity) {
        switch (this.mode) {
            case 0:
                return value(chronoEntity, this.element, this.value, false);
            case 1:
                return min(chronoEntity, this.element);
            case 2:
                return max(chronoEntity, this.element);
            case 3:
                return floor(chronoEntity, this.element);
            case 4:
                return ceiling(chronoEntity, this.element);
            case 5:
                return value(chronoEntity, this.element, this.value, true);
            case 6:
                return move(chronoEntity, false);
            case 7:
                return move(chronoEntity, true);
            default:
                throw new UnsupportedOperationException("Unknown mode: " + this.mode);
        }
    }

    public static ChronoOperator minimized(ChronoElement chronoElement) {
        return new StdOperator(1, chronoElement);
    }

    public static ChronoOperator maximized(ChronoElement chronoElement) {
        return new StdOperator(2, chronoElement);
    }

    public static ChronoOperator decremented(ChronoElement chronoElement) {
        return new StdOperator(6, chronoElement);
    }

    public static ChronoOperator incremented(ChronoElement chronoElement) {
        return new StdOperator(7, chronoElement);
    }

    public static ChronoOperator atFloor(ChronoElement chronoElement) {
        return new StdOperator(3, chronoElement);
    }

    public static ChronoOperator atCeiling(ChronoElement chronoElement) {
        return new StdOperator(4, chronoElement);
    }

    public static ChronoOperator setLenient(Object obj, ChronoElement chronoElement) {
        return new StdOperator(5, chronoElement, obj);
    }

    public static ChronoOperator newValue(Object obj, ChronoElement chronoElement) {
        return new StdOperator(0, chronoElement, obj);
    }

    private ChronoEntity min(ChronoEntity chronoEntity, ChronoElement chronoElement) {
        return chronoEntity.with(chronoElement, chronoEntity.getMinimum(chronoElement));
    }

    private ChronoEntity max(ChronoEntity chronoEntity, ChronoElement chronoElement) {
        return chronoEntity.with(chronoElement, chronoEntity.getMaximum(chronoElement));
    }

    private ChronoEntity floor(ChronoEntity chronoEntity, ChronoElement chronoElement) {
        ChronoEntity context = chronoEntity.getContext();
        while (true) {
            chronoElement = context.getChronology().getRule(chronoElement).getChildAtFloor(context);
            if (chronoElement == null) {
                return context;
            }
            context = withFloor(context, chronoElement);
        }
    }

    private ChronoEntity ceiling(ChronoEntity chronoEntity, ChronoElement chronoElement) {
        ChronoEntity context = chronoEntity.getContext();
        while (true) {
            chronoElement = context.getChronology().getRule(chronoElement).getChildAtCeiling(context);
            if (chronoElement == null) {
                return context;
            }
            context = withCeiling(context, chronoElement);
        }
    }

    private ChronoEntity value(ChronoEntity chronoEntity, ChronoElement chronoElement, Object obj, boolean z) {
        ChronoEntity context = chronoEntity.getContext();
        return (ChronoEntity) context.getChronology().getRule(chronoElement).withValue(context, chronoElement.getType().cast(obj), z);
    }

    private ChronoEntity withFloor(ChronoEntity chronoEntity, ChronoElement chronoElement) {
        ElementRule rule = chronoEntity.getChronology().getRule(chronoElement);
        return (ChronoEntity) rule.withValue(chronoEntity, rule.getMinimum(chronoEntity), chronoElement.isLenient());
    }

    private ChronoEntity withCeiling(ChronoEntity chronoEntity, ChronoElement chronoElement) {
        ElementRule rule = chronoEntity.getChronology().getRule(chronoElement);
        return (ChronoEntity) rule.withValue(chronoEntity, rule.getMaximum(chronoEntity), chronoElement.isLenient());
    }

    private ChronoEntity move(ChronoEntity chronoEntity, boolean z) {
        if (chronoEntity instanceof TimePoint) {
            return (ChronoEntity) chronoEntity.getChronology().getChronoType().cast(add((TimePoint) TimePoint.class.cast(chronoEntity), this.element, z));
        }
        throw new ChronoException("Base units not supported by: " + chronoEntity.getChronology().getChronoType());
    }

    private static TimePoint add(TimePoint timePoint, ChronoElement chronoElement, boolean z) {
        Object baseUnit = timePoint.getChronology().getBaseUnit(chronoElement);
        if (z) {
            return timePoint.plus(1L, baseUnit);
        }
        return timePoint.minus(1L, baseUnit);
    }
}
