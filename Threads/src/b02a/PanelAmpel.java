package b02a;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelAmpel extends JPanel{

		private static final int ROT = 1;
		private static final int GELB = 2;
		private static final int GRUEN = 3;
		
		LabelLampe lbRot,lbGelb,lbGruen;
		String name;
		JLabel lbName;
		Ampel a;
		
		public PanelAmpel(String name, int zeit){
			//Neuer Ampelthread
			a = new Ampel(name, ROT, zeit, zeit, zeit, zeit,this);
			this.name = name;
			
			setLayout(new GridLayout(4,1));
			lbName = new JLabel(name);
			lbRot = new LabelLampe(Color.red);
			lbGelb = new LabelLampe(Color.yellow);
			lbGruen = new LabelLampe(Color.green);
			add(lbName);			
			add(lbRot);
			add(lbGelb);
			add(lbGruen);
			
			
			a.start();
				
		}
		
		public void setzeAmpel(int farbe){
			switch (farbe) {
			case ROT:
				System.out.println("Rot gesetzt");
				lbRot.einschalten();
				lbGelb.ausschalten();
				lbGruen.ausschalten();
			break;
			case GELB:lbGelb.einschalten();	
				 System.out.println("Gelb gesetzt");
				lbGruen.ausschalten();
				lbRot.ausschalten();
			break;
			case GRUEN:
				 lbGruen.einschalten();
				 lbRot.ausschalten();	
				 lbGelb.ausschalten();
			break;
			
			default:
				
				break;
		}
			
			
			
}

		@Override
		protected void printComponent(Graphics g) {
			// TODO Auto-generated method stub
			g.drawString(name, 10, 10);
			
		}}
