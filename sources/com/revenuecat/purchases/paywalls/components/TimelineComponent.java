package com.revenuecat.purchases.paywalls.components;

import com.amazon.a.a.o.b;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.paywalls.components.common.ComponentOverride;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@InternalRevenueCatAPI
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 92\u00020\u0001:\u000589:;<B\u0091\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011\u0012\u0014\u0010\u0013\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0018\u00010\u0011\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010\u0018Bu\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0011¢\u0006\u0002\u0010\u0019J&\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00002\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206HÁ\u0001¢\u0006\u0002\b7R\u001c\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u001b\u001a\u0004\b\"\u0010\u001dR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u000f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0011¢\u0006\b\n\u0000\u001a\u0004\b'\u0010$R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b(\u0010&R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u001c\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\u001b\u001a\u0004\b,\u0010\u001dR\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010/\u001a\u0004\b-\u0010.¨\u0006="}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/TimelineComponent;", "Lcom/revenuecat/purchases/paywalls/components/PaywallComponent;", "seen1", "", "itemSpacing", "textSpacing", "columnGutter", "iconAlignment", "Lcom/revenuecat/purchases/paywalls/components/TimelineComponent$IconAlignment;", "visible", "", "size", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "padding", "Lcom/revenuecat/purchases/paywalls/components/properties/Padding;", "margin", "items", "", "Lcom/revenuecat/purchases/paywalls/components/TimelineComponent$Item;", "overrides", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride;", "Lcom/revenuecat/purchases/paywalls/components/PartialTimelineComponent;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIIILcom/revenuecat/purchases/paywalls/components/TimelineComponent$IconAlignment;Ljava/lang/Boolean;Lcom/revenuecat/purchases/paywalls/components/properties/Size;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Ljava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(IIILcom/revenuecat/purchases/paywalls/components/TimelineComponent$IconAlignment;Ljava/lang/Boolean;Lcom/revenuecat/purchases/paywalls/components/properties/Size;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Lcom/revenuecat/purchases/paywalls/components/properties/Padding;Ljava/util/List;Ljava/util/List;)V", "getColumnGutter$annotations", "()V", "getColumnGutter", "()I", "getIconAlignment$annotations", "getIconAlignment", "()Lcom/revenuecat/purchases/paywalls/components/TimelineComponent$IconAlignment;", "getItemSpacing$annotations", "getItemSpacing", "getItems", "()Ljava/util/List;", "getMargin", "()Lcom/revenuecat/purchases/paywalls/components/properties/Padding;", "getOverrides", "getPadding", "getSize", "()Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "getTextSpacing$annotations", "getTextSpacing", "getVisible", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "Connector", "IconAlignment", "Item", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TimelineComponent implements PaywallComponent {
    private final int columnGutter;
    private final IconAlignment iconAlignment;
    private final int itemSpacing;
    private final List<Item> items;
    private final Padding margin;
    private final List<ComponentOverride<PartialTimelineComponent>> overrides;
    private final Padding padding;
    private final Size size;
    private final int textSpacing;
    private final Boolean visible;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer[] $childSerializers = {null, null, null, null, null, null, null, null, new ArrayListSerializer(TimelineComponent$Item$$serializer.INSTANCE), new ArrayListSerializer(ComponentOverride.INSTANCE.serializer(PartialTimelineComponent$$serializer.INSTANCE))};

    public static /* synthetic */ void getColumnGutter$annotations() {
    }

    public static /* synthetic */ void getIconAlignment$annotations() {
    }

    public static /* synthetic */ void getItemSpacing$annotations() {
    }

    public static /* synthetic */ void getTextSpacing$annotations() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimelineComponent)) {
            return false;
        }
        TimelineComponent timelineComponent = (TimelineComponent) obj;
        return this.itemSpacing == timelineComponent.itemSpacing && this.textSpacing == timelineComponent.textSpacing && this.columnGutter == timelineComponent.columnGutter && this.iconAlignment == timelineComponent.iconAlignment && Intrinsics.areEqual(this.visible, timelineComponent.visible) && Intrinsics.areEqual(this.size, timelineComponent.size) && Intrinsics.areEqual(this.padding, timelineComponent.padding) && Intrinsics.areEqual(this.margin, timelineComponent.margin) && Intrinsics.areEqual(this.items, timelineComponent.items) && Intrinsics.areEqual(this.overrides, timelineComponent.overrides);
    }

    public int hashCode() {
        int iHashCode = ((((((this.itemSpacing * 31) + this.textSpacing) * 31) + this.columnGutter) * 31) + this.iconAlignment.hashCode()) * 31;
        Boolean bool = this.visible;
        return ((((((((((iHashCode + (bool == null ? 0 : bool.hashCode())) * 31) + this.size.hashCode()) * 31) + this.padding.hashCode()) * 31) + this.margin.hashCode()) * 31) + this.items.hashCode()) * 31) + this.overrides.hashCode();
    }

    public String toString() {
        return "TimelineComponent(itemSpacing=" + this.itemSpacing + ", textSpacing=" + this.textSpacing + ", columnGutter=" + this.columnGutter + ", iconAlignment=" + this.iconAlignment + ", visible=" + this.visible + ", size=" + this.size + ", padding=" + this.padding + ", margin=" + this.margin + ", items=" + this.items + ", overrides=" + this.overrides + ')';
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/TimelineComponent$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/TimelineComponent;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer serializer() {
            return TimelineComponent$$serializer.INSTANCE;
        }
    }

    @Deprecated
    public /* synthetic */ TimelineComponent(int i, int i2, int i3, int i4, IconAlignment iconAlignment, Boolean bool, Size size, Padding padding, Padding padding2, List list, List list2, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (i & 15)) {
            PluginExceptionsKt.throwMissingFieldException(i, 15, TimelineComponent$$serializer.INSTANCE.getDescriptor());
        }
        this.itemSpacing = i2;
        this.textSpacing = i3;
        this.columnGutter = i4;
        this.iconAlignment = iconAlignment;
        if ((i & 16) == 0) {
            this.visible = null;
        } else {
            this.visible = bool;
        }
        if ((i & 32) == 0) {
            this.size = new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE);
        } else {
            this.size = size;
        }
        if ((i & 64) == 0) {
            this.padding = Padding.INSTANCE.getZero();
        } else {
            this.padding = padding;
        }
        if ((i & 128) == 0) {
            this.margin = Padding.INSTANCE.getZero();
        } else {
            this.margin = padding2;
        }
        if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) == 0) {
            this.items = CollectionsKt.emptyList();
        } else {
            this.items = list;
        }
        if ((i & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) == 0) {
            this.overrides = CollectionsKt.emptyList();
        } else {
            this.overrides = list2;
        }
    }

    public TimelineComponent(int i, int i2, int i3, IconAlignment iconAlignment, Boolean bool, Size size, Padding padding, Padding margin, List<Item> items, List<ComponentOverride<PartialTimelineComponent>> overrides) {
        Intrinsics.checkNotNullParameter(iconAlignment, "iconAlignment");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(padding, "padding");
        Intrinsics.checkNotNullParameter(margin, "margin");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        this.itemSpacing = i;
        this.textSpacing = i2;
        this.columnGutter = i3;
        this.iconAlignment = iconAlignment;
        this.visible = bool;
        this.size = size;
        this.padding = padding;
        this.margin = margin;
        this.items = items;
        this.overrides = overrides;
    }

    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(TimelineComponent self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer[] kSerializerArr = $childSerializers;
        output.encodeIntElement(serialDesc, 0, self.itemSpacing);
        output.encodeIntElement(serialDesc, 1, self.textSpacing);
        output.encodeIntElement(serialDesc, 2, self.columnGutter);
        output.encodeSerializableElement(serialDesc, 3, TimelineIconAlignmentDeserializer.INSTANCE, self.iconAlignment);
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.visible != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, BooleanSerializer.INSTANCE, self.visible);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.size, new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE))) {
            output.encodeSerializableElement(serialDesc, 5, Size$$serializer.INSTANCE, self.size);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || !Intrinsics.areEqual(self.padding, Padding.INSTANCE.getZero())) {
            output.encodeSerializableElement(serialDesc, 6, Padding$$serializer.INSTANCE, self.padding);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || !Intrinsics.areEqual(self.margin, Padding.INSTANCE.getZero())) {
            output.encodeSerializableElement(serialDesc, 7, Padding$$serializer.INSTANCE, self.margin);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || !Intrinsics.areEqual(self.items, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 8, kSerializerArr[8], self.items);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 9) && Intrinsics.areEqual(self.overrides, CollectionsKt.emptyList())) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 9, kSerializerArr[9], self.overrides);
    }

    public final /* synthetic */ int getItemSpacing() {
        return this.itemSpacing;
    }

    public final /* synthetic */ int getTextSpacing() {
        return this.textSpacing;
    }

    public final /* synthetic */ int getColumnGutter() {
        return this.columnGutter;
    }

    public final /* synthetic */ IconAlignment getIconAlignment() {
        return this.iconAlignment;
    }

    public final /* synthetic */ Boolean getVisible() {
        return this.visible;
    }

    public /* synthetic */ TimelineComponent(int i, int i2, int i3, IconAlignment iconAlignment, Boolean bool, Size size, Padding padding, Padding padding2, List list, List list2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, iconAlignment, (i4 & 16) != 0 ? null : bool, (i4 & 32) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fit.INSTANCE) : size, (i4 & 64) != 0 ? Padding.INSTANCE.getZero() : padding, (i4 & 128) != 0 ? Padding.INSTANCE.getZero() : padding2, (i4 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_EVENT_EMITTER) != 0 ? CollectionsKt.emptyList() : list, (i4 & IntBufferBatchMountItem.INSTRUCTION_UPDATE_PADDING) != 0 ? CollectionsKt.emptyList() : list2);
    }

    public final /* synthetic */ Size getSize() {
        return this.size;
    }

    public final /* synthetic */ Padding getPadding() {
        return this.padding;
    }

    public final /* synthetic */ Padding getMargin() {
        return this.margin;
    }

    public final /* synthetic */ List getItems() {
        return this.items;
    }

    public final /* synthetic */ List getOverrides() {
        return this.overrides;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/TimelineComponent$IconAlignment;", "", "(Ljava/lang/String;I)V", "Title", "TitleAndDescription", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum IconAlignment {
        Title,
        TitleAndDescription;


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/TimelineComponent$IconAlignment$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/TimelineComponent$IconAlignment;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer serializer() {
                return TimelineIconAlignmentDeserializer.INSTANCE;
            }
        }
    }

    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 *2\u00020\u0001:\u0002)*Ba\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0014\u0010\r\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0018\u00010\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013BO\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0014\b\u0002\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e¢\u0006\u0002\u0010\u0014J&\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'HÁ\u0001¢\u0006\u0002\b(R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001f¨\u0006+"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/TimelineComponent$Item;", "", "seen1", "", b.S, "Lcom/revenuecat/purchases/paywalls/components/TextComponent;", "visible", "", b.c, "icon", "Lcom/revenuecat/purchases/paywalls/components/IconComponent;", "connector", "Lcom/revenuecat/purchases/paywalls/components/TimelineComponent$Connector;", "overrides", "", "Lcom/revenuecat/purchases/paywalls/components/common/ComponentOverride;", "Lcom/revenuecat/purchases/paywalls/components/PartialTimelineComponentItem;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/revenuecat/purchases/paywalls/components/TextComponent;Ljava/lang/Boolean;Lcom/revenuecat/purchases/paywalls/components/TextComponent;Lcom/revenuecat/purchases/paywalls/components/IconComponent;Lcom/revenuecat/purchases/paywalls/components/TimelineComponent$Connector;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/revenuecat/purchases/paywalls/components/TextComponent;Ljava/lang/Boolean;Lcom/revenuecat/purchases/paywalls/components/TextComponent;Lcom/revenuecat/purchases/paywalls/components/IconComponent;Lcom/revenuecat/purchases/paywalls/components/TimelineComponent$Connector;Ljava/util/List;)V", "getConnector", "()Lcom/revenuecat/purchases/paywalls/components/TimelineComponent$Connector;", "getDescription", "()Lcom/revenuecat/purchases/paywalls/components/TextComponent;", "getIcon", "()Lcom/revenuecat/purchases/paywalls/components/IconComponent;", "getOverrides", "()Ljava/util/List;", "getTitle", "getVisible", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Item {
        private final Connector connector;
        private final TextComponent description;
        private final IconComponent icon;
        private final List<ComponentOverride<PartialTimelineComponentItem>> overrides;
        private final TextComponent title;
        private final Boolean visible;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer[] $childSerializers = {null, null, null, null, null, new ArrayListSerializer(ComponentOverride.INSTANCE.serializer(PartialTimelineComponentItem$$serializer.INSTANCE))};

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Item)) {
                return false;
            }
            Item item = (Item) obj;
            return Intrinsics.areEqual(this.title, item.title) && Intrinsics.areEqual(this.visible, item.visible) && Intrinsics.areEqual(this.description, item.description) && Intrinsics.areEqual(this.icon, item.icon) && Intrinsics.areEqual(this.connector, item.connector) && Intrinsics.areEqual(this.overrides, item.overrides);
        }

        public int hashCode() {
            int iHashCode = this.title.hashCode() * 31;
            Boolean bool = this.visible;
            int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
            TextComponent textComponent = this.description;
            int iHashCode3 = (((iHashCode2 + (textComponent == null ? 0 : textComponent.hashCode())) * 31) + this.icon.hashCode()) * 31;
            Connector connector = this.connector;
            return ((iHashCode3 + (connector != null ? connector.hashCode() : 0)) * 31) + this.overrides.hashCode();
        }

        public String toString() {
            return "Item(title=" + this.title + ", visible=" + this.visible + ", description=" + this.description + ", icon=" + this.icon + ", connector=" + this.connector + ", overrides=" + this.overrides + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/TimelineComponent$Item$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/TimelineComponent$Item;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer serializer() {
                return TimelineComponent$Item$$serializer.INSTANCE;
            }
        }

        @Deprecated
        public /* synthetic */ Item(int i, TextComponent textComponent, Boolean bool, TextComponent textComponent2, IconComponent iconComponent, Connector connector, List list, SerializationConstructorMarker serializationConstructorMarker) {
            if (9 != (i & 9)) {
                PluginExceptionsKt.throwMissingFieldException(i, 9, TimelineComponent$Item$$serializer.INSTANCE.getDescriptor());
            }
            this.title = textComponent;
            if ((i & 2) == 0) {
                this.visible = null;
            } else {
                this.visible = bool;
            }
            if ((i & 4) == 0) {
                this.description = null;
            } else {
                this.description = textComponent2;
            }
            this.icon = iconComponent;
            if ((i & 16) == 0) {
                this.connector = null;
            } else {
                this.connector = connector;
            }
            if ((i & 32) == 0) {
                this.overrides = CollectionsKt.emptyList();
            } else {
                this.overrides = list;
            }
        }

        public Item(TextComponent title, Boolean bool, TextComponent textComponent, IconComponent icon, Connector connector, List<ComponentOverride<PartialTimelineComponentItem>> overrides) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(icon, "icon");
            Intrinsics.checkNotNullParameter(overrides, "overrides");
            this.title = title;
            this.visible = bool;
            this.description = textComponent;
            this.icon = icon;
            this.connector = connector;
            this.overrides = overrides;
        }

        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Item self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer[] kSerializerArr = $childSerializers;
            TextComponent$$serializer textComponent$$serializer = TextComponent$$serializer.INSTANCE;
            output.encodeSerializableElement(serialDesc, 0, textComponent$$serializer, self.title);
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.visible != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, BooleanSerializer.INSTANCE, self.visible);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.description != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, textComponent$$serializer, self.description);
            }
            output.encodeSerializableElement(serialDesc, 3, IconComponent$$serializer.INSTANCE, self.icon);
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.connector != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, TimelineComponent$Connector$$serializer.INSTANCE, self.connector);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 5) && Intrinsics.areEqual(self.overrides, CollectionsKt.emptyList())) {
                return;
            }
            output.encodeSerializableElement(serialDesc, 5, kSerializerArr[5], self.overrides);
        }

        public final /* synthetic */ TextComponent getTitle() {
            return this.title;
        }

        public final /* synthetic */ Boolean getVisible() {
            return this.visible;
        }

        public final /* synthetic */ TextComponent getDescription() {
            return this.description;
        }

        public final /* synthetic */ IconComponent getIcon() {
            return this.icon;
        }

        public final /* synthetic */ Connector getConnector() {
            return this.connector;
        }

        public /* synthetic */ Item(TextComponent textComponent, Boolean bool, TextComponent textComponent2, IconComponent iconComponent, Connector connector, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(textComponent, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : textComponent2, iconComponent, (i & 16) != 0 ? null : connector, (i & 32) != 0 ? CollectionsKt.emptyList() : list);
        }

        public final /* synthetic */ List getOverrides() {
            return this.overrides;
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001b\u001cB5\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\fJ&\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019HÁ\u0001¢\u0006\u0002\b\u001aR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/TimelineComponent$Connector;", "", "seen1", "", "width", "margin", "Lcom/revenuecat/purchases/paywalls/components/properties/Padding;", "color", "Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILcom/revenuecat/purchases/paywalls/components/properties/Padding;Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(ILcom/revenuecat/purchases/paywalls/components/properties/Padding;Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;)V", "getColor", "()Lcom/revenuecat/purchases/paywalls/components/properties/ColorScheme;", "getMargin", "()Lcom/revenuecat/purchases/paywalls/components/properties/Padding;", "getWidth", "()I", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$purchases_defaultsBc8Release", "$serializer", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Connector {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final ColorScheme color;
        private final Padding margin;
        private final int width;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Connector)) {
                return false;
            }
            Connector connector = (Connector) obj;
            return this.width == connector.width && Intrinsics.areEqual(this.margin, connector.margin) && Intrinsics.areEqual(this.color, connector.color);
        }

        public int hashCode() {
            return (((this.width * 31) + this.margin.hashCode()) * 31) + this.color.hashCode();
        }

        public String toString() {
            return "Connector(width=" + this.width + ", margin=" + this.margin + ", color=" + this.color + ')';
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/paywalls/components/TimelineComponent$Connector$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/revenuecat/purchases/paywalls/components/TimelineComponent$Connector;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer serializer() {
                return TimelineComponent$Connector$$serializer.INSTANCE;
            }
        }

        @Deprecated
        public /* synthetic */ Connector(int i, int i2, Padding padding, ColorScheme colorScheme, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (i & 7)) {
                PluginExceptionsKt.throwMissingFieldException(i, 7, TimelineComponent$Connector$$serializer.INSTANCE.getDescriptor());
            }
            this.width = i2;
            this.margin = padding;
            this.color = colorScheme;
        }

        public Connector(int i, Padding margin, ColorScheme color) {
            Intrinsics.checkNotNullParameter(margin, "margin");
            Intrinsics.checkNotNullParameter(color, "color");
            this.width = i;
            this.margin = margin;
            this.color = color;
        }

        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(Connector self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeIntElement(serialDesc, 0, self.width);
            output.encodeSerializableElement(serialDesc, 1, Padding$$serializer.INSTANCE, self.margin);
            output.encodeSerializableElement(serialDesc, 2, ColorScheme$$serializer.INSTANCE, self.color);
        }

        public final /* synthetic */ int getWidth() {
            return this.width;
        }

        public final /* synthetic */ Padding getMargin() {
            return this.margin;
        }

        public final /* synthetic */ ColorScheme getColor() {
            return this.color;
        }
    }
}
