package me.zhang.adapter.facade;

/**
 * Created by Zhang on 11/11/2015 10:34 下午.
 */
public class AmplifierTest {

    public static void main(String[] args) {
        PopcornPopper popper = new PopcornPopper();
        TheaterLights lights = new TheaterLights();
        Screen screen = new Screen();
        Projector projector = new Projector();
        Amplifier amp = new Amplifier();
        DvdPlayer dvd = new DvdPlayer();

        popper.on();
        popper.pop();

        lights.dim(10);

        screen.down();

        projector.on();
        projector.setInput(dvd);
        projector.wideScreenMode();

        amp.on();
        amp.setDvd(dvd);
        amp.setSurroundSound();
        amp.setVolume(5);

        dvd.on();
        Movie movie = new Movie("Bla bla...");
        dvd.play(movie);
    }

}
