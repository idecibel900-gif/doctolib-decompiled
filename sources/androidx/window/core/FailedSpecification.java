package androidx.window.core;

import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
final class FailedSpecification extends SpecificationComputer {
    private final WindowStrictModeException exception;
    private final Logger logger;
    private final String message;
    private final String tag;
    private final Object value;
    private final VerificationMode verificationMode;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VerificationMode.values().length];
            try {
                iArr[VerificationMode.STRICT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VerificationMode.LOG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[VerificationMode.QUIET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // androidx.window.core.SpecificationComputer
    public SpecificationComputer require(String message, Function1 condition) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(condition, "condition");
        return this;
    }

    public FailedSpecification(Object value, String tag, String message, Logger logger, VerificationMode verificationMode) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(verificationMode, "verificationMode");
        this.value = value;
        this.tag = tag;
        this.message = message;
        this.logger = logger;
        this.verificationMode = verificationMode;
        WindowStrictModeException windowStrictModeException = new WindowStrictModeException(createMessage(value, message));
        StackTraceElement[] stackTrace = windowStrictModeException.getStackTrace();
        Intrinsics.checkNotNullExpressionValue(stackTrace, "stackTrace");
        windowStrictModeException.setStackTrace((StackTraceElement[]) ArraysKt.drop(stackTrace, 2).toArray(new StackTraceElement[0]));
        this.exception = windowStrictModeException;
    }

    @Override // androidx.window.core.SpecificationComputer
    public Object compute() throws WindowStrictModeException {
        int i = WhenMappings.$EnumSwitchMapping$0[this.verificationMode.ordinal()];
        if (i == 1) {
            throw this.exception;
        }
        if (i == 2) {
            this.logger.debug(this.tag, createMessage(this.value, this.message));
            return null;
        }
        if (i == 3) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }
}
