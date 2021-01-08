
class TestJoinMethod1 extends Thread { // Class Thread should be extended not implemented
    // created private variable
    private int n;
    private int n1;
    private int n2;
    private String str;
    private String str1;

    // created constructors of class TestJoinMethod1 based on the objects in main function
    public TestJoinMethod1(int n, int n1) {
        this.n = n;
        this.n1 = n1;
    }
    public TestJoinMethod1(int n, int n1, int n2) {
        this.n = n;
        this.n1 = n1;
        this.n2 = n2;
    }
    public TestJoinMethod1(String str, int n, String str1) {
        this.str = str;
        this.n = n;
        this.str1 =str1;
    }

    public void run() {  // start should be converted into run() method
        for(int i = 1; i <= 3; i++) {
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println(i);
        }
    }

}
public class MinKyeonghoA6_Q1 {

    public static void main (String args[]) {
        TestJoinMethod1 t1 = new TestJoinMethod1(1,2);
        TestJoinMethod1 t2 = new TestJoinMethod1(2,4,5);
        TestJoinMethod1 t3 = new TestJoinMethod1("sys",1,"a");

        // t1.run() doesn't occur compile error, but it is meaningless in Thread
        // changed it to start() method
        t1.start();

        try{
            t1.join();
        } catch(Exception e) {
            System.out.println(e);
        }

        t2.start();
        t3.start();
    }
}