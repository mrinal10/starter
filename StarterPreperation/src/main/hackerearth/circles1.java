    import java.util.ArrayList;
    import java.util.Iterator;
    import java.util.StringTokenizer;
     
    import java.io.BufferedReader;
    import java.io.InputStreamReader;
     
         
class TestClass_circles
{     
	    static class Point 
	    {
		    int x, y;	
		     
		    public Point(int x, int y) 
		    {
			    super();
			    this.x = x;
			    this.y = y;
	    	}
    	}	
     
     
    static class Circle_object {
     
	    int Cx,Cy,r;
	    String set;
	    public Circle_object(int cx, int cy, int r, String set) {
		    super();
		    Cx = cx;
		    Cy = cy;
		    this.r = r;
		    this.set = set;
	    }
     
	    public Circle_object(int cx, int cy, int r) {
		    super();
		    Cx = cx;
		    Cy = cy;
		    this.r = r;
    	}
     
	    public Circle_object() {
	    // TODO Auto-generated constructor stub
	    }
     
	    public String getSet() {
	    	return set;
	    }
	     
	    public void setSet(String set) {
	    	this.set = set;
	    }
	     
	    public int getCx() {
	    	return Cx;
	    }
	     
	    public void setCx(int cx) {
	    	Cx = cx;
	    }
     
	    public int getCy() {
	    	return Cy;
	    }
	     
	    public void setCy(int cy) {
	    	Cy = cy;
	    }
	     
	    public int getR() {
	    	return r;
	    }	     
	     
	    public void setR(int r) {
	    	this.r = r;
	    }
    }
     
     
    public static double distance(Point P,Point Q){
     
    	return (Math.sqrt((P.x-Q.x)*(P.x-Q.x) + (P.y-Q.y)*(P.y-Q.y)));
    }
     
    public static void main(String[] args) throws Exception {
     
	    int Speed_ratio = 1;
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String first_input = br.readLine();
	    int N=Integer.parseInt(first_input),T=N;
	     
	    Point pmin = new Point(100, 100);
	    Point pmax = new Point(0,0);
	     
	    if(T<=1){
		    System.out.println("Not Enough Number of points");
		    System.exit(0);
	    }
	    ArrayList<Point> AllPoints = new ArrayList<Point>();
	    int x=-1,y=-1;
	    String point_String;
	    
	    while(T-->0){
		    point_String = br.readLine();
		    StringTokenizer st = new StringTokenizer(point_String);
		    x=Integer.parseInt(st.nextToken());
		    y=Integer.parseInt(st.nextToken());
		    
		    if(x<pmin.x)
		    pmin.x = x;
		    else if(x>pmax.x)
		    pmax.x = x;
		    if(y<pmin.y)
		    pmin.y = y;
		    else if(y>pmax.y)
		    pmax.y = y;
		     
		    Point point = new Point( x, y);
		    AllPoints.add(point);
	    }
	     
	    int xci = (pmin.x+pmax.x)/2;
	    int yci = (pmin.y+pmax.y)/2;
	    Point pc = new Point(xci,yci);
	    int ri = (int)Math.ceil(Math.max(distance(pc,pmin),distance(pc,pmax)));
	    double theta;
	    double a;
	    double b;
	    double D_theta;
	    int D_radius;
	    boolean cont=true;
	    int ri1,S=0;
	    double checkVal ;
	    double compare_checkVal;
	    int xc0=xci,yc0=yci,r0=ri;
	    ArrayList<Circle_object> AllFinalCircles = new ArrayList<Circle_object>(); // where all selected circles will be stored
	    Circle_object curr_best_circle = new Circle_object(),c0 = new Circle_object(xc0, yc0, r0, "Biggest All Point Circle , No of points: "+N);
	    Circle_object curr_traversing_circle;
	    Point curr_centre=new Point(xci,yci);
	    String points_within_circle="";
	    int rC;
	    T=N;
	    int i=0,j=0,del=0;
	    Point point1,point2,point_c;
	    for(;j<AllPoints.size()-del;j++)
	    {
		    point1 = AllPoints.get(j);
		    i=0;
		    point2=AllPoints.get(i);
		    while((i++<AllPoints.size()-1-del)&&point1.hashCode()!=point2.hashCode()){
			    if(((point2.x==point1.x)&&(point2.y==point1.y+1||point2.y==point1.y-1))||((point2.y==point1.y)&&(point2.x==point1.x+1||point2.x==point1.x-1))){
				    AllPoints.remove(point2);
				    del++;
				    point2=AllPoints.get(i);
			    }
			    point2=AllPoints.get(i);
		    }
	    }
	    if(N/(double)(S+AllPoints.size())>N/(double)(c0.r)){
		    System.out.println(AllFinalCircles.size()+AllPoints.size());
		    Iterator<Circle_object> iterator_c = AllFinalCircles.iterator();
		    Circle_object circle;
		    while(iterator_c.hasNext()){
			    circle = iterator_c.next();
			    System.out.println(circle.Cx+" "+circle.Cy+" "+circle.r);
			     
		    }
		    Iterator<Point>iterator = AllPoints.iterator();
		    while(iterator.hasNext()){
			    point_c = iterator.next();
			    System.out.println(point_c.x+" "+point_c.y+" "+"1");
		    }
	    }
	    else{
		    System.out.println("1");
		    System.out.println(c0.Cx+" "+c0.Cy+" "+c0.r);
	    }
    }     
}