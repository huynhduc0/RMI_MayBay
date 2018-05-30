import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ChuyenBay extends UnicastRemoteObject implements ChuyenBayInterface {
	String MaHieuChuyenBay;
	String thoiGianBay;
	int soGheTrong;
	int soGheDaBan;
	public ChuyenBay(String MH, String tgb,int trong, int daban) throws RemoteException {
		MaHieuChuyenBay=MH;
		thoiGianBay= tgb;
		soGheTrong=trong;
		soGheDaBan=daban;
	}
	public void datve() throws RemoteException {
		// TODO Auto-generated method stub
		soGheDaBan++;
		soGheTrong--;
	}
	public void trave() throws RemoteException {
		// TODO Auto-generated method stub
		soGheDaBan--;
		soGheTrong++;
	}
	public String getMH() throws RemoteException {
		// TODO Auto-generated method stub
		return MaHieuChuyenBay;
	}
	public String getTGB() throws RemoteException {
		// TODO Auto-generated method stub
		return thoiGianBay;
	}
	public int getGT() throws RemoteException {
		// TODO Auto-generated method stub
		return soGheTrong;
	}
	public int getGDB() throws RemoteException {
		// TODO Auto-generated method stub
		return soGheDaBan;
	}

		
	}

