package expo.modules.structuredheaders;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/* JADX INFO: loaded from: classes4.dex */
public class Parameters implements Map {
    public static final Parameters EMPTY = new Parameters(Collections.EMPTY_MAP);
    private final Map delegate;

    private Parameters(Map map) {
        this.delegate = Collections.unmodifiableMap(checkAndTransformMap(map));
    }

    public static Parameters valueOf(Map map) {
        return new Parameters(map);
    }

    public StringBuilder serializeTo(StringBuilder sb) {
        for (Map.Entry entry : this.delegate.entrySet()) {
            sb.append(';');
            sb.append((String) entry.getKey());
            if (!((Item) entry.getValue()).get().equals(Boolean.TRUE)) {
                sb.append('=');
                ((Item) entry.getValue()).serializeTo(sb);
            }
        }
        return sb;
    }

    private static Map checkAndTransformMap(Map map) {
        Objects.requireNonNull(map, "Map must not be null");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map.size());
        for (Map.Entry entry : map.entrySet()) {
            String strCheckKey = Utils.checkKey((String) entry.getKey());
            Item itemAsItem = asItem(strCheckKey, entry.getValue());
            if (!itemAsItem.getParams().isEmpty()) {
                throw new IllegalArgumentException("Parameter value for '" + strCheckKey + "' must be bare item (no parameters)");
            }
            linkedHashMap.put((String) entry.getKey(), itemAsItem);
        }
        return linkedHashMap;
    }

    private static Item asItem(String str, Object obj) {
        if (obj instanceof Item) {
            return (Item) obj;
        }
        if (obj instanceof Integer) {
            return IntegerItem.valueOf(((Integer) obj).longValue());
        }
        if (obj instanceof Long) {
            return IntegerItem.valueOf(((Long) obj).longValue());
        }
        if (obj instanceof String) {
            return StringItem.valueOf((String) obj);
        }
        if (obj instanceof Boolean) {
            return BooleanItem.valueOf(((Boolean) obj).booleanValue());
        }
        if (obj instanceof byte[]) {
            return ByteSequenceItem.valueOf((byte[]) obj);
        }
        if (obj instanceof BigDecimal) {
            return DecimalItem.valueOf((BigDecimal) obj);
        }
        throw new IllegalArgumentException("Can't map value for parameter '" + str + "': " + obj.getClass());
    }

    @Override // java.util.Map
    public void clear() {
        this.delegate.clear();
    }

    @Override // java.util.Map
    public Item compute(String str, BiFunction biFunction) {
        return (Item) this.delegate.compute(str, biFunction);
    }

    @Override // java.util.Map
    public Item computeIfAbsent(String str, Function function) {
        return (Item) this.delegate.computeIfAbsent(str, function);
    }

    @Override // java.util.Map
    public Item computeIfPresent(String str, BiFunction biFunction) {
        return (Item) this.delegate.computeIfPresent(str, biFunction);
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.delegate.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.delegate.containsValue(obj);
    }

    @Override // java.util.Map
    public Set entrySet() {
        return this.delegate.entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return this.delegate.equals(obj);
    }

    @Override // java.util.Map
    public void forEach(BiConsumer biConsumer) {
        this.delegate.forEach(biConsumer);
    }

    @Override // java.util.Map
    public Item get(Object obj) {
        return (Item) this.delegate.get(obj);
    }

    @Override // java.util.Map
    public Item getOrDefault(Object obj, Item item) {
        return (Item) this.delegate.getOrDefault(obj, item);
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.delegate.hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.delegate.isEmpty();
    }

    @Override // java.util.Map
    public Set keySet() {
        return this.delegate.keySet();
    }

    @Override // java.util.Map
    public Item merge(String str, Item item, BiFunction biFunction) {
        return (Item) this.delegate.merge(str, item, biFunction);
    }

    @Override // java.util.Map
    public Item put(String str, Item item) {
        return (Item) this.delegate.put(str, item);
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        this.delegate.putAll(map);
    }

    @Override // java.util.Map
    public Item putIfAbsent(String str, Item item) {
        return (Item) this.delegate.putIfAbsent(str, item);
    }

    @Override // java.util.Map
    public boolean remove(Object obj, Object obj2) {
        return this.delegate.remove(obj, obj2);
    }

    @Override // java.util.Map
    public Item remove(Object obj) {
        return (Item) this.delegate.remove(obj);
    }

    @Override // java.util.Map
    public boolean replace(String str, Item item, Item item2) {
        return this.delegate.replace(str, item, item2);
    }

    @Override // java.util.Map
    public Item replace(String str, Item item) {
        return (Item) this.delegate.replace(str, item);
    }

    @Override // java.util.Map
    public void replaceAll(BiFunction biFunction) {
        this.delegate.replaceAll(biFunction);
    }

    @Override // java.util.Map
    public int size() {
        return this.delegate.size();
    }

    @Override // java.util.Map
    public Collection values() {
        return this.delegate.values();
    }
}
