package com.example.demo.VOs;

public class FuncionarioVO {

    private String matricula;

    private String cod_regime;
    private int carga_horaria;

    private double salario;
    private String telefone;
    private String email;
    private String sexo;
    private boolean chefe;
    private SetorDepartamento2VO setorDepartamento;
    private UserVO user;

    public FuncionarioVO() {
    }
    
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public String getCod_regime() {
        return cod_regime;
    }
    public void setCod_regime(String cod_regime) {
        this.cod_regime = cod_regime;
    }
    public int getCarga_horaria() {
        return carga_horaria;
    }
    public void setCarga_horaria(int carga_horaria) {
        this.carga_horaria = carga_horaria;
    }
    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public boolean isChefe() {
        return chefe;
    }
    public void setChefe(boolean chefe) {
        this.chefe = chefe;
    }
    public SetorDepartamento2VO getSetorDepartamento() {
        return setorDepartamento;
    }
    public void setSetorDepartamento(SetorDepartamento2VO setorDepartamento) {
        this.setorDepartamento = setorDepartamento;
    }
    public UserVO getUser() {
        return user;
    }
    public void setUser(UserVO user) {
        this.user = user;
    }

    

}   
