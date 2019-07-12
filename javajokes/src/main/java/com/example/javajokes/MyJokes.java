package com.example.javajokes;

import java.util.Random;

public class MyJokes {

    public static String getJoke() {
        String jokes[] = {
                "Yo momma is so fat, when she sat on an iPod, she made the iPad!",
                "Q: What did the spider do on the computer? A: Made a website!",
                "Q: What did the computer do at lunchtime? A: Had a byte!",
                "Q: What does a baby computer call his father? A: Data!",
                "Q: Why did the computer keep sneezing? A: It had a virus!",
                "Q: What is a computer virus? A: A terminal illness!",
                "Q: Why was the computer cold? A: It left it's Windows open!",
                "Q: Why was there a bug in the computer? A: Because it was looking for a byte to eat?",
                "Q: Why did the computer squeak? A: Because someone stepped on it's mouse!",
                "Q: What do you get when you cross a computer and a life guard? A: A screensaver!",
                "Q: Where do all the cool mice live? A: In their mousepads",
        };
        int joke_id = new Random().nextInt(jokes.length);
        return jokes[joke_id];
    }

}
