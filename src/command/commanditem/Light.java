package command.commanditem;

import java.awt.*;

public class  Light {

    private Color color;
    private boolean isOnn = false;

    public void Onn(){
        if(isOnn) {
            System.out.println("Light already turned onn");
        }
        else{
            isOnn = true;
            System.out.println("Light turned onn");
        }
    }

    public void Off(){
        if(!isOnn){
            isOnn = false;
            System.out.println("Light is turned off");
        }
        else {
            System.out.println("Light already off");
        }

    }

    public void changeColor(Color color){
        System.out.println("Set tht light color to " + color.toString());
        this.color = color;
    }

}
