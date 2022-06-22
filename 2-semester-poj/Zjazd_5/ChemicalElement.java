/*
Summary: Exercise 05_06 UML CHART ChemicalElements Class construction
Author: Badysiak Paweł s21166
 */
package Zadania.Zjazd_5;

public class ChemicalElement {
    private String nameOfElement;
    private String chemicalSymbol;
    private int atomicNumber;
    private boolean test;

    public ChemicalElement(String nameOfElement, String chemicalSymbol, int atomicNumber) {
        this.nameOfElement = nameOfElement;
        this.chemicalSymbol = chemicalSymbol;
        this.atomicNumber = atomicNumber;
    }

    public boolean isTest() {
        return test;
    }

    public String getNameOfElement() {
        return nameOfElement;
    }

    public String getChemicalSymbol() {
        return chemicalSymbol;
    }

    public int getAtomicNumber() {
        return atomicNumber;
    }

    public boolean isAlkaliMetal() {
        switch (this.atomicNumber) {
            case 3:
            case 11:
            case 19:
            case 37:
            case 55:
            case 87:
                return true;
            default:
                return false;
        }
    }

    public boolean isTransitionMetal() {
        boolean result = (atomicNumber > 20 && atomicNumber < 31)
                || (atomicNumber > 38 && atomicNumber < 49)
                || (atomicNumber > 71 && atomicNumber < 81)
                || (atomicNumber > 103 && atomicNumber < 113);
        return result;
    }

    public boolean isMetal() {
        switch (this.atomicNumber) {
            case 13:
            case 31:
            case 49:
            case 50:
            case 81:
            case 82:
            case 83:
            case 113:
            case 114:
            case 115:
            case 116:
                return true;
            default:
                return false;
        }
    }

    public String typeMetal() {
        if (isMetal()) return "It is a metal";
        else if (isAlkaliMetal()) return "It is a Alkali Metal";
        else if (isTransitionMetal()) return "It is a Transition Metal";
        else return "It is not a metal";
    }

    @Override
    public String toString() {
        return chemicalSymbol + ":" + nameOfElement + " With atomic number " + atomicNumber +". " + typeMetal() + ".";
    }
}
