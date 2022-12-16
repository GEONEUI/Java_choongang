package section13;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Win2 extends JFrame{
	
	JFrame fr1;
	JButton jb1 = new JButton("새 창");
	
	
	Win2(JFrame jf){
		fr1 = jf;
		this.setTitle("새 창");
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = this.getContentPane();
		c.setLayout(new FlowLayout());
		c.add(jb1);
		this.setSize(400, 300);
		this.setLocation(500, 500);
		this.setVisible(false);
		
		jb1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
	
	
	
	
	
	public static void main(String[] args) {
		
	}
	
	
}
