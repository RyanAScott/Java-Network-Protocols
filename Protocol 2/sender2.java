public class sender2 extends Protocol {
    public static void main(String args[]) throws Exception {
        Frame r = new Frame(777);
        Frame s = new Frame(666);
        String buffer;
        int event;

        while (true) {
            buffer = from_network_layer();// 1. get packet
            s.info = buffer;
            s.to_physical_layer("localhost", 888);// 2. send packet
            event = r.wait_for_event();// 3. confirm wait
        }// while
    }// main
}// sender2
