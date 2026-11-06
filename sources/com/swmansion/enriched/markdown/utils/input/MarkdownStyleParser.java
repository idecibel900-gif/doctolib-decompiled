package com.swmansion.enriched.markdown.utils.input;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.views.text.ReactTypefaceUtils;
import com.swmansion.enriched.markdown.input.model.InputFormatterStyle;
import com.swmansion.enriched.markdown.input.model.InputHeadingStyle;
import com.swmansion.enriched.markdown.input.model.InputLinkVariantStyle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
public final class MarkdownStyleParser {
    public static final MarkdownStyleParser INSTANCE = new MarkdownStyleParser();

    private MarkdownStyleParser() {
    }

    public final InputFormatterStyle parse(ReadableMap map) {
        Intrinsics.checkNotNullParameter(map, "map");
        ReadableMap map2 = map.getMap("strong");
        ReadableMap map3 = map.getMap("em");
        ReadableMap map4 = map.getMap("link");
        ReadableMap map5 = map.getMap("spoiler");
        ReadableMap map6 = map.getMap("list");
        Integer numValueOf = null;
        Integer numValueOf2 = (map2 == null || !map2.hasKey("color")) ? null : Integer.valueOf(map2.getInt("color"));
        if (map3 != null && map3.hasKey("color")) {
            numValueOf = Integer.valueOf(map3.getInt("color"));
        }
        Intrinsics.checkNotNull(map4);
        int i = map4.getInt("color");
        boolean z = map4.getBoolean("underline");
        int i2 = map4.getInt("backgroundColor");
        List linkVariants = parseLinkVariants(map);
        Intrinsics.checkNotNull(map5);
        return new InputFormatterStyle(numValueOf2, numValueOf, i, z, i2, linkVariants, map5.getInt("color"), map5.getInt("backgroundColor"), parseHeadings(map), (map6 == null || !map6.hasKey("itemSpacing")) ? 0.0f : (float) map6.getDouble("itemSpacing"));
    }

    private final List parseHeadings(ReadableMap readableMap) {
        IntRange intRange = new IntRange(1, 6);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
        Iterator it = intRange.iterator();
        while (it.hasNext()) {
            ReadableMap map = readableMap.getMap("h" + ((IntIterator) it).nextInt());
            Integer numValueOf = null;
            Float fValueOf = (map == null || !map.hasKey("fontSize")) ? null : Float.valueOf(PixelUtil.toPixelFromSP(map.getDouble("fontSize")));
            int fontWeight = (map == null || !map.hasKey("fontWeight")) ? -1 : ReactTypefaceUtils.parseFontWeight(map.getString("fontWeight"));
            if (map != null && map.hasKey("color")) {
                numValueOf = Integer.valueOf(map.getInt("color"));
            }
            arrayList.add(new InputHeadingStyle(fValueOf, fontWeight, numValueOf));
        }
        return arrayList;
    }

    private final List parseLinkVariants(ReadableMap readableMap) {
        ReadableArray array;
        String string;
        if (readableMap.hasKey("linkVariants") && (array = readableMap.getArray("linkVariants")) != null) {
            IntRange intRangeUntil = RangesKt.until(0, array.size());
            ArrayList arrayList = new ArrayList();
            Iterator it = intRangeUntil.iterator();
            while (it.hasNext()) {
                ReadableMap map = array.getMap(((IntIterator) it).nextInt());
                InputLinkVariantStyle inputLinkVariantStyle = null;
                if (map != null && (string = map.getString("pattern")) != null) {
                    inputLinkVariantStyle = new InputLinkVariantStyle(string, map.getInt("color"), map.getBoolean("underline"), map.getInt("backgroundColor"));
                }
                if (inputLinkVariantStyle != null) {
                    arrayList.add(inputLinkVariantStyle);
                }
            }
            return arrayList;
        }
        return CollectionsKt.emptyList();
    }
}
