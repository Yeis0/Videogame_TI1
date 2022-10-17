package model;

/**
 * This enum represents the resolution of the game.
 * @author Yeison Antonio Rodriguez Zuluaga.
 */
public enum Resolution {

    /**
     * The resolution is 640x480.
     */
    SD(640, 480),

    /**
     * The resolution is 960x540.
     */
    QHD1(960, 540),

    /**
     * The resolution is 1280x720.
     */
    HD(1280, 720),

    /**
     * The resolution is 1920x1080.
     */
    FHD(1920, 1080),

    /**
     * The resolution is 2560x1440.
     */
    QHD2(2560, 1440),

    /**
     * The resolution is 3840x2160.
     */
    UHD(3840, 2160);

    private int width;
    private int height;


    /**
     * This method is the constructor of the enum.
     * @param width The width of the resolution.
     * @param height The height of the resolution.
     */
    Resolution(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * This method returns the width of the resolution.
     * @return The width of the resolution.
     */
    public int getWidth() {
        return width;
    }

    /**
     * This method returns the height of the resolution.
     * @return The height of the resolution.
     */
    public int getHeight() {
        return height;
    }
    
}
