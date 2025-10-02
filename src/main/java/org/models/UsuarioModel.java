package org.models;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class UsuarioModel {
    private String email;
    private String password;
    private String name;
    private String job;




    public UsuarioModel(String email, String password, String name, String job) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.job = job;

   }

    // Getters & Setters
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getJob() { return job; }
    public void setJob(String job) { this.job = job; }


}

