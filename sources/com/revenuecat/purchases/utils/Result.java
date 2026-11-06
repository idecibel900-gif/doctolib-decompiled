package com.revenuecat.purchases.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u00012\u00020\u0003:\u0002\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0004\u0082\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Lcom/revenuecat/purchases/utils/Result;", "A", "B", "", "()V", "Error", "Success", "Lcom/revenuecat/purchases/utils/Result$Error;", "Lcom/revenuecat/purchases/utils/Result$Success;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class Result<A, B> {
    public /* synthetic */ Result(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0002\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0002¢\u0006\u0002\u0010\u0005R\u0013\u0010\u0004\u001a\u00028\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/revenuecat/purchases/utils/Result$Success;", "A", "Lcom/revenuecat/purchases/utils/Result;", "", "value", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Success<A> extends Result {
        private final A value;

        public Success(A a) {
            super(null);
            this.value = a;
        }

        public final A getValue() {
            return this.value;
        }
    }

    private Result() {
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0002\u0010\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0002¢\u0006\u0002\u0010\u0005R\u0013\u0010\u0004\u001a\u00028\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/revenuecat/purchases/utils/Result$Error;", "B", "Lcom/revenuecat/purchases/utils/Result;", "", "value", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Error<B> extends Result {
        private final B value;

        public Error(B b) {
            super(null);
            this.value = b;
        }

        public final B getValue() {
            return this.value;
        }
    }
}
