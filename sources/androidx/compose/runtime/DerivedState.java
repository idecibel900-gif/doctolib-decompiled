package androidx.compose.runtime;

import androidx.collection.ObjectIntMap;

/* JADX INFO: loaded from: classes.dex */
public interface DerivedState extends State {

    public interface Record {
        Object getCurrentValue();

        ObjectIntMap getDependencies();
    }

    Record getCurrentRecord();

    SnapshotMutationPolicy getPolicy();
}
