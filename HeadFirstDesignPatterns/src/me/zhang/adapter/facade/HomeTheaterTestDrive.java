package me.zhang.adapter.facade;

/**
 * Created by Zhang on 11/12/2015 8:33 下午.
 */
public class HomeTheaterTestDrive {

    public static void main(String[] args) {
        Amplifier amp = new Amplifier();
        Tuner tuner = new Tuner();
        DvdPlayer dvd = new DvdPlayer();
        CdPlayer cd = new CdPlayer();
        Projector projector = new Projector();
        Screen screen = new Screen();
        TheaterLights lights = new TheaterLights();
        PopcornPopper popper = new PopcornPopper();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(
                amp, tuner, dvd, cd, projector, lights, screen, popper
        );
        Movie movie = new Movie("Raiders of the Lost Ark");
        homeTheater.watchMovie(movie);
        System.out.println("**************************");
        homeTheater.endMovie();
    }

}
