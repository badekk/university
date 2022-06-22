/* Summary: Excercise 5 Class Human
    Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_2;

public class Human {
    private int age;
    private float weight;
    private float height;
    private String name;
    private String isMale;
    private String indexNumber;
    private float feetSize;

    public Human(int age,
                 float weight,
                 float height,
                 String name,
                 String isMale,
                 String indeksNumber,
                 float feetSize) {
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.name = name;
        this.isMale = isMale;
        this.indexNumber = indeksNumber;
        this.feetSize = feetSize;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsMale() {
        return isMale;
    }

    public void setIsMale(String isMale) {
        this.isMale = isMale;
    }

    public String getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(String indexNumber) {
        this.indexNumber = indexNumber;
    }

    public float getFeetSize() {
        return feetSize;
    }

    public void setFeetSize(float feetSize) {
        this.feetSize = feetSize;
    }

    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                ", weight=" + weight +
                ", height=" + height +
                ", name='" + name + '\'' +
                ", isMale='" + isMale + '\'' +
                ", indexNumber='" + indexNumber + '\'' +
                ", feetSize=" + feetSize +
                '}';
    }
}


