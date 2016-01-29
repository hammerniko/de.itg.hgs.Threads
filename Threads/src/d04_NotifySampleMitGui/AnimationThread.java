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
            System.out.println(i++ + ". Schleifendurchlauf des Threads");
            if (panel.isActive())
                panel.increaseIndex();
            else
                try {
                    synchronized(panel) {
                        panel.wait();
                    }
                } catch (InterruptedException exc) {
                    exc.printStackTrace();
                }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}