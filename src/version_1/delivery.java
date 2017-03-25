package version_1;

/**
 * @author Abhishek
 *
 */

import java.io.*;
import java.net.*;
import java.util.*;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class delivery {

	static Queue<Drone>q=new LinkedList<>();
	static HashSet<String>h=new HashSet<>();
	static Queue<Item>items=new LinkedList<>();
	static Queue<Item>del_items=new LinkedList<>();
	public static void add_drone(){
		System.out.println();
		System.out.println("Enter Drone name");
		Scanner sc=new Scanner(System.in);
		String name=sc.next();
		if(h.contains(name)){
			System.out.println();
			System.out.println(name+" name is already present in system. Please try other name.");
		}
		else{
			h.add(name);
			Drone d=new Drone();
			d.setDroneName(name);

			q.offer(d);
			System.out.println();
			System.out.println("Woohooo! "+d.getDroneName()+" is now part of Drone family.");
		}

		System.out.println();
		
	}
	
	public static void view_drones(){
		System.out.println();

		if(q.size()==0){
			System.out.println("Sorry! There is no drone available.");
		}
		else{
			System.out.println("Available drones are :");
			for(Drone d :q){		
				System.out.println(d.getDroneName());
			}
		}
		System.out.println();
	}
	
	public static void remove_drones(){
		System.out.println();
		System.out.println("Enter Drone name you want to delete");
		Scanner sc=new Scanner(System.in);
		String name=sc.next();
		if(h.contains(name)){
			h.remove(name);
			Drone d_del=null;
			for(Drone d :q){		
				if(d.getDroneName().equals(name)){
					d_del=d;
				}
			}
			q.remove(d_del);
			System.out.println();
			System.out.println("Bye-Bye "+name+"! It was nice working with you.");
		}
		else{
			System.out.println();
			System.out.println("Drone with this name is not available");
		}
		System.out.println();
	}
	
	
	public static void add_delivery_item(){
		System.out.println();
		System.out.println("Enter Item name");
		Scanner sc=new Scanner(System.in);
		String name=sc.nextLine();
		System.out.println("Enter Item delivery address");
		String address=sc.nextLine();
		Item it=new Item();
		it.setItemName(name);
		it.setItemAddress(address);
		items.offer(it);
		System.out.println("Item successfully added to system.");
		System.out.println();
	}
	
	public static void deliver_item() throws InterruptedException{
		if(items.isEmpty()){
			System.out.println();
			System.out.println("No items in system to be delivered");
		}
		else if(q.isEmpty()){
			System.out.println();
			System.out.println("No drone is available for delivery right now.");
		}
		else{
			Command_Center c=new Command_Center();
			Item it=items.remove();
			Drone d=q.remove();
			h.remove(d.getDroneName());
			System.out.println();
			
			String origin=c.getCenterAddress().replaceAll("[^\\w]", "+").replace("++", "+");
			String destination=it.getItemAddress().replaceAll("[^\\w]", "+").replace("++", "+");
			
			try {
				double time = d.getDistance(origin,destination)/d.getDroneSpeed() ;
				int hours= (int)time;
				double min=(time-hours)*60;
				int minutes= (int)min;
				double sec=(min-minutes)*60;
				int seconds=(int)sec;
				System.out.println(d.getDroneName()+" will deliver "+it.getItemName()+" on "+it.getItemAddress()+" in "+hours+" hours "+ minutes+" minutes "+seconds+" seconds  which is "+d.getDistance(origin, destination)+" k.m. distance far.");

				JOptionPane optionPane = new JOptionPane(d.getDroneName()+" has started his delivery journey and will reach to "+it.getItemAddress()+" in "+hours+" hours "+ minutes+" minutes "+seconds+" seconds",JOptionPane.WARNING_MESSAGE);
				JDialog dialog = optionPane.createDialog("Status");
				dialog.setAlwaysOnTop(true); // to show top of all other application
				dialog.setVisible(true);
				int total_sec=hours*3600+minutes*60+seconds;
				long millis=total_sec*1000;
		
				Thread.sleep(millis);
				JOptionPane optionPane1 = new JOptionPane(d.getDroneName()+" has reached to the destination and started unloading item.",JOptionPane.WARNING_MESSAGE);
				JDialog dialog1 = optionPane1.createDialog("Status");
				dialog1.setAlwaysOnTop(true); // to show top of all other application
				dialog1.setVisible(true);
				Thread.sleep(30000);
				JOptionPane optionPane2 = new JOptionPane(d.getDroneName()+" has unloaded the item and will return to command center in "+hours+" hours "+ minutes+" minutes "+seconds+" seconds",JOptionPane.WARNING_MESSAGE);
				JDialog dialog2 = optionPane2.createDialog("Status");
				dialog2.setAlwaysOnTop(true); // to show top of all other application
				dialog2.setVisible(true);
				del_items.offer(it);
				Thread.sleep(millis);
				JOptionPane optionPane3 = new JOptionPane(d.getDroneName()+" has reached command center and ready to pick next item.",JOptionPane.WARNING_MESSAGE);
				JDialog dialog3 = optionPane3.createDialog("Status");
				dialog3.setAlwaysOnTop(true); // to show top of all other application
				dialog3.setVisible(true);
				q.add(d);
				h.add(d.getDroneName());
			} catch (IOException | JSONException e) {
				// TODO Auto-generated catch block
				System.out.println("Item can't be delivered");
				items.offer(it);
				q.add(d);
				h.add(d.getDroneName());
			}


		}

		
	}
	
	
	public static void view_items(){
		System.out.println();

		if(items.size()==0){
			System.out.println(" There is no item to be delievered.");
		}
		else{
			System.out.println("Available items are :");
			for(Item d :items){		
				System.out.println("Item Name: "+d.getItemName() +" Address:"+d.getItemAddress());
			}
		}
		System.out.println();
	}
	
	
	public static void view_delieverd_items(){
		System.out.println();

		if(del_items.size()==0){
			System.out.println(" No items has been delieverd.");
		}
		else{
			System.out.println("Items which are already delievered by drone are :");
			for(Item d :del_items){		
				System.out.println("Item Name: "+d.getItemName() +" Address:"+d.getItemAddress());
			}
		}
		System.out.println();
	}
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Welcome in Drone Delivery System !");

		
		Scanner sc=new Scanner(System.in);
		boolean flag=true;
		while(flag==true){
			System.out.println("     Choose your option");
			System.out.println("1. View Available Drones");
			System.out.println("2. Add Drone");
			System.out.println("3. Remove Drone");
			System.out.println("4. Add item to system for delivery");
			System.out.println("5. Deliver item");
			System.out.println("6. View items to be delivered");
			System.out.println("7. View Delievered Items");
			System.out.println("8. View Test Demo of Delivery System");
			System.out.println("9. Exit the Drone Delivery System");
			int t=sc.nextInt();
		      switch(t) {
		         case 1 : 
		        	 view_drones();
		            break;
		         case 2 : 
		        	 add_drone();
			        break;
		         case 3 : 
		        	 remove_drones();
			        break;
		         case 4 : 
		        	 add_delivery_item();
			        break;
			     case 5 : 
						Thread t2 = new Thread(new Runnable() {


							@Override
							public void run() {
								// TODO Auto-generated method stub
						    	 try {
									deliver_item();
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
							}
						});
						t2.start();
				    break;
			     case 6 : 
			    	 view_items();
				    break;
			     case 7 : 
			    	 view_delieverd_items();
				    break;
			     case 8 : 
			    	 test_case1 t3=new test_case1();
			    	 t3.test();
				    break;  
			     case 9 : 
			 		flag=false;
				    break;
		         default :
		            System.out.println("Invalid Option, try again");
		      }
		}

		
//		Item Name: pen Address:No. 18, Banaswadi Main Road, Marutiseva Nagar, Bengaluru
//		Item Name: banana Address:Brigade Gateway, 8th Floor, 26/1, Dr. Rajkumar Road, Malleshwaram West, Bengaluru
//		Item Name: popaya Address:53, 2nd cross road, vivekananda nagar, Jai Bharath Nagar, Bangalore
//		Item Name: koka Address:6th Floor, Golden Tower, Old Airport Road, Bengaluru
//		
		
	}

}
