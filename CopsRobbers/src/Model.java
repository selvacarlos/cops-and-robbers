import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

class Model {
	private ArrayList<Sprite> sprites;
    private Sprite sprite;
    private boolean bool = false;

    Model() throws IOException {
    	sprites = new ArrayList<Sprite>();
		sprite = new Bank();
		sprites.add(sprite);
    }
    
    public void initialize() {
    	synchronized(sprites) {
    		bool = false;
    		sprites.clear();
    		sprites.add(new Bank());
    	}
    }

    public void update(Graphics g) {
		synchronized(sprites) {
			for (int i = 0; i < sprites.size(); i++) {
		sprites.get(i).updateImage(g);
			}
		}
    }
    
    public void addS(int x, int y) {
    	synchronized(sprites) {
	    	if (bool) {
	    		sprite = new CopCar();
	        	sprite.setX(x);
	        	sprite.setY(y);
	        	sprites.add(sprite);
	        	bool = false;
	    	}
	    	else {
	    		sprite = new RobberCar();
	        	sprite.setX(x);
	        	sprite.setY(y);
	        	sprites.add(sprite);
	        	bool = true;
	    	}
    	}
    }
    
    public void print() {
    	System.out.println(RobberCar.getEscaped() + " robbers have escaped and " + RobberCar.getCaptured() + " have been captured.");
    }
    
    public void updateScene(int x, int y) {
    	synchronized(sprites){
    		for (int i = 0; i < sprites.size(); i++) {
    			sprites.get(i).updateState(x, y);
    		}
    		for (Sprite temp : sprites) {
    			if (temp instanceof CopCar) {
    				for (Sprite robber : sprites) {
    					if (robber instanceof RobberCar) {
    						if (temp.overlaps(robber)) {
    							if (!((RobberCar) robber).isCaptured()) {
    								((RobberCar) robber).captured();
    								break;
    							}
    						}
    					}
    				}
    			}
    		}
    		Iterator<Sprite> iter = sprites.iterator();
    		while (iter.hasNext()) {
    			Sprite s = iter.next();
    			if (s instanceof RobberCar) {
    				if (((RobberCar) s).isEscaped()) {
    					iter.remove();
    					System.out.println("Im Free!");
    				}
    			}
    		}
    	}
    }
}