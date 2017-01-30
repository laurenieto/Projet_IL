/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package parser;

import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gaetan
 */
public class Table_Student {

    public Table_Student() {
    }

    public Table_Student Clone() {
        Table_Student new_student = new Table_Student() ;
        new_student.Id = Id ;
        new_student.Username = Username ;
        new_student.Password = Password ;
        new_student.Firstname = Firstname ;
        new_student.Surname = Surname ;
        new_student.Email = Email;
        new_student.Telephone = Telephone ;
        new_student.YearAtInsa = YearAtInsa ;
        new_student.INSAspeciality = INSAspeciality ;

        return new_student;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String Firstname) {
        this.Firstname = Firstname;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
    }


    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String Telephone) {
        this.Telephone = Telephone;
    }

    public Integer getYearAtInsa() {
        return YearAtInsa;
    }

    public void setYearAtInsa(Integer YearAtInsa) {
        this.YearAtInsa = YearAtInsa;
    }

    public String getINSAspeciality() {
        return INSAspeciality;
    }

    public void setINSAspeciality(String INSAspeciality) {
        this.INSAspeciality = INSAspeciality;
    }

  Integer Id;
  String Username;
  String Password;
  String Firstname;
  String Surname;
  Date BirthDate;
  String Email;
  String Telephone;
  Integer YearAtInsa;
  String INSAspeciality;

  public Table_Student(Integer Id, String Username, String Password, String Firstname, String Surname, Date BirthDate, String Email, String Telephone, Integer YearAtInsa, String INSAspeciality){
      // This constructor has one parameter, name.
      this.Id=Id;
      this.Username=Username;
      this.Password = Password;
      this.Firstname=Firstname;
      this.Surname = Surname;
      this.Email = Email;
      this.Telephone = Telephone;
      this.YearAtInsa = YearAtInsa;
      this.INSAspeciality = INSAspeciality;
   }

    @Override
    public String toString() {
        return "Table_Student{" + "Id=" + Id + ", Username=" + Username + ", Password=" + Password + ", Firstname=" + Firstname + ", Surname=" + Surname + ", Email=" + Email + ", Telephone=" + Telephone + ", YearAtINSA=" + YearAtInsa + ", INSAspeciality=" + INSAspeciality + '}';
    }


}