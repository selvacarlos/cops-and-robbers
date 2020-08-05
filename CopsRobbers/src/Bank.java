import java.awt.Graphics;

public class Bank extends Sprite{
	
	Bank(){
		super("bank.png");
		super.setX(300);
		super.setY(300);
	}
	
	public void update(Graphics g){
		super.updateImage(g);
	}
}