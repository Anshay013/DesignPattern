package command__correct_check__housemanagement.service;

import command__correct_check__housemanagement.Command;

public abstract class ServiceExecuter {

    public ServiceExecuter(Command command){
        System.out.println("Init executer service");
    }

    public void execute(){
        System.out.println("Execute the service");
    }


}
