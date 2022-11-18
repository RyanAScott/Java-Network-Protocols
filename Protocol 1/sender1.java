public class sender1 extends Protocol {
    public static void main(String args[]) throws Exception
    {
        Frame s = new Frame(7777);
        String buffer;

        while (true) {
            buffer = from_network_layer(); // Get Packet
            s.info = buffer;
            s.to_physical_layer("localhost", 8888);   // Send Frame
        }
    }// main
}// sender1
