package com.jalitha.rentcar.demoapplication;

import jdk.jfr.Enabled;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Endpoint(id="stages") //id will be used to route this endpoint ex:- actuator/stages
public class StageEndpoint {
    Map<String, Stage> stages = new ConcurrentHashMap<>();

    @ReadOperation //HTTP GET calls come and map here
    public Map<String, Stage> getAllStages() {
        return stages;
    }

    @ReadOperation
    public Stage getStage(@Selector String name) {  //@Selector is used to end of the route ex:- actuator/stages/{name}
        return stages.get(name);
    }

    @WriteOperation //HTTP PUT calls
    public void setStage(@Selector String name, int stage){
        stages.put(name, new Stage(stage));
    }


    static class Stage {
        private int value;

        public Stage(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

    }
}
