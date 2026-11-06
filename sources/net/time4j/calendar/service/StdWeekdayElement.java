package net.time4j.calendar.service;

import net.time4j.Weekday;
import net.time4j.Weekmodel;
import net.time4j.engine.ChronoDisplay;

/* JADX INFO: loaded from: classes5.dex */
public class StdWeekdayElement extends StdEnumDateElement {
    private static final long serialVersionUID = -84764920511581480L;
    private final transient Weekmodel model;

    public StdWeekdayElement(Class cls, Weekmodel weekmodel) {
        super("DAY_OF_WEEK", cls, Weekday.class, 'E');
        this.model = weekmodel;
    }

    @Override // net.time4j.engine.ChronoElement
    public Weekday getDefaultMinimum() {
        return this.model.getFirstDayOfWeek();
    }

    @Override // net.time4j.engine.ChronoElement
    public Weekday getDefaultMaximum() {
        return this.model.getFirstDayOfWeek().roll(6);
    }

    @Override // net.time4j.calendar.service.StdEnumDateElement
    public int numerical(Weekday weekday) {
        return weekday.getValue(this.model);
    }

    @Override // net.time4j.engine.BasicElement, java.util.Comparator
    public int compare(ChronoDisplay chronoDisplay, ChronoDisplay chronoDisplay2) {
        int value = ((Weekday) chronoDisplay.get(this)).getValue(this.model);
        int value2 = ((Weekday) chronoDisplay2.get(this)).getValue(this.model);
        if (value < value2) {
            return -1;
        }
        return value == value2 ? 0 : 1;
    }
}
