public class receiver1 extends Protocol {
    public static void main(String args[]) throws Exception {
        Frame r = new Frame (8888);
        int event;

        while (true) {
            event = r.wait_for_event(); // 1. wait
            r.from_physical_layer(); // 2. receive frame
            to_network_layer(r.info); // 3. put packet
        }// While
    }// main
}// receiver1
