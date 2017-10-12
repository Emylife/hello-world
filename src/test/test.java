package test;

import java.util.HashMap;
import java.util.Map;

public class test {
	private static Map<String,String> pool = new HashMap<String,String>();
	private static Thread t = new Thread(new Runnable()
	{
		public void run()
		{
			modify();
		}
	});
	public static void modify()
	{
		synchronized (pool) {
			System.out.println("enter modify!");
			try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pool.put("No1", "1");
			System.out.println("modify pool:"+pool.toString());
		}
		
	}
	public static void main(String[] args) {
		t.start();
		pool.put("No2","2");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("put pool:"+pool.toString());
	}
//	public static void main(String[] args) {
//		StringBuffer a = new StringBuffer("a");
//		StringBuffer b = new StringBuffer("b");
//		StringBuffer c = new test().fun(a,b);
//		System.out.println(a+","+b+","+c);
//	}
//	public StringBuffer fun(StringBuffer x, StringBuffer y)
//	{
//		x.append(y);
//		y = x;
//		return y;
//	}
	
}
