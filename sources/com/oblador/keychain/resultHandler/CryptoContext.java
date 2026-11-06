package com.oblador.keychain.resultHandler;

import java.security.Key;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class CryptoContext {
    private final String alias;
    private final Key key;
    private final CryptoOperation operation;
    private final byte[] password;
    private final byte[] username;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CryptoContext)) {
            return false;
        }
        CryptoContext cryptoContext = (CryptoContext) obj;
        return Intrinsics.areEqual(this.alias, cryptoContext.alias) && Intrinsics.areEqual(this.key, cryptoContext.key) && Intrinsics.areEqual(this.password, cryptoContext.password) && Intrinsics.areEqual(this.username, cryptoContext.username) && this.operation == cryptoContext.operation;
    }

    public int hashCode() {
        return (((((((this.alias.hashCode() * 31) + this.key.hashCode()) * 31) + Arrays.hashCode(this.password)) * 31) + Arrays.hashCode(this.username)) * 31) + this.operation.hashCode();
    }

    public String toString() {
        return "CryptoContext(alias=" + this.alias + ", key=" + this.key + ", password=" + Arrays.toString(this.password) + ", username=" + Arrays.toString(this.username) + ", operation=" + this.operation + ")";
    }

    public CryptoContext(String alias, Key key, byte[] password, byte[] username, CryptoOperation operation) {
        Intrinsics.checkNotNullParameter(alias, "alias");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(operation, "operation");
        this.alias = alias;
        this.key = key;
        this.password = password;
        this.username = username;
        this.operation = operation;
    }

    public final Key getKey() {
        return this.key;
    }

    public final byte[] getPassword() {
        return this.password;
    }

    public final byte[] getUsername() {
        return this.username;
    }

    public final CryptoOperation getOperation() {
        return this.operation;
    }
}
