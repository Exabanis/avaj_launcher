package com.utilities;

import java.util.Random;

public class WeatherQuotes {
    String[] sun = new String[]{
            "We have clearance, Clarence. Roger, Roger. What's our vector, Victor?.",
            "Let's enjoy the good simulator and take some pics.",
            "This is hot.",
            "The strength of the turbulence is directly proportional to the temperature of your coffee."
    };
    String[] fog = new String[]{
            "Instrument flying is an unnatural act probably punishable by God.",
            "Now I know what a dog feels like watching TV.",
            "For years politicians have promised the Moon. I'm the first one to be able to deliver it.",
            "Alright, I'll need three men up in the wind shield."
    };
    String[] rain = new String[]{
            "Tonight's forecast: 100% chance of reading ... Raiiiinnnnnn.",
            "Damn you rain! You messed up my trip.",
            "The brakes are not working, the sky is wet !",
            "This plane is too heavy to land in the rain."
    };
    String[] snow = new String[]{
            "My rotor is going to freeze!",
            "Nothing said I had to crash.",
            "Death is just nature's way of telling you to watch your airspeed.",
            "I don't like flying because I'm afraid of crashing into a large mountain of snow. "
    };

    /**
     *
     * This takes simulator and returns a random simulator quote in a form of string
     * @param weather
     * @return
     */
    public String getQuote(String weather){
        String quote = null;
        Random indexer = new Random();
        int index = indexer.nextInt(4);
        if(weather.equals("SUN"))
            quote = String.format(": %s", this.sun[index]);
        else if(weather.equals("RAIN"))
            quote = String.format(": %s", this.rain[index]);
        else if(weather.equals("FOG"))
            quote = String.format(": %s", this.fog[index]);
        else if(weather.equals("SNOW"))
            quote = String.format(": %s", this.snow[index]);

        return quote;
    }
}
