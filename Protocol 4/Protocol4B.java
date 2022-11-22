public class Protocol4B extends Protocol {
    public static void main(String args[]) throws Exception {
        int next_frame_to_send;
        int frame_expected;
        Frame r = new Frame(888);
        Frame s = new Frame(999);
        String buffer;
        int event;

        next_frame_to_send = 0;     // Send frame 0
        frame_expected = 0;         // Expecting to receive frame 0
        buffer = from_network_layer();

        while (true){
            s.info = buffer;        // Send new frame or resend old
            s.seq = next_frame_to_send;     // frame if no ACK due to timeout
            s.ack = 1 - frame_expected;     // ACK last frame number received
            s.to_physical_layer("localhost", 777);  // send frame
            s.start_timer(s.seq);   // Start timer for this send frame
            event = s.wait_for_event();

            if (event == frame_arrival){ // not a timeout
                r.from_physical_layer();    // <
                if(r.seq == frame_expected){    // If correct frame pass to network
                    to_network_layer(r.info);   // ^
                    frame_expected =            // Update next frame expected
                        (frame_expected + 1) % 2;   // (0->1 or 1->0)
                }// if
                if(r.ack == next_frame_to_send){
                    buffer = from_network_layer();
                    frame_expected =            // Update next frame expected
                        (frame_expected + 1) % 2;   // (0->1 or 1->0)
                }// if
            }// if
        }// while
    }// main
}// Protocol4B Class