package d04_NotifySampleMitGui;

class AnimationThread implements Runnable {
	
	//Gemeinsames Objekt des Threads
    private AnimationPanel panel;
    
    public AnimationThread(AnimationPanel panel) {
        this.panel = panel;
    }
    
    public void run() {
        int i = 0;
        while (true) {
            
            if (panel.isActive()){
            	System.out.println(i++ + ". Schleifendurchlauf des Threads");
                panel.increaseIndex();}
            else
                try {
                    synchronized(panel) {
                        panel.wait();
                    }
                } catch (InterruptedException exc) {
                    exc.printStackTrace();
                }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}