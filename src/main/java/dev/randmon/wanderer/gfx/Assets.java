package dev.randmon.wanderer.gfx;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int WIDTH = 128, HEIGHT = 128; //number of pixels in spreadsheet!

    //buffered image objects
    public static BufferedImage player, dirt, grass, tree,
            brickLeft, brickRight, brickMid, brickSingle,
            brickLeftShadow, brickRightShadow, brickMidShadow, brickSingleShadow;

    public static BufferedImage[] player_down, player_up, player_right, player_left;
    public static BufferedImage[] btn_start;

    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage(
                "/textures/spritesheet_wanderer.png"));
        SpriteSheet playerMoveSheet = new SpriteSheet(ImageLoader.loadImage("/textures/playermove_sheet.png"));

        btn_start = new BufferedImage[2];
        btn_start[0] = sheet.crop(WIDTH*8,0, WIDTH*2, HEIGHT);
        btn_start[1] = sheet.crop(WIDTH*8, HEIGHT, WIDTH*2, HEIGHT);

        player_down = new BufferedImage[2];
        player_up = new BufferedImage[2];
        player_right = new BufferedImage[2];
        player_left = new BufferedImage[2];
        player_down[0] = playerMoveSheet.crop(0, 0, WIDTH, HEIGHT);
        player_down[1] = playerMoveSheet.crop(WIDTH, 0, WIDTH, HEIGHT);
        player_up[0] = playerMoveSheet.crop(WIDTH*2, 0, WIDTH, HEIGHT);
        player_up[1] = playerMoveSheet.crop(WIDTH*3, 0, WIDTH, HEIGHT);
        player_right[0] = playerMoveSheet.crop(0, HEIGHT, WIDTH, HEIGHT);
        player_right[1] = playerMoveSheet.crop(WIDTH, HEIGHT, WIDTH, HEIGHT);
        player_left[0] = playerMoveSheet.crop(WIDTH*2, HEIGHT, WIDTH, HEIGHT);
        player_left[1] = playerMoveSheet.crop(WIDTH*3, HEIGHT, WIDTH, HEIGHT);

        player = sheet.crop(0, 0, WIDTH, HEIGHT);

        dirt = sheet.crop(WIDTH, 0, WIDTH, HEIGHT);
        grass = sheet.crop(WIDTH*2, 0, WIDTH, HEIGHT);

        tree = sheet.crop(0, HEIGHT, WIDTH*2, HEIGHT*2);

        brickLeft = sheet.crop(WIDTH*3, 0, WIDTH, HEIGHT);
        brickMid = sheet.crop(WIDTH*4, 0, WIDTH, HEIGHT);
        brickRight = sheet.crop(WIDTH*5, 0, WIDTH, HEIGHT);
        brickSingle = sheet.crop(WIDTH*6, 0, WIDTH, HEIGHT);
        brickLeftShadow = sheet.crop(WIDTH*3, HEIGHT, WIDTH, HEIGHT);
        brickMidShadow = sheet.crop(WIDTH*4, HEIGHT, WIDTH, HEIGHT);
        brickRightShadow = sheet.crop(WIDTH*5, HEIGHT, WIDTH, HEIGHT);
        brickSingleShadow = sheet.crop(WIDTH*6, HEIGHT, WIDTH, HEIGHT);
    }
}
