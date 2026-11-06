package kotlinx.serialization.modules;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ContextualProvider {
    public /* synthetic */ ContextualProvider(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract KSerializer invoke(List list);

    private ContextualProvider() {
    }

    public static final class Argless extends ContextualProvider {
        private final KSerializer serializer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Argless(KSerializer serializer) {
            super(null);
            Intrinsics.checkNotNullParameter(serializer, "serializer");
            this.serializer = serializer;
        }

        public final KSerializer getSerializer() {
            return this.serializer;
        }

        @Override // kotlinx.serialization.modules.ContextualProvider
        public KSerializer invoke(List typeArgumentsSerializers) {
            Intrinsics.checkNotNullParameter(typeArgumentsSerializers, "typeArgumentsSerializers");
            return this.serializer;
        }

        public boolean equals(Object obj) {
            return (obj instanceof Argless) && Intrinsics.areEqual(((Argless) obj).serializer, this.serializer);
        }

        public int hashCode() {
            return this.serializer.hashCode();
        }
    }

    public static final class WithTypeArguments extends ContextualProvider {
        private final Function1 provider;

        public final Function1 getProvider() {
            return this.provider;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WithTypeArguments(Function1 provider) {
            super(null);
            Intrinsics.checkNotNullParameter(provider, "provider");
            this.provider = provider;
        }

        @Override // kotlinx.serialization.modules.ContextualProvider
        public KSerializer invoke(List typeArgumentsSerializers) {
            Intrinsics.checkNotNullParameter(typeArgumentsSerializers, "typeArgumentsSerializers");
            return (KSerializer) this.provider.invoke(typeArgumentsSerializers);
        }
    }
}
