package version_1;


import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;


/**
 * @author Abhishek
 *
 */


public class test_case1 {


	@Test
	public void test() throws InterruptedException {
		final delivery del=new delivery();
		System.out.println("Test Cases/ Demo will be executed in 18 minutes(according to the Maximum delivery time).");
		 Queue<Drone>q1=new LinkedList<>();
		 Queue<Item>items1=new LinkedList<>();
		 Drone d1=new Drone();
		 Drone d2=new Drone();
		 Drone d3=new Drone();
		 Drone d4=new Drone();
		 
		 d1.setDroneName("Stuart");
		 d2.setDroneName("Bob");
		 d3.setDroneName("Kevin");
		 d4.setDroneName("Dave");
		 
		 del.h.add(d1.getDroneName());
		 del.h.add(d2.getDroneName());
		 del.h.add(d3.getDroneName());
		 del.h.add(d4.getDroneName());
		 
		 q1.offer(d1);
		 q1.offer(d2);
		 q1.offer(d3);
		 q1.offer(d4);
		 del.q=q1;
		 System.out.println(d1.getDroneName()+", "+d2.getDroneName()+", "+d3.getDroneName()+" and "+d4.getDroneName()+" is now added to system.");
		 System.out.println();
		 del.view_drones();
		 
		 
		 Item i1=new Item();
		 Item i2=new Item();
		 Item i3=new Item();
		 Item i4=new Item();
		 
		 i1.setItemName("koka");
		 i2.setItemName("popaya");
		 i3.setItemName("pen");
		 i4.setItemName("banana");
		 i1.setItemAddress("6th Floor, Golden Tower, Old Airport Road, Bengaluru");
		 i2.setItemAddress("53, 2nd cross road, vivekananda nagar, Jai Bharath Nagar, Bangalore");
		 i3.setItemAddress("No. 18, Banaswadi Main Road, Marutiseva Nagar, Bengaluru");
		 i4.setItemAddress("Brigade Gateway, 8th Floor, 26/1, Dr. Rajkumar Road, Malleshwaram West, Bengaluru");
		 
		 items1.offer(i1);
		 items1.offer(i2);
		 items1.offer(i3);
		 items1.offer(i4);
		 del.items=items1;
		 
		 System.out.println(i1.getItemName()+", "+i2.getItemName()+", "+i3.getItemName()+" and "+i4.getItemName()+" are added to System.");
		 
		 del.view_items();
		 
		 System.out.println("Starting Delivery.....");
			Thread t1 = new Thread(new Runnable() {


				@Override
				public void run() {
					// TODO Auto-generated method stub
			    	 try {
			    		 del.deliver_item();
			    		 del.view_delieverd_items();
			    		 del.view_drones();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			});
			t1.start();
			Thread t2 = new Thread(new Runnable() {


				@Override
				public void run() {
					// TODO Auto-generated method stub
			    	 try {
			    		 del.deliver_item();
			    		 del.view_delieverd_items();
			    		 del.view_drones();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			});
			t2.start();
			Thread t3 = new Thread(new Runnable() {


				@Override
				public void run() {
					// TODO Auto-generated method stub
			    	 try {
			    		 del.deliver_item();
			    		 del.view_delieverd_items();
			    		 del.view_drones();

					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			});
			t3.start();
			
			
			Thread t4 = new Thread(new Runnable() {


				@Override
				public void run() {
					// TODO Auto-generated method stub
			    	 try {
			    		 del.deliver_item();
			    		 del.view_delieverd_items();
			    		 del.view_drones();
			    		 
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			});
			t4.start();

		Thread.sleep(6000);
		del.view_drones();
		Thread.sleep(10810000);
		 
		 
		
	}

}
