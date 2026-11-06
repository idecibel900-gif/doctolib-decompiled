package com.revenuecat.purchases.models;

import com.google.firebase.messaging.Constants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002R\u0012\u0010\u0003\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/revenuecat/purchases/models/RawDataContainer;", "DataType", "", Constants.MessagePayloadKeys.RAW_DATA, "getRawData", "()Ljava/lang/Object;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface RawDataContainer<DataType> {
    DataType getRawData();
}
