package com.cydeo.tightly_coupled;

public class CydeoApp {
    public static void main(String[] args) {

        FullTimeMentor fullTimeMentor=new FullTimeMentor();
        PartTimeMentor partTimeMentor = new PartTimeMentor();

        Mentor mentor = new Mentor(fullTimeMentor,partTimeMentor); //MI

        mentor.manageAccount();

        //MI Mock Interview mentor
        /**
         * Now since there is tight coupling I need to modify/make changes inside
         * all classes, which is hard for application growing code
         * Enterprise application code are huge and this design is not flexible
         * for any enterprise application
         */
    }
}
