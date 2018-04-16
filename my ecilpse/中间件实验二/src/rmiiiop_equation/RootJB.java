package rmiiiop_equation;
public class RootJB	implements java.io.Serializable
{

private boolean hasRealRoot; private double X1;
private double X2; public double getX2() {
return X2;
}
public void setX2(double X2) { this.X2 = X2;
}
public double getX1() { return X1;
}

public void setX1(double X1) { this.X1 = X1;
}
public boolean isHasRealRoot() { return hasRealRoot;
}
public void setHasRealRoot(boolean hasRealRoot) { this.hasRealRoot = hasRealRoot;
}

}
