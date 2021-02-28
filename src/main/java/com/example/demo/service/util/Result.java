package com.example.demo.service.util;

import io.swagger.annotations.Scope;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Result {
    private int code;
    private Map<String,Object> inputs;
    private Map<String,Object> outputs;
    private  Map<Integer,String> errors;
    private  Map<Integer,String> infos;
    private  Map<Integer,String> warnnings;

    public Result() {
    }

    public Result(Map<String, Object> inputs) {
        this.inputs = inputs;
    }

    public Result(String name,Object object) {
        getInputs().put(name,object) ;
    }

    public boolean hasNoError(){
        return getErrors().isEmpty();
    }
    public void addError(int code, String message){
        getErrors().put(code,message);
    }

    public void addInfo(int code,String message){
        getInfos().put(code,message);
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Map<String, Object> getInputs() {
        if (inputs == null) {
            inputs=new HashMap<>();
        }
        return inputs;
    }

    public void setInputs(Map<String, Object> inputs) {
        this.inputs = inputs;
    }

    public Map<String, Object> getOutputs() {
        if (outputs == null) {
            outputs=new HashMap<>();
        }
        return outputs;
    }

    public void setOutputs(Map<String, Object> outputs) {
        this.outputs = outputs;
    }

    public Map<Integer, String> getErrors() {
        if (errors == null) {
            errors=new HashMap<>();
        }
        return errors;
    }

    public void setErrors(Map<Integer, String> errors) {
        this.errors = errors;
    }

    public Map<Integer, String> getInfos() {
        if (infos == null) {
            infos=new HashMap<>();
        }
        return infos;
    }

    public void setInfos(Map<Integer, String> infos) {
        this.infos = infos;
    }

    public Map<Integer, String> getWarnnings() {
        if (warnnings == null) {
            warnnings=new HashMap<>();
        }
        return warnnings;
    }

    public void setWarnnings(Map<Integer, String> warnnings) {
        this.warnnings = warnnings;
    }
}
