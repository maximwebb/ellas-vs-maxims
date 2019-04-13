package dev.game.gfx;

import dev.game.rooms.Room;
import java.awt.image.BufferedImage;

public class AnimationHandler {
    //number of times to repeat the animation
    private int iteration = 0;
    private int maxIterations;

    private boolean animationDone = false;
    private boolean isPaused = false;

    private int frame = 0;
    //we want to delay each frame update based on the fps
    private double timer = 0;
    private double delay;

    private BufferedImage[] assets;

    //-1 maxIterations means infinite
    public AnimationHandler(BufferedImage[] assets, double fps, int maxIterations) {
        this.assets = assets;

        //get delay between frames
        this.delay = 1 / fps;

        this.maxIterations = maxIterations;
    }

    private void updateAnimationState() {
        //check if end of animation
        if (this.frame >= this.assets.length) {
            //not infinite
            if (this.maxIterations != -1) {
                this.iteration += 1;
                //check if done
                if (this.iteration >= this.maxIterations) {
                    this.animationDone = true;
                }
            }
            //reset
            this.frame = 0;
        }
    }

    //returns the sprite that should be rendered at this frame as a buffered image (automatic update)
    public BufferedImage updateSprite() {
        if (isPaused) {
            return assets[frame];
        }

        timer += Room.getRoom().getDeltaTime();

        //while loop so that we can have more than double the original fps (for some reason???)
        while (timer >= this.delay) {
            //go to next frame
            this.timer -= this.delay;
            this.frame += 1;
        }

        this.updateAnimationState();

        return this.animationDone ? Assets.EMPTY : this.assets[frame];
    }

    //for manual updates
    public BufferedImage nextFrame() {
        this.frame += 1;
        this.updateAnimationState();

        return this.animationDone ? Assets.EMPTY : this.assets[frame];
    }

    public BufferedImage getFrame(int frame) {
        return assets[frame];
    }

    public int getFrameNumber() {
        return frame;
    }

    public boolean done() {
        return this.animationDone;
    }

    public void pause() {
        this.isPaused = true;
    }

    public void play() {
        this.isPaused = false;
    }

    public void reset() {
        this.animationDone = false;
        this.frame = 0;
        this.timer = 0;
        this.iteration = 0;
        this.isPaused = false;
    }
}
