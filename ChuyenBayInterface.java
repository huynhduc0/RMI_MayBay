import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChuyenBayInterface extends Remote {
	public void datve() throws RemoteException;
	public void trave() throws RemoteException;
	public String getMH() throws RemoteException;
	public String getTGB() throws RemoteException;
	public int getGT() throws RemoteException;
	public int getGDB() throws RemoteException;
}
