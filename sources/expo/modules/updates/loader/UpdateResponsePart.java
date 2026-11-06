package expo.modules.updates.loader;

import expo.modules.updates.manifest.Update;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public abstract class UpdateResponsePart {
    public /* synthetic */ UpdateResponsePart(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final class ManifestUpdateResponsePart extends UpdateResponsePart {
        private final Update update;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ManifestUpdateResponsePart) && Intrinsics.areEqual(this.update, ((ManifestUpdateResponsePart) obj).update);
        }

        public int hashCode() {
            return this.update.hashCode();
        }

        public String toString() {
            return "ManifestUpdateResponsePart(update=" + this.update + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ManifestUpdateResponsePart(Update update) {
            super(null);
            Intrinsics.checkNotNullParameter(update, "update");
            this.update = update;
        }

        public final Update getUpdate() {
            return this.update;
        }
    }

    private UpdateResponsePart() {
    }

    public static final class DirectiveUpdateResponsePart extends UpdateResponsePart {
        private final UpdateDirective updateDirective;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DirectiveUpdateResponsePart) && Intrinsics.areEqual(this.updateDirective, ((DirectiveUpdateResponsePart) obj).updateDirective);
        }

        public int hashCode() {
            return this.updateDirective.hashCode();
        }

        public String toString() {
            return "DirectiveUpdateResponsePart(updateDirective=" + this.updateDirective + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DirectiveUpdateResponsePart(UpdateDirective updateDirective) {
            super(null);
            Intrinsics.checkNotNullParameter(updateDirective, "updateDirective");
            this.updateDirective = updateDirective;
        }

        public final UpdateDirective getUpdateDirective() {
            return this.updateDirective;
        }
    }
}
