package utilz;

public class Constants {

    public static class PlayerConstants {

        public static final int IDLE = 0;
        public static final int RUNNING = 1;
        public static final int ATTACK = 2;

        public static int GetSpriteAmount(int player_action) {

            switch (player_action) {

                case IDLE:
                    return 2;
                case RUNNING:
                    return 2;
                case ATTACK:
                    return 1;
                default:
                    return 1;

            }

        }
    }

}
