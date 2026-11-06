package com.amazon.d.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface i extends IInterface {
    void a(f fVar) throws RemoteException;

    void a(g gVar) throws RemoteException;

    void a(h hVar) throws RemoteException;

    void a(j jVar) throws RemoteException;

    public static abstract class a extends Binder implements i {
        private static final String a = "com.amazon.venezia.command.ResultCallback";
        static final int b = 1;
        static final int c = 2;
        static final int d = 3;
        static final int e = 4;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, a);
        }

        public static i a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(a);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof i)) {
                return (i) iInterfaceQueryLocalInterface;
            }
            return new C0056a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(a);
                a(j.a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(a);
                a(h.a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface(a);
                a(f.a.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i != 4) {
                if (i == 1598968902) {
                    parcel2.writeString(a);
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(a);
            a(g.a.a(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }

        /* JADX INFO: renamed from: com.amazon.d.a.i$a$a, reason: collision with other inner class name */
        private static class C0056a implements i {
            private IBinder a;

            C0056a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            public String a() {
                return a.a;
            }

            @Override // com.amazon.d.a.i
            public void a(j jVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.a);
                    parcelObtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    this.a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.amazon.d.a.i
            public void a(h hVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.a);
                    parcelObtain.writeStrongBinder(hVar != null ? hVar.asBinder() : null);
                    this.a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.amazon.d.a.i
            public void a(f fVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.a);
                    parcelObtain.writeStrongBinder(fVar != null ? fVar.asBinder() : null);
                    this.a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.amazon.d.a.i
            public void a(g gVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.a);
                    parcelObtain.writeStrongBinder(gVar != null ? gVar.asBinder() : null);
                    this.a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }
}
