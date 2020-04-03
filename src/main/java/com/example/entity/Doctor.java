package com.example.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class Doctor implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message = "please provide specialisation")
    @Size(min=5,max=10,message = "specialisation's length should be between 5 to 10")
    @Column(length=10)
    private String specialisation;

    @NotNull(message = "please provide docId")
    @Column(length=10)
    @Size(min=5,max=10,message = "Doctor id's length should be between 5 to 10")
    private String docId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    private Account account;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
