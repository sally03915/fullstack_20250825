package com.company.java017_network_ex;

import javax.swing.JOptionPane;

class ThreadStop extends Thread{
	@Override
	public void run() {
		 for(long i=0; i<109999999; i++) {
			if(Thread.currentThread().isInterrupted()) {  //###  stop2)   
				System.out.println("..... ok"); // 방해받았니?
				break; //break
			}
			 System.out.println(".........................................");
		 }
	}
}

public class Thread003_3 {
	public static void main(String[] args) {
		Thread t = new ThreadStop(); t.start();
		if(  JOptionPane.showInputDialog("stop? y").equals("y") ) { t.interrupt();  }
	}
}
