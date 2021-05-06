package c19502146.pac;

import ie.tudublin.Visual;

public class TitisVisual extends Visual
{
    boolean twocubes = false;
    boolean vero = false;
    boolean medley = false;

    public void settings()
    {
        size(800, 800, P3D);
        println("CWD: " + System.getProperty("user.dir"));
        //fullScreen(P3D, SPAN);
    }

    public void keyPressed()
    {
        if (key == '0')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
            
        }
        if (key == '9')
        {
            getAudioPlayer().pause();
        }
        if (key == '1')
        {
            twocubes = ! twocubes;

        }
        if (key =='2')
        {
            vero = ! vero;
        }
        if (key == '3')
        {
            medley = ! medley;
        }
    }

    public void setup()
    {
        colorMode(HSB);
        noCursor();
        
        setFrameSize(256);

        startMinim();
        loadAudio("Joy.mp3");
        //getAp().play();
        //startListening(); 
        
    }

    float smoothedBoxSize = 0;

    public void draw()
    {
        calculateAverageAmplitude();
        background(0);
        noFill();
        lights();
        stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        camera(0, 0, 0, 0, 0, -1, 0, 1, 0);
        translate(0, 0, -250);
        
        float mHeight = getAmplitude() * 40;
        float mWidth = getAmplitude() * 60;
        float boxSize = 50 + (getAmplitude() * 1000);
        smoothedBoxSize = lerp(smoothedBoxSize, boxSize, 0.2f);       
        if (twocubes)
        {
            pushMatrix();
            translate(-100, 0, 0);
            rotateY(angle);
            rotateX(angle);
            box(smoothedBoxSize);
            popMatrix();
            pushMatrix();
            translate(100, 0, 0);
            rotateY(angle);
            rotateX(angle);
            strokeWeight(5); 
            box(smoothedBoxSize);
            popMatrix();
        }
        else if (vero)
        {
            rotateY(angle);
            rotateX(angle);
            strokeWeight(1);
            sphere(smoothedBoxSize/ 2);

        }
        else if (medley)
        {
            pushMatrix();
            translate(-100, 0, 0);
            rotateY(angle);
            rotateX(angle);
            sphere(smoothedBoxSize/ 3);
            popMatrix();
            pushMatrix();
            translate(0, 0, 0);
            rotateY(angle);
            rotateX(angle);
            sphere(smoothedBoxSize/ 3);
            popMatrix();
            pushMatrix();
            translate(100, 0, 0);
            rotateY(angle);
            rotateX(angle);
            sphere(smoothedBoxSize/ 3);
            popMatrix();
            strokeWeight(1);
            fill(255);
            stroke(255);
            rect(-150, 0, width, mHeight);
            fill(199, 21, 133);
            stroke(199, 21, 133);
            rotateX(angle);
            rotateY(angle);
            rect(-50, -100, 50, mWidth, mHeight);
            fill(199, 21, 133);
            stroke(199, 21, 133);
            rotateX(angle);
            rotateY(angle);
            rect(-120, -100, 50, mWidth, mHeight);
            fill(199, 21, 133);
            stroke(199, 21, 133);
            rotateX(angle);
            rotateY(angle);
            rect(70, -100, 50, mWidth, mHeight);
            fill(199, 21, 133);
            stroke(199, 21, 133);
            rotateX(angle);
            rotateY(angle);
            rect(-50, -100, 50, mWidth, mHeight);
            fill(255, 165, 0);
            stroke(199, 21, 133);
            rotateX(angle);
            rotateY(angle);
            triangle(-100, -120, -150, -170, -70, -170);
            fill(255, 165, 0);
            stroke(199, 21, 133);
            rotateX(angle);
            rotateY(angle);
            triangle(-20, -40, 30, 10, 80, 10);
            fill(255, 165, 0);
            stroke(199, 21, 133);
            rotateX(angle);
            rotateY(angle);
            triangle(-100, -120, -150, -170, -70, -170);
        }
        else
        {
            rotateY(angle);
            rotateX(angle);          
            strokeWeight(5);
            
            box(smoothedBoxSize);
        }
        angle += 0.01f;
    }
    float angle = 0;
} 