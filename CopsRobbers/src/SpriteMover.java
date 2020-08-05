public class SpriteMover implements Runnable {
	private Controller c;
	SpriteMover(Controller C) {
		c = C;
	}

	public void run() {
	    while (true) {
	    	c.model.updateScene(c.view.getWidth(), c.view.getHeight());
	    	c.view.repaint();
	    	
	    	try {
	            Thread.sleep(2);
	        } 
	    	catch (InterruptedException e) {
	    	}
	    }
	}
}