package net.time4j.format.expert;

import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import java.io.IOException;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.format.Attributes;

/* JADX INFO: loaded from: classes5.dex */
final class LookupProcessor implements FormatProcessor {
    private final boolean caseInsensitive;
    private final ChronoElement element;
    private final Locale locale;
    private final int protectedLength;
    private final Map resources;

    @Override // net.time4j.format.expert.FormatProcessor
    public boolean isNumerical() {
        return false;
    }

    LookupProcessor(ChronoElement chronoElement, Map map) {
        Map map2;
        Class type = chronoElement.getType();
        if (type.isEnum()) {
            if (map.size() < type.getEnumConstants().length) {
                throw new IllegalArgumentException("Not enough text resources defined for enum: " + type.getName());
            }
            map2 = createMap(type);
        } else {
            map2 = new HashMap(map.size());
        }
        map2.putAll(map);
        this.element = chronoElement;
        this.resources = Collections.unmodifiableMap(map2);
        this.protectedLength = 0;
        this.caseInsensitive = true;
        this.locale = Locale.getDefault();
    }

    private LookupProcessor(ChronoElement chronoElement, Map map, int i, boolean z, Locale locale) {
        this.element = chronoElement;
        this.resources = map;
        this.protectedLength = i;
        this.caseInsensitive = z;
        this.locale = locale;
    }

    @Override // net.time4j.format.expert.FormatProcessor
    public int print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery, Set set, boolean z) throws IOException {
        if (appendable instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) appendable;
            int length = charSequence.length();
            int iPrint = print(chronoDisplay, appendable);
            if (set != null) {
                set.add(new ElementPosition(this.element, length, charSequence.length()));
            }
            return iPrint;
        }
        return print(chronoDisplay, appendable);
    }

    @Override // net.time4j.format.expert.FormatProcessor
    public void parse(CharSequence charSequence, ParseLog parseLog, AttributeQuery attributeQuery, ParsedEntity parsedEntity, boolean z) {
        boolean zBooleanValue;
        int position = parseLog.getPosition();
        int length = charSequence.length();
        int iIntValue = z ? this.protectedLength : ((Integer) attributeQuery.get(Attributes.PROTECTED_CHARACTERS, 0)).intValue();
        if (iIntValue > 0) {
            length -= iIntValue;
        }
        if (position >= length) {
            parseLog.setError(position, "Missing chars for: " + this.element.name());
            parseLog.setWarning();
            return;
        }
        if (z) {
            zBooleanValue = this.caseInsensitive;
        } else {
            zBooleanValue = ((Boolean) attributeQuery.get(Attributes.PARSE_CASE_INSENSITIVE, Boolean.TRUE)).booleanValue();
        }
        Locale locale = z ? this.locale : (Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.getDefault());
        int i = length - position;
        for (Object obj : this.resources.keySet()) {
            String string = getString(obj);
            if (zBooleanValue) {
                String upperCase = string.toUpperCase(locale);
                int length2 = string.length();
                if (length2 <= i) {
                    int i2 = length2 + position;
                    if (upperCase.equals(charSequence.subSequence(position, i2).toString().toUpperCase(locale))) {
                        parsedEntity.put(this.element, obj);
                        parseLog.setPosition(i2);
                        return;
                    }
                } else {
                    continue;
                }
            } else {
                int length3 = string.length();
                if (length3 <= i) {
                    int i3 = length3 + position;
                    if (string.equals(charSequence.subSequence(position, i3).toString())) {
                        parsedEntity.put(this.element, obj);
                        parseLog.setPosition(i3);
                        return;
                    }
                } else {
                    continue;
                }
            }
        }
        parseLog.setError(position, "Element value could not be parsed: " + this.element.name());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LookupProcessor) {
            LookupProcessor lookupProcessor = (LookupProcessor) obj;
            if (this.element.equals(lookupProcessor.element) && this.resources.equals(lookupProcessor.resources)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.element.hashCode() * 7) + (this.resources.hashCode() * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING);
        sb.append(LookupProcessor.class.getName());
        sb.append("[element=");
        sb.append(this.element.name());
        sb.append(", resources=");
        sb.append(this.resources);
        sb.append(']');
        return sb.toString();
    }

    @Override // net.time4j.format.expert.FormatProcessor
    public ChronoElement getElement() {
        return this.element;
    }

    @Override // net.time4j.format.expert.FormatProcessor
    public FormatProcessor withElement(ChronoElement chronoElement) {
        return this.element == chronoElement ? this : new LookupProcessor(chronoElement, this.resources);
    }

    @Override // net.time4j.format.expert.FormatProcessor
    public FormatProcessor quickPath(ChronoFormatter chronoFormatter, AttributeQuery attributeQuery, int i) {
        return new LookupProcessor(this.element, this.resources, ((Integer) attributeQuery.get(Attributes.PROTECTED_CHARACTERS, 0)).intValue(), ((Boolean) attributeQuery.get(Attributes.PARSE_CASE_INSENSITIVE, Boolean.TRUE)).booleanValue(), (Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.getDefault()));
    }

    private int print(ChronoDisplay chronoDisplay, Appendable appendable) throws IOException {
        String string = getString(chronoDisplay.get(this.element));
        appendable.append(string);
        return string.length();
    }

    private String getString(Object obj) {
        String str = (String) this.resources.get(obj);
        return str == null ? obj.toString() : str;
    }

    private static Map createMap(Class cls) {
        return new EnumMap(cls);
    }
}
