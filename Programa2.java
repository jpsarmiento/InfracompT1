import java.util.Scanner;
public class Programa2 implements Runnable {

	private int paridad;
	private int limSup;
	private long time;
	
	public Programa2(int paridad, int limSup, long time) {
		this.paridad=paridad;
		this.limSup=limSup;
		this.time=time;
	}
	
	@Override
	public void run() {
		if(paridad==0) {
			for(int i = 1 ; i <= limSup/2; i++) {
				System.out.println(2*i);
				try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
			}
		}	
		else if(paridad==1) {
			for(int i = 1 ; i <= (limSup+1)/2; i++) {
				System.out.println((2*i)-1);
				try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner l = new Scanner(System.in);
		System.out.println("De el rango superior");
		int limSup=l.nextInt();
		System.out.println("De el tiempo delay de los threads");
		long time=l.nextLong();
		Thread t1 = new Thread(new Programa1(1, limSup, time));
		Thread t0 = new Thread(new Programa1(0, limSup, time));
		t1.start();	
		t0.start();
	}
}