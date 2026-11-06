package com.henninghall.date_picker;

import com.facebook.react.bridge.Dynamic;
import com.henninghall.date_picker.models.Is24HourSource;
import com.henninghall.date_picker.models.Mode;
import com.henninghall.date_picker.props.DateProp;
import com.henninghall.date_picker.props.DividerColorProp;
import com.henninghall.date_picker.props.HeightProp;
import com.henninghall.date_picker.props.IdProp;
import com.henninghall.date_picker.props.Is24hourSourceProp;
import com.henninghall.date_picker.props.LocaleProp;
import com.henninghall.date_picker.props.MaximumDateProp;
import com.henninghall.date_picker.props.MinimumDateProp;
import com.henninghall.date_picker.props.MinuteIntervalProp;
import com.henninghall.date_picker.props.ModeProp;
import com.henninghall.date_picker.props.Prop;
import com.henninghall.date_picker.props.TextColorProp;
import com.henninghall.date_picker.props.TimezoneOffsetInMinutesProp;
import com.revenuecat.purchases.common.Constants;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import j$.util.DesugarTimeZone;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes4.dex */
public class State {
    private Calendar lastSelectedDate = null;
    private final DateProp dateProp = new DateProp();
    private final ModeProp modeProp = new ModeProp();
    private final LocaleProp localeProp = new LocaleProp();
    private final TextColorProp textColorProp = new TextColorProp();
    private final MinuteIntervalProp minuteIntervalProp = new MinuteIntervalProp();
    private final MinimumDateProp minimumDateProp = new MinimumDateProp();
    private final MaximumDateProp maximumDateProp = new MaximumDateProp();
    private final TimezoneOffsetInMinutesProp timezoneOffsetInMinutesProp = new TimezoneOffsetInMinutesProp();
    private final HeightProp heightProp = new HeightProp();
    private final Is24hourSourceProp is24hourSourceProp = new Is24hourSourceProp();
    private final IdProp idProp = new IdProp();
    private final DividerColorProp dividerColorProp = new DividerColorProp();
    private final HashMap props = new HashMap() { // from class: com.henninghall.date_picker.State.1
        {
            put("date", State.this.dateProp);
            put("mode", State.this.modeProp);
            put("locale", State.this.localeProp);
            put("textColor", State.this.textColorProp);
            put("minuteInterval", State.this.minuteIntervalProp);
            put("minimumDate", State.this.minimumDateProp);
            put("maximumDate", State.this.maximumDateProp);
            put("timezoneOffsetInMinutes", State.this.timezoneOffsetInMinutesProp);
            put("height", State.this.heightProp);
            put("is24hourSource", State.this.is24hourSourceProp);
            put(DiagnosticsEntry.ID_KEY, State.this.idProp);
            put("dividerColor", State.this.dividerColorProp);
        }
    };
    public DerivedData derived = new DerivedData(this);

    private Prop getProp(String str) {
        return (Prop) this.props.get(str);
    }

    void setProp(String str, Dynamic dynamic) {
        getProp(str).setValue(dynamic);
    }

    public Mode getMode() {
        return (Mode) this.modeProp.getValue();
    }

    public String getTextColor() {
        return (String) this.textColorProp.getValue();
    }

    public int getMinuteInterval() {
        return ((Integer) this.minuteIntervalProp.getValue()).intValue();
    }

    public Locale getLocale() {
        return (Locale) this.localeProp.getValue();
    }

    public Calendar getMinimumDate() {
        return boundaryPropToCal(this.minimumDateProp);
    }

    public Calendar getMaximumDate() {
        return boundaryPropToCal(this.maximumDateProp);
    }

    private Calendar boundaryPropToCal(Prop prop) {
        Calendar calendarIsoToCalendar = Utils.isoToCalendar((String) prop.getValue(), getTimeZone());
        clearSecondsAndMilliseconds(calendarIsoToCalendar);
        return calendarIsoToCalendar;
    }

    private void clearSecondsAndMilliseconds(Calendar calendar) {
        if (calendar == null) {
            return;
        }
        calendar.set(13, 0);
        calendar.set(14, 0);
    }

    public TimeZone getTimeZone() {
        try {
            String str = (String) this.timezoneOffsetInMinutesProp.getValue();
            if (str != null && !str.equals("")) {
                int i = Integer.parseInt(str);
                int iAbs = Math.abs(i);
                char c = i < 0 ? '-' : '+';
                int iFloor = (int) Math.floor(iAbs / 60.0f);
                return DesugarTimeZone.getTimeZone("GMT" + c + iFloor + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + Utils.toPaddedMinutes(iAbs - (iFloor * 60)));
            }
            return TimeZone.getDefault();
        } catch (Exception e) {
            e.printStackTrace();
            return TimeZone.getDefault();
        }
    }

    public String getIsoDate() {
        return (String) this.dateProp.getValue();
    }

    private Calendar getDate() {
        return Utils.isoToCalendar(getIsoDate(), getTimeZone());
    }

    public Calendar getPickerDate() {
        Calendar date = getDate();
        int minuteInterval = getMinuteInterval();
        if (minuteInterval <= 1) {
            return date;
        }
        date.add(12, -(Integer.parseInt(new SimpleDateFormat("mm", getLocale()).format(date.getTime())) % minuteInterval));
        return (Calendar) date.clone();
    }

    public String getLocaleLanguageTag() {
        return this.localeProp.getLanguageTag();
    }

    public String getId() {
        return (String) this.idProp.getValue();
    }

    public Is24HourSource getIs24HourSource() {
        return (Is24HourSource) this.is24hourSourceProp.getValue();
    }

    public Calendar getLastSelectedDate() {
        return this.lastSelectedDate;
    }

    public void setLastSelectedDate(Calendar calendar) {
        this.lastSelectedDate = calendar;
    }

    public String getDividerColor() {
        return (String) this.dividerColorProp.getValue();
    }
}
