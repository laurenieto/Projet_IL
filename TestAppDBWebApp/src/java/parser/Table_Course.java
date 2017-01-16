/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package parser;

public class Table_Course {

    public Table_Course() {
    }

    public Table_Course Clone() {
        Table_Course new_course = new Table_Course() ;
        new_course.Id = Id ;
   	new_course.CourseName = CourseName ;
	new_course.Nb_Hours = Nb_Hours ;
        return new_course;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }

    public Integer getNbHours() {
        return Nb_Hours;
    }

    public void setNbHours(Integer Nb_Hours) {
        this.Nb_Hours = Nb_Hours;
    }


  Integer Id;
  String CourseName;
  Integer Nb_Hours;


  public Table_Course(Integer Id, String CourseName, Integer Nb_Hours){
      // This constructor has one parameter, name.
      this.Id=Id;
      this.CourseName=CourseName;
      this.Nb_Hours = Nb_Hours;
   }

    @Override
    public String toString() {
        return "Table_Course{" + "Id=" + Id + ", CourseName=" + CourseName + ", Nb_Hours=" + Nb_Hours + '}';
    }


}