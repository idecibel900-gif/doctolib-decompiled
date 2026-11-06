package net.time4j.format;

import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import net.time4j.engine.AttributeKey;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.Chronology;
import net.time4j.engine.StartOfDay;
import net.time4j.scale.TimeScale;
import net.time4j.tz.TZID;
import net.time4j.tz.TransitionStrategy;

/* JADX INFO: loaded from: classes5.dex */
public final class Attributes implements AttributeQuery {
    private final Map attributes;
    public static final AttributeKey CALENDAR_TYPE = PredefinedKey.valueOf("CALENDAR_TYPE", String.class);
    public static final AttributeKey LANGUAGE = PredefinedKey.valueOf("LANGUAGE", Locale.class);
    public static final AttributeKey TIMEZONE_ID = PredefinedKey.valueOf("TIMEZONE_ID", TZID.class);
    public static final AttributeKey TRANSITION_STRATEGY = PredefinedKey.valueOf("TRANSITION_STRATEGY", TransitionStrategy.class);
    public static final AttributeKey LENIENCY = PredefinedKey.valueOf("LENIENCY", Leniency.class);
    public static final AttributeKey TEXT_WIDTH = PredefinedKey.valueOf("TEXT_WIDTH", TextWidth.class);
    public static final AttributeKey OUTPUT_CONTEXT = PredefinedKey.valueOf("OUTPUT_CONTEXT", OutputContext.class);
    public static final AttributeKey PARSE_CASE_INSENSITIVE = PredefinedKey.valueOf("PARSE_CASE_INSENSITIVE", Boolean.class);
    public static final AttributeKey PARSE_PARTIAL_COMPARE = PredefinedKey.valueOf("PARSE_PARTIAL_COMPARE", Boolean.class);
    public static final AttributeKey PARSE_MULTIPLE_CONTEXT = PredefinedKey.valueOf("PARSE_MULTIPLE_CONTEXT", Boolean.class);
    public static final AttributeKey NUMBER_SYSTEM = PredefinedKey.valueOf("NUMBER_SYSTEM", NumberSystem.class);
    public static final AttributeKey ZERO_DIGIT = PredefinedKey.valueOf("ZERO_DIGIT", Character.class);
    public static final AttributeKey NO_GMT_PREFIX = PredefinedKey.valueOf("NO_GMT_PREFIX", Boolean.class);
    public static final AttributeKey DECIMAL_SEPARATOR = PredefinedKey.valueOf("DECIMAL_SEPARATOR", Character.class);
    public static final AttributeKey PAD_CHAR = PredefinedKey.valueOf("PAD_CHAR", Character.class);
    public static final AttributeKey PIVOT_YEAR = PredefinedKey.valueOf("PIVOT_YEAR", Integer.class);
    public static final AttributeKey TRAILING_CHARACTERS = PredefinedKey.valueOf("TRAILING_CHARACTERS", Boolean.class);
    public static final AttributeKey PROTECTED_CHARACTERS = PredefinedKey.valueOf("PROTECTED_CHARACTERS", Integer.class);
    public static final AttributeKey CALENDAR_VARIANT = PredefinedKey.valueOf("CALENDAR_VARIANT", String.class);
    public static final AttributeKey START_OF_DAY = PredefinedKey.valueOf("START_OF_DAY", StartOfDay.class);
    public static final AttributeKey FOUR_DIGIT_YEAR = PredefinedKey.valueOf("FOUR_DIGIT_YEAR", Boolean.class);
    public static final AttributeKey TIME_SCALE = PredefinedKey.valueOf("TIME_SCALE", TimeScale.class);
    public static final AttributeKey FORMAT_PATTERN = PredefinedKey.valueOf("FORMAT_PATTERN", String.class);
    private static final Attributes EMPTY = new Attributes();

    /* synthetic */ Attributes(Map map, AnonymousClass1 anonymousClass1) {
        this(map);
    }

    private Attributes() {
        this.attributes = Collections.EMPTY_MAP;
    }

    private Attributes(Map map) {
        this.attributes = Collections.unmodifiableMap(new HashMap(map));
    }

    public static Attributes empty() {
        return EMPTY;
    }

    public static AttributeKey createKey(String str, Class cls) {
        return PredefinedKey.valueOf(str, cls);
    }

    @Override // net.time4j.engine.AttributeQuery
    public boolean contains(AttributeKey attributeKey) {
        return this.attributes.containsKey(attributeKey.name());
    }

    @Override // net.time4j.engine.AttributeQuery
    public Object get(AttributeKey attributeKey) {
        Object obj = this.attributes.get(attributeKey.name());
        if (obj == null) {
            throw new NoSuchElementException(attributeKey.name());
        }
        return attributeKey.type().cast(obj);
    }

    @Override // net.time4j.engine.AttributeQuery
    public Object get(AttributeKey attributeKey, Object obj) {
        Object obj2 = this.attributes.get(attributeKey.name());
        return obj2 == null ? obj : attributeKey.type().cast(obj2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Attributes) {
            return this.attributes.equals(((Attributes) obj).attributes);
        }
        return false;
    }

    public int hashCode() {
        return this.attributes.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.attributes.size() * 32);
        sb.append(Attributes.class.getName());
        sb.append('[');
        sb.append(this.attributes);
        sb.append(']');
        return sb.toString();
    }

    public static final class Builder {
        private final Map attrs = new HashMap();

        public Builder() {
        }

        public Builder(Chronology chronology) {
            setInternal(Attributes.CALENDAR_TYPE, CalendarText.extractCalendarType(chronology));
        }

        public Builder setLanguage(Locale locale) {
            setInternal(Attributes.LANGUAGE, locale);
            return this;
        }

        public Builder setTimezone(TZID tzid) {
            setInternal(Attributes.TIMEZONE_ID, tzid);
            return this;
        }

        public Builder set(AttributeKey attributeKey, boolean z) {
            this.attrs.put(attributeKey.name(), Boolean.valueOf(z));
            return this;
        }

        public Builder set(AttributeKey attributeKey, int i) {
            if (attributeKey == Attributes.PIVOT_YEAR && i < 100) {
                throw new IllegalArgumentException("Pivot year in far past not supported: " + i);
            }
            this.attrs.put(attributeKey.name(), Integer.valueOf(i));
            return this;
        }

        public Builder set(AttributeKey attributeKey, char c) {
            this.attrs.put(attributeKey.name(), Character.valueOf(c));
            return this;
        }

        public Builder set(AttributeKey attributeKey, Enum r5) {
            if (r5 == null) {
                throw new NullPointerException("Missing attribute value for key: " + attributeKey);
            }
            this.attrs.put(attributeKey.name(), r5);
            if (attributeKey == Attributes.LENIENCY) {
                int i = AnonymousClass1.$SwitchMap$net$time4j$format$Leniency[((Leniency) Leniency.class.cast(r5)).ordinal()];
                if (i == 1) {
                    set(Attributes.PARSE_CASE_INSENSITIVE, false);
                    set(Attributes.PARSE_PARTIAL_COMPARE, false);
                    set(Attributes.TRAILING_CHARACTERS, false);
                    set(Attributes.PARSE_MULTIPLE_CONTEXT, false);
                    return this;
                }
                if (i == 2) {
                    set(Attributes.PARSE_CASE_INSENSITIVE, true);
                    set(Attributes.PARSE_PARTIAL_COMPARE, false);
                    set(Attributes.TRAILING_CHARACTERS, false);
                    set(Attributes.PARSE_MULTIPLE_CONTEXT, true);
                    return this;
                }
                if (i == 3) {
                    set(Attributes.PARSE_CASE_INSENSITIVE, true);
                    set(Attributes.PARSE_PARTIAL_COMPARE, true);
                    set(Attributes.TRAILING_CHARACTERS, true);
                    set(Attributes.PARSE_MULTIPLE_CONTEXT, true);
                    return this;
                }
                throw new UnsupportedOperationException(r5.name());
            }
            if (attributeKey == Attributes.NUMBER_SYSTEM) {
                NumberSystem numberSystem = (NumberSystem) NumberSystem.class.cast(r5);
                if (numberSystem.isDecimal()) {
                    set(Attributes.ZERO_DIGIT, numberSystem.getDigits().charAt(0));
                }
            }
            return this;
        }

        public Builder setAll(Attributes attributes) {
            this.attrs.putAll(attributes.attributes);
            return this;
        }

        public Attributes build() {
            return new Attributes(this.attrs, null);
        }

        private void setInternal(AttributeKey attributeKey, Object obj) {
            if (obj == null) {
                throw new NullPointerException("Missing attribute value for key: " + attributeKey);
            }
            this.attrs.put(attributeKey.name(), obj);
        }
    }

    /* JADX INFO: renamed from: net.time4j.format.Attributes$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$format$Leniency;

        static {
            int[] iArr = new int[Leniency.values().length];
            $SwitchMap$net$time4j$format$Leniency = iArr;
            try {
                iArr[Leniency.STRICT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$net$time4j$format$Leniency[Leniency.SMART.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$net$time4j$format$Leniency[Leniency.LAX.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
