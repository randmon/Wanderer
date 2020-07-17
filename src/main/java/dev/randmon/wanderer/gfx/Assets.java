package dev.randmon.wanderer.gfx;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Assets {

    private static final int WIDTH = 128, HEIGHT = 128; //number of pixels in spreadsheet!

    //buffered image objects
    public static BufferedImage player, dirt, grass, tree, wood,
            brickLeft, brickRight, brickMid, brickSingle,
            brickLeftShadow, brickRightShadow, brickMidShadow, brickSingleShadow,
            grass3d;

    public static BufferedImage[] player_down, player_up, player_right, player_left;
    public static BufferedImage[] btn_start;
    public static BufferedImage[] flowers, dogSmall;

    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage(
                "/textures/spritesheet_wanderer.png"));
        SpriteSheet playerMoveSheet = new SpriteSheet(ImageLoader.loadImage("/textures/playermove_sheet.png"));
        SpriteSheet flowersSheet = new SpriteSheet(ImageLoader.loadImage("/textures/flowers.png"));
        SpriteSheet dogSheet = new SpriteSheet(ImageLoader.loadImage("/textures/dog-sheet.png"));

        grass3d = ImageLoader.loadImage("/textures/grass3d.png");

        //Dog sheet
        dogSmall = new BufferedImage[4];
        dogSmall[0] = dogSheet.crop(0,0,WIDTH, HEIGHT);
        dogSmall[1] = dogSheet.crop(WIDTH,0,WIDTH, HEIGHT);
        dogSmall[2] = dogSheet.crop(WIDTH*2,0,WIDTH, HEIGHT);
        dogSmall[3] = dogSheet.crop(WIDTH*3,0,WIDTH, HEIGHT);

        //Flowers sheet
        flowers = new BufferedImage[7];
        flowers[0] = flowersSheet.crop(0,0,WIDTH, HEIGHT);
        flowers[1] = flowersSheet.crop(WIDTH,0,WIDTH, HEIGHT);
        flowers[2] = flowersSheet.crop(WIDTH*2,0,WIDTH, HEIGHT);
        flowers[3] = flowersSheet.crop(WIDTH*3,0,WIDTH, HEIGHT);
        flowers[4] = flowersSheet.crop(0,HEIGHT,WIDTH, HEIGHT);
        flowers[5] = flowersSheet.crop(WIDTH,HEIGHT,WIDTH, HEIGHT);
        flowers[6] = flowersSheet.crop(WIDTH*2,HEIGHT,WIDTH, HEIGHT);

        //Player move sheet
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

        //Wanderer sheet
        player = sheet.crop(0, 0, WIDTH, HEIGHT);

        btn_start = new BufferedImage[2];
        btn_start[0] = sheet.crop(WIDTH*8,0, WIDTH*2, HEIGHT);
        btn_start[1] = sheet.crop(WIDTH*8, HEIGHT, WIDTH*2, HEIGHT);

        dirt = sheet.crop(WIDTH, 0, WIDTH, HEIGHT);
        grass = sheet.crop(WIDTH*2, 0, WIDTH, HEIGHT);
        wood = sheet.crop(WIDTH*3, HEIGHT*2, WIDTH, HEIGHT);
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
