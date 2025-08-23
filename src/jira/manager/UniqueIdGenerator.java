package jira.manager;

import jira.model.ModelType;

import java.util.UUID;

public class UniqueIdGenerator {


    public String generateUniqueID(ModelType type, String userName) {
        switch (type){
            case TASK -> userName += "task";
            case USER -> userName += "user";
        }
        String uniqueID = userName + "-" + UUID.randomUUID().toString();
        return uniqueID;
    }
}
