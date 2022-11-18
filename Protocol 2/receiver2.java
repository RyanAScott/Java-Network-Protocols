public class receiver2 extends Protocol {
    public static void main(String args[]) throws Exception {
        Frame r = new Frame(888);
        Frame s = new Frame(999);
        int event;

        while(true){
            event = r.wait_for_event();// 1. wait
            r.from_physical_layer();// 2. receive frame
            to_network_layer(r.info);// 3. put packet
            s.to_physical_layer("localhost", 777);// 4. send confirm
        }// while
    }// main
}// receiver2
