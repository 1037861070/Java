package rmiiiop_equation; 
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface RootInterface	extends Remote
{
public RootJB calRoots(double a,double b, double c) throws RemoteException;
}
