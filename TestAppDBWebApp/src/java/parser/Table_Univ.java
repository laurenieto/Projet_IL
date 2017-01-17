
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Gaetan
 */
package parser;
public class Table_Univ {

    public Table_Univ() {
    }

    public Table_Univ Clone() {
        Table_Univ new_univ = new Table_Univ() ;
        new_univ.Adress = Adress ;
        new_univ.City = City ;
        new_univ.Country = Country ;
        new_univ.Email = Email ;
        new_univ.Id = Id ;
        new_univ.Name = Name ;
        new_univ.Nb_Place = Nb_Place ;
        new_univ.Phone = Phone ;

        return new_univ;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String Adress) {
        this.Adress = Adress;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getNb_Place() {
        return Nb_Place;
    }

    public void setNb_Place(String Nb_Place) {
        this.Nb_Place = Nb_Place;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

  Integer Id;
  String Name;
  String Country;
  String City;
  String Adress;
  String Email;
  String Phone;
  String Nb_Place;

  public Table_Univ(Integer Id, String Name, String Country, String City, String Adress, String Email, String Phone,String Nb_Place){
      // This constructor has one parameter, name.
      this.Id=Id;
      this.Name=Name;
      this.Country = Country;
      this.City=City;
      this.Adress = Adress;
      this.Email = Email;
      this.Phone = Phone;
      this.Nb_Place = Nb_Place;
   }

    @Override
    public String toString() {
        return "Table_Univ{" + "Id=" + Id + ", Name=" + Name + ", Country=" + Country + ", City=" + City + ", Adress=" + Adress + ", Email=" + Email + ", Phone=" + Phone + ", Nb_Place=" + Nb_Place + '}';
    }


}