package model.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Seller implements Serializable {
    private Integer id ;
    private String nome;
    private String email;
    private Date aniversario;
    private double salario;
    private Department department;

    public Seller() {
    }

    public Seller(Integer id, String nome, String email, Date aniversario, double salario, Department department) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.aniversario = aniversario;
        this.salario = salario;
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getAniversario() {
        return aniversario;
    }

    public void setAniversario(Date aniversario) {
        this.aniversario = aniversario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seller seller = (Seller) o;
        return Objects.equals(id, seller.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Seller{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", aniversario=" + aniversario +
                ", salario=" + salario +
                ", department=" + department +
                '}';
    }
}
