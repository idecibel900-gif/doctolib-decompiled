package com.revenuecat.purchases.ui.revenuecatui.components.style;

import com.opentok.android.PublisherKit;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bq\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TabControlStyle;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;", "Buttons", "Toggle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TabControlStyle$Buttons;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TabControlStyle$Toggle;", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface TabControlStyle extends ComponentStyle {

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TabControlStyle$Buttons;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TabControlStyle;", "stack", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;)V", "size", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "getSize", "()Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "getStack", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;", "visible", "", "getVisible", "()Z", "component1", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Buttons implements TabControlStyle {
        public static final int $stable = 0;
        private final Size size;
        private final StackComponentStyle stack;
        private final boolean visible;

        public static /* synthetic */ Buttons copy$default(Buttons buttons, StackComponentStyle stackComponentStyle, int i, Object obj) {
            if ((i & 1) != 0) {
                stackComponentStyle = buttons.stack;
            }
            return buttons.copy(stackComponentStyle);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final StackComponentStyle getStack() {
            return this.stack;
        }

        public final Buttons copy(StackComponentStyle stack) {
            Intrinsics.checkNotNullParameter(stack, "stack");
            return new Buttons(stack);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Buttons) && Intrinsics.areEqual(this.stack, ((Buttons) other).stack);
        }

        public int hashCode() {
            return this.stack.hashCode();
        }

        public String toString() {
            return "Buttons(stack=" + this.stack + ')';
        }

        public Buttons(StackComponentStyle stack) {
            Intrinsics.checkNotNullParameter(stack, "stack");
            this.stack = stack;
            this.visible = stack.getVisible();
            this.size = stack.getSize();
        }

        public final /* synthetic */ StackComponentStyle getStack() {
            return this.stack;
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
        public boolean getVisible() {
            return this.visible;
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
        public Size getSize() {
            return this.size;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TabControlStyle$Toggle;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TabControlStyle;", "stack", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;)V", "size", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "getSize", "()Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "getStack", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;", "visible", "", "getVisible", "()Z", "component1", "copy", "equals", PublisherKit.VIDEO_REASON_QUALITY_DEGRADATION_OTHER, "", "hashCode", "", "toString", "", "revenuecatui_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class Toggle implements TabControlStyle {
        public static final int $stable = 0;
        private final Size size;
        private final StackComponentStyle stack;
        private final boolean visible;

        public static /* synthetic */ Toggle copy$default(Toggle toggle, StackComponentStyle stackComponentStyle, int i, Object obj) {
            if ((i & 1) != 0) {
                stackComponentStyle = toggle.stack;
            }
            return toggle.copy(stackComponentStyle);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final StackComponentStyle getStack() {
            return this.stack;
        }

        public final Toggle copy(StackComponentStyle stack) {
            Intrinsics.checkNotNullParameter(stack, "stack");
            return new Toggle(stack);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Toggle) && Intrinsics.areEqual(this.stack, ((Toggle) other).stack);
        }

        public int hashCode() {
            return this.stack.hashCode();
        }

        public String toString() {
            return "Toggle(stack=" + this.stack + ')';
        }

        public Toggle(StackComponentStyle stack) {
            Intrinsics.checkNotNullParameter(stack, "stack");
            this.stack = stack;
            this.visible = stack.getVisible();
            this.size = stack.getSize();
        }

        public final /* synthetic */ StackComponentStyle getStack() {
            return this.stack;
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
        public boolean getVisible() {
            return this.visible;
        }

        @Override // com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle
        public Size getSize() {
            return this.size;
        }
    }
}
