package as111.ssm;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class User {
    @XmlAttribute
    private String name;
    @XmlAttribute
    private String middleName;
    @XmlAttribute
    private String surname;
    @XmlAttribute
    private String phone;
    @XmlAttribute
    private String contractId;
    @XmlAttribute
    private String email;

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public User() {}
    
    public User(String contractId, String name, String middleName, String surname, String phone, String email) {
    	this.contractId = contractId;
    	this.name = name;
    	this.surname = surname;
    	this.phone = phone;
    	this.email = email;
    	this.middleName = middleName;
    }
    
    public String getName() {
    	return name;
    }
    
    public String getSurname() {
    	return surname;
    }
    
    public String getPhone() {
    	return phone;
    }
    
    public String getContractId() {
    	return contractId;
    }
    
    public String getMail() {
    	return email;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public void setSurname(String surname) {
    	this.surname = surname;
    }
    
    public void setPhone(String phone) {
    	this.phone = phone;
    }
    
    public void setContractId(String contractId) {
    	this.contractId = contractId;
    }
    
    public void setMail(String mail) {
    	this.email = mail;
    }
}
