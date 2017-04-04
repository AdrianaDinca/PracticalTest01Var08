package ro.pub.cs.systems.eim.practicaltest01Var08;

/**
 * Created by adriana on 04.04.2017.
 */

public interface Constants {


    final public static int SECONDARY_ACTIVITY_REQUEST_CODE = 1;

    final public static String FIRST_NUMBER = "firstNumber";
    final public static String SECOND_NUMBER = "secondNumber";

    final public static String[] actionTypes = {
            "ro.pub.cs.systems.eim.practicaltest01.a",
            "ro.pub.cs.systems.eim.practicaltest01.b",
            "ro.pub.cs.systems.eim.practicaltest01.c",
            "ro.pub.cs.systems.eim.practicaltest01.d"
    };

    final public static int NUMBER_OF_CLICKS_THRESHOLD = 5;
    final public static int SERVICE_STOPPED = 0;
    final public static int SERVICE_STARTED = 1;

    final public static String PROCESSING_THREAD_TAG = "[Processing Thread]";

    final public static String BROADCAST_RECEIVER_EXTRA = "message";
    final public static String BROADCAST_RECEIVER_TAG = "[Message]";

}
